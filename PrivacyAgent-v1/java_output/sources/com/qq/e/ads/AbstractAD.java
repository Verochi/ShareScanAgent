package com.qq.e.ads;

/* loaded from: classes19.dex */
public abstract class AbstractAD<T> {
    private static final java.util.concurrent.atomic.AtomicBoolean g = new java.util.concurrent.atomic.AtomicBoolean(true);
    protected T a;
    private volatile boolean e;
    private volatile boolean c = false;
    private volatile boolean d = false;
    private volatile long f = -1;
    private final android.os.Handler b = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.qq.e.ads.AbstractAD$1, reason: invalid class name */
    class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;

        /* renamed from: com.qq.e.ads.AbstractAD$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04321 implements java.lang.Runnable {
            final /* synthetic */ com.qq.e.comm.pi.POFactory a;

            public RunnableC04321(com.qq.e.comm.pi.POFactory pOFactory) {
                this.a = pOFactory;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.qq.e.comm.pi.POFactory pOFactory = this.a;
                    if (pOFactory != null) {
                        com.qq.e.ads.AbstractAD.AnonymousClass1 anonymousClass1 = com.qq.e.ads.AbstractAD.AnonymousClass1.this;
                        com.qq.e.ads.AbstractAD abstractAD = com.qq.e.ads.AbstractAD.this;
                        abstractAD.a = (T) abstractAD.a(anonymousClass1.a, pOFactory, anonymousClass1.b, anonymousClass1.c, anonymousClass1.d);
                        com.qq.e.ads.AbstractAD.this.c = true;
                        com.qq.e.ads.AbstractAD abstractAD2 = com.qq.e.ads.AbstractAD.this;
                        if (abstractAD2.a == null) {
                            abstractAD2.a(com.qq.e.comm.constants.ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                        } else {
                            com.qq.e.ads.AbstractAD.a(abstractAD2);
                            com.qq.e.ads.AbstractAD abstractAD3 = com.qq.e.ads.AbstractAD.this;
                            abstractAD3.a((com.qq.e.ads.AbstractAD) abstractAD3.a);
                        }
                    } else {
                        com.qq.e.ads.AbstractAD.this.c = true;
                        com.qq.e.ads.AbstractAD.this.a(com.qq.e.comm.constants.ErrorCode.PLUGIN_INIT_ERROR);
                    }
                } catch (java.lang.Throwable th) {
                    com.qq.e.comm.util.GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                    com.qq.e.ads.AbstractAD.this.c = true;
                    com.qq.e.ads.AbstractAD.this.a(2001);
                }
            }
        }

        public AnonymousClass1(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.qq.e.ads.AbstractAD.this.b.post(new com.qq.e.ads.AbstractAD.AnonymousClass1.RunnableC04321(com.qq.e.comm.managers.a.b().c().getPOFactory()));
            } catch (java.lang.Throwable th) {
                com.qq.e.comm.util.GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                com.qq.e.ads.AbstractAD.this.c = true;
                com.qq.e.ads.AbstractAD.this.a(com.qq.e.comm.constants.ErrorCode.PLUGIN_INIT_ERROR);
            }
        }
    }

    /* renamed from: com.qq.e.ads.AbstractAD$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int a;

        public AnonymousClass2(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.ads.AbstractAD.this.b(this.a);
        }
    }

    public static void a(com.qq.e.ads.AbstractAD abstractAD) {
        if (abstractAD.f > 0) {
            try {
                com.qq.e.comm.managers.setting.GlobalSetting.getSettings().putOpt("gdtwict", java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime() - abstractAD.f));
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private void b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.e = true;
        if (!com.qq.e.comm.managers.a.b().d()) {
            a(2003);
            return;
        }
        java.lang.String a = com.qq.e.comm.managers.a.b().a();
        if (com.qq.e.comm.a.a(context)) {
            this.d = true;
            com.qq.e.comm.managers.a.g.execute(new com.qq.e.ads.AbstractAD.AnonymousClass1(context, a, str, str2));
        } else {
            com.qq.e.comm.util.GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
            a(4002);
        }
    }

    public abstract T a(android.content.Context context, com.qq.e.comm.pi.POFactory pOFactory, java.lang.String str, java.lang.String str2, java.lang.String str3);

    public final void a(int i) {
        if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
            b(i);
        } else {
            this.b.post(new com.qq.e.ads.AbstractAD.AnonymousClass2(i));
        }
    }

    public final void a(android.content.Context context, java.lang.String str) {
        if (context != null && !android.text.TextUtils.isEmpty(str)) {
            b(context, str, "");
        } else {
            com.qq.e.comm.util.GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(2001);
        }
    }

    public final void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context != null && !android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            b(context, str, str2);
        } else {
            com.qq.e.comm.util.GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(2001);
        }
    }

    public abstract void a(T t);

    public final void a(java.lang.String str) {
        com.qq.e.comm.util.GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }

    public final boolean a() {
        return this.e && this.d;
    }

    public abstract void b(int i);

    public final boolean b() {
        if (!this.c && g.compareAndSet(true, false)) {
            this.f = android.os.SystemClock.elapsedRealtime();
        }
        return this.c;
    }
}
