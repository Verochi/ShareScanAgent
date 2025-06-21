package com.ss.android.socialbase.appdownloader.kz.vw;

/* loaded from: classes19.dex */
public class wg {
    public static final void vw(com.ss.android.socialbase.appdownloader.kz.vw.v vVar, int i) throws java.io.IOException {
        int wg = vVar.wg();
        if (wg == i) {
            return;
        }
        throw new java.io.IOException("Expected chunk of type 0x" + java.lang.Integer.toHexString(i) + ", read 0x" + java.lang.Integer.toHexString(wg) + ".");
    }
}
