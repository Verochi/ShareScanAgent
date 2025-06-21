package com.huawei.hms.push.utils;

/* loaded from: classes22.dex */
public class PluginUtil {
    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject.put("data", str);
            jSONObject2.put(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
            return jSONObject2.toString();
        } catch (org.json.JSONException unused) {
            com.huawei.hms.support.log.HMSLog.e("PluginUtil", "rebuild message failed");
            return null;
        }
    }

    public static void a(android.content.Context context, java.lang.String str) {
        com.huawei.hms.push.e.a(context, str, null, com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.huawei.hms.support.log.HMSLog.i("PluginUtil", "onNotification");
        if (!com.huawei.hms.push.u.a(context)) {
            com.huawei.hms.support.log.HMSLog.i("PluginUtil", context.getPackageName() + " disable display notification.");
            com.huawei.hms.push.e.a(context, str, null, com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL);
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        java.nio.charset.Charset charset = com.huawei.hms.push.x.a;
        intent.putExtra("selfshow_info", str3.getBytes(charset));
        intent.putExtra("selfshow_token", str2.getBytes(charset));
        intent.setPackage(context.getPackageName());
        com.huawei.hms.push.i.a(context, intent);
        com.huawei.hms.support.log.HMSLog.i("PluginUtil", "invokeSelfShow done");
    }

    public static boolean a(android.content.Context context) {
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            com.huawei.hms.support.log.HMSLog.w("PluginUtil", "get running app processes null!");
            return false;
        }
        for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                int i = runningAppProcessInfo.importance;
                return (i == 100 || i == 200) ? false : true;
            }
        }
        return false;
    }

    public static boolean a(android.content.Context context, java.lang.String[] strArr) {
        if (android.text.TextUtils.equals(strArr[1], "0")) {
            return a(context) || android.text.TextUtils.equals(strArr[2], "1");
        }
        return false;
    }

    public static void onAppOpened(android.content.Context context, java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
        com.huawei.hms.push.e.a(context, str, str2, "appHasOpenedId");
        com.huawei.hms.push.e.a(context, bundle, "hmsStatistics");
    }

    public static boolean onDataMessage(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z) {
        com.huawei.hms.support.log.HMSLog.i("PluginUtil", "onDataMessage");
        if (android.text.TextUtils.isEmpty(str2)) {
            com.huawei.hms.support.log.HMSLog.i("PluginUtil", "Empty message received");
            return true;
        }
        if (z) {
            a(context, str);
        }
        android.content.Intent intent = new android.content.Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("message_id", str);
        bundle.putByteArray(com.huawei.hms.push.constant.RemoteMessageConst.MSGBODY, str2.getBytes(com.huawei.hms.push.x.a));
        bundle.putString("message_type", "received_message");
        return new com.huawei.hms.push.h().a(context, bundle, intent);
    }

    public static boolean onDeletedMessages(android.content.Context context) {
        com.huawei.hms.support.log.HMSLog.i("PluginUtil", "onDeletedMessages");
        if (context == null) {
            return false;
        }
        android.content.Intent intent = new android.content.Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("message_proxy_type", com.huawei.hms.aaid.plugin.ProxyCenter.getProxy().getProxyType());
        bundle.putString("message_type", "server_deleted_message");
        return new com.huawei.hms.push.h().a(context, bundle, intent);
    }

    public static void onMessage(android.content.Context context, java.lang.String[] strArr) {
        com.huawei.hms.support.log.HMSLog.i("PluginUtil", "onMessage");
        if (context == null || strArr == null || strArr.length < 5) {
            return;
        }
        if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
            com.huawei.hms.utils.ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
        if (a(context, strArr)) {
            a(context, strArr[0], strArr[3], strArr[4]);
        } else {
            onDataMessage(context, strArr[0], strArr[4], true);
        }
    }

    public static boolean onNewToken(android.content.Context context, java.lang.String str, java.lang.String str2, com.huawei.hms.aaid.constant.ErrorEnum errorEnum) {
        com.huawei.hms.support.log.HMSLog.i("PluginUtil", "onNewToken called.");
        android.content.Intent intent = new android.content.Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("error", errorEnum.getInternalCode());
        bundle.putString("message_type", "new_token");
        bundle.putString(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN, str);
        if (android.text.TextUtils.equals(str2, context.getPackageName())) {
            bundle.putString("subjectId", null);
        } else {
            bundle.putString("subjectId", str2);
        }
        bundle.putString("message_proxy_type", com.huawei.hms.aaid.plugin.ProxyCenter.getProxy().getProxyType());
        return new com.huawei.hms.push.h().a(context, bundle, intent);
    }

    public static void onNotificationArrived(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.huawei.hms.push.e.a(context, str, str2, "100");
    }

    public static void onNotificationClicked(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.huawei.hms.push.e.a(context, str, str2, "1");
        onAppOpened(context, str, str2, null);
    }

    public static boolean onOldDataMessage(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
            com.huawei.hms.utils.ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
        return onDataMessage(context, str, a(str2), true);
    }

    public static void saveNotifySwitch(android.content.Context context, boolean z) {
        new com.huawei.hms.aaid.utils.PushPreferences(context, "push_notify_flag").saveBoolean("notify_msg_enable", z);
    }
}
