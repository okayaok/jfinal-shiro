package com.jfinal.shiro.doman;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author hang_xiao
 * @date 2016/11/29
 */
public class Role extends Model<Role> {

    private static final Role role = new Role();

    public void setId(Integer id) {
        set("id", id);
    }

    public Integer getId() {
        return get("id");
    }

    public void setName(String name) {
        set("name", name);
    }

    public String getName() {
        return get("name");
    }
}
