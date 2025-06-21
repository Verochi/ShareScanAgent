package com.loc;

/* loaded from: classes23.dex */
public final class dt extends com.loc.gg {
    private static int a(com.loc.gf gfVar) {
        return gfVar.b();
    }

    public static int a(com.loc.gf gfVar, int i) {
        gfVar.b(1);
        b(gfVar, i);
        return a(gfVar);
    }

    public static int a(com.loc.gf gfVar, int[] iArr) {
        gfVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            gfVar.a(iArr[length]);
        }
        return gfVar.a();
    }

    private static void b(com.loc.gf gfVar, int i) {
        gfVar.b(0, i);
    }
}
