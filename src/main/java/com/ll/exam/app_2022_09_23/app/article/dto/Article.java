package com.ll.exam.app_2022_09_23.app.article.dto;

import lombok.Data;


// @Data 어노테이션은 Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value를 모두 합친 것이다.
@Data
public class Article {
    private long id;
    private String subject;
    private String content;
}
