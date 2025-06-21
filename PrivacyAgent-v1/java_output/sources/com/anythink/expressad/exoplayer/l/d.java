package com.anythink.expressad.exoplayer.l;

/* loaded from: classes12.dex */
public final class d {
    public final java.util.List<byte[]> a;
    public final int b;

    private d(java.util.List<byte[]> list, int i) {
        this.a = list;
        this.b = i;
    }

    public static com.anythink.expressad.exoplayer.l.d a(com.anythink.expressad.exoplayer.k.s sVar) {
        try {
            sVar.d(21);
            int d = sVar.d() & 3;
            int d2 = sVar.d();
            int c = sVar.c();
            int i = 0;
            for (int i2 = 0; i2 < d2; i2++) {
                sVar.d(1);
                int e = sVar.e();
                for (int i3 = 0; i3 < e; i3++) {
                    int e2 = sVar.e();
                    i += e2 + 4;
                    sVar.d(e2);
                }
            }
            sVar.c(c);
            byte[] bArr = new byte[i];
            int i4 = 0;
            for (int i5 = 0; i5 < d2; i5++) {
                sVar.d(1);
                int e3 = sVar.e();
                for (int i6 = 0; i6 < e3; i6++) {
                    int e4 = sVar.e();
                    byte[] bArr2 = com.anythink.expressad.exoplayer.k.p.a;
                    java.lang.System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
                    int length = i4 + bArr2.length;
                    java.lang.System.arraycopy(sVar.a, sVar.c(), bArr, length, e4);
                    i4 = length + e4;
                    sVar.d(e4);
                }
            }
            return new com.anythink.expressad.exoplayer.l.d(i == 0 ? null : java.util.Collections.singletonList(bArr), d + 1);
        } catch (java.lang.ArrayIndexOutOfBoundsException e5) {
            throw new com.anythink.expressad.exoplayer.t("Error parsing HEVC config", e5);
        }
    }
}
