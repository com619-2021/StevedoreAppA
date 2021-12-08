
FROM tomcat:9.0.54-jdk11-openjdk-buster

LABEL maintainer="craig.gallen@solent.ac.uk"

ADD ./target/stevedore /usr/local/tomcat/webapps/stevedore

EXPOSE 8080

CMD ["catalina.sh", "run"]