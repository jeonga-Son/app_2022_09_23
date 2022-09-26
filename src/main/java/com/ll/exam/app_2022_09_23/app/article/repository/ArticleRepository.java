package com.ll.exam.app_2022_09_23.app.article.repository;

import com.ll.exam.app_2022_09_23.app.article.dto.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleRepository {
    @Select("""
            <script>
            SELECT *
            FROM article
            </script>
            """)
    List<Article> getArticles();


    @Insert("""
            <script>
            INSERT INTO article
            SET createDate = NOW(),
            modifyDate = NOW(),
            subject = #{subject},
            content = #{content}
            </script>
            """)
    void write(String subject, String content);
    // 위에 코드 안되면 void write(@Param("subject") String subject(이름 아무거나 상관 없음), String content); 이런식으로 코드 작성.


    @Select("""
            SELECT LAST_INSERT_ID()
            """)
    public long getLastInsertId();

    @Select("""
            <script>
            SELECT *
            FROM article
            WHERE id = #{id}
            </script>    
            """)
    List<Article> getArticleById(long id);


    @Select("""
			<script>
            SELECT A.*
            FROM article AS A
            WHERE 1
            <if test="kw != ''">
                <choose>
                    <when test="kwType == 'subject'">
                        AND A.subject LIKE CONCAT('%', #{kw}, '%')
                    </when>
                    <when test="kwType == 'content'">
                        AND A.content LIKE CONCAT('%', #{kw}, '%')
                    </when>
                    <otherwise>
                        AND (
                             A.subject LIKE CONCAT('%', #{kw}, '%')
                             OR
                             A.content LIKE CONCAT('%', #{kw}, '%')
                        )
                    </otherwise>
                </choose>
            </if>
            </script>
            """)
    List<Article> search(String kwType, String kw);
}
