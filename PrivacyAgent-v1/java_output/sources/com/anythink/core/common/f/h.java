package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public class h extends com.anythink.core.common.f.at implements java.lang.Cloneable {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    int A;
    public java.lang.String B;
    protected int C;
    protected int D;
    protected int E;
    protected int F;
    protected double G;
    boolean H;
    int I;
    java.lang.String J;
    long K;
    long L;
    java.lang.String M;
    private java.lang.String aA;
    private int aB;
    private int aD;
    private int aE;
    private boolean aF;
    private long aG;
    private long aH;
    private java.lang.String aI;
    private java.lang.String aJ;
    private java.lang.String aK;
    private int aL;
    private java.lang.String aN;
    private java.lang.String aO;
    private double aP;
    private java.lang.String aQ;
    private double aR;
    private double aS;
    private java.lang.String aT;
    private long aU;
    private java.lang.String aV;
    private java.lang.String aW;
    private int aX;
    private int aY;
    private java.lang.String aZ;
    private int av;
    private java.lang.String aw;
    private java.lang.String ax;
    private int ay;
    private int az;
    private double bA;
    private int bB;
    private long ba;
    private int bb;
    private int bc;
    private int bd;
    private int be;
    private int bf;
    private long bg;
    private int bi;
    private int bj;
    private int bm;
    private java.lang.String bn;
    private int bo;
    private com.anythink.core.api.ATRewardInfo bp;
    private java.util.Map<java.lang.String, com.anythink.core.api.ATRewardInfo> bq;
    private java.util.Map<java.lang.String, java.lang.Object> br;
    private java.util.Map<java.lang.String, java.lang.Object> bs;
    private com.anythink.core.common.f.c bt;
    private java.util.Map<java.lang.String, java.lang.Object> bu;
    private boolean bv;
    private double bw;
    private int bx;
    private int by;
    private int bz;
    protected int o;
    public int t;
    public java.lang.String u;
    int v;
    protected double w;
    java.lang.String x;
    public int y;
    int z;
    private int aC = -1;
    public java.lang.String p = "";
    public int q = 0;
    public int r = 0;

    /* renamed from: s, reason: collision with root package name */
    public int f170s = 0;
    private java.lang.String aM = "unknow";
    private int bh = -1;
    private int bk = 1;
    private int bl = 13;

    private void A(java.lang.String str) {
        this.u = str;
    }

    private void N(int i2) {
        this.q = i2;
    }

    private void O(int i2) {
        this.r = i2;
    }

    private void P(int i2) {
        this.f170s = i2;
    }

    private void Q(int i2) {
        this.t = i2;
    }

    private org.json.JSONObject R(int i2) {
        return super.F(i2);
    }

    private void a(int i2, org.json.JSONObject jSONObject) {
        if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 6 || i2 == 13) {
            jSONObject.put("extra", this.aV);
        }
    }

    private void a(org.json.JSONObject jSONObject, int i2) {
        int i3;
        try {
            if (android.text.TextUtils.equals(this.al, "2")) {
                if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 13 || i2 == 11 || i2 == 6) {
                    if (this.bh == 0 || i2 == 11) {
                        jSONObject.put(com.anythink.core.d.e.a.ar, this.bz);
                    }
                    java.util.Map<java.lang.String, java.lang.Object> map = this.bs;
                    if (map != null) {
                        java.lang.Object obj = map.get(com.anythink.core.api.ATAdConst.KEY.AD_WIDTH);
                        java.lang.Object obj2 = this.bs.get(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT);
                        if (obj != null) {
                            try {
                                jSONObject.put("bn_width", java.lang.Integer.parseInt(obj.toString()));
                            } catch (java.lang.Exception e2) {
                                e2.getMessage();
                            }
                        }
                        if (obj2 != null) {
                            try {
                                jSONObject.put("bn_height", java.lang.Integer.parseInt(obj2.toString()));
                            } catch (java.lang.Exception e3) {
                                e3.getMessage();
                            }
                        }
                    }
                    if (i2 != 6 || (i3 = this.by) == 0) {
                        return;
                    }
                    jSONObject.put("bn_click_area", i3);
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private long aA() {
        return this.L;
    }

    private java.lang.String aB() {
        return this.M;
    }

    private int aC() {
        return this.by;
    }

    private int aD() {
        return this.bz;
    }

    private int ag() {
        return this.bB;
    }

    private com.anythink.core.common.f.c ah() {
        return this.bt;
    }

    private double ai() {
        return this.bw;
    }

    private boolean aj() {
        return this.bv;
    }

    private double ak() {
        return this.G;
    }

    private int al() {
        return this.bd;
    }

    private int am() {
        return this.bc;
    }

    private java.lang.String an() {
        return this.B;
    }

    private int ao() {
        return this.y;
    }

    private void ap() {
        this.y = 1;
    }

    private java.lang.String aq() {
        return this.u;
    }

    private boolean ar() {
        return this.be == 9;
    }

    private java.lang.String as() {
        return this.aw;
    }

    private int at() {
        return this.q;
    }

    private int au() {
        return this.r;
    }

    private int av() {
        return this.t;
    }

    private boolean aw() {
        return this.H;
    }

    private int ax() {
        return this.I;
    }

    private java.lang.String ay() {
        return this.J;
    }

    private long az() {
        return this.K;
    }

    private void c(boolean z) {
        this.aF = z;
    }

    private void z(java.lang.String str) {
        this.B = str;
    }

    public final int A() {
        return this.v;
    }

    public final void A(int i2) {
        this.bh = i2;
    }

    public final double B() {
        return this.w;
    }

    public final void B(int i2) {
        this.bk = i2;
    }

    public final java.lang.String C() {
        return this.aI;
    }

    public final void C(int i2) {
        this.bl = i2;
    }

    public final int D() {
        int i2 = this.be;
        if (i2 != 8) {
            return i2 != 9 ? 0 : 1;
        }
        return 2;
    }

    public final void D(int i2) {
        this.bm = i2;
    }

    public final int E() {
        return this.aD;
    }

    public final void E(int i2) {
        this.I = i2;
    }

    public final int F() {
        return this.aE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(13:2|3|(1:5)|6|(1:8)|9|(4:174|175|(1:177)|178)|(1:173)|21|(1:23)|24|(1:26)|28)|(2:29|30)|126|127|(6:140|(1:164)|143|(3:145|(2:153|154)|(2:148|149))|158|(1:162))|165|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0389 A[Catch: Exception -> 0x00d1, TryCatch #8 {Exception -> 0x00d1, blocks: (B:31:0x00c9, B:32:0x00d4, B:99:0x0377, B:100:0x0385, B:102:0x0389, B:103:0x038e, B:105:0x0392, B:106:0x0397, B:108:0x039c, B:110:0x03a0, B:124:0x03b8, B:125:0x0407), top: B:29:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0392 A[Catch: Exception -> 0x00d1, TryCatch #8 {Exception -> 0x00d1, blocks: (B:31:0x00c9, B:32:0x00d4, B:99:0x0377, B:100:0x0385, B:102:0x0389, B:103:0x038e, B:105:0x0392, B:106:0x0397, B:108:0x039c, B:110:0x03a0, B:124:0x03b8, B:125:0x0407), top: B:29:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x032a A[Catch: Exception -> 0x0212, TryCatch #7 {Exception -> 0x0212, blocks: (B:33:0x00e7, B:34:0x00ef, B:37:0x0108, B:39:0x0101, B:40:0x010d, B:43:0x0149, B:45:0x016d, B:46:0x0172, B:49:0x018e, B:50:0x0142, B:51:0x0193, B:53:0x01a4, B:55:0x01ab, B:56:0x01a8, B:57:0x01bb, B:60:0x01e7, B:61:0x01e0, B:62:0x01ec, B:65:0x01f5, B:67:0x0217, B:69:0x023f, B:70:0x0262, B:72:0x026a, B:73:0x026f, B:75:0x0274, B:77:0x0278, B:83:0x024d, B:86:0x025f, B:88:0x0292, B:90:0x02f6, B:92:0x031e, B:93:0x033d, B:95:0x0357, B:96:0x035c, B:116:0x032a, B:119:0x033a, B:121:0x02c8, B:123:0x02ef), top: B:29:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x046d A[Catch: Exception -> 0x04af, TRY_LEAVE, TryCatch #1 {Exception -> 0x04af, blocks: (B:127:0x043e, B:140:0x045c, B:143:0x0469, B:145:0x046d, B:152:0x04a0, B:157:0x048c, B:160:0x04a6, B:162:0x04aa, B:164:0x0462, B:149:0x0491, B:154:0x047d), top: B:126:0x043e, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016d A[Catch: Exception -> 0x0212, TryCatch #7 {Exception -> 0x0212, blocks: (B:33:0x00e7, B:34:0x00ef, B:37:0x0108, B:39:0x0101, B:40:0x010d, B:43:0x0149, B:45:0x016d, B:46:0x0172, B:49:0x018e, B:50:0x0142, B:51:0x0193, B:53:0x01a4, B:55:0x01ab, B:56:0x01a8, B:57:0x01bb, B:60:0x01e7, B:61:0x01e0, B:62:0x01ec, B:65:0x01f5, B:67:0x0217, B:69:0x023f, B:70:0x0262, B:72:0x026a, B:73:0x026f, B:75:0x0274, B:77:0x0278, B:83:0x024d, B:86:0x025f, B:88:0x0292, B:90:0x02f6, B:92:0x031e, B:93:0x033d, B:95:0x0357, B:96:0x035c, B:116:0x032a, B:119:0x033a, B:121:0x02c8, B:123:0x02ef), top: B:29:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018e A[Catch: Exception -> 0x0212, TryCatch #7 {Exception -> 0x0212, blocks: (B:33:0x00e7, B:34:0x00ef, B:37:0x0108, B:39:0x0101, B:40:0x010d, B:43:0x0149, B:45:0x016d, B:46:0x0172, B:49:0x018e, B:50:0x0142, B:51:0x0193, B:53:0x01a4, B:55:0x01ab, B:56:0x01a8, B:57:0x01bb, B:60:0x01e7, B:61:0x01e0, B:62:0x01ec, B:65:0x01f5, B:67:0x0217, B:69:0x023f, B:70:0x0262, B:72:0x026a, B:73:0x026f, B:75:0x0274, B:77:0x0278, B:83:0x024d, B:86:0x025f, B:88:0x0292, B:90:0x02f6, B:92:0x031e, B:93:0x033d, B:95:0x0357, B:96:0x035c, B:116:0x032a, B:119:0x033a, B:121:0x02c8, B:123:0x02ef), top: B:29:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0142 A[Catch: Exception -> 0x0212, TryCatch #7 {Exception -> 0x0212, blocks: (B:33:0x00e7, B:34:0x00ef, B:37:0x0108, B:39:0x0101, B:40:0x010d, B:43:0x0149, B:45:0x016d, B:46:0x0172, B:49:0x018e, B:50:0x0142, B:51:0x0193, B:53:0x01a4, B:55:0x01ab, B:56:0x01a8, B:57:0x01bb, B:60:0x01e7, B:61:0x01e0, B:62:0x01ec, B:65:0x01f5, B:67:0x0217, B:69:0x023f, B:70:0x0262, B:72:0x026a, B:73:0x026f, B:75:0x0274, B:77:0x0278, B:83:0x024d, B:86:0x025f, B:88:0x0292, B:90:0x02f6, B:92:0x031e, B:93:0x033d, B:95:0x0357, B:96:0x035c, B:116:0x032a, B:119:0x033a, B:121:0x02c8, B:123:0x02ef), top: B:29:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x031e A[Catch: Exception -> 0x0212, TryCatch #7 {Exception -> 0x0212, blocks: (B:33:0x00e7, B:34:0x00ef, B:37:0x0108, B:39:0x0101, B:40:0x010d, B:43:0x0149, B:45:0x016d, B:46:0x0172, B:49:0x018e, B:50:0x0142, B:51:0x0193, B:53:0x01a4, B:55:0x01ab, B:56:0x01a8, B:57:0x01bb, B:60:0x01e7, B:61:0x01e0, B:62:0x01ec, B:65:0x01f5, B:67:0x0217, B:69:0x023f, B:70:0x0262, B:72:0x026a, B:73:0x026f, B:75:0x0274, B:77:0x0278, B:83:0x024d, B:86:0x025f, B:88:0x0292, B:90:0x02f6, B:92:0x031e, B:93:0x033d, B:95:0x0357, B:96:0x035c, B:116:0x032a, B:119:0x033a, B:121:0x02c8, B:123:0x02ef), top: B:29:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0357 A[Catch: Exception -> 0x0212, TryCatch #7 {Exception -> 0x0212, blocks: (B:33:0x00e7, B:34:0x00ef, B:37:0x0108, B:39:0x0101, B:40:0x010d, B:43:0x0149, B:45:0x016d, B:46:0x0172, B:49:0x018e, B:50:0x0142, B:51:0x0193, B:53:0x01a4, B:55:0x01ab, B:56:0x01a8, B:57:0x01bb, B:60:0x01e7, B:61:0x01e0, B:62:0x01ec, B:65:0x01f5, B:67:0x0217, B:69:0x023f, B:70:0x0262, B:72:0x026a, B:73:0x026f, B:75:0x0274, B:77:0x0278, B:83:0x024d, B:86:0x025f, B:88:0x0292, B:90:0x02f6, B:92:0x031e, B:93:0x033d, B:95:0x0357, B:96:0x035c, B:116:0x032a, B:119:0x033a, B:121:0x02c8, B:123:0x02ef), top: B:29:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0377 A[Catch: Exception -> 0x00d1, TRY_ENTER, TryCatch #8 {Exception -> 0x00d1, blocks: (B:31:0x00c9, B:32:0x00d4, B:99:0x0377, B:100:0x0385, B:102:0x0389, B:103:0x038e, B:105:0x0392, B:106:0x0397, B:108:0x039c, B:110:0x03a0, B:124:0x03b8, B:125:0x0407), top: B:29:0x00c4 }] */
    @Override // com.anythink.core.common.f.at
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final org.json.JSONObject F(int i2) {
        java.lang.CharSequence charSequence;
        java.util.Map<java.lang.String, java.lang.Object> map;
        int i3;
        java.lang.String str;
        java.lang.String str2;
        double d2;
        int i4;
        int i5;
        java.util.Map<java.lang.String, java.lang.Object> map2;
        java.util.Map<java.lang.String, java.lang.Object> map3;
        int i6;
        int i7 = i2;
        org.json.JSONObject F = super.F(i2);
        try {
            F.put("nw_ver", this.u);
            int i8 = this.aC;
            if (i8 != -1) {
                F.put(com.alipay.sdk.m.x.d.w, i8);
            }
            if (!android.text.TextUtils.isEmpty(this.aW)) {
                F.put("tp_bid_id", this.aW);
            }
            if ("4".equals(this.al) || "2".equals(this.al) || "3".equals(this.al)) {
                try {
                    int i9 = this.bh;
                    if (i9 == -1) {
                        i9 = java.lang.Integer.parseInt(this.al);
                    }
                    F.put("ad_type", i9);
                } catch (java.lang.Exception unused) {
                }
            }
            if (i7 == 1 || i7 == 2 || i7 == 4 || i7 == 6 || i7 == 13) {
                F.put("extra", this.aV);
            }
            com.anythink.core.common.f.c cVar = this.bt;
            if (cVar != null) {
                F.put("real_p", cVar.a());
                F.put("real_s", this.B);
                F.put("real_g", this.bt.b());
                F.put("real_t", this.bt.c());
            }
            int i10 = this.bf;
            if (i10 > 0) {
                F.put("ads_list_type", i10);
            }
            charSequence = "2";
        } catch (java.lang.Exception e2) {
            e = e2;
            charSequence = "2";
        }
        try {
            try {
                switch (i7) {
                    case 1:
                        F.put("unit_id", this.aI);
                        F.put("nw_firm_id", this.o);
                        F.put("gro_id", this.av);
                        F.put("auto_req", this.q);
                        F.put("aprn_auto_req", D());
                        F.put("bidtype", this.v);
                        F.put("bidprice", java.lang.String.valueOf(this.w));
                        F.put("ad_reqt", this.bg);
                        break;
                    case 2:
                        F.put("unit_id", this.aI);
                        F.put("nw_firm_id", this.o);
                        F.put("gro_id", this.av);
                        F.put("auto_req", this.q);
                        F.put("aprn_auto_req", D());
                        F.put("status", this.r);
                        F.put("filledtime", this.aH);
                        F.put("flag", this.f170s);
                        F.put("bidtype", this.v);
                        F.put("bidprice", java.lang.String.valueOf(this.w));
                        F.put("data_ft", this.aG);
                        F.put(com.anythink.core.api.ATAdConst.KEY.CP_LOAD_MODE, U());
                        break;
                    case 4:
                        str = "am_bp_type";
                        F.put(com.anythink.expressad.foundation.d.d.h, this.C);
                        F.put("ahs", this.D);
                        F.put("pds", this.E);
                        F.put("phs", this.F);
                        str2 = "phs";
                        F.put("cl_imp", this.aX);
                        if (!android.text.TextUtils.isEmpty(this.bn)) {
                            F.put(com.anythink.core.d.e.a.i, this.bn);
                        }
                        F.put("unit_id", this.aI);
                        F.put("nw_firm_id", this.o);
                        F.put("gro_id", this.av);
                        F.put("auto_req", this.q);
                        F.put("aprn_auto_req", D());
                        F.put("bidtype", this.v);
                        d2 = this.bw;
                        if (d2 <= 0.0d) {
                            F.put("bidprice", java.lang.String.valueOf(d2));
                            F.put(str, 3);
                        } else {
                            F.put("bidprice", java.lang.String.valueOf(this.w));
                            F.put(str, this.bv ? 2 : 1);
                        }
                        F.put(com.anythink.core.common.j.ao, java.lang.String.valueOf(this.G));
                        F.put("myoffer_showtype", this.y);
                        if (!android.text.TextUtils.isEmpty(this.B)) {
                            F.put("scenario", this.B);
                        }
                        F.put(com.anythink.expressad.foundation.d.d.h, this.C);
                        F.put("ahs", this.D);
                        F.put("pds", this.E);
                        F.put(str2, this.F);
                        i7 = i2;
                        if (i7 == 6) {
                            F.put("cl_s_type", this.bk);
                            F.put("cl_area", this.bl);
                        }
                        i4 = this.bo;
                        if (i4 > 0) {
                            F.put("render_type_video", i4);
                        }
                        i5 = this.bB;
                        if (i5 > 0) {
                            F.put("close_button_m", i5);
                        }
                        if (this.o == 2 && (map2 = this.bu) != null && map2.size() > 0) {
                            try {
                                F.put("am_ilrd", new org.json.JSONObject(this.bu).toString());
                                break;
                            } catch (java.lang.Throwable unused2) {
                                break;
                            }
                        }
                        break;
                    case 6:
                        str = "am_bp_type";
                        str2 = "phs";
                        F.put("unit_id", this.aI);
                        F.put("nw_firm_id", this.o);
                        F.put("gro_id", this.av);
                        F.put("auto_req", this.q);
                        F.put("aprn_auto_req", D());
                        F.put("bidtype", this.v);
                        d2 = this.bw;
                        if (d2 <= 0.0d) {
                        }
                        F.put(com.anythink.core.common.j.ao, java.lang.String.valueOf(this.G));
                        F.put("myoffer_showtype", this.y);
                        if (!android.text.TextUtils.isEmpty(this.B)) {
                        }
                        F.put(com.anythink.expressad.foundation.d.d.h, this.C);
                        F.put("ahs", this.D);
                        F.put("pds", this.E);
                        F.put(str2, this.F);
                        i7 = i2;
                        if (i7 == 6) {
                        }
                        i4 = this.bo;
                        if (i4 > 0) {
                        }
                        i5 = this.bB;
                        if (i5 > 0) {
                        }
                        if (this.o == 2) {
                            F.put("am_ilrd", new org.json.JSONObject(this.bu).toString());
                            break;
                        }
                        break;
                    case 7:
                        F.put("unit_id", this.aI);
                        F.put("nw_firm_id", this.o);
                        F.put("gro_id", this.av);
                        F.put("auto_req", this.q);
                        F.put("aprn_auto_req", D());
                        F.put(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS, this.t);
                        F.put("bidtype", this.v);
                        F.put("bidprice", java.lang.String.valueOf(this.w));
                        i7 = i2;
                        break;
                    case 8:
                    case 9:
                        F.put("unit_id", this.aI);
                        F.put("nw_firm_id", this.o);
                        F.put("gro_id", this.av);
                        F.put("auto_req", this.q);
                        F.put("aprn_auto_req", D());
                        F.put("bidtype", this.v);
                        double d3 = this.bw;
                        if (d3 > 0.0d) {
                            F.put("bidprice", java.lang.String.valueOf(d3));
                            F.put("am_bp_type", 3);
                        } else {
                            F.put("bidprice", java.lang.String.valueOf(this.w));
                            F.put("am_bp_type", this.bv ? 2 : 1);
                        }
                        if (!android.text.TextUtils.isEmpty(this.B)) {
                            F.put("scenario", this.B);
                        }
                        if (this.o == 2 && (map3 = this.bu) != null && map3.size() > 0) {
                            try {
                                F.put("am_ilrd", new org.json.JSONObject(this.bu).toString());
                            } catch (java.lang.Throwable unused3) {
                            }
                        }
                        i7 = i2;
                        break;
                    case 10:
                        F.put("isload", this.H ? 1 : 0);
                        F.put("reason", this.I);
                        F.put("gro_id", this.av);
                        F.put("req_par", this.bi);
                        F.put("req_par_num", this.bj);
                        i7 = i2;
                        break;
                    case 11:
                        F.put("auto_req", this.q);
                        F.put("gro_id", this.av);
                        F.put("bidrequesttime", this.K);
                        F.put("bidresponsetime", this.L);
                        F.put("bidresponselist", android.text.TextUtils.isEmpty(this.M) ? "[]" : new org.json.JSONArray(this.M));
                        i7 = i2;
                        break;
                    case 12:
                        F.put("loadtime", this.aH);
                        F.put("gro_id", this.av);
                        int i11 = this.I;
                        if (i11 != 5) {
                            switch (i11) {
                            }
                            F.put("req_par", this.bi);
                            F.put("req_par_num", this.bj);
                            i7 = i2;
                            break;
                        }
                        F.put("reason", i11);
                        F.put("req_par", this.bi);
                        F.put("req_par_num", this.bj);
                        i7 = i2;
                        break;
                    case 13:
                        F.put("unit_id", this.aI);
                        F.put("nw_firm_id", this.o);
                        F.put("gro_id", this.av);
                        F.put("bidtype", this.v);
                        F.put("bidprice", java.lang.String.valueOf(this.w));
                        F.put(com.anythink.core.common.j.ao, java.lang.String.valueOf(this.G));
                        F.put("as_result", !android.text.TextUtils.isEmpty(this.J) ? "[]" : new org.json.JSONArray(this.J));
                        F.put("new_req_id", this.ak);
                        F.put("auto_req", this.q);
                        F.put("req_id_match", 0);
                        F.put("myoffer_showtype", this.y);
                        if (!android.text.TextUtils.isEmpty(this.B)) {
                            F.put("scenario", this.B);
                        }
                        F.put(com.anythink.expressad.foundation.d.d.h, this.C);
                        F.put("ahs", this.D);
                        F.put("pds", this.E);
                        F.put("phs", this.F);
                        i6 = this.I;
                        if (i6 != 12) {
                            F.put("reason", i6);
                        }
                        i7 = i2;
                        break;
                    case 15:
                        F.put("gro_id", this.av);
                        F.put("bidresponselist", android.text.TextUtils.isEmpty(this.M) ? "[]" : new org.json.JSONArray(this.M));
                        i7 = i2;
                        break;
                    case 16:
                        F.put("ad_ch_st", this.bd);
                        F.put("unit_id", this.aI);
                        F.put("nw_firm_id", this.o);
                        F.put("gro_id", this.av);
                        F.put("bidtype", this.v);
                        F.put("bidprice", java.lang.String.valueOf(this.w));
                        F.put(com.anythink.core.common.j.ao, java.lang.String.valueOf(this.G));
                        F.put("as_result", !android.text.TextUtils.isEmpty(this.J) ? "[]" : new org.json.JSONArray(this.J));
                        F.put("new_req_id", this.ak);
                        F.put("auto_req", this.q);
                        F.put("req_id_match", 0);
                        F.put("myoffer_showtype", this.y);
                        if (!android.text.TextUtils.isEmpty(this.B)) {
                        }
                        F.put(com.anythink.expressad.foundation.d.d.h, this.C);
                        F.put("ahs", this.D);
                        F.put("pds", this.E);
                        F.put("phs", this.F);
                        i6 = this.I;
                        if (i6 != 12) {
                        }
                        i7 = i2;
                        break;
                    case 18:
                    case 20:
                        F.put("unit_id", this.aI);
                        F.put("nw_firm_id", this.o);
                        F.put("app_nm", this.aZ);
                        break;
                    case 19:
                        F.put("dl_ts", this.ba);
                        F.put("unit_id", this.aI);
                        F.put("nw_firm_id", this.o);
                        F.put("app_nm", this.aZ);
                        break;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                i7 = i2;
                e.printStackTrace();
                if (android.text.TextUtils.equals(this.al, charSequence)) {
                    if (this.bh != 0) {
                    }
                    F.put(com.anythink.core.d.e.a.ar, this.bz);
                    map = this.bs;
                    if (map != null) {
                    }
                    if (i7 == 6) {
                        F.put("bn_click_area", i3);
                    }
                }
                return F;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            e.printStackTrace();
            if (android.text.TextUtils.equals(this.al, charSequence)) {
            }
            return F;
        }
        if (android.text.TextUtils.equals(this.al, charSequence) && (i7 == 1 || i7 == 2 || i7 == 4 || i7 == 13 || i7 == 11 || i7 == 6)) {
            if (this.bh != 0 || i7 == 11) {
                F.put(com.anythink.core.d.e.a.ar, this.bz);
            }
            map = this.bs;
            if (map != null) {
                java.lang.Object obj = map.get(com.anythink.core.api.ATAdConst.KEY.AD_WIDTH);
                java.lang.Object obj2 = this.bs.get(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT);
                if (obj != null) {
                    try {
                        F.put("bn_width", java.lang.Integer.parseInt(obj.toString()));
                    } catch (java.lang.Exception e5) {
                        e5.getMessage();
                    }
                }
                if (obj2 != null) {
                    try {
                        F.put("bn_height", java.lang.Integer.parseInt(obj2.toString()));
                    } catch (java.lang.Exception e6) {
                        e6.getMessage();
                    }
                }
            }
            if (i7 == 6 && (i3 = this.by) != 0) {
                F.put("bn_click_area", i3);
            }
        }
        return F;
    }

    public final int G() {
        return this.ay;
    }

    public final void G(int i2) {
        this.by = i2;
    }

    public final int H() {
        return this.az;
    }

    public final void H(int i2) {
        this.bz = i2;
    }

    public final java.lang.String I() {
        return this.aA;
    }

    public final int J() {
        return this.aB;
    }

    public final int K() {
        return this.aC;
    }

    public final java.lang.String L() {
        return this.ax;
    }

    public final int M() {
        return this.o;
    }

    public final int N() {
        return this.av;
    }

    public final long O() {
        return this.aG;
    }

    public final long P() {
        return this.aH;
    }

    public final int Q() {
        return this.bh;
    }

    public final int R() {
        return this.bm;
    }

    public final com.anythink.core.common.f.h S() {
        try {
            com.anythink.core.common.f.h hVar = (com.anythink.core.common.f.h) super.clone();
            hVar.bp = this.bp;
            hVar.bs = this.bs;
            hVar.bq = this.bq;
            hVar.br = this.br;
            hVar.bu = this.bu;
            hVar.bt = this.bt;
            return hVar;
        } catch (java.lang.Throwable unused) {
            return this;
        }
    }

    public final double a() {
        return this.bA;
    }

    public final void a(double d2) {
        this.bA = d2;
    }

    public final void a(int i2) {
        this.bB = i2;
    }

    public final void a(long j2) {
        this.bg = j2;
    }

    public final void a(com.anythink.core.api.ATRewardInfo aTRewardInfo) {
        this.bp = aTRewardInfo;
    }

    public final void a(com.anythink.core.common.f.c cVar) {
        this.bt = cVar;
    }

    public final void a(java.lang.String str) {
        this.bn = str;
    }

    public final void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.bu = map;
    }

    public final void a(boolean z) {
        this.bv = z;
    }

    public final java.lang.String b() {
        com.anythink.core.common.f.c cVar = this.bt;
        return cVar != null ? cVar.a() : "";
    }

    public final void b(double d2) {
        this.bw = d2;
    }

    public final void b(int i2) {
        this.bx = i2;
    }

    public final void b(long j2) {
        this.ba = j2;
    }

    public final void b(java.lang.String str) {
        this.aZ = str;
    }

    public final void b(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.bs = map;
    }

    public final void b(boolean z) {
        this.H = z;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> c() {
        return this.bu;
    }

    public final void c(double d2) {
        this.G = d2;
    }

    public final void c(int i2) {
        this.bi = i2;
    }

    public final void c(long j2) {
        this.aG = j2;
    }

    public final void c(java.lang.String str) {
        this.aW = str;
    }

    public final void c(java.util.Map<java.lang.String, com.anythink.core.api.ATRewardInfo> map) {
        this.bq = map;
    }

    public final int d() {
        return this.bx;
    }

    public final void d(double d2) {
        this.aS = d2;
    }

    public final void d(int i2) {
        this.bj = i2;
    }

    public final void d(long j2) {
        this.aH = j2;
    }

    public final void d(java.lang.String str) {
        this.aQ = str;
    }

    public final void d(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.br = map;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> e() {
        return this.bs;
    }

    public final void e(double d2) {
        this.aP = d2;
    }

    public final void e(int i2) {
        this.be = i2;
    }

    public final void e(long j2) {
        this.K = j2;
    }

    public final void e(java.lang.String str) {
        this.aT = str;
    }

    public final int f() {
        return this.bf;
    }

    public final void f(double d2) {
        this.w = d2;
    }

    public final void f(int i2) {
        this.bf = i2;
    }

    public final void f(long j2) {
        this.L = j2;
    }

    public final void f(java.lang.String str) {
        this.x = str;
    }

    public final int g() {
        return this.bb;
    }

    public final void g(int i2) {
        this.bd = i2;
    }

    public final void g(java.lang.String str) {
        this.aJ = str;
    }

    public final void h() {
        this.aY = 1;
    }

    public final void h(int i2) {
        this.bc = i2;
    }

    public final void h(java.lang.String str) {
        this.aK = str;
    }

    public final void i() {
        if (this.aY != 1) {
            this.aX = 1;
        }
    }

    public final void i(int i2) {
        this.bb = i2;
    }

    public final void i(java.lang.String str) {
        this.aM = str;
    }

    public final java.lang.String j() {
        return this.aW;
    }

    public final void j(int i2) {
        this.C = i2;
    }

    public final void j(java.lang.String str) {
        this.aN = str;
    }

    public final double k() {
        return this.aS;
    }

    public final void k(int i2) {
        this.D = i2;
    }

    public final void k(java.lang.String str) {
        this.aO = str;
    }

    public final double l() {
        return this.aP;
    }

    public final void l(int i2) {
        this.E = i2;
    }

    public final void l(java.lang.String str) {
        this.aI = str;
    }

    public final java.lang.String m() {
        return this.aQ;
    }

    public final void m(int i2) {
        this.F = i2;
    }

    public final void m(java.lang.String str) {
        this.aA = str;
    }

    public final java.lang.String n() {
        return this.aT;
    }

    public final void n(int i2) {
        this.aL = i2;
    }

    public final void n(java.lang.String str) {
        this.ax = str;
    }

    public final java.lang.String o() {
        return this.x;
    }

    public final void o(int i2) {
        this.bo = i2;
    }

    public final void o(java.lang.String str) {
        this.aw = str;
    }

    public final java.lang.String p() {
        return this.aJ;
    }

    public final void p(int i2) {
        this.z = i2;
    }

    public final void p(java.lang.String str) {
        this.aV = str;
    }

    public final java.lang.String q() {
        return this.aK;
    }

    public final void q(int i2) {
        this.A = i2;
    }

    public final void q(java.lang.String str) {
        this.J = str;
    }

    public final int r() {
        return this.aL;
    }

    public final void r(int i2) {
        this.v = i2;
    }

    public final void r(java.lang.String str) {
        this.M = str;
    }

    public final java.lang.String s() {
        return this.aM;
    }

    public final void s(int i2) {
        this.aD = i2;
    }

    public final java.lang.String t() {
        return this.aN;
    }

    public final void t(int i2) {
        this.aE = i2;
    }

    public final java.lang.String u() {
        return this.aO;
    }

    public final void u(int i2) {
        this.ay = i2;
    }

    public final java.util.Map<java.lang.String, com.anythink.core.api.ATRewardInfo> v() {
        return this.bq;
    }

    public final void v(int i2) {
        this.az = i2;
    }

    public final com.anythink.core.api.ATRewardInfo w() {
        return this.bp;
    }

    public final void w(int i2) {
        this.aB = i2;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> x() {
        return this.br;
    }

    public final void x(int i2) {
        this.aC = i2;
    }

    public final int y() {
        return this.z;
    }

    public final void y(int i2) {
        this.o = i2;
    }

    public final int z() {
        return this.A;
    }

    public final void z(int i2) {
        this.av = i2;
    }
}
