# Solace 

### Set up Solace server in local by docker
- Start Docker and open PowerShell.
- Go to the image path then load the image: docker load -i solace-pubsub-standard-9.5.0.30-docker.tar.gz
- run in docker: docker run -dp 8080:8080 -p 55555:55555 -p:8008:8008 -p:1883:1883 -p:8000:8000 -p:5672:5672 -p:9000:9000 -p:2222:2222 --shm-size=2g --env username_admin_globalaccesslevel=admin --env username_admin_password=admin --name=solace_local solace-pubsub-standard:9.5.0.30
- open solace server : http://localhost:8080  admin/admin

### Solace use in Spring
- Add dependence in pom:
```
<dependency>
  <groupId>com.solace.spring.boot</groupId>
  <artifactId>solace-jms-spring-boot-starter</artifactId>
  <version>1.0.0</version>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-jms</artifactId>
</dependency>
```
- Add in application config
solace.jms.host=tcp://localhost:55555
solace.jms.msg-vpn=default
solace.jms.client-username=admin
solace.jms.client-password=admin

