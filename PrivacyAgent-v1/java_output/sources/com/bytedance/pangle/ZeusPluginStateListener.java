package com.bytedance.pangle;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public abstract class ZeusPluginStateListener {
    public static final int EVENT_DOWNLOAD_FAILED = 4;
    public static final int EVENT_DOWNLOAD_PROGRESS = 2;
    public static final int EVENT_DOWNLOAD_START = 1;
    public static final int EVENT_DOWNLOAD_SUCCESS = 3;
    public static final int EVENT_INSTALL_FAILED = 7;
    public static final int EVENT_INSTALL_START = 5;
    public static final int EVENT_INSTALL_SUCCESS = 6;
    public static final int EVENT_LOAD_FAILED = 10;
    public static final int EVENT_LOAD_START = 8;
    public static final int EVENT_LOAD_SUCCESS = 9;
    public static final int EVENT_REQUEST_FINISH = 0;
    private static final android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.bytedance.pangle.ZeusPluginStateListener$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ int b;
        final /* synthetic */ java.lang.Object[] c;

        public AnonymousClass1(java.lang.String str, int i, java.lang.Object[] objArr) {
            this.a = str;
            this.b = i;
            this.c = objArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.util.List<com.bytedance.pangle.ZeusPluginStateListener> list = com.bytedance.pangle.i.a().b;
            if (list == null || list.size() <= 0) {
                return;
            }
            java.util.Iterator<com.bytedance.pangle.ZeusPluginStateListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onPluginStateChange(android.text.TextUtils.isEmpty(this.a) ? com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN : this.a, this.b, this.c);
            }
        }
    }

    public static void postStateChange(@androidx.annotation.Nullable java.lang.String str, int i, java.lang.Object... objArr) {
        mHandler.post(new com.bytedance.pangle.ZeusPluginStateListener.AnonymousClass1(str, i, objArr));
        java.util.List<com.bytedance.pangle.ZeusPluginStateListener> list = com.bytedance.pangle.i.a().b;
        if (list == null || list.size() <= 0) {
            return;
        }
        java.util.Iterator<com.bytedance.pangle.ZeusPluginStateListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onStateChangeOnCurThread(android.text.TextUtils.isEmpty(str) ? com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN : str, i, objArr);
        }
    }

    @java.lang.Deprecated
    public void onPluginStateChange(java.lang.String str, int i, java.lang.Object... objArr) {
    }

    public void onStateChangeOnCurThread(java.lang.String str, int i, java.lang.Object... objArr) {
    }
}
