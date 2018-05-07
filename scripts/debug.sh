#!/bin/bash

## this is for debugging jobs on a local spark instance
SPARK_HOME=$1
#LOCAL DEBUG
export SPARK_DEBUG_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005

echo $SPARK_JAVA_OPTS
$SPARK_HOME/bin/spark-submit \
    --class org.reynoldsm88.ngram.extractor.Main \
    --master local \
    --conf spark.driver.extraJavaOptions=$SPARK_DEBUG_OPTS\
    /Users/michael/workspace/spark-drools-experments/ngram-extractor/target/scala-2.11/ngram-extractor-assembly-0.0.1-SNAPSHOT.jar \
    /Users/michael/workspace/spark-drools-experments/ngram-extractor/src/test/resources/config/test-job-config.json