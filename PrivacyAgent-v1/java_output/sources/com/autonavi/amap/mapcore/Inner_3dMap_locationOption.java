package com.autonavi.amap.mapcore;

/* loaded from: classes12.dex */
public class Inner_3dMap_locationOption implements java.lang.Cloneable {
    private static com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol locationProtocol = com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol.HTTP;
    static java.lang.String APIKEY = "";
    private long interval = 2000;
    private long httpTimeOut = com.amap.api.mapcore.util.it.i;
    private boolean isOnceLocation = false;
    private boolean isMockEnable = false;
    private boolean isNeedAddress = true;
    private boolean isWifiActiveScan = true;
    private boolean lastWifiActiveScan = true;
    private com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode locationMode = com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
    private boolean isKillProcess = false;
    private boolean isGpsFirst = false;
    private boolean isOffset = true;
    private boolean isLocationCacheEnable = true;
    private boolean isOnceLocationLatest = false;
    private boolean sensorEnable = false;
    private boolean isWifiScan = true;

    public enum Inner_3dMap_Enum_LocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum Inner_3dMap_Enum_LocationProtocol {
        HTTP(0),
        HTTPS(1);

        private int value;

        Inner_3dMap_Enum_LocationProtocol(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    private com.autonavi.amap.mapcore.Inner_3dMap_locationOption clone(com.autonavi.amap.mapcore.Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.interval = inner_3dMap_locationOption.interval;
        this.isOnceLocation = inner_3dMap_locationOption.isOnceLocation;
        this.locationMode = inner_3dMap_locationOption.locationMode;
        this.isMockEnable = inner_3dMap_locationOption.isMockEnable;
        this.isKillProcess = inner_3dMap_locationOption.isKillProcess;
        this.isGpsFirst = inner_3dMap_locationOption.isGpsFirst;
        this.isNeedAddress = inner_3dMap_locationOption.isNeedAddress;
        this.isWifiActiveScan = inner_3dMap_locationOption.isWifiActiveScan;
        this.httpTimeOut = inner_3dMap_locationOption.httpTimeOut;
        this.isOffset = inner_3dMap_locationOption.isOffset;
        this.isLocationCacheEnable = inner_3dMap_locationOption.isLocationCacheEnable;
        this.isOnceLocationLatest = inner_3dMap_locationOption.isOnceLocationLatest;
        this.sensorEnable = inner_3dMap_locationOption.isSensorEnable();
        this.isWifiScan = inner_3dMap_locationOption.isWifiScan();
        return this;
    }

    public static java.lang.String getAPIKEY() {
        return APIKEY;
    }

    public static void setLocationProtocol(com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol inner_3dMap_Enum_LocationProtocol) {
        locationProtocol = inner_3dMap_Enum_LocationProtocol;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.autonavi.amap.mapcore.Inner_3dMap_locationOption m44clone() {
        try {
            super.clone();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return new com.autonavi.amap.mapcore.Inner_3dMap_locationOption().clone(this);
    }

    public long getHttpTimeOut() {
        return this.httpTimeOut;
    }

    public long getInterval() {
        return this.interval;
    }

    public com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode getLocationMode() {
        return this.locationMode;
    }

    public com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol getLocationProtocol() {
        return locationProtocol;
    }

    public boolean isGpsFirst() {
        return this.isGpsFirst;
    }

    public boolean isKillProcess() {
        return this.isKillProcess;
    }

    public boolean isLocationCacheEnable() {
        return this.isLocationCacheEnable;
    }

    public boolean isMockEnable() {
        return this.isMockEnable;
    }

    public boolean isNeedAddress() {
        return this.isNeedAddress;
    }

    public boolean isOffset() {
        return this.isOffset;
    }

    public boolean isOnceLocation() {
        if (this.isOnceLocationLatest) {
            return true;
        }
        return this.isOnceLocation;
    }

    public boolean isOnceLocationLatest() {
        return this.isOnceLocationLatest;
    }

    public boolean isSensorEnable() {
        return this.sensorEnable;
    }

    public boolean isWifiActiveScan() {
        return this.isWifiActiveScan;
    }

    public boolean isWifiScan() {
        return this.isWifiScan;
    }

    public com.autonavi.amap.mapcore.Inner_3dMap_locationOption setGpsFirst(boolean z) {
        this.isGpsFirst = z;
        return this;
    }

    public void setHttpTimeOut(long j) {
        this.httpTimeOut = j;
    }

    public com.autonavi.amap.mapcore.Inner_3dMap_locationOption setInterval(long j) {
        if (j <= 800) {
            j = 800;
        }
        this.interval = j;
        return this;
    }

    public com.autonavi.amap.mapcore.Inner_3dMap_locationOption setKillProcess(boolean z) {
        this.isKillProcess = z;
        return this;
    }

    public void setLocationCacheEnable(boolean z) {
        this.isLocationCacheEnable = z;
    }

    public com.autonavi.amap.mapcore.Inner_3dMap_locationOption setLocationMode(com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode inner_3dMap_Enum_LocationMode) {
        this.locationMode = inner_3dMap_Enum_LocationMode;
        return this;
    }

    public void setMockEnable(boolean z) {
        this.isMockEnable = z;
    }

    public com.autonavi.amap.mapcore.Inner_3dMap_locationOption setNeedAddress(boolean z) {
        this.isNeedAddress = z;
        return this;
    }

    public com.autonavi.amap.mapcore.Inner_3dMap_locationOption setOffset(boolean z) {
        this.isOffset = z;
        return this;
    }

    public com.autonavi.amap.mapcore.Inner_3dMap_locationOption setOnceLocation(boolean z) {
        this.isOnceLocation = z;
        return this;
    }

    public void setOnceLocationLatest(boolean z) {
        this.isOnceLocationLatest = z;
    }

    public void setSensorEnable(boolean z) {
        this.sensorEnable = z;
    }

    public void setWifiActiveScan(boolean z) {
        this.isWifiActiveScan = z;
        this.lastWifiActiveScan = z;
    }

    public void setWifiScan(boolean z) {
        this.isWifiScan = z;
        this.isWifiActiveScan = z ? this.lastWifiActiveScan : false;
    }

    public java.lang.String toString() {
        return "interval:" + java.lang.String.valueOf(this.interval) + "#isOnceLocation:" + java.lang.String.valueOf(this.isOnceLocation) + "#locationMode:" + java.lang.String.valueOf(this.locationMode) + "#isMockEnable:" + java.lang.String.valueOf(this.isMockEnable) + "#isKillProcess:" + java.lang.String.valueOf(this.isKillProcess) + "#isGpsFirst:" + java.lang.String.valueOf(this.isGpsFirst) + "#isNeedAddress:" + java.lang.String.valueOf(this.isNeedAddress) + "#isWifiActiveScan:" + java.lang.String.valueOf(this.isWifiActiveScan) + "#httpTimeOut:" + java.lang.String.valueOf(this.httpTimeOut) + "#isOffset:" + java.lang.String.valueOf(this.isOffset) + "#isLocationCacheEnable:" + java.lang.String.valueOf(this.isLocationCacheEnable) + "#isLocationCacheEnable:" + java.lang.String.valueOf(this.isLocationCacheEnable) + "#isOnceLocationLatest:" + java.lang.String.valueOf(this.isOnceLocationLatest) + "#sensorEnable:" + java.lang.String.valueOf(this.sensorEnable) + "#";
    }
}
