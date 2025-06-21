package com.ss.android.downloadlib.addownload.v;

/* loaded from: classes19.dex */
public class yl implements com.ss.android.downloadlib.addownload.v.bt {
    @Override // com.ss.android.downloadlib.addownload.v.bt
    public boolean vw(com.ss.android.downloadad.api.vw.wg wgVar, int i, com.ss.android.downloadlib.addownload.v.o oVar, com.ss.android.downloadlib.addownload.vw.t tVar) {
        if (wgVar == null) {
            return false;
        }
        return com.ss.android.downloadlib.addownload.u.vw(wgVar, !android.text.TextUtils.isEmpty(wgVar.ux()) ? com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext()).vw(wgVar.ux(), null, true) : com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext()).wg(wgVar.vw()), i, oVar, true, tVar);
    }
}
