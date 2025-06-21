package com.jd.ad.sdk.jad_xk;

/* loaded from: classes23.dex */
public class jad_dq implements java.io.Serializable {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public int i;
    public int j;
    public java.lang.String jad_ad;
    public int jad_al;
    public int jad_an;
    public java.lang.String jad_be;
    public java.lang.String jad_bm;
    public int jad_bo;
    public java.lang.String jad_cf;
    public int jad_cn;
    public java.lang.String jad_cp;
    public java.lang.String jad_dg;
    public int jad_do;
    public java.lang.String jad_dq;
    public java.lang.String jad_eh;
    public int jad_en;
    public java.lang.String jad_ep;
    public java.lang.String jad_er;
    public java.lang.String jad_fi;
    public int jad_fo;
    public java.lang.String jad_fq;
    public java.lang.String jad_fs;
    public java.lang.String jad_gj;
    public int jad_gp;
    public java.lang.String jad_gr;
    public java.lang.String jad_hj;
    public java.lang.String jad_hk;
    public int jad_hq;
    public int jad_hs;
    public int jad_hu;
    public java.lang.String jad_ik;
    public java.lang.String jad_il;
    public int jad_ir;
    public int jad_it;
    public int jad_iv;
    public java.lang.String jad_jl;
    public java.lang.String jad_jm;
    public int jad_js;
    public int jad_jt;
    public int jad_ju;
    public java.lang.String jad_jw;
    public java.lang.String jad_km;
    public int jad_kn;
    public int jad_kt;
    public int jad_kv;
    public int jad_kx;
    public java.lang.String jad_lo;
    public int jad_lu;
    public int jad_lw;
    public java.lang.String jad_ly;
    public int jad_mp;
    public int jad_mv;
    public int jad_mx;
    public java.lang.String jad_mz;
    public java.lang.String jad_na;
    public int jad_nq;
    public int jad_nw;
    public com.jd.ad.sdk.dl.model.jad_an jad_ny;
    public java.lang.String jad_ob;
    public int jad_or;
    public int jad_ox;
    public int jad_oz;
    public int jad_pa;
    public java.lang.String jad_pc;
    public int jad_ps;
    public int jad_py;
    public int jad_qb;
    public java.lang.String jad_qd;
    public java.lang.String jad_qt;
    public int jad_qz;
    public int jad_ra;
    public int jad_rc;
    public java.lang.String jad_re;
    public double jad_ru;
    public java.lang.String jad_sb;
    public java.lang.String jad_sd;
    public com.jd.ad.sdk.jad_xk.jad_jw jad_sf;
    public int jad_sv;
    public java.lang.String jad_tc;
    public int jad_te;
    public java.lang.String jad_tg;
    public double jad_tw;
    public int jad_ud;
    public int jad_uf;
    public java.lang.String jad_uh;
    public int jad_ux;
    public java.lang.String jad_ve;
    public int jad_vg;
    public int jad_vi;
    public java.lang.String jad_vy;
    public int jad_wf;
    public int jad_wh;
    public int jad_wj;
    public java.lang.String jad_wz;
    public java.lang.String jad_xa;
    public int jad_xg;
    public java.lang.String jad_xi;
    public int jad_xk;
    public java.lang.String jad_yb;
    public int jad_yh;
    public int jad_yj;
    public int jad_yl;
    public java.lang.String jad_zc;
    public int jad_zi;
    public int jad_zk;
    public int jad_zm;
    public java.lang.String k;
    public java.lang.String l;
    public java.lang.String m;
    public java.lang.String n;
    public java.lang.String o;
    public java.lang.String p;
    public java.lang.String q;
    public java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    public int f395s;

    public jad_dq(int i, java.lang.String str) {
        this(i, new org.json.JSONObject(str));
    }

    public jad_dq(int i, org.json.JSONObject jSONObject) {
        this.jad_oz = 0;
        this.jad_pa = 0;
        if (jSONObject == null) {
            return;
        }
        this.jad_an = i;
        jad_an(jSONObject);
    }

    public org.json.JSONObject jad_an() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tp", java.lang.Integer.valueOf(this.jad_bo));
            if (this.jad_bo == 1) {
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adrid", this.jad_cp);
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", this.jad_fs);
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pfid", java.lang.Integer.valueOf(this.jad_jt));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(this.jad_hu));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tpid", java.lang.Integer.valueOf(this.jad_iv));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "plwd", java.lang.Integer.valueOf(this.jad_zk));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "plht", java.lang.Integer.valueOf(this.jad_al));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", java.lang.Integer.valueOf(this.jad_wh));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rem", java.lang.Integer.valueOf(this.jad_lw));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tcbr", java.lang.Integer.valueOf(this.jad_lu));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dstp", java.lang.Integer.valueOf(this.jad_yh));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "srtp", java.lang.Integer.valueOf(this.jad_zi));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ipl", java.lang.Integer.valueOf(this.jad_ps));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "toti", java.lang.Double.valueOf(this.jad_ru));
            }
            if (this.jad_bo == 2) {
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adrid", this.jad_cp);
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", this.jad_fs);
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pfid", java.lang.Integer.valueOf(this.jad_jt));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(this.jad_hu));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tpid", java.lang.Integer.valueOf(this.jad_iv));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", java.lang.Integer.valueOf(this.jad_wh));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rem", java.lang.Integer.valueOf(this.jad_lw));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sddu", java.lang.Integer.valueOf(this.jad_fo));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "alct", java.lang.Integer.valueOf(this.jad_mv));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "jdad", java.lang.Integer.valueOf(this.jad_nw));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adat", java.lang.Integer.valueOf(this.jad_ox));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "catp", java.lang.Integer.valueOf(this.jad_wf));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "msst", java.lang.Integer.valueOf(this.jad_xg));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dstp", java.lang.Integer.valueOf(this.jad_yh));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "srtp", java.lang.Integer.valueOf(this.jad_zi));
                str = "ipl";
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, str, java.lang.Integer.valueOf(this.jad_ps));
            } else {
                str = "ipl";
            }
            java.lang.String str5 = "dstp";
            if (this.jad_bo == 3) {
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adrid", this.jad_cp);
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", this.jad_fs);
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pfid", java.lang.Integer.valueOf(this.jad_jt));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(this.jad_hu));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.umeng.analytics.pro.ay.h, this.jad_er);
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tpid", java.lang.Integer.valueOf(this.jad_iv));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", java.lang.Integer.valueOf(this.jad_wh));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rem", java.lang.Integer.valueOf(this.jad_lw));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "imm", java.lang.Integer.valueOf(this.jad_mx));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sedu", java.lang.Integer.valueOf(this.jad_gp));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dedu", java.lang.Integer.valueOf(this.jad_hq));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sspt", java.lang.Integer.valueOf(this.jad_qz));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "scav", java.lang.Integer.valueOf(this.jad_ra));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adat", java.lang.Integer.valueOf(this.jad_ox));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, str, java.lang.Integer.valueOf(this.jad_ps));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "cons", this.jad_ny.jad_an());
                str2 = "catp";
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, str2, java.lang.Integer.valueOf(this.jad_wf));
                str3 = str;
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, str5, java.lang.Integer.valueOf(this.jad_yh));
                str5 = str5;
                str4 = "srtp";
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, str4, java.lang.Integer.valueOf(this.jad_zi));
            } else {
                str2 = "catp";
                str3 = str;
                str4 = "srtp";
            }
            java.lang.String str6 = str4;
            java.lang.String str7 = str2;
            if (this.jad_bo == 4) {
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adrid", this.jad_cp);
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", this.jad_fs);
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pfid", java.lang.Integer.valueOf(this.jad_jt));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(this.jad_hu));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "clid", this.jad_jw);
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tpid", java.lang.Integer.valueOf(this.jad_iv));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "clf", java.lang.Integer.valueOf(this.jad_kx));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", java.lang.Integer.valueOf(this.jad_wh));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rem", java.lang.Integer.valueOf(this.jad_lw));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dety", java.lang.Integer.valueOf(this.jad_en));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "scdu", java.lang.Integer.valueOf(this.jad_ir));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dcdu", java.lang.Integer.valueOf(this.jad_js));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ecdu", java.lang.Integer.valueOf(this.jad_kt));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sspt", java.lang.Integer.valueOf(this.jad_qz));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "scav", java.lang.Integer.valueOf(this.jad_ra));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adat", java.lang.Integer.valueOf(this.jad_ox));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "atst", java.lang.Integer.valueOf(this.jad_py));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, str7, java.lang.Integer.valueOf(this.jad_wf));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, str5, java.lang.Integer.valueOf(this.jad_yh));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, str6, java.lang.Integer.valueOf(this.jad_zi));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, str3, java.lang.Integer.valueOf(this.jad_ps));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "vpst", java.lang.Integer.valueOf(this.jad_sv));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "vpdt", java.lang.Double.valueOf(this.jad_tw));
                if (this.jad_kx == com.jd.ad.sdk.dl.common.CommonConstants.ClickFrom.AD.ordinal()) {
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sims", java.lang.Integer.valueOf(this.jad_ux));
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ifp", this.jad_vy);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ip", this.jad_wz);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "vpc", this.jad_xa);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "abi", this.jad_yb);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "jbr", java.lang.Integer.valueOf(this.jad_hs));
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "vir", this.jad_zc);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dp", this.jad_ad);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "lau", this.jad_be);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "awa", this.jad_cf);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "moce", this.jad_dg);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "malrun", this.jad_eh);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "appct", this.jad_fi);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.getui.gtc.extension.distribution.gbd.f.b.m, this.jad_hj);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pip", this.jad_ik);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "qem", this.jad_jl);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dne", this.jad_km);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "bra", this.a);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "bri", this.b);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pro", this.c);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "bat", this.d);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "hoo", this.e);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.igexin.sdk.PushBuildConfig.sdk_conf_channelid, this.f);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dbg", this.g);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "cpty", this.h);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "phsc", java.lang.Integer.valueOf(this.i));
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rebl", java.lang.Integer.valueOf(this.j));
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "hdwa", this.k);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "osut", this.l);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "hwml", this.m);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sysm", this.n);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sysd", this.o);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "frds", this.p);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "board", this.q);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "cpfq", this.r);
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "plug", java.lang.Integer.valueOf(this.f395s));
                }
            }
            if (this.jad_bo == 5) {
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "extp", java.lang.Integer.valueOf(this.jad_qb));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.anythink.expressad.d.a.b.dy, java.lang.Integer.valueOf(this.jad_rc));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "erin", this.jad_sd);
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rid", this.jad_bm);
                if (this.jad_qb == 3) {
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", java.lang.Integer.valueOf(this.jad_wh));
                } else {
                    com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", 0);
                }
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "crt", java.lang.Integer.valueOf(this.jad_pa));
            }
            if (this.jad_bo == 6) {
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "iid", this.jad_xi);
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "init", java.lang.Integer.valueOf(this.jad_yj));
                com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "idu", java.lang.Integer.valueOf(this.jad_oz));
            }
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sv", this.jad_re);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "bi", this.jad_qd);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.anythink.core.common.j.af, this.jad_pc);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ts", this.jad_ly);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "os", this.jad_mz);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "osv", this.jad_na);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "did", this.jad_ob);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "geo", this.jad_sf.jad_an());
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "swd", java.lang.Integer.valueOf(this.jad_te));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sht", java.lang.Integer.valueOf(this.jad_uf));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.anythink.expressad.d.a.b.dx, java.lang.Integer.valueOf(this.jad_vg));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "mk", this.jad_tg);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "md", this.jad_uh);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "svb", java.lang.Integer.valueOf(this.jad_vi));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "jdi", java.lang.Integer.valueOf(this.jad_wj));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "qqi", java.lang.Integer.valueOf(this.jad_xk));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "wci", java.lang.Integer.valueOf(this.jad_yl));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tbi", java.lang.Integer.valueOf(this.jad_zm));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tmi", java.lang.Integer.valueOf(this.jad_cn));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pddi", java.lang.Integer.valueOf(this.jad_do));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.anythink.expressad.foundation.g.a.V, this.jad_ep);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.alipay.sdk.m.s.a.u, this.jad_fq);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "asv", this.jad_gr);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.APID, this.jad_dq);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "jbr", java.lang.Integer.valueOf(this.jad_hs));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.aliyun.common.log.struct.AliyunLogKey.KEY_AUDIO_FORMAT, java.lang.Integer.valueOf(this.jad_it));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "atsv", java.lang.Integer.valueOf(this.jad_ju));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ihrd", java.lang.Integer.valueOf(this.jad_kv));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pn", this.jad_sb);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sc", this.jad_tc);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "hos", java.lang.Integer.valueOf(this.jad_ud));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "hosv", this.jad_ve);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sav", this.jad_gj);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "mt", this.jad_hk);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "hwv", this.jad_il);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ca", this.jad_jm);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ppi", java.lang.Integer.valueOf(this.jad_kn));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "cc", this.jad_lo);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sof", java.lang.Integer.valueOf(this.jad_mp));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.getui.gtc.extension.distribution.gbd.f.h.n, java.lang.Integer.valueOf(this.jad_nq));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "em", java.lang.Integer.valueOf(this.jad_or));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "soaid", this.jad_qt);
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w("Event to json ", e.getMessage());
        }
        return jSONObject;
    }

    public final void jad_an(org.json.JSONObject jSONObject) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        try {
            int optInt = jSONObject.optInt("tp");
            this.jad_bo = optInt;
            if (optInt == 1) {
                this.jad_cp = jSONObject.optString("adrid");
                this.jad_fs = jSONObject.optString("pid");
                this.jad_jt = jSONObject.optInt("pfid");
                this.jad_hu = jSONObject.optInt("adt");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_iv = jSONObject.optInt("tpid");
                this.jad_zk = jSONObject.optInt("plwd");
                this.jad_al = jSONObject.optInt("plht");
                this.jad_lw = jSONObject.optInt("rem");
                this.jad_lu = jSONObject.optInt("tcbr");
                this.jad_yh = jSONObject.optInt("dstp");
                this.jad_zi = jSONObject.optInt("srtp");
                this.jad_ps = jSONObject.optInt("ipl");
                str = "###";
                str2 = "ipl";
                this.jad_ru = jSONObject.optDouble("toti", 0.0d);
            } else {
                str = "###";
                str2 = "ipl";
            }
            if (this.jad_bo == 2) {
                this.jad_cp = jSONObject.optString("adrid");
                this.jad_fs = jSONObject.optString("pid");
                this.jad_jt = jSONObject.optInt("pfid");
                this.jad_hu = jSONObject.optInt("adt");
                this.jad_iv = jSONObject.optInt("tpid");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_lw = jSONObject.optInt("rem");
                this.jad_fo = jSONObject.optInt("sddu");
                this.jad_mv = jSONObject.optInt("alct");
                this.jad_nw = jSONObject.optInt("jdad");
                this.jad_ox = jSONObject.optInt("adat");
                this.jad_wf = jSONObject.optInt("catp");
                this.jad_xg = jSONObject.optInt("msst");
                this.jad_yh = jSONObject.optInt("dstp");
                this.jad_zi = jSONObject.optInt("srtp");
                str3 = str2;
                this.jad_ps = jSONObject.optInt(str3);
            } else {
                str3 = str2;
            }
            java.lang.String str4 = str3;
            java.lang.String str5 = "srtp";
            if (this.jad_bo == 3) {
                this.jad_cp = jSONObject.optString("adrid");
                this.jad_fs = jSONObject.optString("pid");
                this.jad_jt = jSONObject.optInt("pfid");
                this.jad_hu = jSONObject.optInt("adt");
                this.jad_er = jSONObject.optString(com.umeng.analytics.pro.ay.h);
                this.jad_iv = jSONObject.optInt("tpid");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_lw = jSONObject.optInt("rem");
                this.jad_mx = jSONObject.optInt("imm");
                this.jad_gp = jSONObject.optInt("sedu");
                this.jad_hq = jSONObject.optInt("dedu");
                this.jad_qz = jSONObject.optInt("sspt");
                this.jad_ra = jSONObject.optInt("scav");
                this.jad_ox = jSONObject.optInt("adat");
                this.jad_wf = jSONObject.optInt("catp");
                this.jad_yh = jSONObject.optInt("dstp");
                this.jad_zi = jSONObject.optInt(str5);
                str5 = str5;
                this.jad_ps = jSONObject.optInt(str4);
                str4 = str4;
                this.jad_ny = new com.jd.ad.sdk.dl.model.jad_an(jSONObject.optJSONObject("cons"));
            }
            if (this.jad_bo == 4) {
                this.jad_cp = jSONObject.optString("adrid");
                this.jad_fs = jSONObject.optString("pid");
                this.jad_jt = jSONObject.optInt("pfid");
                this.jad_hu = jSONObject.optInt("adt");
                this.jad_jw = jSONObject.optString("clid");
                this.jad_iv = jSONObject.optInt("tpid");
                this.jad_kx = jSONObject.optInt("clf");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_lw = jSONObject.optInt("rem");
                this.jad_en = jSONObject.optInt("dety");
                this.jad_ir = jSONObject.optInt("scdu");
                this.jad_js = jSONObject.optInt("dcdu");
                this.jad_kt = jSONObject.optInt("ecdu");
                this.jad_qz = jSONObject.optInt("sspt");
                this.jad_ra = jSONObject.optInt("scav");
                this.jad_ox = jSONObject.optInt("adat");
                this.jad_py = jSONObject.optInt("atst");
                this.jad_wf = jSONObject.optInt("catp");
                this.jad_yh = jSONObject.optInt("dstp");
                this.jad_zi = jSONObject.optInt(str5);
                this.jad_ps = jSONObject.optInt(str4);
                this.jad_sv = jSONObject.optInt("vpst");
                this.jad_tw = jSONObject.optDouble("vpdt", 0.0d);
                if (this.jad_kx == com.jd.ad.sdk.dl.common.CommonConstants.ClickFrom.AD.ordinal()) {
                    this.jad_ux = jSONObject.optInt("sims");
                    this.jad_vy = jSONObject.optString("ifp");
                    this.jad_wz = jSONObject.optString("ip");
                    this.jad_xa = jSONObject.optString("vpc");
                    this.jad_yb = jSONObject.optString("abi");
                    this.jad_hs = jSONObject.optInt("jbr");
                    this.jad_zc = jSONObject.optString("vir");
                    this.jad_ad = jSONObject.optString("dp");
                    this.jad_be = jSONObject.optString("lau");
                    this.jad_cf = jSONObject.optString("awa");
                    this.jad_dg = jSONObject.optString("moce");
                    this.jad_eh = jSONObject.optString("malrun");
                    this.jad_fi = jSONObject.optString("appct");
                    this.jad_hj = jSONObject.optString(com.getui.gtc.extension.distribution.gbd.f.b.m);
                    this.jad_ik = jSONObject.optString("pip");
                    this.jad_jl = jSONObject.optString("qem");
                    this.jad_km = jSONObject.optString("dne");
                    this.a = jSONObject.optString("bra");
                    this.b = jSONObject.optString("bri");
                    this.c = jSONObject.optString("pro");
                    this.d = jSONObject.optString("bat");
                    this.e = jSONObject.optString("hoo");
                    this.f = jSONObject.optString(com.igexin.sdk.PushBuildConfig.sdk_conf_channelid);
                    this.g = jSONObject.optString("dbg");
                    this.h = jSONObject.optString("cpty");
                    this.i = jSONObject.optInt("phsc");
                    this.j = jSONObject.optInt("rebl");
                    this.k = jSONObject.optString("hdwa");
                    this.l = jSONObject.optString("osut");
                    this.m = jSONObject.optString("hwml");
                    this.n = jSONObject.optString("sysm");
                    this.o = jSONObject.optString("sysd");
                    this.p = jSONObject.optString("frds");
                    this.q = jSONObject.optString("board");
                    this.r = jSONObject.optString("cpfq");
                    this.f395s = jSONObject.optInt("plug");
                }
            }
            if (this.jad_bo == 5) {
                this.jad_qb = jSONObject.optInt("extp");
                this.jad_rc = jSONObject.optInt(com.anythink.expressad.d.a.b.dy);
                java.lang.String optString = jSONObject.optString("erin");
                this.jad_sd = optString;
                if (!android.text.TextUtils.isEmpty(optString) && this.jad_an > 0) {
                    java.lang.String str6 = str;
                    if (!this.jad_sd.startsWith(str6)) {
                        this.jad_sd = str6 + this.jad_an + "_" + this.jad_sd;
                    }
                }
                this.jad_bm = jSONObject.optString("rid");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_pa = jSONObject.optInt("crt");
            }
            if (this.jad_bo == 6) {
                this.jad_xi = jSONObject.optString("iid");
                this.jad_yj = jSONObject.optInt("init");
                this.jad_oz = jSONObject.optInt("idu");
            }
            this.jad_ly = jSONObject.optString("ts");
            this.jad_mz = jSONObject.optString("os");
            this.jad_na = jSONObject.optString("osv");
            this.jad_ob = jSONObject.optString("did");
            this.jad_qd = jSONObject.optString("bi");
            this.jad_pc = jSONObject.optString(com.anythink.core.common.j.af);
            this.jad_re = jSONObject.optString("sv");
            this.jad_sf = new com.jd.ad.sdk.jad_xk.jad_jw(jSONObject.optJSONObject("geo"));
            this.jad_te = jSONObject.optInt("swd");
            this.jad_uf = jSONObject.optInt("sht");
            this.jad_vg = jSONObject.optInt(com.anythink.expressad.d.a.b.dx);
            this.jad_tg = jSONObject.optString("mk");
            this.jad_uh = jSONObject.optString("md");
            this.jad_vi = jSONObject.optInt("svb");
            this.jad_wj = jSONObject.optInt("jdi");
            this.jad_xk = jSONObject.optInt("qqi");
            this.jad_yl = jSONObject.optInt("wci");
            this.jad_zm = jSONObject.optInt("tbi");
            this.jad_cn = jSONObject.optInt("tmi");
            this.jad_do = jSONObject.optInt("pddi");
            this.jad_ep = jSONObject.optString(com.anythink.expressad.foundation.g.a.V);
            this.jad_fq = jSONObject.optString(com.alipay.sdk.m.s.a.u);
            this.jad_gr = jSONObject.optString("asv");
            this.jad_dq = jSONObject.optString(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.APID);
            this.jad_hs = jSONObject.optInt("jbr");
            this.jad_it = jSONObject.optInt(com.aliyun.common.log.struct.AliyunLogKey.KEY_AUDIO_FORMAT);
            this.jad_ju = jSONObject.optInt("atsv");
            this.jad_kv = jSONObject.optInt("ihrd");
            this.jad_sb = jSONObject.optString("pn");
            this.jad_tc = jSONObject.optString("sc");
            this.jad_ud = jSONObject.optInt("hos");
            this.jad_ve = jSONObject.optString("hosv");
            this.jad_gj = jSONObject.optString("sav");
            this.jad_hk = jSONObject.optString("mt");
            this.jad_il = jSONObject.optString("hwv");
            this.jad_jm = jSONObject.optString("ca");
            this.jad_kn = jSONObject.optInt("ppi");
            this.jad_lo = jSONObject.optString("cc");
            this.jad_mp = jSONObject.optInt("sof");
            this.jad_nq = jSONObject.optInt(com.getui.gtc.extension.distribution.gbd.f.h.n);
            this.jad_or = jSONObject.optInt("em");
            this.jad_qt = jSONObject.optString("soaid");
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w("parse event from json ", e.getMessage());
        }
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return jad_an().toString();
    }
}
