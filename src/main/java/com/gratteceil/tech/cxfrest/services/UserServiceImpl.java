package com.gratteceil.tech.cxfrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gratteceil.tech.cxfrest.modle.User;
import com.gratteceil.tech.cxfrest.repo.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public Optional<User> save(final User user) {
		return Optional.of(userRepository.save(user));
	}

	public Optional<User> findById(final long id) {
		return Optional.of(userRepository.findOne(id));
	}

	public Optional<List<User>> findAll() {
		return Optional.of(userRepository.findAll());
	}

	public Optional<User> update(final long id, final User user) {

		if (this.findById(id).isPresent()) {
			user.setId(id);
			return this.save(user);
		} else {
			throw new NoSuchElementException();
		}
	}

	public void deleteById(final long id) {
		System.out.println("delete by id " + id);
		userRepository.delete(id);
	}
}
