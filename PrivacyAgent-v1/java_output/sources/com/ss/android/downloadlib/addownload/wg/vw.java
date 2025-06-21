package com.ss.android.downloadlib.addownload.wg;

/* loaded from: classes19.dex */
public class vw {
    public java.lang.String bt;
    public java.lang.String kz;
    public volatile long o;
    public long t;
    public java.lang.String v;
    public long vw;
    public long wg;
    public java.lang.String yl;

    public vw() {
    }

    public vw(long j, long j2, long j3, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.vw = j;
        this.wg = j2;
        this.t = j3;
        this.v = str;
        this.yl = str2;
        this.kz = str3;
        this.bt = str4;
    }

    public static com.ss.android.downloadlib.addownload.wg.vw vw(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.ss.android.downloadlib.addownload.wg.vw vwVar = new com.ss.android.downloadlib.addownload.wg.vw();
        try {
            vwVar.vw = com.ss.android.downloadlib.bt.vl.vw(jSONObject, "mDownloadId");
            vwVar.wg = com.ss.android.downloadlib.bt.vl.vw(jSONObject, "mAdId");
            vwVar.t = com.ss.android.downloadlib.bt.vl.vw(jSONObject, "mExtValue");
            vwVar.v = jSONObject.optString("mPackageName");
            vwVar.yl = jSONObject.optString("mAppName");
            vwVar.kz = jSONObject.optString("mLogExtra");
            vwVar.bt = jSONObject.optString("mFileName");
            vwVar.o = com.ss.android.downloadlib.bt.vl.vw(jSONObject, "mTimeStamp");
            return vwVar;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public org.json.JSONObject vw() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("mDownloadId", this.vw);
            jSONObject.put("mAdId", this.wg);
            jSONObject.put("mExtValue", this.t);
            jSONObject.put("mPackageName", this.v);
            jSONObject.put("mAppName", this.yl);
            jSONObject.put("mLogExtra", this.kz);
            jSONObject.put("mFileName", this.bt);
            jSONObject.put("mTimeStamp", this.o);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
