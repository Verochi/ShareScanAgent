package com.amap.api.location;

/* loaded from: classes12.dex */
public class AMapLocationClientOption implements android.os.Parcelable, java.lang.Cloneable {
    private static int d = 0;
    private static int e = 1;
    private static int f = 2;
    private static int g = 4;
    private boolean A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private float H;
    private com.amap.api.location.AMapLocationClientOption.AMapLocationPurpose I;
    boolean b;
    java.lang.String c;
    private long h;
    private long i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private com.amap.api.location.AMapLocationClientOption.AMapLocationMode o;
    private boolean q;
    private boolean r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f115s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private long x;
    private long y;
    private com.amap.api.location.AMapLocationClientOption.GeoLanguage z;
    private static com.amap.api.location.AMapLocationClientOption.AMapLocationProtocol p = com.amap.api.location.AMapLocationClientOption.AMapLocationProtocol.HTTP;
    static java.lang.String a = "";
    public static final android.os.Parcelable.Creator<com.amap.api.location.AMapLocationClientOption> CREATOR = new com.amap.api.location.AMapLocationClientOption.AnonymousClass1();
    public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
    public static long SCAN_WIFI_INTERVAL = 30000;

    /* renamed from: com.amap.api.location.AMapLocationClientOption$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.location.AMapLocationClientOption> {
        private static com.amap.api.location.AMapLocationClientOption a(android.os.Parcel parcel) {
            return new com.amap.api.location.AMapLocationClientOption(parcel);
        }

        private static com.amap.api.location.AMapLocationClientOption[] a(int i) {
            return new com.amap.api.location.AMapLocationClientOption[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.location.AMapLocationClientOption createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.location.AMapLocationClientOption[] newArray(int i) {
            return a(i);
        }
    }

    /* renamed from: com.amap.api.location.AMapLocationClientOption$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.amap.api.location.AMapLocationClientOption.AMapLocationPurpose.values().length];
            a = iArr;
            try {
                iArr[com.amap.api.location.AMapLocationClientOption.AMapLocationPurpose.SignIn.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.amap.api.location.AMapLocationClientOption.AMapLocationPurpose.Transport.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.amap.api.location.AMapLocationClientOption.AMapLocationPurpose.Sport.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);

        private int a;

        AMapLocationProtocol(int i) {
            this.a = i;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    public enum GeoLanguage {
        DEFAULT,
        ZH,
        EN
    }

    public AMapLocationClientOption() {
        this.h = 2000L;
        this.i = com.loc.fv.i;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
        this.q = false;
        this.r = false;
        this.f115s = true;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = 30000L;
        this.y = 30000L;
        this.z = com.amap.api.location.AMapLocationClientOption.GeoLanguage.DEFAULT;
        this.A = false;
        this.B = 1500;
        this.C = 21600000;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = 0.0f;
        this.I = null;
        this.b = false;
        this.c = null;
    }

    public AMapLocationClientOption(android.os.Parcel parcel) {
        this.h = 2000L;
        this.i = com.loc.fv.i;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        com.amap.api.location.AMapLocationClientOption.AMapLocationMode aMapLocationMode = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
        this.o = aMapLocationMode;
        this.q = false;
        this.r = false;
        this.f115s = true;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = 30000L;
        this.y = 30000L;
        com.amap.api.location.AMapLocationClientOption.GeoLanguage geoLanguage = com.amap.api.location.AMapLocationClientOption.GeoLanguage.DEFAULT;
        this.z = geoLanguage;
        this.A = false;
        this.B = 1500;
        this.C = 21600000;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = 0.0f;
        this.I = null;
        this.b = false;
        this.c = null;
        this.h = parcel.readLong();
        this.i = parcel.readLong();
        this.j = parcel.readByte() != 0;
        this.k = parcel.readByte() != 0;
        this.l = parcel.readByte() != 0;
        this.m = parcel.readByte() != 0;
        this.n = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.o = readInt != -1 ? com.amap.api.location.AMapLocationClientOption.AMapLocationMode.values()[readInt] : aMapLocationMode;
        this.q = parcel.readByte() != 0;
        this.r = parcel.readByte() != 0;
        this.D = parcel.readByte() != 0;
        this.E = parcel.readByte() != 0;
        this.F = parcel.readByte() != 0;
        this.G = parcel.readByte() != 0;
        this.f115s = parcel.readByte() != 0;
        this.t = parcel.readByte() != 0;
        this.u = parcel.readByte() != 0;
        this.v = parcel.readByte() != 0;
        this.w = parcel.readByte() != 0;
        this.x = parcel.readLong();
        int readInt2 = parcel.readInt();
        p = readInt2 == -1 ? com.amap.api.location.AMapLocationClientOption.AMapLocationProtocol.HTTP : com.amap.api.location.AMapLocationClientOption.AMapLocationProtocol.values()[readInt2];
        int readInt3 = parcel.readInt();
        this.z = readInt3 != -1 ? com.amap.api.location.AMapLocationClientOption.GeoLanguage.values()[readInt3] : geoLanguage;
        this.H = parcel.readFloat();
        int readInt4 = parcel.readInt();
        this.I = readInt4 != -1 ? com.amap.api.location.AMapLocationClientOption.AMapLocationPurpose.values()[readInt4] : null;
        OPEN_ALWAYS_SCAN_WIFI = parcel.readByte() != 0;
        this.y = parcel.readLong();
    }

    private com.amap.api.location.AMapLocationClientOption a(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        this.h = aMapLocationClientOption.h;
        this.j = aMapLocationClientOption.j;
        this.o = aMapLocationClientOption.o;
        this.k = aMapLocationClientOption.k;
        this.q = aMapLocationClientOption.q;
        this.r = aMapLocationClientOption.r;
        this.D = aMapLocationClientOption.D;
        this.l = aMapLocationClientOption.l;
        this.m = aMapLocationClientOption.m;
        this.i = aMapLocationClientOption.i;
        this.f115s = aMapLocationClientOption.f115s;
        this.t = aMapLocationClientOption.t;
        this.u = aMapLocationClientOption.u;
        this.v = aMapLocationClientOption.isSensorEnable();
        this.w = aMapLocationClientOption.isWifiScan();
        this.x = aMapLocationClientOption.x;
        setLocationProtocol(aMapLocationClientOption.getLocationProtocol());
        this.z = aMapLocationClientOption.z;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        this.H = aMapLocationClientOption.H;
        this.I = aMapLocationClientOption.I;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(aMapLocationClientOption.getScanWifiInterval());
        this.y = aMapLocationClientOption.y;
        this.C = aMapLocationClientOption.getCacheTimeOut();
        this.A = aMapLocationClientOption.getCacheCallBack();
        this.B = aMapLocationClientOption.getCacheCallBackTime();
        this.E = aMapLocationClientOption.isSelfStartServiceEnable();
        this.F = aMapLocationClientOption.isNoLocReqCgiEnable();
        this.G = aMapLocationClientOption.isSysNetworkLocEnable();
        return this;
    }

    public static java.lang.String getAPIKEY() {
        return a;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return false;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z) {
    }

    public static void setLocationProtocol(com.amap.api.location.AMapLocationClientOption.AMapLocationProtocol aMapLocationProtocol) {
        p = aMapLocationProtocol;
    }

    public static void setOpenAlwaysScanWifi(boolean z) {
        OPEN_ALWAYS_SCAN_WIFI = z;
    }

    public static void setScanWifiInterval(long j) {
        SCAN_WIFI_INTERVAL = j;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.amap.api.location.AMapLocationClientOption m14clone() {
        try {
            super.clone();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return new com.amap.api.location.AMapLocationClientOption().a(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getCacheCallBack() {
        return this.A;
    }

    public int getCacheCallBackTime() {
        return this.B;
    }

    public int getCacheTimeOut() {
        return this.C;
    }

    public float getDeviceModeDistanceFilter() {
        return this.H;
    }

    public com.amap.api.location.AMapLocationClientOption.GeoLanguage getGeoLanguage() {
        return this.z;
    }

    public long getGpsFirstTimeout() {
        return this.y;
    }

    public long getHttpTimeOut() {
        return this.i;
    }

    public long getInterval() {
        return this.h;
    }

    public long getLastLocationLifeCycle() {
        return this.x;
    }

    public com.amap.api.location.AMapLocationClientOption.AMapLocationMode getLocationMode() {
        return this.o;
    }

    public com.amap.api.location.AMapLocationClientOption.AMapLocationProtocol getLocationProtocol() {
        return p;
    }

    public com.amap.api.location.AMapLocationClientOption.AMapLocationPurpose getLocationPurpose() {
        return this.I;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isBeidouFirst() {
        return this.D;
    }

    public boolean isGpsFirst() {
        return this.r;
    }

    public boolean isKillProcess() {
        return this.q;
    }

    public boolean isLocationCacheEnable() {
        return this.t;
    }

    public boolean isMockEnable() {
        return this.k;
    }

    public boolean isNeedAddress() {
        return this.l;
    }

    public boolean isNoLocReqCgiEnable() {
        return this.F;
    }

    public boolean isOffset() {
        return this.f115s;
    }

    public boolean isOnceLocation() {
        return this.j;
    }

    public boolean isOnceLocationLatest() {
        return this.u;
    }

    public boolean isSelfStartServiceEnable() {
        return this.E;
    }

    public boolean isSensorEnable() {
        return this.v;
    }

    public boolean isSysNetworkLocEnable() {
        return this.G;
    }

    public boolean isWifiActiveScan() {
        return this.m;
    }

    public boolean isWifiScan() {
        return this.w;
    }

    public com.amap.api.location.AMapLocationClientOption setBeidouFirst(boolean z) {
        this.D = z;
        return this;
    }

    public void setCacheCallBack(boolean z) {
        this.A = z;
    }

    public void setCacheCallBackTime(int i) {
        this.B = i;
    }

    public void setCacheTimeOut(int i) {
        this.C = i;
    }

    public com.amap.api.location.AMapLocationClientOption setDeviceModeDistanceFilter(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.H = f2;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setGeoLanguage(com.amap.api.location.AMapLocationClientOption.GeoLanguage geoLanguage) {
        this.z = geoLanguage;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setGpsFirst(boolean z) {
        this.r = z;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setGpsFirstTimeout(long j) {
        if (j < 5000) {
            j = 5000;
        }
        if (j > 30000) {
            j = 30000;
        }
        this.y = j;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setHttpTimeOut(long j) {
        this.i = j;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setInterval(long j) {
        if (j <= 800) {
            j = 800;
        }
        this.h = j;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setKillProcess(boolean z) {
        this.q = z;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setLastLocationLifeCycle(long j) {
        this.x = j;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setLocationCacheEnable(boolean z) {
        this.t = z;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setLocationMode(com.amap.api.location.AMapLocationClientOption.AMapLocationMode aMapLocationMode) {
        this.o = aMapLocationMode;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setLocationPurpose(com.amap.api.location.AMapLocationClientOption.AMapLocationPurpose aMapLocationPurpose) {
        java.lang.String str;
        this.I = aMapLocationPurpose;
        if (aMapLocationPurpose != null) {
            int i = com.amap.api.location.AMapLocationClientOption.AnonymousClass2.a[aMapLocationPurpose.ordinal()];
            if (i == 1) {
                this.o = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
                this.j = true;
                this.u = true;
                this.r = false;
                this.D = false;
                this.k = false;
                this.w = true;
                this.E = true;
                this.F = true;
                this.G = true;
                int i2 = d;
                int i3 = e;
                if ((i2 & i3) == 0) {
                    this.b = true;
                    d = i2 | i3;
                    this.c = "signin";
                }
            } else if (i == 2) {
                int i4 = d;
                int i5 = f;
                if ((i4 & i5) == 0) {
                    this.b = true;
                    d = i4 | i5;
                    str = androidx.core.app.NotificationCompat.CATEGORY_TRANSPORT;
                    this.c = str;
                }
                this.o = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
                this.j = false;
                this.u = false;
                this.r = true;
                this.D = false;
                this.E = true;
                this.F = true;
                this.G = true;
                this.k = false;
                this.w = true;
            } else if (i == 3) {
                int i6 = d;
                int i7 = g;
                if ((i6 & i7) == 0) {
                    this.b = true;
                    d = i6 | i7;
                    str = "sport";
                    this.c = str;
                }
                this.o = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
                this.j = false;
                this.u = false;
                this.r = true;
                this.D = false;
                this.E = true;
                this.F = true;
                this.G = true;
                this.k = false;
                this.w = true;
            }
        }
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setMockEnable(boolean z) {
        this.k = z;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setNeedAddress(boolean z) {
        this.l = z;
        return this;
    }

    public void setNoLocReqCgiEnable(boolean z) {
        this.F = z;
    }

    public com.amap.api.location.AMapLocationClientOption setOffset(boolean z) {
        this.f115s = z;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setOnceLocation(boolean z) {
        this.j = z;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setOnceLocationLatest(boolean z) {
        this.u = z;
        return this;
    }

    public void setSelfStartServiceEnable(boolean z) {
        this.E = z;
    }

    public com.amap.api.location.AMapLocationClientOption setSensorEnable(boolean z) {
        this.v = z;
        return this;
    }

    public void setSysNetworkLocEnable(boolean z) {
        this.G = z;
    }

    public com.amap.api.location.AMapLocationClientOption setWifiActiveScan(boolean z) {
        this.m = z;
        this.n = z;
        return this;
    }

    public com.amap.api.location.AMapLocationClientOption setWifiScan(boolean z) {
        this.w = z;
        this.m = z ? this.n : false;
        return this;
    }

    public java.lang.String toString() {
        return "interval:" + java.lang.String.valueOf(this.h) + "#isOnceLocation:" + java.lang.String.valueOf(this.j) + "#locationMode:" + java.lang.String.valueOf(this.o) + "#locationProtocol:" + java.lang.String.valueOf(p) + "#isMockEnable:" + java.lang.String.valueOf(this.k) + "#isKillProcess:" + java.lang.String.valueOf(this.q) + "#isGpsFirst:" + java.lang.String.valueOf(this.r) + "#isBeidouFirst:" + java.lang.String.valueOf(this.D) + "#isSelfStartServiceEnable:" + java.lang.String.valueOf(this.E) + "#noLocReqCgiEnable:" + java.lang.String.valueOf(this.F) + "#sysNetworkLocEnable:" + java.lang.String.valueOf(this.G) + "#isNeedAddress:" + java.lang.String.valueOf(this.l) + "#isWifiActiveScan:" + java.lang.String.valueOf(this.m) + "#wifiScan:" + java.lang.String.valueOf(this.w) + "#httpTimeOut:" + java.lang.String.valueOf(this.i) + "#isLocationCacheEnable:" + java.lang.String.valueOf(this.t) + "#isOnceLocationLatest:" + java.lang.String.valueOf(this.u) + "#sensorEnable:" + java.lang.String.valueOf(this.v) + "#geoLanguage:" + java.lang.String.valueOf(this.z) + "#locationPurpose:" + java.lang.String.valueOf(this.I) + "#callback:" + java.lang.String.valueOf(this.A) + "#time:" + java.lang.String.valueOf(this.B) + "#";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this.h);
        parcel.writeLong(this.i);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        com.amap.api.location.AMapLocationClientOption.AMapLocationMode aMapLocationMode = this.o;
        parcel.writeInt(aMapLocationMode == null ? -1 : aMapLocationMode.ordinal());
        parcel.writeByte(this.q ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.E ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.F ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.G ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f115s ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.t ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.u ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.v ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.w ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.x);
        parcel.writeInt(p == null ? -1 : getLocationProtocol().ordinal());
        com.amap.api.location.AMapLocationClientOption.GeoLanguage geoLanguage = this.z;
        parcel.writeInt(geoLanguage == null ? -1 : geoLanguage.ordinal());
        parcel.writeFloat(this.H);
        com.amap.api.location.AMapLocationClientOption.AMapLocationPurpose aMapLocationPurpose = this.I;
        parcel.writeInt(aMapLocationPurpose != null ? aMapLocationPurpose.ordinal() : -1);
        parcel.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        parcel.writeLong(this.y);
    }
}
