package com.anythink.expressad.exoplayer.l;

/* loaded from: classes12.dex */
public final class a {
    public final java.util.List<byte[]> a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    private a(java.util.List<byte[]> list, int i, int i2, int i3, float f) {
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
    }

    public static com.anythink.expressad.exoplayer.l.a a(com.anythink.expressad.exoplayer.k.s sVar) {
        int i;
        int i2;
        float f;
        try {
            sVar.d(4);
            int d = (sVar.d() & 3) + 1;
            if (d == 3) {
                throw new java.lang.IllegalStateException();
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int d2 = sVar.d() & 31;
            for (int i3 = 0; i3 < d2; i3++) {
                arrayList.add(b(sVar));
            }
            int d3 = sVar.d();
            for (int i4 = 0; i4 < d3; i4++) {
                arrayList.add(b(sVar));
            }
            if (d2 > 0) {
                com.anythink.expressad.exoplayer.k.p.b a = com.anythink.expressad.exoplayer.k.p.a((byte[]) arrayList.get(0), d, ((byte[]) arrayList.get(0)).length);
                int i5 = a.b;
                int i6 = a.c;
                f = a.d;
                i = i5;
                i2 = i6;
            } else {
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new com.anythink.expressad.exoplayer.l.a(arrayList, d, i, i2, f);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            throw new com.anythink.expressad.exoplayer.t("Error parsing AVC config", e);
        }
    }

    private static byte[] b(com.anythink.expressad.exoplayer.k.s sVar) {
        int e = sVar.e();
        int c = sVar.c();
        sVar.d(e);
        return com.anythink.expressad.exoplayer.k.d.a(sVar.a, c, e);
    }
}
