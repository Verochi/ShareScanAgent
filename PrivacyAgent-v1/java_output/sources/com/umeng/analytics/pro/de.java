package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class de {
    private static int a = Integer.MAX_VALUE;

    public static com.umeng.analytics.pro.dd a(byte[] bArr, com.umeng.analytics.pro.dd ddVar) {
        return bArr[0] > 16 ? new com.umeng.analytics.pro.cv.a() : (bArr.length <= 1 || (bArr[1] & 128) == 0) ? ddVar : new com.umeng.analytics.pro.cv.a();
    }

    public static void a(int i) {
        a = i;
    }

    public static void a(com.umeng.analytics.pro.db dbVar, byte b) throws com.umeng.analytics.pro.ci {
        a(dbVar, b, a);
    }

    public static void a(com.umeng.analytics.pro.db dbVar, byte b, int i) throws com.umeng.analytics.pro.ci {
        if (i <= 0) {
            throw new com.umeng.analytics.pro.ci("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                dbVar.t();
                return;
            case 3:
                dbVar.u();
                return;
            case 4:
                dbVar.y();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                dbVar.v();
                return;
            case 8:
                dbVar.w();
                return;
            case 10:
                dbVar.x();
                return;
            case 11:
                dbVar.A();
                return;
            case 12:
                dbVar.j();
                while (true) {
                    byte b2 = dbVar.l().b;
                    if (b2 == 0) {
                        dbVar.k();
                        return;
                    } else {
                        a(dbVar, b2, i - 1);
                        dbVar.m();
                    }
                }
            case 13:
                com.umeng.analytics.pro.cy n = dbVar.n();
                while (i2 < n.c) {
                    int i3 = i - 1;
                    a(dbVar, n.a, i3);
                    a(dbVar, n.b, i3);
                    i2++;
                }
                dbVar.o();
                return;
            case 14:
                com.umeng.analytics.pro.df r = dbVar.r();
                while (i2 < r.b) {
                    a(dbVar, r.a, i - 1);
                    i2++;
                }
                dbVar.s();
                return;
            case 15:
                com.umeng.analytics.pro.cx p = dbVar.p();
                while (i2 < p.b) {
                    a(dbVar, p.a, i - 1);
                    i2++;
                }
                dbVar.q();
                return;
        }
    }
}
