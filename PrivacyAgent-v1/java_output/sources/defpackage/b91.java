package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class b91 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.diamon.view.MainDiamondPositionView n;

    public /* synthetic */ b91(com.moji.diamon.view.MainDiamondPositionView mainDiamondPositionView) {
        this.n = mainDiamondPositionView;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.diamon.view.MainDiamondPositionView.e(this.n, (com.moji.common.area.AreaInfo) obj);
    }
}
