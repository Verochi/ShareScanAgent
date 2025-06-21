package com.amap.api.maps;

/* loaded from: classes12.dex */
public class CoordinateConverter {
    private static final java.lang.String TAG = "CoordinateConverter";
    private android.content.Context ctx;
    private com.amap.api.maps.CoordinateConverter.CoordType coordType = null;
    private com.amap.api.maps.model.LatLng sourceLatLng = null;

    /* renamed from: com.amap.api.maps.CoordinateConverter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.amap.api.maps.CoordinateConverter.CoordType.values().length];
            a = iArr;
            try {
                iArr[com.amap.api.maps.CoordinateConverter.CoordType.BAIDU.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.amap.api.maps.CoordinateConverter.CoordType.MAPBAR.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.amap.api.maps.CoordinateConverter.CoordType.MAPABC.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.amap.api.maps.CoordinateConverter.CoordType.SOSOMAP.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.amap.api.maps.CoordinateConverter.CoordType.ALIYUN.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.amap.api.maps.CoordinateConverter.CoordType.GOOGLE.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.amap.api.maps.CoordinateConverter.CoordType.GPS.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(android.content.Context context) {
        this.ctx = context;
    }

    public static boolean isAMapDataAvailable(double d, double d2) {
        return com.amap.api.mapcore.util.de.a(d, d2);
    }

    public com.amap.api.maps.model.LatLng convert() {
        com.amap.api.maps.CoordinateConverter.CoordType coordType = this.coordType;
        com.amap.api.maps.model.LatLng latLng = null;
        if (coordType == null || this.sourceLatLng == null) {
            return null;
        }
        try {
            java.lang.String str = "";
            switch (com.amap.api.maps.CoordinateConverter.AnonymousClass1.a[coordType.ordinal()]) {
                case 1:
                    latLng = com.amap.api.mapcore.util.aa.a(this.sourceLatLng);
                    str = com.bytedance.sdk.openadsdk.mediation.MediationConstant.ADN_BAIDU;
                    break;
                case 2:
                    latLng = com.amap.api.mapcore.util.aa.b(this.ctx, this.sourceLatLng);
                    str = "mapbar";
                    break;
                case 3:
                    str = "mapabc";
                    latLng = this.sourceLatLng;
                    break;
                case 4:
                    str = "sosomap";
                    latLng = this.sourceLatLng;
                    break;
                case 5:
                    str = "aliyun";
                    latLng = this.sourceLatLng;
                    break;
                case 6:
                    str = "google";
                    latLng = this.sourceLatLng;
                    break;
                case 7:
                    str = com.amap.api.services.geocoder.GeocodeSearch.GPS;
                    latLng = com.amap.api.mapcore.util.aa.a(this.ctx, this.sourceLatLng);
                    break;
            }
            com.amap.api.mapcore.util.di.a(this.ctx, str);
            return latLng;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.gd.c(th, TAG, "convert");
            return this.sourceLatLng;
        }
    }

    public com.amap.api.maps.CoordinateConverter coord(com.amap.api.maps.model.LatLng latLng) {
        this.sourceLatLng = latLng;
        return this;
    }

    public com.amap.api.maps.CoordinateConverter from(com.amap.api.maps.CoordinateConverter.CoordType coordType) {
        this.coordType = coordType;
        return this;
    }
}
