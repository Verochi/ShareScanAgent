package com.qq.e.ads.dfa;

/* loaded from: classes19.dex */
public class GDTApkManager {
    private com.qq.e.comm.pi.DFA a;
    private boolean b = false;
    private boolean c = false;
    private java.util.concurrent.atomic.AtomicInteger d = new java.util.concurrent.atomic.AtomicInteger(0);
    private android.content.Context e;

    /* renamed from: com.qq.e.ads.dfa.GDTApkManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.qq.e.ads.dfa.IGDTApkListener a;

        /* renamed from: com.qq.e.ads.dfa.GDTApkManager$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04331 implements java.lang.Runnable {
            final /* synthetic */ com.qq.e.comm.pi.POFactory a;

            public RunnableC04331(com.qq.e.comm.pi.POFactory pOFactory) {
                this.a = pOFactory;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (this.a != null) {
                        com.qq.e.ads.dfa.GDTApkManager.this.a = com.qq.e.comm.managers.a.b().c().getPOFactory().getGDTApkDelegate(com.qq.e.ads.dfa.GDTApkManager.AnonymousClass1.this.a);
                        com.qq.e.ads.dfa.GDTApkManager.this.c = true;
                        while (com.qq.e.ads.dfa.GDTApkManager.this.d.getAndDecrement() > 0) {
                            com.qq.e.ads.dfa.GDTApkManager.this.loadGDTApk();
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }

        public AnonymousClass1(com.qq.e.ads.dfa.IGDTApkListener iGDTApkListener) {
            this.a = iGDTApkListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.qq.e.ads.dfa.GDTApkManager.AnonymousClass1.RunnableC04331(com.qq.e.comm.managers.a.b().c().getPOFactory()));
            } catch (java.lang.Throwable th) {
                com.qq.e.comm.util.GDTLogger.e("初始化错误：初始化时发生异常", th);
            }
        }
    }

    public GDTApkManager(android.content.Context context, com.qq.e.ads.dfa.IGDTApkListener iGDTApkListener) {
        if (com.qq.e.comm.managers.a.b().d()) {
            a(context, com.qq.e.comm.managers.a.b().a(), iGDTApkListener);
        }
    }

    private void a(android.content.Context context, java.lang.String str, com.qq.e.ads.dfa.IGDTApkListener iGDTApkListener) {
        if (android.text.TextUtils.isEmpty(str) || context == null) {
            com.qq.e.comm.util.GDTLogger.e("初始化错误：GDTApkManager 构造失败，Context和appID不能为空");
        } else {
            if (!com.qq.e.comm.a.a(context)) {
                com.qq.e.comm.util.GDTLogger.e("初始化错误：必需的 Activity/Service/Permission 没有在AndroidManifest.xml中声明");
                return;
            }
            this.b = true;
            this.e = context;
            com.qq.e.comm.managers.a.g.execute(new com.qq.e.ads.dfa.GDTApkManager.AnonymousClass1(iGDTApkListener));
        }
    }

    public final void loadGDTApk() {
        if (this.b) {
            if (!this.c) {
                this.d.incrementAndGet();
                return;
            }
            com.qq.e.comm.pi.DFA dfa = this.a;
            if (dfa != null) {
                dfa.loadGDTApk();
            } else {
                com.qq.e.comm.util.GDTLogger.e("调用loadGDTApk失败，实例未被正常初始化");
            }
        }
    }

    public final void startInstall(com.qq.e.ads.dfa.GDTApk gDTApk) {
        com.qq.e.comm.pi.DFA dfa = this.a;
        if (dfa != null) {
            dfa.startInstall(this.e, gDTApk);
        }
    }
}
