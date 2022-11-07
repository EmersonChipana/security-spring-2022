package bo.edu.ucb.sis213.mrjeff.api;

import bo.edu.ucb.sis213.mrjeff.bl.SecurityBl;
import bo.edu.ucb.sis213.mrjeff.dto.AuthReqDto;
import bo.edu.ucb.sis213.mrjeff.dto.AuthResDto;
import bo.edu.ucb.sis213.mrjeff.dto.ResponseDto;
import bo.edu.ucb.sis213.mrjeff.dto.UserDto;
import bo.edu.ucb.sis213.mrjeff.util.MrJeffException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthApi {

    private SecurityBl securityBl;

    public AuthApi(SecurityBl securityBl) {
        this.securityBl = securityBl;
    }

    /**
     * Endpoint para probar la busqueda por llave primaria
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public UserDto test(@PathVariable(name = "userId") Integer userId) {
        return this.securityBl.getUserByPk(userId);
    }

    /**
     * HACERLO ASÍ POR SIMPLICIDAD.
     * @param authReqDto
     * @return
     */
    @PostMapping()
    public ResponseDto<AuthResDto> authentication(@RequestBody  AuthReqDto authReqDto) {
        if (authReqDto != null && authReqDto.username() != null && authReqDto.password() != null) {
            // Retorna los tokens, null (porque no hay error), true porque fue exitoso
            try {
                return new ResponseDto<>(securityBl.authenticate(authReqDto), null, true);
            } catch (MrJeffException ex) {
                return new ResponseDto<>(null, ex.getMessage(), false);
            }
        } else {
            return new ResponseDto<>(null, "Credenciales incorrectas", false);
        }
    }

    /**
     * SOLO PARA PROPOSITOS ILUSTRATIVOS, ESTA ES LA FORMA CORRECTA EN EL ÁMBITO LABORAL.
     * @param authReqDto
     * @return
     */
    @RequestMapping(value="/v2/", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto<AuthResDto>> authenticationV2(@RequestBody  AuthReqDto authReqDto) {
        if (authReqDto != null && authReqDto.username() != null && authReqDto.password() != null) {
            // Retorna los tokens, null (porque no hay error), true porque fue exitoso
            try {
                ResponseDto<AuthResDto> responseDto = new  ResponseDto<>(securityBl.authenticate(authReqDto), null, true);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } catch (MrJeffException ex) {
                ResponseDto<AuthResDto> responseDto = new ResponseDto<>(null, ex.getMessage(),
                        false);
                return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
            }

        } else {
            ResponseDto<AuthResDto> responseDto = new ResponseDto<>(null, "Credenciales incorrectas",
                    false);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
    }

}
