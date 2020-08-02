#!/bin/sh

echo "********************************************************"
echo "Starting Springboot s3 example :  $PORT"
echo "********************************************************"

java -Dserver.port=$PORT \
     -Dcloud.aws.cloudFront.url=$CLOUD_FRONT \
     -Dcloud.aws.credentials.accessKey=$ACCESS_KEY \
     -Dcloud.aws.credentials.secretKey=$SECRET_KEY \
     -Dcloud.aws.s3.bucket=$BUCKET \
     -Dcloud.aws.region.static=$REGION \
     -jar /usr/local/springboots3example/@project.build.finalName@.jar