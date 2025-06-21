package cn.shuzilm.core;

/* loaded from: classes.dex */
class r implements cn.shuzilm.core.Listener {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ int b;
    final /* synthetic */ cn.shuzilm.core.Listener c;

    public r(android.content.Context context, int i, cn.shuzilm.core.Listener listener) {
        this.a = context;
        this.b = i;
        this.c = listener;
    }

    @Override // cn.shuzilm.core.Listener
    public void handler(java.lang.String str) {
        cn.shuzilm.core.DUHelper dUHelper;
        java.lang.String b;
        dUHelper = cn.shuzilm.core.DUHelper.d;
        b = dUHelper.b(this.a, this.b);
        cn.shuzilm.core.Listener listener = this.c;
        if (listener != null) {
            listener.handler(b);
        }
    }
}
