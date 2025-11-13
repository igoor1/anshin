package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.UserDTO;
import fatec.anshinpet.api.dto.input.UserInput;
import fatec.anshinpet.domain.model.User;
import fatec.anshinpet.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers(){
        var users = userService.findAll();
        return parseListObjects(users, UserDTO.class);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable Long userId) {
        User user = userService.findUserByIdOrException(userId);
        return parseObject(user, UserDTO.class);
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser(@PathVariable Long userId, @RequestBody @Valid UserInput userInput) {
        return userService.update(userId, userInput);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
    }

}
