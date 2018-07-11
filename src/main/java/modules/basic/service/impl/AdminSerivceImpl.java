package modules.basic.service.impl;

import modules.basic.dao.AdminDao;
import modules.basic.entity.Admin;
import modules.basic.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yang on 2017/2/19.
 */
@Service
public class AdminSerivceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    //登录验证
    @Override
    public Admin validate(String account) {
        return adminDao.validate(account);
    }
    //添加用户
    @Override
    public int add(Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        return adminDao.add(admin);
    }

    //删除用户
    @Override
    public int delete(String id) {
        return adminDao.delete(id);
    }

    //更新
    @Override
    public int update(Admin admin) {
        return adminDao.update(admin);
    }

    //查询一个
    @Override
    public Admin getOne(String id) {
        return adminDao.getOne(id);
    }

    //获得所有
    @Override
    public List<Admin> getAll() {
/*        List<Admin> adminList = adminDao.getAll();
        Map<String,String> map = MapUtils.getRoleMap();
        //循环将数字转变为角色名称
        for (Admin admin: adminList) {
            admin.setTemp1(map.get(admin.getRole()+"")); //加上引号查找String类型的key 而不是integer
        }*/
        return null;
    }
}
