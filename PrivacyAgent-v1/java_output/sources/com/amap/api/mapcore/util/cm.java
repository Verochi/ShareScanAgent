package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class cm {
    public static final int[][] a = {new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, new int[]{12}, new int[]{1}, new int[]{13}, new int[]{14}, new int[]{15, 16}, new int[]{17, 18, 19, 20, 21, 26, 27, 28}, new int[]{22, 23}, new int[]{24, 25}, new int[]{39, 40, 41}, new int[]{29, 30, 31}, new int[]{32, 33, 34, 35, 36, 37, 38}};
    public static final java.lang.String[] b = {"land", "water", "green", "building", "highway", "arterial", "local", "railway", "subway", "boundary", "poilabel", "districtlable"};
    public static final java.lang.String[][] c = {new java.lang.String[]{"land", "edu", "public", com.umeng.analytics.pro.f.F, "scenicSpot", "culture", "health", "sports", "business", "parkingLot", "subway"}, new java.lang.String[]{"water"}, new java.lang.String[]{"green"}, new java.lang.String[]{"buildings"}, new java.lang.String[]{"highWay"}, new java.lang.String[]{"ringRoad", "nationalRoad"}, new java.lang.String[]{"provincialRoad", "secondaryRoad", "levelThreeRoad", "levelFourRoad", "roadsBeingBuilt", "overPass", "underPass", "other"}, new java.lang.String[]{"railway", "highSpeedRailway"}, new java.lang.String[]{"subwayline", "subwayBeingBuilt"}, new java.lang.String[]{"China", "foreign", "provincial"}, new java.lang.String[]{"guideBoards", "pois", "aois"}, new java.lang.String[]{"continent", "country", com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_DISTRICT, "town", "village"}};
    public static final java.lang.String[] d = {"regions", "water", "regions", "buildings", "roads", "roads", "roads", "roads", "roads", "borders", "labels", "labels"};

    public static java.lang.String[] a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        while (true) {
            java.lang.String[] strArr = b;
            if (i >= strArr.length) {
                i = -1;
                break;
            }
            if (strArr[i].equals(str)) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return c[i];
        }
        return null;
    }

    public static java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        while (true) {
            java.lang.String[] strArr = b;
            if (i >= strArr.length) {
                i = -1;
                break;
            }
            if (strArr[i].equals(str)) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return d[i];
        }
        return null;
    }
}
