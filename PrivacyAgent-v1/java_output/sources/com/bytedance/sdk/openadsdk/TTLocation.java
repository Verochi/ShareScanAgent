package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public class TTLocation implements com.bytedance.sdk.openadsdk.LocationProvider {
    private double vw;
    private double wg;

    public TTLocation(double d, double d2) {
        this.vw = d;
        this.wg = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.vw;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.wg;
    }

    public void setLatitude(double d) {
        this.vw = d;
    }

    public void setLongitude(double d) {
        this.wg = d;
    }
}
