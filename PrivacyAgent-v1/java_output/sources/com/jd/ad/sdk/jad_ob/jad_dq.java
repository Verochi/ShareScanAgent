package com.jd.ad.sdk.jad_ob;

/* loaded from: classes23.dex */
public class jad_dq {
    public static final int[] jad_an = {2, 3, 4, 5, 6, 7, 8, 9};

    public static class jad_an {
        public static final com.jd.ad.sdk.jad_ob.jad_dq jad_an = new com.jd.ad.sdk.jad_ob.jad_dq();
    }

    public int jad_an(boolean z, int i) {
        if (i == 1) {
            return z ? 6 : 2;
        }
        if (i == 2) {
            return z ? 9 : 5;
        }
        if (i == 4) {
            return z ? 7 : 3;
        }
        if (i != 5) {
            return -1;
        }
        return z ? 8 : 4;
    }

    public java.util.List<java.lang.String> jad_an(int i, java.util.List<java.lang.String> list) {
        int i2;
        java.util.ArrayList arrayList;
        java.util.List<com.jd.ad.sdk.jad_pc.jad_er> list2;
        if (list != null && list.size() > 0) {
            switch (i) {
                case 2:
                case 6:
                    i2 = 1;
                    break;
                case 3:
                case 7:
                    i2 = 4;
                    break;
                case 4:
                case 8:
                    i2 = 5;
                    break;
                case 5:
                case 9:
                    i2 = 2;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            com.jd.ad.sdk.jad_pc.jad_cp jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
            if (jad_cp == null || (list2 = jad_cp.jad_jt) == null || list2.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new java.util.ArrayList();
                for (com.jd.ad.sdk.jad_pc.jad_er jad_erVar : list2) {
                    if (jad_erVar != null && i2 == jad_erVar.jad_bo) {
                        arrayList.add(jad_erVar.jad_an);
                    }
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                for (java.lang.String str : list) {
                    java.util.Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (str.equals((java.lang.String) it.next())) {
                            arrayList2.add(str);
                        }
                    }
                }
                return arrayList2;
            }
        }
        return null;
    }

    public boolean jad_an(int i, java.lang.String str) {
        boolean z;
        com.jd.ad.sdk.jad_pc.jad_cp jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
        java.util.ArrayList arrayList = null;
        java.util.List<com.jd.ad.sdk.jad_pc.jad_hu> list = jad_cp == null ? null : jad_cp.jad_hu;
        if (list != null && list.size() != 0) {
            try {
                boolean jad_an2 = jad_an(list);
                if (jad_an2) {
                    return jad_an2;
                }
                for (com.jd.ad.sdk.jad_pc.jad_hu jad_huVar : list) {
                    if (jad_huVar.jad_an == i) {
                        int i2 = 0;
                        while (true) {
                            int[] iArr = jad_an;
                            if (i2 >= iArr.length) {
                                z = false;
                                break;
                            }
                            if (i == iArr[i2]) {
                                z = true;
                                break;
                            }
                            i2++;
                        }
                        if (z) {
                            java.lang.String str2 = jad_huVar.jad_bo;
                            if (!android.text.TextUtils.isEmpty(str2)) {
                                arrayList = new java.util.ArrayList();
                                arrayList.addAll(java.util.Arrays.asList(str2.split(",")));
                            }
                            java.util.List<java.lang.String> jad_an3 = jad_an(i, arrayList);
                            if (jad_an3 != null && jad_an3.size() > 0) {
                                return jad_an3.contains(str);
                            }
                        }
                        return true;
                    }
                }
                return jad_an2;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final boolean jad_an(java.util.List<com.jd.ad.sdk.jad_pc.jad_hu> list) {
        if (list.size() == 0) {
            return false;
        }
        java.util.Iterator<com.jd.ad.sdk.jad_pc.jad_hu> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().jad_an == 1) {
                return true;
            }
        }
        return false;
    }
}
