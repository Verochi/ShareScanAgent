package com.ss.android.socialbase.appdownloader.vw;

/* loaded from: classes19.dex */
public class u extends com.ss.android.socialbase.appdownloader.vw.vw {
    public u(android.content.Context context, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, java.lang.String str) {
        super(context, downloadSetting, str);
    }

    public static java.lang.String vw(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(java.net.URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        java.lang.String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.endsWith("&") ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
    }

    @Override // com.ss.android.socialbase.appdownloader.vw.yl
    public android.content.Intent wg() {
        java.lang.String optString = this.wg.optString("s");
        java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString("bb"), optString);
        if (!android.text.TextUtils.isEmpty(vw) && vw.split(",").length == 2) {
            java.lang.String vw2 = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString("bc"), optString);
            if (!android.text.TextUtils.isEmpty(vw2) && vw2.split(",").length == 2) {
                java.lang.String[] split = vw.split(",");
                java.lang.String[] split2 = vw2.split(",");
                java.lang.String vw3 = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString(com.anythink.expressad.foundation.g.a.L), optString);
                java.lang.String vw4 = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString("be"), optString);
                java.lang.String vw5 = com.ss.android.socialbase.appdownloader.kz.t.vw(this.wg.optString("bf"), optString);
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(vw3, this.t);
                android.content.Intent intent = new android.content.Intent();
                intent.setAction(vw5);
                intent.setData(android.net.Uri.parse(vw4 + vw(hashMap)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
