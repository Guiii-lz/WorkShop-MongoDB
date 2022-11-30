package io.github.guiiilz.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.guiiilz.workshopmongo.domain.Post;
import io.github.guiiilz.workshopmongo.repository.PostRepository;
import io.github.guiiilz.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	public Post findById(String id) {
		Optional<Post> obj = postRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}


	public List<Post> findAll(){
		List<Post> posts = postRepo.findAll();
		return posts;
	}
}
