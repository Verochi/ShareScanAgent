package com.ss.android.download.api.download;

@java.lang.Deprecated
/* loaded from: classes19.dex */
public class t implements com.ss.android.download.api.download.DownloadEventConfig {
    private java.lang.String bt;
    private boolean cp;
    private boolean d;
    private java.lang.String es;
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String kz;
    private java.lang.String o;
    private java.lang.String t;
    private boolean u;
    private java.lang.String v;
    private java.lang.Object vl;
    private java.lang.String vw;
    private boolean wg;
    private java.lang.String x;
    private java.lang.String yl;
    private java.lang.String z;

    public static final class vw {
        private java.lang.String bt;
        private boolean cp;
        private boolean d;
        private java.lang.String es;
        private java.lang.String j;
        private java.lang.String k;
        private java.lang.String kz;
        private java.lang.String o;
        private java.lang.String t;
        private boolean u;
        private java.lang.String v;
        private java.lang.Object vl;
        private java.lang.String vw;
        private boolean wg;
        private java.lang.String x;
        private java.lang.String yl;
        private java.lang.String z;

        public com.ss.android.download.api.download.t vw() {
            return new com.ss.android.download.api.download.t(this, null);
        }
    }

    public t() {
    }

    private t(com.ss.android.download.api.download.t.vw vwVar) {
        this.vw = vwVar.vw;
        this.wg = vwVar.wg;
        this.t = vwVar.t;
        this.v = vwVar.v;
        this.yl = vwVar.yl;
        this.kz = vwVar.kz;
        this.bt = vwVar.bt;
        this.o = vwVar.o;
        this.x = vwVar.x;
        this.es = vwVar.es;
        this.z = vwVar.z;
        this.vl = vwVar.vl;
        this.u = vwVar.u;
        this.cp = vwVar.cp;
        this.d = vwVar.d;
        this.j = vwVar.j;
        this.k = vwVar.k;
    }

    public /* synthetic */ t(com.ss.android.download.api.download.t.vw vwVar, com.ss.android.download.api.download.t.AnonymousClass1 anonymousClass1) {
        this(vwVar);
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickButtonTag() {
        return this.vw;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickContinueLabel() {
        return this.kz;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickInstallLabel() {
        return this.bt;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickLabel() {
        return this.t;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickPauseLabel() {
        return this.yl;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickStartLabel() {
        return this.v;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.Object getExtraEventObject() {
        return this.vl;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public org.json.JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public org.json.JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getRefer() {
        return this.k;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getStorageDenyLabel() {
        return this.es;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.wg;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.u;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(java.lang.String str) {
    }
}
