package api.reservation.entity;

import api.reservation.entity.dto.UserCredentialsDto;

import java.util.Set;
import java.util.stream.Collectors;

public class UserCresentialsDtoMapper {
    public static UserCredentialsDto map(User user){
        String email = user.getEmail();
        String password = user.getPassword();
        Set<String> roles = user.getRoles()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.toSet());
        return new UserCredentialsDto(email, password, roles);

    }
}
