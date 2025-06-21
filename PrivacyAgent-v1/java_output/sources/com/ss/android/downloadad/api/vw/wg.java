package com.ss.android.downloadad.api.vw;

/* loaded from: classes19.dex */
public class wg implements com.ss.android.downloadad.api.vw.vw {
    private boolean a;
    private boolean ao;
    private boolean aq;
    private int b;
    private java.lang.String bt;
    private int cp;
    private int d;
    private java.lang.String e;
    private java.lang.String es;
    private boolean f;
    private transient boolean fu;
    private long g;
    private int h;
    private boolean hp;
    private java.lang.String ih;
    private boolean ip;
    private boolean iq;
    private int iz;
    private int j;
    private long jb;
    private java.lang.String k;
    private boolean ki;
    private java.lang.String kk;
    private boolean kn;
    private long kz;
    private boolean lb;
    private boolean m;
    private java.lang.String mi;
    private boolean ml;
    private org.json.JSONObject n;
    private int o;
    private boolean ol;
    private boolean oo;
    private boolean q;
    private long qm;

    /* renamed from: s, reason: collision with root package name */
    private int f430s;
    private boolean sh;
    public final java.util.concurrent.atomic.AtomicBoolean t;
    private java.lang.String te;
    private int tj;
    private java.lang.String tq;

    /* renamed from: tv, reason: collision with root package name */
    private java.lang.String f431tv;
    private int u;
    private int up;
    private boolean ux;
    public final java.util.concurrent.atomic.AtomicBoolean v;
    private java.lang.String vl;
    private boolean vs;
    protected boolean vw;
    private long w;
    protected boolean wg;
    private java.lang.String wj;
    private boolean wu;
    private long wy;
    private java.lang.String x;

    @com.ss.android.downloadad.api.constant.AdBaseConstants.FunnelType
    private int xs;
    private long yl;
    private long ym;
    private java.lang.String z;
    private long zl;

    private wg() {
        this.o = 1;
        this.q = true;
        this.iq = false;
        this.iz = 0;
        this.tj = 0;
        this.aq = false;
        this.oo = false;
        this.ao = true;
        this.lb = true;
        this.vw = true;
        this.wg = true;
        this.t = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.v = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.xs = 1;
        this.kn = true;
        this.ym = -1L;
    }

    public wg(com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public wg(com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, int i) {
        this.o = 1;
        this.q = true;
        this.iq = false;
        this.iz = 0;
        this.tj = 0;
        this.aq = false;
        this.oo = false;
        this.ao = true;
        this.lb = true;
        this.vw = true;
        this.wg = true;
        this.t = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.v = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.xs = 1;
        this.kn = true;
        this.ym = -1L;
        this.yl = downloadModel.getId();
        this.kz = downloadModel.getExtraValue();
        this.bt = downloadModel.getLogExtra();
        this.x = downloadModel.getPackageName();
        this.n = downloadModel.getExtra();
        this.q = downloadModel.isAd();
        this.j = downloadModel.getVersionCode();
        this.k = downloadModel.getVersionName();
        this.es = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.z = downloadModel.getDeepLink().getOpenUrl();
            this.vl = downloadModel.getDeepLink().getWebUrl();
        }
        this.u = downloadModel.getModelType();
        this.te = downloadModel.getName();
        this.tq = downloadModel.getAppIcon();
        this.e = downloadModel.getMimeType();
        this.kk = downloadEventConfig.getClickButtonTag();
        this.mi = downloadEventConfig.getRefer();
        this.f = downloadEventConfig.isEnableV3Event();
        this.iq = downloadController.isEnableBackDialog();
        this.cp = downloadController.getLinkMode();
        this.d = downloadController.getDownloadMode();
        this.kn = downloadController.enableShowComplianceDialog();
        this.ml = downloadController.isAutoDownloadOnCardShow();
        this.ao = downloadController.enableNewActivity();
        this.vw = downloadController.enableAH();
        this.wg = downloadController.enableAM();
        this.h = i;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        this.qm = currentTimeMillis;
        this.w = currentTimeMillis;
        this.oo = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) {
            this.wj = ((com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel).getTaskKey();
        }
    }

    public static com.ss.android.downloadad.api.vw.wg wg(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.ss.android.downloadad.api.vw.wg wgVar = new com.ss.android.downloadad.api.vw.wg();
        try {
            wgVar.v(com.ss.android.download.api.t.wg.vw(jSONObject, "mId"));
            wgVar.yl(com.ss.android.download.api.t.wg.vw(jSONObject, "mExtValue"));
            wgVar.t(jSONObject.optString("mLogExtra"));
            wgVar.yl(jSONObject.optInt("mDownloadStatus"));
            wgVar.wg(jSONObject.optString("mPackageName"));
            boolean z = true;
            wgVar.vw(jSONObject.optBoolean("mIsAd", true));
            wgVar.kz(com.ss.android.download.api.t.wg.vw(jSONObject, "mTimeStamp"));
            wgVar.kz(jSONObject.optInt("mVersionCode"));
            wgVar.v(jSONObject.optString("mVersionName"));
            wgVar.bt(jSONObject.optInt("mDownloadId"));
            wgVar.wg(jSONObject.optBoolean("mIsV3Event"));
            wgVar.o(jSONObject.optInt("mScene"));
            wgVar.kz(jSONObject.optString("mEventTag"));
            wgVar.bt(jSONObject.optString("mEventRefer"));
            wgVar.o(jSONObject.optString("mDownloadUrl"));
            wgVar.t(jSONObject.optBoolean("mEnableBackDialog"));
            wgVar.t.set(jSONObject.optBoolean("hasSendInstallFinish"));
            wgVar.v.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            wgVar.v(jSONObject.optInt("mLastFailedErrCode"));
            wgVar.vw(jSONObject.optString("mLastFailedErrMsg"));
            wgVar.x(jSONObject.optString("mOpenUrl"));
            wgVar.es(jSONObject.optInt("mLinkMode"));
            wgVar.z(jSONObject.optInt("mDownloadMode"));
            wgVar.vl(jSONObject.optInt("mModelType"));
            wgVar.es(jSONObject.optString("mAppName"));
            wgVar.z(jSONObject.optString("mAppIcon"));
            wgVar.vw(jSONObject.optInt("mDownloadFailedTimes", 0));
            wgVar.vw(com.ss.android.download.api.t.wg.vw(jSONObject, "mRecentDownloadResumeTime"));
            wgVar.wg(jSONObject.optInt("mClickPauseTimes"));
            wgVar.wg(com.ss.android.download.api.t.wg.vw(jSONObject, "mJumpInstallTime"));
            wgVar.t(com.ss.android.download.api.t.wg.vw(jSONObject, "mCancelInstallTime"));
            wgVar.t(jSONObject.optInt("mLastFailedResumeCount"));
            wgVar.vl(jSONObject.optString("downloadFinishReason"));
            wgVar.x(jSONObject.optLong("clickDownloadSize"));
            wgVar.o(jSONObject.optLong("clickDownloadTime"));
            wgVar.o(jSONObject.optBoolean("mIsUpdateDownload"));
            wgVar.u(jSONObject.optString("mOriginMimeType"));
            wgVar.x(jSONObject.optBoolean("mIsPatchApplyHandled"));
            wgVar.kz(jSONObject.optBoolean("installAfterCleanSpace"));
            wgVar.x(jSONObject.optInt(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FUNNEL_TYPE, 1));
            wgVar.yl(jSONObject.optString(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_WEB_URL));
            wgVar.j(jSONObject.optBoolean(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG, true));
            wgVar.k(jSONObject.optBoolean(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW));
            wgVar.te(jSONObject.optInt("enable_new_activity", 1) == 1);
            wgVar.tq(jSONObject.optInt("enable_pause", 1) == 1);
            wgVar.q(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            wgVar.qm(z);
            wgVar.vw(jSONObject.optJSONObject("mExtras"));
            wgVar.n(jSONObject.optBoolean("intent_jump_browser_success"));
            wgVar.cp(jSONObject.optString(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_TASK_KEY));
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.addownload.z.q().vw(e, "NativeDownloadModel fromJson");
        }
        return wgVar;
    }

    public int a() {
        return this.cp;
    }

    public com.ss.android.downloadad.api.download.AdDownloadController am() {
        return new com.ss.android.downloadad.api.download.AdDownloadController.Builder().setIsEnableBackDialog(this.iq).setLinkMode(this.cp).setDownloadMode(this.d).setEnableShowComplianceDialog(this.kn).setEnableAH(this.vw).setEnableAM(this.wg).build();
    }

    public java.lang.String ao() {
        return this.k;
    }

    public int aq() {
        return this.o;
    }

    public int b() {
        return this.b;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public org.json.JSONObject bt() {
        return this.n;
    }

    public void bt(int i) {
        this.h = i;
    }

    public void bt(long j) {
        this.ym = j;
    }

    public void bt(java.lang.String str) {
        this.mi = str;
    }

    public void bt(boolean z) {
        this.ki = z;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.util.List<java.lang.String> cp() {
        return null;
    }

    public void cp(java.lang.String str) {
        this.wj = str;
    }

    public void cp(boolean z) {
        this.ol = z;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.Object d() {
        return null;
    }

    public void d(boolean z) {
        this.ux = z;
    }

    public long e() {
        return this.qm;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.String es() {
        return this.kk;
    }

    public void es(int i) {
        this.cp = i;
    }

    public void es(java.lang.String str) {
        this.te = str;
    }

    public void es(boolean z) {
        this.fu = z;
    }

    public java.lang.String f() {
        return this.te;
    }

    public boolean fu() {
        return this.hp;
    }

    public boolean g() {
        return this.a;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public com.ss.android.download.api.download.DownloadController h() {
        return am();
    }

    public boolean hp() {
        return this.ux;
    }

    public boolean ih() {
        return this.aq;
    }

    public boolean ip() {
        return this.sh;
    }

    public int iq() {
        return this.iz;
    }

    public synchronized void iz() {
        this.iz++;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public org.json.JSONObject j() {
        return null;
    }

    public void j(boolean z) {
        this.kn = z;
    }

    public boolean jb() {
        return this.ki;
    }

    public void k(boolean z) {
        this.ml = z;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public boolean k() {
        return this.ao;
    }

    public boolean ki() {
        return this.fu;
    }

    public boolean kk() {
        return this.iq;
    }

    public long kn() {
        return this.g;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.String kz() {
        return this.z;
    }

    public void kz(int i) {
        this.j = i;
    }

    public void kz(long j) {
        if (j > 0) {
            this.qm = j;
        }
    }

    public void kz(java.lang.String str) {
        this.kk = str;
    }

    public void kz(boolean z) {
        this.a = z;
    }

    public com.ss.android.downloadad.api.download.AdDownloadEventConfig l() {
        return new com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder().setClickButtonTag(this.kk).setRefer(this.mi).setIsEnableV3Event(this.f).build();
    }

    public int lb() {
        return this.f430s;
    }

    public java.lang.String m() {
        return this.e;
    }

    public long mi() {
        return this.ym;
    }

    public long ml() {
        return this.jb;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public com.ss.android.download.api.download.DownloadEventConfig n() {
        return l();
    }

    public void n(boolean z) {
        this.wu = z;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public int o() {
        return this.xs;
    }

    public void o(int i) {
        this.f430s = i;
    }

    public void o(long j) {
        this.g = j;
    }

    public void o(java.lang.String str) {
        this.es = str;
    }

    public void o(boolean z) {
        this.aq = z;
    }

    public boolean ol() {
        return this.wu;
    }

    public int oo() {
        return this.j;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public int q() {
        return -1;
    }

    public void q(boolean z) {
        this.vw = z;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public com.ss.android.download.api.download.DownloadModel qm() {
        return wj();
    }

    public void qm(boolean z) {
        this.wg = z;
    }

    public java.lang.String s() {
        return this.ih;
    }

    public boolean sh() {
        return this.ol;
    }

    public void t(int i) {
        this.b = i;
    }

    public void t(long j) {
        this.wy = j;
    }

    public void t(java.lang.String str) {
        this.bt = str;
    }

    public void t(boolean z) {
        this.iq = z;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public boolean t() {
        return this.q;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public org.json.JSONObject te() {
        return null;
    }

    public void te(boolean z) {
        this.ao = z;
    }

    public int tj() {
        return this.tj;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public int tq() {
        return this.h;
    }

    public void tq(boolean z) {
        this.lb = z;
    }

    public java.lang.String tv() {
        return this.f431tv;
    }

    public void u(java.lang.String str) {
        this.e = str;
    }

    public void u(boolean z) {
        this.sh = z;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public boolean u() {
        return this.f;
    }

    public int up() {
        return this.up;
    }

    public java.lang.String ux() {
        return this.wj;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.String v() {
        return this.bt;
    }

    public void v(int i) {
        this.up = i;
    }

    public void v(long j) {
        this.yl = j;
    }

    public void v(java.lang.String str) {
        this.k = str;
    }

    public void v(boolean z) {
        this.m = z;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public long vl() {
        return this.kz;
    }

    public void vl(int i) {
        this.u = i;
    }

    public void vl(java.lang.String str) {
        this.ih = str;
    }

    public void vl(boolean z) {
        this.hp = z;
    }

    public boolean vs() {
        return this.oo;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.String vw() {
        return this.es;
    }

    public void vw(int i) {
        this.iz = i;
    }

    public void vw(long j) {
        this.w = j;
    }

    public void vw(java.lang.String str) {
        this.f431tv = str;
    }

    public void vw(org.json.JSONObject jSONObject) {
        this.n = jSONObject;
    }

    public void vw(boolean z) {
        this.q = z;
    }

    public synchronized void w() {
        this.tj++;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public long wg() {
        return this.yl;
    }

    public void wg(int i) {
        this.tj = i;
    }

    public void wg(long j) {
        this.zl = j;
    }

    public void wg(java.lang.String str) {
        this.x = str;
    }

    public void wg(boolean z) {
        this.f = z;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel wj() {
        return new com.ss.android.downloadad.api.download.AdDownloadModel.Builder().setAdId(this.yl).setExtraValue(this.kz).setLogExtra(this.bt).setPackageName(this.x).setExtra(this.n).setIsAd(this.q).setVersionCode(this.j).setVersionName(this.k).setDownloadUrl(this.es).setModelType(this.u).setMimeType(this.e).setAppName(this.te).setAppIcon(this.tq).setTaskKey(this.wj).setDeepLink(new com.ss.android.download.api.model.DeepLink(this.z, this.vl, null)).build();
    }

    public org.json.JSONObject wu() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("mId", this.yl);
            jSONObject.put("mExtValue", this.kz);
            jSONObject.put("mLogExtra", this.bt);
            jSONObject.put("mDownloadStatus", this.o);
            jSONObject.put("mPackageName", this.x);
            jSONObject.put("mIsAd", this.q);
            jSONObject.put("mTimeStamp", this.qm);
            jSONObject.put("mExtras", this.n);
            jSONObject.put("mVersionCode", this.j);
            jSONObject.put("mVersionName", this.k);
            jSONObject.put("mDownloadId", this.h);
            jSONObject.put("mIsV3Event", this.f);
            jSONObject.put("mScene", this.f430s);
            jSONObject.put("mEventTag", this.kk);
            jSONObject.put("mEventRefer", this.mi);
            jSONObject.put("mDownloadUrl", this.es);
            jSONObject.put("mEnableBackDialog", this.iq);
            jSONObject.put("hasSendInstallFinish", this.t.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.v.get());
            jSONObject.put("mLastFailedErrCode", this.up);
            jSONObject.put("mLastFailedErrMsg", this.f431tv);
            jSONObject.put("mOpenUrl", this.z);
            jSONObject.put("mLinkMode", this.cp);
            jSONObject.put("mDownloadMode", this.d);
            jSONObject.put("mModelType", this.u);
            jSONObject.put("mAppName", this.te);
            jSONObject.put("mAppIcon", this.tq);
            jSONObject.put("mDownloadFailedTimes", this.iz);
            long j = this.w;
            if (j == 0) {
                j = this.qm;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.tj);
            jSONObject.put("mJumpInstallTime", this.zl);
            jSONObject.put("mCancelInstallTime", this.wy);
            jSONObject.put("mLastFailedResumeCount", this.b);
            jSONObject.put("mIsUpdateDownload", this.aq);
            jSONObject.put("mOriginMimeType", this.e);
            jSONObject.put("mIsPatchApplyHandled", this.oo);
            jSONObject.put("downloadFinishReason", this.ih);
            jSONObject.put("clickDownloadTime", this.g);
            jSONObject.put("clickDownloadSize", this.jb);
            jSONObject.put("installAfterCleanSpace", this.a);
            jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FUNNEL_TYPE, this.xs);
            jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_WEB_URL, this.vl);
            jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG, this.kn);
            jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW, this.ml);
            int i = 1;
            jSONObject.put("enable_new_activity", this.ao ? 1 : 0);
            jSONObject.put("enable_pause", this.lb ? 1 : 0);
            jSONObject.put("enable_ah", this.vw ? 1 : 0);
            if (!this.wg) {
                i = 0;
            }
            jSONObject.put("enable_am", i);
            jSONObject.putOpt("intent_jump_browser_success", java.lang.Boolean.valueOf(this.wu));
            jSONObject.put(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_TASK_KEY, this.wj);
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.addownload.z.q().vw(e, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public long wy() {
        return this.zl;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.String x() {
        return this.mi;
    }

    public void x(int i) {
        this.xs = i;
    }

    public void x(long j) {
        this.jb = j;
    }

    public void x(java.lang.String str) {
        this.z = str;
    }

    public void x(boolean z) {
        this.oo = z;
    }

    public boolean xs() {
        return this.vs;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.String yl() {
        return this.x;
    }

    public void yl(int i) {
        this.o = i;
    }

    public void yl(long j) {
        this.kz = j;
    }

    public void yl(java.lang.String str) {
        this.vl = str;
    }

    public void yl(boolean z) {
        this.vs = z;
    }

    public boolean ym() {
        return this.ip;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public org.json.JSONObject z() {
        return null;
    }

    public void z(int i) {
        this.d = i;
    }

    public void z(java.lang.String str) {
        this.tq = str;
    }

    public void z(boolean z) {
        this.ip = z;
    }

    public long zl() {
        long j = this.w;
        return j == 0 ? this.qm : j;
    }
}
