package com.ss.android.socialbase.appdownloader;

/* loaded from: classes19.dex */
public class kz {
    private com.ss.android.socialbase.downloader.depend.IDownloadDepend a;
    private boolean aq;
    private boolean b;
    private java.lang.String bt;
    private com.ss.android.socialbase.downloader.depend.IDownloadListener cp;
    private java.lang.String d;
    private boolean e;
    private com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend f;
    private int fu;
    private com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler g;
    private boolean h;
    private java.lang.String hp;
    private org.json.JSONObject ih;
    private boolean ip;
    private java.lang.String iq;
    private java.lang.String iz;
    private boolean jb;
    private boolean k;
    private int ki;
    private int kk;
    private com.ss.android.socialbase.downloader.depend.INotificationClickCallback kn;
    private java.lang.String kz;
    private java.lang.String m;
    private boolean ml;
    private boolean n;
    private java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> o;
    private boolean oo;
    private com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator q;
    private com.ss.android.socialbase.downloader.notification.AbsNotificationItem qm;

    /* renamed from: s, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.t.yl f432s;
    private java.lang.String t;
    private com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator te;
    private long tj;
    private com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator tq;
    private com.ss.android.socialbase.downloader.depend.IDownloadListener u;
    private java.lang.String up;
    private java.lang.String ux;
    private java.util.List<java.lang.String> v;
    private android.app.Activity vw;
    private boolean w;
    private android.content.Context wg;
    private int[] wu;
    private int wy;
    private com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider xs;
    private java.lang.String yl;
    private long ym;
    private boolean x = true;
    private boolean es = false;
    private boolean z = true;
    private boolean vl = false;
    private java.lang.String j = "application/vnd.android.package-archive";
    private int zl = 5;

    /* renamed from: tv, reason: collision with root package name */
    private boolean f433tv = true;
    private com.ss.android.socialbase.downloader.constants.EnqueueType ao = com.ss.android.socialbase.downloader.constants.EnqueueType.ENQUEUE_NONE;
    private int lb = 150;
    private boolean mi = true;
    private java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> vs = new java.util.ArrayList();
    private boolean sh = true;
    private boolean ol = true;

    public kz(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
        this.wg = context.getApplicationContext();
        this.t = str;
    }

    public com.ss.android.socialbase.appdownloader.t.yl a() {
        return this.f432s;
    }

    public com.ss.android.socialbase.downloader.constants.EnqueueType ao() {
        return this.ao;
    }

    public boolean aq() {
        return this.oo;
    }

    public int b() {
        return this.lb;
    }

    public com.ss.android.socialbase.appdownloader.kz bt(java.lang.String str) {
        this.iq = str;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz bt(boolean z) {
        this.b = z;
        return this;
    }

    public boolean bt() {
        return this.z;
    }

    public com.ss.android.socialbase.appdownloader.kz cp(boolean z) {
        this.w = z;
        return this;
    }

    public com.ss.android.socialbase.downloader.notification.AbsNotificationItem cp() {
        return this.qm;
    }

    public com.ss.android.socialbase.appdownloader.kz d(boolean z) {
        this.ip = z;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator d() {
        return this.tq;
    }

    public boolean e() {
        return this.mi;
    }

    public com.ss.android.socialbase.appdownloader.kz es(java.lang.String str) {
        this.ux = str;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz es(boolean z) {
        this.aq = z;
        return this;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadListener es() {
        return this.cp;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadDepend f() {
        return this.a;
    }

    public boolean fu() {
        return this.sh;
    }

    public java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> g() {
        return this.vs;
    }

    public android.app.Activity getActivity() {
        return this.vw;
    }

    public android.content.Context getContext() {
        return this.wg;
    }

    public int h() {
        return this.zl;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler hp() {
        return this.g;
    }

    public long ih() {
        return this.ym;
    }

    public java.lang.String ip() {
        return this.m;
    }

    public int iq() {
        return this.wy;
    }

    public boolean iz() {
        return this.b;
    }

    public com.ss.android.socialbase.appdownloader.kz j(boolean z) {
        this.sh = z;
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator j() {
        return this.te;
    }

    public java.lang.String jb() {
        return this.hp;
    }

    public boolean k() {
        return this.n;
    }

    public int[] ki() {
        return this.wu;
    }

    public java.lang.String kk() {
        return this.kz;
    }

    public boolean kn() {
        return this.ml;
    }

    public com.ss.android.socialbase.appdownloader.kz kz(@com.ss.android.socialbase.downloader.constants.ExecutorGroup int i) {
        this.ki = i;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz kz(java.lang.String str) {
        this.j = str;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz kz(boolean z) {
        this.h = z;
        return this;
    }

    public boolean kz() {
        return this.es;
    }

    public boolean lb() {
        return this.w;
    }

    public boolean m() {
        return this.ol;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend mi() {
        return this.f;
    }

    public int ml() {
        return this.ki;
    }

    public long n() {
        return this.tj;
    }

    public com.ss.android.socialbase.appdownloader.kz o(java.lang.String str) {
        this.iz = str;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz o(boolean z) {
        this.jb = z;
        return this;
    }

    public boolean o() {
        return this.vl;
    }

    public org.json.JSONObject ol() {
        return this.ih;
    }

    public boolean oo() {
        return this.jb;
    }

    public java.lang.String q() {
        return this.iq;
    }

    public java.lang.String qm() {
        return this.iz;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider s() {
        return this.xs;
    }

    public java.util.List<java.lang.String> sh() {
        return this.v;
    }

    public com.ss.android.socialbase.appdownloader.kz t(int i) {
        this.wy = i;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz t(@androidx.annotation.NonNull java.lang.String str) {
        this.bt = str;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz t(boolean z) {
        this.vl = z;
        return this;
    }

    public java.lang.String t() {
        return this.bt;
    }

    public boolean te() {
        return this.h;
    }

    public java.lang.String tj() {
        return this.up;
    }

    public int tq() {
        return this.fu;
    }

    public boolean tv() {
        return this.e;
    }

    public com.ss.android.socialbase.appdownloader.kz u(boolean z) {
        this.mi = z;
        return this;
    }

    public boolean u() {
        return this.k;
    }

    public int up() {
        return this.kk;
    }

    public com.ss.android.socialbase.appdownloader.kz v(int i) {
        this.lb = i;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz v(java.lang.String str) {
        this.hp = str;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz v(boolean z) {
        this.k = z;
        return this;
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> v() {
        return this.o;
    }

    public com.ss.android.socialbase.appdownloader.kz vl(boolean z) {
        this.oo = z;
        return this;
    }

    public java.lang.String vl() {
        return this.j;
    }

    public java.lang.String vs() {
        return this.ux;
    }

    public com.ss.android.socialbase.appdownloader.kz vw(long j) {
        this.tj = j;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz vw(com.ss.android.socialbase.downloader.constants.EnqueueType enqueueType) {
        this.ao = enqueueType;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz vw(com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (this.vs) {
            if (iDownloadCompleteHandler != null) {
                if (!this.vs.contains(iDownloadCompleteHandler)) {
                    this.vs.add(iDownloadCompleteHandler);
                    return this;
                }
            }
            return this;
        }
    }

    public com.ss.android.socialbase.appdownloader.kz vw(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
        this.g = iDownloadDiskSpaceHandler;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz vw(com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.xs = iDownloadFileUriProvider;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz vw(com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        this.u = iDownloadListener;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz vw(java.lang.String str) {
        this.yl = str;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz vw(java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) {
        this.o = list;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz vw(org.json.JSONObject jSONObject) {
        this.ih = jSONObject;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz vw(boolean z) {
        this.x = z;
        return this;
    }

    public java.lang.String vw() {
        return this.t;
    }

    public void vw(int i) {
        this.fu = i;
    }

    public boolean w() {
        return this.f433tv;
    }

    public com.ss.android.socialbase.appdownloader.kz wg(int i) {
        this.zl = i;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz wg(java.lang.String str) {
        this.kz = str;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz wg(java.util.List<java.lang.String> list) {
        this.v = list;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz wg(boolean z) {
        this.es = z;
        return this;
    }

    public java.lang.String wg() {
        return this.yl;
    }

    public com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator wy() {
        return this.q;
    }

    public com.ss.android.socialbase.appdownloader.kz x(java.lang.String str) {
        this.up = str;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz x(boolean z) {
        this.f433tv = z;
        return this;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadListener x() {
        return this.u;
    }

    public com.ss.android.socialbase.downloader.depend.INotificationClickCallback xs() {
        return this.kn;
    }

    public com.ss.android.socialbase.appdownloader.kz yl(int i) {
        this.kk = i;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz yl(java.lang.String str) {
        this.d = str;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz yl(boolean z) {
        this.n = z;
        return this;
    }

    public boolean yl() {
        return this.x;
    }

    public boolean ym() {
        return this.ip;
    }

    public com.ss.android.socialbase.appdownloader.kz z(java.lang.String str) {
        this.m = str;
        return this;
    }

    public com.ss.android.socialbase.appdownloader.kz z(boolean z) {
        this.e = z;
        return this;
    }

    public java.lang.String z() {
        return this.d;
    }

    public boolean zl() {
        return this.aq;
    }
}
