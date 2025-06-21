package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: classes19.dex */
public class t extends com.ss.android.socialbase.downloader.utils.LruCache<java.lang.Long, com.ss.android.downloadlib.addownload.wg.wg> {

    public static class vw {
        private static com.ss.android.downloadlib.addownload.compliance.t vw = new com.ss.android.downloadlib.addownload.compliance.t(null);
    }

    private t() {
        super(16, 16);
    }

    public /* synthetic */ t(com.ss.android.downloadlib.addownload.compliance.t.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.ss.android.downloadlib.addownload.compliance.t vw() {
        return com.ss.android.downloadlib.addownload.compliance.t.vw.vw;
    }

    public com.ss.android.downloadlib.addownload.wg.wg vw(long j) {
        return get(java.lang.Long.valueOf(j));
    }

    public com.ss.android.downloadlib.addownload.wg.wg vw(long j, long j2) {
        return get(get(java.lang.Long.valueOf(j)) != null ? java.lang.Long.valueOf(j) : java.lang.Long.valueOf(j2));
    }

    public void vw(com.ss.android.downloadlib.addownload.wg.wg wgVar) {
        if (wgVar == null) {
            return;
        }
        put(java.lang.Long.valueOf(wgVar.vw()), wgVar);
    }
}
