package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class wb implements com.mojiweather.area.adapter.CityManageAdapter.OnItemViewClickedListener {
    public final /* synthetic */ com.mojiweather.area.AreaManageFragment a;

    public /* synthetic */ wb(com.mojiweather.area.AreaManageFragment areaManageFragment) {
        this.a = areaManageFragment;
    }

    public final void onChangeNotification(com.moji.common.area.AreaInfo areaInfo) {
        com.mojiweather.area.AreaManageFragment.j(this.a, areaInfo);
    }
}
