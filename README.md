# 마쉴랭

## **📍**Overview
- - - 
### 📜프로젝트 소개

- 술에 진심인 사람들을 위한 칵테일 레시피 공유 커뮤니티
- 술, 안주, 사는 얘기를 자유롭게 할 수 있는 공간

### **⏳**작업 기간 (2023.01 ~ 2023.03)

### 🔗링크
- [마쉴랭 웹사이트](https://msl-frontend.vercel.app/) (현재는 AWS 비용 문제로 인해 닫아두었습니다)
- [API 명세서](https://api.mashillaeng.site/swagger-ui/index.html#/)
- [고민과 해결](https://github.com/lamodadite/MSL-backend#%EA%B3%A0%EB%AF%BC%EA%B3%BC-%ED%95%B4%EA%B2%B0)


### 😀팀 소개

|         역할 |        이름 |
| --- | --- |
| 프론트엔드 | 정채운 |
| 백엔드 | 김민영 |
| 백엔드 | 이종민 |

### 📚 백엔드 협업 방식
- 백엔드가 두명이지만 두 명 모두 모든 기능을 개발했습니다.
- 정해진 기간동안 둘 다 같은 기능을 만들고, 서로의 코드를 비교하며 더 나은 방식에 대해 토론했습니다.
- 더 낫다고 결론지은 한쪽의 코드를 머지하거나, 아예 새로운 코드를 함께 작성했습니다.
- 때문에 각 기능의 기여도는 둘 다 80% 이상입니다.

## ⚒️주요 기능
- - - 

로그인 인증을 포함한 SNS의 주요 기능들을 대부분 구현했습니다.

<details>
<summary>주요 기능 펼치기</summary>
<div>

- 인증 / 인가
    - 회원가입
    - JWT를 이용한 로그인
    - 일반 유저 / 관리자 권한
- 유저
    - 유저 정보 변경
    - 메일인증을 통한 비밀번호 변경
- 게시판 CRUD
    - 게시글 등록, 수정, 삭제
    - 카테고리별, 유저별, 태그별 게시글 조회
    - 좋아요를 50개 받은 게시물은 인기 게시물로 조회
- 좋아요
    - 게시글 좋아요 입력, 취소
    - 댓글 좋아요 입력, 취소
- 신고
    - 신고를 50개 이상 받은 게시물은 관리자 페이지에서 조회
    - 관리자 권한으로 신고된 게시물 삭제 가능
    - 신고 취소
- 댓글
    - 게시글에 댓글 입력, 수정, 삭제
    - 댓글에 대댓글 입력, 수정 ,삭제
- 유저 팔로우
    - 마음에 드는 유저 팔로우, 언팔로우
    - 팔로우 한 유저들의 게시글 목록만 조회 가능
- 해시태그
    - 게시글 등록 시 해시태그 여러개 입력 가능
    - 해당 해시태그가 달린 게시물만 따로 검색 가능
- 1:1 채팅
    - WebSocket을 이용한 실시간 채팅
    - 채팅 메세지 읽음 / 안읽음 상태 표시
    - 안읽은 채팅이 존재할 때 알림 표시

</div>
</details>

## **💻**기술 스택
- - -

### 프론트엔드

- Javascprit
- react

### 백엔드

- Java : 17
- Spring Boot : 2.7.7
- Spring Data JPA
- QueryDsl
- Build : Gradle
- Test : Postman
- DB : MySQL
- IDE : Intellij IDEA

### 협업

- Git
- Notion
- Discord

### 인프라

- Github Actions
- Docker
- AWS EC2
- AWS CodeDeploy
- AWS S3
- AWS ELB
- AWS Route 53
- AWS RDS

## **🛠 Architecture**
- - -

![Blank diagram (1)](https://user-images.githubusercontent.com/102534186/231504360-68ff7a55-2e0c-4e69-84e4-116b4e70f2ce.png)


## 🎯ERD
- - -

![image](https://user-images.githubusercontent.com/102534186/229378435-9e838c80-3eb3-4149-b84f-ef276b1db8be.png)

## 📃페이지
- - -

<details>
<summary>페이지 동작 예시 펼치기</summary>
<div>

### 게시글 전체조회 


![Pasted Graphic](https://user-images.githubusercontent.com/67457956/229806689-6c796222-d963-4f34-8380-b5ba8ef64d3b.png)



### 게시글 상세조회


![Pasted Graphic 1](https://user-images.githubusercontent.com/67457956/229808232-ab716863-a3de-4d40-81de-1f722e5a14f8.png)



### 댓글 조회


![Pasted Graphic 2](https://user-images.githubusercontent.com/67457956/229808716-4babb640-f7f1-4a4c-9e6a-078c10f37bbb.png)



### 유저 프로필 


![image](https://user-images.githubusercontent.com/67457956/229809273-a8e145fc-de74-4791-aa4e-23ff73b6afae.png)



### 해쉬태그 검색

![Pasted Graphic 4](https://user-images.githubusercontent.com/67457956/229809397-0625eced-6b56-4534-83e1-251eec625c0f.png)



### 게시글 검색


![Pasted Graphic 5](https://user-images.githubusercontent.com/67457956/229809569-b80b274f-74e2-4d6b-80ad-96c410f5c5f5.png)\



### 팔로잉 뉴스피드


![Pasted Graphic 6](https://user-images.githubusercontent.com/67457956/229809835-2eb355d9-1612-4e37-8b88-f8afe32cc79f.png)



### 팔로잉 팔로워 조회

![image](https://user-images.githubusercontent.com/67457956/229810850-89e0b58c-953f-41ad-9c02-842a488efb34.png)


   
### 채팅

![image](https://user-images.githubusercontent.com/67457956/229811170-498bb32a-2847-44df-8ee8-a23f19732bf3.png)


</div>
</details>

## 📌고민과 해결

- - - 

<details>
<summary>JWT를 이용한 인증/인가 처리</summary>
<div>

### 로그인 순서도

![로그인 구조도 drawio](https://user-images.githubusercontent.com/102534186/231640570-181bb3fb-9740-40e4-8e82-4bfc1c65129e.png)


---

### Spring Security를 사용하지 않은 이유

- Spring Security를 사용하기 위해 공부해보니, 강력한 기능만큼 그 원리도 복잡했습니다.
- 구글링을 하며 필요한 기능만 적절히 사용할수도 있지만 그것보다는 **직접 구현해보면서 원리를 파악**해보고 싶었습니다.

---

### 토큰을 어디에 보관할 것인가?

- 클라이언트에서 토큰을 어디에 보관해야 더 보안적으로 안전할지 고민했습니다.
- 브라우저의 저장소와 쿠키라는 선택지가 있었습니다.

|  | 쿠키 | 브라우저 저장소 |
| --- | --- | --- |
| XXS | 안전 | 비교적 위험 |
| CSRF | 비교적 위험 | 안전 |
- 최종적으로 **쿠키를 사용하기로 결정**했습니다. 이유는 아래와 같습니다.
    - 쿠키에는 secure, httpOnly, samesite 등 여러가지 보안 옵션이 존재합니다.
    - CSRF 공격에는 samsite 설정으로, CORS 공격에는 서버의 allowedOrigins 설정을 적용했습니다.
    - 쿠키는 별도로 헤더에 담지 않아도 요청을 보낼때 자동으로 함께 보내지기 때문에 코드가 간결해집니다.

---

### 요청의 종류에 따른 인증처리

- 클라이언트의 요청에는 여러 종류가 있습니다.
    - 로그인이 필요없는 요청 (ex. 게시물 리스트 조회)
    - 로그인을 했는지 안했는지에 따라 응답이 달라지는 요청
    - 특정 권한이 필요한 요청
- 초기에는 토큰의 유효성 검증을 필터에서 담당하도록 설계했습니다.
- 하지만 필터는 토큰의 유효성 검증을 할 필요가 없는 요청에 대해서도 검증을 진행했습니다.
- 이러한 불필요한 과정을 없애기 위해 **인터셉터로 검증 지점을 변경**했습니다. 📍[[코드 보기]](https://github.com/lamodadite/MSL-backend/blob/main/src/main/java/Maswillaeng/MSLback/utils/interceptor/ValidInterceptor.java)
- 검증이 필요한 요청만 인터셉터를 거치도록 **커스텀 어노테이션을 만들어** 컨트롤러에 명시하도록 했습니다. 

![image](https://user-images.githubusercontent.com/102534186/231640754-964fceef-d7a6-417d-942d-75e9a128043f.png)

---

### 토큰의 클레임을 담을 객체의 필요성

- 토큰의 클레임을 가지고 요청을 진행하기 위해 Spring Security의 UserDetails와 같은 역할을 하는 객체가 필요했습니다.
- SecurityContextHolder에서 사용하는 **threadLocal의 존재에 대해 알게되어 이를 활용**했습니다. 📍[[코드 보기]](https://github.com/lamodadite/MSL-backend/blob/main/src/main/java/Maswillaeng/MSLback/utils/auth/UserContext.java)
    - ValidInterceptor의 preHandle에서 토큰의 클레임을 ThreadLocal에 넣어줍니다. 
    - ValidInterceptor postHandle 에서 토큰 데이터를 ThreadLocal에서 삭제해줍니다.
- threadLocal을 사용함으로써 thread-safe하게 데이터를 관리할 수 있습니다.
</div>
</details>

<details>
<summary>조회 로직 최적화 과정</summary>
<div>

### 상황

- 게시물 상세 조회 기능을 구현하는 과정이었습니다.
- 초기에는 Spring Data JPA의 기능을 이용하여 엔티티를 조회하고 있었습니다.
    - `postRepository.findById()`
- POST 엔티티를 조회해 필요한 정보를 DTO로 맵핑하여 반환했습니다.
- 응답 스펙에는 user, comment, hashtag, report, postLike, commentLike 등 연관관계를 가진 엔티티의 속성들이 포함되어 있었습니다.
![Post drawio](https://user-images.githubusercontent.com/102534186/231640939-c31417ff-ab48-4c08-8699-cc1f1c474359.png)
- 해당 로직과 연관된 데이터가 많아지자 **JPA의 N+1문제가 발생**했습니다.

### 해결 과정 1

- 연관관계를 맺고 있는 모든 엔티티에 fetch join을 적용했습니다.
- 쿼리가 나가긴 했지만, 데이터를 제대로 가져오지 않았습니다.
- 원인을 찾아보니 **둘 이상의 컬렉션은 fetch join 할 수 없기 때문**이었습니다.

### 해결 과정 2

- fetch join으로 해결할 수 없으니 native query를 작성하거나 로직 자체를 바꿔야 하나 고민했습니다.
- 하지만 실무에는 더 복잡한 상황이 있을텐데 이정도 상황에서 JPA를 포기하고 싶지 않았습니다.
- 좀 더 깊게 찾아보니 **batch size를 조절하는 방법**이 있다는것을 알게 되었습니다.
- 이를 적용하기 위해 application.yml에서 `default_batch_fetch_size` 를 100으로 조절했습니다.
- **총 4개의 쿼리가 나가는 것을 확인**했습니다. 📍[[코드 보기]](https://github.com/lamodadite/MSL-backend/blob/c07df39def71a336ec42f4fc3c804c2ed6659f79/src/main/java/Maswillaeng/MSLback/domain/repository/PostQueryRepository.java#L33-L61)

<aside>
📌 최적화라고 하기엔 아직 여지가 많이 남았다고 생각합니다. 한정된 시간과 리소스 안에서 최선을 다하긴 했지만 아쉬움이 남습니다.
</aside>

</div>
</details>

<details>
<summary>조회수 증가 로직의 동시성 이슈 해결</summary>
<div>

### 상황

- 게시물 상세 내용을 조회하면 조회수를 1 증가시켜주는 로직이 있습니다.

```java
// 트랜잭션 시작
// post 엔티티 조회
Post post = postQueryRepository.findByIdFetchJoin(postId)
            .orElseThrow(() -> new EntityNotFoundException(Post.class.getSimpleName()));
// post의 조회수 증가
post.increaseHits();
// post DTO 변환
...
// 트랜잭션 종료 
```

- 동시요청 테스트시 **조회수 증가가 누락**되는 현상을 발견했습니다.
- 여러 트랜잭션이 같은 데이터를 변경하면서 발생하는 lost update 현상임을 확인했습니다.

### 고민

- 동시성 이슈를 해결하는 방법은 여러가지가 있었습니다.
    - 설계 자체를 변경
    - 애플리케이션 레벨에서 처리 (자바의 Syncronized 키워드 활용 등)
    - 데이터베이스 레벨에서의 처리 (비관적 락, 낙관적 락)
- 외에도 다양한 방법이 있겠지만 제 수준에서 생각할 수 있는 방법은 이 3가지였습니다.
- 고민 끝에 **데이터베이스에서 비관적 락을 거는 방식을 적용**했습니다. 이유는 다음과 같습니다.
    - 설계 자체를 변경하기 보다는 상용 기술을 활용해보고 싶은 개인적 욕심
    - 자바의 Syncronized 키워드는 서버가 2개 이상일시 동시성을 보장하지 않음
    - 낙관적 락 방식은 문제 발생시 트랜잭션을 롤백시키기 때문에 현재 상황에 부합하지 않다고 판단

### 해결

- 처음 post를 조회하는 쿼리에 **비관적 락**을 거는 명령어를 추가했습니다.📍[[코드 보기]](https://github.com/lamodadite/MSL-backend/blob/9e1c039dd6161c6c106ddd787b20b7aa56d6c544/src/main/java/Maswillaeng/MSLback/domain/repository/PostQueryRepository.java#L64-L73)
- 1000명의 유저가 동시에 요청을 보냈을때 **조회수가 정확히 1000 올라가는 것을 확인**했습니다.
- 하지만 처리량(초당 처리개수)은 50%정도 하락했습니다. 성능에 **유의미한 하락**이 있었습니다.

<aside>
📌 해결이라고 하기엔 성능이 너무 많이 하락했습니다. 때문에 실제 서비스 운영시에는 해당 이슈가 자주 발생하는지 확인한 뒤 더 느슨한 방법을 고려할 수 있을것 같습니다.
</aside>

</div>
</details>

<details>
<summary>자식 엔티티의 생명주기 관리</summary>
<div>

### 상황

![post-tag drawio](https://user-images.githubusercontent.com/102534186/231641224-af686616-37ab-4672-999a-f1f45aac6ae3.png)


- post와 tag의 **다대다 관계를 풀기 위해** 중간에 hashTag라는 맵핑 테이블을 만들었습니다.
- post와 hashTag는 부모 자식 관계이므로 영속성 전이 설정을 해두었습니다.
    - `cascade = CascadeType.ALL`
- 이를 통해 post를 삭제했을때 연관된 hashTag도 함께 삭제됐지만, **tag는 그대로 남아있는 문제가 발생**했습니다.
- tag는 여러 포스트에서 참조하고 있을 수 있기 때문에 해당 tag를 참조하는 post가 없는것이 확정적일때 직접 삭제해줘야 했습니다.

### 고민

- 스케쥴링을 통해 일정 주기로 tag 테이블에서 쓰임이 없는 데이터를 삭제하면 어떨까 생각했습니다.
- 하지만 서버를 띄우고 작업하지 않았기 때문에 **테스트가 어렵다**는 단점이 있었습니다.
- 어플리케이션 레벨에서 문제를 해결하고 싶다는 개인적인 욕심도 있었습니다.
- hashTag가 삭제될때 같은 tag를 참조하는 hashTag의 숫자를 확인하여 tag를 삭제할것인지 선택하는 로직을 작성하여 해결했습니다.

### 해결

- **어플리케이션 레벨에서 해결**하긴 했지만 단순 삭제보다 로직이 무거워졌습니다. 📍[[코드 보기]](https://github.com/lamodadite/MSL-backend/blob/9e1c039dd6161c6c106ddd787b20b7aa56d6c544/src/main/java/Maswillaeng/MSLback/service/HashTagService.java#L39-L43)
- 더 깔끔하게 처리할 방법이 분명 있을텐데 실무에서는 어떻게 하는지 궁금했습니다.

<aside>
📌 찾아보니 실무에서는 향후 복구나 이력 확인, 보안 등의 문제로 직접 데이터를 삭제하는 일이 드물다는 사실을 알게 되었습니다. 그렇다면 데이터를 무한정 쌓아놓는 것인지, 일정 주기로 삭제하는 것인지, 삭제한다면 어떻게 하는지에 대한 의문이 남아있습니다.

</aside>

</div>
</details>

<details>
<summary>AWS 기반 인프라 구축과 CI/CD</summary>
<div>

### 인프라 구조

![Blank diagram (1)](https://user-images.githubusercontent.com/102534186/231641503-166911cb-5973-4c57-be2b-fecab87ca7e9.png)

### NGINX를 써야 하는가?

- 초기 설계는 이러했습니다.

![image](https://user-images.githubusercontent.com/102534186/231641574-1fa625cb-8796-4c7e-833b-a804782a4aae.png)

- 구글링을 통해 다른 사람들은 어떻게 했는지 찾아보고 따라했습니다.
- nginx의 역할과 ELB에 대해 학습하면서 **역할이 겹치지 않나 하는 의문**이 들었습니다.
- 해당 구조에서 제가 이해한 nginx의 역할은 3가지 입니다.
    - 정적 리소스 관리
    - 리버스 프록시
    - 로드 밸런싱
- 정적 리소스 관리는 현재 구조에서는 필요 없습니다. 필요하다면 S3를 이용할 수 있습니다.
- 리버스 프록시와 로드밸런싱의 역할은 이미 ELB에서 하고 있습니다.
- 제가 찾아본 모든 블로그 글에서 nginx와 ELB를 함께 쓰고 있었지만 과감히 **nginx를 제거**했습니다.

### 성장한 점

- AWS 생태계를 이해하고 클라우드 기반 인프라를 실제로 구축하는 경험을 할 수 있었습니다.
- docker의 개념과 역할을 이해하고 실제로 컨테이너를 띄워 실행시켜보았습니다.
- 리눅스 환경에서 서버를 실행하고 관리하는 경험을 할 수 있었습니다.
- 배포 자동화의 원리를 이해하고, 그 필요성과 편리함을 느꼈습니다.
