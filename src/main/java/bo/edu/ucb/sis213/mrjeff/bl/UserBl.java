package bo.edu.ucb.sis213.mrjeff.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.mrjeff.dao.MrUserDao;
import bo.edu.ucb.sis213.mrjeff.dao.UserPersonDao;
import bo.edu.ucb.sis213.mrjeff.dto.CreateUserDto;
import bo.edu.ucb.sis213.mrjeff.dto.UserDto;
import bo.edu.ucb.sis213.mrjeff.entity.MrUser;
import bo.edu.ucb.sis213.mrjeff.entity.UserPerson;
import org.springframework.stereotype.Service;

@Service
public class UserBl {
    private MrUserDao mrUserDao;
    private UserPersonDao userPersonDao;

    public UserBl(MrUserDao mrUserDao, UserPersonDao userPersonDao) {
        this.mrUserDao = mrUserDao;
        this.userPersonDao = userPersonDao;
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

    public UserPerson findByUsername(String username) {
        return userPersonDao.findByUsername(username);
    }
}
