package com.alipay.apmobilesecuritysdk.f;

/* loaded from: classes.dex */
public final class c implements java.lang.Runnable {
    public final /* synthetic */ com.alipay.apmobilesecuritysdk.f.b a;

    public c(com.alipay.apmobilesecuritysdk.f.b bVar) {
        this.a = bVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x000e */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        java.util.LinkedList linkedList;
        java.util.LinkedList linkedList2;
        java.util.LinkedList linkedList3;
        try {
            android.os.Process.setThreadPriority(0);
            while (!linkedList.isEmpty()) {
                linkedList2 = this.a.c;
                java.lang.Runnable runnable = (java.lang.Runnable) linkedList2.get(0);
                linkedList3 = this.a.c;
                linkedList3.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (java.lang.Exception unused) {
        } catch (java.lang.Throwable th) {
            com.alipay.apmobilesecuritysdk.f.b.b(this.a);
            throw th;
        }
        com.alipay.apmobilesecuritysdk.f.b.b(this.a);
    }
}
