#!/bin/bash

#./run.sh ~/tools/spark ~/tools/data /Users/michael/workspace/spark-drools-experments/ngram-extractor/target/scala-2.11/ngram-extractor-assembly-0.0.1-SNAPSHOT.jar

# consider using this as shorthand way of getting the IP address
# I only need this because Docker for Mac networking is a real PITA
# ifconfig | grep inet | grep 192.* | awk '{print $2}'

SPARK_HOME=$1
SPARK_APPS_DIR=$2
APP=$3

echo "Local SPARK_HOME is $SPARK_HOME"
echo "Deploying application to Docker shared volume $APP"
cp $APP $SPARK_APPS_DIR

$SPARK_HOME/bin/spark-submit \
    --class org.reynoldsm88.ngram.extractor.NgramExtractor \
    --master spark://<PUT_IP_HERE>:7077 \
    --deploy-mode cluster \
    --supervise \
    /etc/spark/apps/ngram-extractor-assembly-0.0.1-SNAPSHOT.jar

# @michael - saving this because eventually I would like to use the REST client instead of spark-submit
#            for some reason it doesn't work the same as spark-submit :(
#curl -X POST http://192.168.1.170:6066/v1/submissions/create --header "Content-Type:application/json;charset=UTF-8" --data '{
#  "action" : "CreateSubmissionRequest",
#  "appArgs" : [ "myAppArgument1" ],
#  "appResource" : "/etc/spark/apps/ngram-extractor-assembly-0.0.1-SNAPSHOT.jar",
#  "clientSparkVersion" : "2.2.0",
#  "environmentVariables" : {
#    "SPARK_ENV_LOADED" : "1"
#  },
#  "mainClass" : "org.reynoldsm88.ngram.extractor.NgramExtractor",
#  "sparkProperties" : {
#    "spark.master" : "spark://192.168.1.17:7077",
#    "spark.jars" : "/ets/spark/apps/ngram-extractor-assembly-0.0.1-SNAPSHOT.jar",
#    "spark.driver.supervise" : "false",
#    "spark.app.name" : "MyJob",
#    "spark.eventLog.enabled": "true",
#    "spark.submit.deployMode" : "client"
#  }
#}'