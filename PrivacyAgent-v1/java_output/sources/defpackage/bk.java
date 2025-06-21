package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class bk implements java.lang.Runnable {
    public final /* synthetic */ java.util.List n;
    public final /* synthetic */ java.util.List t;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef u;
    public final /* synthetic */ java.lang.String v;

    public /* synthetic */ bk(java.util.List list, java.util.List list2, kotlin.jvm.internal.Ref.ObjectRef objectRef, java.lang.String str) {
        this.n = list;
        this.t = list2;
        this.u = objectRef;
        this.v = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.callupother.CallUpOtherManager.a(this.n, this.t, this.u, this.v);
    }
}
