package com.jfinal.shiro.config;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.shiro.controller.HomeController;
import com.jfinal.shiro.controller.LoginController;
import com.jfinal.shiro.doman.Role;
import com.jfinal.shiro.doman.User;

/**
 * @author hang_xiao
 * @date 2016/11/29
 */
public class ApplicationConfig extends JFinalConfig {

    /**
     * 设置访问页面的基本路径
     */
    private static final String BASE_VIEW_PATH = "/WEB-INF/template";

    /**
     * 定义一个全局routes变量
     */
    Routes routes;

    @Override
    public void configConstant(Constants constants) {

        //通过PropKit.use加载的配置将成为主配置，可以通过PropKit.get(...)直接取值
        PropKit.use("mysql-connection.properties");
        //设置为发开模式
        constants.setDevMode(true);
        constants.setViewType(ViewType.FREE_MARKER);
        constants.setBaseViewPath(BASE_VIEW_PATH);

    }

    @Override
    public void configRoute(Routes route) {
        this.routes = route;
        route.add("/", LoginController.class);
        route.add("/home", HomeController.class);
    }

    @Override
    public void configPlugin(Plugins plugins) {
        //连接mysql数据库
        C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("username"), PropKit.get("password"), PropKit.get("jdbcDriver"));
        plugins.add(c3p0Plugin);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
        plugins.add(arp);

        arp.addMapping("users", User.class);
        arp.addMapping("roles", Role.class);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
