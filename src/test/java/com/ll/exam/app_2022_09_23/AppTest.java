package com.ll.exam.app_2022_09_23;

import com.ll.exam.app_2022_09_23.app.article.dto.Article;
import com.ll.exam.app_2022_09_23.app.article.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
//  @Transactional 포함된 메서드가 호출되면, TransactionalManager를 사용하여 트랜잭션을 시작한다.
//메서드가 실행하기 전 begin을 호출하고, 메서드가 종료된 뒤 commit을 호출한다. 비정상일 경우, Rollback한다.
@Transactional
class AppTest {

	@Autowired
	private ArticleService articleService;

	@Test
	@DisplayName("게시물들 조회")
	void t1() {
		List<Article> articles = articleService.getArticles();
		assertThat(articles.size()).isGreaterThan(0);
	}

	@Test
	@DisplayName("게시물 단건 조회")
	void t3() {
		List<Article> articles = articleService.getArticleById(2L);
		assertThat(articles).isNotNull();
	}

	@Test
	@DisplayName("게시물 작성")
	 void t2() {
		long id = articleService.write("제목3", "내용3");

		assertThat(id).isGreaterThan(0);
	}

}
