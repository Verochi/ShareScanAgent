package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class m3 {
    public static java.lang.String A = null;
    public static java.lang.String B = null;
    public static java.lang.String C = null;
    public static java.lang.String D = null;
    public static java.lang.String E = null;
    public static android.content.Context a = null;
    public static java.lang.String b = "";
    public static java.lang.String c = "";
    public static java.lang.String d = "";
    public static java.lang.String e = null;
    public static java.lang.String f = "";
    public static java.lang.String g = "";
    public static java.lang.String h = null;
    public static java.lang.String i = null;
    public static java.lang.String j = "{}";
    public static boolean p;
    public static javax.crypto.SecretKey v;
    public static javax.crypto.spec.IvParameterSpec w;
    public static java.lang.String x;
    public static java.lang.String y;
    public static java.lang.String z;
    public static volatile org.json.JSONArray k = new org.json.JSONArray();
    public static java.lang.String l = "{}";
    public static java.lang.String m = "";
    public static int n = 0;
    public static java.lang.String o = "ANDROID-V3";
    public static java.util.HashMap<java.lang.String, java.lang.String> q = new java.util.HashMap<>();
    public static int r = 1;

    /* renamed from: s, reason: collision with root package name */
    public static int f490s = 1;
    public static int t = -1;
    public static long u = 0;
    public static org.json.JSONObject F = new org.json.JSONObject();
    public static volatile boolean G = false;
    public static final java.util.Set<java.lang.String> H = java.util.Collections.newSetFromMap(new java.util.concurrent.ConcurrentHashMap());
    public static final java.util.Set<java.lang.String> I = java.util.Collections.newSetFromMap(new java.util.concurrent.ConcurrentHashMap());
    public static android.os.Bundle J = null;

    public static java.lang.String a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.umeng.analytics.pro.bo.al, i);
            jSONObject.put("ext", j);
        } catch (org.json.JSONException e2) {
            com.zx.a.I8b7.r2.a(e2);
        }
        return jSONObject.toString();
    }

    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return split.length == 2 ? split[0] : str;
    }

    public static void a(android.content.Context context) throws java.lang.Exception {
        java.lang.String sb;
        android.content.Context applicationContext = context.getApplicationContext();
        a = applicationContext;
        g = applicationContext.getPackageName();
        com.zx.a.I8b7.x1.d(a);
        f = com.zx.a.I8b7.x1.a(a);
        java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("initAppId: ");
        a2.append(f);
        com.zx.a.I8b7.r2.a(a2.toString());
        b(a);
        if (android.text.TextUtils.isEmpty(h)) {
            b();
        } else {
            java.lang.String a3 = com.zx.a.I8b7.p.a(com.zx.a.I8b7.w3.b() + android.os.Build.MODEL, "SHA256");
            java.lang.String[] split = h.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length < 2) {
                java.lang.StringBuilder a4 = com.zx.a.I8b7.f3.a("ZXID 检测到老版本LID:");
                a4.append(h);
                com.zx.a.I8b7.r.a(a4.toString());
                h += com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + a3;
                com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
                com.zx.a.I8b7.u3 u3Var = l2Var.a;
                java.lang.String str = h;
                u3Var.getClass();
                if (!android.text.TextUtils.equals(str, h)) {
                    h = str;
                    l2Var.a.a(0, str, true);
                }
                java.lang.StringBuilder a5 = com.zx.a.I8b7.f3.a("ZXID 兼容老版本LID后重新生成LID:");
                a5.append(h);
                sb = a5.toString();
            } else if (android.text.TextUtils.equals(a3, split[1])) {
                sb = "ZXID LID校验通过!";
            } else {
                com.zx.a.I8b7.u3 u3Var2 = com.zx.a.I8b7.l2.a.a.a;
                if (u3Var2.b == null) {
                    u3Var2.b = u3Var2.d();
                }
                try {
                    android.database.sqlite.SQLiteDatabase sQLiteDatabase = u3Var2.b;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("key in(");
                    sb2.append("0,1,3,4,6,11,12,15,21,22,23,321,24,25,26,19,13,14");
                    sb2.append(")");
                    sQLiteDatabase.delete("zx_table", sb2.toString(), null);
                    h = "";
                    i = "";
                    j = "";
                    l = "{}";
                    n = 0;
                    o = "ANDROID-V3";
                    p = false;
                    x = "";
                    y = "";
                    z = "";
                    D = "";
                    r = 1;
                    A = "";
                    com.zx.a.I8b7.r2.a("ZXID清理数据成功");
                } catch (java.lang.Exception e2) {
                    java.lang.StringBuilder a6 = com.zx.a.I8b7.f3.a("清理本地数据error:");
                    a6.append(e2.getMessage());
                    com.zx.a.I8b7.r2.b(a6.toString());
                }
                b();
                sb = "ZXID LID校验不通过";
            }
            com.zx.a.I8b7.r.a(sb);
        }
        com.zx.a.I8b7.o2 o2Var = com.zx.a.I8b7.i0.a;
        try {
            com.zx.a.I8b7.o2.a aVar = new com.zx.a.I8b7.o2.a();
            aVar.b.add(new com.zx.a.I8b7.s0(com.zx.a.I8b7.r2.a.a.a, 5));
            aVar.b.add(new com.zx.a.I8b7.g0());
            javax.net.ssl.SSLSocketFactory c2 = com.zx.a.I8b7.i0.c();
            if (c2 == null) {
                throw new java.lang.NullPointerException("sslSocketFactory == null");
            }
            aVar.c = c2;
            com.zx.a.I8b7.i0.a = new com.zx.a.I8b7.o2(aVar);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
            th.printStackTrace();
        }
    }

    public static void a(com.zx.a.I8b7.u3 u3Var) {
        if (w == null) {
            javax.crypto.spec.IvParameterSpec g2 = u3Var.g();
            w = g2;
            if (g2 == null) {
                byte[] generateSeed = new java.security.SecureRandom().generateSeed(16);
                java.lang.String str = new java.lang.String(android.util.Base64.encode(generateSeed, 0), java.nio.charset.StandardCharsets.UTF_8);
                u3Var.a(10, str, false);
                com.zx.a.I8b7.r2.a("ZXID saveIvParameter ivStr:".concat(str));
                w = new javax.crypto.spec.IvParameterSpec(generateSeed);
            }
        }
        if (v == null) {
            javax.crypto.SecretKey i2 = u3Var.i();
            v = i2;
            if (i2 == null) {
                try {
                    java.security.SecureRandom secureRandom = com.zx.a.I8b7.p.a;
                    javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES");
                    keyGenerator.init(128);
                    javax.crypto.SecretKey generateKey = keyGenerator.generateKey();
                    v = generateKey;
                    u3Var.a(generateKey.getEncoded());
                } catch (java.security.NoSuchAlgorithmException e2) {
                    com.zx.a.I8b7.r2.a(e2);
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void b() {
        java.lang.String str = java.util.UUID.randomUUID().toString().replaceAll(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "") + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.zx.a.I8b7.p.a(com.zx.a.I8b7.w3.b() + android.os.Build.MODEL, "SHA256");
        com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
        l2Var.a.getClass();
        if (!android.text.TextUtils.equals(str, h)) {
            h = str;
            l2Var.a.a(0, str, true);
        }
        com.zx.a.I8b7.r.a("ZXID 生成LID:".concat(java.lang.String.valueOf(str)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x02e6, code lost:
    
        if (r4 != null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02f2, code lost:
    
        com.zx.a.I8b7.m3.G = true;
        r13 = com.zx.a.I8b7.h1.b.a;
        r13.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0306, code lost:
    
        if (new org.json.JSONObject(com.zx.a.I8b7.m3.l).has("zxc2") == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0308, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:158:0x032a A[Catch: all -> 0x035f, TryCatch #7 {all -> 0x035f, blocks: (B:156:0x0322, B:158:0x032a, B:160:0x0333, B:161:0x0336, B:163:0x033a, B:164:0x033d), top: B:155:0x0322 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(android.content.Context context) {
        com.zx.a.I8b7.h1 h1Var;
        java.lang.String string;
        java.lang.String str;
        a = context.getApplicationContext();
        com.zx.a.I8b7.u3 u3Var = com.zx.a.I8b7.l2.a.a.a;
        a(u3Var);
        u3Var.getClass();
        boolean z2 = false;
        android.database.Cursor cursor = null;
        try {
            if (u3Var.b == null) {
                u3Var.b = u3Var.b();
            }
            try {
                cursor = u3Var.b().query("zx_table", new java.lang.String[]{"key", "value"}, null, null, null, null, null);
            } catch (java.lang.Exception e2) {
                com.zx.a.I8b7.r2.b("query ex = " + e2.toString());
            }
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    int i2 = cursor.getInt(cursor.getColumnIndex("key"));
                    try {
                        string = cursor.getString(cursor.getColumnIndex("value"));
                        if ((!android.text.TextUtils.isEmpty(string) && i2 == 11) || i2 == 12 || i2 == 0 || i2 == 1 || i2 == 16 || i2 == 63 || i2 == 30 || i2 == 28 || i2 == 15 || i2 == 21 || i2 == 22 || i2 == 23 || i2 == 321 || i2 == 18 || i2 == 13 || i2 == 19) {
                            string = new java.lang.String(com.zx.a.I8b7.p.a("AES/CBC/PKCS5Padding", v, w, android.util.Base64.decode(string, 0)), java.nio.charset.StandardCharsets.UTF_8);
                        }
                    } catch (java.lang.Throwable th) {
                        com.zx.a.I8b7.r2.b("ZXTable解密失败,Key:" + i2 + ",error:" + th.getMessage());
                    }
                    if (i2 == 0) {
                        h = string;
                        str = "read lid = " + h;
                    } else if (i2 == 1) {
                        i = string;
                        str = "read zid = " + i;
                    } else if (i2 == 3) {
                        n = java.lang.Integer.parseInt(string);
                        str = "read syncId = " + n;
                    } else if (i2 == 4) {
                        o = string;
                        str = "read configVersion = " + o;
                    } else if (i2 == 28) {
                        m = string;
                        str = "read lastReportExtList = " + m;
                    } else if (i2 == 30) {
                        l = string;
                    } else if (i2 == 63) {
                        k = new org.json.JSONArray(string);
                        str = "read reqBZ = " + k;
                    } else if (i2 == 321) {
                        com.zx.a.I8b7.r2.a("read err = ".concat(java.lang.String.valueOf(string)));
                        com.zx.a.I8b7.y yVar = com.zx.a.I8b7.y.b.a;
                        yVar.getClass();
                        try {
                            if (!android.text.TextUtils.isEmpty(string)) {
                                yVar.b = yVar.a(new org.json.JSONArray(string), yVar.b, 10);
                            }
                        } catch (org.json.JSONException e3) {
                            e = e3;
                            com.zx.a.I8b7.r2.a(e);
                        }
                    } else if (i2 == 6) {
                        p = java.lang.Boolean.parseBoolean(string);
                        str = "read isInitialized = " + p;
                    } else if (i2 == 7) {
                        t = java.lang.Integer.parseInt(string);
                        str = "read permission = " + t;
                    } else if (i2 != 8) {
                        switch (i2) {
                            case 11:
                                x = string;
                                str = "read fieldConfigJSON = " + x;
                                break;
                            case 12:
                                y = string;
                                str = "read reportConfigJSON = " + y;
                                break;
                            case 13:
                                D = string;
                                str = "read localLv1JSON = " + D;
                                break;
                            case 14:
                                r = java.lang.Integer.parseInt(string);
                                break;
                            case 15:
                                z = string;
                                str = "read cryptoConfigJSON = " + z;
                                break;
                            case 16:
                                j = string;
                                break;
                            default:
                                switch (i2) {
                                    case 18:
                                        F = new org.json.JSONObject(string);
                                        break;
                                    case 19:
                                        C = string;
                                        com.zx.a.I8b7.r2.a("read invokeConfigJSON = " + C);
                                        c();
                                        break;
                                    case 20:
                                        f490s = java.lang.Integer.parseInt(string);
                                        str = "read allowPermissionDialog = " + f490s;
                                        break;
                                    case 21:
                                        A = string;
                                        str = "read appConfigJSON = " + A;
                                        break;
                                    case 22:
                                        B = string;
                                        str = "read commonConfigJSON = " + B;
                                        break;
                                    case 23:
                                        com.zx.a.I8b7.r2.a("read events = ".concat(java.lang.String.valueOf(string)));
                                        com.zx.a.I8b7.y yVar2 = com.zx.a.I8b7.y.b.a;
                                        yVar2.getClass();
                                        try {
                                            if (!android.text.TextUtils.isEmpty(string)) {
                                                yVar2.a = yVar2.a(new org.json.JSONArray(string), yVar2.a, 100);
                                            }
                                        } catch (org.json.JSONException e4) {
                                            e = e4;
                                            com.zx.a.I8b7.r2.a(e);
                                        }
                                }
                                break;
                        }
                    } else {
                        u = java.lang.Long.parseLong(string);
                        str = "read lastRequestTime = " + u;
                    }
                    com.zx.a.I8b7.r2.a(str);
                }
            }
        } catch (java.lang.Throwable th2) {
            try {
                com.zx.a.I8b7.r2.a(th2);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (!z2) {
            return;
        }
        try {
            if (h1Var.e.getAndSet(true)) {
                com.zx.a.I8b7.r2.a("zx rt start");
                java.util.Timer timer = h1Var.a;
                if (timer != null) {
                    timer.cancel();
                }
                java.util.TimerTask timerTask = h1Var.b;
                if (timerTask != null) {
                    timerTask.cancel();
                }
                long a2 = h1Var.a();
                h1Var.a(a2);
                h1Var.b();
                h1Var.a = new java.util.Timer();
                com.zx.a.I8b7.g1 g1Var = new com.zx.a.I8b7.g1(h1Var, a2);
                h1Var.b = g1Var;
                h1Var.a.schedule(g1Var, 0L, 1000L);
                return;
            }
            return;
        } catch (java.lang.Throwable th3) {
            com.zx.a.I8b7.r2.a(th3);
            return;
        }
        boolean z3 = false;
        if (!z3) {
            try {
                if (new org.json.JSONObject(l).has("zxc3")) {
                    z2 = true;
                }
            } catch (java.lang.Throwable unused) {
            }
            if (!z2) {
            }
        }
        if (h1Var.e.getAndSet(true)) {
        }
    }

    public static void c() {
        try {
            if (C != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(C);
                org.json.JSONArray optJSONArray = jSONObject.optJSONArray(com.umeng.commonsdk.framework.UMModuleRegister.INNER);
                org.json.JSONArray optJSONArray2 = jSONObject.optJSONArray("external");
                if (optJSONArray != null) {
                    java.util.Set<java.lang.String> set = H;
                    set.clear();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        set.add(optJSONArray.getString(i2));
                    }
                }
                if (optJSONArray2 != null) {
                    java.util.Set<java.lang.String> set2 = I;
                    set2.clear();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        set2.add(optJSONArray2.getString(i3));
                    }
                }
            }
        } catch (org.json.JSONException e2) {
            com.zx.a.I8b7.r2.a(e2);
        }
    }
}
