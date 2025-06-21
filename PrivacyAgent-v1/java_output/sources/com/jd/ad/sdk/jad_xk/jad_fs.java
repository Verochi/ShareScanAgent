package com.jd.ad.sdk.jad_xk;

/* loaded from: classes23.dex */
public class jad_fs {
    public static void jad_an(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tp", 6);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "iid", str);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "init", 2);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "idu", 0);
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(java.lang.String str, int i, int i2, java.lang.String str2, int i3) {
        if (com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_NET_IS_UNAVAILABLE_ERROR.jad_an(new java.lang.String[0]).equals(str2)) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tp", 5);
        if (i == 2 || i == 3) {
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rid", str);
        } else {
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rid", "");
        }
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "extp", java.lang.Integer.valueOf(i));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.anythink.expressad.d.a.b.dy, java.lang.Integer.valueOf(i2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "erin", str2);
        if (i == 3) {
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", java.lang.Integer.valueOf(i3));
        } else {
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", 0);
        }
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(java.lang.String str, int i, java.lang.String str2) {
        jad_an(str, 5, i, str2, 0);
    }

    public static void jad_an(java.lang.String str, long j) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tp", 6);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "iid", str);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "init", 3);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "idu", java.lang.Long.valueOf(j));
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, int i9, int i10, double d) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tp", 1);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adrid", str);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", str2);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pfid", java.lang.Integer.valueOf(i));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(i2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", java.lang.Integer.valueOf(i3));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "plwd", java.lang.Integer.valueOf(i5));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "plht", java.lang.Integer.valueOf(i4));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tpid", java.lang.Integer.valueOf(i6));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rem", java.lang.Integer.valueOf(i7));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tcbr", java.lang.Long.valueOf(j));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dstp", java.lang.Integer.valueOf(i8));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "srtp", java.lang.Integer.valueOf(i9));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ipl", java.lang.Integer.valueOf(i10));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "toti", java.lang.Double.valueOf(d));
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, int i7, int i8, int i9, int i10, org.json.JSONObject jSONObject, int i11, int i12, int i13) {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "tp", 3);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "adrid", str);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "pid", str2);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "pfid", java.lang.Integer.valueOf(i));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "adt", java.lang.Integer.valueOf(i2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, com.umeng.analytics.pro.ay.h, com.jd.ad.sdk.fdt.utils.UUIDUtils.uuid());
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "tpid", java.lang.Integer.valueOf(i3));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "sen", java.lang.Integer.valueOf(i4));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "rem", java.lang.Integer.valueOf(i5));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "imm", java.lang.Integer.valueOf(i6));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "sedu", java.lang.Long.valueOf(j));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "dedu", java.lang.Long.valueOf(j2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "sspt", java.lang.Integer.valueOf(i7));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "scav", java.lang.Integer.valueOf(i8));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "adat", java.lang.Integer.valueOf(i9));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "catp", java.lang.Integer.valueOf(i10));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "cons", jSONObject);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "dstp", java.lang.Integer.valueOf(i11));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "srtp", java.lang.Integer.valueOf(i12));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "ipl", java.lang.Integer.valueOf(i13));
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_bo(jSONObject2);
    }

    public static void jad_an(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, long j3, int i7, int i8, int i9, int i10, int i11, int i12) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tp", 4);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adrid", str);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", str2);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pfid", java.lang.Integer.valueOf(i));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(i2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "clid", com.jd.ad.sdk.fdt.utils.UUIDUtils.uuid());
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tpid", java.lang.Integer.valueOf(i3));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "clf", java.lang.Integer.valueOf(i9));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", java.lang.Integer.valueOf(i4));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rem", java.lang.Integer.valueOf(i5));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dety", java.lang.Integer.valueOf(i6));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "scdu", java.lang.Long.valueOf(j));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dcdu", java.lang.Long.valueOf(j2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ecdu", java.lang.Long.valueOf(j3));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sspt", java.lang.Integer.valueOf(i7));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "scav", java.lang.Integer.valueOf(i8));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dstp", java.lang.Integer.valueOf(i10));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "srtp", java.lang.Integer.valueOf(i11));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ipl", java.lang.Integer.valueOf(i12));
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, long j3, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tp", 4);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adrid", str);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", str2);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pfid", java.lang.Integer.valueOf(i));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(i2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "clid", com.jd.ad.sdk.fdt.utils.UUIDUtils.uuid());
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tpid", java.lang.Integer.valueOf(i3));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "clf", java.lang.Integer.valueOf(com.jd.ad.sdk.dl.common.CommonConstants.ClickFrom.AD.ordinal()));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", java.lang.Integer.valueOf(i4));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rem", java.lang.Integer.valueOf(i5));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dety", java.lang.Integer.valueOf(i6));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "scdu", java.lang.Long.valueOf(j));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dcdu", java.lang.Long.valueOf(j2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ecdu", java.lang.Long.valueOf(j3));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sspt", java.lang.Integer.valueOf(i7));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "scav", java.lang.Integer.valueOf(i8));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adat", java.lang.Integer.valueOf(i9));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "atst", java.lang.Integer.valueOf(i10));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "catp", java.lang.Integer.valueOf(i11));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dstp", java.lang.Integer.valueOf(i12));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "srtp", java.lang.Integer.valueOf(i13));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ipl", java.lang.Integer.valueOf(i14));
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, int i6, long j2, int i7, int i8, int i9, int i10, int i11, int i12) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tp", 2);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adrid", str);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", str2);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pfid", java.lang.Integer.valueOf(i));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(i2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "tpid", java.lang.Integer.valueOf(i3));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sen", java.lang.Integer.valueOf(i4));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "rem", java.lang.Integer.valueOf(i5));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "sddu", java.lang.Long.valueOf(j));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "alct", java.lang.Integer.valueOf(i6));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "alct", java.lang.Integer.valueOf(i6));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "jdad", java.lang.Long.valueOf(j2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adat", java.lang.Integer.valueOf(i7));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "catp", java.lang.Integer.valueOf(i8));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "msst", java.lang.Integer.valueOf(i9));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "dstp", java.lang.Integer.valueOf(i10));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "srtp", java.lang.Integer.valueOf(i11));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "ipl", java.lang.Integer.valueOf(i12));
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }
}
