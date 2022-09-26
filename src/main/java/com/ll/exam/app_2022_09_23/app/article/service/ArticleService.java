package com.ll.exam.app_2022_09_23.app.article.service;

import com.ll.exam.app_2022_09_23.app.article.dto.Article;
import com.ll.exam.app_2022_09_23.app.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

//@RequiredArgsConstructor 어노테이션은 생성자 주입을 편리하게 도와주는 lombok 어노테이션이다.
//final이나 @NotNull을 필드 앞에 붙이면 생성자를 자동으로 생성해준다.
//의존성이 많아지는 경우 간결한 생성자 주입을 할 수 있도록 도와준다.
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    public List<Article> getArticles() {
        return articleRepository.getArticles();
    }

    public long write(String subject, String content) {
        articleRepository.write(subject, content);

        return articleRepository.getLastInsertId();
    }

    public List<Article> getArticleById(long id) {
        return articleRepository.getArticleById(id);
    }

    public List<Article> search(String kwType, String kw) {
        return articleRepository.search(kwType, kw);
    }
}
