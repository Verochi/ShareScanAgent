package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class zg2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.ShortTimeActivity n;

    public /* synthetic */ zg2(com.moji.shorttime.ui.ShortTimeActivity shortTimeActivity) {
        this.n = shortTimeActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.ShortTimeActivity.d(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
