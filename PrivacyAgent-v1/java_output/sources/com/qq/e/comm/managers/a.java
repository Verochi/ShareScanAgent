package com.qq.e.comm.managers;

/* loaded from: classes19.dex */
public class a implements com.qq.e.comm.managers.IGDTAdManager {
    public static final java.util.concurrent.ExecutorService g = java.util.concurrent.Executors.newSingleThreadExecutor();
    private volatile boolean a;
    private volatile boolean b;
    private volatile android.content.Context c;
    private volatile com.qq.e.comm.managers.plugin.PM d;
    private volatile com.qq.e.comm.managers.devtool.DevTools e;
    private volatile java.lang.String f;

    /* renamed from: com.qq.e.comm.managers.a$a, reason: collision with other inner class name */
    public class RunnableC0435a implements java.lang.Runnable {
        final /* synthetic */ com.qq.e.comm.managers.GDTAdSdk.OnStartListener a;

        public RunnableC0435a(com.qq.e.comm.managers.GDTAdSdk.OnStartListener onStartListener) {
            this.a = onStartListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.qq.e.comm.pi.POFactory pOFactory = com.qq.e.comm.managers.a.this.d.getPOFactory(false, false);
                if (pOFactory != null) {
                    pOFactory.start(com.qq.e.comm.managers.a.this.d.getStartCaller(1));
                    com.qq.e.comm.managers.GDTAdSdk.OnStartListener onStartListener = this.a;
                    if (onStartListener != null) {
                        onStartListener.onStartSuccess();
                    }
                } else {
                    com.qq.e.comm.managers.GDTAdSdk.OnStartListener onStartListener2 = this.a;
                    if (onStartListener2 != null) {
                        onStartListener2.onStartFailed(new java.lang.Exception("GDTAdSdk start异常"));
                    }
                }
            } catch (com.qq.e.comm.managers.plugin.e e) {
                com.qq.e.comm.util.GDTLogger.e(e.getMessage(), e);
                com.qq.e.comm.managers.GDTAdSdk.OnStartListener onStartListener3 = this.a;
                if (onStartListener3 != null) {
                    onStartListener3.onStartFailed(e);
                }
            }
        }
    }

    public static final class b {
        private static com.qq.e.comm.managers.a a = new com.qq.e.comm.managers.a(null);
    }

    private a() {
        this.a = false;
        this.b = false;
    }

    public /* synthetic */ a(com.qq.e.comm.managers.a.RunnableC0435a runnableC0435a) {
        this();
    }

    public static com.qq.e.comm.managers.a b() {
        return com.qq.e.comm.managers.a.b.a;
    }

    public java.lang.String a() {
        return this.f;
    }

    public synchronized void a(com.qq.e.comm.managers.GDTAdSdk.OnStartListener onStartListener) {
        if (this.a) {
            g.submit(new com.qq.e.comm.managers.a.RunnableC0435a(onStartListener));
            return;
        }
        com.qq.e.comm.util.GDTLogger.e("在调用start方法前请先调用initWithoutStart方法");
        if (onStartListener != null) {
            onStartListener.onStartFailed(new java.lang.Exception("在调用start方法前请先调用initWithoutStart方法"));
        }
    }

    public synchronized boolean a(android.content.Context context, java.lang.String str, boolean z) {
        if (this.a) {
            return true;
        }
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            com.qq.e.comm.util.GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
            return false;
        }
        try {
            this.f = str;
            this.c = context.getApplicationContext();
            this.d = new com.qq.e.comm.managers.plugin.PM(this.c, null);
            g.submit(new com.qq.e.comm.managers.b(this, z));
            this.a = true;
            return true;
        } catch (java.lang.Throwable th) {
            com.qq.e.comm.util.GDTLogger.e("GDTADManager初始化错误", th);
            return false;
        }
    }

    public com.qq.e.comm.managers.plugin.PM c() {
        return this.d;
    }

    public boolean d() {
        if (this.a) {
            return true;
        }
        com.qq.e.comm.util.GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.initWithoutStart() 初始化");
        return false;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public java.lang.String getBuyerId(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (!d()) {
            return "";
        }
        try {
            return this.d.getPOFactory().getBuyerId(map);
        } catch (java.lang.Exception e) {
            com.qq.e.comm.util.GDTLogger.e("SDK 初始化异常", e);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public com.qq.e.comm.managers.devtool.DevTools getDevTools() {
        if (this.e == null) {
            this.e = new com.qq.e.comm.managers.devtool.DevTools();
        }
        return this.e;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public java.lang.String getSDKInfo(java.lang.String str) {
        if (!d()) {
            return "";
        }
        try {
            return this.d.getPOFactory().getSDKInfo(str);
        } catch (java.lang.Exception e) {
            com.qq.e.comm.util.GDTLogger.e("SDK 初始化异常", e);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(com.qq.e.ads.dfa.GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (!this.b) {
            return 0;
        }
        try {
            return this.d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
        } catch (java.lang.Exception e) {
            com.qq.e.comm.util.GDTLogger.e("SDK 初始化异常", e);
            return 0;
        }
    }
}
