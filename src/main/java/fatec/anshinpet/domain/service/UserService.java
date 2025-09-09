package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.UserDTO;
import fatec.anshinpet.api.dto.input.UserInput;
import fatec.anshinpet.domain.exception.BusinessException;
import fatec.anshinpet.domain.exception.UserNotFoundException;
import fatec.anshinpet.domain.model.Role;
import fatec.anshinpet.domain.model.User;
import fatec.anshinpet.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserByIdOrException(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
            new UserNotFoundException("User not found!")
        );
    }

    @Transactional
    public User create(User user, String roleName)  {
        checkEmailAvailability(user.getEmail());
        Role userRole = ("ADMIN".equals(roleName)) ? roleService.getAdminRole() : roleService.getUserRole();
        user.setRoles(Set.of(userRole));
        if (Objects.nonNull(user.getPassword())) user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    public UserDTO update(Long userId, UserInput userInput) {
        User currentUser = findUserByIdOrException(userId);
        BeanUtils.copyProperties(userInput, currentUser, "id", "password");
        if(Objects.nonNull(userInput.getPassword())) currentUser.setPassword(passwordEncoder.encode(userInput.getPassword()));
        userRepository.save(currentUser);
        return parseObject(currentUser, UserDTO.class);
    }

    @Transactional
    public void delete(Long userId) {
        User user = findUserByIdOrException(userId);
        userRepository.deleteById(user.getId());
    }

    private void checkEmailAvailability(String email) {
        userRepository.findUserByEmail(email)
                .ifPresent(u -> {
                    throw new BusinessException("User with this email already exists!");
                });
    }

}
