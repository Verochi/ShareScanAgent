package com.tencent.connect.a;

/* loaded from: classes19.dex */
public class a {
    private static java.lang.Class<?> a;
    private static java.lang.Class<?> b;
    private static java.lang.reflect.Method c;
    private static java.lang.reflect.Method d;
    private static java.lang.reflect.Method e;
    private static java.lang.reflect.Method f;
    private static boolean g;

    public static void a(android.content.Context context, com.tencent.connect.auth.QQToken qQToken, java.lang.String str, java.lang.String... strArr) {
        if (g) {
            b(context, qQToken);
            try {
                d.invoke(b, context, str, strArr);
            } catch (java.lang.Exception e2) {
                com.tencent.open.log.SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }

    public static boolean a(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        return com.tencent.open.utils.g.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f.invoke(a, java.lang.Boolean.TRUE);
            } else {
                f.invoke(a, java.lang.Boolean.FALSE);
            }
        } catch (java.lang.Exception e2) {
            com.tencent.open.log.SLog.e("OpenConfig", "checkStatStatus exception: " + e2.toString());
        }
    }

    public static void c(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        java.lang.String str = "Aqc" + qQToken.getAppId();
        try {
            a = java.lang.Class.forName("com.tencent.stat.StatConfig");
            java.lang.Class<?> cls = java.lang.Class.forName("com.tencent.stat.StatService");
            b = cls;
            c = cls.getMethod("reportQQ", android.content.Context.class, java.lang.String.class);
            d = b.getMethod("trackCustomEvent", android.content.Context.class, java.lang.String.class, java.lang.String[].class);
            java.lang.Class<?> cls2 = b;
            java.lang.Class<?> cls3 = java.lang.Integer.TYPE;
            e = cls2.getMethod("commitEvents", android.content.Context.class, cls3);
            java.lang.Class<?> cls4 = a;
            java.lang.Class<?> cls5 = java.lang.Boolean.TYPE;
            f = cls4.getMethod("setEnableStatService", cls5);
            b(context, qQToken);
            a.getMethod("setAutoExceptionCaught", cls5).invoke(a, java.lang.Boolean.FALSE);
            a.getMethod("setEnableSmartReporting", cls5).invoke(a, java.lang.Boolean.TRUE);
            a.getMethod("setSendPeriodMinutes", cls3).invoke(a, 1440);
            java.lang.Class<?> cls6 = java.lang.Class.forName("com.tencent.stat.StatReportStrategy");
            a.getMethod("setStatSendStrategy", cls6).invoke(a, cls6.getField("PERIOD").get(null));
            b.getMethod("startStatService", android.content.Context.class, java.lang.String.class, java.lang.String.class).invoke(b, context, str, java.lang.Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            g = true;
        } catch (java.lang.Exception e2) {
            com.tencent.open.log.SLog.e("OpenConfig", "start4QQConnect exception: " + e2.toString());
        }
    }

    public static void d(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        if (!android.text.TextUtils.isEmpty(qQToken.getOpenId())) {
            com.tencent.open.a.d.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "0", "0", "0");
        }
        if (g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    c.invoke(b, context, qQToken.getOpenId());
                } catch (java.lang.Exception e2) {
                    com.tencent.open.log.SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                }
            }
        }
    }
}
