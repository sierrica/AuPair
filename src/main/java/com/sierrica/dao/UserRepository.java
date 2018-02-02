package com.sierrica.dao;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;

//import org.springframework.data.repository.CrudRepository;
import com.sierrica.model.User;

public interface UserRepository {
//public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByEmail(String email);
}
