package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class bv extends java.lang.Thread {
    private static final java.lang.String b = "ApkDownloadThread";
    private static final int c = 900000;
    private static volatile com.baidu.mobads.sdk.internal.bv h;
    private volatile java.lang.String d;
    private java.lang.String e;
    private double f;
    private android.os.Handler g;
    private final android.content.Context i;
    private final com.baidu.mobads.sdk.internal.bx k;
    private com.baidu.mobads.sdk.internal.ci j = null;
    private com.baidu.mobads.sdk.internal.bt l = com.baidu.mobads.sdk.internal.bt.a();
    com.baidu.mobads.sdk.internal.ci.a a = new com.baidu.mobads.sdk.internal.bw(this);

    private bv(android.content.Context context, com.baidu.mobads.sdk.internal.bx bxVar, java.lang.String str, android.os.Handler handler) {
        this.e = null;
        this.i = context;
        this.k = bxVar;
        a(bxVar.c());
        this.g = handler;
        this.e = str;
    }

    public static com.baidu.mobads.sdk.internal.bv a(android.content.Context context, com.baidu.mobads.sdk.internal.bx bxVar, java.lang.String str, android.os.Handler handler) {
        if (h == null) {
            h = new com.baidu.mobads.sdk.internal.bv(context, bxVar, str, handler);
        }
        return h;
    }

    private java.lang.String a() {
        java.lang.String str = "__xadsdk__remote__final__" + java.util.UUID.randomUUID().toString() + ".jar";
        java.lang.String str2 = this.e + str;
        java.io.File file = new java.io.File(str2);
        try {
            file.createNewFile();
            this.j.a(this.e, str);
            return str2;
        } catch (java.io.IOException e) {
            file.delete();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, com.baidu.mobads.sdk.internal.bx bxVar, java.lang.String str2) {
        if (str.equals(com.baidu.mobads.sdk.internal.bz.k) || str.equals(com.baidu.mobads.sdk.internal.bz.l)) {
            android.os.Message obtainMessage = this.g.obtainMessage();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelable(com.baidu.mobads.sdk.internal.bz.m, bxVar);
            bundle.putString(com.baidu.mobads.sdk.internal.bz.n, str);
            obtainMessage.setData(bundle);
            this.g.sendMessage(obtainMessage);
        }
    }

    private boolean b() {
        try {
            try {
                this.j = new com.baidu.mobads.sdk.internal.ci(this.i, new java.net.URL(this.d), this.k, this.a);
            } catch (java.net.MalformedURLException unused) {
                this.j = new com.baidu.mobads.sdk.internal.ci(this.i, this.d, this.k, this.a);
            }
            double d = com.baidu.mobads.sdk.internal.bz.q != null ? com.baidu.mobads.sdk.internal.bz.q.b : com.baidu.mobads.sdk.internal.bz.p != null ? com.baidu.mobads.sdk.internal.bz.p.b > 0.0d ? com.baidu.mobads.sdk.internal.bz.p.b : com.baidu.mobads.sdk.internal.bz.p.b : 0.0d;
            this.l.a(b, "isNewApkAvailable: local apk version is: " + d + ", remote apk version: " + this.k.b());
            if (d > 0.0d) {
                if (this.k.b() <= 0.0d) {
                    this.l.a(b, "remote is null, local apk version is null, do not upgrade");
                    return false;
                }
                this.l.a(b, "remote not null, local apk version is null, force upgrade");
                this.f = this.k.b();
                return true;
            }
            if (this.k.b() > 0.0d) {
                if (this.k.b() <= d) {
                    return false;
                }
                this.f = this.k.b();
                return true;
            }
            this.l.a(b, "remote apk version is: null, local apk version is: " + d + ", do not upgrade");
            return false;
        } catch (java.lang.Exception e) {
            java.lang.String str = "parse apk failed, error:" + e.toString();
            this.l.a(b, str);
            throw new com.baidu.mobads.sdk.internal.bz.a(str);
        }
    }

    public void a(java.lang.String str) {
        this.d = str;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.l.a(b, "download apk successfully, downloader exit");
                    h = null;
                } catch (java.io.IOException e) {
                    this.l.a(b, "create File or HTTP Get failed, exception: " + e.getMessage());
                }
                this.l.a(b, "no newer apk, downloader exit");
                h = null;
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
