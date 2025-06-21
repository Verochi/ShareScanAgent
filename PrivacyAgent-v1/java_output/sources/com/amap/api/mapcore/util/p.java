package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class p implements com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate {
    public static volatile android.content.Context a;
    private static java.lang.String f;
    public int b = 0;
    boolean c = true;
    private com.autonavi.amap.mapcore.interfaces.IAMap d;
    private int e;
    private com.amap.api.maps.AMapOptions g;

    public p(int i) {
        this.e = 0;
        this.e = i % 3;
        b();
    }

    private static void a() {
        try {
            java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i = 0; i < stackTrace.length; i++) {
                if (stackTrace[i].getClassName() != null && stackTrace[i].getClassName().endsWith("TextureMapView")) {
                    z2 = true;
                }
                if (stackTrace[i].getClassName() != null && stackTrace[i].getClassName().endsWith(com.baidu.mobads.sdk.internal.a.c.e)) {
                    z = true;
                }
                if ("OnDestroyView".equalsIgnoreCase(stackTrace[i].getMethodName())) {
                    z3 = true;
                }
            }
            if (z && z2 && !z3) {
                c();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(android.content.Context context) {
        if (context != null) {
            a = context.getApplicationContext();
        }
    }

    private void a(com.amap.api.maps.AMapOptions aMapOptions) throws android.os.RemoteException {
        if (aMapOptions == null || this.d == null) {
            return;
        }
        com.amap.api.maps.model.CameraPosition camera = aMapOptions.getCamera();
        if (camera != null) {
            this.d.moveCamera(com.amap.api.maps.CameraUpdateFactory.newCameraPosition(camera));
        }
        com.amap.api.maps.UiSettings aMapUiSettings = this.d.getAMapUiSettings();
        aMapUiSettings.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled());
        aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled());
        aMapUiSettings.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled());
        aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled());
        aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled());
        aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled());
        aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled());
        aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
        this.d.setMapType(aMapOptions.getMapType());
        this.d.setZOrderOnTop(aMapOptions.getZOrderOnTop());
    }

    private static void b() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i = 0; i < 80; i++) {
                sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            }
            f = sb.toString();
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void c() {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final com.autonavi.amap.mapcore.interfaces.IAMap getMap() throws android.os.RemoteException {
        if (this.d == null) {
            if (a == null) {
                return null;
            }
            int i = a.getResources().getDisplayMetrics().densityDpi;
            if (i <= 120) {
                com.amap.api.mapcore.util.l.a = 0.5f;
            } else if (i <= 160) {
                com.amap.api.mapcore.util.l.a = 0.8f;
            } else if (i <= 240) {
                com.amap.api.mapcore.util.l.a = 0.87f;
            } else if (i <= 320) {
                com.amap.api.mapcore.util.l.a = 1.0f;
            } else if (i <= 480) {
                com.amap.api.mapcore.util.l.a = 1.5f;
            } else if (i <= 640) {
                com.amap.api.mapcore.util.l.a = 1.8f;
            } else {
                com.amap.api.mapcore.util.l.a = 0.9f;
            }
            int i2 = this.e;
            if (i2 == 0) {
                this.d = new com.amap.api.mapcore.util.d(a, this.c).a();
            } else if (i2 == 1) {
                this.d = new com.amap.api.mapcore.util.e(a, this.c).a();
            } else {
                this.d = new com.amap.api.mapcore.util.c(a).a();
            }
        }
        return this.d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final boolean isReady() throws android.os.RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void loadWorldVectorMap(boolean z) {
        this.c = z;
        com.autonavi.amap.mapcore.interfaces.IAMap iAMap = this.d;
        if (iAMap != null) {
            iAMap.loadWorldVectorMap(z);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onCreate(android.os.Bundle bundle) throws android.os.RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) throws android.os.RemoteException {
        byte[] byteArray;
        if (a == null && layoutInflater != null) {
            setContext(layoutInflater.getContext().getApplicationContext());
        }
        try {
            com.autonavi.amap.mapcore.interfaces.IAMap map = getMap();
            this.d = map;
            map.setVisibilityEx(this.b);
            if (this.g == null && bundle != null && (byteArray = bundle.getByteArray("MAP_OPTIONS")) != null) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.g = com.amap.api.maps.AMapOptions.CREATOR.createFromParcel(obtain);
            }
            a(this.g);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return this.d.getView();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onDestroy() throws android.os.RemoteException {
        a();
        com.autonavi.amap.mapcore.interfaces.IAMap iAMap = this.d;
        if (iAMap != null) {
            iAMap.clear();
            this.d.destroy();
            this.d = null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onDestroyView() throws android.os.RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onInflate(android.app.Activity activity, com.amap.api.maps.AMapOptions aMapOptions, android.os.Bundle bundle) throws android.os.RemoteException {
        setContext(activity.getApplicationContext());
        this.g = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onLowMemory() throws android.os.RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onPause() throws android.os.RemoteException {
        com.autonavi.amap.mapcore.interfaces.IAMap iAMap = this.d;
        if (iAMap != null) {
            iAMap.onActivityPause();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onResume() throws android.os.RemoteException {
        com.autonavi.amap.mapcore.interfaces.IAMap iAMap = this.d;
        if (iAMap != null) {
            iAMap.onActivityResume();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onSaveInstanceState(android.os.Bundle bundle) throws android.os.RemoteException {
        if (this.d != null) {
            if (this.g == null) {
                this.g = new com.amap.api.maps.AMapOptions();
            }
            try {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                com.amap.api.maps.AMapOptions camera = this.g.camera(getMap().getCameraPosition());
                this.g = camera;
                camera.writeToParcel(obtain, 0);
                bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setContext(android.content.Context context) {
        a(context);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setOptions(com.amap.api.maps.AMapOptions aMapOptions) {
        this.g = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setVisibility(int i) {
        this.b = i;
        com.autonavi.amap.mapcore.interfaces.IAMap iAMap = this.d;
        if (iAMap != null) {
            iAMap.setVisibilityEx(i);
        }
    }
}
