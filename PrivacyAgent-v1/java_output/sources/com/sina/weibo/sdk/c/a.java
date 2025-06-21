package com.sina.weibo.sdk.c;

/* loaded from: classes19.dex */
public final class a {

    /* renamed from: com.sina.weibo.sdk.c.a$a, reason: collision with other inner class name */
    public static class C0466a {
        public int am;
        public java.lang.String packageName = "com.sina.weibo";
        public java.lang.String al = "com.sina.weibo.SSOActivity";
    }

    public static boolean a(android.content.Context context, android.content.Intent intent) {
        android.content.pm.PackageManager packageManager;
        android.content.pm.ResolveInfo resolveActivity;
        if (context == null || (packageManager = context.getPackageManager()) == null || (resolveActivity = packageManager.resolveActivity(intent, 0)) == null) {
            return false;
        }
        try {
            android.content.pm.Signature[] signatureArr = packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures;
            if (signatureArr == null) {
                return false;
            }
            for (android.content.pm.Signature signature : signatureArr) {
                if ("18da2bf10352443a00a5e046d9fca6bd".equals(com.sina.weibo.sdk.c.d.a(signature.toByteArray()))) {
                    return true;
                }
            }
            return false;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static com.sina.weibo.sdk.c.a.C0466a c(android.content.Context context) {
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices;
        android.content.Intent intent = new android.content.Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        com.sina.weibo.sdk.c.a.C0466a c0466a = null;
        if (context != null && (queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) != null && !queryIntentServices.isEmpty()) {
            for (android.content.pm.ResolveInfo resolveInfo : queryIntentServices) {
                android.content.pm.ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && serviceInfo.applicationInfo != null && !android.text.TextUtils.isEmpty(serviceInfo.packageName)) {
                    java.lang.String str = resolveInfo.serviceInfo.packageName;
                    com.sina.weibo.sdk.c.a.C0466a d = d(context, str);
                    if (d != null) {
                        c0466a = d;
                    }
                    if ("com.sina.weibo".equals(str) || "com.sina.weibog3".equals(str)) {
                        break;
                    }
                }
            }
        }
        return c0466a;
    }

    private static com.sina.weibo.sdk.c.a.C0466a d(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            java.io.InputStream open = context.createPackageContext(str, 2).getAssets().open("weibo_for_sdk.json");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = open.read(bArr, 0, 4096);
                if (read == -1) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(sb.toString());
                    com.sina.weibo.sdk.c.a.C0466a c0466a = new com.sina.weibo.sdk.c.a.C0466a();
                    c0466a.am = jSONObject.optInt("support_api", -1);
                    c0466a.al = jSONObject.optString("authActivityName", null);
                    c0466a.packageName = str;
                    return c0466a;
                }
                sb.append(new java.lang.String(bArr, 0, read));
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (org.json.JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
