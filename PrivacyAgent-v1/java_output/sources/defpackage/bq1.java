package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class bq1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ kotlin.jvm.functions.Function1 n;

    public /* synthetic */ bq1(kotlin.jvm.functions.Function1 function1) {
        this.n = function1;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.diamon.utils.NonNullObserverKt.a(this.n, obj);
    }
}
