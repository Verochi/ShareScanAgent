package com.getui.gtc.extension.distribution.gbd.f;

/* loaded from: classes22.dex */
public final class g {
    public static final java.lang.String a = "GBD_Extension";
    private static final java.lang.String b = "sdk.gtc.dim.busi.enable";
    private static final int d = 1;
    private static final int e = 2;
    private int c;
    private boolean f;

    public static class a {
        private static final com.getui.gtc.extension.distribution.gbd.f.g a = new com.getui.gtc.extension.distribution.gbd.f.g((byte) 0);

        private a() {
        }
    }

    private g() {
        this.c = 3;
        boolean a2 = com.getui.gtc.extension.distribution.gbd.f.d.a(3, 2, 9, 0);
        this.f = a2;
        if (a2) {
            java.util.Map<java.lang.String, java.lang.String> a3 = com.getui.gtc.dyc.b.a.a(com.getui.gtc.base.GtcProvider.context(), "GTC");
            if (a3 == null || !a3.containsKey(b)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "extension : parseGtcConfig, use defaultValue busiEnable (" + this.c + ")");
                return;
            }
            this.c = java.lang.Integer.parseInt(a3.get(b));
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "extension : parseGtcConfig, busiEnable(" + this.c + ")");
        }
    }

    public /* synthetic */ g(byte b2) {
        this();
    }

    private boolean a(java.lang.String str, java.lang.String str2) {
        if ((this.c & 1) == 1) {
            return b(str, str2);
        }
        return true;
    }

    public static java.lang.String b() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (com.getui.gtc.dim.Caller caller : com.getui.gtc.dim.Caller.values()) {
                if (caller != null && caller != com.getui.gtc.dim.Caller.UNKNOWN && caller != com.getui.gtc.dim.Caller.WUS) {
                    java.lang.String name = caller.name();
                    java.lang.String[] strArr = com.getui.gtc.extension.distribution.gbd.f.e.a.z;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        java.lang.String str = "#null";
                        if (i >= length) {
                            break;
                        }
                        java.lang.String str2 = strArr[i];
                        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                        java.lang.Object a2 = com.getui.gtc.extension.distribution.gbd.f.c.a(str2, name);
                        if (a2 instanceof java.lang.Boolean) {
                            sb.append(name);
                            sb.append("#");
                            sb.append(str2);
                            sb.append("#");
                            str = ((java.lang.Boolean) a2).booleanValue() ? "1" : "0";
                        } else {
                            sb.append(name);
                            sb.append("#");
                            sb.append(str2);
                        }
                        sb.append(str);
                        sb.append(",");
                        i++;
                    }
                    for (java.lang.String str3 : com.getui.gtc.extension.distribution.gbd.f.e.a.A) {
                        com.getui.gtc.extension.distribution.gbd.f.c unused2 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                        java.lang.Object a3 = com.getui.gtc.extension.distribution.gbd.f.c.a(str3, name);
                        if (a3 instanceof java.lang.Long) {
                            sb.append(name);
                            sb.append("#");
                            sb.append(str3);
                            sb.append("#");
                            sb.append(((java.lang.Long) a3).longValue() / 1000);
                        } else {
                            sb.append(name);
                            sb.append("#");
                            sb.append(str3);
                            sb.append("#null");
                        }
                        sb.append(",");
                    }
                }
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    private boolean b(java.lang.String str) {
        return a(str, null);
    }

    private static boolean b(java.lang.String str, java.lang.String str2) {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.Object a2 = com.getui.gtc.extension.distribution.gbd.f.c.a(str, str2);
        return !(a2 instanceof java.lang.Boolean) || ((java.lang.Boolean) a2).booleanValue();
    }

    private long c(java.lang.String str) {
        if ((this.c & 2) != 2) {
            return -1L;
        }
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.Object a2 = com.getui.gtc.extension.distribution.gbd.f.c.a(str, (java.lang.String) null);
        if (a2 instanceof java.lang.Long) {
            return ((java.lang.Long) a2).longValue();
        }
        return -1L;
    }

    private static com.getui.gtc.extension.distribution.gbd.f.g c() {
        return com.getui.gtc.extension.distribution.gbd.f.g.a.a;
    }

    private void d() {
        java.lang.StringBuilder sb;
        if (this.f) {
            java.util.Map<java.lang.String, java.lang.String> a2 = com.getui.gtc.dyc.b.a.a(com.getui.gtc.base.GtcProvider.context(), "GTC");
            if (a2 == null || !a2.containsKey(b)) {
                sb = new java.lang.StringBuilder("extension : parseGtcConfig, use defaultValue busiEnable (");
            } else {
                this.c = java.lang.Integer.parseInt(a2.get(b));
                sb = new java.lang.StringBuilder("extension : parseGtcConfig, busiEnable(");
            }
            sb.append(this.c);
            sb.append(")");
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, sb.toString());
        }
    }

    private boolean d(java.lang.String str) {
        return a(com.getui.gtc.extension.distribution.gbd.f.e.a.c, com.getui.gtc.extension.distribution.gbd.f.e.a.d, com.getui.gtc.extension.distribution.gbd.d.h.bg, "lbs-net", str);
    }

    public final boolean a() {
        try {
            return !a(com.getui.gtc.extension.distribution.gbd.f.e.a.w, com.getui.gtc.dim.Caller.IDO.name());
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public final boolean a(java.lang.String str) {
        return a(com.getui.gtc.extension.distribution.gbd.f.e.a.e, com.getui.gtc.extension.distribution.gbd.f.e.a.f, -1L, "lbs-gps", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fc A[Catch: all -> 0x0126, TryCatch #0 {all -> 0x0126, blocks: (B:3:0x002e, B:6:0x0034, B:9:0x004e, B:12:0x0058, B:16:0x0076, B:18:0x0080, B:20:0x008b, B:21:0x0094, B:25:0x00cc, B:27:0x00e4, B:28:0x00f8, B:30:0x00fc, B:32:0x0111), top: B:2:0x002e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(java.lang.String str, java.lang.String str2, long j, java.lang.String str3, java.lang.String str4) {
        java.lang.String str5;
        long j2;
        java.lang.String str6 = str3 + "(" + str + ", " + str2 + ")";
        try {
            if (!this.f) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "extension : " + str6 + " enable true (gtc < 3290), " + str4);
                return true;
            }
            if (!a(str, null)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "extension : check " + str6 + " enable false, " + str4);
                return false;
            }
            if (j >= 0) {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if ((this.c & 2) == 2) {
                    com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                    java.lang.Object a2 = com.getui.gtc.extension.distribution.gbd.f.c.a(str2, (java.lang.String) null);
                    if (a2 instanceof java.lang.Long) {
                        j2 = ((java.lang.Long) a2).longValue();
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("extension : check ");
                        sb.append(str6);
                        sb.append("  enable true, lastTime(");
                        sb.append(j);
                        sb.append("), timeDiff(");
                        long j3 = currentTimeMillis - j;
                        sb.append(j3);
                        sb.append("), interval(");
                        sb.append(j2);
                        sb.append("), ");
                        sb.append(str4);
                        com.getui.gtc.extension.distribution.gbd.n.j.a(a, sb.toString());
                        if (j2 >= 0) {
                            str5 = "extension : check " + str6 + " ,not check ," + str4;
                        } else {
                            if (j3 < j2) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "extension : check " + str6 + " interval false, " + str4);
                                return false;
                            }
                            str5 = "extension : check " + str6 + " interval true, " + str4;
                        }
                    }
                }
                j2 = -1;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("extension : check ");
                sb2.append(str6);
                sb2.append("  enable true, lastTime(");
                sb2.append(j);
                sb2.append("), timeDiff(");
                long j32 = currentTimeMillis - j;
                sb2.append(j32);
                sb2.append("), interval(");
                sb2.append(j2);
                sb2.append("), ");
                sb2.append(str4);
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, sb2.toString());
                if (j2 >= 0) {
                }
            } else {
                str5 = "extension : check " + str6 + " enable true, " + str4;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, str5);
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return true;
        }
    }
}
