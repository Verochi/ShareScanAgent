package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class l {
    public static int a(android.content.Context context) {
        int i = context.getApplicationInfo().icon;
        if (i != 0) {
            return i;
        }
        int identifier = context.getResources().getIdentifier("btn_star_big_on", com.anythink.expressad.foundation.h.i.c, com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
        if (identifier != 0) {
            return identifier;
        }
        com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
        return android.R.drawable.sym_def_app_icon;
    }

    public static android.graphics.Bitmap a(android.content.Context context, com.huawei.hms.push.k kVar) {
        if (context == null || kVar == null) {
            return null;
        }
        try {
            if (com.huawei.hms.android.HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            }
            if ("com.huawei.android.pushagent".equals(kVar.k())) {
                return null;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("get left bitmap from ");
            sb.append(kVar.k());
            com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", sb.toString());
            return ((android.graphics.drawable.BitmapDrawable) context.getPackageManager().getApplicationIcon(kVar.k())).getBitmap();
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
            return null;
        } catch (java.lang.Exception unused2) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", "build left icon occur Exception.");
            return null;
        }
    }

    @android.annotation.TargetApi(23)
    public static void a(android.content.Context context, android.app.Notification.Builder builder, com.huawei.hms.push.k kVar) {
        if (context == null || builder == null || kVar == null) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", "msg is null");
        } else {
            builder.setSmallIcon(b(context, kVar));
        }
    }

    public static int b(android.content.Context context, com.huawei.hms.push.k kVar) {
        int i = 0;
        if (context == null || kVar == null) {
            com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
            return 0;
        }
        if (!android.text.TextUtils.isEmpty(kVar.m())) {
            java.lang.String[] split = kVar.m().split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            if (split.length == 3) {
                i = com.huawei.hms.push.r.a(context, split[1], split[2]);
            }
        }
        if (i == 0) {
            i = com.huawei.hms.push.r.a(context, "com.huawei.messaging.default_notification_icon");
        }
        return i != 0 ? i : a(context);
    }
}
