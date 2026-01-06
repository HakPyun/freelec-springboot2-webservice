package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
//CRUD메소드 자동 생성
public interface PostsRepository extends JpaRepository<Posts, Long>{
}
