package ru.gnupunk.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gnupunk.client.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmailAndName(String email, String name);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByName(String name);
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
