package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class ab {
    private static final java.lang.String a = "GBD_sdu";

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.ab$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<android.content.Context, java.lang.Boolean> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.Boolean a2(android.content.Context context) {
            if (!com.getui.gtc.extension.distribution.gbd.d.d.dx) {
                return java.lang.Boolean.FALSE;
            }
            try {
                return java.lang.Boolean.valueOf(((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimState() == 5);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return java.lang.Boolean.FALSE;
            }
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.Boolean a(android.content.Context context) {
            return a2(context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        if (r9 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(int i, android.content.Context context) {
        android.net.Uri parse = android.net.Uri.parse("content://telephony/siminfo");
        android.content.ContentResolver contentResolver = context.getContentResolver();
        if (!com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, com.anythink.china.common.d.a)) {
            return -1;
        }
        android.database.Cursor cursor = null;
        try {
            cursor = contentResolver.query(parse, new java.lang.String[]{"_id", "sim_id"}, "sim_id = ?", new java.lang.String[]{java.lang.String.valueOf(i)}, null);
            if (cursor != null && cursor.moveToFirst()) {
                int i2 = cursor.getInt(cursor.getColumnIndex("_id"));
                cursor.close();
                return i2;
            }
        } catch (java.lang.Throwable th) {
            try {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    public static int a(android.content.Context context) {
        try {
            if (com.getui.gtc.extension.distribution.gbd.d.d.dx) {
                return ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimState();
            }
            return 0;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return 0;
        }
    }

    private static int a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "operator ".concat(java.lang.String.valueOf(str)));
        str.hashCode();
        switch (str) {
            case "46000":
            case "46002":
            case "46004":
            case "46007":
                return 1;
            case "46001":
            case "46006":
            case "46009":
                return 2;
            case "46003":
            case "46005":
            case "46011":
                return 3;
            default:
                return 4;
        }
    }

    public static java.lang.String a() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b("gbd", "get sn ");
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            return com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.m, (com.getui.gtc.extension.distribution.gbd.f.f) null);
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            return "";
        }
    }

    public static java.lang.String a(int i) {
        java.lang.String str;
        if (i == 1) {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            str = com.getui.gtc.extension.distribution.gbd.f.e.b.n;
        } else {
            if (i != 2) {
                return "";
            }
            com.getui.gtc.extension.distribution.gbd.f.c unused2 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            str = com.getui.gtc.extension.distribution.gbd.f.e.b.o;
        }
        return com.getui.gtc.extension.distribution.gbd.f.c.a(true, str, (com.getui.gtc.extension.distribution.gbd.f.f) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b() {
        char c;
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.w, (com.getui.gtc.extension.distribution.gbd.f.f) null);
            if (android.text.TextUtils.isEmpty(a2)) {
                return 4;
            }
            int hashCode = a2.hashCode();
            if (hashCode == 618558396) {
                if (a2.equals("中国电信")) {
                    c = 2;
                    if (c != 0) {
                    }
                }
                c = 65535;
                if (c != 0) {
                }
            } else if (hashCode != 618596989) {
                if (hashCode == 618663094 && a2.equals("中国联通")) {
                    c = 1;
                    if (c != 0) {
                        return 1;
                    }
                    if (c != 1) {
                        return c != 2 ? 4 : 3;
                    }
                    return 2;
                }
                c = 65535;
                if (c != 0) {
                }
            } else {
                if (a2.equals("中国移动")) {
                    c = 0;
                    if (c != 0) {
                    }
                }
                c = 65535;
                if (c != 0) {
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return 4;
        }
    }

    public static java.lang.String b(android.content.Context context) {
        java.lang.String line1Number;
        java.lang.String str;
        java.lang.String str2;
        boolean a2 = com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, com.anythink.china.common.d.a);
        java.lang.String str3 = "";
        if (!com.getui.gtc.extension.distribution.gbd.d.d.p || !a2) {
            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_PN", "not collect old local pn or no phone permission.");
            return "";
        }
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            line1Number = telephonyManager.getLine1Number();
            if (com.getui.gtc.extension.distribution.gbd.d.d.o) {
                int a3 = a(0, context);
                int a4 = a(1, context);
                java.lang.reflect.Method method = telephonyManager.getClass().getMethod("getLine1Number", java.lang.Integer.TYPE);
                java.lang.String str4 = (java.lang.String) method.invoke(telephonyManager, java.lang.Integer.valueOf(a3));
                str2 = (java.lang.String) method.invoke(telephonyManager, java.lang.Integer.valueOf(a4));
                if (!android.text.TextUtils.isEmpty(line1Number) || !android.text.TextUtils.isEmpty(str4) || !android.text.TextUtils.isEmpty(str2)) {
                    str3 = line1Number + "#" + str4 + "," + str2;
                }
                str = str3;
                str3 = str4;
            } else {
                str = android.text.TextUtils.isEmpty(line1Number) ? "" : line1Number;
                str2 = "";
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_PN", "local MultiSlotEnable = " + com.getui.gtc.extension.distribution.gbd.d.d.o + ", local pn = " + line1Number + "#" + str3 + "," + str2);
            return str;
        } catch (java.lang.Throwable th2) {
            th = th2;
            str3 = str;
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return str3;
        }
    }

    public static boolean c() {
        for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.d.cE.split(",")) {
            try {
                java.lang.Class.forName(str + ".UniAccountHelper");
                com.getui.gtc.extension.distribution.gbd.d.h.aV = str;
                return true;
            } catch (java.lang.Throwable unused) {
            }
        }
        return false;
    }

    private static boolean c(android.content.Context context) {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.Boolean bool = (java.lang.Boolean) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "sm", context, new com.getui.gtc.extension.distribution.gbd.n.ab.AnonymousClass1());
        return bool != null && bool.booleanValue();
    }

    private static boolean d() {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) com.getui.gtc.extension.distribution.gbd.d.c.d.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    private static boolean e() {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) com.getui.gtc.extension.distribution.gbd.d.c.d.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
    }

    private static int f() {
        try {
            try {
                java.lang.Class.forName(new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.e.a(com.getui.gtc.extension.distribution.gbd.d.g.bp)) + "CtAuth");
                return 1;
            } catch (java.lang.Throwable unused) {
                return -1;
            }
        } catch (java.lang.Throwable unused2) {
            java.lang.Class.forName(new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.e.a(com.getui.gtc.extension.distribution.gbd.d.g.bo)) + "CtAuth");
            return 2;
        }
    }

    private static boolean g() {
        java.lang.String str;
        int i;
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(com.getui.gtc.extension.distribution.gbd.d.d.cF.split(",")));
        if ((android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cF) || "none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.cF)) || !arrayList.contains(com.anythink.expressad.d.a.b.dx)) {
            return true;
        }
        try {
            str = new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.e.a(com.getui.gtc.extension.distribution.gbd.d.g.bo));
            i = com.getui.gtc.extension.distribution.gbd.d.h.aQ;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        if (i == 1) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append("a");
            return !android.text.TextUtils.isEmpty((java.lang.String) java.lang.Class.forName(sb.toString()).getField("a").get(null));
        }
        if (i != 2) {
            return false;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(str);
        sb2.append("CtAuth");
        return !android.text.TextUtils.isEmpty((java.lang.String) java.lang.Class.forName(sb2.toString()).getField("mAppId").get(null));
    }

    private static boolean h() {
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(com.getui.gtc.extension.distribution.gbd.d.d.cF.split(",")));
        if ((android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cF) || "none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.cF)) || !arrayList.contains(com.ss.android.socialbase.downloader.segment.Segment.JsonKey.CURRENT)) {
            return true;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(com.getui.gtc.extension.distribution.gbd.d.h.aV + ".UniAccountHelper");
            java.lang.Object invoke = cls.getMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mContext");
            declaredField.setAccessible(true);
            return ((android.content.Context) declaredField.get(invoke)) != null;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }
}
