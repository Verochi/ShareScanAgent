package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class kq0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.function.IRadarMapChildFunction n;

    public /* synthetic */ kq0(com.moji.shorttime.ui.function.IRadarMapChildFunction iRadarMapChildFunction) {
        this.n = iRadarMapChildFunction;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.function.IRadarMapChildFunction.b(this.n, (java.lang.Boolean) obj);
    }
}
