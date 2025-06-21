package com.getui.gtc.extension.distribution.gbd.c;

/* loaded from: classes22.dex */
public final class k {
    public double a;
    public double b;
    public long c;
    private final int d;
    private double e;

    public k(java.util.List<java.lang.String> list, int i) {
        this.d = i;
        try {
            if (list.size() >= 3) {
                this.a = java.lang.Double.parseDouble(list.get(0));
                this.b = java.lang.Double.parseDouble(list.get(1));
                this.c = java.lang.Long.parseLong(list.get(2));
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private int b() {
        return this.d;
    }

    private long c() {
        return this.c;
    }

    private double d() {
        return this.a;
    }

    private double e() {
        return this.b;
    }

    private static java.lang.String f() {
        return "";
    }

    public final java.lang.String a() {
        return this.a + "#" + this.b + "#" + this.c;
    }
}
