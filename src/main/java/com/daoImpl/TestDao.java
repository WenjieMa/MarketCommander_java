package com.daoImpl;
import java.util.List;

import com.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao extends JpaRepository<User, Long>{

    List<User> findByUsername(String username);
}