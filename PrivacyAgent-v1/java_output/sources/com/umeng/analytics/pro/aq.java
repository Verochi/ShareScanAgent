package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class aq implements java.lang.Runnable {
    public static final java.lang.String a = "https://aspect-upush.umeng.com/occa/v1/event/report";
    public static final java.lang.String b = "https://cnlogs.umeng.com/ext_event";
    private java.lang.String c;
    private java.lang.String d;

    public aq(java.lang.String str, org.json.JSONObject jSONObject) {
        this.c = str;
        this.d = jSONObject.toString();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (android.text.TextUtils.isEmpty(this.d)) {
                return;
            }
            com.umeng.analytics.pro.ap.b(this.c, this.d.getBytes());
        } catch (java.lang.Throwable unused) {
        }
    }
}
