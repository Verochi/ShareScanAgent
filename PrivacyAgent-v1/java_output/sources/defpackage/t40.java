package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class t40 implements com.amap.api.services.district.DistrictSearch.OnDistrictSearchListener {
    public final /* synthetic */ com.moji.location.DistrictSearchManager.OnDistrictSearchSuccessListener a;
    public final /* synthetic */ com.moji.location.DistrictSearchManager b;
    public final /* synthetic */ com.moji.http.rainclould.entity.DisasterListResult.Disaster c;

    public /* synthetic */ t40(com.moji.location.DistrictSearchManager.OnDistrictSearchSuccessListener onDistrictSearchSuccessListener, com.moji.location.DistrictSearchManager districtSearchManager, com.moji.http.rainclould.entity.DisasterListResult.Disaster disaster) {
        this.a = onDistrictSearchSuccessListener;
        this.b = districtSearchManager;
        this.c = disaster;
    }

    @Override // com.amap.api.services.district.DistrictSearch.OnDistrictSearchListener
    public final void onDistrictSearched(com.amap.api.services.district.DistrictResult districtResult) {
        com.moji.location.DistrictSearchManager.a(this.a, this.b, this.c, districtResult);
    }
}
