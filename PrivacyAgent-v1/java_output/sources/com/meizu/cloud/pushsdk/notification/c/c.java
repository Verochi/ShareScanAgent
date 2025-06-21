package com.meizu.cloud.pushsdk.notification.c;

/* loaded from: classes23.dex */
public class c {
    public static int a(android.content.Context context) {
        return com.meizu.cloud.pushsdk.notification.c.d.a(context).a(context, "push_expandable_big_image_notification", "layout");
    }

    public static int b(android.content.Context context) {
        return com.meizu.cloud.pushsdk.notification.c.d.a(context).a(context, "push_expandable_big_text_notification", "layout");
    }

    public static int c(android.content.Context context) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.notification.c.d a = com.meizu.cloud.pushsdk.notification.c.d.a(context);
        int flymeVersion = com.meizu.cloud.pushsdk.util.MzSystemUtils.getFlymeVersion();
        if (flymeVersion > 0 && flymeVersion <= 6) {
            str = "push_pure_pic_notification_f6";
        } else if (flymeVersion == 7) {
            str = "push_pure_pic_notification_f7";
        } else if (flymeVersion == 8) {
            str = "push_pure_pic_notification_f8";
        } else {
            java.lang.String valueOf = java.lang.String.valueOf(context.getResources().getDisplayMetrics().density);
            if (valueOf.length() > 3) {
                valueOf = valueOf.substring(0, 3);
            }
            str = ("2.0".equals(valueOf) || "3.0".equals(valueOf) || "4.0".equals(valueOf) || "6.0".equals(valueOf)) ? "push_pure_pic_notification_f9" : "3.3".equals(valueOf) ? "push_pure_pic_notification_f9_337" : "push_pure_pic_notification_f9_275";
        }
        return a.a(context, str, "layout");
    }

    public static int d(android.content.Context context) {
        return com.meizu.cloud.pushsdk.notification.c.d.a(context).a(context, "push_big_notification_title", "id");
    }

    public static int e(android.content.Context context) {
        return com.meizu.cloud.pushsdk.notification.c.d.a(context).a(context, "push_big_notification_content", "id");
    }

    public static int f(android.content.Context context) {
        return com.meizu.cloud.pushsdk.notification.c.d.a(context).a(context, "push_big_notification_date", "id");
    }

    public static int g(android.content.Context context) {
        return com.meizu.cloud.pushsdk.notification.c.d.a(context).a(context, "push_big_bigview_defaultView", "id");
    }

    public static int h(android.content.Context context) {
        return com.meizu.cloud.pushsdk.notification.c.d.a(context).a(context, "push_big_bigtext_defaultView", "id");
    }

    public static int i(android.content.Context context) {
        return com.meizu.cloud.pushsdk.notification.c.d.a(context).a(context, "push_pure_bigview_banner", "id");
    }

    public static int j(android.content.Context context) {
        return com.meizu.cloud.pushsdk.notification.c.d.a(context).a(context, "push_pure_bigview_expanded", "id");
    }

    public static int k(android.content.Context context) {
        return com.meizu.cloud.pushsdk.notification.c.d.a(context).a(context, "push_big_notification_icon", "id");
    }

    public static int l(android.content.Context context) {
        return com.meizu.cloud.pushsdk.notification.c.d.a(context).a(context, "stat_sys_third_app_notify", com.anythink.expressad.foundation.h.i.c);
    }

    public static int m(android.content.Context context) {
        return com.meizu.cloud.pushsdk.notification.c.d.a(context).a(context, "push_pure_close", "id");
    }
}
