package com.huawei.agconnect.config.impl;

/* loaded from: classes22.dex */
public class a extends com.huawei.agconnect.AGConnectApp {
    public static final java.util.Map<java.lang.String, com.huawei.agconnect.AGConnectApp> b = new java.util.HashMap();
    public static final java.lang.Object c = new java.lang.Object();
    public static java.lang.String d;
    public com.huawei.agconnect.config.AGConnectServicesConfig a;

    public a(android.content.Context context, java.lang.String str) {
        this.a = com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(context, str);
    }

    public static com.huawei.agconnect.AGConnectApp a() {
        return a(d);
    }

    public static com.huawei.agconnect.AGConnectApp a(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        java.lang.String packageName = context.getPackageName();
        d = packageName;
        return a(context, packageName);
    }

    public static com.huawei.agconnect.AGConnectApp a(android.content.Context context, java.lang.String str) {
        com.huawei.agconnect.AGConnectApp aGConnectApp;
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("packageName can not be empty");
        }
        synchronized (c) {
            java.util.Map<java.lang.String, com.huawei.agconnect.AGConnectApp> map = b;
            aGConnectApp = map.get(str);
            if (aGConnectApp == null) {
                map.put(str, new com.huawei.agconnect.config.impl.a(context, str));
            }
        }
        return aGConnectApp;
    }

    public static com.huawei.agconnect.AGConnectApp a(java.lang.String str) {
        com.huawei.agconnect.AGConnectApp aGConnectApp;
        synchronized (c) {
            aGConnectApp = b.get(str);
            if (aGConnectApp == null) {
                throw new java.lang.IllegalStateException("you should call AGConnectApp.initialize first");
            }
        }
        return aGConnectApp;
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setApiKey(java.lang.String str) {
        this.a.setParam("/client/api_key", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setAppId(java.lang.String str) {
        this.a.setParam("/client/app_id", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setClientId(java.lang.String str) {
        this.a.setParam("/client/client_id", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setClientSecret(java.lang.String str) {
        this.a.setParam("/client/client_secret", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setCpId(java.lang.String str) {
        this.a.setParam("/client/cp_id", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setCustomAuthProvider(com.huawei.agconnect.CustomAuthProvider customAuthProvider) {
        ((com.huawei.agconnect.core.a.b) com.huawei.agconnect.AGConnectInstance.getInstance()).a(customAuthProvider);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setCustomCredentialsProvider(com.huawei.agconnect.CustomCredentialsProvider customCredentialsProvider) {
        ((com.huawei.agconnect.core.a.b) com.huawei.agconnect.AGConnectInstance.getInstance()).a(customCredentialsProvider);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setParam(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("path can not be empty");
        }
        this.a.setParam(str, str2);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setProductId(java.lang.String str) {
        this.a.setParam("/client/product_id", str);
    }
}
