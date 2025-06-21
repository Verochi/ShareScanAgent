package com.ss.android.socialbase.appdownloader.vw;

/* loaded from: classes19.dex */
public class vl extends com.ss.android.socialbase.appdownloader.vw.vw {
    public vl(android.content.Context context, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, java.lang.String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.vw.yl
    public android.content.Intent wg() {
        java.lang.String optString = this.wg.optString("s");
        java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString("ag"), optString);
        java.lang.String vw2 = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString("ah"), optString);
        java.lang.String vw3 = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString(com.anythink.expressad.d.a.b.cZ), optString);
        java.lang.String vw4 = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString("aj"), optString);
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(vw, this.t);
        intent.putExtra(vw2, "*/*");
        intent.putExtra(vw3, true);
        intent.setAction(vw4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
