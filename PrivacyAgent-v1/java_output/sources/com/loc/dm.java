package com.loc;

/* loaded from: classes23.dex */
public final class dm extends com.loc.gg {
    private static int a(com.loc.gf gfVar) {
        return gfVar.b();
    }

    public static int a(com.loc.gf gfVar, byte b, int i) {
        gfVar.b(2);
        a(gfVar, i);
        a(gfVar, b);
        return a(gfVar);
    }

    public static int a(com.loc.gf gfVar, byte[] bArr) {
        gfVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            gfVar.a(bArr[length]);
        }
        return gfVar.a();
    }

    private static void a(com.loc.gf gfVar, byte b) {
        gfVar.a(0, b);
    }

    private static void a(com.loc.gf gfVar, int i) {
        gfVar.b(1, i);
    }
}
