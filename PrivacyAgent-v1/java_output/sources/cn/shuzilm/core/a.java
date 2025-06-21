package cn.shuzilm.core;

/* loaded from: classes.dex */
class a implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ java.lang.String c;
    final /* synthetic */ int d;
    final /* synthetic */ cn.shuzilm.core.Listener e;
    final /* synthetic */ cn.shuzilm.core.DUHelper f;

    public a(cn.shuzilm.core.DUHelper dUHelper, android.content.Context context, java.lang.String str, java.lang.String str2, int i, cn.shuzilm.core.Listener listener) {
        this.f = dUHelper;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        cn.shuzilm.core.DUHelper dUHelper;
        java.lang.String a;
        try {
            dUHelper = cn.shuzilm.core.DUHelper.d;
            a = dUHelper.a(this.a, this.b, this.c, this.d);
            if (this.e != null) {
                if (a == null) {
                    a = this.f.h(this.a);
                }
                this.e.handler(a);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
