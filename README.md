# spring
spring related projects

Steps to be followed : 

1. docker login
2. docker pull livingstonlvin/jwt-mysql:latest
3. docker network create v4
4. docker pull mysql
5. docker run --network v4 --name v4 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=v3 -d mysql
6. docker exec -it v4 bash
7. mysql -u root -p v3
8. root
9. show databases;
10. use v3;
11. docker run --network v4 -p 9000:9000 livingstonlvin/jwt-mysql
12. insert into my_user values(1,'user','USER','user');
13. in postman
      i. POST ---> http://localhost:9000/authenticate 
      ii. body(raw,json) ---> {"username":"user","password":"user"}
    Response : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjExNjA3OTMxLCJpYXQiOjE2MTE1NzE5MzF9.ztQ1KmvJ5MBrlVTFnm3Cj3xy90MwUZyJRWdcQQ-Gg4w
    
      iii. GET ---> http://localhost:9000/hi
      iv. header (Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjExNjA3OTMxLCJpYXQiOjE2MTE1NzE5MzF9.ztQ1KmvJ5MBrlVTFnm3Cj3xy90MwUZyJRWdcQQ-Gg4w)
     Response : Hello
