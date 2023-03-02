## Network
- Bridge network
  - 가상환경 내에서 네트워크 환경 사용
- Host network
  - 호스트의 네트워크 환경을 그대로 사용
  - 포트 포워딩 없이 내부 어플리케이션 사용
- None network
  - 네트워크를 사용하지 않음
  - 외부와 단절

### 현재 네트워크 확인
```docker network ls```

### 네트워크 생성
```shell
docker network create --gateway 192.168.0.1 --subnet 192.168.0.0/16 {네트워크 이름}
dns나 서브넷 주소는 빈 주소로 알아서 적어야 하는 듯
```
네트워크 상세정보(주소와 등록된 컨테이너 확인 가능)
```shell
docker network inspect {네트워크 이름}
```

## RabbitMQ 실행
```shell
docker run -d --name rabbitmq --network ecommerce-network \
 -p 15672:15672 -p 5672:5672 -p 15671:15671 -p 5671:5671 -p 4369:4369 \
 -e RABBITMQ_DEFAULT_USER=guest \
 -e RABBITMQ_DEFAULT_PASS=guest rabbitmq:management
```

### config-serivce Dockerfile
```shell
FROM openjdk:11-jre-slim-buster
VOLUME /tmp
COPY build/libs/config-service-1.0.jar ConfigService.jar
COPY apiEncryptionKey.jks apiEncryptionKey.jks
ENTRYPOINT ["java","-jar","ConfigService.jar"]
```

### docker 빌드하여 실행하기
```shell
docker build -t dnwo0719/config-service:1.0 . 
```

```shell
docker run -d -p 8888:8888 --network ecommerce-network \
-e "spring.rabbitmq.host=rabbitmq" -e "spring.profiles.active=default"\
--name config-service dnwo0719/config-service:1.0
```

### discovery-serivce 빌드
```shell
docker build --tag dnwo0719/discovery-service:1.0 .
```
실행
```shell
docker run -d -p 8761:8761 --network ecommerce-network \
 -e "spring.cloud.config.uri=http://config-service:8888" \
 --name discovery-service dnwo0719/discovery-service:1.0
```

docker hub에 올리기
```shell
docker push dnwo0719/discovery-service:1.0
```

### apigateway-service 빌드



실행하기
```shell
docker run -d -p 8000:8000 --network ecommerce-network \
 -e "spring.cloud.config.uri=http://config-service:8888" \
 -e "spring.rabbitmq.host=rabbitmq" \
 -e "eureka.client.serviceUrl.defaultZone=http://discovery-service:8761/eureka/" \
 --name apigateway-service dnwo0719/apigateway-service:1.0
```

### MariaDB 빌드하기
- 이미 생성된 mariaDB의 테이블 파일을 가지고 빌드하면 테이블을 새로 create할 필요가 없다
- 설치한 mariaDB의 폴더 경로로 가서 data폴더의 데이터를 작업할 dockerfile쪽으로 복사한다.
- ``mysqld: Please consult the Knowledge Base to find out how to run mysqld as root!`` 해당 오류로 루트 옵션 추가
```dockerfile
FROM mariadb
ENV MYSQL_ROOT_PASSWORD test1357
ENV MYSQL_DATABASE mydb
COPY ./data /var/lib/mysql
EXPOSE 3306
ENTRYPOINT ["mysqld", "--user=root"]
```
```shell
docker run --name mariadb \
  -e MYSQL_ROOT_PASSWORD=1234\
  -e MYSQL_DATABASE=mydb\
  -p 3306:3306\
  -d mariadb
```

권한 설정
```shell

```