package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class i extends com.huawei.hms.aaid.utils.PushPreferences {
    public static final java.lang.String TAG = "i";
    public android.content.Context b;

    public i(android.content.Context context) {
        super(context, "push_client_self_info");
        this.b = context;
    }

    public static com.huawei.hms.opendevice.i a(android.content.Context context) {
        return new com.huawei.hms.opendevice.i(context);
    }

    public java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return com.huawei.hms.aaid.encrypt.PushEncrypter.decrypter(this.b, getString(str));
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "getSecureData" + e.getMessage());
            return "";
        }
    }

    public void a() {
        java.util.Map<java.lang.String, ?> all = getAll();
        if (all.isEmpty() || all.keySet().isEmpty()) {
            return;
        }
        for (java.lang.String str : all.keySet()) {
            if (!"push_kit_auto_init_enabled".equals(str) && !"_proxy_init".equals(str)) {
                removeKey(str);
            }
        }
    }

    public boolean a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return saveString(str, com.huawei.hms.aaid.encrypt.PushEncrypter.encrypter(this.b, str2));
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "saveSecureData" + e.getMessage());
            return false;
        }
    }

    public java.lang.String b(java.lang.String str) {
        try {
            return android.text.TextUtils.isEmpty(str) ? a("token_info_v2") : a(str);
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "getSecureData" + e.getMessage());
            return "";
        }
    }

    public boolean b(java.lang.String str, java.lang.String str2) {
        try {
            return android.text.TextUtils.isEmpty(str) ? a("token_info_v2", str2) : a(str, str2);
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "saveSecureData" + e.getMessage());
            return false;
        }
    }

    public boolean c(java.lang.String str) {
        try {
            return android.text.TextUtils.isEmpty(str) ? removeKey("token_info_v2") : removeKey(str);
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "removeToken" + e.getMessage());
            return false;
        }
    }
}
