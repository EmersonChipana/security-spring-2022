package bo.edu.ucb.sis213.mrjeff.unit;

import bo.edu.ucb.sis213.mrjeff.bl.SecurityBl;
import bo.edu.ucb.sis213.mrjeff.dao.MrUserDao;
import bo.edu.ucb.sis213.mrjeff.dto.AuthReqDto;
import bo.edu.ucb.sis213.mrjeff.dto.AuthResDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SecurityBlTest {


    @Test
    void successfulAuthentication() {
        MrUserDao mrUserDao = Mockito.mock(MrUserDao.class);
        SecurityBl securityBl = new SecurityBl(mrUserDao);

        AuthResDto response = securityBl.authenticate(new AuthReqDto("jperez", "12345678"));
        Assertions.assertNotNull(response); // Que la respuesta no sea nula
        Assertions.assertNotNull(response.getToken()); // Que el token no sea nulo
        Assertions.assertNotNull(response.getRefresh()); // Que el refresh token no sea nulo
    }
}
