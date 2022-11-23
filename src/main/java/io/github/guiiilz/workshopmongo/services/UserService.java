package io.github.guiiilz.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.guiiilz.workshopmongo.domain.User;
import io.github.guiiilz.workshopmongo.dto.UserDTO;
import io.github.guiiilz.workshopmongo.repository.UserRepository;
import io.github.guiiilz.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public User insert(User obj) {
		return userRepo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		userRepo.deleteById(id);
	}
	
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}
	
	public User update(User user) {
		User newUser= findById(user.getId());
		updateData(newUser, user);
		return userRepo.save(newUser);
	}

	
	
	
}
