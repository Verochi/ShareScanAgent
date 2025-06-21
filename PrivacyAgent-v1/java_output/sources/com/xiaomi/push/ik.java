package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ik {
    private static int a = Integer.MAX_VALUE;

    public static void a(com.xiaomi.push.ih ihVar, byte b) {
        a(ihVar, b, a);
    }

    private static void a(com.xiaomi.push.ih ihVar, byte b, int i) {
        if (i <= 0) {
            throw new com.xiaomi.push.ia("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                ihVar.f();
                return;
            case 3:
                ihVar.g();
                return;
            case 4:
                ihVar.k();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                ihVar.h();
                return;
            case 8:
                ihVar.i();
                return;
            case 10:
                ihVar.j();
                return;
            case 11:
                ihVar.m();
                return;
            case 12:
                break;
            case 13:
                com.xiaomi.push.ig c = ihVar.c();
                while (i2 < c.c) {
                    int i3 = i - 1;
                    a(ihVar, c.a, i3);
                    a(ihVar, c.b, i3);
                    i2++;
                }
                return;
            case 14:
                com.xiaomi.push.il e = ihVar.e();
                while (i2 < e.b) {
                    a(ihVar, e.a, i - 1);
                    i2++;
                }
                return;
            case 15:
                com.xiaomi.push.Cif d = ihVar.d();
                while (i2 < d.b) {
                    a(ihVar, d.a, i - 1);
                    i2++;
                }
                return;
        }
        while (true) {
            byte b2 = ihVar.b().b;
            if (b2 == 0) {
                return;
            } else {
                a(ihVar, b2, i - 1);
            }
        }
    }
}
