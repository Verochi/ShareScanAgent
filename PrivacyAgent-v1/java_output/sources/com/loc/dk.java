package com.loc;

/* loaded from: classes23.dex */
public final class dk extends com.loc.gg {
    private static int a(com.loc.gf gfVar) {
        return gfVar.b();
    }

    public static int a(com.loc.gf gfVar, byte b, int i) {
        gfVar.b(2);
        a(gfVar, i);
        a(gfVar, b);
        return a(gfVar);
    }

    private static void a(com.loc.gf gfVar, byte b) {
        gfVar.a(0, b);
    }

    private static void a(com.loc.gf gfVar, int i) {
        gfVar.b(1, i);
    }
}
