package com.jfinal.shiro.doman;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author hang_xiao
 * @date 2016/11/29
 */
public class User extends Model<User> {

    public static final User user = new User();

    public void setId(Integer id) {
        set("id", id);
    }

    public Integer getId() {
        return get("id");
    }

    public void setUsername(String username) {
        set("username", username);
    }

    public String getUsername() {
        return get("username");
    }

    public void setPassword(String password) {
        set("password", password);
    }

    public String getPassword() {
        return get("password");
    }

    public User findByUsername(String username) {
        return User.user.findFirst("select * from users where username=?", username);
    }
}
