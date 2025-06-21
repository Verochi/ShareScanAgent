package com.jd.ad.sdk.jad_qd;

/* loaded from: classes23.dex */
public class jad_jt {

    public static class jad_an {
        public static final com.jd.ad.sdk.jad_qd.jad_jt jad_an = new com.jd.ad.sdk.jad_qd.jad_jt();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b6 A[Catch: Exception -> 0x00f9, all -> 0x0152, LOOP:0: B:52:0x009e->B:60:0x00b6, LOOP_END, TryCatch #2 {Exception -> 0x00f9, blocks: (B:39:0x0067, B:48:0x007b, B:53:0x00a0, B:55:0x00a8, B:64:0x00bc, B:66:0x00c2, B:68:0x00ca, B:70:0x00d2, B:73:0x00df, B:75:0x00e5, B:60:0x00b6), top: B:38:0x0067, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e5 A[Catch: Exception -> 0x00f9, all -> 0x0152, TRY_LEAVE, TryCatch #2 {Exception -> 0x00f9, blocks: (B:39:0x0067, B:48:0x007b, B:53:0x00a0, B:55:0x00a8, B:64:0x00bc, B:66:0x00c2, B:68:0x00ca, B:70:0x00d2, B:73:0x00df, B:75:0x00e5, B:60:0x00b6), top: B:38:0x0067, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double[] jad_an(android.content.Context context) {
        long j;
        long j2;
        java.lang.Object jad_bo;
        boolean z;
        android.location.Location location;
        java.lang.String str;
        boolean z2;
        int checkSelfPermission;
        synchronized (this) {
            if (context != null) {
                if (androidx.core.content.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.content.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    com.jd.ad.sdk.jad_pc.jad_cp jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
                    if (jad_cp != null) {
                        j = jad_cp.jad_er;
                        if (j > 0) {
                            j2 = j * 1000;
                            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                            jad_anVar.getClass();
                            jad_bo = jad_anVar.jad_bo("lastRequestLocationTime");
                            if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - ((jad_bo != null || !(jad_bo instanceof java.lang.Long)) ? -1L : ((java.lang.Long) jad_bo).longValue())) <= j2) {
                                double[] dArr = {-1.0d, -1.0d, -1.0d};
                                try {
                                    java.lang.String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
                                    android.location.LocationManager locationManager = (android.location.LocationManager) context.getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
                                    if (locationManager != null) {
                                        android.location.Criteria criteria = new android.location.Criteria();
                                        criteria.setAccuracy(1);
                                        criteria.setSpeedRequired(false);
                                        criteria.setCostAllowed(false);
                                        criteria.setBearingRequired(false);
                                        criteria.setAltitudeRequired(false);
                                        criteria.setPowerRequirement(0);
                                        java.lang.String bestProvider = locationManager.getBestProvider(criteria, true);
                                        if (!android.text.TextUtils.isEmpty(bestProvider)) {
                                            int i = 0;
                                            while (true) {
                                                if (i >= 2) {
                                                    z = true;
                                                    break;
                                                }
                                                java.lang.String str2 = strArr[i];
                                                if (android.os.Build.VERSION.SDK_INT >= 23) {
                                                    checkSelfPermission = context.checkSelfPermission(str2);
                                                    if (checkSelfPermission != 0) {
                                                        z2 = false;
                                                        if (z2) {
                                                            z = false;
                                                            break;
                                                        }
                                                        i++;
                                                    }
                                                }
                                                z2 = true;
                                                if (z2) {
                                                }
                                            }
                                            if (z) {
                                                location = !android.text.TextUtils.isEmpty(bestProvider) ? locationManager.getLastKnownLocation(bestProvider) : null;
                                                if (location == null) {
                                                    location = locationManager.getLastKnownLocation(com.amap.api.services.geocoder.GeocodeSearch.GPS);
                                                }
                                                if (location == null) {
                                                    location = locationManager.getLastKnownLocation("network");
                                                }
                                                str = location == null ? "passive" : "network";
                                                if (location != null) {
                                                    dArr[0] = location.getLatitude();
                                                    dArr[1] = location.getLongitude();
                                                    dArr[2] = location.getAccuracy();
                                                }
                                            }
                                            location = locationManager.getLastKnownLocation(str);
                                            if (location != null) {
                                            }
                                        }
                                    }
                                } catch (java.lang.Exception e) {
                                    e.printStackTrace();
                                }
                                com.jd.ad.sdk.dl.baseinfo.JADLocation jADLocation = new com.jd.ad.sdk.dl.baseinfo.JADLocation(dArr[0], dArr[1], dArr[2]);
                                if (jADLocation.isValid()) {
                                    com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("obtainLocationValue", jADLocation.toJSONObject().toString());
                                }
                                com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("lastRequestLocationTime", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                            }
                        }
                    }
                    j = com.anythink.expressad.d.a.b.aC;
                    j2 = j * 1000;
                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                    jad_anVar2.getClass();
                    jad_bo = jad_anVar2.jad_bo("lastRequestLocationTime");
                    if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - ((jad_bo != null || !(jad_bo instanceof java.lang.Long)) ? -1L : ((java.lang.Long) jad_bo).longValue())) <= j2) {
                    }
                }
            }
        }
        double[] dArr2 = com.jd.ad.sdk.jad_qd.jad_dq.jad_bo;
        java.lang.String jad_an2 = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("obtainLocationValue");
        if (android.text.TextUtils.isEmpty(jad_an2)) {
            return dArr2;
        }
        try {
            return com.jd.ad.sdk.dl.baseinfo.JADLocation.parseJSON(new org.json.JSONObject(jad_an2)).toDoubleArray();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return dArr2;
        }
    }
}
