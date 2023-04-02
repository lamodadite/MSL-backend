# 마쉴랭

## **📍**Overview

### 📜프로젝트 소개

- 술에 진심인 사람들을 위한 칵테일 레시피 공유 커뮤니티
- 술, 안주, 사는 얘기를 자유롭게 할 수 있는 공간

### **⏳**작업 기간 (2023.01 ~ 2023.03)

### 😀팀 소개

|         역할 |        이름 |
| --- | --- |
| 프론트엔드 | 정채운 |
| 백엔드 | 김민영 |
| 백엔드 | 이종민 |

### ⚒️주요 기능

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

## **💻**기술 스택

### 프론트엔드

- Javascprit
- react

### 백엔드

- Java : 17
- Spring Boot : 2.7.7
- Spring Data JPA
- QueryDsl
- Build : Gradle
- Test : Junit5
- DB : MySQL
- IDE : Intellij IDEA

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
![Blank diagram](https://user-images.githubusercontent.com/102534186/229378676-fb655439-34f8-4b8e-8c6d-b7619fb3d934.png)

## 🎯ERD
![image](https://user-images.githubusercontent.com/102534186/229378435-9e838c80-3eb3-4149-b84f-ef276b1db8be.png)

## 📃페이지

## 📒API 명세서

[API 명세서](https://api.mashillaeng.site/swagger-ui/index.html#/)
