package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public abstract class e {
    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo = new com.huawei.hms.framework.network.grs.GrsBaseInfo();
        grsBaseInfo.setSerCountry(str4);
        if (!android.text.TextUtils.isEmpty(str3)) {
            grsBaseInfo.setAppName(str3);
        }
        java.lang.String synGetGrsUrl = new com.huawei.hms.framework.network.grs.GrsClient(context, grsBaseInfo).synGetGrsUrl(str, str2);
        if (android.text.TextUtils.isEmpty(synGetGrsUrl)) {
            com.huawei.hms.support.log.HMSLog.i("QueryGrs", "Query Grs base url is empty.");
            return "";
        }
        com.huawei.hms.support.log.HMSLog.i("QueryGrs", "Query Grs base url success.");
        return synGetGrsUrl;
    }
}
