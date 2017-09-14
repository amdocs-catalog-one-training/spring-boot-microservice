# spring-boot-microservice
this microservise need any oracle server installed on your computer.
after downloading the code, please edit resources/application.properties file with yours database
credentials and uncomment "spring.jpa.hibernate.ddl-auto=create-drop" line, it will create the table on start.
after you can comment it if you do not want that table will recreated on each start (in this case you will lose all information) 
you also can edit server.port property to set port on which will run service
