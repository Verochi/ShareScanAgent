package com.getui.gtc.extension.distribution.gbd.n.d.c;

/* loaded from: classes22.dex */
final class e extends java.util.ArrayList<com.getui.gtc.extension.distribution.gbd.n.d.c.d> {
    private static final int a = 16;
    private final int b;

    private e(int i, int i2) {
        super(i);
        this.b = i2;
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.c.e a(int i) {
        return new com.getui.gtc.extension.distribution.gbd.n.d.c.e(16, i);
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.c.e b() {
        return new com.getui.gtc.extension.distribution.gbd.n.d.c.e(0, 0);
    }

    private int c() {
        return this.b;
    }

    public final boolean a() {
        return size() < this.b;
    }
}
