package bo.edu.ucb.sis213.mrjeff.bl;

import bo.edu.ucb.sis213.mrjeff.dao.MrUserDao;
import bo.edu.ucb.sis213.mrjeff.dto.UserDto;
import bo.edu.ucb.sis213.mrjeff.entity.MrUser;
import org.springframework.stereotype.Service;

@Service
public class SecurityBl {
    private MrUserDao mrUserDao;

    public SecurityBl(MrUserDao mrUserDao) {
        this.mrUserDao = mrUserDao;
    }

    public UserDto getUserByPk(Integer userId) {
        MrUser mrUser = mrUserDao.findByPrimaryKey(userId);
        // Transformamos la entidad de Base de Datos
        // a un DTO para retornar via API  (Data Transfer Object)
        UserDto userDto = new UserDto(mrUser.getUserId(), mrUser.getUsername());
        return userDto;
    }
}
