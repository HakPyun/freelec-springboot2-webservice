package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter//getter와 field가 같이 있으면 jackson(JSON)이 get(field)의 property가 존재한다고 봄.
@NoArgsConstructor//JSON을 dto에 담을 때 기본 생성자 필요. 역직렬화시 객체생성 해야해서 필요함(JSON -> Java Object)
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

    //Jackson은 스프링부트에서 RequestBody, ResponseBody, RestController쓸 때 뒤에서 자동으로 쓰이는 것. 직렬화(객체 -> JSON) 역직렬화(JSON -> 객체) 담당

    /* 리플렉션이 setter없이 값을 꽂아넣는 방법.
    *
    * Field field = Member.class.getDeclaredField("name");
    * field.setAccessible(true);
    * field.set(member, "kim");
    *
    */

}
