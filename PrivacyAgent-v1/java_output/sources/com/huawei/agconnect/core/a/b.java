package com.huawei.agconnect.core.a;

/* loaded from: classes22.dex */
public class b extends com.huawei.agconnect.AGConnectInstance {
    public static java.util.List<com.huawei.agconnect.core.Service> d;
    public static final java.lang.Object e = new java.lang.Object();
    public static final java.util.Map<java.lang.String, com.huawei.agconnect.AGConnectInstance> f = new java.util.HashMap();
    public static java.lang.String g;
    public final com.huawei.agconnect.AGConnectOptions a;
    public final com.huawei.agconnect.core.a.d b;
    public final com.huawei.agconnect.core.a.d c;

    /* renamed from: com.huawei.agconnect.core.a.b$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.huawei.agconnect.JsonProcessingFactory.JsonProcessor {
        @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
        public java.lang.String processOption(com.huawei.agconnect.AGConnectOptions aGConnectOptions) {
            java.lang.String str;
            if (aGConnectOptions.getRoutePolicy().equals(com.huawei.agconnect.AGCRoutePolicy.CHINA)) {
                str = "/agcgw_all/CN";
            } else if (aGConnectOptions.getRoutePolicy().equals(com.huawei.agconnect.AGCRoutePolicy.RUSSIA)) {
                str = "/agcgw_all/RU";
            } else if (aGConnectOptions.getRoutePolicy().equals(com.huawei.agconnect.AGCRoutePolicy.GERMANY)) {
                str = "/agcgw_all/DE";
            } else {
                if (!aGConnectOptions.getRoutePolicy().equals(com.huawei.agconnect.AGCRoutePolicy.SINGAPORE)) {
                    return null;
                }
                str = "/agcgw_all/SG";
            }
            return aGConnectOptions.getString(str);
        }
    }

    /* renamed from: com.huawei.agconnect.core.a.b$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.huawei.agconnect.JsonProcessingFactory.JsonProcessor {
        @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
        public java.lang.String processOption(com.huawei.agconnect.AGConnectOptions aGConnectOptions) {
            java.lang.String str;
            if (aGConnectOptions.getRoutePolicy().equals(com.huawei.agconnect.AGCRoutePolicy.CHINA)) {
                str = "/agcgw_all/CN_back";
            } else if (aGConnectOptions.getRoutePolicy().equals(com.huawei.agconnect.AGCRoutePolicy.RUSSIA)) {
                str = "/agcgw_all/RU_back";
            } else if (aGConnectOptions.getRoutePolicy().equals(com.huawei.agconnect.AGCRoutePolicy.GERMANY)) {
                str = "/agcgw_all/DE_back";
            } else {
                if (!aGConnectOptions.getRoutePolicy().equals(com.huawei.agconnect.AGCRoutePolicy.SINGAPORE)) {
                    return null;
                }
                str = "/agcgw_all/SG_back";
            }
            return aGConnectOptions.getString(str);
        }
    }

    /* renamed from: com.huawei.agconnect.core.a.b$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.huawei.agconnect.JsonProcessingFactory.JsonProcessor {
        @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
        public java.lang.String processOption(com.huawei.agconnect.AGConnectOptions aGConnectOptions) {
            java.lang.String str;
            if (aGConnectOptions.getRoutePolicy().equals(com.huawei.agconnect.AGCRoutePolicy.CHINA)) {
                str = "/service/analytics/collector_url_cn";
            } else if (aGConnectOptions.getRoutePolicy().equals(com.huawei.agconnect.AGCRoutePolicy.RUSSIA)) {
                str = "/service/analytics/collector_url_ru";
            } else if (aGConnectOptions.getRoutePolicy().equals(com.huawei.agconnect.AGCRoutePolicy.GERMANY)) {
                str = "/service/analytics/collector_url_de";
            } else {
                if (!aGConnectOptions.getRoutePolicy().equals(com.huawei.agconnect.AGCRoutePolicy.SINGAPORE)) {
                    return null;
                }
                str = "/service/analytics/collector_url_sg";
            }
            return aGConnectOptions.getString(str);
        }
    }

    /* renamed from: com.huawei.agconnect.core.a.b$4, reason: invalid class name */
    public class AnonymousClass4 implements com.huawei.agconnect.core.service.auth.CredentialsProvider {
        public final /* synthetic */ com.huawei.agconnect.CustomCredentialsProvider a;

        public AnonymousClass4(com.huawei.agconnect.CustomCredentialsProvider customCredentialsProvider) {
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

    /* renamed from: com.huawei.agconnect.core.a.b$5, reason: invalid class name */
    public class AnonymousClass5 implements com.huawei.agconnect.core.service.auth.AuthProvider {
        public final /* synthetic */ com.huawei.agconnect.CustomAuthProvider a;

        public AnonymousClass5(com.huawei.agconnect.CustomAuthProvider customAuthProvider) {
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
            return "";
        }

        @Override // com.huawei.agconnect.core.service.auth.AuthProvider
        public void removeTokenListener(com.huawei.agconnect.core.service.auth.OnTokenListener onTokenListener) {
        }
    }

    public b(com.huawei.agconnect.AGConnectOptions aGConnectOptions) {
        this.a = aGConnectOptions;
        this.b = new com.huawei.agconnect.core.a.d(d, aGConnectOptions.getContext());
        com.huawei.agconnect.core.a.d dVar = new com.huawei.agconnect.core.a.d(null, aGConnectOptions.getContext());
        this.c = dVar;
        if (aGConnectOptions instanceof com.huawei.agconnect.config.impl.b) {
            dVar.a(((com.huawei.agconnect.config.impl.b) aGConnectOptions).a(), aGConnectOptions.getContext());
        }
    }

    public static com.huawei.agconnect.AGConnectInstance a() {
        java.lang.String str = g;
        if (str == null) {
            str = com.huawei.agconnect.config.impl.Utils.DEFAULT_NAME;
        }
        return a(str);
    }

    public static com.huawei.agconnect.AGConnectInstance a(com.huawei.agconnect.AGConnectOptions aGConnectOptions) {
        return b(aGConnectOptions, false);
    }

    public static com.huawei.agconnect.AGConnectInstance a(java.lang.String str) {
        com.huawei.agconnect.AGConnectInstance aGConnectInstance;
        synchronized (e) {
            aGConnectInstance = f.get(str);
            if (aGConnectInstance == null && !com.huawei.agconnect.config.impl.Utils.DEFAULT_NAME.equals(str)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("not find instance for : ");
                sb.append(str);
            }
        }
        return aGConnectInstance;
    }

    public static synchronized void a(android.content.Context context) {
        synchronized (com.huawei.agconnect.core.a.b.class) {
            if (f.size() > 0) {
                return;
            }
            c(context, com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(context));
        }
    }

    public static synchronized void a(android.content.Context context, com.huawei.agconnect.AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        synchronized (com.huawei.agconnect.core.a.b.class) {
            e(context, aGConnectOptionsBuilder);
            c(context, aGConnectOptionsBuilder.build(context));
        }
    }

    public static com.huawei.agconnect.AGConnectInstance b(com.huawei.agconnect.AGConnectOptions aGConnectOptions, boolean z) {
        com.huawei.agconnect.AGConnectInstance aGConnectInstance;
        synchronized (e) {
            java.util.Map<java.lang.String, com.huawei.agconnect.AGConnectInstance> map = f;
            aGConnectInstance = map.get(aGConnectOptions.getIdentifier());
            if (aGConnectInstance == null || z) {
                aGConnectInstance = new com.huawei.agconnect.core.a.b(aGConnectOptions);
                map.put(aGConnectOptions.getIdentifier(), aGConnectInstance);
            }
        }
        return aGConnectInstance;
    }

    public static synchronized void c(android.content.Context context, com.huawei.agconnect.AGConnectOptions aGConnectOptions) {
        synchronized (com.huawei.agconnect.core.a.b.class) {
            android.content.Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            d();
            f();
            com.huawei.agconnect.config.impl.a.a(context);
            if (d == null) {
                d = new com.huawei.agconnect.core.a.c(context).a();
            }
            b(aGConnectOptions, true);
            g = aGConnectOptions.getIdentifier();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("AGC SDK initialize end, default route:");
            sb.append(aGConnectOptions.getRoutePolicy().getRouteName());
            com.huawei.agconnect.core.a.a.a();
        }
    }

    public static void d() {
        com.huawei.agconnect.JsonProcessingFactory.registerProcessor("/agcgw/url", new com.huawei.agconnect.core.a.b.AnonymousClass1());
        com.huawei.agconnect.JsonProcessingFactory.registerProcessor("/agcgw/backurl", new com.huawei.agconnect.core.a.b.AnonymousClass2());
    }

    public static void e(android.content.Context context, com.huawei.agconnect.AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        com.huawei.agconnect.config.AGConnectServicesConfig fromContext = com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(context);
        if (aGConnectOptionsBuilder.getInputStream() != null) {
            try {
                java.lang.String utils = com.huawei.agconnect.config.impl.Utils.toString(aGConnectOptionsBuilder.getInputStream(), "UTF-8");
                aGConnectOptionsBuilder.getInputStream().reset();
                fromContext.overlayWith(new java.io.ByteArrayInputStream(utils.getBytes(java.nio.charset.Charset.forName("UTF-8"))));
            } catch (java.io.IOException unused) {
            }
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : aGConnectOptionsBuilder.getCustomConfigMap().entrySet()) {
            fromContext.setParam(entry.getKey(), entry.getValue());
        }
        if (aGConnectOptionsBuilder.getRoutePolicy() != com.huawei.agconnect.AGCRoutePolicy.UNKNOWN) {
            fromContext.setRoutePolicy(aGConnectOptionsBuilder.getRoutePolicy());
        }
    }

    public static void f() {
        com.huawei.agconnect.JsonProcessingFactory.registerProcessor("/service/analytics/collector_url", new com.huawei.agconnect.core.a.b.AnonymousClass3());
    }

    public void a(com.huawei.agconnect.CustomAuthProvider customAuthProvider) {
        this.c.a(java.util.Collections.singletonList(com.huawei.agconnect.core.Service.builder((java.lang.Class<?>) com.huawei.agconnect.core.service.auth.AuthProvider.class, new com.huawei.agconnect.core.a.b.AnonymousClass5(customAuthProvider)).build()), this.a.getContext());
    }

    public void a(com.huawei.agconnect.CustomCredentialsProvider customCredentialsProvider) {
        this.c.a(java.util.Collections.singletonList(com.huawei.agconnect.core.Service.builder((java.lang.Class<?>) com.huawei.agconnect.core.service.auth.CredentialsProvider.class, new com.huawei.agconnect.core.a.b.AnonymousClass4(customCredentialsProvider)).build()), this.a.getContext());
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public android.content.Context getContext() {
        return this.a.getContext();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public java.lang.String getIdentifier() {
        return this.a.getIdentifier();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public com.huawei.agconnect.AGConnectOptions getOptions() {
        return this.a;
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public <T> T getService(java.lang.Class<? super T> cls) {
        T t = (T) this.c.a(this, cls);
        return t != null ? t : (T) this.b.a(this, cls);
    }
}
