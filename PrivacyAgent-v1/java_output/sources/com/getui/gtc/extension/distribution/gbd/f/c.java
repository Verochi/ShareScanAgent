package com.getui.gtc.extension.distribution.gbd.f;

/* loaded from: classes22.dex */
public final class c {
    private static final java.lang.String a = "GBD_DC";

    public static class a {
        private static final com.getui.gtc.extension.distribution.gbd.f.c a = new com.getui.gtc.extension.distribution.gbd.f.c((byte) 0);

        private a() {
        }
    }

    private c() {
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    private static com.getui.gtc.extension.distribution.gbd.f.c a() {
        return com.getui.gtc.extension.distribution.gbd.f.c.a.a;
    }

    private static java.lang.Object a(java.lang.String str) {
        return a(str, (java.lang.String) null);
    }

    private static <T> T a(java.lang.String str, com.getui.gtc.extension.distribution.gbd.f.f fVar) {
        return (T) com.getui.gtc.extension.distribution.gbd.h.a.a(true, str, fVar);
    }

    private static <T, R> R a(java.lang.String str, T t, com.getui.gtc.extension.distribution.gbd.f.j<T, R> jVar) {
        return (R) com.getui.gtc.extension.distribution.gbd.h.a.a(true, str, t, jVar);
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2) {
        return com.getui.gtc.dim.DimManager.getInstance().getSetting(str, str2);
    }

    public static <T, R> R a(boolean z, java.lang.String str, T t, com.getui.gtc.extension.distribution.gbd.f.j<T, R> jVar) {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d : " + str + ", " + z);
            if (z) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d : " + str + ", have been allowed");
                return (R) com.getui.gtc.extension.distribution.gbd.h.a.a(true, str, t, jVar);
            }
            if (!com.getui.gtc.extension.distribution.gbd.f.h.c()) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d :" + str + " , h c not enable");
                return null;
            }
            java.lang.String b = com.getui.gtc.extension.distribution.gbd.f.h.b(str);
            if (android.text.TextUtils.isEmpty(b)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d : " + str + ", enabled closed and keyMapping not contains key");
                return null;
            }
            if (!com.getui.gtc.extension.distribution.gbd.f.h.a(str, b)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d :" + str + ", " + b + " , check condition not passed");
                return null;
            }
            if (com.getui.gtc.extension.distribution.gbd.f.h.a(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d :" + str + ", " + b + " , half close passed");
                return (R) com.getui.gtc.extension.distribution.gbd.h.a.a(false, str, t, jVar);
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d :" + str + ", " + b + " , check safe not passed");
            return null;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    public static java.lang.String a(boolean z, java.lang.String str, com.getui.gtc.extension.distribution.gbd.f.f fVar) {
        java.lang.String str2 = (java.lang.String) b(z, str, fVar);
        return android.text.TextUtils.isEmpty(str2) ? "" : str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0058, code lost:
    
        if (com.getui.gtc.extension.distribution.gbd.f.h.a(com.getui.gtc.extension.distribution.gbd.d.c.d) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0031, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(boolean z, java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "hc pre checkEnabled :" + str + ", " + z);
        boolean z2 = true;
        if (!z) {
            java.lang.String b = com.getui.gtc.extension.distribution.gbd.f.h.b(str);
            if (android.text.TextUtils.isEmpty(b)) {
                b = com.getui.gtc.extension.distribution.gbd.f.h.a(str);
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "hc pre checkEnabled(fc&ss) :" + str + ", false, " + b);
            if (com.getui.gtc.extension.distribution.gbd.f.h.a(str, b)) {
            }
            z2 = false;
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "hc pre checkEnabled :" + str + ", r : " + z2);
        return z2;
    }

    private static <T, R> R b(java.lang.String str, T t, com.getui.gtc.extension.distribution.gbd.f.j<T, R> jVar) {
        return (R) a(true, str, t, jVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static <T> T b(boolean z, java.lang.String str, com.getui.gtc.extension.distribution.gbd.f.f fVar) {
        char c;
        java.lang.String str2;
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d c :" + str + ", " + z);
            boolean c2 = com.getui.gtc.extension.distribution.gbd.f.h.c();
            com.getui.gtc.extension.distribution.gbd.f.d a2 = com.getui.gtc.extension.distribution.gbd.f.d.a();
            if (z) {
                if (a2.f) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d c :" + str + " , gtc(>=3260) ctrl half close");
                    return (T) com.getui.gtc.extension.distribution.gbd.h.a.a(true, str, fVar);
                }
                if (a2.a(str)) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d c :" + str + " , both d&c have been allowed");
                    return (T) com.getui.gtc.extension.distribution.gbd.h.a.a(true, str, fVar);
                }
                if (!c2) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d c :" + str + " , h c not enable, from gtc");
                    return (T) com.getui.gtc.extension.distribution.gbd.h.a.a(true, str, fVar);
                }
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d c :" + str + " , gtc not allowed, continue check");
            } else if (!c2) {
                return null;
            }
            if (a2.f) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d c :" + str + " , gtc(>=3260) ctrl half close");
                return (T) com.getui.gtc.extension.distribution.gbd.h.a.a(true, str, fVar);
            }
            java.lang.String a3 = com.getui.gtc.extension.distribution.gbd.f.h.a(str);
            if (android.text.TextUtils.isEmpty(a3)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d c :" + str + " , not allow and keyMapping not contains key");
                return (T) com.getui.gtc.extension.distribution.gbd.h.a.a(false, str, fVar);
            }
            if (!com.getui.gtc.extension.distribution.gbd.f.h.a(str, a3)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d c :" + str + ", " + a3 + " , check condition not passed");
                return null;
            }
            if (!com.getui.gtc.extension.distribution.gbd.f.h.a(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d c :" + str + ", " + a3 + " , check safe not passed");
                return null;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "g d c :" + str + ", " + a3 + " , half close passed");
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    str2 = "set a error : key is empty";
                } else {
                    if (a2.d != null) {
                        try {
                            switch (str.hashCode()) {
                                case 320894984:
                                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.C)) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320894985:
                                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.D)) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320895945:
                                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.G)) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320895946:
                                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.H)) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320919010:
                                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.N)) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            if (c == 0) {
                                a2.a(com.getui.gtc.extension.distribution.gbd.f.e.b.H, com.getui.gtc.extension.distribution.gbd.f.e.b.E);
                            } else if (c == 1) {
                                a2.a(com.getui.gtc.extension.distribution.gbd.f.e.b.C, com.getui.gtc.extension.distribution.gbd.f.e.b.A);
                            } else if (c == 2) {
                                a2.a(com.getui.gtc.extension.distribution.gbd.f.e.b.D, com.getui.gtc.extension.distribution.gbd.f.e.b.B);
                            } else if (c == 3) {
                                a2.a(com.getui.gtc.extension.distribution.gbd.f.e.b.G, com.getui.gtc.extension.distribution.gbd.f.e.b.H, com.getui.gtc.extension.distribution.gbd.f.e.b.E);
                            } else if (c != 4) {
                                a2.a(str);
                            } else {
                                a2.a(com.getui.gtc.extension.distribution.gbd.f.e.b.O, com.getui.gtc.extension.distribution.gbd.f.e.b.M, com.getui.gtc.extension.distribution.gbd.f.e.b.K, com.getui.gtc.extension.distribution.gbd.f.e.b.L);
                            }
                        } catch (java.lang.Throwable th) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                        }
                        return (T) com.getui.gtc.extension.distribution.gbd.h.a.a(false, str, fVar);
                    }
                    str2 = "set a error : globalAllowSysCall is null";
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_D_ALLOW", str2);
                return (T) com.getui.gtc.extension.distribution.gbd.h.a.a(false, str, fVar);
            } finally {
                a2.b(str);
            }
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
            return null;
        }
    }

    private static java.lang.String b(java.lang.String str) {
        return a(true, str, (com.getui.gtc.extension.distribution.gbd.f.f) null);
    }

    private static java.lang.String b(java.lang.String str, com.getui.gtc.extension.distribution.gbd.f.f fVar) {
        return a(true, str, fVar);
    }

    private static <T> T c(java.lang.String str, com.getui.gtc.extension.distribution.gbd.f.f fVar) {
        return (T) b(true, str, fVar);
    }
}
