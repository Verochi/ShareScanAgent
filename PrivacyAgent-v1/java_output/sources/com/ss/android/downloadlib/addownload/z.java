package com.ss.android.downloadlib.addownload;

/* loaded from: classes19.dex */
public class z {
    private static com.ss.android.download.api.config.x bt;
    private static com.ss.android.download.api.config.d cp;
    private static com.ss.android.download.api.config.z d;
    private static com.ss.android.download.api.config.wg es;
    private static com.ss.android.download.api.config.qm j;
    private static com.ss.android.download.api.config.cp k;
    private static com.ss.android.download.api.config.o kz;
    private static com.ss.android.download.api.config.tq n;
    private static com.ss.android.download.api.config.es o;
    private static com.ss.android.download.api.wg.vw q;
    private static com.ss.android.download.api.config.k qm;
    private static com.ss.android.download.api.config.bt t;
    private static com.ss.android.download.api.config.u te;
    private static com.ss.android.download.api.config.j tq;
    private static com.ss.android.download.api.config.yl u;
    private static com.ss.android.download.api.config.t v;
    private static com.ss.android.download.api.config.v vl;
    public static final org.json.JSONObject vw = new org.json.JSONObject();
    private static android.content.Context wg;
    private static com.ss.android.download.api.model.vw x;
    private static com.ss.android.download.api.config.vl yl;
    private static com.ss.android.socialbase.appdownloader.t.o z;

    /* renamed from: com.ss.android.downloadlib.addownload.z$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.ss.android.download.api.config.t {
    }

    /* renamed from: com.ss.android.downloadlib.addownload.z$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.ss.android.socialbase.appdownloader.t.o {
        @Override // com.ss.android.socialbase.appdownloader.t.o
        public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.z$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.ss.android.download.api.config.j {
    }

    /* renamed from: com.ss.android.downloadlib.addownload.z$4, reason: invalid class name */
    public static class AnonymousClass4 implements com.ss.android.download.api.wg.vw {
        @Override // com.ss.android.download.api.wg.vw
        public void vw(java.lang.Throwable th, java.lang.String str) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.z$5, reason: invalid class name */
    public static class AnonymousClass5 implements com.ss.android.download.api.config.tq {
    }

    public static com.ss.android.download.api.config.d bt() {
        return cp;
    }

    public static java.lang.String cp() {
        return "1.7.0";
    }

    public static com.ss.android.download.api.config.v d() {
        return vl;
    }

    @androidx.annotation.NonNull
    public static com.ss.android.download.api.model.vw es() {
        if (x == null) {
            x = new com.ss.android.download.api.model.vw.C0467vw().vw();
        }
        return x;
    }

    public static android.content.Context getContext() {
        android.content.Context context = wg;
        if (context != null) {
            return context;
        }
        throw new java.lang.IllegalArgumentException("Context is null");
    }

    public static boolean h() {
        return (t == null || kz == null || o == null || es == null || qm == null) ? false : true;
    }

    public static com.ss.android.download.api.config.yl j() {
        return u;
    }

    public static com.ss.android.download.api.config.z k() {
        return d;
    }

    public static com.ss.android.socialbase.appdownloader.t.o kz() {
        if (z == null) {
            z = new com.ss.android.downloadlib.addownload.z.AnonymousClass2();
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        if (r0 > 29) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r1 != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        return getContext().getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String n() {
        boolean isExternalStorageLegacy;
        try {
            int i = getContext().getApplicationInfo().targetSdkVersion;
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                if (i == 29) {
                    isExternalStorageLegacy = android.os.Environment.isExternalStorageLegacy();
                }
            }
            return android.os.Environment.getExternalStorageDirectory().getPath() + java.io.File.separator + x().optString("default_save_dir_name", "ByteDownload");
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @androidx.annotation.NonNull
    public static com.ss.android.download.api.config.j o() {
        if (tq == null) {
            tq = new com.ss.android.downloadlib.addownload.z.AnonymousClass3();
        }
        return tq;
    }

    @androidx.annotation.NonNull
    public static com.ss.android.download.api.wg.vw q() {
        if (q == null) {
            q = new com.ss.android.downloadlib.addownload.z.AnonymousClass4();
        }
        return q;
    }

    @androidx.annotation.NonNull
    public static com.ss.android.download.api.config.tq qm() {
        if (n == null) {
            n = new com.ss.android.downloadlib.addownload.z.AnonymousClass5();
        }
        return n;
    }

    @androidx.annotation.NonNull
    public static com.ss.android.download.api.config.vl t() {
        if (yl == null) {
            yl = new com.ss.android.download.api.vw.vw();
        }
        return yl;
    }

    @androidx.annotation.NonNull
    public static com.ss.android.download.api.config.k te() {
        return qm;
    }

    public static com.ss.android.download.api.config.qm tq() {
        return j;
    }

    @androidx.annotation.Nullable
    public static com.ss.android.download.api.config.cp u() {
        return k;
    }

    public static com.ss.android.download.api.config.o v() {
        return kz;
    }

    @androidx.annotation.Nullable
    public static com.ss.android.download.api.config.wg vl() {
        return es;
    }

    public static com.ss.android.download.api.config.bt vw() {
        return t;
    }

    public static void vw(android.content.Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new java.lang.IllegalArgumentException("Context is null");
        }
        wg = context.getApplicationContext();
    }

    public static void vw(@androidx.annotation.NonNull com.ss.android.download.api.config.bt btVar) {
        t = btVar;
    }

    public static void vw(@androidx.annotation.NonNull com.ss.android.download.api.config.es esVar) {
        o = esVar;
    }

    public static void vw(com.ss.android.download.api.config.k kVar) {
        qm = kVar;
    }

    public static void vw(@androidx.annotation.NonNull com.ss.android.download.api.config.o oVar) {
        kz = oVar;
    }

    public static void vw(@androidx.annotation.NonNull com.ss.android.download.api.config.vl vlVar) {
        yl = vlVar;
    }

    public static void vw(@androidx.annotation.NonNull com.ss.android.download.api.config.wg wgVar) {
        es = wgVar;
    }

    public static void vw(@androidx.annotation.NonNull com.ss.android.download.api.config.x xVar) {
        bt = xVar;
    }

    public static void vw(@androidx.annotation.NonNull com.ss.android.download.api.model.vw vwVar) {
        x = vwVar;
    }

    public static void vw(com.ss.android.download.api.wg.vw vwVar) {
        q = vwVar;
    }

    public static void vw(java.lang.String str) {
        com.ss.android.socialbase.appdownloader.v.es().vw(str);
    }

    @androidx.annotation.NonNull
    public static com.ss.android.download.api.config.t wg() {
        if (v == null) {
            v = new com.ss.android.downloadlib.addownload.z.AnonymousClass1();
        }
        return v;
    }

    public static void wg(android.content.Context context) {
        if (wg != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        wg = context.getApplicationContext();
    }

    @androidx.annotation.NonNull
    public static org.json.JSONObject x() {
        com.ss.android.download.api.config.es esVar = o;
        return (esVar == null || esVar.vw() == null) ? vw : o.vw();
    }

    @androidx.annotation.NonNull
    public static com.ss.android.download.api.config.x yl() {
        if (bt == null) {
            bt = new com.ss.android.download.api.vw.wg();
        }
        return bt;
    }

    public static com.ss.android.download.api.config.u z() {
        return te;
    }
}
