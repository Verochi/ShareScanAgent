package com.getui.gs.g;

/* loaded from: classes22.dex */
public final class c {
    private static final java.lang.Object a = new java.lang.Object();
    private static volatile long b;
    private static volatile long c;
    private static volatile long d;
    private static volatile long e;
    private static volatile long f;
    private static volatile long g;
    private static volatile long h;
    private static volatile long i;
    private static volatile long j;
    private static volatile long k;
    private static volatile long l;
    private static long m;
    private static long n;
    private static long o;
    private static long p;
    private static long q;
    private static long r;

    /* renamed from: s, reason: collision with root package name */
    private static long f310s;
    private static long t;
    private static long u;
    private static long v;
    private static long w;
    private static long x;

    public static long a(int i2) {
        return java.lang.System.currentTimeMillis() - com.getui.gs.ias.core.a.C0291a.a(i2);
    }

    private static long a(int i2, long j2, long j3) {
        long d2 = (long) (j3 * com.getui.gs.ias.core.a.C0291a.d(i2));
        if (d2 != 0 || j2 == 0) {
            j2 = d2;
        }
        return java.lang.Math.max(com.getui.gs.ias.core.a.C0291a.b(i2), java.lang.Math.min(com.getui.gs.ias.core.a.C0291a.c(i2), j2));
    }

    public static java.lang.String a(int i2, java.lang.String str) {
        java.lang.String[] split = str.split("\\|");
        long h2 = h();
        long j2 = l;
        if (i2 == 8) {
            long j3 = h;
            long j4 = c;
            split[0] = java.lang.String.valueOf(h2);
            split[1] = java.lang.String.valueOf(j4);
            split[2] = java.lang.String.valueOf(j2);
            split[3] = java.lang.String.valueOf(j3);
        } else {
            if (i2 != 11) {
                return str;
            }
            long j5 = i;
            long j6 = d;
            split[0] = java.lang.String.valueOf(h2);
            split[1] = java.lang.String.valueOf(j6);
            split[2] = java.lang.String.valueOf(j2);
            split[3] = java.lang.String.valueOf(j5);
        }
        int length = split.length;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i3 = 0; i3 < length; i3++) {
            sb.append(split[i3]);
            if (i3 != length - 1) {
                sb.append("|");
            }
        }
        return sb.toString();
    }

    public static java.lang.String a(com.getui.gs.d.a.EnumC0289a enumC0289a, java.lang.String str) {
        java.lang.String[] split = str.split("\\|");
        long h2 = h();
        long j2 = l;
        if (enumC0289a == com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE) {
            long j3 = k;
            long j4 = f;
            split[0] = java.lang.String.valueOf(h2);
            split[1] = java.lang.String.valueOf(j4);
            split[2] = java.lang.String.valueOf(j2);
            split[3] = java.lang.String.valueOf(j3);
        } else {
            if (enumC0289a != com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL && enumC0289a != com.getui.gs.d.a.EnumC0289a.TYPE_DURATION) {
                return str;
            }
            long j5 = j;
            long j6 = e;
            split[0] = java.lang.String.valueOf(h2);
            split[1] = java.lang.String.valueOf(j6);
            split[2] = java.lang.String.valueOf(j2);
            split[3] = java.lang.String.valueOf(j5);
        }
        int length = split.length;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(split[i2]);
            if (i2 != length - 1) {
                sb.append("|");
            }
        }
        return sb.toString();
    }

    public static void a() {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        long j2;
        com.getui.gs.b.e eVar3;
        com.getui.gs.b.e eVar4;
        int i2;
        eVar = com.getui.gs.b.e.a.a;
        com.getui.gs.b.b bVar = eVar.a;
        l = bVar.a(8);
        b = bVar.a(9);
        c = bVar.a(13);
        d = bVar.a(17);
        e = bVar.a(21);
        f = bVar.a(25);
        m = bVar.a(10);
        n = bVar.a(14);
        o = bVar.a(18);
        p = bVar.a(22);
        q = bVar.a(26);
        r = bVar.a(11);
        f310s = bVar.a(15);
        t = bVar.a(19);
        u = bVar.a(23);
        v = bVar.a(27);
        g = bVar.a(12);
        h = bVar.a(16);
        i = bVar.a(20);
        j = bVar.a(24);
        k = bVar.a(28);
        w = bVar.a(29);
        x = bVar.a(30);
        eVar2 = com.getui.gs.b.e.a.a;
        java.util.List<com.getui.gs.g.a> a2 = eVar2.d.a();
        int size = a2.size();
        long j3 = 0;
        if (size > 0) {
            int i3 = 0;
            long j4 = 0;
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            while (i3 < size) {
                com.getui.gs.g.a aVar = a2.get(i3);
                int i4 = aVar.c;
                if (aVar.e >= a(i4)) {
                    i2 = size;
                    long j8 = aVar.f - aVar.e;
                    if (j8 > j3) {
                        if (i4 == 8) {
                            j5 += j8;
                            j4++;
                        } else if (i4 == 11) {
                            j7 += j8;
                            j6++;
                        }
                    }
                } else {
                    i2 = size;
                }
                i3++;
                size = i2;
                j3 = 0;
            }
            j2 = j3;
            long j9 = j4 > j2 ? j5 / j4 : j2;
            if (j6 > j2) {
                j2 = j7 / j6;
            }
            j3 = j9;
        } else {
            j2 = 0;
        }
        long a3 = a(8, w, j3);
        if (a3 != w) {
            eVar4 = com.getui.gs.b.e.a.a;
            com.getui.gs.b.b bVar2 = eVar4.a;
            w = a3;
            bVar2.a(29, a3);
        }
        long a4 = a(11, x, j2);
        if (a4 != x) {
            eVar3 = com.getui.gs.b.e.a.a;
            com.getui.gs.b.b bVar3 = eVar3.a;
            x = a4;
            bVar3.a(30, a4);
        }
        com.getui.gs.h.b.a.a.a.d("lastInterval : " + w + " --- " + x);
    }

    public static void a(int i2, boolean z, int i3) {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        com.getui.gs.b.b bVar;
        int i4;
        long j2;
        com.getui.gs.b.e eVar3;
        com.getui.gs.b.e eVar4;
        if (i2 == 8) {
            if (z) {
                n += i3;
                eVar4 = com.getui.gs.b.e.a.a;
                bVar = eVar4.a;
                i4 = 14;
                j2 = n;
            } else {
                f310s += i3;
                eVar3 = com.getui.gs.b.e.a.a;
                bVar = eVar3.a;
                i4 = 15;
                j2 = f310s;
            }
        } else {
            if (i2 != 11) {
                return;
            }
            if (!z) {
                t += i3;
                eVar = com.getui.gs.b.e.a.a;
                eVar.a.a(19, t);
                return;
            } else {
                o += i3;
                eVar2 = com.getui.gs.b.e.a.a;
                bVar = eVar2.a;
                i4 = 18;
                j2 = o;
            }
        }
        bVar.a(i4, j2);
    }

    public static void a(com.getui.gs.d.a.EnumC0289a enumC0289a, boolean z, int i2) {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        com.getui.gs.b.b bVar;
        int i3;
        long j2;
        com.getui.gs.b.e eVar3;
        com.getui.gs.b.e eVar4;
        if (enumC0289a == com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE) {
            if (z) {
                q += i2;
                eVar4 = com.getui.gs.b.e.a.a;
                bVar = eVar4.a;
                i3 = 26;
                j2 = q;
            } else {
                v += i2;
                eVar3 = com.getui.gs.b.e.a.a;
                bVar = eVar3.a;
                i3 = 27;
                j2 = v;
            }
        } else {
            if (enumC0289a != com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL && enumC0289a != com.getui.gs.d.a.EnumC0289a.TYPE_DURATION) {
                return;
            }
            if (!z) {
                u += i2;
                eVar = com.getui.gs.b.e.a.a;
                eVar.a.a(23, u);
                return;
            } else {
                p += i2;
                eVar2 = com.getui.gs.b.e.a.a;
                bVar = eVar2.a;
                i3 = 22;
                j2 = p;
            }
        }
        bVar.a(i3, j2);
    }

    public static void a(boolean z) {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.b bVar;
        long j2;
        int i2;
        com.getui.gs.b.e eVar2;
        if (z) {
            eVar2 = com.getui.gs.b.e.a.a;
            bVar = eVar2.a;
            j2 = m + 1;
            m = j2;
            i2 = 10;
        } else {
            eVar = com.getui.gs.b.e.a.a;
            bVar = eVar.a;
            j2 = r + 1;
            r = j2;
            i2 = 11;
        }
        bVar.a(i2, j2);
    }

    public static long b(int i2) {
        return i2 == 11 ? x : w;
    }

    public static void b() {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        com.getui.gs.b.e eVar3;
        com.getui.gs.b.e eVar4;
        com.getui.gs.b.e eVar5;
        com.getui.gs.b.e eVar6;
        eVar = com.getui.gs.b.e.a.a;
        com.getui.gs.b.b bVar = eVar.a;
        l = 0L;
        bVar.a(8, 0L);
        eVar2 = com.getui.gs.b.e.a.a;
        com.getui.gs.b.b bVar2 = eVar2.a;
        g = 0L;
        bVar2.a(12, 0L);
        eVar3 = com.getui.gs.b.e.a.a;
        com.getui.gs.b.b bVar3 = eVar3.a;
        h = 0L;
        bVar3.a(16, 0L);
        eVar4 = com.getui.gs.b.e.a.a;
        com.getui.gs.b.b bVar4 = eVar4.a;
        i = 0L;
        bVar4.a(20, 0L);
        eVar5 = com.getui.gs.b.e.a.a;
        com.getui.gs.b.b bVar5 = eVar5.a;
        j = 0L;
        bVar5.a(24, 0L);
        eVar6 = com.getui.gs.b.e.a.a;
        com.getui.gs.b.b bVar6 = eVar6.a;
        k = 0L;
        bVar6.a(28, 0L);
    }

    public static java.lang.String c() {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        com.getui.gs.b.e eVar3;
        long i2 = i();
        long j2 = l;
        long j3 = g;
        long j4 = b;
        long n2 = n();
        long o2 = o();
        eVar = com.getui.gs.b.e.a.a;
        eVar.a.a(8, j2);
        eVar2 = com.getui.gs.b.e.a.a;
        eVar2.a.a(12, j3);
        eVar3 = com.getui.gs.b.e.a.a;
        eVar3.a.a(9, j4);
        long b2 = com.getui.gs.ias.core.a.b() / 1000;
        return java.lang.String.format(java.util.Locale.getDefault(), "%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", java.lang.Long.valueOf(i2), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(i2), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(n2), java.lang.Long.valueOf(o2), java.lang.Long.valueOf(b2), java.lang.Long.valueOf(b2));
    }

    public static java.lang.String d() {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        com.getui.gs.b.e eVar3;
        long j2 = j();
        long j3 = l;
        long j4 = h;
        long j5 = c;
        long n2 = n();
        long o2 = o();
        eVar = com.getui.gs.b.e.a.a;
        eVar.a.a(8, j3);
        eVar2 = com.getui.gs.b.e.a.a;
        eVar2.a.a(16, j4);
        eVar3 = com.getui.gs.b.e.a.a;
        eVar3.a.a(13, j5);
        return java.lang.String.format(java.util.Locale.getDefault(), "%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j5), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j5), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(n2), java.lang.Long.valueOf(o2), java.lang.Long.valueOf(com.getui.gs.ias.core.a.d() / 1000), java.lang.Long.valueOf(w / 1000));
    }

    public static java.lang.String e() {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        com.getui.gs.b.e eVar3;
        long k2 = k();
        long j2 = l;
        long j3 = i;
        long j4 = d;
        long n2 = n();
        long o2 = o();
        eVar = com.getui.gs.b.e.a.a;
        eVar.a.a(8, j2);
        eVar2 = com.getui.gs.b.e.a.a;
        eVar2.a.a(20, j3);
        eVar3 = com.getui.gs.b.e.a.a;
        eVar3.a.a(17, j4);
        return java.lang.String.format(java.util.Locale.getDefault(), "%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", java.lang.Long.valueOf(k2), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(k2), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(n2), java.lang.Long.valueOf(o2), java.lang.Long.valueOf(com.getui.gs.ias.core.a.e() / 1000), java.lang.Long.valueOf(x / 1000));
    }

    public static java.lang.String f() {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        com.getui.gs.b.e eVar3;
        long l2 = l();
        long j2 = l;
        long j3 = j;
        long j4 = e;
        long n2 = n();
        long o2 = o();
        eVar = com.getui.gs.b.e.a.a;
        eVar.a.a(8, j2);
        eVar2 = com.getui.gs.b.e.a.a;
        eVar2.a.a(24, j3);
        eVar3 = com.getui.gs.b.e.a.a;
        eVar3.a.a(21, j4);
        long f2 = com.getui.gs.ias.core.a.f() / 1000;
        return java.lang.String.format(java.util.Locale.getDefault(), "%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", java.lang.Long.valueOf(l2), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(l2), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(n2), java.lang.Long.valueOf(o2), java.lang.Long.valueOf(f2), java.lang.Long.valueOf(f2));
    }

    public static java.lang.String g() {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        com.getui.gs.b.e eVar3;
        long m2 = m();
        long j2 = l;
        long j3 = k;
        long j4 = f;
        long n2 = n();
        long o2 = o();
        eVar = com.getui.gs.b.e.a.a;
        eVar.a.a(8, j2);
        eVar2 = com.getui.gs.b.e.a.a;
        eVar2.a.a(28, j3);
        eVar3 = com.getui.gs.b.e.a.a;
        eVar3.a.a(25, j4);
        long g2 = com.getui.gs.ias.core.a.g() / 1000;
        return java.lang.String.format(java.util.Locale.getDefault(), "%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", java.lang.Long.valueOf(m2), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(m2), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(n2), java.lang.Long.valueOf(o2), java.lang.Long.valueOf(g2), java.lang.Long.valueOf(g2));
    }

    private static long h() {
        return b + c + d + e + f;
    }

    private static long i() {
        long j2;
        synchronized (a) {
            l++;
            g++;
            long j3 = b + 1;
            b = j3;
            j2 = j3 + c + d + e + f;
        }
        return j2;
    }

    private static long j() {
        long j2;
        synchronized (a) {
            l++;
            h++;
            long j3 = b;
            long j4 = c + 1;
            c = j4;
            j2 = j3 + j4 + d + e + f;
        }
        return j2;
    }

    private static long k() {
        long j2;
        synchronized (a) {
            l++;
            i++;
            long j3 = b + c;
            long j4 = d + 1;
            d = j4;
            j2 = j3 + j4 + e + f;
        }
        return j2;
    }

    private static long l() {
        long j2;
        synchronized (a) {
            l++;
            j++;
            long j3 = b + c + d;
            long j4 = e + 1;
            e = j4;
            j2 = j3 + j4 + f;
        }
        return j2;
    }

    private static long m() {
        long j2;
        synchronized (a) {
            l++;
            k++;
            long j3 = b + c + d + e;
            long j4 = f + 1;
            f = j4;
            j2 = j3 + j4;
        }
        return j2;
    }

    private static long n() {
        return m + n + o + p + q;
    }

    private static long o() {
        return r + f310s + t + u + v;
    }
}
