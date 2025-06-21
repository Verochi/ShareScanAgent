package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class e {
    public static final java.lang.String a = "e";

    public static android.os.Bundle a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("sdkVer", java.lang.String.valueOf(60500300));
        bundle.putString(com.vivo.push.PushClientConstants.TAG_PKG_NAME, context.getPackageName());
        bundle.putString("aaid", com.huawei.hms.aaid.HmsInstanceId.getInstance(context).getId());
        com.huawei.hms.aaid.plugin.PushProxy proxy = com.huawei.hms.aaid.plugin.ProxyCenter.getProxy();
        if (proxy != null) {
            bundle.putString("proxyType", proxy.getProxyType());
        }
        bundle.putString(com.huawei.hms.push.constant.RemoteMessageConst.MSGID, str);
        if (!android.text.TextUtils.isEmpty(str2)) {
            bundle.putString(com.huawei.hms.push.constant.RemoteMessageConst.ANALYTIC_INFO, str2);
        }
        return bundle;
    }

    public static void a(android.content.Context context, android.os.Bundle bundle, java.lang.String str) {
        com.huawei.hms.push.utils.ha.PushBaseAnalytics pushAnalytics;
        if (bundle == null || (pushAnalytics = com.huawei.hms.push.utils.ha.PushAnalyticsCenter.getInstance().getPushAnalytics()) == null) {
            return;
        }
        bundle.putString("sdk_version", java.lang.String.valueOf(60500300));
        com.huawei.hms.support.log.HMSLog.i(a, "eventId:" + str);
        pushAnalytics.report(context, str, bundle);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.huawei.hms.push.utils.ha.PushBaseAnalytics pushAnalytics = com.huawei.hms.push.utils.ha.PushAnalyticsCenter.getInstance().getPushAnalytics();
        if (pushAnalytics == null) {
            return;
        }
        android.os.Bundle a2 = a(context, str, str2);
        com.huawei.hms.support.log.HMSLog.i(a, "eventId:" + str3);
        pushAnalytics.report(context, str3, a2);
    }
}
