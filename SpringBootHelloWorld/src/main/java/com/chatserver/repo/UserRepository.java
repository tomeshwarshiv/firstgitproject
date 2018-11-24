package com.chatserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatserver.entity.User;
import java.lang.String;
import java.util.List;
import java.lang.Integer;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByEmailIdAndPass(String emailid, String pass);

	public User findByEmailId(String emailid);

	public User findById(Integer id);

}
