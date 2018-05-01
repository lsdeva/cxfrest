package com.gratteceil.tech.cxfrest.services;



import java.util.List;
import java.util.Optional;

import com.gratteceil.tech.cxfrest.modle.User;

public interface UserService {

    Optional<User> save(User user);

    Optional<User> findById(long id);

    Optional<List<User>> findAll();

    Optional<User> update(long id, User user);

    void deleteById(long id);
}