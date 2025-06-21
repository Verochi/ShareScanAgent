package com.tanx.exposer.tanxc_do.tanxc_new;

/* loaded from: classes19.dex */
public final class tanxc_do {
    public static final java.util.HashMap<java.lang.String, android.os.HandlerThread> a = new java.util.HashMap<>();

    public static android.os.HandlerThread a(java.lang.String str) {
        android.os.HandlerThread handlerThread;
        java.util.HashMap<java.lang.String, android.os.HandlerThread> hashMap = a;
        synchronized (hashMap) {
            handlerThread = hashMap.get(str);
            if (handlerThread != null && handlerThread.getLooper() == null) {
                hashMap.remove(str);
                handlerThread = null;
            }
            if (handlerThread == null) {
                handlerThread = new android.os.HandlerThread(str);
                handlerThread.start();
                hashMap.put(str, handlerThread);
            }
        }
        return handlerThread;
    }

    public static android.os.Looper tanxc_do() {
        return a("tanx_exposer_sdk").getLooper();
    }
}
