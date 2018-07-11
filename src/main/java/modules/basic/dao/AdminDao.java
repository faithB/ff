package modules.basic.dao;

import modules.basic.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by yang on 2017/2/19.
 */
public interface AdminDao extends BaseDao<Admin> {
    Admin validate(@Param("account") String account);
}
