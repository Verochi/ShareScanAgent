package androidx.appcompat.app;

/* loaded from: classes.dex */
class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final java.lang.String TAG = "TwilightManager";
    private static androidx.appcompat.app.TwilightManager sInstance;
    private final android.content.Context mContext;
    private final android.location.LocationManager mLocationManager;
    private final androidx.appcompat.app.TwilightManager.TwilightState mTwilightState = new androidx.appcompat.app.TwilightManager.TwilightState();

    public static class TwilightState {
        boolean isNight;
        long nextUpdate;
        long todaySunrise;
        long todaySunset;
        long tomorrowSunrise;
        long yesterdaySunset;
    }

    @androidx.annotation.VisibleForTesting
    public TwilightManager(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.location.LocationManager locationManager) {
        this.mContext = context;
        this.mLocationManager = locationManager;
    }

    public static androidx.appcompat.app.TwilightManager getInstance(@androidx.annotation.NonNull android.content.Context context) {
        if (sInstance == null) {
            android.content.Context applicationContext = context.getApplicationContext();
            sInstance = new androidx.appcompat.app.TwilightManager(applicationContext, (android.location.LocationManager) applicationContext.getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION));
        }
        return sInstance;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    private android.location.Location getLastKnownLocation() {
        android.location.Location lastKnownLocationForProvider = androidx.core.content.PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? getLastKnownLocationForProvider("network") : null;
        android.location.Location lastKnownLocationForProvider2 = androidx.core.content.PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0 ? getLastKnownLocationForProvider(com.amap.api.services.geocoder.GeocodeSearch.GPS) : null;
        return (lastKnownLocationForProvider2 == null || lastKnownLocationForProvider == null) ? lastKnownLocationForProvider2 != null ? lastKnownLocationForProvider2 : lastKnownLocationForProvider : lastKnownLocationForProvider2.getTime() > lastKnownLocationForProvider.getTime() ? lastKnownLocationForProvider2 : lastKnownLocationForProvider;
    }

    @androidx.annotation.RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private android.location.Location getLastKnownLocationForProvider(java.lang.String str) {
        try {
            if (this.mLocationManager.isProviderEnabled(str)) {
                return this.mLocationManager.getLastKnownLocation(str);
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private boolean isStateValid() {
        return this.mTwilightState.nextUpdate > java.lang.System.currentTimeMillis();
    }

    @androidx.annotation.VisibleForTesting
    public static void setInstance(androidx.appcompat.app.TwilightManager twilightManager) {
        sInstance = twilightManager;
    }

    private void updateState(@androidx.annotation.NonNull android.location.Location location) {
        long j;
        androidx.appcompat.app.TwilightManager.TwilightState twilightState = this.mTwilightState;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        androidx.appcompat.app.TwilightCalculator twilightCalculator = androidx.appcompat.app.TwilightCalculator.getInstance();
        twilightCalculator.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = twilightCalculator.sunset;
        twilightCalculator.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = twilightCalculator.state == 1;
        long j3 = twilightCalculator.sunrise;
        long j4 = twilightCalculator.sunset;
        boolean z2 = z;
        twilightCalculator.calculateTwilight(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = twilightCalculator.sunrise;
        if (j3 == -1 || j4 == -1) {
            j = com.heytap.mcssdk.constant.a.g + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        twilightState.isNight = z2;
        twilightState.yesterdaySunset = j2;
        twilightState.todaySunrise = j3;
        twilightState.todaySunset = j4;
        twilightState.tomorrowSunrise = j5;
        twilightState.nextUpdate = j;
    }

    public boolean isNight() {
        androidx.appcompat.app.TwilightManager.TwilightState twilightState = this.mTwilightState;
        if (isStateValid()) {
            return twilightState.isNight;
        }
        android.location.Location lastKnownLocation = getLastKnownLocation();
        if (lastKnownLocation != null) {
            updateState(lastKnownLocation);
            return twilightState.isNight;
        }
        int i = java.util.Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
