package com.jojoldu.book.springboot.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass//필드만 자식 엔티티에 물려줌. 상속만 해서는 JPA가 컬럼으로 인식하지 못해서 필요
@EntityListeners(AuditingEntityListener.class)//아래 어노테이션들이 작동하기 위해 필요함.
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
