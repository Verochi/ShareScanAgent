package com.ss.android.downloadlib.activity;

/* loaded from: classes19.dex */
public class TTDelegateActivity extends android.app.Activity implements androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback {
    private static com.ss.android.downloadlib.guide.install.vw v;
    private com.ss.android.downloadad.api.vw.wg t;
    protected android.content.Intent vw = null;
    private boolean wg;

    /* renamed from: com.ss.android.downloadlib.activity.TTDelegateActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.download.api.config.q {
        private java.lang.ref.WeakReference<android.app.Activity> t;
        final /* synthetic */ java.lang.String vw;

        public AnonymousClass1(java.lang.String str) {
            this.vw = str;
            this.t = new java.lang.ref.WeakReference<>(com.ss.android.downloadlib.activity.TTDelegateActivity.this);
        }

        @Override // com.ss.android.download.api.config.q
        public void vw() {
            com.ss.android.downloadlib.bt.es.vw(this.vw);
            com.ss.android.socialbase.appdownloader.t.vw(this.t.get());
        }

        @Override // com.ss.android.download.api.config.q
        public void vw(java.lang.String str) {
            com.ss.android.downloadlib.bt.es.vw(this.vw, str);
            com.ss.android.socialbase.appdownloader.t.vw(this.t.get());
        }
    }

    /* renamed from: com.ss.android.downloadlib.activity.TTDelegateActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.download.api.model.wg.InterfaceC0468wg {
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg vw;

        public AnonymousClass2(com.ss.android.downloadad.api.vw.wg wgVar) {
            this.vw = wgVar;
        }

        @Override // com.ss.android.download.api.model.wg.InterfaceC0468wg
        public void t(android.content.DialogInterface dialogInterface) {
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) com.ss.android.downloadlib.activity.TTDelegateActivity.this);
        }

        @Override // com.ss.android.download.api.model.wg.InterfaceC0468wg
        public void vw(android.content.DialogInterface dialogInterface) {
            com.ss.android.downloadlib.wg.vw.wg(this.vw);
            com.ss.android.downloadlib.activity.TTDelegateActivity tTDelegateActivity = com.ss.android.downloadlib.activity.TTDelegateActivity.this;
            if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                dialogInterface.dismiss();
            }
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) com.ss.android.downloadlib.activity.TTDelegateActivity.this);
        }

        @Override // com.ss.android.download.api.model.wg.InterfaceC0468wg
        public void wg(android.content.DialogInterface dialogInterface) {
            com.ss.android.downloadlib.v.vw.vw().wg("market_openapp_cancel", this.vw);
            com.ss.android.downloadlib.activity.TTDelegateActivity tTDelegateActivity = com.ss.android.downloadlib.activity.TTDelegateActivity.this;
            if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                dialogInterface.dismiss();
            }
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) com.ss.android.downloadlib.activity.TTDelegateActivity.this);
        }
    }

    private static android.content.Intent t(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar) {
        return new android.content.Intent(com.ss.android.downloadlib.addownload.z.getContext(), (java.lang.Class<?>) com.ss.android.downloadlib.activity.TTDelegateActivity.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void t() {
        java.lang.String str;
        int i;
        int i2;
        int i3;
        java.lang.CharSequence charSequence;
        long longExtra = this.vw.getLongExtra("model_id", 0L);
        java.lang.String stringExtra = this.vw.getStringExtra("message_text");
        java.lang.String stringExtra2 = this.vw.getStringExtra("positive_button_text");
        java.lang.String stringExtra3 = this.vw.getStringExtra("negative_button_text");
        java.lang.String stringExtra4 = this.vw.getStringExtra("delete_button_text");
        int intExtra = this.vw.getIntExtra("type", 0);
        com.ss.android.downloadad.api.vw.wg v2 = com.ss.android.downloadlib.addownload.wg.kz.vw().v(longExtra);
        if (v2 != null) {
            com.ss.android.socialbase.downloader.model.DownloadInfo vw = !android.text.TextUtils.isEmpty(v2.ux()) ? com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext()).vw(v2.ux(), null, true) : com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext()).wg(v2.vw());
            if (vw != null) {
                long curBytes = vw.getCurBytes();
                long totalBytes = vw.getTotalBytes();
                if (curBytes > 0 && totalBytes > 0) {
                    str = stringExtra3;
                    i3 = (int) (curBytes / 1048576);
                    i2 = (int) (totalBytes / 1048576);
                    i = com.ss.android.downloadlib.addownload.es.vw(vw.getId(), (int) ((curBytes * 100) / totalBytes));
                    com.ss.android.downloadlib.addownload.vw.yl.vw t = new com.ss.android.downloadlib.addownload.vw.yl.vw(this).vw(false).vw(stringExtra).wg(stringExtra2).t(str);
                    if (intExtra != 7) {
                        if (com.ss.android.downloadlib.addownload.v.kz.vw() == null) {
                            return;
                        }
                        t.vw(com.ss.android.downloadlib.addownload.v.kz.vw());
                        t.vw().show();
                        charSequence = "download_percent";
                    } else if (intExtra == 8) {
                        if (com.ss.android.downloadlib.addownload.v.vw.vw() == null) {
                            return;
                        }
                        t.vw(com.ss.android.downloadlib.addownload.v.vw.vw());
                        t.vw().show();
                        charSequence = "apk_size";
                    } else if (intExtra == 20) {
                        if (com.ss.android.downloadlib.addownload.v.t.vw() == null || com.ss.android.downloadlib.addownload.v.t.wg() == null) {
                            return;
                        }
                        t.vw(com.ss.android.downloadlib.addownload.v.t.vw()).v(stringExtra4).vw(com.ss.android.downloadlib.addownload.v.t.wg());
                        t.vw().show();
                        charSequence = "download_percent_cancel";
                    } else if (intExtra != 21) {
                        charSequence = "";
                    } else {
                        if (com.ss.android.downloadlib.addownload.v.wg.vw() == null || com.ss.android.downloadlib.addownload.v.wg.wg() == null) {
                            return;
                        }
                        t.vw(com.ss.android.downloadlib.addownload.v.wg.vw()).v(stringExtra4).vw(com.ss.android.downloadlib.addownload.v.wg.wg());
                        t.vw().show();
                        charSequence = "apk_size_cancel";
                    }
                    if (android.text.TextUtils.isEmpty(charSequence)) {
                        this.wg = true;
                        this.t = v2;
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", charSequence);
                            jSONObject.putOpt("pause_optimise_action", "show_dialog");
                            jSONObject.putOpt("download_percent", java.lang.Integer.valueOf(i));
                            jSONObject.putOpt("download_current_bytes", java.lang.Integer.valueOf(i3));
                            jSONObject.putOpt("download_total_bytes", java.lang.Integer.valueOf(i2));
                        } catch (org.json.JSONException e) {
                            e.printStackTrace();
                        }
                        if (android.text.TextUtils.equals(charSequence, "download_percent") || android.text.TextUtils.equals(charSequence, "apk_size")) {
                            com.ss.android.downloadlib.v.vw.vw().vw("pause_optimise", jSONObject, v2);
                            return;
                        } else {
                            if (android.text.TextUtils.equals(charSequence, "download_percent_cancel") || android.text.TextUtils.equals(charSequence, "apk_size_cancel")) {
                                com.ss.android.downloadlib.v.vw.vw().vw("pause_cancel_optimise", jSONObject, v2);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
            }
        }
        str = stringExtra3;
        i = -1;
        i2 = 0;
        i3 = 0;
        com.ss.android.downloadlib.addownload.vw.yl.vw t2 = new com.ss.android.downloadlib.addownload.vw.yl.vw(this).vw(false).vw(stringExtra).wg(stringExtra2).t(str);
        if (intExtra != 7) {
        }
        if (android.text.TextUtils.isEmpty(charSequence)) {
        }
    }

    private void t(long j) {
        new com.ss.android.downloadlib.addownload.compliance.vw(this, j).show();
    }

    public static void vw(long j) {
        android.content.Intent intent = new android.content.Intent(com.ss.android.downloadlib.addownload.z.getContext(), (java.lang.Class<?>) com.ss.android.downloadlib.activity.TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (com.ss.android.downloadlib.addownload.z.getContext() != null) {
            com.ss.android.downloadlib.addownload.z.getContext().startActivity(intent);
        }
    }

    private void vw(long j, java.lang.String str) {
        if (com.ss.android.downloadlib.addownload.u.vw() == null) {
            return;
        }
        com.ss.android.downloadad.api.vw.wg v2 = com.ss.android.downloadlib.addownload.wg.kz.vw().v(j);
        if (v2 != null) {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(v2.tq());
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.putOpt("time_after_click", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - v2.kn()));
                jSONObject.putOpt("click_download_size", java.lang.Long.valueOf(v2.ml()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", java.lang.Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", java.lang.Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", java.lang.Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", java.lang.Integer.valueOf((int) (downloadInfo.getCurBytes() / 1048576)));
                    jSONObject.putOpt("download_total_bytes", java.lang.Integer.valueOf((int) (downloadInfo.getTotalBytes() / 1048576)));
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            if (android.text.TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.v.vw.vw().wg("pause_reserve_wifi_dialog_show", jSONObject, v2);
            } else {
                com.ss.android.downloadlib.v.vw.vw().vw("cancel_pause_reserve_wifi_dialog_show", jSONObject, v2);
            }
        }
        com.ss.android.downloadlib.addownload.vw.yl.vw vw = new com.ss.android.downloadlib.addownload.vw.yl.vw(this).vw(false).vw(com.ss.android.downloadlib.addownload.u.vw());
        if (!android.text.TextUtils.isEmpty(str)) {
            vw.v(str).vw(com.ss.android.downloadlib.addownload.u.wg());
        }
        vw.vw().show();
        this.wg = true;
        this.t = v2;
    }

    public static void vw(com.ss.android.downloadad.api.vw.vw vwVar) {
        android.content.Intent t = t(vwVar);
        t.addFlags(268435456);
        t.putExtra("type", 4);
        t.putExtra("model_id", vwVar.wg());
        if (com.ss.android.downloadlib.addownload.z.getContext() != null) {
            com.ss.android.downloadlib.addownload.z.getContext().startActivity(t);
        }
    }

    private static void vw(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar, int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        android.content.Intent t = t(vwVar);
        t.addFlags(268435456);
        t.putExtra("type", i);
        if (!android.text.TextUtils.isEmpty(str2)) {
            t.putExtra("positive_button_text", str2);
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            t.putExtra("negative_button_text", str3);
        }
        if (!android.text.TextUtils.isEmpty(str4)) {
            t.putExtra("delete_button_text", str4);
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            t.putExtra("message_text", str);
        }
        t.putExtra("model_id", vwVar.wg());
        if (com.ss.android.downloadlib.addownload.z.getContext() != null) {
            com.ss.android.downloadlib.addownload.z.getContext().startActivity(t);
        }
    }

    public static void vw(com.ss.android.downloadad.api.vw.vw vwVar, com.ss.android.downloadlib.guide.install.vw vwVar2) {
        android.content.Intent t = t(vwVar);
        t.addFlags(268435456);
        t.putExtra("type", 9);
        v = vwVar2;
        if (com.ss.android.downloadlib.addownload.z.getContext() != null) {
            com.ss.android.downloadlib.addownload.z.getContext().startActivity(t);
        }
    }

    public static void vw(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar, java.lang.String str) {
        vw(vwVar, 19, "", "", "", str);
    }

    public static void vw(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        vw(vwVar, 8, str, str2, str3, "");
    }

    public static void vw(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        vw(vwVar, 21, str, str2, str3, str4);
    }

    private void vw(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            android.net.Uri parse = android.net.Uri.parse(str);
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.putExtra("open_url", str);
            intent.addFlags(268435456);
            if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
                intent.addFlags(67108864);
            }
            intent.putExtra("start_only_for_android", true);
            startActivity(intent);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } finally {
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
        }
    }

    public static void vw(java.lang.String str, long j) {
        android.content.Intent intent = new android.content.Intent(com.ss.android.downloadlib.addownload.z.getContext(), (java.lang.Class<?>) com.ss.android.downloadlib.activity.TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 15);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        if (com.ss.android.downloadlib.addownload.z.getContext() != null) {
            com.ss.android.downloadlib.addownload.z.getContext().startActivity(intent);
        }
    }

    public static void vw(java.lang.String str, long j, java.lang.String str2) {
        android.content.Intent intent = new android.content.Intent(com.ss.android.downloadlib.addownload.z.getContext(), (java.lang.Class<?>) com.ss.android.downloadlib.activity.TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 13);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("need_comment", str2);
        if (com.ss.android.downloadlib.addownload.z.getContext() != null) {
            com.ss.android.downloadlib.addownload.z.getContext().startActivity(intent);
        }
    }

    public static void vw(java.lang.String str, long j, java.lang.String str2, @androidx.annotation.NonNull org.json.JSONObject jSONObject) {
        android.content.Intent intent = new android.content.Intent(com.ss.android.downloadlib.addownload.z.getContext(), (java.lang.Class<?>) com.ss.android.downloadlib.activity.TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM, str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (com.ss.android.downloadlib.addownload.z.getContext() != null) {
            com.ss.android.downloadlib.addownload.z.getContext().startActivity(intent);
        }
    }

    public static void vw(java.lang.String str, com.ss.android.downloadad.api.vw.vw vwVar) {
        android.content.Intent t = t(vwVar);
        t.addFlags(268435456);
        t.putExtra("type", 2);
        t.putExtra("open_url", str);
        if (com.ss.android.downloadlib.addownload.z.getContext() != null) {
            com.ss.android.downloadlib.addownload.z.getContext().startActivity(t);
        }
    }

    public static void vw(java.lang.String str, java.lang.String[] strArr) {
        android.content.Intent intent = new android.content.Intent(com.ss.android.downloadlib.addownload.z.getContext(), (java.lang.Class<?>) com.ss.android.downloadlib.activity.TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (com.ss.android.downloadlib.addownload.z.getContext() != null) {
            com.ss.android.downloadlib.addownload.z.getContext().startActivity(intent);
        }
    }

    private void wg() {
        android.view.Window window = getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void wg(long j) {
        com.ss.android.downloadad.api.vw.wg v2 = com.ss.android.downloadlib.addownload.wg.kz.vw().v(j);
        if (v2 == null) {
            com.ss.android.downloadlib.yl.t.vw().vw("showOpenAppDialogInner nativeModel null");
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
            return;
        }
        com.ss.android.download.api.config.vl t = com.ss.android.downloadlib.addownload.z.t();
        com.ss.android.download.api.model.wg.vw vw = new com.ss.android.download.api.model.wg.vw(this).vw("已安装完成");
        java.lang.Object[] objArr = new java.lang.Object[1];
        objArr[0] = android.text.TextUtils.isEmpty(v2.f()) ? "刚刚下载的应用" : v2.f();
        t.wg(vw.wg(java.lang.String.format("%1$s已安装完成，是否立即打开？", objArr)).t("打开").v("取消").vw(false).vw(com.ss.android.downloadlib.bt.vl.v(this, v2.yl())).vw(new com.ss.android.downloadlib.activity.TTDelegateActivity.AnonymousClass2(v2)).vw(2).vw());
        com.ss.android.downloadlib.v.vw.vw().wg("market_openapp_window_show", v2);
    }

    public static void wg(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar) {
        vw(vwVar, 5, "", "", "", "");
    }

    public static void wg(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        vw(vwVar, 7, str, str2, str3, "");
    }

    public static void wg(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        vw(vwVar, 20, str, str2, str3, str4);
    }

    private void wg(java.lang.String str) {
        android.content.Intent bt = com.ss.android.downloadlib.bt.vl.bt(this, str);
        if (bt == null) {
            return;
        }
        try {
            bt.addFlags(268435456);
            bt.putExtra("start_only_for_android", true);
            startActivity(bt);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } finally {
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
        }
    }

    public static void wg(java.lang.String str, long j, java.lang.String str2) {
        android.content.Intent intent = new android.content.Intent(com.ss.android.downloadlib.addownload.z.getContext(), (java.lang.Class<?>) com.ss.android.downloadlib.activity.TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 14);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (com.ss.android.downloadlib.addownload.z.getContext() != null) {
            com.ss.android.downloadlib.addownload.z.getContext().startActivity(intent);
        }
    }

    public static void wg(java.lang.String str, com.ss.android.downloadad.api.vw.vw vwVar) {
        android.content.Intent t = t(vwVar);
        t.addFlags(268435456);
        t.putExtra("type", 11);
        t.putExtra("package_name", str);
        if (com.ss.android.downloadlib.addownload.z.getContext() != null) {
            com.ss.android.downloadlib.addownload.z.getContext().startActivity(t);
        }
    }

    private void wg(java.lang.String str, java.lang.String[] strArr) {
        if (android.text.TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
            return;
        }
        com.ss.android.downloadlib.activity.TTDelegateActivity.AnonymousClass1 anonymousClass1 = new com.ss.android.downloadlib.activity.TTDelegateActivity.AnonymousClass1(str);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            try {
                com.ss.android.downloadlib.addownload.z.yl().vw(this, strArr, anonymousClass1);
                return;
            } catch (java.lang.Exception e) {
                com.ss.android.downloadlib.addownload.z.q().vw(e, "requestPermission");
            }
        }
        anonymousClass1.vw();
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        wg();
        this.vw = getIntent();
        com.ss.android.downloadlib.addownload.z.wg(this);
        vw();
    }

    @Override // android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
        super.onNewIntent(intent);
        setIntent(intent);
        this.vw = intent;
        com.ss.android.downloadlib.addownload.z.wg(this);
        vw();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @androidx.annotation.NonNull java.lang.String[] strArr, @androidx.annotation.NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        com.ss.android.downloadlib.addownload.z.yl().vw(this, i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onStop() {
        com.ss.android.downloadad.api.vw.wg wgVar;
        super.onStop();
        if (!this.wg || (wgVar = this.t) == null) {
            return;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo vw = !android.text.TextUtils.isEmpty(wgVar.ux()) ? com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext()).vw(this.t.ux(), null, true) : com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext()).wg(this.t.vw());
        if (vw == null || vw.getCurBytes() < vw.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void vw() {
        android.content.Intent intent = this.vw;
        if (intent != null) {
            switch (intent.getIntExtra("type", 0)) {
                case 1:
                    wg(this.vw.getStringExtra("permission_id_key"), this.vw.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    vw(this.vw.getStringExtra("open_url"));
                    break;
                case 3:
                case 6:
                case 16:
                case 17:
                case 18:
                default:
                    com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
                    break;
                case 4:
                    wg(this.vw.getLongExtra("model_id", 0L));
                    break;
                case 5:
                    vw(this.vw.getLongExtra("model_id", 0L), "");
                    break;
                case 7:
                case 8:
                case 20:
                case 21:
                    t();
                    break;
                case 9:
                    com.ss.android.downloadlib.guide.install.vw vwVar = v;
                    if (vwVar != null) {
                        vwVar.vw();
                    }
                    com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
                    break;
                case 10:
                    t(this.vw.getLongExtra("app_info_id", 0L));
                    break;
                case 11:
                    wg(this.vw.getStringExtra("package_name"));
                    break;
                case 12:
                    com.ss.android.downloadlib.bt.o.vw(this, this.vw.getStringExtra("package_name"), this.vw.getLongExtra("model_id", 0L), this.vw.getStringExtra(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM), this.vw.getStringExtra("ext_json"));
                    com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
                    break;
                case 13:
                    com.ss.android.downloadlib.bt.o.vw(this, this.vw.getStringExtra("package_name"), this.vw.getLongExtra("model_id", 0L), this.vw.getStringExtra("need_comment"));
                    com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
                    break;
                case 14:
                    com.ss.android.downloadlib.bt.o.wg(this, this.vw.getStringExtra("package_name"), this.vw.getLongExtra("model_id", 0L), this.vw.getStringExtra("market_app_id"));
                    com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
                    break;
                case 15:
                    com.ss.android.downloadlib.bt.o.vw(this, this.vw.getStringExtra("package_name"), this.vw.getLongExtra("model_id", 0L));
                    com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
                    break;
                case 19:
                    vw(this.vw.getLongExtra("model_id", 0L), this.vw.getStringExtra("delete_button_text"));
                    break;
            }
            this.vw = null;
        }
    }
}
