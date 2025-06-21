package com.jd.ad.sdk.jad_zi;

/* loaded from: classes23.dex */
public class jad_jw implements com.jd.ad.sdk.mdt.service.JADTouchService {
    public final java.lang.String[] jad_an(com.jd.ad.sdk.jad_fs.jad_bo jad_boVar, java.lang.String str) {
        com.jd.ad.sdk.jad_yl.jad_fs jad_cp = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an.jad_cp(str);
        java.util.List<java.lang.String> emptyList = jad_cp != null ? jad_cp.jad_kx : java.util.Collections.emptyList();
        if (emptyList == null) {
            return new java.lang.String[0];
        }
        java.lang.String[] strArr = (java.lang.String[]) emptyList.toArray(new java.lang.String[0]);
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        java.lang.String[] strArr2 = new java.lang.String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = jad_boVar.jad_an(strArr[i]);
        }
        return strArr2;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public int onUserCancelJdJump(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.jad_fs.jad_bo jad_boVar = com.jd.ad.sdk.jad_fs.jad_cp.jad_an.jad_an.jad_an.get(str);
        if (jad_boVar == null) {
            return -2;
        }
        java.lang.String str2 = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_an.get(str);
        java.lang.String str3 = "";
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return -2;
        }
        com.jd.ad.sdk.jad_na.jad_bo jad_boVar2 = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an;
        com.jd.ad.sdk.jad_yl.jad_fs jad_cp = jad_boVar2.jad_cp(str2);
        java.lang.String str4 = (jad_cp == null || android.text.TextUtils.isEmpty(jad_cp.jad_cp)) ? "" : jad_cp.jad_cp;
        com.jd.ad.sdk.jad_yl.jad_fs jad_cp2 = jad_boVar2.jad_cp(str2);
        if (jad_cp2 != null && !android.text.TextUtils.isEmpty(jad_cp2.jad_ly)) {
            str3 = jad_cp2.jad_ly;
        }
        if (!"1".equals(str3) || android.text.TextUtils.isEmpty(str4)) {
            return 2;
        }
        java.lang.String jad_an = jad_boVar.jad_an(str4);
        if (android.text.TextUtils.isEmpty(jad_an)) {
            return 2;
        }
        if (!com.jd.ad.sdk.jad_er.jad_an.jad_bo(context, jad_an)) {
            return 3;
        }
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_an(jad_an(jad_boVar, str2));
        return 4;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public int onViewClicked(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.jad_fs.jad_bo jad_boVar = com.jd.ad.sdk.jad_fs.jad_cp.jad_an.jad_an.jad_an.get(str);
        if (jad_boVar == null) {
            return -2;
        }
        java.lang.String str2 = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_an.get(str);
        java.lang.String str3 = "";
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return -2;
        }
        com.jd.ad.sdk.jad_na.jad_bo jad_boVar2 = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an;
        com.jd.ad.sdk.jad_yl.jad_fs jad_cp = jad_boVar2.jad_cp(str2);
        java.lang.String str4 = (jad_cp == null || android.text.TextUtils.isEmpty(jad_cp.jad_dq)) ? "" : jad_cp.jad_dq;
        com.jd.ad.sdk.jad_yl.jad_fs jad_cp2 = jad_boVar2.jad_cp(str2);
        java.lang.String str5 = (jad_cp2 == null || android.text.TextUtils.isEmpty(jad_cp2.jad_cp)) ? "" : jad_cp2.jad_cp;
        com.jd.ad.sdk.jad_yl.jad_fs jad_cp3 = jad_boVar2.jad_cp(str2);
        if (jad_cp3 != null && !android.text.TextUtils.isEmpty(jad_cp3.jad_ly)) {
            str3 = jad_cp3.jad_ly;
        }
        if ("1".equals(str3) && !android.text.TextUtils.isEmpty(str4) && com.jd.ad.sdk.jad_er.jad_an.jad_an(context, jad_boVar.jad_an(str4))) {
            com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_an(jad_an(jad_boVar, str2));
            return 1;
        }
        if (!"1".equals(str3) || android.text.TextUtils.isEmpty(str5)) {
            return 2;
        }
        java.lang.String jad_an = jad_boVar.jad_an(str5);
        if (android.text.TextUtils.isEmpty(jad_an)) {
            return 2;
        }
        if (!com.jd.ad.sdk.jad_er.jad_an.jad_bo(context, jad_an)) {
            return 3;
        }
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_an(jad_an(jad_boVar, str2));
        return 0;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void onViewTouch(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.MotionEvent motionEvent, @androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.jad_fs.jad_an jad_anVar;
        com.jd.ad.sdk.jad_fs.jad_bo jad_boVar = com.jd.ad.sdk.jad_fs.jad_cp.jad_an.jad_an.jad_an.get(str);
        if (jad_boVar == null || (jad_anVar = jad_boVar.jad_an) == null || motionEvent == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            jad_anVar.jad_an.clear();
            jad_anVar.jad_bo = new com.jd.ad.sdk.jad_fs.jad_dq(java.lang.Math.round(motionEvent.getX()), java.lang.Math.round(motionEvent.getY()), java.lang.System.currentTimeMillis());
            return;
        }
        if (action != 1) {
            if (action == 2) {
                if (jad_anVar.jad_an.size() > 999) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    arrayList.add(jad_anVar.jad_an.get(0));
                    arrayList.addAll(jad_anVar.jad_an.subList(r0.size() - 399, jad_anVar.jad_an.size()));
                    jad_anVar.jad_an.clear();
                    jad_anVar.jad_an.addAll(arrayList);
                    arrayList.clear();
                }
                jad_anVar.jad_an.add(new com.jd.ad.sdk.jad_fs.jad_dq(new java.lang.Double(motionEvent.getX()).intValue(), new java.lang.Double(motionEvent.getY()).intValue(), java.lang.System.currentTimeMillis()));
                return;
            }
            if (action != 3) {
                return;
            }
        }
        jad_anVar.jad_cp = new com.jd.ad.sdk.jad_fs.jad_dq(new java.lang.Double(motionEvent.getX()).intValue(), new java.lang.Double(motionEvent.getY()).intValue(), java.lang.System.currentTimeMillis());
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void registerTouchView(@androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.jad_fs.jad_cp jad_cpVar = com.jd.ad.sdk.jad_fs.jad_cp.jad_an.jad_an;
        if (jad_cpVar.jad_an.get(str) == null) {
            jad_cpVar.jad_an.put(str, new com.jd.ad.sdk.jad_fs.jad_bo());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void unregisterTouchView(@androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.jad_fs.jad_cp jad_cpVar = com.jd.ad.sdk.jad_fs.jad_cp.jad_an.jad_an;
        if (jad_cpVar.jad_an.get(str) != null) {
            jad_cpVar.jad_an.remove(str);
        }
    }
}
