FROM java:8
EXPOSE 9000
ADD target/jwt-mysql.jar jwt-mysql
ENTRYPOINT [ "java","-jar","jwt-mysql" ]