package com.huawei.agconnect;

/* loaded from: classes22.dex */
public final class AGConnectOptionsBuilder {
    public java.lang.String a;
    public java.io.InputStream c;
    public com.huawei.agconnect.AGCRoutePolicy b = com.huawei.agconnect.AGCRoutePolicy.UNKNOWN;
    public final java.util.Map<java.lang.String, java.lang.String> d = new java.util.HashMap();
    public final java.util.List<com.huawei.agconnect.core.Service> e = new java.util.ArrayList();

    /* renamed from: com.huawei.agconnect.AGConnectOptionsBuilder$1, reason: invalid class name */
    public class AnonymousClass1 implements com.huawei.agconnect.core.service.auth.CredentialsProvider {
        public final /* synthetic */ com.huawei.agconnect.CustomCredentialsProvider a;

        public AnonymousClass1(com.huawei.agconnect.CustomCredentialsProvider customCredentialsProvider) {
            this.a = customCredentialsProvider;
        }

        @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
        public com.huawei.hmf.tasks.Task<com.huawei.agconnect.core.service.auth.Token> getTokens() {
            return this.a.getTokens(false);
        }

        @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
        public com.huawei.hmf.tasks.Task<com.huawei.agconnect.core.service.auth.Token> getTokens(boolean z) {
            return this.a.getTokens(z);
        }
    }

    /* renamed from: com.huawei.agconnect.AGConnectOptionsBuilder$2, reason: invalid class name */
    public class AnonymousClass2 implements com.huawei.agconnect.core.service.auth.AuthProvider {
        public final /* synthetic */ com.huawei.agconnect.CustomAuthProvider a;

        public AnonymousClass2(com.huawei.agconnect.CustomAuthProvider customAuthProvider) {
            this.a = customAuthProvider;
        }

        @Override // com.huawei.agconnect.core.service.auth.AuthProvider
        public void addTokenListener(com.huawei.agconnect.core.service.auth.OnTokenListener onTokenListener) {
        }

        @Override // com.huawei.agconnect.core.service.auth.AuthProvider
        public com.huawei.hmf.tasks.Task<com.huawei.agconnect.core.service.auth.Token> getTokens() {
            return this.a.getTokens(false);
        }

        @Override // com.huawei.agconnect.core.service.auth.AuthProvider
        public com.huawei.hmf.tasks.Task<com.huawei.agconnect.core.service.auth.Token> getTokens(boolean z) {
            return this.a.getTokens(z);
        }

        @Override // com.huawei.agconnect.core.service.auth.AuthProvider
        public java.lang.String getUid() {
            return this.a.getUid();
        }

        @Override // com.huawei.agconnect.core.service.auth.AuthProvider
        public void removeTokenListener(com.huawei.agconnect.core.service.auth.OnTokenListener onTokenListener) {
        }
    }

    public com.huawei.agconnect.AGConnectOptions build(android.content.Context context) {
        return new com.huawei.agconnect.config.impl.b(context, this.a, this.b, this.c, this.d, this.e, null);
    }

    public com.huawei.agconnect.AGConnectOptions build(android.content.Context context, java.lang.String str) {
        return new com.huawei.agconnect.config.impl.b(context, this.a, this.b, this.c, this.d, this.e, str);
    }

    public java.util.Map<java.lang.String, java.lang.String> getCustomConfigMap() {
        return new java.util.HashMap(this.d);
    }

    public java.io.InputStream getInputStream() {
        return this.c;
    }

    public com.huawei.agconnect.AGCRoutePolicy getRoutePolicy() {
        return this.b;
    }

    public com.huawei.agconnect.AGConnectOptionsBuilder setApiKey(java.lang.String str) {
        this.d.put("/client/api_key", str);
        return this;
    }

    public com.huawei.agconnect.AGConnectOptionsBuilder setAppId(java.lang.String str) {
        this.d.put("/client/app_id", str);
        return this;
    }

    public com.huawei.agconnect.AGConnectOptionsBuilder setCPId(java.lang.String str) {
        this.d.put("/client/cp_id", str);
        return this;
    }

    public com.huawei.agconnect.AGConnectOptionsBuilder setClientId(java.lang.String str) {
        this.d.put("/client/client_id", str);
        return this;
    }

    public com.huawei.agconnect.AGConnectOptionsBuilder setClientSecret(java.lang.String str) {
        this.d.put("/client/client_secret", str);
        return this;
    }

    public com.huawei.agconnect.AGConnectOptionsBuilder setCustomAuthProvider(com.huawei.agconnect.CustomAuthProvider customAuthProvider) {
        if (customAuthProvider != null) {
            this.e.add(com.huawei.agconnect.core.Service.builder((java.lang.Class<?>) com.huawei.agconnect.core.service.auth.AuthProvider.class, new com.huawei.agconnect.AGConnectOptionsBuilder.AnonymousClass2(customAuthProvider)).build());
        }
        return this;
    }

    public com.huawei.agconnect.AGConnectOptionsBuilder setCustomCredentialProvider(com.huawei.agconnect.CustomCredentialsProvider customCredentialsProvider) {
        if (customCredentialsProvider != null) {
            this.e.add(com.huawei.agconnect.core.Service.builder((java.lang.Class<?>) com.huawei.agconnect.core.service.auth.CredentialsProvider.class, new com.huawei.agconnect.AGConnectOptionsBuilder.AnonymousClass1(customCredentialsProvider)).build());
        }
        return this;
    }

    public com.huawei.agconnect.AGConnectOptionsBuilder setCustomValue(java.lang.String str, java.lang.String str2) {
        this.d.put(str, str2);
        return this;
    }

    public com.huawei.agconnect.AGConnectOptionsBuilder setInputStream(java.io.InputStream inputStream) {
        this.c = inputStream;
        return this;
    }

    public com.huawei.agconnect.AGConnectOptionsBuilder setPackageName(java.lang.String str) {
        this.a = str;
        return this;
    }

    public com.huawei.agconnect.AGConnectOptionsBuilder setProductId(java.lang.String str) {
        this.d.put("/client/product_id", str);
        return this;
    }

    public com.huawei.agconnect.AGConnectOptionsBuilder setRoutePolicy(com.huawei.agconnect.AGCRoutePolicy aGCRoutePolicy) {
        this.b = aGCRoutePolicy;
        return this;
    }
}
