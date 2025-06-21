package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ0\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ0\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lmoji/com/mjweatherservicebase/card/SpotJumpManager;", "", "()V", "AREA_ID", "", "AREA_LAT", "AREA_LON", "AREA_NAME", "AREA_NEARBY", "REQUEST_CODE_OPEN_MEMBER", "", "SPOT_ID", "openPeachDetailActivity", "", "attractionId", "openPeachSpotListActivity", "areaId", "areaName", "mLat", "", "mLon", "nearby", "", "openSpotDetailActivity", "openSpotListActivity", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class SpotJumpManager {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String AREA_ID = "area_id";

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String AREA_LAT = "area_lat";

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String AREA_LON = "area_lon";

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String AREA_NAME = "area_name";

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String AREA_NEARBY = "area_nearby";

    @org.jetbrains.annotations.NotNull
    public static final moji.com.mjweatherservicebase.card.SpotJumpManager INSTANCE = new moji.com.mjweatherservicebase.card.SpotJumpManager();
    public static final int REQUEST_CODE_OPEN_MEMBER = 85;

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SPOT_ID = "spot_id";

    public final void openPeachDetailActivity(int attractionId) {
        com.moji.router.MJRouter.getInstance().build("peachflower/detail").withLong("spot_id", attractionId).start();
    }

    public final void openPeachSpotListActivity(int areaId, @org.jetbrains.annotations.NotNull java.lang.String areaName, double mLat, double mLon, boolean nearby) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(areaName, "areaName");
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong(AREA_ID, areaId);
        bundle.putString(AREA_NAME, areaName);
        if (com.moji.location.util.LocationUtil.isLatLanValid(mLat, mLon)) {
            bundle.putDouble(AREA_LAT, mLat);
            bundle.putDouble(AREA_LON, mLon);
        }
        bundle.putBoolean(AREA_NEARBY, nearby);
        com.moji.router.MJRouter.getInstance().build("peachflowers/spot").withBundle(bundle).start();
    }

    public final void openSpotDetailActivity(int attractionId) {
        com.moji.router.MJRouter.getInstance().build("rflowers/detail").withLong("spot_id", attractionId).start();
    }

    public final void openSpotListActivity(int areaId, @org.jetbrains.annotations.NotNull java.lang.String areaName, double mLat, double mLon, boolean nearby) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(areaName, "areaName");
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong(AREA_ID, areaId);
        bundle.putString(AREA_NAME, areaName);
        if (com.moji.location.util.LocationUtil.isLatLanValid(mLat, mLon)) {
            bundle.putDouble(AREA_LAT, mLat);
            bundle.putDouble(AREA_LON, mLon);
        }
        bundle.putBoolean(AREA_NEARBY, nearby);
        com.moji.router.MJRouter.getInstance().build("rapeflowers/spot").withBundle(bundle).start();
    }
}
