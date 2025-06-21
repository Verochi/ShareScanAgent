package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class cq1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ kotlin.jvm.functions.Function1 n;

    public /* synthetic */ cq1(kotlin.jvm.functions.Function1 function1) {
        this.n = function1;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.credit.util.NonNullObserverKt.a(this.n, obj);
    }
}
