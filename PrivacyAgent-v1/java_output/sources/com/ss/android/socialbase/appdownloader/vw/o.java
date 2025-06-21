package com.ss.android.socialbase.appdownloader.vw;

/* loaded from: classes19.dex */
public class o extends com.ss.android.socialbase.appdownloader.vw.vw {
    public o(android.content.Context context, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, java.lang.String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.vw.yl
    public android.content.Intent wg() {
        android.content.Intent intent = new android.content.Intent(com.ss.android.socialbase.downloader.constants.DownloadConstants.LOWER_OPPO + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.t);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
