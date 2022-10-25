package bo.edu.ucb.sis213.mrjeff.api;

import bo.edu.ucb.sis213.mrjeff.bl.SecurityBl;
import bo.edu.ucb.sis213.mrjeff.bl.UserBl;
import bo.edu.ucb.sis213.mrjeff.dto.CreateUserDto;
import bo.edu.ucb.sis213.mrjeff.dto.UserDto;
import bo.edu.ucb.sis213.mrjeff.entity.MrUser;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserApi {
    private UserBl userBl;
    private SecurityBl securityBl;

    public UserApi(UserBl userBl, SecurityBl securityBl) {
        this.userBl = userBl;
        this.securityBl = securityBl;
    }

    @PostMapping
    public Map createUser( @RequestHeader Map<String, String> headers, @RequestBody CreateUserDto createUserDto) {
        System.out.println("Headers: " + headers);
        if (headers.get("Authorization") == null && headers.get("authorization") == null ) {
            return Map.of("message", "No se ha enviado el token de autorización");
        }
        // Se acostumbra que cuando se envia el token, se lo envia en el siguiente formato
        // Authorization: Bearer TOKEN
        String jwt = "";
        if (headers.get("Authorization") != null) {
            jwt = headers.get("Authorization").split(" ")[1];
        } else {
            jwt = headers.get("authorization").split(" ")[1];
        }

        System.out.println("El token enviado es: " + jwt);
        if (this.securityBl.tokenHasRole(jwt, "CREAR_USUARIO")) {
            userBl.createUser(createUserDto);
            return Map.of("message", "User created");
        } else {
            return Map.of("message", "The user does not have the required role");
        }
    }
}
