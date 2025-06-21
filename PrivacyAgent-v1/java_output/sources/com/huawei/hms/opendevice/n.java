package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class n {

    public enum a {
        MOBILE("1"),
        PC("2"),
        TABLET("3"),
        TV("4"),
        SOUNDBOX("5"),
        GLASS("6"),
        WATCH("7"),
        VEHICLE("8"),
        OFFICE_DEVICE("9"),
        IOT_DEVICES(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ),
        HEALTHY(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE),
        ENTERTAINMENT(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR),
        TRANSPORT_DEVICES("13");

        public java.lang.String o;

        a(java.lang.String str) {
            this.o = str;
        }

        public java.lang.String a() {
            return this.o;
        }
    }

    public enum b {
        IOS("ios"),
        ANDROID(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM),
        HARMONY("harmony"),
        WINDOWS(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS),
        EMBED("embed"),
        OTHERS("others");

        public java.lang.String h;

        b(java.lang.String str) {
            this.h = str;
        }

        public java.lang.String a() {
            return this.h;
        }
    }

    public static void a(android.content.Context context, java.lang.String str) {
        new com.huawei.hms.opendevice.m(context, str).start();
    }

    public static void b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.hms.support.log.HMSLog.e("ReportAaidToken", "Https response is empty.");
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            int optInt = jSONObject.optInt("ret", 256);
            if (optInt != 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Https response body's ret code: ");
                sb.append(optInt);
                sb.append(", error message: ");
                sb.append(jSONObject.optString("msg"));
                com.huawei.hms.support.log.HMSLog.e("ReportAaidToken", sb.toString());
                return;
            }
            boolean saveString = com.huawei.hms.opendevice.i.a(context).saveString("reportAaidAndToken", com.huawei.hms.opendevice.r.a(str3 + str2, "SHA-256"));
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Report success ");
            sb2.append(saveString ? "and save success." : "but save failure.");
            com.huawei.hms.support.log.HMSLog.d("ReportAaidToken", sb2.toString());
        } catch (org.json.JSONException unused) {
            com.huawei.hms.support.log.HMSLog.e("ReportAaidToken", "Has JSONException.");
        } catch (java.lang.Exception unused2) {
            com.huawei.hms.support.log.HMSLog.e("ReportAaidToken", "Exception occur.");
        }
    }

    public static boolean b(android.content.Context context) {
        int packageVersionCode = new com.huawei.hms.utils.PackageManagerHelper(context).getPackageVersionCode("com.huawei.android.pushagent");
        com.huawei.hms.support.log.HMSLog.d("ReportAaidToken", "NC version code: " + packageVersionCode);
        return (90101400 <= packageVersionCode && packageVersionCode < 100000000) || packageVersionCode >= 100001301;
    }

    public static java.lang.String c(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("timezone", java.util.TimeZone.getDefault().getID());
            jSONObject2.put("country", com.huawei.hms.android.SystemUtils.getLocalCountry());
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            jSONObject3.put("agent_version", new com.huawei.hms.utils.PackageManagerHelper(context).getPackageVersionName("com.huawei.android.pushagent"));
            jSONObject3.put("hms_version", java.lang.String.valueOf(com.huawei.hms.utils.Util.getHmsVersion(context)));
            org.json.JSONObject jSONObject4 = new org.json.JSONObject();
            jSONObject4.put("dev_type", com.huawei.hms.opendevice.n.a.MOBILE.a());
            jSONObject4.put("dev_sub_type", com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            jSONObject4.put("os_type", com.huawei.hms.opendevice.n.b.ANDROID.a());
            jSONObject4.put("os_version", java.lang.String.valueOf(com.huawei.hms.android.HwBuildEx.VERSION.EMUI_SDK_INT));
            jSONObject.put("id", java.util.UUID.randomUUID().toString());
            jSONObject.put("global", jSONObject2);
            jSONObject.put("push_agent", jSONObject3);
            jSONObject.put("hardware", jSONObject4);
            jSONObject.put("aaid", str);
            jSONObject.put("token", str2);
            jSONObject.put("app_id", com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(context).getString("client/app_id"));
            jSONObject.put("region", com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(context).getString("region"));
            return jSONObject.toString();
        } catch (org.json.JSONException unused) {
            com.huawei.hms.support.log.HMSLog.e("ReportAaidToken", "Catch JSONException.");
            return null;
        }
    }

    public static boolean d(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.huawei.hms.opendevice.i a2 = com.huawei.hms.opendevice.i.a(context);
        if (!a2.containsKey("reportAaidAndToken")) {
            com.huawei.hms.support.log.HMSLog.d("ReportAaidToken", "It hasn't been reported, this time needs report.");
            return true;
        }
        if (android.text.TextUtils.isEmpty(a2.getString("reportAaidAndToken"))) {
            com.huawei.hms.support.log.HMSLog.e("ReportAaidToken", "It has been reported, but sp file is empty, this time needs report.");
            return true;
        }
        return !r4.equals(com.huawei.hms.opendevice.r.a(str2 + str, "SHA-256"));
    }
}
