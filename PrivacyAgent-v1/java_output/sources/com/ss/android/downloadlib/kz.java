package com.ss.android.downloadlib;

/* loaded from: classes19.dex */
public class kz {
    private static volatile com.ss.android.downloadlib.kz vw;
    private com.ss.android.download.api.config.kz wg = null;

    private kz() {
    }

    public static com.ss.android.downloadlib.kz vw() {
        if (vw == null) {
            synchronized (com.ss.android.downloadlib.kz.class) {
                if (vw == null) {
                    vw = new com.ss.android.downloadlib.kz();
                }
            }
        }
        return vw;
    }

    public com.ss.android.download.api.config.kz wg() {
        return this.wg;
    }
}
