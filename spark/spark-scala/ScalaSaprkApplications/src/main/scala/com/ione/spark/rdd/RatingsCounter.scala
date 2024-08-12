package com.ione.spark.rdd

import org.apache.log4j._
import org.apache.spark.SparkContext

object RatingsCounter {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "RatingsCounter")

    val lines = sc.textFile("data/ml-100k/u.data")

    //the file format is userID, movieID, rating, timestamp
    val ratings = lines.map(x => x.split("\t")(2))

    val results = ratings.countByValue()

    val sortedResults = results.toSeq.sortBy(_._1)


    // print each result on its own line

    sortedResults.foreach(println)

    sc.stop()
  }

}
