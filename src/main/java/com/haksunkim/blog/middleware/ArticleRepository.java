package com.haksunkim.blog.middleware;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
