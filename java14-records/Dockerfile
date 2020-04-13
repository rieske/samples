FROM openjdk:14-jdk-slim

ENV JAVA_OPTS --illegal-access=deny -Xmx64m -Xms64m --enable-preview

ENTRYPOINT /opt/service/records/bin/records

ADD build/distributions/records.tar /opt/service/

