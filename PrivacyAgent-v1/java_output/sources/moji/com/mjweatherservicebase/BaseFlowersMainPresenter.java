package moji.com.mjweatherservicebase;

@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\bH&J\b\u0010\u0013\u001a\u00020\bH&J\b\u0010\u0014\u001a\u00020\bH&J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000fH&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000fH&J(\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH&J\b\u0010 \u001a\u00020\u001cH&J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000fH&¨\u0006#"}, d2 = {"Lmoji/com/mjweatherservicebase/BaseFlowersMainPresenter;", "", "()V", "bannerShow", "", "eventMapLocationClick", "eventMapNameClick", "param1", "", "param2", "Lorg/json/JSONObject;", "eventMapSpotClick", "eventMapTypeClick", "eventNearbyScroll", "flowerMapClickIconRes", "", "flowerMapCountrySpoTextRes", "flowerMapIconRes", "flowerMapIconTextRes", "getFlowerType", "getNearbyTitle", "hotPhotoClick", "id", "nearPhotoClick", "spotID", "nearbyMoreClick", "areaId", "nearby", "", "mLat", "", "mLon", "needShowMoreView", "openDetailActivity", "attractionId", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public abstract class BaseFlowersMainPresenter {
    public abstract void bannerShow();

    public abstract void eventMapLocationClick();

    public abstract void eventMapNameClick(@org.jetbrains.annotations.NotNull java.lang.String param1, @org.jetbrains.annotations.NotNull org.json.JSONObject param2);

    public abstract void eventMapSpotClick();

    public abstract void eventMapTypeClick();

    public abstract void eventNearbyScroll();

    public abstract int flowerMapClickIconRes();

    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String flowerMapCountrySpoTextRes();

    public abstract int flowerMapIconRes();

    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String flowerMapIconTextRes();

    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getFlowerType();

    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getNearbyTitle();

    public abstract void hotPhotoClick(int id);

    public abstract void nearPhotoClick(int spotID);

    public abstract void nearbyMoreClick(int areaId, boolean nearby, double mLat, double mLon);

    public abstract boolean needShowMoreView();

    public abstract void openDetailActivity(int attractionId);
}
