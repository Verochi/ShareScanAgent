package com.jd.ad.sdk.jad_fs;

/* loaded from: classes23.dex */
public class jad_bo {
    public com.jd.ad.sdk.jad_fs.jad_an jad_an;

    public jad_bo() {
        this.jad_an = null;
        this.jad_an = new com.jd.ad.sdk.jad_fs.jad_an();
    }

    public java.lang.String jad_an(@androidx.annotation.NonNull java.lang.String str) {
        java.lang.String str2;
        java.lang.String replaceAll;
        com.jd.ad.sdk.jad_fs.jad_dq jad_dqVar;
        java.lang.String sb;
        java.lang.String sb2;
        com.jd.ad.sdk.jad_fs.jad_dq jad_dqVar2;
        com.jd.ad.sdk.jad_fs.jad_dq jad_dqVar3;
        com.jd.ad.sdk.jad_fs.jad_dq jad_dqVar4;
        com.jd.ad.sdk.jad_fs.jad_an jad_anVar = this.jad_an;
        if (jad_anVar == null) {
            return str;
        }
        try {
            int size = jad_anVar.jad_an.size();
            com.jd.ad.sdk.jad_fs.jad_dq jad_dqVar5 = jad_anVar.jad_bo;
            long j = 0;
            long j2 = (jad_dqVar5 == null || (jad_dqVar4 = jad_anVar.jad_cp) == null) ? 0L : jad_dqVar4.jad_an - jad_dqVar5.jad_an;
            if (jad_anVar.jad_an.size() > 0 && (jad_dqVar2 = jad_anVar.jad_an.get(0)) != null && (jad_dqVar3 = jad_anVar.jad_cp) != null) {
                j = jad_dqVar3.jad_an - jad_dqVar2.jad_an;
            }
            java.lang.String str3 = "|" + size + "," + j2 + "," + j + "," + com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) + "," + com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (jad_anVar.jad_an.size() > 400) {
                int size2 = jad_anVar.jad_an.size();
                arrayList.add(jad_anVar.jad_an.get(0));
                arrayList.addAll(jad_anVar.jad_an.subList(size2 - 399, size2));
            } else {
                arrayList.addAll(jad_anVar.jad_an);
            }
            java.lang.String jad_an = jad_anVar.jad_an(arrayList, jad_anVar.jad_an.size() > 10 ? (int) java.lang.Math.floor(jad_anVar.jad_an.size() / 10) : 1);
            if (jad_anVar.jad_bo != null && jad_anVar.jad_an.isEmpty()) {
                java.util.List<com.jd.ad.sdk.jad_fs.jad_dq> list = jad_anVar.jad_an;
                com.jd.ad.sdk.jad_fs.jad_dq jad_dqVar6 = jad_anVar.jad_bo;
                list.add(new com.jd.ad.sdk.jad_fs.jad_dq(jad_dqVar6.jad_bo, jad_dqVar6.jad_cp, jad_dqVar6.jad_an));
            }
            java.util.List<com.jd.ad.sdk.jad_fs.jad_dq> list2 = jad_anVar.jad_an;
            if (list2 == null || list2.size() <= 0) {
                jad_dqVar = null;
            } else {
                java.util.List<com.jd.ad.sdk.jad_fs.jad_dq> list3 = jad_anVar.jad_an;
                jad_dqVar = list3.get(list3.size() - 1);
            }
            java.lang.String str4 = str3 + jad_an + ((jad_anVar.jad_cp == null || jad_dqVar == null) ? "" : "|" + jad_anVar.jad_cp.jad_bo + "," + jad_anVar.jad_cp.jad_cp + "," + (jad_anVar.jad_cp.jad_an - jad_dqVar.jad_an)) + ("|" + jad_anVar.jad_an());
            com.jd.ad.sdk.logger.Logger.d("[cheat] path resultString: " + str4);
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            if (android.text.TextUtils.isEmpty(str)) {
                sb = "";
            } else {
                int floor = (int) java.lang.Math.floor(str.length() / 12);
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                for (int i = 0; i < 12; i++) {
                    sb4.append(java.lang.Integer.toHexString(java.lang.Integer.valueOf(str.charAt(i * floor)).intValue() % 12));
                }
                sb = sb4.toString();
            }
            sb3.append(sb);
            sb3.append(str4);
            sb2 = sb3.toString();
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.d("getPathList Exception: " + e);
        }
        if (android.text.TextUtils.isEmpty(sb2)) {
            str2 = "";
            if (!android.text.TextUtils.isEmpty(str2) || str2.length() <= 2048) {
                replaceAll = str.replaceAll("__SDKAC__", str2);
            } else {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.URL_AC_LENGTH_EXCEEDS_2KB;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(new java.lang.String[0]));
                replaceAll = str;
            }
            if (!android.text.TextUtils.isEmpty(replaceAll) && replaceAll.length() > 4096) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.OPEN_JD_URL_LENGTH_EXCEEDS_4KB;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(new java.lang.String[0]));
            }
            return replaceAll;
        }
        com.jd.ad.sdk.logger.Logger.d("[cheat] Path all is: " + sb2);
        str2 = android.util.Base64.encodeToString(sb2.getBytes(java.nio.charset.Charset.defaultCharset()), 10);
        com.jd.ad.sdk.logger.Logger.d("[cheat] Path all encode is: " + str2);
        if (android.text.TextUtils.isEmpty(str2)) {
        }
        replaceAll = str.replaceAll("__SDKAC__", str2);
        if (!android.text.TextUtils.isEmpty(replaceAll)) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar32 = com.jd.ad.sdk.jad_wj.jad_an.OPEN_JD_URL_LENGTH_EXCEEDS_4KB;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar32.jad_an, jad_anVar32.jad_an(new java.lang.String[0]));
        }
        return replaceAll;
    }
}
