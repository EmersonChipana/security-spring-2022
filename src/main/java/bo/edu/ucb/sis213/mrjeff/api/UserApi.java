package bo.edu.ucb.sis213.mrjeff.api;

import bo.edu.ucb.sis213.mrjeff.bl.SecurityBl;
import bo.edu.ucb.sis213.mrjeff.bl.UserBl;
import bo.edu.ucb.sis213.mrjeff.dto.CreateUserDto;
import bo.edu.ucb.sis213.mrjeff.dto.ResponseDto;
import bo.edu.ucb.sis213.mrjeff.dto.UserDto;
import bo.edu.ucb.sis213.mrjeff.entity.UserPerson;
import bo.edu.ucb.sis213.mrjeff.util.AuthUtil;
import bo.edu.ucb.sis213.mrjeff.util.MrJeffException;
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
    public ResponseDto<String> createUser(@RequestHeader Map<String, String> headers, @RequestBody CreateUserDto createUserDto) {
        try {
            String jwt = AuthUtil.getTokenFromHeader(headers);
            // Si no tiene error, se lanzaraá una excepción
            AuthUtil.verifyHasRole(jwt, "CREAR_USUARIO"); // Authorization
            userBl.createUser(createUserDto);
            return new ResponseDto<>("Usuario creado correctamente", null, true);
        } catch (MrJeffException ex) {
            return new ResponseDto<>(ex.getMessage(), null, false);
        }
    }

    /**
     * Endpoint para probar la busqueda por llave primaria
     * @param userId
     * @return
     */
    @GetMapping("/")
    public ResponseDto<UserPerson> getUserFromToken(@RequestHeader Map<String, String> headers) {
        try {
            String username = AuthUtil.isUserAuthenticated(AuthUtil.getTokenFromHeader(headers));
            return new ResponseDto<>(this.userBl.findByUsername(username), null, true);
        }
        catch (MrJeffException ex) {
            return new ResponseDto<>(null, ex.getMessage(), false);
        }
    }

}
