package com.ss.android.downloadlib.addownload.v;

/* loaded from: classes19.dex */
public class vl implements com.ss.android.downloadlib.addownload.v.x {
    @Override // com.ss.android.downloadlib.addownload.v.x
    public boolean vw(com.ss.android.downloadad.api.vw.wg wgVar, int i, com.ss.android.downloadlib.addownload.v.o oVar) {
        if (wgVar == null) {
            return false;
        }
        return com.ss.android.downloadlib.addownload.u.vw(wgVar, !android.text.TextUtils.isEmpty(wgVar.ux()) ? com.ss.android.downloadlib.o.vw((android.content.Context) null).vw(wgVar.ux(), null, true) : com.ss.android.downloadlib.o.vw((android.content.Context) null).wg(wgVar.vw()), i, oVar, false, null);
    }
}
