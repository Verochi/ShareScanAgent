package com.sensorsdata.analytics.android.sdk.advert.scan;

/* loaded from: classes19.dex */
public class WhiteListScanHelper implements com.sensorsdata.analytics.android.sdk.advert.scan.IAdvertScanListener {

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.scan.WhiteListScanHelper$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.lang.Thread {
        final /* synthetic */ android.app.Activity val$activity;
        final /* synthetic */ java.lang.String val$info_id;
        final /* synthetic */ java.lang.String val$project;
        final /* synthetic */ java.lang.String val$url;

        /* renamed from: com.sensorsdata.analytics.android.sdk.advert.scan.WhiteListScanHelper$1$1, reason: invalid class name and collision with other inner class name */
        public class C04381 extends com.sensorsdata.analytics.android.sdk.network.HttpCallback.JsonCallback {
            public C04381() {
            }

            @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback.JsonCallback, com.sensorsdata.analytics.android.sdk.network.HttpCallback
            public void onAfter() {
                com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(com.sensorsdata.analytics.android.sdk.advert.scan.WhiteListScanHelper.AnonymousClass1.this.val$activity);
            }

            @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
            public void onFailure(int i, java.lang.String str) {
                android.app.Activity activity = com.sensorsdata.analytics.android.sdk.advert.scan.WhiteListScanHelper.AnonymousClass1.this.val$activity;
                com.sensorsdata.analytics.android.sdk.util.ToastUtil.showLong(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_whitelist_request_falied));
            }

            @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
            public void onResponse(org.json.JSONObject jSONObject) {
                if (jSONObject.optInt("code", -1) == 0) {
                    android.app.Activity activity = com.sensorsdata.analytics.android.sdk.advert.scan.WhiteListScanHelper.AnonymousClass1.this.val$activity;
                    com.sensorsdata.analytics.android.sdk.util.ToastUtil.showLong(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_whitelist_request_success));
                } else {
                    android.app.Activity activity2 = com.sensorsdata.analytics.android.sdk.advert.scan.WhiteListScanHelper.AnonymousClass1.this.val$activity;
                    com.sensorsdata.analytics.android.sdk.util.ToastUtil.showLong(activity2, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity2, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_whitelist_request_falied));
                }
            }
        }

        public AnonymousClass1(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.val$activity = activity;
            this.val$info_id = str;
            this.val$project = str2;
            this.val$url = str3;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("android_oaid", com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifier(this.val$activity));
                jSONObject.put("android_oaid_reflection", com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifierByReflection(this.val$activity));
                jSONObject.put("android_id", com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.getIdentifier(this.val$activity));
                jSONObject.put("android_imei", com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.getInstallSource(this.val$activity));
                jSONObject.put("info_id", this.val$info_id);
                jSONObject.put("project_name", this.val$project);
                jSONObject.put(com.umeng.analytics.pro.bo.ai, "2");
                new com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder(com.sensorsdata.analytics.android.sdk.network.HttpMethod.POST, this.val$url).jsonData(jSONObject.toString()).callback(new com.sensorsdata.analytics.android.sdk.advert.scan.WhiteListScanHelper.AnonymousClass1.C04381()).execute();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    private static void updateWhitelist(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        new com.sensorsdata.analytics.android.sdk.advert.scan.WhiteListScanHelper.AnonymousClass1(activity, str2, str3, str).start();
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.scan.IAdvertScanListener
    public void handlerScanUri(android.app.Activity activity, android.net.Uri uri) {
        if (!"2".equals(uri.getQueryParameter(com.umeng.analytics.pro.bo.ai))) {
            com.sensorsdata.analytics.android.sdk.util.ToastUtil.showLong(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_whitelist_platform_error));
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(activity);
            return;
        }
        java.lang.String queryParameter = uri.getQueryParameter("apiurl");
        java.lang.String queryParameter2 = uri.getQueryParameter("info_id");
        if (android.text.TextUtils.isEmpty(queryParameter) || android.text.TextUtils.isEmpty(queryParameter2)) {
            com.sensorsdata.analytics.android.sdk.util.ToastUtil.showLong(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_whitelist_request_falied));
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(activity);
            return;
        }
        java.lang.String queryParameter3 = uri.getQueryParameter("project");
        if (android.text.TextUtils.isEmpty(queryParameter3)) {
            queryParameter3 = "default";
        }
        if (queryParameter3.equals(new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getServerUrl()).getProject())) {
            updateWhitelist(activity, queryParameter, queryParameter2, queryParameter3);
        } else {
            com.sensorsdata.analytics.android.sdk.util.ToastUtil.showLong(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_whitelist_project_error));
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(activity);
        }
    }
}
