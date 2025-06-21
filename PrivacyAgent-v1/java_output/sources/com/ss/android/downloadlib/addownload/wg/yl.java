package com.ss.android.downloadlib.addownload.wg;

/* loaded from: classes19.dex */
public class yl implements com.ss.android.downloadad.api.vw.vw {
    public com.ss.android.download.api.download.DownloadEventConfig t;
    public com.ss.android.download.api.download.DownloadController v;
    public long vw;
    public com.ss.android.download.api.download.DownloadModel wg;
    public com.ss.android.downloadad.api.vw.wg yl;

    public yl() {
    }

    public yl(long j, @androidx.annotation.NonNull com.ss.android.download.api.download.DownloadModel downloadModel, @androidx.annotation.NonNull com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, @androidx.annotation.NonNull com.ss.android.download.api.download.DownloadController downloadController) {
        this.vw = j;
        this.wg = downloadModel;
        this.t = downloadEventConfig;
        this.v = downloadController;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public org.json.JSONObject bt() {
        return this.wg.getExtra();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.util.List<java.lang.String> cp() {
        return this.wg.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.Object d() {
        return this.t.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.String es() {
        return this.t.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public com.ss.android.download.api.download.DownloadController h() {
        return this.v;
    }

    public boolean iq() {
        com.ss.android.download.api.download.DownloadModel downloadModel;
        if (this.vw == 0 || (downloadModel = this.wg) == null || this.t == null || this.v == null) {
            return true;
        }
        return downloadModel.isAd() && this.vw <= 0;
    }

    public boolean iz() {
        if (iq()) {
            return false;
        }
        if (!this.wg.isAd()) {
            return this.wg instanceof com.ss.android.downloadad.api.download.AdDownloadModel;
        }
        com.ss.android.download.api.download.DownloadModel downloadModel = this.wg;
        return (downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) && !android.text.TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.t instanceof com.ss.android.downloadad.api.download.AdDownloadEventConfig) && (this.v instanceof com.ss.android.downloadad.api.download.AdDownloadController);
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public org.json.JSONObject j() {
        return this.t.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public boolean k() {
        return this.v.enableNewActivity();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.String kz() {
        if (this.wg.getDeepLink() != null) {
            return this.wg.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public com.ss.android.download.api.download.DownloadEventConfig n() {
        return this.t;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public int o() {
        if (this.v.getDownloadMode() == 2) {
            return 2;
        }
        return this.wg.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public int q() {
        return this.t.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public com.ss.android.download.api.download.DownloadModel qm() {
        return this.wg;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public boolean t() {
        return this.wg.isAd();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public org.json.JSONObject te() {
        return this.wg.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public int tq() {
        return 0;
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public boolean u() {
        return this.t.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.String v() {
        return this.wg.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public long vl() {
        return this.wg.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.String vw() {
        return this.wg.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public long wg() {
        return this.wg.getId();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.String x() {
        return this.t.getRefer();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public java.lang.String yl() {
        return this.wg.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.vw.vw
    public org.json.JSONObject z() {
        return this.t.getParamsJson();
    }
}
