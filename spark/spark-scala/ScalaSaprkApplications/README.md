# Scala-Saprk-Applications


-Dlog4j.configuration=file:log4j.properties
-Dlogfile.name=spark.log
-Dspark.yarn.app.container.log.dir=app-logs

### VM arguments

--add-opens=java.base/java.lang=ALL-UNNAMED
--add-opens=java.base/java.lang.invoke=ALL-UNNAMED
--add-opens=java.base/java.lang.reflect=ALL-UNNAMED
--add-opens=java.base/java.io=ALL-UNNAMED
--add-opens=java.base/java.net=ALL-UNNAMED
--add-opens=java.base/java.nio=ALL-UNNAMED
--add-opens=java.base/java.util=ALL-UNNAMED
--add-opens=java.base/java.util.concurrent=ALL-UNNAMED
--add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED
--add-opens=java.base/sun.nio.ch=ALL-UNNAMED
--add-opens=java.base/sun.nio.cs=ALL-UNNAMED
--add-opens=java.base/sun.security.action=ALL-UNNAMED
--add-opens=java.base/sun.util.calendar=ALL-UNNAMED
--add-opens=java.security.jgss/sun.security.krb5=ALL-UNNAMED

-Dlog4j.configuration=file:log4j.properties
-Dlogfile.name=spark.log
-Dspark.yarn.app.container.log.dir=app-logs

## Spark 
is a fast and general cluster computing system for Big Data. It provides high-level APIs in Scala, Java, Python, and R, and an optimized engine that supports general computation graphs for data analysis. It also supports a rich set of higher-level tools including Spark SQL for SQL and structured data processing, MLlib for machine learning, GraphX for graph processing, and Spark Streaming for stream processing.

## RDD 

RDDs are the building blocks of Spark. They are immutable distributed collections of objects. Each dataset in RDD is divided into logical partitions, which may be computed on different nodes of the cluster. RDDs can contain any type of Python, Java, or Scala objects, including user-defined classes.

### Word Count
#### 1.1 Word Count with RDDs

![img.png](documents-resources/images/img.png)
Input:

data/samples.txt

hello scala
how are you
great news !

hello scala

Output:

scala  2
are  1
news  1
you  1
how  1
!  1
hello  2
great  1


#### 1.2 Word Count with dataframes

#### 1.3 Word Count with Datasets