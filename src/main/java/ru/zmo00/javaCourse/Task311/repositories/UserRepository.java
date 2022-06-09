package ru.zmo00.javaCourse.Task311.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zmo00.javaCourse.Task311.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
