#!/bin/bash
./gradlew build
docker build -t records .
docker run records
