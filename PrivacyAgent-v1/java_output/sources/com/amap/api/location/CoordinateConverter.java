package com.amap.api.location;

/* loaded from: classes12.dex */
public class CoordinateConverter {
    private static int b = 0;
    private static int c = 1;
    private static int d = 2;
    private static int e = 4;
    private static int f = 8;
    private static int g = 16;
    private static int h = 32;
    private static int i = 64;
    private android.content.Context j;
    private com.amap.api.location.CoordinateConverter.CoordType k = null;
    private com.amap.api.location.DPoint l = null;
    com.amap.api.location.DPoint a = null;

    /* renamed from: com.amap.api.location.CoordinateConverter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.amap.api.location.CoordinateConverter.CoordType.values().length];
            a = iArr;
            try {
                iArr[com.amap.api.location.CoordinateConverter.CoordType.BAIDU.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.amap.api.location.CoordinateConverter.CoordType.MAPBAR.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.amap.api.location.CoordinateConverter.CoordType.MAPABC.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.amap.api.location.CoordinateConverter.CoordType.SOSOMAP.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.amap.api.location.CoordinateConverter.CoordType.ALIYUN.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.amap.api.location.CoordinateConverter.CoordType.GOOGLE.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.amap.api.location.CoordinateConverter.CoordType.GPS.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public CoordinateConverter(android.content.Context context) {
        this.j = context;
    }

    public static float calculateLineDistance(com.amap.api.location.DPoint dPoint, com.amap.api.location.DPoint dPoint2) {
        try {
            return com.loc.gd.a(dPoint, dPoint2);
        } catch (java.lang.Throwable unused) {
            return 0.0f;
        }
    }

    public static boolean isAMapDataAvailable(double d2, double d3) {
        return com.loc.fv.a(d2, d3);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0050. Please report as an issue. */
    public synchronized com.amap.api.location.DPoint convert() throws java.lang.Exception {
        int i2;
        int i3;
        com.amap.api.location.DPoint dPoint;
        if (this.k == null) {
            throw new java.lang.IllegalArgumentException("转换坐标类型不能为空");
        }
        com.amap.api.location.DPoint dPoint2 = this.l;
        if (dPoint2 == null) {
            throw new java.lang.IllegalArgumentException("转换坐标源不能为空");
        }
        if (dPoint2.getLongitude() > 180.0d || this.l.getLongitude() < -180.0d) {
            throw new java.lang.IllegalArgumentException("请传入合理经度");
        }
        if (this.l.getLatitude() > 90.0d || this.l.getLatitude() < -90.0d) {
            throw new java.lang.IllegalArgumentException("请传入合理纬度");
        }
        boolean z = true;
        java.lang.String str = null;
        switch (com.amap.api.location.CoordinateConverter.AnonymousClass1.a[this.k.ordinal()]) {
            case 1:
                this.a = com.loc.fy.a(this.l);
                i2 = b;
                i3 = c;
                if ((i2 & i3) == 0) {
                    str = com.bytedance.sdk.openadsdk.mediation.MediationConstant.ADN_BAIDU;
                    b = i2 | i3;
                    break;
                }
                z = false;
                break;
            case 2:
                this.a = com.loc.fy.b(this.j, this.l);
                i2 = b;
                i3 = d;
                if ((i2 & i3) == 0) {
                    str = "mapbar";
                    b = i2 | i3;
                    break;
                }
                z = false;
                break;
            case 3:
                int i4 = b;
                int i5 = e;
                if ((i4 & i5) == 0) {
                    str = "mapabc";
                    b = i4 | i5;
                } else {
                    z = false;
                }
                dPoint = this.l;
                this.a = dPoint;
                break;
            case 4:
                int i6 = b;
                int i7 = f;
                if ((i6 & i7) == 0) {
                    str = "sosomap";
                    b = i6 | i7;
                } else {
                    z = false;
                }
                dPoint = this.l;
                this.a = dPoint;
                break;
            case 5:
                int i8 = b;
                int i9 = g;
                if ((i8 & i9) == 0) {
                    str = "aliyun";
                    b = i8 | i9;
                } else {
                    z = false;
                }
                dPoint = this.l;
                this.a = dPoint;
                break;
            case 6:
                int i10 = b;
                int i11 = h;
                if ((i10 & i11) == 0) {
                    str = "google";
                    b = i10 | i11;
                } else {
                    z = false;
                }
                dPoint = this.l;
                this.a = dPoint;
                break;
            case 7:
                int i12 = b;
                int i13 = i;
                if ((i12 & i13) == 0) {
                    str = com.amap.api.services.geocoder.GeocodeSearch.GPS;
                    b = i12 | i13;
                } else {
                    z = false;
                }
                dPoint = com.loc.fy.a(this.j, this.l);
                this.a = dPoint;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (!android.text.TextUtils.isEmpty(str)) {
                jSONObject.put("amap_loc_coordinate", str);
            }
            com.loc.gb.a(this.j, "O021", jSONObject);
        }
        return this.a;
    }

    public synchronized com.amap.api.location.CoordinateConverter coord(com.amap.api.location.DPoint dPoint) throws java.lang.Exception {
        try {
            if (dPoint == null) {
                throw new java.lang.IllegalArgumentException("传入经纬度对象为空");
            }
            if (dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                throw new java.lang.IllegalArgumentException("请传入合理经度");
            }
            if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d) {
                throw new java.lang.IllegalArgumentException("请传入合理纬度");
            }
            this.l = dPoint;
        } catch (java.lang.Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized com.amap.api.location.CoordinateConverter from(com.amap.api.location.CoordinateConverter.CoordType coordType) {
        this.k = coordType;
        return this;
    }
}
