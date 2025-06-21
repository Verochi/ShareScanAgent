package androidx.core.location;

/* loaded from: classes.dex */
public abstract class GnssStatusCompat {

    @android.annotation.SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_BEIDOU = 5;

    @android.annotation.SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_GALILEO = 6;

    @android.annotation.SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_GLONASS = 3;

    @android.annotation.SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_GPS = 1;

    @android.annotation.SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_IRNSS = 7;

    @android.annotation.SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_QZSS = 4;

    @android.annotation.SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_SBAS = 2;

    @android.annotation.SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_UNKNOWN = 0;

    public static abstract class Callback {
        public void onFirstFix(@androidx.annotation.IntRange(from = 0) int i) {
        }

        public void onSatelliteStatusChanged(@androidx.annotation.NonNull androidx.core.location.GnssStatusCompat gnssStatusCompat) {
        }

        public void onStarted() {
        }

        public void onStopped() {
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public @interface ConstellationType {
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(24)
    public static androidx.core.location.GnssStatusCompat wrap(@androidx.annotation.NonNull android.location.GnssStatus gnssStatus) {
        return new androidx.core.location.GnssStatusWrapper(gnssStatus);
    }

    @androidx.annotation.NonNull
    @android.annotation.SuppressLint({"ReferencesDeprecated"})
    public static androidx.core.location.GnssStatusCompat wrap(@androidx.annotation.NonNull android.location.GpsStatus gpsStatus) {
        return new androidx.core.location.GpsStatusWrapper(gpsStatus);
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = com.autonavi.amap.mapcore.VirtualEarthProjection.MAX_LONGITUDE)
    public abstract float getAzimuthDegrees(@androidx.annotation.IntRange(from = 0) int i);

    @androidx.annotation.FloatRange(from = 0.0d, to = 63.0d)
    public abstract float getBasebandCn0DbHz(@androidx.annotation.IntRange(from = 0) int i);

    @androidx.annotation.FloatRange(from = 0.0d)
    public abstract float getCarrierFrequencyHz(@androidx.annotation.IntRange(from = 0) int i);

    @androidx.annotation.FloatRange(from = 0.0d, to = 63.0d)
    public abstract float getCn0DbHz(@androidx.annotation.IntRange(from = 0) int i);

    public abstract int getConstellationType(@androidx.annotation.IntRange(from = 0) int i);

    @androidx.annotation.FloatRange(from = -90.0d, to = 90.0d)
    public abstract float getElevationDegrees(@androidx.annotation.IntRange(from = 0) int i);

    @androidx.annotation.IntRange(from = 0)
    public abstract int getSatelliteCount();

    @androidx.annotation.IntRange(from = 1, to = com.igexin.sdk.main.PushConfig.TAGS_MAX_NUMBER)
    public abstract int getSvid(@androidx.annotation.IntRange(from = 0) int i);

    public abstract boolean hasAlmanacData(@androidx.annotation.IntRange(from = 0) int i);

    public abstract boolean hasBasebandCn0DbHz(@androidx.annotation.IntRange(from = 0) int i);

    public abstract boolean hasCarrierFrequencyHz(@androidx.annotation.IntRange(from = 0) int i);

    public abstract boolean hasEphemerisData(@androidx.annotation.IntRange(from = 0) int i);

    public abstract boolean usedInFix(@androidx.annotation.IntRange(from = 0) int i);
}
