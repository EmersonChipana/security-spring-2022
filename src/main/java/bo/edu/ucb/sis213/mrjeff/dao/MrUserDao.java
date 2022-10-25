package bo.edu.ucb.sis213.mrjeff.dao;

import bo.edu.ucb.sis213.mrjeff.dto.CreateUserDto;
import bo.edu.ucb.sis213.mrjeff.entity.MrUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MrUserDao {

    @Select("""
            select user_id, username, secret, status, tx_username,
                tx_host, tx_date
            from 
                mr_user
            WHERE
                user_id = #{userId}
                AND status = true
            """)
    MrUser findByPrimaryKey(Integer userId);

    @Select("""
            select secret
            from 
                mr_user
            WHERE
                username = #{username} 
                AND status = true
            """)
    String findByUsernameAndPassword(String username);

    @Insert("""
      INSERT INTO
       mr_user (username, secret, status, tx_username, tx_host, tx_date)
      VALUES (#{username}, #{secret}, true, 'anonymous', 'localhost', now())  
            """)
    void createUser (MrUser mrUser);

}
