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
        // Implementación falsa
        MrUserDao mrUserDao = Mockito.mock(MrUserDao.class);
        // Nosotros sabemos que para esta prueba se necesita:
        // mrUserDao.findByUsernameAndPassword(credentials.username());
        // Debido a que es prueba unitaria debemos crear el comportamiento de lo que va a hacer el mock
        // Cuando se llame a findByUsernameAndPassword con el argumento "ernestomar"
        Mockito.when(mrUserDao.findSecretByUsername("ernesto"))
                .thenReturn("$2a$12$So1a4kRWCh9USHBfUgs1NOtwUCNXLFvuSmfccBOLe.rPxsy0.LGC6");

        SecurityBl securityBl = new SecurityBl(mrUserDao);
        AuthResDto response = securityBl.authenticate(new AuthReqDto("ernesto", "ABCabc123"));
        Assertions.assertNotNull(response); // Que la respuesta no sea nula
        Assertions.assertNotNull(response.getToken()); // Que el token no sea nulo
        Assertions.assertNotNull(response.getRefresh()); // Que el refresh token no sea nulo
    }
}
