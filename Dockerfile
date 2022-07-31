FROM gradle:7.3.3-jdk11

RUN apt-get update && apt-get install -y curl wget git bison unzip

RUN mkdir /home/gradle/grooven-tool

COPY . /home/gradle/grooven-tool/
WORKDIR /home/gradle/grooven-tool

RUN gradle buildDependents
RUN gradle build
