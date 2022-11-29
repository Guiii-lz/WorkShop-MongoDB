package io.github.guiiilz.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.github.guiiilz.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
