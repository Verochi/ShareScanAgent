package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ay {
    public static final java.lang.String A = "rtd";
    public static final java.lang.String B = "lepd";
    public static final java.lang.String C = "ccfg";
    private static java.util.Map<java.lang.String, java.lang.String> D = null;
    private static java.lang.String E = null;
    public static final java.lang.String a = "env";
    public static final java.lang.String b = "exp";
    public static final java.lang.String c = "imp";
    public static final java.lang.String d = "ua";
    public static final java.lang.String e = "zc";
    public static final java.lang.String f = "id";
    public static final java.lang.String g = "zf";
    public static final java.lang.String h = "exid";
    public static final java.lang.String i = "ucc";
    public static final java.lang.String j = "ugc";
    public static final java.lang.String k = "usi";
    public static final java.lang.String l = "uso";
    public static final java.lang.String m = "user";
    public static final java.lang.String n = "uspi";
    public static final java.lang.String o = "dtfn";
    public static final java.lang.String p = "pr";
    public static final java.lang.String q = "upg";
    public static final java.lang.String r = "pri";

    /* renamed from: s, reason: collision with root package name */
    public static final java.lang.String f444s = "probe";
    public static final java.lang.String t = "bl";
    public static final java.lang.String u = "wl";
    public static final java.lang.String v = "subp";
    public static final java.lang.String w = "subua";
    public static final java.lang.String x = "sta";
    public static final java.lang.String y = "emi";
    public static final java.lang.String z = "sli";

    public static class a {
        private static final com.umeng.analytics.pro.ay a = new com.umeng.analytics.pro.ay(null);

        private a() {
        }
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        D = hashMap;
        E = "";
        hashMap.put(a, "envelope");
        D.put(b, ".umeng");
        D.put(c, ".imprint");
        D.put("ua", "ua.db");
        D.put(e, "umeng_zero_cache.db");
        D.put("id", "umeng_it.cache");
        D.put(g, "umeng_zcfg_flag");
        D.put(h, "exid.dat");
        D.put(i, "umeng_common_config");
        D.put(j, "umeng_general_config");
        D.put(k, com.umeng.umcrash.UMCrash.KEY_CALLBACK_SESSION_ID);
        D.put(l, "umeng_sp_oaid");
        D.put(m, "mobclick_agent_user_");
        D.put(n, "umeng_subprocess_info");
        D.put(o, "delayed_transmission_flag_new");
        D.put("pr", "umeng_policy_result_flag");
        D.put(q, "um_policy_grant");
        D.put(r, "um_pri");
        D.put(f444s, "UM_PROBE_DATA");
        D.put("bl", "ekv_bl");
        D.put(u, "ekv_wl");
        D.put(v, com.umeng.analytics.pro.g.a);
        D.put(w, "ua_");
        D.put(x, "stateless");
        D.put(y, ".emitter");
        D.put(z, "um_slmode_sp");
        D.put(A, "um_rtd_conf");
        D.put(B, "");
        D.put(C, ".dmpvedpogjhejs.cfg");
    }

    private ay() {
    }

    public /* synthetic */ ay(com.umeng.analytics.pro.ay.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.analytics.pro.ay b() {
        return com.umeng.analytics.pro.ay.a.a;
    }

    public void a() {
        E = "";
    }

    public void a(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && android.text.TextUtils.isEmpty(E)) {
            if (str.length() > 3) {
                E = str.substring(0, 3) + "_";
                return;
            }
            E = str + "_";
        }
    }

    public java.lang.String b(java.lang.String str) {
        if (!D.containsKey(str)) {
            return "";
        }
        java.lang.String str2 = D.get(str);
        if (!b.equalsIgnoreCase(str) && !c.equalsIgnoreCase(str) && !y.equalsIgnoreCase(str)) {
            return E + str2;
        }
        return "." + E + str2.substring(1);
    }
}
