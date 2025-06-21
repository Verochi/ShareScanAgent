package com.ss.android.socialbase.appdownloader.vw;

/* loaded from: classes19.dex */
public class kz extends com.ss.android.socialbase.appdownloader.vw.vw {
    public kz(android.content.Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.vw.yl
    public android.content.Intent wg() {
        android.content.Intent intent = new android.content.Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
