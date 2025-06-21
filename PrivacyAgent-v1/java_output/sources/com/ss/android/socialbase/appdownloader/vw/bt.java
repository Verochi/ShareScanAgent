package com.ss.android.socialbase.appdownloader.vw;

/* loaded from: classes19.dex */
public class bt extends com.ss.android.socialbase.appdownloader.vw.vw {
    public bt(android.content.Context context, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, java.lang.String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.vw.yl
    public android.content.Intent wg() {
        android.content.Intent intent = new android.content.Intent(com.ss.android.socialbase.downloader.constants.DownloadConstants.LOWER_OPPO + ".filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.t);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
