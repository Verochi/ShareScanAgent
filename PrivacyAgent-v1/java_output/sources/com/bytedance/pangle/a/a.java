package com.bytedance.pangle.a;

/* loaded from: classes12.dex */
public final class a {
    final java.util.concurrent.CountDownLatch a;
    java.lang.Throwable b;

    /* renamed from: com.bytedance.pangle.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.bytedance.pangle.a.a.InterfaceC0264a a;

        public AnonymousClass1(com.bytedance.pangle.a.a.InterfaceC0264a interfaceC0264a) {
            this.a = interfaceC0264a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.a.a();
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.a.a.this.b = th;
            }
            com.bytedance.pangle.a.a.this.a.countDown();
        }
    }

    /* renamed from: com.bytedance.pangle.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0264a {
        void a();
    }

    private a(com.bytedance.pangle.a.a.InterfaceC0264a[] interfaceC0264aArr) {
        this.a = new java.util.concurrent.CountDownLatch(interfaceC0264aArr.length);
        for (com.bytedance.pangle.a.a.InterfaceC0264a interfaceC0264a : interfaceC0264aArr) {
            com.bytedance.pangle.d.e.a(new com.bytedance.pangle.a.a.AnonymousClass1(interfaceC0264a));
        }
    }

    public static void a(com.bytedance.pangle.a.a.InterfaceC0264a... interfaceC0264aArr) {
        com.bytedance.pangle.a.a aVar = new com.bytedance.pangle.a.a(interfaceC0264aArr);
        try {
            aVar.a.await();
            java.lang.Throwable th = aVar.b;
            if (th != null) {
                throw th;
            }
        } catch (java.lang.InterruptedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }
}
