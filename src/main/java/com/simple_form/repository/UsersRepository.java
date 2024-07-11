package com.simple_form.repository;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.simple_form.model.UsersModel;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Integer>{

	Optional<UsersModel> findByLoginAndPassword(String login, String password);

	Optional<UsersModel> findFirstByLogin(String string);
}
