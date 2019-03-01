FROM atlassianlabs/docker-node-jdk-chrome-firefox
WORKDIR /root/
RUN apt-get update -y
RUN apt-get install -y firefox-esr
RUN npm i
COPY src src
COPY pom.xml .
