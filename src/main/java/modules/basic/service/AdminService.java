package modules.basic.service;

import modules.basic.entity.Admin;
import org.springframework.stereotype.Service;

/**
 * Created by yang on 2017/2/19.
 */
@Service
public interface AdminService extends BaseService<Admin> {
    Admin validate(String account);
}
