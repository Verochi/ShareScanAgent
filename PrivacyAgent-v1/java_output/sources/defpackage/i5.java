package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class i5 implements java.lang.Runnable {
    public final /* synthetic */ kotlin.jvm.functions.Function1 n;
    public final /* synthetic */ kotlin.jvm.functions.Function1 t;

    public /* synthetic */ i5(kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function12) {
        this.n = function1;
        this.t = function12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.util.AdMJUtils.a(this.n, this.t);
    }
}
