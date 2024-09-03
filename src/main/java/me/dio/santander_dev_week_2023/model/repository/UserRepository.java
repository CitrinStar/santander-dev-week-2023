package me.dio.santander_dev_week_2023.model.repository;

import me.dio.santander_dev_week_2023.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
