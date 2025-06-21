package com.ss.android.downloadlib.v;

/* loaded from: classes19.dex */
public class t {
    private static volatile com.ss.android.downloadlib.v.t wg;
    private android.database.sqlite.SQLiteDatabase vw;

    private t() {
        try {
            this.vw = new com.ss.android.downloadlib.v.wg(com.ss.android.downloadlib.addownload.z.getContext()).getWritableDatabase();
        } catch (java.lang.Throwable th) {
            com.ss.android.downloadlib.yl.t.vw().vw(th, "ClickEventHelper");
        }
    }

    private void t(long j, java.lang.String str) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.vw;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            java.lang.String optString = new org.json.JSONObject(str).optString(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId);
            if (android.text.TextUtils.isEmpty(optString)) {
                return;
            }
            this.vw.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new java.lang.String[]{java.lang.String.valueOf(java.lang.System.currentTimeMillis() - 1209600000), java.lang.String.valueOf(j), optString});
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static com.ss.android.downloadlib.v.t vw() {
        if (wg == null) {
            synchronized (com.ss.android.downloadlib.v.t.class) {
                if (wg == null) {
                    wg = new com.ss.android.downloadlib.v.t();
                }
            }
        }
        return wg;
    }

    public boolean t() {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt("click_event_switch", 0) == 2;
    }

    public void vw(long j, java.lang.String str) {
        java.lang.String optString;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.vw;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            optString = new org.json.JSONObject(str).optString(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (android.text.TextUtils.isEmpty(optString)) {
            return;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.bytedance.sdk.openadsdk.mediation.MediationConstant.EXTRA_ADID, java.lang.Long.valueOf(j));
        contentValues.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId, optString);
        contentValues.put("time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        this.vw.insert("click_event", null, contentValues);
        t(j, str);
    }

    public boolean wg() {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt("click_event_switch", 0) == 1;
    }

    public boolean wg(long j, java.lang.String str) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.vw;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        android.database.Cursor cursor = null;
        try {
            try {
                java.lang.String optString = new org.json.JSONObject(str).optString(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId);
                if (android.text.TextUtils.isEmpty(optString)) {
                    return false;
                }
                cursor = this.vw.query("click_event", com.ss.android.downloadlib.v.wg.vw, "time > ? AND ad_id = ? AND req_id = ?", new java.lang.String[]{java.lang.String.valueOf(java.lang.System.currentTimeMillis() - 1209600000), java.lang.String.valueOf(j), optString}, null, null, null, null);
                boolean z = cursor.getCount() > 0;
                cursor.close();
                return z;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (java.lang.Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
