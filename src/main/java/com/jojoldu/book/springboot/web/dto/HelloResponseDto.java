package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

    /* RequiredArgsConstructor가 만드는 생성자
    * HelloResponseDto dto = new HelloResponseDto(String name, int amount) {
    *   this.name = name;
    *   this.amount = amount;
    * }
    */

    /* Getter가 만드는 메서드
    * public String getName() {
    *    return this.name;
    * }
    *
    * public int getAmount() {
    *    return this.amount;
    * }
    */
}
