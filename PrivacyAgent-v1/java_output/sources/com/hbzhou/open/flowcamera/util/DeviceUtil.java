package com.hbzhou.open.flowcamera.util;

/* loaded from: classes22.dex */
public class DeviceUtil {
    public static java.lang.String[] a = {"hwH60", "hwPE", "hwH30", "hwHol", "hwG750", "hw7D", "hwChe2"};

    public static java.lang.String getDeviceInfo() {
        return "手机型号：" + android.os.Build.DEVICE + "\n系统版本：" + android.os.Build.VERSION.RELEASE + "\nSDK版本：" + android.os.Build.VERSION.SDK_INT;
    }

    public static java.lang.String getDeviceModel() {
        return android.os.Build.DEVICE;
    }

    public static boolean isHuaWeiRongyao() {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            if (a[i].equals(getDeviceModel())) {
                return true;
            }
        }
        return false;
    }
}
