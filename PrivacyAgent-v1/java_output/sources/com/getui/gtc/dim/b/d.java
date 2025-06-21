package com.getui.gtc.dim.b;

/* loaded from: classes22.dex */
public final class d {
    public final java.util.Map<java.lang.String, java.lang.Long> a;

    public static class a {
        private static final com.getui.gtc.dim.b.d a = new com.getui.gtc.dim.b.d((byte) 0);
    }

    private d() {
        this.a = new java.util.HashMap();
        try {
            com.getui.gtc.base.db.DbManager.init(com.getui.gtc.base.GtcProvider.context(), com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class);
            ((com.getui.gtc.dim.a.b) com.getui.gtc.base.db.DbManager.getTable(com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class)).a();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public static com.getui.gtc.dim.b.h a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return ((com.getui.gtc.dim.a.b) com.getui.gtc.base.db.DbManager.getTable(com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class)).a(str);
    }

    public static boolean a(java.lang.String str, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return ((com.getui.gtc.dim.a.b) com.getui.gtc.base.db.DbManager.getTable(com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class)).a(str, obj);
    }

    private java.lang.Long b(java.lang.String str) {
        try {
            if (this.a.containsKey(str)) {
                return this.a.get(str);
            }
            com.getui.gtc.dim.b.d unused = com.getui.gtc.dim.b.d.a.a;
            com.getui.gtc.dim.b.h a2 = a(str);
            java.lang.Long l = a2 != null ? (java.lang.Long) a2.a : null;
            com.getui.gtc.dim.e.b.a("dim interval from db : " + str + " : " + l);
            this.a.put(str, l);
            return l;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(com.umeng.analytics.pro.bo.ba, th);
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static long c(java.lang.String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 320892099:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.w)) {
                    c = 0;
                    break;
                }
                break;
            case 320894021:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.y)) {
                    c = 1;
                    break;
                }
                break;
            case 320894022:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.z)) {
                    c = 2;
                    break;
                }
                break;
            case 320894982:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.A)) {
                    c = 3;
                    break;
                }
                break;
            case 320894983:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.B)) {
                    c = 4;
                    break;
                }
                break;
            case 320894984:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.C)) {
                    c = 5;
                    break;
                }
                break;
            case 320894985:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.D)) {
                    c = 6;
                    break;
                }
                break;
            case 320895943:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.E)) {
                    c = 7;
                    break;
                }
                break;
            case 320895944:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.F)) {
                    c = '\b';
                    break;
                }
                break;
            case 320895945:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.G)) {
                    c = '\t';
                    break;
                }
                break;
            case 320895946:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.H)) {
                    c = '\n';
                    break;
                }
                break;
            case 320896904:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.I)) {
                    c = 11;
                    break;
                }
                break;
            case 320896905:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.J)) {
                    c = '\f';
                    break;
                }
                break;
            case 320919007:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.K)) {
                    c = '\r';
                    break;
                }
                break;
            case 320919008:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.L)) {
                    c = 14;
                    break;
                }
                break;
            case 320919009:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.M)) {
                    c = 15;
                    break;
                }
                break;
            case 320919011:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.O)) {
                    c = 16;
                    break;
                }
                break;
            case 1672919129:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.b)) {
                    c = 17;
                    break;
                }
                break;
            case 1672919131:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.c)) {
                    c = 18;
                    break;
                }
                break;
            case 1672919132:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.d)) {
                    c = 19;
                    break;
                }
                break;
            case 1672920090:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.e)) {
                    c = 20;
                    break;
                }
                break;
            case 1672920092:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.f)) {
                    c = 21;
                    break;
                }
                break;
            case 1672920093:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.g)) {
                    c = 22;
                    break;
                }
                break;
            case 1672921051:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.h)) {
                    c = 23;
                    break;
                }
                break;
            case 1672921052:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.i)) {
                    c = 24;
                    break;
                }
                break;
            case 1672922012:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.j)) {
                    c = 25;
                    break;
                }
                break;
            case 1672922973:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.k)) {
                    c = com.alibaba.fastjson.parser.JSONLexer.EOI;
                    break;
                }
                break;
            case 1672922974:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.l)) {
                    c = 27;
                    break;
                }
                break;
            case 1672923934:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.m)) {
                    c = 28;
                    break;
                }
                break;
            case 1672923936:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.n)) {
                    c = 29;
                    break;
                }
                break;
            case 1672923937:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.o)) {
                    c = 30;
                    break;
                }
                break;
            case 1672924895:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.p)) {
                    c = 31;
                    break;
                }
                break;
            case 1672925856:
                if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.q)) {
                    c = ' ';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\f':
                return 5000L;
            case '\r':
            case 14:
            case 15:
            case 16:
                return com.anythink.expressad.d.a.b.aD;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case ' ':
                return 86400000L;
            default:
                return 0L;
        }
    }

    public final java.lang.Long a(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str2)) {
            return b(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + com.getui.gtc.dim.Caller.valueOf(str2).name());
        }
        com.getui.gtc.dim.b.g d = com.getui.gtc.dim.b.g.d();
        int c = d.c();
        com.getui.gtc.dim.b.a a2 = com.getui.gtc.dim.b.a.a(str);
        if (a2 == null) {
            return null;
        }
        java.lang.Long l = null;
        for (com.getui.gtc.dim.Caller caller : com.getui.gtc.dim.Caller.values()) {
            if (caller.containAt(c)) {
                java.lang.Boolean b = d.b(a2.a, caller.name());
                java.lang.Long b2 = b(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + caller.name());
                com.getui.gtc.dim.e.b.a("dim check interval for " + str + ", inited caller = " + caller + ", callable = " + b + ", interval = " + b2);
                if (b == null || b.booleanValue()) {
                    if (b2 == null) {
                        return null;
                    }
                    if (l == null || b2.longValue() < l.longValue()) {
                        l = b2;
                    }
                }
            }
        }
        return l;
    }

    public final void a(java.lang.String str, long j) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.a.put(str, java.lang.Long.valueOf(j));
        com.getui.gtc.dim.e.b.a("dim storage globalValidTime set: " + str + " : " + j);
    }

    public final boolean a(com.getui.gtc.dim.b.h hVar, java.lang.String str) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        long c = c(str);
        java.lang.Long l = this.a.get(str);
        if (l == null) {
            l = this.a.get("dim-2-2-0-1");
        }
        long longValue = l != null ? l.longValue() : c;
        java.lang.Long l2 = null;
        if ((com.getui.gtc.dim.b.g.d().a() & 2) != 0) {
            com.getui.gtc.dim.b.a a2 = com.getui.gtc.dim.b.a.a(str);
            if (a2 != null) {
                l2 = a(a2.b, (java.lang.String) null);
            }
        } else {
            com.getui.gtc.dim.e.b.a("dim ig in");
        }
        if (l2 != null) {
            longValue = l2.longValue();
        }
        com.getui.gtc.dim.e.b.a("dim storageValidTime check for " + str + ", dycValue = " + l + ", localValue = " + c + ", interval = " + l2 + ", use " + longValue);
        boolean z = currentTimeMillis - hVar.b > longValue;
        if (z) {
            com.getui.gtc.dim.e.b.b("dim storage source expired for ".concat(java.lang.String.valueOf(str)));
        }
        return z;
    }
}
