package io.github.guiiilz.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.github.guiiilz.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


}
