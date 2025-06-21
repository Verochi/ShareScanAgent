package com.anythink.core.d;

/* loaded from: classes12.dex */
public class e extends com.anythink.core.d.c {
    public static final java.lang.String a = "Placement";
    public static final int b = 0;
    public static final int c = 1;
    public static final int e = 2;
    private long A;
    private long B;
    private long C;
    private int D;
    private java.lang.String E;
    private com.anythink.core.common.f.as F;
    private int G;
    private java.lang.String H;
    private int I;
    private int J;
    private java.lang.String K;
    private java.util.Map<java.lang.String, java.lang.Object> L;
    private java.util.Map<java.lang.String, com.anythink.core.api.ATRewardInfo> M;
    private com.anythink.core.api.ATRewardInfo N;
    private java.lang.String O;
    private java.lang.String P;
    private long Q;
    private java.lang.String R;
    private long S;
    private int T;
    private long U;
    private int V;
    private java.util.List<com.anythink.core.common.f.z> W;
    private com.anythink.core.common.f.ab X;
    private long Y;
    private double Z;
    private int aA;
    private int aB;
    private java.util.List<java.lang.Integer> aC;
    private int aD;
    private int aE;
    private int aF;
    private int aH;
    private double[][] aL;
    private int aN;
    private long aO;
    private int aP;
    private int aQ;
    private int aR;
    private java.util.List<java.lang.Integer> aS;
    private int aT;
    private java.lang.String aU;
    private int aV;
    private int aW;
    private int[] aX;
    private int aY;
    private java.lang.String aZ;
    private java.lang.String aa;
    private java.util.List<java.lang.String> ab;
    private java.lang.String ac;
    private java.lang.String ad;
    private java.lang.String ae;
    private java.lang.String af;
    private long ag;
    private java.lang.String ah;
    private java.lang.String ai;
    private java.lang.String aj;
    private double ak;
    private java.lang.String al;
    private long am;
    private long an;
    private long ao;
    private long ap;
    private int aq;
    private int ar;
    private int as;
    private long at;
    private org.json.JSONObject au;
    private java.lang.String av;
    private org.json.JSONObject aw;
    private int ax;
    private java.lang.String ay;
    private java.lang.String az;
    private java.lang.String ba;
    private java.lang.String bb;
    private long bc;
    private java.lang.String bd;
    private java.lang.String be;
    private double bf;
    private int bg;
    private int bh;
    private int bi;
    private int bj;
    private org.json.JSONObject bk;
    private long f;
    private long g;
    private int h;
    private int i;
    private int j;
    private long k;
    private long l;
    private long m;
    private int n;
    private int o;
    private int p;
    private int q;
    private java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f190s;
    private java.lang.String t;
    private java.lang.String u;
    private java.lang.String v;
    private java.util.List<com.anythink.core.common.f.au> w;
    private java.util.Map<java.lang.String, com.anythink.core.common.f.au> x;
    private int y;
    private int z;
    private int aG = 0;
    private int aI = 10;
    private int aJ = 10;
    private int aK = 2;
    private int aM = 1;

    public static class a {
        public static final java.lang.String A = "req_w_time";
        public static final java.lang.String B = "wf_loadts";
        public static final java.lang.String C = "req_ug_type";
        public static final java.lang.String D = "req_ug_numsp";
        public static final java.lang.String E = "bf_ldf_rf_sw";
        public static final java.lang.String F = "hb_start_time";
        public static final java.lang.String G = "dsp_list";
        public static final java.lang.String H = "bid_floor";
        public static final java.lang.String I = "max_unit_ids";
        public static final java.lang.String J = "xdb_list";
        public static final java.lang.String K = "s2s_bd_max";
        public static final java.lang.String L = "req_merge";
        public static final java.lang.String M = "exclude_id_max";
        public static final java.lang.String N = "install_id_max";
        public static final java.lang.String O = "install_ids";
        public static final java.lang.String P = "exclude_ids";
        public static final java.lang.String Q = "is_test";
        public static final java.lang.String R = "gsp_rates";
        public static final java.lang.String S = "mdna_r";
        public static final java.lang.String T = "adx_ext";
        public static final java.lang.String U = "wf_id";
        public static final java.lang.String V = "sysh_mtg_sw";
        public static final java.lang.String W = "mid_gdt_sw";
        public static final java.lang.String X = "lm_lrqf_interval_sws";
        public static final java.lang.String Y = "wf_lscb_type";
        public static final java.lang.String Z = "reqid_pg_sw";
        public static final java.lang.String a = "hb_bid_timeout";
        private static final java.lang.String aA = "unit_caps_d";
        private static final java.lang.String aB = "unit_caps_h";
        private static final java.lang.String aC = "unit_pacing";
        private static final java.lang.String aD = "wifi_auto_sw";
        private static final java.lang.String aE = "show_type";
        private static final java.lang.String aF = "refresh";
        private static final java.lang.String aG = "ug_list";
        private static final java.lang.String aH = "ol_list";
        private static final java.lang.String aI = "gro_id";
        private static final java.lang.String aJ = "hb_list";
        private static final java.lang.String aK = "s2shb_list";
        private static final java.lang.String aL = "format";
        private static final java.lang.String aM = "auto_refresh";
        private static final java.lang.String aN = "auto_refresh_time";
        private static final java.lang.String aO = "s_t";
        private static final java.lang.String aP = "l_s_t";
        private static final java.lang.String aQ = "ra";
        private static final java.lang.String aR = "asid";
        private static final java.lang.String aS = "tp_ps";
        private static final java.lang.String aT = "t_g_id";
        private static final java.lang.String aU = "s_id";
        private static final java.lang.String aV = "u_n_f_sw";
        private static final java.lang.String aW = "m_o";
        private static final java.lang.String aX = "m_o_s";
        private static final java.lang.String aY = "m_o_ks";
        private static final java.lang.String aZ = "p_m_o";
        public static final java.lang.String aa = "sr_sw";
        public static final java.lang.String ab = "p_c";
        public static final java.lang.String ac = "has_1st_rl";
        public static final java.lang.String ad = "updateTime";
        public static final java.lang.String ae = "upd_type";
        public static final java.lang.String af = "upd_th";
        public static final java.lang.String ag = "value_n";
        public static final java.lang.String ah = "bid_value_n";
        public static final java.lang.String ai = "sto_stg";
        public static final java.lang.String aj = "lf_rt_itr";
        public static final java.lang.String ak = "wf2_mode_sw";
        public static final java.lang.String al = "wf2_req_ug_type";
        public static final java.lang.String am = "wf2_mode_req_num";
        public static final java.lang.String an = "am_est_num";
        public static final java.lang.String ao = "share_pl_id";
        public static final java.lang.String ap = "s2s_sw";
        public static final java.lang.String aq = "bd_req_bid_sw";
        public static final java.lang.String ar = "bn_template_id";
        public static final java.lang.String as = "mix_click_type";
        public static final java.lang.String at = "auto_refresh_type";
        private static final java.lang.String au = "ps_id_timeout";
        private static final java.lang.String av = "ps_ct";
        private static final java.lang.String aw = "ps_ct_out";
        private static final java.lang.String ax = "pucs";
        private static final java.lang.String ay = "ad_delivery_sw";
        private static final java.lang.String az = "req_ug_num";
        public static final java.lang.String b = "addr_bid";
        private static final java.lang.String ba = "callback";
        private static final java.lang.String bb = "sc_list";
        private static final java.lang.String bc = "rw_n";
        private static final java.lang.String bd = "rw_num";
        private static final java.lang.String be = "reward";
        private static final java.lang.String bf = "currency";
        private static final java.lang.String bg = "cc";
        private static final java.lang.String bh = "exch_r";
        private static final java.lang.String bi = "acct_cy";
        public static final java.lang.String c = "load_fail_wtime";
        public static final java.lang.String d = "load_cap";
        public static final java.lang.String e = "load_cap_time";
        public static final java.lang.String f = "cached_offers_num";
        public static final java.lang.String g = "adx_list";
        public static final java.lang.String h = "adx_st";
        public static final java.lang.String i = "ilrd";
        public static final java.lang.String j = "hb_list";
        public static final java.lang.String k = "inh_list";
        public static final java.lang.String l = "fbhb_bid_wtime";
        public static final java.lang.String m = "burl_nt_firm";
        public static final java.lang.String n = "wf_bid_addr";
        public static final java.lang.String o = "ss_data";
        public static final java.lang.String p = "cn_addr_bid";
        public static final java.lang.String q = "cn_wf_bid_addr";
        public static final java.lang.String r = "byuid_wt";

        /* renamed from: s, reason: collision with root package name */
        public static final java.lang.String f191s = "addr_bks";
        public static final java.lang.String t = "addr_subbks";
        public static final java.lang.String u = "s2sbks_list";
        public static final java.lang.String v = "exch_rate_c2u";
        public static final java.lang.String w = "doffer_list";
        public static final java.lang.String x = "bottom_list";
        public static final java.lang.String y = "bottom_reqts";
        public static final java.lang.String z = "cb_w_time";
    }

    private void A(int i) {
        this.q = i;
    }

    private void A(java.lang.String str) {
        this.ae = str;
    }

    private void B(int i) {
        this.T = i;
    }

    private void B(java.lang.String str) {
        this.af = str;
    }

    private void C(int i) {
        this.V = i;
    }

    private void C(java.lang.String str) {
        this.bd = str;
    }

    private void D(int i) {
        this.bh = i;
    }

    private void D(java.lang.String str) {
        this.be = str;
    }

    private void E(int i) {
        this.bg = i;
    }

    private void F(int i) {
        this.bi = i;
    }

    private void G(int i) {
        this.bj = i;
    }

    private void H(int i) {
        this.aA = i;
    }

    private void I(int i) {
        this.aB = i;
    }

    private void J(int i) {
        this.aE = i;
    }

    private void K(int i) {
        this.aH = i;
    }

    private void L(int i) {
        this.aI = i;
    }

    private void M(int i) {
        this.aJ = i;
    }

    private void N(int i) {
        this.aK = i;
    }

    private void O(int i) {
        this.aM = i;
    }

    private void P(int i) {
        this.aW = i;
    }

    public static com.anythink.core.d.e a(org.json.JSONObject jSONObject) {
        com.anythink.core.d.e h = h(jSONObject);
        if (h != null) {
            java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.anythink.core.d.k.a(h, concurrentHashMap, arrayList);
            h.w = arrayList;
            h.x = concurrentHashMap;
        }
        return h;
    }

    private static java.util.List<com.anythink.core.common.f.z> a(java.lang.String str, java.lang.String str2, long j, com.anythink.core.common.f.ab abVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                com.anythink.core.common.f.z zVar = new com.anythink.core.common.f.z();
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                zVar.k(optJSONObject.optString("o_id"));
                zVar.l(optJSONObject.optString(com.bytedance.sdk.openadsdk.mediation.MediationConstant.EXTRA_CID));
                zVar.m(optJSONObject.optString("t"));
                zVar.x(optJSONObject.optString("p_g"));
                zVar.n(optJSONObject.optString("d"));
                zVar.o(optJSONObject.optString("ic_u"));
                zVar.p(optJSONObject.optString("im_u"));
                zVar.q(optJSONObject.optString("f_i_u"));
                zVar.r(optJSONObject.optString("a_c_u"));
                zVar.s(optJSONObject.optString("c_t"));
                zVar.t(optJSONObject.optString("v_u"));
                zVar.g(optJSONObject.optInt("l_t"));
                zVar.u(optJSONObject.optString("p_u"));
                zVar.v(optJSONObject.optString("dl"));
                zVar.w(optJSONObject.optString("c_u"));
                zVar.I(optJSONObject.optString("ip_u"));
                zVar.J(optJSONObject.optString("t_u"));
                zVar.K(optJSONObject.optString("t_u_25"));
                zVar.L(optJSONObject.optString("t_u_50"));
                zVar.M(optJSONObject.optString("t_u_75"));
                zVar.N(optJSONObject.optString("t_u_100"));
                zVar.O(optJSONObject.optString("s_e_c_t_u"));
                zVar.P(optJSONObject.optString("c_t_u"));
                zVar.Q(optJSONObject.optString("ip_n_u"));
                zVar.R(optJSONObject.optString("c_n_u"));
                zVar.W = optJSONObject.optInt("o_a_d_c");
                zVar.X = optJSONObject.optLong("o_a_p");
                zVar.a(j);
                zVar.f(optJSONObject.optInt("unit_type"));
                zVar.a(optJSONObject.optInt("c_m"));
                zVar.b(optJSONObject.optString("ext_h_pic"));
                zVar.F(optJSONObject.optString("ext_big_h_pic"));
                zVar.G(optJSONObject.optString("ext_rect_h_pic"));
                zVar.H(optJSONObject.optString("ext_home_h_pic"));
                zVar.a(str2);
                zVar.z(optJSONObject.optString("pub"));
                zVar.A(optJSONObject.optString("app_vc"));
                zVar.B(optJSONObject.optString("pvc"));
                zVar.C(optJSONObject.optString("pms"));
                zVar.a((com.anythink.core.common.f.n) abVar);
                arrayList.add(zVar);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    private void a(double d) {
        this.ak = d;
    }

    private void a(long j) {
        this.aO = j;
    }

    private void a(com.anythink.core.api.ATRewardInfo aTRewardInfo) {
        this.N = aTRewardInfo;
    }

    private void a(com.anythink.core.common.f.ab abVar) {
        this.X = abVar;
    }

    private void a(com.anythink.core.common.f.as asVar) {
        this.F = asVar;
    }

    private void a(java.util.List<java.lang.Integer> list) {
        this.aS = list;
    }

    private void a(java.util.Map<java.lang.String, com.anythink.core.common.f.au> map) {
        this.x = map;
    }

    private void a(int[] iArr) {
        this.aX = iArr;
    }

    private void a(double[][] dArr) {
        this.aL = dArr;
    }

    private boolean a(com.anythink.core.d.e eVar) {
        if (eVar == null) {
            return true;
        }
        return (android.text.TextUtils.equals(this.E, eVar.E) || ay()) ? false : true;
    }

    private org.json.JSONObject aW() {
        return this.au;
    }

    private java.lang.String aX() {
        return this.bb;
    }

    private java.lang.String aY() {
        return this.R;
    }

    private int aZ() {
        return this.D;
    }

    private void b(double d) {
        this.Z = d;
    }

    private void b(int i) {
        this.aN = i;
    }

    private void b(long j) {
        this.at = j;
    }

    private void b(java.util.List<com.anythink.core.common.f.au> list) {
        this.w = list;
    }

    private void b(java.util.Map<java.lang.String, com.anythink.core.api.ATRewardInfo> map) {
        this.M = map;
    }

    private int ba() {
        return this.i;
    }

    private int bb() {
        return this.n;
    }

    private int bc() {
        return this.o;
    }

    private int bd() {
        return this.p;
    }

    private com.anythink.core.common.f.as be() {
        return this.F;
    }

    private long bf() {
        return this.bc;
    }

    private java.lang.String bg() {
        return this.ae;
    }

    private long bh() {
        return this.an;
    }

    private long bi() {
        return this.ao;
    }

    private int bj() {
        return this.aB;
    }

    private int bk() {
        return this.aE;
    }

    private boolean bl() {
        return this.aG == 0;
    }

    private int[] bm() {
        return this.aX;
    }

    private com.anythink.core.common.f.au bn() {
        java.util.List<com.anythink.core.common.f.au> a2 = com.anythink.core.d.k.a(this, this.ba);
        if (a2.size() > 0) {
            return a2.get(0);
        }
        return null;
    }

    private void c(double d) {
        this.bf = d;
    }

    private void c(int i) {
        this.aF = i;
    }

    private void c(long j) {
        this.ap = j;
    }

    private void c(java.lang.String str) {
        this.aU = str;
    }

    private void c(java.util.List<java.lang.Integer> list) {
        this.aC = list;
    }

    private void c(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.L = map;
    }

    private void d(int i) {
        this.aQ = i;
    }

    private void d(long j) {
        this.am = j;
    }

    private void d(java.lang.String str) {
        this.az = str;
    }

    private void d(java.util.List<java.lang.String> list) {
        this.ab = list;
    }

    private void e(int i) {
        this.aR = i;
    }

    private void e(long j) {
        this.ag = j;
    }

    private void e(java.lang.String str) {
        this.ay = str;
    }

    private void e(java.util.List<com.anythink.core.common.f.z> list) {
        this.W = list;
    }

    private void e(org.json.JSONObject jSONObject) {
        this.aw = jSONObject;
    }

    private void f(int i) {
        this.aP = i;
    }

    private void f(long j) {
        this.Y = j;
    }

    private void f(java.lang.String str) {
        this.av = str;
    }

    private void f(org.json.JSONObject jSONObject) {
        this.au = jSONObject;
    }

    private void g(int i) {
        this.aT = i;
    }

    private void g(long j) {
        this.Q = j;
    }

    private void g(java.lang.String str) {
        this.al = str;
    }

    private void g(org.json.JSONObject jSONObject) {
        this.bk = jSONObject;
    }

    private static com.anythink.core.d.e h(org.json.JSONObject jSONObject) {
        long optLong;
        int i;
        org.json.JSONArray optJSONArray;
        int length;
        if (jSONObject == null) {
            return null;
        }
        try {
            com.anythink.core.d.e eVar = new com.anythink.core.d.e();
            eVar.b(jSONObject);
            eVar.c(jSONObject);
            eVar.d(jSONObject);
            if (jSONObject.isNull("ps_ct")) {
                eVar.f = 0L;
            } else {
                eVar.f = jSONObject.optLong("ps_ct");
            }
            if (jSONObject.isNull("ps_ct_out")) {
                eVar.g = 0L;
            } else {
                eVar.g = jSONObject.optLong("ps_ct_out");
            }
            if (jSONObject.isNull("pucs")) {
                eVar.h = 1;
            } else {
                eVar.h = jSONObject.optInt("pucs");
            }
            if (jSONObject.isNull("ad_delivery_sw")) {
                eVar.i = 1;
            } else {
                eVar.i = jSONObject.optInt("ad_delivery_sw");
            }
            if (jSONObject.isNull("req_ug_num")) {
                eVar.j = -1;
            } else {
                eVar.j = jSONObject.optInt("req_ug_num");
            }
            if (jSONObject.isNull("unit_caps_d")) {
                eVar.k = -1L;
            } else {
                eVar.k = jSONObject.optLong("unit_caps_d");
            }
            if (jSONObject.isNull("unit_caps_h")) {
                eVar.l = -1L;
            } else {
                eVar.l = jSONObject.optLong("unit_caps_h");
            }
            if (jSONObject.isNull("unit_pacing")) {
                eVar.m = -1L;
            } else {
                eVar.m = jSONObject.optLong("unit_pacing");
            }
            if (jSONObject.isNull("wifi_auto_sw")) {
                eVar.n = 0;
            } else {
                eVar.n = jSONObject.optInt("wifi_auto_sw");
            }
            if (jSONObject.isNull("show_type")) {
                eVar.o = 0;
            } else {
                eVar.o = jSONObject.optInt("show_type");
            }
            if (jSONObject.isNull(com.alipay.sdk.m.x.d.w)) {
                eVar.p = 0;
            } else {
                eVar.p = jSONObject.optInt(com.alipay.sdk.m.x.d.w);
            }
            if (jSONObject.isNull("gro_id")) {
                eVar.q = 0;
            } else {
                eVar.q = jSONObject.optInt("gro_id");
            }
            if (jSONObject.isNull("format")) {
                eVar.y = 0;
            } else {
                eVar.y = jSONObject.optInt("format");
            }
            if (jSONObject.isNull("auto_refresh")) {
                eVar.z = 0;
            } else {
                eVar.z = jSONObject.optInt("auto_refresh");
            }
            if (jSONObject.isNull("auto_refresh_time")) {
                eVar.A = 0L;
            } else {
                eVar.A = jSONObject.optLong("auto_refresh_time");
            }
            if (jSONObject.isNull("s_t")) {
                eVar.B = com.heytap.mcssdk.constant.a.h;
            } else {
                eVar.B = jSONObject.optLong("s_t");
            }
            if (jSONObject.isNull(com.anythink.core.common.j.L)) {
                eVar.C = 1800000L;
            } else {
                eVar.C = jSONObject.optLong(com.anythink.core.common.j.L);
            }
            if (jSONObject.isNull("ra")) {
                eVar.D = -1;
            } else {
                eVar.D = jSONObject.optInt("ra");
            }
            if (jSONObject.isNull("asid")) {
                eVar.E = "";
            } else {
                eVar.E = jSONObject.optString("asid");
            }
            if (jSONObject.isNull("tp_ps")) {
                eVar.F = null;
            } else {
                try {
                    com.anythink.core.common.f.as asVar = new com.anythink.core.common.f.as();
                    org.json.JSONObject optJSONObject = jSONObject.optJSONObject("tp_ps");
                    asVar.a = optJSONObject.optInt("pucs") == 1;
                    asVar.b = optJSONObject.optLong("apdt");
                    asVar.c = optJSONObject.optInt("aprn");
                    asVar.d = optJSONObject.optInt("puas") == 1;
                    asVar.e = optJSONObject.optLong("cdt");
                    asVar.f = optJSONObject.optInt("ski_swt") == 1;
                    asVar.g = optJSONObject.optInt("aut_swt") == 1;
                    eVar.F = asVar;
                } catch (java.lang.Exception unused) {
                }
            }
            if (jSONObject.isNull("ug_list")) {
                eVar.r = "[]";
            } else {
                eVar.r = jSONObject.optString("ug_list");
            }
            if (jSONObject.isNull("ol_list")) {
                eVar.f190s = "[]";
            } else {
                eVar.f190s = jSONObject.optString("ol_list");
            }
            if (jSONObject.isNull("s2shb_list")) {
                eVar.t = "[]";
            } else {
                eVar.t = jSONObject.optString("s2shb_list");
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.g)) {
                eVar.ba = "[]";
            } else {
                eVar.ba = jSONObject.optString(com.anythink.core.d.e.a.g);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.j)) {
                eVar.u = "[]";
            } else {
                eVar.u = jSONObject.optString(com.anythink.core.d.e.a.j);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.k)) {
                eVar.v = "[]";
            } else {
                eVar.v = jSONObject.optString(com.anythink.core.d.e.a.k);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.u)) {
                eVar.aj = "";
            } else {
                eVar.aj = jSONObject.optString(com.anythink.core.d.e.a.u);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.w)) {
                eVar.bd = "[]";
            } else {
                eVar.bd = jSONObject.optString(com.anythink.core.d.e.a.w);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.ad)) {
                eVar.bc = 0L;
                optLong = 0;
            } else {
                optLong = jSONObject.optLong(com.anythink.core.d.e.a.ad);
                eVar.bc = optLong;
            }
            if (jSONObject.isNull("t_g_id")) {
                eVar.G = -1;
            } else {
                eVar.G = jSONObject.optInt("t_g_id");
            }
            if (jSONObject.isNull("s_id")) {
                eVar.H = "";
            } else {
                eVar.H = jSONObject.optString("s_id");
            }
            if (jSONObject.isNull("u_n_f_sw")) {
                eVar.I = 0;
            } else {
                eVar.I = jSONObject.optInt("u_n_f_sw");
            }
            if (!jSONObject.isNull("m_o_s")) {
                eVar.X = com.anythink.core.common.f.ab.i(jSONObject.optString("m_o_s"));
            }
            if (jSONObject.isNull("m_o")) {
                eVar.W = null;
            } else {
                eVar.W = a(jSONObject.optString("m_o"), jSONObject.optString("m_o_ks"), optLong, eVar.X);
            }
            if (jSONObject.isNull("p_m_o")) {
                eVar.J = 0;
            } else {
                eVar.J = jSONObject.optInt("p_m_o");
            }
            if (jSONObject.isNull(com.anythink.core.common.h.l.a)) {
                eVar.L = null;
            } else {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(jSONObject.optString(com.anythink.core.common.h.l.a));
                java.util.HashMap hashMap = new java.util.HashMap();
                java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    hashMap.put(next, jSONObject2.opt(next));
                }
                eVar.L = hashMap;
            }
            if (!jSONObject.isNull("callback")) {
                org.json.JSONObject jSONObject3 = new org.json.JSONObject(jSONObject.optString("callback"));
                if (!jSONObject3.isNull("sc_list")) {
                    org.json.JSONObject jSONObject4 = new org.json.JSONObject(jSONObject3.optString("sc_list"));
                    java.util.HashMap hashMap2 = new java.util.HashMap();
                    java.util.Iterator<java.lang.String> keys2 = jSONObject4.keys();
                    while (keys2.hasNext()) {
                        java.lang.String next2 = keys2.next();
                        org.json.JSONObject jSONObject5 = new org.json.JSONObject(jSONObject4.optString(next2));
                        com.anythink.core.api.ATRewardInfo aTRewardInfo = new com.anythink.core.api.ATRewardInfo();
                        aTRewardInfo.rewardName = jSONObject5.optString("rw_n");
                        aTRewardInfo.rewardNumber = jSONObject5.optInt("rw_num");
                        hashMap2.put(next2, aTRewardInfo);
                    }
                    eVar.M = hashMap2;
                }
                if (!jSONObject3.isNull("reward")) {
                    org.json.JSONObject jSONObject6 = new org.json.JSONObject(jSONObject3.optString("reward"));
                    com.anythink.core.api.ATRewardInfo aTRewardInfo2 = new com.anythink.core.api.ATRewardInfo();
                    if (!jSONObject6.isNull("rw_n")) {
                        aTRewardInfo2.rewardName = jSONObject6.optString("rw_n");
                    }
                    if (!jSONObject6.isNull("rw_num")) {
                        aTRewardInfo2.rewardNumber = jSONObject6.optInt("rw_num");
                    }
                    eVar.N = aTRewardInfo2;
                }
                if (!jSONObject3.isNull("currency")) {
                    eVar.O = jSONObject3.optString("currency");
                }
                if (!jSONObject3.isNull("cc")) {
                    eVar.P = jSONObject3.optString("cc");
                }
                if (!jSONObject3.isNull("exch_r")) {
                    eVar.Z = jSONObject3.optDouble("exch_r", 0.0d);
                }
                if (!jSONObject3.isNull("acct_cy")) {
                    eVar.aa = jSONObject3.optString("acct_cy");
                }
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.a)) {
                eVar.Q = 10000L;
            } else {
                eVar.Q = jSONObject.optLong(com.anythink.core.d.e.a.a);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.b)) {
                eVar.R = "";
            } else {
                eVar.R = jSONObject.optString(com.anythink.core.d.e.a.b);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.c)) {
                eVar.S = 10000L;
            } else {
                eVar.S = jSONObject.optLong(com.anythink.core.d.e.a.c);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.d)) {
                eVar.T = -1;
            } else {
                eVar.T = jSONObject.optInt(com.anythink.core.d.e.a.d);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.e)) {
                eVar.U = com.heytap.mcssdk.constant.a.h;
            } else {
                eVar.U = jSONObject.optLong(com.anythink.core.d.e.a.e);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.f)) {
                eVar.V = 2;
            } else {
                eVar.V = jSONObject.optInt(com.anythink.core.d.e.a.f);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.i)) {
                eVar.aZ = null;
            } else {
                eVar.aZ = jSONObject.optString(com.anythink.core.d.e.a.i);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.h)) {
                eVar.bb = "";
            } else {
                eVar.bb = jSONObject.optString(com.anythink.core.d.e.a.h);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.l)) {
                eVar.Y = moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME;
            } else {
                eVar.Y = jSONObject.optLong(com.anythink.core.d.e.a.l);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.m)) {
                eVar.ab = null;
            } else {
                org.json.JSONArray optJSONArray2 = jSONObject.optJSONArray(com.anythink.core.d.e.a.m);
                java.util.ArrayList arrayList = new java.util.ArrayList(3);
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    arrayList.add(optJSONArray2.optString(i2));
                }
                eVar.ab = arrayList;
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.n)) {
                eVar.ac = "";
            } else {
                eVar.ac = jSONObject.optString(com.anythink.core.d.e.a.n);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.o)) {
                eVar.ad = "";
            } else {
                eVar.ad = jSONObject.optString(com.anythink.core.d.e.a.o);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.p)) {
                eVar.ae = "";
            } else {
                eVar.ae = jSONObject.optString(com.anythink.core.d.e.a.p);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.q)) {
                eVar.af = "";
            } else {
                eVar.af = jSONObject.optString(com.anythink.core.d.e.a.q);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.r)) {
                eVar.ag = 500L;
            } else {
                eVar.ag = jSONObject.optLong(com.anythink.core.d.e.a.r);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.f191s)) {
                eVar.ah = "";
            } else {
                eVar.ah = jSONObject.optString(com.anythink.core.d.e.a.f191s);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.t)) {
                eVar.ai = "";
            } else {
                eVar.ai = jSONObject.optString(com.anythink.core.d.e.a.t);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.v)) {
                eVar.ak = 0.1614d;
            } else {
                eVar.ak = jSONObject.optDouble(com.anythink.core.d.e.a.v);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.x)) {
                eVar.al = "[]";
            } else {
                eVar.al = jSONObject.optString(com.anythink.core.d.e.a.x);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.y)) {
                eVar.am = 1000L;
            } else {
                eVar.am = jSONObject.optLong(com.anythink.core.d.e.a.y);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.z)) {
                eVar.an = 0L;
            } else {
                eVar.an = jSONObject.optLong(com.anythink.core.d.e.a.z);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.A)) {
                eVar.ao = 2000L;
            } else {
                eVar.ao = jSONObject.optLong(com.anythink.core.d.e.a.A);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.B)) {
                eVar.ap = -1L;
            } else {
                eVar.ap = jSONObject.optLong(com.anythink.core.d.e.a.B);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.C)) {
                eVar.aq = 1;
            } else {
                int optInt = jSONObject.optInt(com.anythink.core.d.e.a.C);
                if (optInt != 1 && optInt != 2) {
                    optInt = 1;
                }
                eVar.aq = optInt;
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.D)) {
                eVar.ar = 1;
            } else {
                eVar.ar = jSONObject.optInt(com.anythink.core.d.e.a.D);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.E)) {
                eVar.as = 2;
            } else {
                eVar.as = jSONObject.optInt(com.anythink.core.d.e.a.E);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.F)) {
                eVar.at = 2000L;
            } else {
                eVar.at = jSONObject.optLong(com.anythink.core.d.e.a.F);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.G)) {
                eVar.be = "[]";
            } else {
                eVar.be = jSONObject.optString(com.anythink.core.d.e.a.G);
            }
            if (jSONObject.isNull("bid_floor")) {
                eVar.bf = 0.0d;
            } else {
                eVar.bf = jSONObject.optDouble("bid_floor");
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.I)) {
                eVar.au = null;
            } else {
                eVar.au = jSONObject.optJSONObject(com.anythink.core.d.e.a.I);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.J)) {
                eVar.av = "";
            } else {
                eVar.av = jSONObject.optString(com.anythink.core.d.e.a.J);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.K)) {
                eVar.bg = 0;
            } else {
                eVar.bg = jSONObject.optInt(com.anythink.core.d.e.a.K);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.L)) {
                eVar.bh = 2;
            } else {
                eVar.bh = jSONObject.optInt(com.anythink.core.d.e.a.L);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.M)) {
                eVar.bj = 0;
            } else {
                eVar.bj = jSONObject.optInt(com.anythink.core.d.e.a.M);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.N)) {
                eVar.bi = 0;
            } else {
                eVar.bi = jSONObject.optInt(com.anythink.core.d.e.a.N);
            }
            if (jSONObject.isNull("is_test")) {
                eVar.aY = 2;
            } else {
                eVar.aY = jSONObject.optInt("is_test");
            }
            eVar.aw = jSONObject.optJSONObject(com.anythink.core.d.e.a.R);
            if (jSONObject.isNull("mdna_r")) {
                eVar.ax = 1;
            } else {
                eVar.ax = jSONObject.optInt("mdna_r");
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.T)) {
                eVar.ay = "";
            } else {
                eVar.ay = jSONObject.optString(com.anythink.core.d.e.a.T);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.U)) {
                eVar.az = "";
            } else {
                eVar.az = jSONObject.optString(com.anythink.core.d.e.a.U);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.V)) {
                eVar.aA = 2;
            } else {
                eVar.aA = jSONObject.optInt(com.anythink.core.d.e.a.V);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.W)) {
                i = 1;
                eVar.aB = 1;
            } else {
                eVar.aB = jSONObject.optInt(com.anythink.core.d.e.a.W);
                i = 1;
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.X)) {
                eVar.aC = new java.util.ArrayList(i);
            } else {
                java.util.ArrayList arrayList2 = new java.util.ArrayList(3);
                org.json.JSONArray optJSONArray3 = jSONObject.optJSONArray(com.anythink.core.d.e.a.X);
                if (optJSONArray3 != null) {
                    int length2 = optJSONArray3.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        arrayList2.add(java.lang.Integer.valueOf(optJSONArray3.optInt(i3)));
                    }
                }
                eVar.aC = arrayList2;
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.Y)) {
                eVar.aD = 2;
            } else {
                eVar.aD = jSONObject.optInt(com.anythink.core.d.e.a.Y);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.Z)) {
                eVar.aE = 1;
            } else {
                eVar.aE = jSONObject.optInt(com.anythink.core.d.e.a.Z);
            }
            if (jSONObject.isNull(com.anythink.core.d.e.a.aa)) {
                eVar.aF = 2;
            } else {
                eVar.aF = jSONObject.optInt(com.anythink.core.d.e.a.aa);
            }
            if (!jSONObject.isNull(com.anythink.core.d.e.a.ab)) {
                eVar.bk = jSONObject.optJSONObject(com.anythink.core.d.e.a.ab);
            }
            if (!jSONObject.isNull(com.anythink.core.d.e.a.ac)) {
                eVar.aH = jSONObject.optInt(com.anythink.core.d.e.a.ac);
            }
            if (!jSONObject.isNull(com.anythink.core.d.e.a.ag)) {
                eVar.aI = jSONObject.optInt(com.anythink.core.d.e.a.ag);
            }
            if (!jSONObject.isNull(com.anythink.core.d.e.a.ah)) {
                eVar.aJ = jSONObject.optInt(com.anythink.core.d.e.a.ah);
            }
            if (!jSONObject.isNull(com.anythink.core.d.e.a.ae)) {
                eVar.aK = jSONObject.optInt(com.anythink.core.d.e.a.ae);
            }
            if (!jSONObject.isNull(com.anythink.core.d.e.a.af)) {
                try {
                    org.json.JSONArray optJSONArray4 = jSONObject.optJSONArray(com.anythink.core.d.e.a.af);
                    if (optJSONArray4 != null) {
                        double[][] dArr = new double[optJSONArray4.length()][];
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            java.lang.Object obj = optJSONArray4.get(i4);
                            if (obj instanceof org.json.JSONArray) {
                                org.json.JSONArray jSONArray = (org.json.JSONArray) obj;
                                dArr[i4] = new double[]{java.lang.Double.parseDouble(java.lang.String.valueOf(jSONArray.get(0))), java.lang.Double.parseDouble(java.lang.String.valueOf(jSONArray.get(1)))};
                            }
                        }
                        eVar.aL = dArr;
                    }
                } catch (java.lang.Exception unused2) {
                }
            }
            if (!jSONObject.isNull(com.anythink.core.d.e.a.ai)) {
                eVar.aM = jSONObject.optInt(com.anythink.core.d.e.a.ai);
            }
            eVar.aO = jSONObject.optLong(com.anythink.core.d.e.a.aj, 2000L);
            eVar.aP = jSONObject.optInt(com.anythink.core.d.e.a.ak, 2);
            int optInt2 = jSONObject.optInt(com.anythink.core.d.e.a.al, 1);
            if (optInt2 != 1 && optInt2 != 2) {
                optInt2 = 1;
            }
            eVar.aQ = optInt2;
            eVar.aR = jSONObject.optInt(com.anythink.core.d.e.a.am, 1);
            eVar.aT = jSONObject.optInt(com.anythink.core.d.e.a.an, 0);
            eVar.aU = jSONObject.optString(com.anythink.core.d.e.a.ao, "");
            eVar.aV = jSONObject.optInt("s2s_sw", 2);
            org.json.JSONArray optJSONArray5 = jSONObject.optJSONArray(com.anythink.core.d.e.a.aq);
            if (optJSONArray5 != null && (length = optJSONArray5.length()) > 0) {
                java.util.ArrayList arrayList3 = new java.util.ArrayList();
                for (int i5 = 0; i5 < length; i5++) {
                    java.lang.Object obj2 = optJSONArray5.get(i5);
                    if (obj2 instanceof java.lang.Integer) {
                        arrayList3.add((java.lang.Integer) obj2);
                    }
                }
                eVar.aS = arrayList3;
            }
            eVar.aW = jSONObject.optInt(com.anythink.core.d.e.a.ar, 1);
            int[] iArr = {1, 2, 3, 4, 5};
            if (!jSONObject.isNull(com.anythink.core.d.e.a.as) && (optJSONArray = jSONObject.optJSONArray(com.anythink.core.d.e.a.as)) != null && optJSONArray.length() > 0) {
                try {
                    iArr = new int[optJSONArray.length()];
                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                        iArr[i6] = optJSONArray.getInt(i6);
                    }
                } catch (java.lang.Exception unused3) {
                    iArr = new int[]{1, 2, 3, 4, 5};
                }
            }
            eVar.aX = iArr;
            eVar.aN = jSONObject.optInt(com.anythink.core.d.e.a.at, 1);
            return eVar;
        } catch (java.lang.Exception unused4) {
            return null;
        }
    }

    private void h(int i) {
        this.aV = i;
    }

    private void h(long j) {
        this.B = j;
    }

    private void h(java.lang.String str) {
        this.ah = str;
    }

    private void i(int i) {
        this.aD = i;
    }

    private void i(long j) {
        this.C = j;
    }

    private void i(java.lang.String str) {
        this.ai = str;
    }

    private void j(int i) {
        this.ax = i;
    }

    private void j(long j) {
        this.A = j;
    }

    private void j(java.lang.String str) {
        this.aj = str;
    }

    private void k(int i) {
        this.aY = i;
    }

    private void k(long j) {
        this.f = j;
    }

    private void k(java.lang.String str) {
        this.ad = str;
    }

    private void l(int i) {
        this.as = i;
    }

    private void l(long j) {
        this.g = j;
    }

    private void l(java.lang.String str) {
        this.ac = str;
    }

    private void m(int i) {
        this.aq = i;
    }

    private void m(long j) {
        this.k = j;
    }

    private void m(java.lang.String str) {
        this.aa = str;
    }

    private void n(int i) {
        this.ar = i;
    }

    private void n(long j) {
        this.l = j;
    }

    private void n(java.lang.String str) {
        this.v = str;
    }

    private void o(int i) {
        this.J = i;
    }

    private void o(long j) {
        this.m = j;
    }

    private void o(java.lang.String str) {
        this.aZ = str;
    }

    private void p(int i) {
        this.G = i;
    }

    private void p(long j) {
        this.bc = j;
    }

    private void p(java.lang.String str) {
        this.bb = str;
    }

    private void q(int i) {
        this.I = i;
    }

    private void q(long j) {
        this.S = j;
    }

    private void q(java.lang.String str) {
        this.ba = str;
    }

    private void r(int i) {
        this.D = i;
    }

    private void r(long j) {
        this.U = j;
    }

    private void r(java.lang.String str) {
        this.R = str;
    }

    private void s(int i) {
        this.z = i;
    }

    private void s(long j) {
        this.an = j;
    }

    private void s(java.lang.String str) {
        this.O = str;
    }

    private void t(int i) {
        this.y = i;
    }

    private void t(long j) {
        this.ao = j;
    }

    private void t(java.lang.String str) {
        this.P = str;
    }

    private void u(int i) {
        this.h = i;
    }

    private void u(java.lang.String str) {
        this.H = str;
    }

    private void v(int i) {
        this.i = i;
    }

    private void v(java.lang.String str) {
        this.E = str;
    }

    private void w(int i) {
        this.j = i;
    }

    private void w(java.lang.String str) {
        this.r = str;
    }

    private void x(int i) {
        this.n = i;
    }

    private void x(java.lang.String str) {
        this.f190s = str;
    }

    private void y(int i) {
        this.o = i;
    }

    private void y(java.lang.String str) {
        this.t = str;
    }

    private void z(int i) {
        this.p = i;
    }

    private void z(java.lang.String str) {
        this.u = str;
    }

    public final long A() {
        return this.am;
    }

    public final double B() {
        return this.ak;
    }

    public final java.lang.String C() {
        return this.ah;
    }

    public final java.lang.String D() {
        return this.ai;
    }

    public final java.lang.String E() {
        return this.aj;
    }

    public final long F() {
        return this.ag;
    }

    public final java.lang.String G() {
        return this.ad;
    }

    public final java.lang.String H() {
        return this.ac;
    }

    public final java.util.List<java.lang.String> I() {
        return this.ab;
    }

    public final double J() {
        return this.Z;
    }

    public final java.lang.String K() {
        return this.aa;
    }

    public final long L() {
        return this.Y;
    }

    public final java.lang.String M() {
        return this.v;
    }

    public final java.lang.String N() {
        return this.aZ;
    }

    public final java.lang.String O() {
        return this.ba;
    }

    public final com.anythink.core.common.f.ab P() {
        return this.X;
    }

    public final java.util.List<com.anythink.core.common.f.z> Q() {
        return this.W;
    }

    public final long R() {
        return this.Q;
    }

    public final java.util.Map<java.lang.String, com.anythink.core.api.ATRewardInfo> S() {
        return this.M;
    }

    public final java.lang.String T() {
        return this.O;
    }

    public final java.lang.String U() {
        return this.P;
    }

    public final com.anythink.core.api.ATRewardInfo V() {
        return this.N;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> W() {
        return this.L;
    }

    public final int X() {
        return this.J;
    }

    public final int Y() {
        return this.G;
    }

    public final java.lang.String Z() {
        return this.H;
    }

    public final int a() {
        return this.aN;
    }

    public final com.anythink.core.common.f.au a(java.lang.String str) {
        java.util.Map<java.lang.String, com.anythink.core.common.f.au> map = this.x;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> a(java.lang.String str, java.lang.String str2, com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.q M;
        java.util.Map<java.lang.String, java.lang.Object> c2 = com.anythink.core.common.o.i.c(auVar.h());
        boolean b2 = com.anythink.core.common.o.h.b();
        com.anythink.core.d.a b3 = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
        if (!android.text.TextUtils.isEmpty(auVar.z())) {
            c2.put("payload", auVar.z());
        }
        if (!android.text.TextUtils.isEmpty(auVar.Q())) {
            c2.put("custom_inhouse_bid_result", auVar.Q());
        }
        boolean z = false;
        c2.put(com.anythink.core.common.b.h.o.c, java.lang.Boolean.valueOf(b3.x() == 3));
        if (b3.y() == 2 && b2) {
            z = true;
        }
        c2.put(com.anythink.core.common.b.h.o.d, java.lang.Boolean.valueOf(z));
        c2.put(com.anythink.core.common.b.h.o.e, java.lang.Boolean.valueOf(com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).c()));
        c2.put("ad_type", java.lang.Integer.valueOf(auVar.W()));
        if (this.aB == 1) {
            c2.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.MEDIATION_WF_ID, str + "_" + this.G + "_" + this.q);
        }
        c2.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.STACK_INFO, com.anythink.core.common.u.a().f(str));
        if (auVar.d() == 28 && (M = auVar.M()) != null) {
            c2.put(com.anythink.core.common.b.h.o.k, java.lang.Double.valueOf(com.anythink.core.common.o.h.a(auVar) * M.l));
        }
        java.lang.String l = com.anythink.core.common.o.e.l();
        if (!android.text.TextUtils.isEmpty(l)) {
            c2.put(com.anythink.core.api.ATAdConst.KEY.WECHAT_APPID, l);
        }
        if (auVar.d() == 35 || auVar.m() == 3 || auVar.m() == 4 || auVar.m() == 7) {
            com.anythink.core.common.f.m mVar = new com.anythink.core.common.f.m();
            mVar.a = auVar.z();
            mVar.f = auVar.d();
            mVar.c = auVar.u();
            mVar.d = str2;
            mVar.b = str;
            mVar.h = this.G;
            mVar.i = this.q;
            mVar.j = this.y;
            mVar.g = auVar.e();
            com.anythink.core.common.f.q M2 = auVar.M();
            mVar.k = M2 != null ? M2.g : "";
            mVar.l = M2 != null ? M2.h : "";
            if (auVar.d() == 35) {
                mVar.n = this.X;
            } else {
                mVar.n = com.anythink.core.common.f.aj.i(this.bb);
            }
            com.anythink.core.common.f.n nVar = mVar.n;
            if (nVar != null) {
                nVar.s(this.y);
            }
            mVar.m = M2 != null ? M2.f : 0L;
            c2.put(com.anythink.core.common.b.h.o.a, mVar);
        }
        if (auVar.ah()) {
            c2.put(com.anythink.core.common.b.h.o.i, this.au);
        }
        if (auVar.d() == 50 && this.aE == 1) {
            c2.put(com.anythink.core.common.b.h.o.m, str2);
        }
        if (auVar.d() == 46) {
            com.anythink.core.api.ATAdConst.CURRENCY currency = com.anythink.core.api.ATAdConst.CURRENCY.RMB;
            if (android.text.TextUtils.equals(auVar.ag(), "USD")) {
                currency = com.anythink.core.api.ATAdConst.CURRENCY.USD;
            }
            c2.put(com.anythink.core.common.b.h.o.n, currency);
        }
        if (auVar.d() == 2) {
            c2.put(com.anythink.core.common.b.h.o.p, auVar.ar());
        }
        if (auVar.W() == 0) {
            c2.put(com.anythink.core.d.e.a.ar, java.lang.Integer.valueOf(this.aW));
            if (auVar.ax() == null) {
                c2.put(com.anythink.core.d.e.a.as, this.aX);
            } else {
                c2.put(com.anythink.core.d.e.a.as, auVar.ax());
            }
        }
        org.json.JSONObject W = b3.W();
        if (W != null) {
            try {
                java.lang.String string = W.getString(java.lang.String.valueOf(auVar.d()));
                if (!android.text.TextUtils.isEmpty(string)) {
                    c2.put("network_ext", string);
                }
            } catch (java.lang.Exception unused) {
            }
        }
        org.json.JSONArray aB = auVar.aB();
        if (aB != null && aB.length() > 0) {
            c2.put("web_content_urls", aB);
        }
        int aC = auVar.aC();
        if (aC > 0) {
            c2.put(com.anythink.core.common.j.aC, java.lang.Integer.valueOf(aC));
        }
        return c2;
    }

    public final void a(int i) {
        this.aG = i;
    }

    public final java.lang.String aA() {
        return this.be;
    }

    public final int aB() {
        return this.bh;
    }

    public final int aC() {
        return this.bg;
    }

    public final double aD() {
        return this.bf;
    }

    public final int aE() {
        return this.bi;
    }

    public final int aF() {
        return this.bj;
    }

    public final int aG() {
        return this.aA;
    }

    public final org.json.JSONObject aH() {
        return this.bk;
    }

    public final boolean aI() {
        return this.aG == 1;
    }

    public final int aJ() {
        return this.aH;
    }

    public final boolean aK() {
        return this.aH == 1;
    }

    public final boolean aL() {
        return this.aG == 2;
    }

    public final int aM() {
        return this.aI;
    }

    public final int aN() {
        return this.aJ;
    }

    public final int aO() {
        return this.aK;
    }

    public final double[][] aP() {
        return this.aL;
    }

    public final int aQ() {
        return this.aG;
    }

    public final int aR() {
        return this.aM;
    }

    public final int aS() {
        return this.aW;
    }

    public final boolean aT() {
        return this.i == 1;
    }

    public final boolean aU() {
        java.lang.System.currentTimeMillis();
        return java.lang.System.currentTimeMillis() - this.bc > this.f;
    }

    public final boolean aV() {
        return !android.text.TextUtils.isEmpty(this.aU);
    }

    public final int aa() {
        return this.I;
    }

    public final long ab() {
        return this.B;
    }

    public final long ac() {
        return this.C;
    }

    public final java.lang.String ad() {
        return this.E;
    }

    public final int ae() {
        return this.z;
    }

    public final long af() {
        return this.A;
    }

    public final int ag() {
        return this.y;
    }

    public final long ah() {
        return this.g;
    }

    public final int ai() {
        return this.h;
    }

    public final int aj() {
        return this.j;
    }

    public final long ak() {
        return this.k;
    }

    public final long al() {
        return this.l;
    }

    public final long am() {
        return this.m;
    }

    public final int an() {
        return this.q;
    }

    public final java.lang.String ao() {
        return this.r;
    }

    public final java.lang.String ap() {
        return this.f190s;
    }

    public final java.lang.String aq() {
        return this.t;
    }

    public final java.lang.String ar() {
        return this.u;
    }

    public final long as() {
        return this.S;
    }

    public final int at() {
        return this.T;
    }

    public final long au() {
        return this.U;
    }

    public final int av() {
        return this.V;
    }

    public final java.lang.String aw() {
        return this.af;
    }

    public final java.lang.String ax() {
        return this.bd;
    }

    public final int b() {
        return this.aF;
    }

    public final com.anythink.core.common.f.z b(java.lang.String str) {
        java.util.List<com.anythink.core.common.f.z> list = this.W;
        if (list == null) {
            return null;
        }
        for (com.anythink.core.common.f.z zVar : list) {
            if (zVar.n() == null) {
                zVar.a((com.anythink.core.common.f.n) this.X);
            }
            if (android.text.TextUtils.equals(str, zVar.s()) && !zVar.a(this.X)) {
                return zVar;
            }
        }
        return null;
    }

    public final java.util.List<java.lang.Integer> c() {
        return this.aS;
    }

    public final int d() {
        return this.aQ;
    }

    public final int e() {
        return this.aR;
    }

    public final int f() {
        return this.aP;
    }

    public final int g() {
        return this.aP == 1 ? 2 : 1;
    }

    public final long h() {
        return this.aO;
    }

    public final int i() {
        return this.aT;
    }

    public final java.lang.String j() {
        return this.aU;
    }

    public final int k() {
        return this.aV;
    }

    public final java.util.List<com.anythink.core.common.f.au> l() {
        return this.w;
    }

    public final int m() {
        return this.aD;
    }

    public final java.util.List<java.lang.Integer> n() {
        return this.aC;
    }

    public final java.lang.String o() {
        return this.az;
    }

    public final int p() {
        return this.ax;
    }

    public final java.lang.String q() {
        return this.ay;
    }

    public final org.json.JSONObject r() {
        return this.aw;
    }

    public final java.lang.String s() {
        return this.av;
    }

    public final int t() {
        return this.aY;
    }

    public final long u() {
        return this.at;
    }

    public final int v() {
        return this.as;
    }

    public final int w() {
        return this.aq;
    }

    public final int x() {
        int i = this.aq;
        if (i == 1) {
            return this.j;
        }
        if (i != 2) {
            return 1;
        }
        return this.ar;
    }

    public final long y() {
        return this.ap;
    }

    public final java.lang.String z() {
        return this.al;
    }
}
