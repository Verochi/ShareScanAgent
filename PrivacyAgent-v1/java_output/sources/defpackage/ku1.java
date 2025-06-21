package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class ku1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjtravel.common.OffSiteTravelAll n;
    public final /* synthetic */ com.moji.mjtravel.offsite.OffSitePart2PKCity t;

    public /* synthetic */ ku1(com.moji.mjtravel.common.OffSiteTravelAll offSiteTravelAll, com.moji.mjtravel.offsite.OffSitePart2PKCity offSitePart2PKCity) {
        this.n = offSiteTravelAll;
        this.t = offSitePart2PKCity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjtravel.offsite.OffSitePart2PKCity.a(this.n, this.t, view);
    }
}
