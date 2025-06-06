package api.reservation.repository;

import api.reservation.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findAllUsersByRoles_Name(String name);
    void deleteByEmail(String email);
}
