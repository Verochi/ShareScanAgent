package defpackage;

/* loaded from: classes16.dex */
public final /* synthetic */ class ot2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.sunglow.SunglowMainActivity n;

    public /* synthetic */ ot2(com.moji.sunglow.SunglowMainActivity sunglowMainActivity) {
        this.n = sunglowMainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.sunglow.SunglowMainActivity.g(this.n, (com.moji.http.sunglow.GlowCityRankBean) obj);
    }
}
