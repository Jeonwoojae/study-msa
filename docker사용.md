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
```
네트워크 상세정보(주소와 등록된 컨테이너 확인 가능)
```shell
docker network inspect {네트워크 이름}
```

## RabbitMQ
```shell
docker run -d --name rabbitmq --network ecommerce-network \
 -p 15672:15672 -p 5672:5672 -p 15671:15671 -p 5671:5671 -p 4369:4369 \
 -e RABBITMQ_DEFAULT_USER=guest \
 -e RABBITMQ_DEFAULT_PASS=guest rabbitmq:management
```
