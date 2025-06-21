package com.getui.gtc.extension.distribution.gbd.f;

/* loaded from: classes22.dex */
public final class d {
    public static final int a = 2;
    public static final int b = 1;
    private static final java.lang.String g = "GBD_D_ALLOW";
    private static final com.getui.gtc.extension.distribution.gbd.f.d h = new com.getui.gtc.extension.distribution.gbd.f.d();
    public final java.util.Map<java.lang.String, java.lang.Integer> c;
    final java.util.Map<java.lang.String, java.lang.Integer> d;
    public final boolean e = com.getui.gtc.extension.distribution.gbd.n.l.a(3, 2, 2, 0);
    final boolean f = com.getui.gtc.extension.distribution.gbd.n.l.a(3, 2, 6, 0);

    /* JADX WARN: Removed duplicated region for block: B:5:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private d() {
        java.util.HashMap hashMap;
        java.util.Map<java.lang.String, java.lang.Integer> c = c();
        if (c != null) {
            try {
                hashMap = new java.util.HashMap(c);
            } catch (java.lang.Throwable unused) {
            }
            if (hashMap == null) {
                this.d = c;
                this.c = hashMap;
                return;
            } else {
                this.d = null;
                this.c = null;
                return;
            }
        }
        hashMap = null;
        if (hashMap == null) {
        }
    }

    public static com.getui.gtc.extension.distribution.gbd.f.d a() {
        return h;
    }

    public static boolean a(int... iArr) {
        return com.getui.gtc.extension.distribution.gbd.n.l.a(iArr);
    }

    private void b(java.lang.String... strArr) {
        com.getui.gtc.extension.distribution.gbd.n.j.b(g, "restore a : " + java.util.Arrays.toString(strArr));
        for (java.lang.String str : strArr) {
            java.lang.Integer num = this.c.get(str);
            if (num == null) {
                this.d.remove(str);
            } else {
                this.d.put(str, num);
            }
        }
    }

    private boolean b() {
        java.util.Map<java.lang.String, java.lang.Integer> map;
        java.lang.String str;
        java.util.Map<java.lang.String, java.lang.Integer> map2 = this.c;
        if (map2 == null) {
            return false;
        }
        java.lang.Integer num = map2.get(com.getui.gtc.extension.distribution.gbd.f.e.b.y);
        if (num == null) {
            if (this.e) {
                map = this.c;
                str = "dim-2-2-0-1";
            } else {
                map = this.c;
                str = "dim-2-2-3-1";
            }
            num = map.get(str);
        }
        return num != null && (num.intValue() == 2 || (num.intValue() == 1 && com.getui.gtc.extension.distribution.gbd.n.l.d()));
    }

    private static java.util.Map<java.lang.String, java.lang.Integer> c() {
        java.lang.String str;
        try {
            java.lang.String str2 = "f";
            java.lang.String str3 = "b";
            if (com.getui.gtc.extension.distribution.gbd.n.l.a(3, 2, 9, 0)) {
                str = "g";
                com.getui.gtc.extension.distribution.gbd.n.j.a(g, "gtc dim version : above 3290");
            } else if (com.getui.gtc.extension.distribution.gbd.n.l.a(3, 2, 6, 0)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(g, "gtc dim version : above 3260");
                str = "f";
                str2 = "e";
            } else {
                str2 = "d";
                if (com.getui.gtc.extension.distribution.gbd.n.l.a(3, 2, 1, 0)) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(g, "gtc dim version : above 3210");
                    str = "e";
                } else {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(g, "gtc dim version : below and is  3210");
                    str3 = "a";
                    str = "d";
                }
            }
            java.lang.reflect.Field declaredField = java.lang.Class.forName("com.getui.gtc.dim.b.".concat(str2)).getDeclaredField(str3);
            declaredField.setAccessible(true);
            java.lang.reflect.Field declaredField2 = java.lang.Class.forName("com.getui.gtc.dim.b." + str + "$a").getDeclaredField("a");
            declaredField2.setAccessible(true);
            java.lang.Object obj = declaredField2.get(null);
            com.getui.gtc.extension.distribution.gbd.n.j.a(g, "gtc dim: " + declaredField.get(obj).toString());
            return (java.util.Map) declaredField.get(obj);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private boolean c(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.Integer> map;
        java.lang.String str2;
        java.lang.Integer num = this.c.get(str);
        if (num == null) {
            if (this.e) {
                map = this.c;
                str2 = "dim-2-2-0-1";
            } else {
                map = this.c;
                str2 = "dim-2-2-3-1";
            }
            num = map.get(str2);
        }
        if (num != null) {
            return num.intValue() == 2 || (num.intValue() == 1 && com.getui.gtc.extension.distribution.gbd.n.l.d());
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void d(java.lang.String str) {
        char c;
        java.lang.String str2;
        if (android.text.TextUtils.isEmpty(str)) {
            str2 = "set a error : key is empty";
        } else {
            if (this.d != null) {
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
                        a(com.getui.gtc.extension.distribution.gbd.f.e.b.H, com.getui.gtc.extension.distribution.gbd.f.e.b.E);
                        return;
                    }
                    if (c == 1) {
                        a(com.getui.gtc.extension.distribution.gbd.f.e.b.C, com.getui.gtc.extension.distribution.gbd.f.e.b.A);
                        return;
                    }
                    if (c == 2) {
                        a(com.getui.gtc.extension.distribution.gbd.f.e.b.D, com.getui.gtc.extension.distribution.gbd.f.e.b.B);
                        return;
                    }
                    if (c == 3) {
                        a(com.getui.gtc.extension.distribution.gbd.f.e.b.G, com.getui.gtc.extension.distribution.gbd.f.e.b.H, com.getui.gtc.extension.distribution.gbd.f.e.b.E);
                        return;
                    } else if (c != 4) {
                        a(str);
                        return;
                    } else {
                        a(com.getui.gtc.extension.distribution.gbd.f.e.b.O, com.getui.gtc.extension.distribution.gbd.f.e.b.M, com.getui.gtc.extension.distribution.gbd.f.e.b.K, com.getui.gtc.extension.distribution.gbd.f.e.b.L);
                        return;
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    return;
                }
            }
            str2 = "set a error : globalAllowSysCall is null";
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(g, str2);
    }

    private boolean d() {
        return this.f;
    }

    public final void a(java.lang.String... strArr) {
        com.getui.gtc.extension.distribution.gbd.n.j.b(g, "set a : " + java.util.Arrays.toString(strArr));
        for (java.lang.String str : strArr) {
            this.d.put(str, 2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean a(java.lang.String str) {
        char c;
        java.lang.String str2;
        if (android.text.TextUtils.isEmpty(str)) {
            str2 = "is a error : key is empty";
        } else {
            if (this.c != null) {
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
                    return c != 0 ? c != 1 ? c != 2 ? c != 3 ? c != 4 ? c(str) : c(com.getui.gtc.extension.distribution.gbd.f.e.b.O) || c(com.getui.gtc.extension.distribution.gbd.f.e.b.M) || c(com.getui.gtc.extension.distribution.gbd.f.e.b.K) || c(com.getui.gtc.extension.distribution.gbd.f.e.b.L) : c(com.getui.gtc.extension.distribution.gbd.f.e.b.G) || c(com.getui.gtc.extension.distribution.gbd.f.e.b.H) || c(com.getui.gtc.extension.distribution.gbd.f.e.b.E) : c(com.getui.gtc.extension.distribution.gbd.f.e.b.D) || c(com.getui.gtc.extension.distribution.gbd.f.e.b.B) : c(com.getui.gtc.extension.distribution.gbd.f.e.b.C) || c(com.getui.gtc.extension.distribution.gbd.f.e.b.A) : c(com.getui.gtc.extension.distribution.gbd.f.e.b.H) || c(com.getui.gtc.extension.distribution.gbd.f.e.b.E);
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    return false;
                }
            }
            str2 = "is a error : rawClone is null";
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(g, str2);
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void b(java.lang.String str) {
        char c;
        java.lang.String str2;
        if (android.text.TextUtils.isEmpty(str)) {
            str2 = "restore a error : k is empty";
        } else {
            if (this.d != null) {
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
                        b(com.getui.gtc.extension.distribution.gbd.f.e.b.H, com.getui.gtc.extension.distribution.gbd.f.e.b.E);
                        return;
                    }
                    if (c == 1) {
                        b(com.getui.gtc.extension.distribution.gbd.f.e.b.C, com.getui.gtc.extension.distribution.gbd.f.e.b.A);
                        return;
                    }
                    if (c == 2) {
                        b(com.getui.gtc.extension.distribution.gbd.f.e.b.D, com.getui.gtc.extension.distribution.gbd.f.e.b.B);
                        return;
                    }
                    if (c == 3) {
                        b(com.getui.gtc.extension.distribution.gbd.f.e.b.G, com.getui.gtc.extension.distribution.gbd.f.e.b.H, com.getui.gtc.extension.distribution.gbd.f.e.b.E);
                        return;
                    } else if (c != 4) {
                        b(str);
                        return;
                    } else {
                        b(com.getui.gtc.extension.distribution.gbd.f.e.b.O, com.getui.gtc.extension.distribution.gbd.f.e.b.M, com.getui.gtc.extension.distribution.gbd.f.e.b.K, com.getui.gtc.extension.distribution.gbd.f.e.b.L);
                        return;
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    return;
                }
            }
            str2 = "restore a error : gtc c is null";
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(g, str2);
    }
}
