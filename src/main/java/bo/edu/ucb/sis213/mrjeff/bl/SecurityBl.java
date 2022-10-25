package bo.edu.ucb.sis213.mrjeff.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.mrjeff.dao.MrUserDao;
import bo.edu.ucb.sis213.mrjeff.dto.AuthReqDto;
import bo.edu.ucb.sis213.mrjeff.dto.AuthResDto;
import bo.edu.ucb.sis213.mrjeff.dto.UserDto;
import bo.edu.ucb.sis213.mrjeff.entity.MrUser;
import org.springframework.stereotype.Service;

@Service
public class SecurityBl {
    private MrUserDao mrUserDao;


    public SecurityBl(MrUserDao mrUserDao) {
        this.mrUserDao = mrUserDao;
    }

    /**
     * Método realizado para probar la conexión a la BBDD
     * @param userId
     * @return
     */
    public UserDto getUserByPk(Integer userId) {
        MrUser mrUser = mrUserDao.findByPrimaryKey(userId);
        // Transformamos la entidad de Base de Datos
        // a un DTO para retornar via API  (Data Transfer Object)
        UserDto userDto = new UserDto(mrUser.getUserId(), mrUser.getUsername());
        return userDto;
    }

    /**
     * Este metodo realiza la autenticación del sistema, va a buscar al repositorio de BBDD
     * la contraseña del usuario y la compara con su equivalente en BCRYPT
     * @param credentials
     * @return
     */
    public AuthResDto authenticate(AuthReqDto credentials) {
        AuthResDto result = new AuthResDto();
        System.out.println("Comenzando proceso de autenticación con: " + credentials);
        String currentPasswordInBCrypt = mrUserDao.findByUsernameAndPassword(credentials.username());
        System.out.println("Se obtuvo la siguiente contraseña de bbdd: " + currentPasswordInBCrypt);
        // Consulto si los passwords coinciden
        if (currentPasswordInBCrypt != null ) {
            System.out.println("Se procede a verificar si las contraseñas coinciden");
            BCrypt.Result bcryptResult = BCrypt.verifyer().verify(credentials.password().toCharArray(), currentPasswordInBCrypt);
            if (bcryptResult.verified) { // Ha sido verificado
                // Procedo a generar el token
                System.out.println("Las constraseñas coinciden se genera el token");
                result.setToken("TEST TOKEN");
                result.setRefresh("TEST REFRESH TOKEN");
            } else {
                System.out.println("Las constraseñas no coinciden");
                throw new RuntimeException("Forbiden the secret and password are wrong.");
            }
        } else {
            System.out.println("Usuario no existente");
            throw new RuntimeException("Forbiden the secret and password are wrong.");
        }
        return result;
    }

}
