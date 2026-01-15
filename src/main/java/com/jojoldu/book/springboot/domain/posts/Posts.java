package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor//JPA 프록시를 위해 사용
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder//생성자가 하는일과 동일하나 필드가 더 많으면 가독성을 위해 사용하는게 좋음.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /* Builder가 만드는 구조
    * class UserBuilder {
    *   private String name;   // 기본값 null
    *   private int age;       // 기본값 0
    *
    *   public User build() {
    *       return new User(name, age);
    *     }
    * }
    *
    * User user = User.builder().build();로 아무 값을 안채우면
    * new User(null, 0)이 호출되지 기본 생성자가 호출되는 건 아니다.
    *
    */

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
