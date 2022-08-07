# :fork_and_knife:momukji-services
## :pushpin: 개요
모먹지 프로젝트는 배달 기반의 음식 주문 서비스 입니다. 
Microservice Architecture의 전반적인 이해 및 패턴 구현을 위해 제작되었으며, 현재 해당 momukji-services 깃 저장소에는 모먹지 프로젝트의 Microservices를 다루고 있습니다. 모먹지 프로젝트의 Microservices에는 Customer, Store , Rider의 주요 API들이 있는 **Main**과 JWT 토큰 발행과 인증 관련 API를 다루는 **Auth**, user관련 API를 다루는 **User** 로 구성되어 있습니다. 클라이언트의 모든 API 호출을  올바른 Microservice로 라우팅하는 역할인 Gateway는 다른 깃 저장소인 momukji-gateway 에 구현되었습니다. 진행 상황에 있어 세분화된 기록을 위해 저장소를 분리하였습니다. 프로젝트 진행에 따라 ReadMe 업데이트 예정입니다.
* momukji-gateway : https://github.com/f-lab-edu/momukji-gateway

## :pushpin: 목표 및 사용 기술 스택 
<img src="https://img.shields.io/badge/Spring%20Boot-2.6.9-yellow">  <img src = "https://img.shields.io/badge/Architecture-MSA-red" > <img src="https://img.shields.io/badge/Authentication-JWT-yellowgreen"> <img src = "https://img.shields.io/badge/Http%20Client%20Library-Spring%20Cloud%20OpenFeign-green?logo=Spring&logoColor=green"> <img src = "https://img.shields.io/badge/Message%20Queue-RabbitMQ-orange?logo=RabbitMQ&logoColor=orange"> <img src = "https://img.shields.io/badge/DataBase-MySQL-blue?logo=MySQL&logoColor=blue"> <img src = "https://img.shields.io/badge/DataBase-MongoDB-green?logo=mongoDB&logoColor=green">  <img src = "https://img.shields.io/badge/Code%20Style-Naver%20CheckStyle-brightgreen?logo=naver&logoColor=brightgreen"> 

* 배달 앱 서비스를 구현해 내는 것이 목표입니다.
* 대규모 트래픽과 대용량 데이터 처리가 가능하도록 구현해내고 싶습니다. 
* 이유와 근거가 명확한 기술의 사용을 지향합니다.
* 이 프로젝트를 통해 기존의 Monolithic Architecture을 Microservice Architecture로 전환함으로써 두 구조에 대한 전반적인 이해도를 높이고 패턴 구조를 구현하는데 목표를 두고 있습니다. 

## :pushpin: 중점사항 
* MSA 구조를 통해 대용량 처리, 서비스별 트래픽 분석, 트래픽별 서비스 증설 구현
* MonogoDB를 활용하여 대용량처리 과정 중 DB 병목 현상 방지

## :pushpin: 프로젝트 구조도
![image](https://user-images.githubusercontent.com/68679529/182789051-91e88a58-ce1a-4bf7-97a5-85ec6d3d7199.jpg)

## :pushpin: 시퀀스 다이어그램 및 유즈케이스
   ![im2](https://user-images.githubusercontent.com/68679529/183066391-206de043-0710-4cf9-a2bd-edba81eaa7a1.jpg)

**🐣Customer**
-   회원가입한다
-   로그인한다
-   탈퇴한다
-   음식 카테고리를 선택하여 가게 목록을 본다
    -   음식 카테고리 내려받기
    -   가게 목록 내려받기
        -   가게 위치 정보도 같이 수신
        -   API 파라미터로 내 위치 정보도 전달
-   가게 상세정보를 본다
    -   음식 메뉴를 본다
-   가게에 결제하고 주문한다 (돈은 가상머니로 구현한다)
-   주문 상태를 확인한다 (WebSocket 비동기 알림 사용한다)
-   주문을 취소하고 환불받는다

**🐣Store**
-   회원가입한다
-   로그인한다
-   탈퇴한다
-   내 가게를 등록한다
-   주문 푸쉬알람을 받는다
-   주문을 거절/승인한다
    -   승인 후 받은 주문을 취소한다
-   주문 정보를 확인한다 (주문 목록, 소비자 연락처, 주문상태)
-   라이더 호출
    -   라이더에게 음식 인계 후 인계 정보 등록

**🐣Rider**
-   회원가입한다
-   로그인한다
-   탈퇴한다
-   배차요청 푸쉬알람을 받는다 (WebSocket 비동기 알림 사용한다)
-   배차요청 대기 목록을 본다
-   배차 요청을 받는다
-   수락한 배차 요청을 취소한다
-   배달을 완료한다
-   배차요청 푸쉬알림 수신 여부를 설정한다

## :pushpin: DB ERD
![erd](https://user-images.githubusercontent.com/68679529/183069649-42aa7a64-a7da-40de-b99b-e8bac0c4fff4.png)

## :pushpin: Oven 프로토타이핑
* [머먹지 프로젝트 oven 프로토타이핑 링크](https://ovenapp.io/project/UnMtYWVbRCW2bjHASFWKhzwq8hVeGhi8#SwbqJ)

## :pushpin: 정책

![image](https://user-images.githubusercontent.com/68679529/183069021-77778f19-f9a5-4c9c-bb8d-f1a9c391f7b8.png)
