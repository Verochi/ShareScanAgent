package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public class g {
    private static java.lang.String a = "DomainSameTool";

    public static boolean a(android.content.Context context) {
        if (context == null) {
            return false;
        }
        try {
            android.content.res.Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM)) > 0;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    private static void b(android.content.Context context) {
    }
}
