package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: classes19.dex */
public class kz {
    private final java.util.concurrent.atomic.AtomicInteger vw;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.kz$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.downloadlib.addownload.wg.yl vw;
        final /* synthetic */ com.ss.android.downloadlib.addownload.compliance.o wg;

        public AnonymousClass1(com.ss.android.downloadlib.addownload.wg.yl ylVar, com.ss.android.downloadlib.addownload.compliance.o oVar) {
            this.vw = ylVar;
            this.wg = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.addownload.compliance.kz kzVar = com.ss.android.downloadlib.addownload.compliance.kz.this;
            kzVar.wg(this.vw, kzVar.wg(), com.ss.android.downloadlib.addownload.compliance.kz.this.vw(this.vw, true, 4), this.wg);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.kz$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.download.api.config.te {
        final /* synthetic */ java.lang.String t;
        final /* synthetic */ byte[] v;
        final /* synthetic */ com.ss.android.downloadlib.addownload.wg.yl vw;
        final /* synthetic */ com.ss.android.downloadlib.addownload.compliance.o wg;

        public AnonymousClass2(com.ss.android.downloadlib.addownload.wg.yl ylVar, com.ss.android.downloadlib.addownload.compliance.o oVar, java.lang.String str, byte[] bArr) {
            this.vw = ylVar;
            this.wg = oVar;
            this.t = str;
            this.v = bArr;
        }

        @Override // com.ss.android.download.api.config.te
        public void vw(java.lang.String str) {
            com.ss.android.downloadlib.addownload.compliance.kz.this.vw(this.vw, str, this.wg);
        }

        @Override // com.ss.android.download.api.config.te
        public void vw(java.lang.Throwable th) {
            com.ss.android.downloadlib.addownload.compliance.kz.this.vw(this.vw, this.t, this.v, this.wg);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.kz$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String vw;

        public AnonymousClass3(java.lang.String str) {
            this.vw = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.addownload.z.t().vw(6, com.ss.android.downloadlib.addownload.z.getContext(), null, this.vw, null, 0);
        }
    }

    public static class vw {
        private static com.ss.android.downloadlib.addownload.compliance.kz vw = new com.ss.android.downloadlib.addownload.compliance.kz(null);
    }

    private kz() {
        this.vw = new java.util.concurrent.atomic.AtomicInteger(0);
    }

    public /* synthetic */ kz(com.ss.android.downloadlib.addownload.compliance.kz.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.ss.android.downloadlib.addownload.compliance.kz vw() {
        return com.ss.android.downloadlib.addownload.compliance.kz.vw.vw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(@androidx.annotation.NonNull com.ss.android.downloadlib.addownload.wg.yl ylVar, java.lang.String str, com.ss.android.downloadlib.addownload.compliance.o oVar) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.yl.t.vw().vw("response content is null");
                vw(404, ylVar);
                oVar.vw();
                return;
            }
            this.vw.set(0);
            com.ss.android.downloadlib.addownload.compliance.yl bt = com.ss.android.downloadlib.addownload.compliance.yl.bt(str);
            if (bt.vw() != 0) {
                vw(403, ylVar);
                oVar.vw();
            } else if (!android.text.TextUtils.isEmpty(bt.wg())) {
                oVar.vw(bt.wg());
            } else {
                vw(405, ylVar);
                oVar.vw();
            }
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.yl.t.vw().vw(e, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(com.ss.android.downloadlib.addownload.wg.yl ylVar, java.lang.String str, byte[] bArr, com.ss.android.downloadlib.addownload.compliance.o oVar) {
        if (this.vw.get() < 6) {
            this.vw.incrementAndGet();
            wg(ylVar, str, bArr, oVar);
        } else {
            vw("当前网络不佳，请稍后再试");
            this.vw.set(0);
            vw(402, ylVar);
        }
    }

    private void vw(java.lang.String str) {
        com.ss.android.downloadlib.bt.vw().wg().post(new com.ss.android.downloadlib.addownload.compliance.kz.AnonymousClass3(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] vw(com.ss.android.downloadlib.addownload.wg.yl ylVar, boolean z, int i) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("download_url", ylVar.vw());
            jSONObject.put("package_name", ylVar.yl());
            jSONObject.put("call_scene", 50);
            if (z) {
                jSONObject.put("sender_package_name", com.ss.android.downloadlib.addownload.z.getContext().getPackageName());
                jSONObject.put("sender_version", com.ss.android.downloadlib.addownload.z.es().yl);
                if (i > 0) {
                    jSONObject.put("store", i);
                }
            } else {
                jSONObject.put("id", java.lang.String.valueOf(ylVar.wg()));
                if (ylVar.qm().getDeepLink() != null) {
                    if (android.text.TextUtils.isEmpty(ylVar.qm().getDeepLink().getWebUrl())) {
                        com.ss.android.downloadlib.yl.t.vw().vw("web_url is null");
                    }
                    jSONObject.put("web_url", ylVar.qm().getDeepLink().getWebUrl());
                } else {
                    com.ss.android.downloadlib.yl.t.vw().vw("deeplink is null");
                }
            }
        } catch (java.lang.Exception unused) {
            com.ss.android.downloadlib.yl.t.vw().vw("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String wg() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.vw.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com");
        sb.append("/customer/api/app/deep_link");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(@androidx.annotation.NonNull com.ss.android.downloadlib.addownload.wg.yl ylVar, java.lang.String str, byte[] bArr, com.ss.android.downloadlib.addownload.compliance.o oVar) {
        com.ss.android.downloadlib.addownload.z.v().vw(str, bArr, "application/json; charset=utf-8", 0, new com.ss.android.downloadlib.addownload.compliance.kz.AnonymousClass2(ylVar, oVar, str, bArr));
    }

    public void vw(int i, com.ss.android.downloadlib.addownload.wg.yl ylVar) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().vw("get_miui_market_compliance_error", jSONObject, ylVar);
    }

    public void vw(int i, com.ss.android.downloadlib.addownload.wg.yl ylVar, org.json.JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().vw("get_miui_market_compliance_success", jSONObject, ylVar);
    }

    public void vw(com.ss.android.downloadlib.addownload.wg.yl ylVar, com.ss.android.downloadlib.addownload.compliance.o oVar) {
        if (com.ss.android.downloadlib.addownload.z.v() != null) {
            com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.addownload.compliance.kz.AnonymousClass1(ylVar, oVar));
        } else {
            com.ss.android.downloadlib.yl.t.vw().vw("getDownloadNetworkFactory == NULL");
            vw(401, ylVar);
        }
    }
}
