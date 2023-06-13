package com.crud.crud_app.repository;

import com.crud.crud_app.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<user, Integer> {
}
