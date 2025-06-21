package com.jd.ad.sdk.jad_ob;

/* loaded from: classes23.dex */
public class jad_jt {
    public static java.util.Map<java.lang.String, com.jd.ad.sdk.jad_yl.jad_an> jad_an;
    public static java.util.Map<java.lang.String, com.jd.ad.sdk.jad_yl.jad_an> jad_bo;
    public static final java.util.Map<java.lang.String, com.jd.ad.sdk.jad_yl.jad_an> jad_cp = new java.util.HashMap();

    public static com.jd.ad.sdk.jad_yl.jad_an jad_an(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.util.Map<java.lang.String, com.jd.ad.sdk.jad_yl.jad_an> map = jad_bo;
        if (map == null || map.size() == 0) {
            jad_bo = jad_an();
        }
        java.util.Map<java.lang.String, com.jd.ad.sdk.jad_yl.jad_an> map2 = jad_bo;
        jad_an = map2;
        if (map2 == null || map2.size() <= 0) {
            jad_an = jad_cp;
        }
        java.util.Map<java.lang.String, com.jd.ad.sdk.jad_yl.jad_an> map3 = jad_an;
        if (map3 == null || map3.size() <= 0) {
            return null;
        }
        return map3.get(str);
    }

    public static java.util.Map<java.lang.String, com.jd.ad.sdk.jad_yl.jad_an> jad_an() {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.HashMap hashMap2 = new java.util.HashMap();
        com.jd.ad.sdk.jad_pc.jad_cp jad_cp2 = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
        java.util.List<com.jd.ad.sdk.jad_pc.jad_fs> list = jad_cp2 != null ? jad_cp2.jad_cp : null;
        if (list != null && list.size() != 0) {
            for (com.jd.ad.sdk.jad_pc.jad_fs jad_fsVar : list) {
                hashMap2.put(java.lang.Integer.valueOf(jad_fsVar.jad_an), jad_fsVar);
            }
            java.util.List<com.jd.ad.sdk.jad_pc.jad_er> list2 = jad_cp2.jad_jt;
            if (list2 != null && list2.size() != 0) {
                for (com.jd.ad.sdk.jad_pc.jad_er jad_erVar : list2) {
                    java.util.HashMap hashMap3 = new java.util.HashMap();
                    if (jad_erVar != null) {
                        com.jd.ad.sdk.jad_yl.jad_an jad_anVar = new com.jd.ad.sdk.jad_yl.jad_an();
                        com.jd.ad.sdk.jad_pc.jad_fs jad_fsVar2 = (com.jd.ad.sdk.jad_pc.jad_fs) hashMap2.get(java.lang.Integer.valueOf(jad_erVar.jad_cp));
                        jad_anVar.jad_an = jad_fsVar2 != null ? jad_fsVar2.jad_bo : "";
                        java.lang.String str = jad_erVar.jad_an;
                        jad_anVar.jad_bo = str;
                        jad_anVar.jad_cp = jad_erVar.jad_er;
                        jad_anVar.jad_dq = jad_erVar.jad_jt;
                        jad_anVar.jad_er = jad_erVar.jad_hu;
                        hashMap3.put(str, jad_anVar);
                    }
                    hashMap.putAll(hashMap3);
                }
                jad_bo = hashMap;
            }
        }
        return hashMap;
    }
}
