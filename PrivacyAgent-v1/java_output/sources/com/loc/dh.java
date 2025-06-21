package com.loc;

/* loaded from: classes23.dex */
public final class dh extends com.loc.gg {
    private static int a(com.loc.gf gfVar) {
        return gfVar.b();
    }

    public static int a(com.loc.gf gfVar, int i, int i2, int i3) {
        gfVar.b(3);
        c(gfVar, i3);
        b(gfVar, i2);
        a(gfVar, i);
        return a(gfVar);
    }

    public static int a(com.loc.gf gfVar, byte[] bArr) {
        gfVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            gfVar.a(bArr[length]);
        }
        return gfVar.a();
    }

    public static int a(com.loc.gf gfVar, int[] iArr) {
        gfVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            gfVar.a(iArr[length]);
        }
        return gfVar.a();
    }

    private static void a(com.loc.gf gfVar, int i) {
        gfVar.b(0, i);
    }

    public static int b(com.loc.gf gfVar, byte[] bArr) {
        gfVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            gfVar.a(bArr[length]);
        }
        return gfVar.a();
    }

    private static void b(com.loc.gf gfVar, int i) {
        gfVar.b(1, i);
    }

    private static void c(com.loc.gf gfVar, int i) {
        gfVar.b(2, i);
    }
}
