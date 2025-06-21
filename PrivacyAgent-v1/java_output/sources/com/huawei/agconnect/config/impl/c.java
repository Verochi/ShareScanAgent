package com.huawei.agconnect.config.impl;

/* loaded from: classes22.dex */
public class c extends com.huawei.agconnect.config.AGConnectServicesConfig {
    public final android.content.Context c;
    public final java.lang.String d;
    public com.huawei.agconnect.config.LazyInputStream e;
    public volatile com.huawei.agconnect.config.impl.d f;
    public final java.lang.Object g = new java.lang.Object();
    public com.huawei.agconnect.AGCRoutePolicy h = com.huawei.agconnect.AGCRoutePolicy.UNKNOWN;
    public final java.util.Map<java.lang.String, java.lang.String> i = new java.util.HashMap();
    public volatile com.huawei.agconnect.config.impl.e j;

    /* renamed from: com.huawei.agconnect.config.impl.c$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.huawei.agconnect.config.LazyInputStream {
        public final /* synthetic */ java.io.InputStream c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(android.content.Context context, java.io.InputStream inputStream) {
            super(context);
            this.c = inputStream;
        }

        @Override // com.huawei.agconnect.config.LazyInputStream
        public java.io.InputStream get(android.content.Context context) {
            return this.c;
        }
    }

    public c(android.content.Context context, java.lang.String str) {
        this.c = context;
        this.d = str;
    }

    public static com.huawei.agconnect.config.LazyInputStream a(android.content.Context context, java.io.InputStream inputStream) {
        return new com.huawei.agconnect.config.impl.c.AnonymousClass1(context, inputStream);
    }

    public static java.lang.String b(java.lang.String str) {
        int i = 0;
        if (str.length() > 0) {
            while (str.charAt(i) == '/') {
                i++;
            }
        }
        return '/' + str.substring(i);
    }

    public final void c() {
        if (this.f == null) {
            synchronized (this.g) {
                if (this.f == null) {
                    com.huawei.agconnect.config.LazyInputStream lazyInputStream = this.e;
                    if (lazyInputStream != null) {
                        this.f = new com.huawei.agconnect.config.impl.h(lazyInputStream.loadInputStream());
                        this.e.close();
                        this.e = null;
                    } else {
                        this.f = new com.huawei.agconnect.config.impl.k(this.c, this.d);
                    }
                    this.j = new com.huawei.agconnect.config.impl.e(this.f);
                }
                e();
            }
        }
    }

    public final java.lang.String d(java.lang.String str) {
        com.huawei.agconnect.JsonProcessingFactory.JsonProcessor jsonProcessor;
        java.util.Map<java.lang.String, com.huawei.agconnect.JsonProcessingFactory.JsonProcessor> processors = com.huawei.agconnect.JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str) && (jsonProcessor = processors.get(str)) != null) {
            return jsonProcessor.processOption(this);
        }
        return null;
    }

    public final void e() {
        if (this.h != com.huawei.agconnect.AGCRoutePolicy.UNKNOWN || this.f == null) {
            return;
        }
        this.h = com.huawei.agconnect.config.impl.Utils.getRoutePolicyFromJson(this.f.a("/region", null), this.f.a("/agcgw/url", null));
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(java.lang.String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(java.lang.String str, boolean z) {
        return java.lang.Boolean.parseBoolean(getString(str, java.lang.String.valueOf(z)));
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public android.content.Context getContext() {
        return this.c;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public java.lang.String getIdentifier() {
        return com.huawei.agconnect.config.impl.Utils.DEFAULT_NAME;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(java.lang.String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(java.lang.String str, int i) {
        try {
            return java.lang.Integer.parseInt(getString(str, java.lang.String.valueOf(i)));
        } catch (java.lang.NumberFormatException unused) {
            return i;
        }
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public java.lang.String getPackageName() {
        return this.d;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public com.huawei.agconnect.AGCRoutePolicy getRoutePolicy() {
        if (this.h == null) {
            this.h = com.huawei.agconnect.AGCRoutePolicy.UNKNOWN;
        }
        com.huawei.agconnect.AGCRoutePolicy aGCRoutePolicy = this.h;
        com.huawei.agconnect.AGCRoutePolicy aGCRoutePolicy2 = com.huawei.agconnect.AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy == aGCRoutePolicy2 && this.f == null) {
            c();
        }
        com.huawei.agconnect.AGCRoutePolicy aGCRoutePolicy3 = this.h;
        return aGCRoutePolicy3 == null ? aGCRoutePolicy2 : aGCRoutePolicy3;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public java.lang.String getString(java.lang.String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public java.lang.String getString(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            throw new java.lang.NullPointerException("path must not be null.");
        }
        if (this.f == null) {
            c();
        }
        java.lang.String b = b(str);
        java.lang.String str3 = this.i.get(b);
        if (str3 != null) {
            return str3;
        }
        java.lang.String d = d(b);
        if (d != null) {
            return d;
        }
        java.lang.String a = this.f.a(b, str2);
        return com.huawei.agconnect.config.impl.e.a(a) ? this.j.a(a, str2) : a;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(com.huawei.agconnect.config.LazyInputStream lazyInputStream) {
        this.e = lazyInputStream;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(java.io.InputStream inputStream) {
        overlayWith(a(this.c, inputStream));
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setParam(java.lang.String str, java.lang.String str2) {
        this.i.put(com.huawei.agconnect.config.impl.Utils.fixPath(str), str2);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setRoutePolicy(com.huawei.agconnect.AGCRoutePolicy aGCRoutePolicy) {
        this.h = aGCRoutePolicy;
    }
}
