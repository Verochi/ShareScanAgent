package defpackage;

/* renamed from: do, reason: invalid class name */
/* loaded from: classes6.dex */
public final /* synthetic */ class Cdo implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjtravel.CityTravelMainActivity n;

    public /* synthetic */ Cdo(com.moji.mjtravel.CityTravelMainActivity cityTravelMainActivity) {
        this.n = cityTravelMainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjtravel.CityTravelMainActivity.b(this.n, (com.moji.mjtravel.common.LocalTravelAll) obj);
    }
}
