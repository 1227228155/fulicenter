package cn.ucai.fulicenter;

import android.app.Application;

import cn.ucai.fulicenter.bean.User;

/**
 * Created by Administrator on 2016/10/17 0017.
 */

public class FuLiCenterApplication extends Application {
    private  static  FuLiCenterApplication instance;
    public   static  FuLiCenterApplication application;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        FuLiCenterApplication.username = username;
    }

    public  static  String username;
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        FuLiCenterApplication.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        instance=this;

    }

    public  static  FuLiCenterApplication getInstance(){
        if (instance==null){
            instance = new FuLiCenterApplication();
        }
        return instance;
    }
}
