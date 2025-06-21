package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class x10 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.diamon.activity.DiamondPreviewActivity n;

    public /* synthetic */ x10(com.moji.diamon.activity.DiamondPreviewActivity diamondPreviewActivity) {
        this.n = diamondPreviewActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.diamon.activity.DiamondPreviewActivity.c(this.n, (com.moji.diamon.entity.DiamondPositionData) obj);
    }
}
