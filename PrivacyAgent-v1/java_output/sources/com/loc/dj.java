package com.loc;

/* loaded from: classes23.dex */
public final class dj extends com.loc.gg {
    private static int a(com.loc.gf gfVar) {
        return gfVar.b();
    }

    public static int a(com.loc.gf gfVar, int i, byte b, int i2, int i3) {
        gfVar.b(4);
        c(gfVar, i3);
        b(gfVar, i2);
        a(gfVar, i);
        a(gfVar, b);
        return a(gfVar);
    }

    public static int a(com.loc.gf gfVar, int[] iArr) {
        gfVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            gfVar.a(iArr[length]);
        }
        return gfVar.a();
    }

    private static void a(com.loc.gf gfVar, byte b) {
        gfVar.a(1, b);
    }

    private static void a(com.loc.gf gfVar, int i) {
        gfVar.b(0, i);
    }

    public static int b(com.loc.gf gfVar, int[] iArr) {
        gfVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            gfVar.a(iArr[length]);
        }
        return gfVar.a();
    }

    private static void b(com.loc.gf gfVar, int i) {
        gfVar.b(2, i);
    }

    private static void c(com.loc.gf gfVar, int i) {
        gfVar.b(3, i);
    }
}
