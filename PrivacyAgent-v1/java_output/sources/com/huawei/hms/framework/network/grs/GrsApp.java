package com.huawei.hms.framework.network.grs;

/* loaded from: classes22.dex */
public class GrsApp {
    private static final java.lang.String BRAND;
    private static final com.huawei.hms.framework.network.grs.GrsApp INSTANCE = new com.huawei.hms.framework.network.grs.GrsApp();
    private static final java.lang.String TAG = "GrsApp";
    private java.lang.String appConfigName;

    static {
        java.lang.String str;
        java.lang.String name = com.huawei.hms.framework.network.grs.GrsApp.class.getPackage().getName();
        if ("com.huawei.hms.framework.network.grs".equals(name)) {
            str = "";
        } else {
            java.lang.String[] split = name.split("\\.");
            com.huawei.hms.framework.common.Logger.v(TAG, "current brand is:" + split[1]);
            str = split[1];
        }
        BRAND = str;
    }

    private GrsApp() {
    }

    public static com.huawei.hms.framework.network.grs.GrsApp getInstance() {
        return INSTANCE;
    }

    public java.lang.String getAppConfigName() {
        return this.appConfigName;
    }

    public java.lang.String getBrand(java.lang.String str) {
        java.lang.String str2 = BRAND;
        if (android.text.TextUtils.isEmpty(str2)) {
            return "";
        }
        return str2 + str;
    }

    public java.lang.String getIssueCountryCode(android.content.Context context) {
        return com.huawei.hms.framework.network.grs.a.a(context, false).getCountryCode();
    }

    public void setAppConfigName(java.lang.String str) {
        this.appConfigName = str;
    }
}
