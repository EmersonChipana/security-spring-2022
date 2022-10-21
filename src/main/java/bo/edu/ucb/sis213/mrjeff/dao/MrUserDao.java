package bo.edu.ucb.sis213.mrjeff.dao;

import bo.edu.ucb.sis213.mrjeff.entity.MrUser;
import org.apache.ibatis.annotations.Select;

public interface MrUserDao {

    @Select("""
            select user_id, username, secret, status, tx_username,
                tx_host, tx_date
            from 
                mr_user
            WHERE
                user_id = #{userId};
            """)
    MrUser findByPrimaryKey(Integer userId);
}
