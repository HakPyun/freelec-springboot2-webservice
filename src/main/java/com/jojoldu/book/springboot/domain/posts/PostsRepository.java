package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
//CRUD메소드 자동 생성, 리포지토리 빈 등록 엔티티타입과 기본키 타입 필요
public interface PostsRepository extends JpaRepository<Posts, Long>{
}
