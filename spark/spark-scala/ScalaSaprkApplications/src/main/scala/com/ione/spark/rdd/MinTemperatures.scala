package com.ione.spark.rdd

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import scala.math.min

/** Find the minimum temparature by weather station */
object MinTemperatures {

  def parseLine(line: String): (String, String, Float) = {

    val fields = line.split(",")
    val stationId = fields(0)
    val entryType = fields(2)
    val temperature = fields(3).toFloat * 0.1f * (9.0f / 5.0f) + 32.0f
    (stationId, entryType, temperature)
  }

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    // Create a logger instance
    val logger = Logger.getLogger(MinTemperatures.getClass.getName)

    val sc = new SparkContext("local[*]", "MinTemperatures")

    val lines = sc.textFile("data/temperatures.csv")

    logger.info("infolevel:Reading the file")
    logger.debug("debuglevel:Reading the file")
    logger.trace("tracelevel:Reading the file")
    logger.error("errorlevel:Reading the file")

    val parsedLines = lines.map(parseLine)

    val minTemperatures = parsedLines.filter(x => x._2 == "TMIN")

    val stationTemperatures = minTemperatures.map(x => (x._1, x._3.toFloat))

    val minTempsByStation = stationTemperatures.reduceByKey((x,y) => min(x,y))

    val results = minTempsByStation.collect()

    for( result <- results.sorted) {
      val station = result._1
      val temp = result._2

      val formattedTemp = f"$temp%.2f F"
      println(s"$station minimum temperature: $formattedTemp" )
    }






  }

}
