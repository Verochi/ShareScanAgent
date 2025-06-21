package com.jd.ad.sdk.jad_na;

/* loaded from: classes23.dex */
public class jad_bo {

    public static class jad_an {
        public static final com.jd.ad.sdk.jad_na.jad_bo jad_an = new com.jd.ad.sdk.jad_na.jad_bo();
    }

    public com.jd.ad.sdk.jad_yl.jad_cp jad_an(java.lang.String str) {
        com.jd.ad.sdk.jad_yl.jad_hu jad_huVar;
        java.util.List<com.jd.ad.sdk.jad_yl.jad_dq> list;
        com.jd.ad.sdk.jad_yl.jad_dq jad_dqVar;
        com.jd.ad.sdk.jad_yl.jad_jt jad_er = jad_er(str);
        if (jad_er == null || (jad_huVar = jad_er.jad_cp) == null || (list = jad_huVar.jad_an) == null || list.isEmpty() || (jad_dqVar = list.get(0)) == null) {
            return null;
        }
        return jad_dqVar.jad_bo;
    }

    public java.lang.String jad_bo(java.lang.String str) {
        com.jd.ad.sdk.jad_yl.jad_er jad_erVar;
        java.util.List<com.jd.ad.sdk.jad_yl.jad_er> list;
        java.util.List<com.jd.ad.sdk.jad_yl.jad_fs> jad_dq = jad_dq(str);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jad_dq != null && !jad_dq.isEmpty()) {
            for (int i = 0; i < jad_dq.size(); i++) {
                com.jd.ad.sdk.jad_yl.jad_fs jad_fsVar = jad_dq.get(i);
                int size = arrayList.size();
                if (jad_fsVar != null) {
                    java.lang.String str2 = jad_fsVar.jad_er;
                    if (android.text.TextUtils.isEmpty(str2)) {
                        list = jad_fsVar.jad_fs;
                    } else {
                        java.util.ArrayList arrayList2 = new java.util.ArrayList();
                        com.jd.ad.sdk.jad_yl.jad_er jad_erVar2 = new com.jd.ad.sdk.jad_yl.jad_er();
                        jad_erVar2.jad_an = str2;
                        java.lang.String.valueOf(size);
                        arrayList2.add(jad_erVar2);
                        list = arrayList2;
                    }
                } else {
                    list = null;
                }
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(list);
                }
            }
        }
        return (arrayList.isEmpty() || (jad_erVar = (com.jd.ad.sdk.jad_yl.jad_er) arrayList.get(0)) == null || android.text.TextUtils.isEmpty(jad_erVar.jad_an)) ? "" : jad_erVar.jad_an;
    }

    public final com.jd.ad.sdk.jad_yl.jad_fs jad_cp(java.lang.String str) {
        java.util.List<com.jd.ad.sdk.jad_yl.jad_fs> jad_dq;
        if (jad_er(str) == null || (jad_dq = jad_dq(str)) == null || jad_dq.isEmpty()) {
            return null;
        }
        return jad_dq.get(0);
    }

    @androidx.annotation.Nullable
    public java.util.List<com.jd.ad.sdk.jad_yl.jad_fs> jad_dq(java.lang.String str) {
        com.jd.ad.sdk.jad_yl.jad_hu jad_huVar;
        com.jd.ad.sdk.jad_yl.jad_jt jad_er = jad_er(str);
        if (jad_er == null) {
            return null;
        }
        com.jd.ad.sdk.jad_yl.jad_jt jad_er2 = jad_er(str);
        java.util.List<com.jd.ad.sdk.jad_yl.jad_dq> list = (jad_er2 == null || (jad_huVar = jad_er2.jad_cp) == null) ? null : jad_huVar.jad_an;
        if (list == null || list.isEmpty() || jad_er.jad_cp.jad_an.get(0).jad_bo == null || jad_er.jad_cp.jad_an.get(0).jad_bo.jad_an == null || jad_er.jad_cp.jad_an.get(0).jad_bo.jad_an.isEmpty()) {
            return null;
        }
        return jad_er.jad_cp.jad_an.get(0).jad_bo.jad_an;
    }

    public com.jd.ad.sdk.jad_yl.jad_jt jad_er(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.jd.ad.sdk.jad_yl.jad_jt.jad_an(str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
