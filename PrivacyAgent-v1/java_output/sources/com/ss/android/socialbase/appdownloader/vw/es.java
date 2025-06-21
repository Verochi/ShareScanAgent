package com.ss.android.socialbase.appdownloader.vw;

/* loaded from: classes19.dex */
public class es extends com.ss.android.socialbase.appdownloader.vw.vw {
    public es(android.content.Context context, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, java.lang.String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.vw.yl
    public android.content.Intent wg() {
        android.content.Intent intent = new android.content.Intent("com.android.filemanager.FILE_OPEN");
        intent.putExtra("FilePathToBeOpenAfterScan", this.t);
        intent.putExtra("com.iqoo.secure", true);
        intent.putExtra("OpenParentAndLocationDestFile", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
