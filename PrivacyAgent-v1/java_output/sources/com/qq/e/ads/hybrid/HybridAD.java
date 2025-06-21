package com.qq.e.ads.hybrid;

/* loaded from: classes19.dex */
public class HybridAD extends com.qq.e.ads.AbstractAD<com.qq.e.comm.pi.HADI> implements com.qq.e.comm.pi.HADI {
    private com.qq.e.ads.hybrid.HybridADListener h;
    private java.util.concurrent.CountDownLatch i = new java.util.concurrent.CountDownLatch(1);
    private com.qq.e.ads.hybrid.HybridADSetting j;

    /* renamed from: com.qq.e.ads.hybrid.HybridAD$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.qq.e.ads.hybrid.HybridAD.this.i.await(30L, java.util.concurrent.TimeUnit.SECONDS);
                if (!com.qq.e.ads.hybrid.HybridAD.this.b() || ((com.qq.e.ads.AbstractAD) com.qq.e.ads.hybrid.HybridAD.this).a == null) {
                    com.qq.e.comm.util.GDTLogger.e("初始化错误：广告实例未被初始化");
                    com.qq.e.ads.hybrid.HybridAD.this.a(2001);
                } else {
                    ((com.qq.e.comm.pi.HADI) ((com.qq.e.ads.AbstractAD) com.qq.e.ads.hybrid.HybridAD.this).a).loadUrl(this.a);
                }
            } catch (java.lang.InterruptedException unused) {
                com.qq.e.comm.util.GDTLogger.e("初始化错误：广告实例未被初始化");
                com.qq.e.ads.hybrid.HybridAD.this.a(2001);
            }
        }
    }

    public HybridAD(android.content.Context context, com.qq.e.ads.hybrid.HybridADSetting hybridADSetting, com.qq.e.ads.hybrid.HybridADListener hybridADListener) {
        this.j = hybridADSetting;
        this.h = hybridADListener;
        a(context, "NO_POS_ID");
    }

    public com.qq.e.comm.pi.HADI a(com.qq.e.comm.pi.POFactory pOFactory) {
        return pOFactory.getHybridAD(this.j, this.h);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ com.qq.e.comm.pi.HADI a(android.content.Context context, com.qq.e.comm.pi.POFactory pOFactory, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return a(pOFactory);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(com.qq.e.comm.pi.HADI hadi) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        com.qq.e.ads.hybrid.HybridADListener hybridADListener = this.h;
        if (hybridADListener != null) {
            hybridADListener.onError(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(i));
        }
        this.i.countDown();
    }

    public void c() {
        this.i.countDown();
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(java.lang.String str) {
        if (a()) {
            if (!b()) {
                new java.lang.Thread(new com.qq.e.ads.hybrid.HybridAD.AnonymousClass1(str)).start();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((com.qq.e.comm.pi.HADI) t).loadUrl(str);
            } else {
                a("loadUrl");
            }
        }
    }
}
