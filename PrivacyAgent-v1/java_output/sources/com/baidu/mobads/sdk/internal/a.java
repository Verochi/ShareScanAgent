package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class a {
    public static final java.lang.String a = "none";
    public static final java.lang.String b = "text";
    public static final java.lang.String c = "static_image";
    public static final java.lang.String d = "gif";
    public static final java.lang.String e = "rich_media";
    public static final java.lang.String f = "html";
    public static final java.lang.String g = "hybrid";
    public static final java.lang.String h = "video";
    private static final long i = 1750000;
    private java.lang.String A;
    private java.lang.String B;
    private java.lang.String C;
    private java.lang.String D;
    private int E;
    private java.lang.String F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private java.lang.String M;
    private java.util.List<java.lang.String> O;
    private org.json.JSONObject P;
    private long Q;
    private long R;
    private java.lang.String S;
    private java.lang.String T;
    private java.lang.String U;
    private java.lang.String V;
    private java.lang.String W;
    private java.lang.String X;
    private java.lang.String Y;
    private org.json.JSONObject Z;
    private int aa;
    private int ab;
    private int ac;
    private java.util.List<java.lang.String> ad;
    private java.lang.String af;
    private java.lang.String ag;
    private org.json.JSONObject ah;
    private org.json.JSONObject ai;
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String l;
    private java.lang.String m;
    private int n;
    private int o;
    private java.lang.String p;
    private long q;
    private int r;
    private java.lang.String t;
    private java.lang.String u;
    private java.lang.String v;
    private java.lang.String w;
    private java.lang.String x;
    private java.lang.String y;
    private java.lang.String z;

    /* renamed from: s, reason: collision with root package name */
    private int f293s = 1;
    private java.lang.String N = "none";
    private int ae = 0;

    private static int a(org.json.JSONObject jSONObject, int i2, int i3) {
        java.lang.String[] split;
        int i4 = 0;
        if (jSONObject != null) {
            try {
                org.json.JSONObject optJSONObject = jSONObject.optJSONObject("st_op");
                if (optJSONObject != null) {
                    java.lang.String optString = optJSONObject.optString("tp_id");
                    if (!android.text.TextUtils.isEmpty(optString) && optString.startsWith("opt_style_") && (split = optString.substring(10).split("_")) != null && split.length > 0) {
                        i4 = java.lang.Integer.parseInt(split[0]);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.baidu.mobads.sdk.internal.bt.a().d(th.getMessage());
            }
        }
        if (a(i4)) {
            i2 = i4;
        } else if (!a(i2)) {
            i2 = i3;
        }
        if (i2 == 42) {
            return 41;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x014c A[Catch: all -> 0x017b, JSONException -> 0x0180, TryCatch #4 {JSONException -> 0x0180, all -> 0x017b, blocks: (B:5:0x0082, B:8:0x0094, B:10:0x00a5, B:11:0x00bc, B:13:0x00c8, B:15:0x00d3, B:17:0x00d9, B:18:0x00db, B:20:0x00e1, B:22:0x00e7, B:24:0x00ef, B:28:0x00f8, B:30:0x0102, B:32:0x011f, B:36:0x0125, B:37:0x012b, B:39:0x0133, B:41:0x0139, B:43:0x0143, B:45:0x014c, B:47:0x015a, B:49:0x0161, B:50:0x0169, B:52:0x016f), top: B:4:0x0082 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.mobads.sdk.internal.a a(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        com.baidu.mobads.sdk.internal.a aVar = new com.baidu.mobads.sdk.internal.a();
        aVar.ai = jSONObject;
        aVar.P = jSONObject.optJSONObject("remoteParams");
        aVar.j = jSONObject.optString("tit");
        aVar.k = jSONObject.optString("desc");
        aVar.l = jSONObject.optString("icon");
        aVar.m = jSONObject.optString("w_picurl");
        aVar.n = jSONObject.optInt(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH);
        aVar.o = jSONObject.optInt("h");
        aVar.p = jSONObject.optString("appname");
        aVar.T = jSONObject.optString("adLogo");
        aVar.U = jSONObject.optString("baiduLogo");
        aVar.aa = jSONObject.optInt("region_click", 2);
        aVar.ab = jSONObject.optInt("dl_dialog", 2);
        aVar.Y = jSONObject.optString("btn");
        try {
            java.lang.String optString = jSONObject.optString("control_flags");
            if (!android.text.TextUtils.isEmpty(optString)) {
                java.lang.String optString2 = new org.json.JSONObject(optString).optString("innovate");
                if (!android.text.TextUtils.isEmpty(optString2)) {
                    org.json.JSONObject jSONObject3 = new org.json.JSONObject(optString2);
                    aVar.V = jSONObject3.optString("gjico");
                    aVar.W = jSONObject3.optString("gjtxt");
                    aVar.X = jSONObject3.optString("gjurl");
                }
            }
            java.lang.String optString3 = jSONObject.optString("cloud_control");
            if (!android.text.TextUtils.isEmpty(optString3)) {
                org.json.JSONObject jSONObject4 = new org.json.JSONObject(optString3);
                if (jSONObject4.has(com.anythink.basead.b.a.C0131a.k) && jSONObject4.optInt(com.anythink.basead.b.a.C0131a.k, 1) == 0) {
                    aVar.Y = "";
                }
                if (jSONObject4.has("marketing")) {
                    int optInt = jSONObject4.optInt("marketing", 0);
                    if (optInt == 1) {
                        org.json.JSONArray optJSONArray = jSONObject4.optJSONArray("marketing_logo");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            int i2 = 0;
                            for (int i3 = 2; i2 < i3; i3 = 2) {
                                java.lang.String optString4 = optJSONArray.optString(i2);
                                if (!android.text.TextUtils.isEmpty(optString4)) {
                                    org.json.JSONObject jSONObject5 = new org.json.JSONObject(optString4);
                                    aVar.V = jSONObject5.optString("gjico", aVar.V);
                                    aVar.W = jSONObject5.optString("gjtxt", aVar.W);
                                    aVar.X = jSONObject5.optString("gjurl", aVar.X);
                                }
                                i2++;
                            }
                        }
                    } else if (optInt == 0) {
                        aVar.V = "";
                        aVar.W = "";
                        aVar.X = "";
                    }
                }
                org.json.JSONArray optJSONArray2 = jSONObject4.optJSONArray("btn_style");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    java.lang.String optString5 = optJSONArray2.optString(0);
                    if (!android.text.TextUtils.isEmpty(optString5)) {
                        jSONObject2 = new org.json.JSONObject(optString5);
                        if (jSONObject2 != null) {
                            aVar.ac = jSONObject2.optInt("type", 0);
                            org.json.JSONArray optJSONArray3 = jSONObject2.optJSONArray("colors");
                            if (optJSONArray3 != null && optJSONArray3.length() == 4) {
                                aVar.ad = new java.util.ArrayList();
                                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                    aVar.ad.add(optJSONArray3.optString(i4));
                                }
                            }
                        }
                    }
                }
                jSONObject2 = null;
                if (jSONObject2 != null) {
                }
            }
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        aVar.Z = jSONObject.optJSONObject("monitors");
        aVar.q = jSONObject.optLong("sz");
        aVar.r = jSONObject.optInt("auto_play", 0);
        aVar.f293s = jSONObject.optInt("auto_play_non_wifi", 1);
        aVar.w = jSONObject.optString("pk");
        aVar.E = jSONObject.optInt(com.tencent.open.SocialConstants.PARAM_ACT);
        aVar.F = jSONObject.optString("apo", "");
        aVar.t = jSONObject.optString("bidlayer", "");
        aVar.u = jSONObject.optString("ads_bidlayer", "");
        aVar.v = jSONObject.optString("enc_bid_price", "");
        aVar.G = jSONObject.optInt("container_width");
        aVar.H = jSONObject.optInt("container_height");
        aVar.I = jSONObject.optInt("size_type");
        int optInt2 = jSONObject.optInt("style_type");
        aVar.J = optInt2;
        aVar.K = a(jSONObject, optInt2, 29);
        aVar.x = jSONObject.optString("vurl", "");
        aVar.L = jSONObject.optInt("duration", 0);
        aVar.M = jSONObject.optString("type");
        aVar.y = jSONObject.optString(f, null);
        aVar.A = jSONObject.optString("app_version", "");
        aVar.z = jSONObject.optString(com.aliyun.vod.log.core.AliyunLogCommon.Module.PUBLISHER, "");
        aVar.D = jSONObject.optString("permission_link", "");
        aVar.B = jSONObject.optString("privacy_link", "");
        aVar.C = jSONObject.optString("function_link", "");
        aVar.ae = jSONObject.optInt("media_player_render", 0);
        aVar.af = jSONObject.optString("qk", "");
        aVar.ag = jSONObject.optString("buyer", "");
        try {
            java.lang.String optString6 = jSONObject.optString("media_key");
            if (!android.text.TextUtils.isEmpty(optString6)) {
                aVar.ah = new org.json.JSONObject(optString6);
            }
        } catch (java.lang.Throwable th2) {
            com.baidu.mobads.sdk.internal.ay.b(th2);
        }
        try {
            org.json.JSONArray optJSONArray4 = jSONObject.optJSONArray("morepics");
            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                aVar.O = new java.util.ArrayList();
                for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                    aVar.O.add(optJSONArray4.getString(i5));
                }
            }
        } catch (java.lang.Exception unused) {
        }
        if (android.text.TextUtils.isEmpty(aVar.y)) {
            java.lang.String str = aVar.M;
            if (str != null) {
                if (str.equals("text")) {
                    aVar.M = "text";
                } else if (aVar.M.equals("image")) {
                    if (!android.text.TextUtils.isEmpty(aVar.m)) {
                        int lastIndexOf = aVar.m.toLowerCase(java.util.Locale.getDefault()).lastIndexOf(46);
                        if ((lastIndexOf >= 0 ? aVar.m.toLowerCase(java.util.Locale.getDefault()).substring(lastIndexOf) : "").contains(".gif")) {
                            aVar.N = "gif";
                        } else {
                            aVar.N = c;
                        }
                    }
                } else if (aVar.M.equals("rm")) {
                    aVar.N = e;
                } else if (aVar.M.equals("video")) {
                    aVar.N = "video";
                }
            }
        } else {
            aVar.N = f;
        }
        org.json.JSONObject jSONObject6 = aVar.P;
        if (jSONObject6 != null) {
            aVar.Q = jSONObject6.optLong("createTime", 0L);
            aVar.R = aVar.P.optLong("expireTime", i);
            aVar.T = aVar.P.optString("adLogo", com.baidu.mobads.sdk.internal.z.aL);
            aVar.U = aVar.P.optString("baiduLogo", com.baidu.mobads.sdk.internal.z.aM);
            aVar.S = aVar.P.optString("uniqueId", "");
        }
        return aVar;
    }

    public static java.util.List<com.baidu.mobads.sdk.internal.a> a(org.json.JSONArray jSONArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i2)));
                } catch (org.json.JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static boolean a(int i2) {
        return (i2 < 28 || 31 == i2 || 32 == i2 || 38 == i2 || 39 == i2 || 40 == i2 || 42 < i2) ? false : true;
    }

    public java.lang.String A() {
        return this.v;
    }

    public java.lang.String B() {
        return this.A;
    }

    public java.lang.String C() {
        return this.z;
    }

    public java.lang.String D() {
        return this.B;
    }

    public java.lang.String E() {
        return this.C;
    }

    public java.lang.String F() {
        return this.D;
    }

    public long G() {
        return this.R;
    }

    public java.util.List<java.lang.String> H() {
        return this.O;
    }

    public java.lang.String I() {
        return this.S;
    }

    public org.json.JSONObject J() {
        return this.P;
    }

    public java.lang.String K() {
        return this.V;
    }

    public java.lang.String L() {
        return this.W;
    }

    public java.lang.String M() {
        return this.X;
    }

    public java.lang.String N() {
        java.lang.String str = this.Y;
        return (str == null || str.length() <= 4) ? this.Y : "";
    }

    public int O() {
        return this.ac;
    }

    public java.util.List<java.lang.String> P() {
        return this.ad;
    }

    public org.json.JSONObject Q() {
        return this.Z;
    }

    public int R() {
        return this.aa;
    }

    public int S() {
        return this.ab;
    }

    public int T() {
        return this.ae;
    }

    public org.json.JSONObject U() {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("uniqueId", this.S);
            jSONObject.put("tit", this.j);
            jSONObject.put("desc", this.k);
            jSONObject.put("pk", this.w);
            jSONObject.put("appname", this.p);
            jSONObject.put(com.tencent.open.SocialConstants.PARAM_ACT, this.E);
            return jSONObject;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public java.lang.String V() {
        return this.af;
    }

    public java.lang.String W() {
        if (android.text.TextUtils.isEmpty(this.ag)) {
            return "";
        }
        try {
            long parseLong = java.lang.Long.parseLong(this.ag);
            int length = this.ag.length();
            return (parseLong <= 100000 || length <= 5) ? "" : this.ag.substring(length - 4, length);
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.ay.b(th);
            return "";
        }
    }

    public java.lang.String a() {
        return this.j;
    }

    public java.lang.String a(java.lang.String str) {
        if (this.ah == null) {
            return null;
        }
        org.json.JSONObject jSONObject = this.ai;
        org.json.JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("apo") : null;
        java.lang.String optString = this.ah.optString(str);
        if (android.text.TextUtils.isEmpty(optString)) {
            return null;
        }
        if (android.text.TextUtils.equals(optString, "fallback") && optJSONObject != null) {
            return optJSONObject.optString("fallback");
        }
        if (android.text.TextUtils.equals(optString, "page") && optJSONObject != null) {
            return optJSONObject.optString("page");
        }
        org.json.JSONObject jSONObject2 = this.ai;
        if (jSONObject2 != null) {
            return jSONObject2.optString(optString);
        }
        return null;
    }

    public java.lang.String b() {
        return this.k;
    }

    public java.lang.String c() {
        return this.l;
    }

    public java.lang.String d() {
        return this.m;
    }

    public int e() {
        return this.n;
    }

    public int f() {
        return this.o;
    }

    public java.lang.String g() {
        return this.p;
    }

    public java.lang.String h() {
        return this.T;
    }

    public java.lang.String i() {
        return this.U;
    }

    public long j() {
        return this.q;
    }

    public int k() {
        return this.r;
    }

    public int l() {
        return this.f293s;
    }

    public java.lang.String m() {
        return this.w;
    }

    public java.lang.String n() {
        return this.x;
    }

    public java.lang.String o() {
        return this.y;
    }

    public int p() {
        return this.E;
    }

    public java.lang.String q() {
        return this.F;
    }

    public int r() {
        return this.G;
    }

    public int s() {
        return this.H;
    }

    public int t() {
        return this.I;
    }

    public int u() {
        return this.J;
    }

    public int v() {
        return this.K;
    }

    public int w() {
        return this.L;
    }

    public java.lang.String x() {
        return this.N;
    }

    public long y() {
        return this.Q;
    }

    public java.lang.String z() {
        return !android.text.TextUtils.isEmpty(this.u) ? this.u : this.t;
    }
}
