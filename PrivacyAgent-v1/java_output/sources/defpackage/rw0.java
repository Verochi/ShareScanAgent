package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class rw0 implements com.moji.NestedScrollLinearLayout.OnScrollAreaChangeListener {
    public final /* synthetic */ com.moji.newliveview.databinding.LiveHomeTabCityBinding a;
    public final /* synthetic */ com.moji.liveview.home.near.ui.LiveCityPresenter b;

    public /* synthetic */ rw0(com.moji.newliveview.databinding.LiveHomeTabCityBinding liveHomeTabCityBinding, com.moji.liveview.home.near.ui.LiveCityPresenter liveCityPresenter) {
        this.a = liveHomeTabCityBinding;
        this.b = liveCityPresenter;
    }

    public final void onScrollAreaChange(boolean z) {
        com.moji.liveview.home.near.ui.LiveCityPresenter.b(this.a, this.b, z);
    }
}
