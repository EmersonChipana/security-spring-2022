package bo.edu.ucb.sis213.mrjeff.api;

import bo.edu.ucb.sis213.mrjeff.bl.UserBl;
import bo.edu.ucb.sis213.mrjeff.dto.CreateUserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserApi {
    private UserBl userBl;

    public UserApi(UserBl userBl) {
        this.userBl = userBl;
    }

    @PostMapping
    public Map createUser(@RequestBody CreateUserDto createUserDto) {
        userBl.createUser(createUserDto);
        return Map.of("message", "User created");
    }
}
