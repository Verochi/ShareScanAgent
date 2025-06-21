package com.amap.api.location;

/* loaded from: classes12.dex */
public class UmidtokenInfo {
    private static com.amap.api.location.AMapLocationClient d;
    static android.os.Handler a = new android.os.Handler();
    static java.lang.String b = null;
    private static long e = 30000;
    static boolean c = true;

    /* renamed from: com.amap.api.location.UmidtokenInfo$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.amap.api.location.UmidtokenInfo.d != null) {
                    com.amap.api.location.UmidtokenInfo.d.onDestroy();
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "UmidListener", "postDelayed");
            }
        }
    }

    public static class a implements com.amap.api.location.AMapLocationListener {
        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(com.amap.api.location.AMapLocation aMapLocation) {
            try {
                if (com.amap.api.location.UmidtokenInfo.d != null) {
                    com.amap.api.location.UmidtokenInfo.a.removeCallbacksAndMessages(null);
                    com.amap.api.location.UmidtokenInfo.d.onDestroy();
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "UmidListener", "onLocationChanged");
            }
        }
    }

    public static java.lang.String getUmidtoken() {
        return b;
    }

    public static void setLocAble(boolean z) {
        c = z;
    }

    public static synchronized void setUmidtoken(android.content.Context context, java.lang.String str) {
        synchronized (com.amap.api.location.UmidtokenInfo.class) {
            try {
                b = str;
                com.loc.p.a(str);
                if (d == null && c) {
                    com.amap.api.location.UmidtokenInfo.a aVar = new com.amap.api.location.UmidtokenInfo.a();
                    d = new com.amap.api.location.AMapLocationClient(context);
                    com.amap.api.location.AMapLocationClientOption aMapLocationClientOption = new com.amap.api.location.AMapLocationClientOption();
                    aMapLocationClientOption.setOnceLocation(true);
                    aMapLocationClientOption.setNeedAddress(false);
                    d.setLocationOption(aMapLocationClientOption);
                    d.setLocationListener(aVar);
                    d.startLocation();
                    a.postDelayed(new com.amap.api.location.UmidtokenInfo.AnonymousClass1(), 30000L);
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "UmidListener", "setUmidtoken");
            }
        }
    }
}
