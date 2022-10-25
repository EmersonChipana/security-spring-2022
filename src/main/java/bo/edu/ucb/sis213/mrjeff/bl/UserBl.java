package bo.edu.ucb.sis213.mrjeff.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.mrjeff.dao.MrUserDao;
import bo.edu.ucb.sis213.mrjeff.dto.CreateUserDto;
import bo.edu.ucb.sis213.mrjeff.entity.MrUser;
import org.springframework.stereotype.Service;

@Service
public class UserBl {
    private MrUserDao mrUserDao;

    public UserBl(MrUserDao mrUserDao) {
        this.mrUserDao = mrUserDao;
    }

    public void createUser(CreateUserDto createUserDto) {
        MrUser mrUser = new MrUser();
        mrUser.setUsername(createUserDto.getUsername());
        // Encrypt secret with BCrypt
        String secret = BCrypt.withDefaults().hashToString(12,
                createUserDto.getSecret().toCharArray());
        mrUser.setSecret(secret);
        this.mrUserDao.createUser(mrUser);
    }
}
