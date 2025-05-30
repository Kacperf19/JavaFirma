package api.reservation.service;

import api.reservation.entity.User;
import api.reservation.entity.UserCresentialsDtoMapper;
import api.reservation.entity.UserRole;
import api.reservation.entity.dto.UserCredentialsDto;
import api.reservation.entity.dto.UserRegistrotorDto;
import api.reservation.repository.UserRepository;
import api.reservation.repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }


    public Optional<UserCredentialsDto> findCredentialsByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserCresentialsDtoMapper::map);
    }

    @Transactional
    public void register(UserRegistrotorDto registration) {
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        String passwordHash = passwordEncoder.encode(registration.getPassword());
        user.setPassword(passwordHash);

        Optional<UserRole> userRole = userRoleRepository.findByName("USER");
        userRole.ifPresentOrElse(
                role ->
                        user.getRoles().add(role),
                () -> {
                    throw new NoSuchElementException();
                }


        );
        userRepository.save(user);


    }

    public List<String> findAllUserEmails() {
        return userRepository.findAllUsersByRoles_Name("USER")
                .stream()
                .map(User::getEmail)
                .toList();
    }
    @Transactional
    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }
}
