package com.ss.android.downloadlib.yl;

/* loaded from: classes19.dex */
public class t implements com.ss.android.download.api.wg.vw {

    public static class vw {
        private static com.ss.android.downloadlib.yl.t vw = new com.ss.android.downloadlib.yl.t();
    }

    public static com.ss.android.downloadlib.yl.t vw() {
        return com.ss.android.downloadlib.yl.t.vw.vw;
    }

    public static java.lang.String vw(java.lang.Throwable th) {
        try {
            return android.util.Log.getStackTraceString(th);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private void wg(java.lang.Throwable th) {
        if (com.ss.android.socialbase.appdownloader.kz.kz.wg(com.ss.android.downloadlib.addownload.z.getContext())) {
            throw new com.ss.android.downloadlib.yl.vw(th);
        }
    }

    private boolean wg() {
        return com.ss.android.downloadlib.addownload.z.x().optInt("enable_monitor", 1) != 1;
    }

    public void vw(java.lang.String str) {
        vw(true, str);
    }

    @Override // com.ss.android.download.api.wg.vw
    public void vw(java.lang.Throwable th, java.lang.String str) {
        vw(true, th, str);
    }

    public void vw(boolean z, java.lang.String str) {
        if (wg()) {
            return;
        }
        if (z) {
            wg(new java.lang.RuntimeException(str));
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "msg", str);
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "stack", vw(new java.lang.Throwable()));
        com.ss.android.downloadlib.addownload.z.o();
    }

    public void vw(boolean z, java.lang.Throwable th, java.lang.String str) {
        if (wg()) {
            return;
        }
        if (th == null) {
            th = new java.lang.Throwable();
        }
        if (z) {
            wg(th);
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (android.text.TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "msg", str);
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "stack", android.util.Log.getStackTraceString(th));
        com.ss.android.downloadlib.addownload.z.o();
    }

    public void wg(java.lang.String str) {
        wg(true, str);
    }

    public void wg(boolean z, java.lang.String str) {
        if (wg()) {
            return;
        }
        if (z) {
            wg(new java.lang.RuntimeException(str));
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "msg", str);
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "stack", vw(new java.lang.Throwable()));
        com.ss.android.downloadlib.addownload.z.o();
    }
}
