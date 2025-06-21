package com.jd.ad.sdk.jad_kx;

/* loaded from: classes23.dex */
public class jad_fs {
    public java.util.Map<java.lang.String, java.util.ArrayList<com.jd.ad.sdk.jad_kx.jad_cp>> jad_an = new java.util.LinkedHashMap();
    public final java.util.List<java.lang.String> jad_bo = new java.util.ArrayList();
    public final java.util.List<java.lang.String> jad_cp = new java.util.ArrayList();

    public static class jad_an {
        public static final com.jd.ad.sdk.jad_kx.jad_fs jad_an = new com.jd.ad.sdk.jad_kx.jad_fs();
    }

    public java.util.ArrayList<com.jd.ad.sdk.jad_kx.jad_cp> jad_an(java.lang.String str) {
        java.util.Map<java.lang.String, java.util.ArrayList<com.jd.ad.sdk.jad_kx.jad_cp>> map = this.jad_an;
        java.util.ArrayList<com.jd.ad.sdk.jad_kx.jad_cp> arrayList = map != null ? map.get(str) : null;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        this.jad_bo.clear();
        long currentTimeMillis = java.lang.System.currentTimeMillis() - (com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an.jad_bo() * 1000);
        java.util.Iterator<com.jd.ad.sdk.jad_kx.jad_cp> it = arrayList.iterator();
        while (it.hasNext()) {
            com.jd.ad.sdk.jad_kx.jad_cp next = it.next();
            if (next != null) {
                java.lang.String str2 = next.jad_er;
                java.lang.String str3 = next.jad_dq;
                java.lang.String str4 = next.jad_bo;
                if (android.text.TextUtils.isEmpty(str3) || java.lang.Long.parseLong(str2) < currentTimeMillis) {
                    this.jad_bo.add(str4);
                    it.remove();
                }
            }
        }
        return arrayList;
    }
}
