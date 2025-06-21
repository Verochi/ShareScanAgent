package com.amap.api.fence;

/* loaded from: classes12.dex */
public class GeoFenceClient {
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_STAYED = 4;
    android.content.Context a;
    com.loc.a b;

    public GeoFenceClient(android.content.Context context) {
        this.a = null;
        this.b = null;
        try {
            if (context == null) {
                throw new java.lang.IllegalArgumentException("Context参数不能为null");
            }
            android.content.Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            this.b = a(applicationContext);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "<init>");
        }
    }

    private static com.loc.a a(android.content.Context context) {
        return new com.loc.a(context);
    }

    public void addGeoFence(com.amap.api.location.DPoint dPoint, float f, java.lang.String str) {
        try {
            this.b.a(dPoint, f, str);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "addGeoFence round");
        }
    }

    public void addGeoFence(java.lang.String str, java.lang.String str2) {
        try {
            this.b.a(str, str2);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "addGeoFence district");
        }
    }

    public void addGeoFence(java.lang.String str, java.lang.String str2, com.amap.api.location.DPoint dPoint, float f, int i, java.lang.String str3) {
        try {
            this.b.a(str, str2, dPoint, f, i, str3);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4) {
        try {
            this.b.a(str, str2, str3, i, str4);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(java.util.List<com.amap.api.location.DPoint> list, java.lang.String str) {
        try {
            this.b.a(list, str);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "addGeoFence polygon");
        }
    }

    public android.app.PendingIntent createPendingIntent(java.lang.String str) {
        try {
            return this.b.a(str);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "creatPendingIntent");
            return null;
        }
    }

    public java.util.List<com.amap.api.fence.GeoFence> getAllGeoFence() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            return this.b.b();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "getGeoFenceList");
            return arrayList;
        }
    }

    public boolean isPause() {
        try {
            return this.b.i();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "isPause");
            return true;
        }
    }

    public void pauseGeoFence() {
        try {
            this.b.f();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "pauseGeoFence");
        }
    }

    public void removeGeoFence() {
        try {
            this.b.a();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "removeGeoFence");
        }
    }

    public boolean removeGeoFence(com.amap.api.fence.GeoFence geoFence) {
        try {
            return this.b.a(geoFence);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "removeGeoFence1");
            return false;
        }
    }

    public void resumeGeoFence() {
        try {
            this.b.h();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "resumeGeoFence");
        }
    }

    public void setActivateAction(int i) {
        try {
            this.b.a(i);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "setActivatesAction");
        }
    }

    public void setGeoFenceAble(java.lang.String str, boolean z) {
        try {
            this.b.a(str, z);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "setGeoFenceAble");
        }
    }

    public void setGeoFenceListener(com.amap.api.fence.GeoFenceListener geoFenceListener) {
        try {
            this.b.a(geoFenceListener);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }

    public void setLocationClientOption(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.b.a(aMapLocationClientOption);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }
}
