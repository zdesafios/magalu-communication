
FROM maven:3-jdk-11

RUN mkdir -p /var/source
RUN mkdir -p /var/deploy

COPY $PWD/core-application /var/source/
COPY $PWD/web-api /var/source
COPY $PWD/mvn-build.sh /var/source/mvn-build.sh
 
WORKDIR /var/source

ENTRYPOINT ["sh", "mvn-build.sh"]
