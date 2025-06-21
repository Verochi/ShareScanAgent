package com.umeng.commonsdk.framework;

/* loaded from: classes19.dex */
public class a implements com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback {
    private static android.os.HandlerThread a = null;
    private static android.os.Handler b = null;
    private static android.os.Handler c = null;
    private static final int d = 200;
    private static final int e = 273;
    private static final int f = 274;
    private static final int g = 512;
    private static final int h = 769;
    private static com.umeng.commonsdk.framework.a.FileObserverC0519a i = null;
    private static android.net.ConnectivityManager j = null;
    private static android.content.IntentFilter k = null;
    private static volatile boolean l = false;
    private static java.util.ArrayList<com.umeng.commonsdk.framework.UMSenderStateNotify> m = null;
    private static final java.lang.String p = "report_policy";
    private static final java.lang.String q = "report_interval";

    /* renamed from: s, reason: collision with root package name */
    private static final int f456s = 15;
    private static final int t = 3;
    private static final int u = 90;
    private static android.content.BroadcastReceiver x;
    private static java.lang.Object n = new java.lang.Object();
    private static java.util.concurrent.locks.ReentrantLock o = new java.util.concurrent.locks.ReentrantLock();
    private static boolean r = false;
    private static int v = 15;
    private static java.lang.Object w = new java.lang.Object();

    /* renamed from: com.umeng.commonsdk.framework.a$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.net.ConnectivityManager.NetworkCallback {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            android.content.Context context = this.a;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, com.umeng.commonsdk.internal.b.a(context).a(), null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(android.net.Network network, android.net.NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(android.net.Network network) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> onLost");
            android.content.Context context = this.a;
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, com.umeng.commonsdk.internal.b.a(context).a(), null, 2000L);
        }
    }

    /* renamed from: com.umeng.commonsdk.framework.a$2, reason: invalid class name */
    public static class AnonymousClass2 extends android.content.BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (intent.getAction().equals(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, com.umeng.commonsdk.internal.b.a(context).a(), null);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.framework.a$3, reason: invalid class name */
    public class AnonymousClass3 extends android.os.Handler {
        public AnonymousClass3(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 273) {
                com.umeng.commonsdk.statistics.common.ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                try {
                    com.umeng.commonsdk.framework.a.o.tryLock(1L, java.util.concurrent.TimeUnit.SECONDS);
                    try {
                        com.umeng.commonsdk.framework.a.n();
                    } catch (java.lang.Throwable unused) {
                    }
                    com.umeng.commonsdk.framework.a.o.unlock();
                    return;
                } catch (java.lang.Throwable unused2) {
                    return;
                }
            }
            if (i == com.umeng.commonsdk.framework.a.f) {
                com.umeng.commonsdk.framework.a.l();
            } else {
                if (i != 512) {
                    return;
                }
                com.umeng.commonsdk.framework.a.m();
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.framework.a$a, reason: collision with other inner class name */
    public static class FileObserverC0519a extends android.os.FileObserver {
        public FileObserverC0519a(java.lang.String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, java.lang.String str) {
            if ((i & 8) != 8) {
                return;
            }
            com.umeng.commonsdk.statistics.common.ULog.d("--->>> envelope file created >>> " + str);
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            com.umeng.commonsdk.framework.a.c(273);
        }
    }

    static {
        android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext();
        if (appContext != null) {
            j = (android.net.ConnectivityManager) appContext.getSystemService("connectivity");
        }
        x = new com.umeng.commonsdk.framework.a.AnonymousClass2();
    }

    public a(android.content.Context context, android.os.Handler handler) {
        if (j == null) {
            android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext();
            if (j != null) {
                j = (android.net.ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        c = handler;
        try {
            if (a == null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("NetWorkSender");
                a = handlerThread;
                handlerThread.start();
                if (i == null) {
                    com.umeng.commonsdk.framework.a.FileObserverC0519a fileObserverC0519a = new com.umeng.commonsdk.framework.a.FileObserverC0519a(com.umeng.commonsdk.framework.UMFrUtils.getEnvelopeDirPath(context));
                    i = fileObserverC0519a;
                    fileObserverC0519a.startWatching();
                    com.umeng.commonsdk.statistics.common.ULog.d("--->>> FileMonitor has already started!");
                }
                j();
                if (b == null) {
                    b = new com.umeng.commonsdk.framework.a.AnonymousClass3(a.getLooper());
                }
                com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(context).registImprintCallback(p, this);
                com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(context).registImprintCallback(q, this);
            }
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
    }

    private static void a(int i2, int i3) {
        android.os.Handler handler;
        if (!l || (handler = b) == null) {
            return;
        }
        handler.removeMessages(i2);
        android.os.Message obtainMessage = b.obtainMessage();
        obtainMessage.what = i2;
        b.sendMessageDelayed(obtainMessage, i3);
    }

    private static void a(int i2, long j2) {
        android.os.Handler handler;
        if (!l || (handler = b) == null) {
            return;
        }
        android.os.Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j2);
        b.sendMessageDelayed(obtainMessage, j2);
    }

    public static void a(android.content.Context context) {
        if (j != null || context == null) {
            return;
        }
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        j = connectivityManager;
        if (connectivityManager != null) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
            b(context);
        }
    }

    public static void a(com.umeng.commonsdk.framework.UMSenderStateNotify uMSenderStateNotify) {
        synchronized (n) {
            try {
                if (m == null) {
                    m = new java.util.ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i2 = 0; i2 < m.size(); i2++) {
                        if (uMSenderStateNotify == m.get(i2)) {
                            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    m.add(uMSenderStateNotify);
                }
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(com.umeng.commonsdk.framework.UMModuleRegister.getAppContext(), th);
            }
        }
    }

    public static void a(boolean z) {
        int size;
        l = z;
        if (!z) {
            com.umeng.commonsdk.statistics.common.ULog.i("--->>> network disconnected.");
            l = false;
            return;
        }
        synchronized (n) {
            java.util.ArrayList<com.umeng.commonsdk.framework.UMSenderStateNotify> arrayList = m;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    m.get(i2).onConnectionAvailable();
                }
            }
        }
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
        d();
    }

    public static boolean a() {
        boolean z;
        synchronized (w) {
            z = r;
        }
        return z;
    }

    public static int b() {
        int i2;
        synchronized (w) {
            i2 = v;
        }
        return i2;
    }

    private static void b(int i2) {
        android.os.Handler handler;
        if (!l || (handler = b) == null || handler.hasMessages(i2)) {
            return;
        }
        android.os.Message obtainMessage = b.obtainMessage();
        obtainMessage.what = i2;
        b.sendMessage(obtainMessage);
    }

    @android.annotation.SuppressLint({"NewApi", "MissingPermission"})
    public static void b(android.content.Context context) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> registerNetReceiver: context is null, registerNetReceiver failed.");
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 33) {
            if (!com.umeng.commonsdk.statistics.common.DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
                return;
            }
            android.net.NetworkRequest build = new android.net.NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
            if (j != null) {
                android.content.Context applicationContext = context.getApplicationContext();
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerNetworkCallback");
                j.registerNetworkCallback(build, new com.umeng.commonsdk.framework.a.AnonymousClass1(applicationContext));
                return;
            }
            return;
        }
        if (!com.umeng.commonsdk.statistics.common.DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
            return;
        }
        if (j == null || k != null) {
            return;
        }
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        k = intentFilter;
        intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        if (x != null) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerReceiver");
            context.registerReceiver(x, k);
        }
    }

    public static void c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i2) {
        android.os.Handler handler;
        if (!l || (handler = b) == null) {
            return;
        }
        android.os.Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        b.sendMessage(obtainMessage);
    }

    public static void d() {
        if (o.tryLock()) {
            try {
                b(273);
            } finally {
                o.unlock();
            }
        }
    }

    public static void e() {
        a(f, 3000);
    }

    private void j() {
        synchronized (w) {
            if (com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.umeng.commonsdk.framework.UMModuleRegister.getAppContext(), p, ""))) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                r = true;
                v = 15;
                int intValue = java.lang.Integer.valueOf(com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.umeng.commonsdk.framework.UMModuleRegister.getAppContext(), q, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_WPA_STATE)).intValue();
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    v = intValue * 1000;
                }
                v = 15;
            } else {
                r = false;
            }
        }
    }

    private static void k() {
        if (a != null) {
            a = null;
        }
        if (b != null) {
            b = null;
        }
        if (c != null) {
            c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        int size;
        synchronized (n) {
            java.util.ArrayList<com.umeng.commonsdk.framework.UMSenderStateNotify> arrayList = m;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    m.get(i2).onSenderIdle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        com.umeng.commonsdk.statistics.common.ULog.d("--->>> handleProcessNext: Enter...");
        if (l) {
            android.content.Context appContext = com.umeng.commonsdk.framework.UMModuleRegister.getAppContext();
            try {
                if (com.umeng.commonsdk.framework.UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    com.umeng.commonsdk.statistics.common.ULog.d("--->>> The envelope file exists.");
                    if (com.umeng.commonsdk.framework.UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        com.umeng.commonsdk.statistics.common.ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        com.umeng.commonsdk.framework.UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    java.io.File envelopeFile = com.umeng.commonsdk.framework.UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        java.lang.String path = envelopeFile.getPath();
                        com.umeng.commonsdk.statistics.common.ULog.d("--->>> Ready to send envelope file [" + path + "].");
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                        if (!new com.umeng.commonsdk.statistics.c(appContext).a(envelopeFile)) {
                            com.umeng.commonsdk.statistics.common.ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        com.umeng.commonsdk.statistics.common.ULog.d("--->>> Send envelope file success, delete it.");
                        if (!com.umeng.commonsdk.framework.UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                            com.umeng.commonsdk.statistics.common.ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                            com.umeng.commonsdk.framework.UMFrUtils.removeEnvelopeFile(envelopeFile);
                        }
                        c(273);
                        return;
                    }
                }
                e();
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(java.lang.String str, java.lang.String str2) {
        synchronized (w) {
            if (p.equals(str)) {
                if (com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(str2)) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    r = true;
                } else {
                    r = false;
                }
            }
            if (q.equals(str)) {
                int intValue = java.lang.Integer.valueOf(str2).intValue();
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    v = intValue * 1000;
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + v);
                }
                v = 15000;
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + v);
            }
        }
    }
}
