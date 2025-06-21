package com.ss.android.downloadlib.addownload;

/* loaded from: classes19.dex */
public class v {
    private java.util.concurrent.atomic.AtomicBoolean t = new java.util.concurrent.atomic.AtomicBoolean(false);
    private java.util.concurrent.atomic.AtomicBoolean v = new java.util.concurrent.atomic.AtomicBoolean(false);
    private android.os.Handler vw;
    private com.ss.android.downloadlib.addownload.wg.yl wg;

    /* renamed from: com.ss.android.downloadlib.addownload.v$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.downloadlib.addownload.yl.wg {
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg t;
        final /* synthetic */ long v;
        final /* synthetic */ int vw;
        final /* synthetic */ java.lang.String wg;
        final /* synthetic */ com.ss.android.downloadlib.addownload.yl.vw yl;

        public AnonymousClass1(int i, java.lang.String str, com.ss.android.downloadad.api.vw.wg wgVar, long j, com.ss.android.downloadlib.addownload.yl.vw vwVar) {
            this.vw = i;
            this.wg = str;
            this.t = wgVar;
            this.v = j;
            this.yl = vwVar;
        }

        @Override // com.ss.android.downloadlib.addownload.yl.wg
        public void vw(long j) {
            com.ss.android.downloadlib.addownload.v.this.vw(this.vw, this.wg, j, this.t, this.v, this.yl);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.v$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.downloadlib.addownload.yl.vw vw;

        public AnonymousClass2(com.ss.android.downloadlib.addownload.yl.vw vwVar) {
            this.vw = vwVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.downloadlib.addownload.v.this.t.get()) {
                return;
            }
            com.ss.android.downloadlib.addownload.v.this.t.set(true);
            this.vw.vw();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.v$3, reason: invalid class name */
    public class AnonymousClass3 implements com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener {
        final /* synthetic */ com.ss.android.downloadlib.addownload.yl.wg vw;

        public AnonymousClass3(com.ss.android.downloadlib.addownload.yl.wg wgVar) {
            this.vw = wgVar;
        }

        @Override // com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener
        public void onFetchFinished(java.util.Map<java.lang.String, java.lang.String> map) {
            if (com.ss.android.downloadlib.addownload.v.this.t.get()) {
                return;
            }
            com.ss.android.downloadlib.addownload.v.this.t.set(true);
            long vw = com.ss.android.downloadlib.addownload.v.this.vw(map);
            if (vw > 0) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.putOpt("apk_size", java.lang.Long.valueOf(vw));
                    jSONObject.putOpt("available_space", java.lang.Long.valueOf(com.ss.android.downloadlib.addownload.v.v()));
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
            this.vw.vw(vw);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.v$4, reason: invalid class name */
    public class AnonymousClass4 implements com.ss.android.downloadlib.addownload.t.yl {
        final /* synthetic */ java.lang.String t;
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg vw;
        final /* synthetic */ com.ss.android.downloadlib.addownload.yl.vw wg;

        public AnonymousClass4(com.ss.android.downloadad.api.vw.wg wgVar, com.ss.android.downloadlib.addownload.yl.vw vwVar, java.lang.String str) {
            this.vw = wgVar;
            this.wg = vwVar;
            this.t = str;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.v$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.downloadlib.addownload.yl.vw vw;

        public AnonymousClass5(com.ss.android.downloadlib.addownload.yl.vw vwVar) {
            this.vw = vwVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.vw.vw();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.v$6, reason: invalid class name */
    public static class AnonymousClass6 implements com.ss.android.downloadlib.addownload.t.yl {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo vw;

        public AnonymousClass6(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            this.vw = downloadInfo;
        }
    }

    public v(android.os.Handler handler) {
        this.vw = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long v() {
        return com.ss.android.downloadlib.bt.vl.wg(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long vw(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                    java.lang.String key = entry.getKey();
                    java.lang.String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return java.lang.Long.parseLong(value);
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static org.json.JSONObject vw(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static void vw(int i) {
        if (com.ss.android.downloadlib.bt.yl.kz(i) && com.ss.android.downloadlib.addownload.z.u() != null && com.ss.android.downloadlib.addownload.z.u().wg()) {
            com.ss.android.downloadlib.addownload.z.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(int i, java.lang.String str, long j, com.ss.android.downloadad.api.vw.wg wgVar, long j2, com.ss.android.downloadlib.addownload.yl.vw vwVar) {
        this.t.set(true);
        boolean z = false;
        if (j > 0) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.putOpt("apk_size", java.lang.Long.valueOf(j));
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            long longValue = (java.lang.Double.valueOf((com.ss.android.downloadlib.bt.yl.vw(i) + 1.0d) * j).longValue() + com.ss.android.downloadlib.bt.yl.wg(i)) - j2;
            long v = v();
            if (v < longValue) {
                vw(wgVar, jSONObject, longValue, v);
                vw(wgVar);
                long v2 = v();
                if (v2 < longValue) {
                    wgVar.v(true);
                    java.lang.String vw = wgVar.vw();
                    com.ss.android.downloadlib.addownload.t.v.vw().vw(vw, new com.ss.android.downloadlib.addownload.v.AnonymousClass4(wgVar, vwVar, vw));
                    z = vw(i, wgVar, str, longValue);
                    if (z) {
                        wgVar.yl(true);
                    }
                } else {
                    wg(wgVar, jSONObject, v, v2);
                }
            }
        }
        if (z) {
            return;
        }
        this.vw.post(new com.ss.android.downloadlib.addownload.v.AnonymousClass5(vwVar));
    }

    private static void vw(com.ss.android.downloadad.api.vw.wg wgVar) {
        long v = v();
        if (com.ss.android.downloadlib.addownload.z.u() != null) {
            com.ss.android.downloadlib.addownload.z.u();
        }
        com.ss.android.downloadlib.addownload.t.t.vw();
        com.ss.android.downloadlib.addownload.t.t.wg();
        if (com.ss.android.downloadlib.bt.yl.bt(wgVar.tq())) {
            com.ss.android.downloadlib.addownload.t.t.vw(com.ss.android.downloadlib.addownload.z.getContext());
        }
        long v2 = v();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", java.lang.Long.valueOf(v2 - v));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().vw("clean_quite_finish", jSONObject, wgVar);
    }

    private void vw(com.ss.android.downloadad.api.vw.wg wgVar, org.json.JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", java.lang.Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", java.lang.Long.valueOf(j));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().vw("clean_space_no_enough_for_download", jSONObject, wgVar);
    }

    private void vw(java.lang.String str, com.ss.android.downloadad.api.vw.wg wgVar, com.ss.android.downloadlib.addownload.yl.wg wgVar2) {
        if (wgVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.asyncFetchHttpHeadInfo(str, new com.ss.android.downloadlib.addownload.v.AnonymousClass3(wgVar2));
    }

    private boolean vw(int i, @androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar, java.lang.String str, long j) {
        if (!com.ss.android.downloadlib.bt.yl.kz(i)) {
            return false;
        }
        if (com.ss.android.downloadlib.addownload.z.u() != null) {
            return com.ss.android.downloadlib.addownload.z.u().vw(i, str, true, j);
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().vw("cleanspace_window_show", jSONObject, wgVar);
        return false;
    }

    public static boolean vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, long j) {
        int id = downloadInfo.getId();
        boolean z = false;
        if (!com.ss.android.downloadlib.bt.yl.kz(id)) {
            return false;
        }
        if (com.ss.android.downloadlib.addownload.z.u() != null && (z = com.ss.android.downloadlib.addownload.z.u().vw(id, downloadInfo.getUrl(), false, j))) {
            com.ss.android.downloadlib.addownload.t.v.vw().vw(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.v.AnonymousClass6(downloadInfo));
        }
        return z;
    }

    public static long wg() {
        if (com.ss.android.downloadlib.addownload.z.u() != null) {
            return com.ss.android.downloadlib.addownload.z.u().vw();
        }
        return 0L;
    }

    private void wg(com.ss.android.downloadad.api.vw.wg wgVar, org.json.JSONObject jSONObject, long j, long j2) {
        wgVar.vl("1");
        com.ss.android.downloadlib.addownload.wg.x.vw().vw(wgVar);
        try {
            jSONObject.putOpt("quite_clean_size", java.lang.Long.valueOf(j2 - j));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().vw("cleanspace_download_after_quite_clean", jSONObject, wgVar);
    }

    public void vw(int i, long j, long j2, com.ss.android.downloadlib.addownload.yl.vw vwVar) {
        this.v.set(false);
        if (vwVar == null) {
            return;
        }
        if (!com.ss.android.downloadlib.bt.yl.kz(i) || !com.ss.android.downloadlib.bt.yl.yl(i)) {
            vwVar.vw();
            return;
        }
        long t = com.ss.android.downloadlib.bt.yl.t(i);
        this.t.set(false);
        java.lang.String downloadUrl = this.wg.wg.getDownloadUrl();
        com.ss.android.downloadad.api.vw.wg wg = com.ss.android.downloadlib.addownload.wg.kz.vw().wg(downloadUrl);
        if (wg == null) {
            com.ss.android.downloadlib.addownload.wg.yl ylVar = this.wg;
            wg = new com.ss.android.downloadad.api.vw.wg(ylVar.wg, ylVar.t, ylVar.v, 0);
            com.ss.android.downloadlib.addownload.wg.kz.vw().vw(wg);
        }
        com.ss.android.downloadad.api.vw.wg wgVar = wg;
        wgVar.yl(false);
        if (com.ss.android.downloadlib.addownload.z.u() != null) {
            com.ss.android.downloadlib.addownload.z.u();
            wgVar.wg();
        }
        com.ss.android.downloadlib.addownload.t.v.vw().vw(wgVar.vw());
        boolean v = com.ss.android.downloadlib.bt.yl.v(i);
        if (j2 > 0) {
            vw(i, downloadUrl, j2, wgVar, j, vwVar);
        } else if (v) {
            vw(downloadUrl, wgVar, new com.ss.android.downloadlib.addownload.v.AnonymousClass1(i, downloadUrl, wgVar, j, vwVar));
        } else {
            t = 0;
        }
        this.vw.postDelayed(new com.ss.android.downloadlib.addownload.v.AnonymousClass2(vwVar), t);
    }

    public void vw(com.ss.android.downloadlib.addownload.wg.yl ylVar) {
        this.wg = ylVar;
    }

    public void vw(boolean z) {
        this.v.set(z);
    }

    public boolean vw() {
        return this.v.get();
    }
}
