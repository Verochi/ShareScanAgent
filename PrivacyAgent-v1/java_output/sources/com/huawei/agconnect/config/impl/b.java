package com.huawei.agconnect.config.impl;

/* loaded from: classes22.dex */
public class b implements com.huawei.agconnect.AGConnectOptions {
    public final java.lang.String a;
    public final android.content.Context b;
    public final java.lang.String c;
    public final com.huawei.agconnect.AGCRoutePolicy d;
    public final com.huawei.agconnect.config.impl.d e;
    public final com.huawei.agconnect.config.impl.e f;
    public final java.util.Map<java.lang.String, java.lang.String> g;
    public final java.util.List<com.huawei.agconnect.core.Service> h;
    public final java.util.Map<java.lang.String, java.lang.String> i = new java.util.HashMap();

    public b(android.content.Context context, java.lang.String str, com.huawei.agconnect.AGCRoutePolicy aGCRoutePolicy, java.io.InputStream inputStream, java.util.Map<java.lang.String, java.lang.String> map, java.util.List<com.huawei.agconnect.core.Service> list, java.lang.String str2) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.b = context;
        str = str == null ? context.getPackageName() : str;
        this.c = str;
        if (inputStream != null) {
            this.e = new com.huawei.agconnect.config.impl.h(inputStream, str);
            com.huawei.agconnect.config.impl.Utils.closeQuietly(inputStream);
        } else {
            this.e = new com.huawei.agconnect.config.impl.k(context, str);
        }
        this.f = new com.huawei.agconnect.config.impl.e(this.e);
        com.huawei.agconnect.AGCRoutePolicy aGCRoutePolicy2 = com.huawei.agconnect.AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy != aGCRoutePolicy2 && "1.0".equals(this.e.a("/configuration_version", null))) {
            throw new java.lang.RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.d = (aGCRoutePolicy == null || aGCRoutePolicy == aGCRoutePolicy2) ? com.huawei.agconnect.config.impl.Utils.getRoutePolicyFromJson(this.e.a("/region", null), this.e.a("/agcgw/url", null)) : aGCRoutePolicy;
        this.g = com.huawei.agconnect.config.impl.Utils.fixKeyPathMap(map);
        this.h = list;
        this.a = str2 == null ? b() : str2;
    }

    public final java.lang.String a(java.lang.String str) {
        java.util.Map<java.lang.String, com.huawei.agconnect.JsonProcessingFactory.JsonProcessor> processors = com.huawei.agconnect.JsonProcessingFactory.getProcessors();
        if (!processors.containsKey(str)) {
            return null;
        }
        if (this.i.containsKey(str)) {
            return this.i.get(str);
        }
        com.huawei.agconnect.JsonProcessingFactory.JsonProcessor jsonProcessor = processors.get(str);
        if (jsonProcessor == null) {
            return null;
        }
        java.lang.String processOption = jsonProcessor.processOption(this);
        this.i.put(str, processOption);
        return processOption;
    }

    public java.util.List<com.huawei.agconnect.core.Service> a() {
        return this.h;
    }

    public final java.lang.String b() {
        return java.lang.String.valueOf(("{packageName='" + this.c + "', routePolicy=" + this.d + ", reader=" + this.e.toString().hashCode() + ", customConfigMap=" + new org.json.JSONObject(this.g).toString().hashCode() + '}').hashCode());
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
        return this.b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public java.lang.String getIdentifier() {
        return this.a;
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
        return this.c;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public com.huawei.agconnect.AGCRoutePolicy getRoutePolicy() {
        com.huawei.agconnect.AGCRoutePolicy aGCRoutePolicy = this.d;
        return aGCRoutePolicy == null ? com.huawei.agconnect.AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public java.lang.String getString(java.lang.String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public java.lang.String getString(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return str2;
        }
        java.lang.String fixPath = com.huawei.agconnect.config.impl.Utils.fixPath(str);
        java.lang.String str3 = this.g.get(fixPath);
        if (str3 != null) {
            return str3;
        }
        java.lang.String a = a(fixPath);
        if (a != null) {
            return a;
        }
        java.lang.String a2 = this.e.a(fixPath, str2);
        return com.huawei.agconnect.config.impl.e.a(a2) ? this.f.a(a2, str2) : a2;
    }
}
