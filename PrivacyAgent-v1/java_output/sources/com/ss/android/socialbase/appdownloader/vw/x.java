package com.ss.android.socialbase.appdownloader.vw;

/* loaded from: classes19.dex */
public class x extends com.ss.android.socialbase.appdownloader.vw.vw {
    private java.lang.String v;
    private java.lang.String yl;

    public x(android.content.Context context, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(context, downloadSetting, str);
        this.v = str2;
        this.yl = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3  */
    @Override // com.ss.android.socialbase.appdownloader.vw.yl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public android.content.Intent wg() {
        java.lang.String str;
        java.lang.String optString = this.wg.optString("s");
        java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString("ak"), optString);
        java.lang.String vw2 = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString("am"), optString);
        java.lang.String vw3 = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString(com.alipay.sdk.m.s.a.u), optString);
        java.lang.String str2 = null;
        if (!android.text.TextUtils.isEmpty(vw3) && vw3.split(",").length == 2) {
            java.lang.String[] split = vw3.split(",");
            java.lang.String vw4 = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString("al"), optString);
            java.lang.String vw5 = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString("ao"), optString);
            if (!android.text.TextUtils.isEmpty(vw5) && vw5.split(",").length == 2) {
                java.lang.String[] split2 = vw5.split(",");
                org.json.JSONObject optJSONObject = this.wg.optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
                if (optJSONObject != null) {
                    java.lang.String optString2 = optJSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
                    if (!android.text.TextUtils.isEmpty(optString2) && optString2.contains("%s")) {
                        try {
                            str = java.lang.String.format(optString2, this.yl);
                        } catch (java.lang.Throwable unused) {
                        }
                        str2 = str;
                        if (str2.length() > 255) {
                            str2 = vw4.substring(str2.length() - 255);
                        }
                    }
                    str = this.yl;
                    str2 = str;
                    if (str2.length() > 255) {
                    }
                }
                android.content.Intent intent = new android.content.Intent(vw);
                intent.putExtra(split2[0], split2[1]);
                intent.putExtra(vw2, this.v);
                intent.putExtra(vw4, str2);
                intent.putExtra(split[0], java.lang.Integer.parseInt(split[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
