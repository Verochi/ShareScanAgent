package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
public class m extends com.sijla.mla.a.b.s {
    private static final java.lang.String[] L;
    private static final java.lang.String[] M;
    private static final java.lang.String[] N;
    private static java.lang.String a = com.sijla.mla.L2.s1530617380();
    private static java.lang.String b = com.sijla.mla.L2.s34963725();
    private static final java.lang.String[] f = {com.sijla.mla.L2.s1247181706(), com.sijla.mla.L2.s1068747602(), com.sijla.mla.L2.s1070220242(), com.sijla.mla.L2.s719107439(), com.sijla.mla.L2.s1070346210(), com.sijla.mla.L2.s948601143(), com.sijla.mla.L2.s217845180(), com.sijla.mla.L2.s218342978(), com.sijla.mla.L2.s680619016(), com.sijla.mla.L2.s1083755539(), com.sijla.mla.L2.s243329634(), com.sijla.mla.L2.s34744710(), com.sijla.mla.L2.s1121242(), "walkdir", "base64encode", "base64decode", "xxtea", "zip", "md5file", "osc"};
    private static final long g;
    private static long h;
    private static final java.lang.String[] j;
    private com.sijla.mla.a.b i;

    public class a extends com.sijla.mla.a.b.t {
        public a(int i, java.lang.String str) {
            this.d = i;
            this.e = str;
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            try {
                switch (this.d) {
                    case 0:
                        return com.sijla.mla.a.h.a(com.sijla.mla.a.b.m.ae());
                    case 1:
                        java.lang.String b = yVar.b(1, "%c");
                        double o = yVar.c(2).u() ? yVar.c(2).o() : com.sijla.mla.a.b.m.a((com.sijla.mla.a.o) null);
                        if (!b.equals("*t")) {
                            com.sijla.mla.a.b.m mVar = com.sijla.mla.a.b.m.this;
                            if (o == -1.0d) {
                                o = com.sijla.mla.a.b.m.a((com.sijla.mla.a.o) null);
                            }
                            return com.sijla.mla.a.n.c(mVar.a(b, o));
                        }
                        java.util.Calendar calendar = java.util.Calendar.getInstance();
                        calendar.setTime(new java.util.Date((long) (o * 1000.0d)));
                        com.sijla.mla.a.o oVar = new com.sijla.mla.a.o();
                        oVar.a(com.sijla.mla.L2.s1088242851(), com.sijla.mla.a.k.c_(calendar.get(1)));
                        oVar.a(com.sijla.mla.L2.s958133180(), com.sijla.mla.a.k.c_(calendar.get(2) + 1));
                        oVar.a(com.sijla.mla.L2.s34475816(), com.sijla.mla.a.k.c_(calendar.get(5)));
                        oVar.a(com.sijla.mla.L2.s1072860124(), com.sijla.mla.a.k.c_(calendar.get(11)));
                        oVar.a(com.sijla.mla.L2.s34751282(), com.sijla.mla.a.k.c_(calendar.get(12)));
                        oVar.a(com.sijla.mla.L2.s34925843(), com.sijla.mla.a.k.c_(calendar.get(13)));
                        oVar.a(com.sijla.mla.L2.s1086366235(), com.sijla.mla.a.k.c_(calendar.get(7)));
                        oVar.a(com.sijla.mla.L2.s1088213277(), com.sijla.mla.a.k.c_(calendar.get(6)));
                        oVar.a(com.sijla.mla.L2.s1069254199(), com.sijla.mla.a.r.a(com.sijla.mla.a.b.m.a(calendar)));
                        return oVar;
                    case 2:
                        return com.sijla.mla.a.h.a(com.sijla.mla.a.b.m.a(yVar.s(1), yVar.s(2)));
                    case 3:
                        yVar.b(1, null);
                        return com.sijla.mla.a.b.m.af();
                    case 4:
                        com.sijla.mla.a.b.m.m(yVar.c(1, 0));
                        return com.sijla.mla.a.r.n;
                    case 5:
                        java.lang.String c = com.sijla.mla.a.b.m.c(yVar.v(1));
                        return c != null ? com.sijla.mla.a.n.c(c) : com.sijla.mla.a.r.k;
                    case 6:
                        com.sijla.mla.a.b.m.i(yVar.v(1));
                        return com.sijla.mla.a.r.l;
                    case 7:
                        yVar.v(1);
                        yVar.v(2);
                        com.sijla.mla.a.b.m.ag();
                        return com.sijla.mla.a.r.l;
                    case 8:
                        yVar.b(1, null);
                        yVar.b(2, com.sijla.mla.L2.s34396611());
                        java.lang.String ah = com.sijla.mla.a.b.m.ah();
                        return ah != null ? com.sijla.mla.a.n.c(ah) : com.sijla.mla.a.r.k;
                    case 9:
                        return com.sijla.mla.a.h.a(com.sijla.mla.a.b.m.a(yVar.q(1)));
                    case 10:
                        return com.sijla.mla.a.n.c(com.sijla.mla.a.b.m.ai());
                    case 11:
                        return com.sijla.mla.a.n.c(com.sijla.h.a.g.a(yVar.w(1).b));
                    case 12:
                        return com.sijla.mla.a.h.a(java.lang.System.currentTimeMillis());
                    case 13:
                        com.sijla.c.a.a(new java.io.File(yVar.v(1)), new com.sijla.mla.a.b.n(this, yVar.t(2), yVar.p(3)));
                        return com.sijla.mla.a.r.l;
                    case 14:
                        return com.sijla.mla.a.n.c(com.sijla.d.a.a(yVar.v(1).getBytes()));
                    case 15:
                        return com.sijla.mla.a.n.a(com.sijla.d.a.a(yVar.v(1)));
                    case 16:
                        return com.sijla.mla.a.n.a(com.sijla.mla.L2.xx(yVar.w(1).b, yVar.v(2).getBytes(), yVar.u(3)));
                    case 17:
                        return com.sijla.mla.a.r.l;
                    case 18:
                        try {
                            return com.sijla.mla.a.n.c(com.sijla.h.a.g.a(com.sijla.h.c.a(new java.io.File(yVar.v(1)))));
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                            return com.sijla.mla.a.r.k;
                        }
                    case 19:
                        return com.sijla.mla.a.n.c(com.sijla.h.a.a.n(com.sijla.b.g.b()));
                    default:
                        return com.sijla.mla.a.r.n;
                }
            } catch (java.io.IOException e2) {
                return com.sijla.mla.a.r.a(com.sijla.mla.a.r.k, (com.sijla.mla.a.y) com.sijla.mla.a.n.c(e2.getMessage()));
            }
            return com.sijla.mla.a.r.a(com.sijla.mla.a.r.k, (com.sijla.mla.a.y) com.sijla.mla.a.n.c(e2.getMessage()));
        }
    }

    static {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        g = currentTimeMillis;
        h = currentTimeMillis;
        j = new java.lang.String[]{com.sijla.mla.L2.s33988248(), com.sijla.mla.L2.s33803736(), com.sijla.mla.L2.s34017760(), com.sijla.mla.L2.s34091726(), com.sijla.mla.L2.s34005763(), com.sijla.mla.L2.s33597927(), com.sijla.mla.L2.s33969214()};
        L = new java.lang.String[]{com.sijla.mla.L2.s1066322480(), com.sijla.mla.L2.s2026815120(), com.sijla.mla.L2.s1492155977(), com.sijla.mla.L2.s1276439886(), com.sijla.mla.L2.s1106556806(), com.sijla.mla.L2.s190526497(), com.sijla.mla.L2.s1498266233()};
        M = new java.lang.String[]{com.sijla.mla.L2.s33700909(), com.sijla.mla.L2.s33585217(), com.sijla.mla.L2.s33790406(), com.sijla.mla.L2.s33447329(), com.sijla.mla.L2.s33790623(), com.sijla.mla.L2.s33720129(), com.sijla.mla.L2.s33720067(), com.sijla.mla.L2.s33451793(), com.sijla.mla.L2.s33972934(), com.sijla.mla.L2.s33851972(), com.sijla.mla.L2.s33833775(), com.sijla.mla.L2.s33525666()};
        N = new java.lang.String[]{com.sijla.mla.L2.s2051158214(), com.sijla.mla.L2.s26725054(), com.sijla.mla.L2.s1887092479(), com.sijla.mla.L2.s2078183710(), com.sijla.mla.L2.s33790623(), com.sijla.mla.L2.s1045326110(), com.sijla.mla.L2.s1045324808(), com.sijla.mla.L2.s132539389(), com.sijla.mla.L2.s1769128141(), com.sijla.mla.L2.s14217092(), com.sijla.mla.L2.s1109120210(), com.sijla.mla.L2.s145379685()};
    }

    public static double a(double d, double d2) {
        return d - d2;
    }

    public static double a(com.sijla.mla.a.o oVar) {
        java.util.Date time;
        if (oVar == null) {
            time = new java.util.Date();
        } else {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.set(1, oVar.g(com.sijla.mla.L2.s1088242851()).x());
            calendar.set(2, oVar.g(com.sijla.mla.L2.s958133180()).x() - 1);
            calendar.set(5, oVar.g(com.sijla.mla.L2.s34475816()).x());
            calendar.set(11, oVar.g(com.sijla.mla.L2.s1072860124()).a(12));
            calendar.set(12, oVar.g(com.sijla.mla.L2.s34751282()).a(0));
            calendar.set(13, oVar.g(com.sijla.mla.L2.s34925843()).a(0));
            calendar.set(14, 0);
            time = calendar.getTime();
        }
        return time.getTime() / 1000.0d;
    }

    private static int a(java.util.Calendar calendar, int i) {
        java.util.Calendar b2 = b(calendar);
        int i2 = i + 8;
        b2.set(5, ((i2 - b2.get(7)) % 7) + 1);
        if (b2.after(calendar)) {
            b2.set(1, b2.get(1) - 1);
            b2.set(5, ((i2 - b2.get(7)) % 7) + 1);
        }
        return ((int) ((calendar.getTime().getTime() - b2.getTime().getTime()) / 604800000)) + 1;
    }

    public static /* synthetic */ boolean a(java.util.Calendar calendar) {
        return c(calendar) != calendar.getTimeZone().getRawOffset() / 1000;
    }

    public static double ae() {
        return (java.lang.System.currentTimeMillis() - g) / 1000.0d;
    }

    public static com.sijla.mla.a.y af() {
        return com.sijla.mla.a.r.a(com.sijla.mla.a.r.k, (com.sijla.mla.a.r) com.sijla.mla.a.n.c(com.sijla.mla.L2.s1070346210()), (com.sijla.mla.a.y) com.sijla.mla.a.r.p);
    }

    public static void ag() {
        throw new java.io.IOException("not implemented");
    }

    public static java.lang.String ah() {
        return com.sijla.mla.L2.s34785();
    }

    public static java.lang.String ai() {
        java.lang.String sb;
        synchronized (com.sijla.mla.a.b.m.class) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(a);
            long j2 = h;
            h = 1 + j2;
            sb2.append(j2);
            sb2.append(b);
            sb = sb2.toString();
        }
        return sb;
    }

    private static java.util.Calendar b(java.util.Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.setTime(calendar.getTime());
        calendar2.set(2, 0);
        calendar2.set(5, 1);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        return calendar2;
    }

    private static int c(java.util.Calendar calendar) {
        return calendar.getTimeZone().getOffset(1, calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(7), (((calendar.get(11) * com.anythink.expressad.d.a.b.ck) + (calendar.get(12) * 60)) + calendar.get(13)) * 1000) / 1000;
    }

    public static java.lang.String c(java.lang.String str) {
        return java.lang.System.getProperty(str);
    }

    public static void i(java.lang.String str) {
        new java.io.File(str).delete();
    }

    public static void m(int i) {
        java.lang.System.exit(i);
    }

    public final java.lang.String a(java.lang.String str, double d) {
        int i;
        int i2;
        java.lang.String substring;
        int i3;
        int a2;
        java.lang.String str2;
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(new java.util.Date((long) (d * 1000.0d)));
        if (str.startsWith("!")) {
            d -= c(calendar);
            calendar.setTime(new java.util.Date((long) (1000.0d * d)));
            str = str.substring(1);
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        com.sijla.mla.a.a aVar = new com.sijla.mla.a.a(length);
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            byte b2 = bytes[i4];
            if (b2 == 10) {
                aVar.a("\n");
            } else if (b2 != 37) {
                aVar.a(b2);
            } else if (i5 < length) {
                i4 = i5 + 1;
                byte b3 = bytes[i5];
                if (b3 != 37) {
                    if (b3 != 77) {
                        if (b3 != 83) {
                            if (b3 != 85) {
                                if (b3 == 106) {
                                    i2 = ((int) ((calendar.getTime().getTime() - b(calendar).getTime().getTime()) / 86400000)) + 1001;
                                } else if (b3 != 109) {
                                    if (b3 == 112) {
                                        substring = calendar.get(11) < 12 ? com.sijla.mla.L2.s1077780() : com.sijla.mla.L2.s1092195();
                                    } else if (b3 == 65) {
                                        substring = L[calendar.get(7) - 1];
                                    } else if (b3 == 66) {
                                        substring = N[calendar.get(2)];
                                    } else if (b3 == 72) {
                                        i = calendar.get(11);
                                    } else if (b3 != 73) {
                                        switch (b3) {
                                            case 87:
                                                a2 = a(calendar, 1);
                                                break;
                                            case 88:
                                                str2 = "%H:%M:%S";
                                                substring = a(str2, d);
                                                break;
                                            case 89:
                                                a2 = calendar.get(1);
                                                break;
                                            default:
                                                switch (b3) {
                                                    case 97:
                                                        substring = j[calendar.get(7) - 1];
                                                        break;
                                                    case 98:
                                                        substring = M[calendar.get(2)];
                                                        break;
                                                    case 99:
                                                        str2 = "%a %b %d %H:%M:%S %Y";
                                                        substring = a(str2, d);
                                                        break;
                                                    case 100:
                                                        i3 = 5;
                                                        break;
                                                    default:
                                                        switch (b3) {
                                                            case 119:
                                                                a2 = (calendar.get(7) + 6) % 7;
                                                                break;
                                                            case 120:
                                                                str2 = "%m/%d/%y";
                                                                substring = a(str2, d);
                                                                break;
                                                            case 121:
                                                                substring = java.lang.String.valueOf(calendar.get(1)).substring(2);
                                                                break;
                                                            case 122:
                                                                int c = c(calendar) / 60;
                                                                int abs = java.lang.Math.abs(c);
                                                                java.lang.String substring2 = java.lang.String.valueOf((abs / 60) + 100).substring(1);
                                                                java.lang.String substring3 = java.lang.String.valueOf((abs % 60) + 100).substring(1);
                                                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                                                sb.append(c >= 0 ? "+" : com.sijla.mla.L2.s34103());
                                                                sb.append(substring2);
                                                                sb.append(substring3);
                                                                substring = sb.toString();
                                                                break;
                                                            default:
                                                                com.sijla.mla.a.r.a(1, "invalid conversion specifier '%" + ((int) b3) + "'");
                                                                break;
                                                        }
                                                }
                                        }
                                    } else {
                                        i = calendar.get(11) % 12;
                                    }
                                    aVar.a(substring);
                                } else {
                                    i2 = calendar.get(2) + 101;
                                }
                                substring = java.lang.String.valueOf(i2).substring(1);
                                aVar.a(substring);
                            } else {
                                a2 = a(calendar, 0);
                            }
                            substring = java.lang.String.valueOf(a2);
                            aVar.a(substring);
                        } else {
                            i3 = 13;
                        }
                        i = calendar.get(i3);
                    } else {
                        i = calendar.get(12);
                    }
                    i2 = i + 100;
                    substring = java.lang.String.valueOf(i2).substring(1);
                    aVar.a(substring);
                } else {
                    aVar.a((byte) 37);
                }
            }
            i4 = i5;
        }
        return aVar.c();
    }

    @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
    public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        this.i = rVar2.a();
        com.sijla.mla.a.o oVar = new com.sijla.mla.a.o();
        for (int i = 0; i < 20; i++) {
            java.lang.String str = f[i];
            oVar.a(str, new com.sijla.mla.a.b.m.a(i, str));
        }
        rVar2.a(com.sijla.mla.L2.s1123164(), oVar);
        rVar2.g(com.sijla.mla.L2.s573041986()).g(com.sijla.mla.L2.s537344421()).a(com.sijla.mla.L2.s1123164(), oVar);
        return oVar;
    }
}
