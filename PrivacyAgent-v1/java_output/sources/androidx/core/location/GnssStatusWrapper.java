package androidx.core.location;

@androidx.annotation.RequiresApi(24)
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class GnssStatusWrapper extends androidx.core.location.GnssStatusCompat {
    private final android.location.GnssStatus mWrapped;

    public GnssStatusWrapper(android.location.GnssStatus gnssStatus) {
        this.mWrapped = (android.location.GnssStatus) androidx.core.util.Preconditions.checkNotNull(gnssStatus);
    }

    public boolean equals(java.lang.Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof androidx.core.location.GnssStatusWrapper)) {
            return false;
        }
        equals = this.mWrapped.equals(((androidx.core.location.GnssStatusWrapper) obj).mWrapped);
        return equals;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int i) {
        float azimuthDegrees;
        azimuthDegrees = this.mWrapped.getAzimuthDegrees(i);
        return azimuthDegrees;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int i) {
        float basebandCn0DbHz;
        if (android.os.Build.VERSION.SDK_INT < 30) {
            throw new java.lang.UnsupportedOperationException();
        }
        basebandCn0DbHz = this.mWrapped.getBasebandCn0DbHz(i);
        return basebandCn0DbHz;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int i) {
        float carrierFrequencyHz;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            throw new java.lang.UnsupportedOperationException();
        }
        carrierFrequencyHz = this.mWrapped.getCarrierFrequencyHz(i);
        return carrierFrequencyHz;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int i) {
        float cn0DbHz;
        cn0DbHz = this.mWrapped.getCn0DbHz(i);
        return cn0DbHz;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int i) {
        int constellationType;
        constellationType = this.mWrapped.getConstellationType(i);
        return constellationType;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int i) {
        float elevationDegrees;
        elevationDegrees = this.mWrapped.getElevationDegrees(i);
        return elevationDegrees;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        int satelliteCount;
        satelliteCount = this.mWrapped.getSatelliteCount();
        return satelliteCount;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int i) {
        int svid;
        svid = this.mWrapped.getSvid(i);
        return svid;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int i) {
        boolean hasAlmanacData;
        hasAlmanacData = this.mWrapped.hasAlmanacData(i);
        return hasAlmanacData;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int i) {
        boolean hasBasebandCn0DbHz;
        if (android.os.Build.VERSION.SDK_INT < 30) {
            return false;
        }
        hasBasebandCn0DbHz = this.mWrapped.hasBasebandCn0DbHz(i);
        return hasBasebandCn0DbHz;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int i) {
        boolean hasCarrierFrequencyHz;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return false;
        }
        hasCarrierFrequencyHz = this.mWrapped.hasCarrierFrequencyHz(i);
        return hasCarrierFrequencyHz;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int i) {
        boolean hasEphemerisData;
        hasEphemerisData = this.mWrapped.hasEphemerisData(i);
        return hasEphemerisData;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.mWrapped.hashCode();
        return hashCode;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int i) {
        boolean usedInFix;
        usedInFix = this.mWrapped.usedInFix(i);
        return usedInFix;
    }
}
