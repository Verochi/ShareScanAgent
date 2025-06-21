package com.anythink.core.common.h;

/* loaded from: classes12.dex */
public final class c {
    public static final java.lang.String A = "it_src";
    public static final java.lang.String B = "lat";
    public static final java.lang.String C = "lon";
    public static final java.lang.String D = "inst_wx";
    public static final java.lang.String E = "mini_sdk";
    public static final java.lang.String F = "ms_type";
    public static final java.lang.String G = "device_set";
    public static final java.lang.String H = "gdpr_cs";
    public static final java.lang.String I = "abtest_id";
    public static final java.lang.String J = "first_init_time";
    public static final java.lang.String K = "days_from_first_init";
    public static final java.lang.String L = "cs_cl";
    public static final java.lang.String M = "is_ofm";
    public static final java.lang.String N = "app_id";
    public static final java.lang.String O = "api_ver";
    public static final java.lang.String P = "custom";
    public static final java.lang.String Q = "rdid";
    public static final java.lang.String R = "rc";
    public static final java.lang.String S = "data";
    public static final java.lang.String T = "tcp_tk_da_type";
    public static final java.lang.String U = "ofl";
    public static final java.lang.String V = "tcp_rate";
    public static final java.lang.String W = "p";
    public static final java.lang.String X = "p2";
    public static final java.lang.String Y = "sign";
    public static final java.lang.String Z = "common";
    public static final java.lang.String a = "platform";
    public static final java.lang.String aA = "c_num";
    public static final java.lang.String aB = "t_store";
    public static final int aa = 1;
    public static final int ab = 2;
    public static final int ac = 3;
    public static final java.lang.String ad = "area_type";
    public static final java.lang.String ae = "sp_http";
    public static final java.lang.String af = "os_fw";
    public static final java.lang.String ag = "is_test";
    public static final java.lang.String ah = "mdna_oid";
    public static final java.lang.String ai = "mdna_appkey";
    public static final java.lang.String aj = "mdna_r";
    public static final java.lang.String ak = "user_num";
    public static final java.lang.String al = "cp_device_id";
    public static final java.lang.String am = "cp_pl_id";
    public static int an = -1;
    public static int ao = -1;
    public static final java.lang.String ap = "al_it_apil";
    public static final java.lang.String aq = "wx_data";
    public static final java.lang.String ar = "cached";
    public static final java.lang.String as = "cached";
    public static final java.lang.String at = "n_cache";
    public static final java.lang.String au = "get_1st_rl";
    public static final java.lang.String av = "value_d";
    public static final java.lang.String aw = "pl_type";
    public static final java.lang.String ax = "amazon_id";
    public static final java.lang.String ay = "amazon_lat";
    public static final java.lang.String az = "t_mem";
    public static final java.lang.String b = "os_vn";
    public static final java.lang.String c = "os_vc";
    public static final java.lang.String d = "package_name";
    public static final java.lang.String e = "app_vn";
    public static final java.lang.String f = "app_vc";
    public static final java.lang.String g = "brand";
    public static final java.lang.String h = "model";
    public static final java.lang.String i = "screen";
    public static final java.lang.String j = "network_type";
    public static final java.lang.String k = "mnc";
    public static final java.lang.String l = "mcc";
    public static final java.lang.String m = "language";
    public static final java.lang.String n = "timezone";
    public static final java.lang.String o = "sdk_ver";
    public static final java.lang.String p = "gp_ver";
    public static final java.lang.String q = "nw_ver";
    public static final java.lang.String r = "ua";

    /* renamed from: s, reason: collision with root package name */
    public static final java.lang.String f177s = "orient";
    public static final java.lang.String t = "system";
    public static final java.lang.String u = "android_id";
    public static final java.lang.String v = "gaid";
    public static final java.lang.String w = "channel";
    public static final java.lang.String x = "sub_channel";
    public static final java.lang.String y = "upid";
    public static final java.lang.String z = "ps_id";

    public static org.json.JSONObject a() {
        return a(com.anythink.core.common.b.o.a().l());
    }

    public static org.json.JSONObject a(int i2) {
        java.util.List<com.anythink.core.common.f.s> n2;
        org.json.JSONObject aw2;
        com.anythink.core.common.o.e.r(com.anythink.core.common.b.o.a().f());
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        android.content.Context f2 = com.anythink.core.common.b.o.a().f();
        try {
            jSONObject.put("platform", 1);
            jSONObject.put("os_vn", com.anythink.core.common.o.e.e());
            jSONObject.put("os_vc", com.anythink.core.common.o.e.d());
            jSONObject.put("package_name", com.anythink.core.common.o.e.l(f2));
            jSONObject.put("app_vn", com.anythink.core.common.o.e.j(f2));
            jSONObject.put("app_vc", com.anythink.core.common.o.e.i(f2));
            jSONObject.put("brand", com.anythink.core.common.o.e.b());
            jSONObject.put("model", com.anythink.core.common.o.e.a());
            jSONObject.put("screen", com.anythink.core.common.o.e.k(f2));
            jSONObject.put("network_type", com.anythink.core.common.o.e.n(f2));
            jSONObject.put("mnc", com.anythink.core.common.o.e.c(f2));
            jSONObject.put("mcc", com.anythink.core.common.o.e.b(f2));
            jSONObject.put("language", com.anythink.core.common.o.e.f(f2));
            jSONObject.put("timezone", com.anythink.core.common.o.e.c());
            jSONObject.put("sdk_ver", com.anythink.core.common.o.h.a());
            jSONObject.put("gp_ver", com.anythink.core.common.o.e.o(f2));
            jSONObject.put("ua", com.anythink.core.common.o.e.i());
            jSONObject.put("orient", com.anythink.core.common.o.e.g(f2));
            jSONObject.put("system", 1);
            if (!android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().m())) {
                jSONObject.put("channel", com.anythink.core.common.b.o.a().m());
            }
            if (!android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().n())) {
                jSONObject.put("sub_channel", com.anythink.core.common.b.o.a().n());
            }
            jSONObject.put("upid", com.anythink.core.common.b.r.a(f2).b() ? com.anythink.core.common.b.o.a().x() : "");
            jSONObject.put("ps_id", com.anythink.core.common.b.o.a().q());
            com.anythink.core.d.a b2 = com.anythink.core.d.b.a(f2).b(com.anythink.core.common.b.o.a().o());
            if (b2 != null) {
                jSONObject.put(I, android.text.TextUtils.isEmpty(b2.I()) ? "" : b2.I());
            }
            jSONObject.put(J, com.anythink.core.common.b.o.a().g());
            jSONObject.put(K, com.anythink.core.common.b.o.a().h());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.anythink.core.common.b.o.a().d());
            sb.append(com.anythink.core.common.b.r.a(f2).a());
            jSONObject.put(H, sb.toString());
            if (com.anythink.core.common.b.o.a().i() == 1) {
                jSONObject.put(M, 1);
            }
            if (com.anythink.core.common.b.o.a().H() && com.anythink.core.common.b.j.a().a(b2)) {
                java.lang.String b3 = com.anythink.core.common.b.j.a().b();
                java.lang.String c2 = com.anythink.core.common.b.j.a().c();
                java.lang.String d2 = com.anythink.core.common.b.j.a().d();
                if (android.text.TextUtils.isEmpty(b3)) {
                    b3 = "";
                }
                jSONObject.put(ah, b3);
                if (android.text.TextUtils.isEmpty(c2)) {
                    c2 = "";
                }
                jSONObject.put(ai, c2);
                jSONObject.put(Q, android.text.TextUtils.isEmpty(d2) ? "" : d2);
                jSONObject.put("mdna_r", com.anythink.core.common.b.o.a().K());
            }
            jSONObject.put(ae, com.anythink.core.common.b.o.a().C() ? com.anythink.core.common.b.o.a().D() ? "1" : "3" : com.anythink.core.common.b.o.a().D() ? "2" : "4");
            com.anythink.core.api.IExHandler b4 = com.anythink.core.common.b.o.a().b();
            if (b4 != null) {
                b4.fillRequestDeviceData(jSONObject, i2);
            }
            java.lang.String j2 = com.anythink.core.common.o.e.j();
            if (!android.text.TextUtils.isEmpty(j2)) {
                jSONObject.put(af, java.lang.Integer.parseInt(j2));
            }
            if ((i2 & 4) == 4) {
                try {
                    com.anythink.core.d.a b5 = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
                    if (b5 != null && (aw2 = b5.aw()) != null) {
                        jSONObject.put("a_c", aw2);
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            if ((i2 & 16) == 16 && (n2 = com.anythink.core.common.o.e.n()) != null && n2.size() > 0) {
                for (int i3 = 0; i3 < n2.size(); i3++) {
                    com.anythink.core.common.f.s sVar = n2.get(i3);
                    if (sVar != null && !android.text.TextUtils.isEmpty(sVar.b())) {
                        jSONObject.put(sVar.a(), sVar.b());
                    }
                }
            }
        } catch (java.lang.Exception unused2) {
        }
        return jSONObject;
    }

    public static org.json.JSONObject a(java.lang.String str) {
        return a(com.anythink.core.common.b.o.a().d(str));
    }

    public static org.json.JSONObject a(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                for (java.lang.String str : map.keySet()) {
                    java.lang.Object obj = map.get(str);
                    if (obj != null) {
                        try {
                            jSONObject.put(str, obj.toString());
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                }
            } catch (java.lang.Throwable unused2) {
            }
            return jSONObject;
        } catch (java.lang.Throwable unused3) {
            return null;
        }
    }

    private static void a(android.content.Context context, org.json.JSONObject jSONObject) {
        int i2 = an;
        if (i2 == -1) {
            boolean c2 = com.anythink.core.common.o.h.c(context);
            boolean b2 = com.anythink.core.common.o.h.b(context);
            int i3 = b2 ? 2 : c2 ? 1 : 0;
            if (c2 && b2) {
                i3 = 3;
            }
            if (i3 > 0) {
                jSONObject.put(F, i3);
            }
            an = i3;
        } else if (i2 > 0) {
            jSONObject.put(F, i2);
        }
        int i4 = ao;
        if (i4 != -1) {
            if (i4 == 1) {
                jSONObject.put(E, i4);
            }
        } else {
            boolean c3 = com.anythink.core.common.o.h.c();
            if (c3) {
                jSONObject.put(E, 1);
            }
            ao = c3 ? 1 : 0;
        }
    }

    public static void a(org.json.JSONObject jSONObject) {
        try {
            com.anythink.core.common.f.ax L2 = com.anythink.core.common.b.o.a().L();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            int i2 = 1;
            if (L2.b() != 1) {
                i2 = 0;
            }
            jSONObject2.put("has_sdk", i2);
            jSONObject2.put("sdk_ver", java.lang.String.valueOf(L2.c()));
            jSONObject2.put("sdk_api_ver", java.lang.String.valueOf(L2.d()));
            jSONObject2.put("open_app_id", com.anythink.core.common.o.e.l());
            jSONObject.put(aq, jSONObject2);
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:0|1|(2:104|105)(1:3)|4|5|(3:96|97|(2:99|(34:101|8|(1:10)(1:95)|11|12|(1:14)(1:94)|15|(1:17)|18|(1:20)|21|(1:23)|24|25|(1:(1:28))(5:84|(1:86)(1:93)|(1:89)|(1:91)|92)|29|30|(1:(1:33))(3:80|(1:82)|83)|34|(7:36|(1:38)|39|(1:41)|42|(1:44)|45)|46|47|48|(1:50)|52|53|(1:55)|57|(1:59)|60|(1:62)|63|(6:65|(1:67)|68|(1:70)|71|(1:73))|76)))|7|8|(0)(0)|11|12|(0)(0)|15|(0)|18|(0)|21|(0)|24|25|(0)(0)|29|30|(0)(0)|34|(0)|46|47|48|(0)|52|53|(0)|57|(0)|60|(0)|63|(0)|76) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049 A[Catch: Exception -> 0x01d3, TryCatch #3 {Exception -> 0x01d3, blocks: (B:105:0x0023, B:4:0x0029, B:10:0x0049, B:11:0x004f, B:14:0x0067, B:15:0x0075, B:17:0x0083, B:18:0x0095, B:20:0x00a3, B:21:0x00ac, B:24:0x00b5, B:28:0x00c8, B:29:0x00e5, B:33:0x00ed, B:34:0x00fc, B:36:0x0106, B:38:0x011d, B:39:0x0122, B:41:0x0128, B:42:0x012d, B:44:0x0133, B:45:0x0138, B:46:0x013d, B:57:0x016b, B:59:0x0175, B:60:0x017a, B:62:0x0180, B:63:0x0185, B:65:0x018a, B:67:0x0194, B:68:0x01a1, B:70:0x01ab, B:71:0x01b8, B:73:0x01c6, B:80:0x00f1, B:82:0x00f7, B:83:0x00fa, B:84:0x00cc, B:91:0x00e0, B:92:0x00e3, B:94:0x0070), top: B:104:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[Catch: Exception -> 0x01d3, TRY_ENTER, TryCatch #3 {Exception -> 0x01d3, blocks: (B:105:0x0023, B:4:0x0029, B:10:0x0049, B:11:0x004f, B:14:0x0067, B:15:0x0075, B:17:0x0083, B:18:0x0095, B:20:0x00a3, B:21:0x00ac, B:24:0x00b5, B:28:0x00c8, B:29:0x00e5, B:33:0x00ed, B:34:0x00fc, B:36:0x0106, B:38:0x011d, B:39:0x0122, B:41:0x0128, B:42:0x012d, B:44:0x0133, B:45:0x0138, B:46:0x013d, B:57:0x016b, B:59:0x0175, B:60:0x017a, B:62:0x0180, B:63:0x0185, B:65:0x018a, B:67:0x0194, B:68:0x01a1, B:70:0x01ab, B:71:0x01b8, B:73:0x01c6, B:80:0x00f1, B:82:0x00f7, B:83:0x00fa, B:84:0x00cc, B:91:0x00e0, B:92:0x00e3, B:94:0x0070), top: B:104:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083 A[Catch: Exception -> 0x01d3, TryCatch #3 {Exception -> 0x01d3, blocks: (B:105:0x0023, B:4:0x0029, B:10:0x0049, B:11:0x004f, B:14:0x0067, B:15:0x0075, B:17:0x0083, B:18:0x0095, B:20:0x00a3, B:21:0x00ac, B:24:0x00b5, B:28:0x00c8, B:29:0x00e5, B:33:0x00ed, B:34:0x00fc, B:36:0x0106, B:38:0x011d, B:39:0x0122, B:41:0x0128, B:42:0x012d, B:44:0x0133, B:45:0x0138, B:46:0x013d, B:57:0x016b, B:59:0x0175, B:60:0x017a, B:62:0x0180, B:63:0x0185, B:65:0x018a, B:67:0x0194, B:68:0x01a1, B:70:0x01ab, B:71:0x01b8, B:73:0x01c6, B:80:0x00f1, B:82:0x00f7, B:83:0x00fa, B:84:0x00cc, B:91:0x00e0, B:92:0x00e3, B:94:0x0070), top: B:104:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3 A[Catch: Exception -> 0x01d3, TryCatch #3 {Exception -> 0x01d3, blocks: (B:105:0x0023, B:4:0x0029, B:10:0x0049, B:11:0x004f, B:14:0x0067, B:15:0x0075, B:17:0x0083, B:18:0x0095, B:20:0x00a3, B:21:0x00ac, B:24:0x00b5, B:28:0x00c8, B:29:0x00e5, B:33:0x00ed, B:34:0x00fc, B:36:0x0106, B:38:0x011d, B:39:0x0122, B:41:0x0128, B:42:0x012d, B:44:0x0133, B:45:0x0138, B:46:0x013d, B:57:0x016b, B:59:0x0175, B:60:0x017a, B:62:0x0180, B:63:0x0185, B:65:0x018a, B:67:0x0194, B:68:0x01a1, B:70:0x01ab, B:71:0x01b8, B:73:0x01c6, B:80:0x00f1, B:82:0x00f7, B:83:0x00fa, B:84:0x00cc, B:91:0x00e0, B:92:0x00e3, B:94:0x0070), top: B:104:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0106 A[Catch: Exception -> 0x01d3, TryCatch #3 {Exception -> 0x01d3, blocks: (B:105:0x0023, B:4:0x0029, B:10:0x0049, B:11:0x004f, B:14:0x0067, B:15:0x0075, B:17:0x0083, B:18:0x0095, B:20:0x00a3, B:21:0x00ac, B:24:0x00b5, B:28:0x00c8, B:29:0x00e5, B:33:0x00ed, B:34:0x00fc, B:36:0x0106, B:38:0x011d, B:39:0x0122, B:41:0x0128, B:42:0x012d, B:44:0x0133, B:45:0x0138, B:46:0x013d, B:57:0x016b, B:59:0x0175, B:60:0x017a, B:62:0x0180, B:63:0x0185, B:65:0x018a, B:67:0x0194, B:68:0x01a1, B:70:0x01ab, B:71:0x01b8, B:73:0x01c6, B:80:0x00f1, B:82:0x00f7, B:83:0x00fa, B:84:0x00cc, B:91:0x00e0, B:92:0x00e3, B:94:0x0070), top: B:104:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014d A[Catch: all -> 0x015a, TRY_LEAVE, TryCatch #0 {all -> 0x015a, blocks: (B:48:0x0145, B:50:0x014d), top: B:47:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0162 A[Catch: all -> 0x016b, TRY_LEAVE, TryCatch #1 {all -> 0x016b, blocks: (B:53:0x015a, B:55:0x0162), top: B:52:0x015a }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0175 A[Catch: Exception -> 0x01d3, TryCatch #3 {Exception -> 0x01d3, blocks: (B:105:0x0023, B:4:0x0029, B:10:0x0049, B:11:0x004f, B:14:0x0067, B:15:0x0075, B:17:0x0083, B:18:0x0095, B:20:0x00a3, B:21:0x00ac, B:24:0x00b5, B:28:0x00c8, B:29:0x00e5, B:33:0x00ed, B:34:0x00fc, B:36:0x0106, B:38:0x011d, B:39:0x0122, B:41:0x0128, B:42:0x012d, B:44:0x0133, B:45:0x0138, B:46:0x013d, B:57:0x016b, B:59:0x0175, B:60:0x017a, B:62:0x0180, B:63:0x0185, B:65:0x018a, B:67:0x0194, B:68:0x01a1, B:70:0x01ab, B:71:0x01b8, B:73:0x01c6, B:80:0x00f1, B:82:0x00f7, B:83:0x00fa, B:84:0x00cc, B:91:0x00e0, B:92:0x00e3, B:94:0x0070), top: B:104:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0180 A[Catch: Exception -> 0x01d3, TryCatch #3 {Exception -> 0x01d3, blocks: (B:105:0x0023, B:4:0x0029, B:10:0x0049, B:11:0x004f, B:14:0x0067, B:15:0x0075, B:17:0x0083, B:18:0x0095, B:20:0x00a3, B:21:0x00ac, B:24:0x00b5, B:28:0x00c8, B:29:0x00e5, B:33:0x00ed, B:34:0x00fc, B:36:0x0106, B:38:0x011d, B:39:0x0122, B:41:0x0128, B:42:0x012d, B:44:0x0133, B:45:0x0138, B:46:0x013d, B:57:0x016b, B:59:0x0175, B:60:0x017a, B:62:0x0180, B:63:0x0185, B:65:0x018a, B:67:0x0194, B:68:0x01a1, B:70:0x01ab, B:71:0x01b8, B:73:0x01c6, B:80:0x00f1, B:82:0x00f7, B:83:0x00fa, B:84:0x00cc, B:91:0x00e0, B:92:0x00e3, B:94:0x0070), top: B:104:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018a A[Catch: Exception -> 0x01d3, TryCatch #3 {Exception -> 0x01d3, blocks: (B:105:0x0023, B:4:0x0029, B:10:0x0049, B:11:0x004f, B:14:0x0067, B:15:0x0075, B:17:0x0083, B:18:0x0095, B:20:0x00a3, B:21:0x00ac, B:24:0x00b5, B:28:0x00c8, B:29:0x00e5, B:33:0x00ed, B:34:0x00fc, B:36:0x0106, B:38:0x011d, B:39:0x0122, B:41:0x0128, B:42:0x012d, B:44:0x0133, B:45:0x0138, B:46:0x013d, B:57:0x016b, B:59:0x0175, B:60:0x017a, B:62:0x0180, B:63:0x0185, B:65:0x018a, B:67:0x0194, B:68:0x01a1, B:70:0x01ab, B:71:0x01b8, B:73:0x01c6, B:80:0x00f1, B:82:0x00f7, B:83:0x00fa, B:84:0x00cc, B:91:0x00e0, B:92:0x00e3, B:94:0x0070), top: B:104:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f1 A[Catch: Exception -> 0x01d3, TryCatch #3 {Exception -> 0x01d3, blocks: (B:105:0x0023, B:4:0x0029, B:10:0x0049, B:11:0x004f, B:14:0x0067, B:15:0x0075, B:17:0x0083, B:18:0x0095, B:20:0x00a3, B:21:0x00ac, B:24:0x00b5, B:28:0x00c8, B:29:0x00e5, B:33:0x00ed, B:34:0x00fc, B:36:0x0106, B:38:0x011d, B:39:0x0122, B:41:0x0128, B:42:0x012d, B:44:0x0133, B:45:0x0138, B:46:0x013d, B:57:0x016b, B:59:0x0175, B:60:0x017a, B:62:0x0180, B:63:0x0185, B:65:0x018a, B:67:0x0194, B:68:0x01a1, B:70:0x01ab, B:71:0x01b8, B:73:0x01c6, B:80:0x00f1, B:82:0x00f7, B:83:0x00fa, B:84:0x00cc, B:91:0x00e0, B:92:0x00e3, B:94:0x0070), top: B:104:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00cc A[Catch: Exception -> 0x01d3, TryCatch #3 {Exception -> 0x01d3, blocks: (B:105:0x0023, B:4:0x0029, B:10:0x0049, B:11:0x004f, B:14:0x0067, B:15:0x0075, B:17:0x0083, B:18:0x0095, B:20:0x00a3, B:21:0x00ac, B:24:0x00b5, B:28:0x00c8, B:29:0x00e5, B:33:0x00ed, B:34:0x00fc, B:36:0x0106, B:38:0x011d, B:39:0x0122, B:41:0x0128, B:42:0x012d, B:44:0x0133, B:45:0x0138, B:46:0x013d, B:57:0x016b, B:59:0x0175, B:60:0x017a, B:62:0x0180, B:63:0x0185, B:65:0x018a, B:67:0x0194, B:68:0x01a1, B:70:0x01ab, B:71:0x01b8, B:73:0x01c6, B:80:0x00f1, B:82:0x00f7, B:83:0x00fa, B:84:0x00cc, B:91:0x00e0, B:92:0x00e3, B:94:0x0070), top: B:104:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0070 A[Catch: Exception -> 0x01d3, TryCatch #3 {Exception -> 0x01d3, blocks: (B:105:0x0023, B:4:0x0029, B:10:0x0049, B:11:0x004f, B:14:0x0067, B:15:0x0075, B:17:0x0083, B:18:0x0095, B:20:0x00a3, B:21:0x00ac, B:24:0x00b5, B:28:0x00c8, B:29:0x00e5, B:33:0x00ed, B:34:0x00fc, B:36:0x0106, B:38:0x011d, B:39:0x0122, B:41:0x0128, B:42:0x012d, B:44:0x0133, B:45:0x0138, B:46:0x013d, B:57:0x016b, B:59:0x0175, B:60:0x017a, B:62:0x0180, B:63:0x0185, B:65:0x018a, B:67:0x0194, B:68:0x01a1, B:70:0x01ab, B:71:0x01b8, B:73:0x01c6, B:80:0x00f1, B:82:0x00f7, B:83:0x00fa, B:84:0x00cc, B:91:0x00e0, B:92:0x00e3, B:94:0x0070), top: B:104:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x004e  */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.anythink.core.api.IExHandler] */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v10, types: [int] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static org.json.JSONObject b(int i2) {
        java.lang.String N2;
        org.json.JSONObject jSONObject;
        boolean z2;
        ?? b2;
        android.location.Location r2;
        java.lang.String s2;
        int i3;
        int i4;
        com.anythink.core.api.ATPrivacyConfig J2;
        java.lang.String o2;
        int p2;
        java.lang.Object obj;
        java.lang.Object obj2;
        android.content.Context f2 = com.anythink.core.common.b.o.a().f();
        ?? jSONObject2 = new org.json.JSONObject();
        com.anythink.core.d.a b3 = com.anythink.core.d.b.a(f2).b(com.anythink.core.common.b.o.a().o());
        if (b3 != null) {
            try {
                N2 = b3.N();
            } catch (java.lang.Exception unused) {
            }
        } else {
            N2 = "";
        }
        if (!android.text.TextUtils.isEmpty(N2)) {
            try {
                jSONObject = new org.json.JSONObject(N2);
            } catch (java.lang.Exception unused2) {
            }
            if (!jSONObject.isNull("a")) {
                if (jSONObject.optInt("a") != 1) {
                    z2 = false;
                    jSONObject2.put("android_id", !z2 ? com.anythink.core.common.o.e.d(f2) : "");
                    jSONObject2.put("gaid", com.anythink.core.common.o.e.f());
                    b2 = com.anythink.core.common.b.o.a().b();
                    if (b2 == 0) {
                        b2.fillRequestData(jSONObject2, b3);
                        jSONObject2.put("is_cn_sdk", "1");
                    } else {
                        jSONObject2.put("is_cn_sdk", "0");
                    }
                    java.lang.String m2 = com.anythink.core.common.o.e.m(f2);
                    r2 = com.anythink.core.common.b.o.a().r();
                    if (r2 != null) {
                        jSONObject2.put("lat", r2.getLatitude());
                        jSONObject2.put(C, r2.getLongitude());
                    }
                    s2 = com.anythink.core.common.b.o.a().s();
                    if (!android.text.TextUtils.isEmpty(s2)) {
                        jSONObject2.put(D, java.lang.Integer.parseInt(s2));
                    }
                    jSONObject2.put("it_src", android.text.TextUtils.isEmpty(m2) ? "" : m2);
                    jSONObject2.put("area_type", com.anythink.core.common.b.h.e.a);
                    i3 = an;
                    if (i3 != -1) {
                        boolean c2 = com.anythink.core.common.o.h.c(f2);
                        boolean b4 = com.anythink.core.common.o.h.b(f2);
                        ?? r5 = b4 ? 2 : c2;
                        if (c2 && b4) {
                            r5 = 3;
                        }
                        if (r5 > 0) {
                            jSONObject2.put(F, r5);
                        }
                        an = r5;
                    } else if (i3 > 0) {
                        jSONObject2.put(F, i3);
                    }
                    i4 = ao;
                    if (i4 != -1) {
                        boolean c3 = com.anythink.core.common.o.h.c();
                        if (c3) {
                            jSONObject2.put(E, 1);
                        }
                        ao = c3 ? 1 : 0;
                    } else if (i4 == 1) {
                        jSONObject2.put(E, i4);
                    }
                    J2 = com.anythink.core.common.b.o.a().J();
                    if (J2 != null) {
                        java.lang.String devGaid = J2.getDevGaid();
                        java.lang.String devImei = J2.getDevImei();
                        java.lang.String devOaid = J2.getDevOaid();
                        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                        if (!android.text.TextUtils.isEmpty(devGaid)) {
                            jSONObject3.put("set_gaid", devGaid);
                        }
                        if (!android.text.TextUtils.isEmpty(devImei)) {
                            jSONObject3.put("set_imei", devImei);
                        }
                        if (!android.text.TextUtils.isEmpty(devOaid)) {
                            jSONObject3.put("set_oaid", devOaid);
                        }
                        jSONObject2.put(G, jSONObject3);
                    }
                    java.util.Map<java.lang.String, java.lang.Object> l2 = com.anythink.core.common.b.o.a().l();
                    obj2 = l2.get(com.anythink.core.api.ATCustomRuleKeys.USER_NUMBER);
                    if (obj2 != null) {
                        jSONObject2.put(ak, java.lang.Long.parseLong(obj2.toString()));
                    }
                    obj = l2.get(com.anythink.core.api.ATCustomRuleKeys.USER_DEVICE_ID);
                    if (obj != null) {
                        jSONObject2.put(al, obj.toString());
                    }
                    o2 = com.anythink.core.common.o.e.o();
                    if (!android.text.TextUtils.isEmpty(o2)) {
                        jSONObject2.put("amazon_id", o2);
                    }
                    p2 = com.anythink.core.common.o.e.p();
                    if (p2 > 0) {
                        jSONObject2.put(ay, p2);
                    }
                    if ((i2 & 32) == 32) {
                        if (com.anythink.core.common.i.e.a().f() > 0) {
                            jSONObject2.put("t_mem", com.anythink.core.common.i.e.a().f());
                        }
                        if (com.anythink.core.common.i.e.a().g() > 0) {
                            jSONObject2.put("c_num", com.anythink.core.common.i.e.a().g());
                        }
                        if (com.anythink.core.common.i.e.a().h() > 0) {
                            jSONObject2.put("t_store", com.anythink.core.common.i.e.a().h());
                        }
                    }
                    return jSONObject2;
                }
            }
        }
        z2 = true;
        jSONObject2.put("android_id", !z2 ? com.anythink.core.common.o.e.d(f2) : "");
        jSONObject2.put("gaid", com.anythink.core.common.o.e.f());
        b2 = com.anythink.core.common.b.o.a().b();
        if (b2 == 0) {
        }
        java.lang.String m22 = com.anythink.core.common.o.e.m(f2);
        r2 = com.anythink.core.common.b.o.a().r();
        if (r2 != null) {
        }
        s2 = com.anythink.core.common.b.o.a().s();
        if (!android.text.TextUtils.isEmpty(s2)) {
        }
        jSONObject2.put("it_src", android.text.TextUtils.isEmpty(m22) ? "" : m22);
        jSONObject2.put("area_type", com.anythink.core.common.b.h.e.a);
        i3 = an;
        if (i3 != -1) {
        }
        i4 = ao;
        if (i4 != -1) {
        }
        J2 = com.anythink.core.common.b.o.a().J();
        if (J2 != null) {
        }
        java.util.Map<java.lang.String, java.lang.Object> l22 = com.anythink.core.common.b.o.a().l();
        obj2 = l22.get(com.anythink.core.api.ATCustomRuleKeys.USER_NUMBER);
        if (obj2 != null) {
        }
        obj = l22.get(com.anythink.core.api.ATCustomRuleKeys.USER_DEVICE_ID);
        if (obj != null) {
        }
        o2 = com.anythink.core.common.o.e.o();
        if (!android.text.TextUtils.isEmpty(o2)) {
        }
        p2 = com.anythink.core.common.o.e.p();
        if (p2 > 0) {
        }
        if ((i2 & 32) == 32) {
        }
        return jSONObject2;
    }

    private static void b(org.json.JSONObject jSONObject) {
        com.anythink.core.api.ATPrivacyConfig J2 = com.anythink.core.common.b.o.a().J();
        if (J2 != null) {
            java.lang.String devGaid = J2.getDevGaid();
            java.lang.String devImei = J2.getDevImei();
            java.lang.String devOaid = J2.getDevOaid();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            if (!android.text.TextUtils.isEmpty(devGaid)) {
                jSONObject2.put("set_gaid", devGaid);
            }
            if (!android.text.TextUtils.isEmpty(devImei)) {
                jSONObject2.put("set_imei", devImei);
            }
            if (!android.text.TextUtils.isEmpty(devOaid)) {
                jSONObject2.put("set_oaid", devOaid);
            }
            jSONObject.put(G, jSONObject2);
        }
    }
}
