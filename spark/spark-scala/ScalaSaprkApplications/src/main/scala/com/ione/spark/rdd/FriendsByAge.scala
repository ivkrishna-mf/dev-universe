package com.ione.spark.rdd

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object FriendsByAge {

  /**
   * A funciton that splits line of input into age and number of friends
   */
  def parseLine(line: String): (Int, Int) = {
   // split by commas
    val fields = line.split(",")
    // extract the age and number of friends
    val age = fields(2).toInt
    val numFriends = fields(3).toInt
    // create a tuple that is our result
    (age, numFriends)
  }

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "FriendsByAge")

    val lines = sc.textFile("data/fakefriends.csv")

    val rdd = lines.map(parseLine)

    val totalsByAge = rdd.mapValues( x => (x, 1)).reduceByKey( (x, y) => (x._1 + y._1, x._2 + y._2))

    // (age, (totalFriends, totalInstances))
    // average totalFriends/ totalInstances
    val averageByAge = totalsByAge.mapValues(x => x._1 / x._2)

    // collect the results from the RDD
    val results = averageByAge.collect()

    // sort and print the final results
    results.sorted.foreach(println)




  }





}
