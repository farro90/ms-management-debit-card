FROM openjdk:11
VOLUME /tmp
EXPOSE 8116
ADD ./target/ms-management-debit-card-0.0.1-SNAPSHOT.jar ms-management-debit-card.jar
ENTRYPOINT ["java","-jar","ms-management-debit-card.jar"]