package com.ss.android.socialbase.appdownloader.vw;

/* loaded from: classes19.dex */
public class t extends com.ss.android.socialbase.appdownloader.vw.vw {
    private final org.json.JSONObject v;

    public t(android.content.Context context, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, java.lang.String str, org.json.JSONObject jSONObject) {
        super(context, downloadSetting, str);
        this.v = jSONObject;
    }

    private static void vw(@androidx.annotation.NonNull android.content.Intent intent, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        java.util.Iterator<java.lang.String> keys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (keys = jSONObject.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            java.lang.String optString = jSONObject2.optString(next);
            if (optString != null) {
                vw(jSONObject, next, optString, intent);
            }
        }
    }

    private static void vw(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2, android.content.Intent intent) {
        str2.hashCode();
        switch (str2) {
            case "double":
                intent.putExtra(str, jSONObject.optDouble(str));
                break;
            case "string":
                intent.putExtra(str, jSONObject.optString(str));
                break;
            case "int":
                intent.putExtra(str, jSONObject.optInt(str));
                break;
            case "long":
                intent.putExtra(str, jSONObject.optLong(str));
                break;
            case "boolean":
                intent.putExtra(str, jSONObject.optBoolean(str));
                break;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.vw.yl
    public android.content.Intent wg() {
        java.lang.String optString = this.v.optString("action");
        java.lang.String optString2 = this.v.optString("category");
        int optInt = this.v.optInt("flags", 1342210048);
        java.lang.String optString3 = this.v.optString("path_extra_key");
        java.lang.String optString4 = this.v.optString("path_data_key");
        org.json.JSONObject optJSONObject = this.v.optJSONObject("extra");
        org.json.JSONObject optJSONObject2 = this.v.optJSONObject("extra_type");
        if (android.text.TextUtils.isEmpty(optString)) {
            return null;
        }
        android.content.Intent intent = new android.content.Intent(optString);
        if (!android.text.TextUtils.isEmpty(optString2)) {
            intent.addCategory(optString2);
        }
        if (!android.text.TextUtils.isEmpty(optString4)) {
            try {
                intent.setData(android.net.Uri.parse(java.lang.String.format(optString4, this.t)));
            } catch (java.lang.Throwable unused) {
            }
        }
        intent.setFlags(optInt);
        if (!android.text.TextUtils.isEmpty(optString3)) {
            intent.putExtra(optString3, this.t);
        }
        vw(intent, optJSONObject, optJSONObject2);
        return intent;
    }
}
