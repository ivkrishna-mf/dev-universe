

package datasets

import org.apache.spark.sql.SparkSession


object WordCountDatasets {
  case class word(word: String)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[1]")
      .appName("WordCountDatasets")
      .getOrCreate()

    val inputFile = "data/samples.txt"

    val lines = spark.read.textFile(inputFile)

    // Split lines into words
    import spark.implicits._
    val words = lines
      .flatMap(line => line.split("\\s+"))
      .filter(_.nonEmpty) // Remove empty words

    // Calculate word count
    val wordCounts = words.groupBy("value").count()

    wordCounts.show()
  }
}
