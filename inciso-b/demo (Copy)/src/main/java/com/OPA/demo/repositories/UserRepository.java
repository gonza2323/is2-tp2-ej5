package com.OPA.demo.repositories;

import com.OPA.demo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);


    @Query("SELECT u FROM UserEntity u WHERE u.username = ?1")
    Optional<UserEntity> getName(String username);

    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    public Optional<UserEntity> getEmail(@Param("email")String email);

    boolean existsByUsername(String admin);
}
