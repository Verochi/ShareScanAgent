package com.loc;

/* loaded from: classes23.dex */
public final class fv {
    public static java.lang.String a = "5.3";
    static java.lang.String l;
    static java.util.HashMap<java.lang.String, java.lang.String> m;
    public static final java.lang.String[] b = {"5.1"};
    static java.lang.String c = "http://apilocate.amap.com/mobile/binary";
    static java.lang.String d = "http://dualstack-a.apilocate.amap.com/mobile/binary";
    static java.lang.String e = "";
    private static final java.lang.String[] p = {"com.amap.api.location", "com.loc", "com.amap.api.fence"};
    static java.lang.String f = "11G;11K;13J;13S;15O;15U;17J;17Y;197;1A6";
    public static java.lang.String g = null;
    public static java.lang.String h = null;
    public static int i = 30000;
    public static java.lang.String j = null;
    public static java.lang.String k = null;
    private static com.loc.x q = null;
    private static boolean r = false;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f411s = false;
    static boolean n = false;
    static boolean o = false;

    public static android.os.Bundle a(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        android.os.Bundle bundle = new android.os.Bundle();
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new com.amap.api.location.AMapLocationClientOption();
        }
        try {
            bundle.putParcelable("opt", aMapLocationClientOption);
        } catch (java.lang.Throwable th) {
            a(th, "CoreUtil", "getOptionBundle");
        }
        return bundle;
    }

    public static com.amap.api.location.AMapLocation a(com.amap.api.location.AMapLocation aMapLocation, com.amap.api.location.AMapLocation aMapLocation2) {
        if (aMapLocation2 == null) {
            return aMapLocation;
        }
        try {
            aMapLocation.setCountry(aMapLocation2.getCountry());
            aMapLocation.setRoad(aMapLocation2.getRoad());
            aMapLocation.setPoiName(aMapLocation2.getPoiName());
            aMapLocation.setStreet(aMapLocation2.getStreet());
            aMapLocation.setNumber(aMapLocation2.getStreetNum());
            java.lang.String cityCode = aMapLocation2.getCityCode();
            java.lang.String adCode = aMapLocation2.getAdCode();
            aMapLocation.setCityCode(cityCode);
            aMapLocation.setAdCode(adCode);
            aMapLocation.setCity(aMapLocation2.getCity());
            aMapLocation.setDistrict(aMapLocation2.getDistrict());
            aMapLocation.setProvince(aMapLocation2.getProvince());
            aMapLocation.setAoiName(aMapLocation2.getAoiName());
            aMapLocation.setAddress(aMapLocation2.getAddress());
            aMapLocation.setDescription(aMapLocation2.getDescription());
            if (aMapLocation.getExtras() != null) {
                aMapLocation.getExtras().putString("citycode", aMapLocation2.getCityCode());
                aMapLocation.getExtras().putString("desc", aMapLocation2.getExtras().getString("desc"));
                aMapLocation.getExtras().putString("adcode", aMapLocation2.getAdCode());
            } else {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("citycode", aMapLocation2.getCityCode());
                bundle.putString("desc", aMapLocation2.getExtras().getString("desc"));
                bundle.putString("adcode", aMapLocation2.getAdCode());
                aMapLocation.setExtras(bundle);
            }
        } catch (java.lang.Throwable unused) {
        }
        return aMapLocation;
    }

    public static com.amap.api.location.AMapLocationClientOption a(android.os.Bundle bundle) {
        com.amap.api.location.AMapLocationClientOption aMapLocationClientOption = new com.amap.api.location.AMapLocationClientOption();
        if (bundle == null) {
            return aMapLocationClientOption;
        }
        try {
            bundle.setClassLoader(com.amap.api.location.AMapLocationClientOption.class.getClassLoader());
            return (com.amap.api.location.AMapLocationClientOption) bundle.getParcelable("opt");
        } catch (java.lang.Throwable th) {
            a(th, "CoreUtil", "getOptionFromBundle");
            return aMapLocationClientOption;
        }
    }

    public static java.lang.String a() {
        return c;
    }

    public static void a(android.content.Context context) {
        try {
            if (com.loc.y.b(context)) {
                c = "http://abroad.apilocate.amap.com/mobile/binary";
                return;
            }
            f();
            java.lang.String a2 = com.loc.fk.a(com.loc.m.f(context));
            l = a2;
            a(a2);
        } catch (java.lang.Throwable th) {
            a(th, "CoreUtil", "checkUrl");
        }
    }

    public static void a(com.amap.api.location.AMapLocation aMapLocation, org.json.JSONObject jSONObject) {
        java.lang.String str;
        if (jSONObject != null) {
            try {
                double optDouble = jSONObject.optDouble("lat", aMapLocation.getLatitude());
                double optDouble2 = jSONObject.optDouble(com.anythink.core.common.h.c.C, aMapLocation.getLongitude());
                aMapLocation.setProvider(jSONObject.optString(com.umeng.analytics.pro.f.M, aMapLocation.getProvider()));
                aMapLocation.setLatitude(optDouble);
                aMapLocation.setLongitude(optDouble2);
                aMapLocation.setAltitude(jSONObject.optDouble("altitude", aMapLocation.getAltitude()));
                try {
                    java.lang.String optString = jSONObject.optString("accuracy");
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        aMapLocation.setAccuracy(java.lang.Float.parseFloat(optString));
                    }
                } catch (java.lang.Throwable unused) {
                }
                try {
                    java.lang.String optString2 = jSONObject.optString("speed");
                    if (!android.text.TextUtils.isEmpty(optString2)) {
                        aMapLocation.setSpeed(java.lang.Float.parseFloat(optString2));
                    }
                } catch (java.lang.Throwable unused2) {
                }
                try {
                    java.lang.String optString3 = jSONObject.optString("bearing");
                    if (!android.text.TextUtils.isEmpty(optString3)) {
                        aMapLocation.setBearing(java.lang.Float.parseFloat(optString3));
                    }
                } catch (java.lang.Throwable unused3) {
                }
                aMapLocation.setAdCode(jSONObject.optString("adcode", aMapLocation.getAdCode()));
                aMapLocation.setCityCode(jSONObject.optString("citycode", aMapLocation.getCityCode()));
                aMapLocation.setAddress(jSONObject.optString("address", aMapLocation.getAddress()));
                java.lang.String optString4 = jSONObject.optString("desc", "");
                aMapLocation.setCountry(jSONObject.optString("country", aMapLocation.getCountry()));
                aMapLocation.setProvince(jSONObject.optString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince()));
                aMapLocation.setCity(jSONObject.optString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, aMapLocation.getCity()));
                aMapLocation.setDistrict(jSONObject.optString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict()));
                aMapLocation.setRoad(jSONObject.optString("road", aMapLocation.getRoad()));
                aMapLocation.setStreet(jSONObject.optString("street", aMapLocation.getStreet()));
                aMapLocation.setNumber(jSONObject.optString("number", aMapLocation.getStreetNum()));
                aMapLocation.setPoiName(jSONObject.optString("poiname", aMapLocation.getPoiName()));
                aMapLocation.setAoiName(jSONObject.optString("aoiname", aMapLocation.getAoiName()));
                aMapLocation.setErrorCode(jSONObject.optInt("errorCode", aMapLocation.getErrorCode()));
                aMapLocation.setErrorInfo(jSONObject.optString(com.amap.api.maps.model.MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo()));
                aMapLocation.setLocationType(jSONObject.optInt(com.amap.api.maps.model.MyLocationStyle.LOCATION_TYPE, aMapLocation.getLocationType()));
                aMapLocation.setLocationDetail(jSONObject.optString("locationDetail", aMapLocation.getLocationDetail()));
                aMapLocation.setTime(jSONObject.optLong("time", aMapLocation.getTime()));
                boolean optBoolean = jSONObject.optBoolean("isOffset", aMapLocation.isOffset());
                aMapLocation.setOffset(optBoolean);
                aMapLocation.setBuildingId(jSONObject.optString("poiid", aMapLocation.getBuildingId()));
                aMapLocation.setFloor(jSONObject.optString("floor", aMapLocation.getFloor()));
                aMapLocation.setDescription(jSONObject.optString("description", aMapLocation.getDescription()));
                if (jSONObject.has("coordType")) {
                    str = jSONObject.optString("coordType", "GCJ02");
                } else {
                    if (a(optDouble, optDouble2) && optBoolean) {
                        aMapLocation.setCoordType("GCJ02");
                        android.os.Bundle bundle = new android.os.Bundle();
                        bundle.putString("citycode", aMapLocation.getCityCode());
                        bundle.putString("desc", optString4.toString());
                        bundle.putString("adcode", aMapLocation.getAdCode());
                        aMapLocation.setExtras(bundle);
                    }
                    str = "WGS84";
                }
                aMapLocation.setCoordType(str);
                android.os.Bundle bundle2 = new android.os.Bundle();
                bundle2.putString("citycode", aMapLocation.getCityCode());
                bundle2.putString("desc", optString4.toString());
                bundle2.putString("adcode", aMapLocation.getAdCode());
                aMapLocation.setExtras(bundle2);
            } catch (java.lang.Throwable th) {
                a(th, "CoreUtil", "transformLocation");
            }
        }
    }

    private static void a(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap;
        if (str != null) {
            try {
                if (str.length() == 0 || (hashMap = m) == null || !hashMap.containsKey(str)) {
                    return;
                }
                java.lang.String str2 = m.get(str);
                java.lang.String str3 = (str2 == null || str2.length() <= 0) ? null : new java.lang.String(com.loc.fk.b(b(str2), str), "utf-8");
                if (str3 == null || str3.length() <= 0 || !str3.contains("http:")) {
                    return;
                }
                e = str3;
                c = str3;
            } catch (java.lang.Throwable th) {
                a(th, "CoreUtil", "checkUrl");
            }
        }
    }

    public static void a(java.lang.Throwable th, java.lang.String str, java.lang.String str2) {
        if ("reportError".equals(str2) || (th instanceof com.loc.l)) {
            return;
        }
        try {
            com.loc.aw.b(th, str, str2);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static boolean a(double d2, double d3) {
        int i2 = (int) ((d3 - 73.0d) / 0.5d);
        int i3 = (int) ((d2 - 3.5d) / 0.5d);
        if (i3 < 0 || i3 >= 101 || i2 < 0 || i2 >= 124) {
            return false;
        }
        try {
            return "00000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000001011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011010111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100110001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100000000000010111110100000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000001111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111000000111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111101111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000101111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000011110000000001111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000011000011111100000000111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000001111111100111111111100110111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000101111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011100000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110011111110000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111110000000000000000000000111011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000011111111111111111111111111111111111111111111111100001111111111111111111111111111111111111111111111111010000000000000000000000111111111111111111111111111111111111111111110000000000000001111111111111111111111111111111111111111111100000000000000000000011111111111111111111111111111111100000000000000000000000000001111111111111111111111111111111111111111110000000000000000000001111111111111111111111111111111100000000000000000000000000000001111111111111111111111111111111111111111000000000000000000000111111111111111111111111111111110000000000000000000000000000001111111111111111111111111111111111111111100000000000000000000111111111111111111111111111111000000000000000000000000000000000111111111111111111111111111111111111111111000000000000000000001111111111111111111111111110000000000000000000000000000000000001110011111111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000001111111111111111111111111111111111111000000000000000000001111111111111111111000000000000000000000000000000000000000000000000011111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000000011111111111111111111111111111111111000000000000000000001111111111111111100000000000000000000000000000000000000000000000000000000111111111111111111111111111111110000000000000000000000000111111111100000000000000000000000000000000000000000000000000111111111111111111111111111111111111111000000000000000000000000011111111100000000000000000000000000000000000000000000000000011111111111111111111111111111110001111100000000000000000000000000111110000000000000000000000000000000000000000000000000000001111111111111111111111111111111000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000011111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010110000000000000000000000".charAt((i3 * 124) + i2) == '1';
        } catch (java.lang.Throwable th) {
            a(th, "CoreUtil", "isChina");
            return true;
        }
    }

    private static boolean a(double d2, double d3, double d4, double d5, double d6, double d7) {
        return java.lang.Math.abs(b(d2, d3, d4, d5, d6, d7)) < 1.0E-9d && (d2 - d4) * (d2 - d6) <= 0.0d && (d3 - d5) * (d3 - d7) <= 0.0d;
    }

    private static boolean a(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d4 - d2;
        double d10 = d8 - d7;
        double d11 = d5 - d3;
        double d12 = 180.0d - d6;
        double d13 = (d9 * d10) - (d11 * d12);
        if (d13 != 0.0d) {
            double d14 = d3 - d7;
            double d15 = d2 - d6;
            double d16 = ((d12 * d14) - (d10 * d15)) / d13;
            double d17 = ((d14 * d9) - (d15 * d11)) / d13;
            if (d16 >= 0.0d && d16 <= 1.0d && d17 >= 0.0d && d17 <= 1.0d) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x009a, code lost:
    
        if (r25 > r29) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x009c, code lost:
    
        r22 = r22 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b9, code lost:
    
        if (r29 > r25) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(com.amap.api.location.DPoint dPoint, java.util.List<com.amap.api.location.DPoint> list) {
        int i2;
        double longitude = dPoint.getLongitude();
        double latitude = dPoint.getLatitude();
        double latitude2 = dPoint.getLatitude();
        if (!list.get(0).equals(list.get(list.size() - 1))) {
            list.add(list.get(0));
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < list.size() - 1) {
            double longitude2 = list.get(i3).getLongitude();
            double latitude3 = list.get(i3).getLatitude();
            int i5 = i3 + 1;
            double longitude3 = list.get(i5).getLongitude();
            double latitude4 = list.get(i5).getLatitude();
            if (a(longitude, latitude, longitude2, latitude3, longitude3, latitude4)) {
                return true;
            }
            if (java.lang.Math.abs(latitude4 - latitude3) >= 1.0E-9d) {
                if (!a(longitude2, latitude3, longitude, latitude, 180.0d, latitude2)) {
                    if (!a(longitude3, latitude4, longitude, latitude, 180.0d, latitude2)) {
                        i2 = i5;
                        if (a(longitude2, latitude3, longitude3, latitude4, longitude, latitude, latitude2)) {
                            i4++;
                        }
                    }
                }
                i3 = i2;
            }
            i2 = i5;
            i3 = i2;
        }
        return i4 % 2 != 0;
    }

    private static double b(double d2, double d3, double d4, double d5, double d6, double d7) {
        return ((d4 - d2) * (d7 - d3)) - ((d6 - d2) * (d5 - d3));
    }

    public static java.lang.String b() {
        return d;
    }

    public static java.lang.String b(android.content.Context context) {
        return com.loc.t.a(com.loc.m.e(context));
    }

    private static byte[] b(java.lang.String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.US);
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (com.loc.gd.f(lowerCase.substring(i3, i3 + 2)) & 255);
        }
        return bArr;
    }

    public static com.loc.x c() {
        try {
            if (q == null) {
                q = new com.loc.x.a("loc", "6.4.5", "AMAP_Location_SDK_Android 6.4.5").a(e()).a("6.4.5").a();
            }
        } catch (java.lang.Throwable th) {
            a(th, "CoreUtil", "getSDKInfo");
        }
        return q;
    }

    public static void c(android.content.Context context) {
        try {
            if (com.loc.y.b(context)) {
                c = "http://abroad.apilocate.amap.com/mobile/binary";
                d = "http://abroad.apilocate.amap.com/mobile/binary";
            } else {
                c = "http://apilocate.amap.com/mobile/binary";
                d = "http://dualstack-a.apilocate.amap.com/mobile/binary";
            }
        } catch (java.lang.Throwable th) {
            a(th, "CoreUtil", "changeUrl");
        }
    }

    public static java.lang.String d() {
        return f;
    }

    private static java.lang.String[] e() {
        return (java.lang.String[]) p.clone();
    }

    private static void f() {
        try {
            if (m == null) {
                m = new java.util.HashMap<>(16);
            }
            m.clear();
            m.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");
            m.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");
            m.put("668319f11506def6208d6afe320dfd52", "53E53D46011A6BBAEA4FAE5442E659E0577CDD336F930C28635C322FB3F51C3C63F7FBAC9EAE448DFA2E5E5D716C4807");
        } catch (java.lang.Throwable th) {
            a(th, "CoreUtil", "initUrlHash");
        }
    }
}
