package com.vivo.push;

/* loaded from: classes19.dex */
public abstract class l implements java.lang.Runnable {
    protected android.content.Context a;
    private int b;
    private com.vivo.push.o c;

    public l(com.vivo.push.o oVar) {
        this.b = -1;
        this.c = oVar;
        int b = oVar.b();
        this.b = b;
        if (b < 0) {
            throw new java.lang.IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.a = com.vivo.push.e.a().h();
    }

    public final int a() {
        return this.b;
    }

    public abstract void a(com.vivo.push.o oVar);

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context = this.a;
        if (context != null && !(this.c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.p.a(context, "[执行指令]" + this.c);
        }
        a(this.c);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        com.vivo.push.o oVar = this.c;
        sb.append(oVar == null ? "[null]" : oVar.toString());
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }
}
