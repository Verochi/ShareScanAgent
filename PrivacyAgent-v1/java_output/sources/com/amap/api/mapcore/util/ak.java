package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ak implements com.amap.api.maps.LocationSource, com.autonavi.amap.mapcore.Inner_3dMap_locationListener {
    private com.amap.api.maps.LocationSource.OnLocationChangedListener d;
    private com.amap.api.mapcore.util.eb e;
    private com.autonavi.amap.mapcore.Inner_3dMap_locationOption f;
    private android.content.Context g;
    private android.os.Bundle c = null;
    boolean a = false;
    long b = 2000;

    public ak(android.content.Context context) {
        this.g = context;
    }

    private void a(boolean z) {
        com.amap.api.mapcore.util.eb ebVar;
        if (this.f != null && (ebVar = this.e) != null) {
            ebVar.c();
            com.amap.api.mapcore.util.eb ebVar2 = new com.amap.api.mapcore.util.eb(this.g);
            this.e = ebVar2;
            ebVar2.a(this);
            this.f.setOnceLocation(z);
            this.f.setNeedAddress(false);
            if (!z) {
                this.f.setInterval(this.b);
            }
            this.e.a(this.f);
            this.e.a();
        }
        this.a = z;
    }

    public final void a(int i) {
        if (i == 1 || i == 0) {
            a(true);
        } else {
            a(false);
        }
    }

    public final void a(long j) {
        com.autonavi.amap.mapcore.Inner_3dMap_locationOption inner_3dMap_locationOption = this.f;
        if (inner_3dMap_locationOption != null && this.e != null && inner_3dMap_locationOption.getInterval() != j) {
            this.f.setInterval(j);
            this.e.a(this.f);
        }
        this.b = j;
    }

    @Override // com.amap.api.maps.LocationSource
    public final void activate(com.amap.api.maps.LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.d = onLocationChangedListener;
        if (com.amap.api.mapcore.util.fe.a(this.g, com.amap.api.mapcore.util.dl.a()).a == com.amap.api.mapcore.util.fe.c.SuccessCode && this.e == null) {
            this.e = new com.amap.api.mapcore.util.eb(this.g);
            this.f = new com.autonavi.amap.mapcore.Inner_3dMap_locationOption();
            this.e.a(this);
            this.f.setInterval(this.b);
            this.f.setOnceLocation(this.a);
            this.f.setLocationMode(com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy);
            this.f.setNeedAddress(false);
            this.e.a(this.f);
            this.e.a();
        }
    }

    @Override // com.amap.api.maps.LocationSource
    public final void deactivate() {
        this.d = null;
        com.amap.api.mapcore.util.eb ebVar = this.e;
        if (ebVar != null) {
            ebVar.b();
            this.e.c();
        }
        this.e = null;
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationListener
    public final void onLocationChanged(com.autonavi.amap.mapcore.Inner_3dMap_location inner_3dMap_location) {
        try {
            if (this.d == null || inner_3dMap_location == null) {
                return;
            }
            android.os.Bundle extras = inner_3dMap_location.getExtras();
            this.c = extras;
            if (extras == null) {
                this.c = new android.os.Bundle();
            }
            this.c.putInt("errorCode", inner_3dMap_location.getErrorCode());
            this.c.putString(com.amap.api.maps.model.MyLocationStyle.ERROR_INFO, inner_3dMap_location.getErrorInfo());
            this.c.putInt(com.amap.api.maps.model.MyLocationStyle.LOCATION_TYPE, inner_3dMap_location.getLocationType());
            this.c.putFloat("Accuracy", inner_3dMap_location.getAccuracy());
            this.c.putString("AdCode", inner_3dMap_location.getAdCode());
            this.c.putString("Address", inner_3dMap_location.getAddress());
            this.c.putString("AoiName", inner_3dMap_location.getAoiName());
            this.c.putString("City", inner_3dMap_location.getCity());
            this.c.putString("CityCode", inner_3dMap_location.getCityCode());
            this.c.putString("Country", inner_3dMap_location.getCountry());
            this.c.putString("District", inner_3dMap_location.getDistrict());
            this.c.putString("Street", inner_3dMap_location.getStreet());
            this.c.putString("StreetNum", inner_3dMap_location.getStreetNum());
            this.c.putString("PoiName", inner_3dMap_location.getPoiName());
            this.c.putString("Province", inner_3dMap_location.getProvince());
            this.c.putFloat("Speed", inner_3dMap_location.getSpeed());
            this.c.putString("Floor", inner_3dMap_location.getFloor());
            this.c.putFloat("Bearing", inner_3dMap_location.getBearing());
            this.c.putString("BuildingId", inner_3dMap_location.getBuildingId());
            this.c.putDouble("Altitude", inner_3dMap_location.getAltitude());
            inner_3dMap_location.setExtras(this.c);
            this.d.onLocationChanged(inner_3dMap_location);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
