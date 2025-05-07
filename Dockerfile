FROM openjdk:21

WORKDIR /app

COPY src /app/src

RUN javac src/kimesh/hyperionDev/Main.java -d out

CMD ["java", "-cp", "out", "kimesh.hyperionDev.Main"]