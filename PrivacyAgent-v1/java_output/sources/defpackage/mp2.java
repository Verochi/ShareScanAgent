package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class mp2 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ java.io.PrintStream n;

    public /* synthetic */ mp2(java.io.PrintStream printStream) {
        this.n = printStream;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        this.n.println((java.lang.Long) obj);
    }
}
