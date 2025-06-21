package cn.shuzilm.core;

/* loaded from: classes.dex */
class j implements java.lang.Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            java.lang.System.loadLibrary(com.umeng.analytics.pro.f.ac);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
