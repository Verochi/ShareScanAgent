package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class r71 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.MainActivity n;

    public /* synthetic */ r71(com.moji.mjweather.MainActivity mainActivity) {
        this.n = mainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.MainActivity.w(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
