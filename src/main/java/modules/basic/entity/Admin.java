package modules.basic.entity;

import java.io.Serializable;

/**
 * Created by yang on 2017/2/18.
 */
public class Admin implements Serializable {
    private String id;
    private String account;
    private String password;
    private String name;
    private int role;//角色  0超级管理员    1前台   2服务员   3厨师
    private String temp1;
    private String temp2;
    private String temp3;

    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id ;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3;
    }
    /*
* id bigint not null comment '管理员表id',
	account varchar(255) comment '账号',
	password varchar(255) comment '密码',
	name varchar(255) comment '姓名',
	role int comment '角色  0超级管理员    1前台   2服务员   3厨师  ',
	temp1 varchar(255) comment '预留字段1',
    temp2 varchar(255) comment '预留字段2',
    temp3 varchar(255) comment '预留字段3',

* */
}
