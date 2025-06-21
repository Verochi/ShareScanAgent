package defpackage;

/* loaded from: classes26.dex */
public final /* synthetic */ class g60 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.NestedScrollLinearLayout n;
    public final /* synthetic */ com.moji.index.dress.DressActivity2 t;
    public final /* synthetic */ com.moji.viewpager.CeilViewPager u;

    public /* synthetic */ g60(com.moji.NestedScrollLinearLayout nestedScrollLinearLayout, com.moji.index.dress.DressActivity2 dressActivity2, com.moji.viewpager.CeilViewPager ceilViewPager) {
        this.n = nestedScrollLinearLayout;
        this.t = dressActivity2;
        this.u = ceilViewPager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.index.dress.DressActivity2.b(this.n, this.t, this.u);
    }
}
