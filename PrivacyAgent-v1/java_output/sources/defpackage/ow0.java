package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class ow0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.snsforum.v9.entity.LiveNearV9Result.Local n;
    public final /* synthetic */ com.moji.liveview.home.near.view.LiveCityDressView t;

    public /* synthetic */ ow0(com.moji.http.snsforum.v9.entity.LiveNearV9Result.Local local, com.moji.liveview.home.near.view.LiveCityDressView liveCityDressView) {
        this.n = local;
        this.t = liveCityDressView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview.home.near.view.LiveCityDressView.b(this.n, this.t, view);
    }
}
