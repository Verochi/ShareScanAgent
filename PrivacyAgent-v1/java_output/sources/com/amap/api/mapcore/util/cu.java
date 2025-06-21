package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class cu {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public cu(double d, double d2, double d3, double d4) {
        this.a = d;
        this.b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    private boolean a(double d, double d2, double d3, double d4) {
        return d < this.c && this.a < d2 && d3 < this.d && this.b < d4;
    }

    public final boolean a(double d, double d2) {
        return this.a <= d && d <= this.c && this.b <= d2 && d2 <= this.d;
    }

    public final boolean a(com.amap.api.mapcore.util.cu cuVar) {
        return a(cuVar.a, cuVar.c, cuVar.b, cuVar.d);
    }

    public final boolean a(com.autonavi.amap.mapcore.DPoint dPoint) {
        return a(dPoint.x, dPoint.y);
    }

    public final boolean b(com.amap.api.mapcore.util.cu cuVar) {
        return cuVar.a >= this.a && cuVar.c <= this.c && cuVar.b >= this.b && cuVar.d <= this.d;
    }
}
