package cn.shuzilm.core;

/* loaded from: classes.dex */
class p implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ java.lang.String c;
    final /* synthetic */ java.lang.String d;
    final /* synthetic */ cn.shuzilm.core.Listener e;
    final /* synthetic */ cn.shuzilm.core.DUHelper f;

    public p(cn.shuzilm.core.DUHelper dUHelper, android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, cn.shuzilm.core.Listener listener) {
        this.f = dUHelper;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        cn.shuzilm.core.DUHelper dUHelper;
        java.lang.String b;
        try {
            dUHelper = cn.shuzilm.core.DUHelper.d;
            b = dUHelper.b(this.a, this.b, this.c, this.d);
            cn.shuzilm.core.Listener listener = this.e;
            if (listener != null) {
                listener.handler(b);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
