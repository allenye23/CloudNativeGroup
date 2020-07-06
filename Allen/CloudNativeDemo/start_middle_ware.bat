@REM start redis
docker run --name some-redis -p 6379:6379  -d redis:latest
@REM start mysql
docker run --name my-mysql -p 3306:3306 -v D:/data/mysql/datadir:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=test2345.. -d mysql:latest
@REM start solace/kafka/rabbitmq
docker run -d --name some-rabbit -p 5672:5672 -p 15672:15672  -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=password rabbitmq:3.8.5-management
