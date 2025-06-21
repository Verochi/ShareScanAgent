package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class cr {
    static java.lang.String a;

    static {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
        }
        a = sb.toString();
    }

    public static void a() {
        c(a);
        c("当前使用的自定义地图样式文件和目前版本不匹配，请到官网(lbs.amap.com)更新新版样式文件");
        c(a);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        c(a);
        if (context != null) {
            b("key:" + com.amap.api.mapcore.util.ev.f(context));
        }
        c(str);
        c(a);
    }

    public static void a(java.lang.String str) {
        c(a);
        c(str);
        c(a);
    }

    private static void b(java.lang.String str) {
        if (str.length() >= 78) {
            c("|" + str.substring(0, 78) + "|");
            b(str.substring(78));
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("|");
        sb.append(str);
        for (int i = 0; i < 78 - str.length(); i++) {
            sb.append(" ");
        }
        sb.append("|");
        c(sb.toString());
    }

    private static void c(java.lang.String str) {
    }
}
