package com.huawei.agconnect;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class AGConnectApp {
    public static com.huawei.agconnect.AGConnectApp getInstance() {
        return com.huawei.agconnect.config.impl.a.a();
    }

    public static com.huawei.agconnect.AGConnectApp initialize(android.content.Context context) {
        return com.huawei.agconnect.config.impl.a.a(context);
    }

    public abstract void setApiKey(java.lang.String str);

    public abstract void setAppId(java.lang.String str);

    public abstract void setClientId(java.lang.String str);

    public abstract void setClientSecret(java.lang.String str);

    public abstract void setCpId(java.lang.String str);

    public abstract void setCustomAuthProvider(com.huawei.agconnect.CustomAuthProvider customAuthProvider);

    public abstract void setCustomCredentialsProvider(com.huawei.agconnect.CustomCredentialsProvider customCredentialsProvider);

    public abstract void setParam(java.lang.String str, java.lang.String str2);

    public abstract void setProductId(java.lang.String str);
}
