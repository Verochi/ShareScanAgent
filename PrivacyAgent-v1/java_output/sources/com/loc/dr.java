package com.loc;

/* loaded from: classes23.dex */
public final class dr extends com.loc.gg {
    public static int a(com.loc.gf gfVar, int i, int i2, short s2) {
        gfVar.b(4);
        b(gfVar, i2);
        a(gfVar, i);
        a(gfVar, s2);
        a(gfVar);
        return b(gfVar);
    }

    private static void a(com.loc.gf gfVar) {
        gfVar.a(0, (byte) 1);
    }

    private static void a(com.loc.gf gfVar, int i) {
        gfVar.a(1, i);
    }

    private static void a(com.loc.gf gfVar, short s2) {
        gfVar.a(3, s2);
    }

    private static int b(com.loc.gf gfVar) {
        return gfVar.b();
    }

    private static void b(com.loc.gf gfVar, int i) {
        gfVar.a(2, i);
    }
}
