#!/bin/bash

SPARK_HOME=$1
echo "SPARK_HOME is set to $SPARK_HOME"

$SPARK_HOME/bin/spark-submit \
    --class org.reynoldsm88.ngram.extractor.NgramExtractor \
    --master spark://localhost:7077 \
    --deploy-mode client \
    ngram-extractor/target/scala-2.11/ngram-extractor-assembly-0.0.1-SNAPSHOT.jar \
    /Users/michael/workspace/trump_transcripts/transcripts/general_debate_2016-09-26.md
