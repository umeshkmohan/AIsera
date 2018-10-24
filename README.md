# AISERA
This project will read the input data stream and produce the output via query stream
This project makes use of spark structured streaming

## Quick Start

### Main function 

```UserSummaryStreams``` is the main function for producing the final metrics
For simplification of running the jar , its reading data from json file. 
It could be changed to read from any source and  write into any sink using config


### How to Build and Deploy

This project is built with sbt, you could use sbt related commands to test/compile/package.
Please double check the scala/spark version
You could use spark-submit --jars to run the project


#### Run in local mode 
## main object to execute
```org.umesh.report.UserSummaryStreams``` 


#### Run in cluster mode
```bash
{$SPARK_HOME}/bin/spark-submit \
     --class UserSummaryStreams \
     --name "userMetrics" \
     --master yarn-cluster \
     --num-executors 4 \
     --driver-memory 1gb \
     --executor-memory 5gb \
     --executor-cores 1 \
     spark-aisera-assembly-0.1.0-SNAPSHOT.jar \
```