package com.example.yikezhong.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.mob.MobSDK;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Fresco  Mob登录 友盟分享 的初始化全局配置类
 * 注意：如果你的项目使用了继承 Application 的类，那么你需要在这个类中重写 attachBaseContext() 方法并调用 MultiDex.install(this) 来启用 multidex ，
 * AndroidManifest里的application中的name对应的值改为你这个自定义的类。
 */
public class MyApplication extends  Application {
    private static Context context;

    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        //Fresco
        Fresco.initialize(this);
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);

        MobSDK.init(this);

        UMShareAPI.get(this);
        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:【友盟+】 AppKey
         * 参数3:【友盟+】 Channel
         * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数5:Push推送业务的secret
         */
        UMConfigure.init(this,
                         "58edcfeb310c93091c000be2",
                         "Umeng", UMConfigure.DEVICE_TYPE_PHONE,
                         "1fe6a20054bcef865eeb0991ee84525b");



        /**
         * 设置组件化的Log开关,默认情况下SDK运行调试日志关闭。需要用户手动打开。
         * 可通过UMConfigure.setLogEnabled(boolean)接口控制【友盟+】LOG的输出。
         * 参数: boolean 默认为false，如需查看LOG设置为true
         */
        UMConfigure.setLogEnabled(true);
    }

    public static Context getAppContext() {
        return context;
    }
}
