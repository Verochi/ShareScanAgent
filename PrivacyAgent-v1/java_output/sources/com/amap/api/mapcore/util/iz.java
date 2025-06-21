package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class iz {
    public static com.autonavi.amap.mapcore.Inner_3dMap_location a;
    com.amap.api.mapcore.util.im b = null;

    /* renamed from: com.amap.api.mapcore.util.iz$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.values().length];
            a = iArr;
            try {
                iArr[com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Device_Sensors.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    private static com.amap.api.location.AMapLocationClientOption a(com.autonavi.amap.mapcore.Inner_3dMap_locationOption inner_3dMap_locationOption) {
        com.amap.api.location.AMapLocationClientOption aMapLocationClientOption = new com.amap.api.location.AMapLocationClientOption();
        aMapLocationClientOption.setInterval(inner_3dMap_locationOption.getInterval());
        com.amap.api.location.AMapLocationClientOption.AMapLocationMode aMapLocationMode = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving;
        int i = com.amap.api.mapcore.util.iz.AnonymousClass1.a[inner_3dMap_locationOption.getLocationMode().ordinal()];
        aMapLocationClientOption.setLocationMode(i != 1 ? i != 2 ? com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy : com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors : com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        aMapLocationClientOption.setOnceLocation(inner_3dMap_locationOption.isOnceLocation());
        aMapLocationClientOption.setNeedAddress(inner_3dMap_locationOption.isNeedAddress());
        aMapLocationClientOption.setLocationCacheEnable(inner_3dMap_locationOption.isLocationCacheEnable());
        return aMapLocationClientOption;
    }

    public static com.autonavi.amap.mapcore.Inner_3dMap_location a(com.amap.api.location.AMapLocation aMapLocation) {
        com.autonavi.amap.mapcore.Inner_3dMap_location inner_3dMap_location = new com.autonavi.amap.mapcore.Inner_3dMap_location("");
        if (aMapLocation != null) {
            try {
                inner_3dMap_location.setLatitude(aMapLocation.getLatitude());
                inner_3dMap_location.setLongitude(aMapLocation.getLongitude());
                inner_3dMap_location.setAccuracy(aMapLocation.getAccuracy());
                inner_3dMap_location.setBearing(aMapLocation.getBearing());
                inner_3dMap_location.setAltitude(aMapLocation.getAltitude());
                inner_3dMap_location.setProvider(aMapLocation.getProvider());
                inner_3dMap_location.setSpeed(aMapLocation.getSpeed());
                inner_3dMap_location.setTime(aMapLocation.getTime());
                inner_3dMap_location.setErrorCode(aMapLocation.getErrorCode());
                inner_3dMap_location.setErrorInfo(aMapLocation.getErrorInfo());
                inner_3dMap_location.setLocationType(aMapLocation.getLocationType());
                inner_3dMap_location.setLocationDetail(aMapLocation.getLocationDetail());
                inner_3dMap_location.setProvince(aMapLocation.getProvince());
                inner_3dMap_location.setCity(aMapLocation.getCity());
                inner_3dMap_location.setCityCode(aMapLocation.getCityCode());
                inner_3dMap_location.setCountry(aMapLocation.getCountry());
                inner_3dMap_location.setDistrict(aMapLocation.getDistrict());
                inner_3dMap_location.setAddress(aMapLocation.getAddress());
                inner_3dMap_location.setAdCode(aMapLocation.getAdCode());
                inner_3dMap_location.setExtras(aMapLocation.getExtras());
                inner_3dMap_location.setRoad(aMapLocation.getRoad());
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "Util", "converterLocation");
            }
        }
        return inner_3dMap_location;
    }

    public static void a(java.lang.Object obj, com.autonavi.amap.mapcore.Inner_3dMap_locationOption inner_3dMap_locationOption) {
        if (obj == null) {
            return;
        }
        ((com.amap.api.location.AMapLocationClient) obj).setLocationOption(a(inner_3dMap_locationOption));
    }

    public final void a(java.lang.Object obj, com.autonavi.amap.mapcore.Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (this.b == null) {
            this.b = new com.amap.api.mapcore.util.im();
        }
        this.b.a(inner_3dMap_locationListener);
        ((com.amap.api.location.AMapLocationClient) obj).setLocationListener(this.b);
    }
}
