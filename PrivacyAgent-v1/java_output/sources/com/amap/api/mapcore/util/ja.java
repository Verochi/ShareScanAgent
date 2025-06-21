package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ja {
    private static com.amap.api.mapcore.util.ja b;
    private com.amap.api.mapcore.util.je c = null;
    private long d = 0;
    private long e = 0;
    long a = 0;

    private ja() {
    }

    public static synchronized com.amap.api.mapcore.util.ja a() {
        com.amap.api.mapcore.util.ja jaVar;
        synchronized (com.amap.api.mapcore.util.ja.class) {
            if (b == null) {
                b = new com.amap.api.mapcore.util.ja();
            }
            jaVar = b;
        }
        return jaVar;
    }

    public final com.amap.api.mapcore.util.je a(com.amap.api.mapcore.util.je jeVar) {
        if (com.amap.api.mapcore.util.ix.b() - this.a > 30000) {
            this.c = jeVar;
            this.a = com.amap.api.mapcore.util.ix.b();
            return this.c;
        }
        this.a = com.amap.api.mapcore.util.ix.b();
        if (!com.amap.api.mapcore.util.ji.a(this.c) || !com.amap.api.mapcore.util.ji.a(jeVar)) {
            this.d = com.amap.api.mapcore.util.ix.b();
            this.c = jeVar;
            return jeVar;
        }
        if (jeVar.getTime() == this.c.getTime() && jeVar.getAccuracy() < 300.0f) {
            return jeVar;
        }
        if (jeVar.getProvider().equalsIgnoreCase(com.amap.api.services.geocoder.GeocodeSearch.GPS)) {
            this.d = com.amap.api.mapcore.util.ix.b();
            this.c = jeVar;
            return jeVar;
        }
        if (jeVar.c() != this.c.c()) {
            this.d = com.amap.api.mapcore.util.ix.b();
            this.c = jeVar;
            return jeVar;
        }
        if (!jeVar.getBuildingId().equals(this.c.getBuildingId()) && !android.text.TextUtils.isEmpty(jeVar.getBuildingId())) {
            this.d = com.amap.api.mapcore.util.ix.b();
            this.c = jeVar;
            return jeVar;
        }
        float a = com.amap.api.mapcore.util.ix.a(new double[]{jeVar.getLatitude(), jeVar.getLongitude(), this.c.getLatitude(), this.c.getLongitude()});
        float accuracy = this.c.getAccuracy();
        float accuracy2 = jeVar.getAccuracy();
        float f = accuracy2 - accuracy;
        long b2 = com.amap.api.mapcore.util.ix.b();
        long j = b2 - this.d;
        if ((accuracy < 101.0f && accuracy2 > 299.0f) || (accuracy > 299.0f && accuracy2 > 299.0f)) {
            long j2 = this.e;
            if (j2 == 0) {
                this.e = b2;
            } else if (b2 - j2 > 30000) {
                this.d = b2;
                this.c = jeVar;
                this.e = 0L;
                return jeVar;
            }
            return this.c;
        }
        if (accuracy2 < 101.0f && accuracy > 299.0f) {
            this.d = b2;
            this.c = jeVar;
            this.e = 0L;
            return jeVar;
        }
        if (accuracy2 <= 299.0f) {
            this.e = 0L;
        }
        if (a < 10.0f && a > 0.1d && accuracy2 > 5.0f) {
            if (f < -300.0f && accuracy / accuracy2 >= 2.0f) {
                this.d = b2;
                this.c = jeVar;
                return jeVar;
            }
            return this.c;
        }
        if (f < 300.0f) {
            this.d = com.amap.api.mapcore.util.ix.b();
            this.c = jeVar;
            return jeVar;
        }
        if (j < 30000) {
            return this.c;
        }
        this.d = com.amap.api.mapcore.util.ix.b();
        this.c = jeVar;
        return jeVar;
    }
}
