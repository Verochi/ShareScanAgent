package com.amap.api.maps;

/* loaded from: classes12.dex */
public interface LocationSource {

    public interface OnLocationChangedListener {
        void onLocationChanged(android.location.Location location);
    }

    void activate(com.amap.api.maps.LocationSource.OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
