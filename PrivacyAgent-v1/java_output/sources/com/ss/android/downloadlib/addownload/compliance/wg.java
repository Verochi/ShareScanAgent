package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: classes19.dex */
public class wg {
    private java.lang.ref.SoftReference<android.app.Activity> vw;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.wg$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.downloadlib.bt.t.vw<java.lang.Boolean, java.lang.Object> {
        final /* synthetic */ long vw;
        final /* synthetic */ long wg;

        public AnonymousClass1(long j, long j2) {
            this.vw = j;
            this.wg = j2;
        }

        @Override // com.ss.android.downloadlib.bt.t.vw
        public java.lang.Object vw(java.lang.Boolean bool) {
            if (!bool.booleanValue()) {
                com.ss.android.downloadlib.addownload.compliance.wg.this.wg(this.wg);
                return null;
            }
            com.ss.android.downloadlib.addownload.compliance.wg.this.vw(com.ss.android.downloadlib.addownload.wg.wg.vw(this.vw, this.wg));
            com.ss.android.downloadlib.addownload.compliance.bt.wg("lp_app_dialog_try_show", this.wg);
            return null;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.wg$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.downloadlib.bt.t.vw<java.lang.String, java.lang.Boolean> {
        final /* synthetic */ long vw;
        final /* synthetic */ long wg;

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.wg$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.ss.android.download.api.config.te {
            final /* synthetic */ boolean[] vw;

            public AnonymousClass1(boolean[] zArr) {
                this.vw = zArr;
            }

            @Override // com.ss.android.download.api.config.te
            public void vw(java.lang.String str) {
                boolean[] zArr = this.vw;
                com.ss.android.downloadlib.addownload.compliance.wg.AnonymousClass2 anonymousClass2 = com.ss.android.downloadlib.addownload.compliance.wg.AnonymousClass2.this;
                zArr[0] = com.ss.android.downloadlib.addownload.compliance.wg.this.vw(anonymousClass2.vw, anonymousClass2.wg, str);
            }

            @Override // com.ss.android.download.api.config.te
            public void vw(java.lang.Throwable th) {
                com.ss.android.downloadlib.addownload.compliance.bt.vw(2, com.ss.android.downloadlib.addownload.compliance.wg.AnonymousClass2.this.wg);
                this.vw[0] = false;
            }
        }

        public AnonymousClass2(long j, long j2) {
            this.vw = j;
            this.wg = j2;
        }

        @Override // com.ss.android.downloadlib.bt.t.vw
        public java.lang.Boolean vw(java.lang.String str) {
            boolean[] zArr = {false};
            com.ss.android.downloadlib.addownload.z.v().vw("GET", str, new java.util.HashMap(), new com.ss.android.downloadlib.addownload.compliance.wg.AnonymousClass2.AnonymousClass1(zArr));
            return java.lang.Boolean.valueOf(zArr[0]);
        }
    }

    public static class vw {
        private static com.ss.android.downloadlib.addownload.compliance.wg vw = new com.ss.android.downloadlib.addownload.compliance.wg(null);
    }

    private wg() {
    }

    public /* synthetic */ wg(com.ss.android.downloadlib.addownload.compliance.wg.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.ss.android.downloadlib.addownload.compliance.wg vw() {
        return com.ss.android.downloadlib.addownload.compliance.wg.vw.vw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vw(long j, long j2, java.lang.String str) {
        try {
            org.json.JSONObject optJSONObject = new org.json.JSONObject(str).optJSONObject("package");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.wg.wg wgVar = new com.ss.android.downloadlib.addownload.wg.wg();
                wgVar.vw = j;
                wgVar.wg = j2;
                wgVar.v = optJSONObject.optString("icon_url");
                wgVar.yl = optJSONObject.optString("app_name");
                wgVar.t = optJSONObject.optString("package_name");
                wgVar.kz = optJSONObject.optString(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                wgVar.bt = optJSONObject.optString("developer_name");
                wgVar.x = optJSONObject.optString("policy_url");
                org.json.JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        org.json.JSONObject jSONObject = (org.json.JSONObject) optJSONArray.get(i);
                        wgVar.o.add(new android.util.Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                com.ss.android.downloadlib.addownload.compliance.t.vw().vw(wgVar);
                com.ss.android.downloadlib.addownload.compliance.v.vw().vw(wgVar.vw(), j2, wgVar.v);
                return true;
            }
            com.ss.android.downloadlib.addownload.compliance.bt.vw(7, j2);
            return false;
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.yl.t.vw().vw(e, "AdLpComplianceManager parseResponse");
            com.ss.android.downloadlib.addownload.compliance.bt.vw(7, j2);
            return false;
        }
    }

    public void vw(long j) {
        com.ss.android.downloadlib.activity.TTDelegateActivity.vw(j);
    }

    public void vw(android.app.Activity activity) {
        this.vw = new java.lang.ref.SoftReference<>(activity);
    }

    public boolean vw(com.ss.android.download.api.download.DownloadModel downloadModel) {
        if (!downloadModel.isAd() || com.ss.android.downloadlib.addownload.z.x().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        java.lang.String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (android.text.TextUtils.isEmpty(webUrl) || java.util.regex.Pattern.compile(com.ss.android.downloadlib.addownload.z.x().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public boolean vw(@androidx.annotation.NonNull com.ss.android.downloadlib.addownload.wg.yl ylVar) {
        long j;
        long j2;
        if (android.text.TextUtils.isEmpty(ylVar.wg.getLogExtra())) {
            com.ss.android.downloadlib.addownload.compliance.bt.vw(9, ylVar);
            com.ss.android.downloadlib.yl.t.vw().vw("requestAppInfo getLogExtra null");
            j2 = 0;
        } else {
            try {
                j = com.ss.android.downloadlib.bt.vl.vw(new org.json.JSONObject(ylVar.wg.getLogExtra()), "convert_id");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                j = 0;
            }
            if (j <= 0) {
                com.ss.android.downloadlib.addownload.compliance.bt.vw(3, ylVar);
            }
            j2 = j;
        }
        long j3 = ylVar.vw;
        com.ss.android.downloadlib.addownload.wg.wg vw2 = com.ss.android.downloadlib.addownload.compliance.t.vw().vw(j2, j3);
        if (vw2 != null) {
            com.ss.android.downloadlib.addownload.compliance.v.vw().vw(vw2.vw(), j3, vw2.v);
            vw(vw2.vw());
            com.ss.android.downloadlib.addownload.compliance.bt.vw("lp_app_dialog_try_show", ylVar);
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (j2 > 0) {
            sb.append("convert_id=");
            sb.append(j2);
        }
        if (!android.text.TextUtils.isEmpty(ylVar.wg.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=");
            sb.append(ylVar.wg.getPackageName());
        }
        if (sb.length() <= 0) {
            com.ss.android.downloadlib.addownload.compliance.bt.vw(6, ylVar);
            return false;
        }
        long j4 = j2;
        com.ss.android.downloadlib.bt.t.vw(new com.ss.android.downloadlib.addownload.compliance.wg.AnonymousClass2(j4, j3), "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).vw(new com.ss.android.downloadlib.addownload.compliance.wg.AnonymousClass1(j4, j3)).vw();
        return true;
    }

    public android.app.Activity wg() {
        android.app.Activity activity = this.vw.get();
        this.vw = null;
        return activity;
    }

    public void wg(long j) {
        com.ss.android.downloadlib.addownload.yl vw2 = com.ss.android.downloadlib.bt.vw().vw(com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j).wg.getDownloadUrl());
        if (vw2 != null) {
            vw2.vw(true, true);
        } else {
            com.ss.android.downloadlib.addownload.compliance.bt.vw(11, j);
            com.ss.android.downloadlib.yl.t.vw().wg("startDownload handler null");
        }
    }
}
