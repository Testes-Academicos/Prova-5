package com.uniamerica.systemstudents.repository;


import com.uniamerica.systemstudents.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
