package com.study.spadeworker.domain.article.dto;

import com.study.spadeworker.domain.article.entity.Article;
import com.study.spadeworker.domain.article.entity.ArticleCategory;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ArticleDetailDto {
    private Long articleId;

    private String title;

    private String content;

    private int likesCount;

    private int dislikesCount;

    private String username;

    private String articleCategory;

    private List<String> hashtagList;

    private LocalDateTime createdAt;

    private ArticleDetailDto(Long articleId,
                             String title,
                             String content,
                             int likesCount,
                             int dislikesCount,
                             String username,
                             String articleCategory,
                             List<String> hashtagList,
                             LocalDateTime createdAt) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.likesCount = likesCount;
        this.dislikesCount = dislikesCount;
        this.username = username;
        this.articleCategory = articleCategory;
        this.hashtagList = hashtagList;
        this.createdAt = createdAt;
    }

    public static ArticleDetailDto from(Article article, List<String> hashtagList) {
        return new ArticleDetailDto(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getLikesCount(),
                article.getDislikesCount(),
                article.getUser().getName(),
                article.getArticleCategory().getTitle(),
                hashtagList,
                article.getCreatedAt()
        );
    }
}
