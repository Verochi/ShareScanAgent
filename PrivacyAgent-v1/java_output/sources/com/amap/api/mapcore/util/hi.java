package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class hi {
    public static final int DEFAULT_RETRY_TIMEOUT = 5000;
    com.amap.api.mapcore.util.hb.a f;
    private java.lang.String h;
    private boolean i;
    private boolean j;
    int c = 20000;
    int d = 20000;
    java.net.Proxy e = null;
    private boolean a = false;
    private int b = 20000;
    private boolean g = true;
    private com.amap.api.mapcore.util.hi.a k = com.amap.api.mapcore.util.hi.a.NORMAL;
    private com.amap.api.mapcore.util.hi.b l = com.amap.api.mapcore.util.hi.b.FIRST_NONDEGRADE;

    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);

        private int f;

        a(int i) {
            this.f = i;
        }
    }

    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);

        private int h;

        b(int i2) {
            this.h = i2;
        }

        public final int a() {
            return this.h;
        }

        public final boolean b() {
            int i2 = this.h;
            return i2 == FIRST_NONDEGRADE.h || i2 == NEVER_GRADE.h || i2 == FIX_NONDEGRADE.h;
        }

        public final boolean c() {
            int i2 = this.h;
            return i2 == DEGRADE_BYERROR.h || i2 == DEGRADE_ONLY.h || i2 == FIX_DEGRADE_BYERROR.h || i2 == FIX_DEGRADE_ONLY.h;
        }

        public final boolean d() {
            int i2 = this.h;
            return i2 == DEGRADE_BYERROR.h || i2 == FIX_DEGRADE_BYERROR.h;
        }

        public final boolean e() {
            return this.h == NEVER_GRADE.h;
        }
    }

    public enum c {
        HTTP(0),
        HTTPS(1);

        private int c;

        c(int i) {
            this.c = i;
        }
    }

    private java.lang.String a(java.lang.String str) {
        byte[] entityBytes = getEntityBytes();
        if (entityBytes == null || entityBytes.length == 0) {
            return str;
        }
        java.util.Map<java.lang.String, java.lang.String> params = getParams();
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.amap.api.mapcore.util.hb.e;
        if (hashMap != null) {
            if (params != null) {
                params.putAll(hashMap);
            } else {
                params = hashMap;
            }
        }
        if (params == null) {
            return str;
        }
        java.lang.String a2 = com.amap.api.mapcore.util.hf.a(params);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(a2);
        return stringBuffer.toString();
    }

    final java.lang.String a() {
        return a(getURL());
    }

    final java.lang.String b() {
        return a(getIPV6URL());
    }

    public int getConntectionTimeout() {
        return this.c;
    }

    public com.amap.api.mapcore.util.hi.a getDegradeAbility() {
        return this.k;
    }

    public com.amap.api.mapcore.util.hi.b getDegradeType() {
        return this.l;
    }

    public byte[] getEntityBytes() {
        return null;
    }

    public java.lang.String getIPDNSName() {
        return "";
    }

    public java.lang.String getIPV6URL() {
        return getURL();
    }

    public java.lang.String getNon_degrade_final_Host() {
        return this.h;
    }

    public abstract java.util.Map<java.lang.String, java.lang.String> getParams();

    public java.net.Proxy getProxy() {
        return this.e;
    }

    public int getReal_max_timeout() {
        return this.b;
    }

    public abstract java.util.Map<java.lang.String, java.lang.String> getRequestHead();

    public java.lang.String getSDKName() {
        return "";
    }

    public int getSoTimeout() {
        return this.d;
    }

    public abstract java.lang.String getURL();

    public com.amap.api.mapcore.util.hb.a getUrlConnectionImpl() {
        return this.f;
    }

    public boolean isBinary() {
        return this.a;
    }

    public boolean isHostToIP() {
        return this.g;
    }

    public boolean isHttps() {
        return this.j;
    }

    public boolean isIPRequest() {
        return !android.text.TextUtils.isEmpty(getIPDNSName());
    }

    public boolean isIPV6Request() {
        return this.i;
    }

    public boolean isIgnoreGZip() {
        return false;
    }

    public boolean isSupportIPV6() {
        return false;
    }

    public java.lang.String parseSDKNameFromPlatInfo(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3 = "";
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                java.lang.String[] split = str.split("&");
                if (split.length > 1) {
                    int length = split.length;
                    int i = 0;
                    java.lang.String str4 = "";
                    while (true) {
                        if (i >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = split[i];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains("product")) {
                            break;
                        }
                        i++;
                    }
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        java.lang.String[] split2 = str2.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!android.text.TextUtils.isEmpty(str4) && android.text.TextUtils.isEmpty(com.amap.api.mapcore.util.fx.a(str3))) {
                                java.lang.String[] split3 = str4.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                                if (split3.length > 1) {
                                    com.amap.api.mapcore.util.fx.a(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "ht", "pnfp");
        }
        return str3;
    }

    public java.lang.String parseSdkNameFromHeader(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return parseSDKNameFromPlatInfo(map.get("platinfo"));
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "ht", "pnfh");
            return null;
        }
    }

    public java.lang.String parseSdkNameFromRequest() {
        java.lang.String str;
        try {
            str = getSDKName();
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    str = this.a ? parseSDKNameFromPlatInfo(((com.amap.api.mapcore.util.hc) this).g()) : parseSdkNameFromHeader(getRequestHead());
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.amap.api.mapcore.util.ga.a(th, "ht", "pnfr");
                return str;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            str = "";
        }
        return str;
    }

    public void setBinary(boolean z) {
        this.a = z;
    }

    public final void setConnectionTimeout(int i) {
        this.c = i;
    }

    public void setDegradeAbility(com.amap.api.mapcore.util.hi.a aVar) {
        this.k = aVar;
    }

    public void setDegradeType(com.amap.api.mapcore.util.hi.b bVar) {
        this.l = bVar;
    }

    public void setHostToIP(boolean z) {
        this.g = z;
    }

    public void setHttpProtocol(com.amap.api.mapcore.util.hi.c cVar) {
        this.j = cVar == com.amap.api.mapcore.util.hi.c.HTTPS;
    }

    public void setIPV6Request(boolean z) {
        this.i = z;
    }

    public void setNon_degrade_final_Host(java.lang.String str) {
        this.h = str;
    }

    public final void setProxy(java.net.Proxy proxy) {
        this.e = proxy;
    }

    public void setReal_max_timeout(int i) {
        this.b = i;
    }

    public final void setSoTimeout(int i) {
        this.d = i;
    }

    public void setUrlConnectionImpl(com.amap.api.mapcore.util.hb.a aVar) {
        this.f = aVar;
    }
}
