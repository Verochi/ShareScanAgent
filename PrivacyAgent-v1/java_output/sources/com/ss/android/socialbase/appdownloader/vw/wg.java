package com.ss.android.socialbase.appdownloader.vw;

@androidx.annotation.RequiresApi(api = 26)
/* loaded from: classes19.dex */
public class wg extends com.ss.android.socialbase.appdownloader.vw.vw {
    public wg(android.content.Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.vw.yl
    public android.content.Intent wg() {
        android.content.Intent intent = new android.content.Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", android.net.Uri.parse("package:" + this.vw.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        return intent;
    }
}
