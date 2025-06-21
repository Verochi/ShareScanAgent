package com.ss.android.downloadlib.addownload.vw;

/* loaded from: classes19.dex */
class wg {
    @androidx.annotation.NonNull
    public java.util.concurrent.CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.wg.vw> vw(java.lang.String str, java.lang.String str2) {
        java.util.concurrent.CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.wg.vw> copyOnWriteArrayList = new java.util.concurrent.CopyOnWriteArrayList<>();
        try {
            java.lang.String string = com.ss.android.downloadlib.addownload.z.getContext().getSharedPreferences(str, 0).getString(str2, "");
            if (!android.text.TextUtils.isEmpty(string)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(string);
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    com.ss.android.downloadlib.addownload.wg.vw vw = com.ss.android.downloadlib.addownload.wg.vw.vw(jSONObject.optJSONObject(keys.next()));
                    if (vw != null) {
                        copyOnWriteArrayList.add(vw);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    public void vw(java.lang.String str, java.lang.String str2, java.util.concurrent.CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.wg.vw> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.util.Iterator<com.ss.android.downloadlib.addownload.wg.vw> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.ss.android.downloadlib.addownload.wg.vw next = it.next();
                if (next != null) {
                    jSONObject.put(java.lang.String.valueOf(next.wg), next.vw());
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.addownload.z.getContext().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }

    public void wg(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        com.ss.android.downloadlib.addownload.z.getContext().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }
}
