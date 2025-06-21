package com.amap.api.services.core;

/* loaded from: classes12.dex */
public class ServiceSettings {
    public static final java.lang.String CHINESE = "zh-CN";
    public static final java.lang.String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static com.amap.api.services.core.ServiceSettings c;
    private java.lang.String a = "zh-CN";
    private int b = 1;
    private int d = 20000;
    private int e = 20000;

    private ServiceSettings() {
    }

    public static com.amap.api.services.core.ServiceSettings getInstance() {
        if (c == null) {
            c = new com.amap.api.services.core.ServiceSettings();
        }
        return c;
    }

    public static synchronized void updatePrivacyAgree(android.content.Context context, boolean z) {
        synchronized (com.amap.api.services.core.ServiceSettings.class) {
            com.amap.api.col.s.br.a(context, z, com.amap.api.col.s.h.a(false));
        }
    }

    public static synchronized void updatePrivacyShow(android.content.Context context, boolean z, boolean z2) {
        synchronized (com.amap.api.services.core.ServiceSettings.class) {
            com.amap.api.col.s.br.a(context, z, z2, com.amap.api.col.s.h.a(false));
        }
    }

    public void destroyInnerAsynThreadPool() {
        try {
            com.amap.api.col.s.an.b();
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "ServiceSettings", "destroyInnerAsynThreadPool");
        }
    }

    public int getConnectionTimeOut() {
        return this.d;
    }

    public java.lang.String getLanguage() {
        return this.a;
    }

    public int getProtocol() {
        return this.b;
    }

    public int getSoTimeOut() {
        return this.e;
    }

    public void setApiKey(java.lang.String str) {
        com.amap.api.col.s.bk.a(str);
    }

    public void setConnectionTimeOut(int i) {
        if (i < 5000) {
            this.d = 5000;
        } else if (i > 30000) {
            this.d = 30000;
        } else {
            this.d = i;
        }
    }

    public void setLanguage(java.lang.String str) {
        this.a = str;
    }

    public void setProtocol(int i) {
        this.b = i;
        com.amap.api.col.s.bo.a().a(this.b == 2);
    }

    public void setSoTimeOut(int i) {
        if (i < 5000) {
            this.e = 5000;
        } else if (i > 30000) {
            this.e = 30000;
        } else {
            this.e = i;
        }
    }
}
