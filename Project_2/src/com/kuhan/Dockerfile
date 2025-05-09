FROM openjdk:latest
WORKDIR /app
COPY MyClass.java /app/MyClass.java
RUN javac -d . MyClass.java
CMD ["java", "com.kuhan.MyClass"]