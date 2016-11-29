package com.jfinal.shiro.controller;

import com.jfinal.core.Controller;

/**
 * @author hang_xiao
 * @date 2016/11/29
 */
public class LoginController extends Controller {

    public void index() {
        render("login.ftl");
    }
}
