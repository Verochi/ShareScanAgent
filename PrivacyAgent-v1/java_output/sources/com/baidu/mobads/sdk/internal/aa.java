package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class aa {
    private static final java.lang.String a = "LoadRemoteDex";
    private static com.baidu.mobads.sdk.internal.aa i;
    private com.baidu.mobads.sdk.api.IXAdContainerFactory b;
    private com.baidu.mobads.sdk.internal.bo c;
    private java.lang.Runnable f;
    private android.content.Context g;
    private boolean k;
    private int d = 5000;
    private android.os.Handler e = new android.os.Handler(android.os.Looper.getMainLooper());
    private com.baidu.mobads.sdk.internal.bt h = com.baidu.mobads.sdk.internal.bt.a();
    private java.util.concurrent.atomic.AtomicBoolean j = new java.util.concurrent.atomic.AtomicBoolean(false);

    public interface a {
        public static final int a = 1;
        public static final int b = 2;

        void onFailure();

        void onSuccess();
    }

    private aa() {
    }

    public static com.baidu.mobads.sdk.internal.aa a() {
        if (i == null) {
            synchronized (com.baidu.mobads.sdk.internal.aa.class) {
                if (i == null) {
                    i = new com.baidu.mobads.sdk.internal.aa();
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str) {
        this.h.a(a, "加载dex失败原因=" + str);
        this.j.set(false);
        i();
        com.baidu.mobads.sdk.internal.s.a().a(2);
    }

    private void f() {
        this.j.set(true);
        if (com.baidu.mobads.sdk.internal.an.a()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        synchronized (com.baidu.mobads.sdk.internal.aa.class) {
            try {
                com.baidu.mobads.sdk.internal.bo boVar = new com.baidu.mobads.sdk.internal.bo(java.lang.Class.forName(com.baidu.mobads.sdk.internal.z.aN, true, getClass().getClassLoader()), this.g);
                this.c = boVar;
                this.b = boVar.a();
                k();
            } catch (java.lang.Exception unused) {
                a("反射调用remote失败");
            }
        }
    }

    private void h() {
        this.f = new com.baidu.mobads.sdk.internal.ab(this);
        j();
        if (com.baidu.mobads.sdk.internal.h.a == null) {
            synchronized (com.baidu.mobads.sdk.internal.bz.class) {
                if (com.baidu.mobads.sdk.internal.h.a == null) {
                    com.baidu.mobads.sdk.internal.h.a = new com.baidu.mobads.sdk.internal.bz(this.g);
                }
            }
        }
        if (this.b != null) {
            k();
            return;
        }
        if (com.baidu.mobads.sdk.internal.h.a == null) {
            this.h.a(a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
            return;
        }
        this.h.a(a, "start load apk");
        try {
            com.baidu.mobads.sdk.internal.h.a.a(new com.baidu.mobads.sdk.internal.ac(this));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void i() {
        java.lang.Runnable runnable = this.f;
        if (runnable != null) {
            this.e.removeCallbacks(runnable);
        }
        this.f = null;
    }

    private void j() {
        java.lang.Runnable runnable = this.f;
        if (runnable != null) {
            this.e.postDelayed(runnable, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.j.set(false);
        com.baidu.mobads.sdk.internal.bm.a(this.g);
        i();
        com.baidu.mobads.sdk.internal.s.a().a(1);
        com.baidu.mobads.sdk.internal.cn.a(this.g).b();
        com.baidu.mobads.sdk.internal.cn.a(this.g).a();
    }

    public void a(android.content.Context context, com.baidu.mobads.sdk.internal.aa.a aVar) {
        if (context == null) {
            this.h.c(a, "init Context is null,error");
            return;
        }
        this.g = context.getApplicationContext();
        com.baidu.mobads.sdk.internal.s.a().a(aVar);
        if (this.b != null) {
            k();
        } else {
            if (this.j.get()) {
                return;
            }
            f();
        }
    }

    public android.content.Context b() {
        return this.g;
    }

    public com.baidu.mobads.sdk.api.IXAdContainerFactory c() {
        if (this.g == null) {
            return null;
        }
        if (this.b == null && !this.j.get()) {
            f();
        }
        return this.b;
    }

    public java.lang.String d() {
        if (this.b == null) {
            return "";
        }
        return "_" + this.b.getRemoteVersion();
    }

    public boolean e() {
        return this.k;
    }
}
