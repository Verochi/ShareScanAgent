package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class wr0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjpersonalmodule.data.IPersonalGridItem n;
    public final /* synthetic */ com.moji.mjweather.weather.beta.life.IndexGridHorizontalAdapter.OtherClick t;
    public final /* synthetic */ com.moji.mjweather.weather.beta.life.IndexGridItemViewHolderFor10_3 u;

    public /* synthetic */ wr0(com.moji.mjpersonalmodule.data.IPersonalGridItem iPersonalGridItem, com.moji.mjweather.weather.beta.life.IndexGridHorizontalAdapter.OtherClick otherClick, com.moji.mjweather.weather.beta.life.IndexGridItemViewHolderFor10_3 indexGridItemViewHolderFor10_3) {
        this.n = iPersonalGridItem;
        this.t = otherClick;
        this.u = indexGridItemViewHolderFor10_3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.weather.beta.life.IndexGridItemViewHolderFor10_3.a(this.n, this.t, this.u, view);
    }
}
