package com.gratteceil.tech.cxfrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gratteceil.tech.cxfrest.modle.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
