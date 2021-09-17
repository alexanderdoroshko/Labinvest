package by.labinvent.monitorsensors.repository;


import by.labinvent.monitorsensors.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
