package com.qq.e.comm.constants;

/* loaded from: classes19.dex */
public class CustomPkgConstants {
    private static final java.lang.String a = com.qq.e.comm.DownloadService.class.getName();
    private static final java.lang.String b = com.qq.e.ads.ADActivity.class.getName();
    private static final java.lang.String c = com.qq.e.ads.PortraitADActivity.class.getName();
    private static final java.lang.String d = com.qq.e.ads.RewardvideoPortraitADActivity.class.getName();
    private static final java.lang.String e = com.qq.e.ads.LandscapeADActivity.class.getName();
    private static final java.lang.String f = com.qq.e.ads.RewardvideoLandscapeADActivity.class.getName();

    public static java.lang.String getADActivityName() {
        java.lang.String customADActivityClassName = com.qq.e.comm.managers.setting.GlobalSetting.getCustomADActivityClassName();
        return !android.text.TextUtils.isEmpty(customADActivityClassName) ? customADActivityClassName : b;
    }

    public static java.lang.String getAssetPluginXorKey() {
        return "";
    }

    public static java.lang.String getDownLoadServiceName() {
        return a;
    }

    public static java.lang.String getLandscapeADActivityName() {
        java.lang.String customLandscapeActivityClassName = com.qq.e.comm.managers.setting.GlobalSetting.getCustomLandscapeActivityClassName();
        return !android.text.TextUtils.isEmpty(customLandscapeActivityClassName) ? customLandscapeActivityClassName : e;
    }

    public static java.lang.String getPortraitADActivityName() {
        java.lang.String customPortraitActivityClassName = com.qq.e.comm.managers.setting.GlobalSetting.getCustomPortraitActivityClassName();
        return !android.text.TextUtils.isEmpty(customPortraitActivityClassName) ? customPortraitActivityClassName : c;
    }

    public static java.lang.String getRewardvideoLandscapeADActivityName() {
        java.lang.String customRewardvideoLandscapeActivityClassName = com.qq.e.comm.managers.setting.GlobalSetting.getCustomRewardvideoLandscapeActivityClassName();
        return !android.text.TextUtils.isEmpty(customRewardvideoLandscapeActivityClassName) ? customRewardvideoLandscapeActivityClassName : f;
    }

    public static java.lang.String getRewardvideoPortraitADActivityName() {
        java.lang.String customRewardvideoPortraitActivityClassName = com.qq.e.comm.managers.setting.GlobalSetting.getCustomRewardvideoPortraitActivityClassName();
        return !android.text.TextUtils.isEmpty(customRewardvideoPortraitActivityClassName) ? customRewardvideoPortraitActivityClassName : d;
    }
}
