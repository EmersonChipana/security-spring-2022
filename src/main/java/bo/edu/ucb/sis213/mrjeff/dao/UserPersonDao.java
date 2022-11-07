package bo.edu.ucb.sis213.mrjeff.dao;

import bo.edu.ucb.sis213.mrjeff.entity.UserPerson;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserPersonDao {
    /**
     * En la vida real sería un query similar a:
     *  SELECT p.first_name, p.last_name, u.username
     *  FROM user u JOIN person p ON u.person_id = p.person_id
     *  WHERE u.username = #{username}
     *  AND u.status = true
     */

    @Select("""
            SELECT 'LUISA' as first_name, 'RAMIREZ' as last_name, username
            from 
                mr_user
            WHERE
                username = #{username}
                AND status = true
            """)
    public UserPerson findByUsername(String username);


}
