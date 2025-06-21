package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class u10 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.diamon.entity.DiamondData n;
    public final /* synthetic */ com.moji.diamon.adapter.DiamondPersonalAdapter.DiamondPersonalViewHolder t;

    public /* synthetic */ u10(com.moji.diamon.entity.DiamondData diamondData, com.moji.diamon.adapter.DiamondPersonalAdapter.DiamondPersonalViewHolder diamondPersonalViewHolder) {
        this.n = diamondData;
        this.t = diamondPersonalViewHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.diamon.adapter.DiamondPersonalAdapter.DiamondPersonalViewHolder.a(this.n, this.t);
    }
}
