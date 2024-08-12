
package com.ione.spark.rdd

import org.apache.spark.sql.SparkSession


object WordCountRdd {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[1]")
      .appName("WordCountrdd")
      .getOrCreate()
    val sc = spark.sparkContext;
    val text = sc.textFile("data/samples.txt")
    val counts = text.flatMap(line => line.split("\\s+")
    ).filter(line => line.nonEmpty).map(word => (word, 1)).reduceByKey(_ + _)
    counts.foreach(f => {
      println(f._1 + "  " + f._2)
    })
    counts.saveAsTextFile("output/results/wc-output-dir/")
  }

}
