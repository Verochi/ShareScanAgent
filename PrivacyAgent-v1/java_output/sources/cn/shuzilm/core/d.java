package cn.shuzilm.core;

/* loaded from: classes.dex */
class d implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ boolean b;
    final /* synthetic */ int c;
    final /* synthetic */ cn.shuzilm.core.Listener d;

    public d(android.content.Context context, boolean z, int i, cn.shuzilm.core.Listener listener) {
        this.a = context;
        this.b = z;
        this.c = i;
        this.d = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.concurrent.locks.Lock lock;
        cn.shuzilm.core.AIClient aIClient;
        cn.shuzilm.core.AIClient aIClient2;
        java.lang.String zZVTFJRA;
        cn.shuzilm.core.AIClient aIClient3;
        cn.shuzilm.core.AIClient aIClient4;
        cn.shuzilm.core.AIClient aIClient5;
        cn.shuzilm.core.AIClient unused;
        cn.shuzilm.core.AIClient unused2;
        try {
            lock = cn.shuzilm.core.DUHelper.f;
            lock.lock();
            aIClient = cn.shuzilm.core.DUHelper.c;
            if (aIClient == null) {
                cn.shuzilm.core.AIClient unused3 = cn.shuzilm.core.DUHelper.c = new cn.shuzilm.core.AIClient(this.a);
                if (this.b) {
                    aIClient5 = cn.shuzilm.core.DUHelper.c;
                    aIClient5.asynAI(2);
                }
            }
            unused = cn.shuzilm.core.DUHelper.c;
            if (!cn.shuzilm.core.AIClient.isf && this.b) {
                aIClient4 = cn.shuzilm.core.DUHelper.c;
                aIClient4.asynAI(2);
            }
            unused2 = cn.shuzilm.core.DUHelper.c;
        } finally {
            try {
            } finally {
            }
        }
        if (!cn.shuzilm.core.AIClient.isf) {
            if (!this.b) {
            }
            this.d.handler("NA");
        }
        java.lang.String upperCase = android.os.Build.MANUFACTURER.toUpperCase();
        if (this.c == 1) {
            upperCase = "HUAWEI";
        }
        aIClient2 = cn.shuzilm.core.DUHelper.c;
        zZVTFJRA = cn.shuzilm.core.DUHelper.zZVTFJRA(this.a, aIClient2.cm(upperCase));
        if (zZVTFJRA == null) {
            zZVTFJRA = "NA";
        }
        aIClient3 = cn.shuzilm.core.DUHelper.c;
        if (aIClient3.isOaidCollectAllowed(3)) {
            this.d.handler(zZVTFJRA);
        } else {
            this.d.handler("NA");
        }
    }
}
