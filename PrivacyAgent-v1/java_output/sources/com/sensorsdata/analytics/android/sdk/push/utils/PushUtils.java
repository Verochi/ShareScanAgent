package com.sensorsdata.analytics.android.sdk.push.utils;

/* loaded from: classes19.dex */
public class PushUtils {
    public static java.lang.String getJPushSDKName(byte b) {
        switch (b) {
            case 0:
            case 7:
            default:
                return "Jpush";
            case 1:
                return "Xiaomi";
            case 2:
                return "HUAWEI";
            case 3:
                return "Meizu";
            case 4:
                return com.ss.android.download.api.constant.BaseConstants.ROM_OPPO_UPPER_CONSTANT;
            case 5:
                return com.igexin.assist.util.AssistUtils.BRAND_VIVO;
            case 6:
                return "Asus";
            case 8:
                return "fcm";
        }
    }
}
