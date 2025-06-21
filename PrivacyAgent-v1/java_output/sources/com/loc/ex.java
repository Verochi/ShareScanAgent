package com.loc;

/* loaded from: classes23.dex */
public final class ex {
    com.loc.ey a = null;
    long b = 0;
    long c = 0;
    private boolean h = true;
    int d = 0;
    long e = 0;
    com.amap.api.location.AMapLocation f = null;
    long g = 0;

    private com.loc.ey b(com.loc.ey eyVar) {
        int i;
        if (com.loc.gd.a(eyVar)) {
            if (!this.h || !com.loc.fu.a(eyVar.getTime())) {
                i = this.d;
            } else if (eyVar.getLocationType() == 5 || eyVar.getLocationType() == 6) {
                i = 4;
            }
            eyVar.setLocationType(i);
        }
        return eyVar;
    }

    public final com.amap.api.location.AMapLocation a(com.amap.api.location.AMapLocation aMapLocation) {
        if (!com.loc.gd.a(aMapLocation)) {
            return aMapLocation;
        }
        long b = com.loc.gd.b() - this.g;
        this.g = com.loc.gd.b();
        if (b > 5000) {
            return aMapLocation;
        }
        com.amap.api.location.AMapLocation aMapLocation2 = this.f;
        if (aMapLocation2 == null) {
            this.f = aMapLocation;
            return aMapLocation;
        }
        if (1 != aMapLocation2.getLocationType() && !com.amap.api.services.geocoder.GeocodeSearch.GPS.equalsIgnoreCase(this.f.getProvider())) {
            this.f = aMapLocation;
            return aMapLocation;
        }
        if (this.f.getAltitude() == aMapLocation.getAltitude() && this.f.getLongitude() == aMapLocation.getLongitude()) {
            this.f = aMapLocation;
            return aMapLocation;
        }
        long abs = java.lang.Math.abs(aMapLocation.getTime() - this.f.getTime());
        if (30000 < abs) {
            this.f = aMapLocation;
            return aMapLocation;
        }
        if (com.loc.gd.a(aMapLocation, this.f) > (((this.f.getSpeed() + aMapLocation.getSpeed()) * abs) / 2000.0f) + ((this.f.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
            return this.f;
        }
        this.f = aMapLocation;
        return aMapLocation;
    }

    public final com.loc.ey a(com.loc.ey eyVar) {
        if (com.loc.gd.b() - this.e > 30000) {
            this.a = eyVar;
            this.e = com.loc.gd.b();
            return this.a;
        }
        this.e = com.loc.gd.b();
        if (!com.loc.gd.a(this.a) || !com.loc.gd.a(eyVar)) {
            this.b = com.loc.gd.b();
            this.a = eyVar;
            return eyVar;
        }
        if (eyVar.getTime() == this.a.getTime() && eyVar.getAccuracy() < 300.0f) {
            return eyVar;
        }
        if (com.amap.api.services.geocoder.GeocodeSearch.GPS.equals(eyVar.getProvider())) {
            this.b = com.loc.gd.b();
            this.a = eyVar;
            return eyVar;
        }
        if (eyVar.c() != this.a.c()) {
            this.b = com.loc.gd.b();
            this.a = eyVar;
            return eyVar;
        }
        if (eyVar.getBuildingId() != null && !eyVar.getBuildingId().equals(this.a.getBuildingId()) && !android.text.TextUtils.isEmpty(eyVar.getBuildingId())) {
            this.b = com.loc.gd.b();
            this.a = eyVar;
            return eyVar;
        }
        this.d = eyVar.getLocationType();
        float a = com.loc.gd.a(eyVar, this.a);
        float accuracy = this.a.getAccuracy();
        float accuracy2 = eyVar.getAccuracy();
        float f = accuracy2 - accuracy;
        long b = com.loc.gd.b();
        long j = b - this.b;
        boolean z = accuracy <= 100.0f && accuracy2 > 299.0f;
        boolean z2 = accuracy > 299.0f && accuracy2 > 299.0f;
        if (z || z2) {
            long j2 = this.c;
            if (j2 == 0) {
                this.c = b;
            } else if (b - j2 > 30000) {
                this.b = b;
                this.a = eyVar;
                this.c = 0L;
                return eyVar;
            }
            com.loc.ey b2 = b(this.a);
            this.a = b2;
            return b2;
        }
        if (accuracy2 < 100.0f && accuracy > 299.0f) {
            this.b = b;
            this.a = eyVar;
            this.c = 0L;
            return eyVar;
        }
        if (accuracy2 <= 299.0f) {
            this.c = 0L;
        }
        if (a >= 10.0f || a <= 0.1d || accuracy2 <= 5.0f) {
            if (f < 300.0f) {
                this.b = com.loc.gd.b();
                this.a = eyVar;
                return eyVar;
            }
            if (j >= 30000) {
                this.b = com.loc.gd.b();
                this.a = eyVar;
                return eyVar;
            }
            com.loc.ey b3 = b(this.a);
            this.a = b3;
            return b3;
        }
        if (f >= -300.0f) {
            com.loc.ey b4 = b(this.a);
            this.a = b4;
            return b4;
        }
        if (accuracy / accuracy2 >= 2.0f) {
            this.b = b;
            this.a = eyVar;
            return eyVar;
        }
        com.loc.ey b5 = b(this.a);
        this.a = b5;
        return b5;
    }

    public final void a() {
        this.a = null;
        this.b = 0L;
        this.c = 0L;
        this.f = null;
        this.g = 0L;
    }

    public final void a(boolean z) {
        this.h = z;
    }
}
