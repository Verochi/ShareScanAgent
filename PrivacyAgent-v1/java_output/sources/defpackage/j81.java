package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class j81 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.MainActivity n;

    public /* synthetic */ j81(com.moji.mjweather.MainActivity mainActivity) {
        this.n = mainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.MainActivity.b(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
