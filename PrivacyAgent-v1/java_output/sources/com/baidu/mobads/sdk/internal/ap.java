package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class ap {
    private static final java.lang.String a = com.baidu.mobads.sdk.internal.z.m;
    private static final java.lang.String b = "__sdk_remote_dl_no_install";
    private static final long c = 3600000;
    private android.content.Context d;
    private android.content.SharedPreferences e;
    private android.content.SharedPreferences.Editor f;
    private com.baidu.mobads.sdk.internal.at g;
    private com.baidu.mobads.sdk.api.PromoteInstallManager.PromoteInstallListener h;
    private int i;
    private long j;

    public static class a {
        private static final com.baidu.mobads.sdk.internal.ap a = new com.baidu.mobads.sdk.internal.ap(null);

        private a() {
        }
    }

    private ap() {
        this.i = 0;
        this.j = 0L;
    }

    public /* synthetic */ ap(com.baidu.mobads.sdk.internal.aq aqVar) {
        this();
    }

    public static com.baidu.mobads.sdk.internal.ap a(android.content.Context context, com.baidu.mobads.sdk.api.PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        com.baidu.mobads.sdk.internal.ap.a.a.b(context, promoteInstallListener);
        return com.baidu.mobads.sdk.internal.ap.a.a;
    }

    private java.util.List<java.lang.String> a(java.util.Map<java.lang.String, java.lang.Long> map) {
        if (map == null || map.size() <= 0) {
            com.baidu.mobads.sdk.api.PromoteInstallManager.PromoteInstallListener promoteInstallListener = this.h;
            if (promoteInstallListener != null) {
                promoteInstallListener.onFail("暂无可用物料，请稍后再试");
            }
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(map.entrySet());
        java.util.Collections.sort(arrayList, new com.baidu.mobads.sdk.internal.aq(this));
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((java.util.Map.Entry) it.next()).getKey());
        }
        if (map.get(arrayList2.get(0)).longValue() > this.j || this.i < 3) {
            return arrayList2;
        }
        com.baidu.mobads.sdk.api.PromoteInstallManager.PromoteInstallListener promoteInstallListener2 = this.h;
        if (promoteInstallListener2 != null) {
            promoteInstallListener2.onFail("暂无可用物料，请稍后再试");
        }
        return null;
    }

    private boolean a(org.json.JSONObject jSONObject) {
        java.io.File file = new java.io.File(jSONObject.optString("folder") + jSONObject.optString(com.liulishuo.filedownloader.model.FileDownloadModel.FILENAME));
        return file.exists() && file.length() > 0;
    }

    private void b(android.content.Context context, com.baidu.mobads.sdk.api.PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        this.d = context;
        android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(b, 0);
        this.e = sharedPreferences;
        this.f = sharedPreferences.edit();
        this.g = com.baidu.mobads.sdk.internal.at.a(context, a);
        this.h = promoteInstallListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        r3 = new com.baidu.mobads.sdk.internal.ao(r7, r16.d, r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        if (r17 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
    
        r0 = new org.json.JSONObject(r7.toString());
        r0.put(com.anythink.pd.ExHandler.JSON_REQUEST_INSTALL_TS, r8);
        r0 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0080, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0081, code lost:
    
        r0.printStackTrace();
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b4, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.mobads.sdk.api.IPromoteInstallAdInfo a(boolean z) {
        java.util.Map<java.lang.String, ?> all;
        java.util.List<java.lang.String> a2;
        java.lang.String str;
        java.lang.Long l;
        com.baidu.mobads.sdk.internal.ao aoVar;
        java.lang.String str2;
        com.baidu.mobads.sdk.internal.ao aoVar2 = null;
        try {
            all = this.e.getAll();
            a2 = a((java.util.Map<java.lang.String, java.lang.Long>) all);
        } catch (java.lang.Throwable unused) {
        }
        if (a2 == null) {
            return null;
        }
        int i = 0;
        while (true) {
            if (i >= a2.size()) {
                break;
            }
            str = a2.get(i);
            java.lang.Object b2 = this.g.b(null, "getAdDownLoadInfo", this.d, str);
            if (!(b2 instanceof org.json.JSONObject) || ((org.json.JSONObject) b2).length() <= 0) {
                this.f.remove(str);
                this.f.commit();
            } else {
                org.json.JSONObject jSONObject = (org.json.JSONObject) b2;
                l = (java.lang.Long) all.get(str);
                if (a(jSONObject) && java.lang.System.currentTimeMillis() - l.longValue() < 3600000 && !com.baidu.mobads.sdk.internal.bu.a(this.d, str)) {
                    break;
                }
                this.f.remove(str);
                this.f.commit();
            }
            i++;
        }
        com.baidu.mobads.sdk.api.PromoteInstallManager.PromoteInstallListener promoteInstallListener = this.h;
        if (promoteInstallListener != null) {
            promoteInstallListener.onFail("暂无可用物料，请稍后再试");
        }
        return aoVar2;
        this.g.b(null, "startInstallDialogActivity", this.d, str2);
        int i2 = this.i + 1;
        this.i = i2;
        if (i2 <= 3) {
            this.j = l.longValue();
        }
        this.f.remove(str);
        this.f.commit();
        com.baidu.mobads.sdk.api.PromoteInstallManager.PromoteInstallListener promoteInstallListener2 = this.h;
        if (promoteInstallListener2 != null) {
            promoteInstallListener2.onSuccess();
        }
        return aoVar;
    }

    public void a(android.content.Context context, java.lang.String str) {
        this.g.b(null, "handleAdInstall", context, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean a() {
        java.util.Map<java.lang.String, ?> all;
        java.util.List<java.lang.String> a2;
        try {
            all = this.e.getAll();
            a2 = a((java.util.Map<java.lang.String, java.lang.Long>) all);
        } catch (java.lang.Throwable unused) {
        }
        if (a2 == null) {
            return false;
        }
        for (int i = 0; i < a2.size(); i++) {
            java.lang.String str = a2.get(i);
            java.lang.Object b2 = this.g.b(null, "getAdDownLoadInfo", this.d, str);
            if ((b2 instanceof org.json.JSONObject) && ((org.json.JSONObject) b2).length() > 0) {
                java.lang.Long l = (java.lang.Long) all.get(str);
                if (a((org.json.JSONObject) b2) && java.lang.System.currentTimeMillis() - l.longValue() < 3600000 && !com.baidu.mobads.sdk.internal.bu.a(this.d, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean b() {
        java.lang.Object b2 = this.g.b(null, "isInstallPopSwitch", new java.lang.Object[0]);
        if (b2 instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) b2).booleanValue();
        }
        return false;
    }

    public int c() {
        java.lang.Object b2 = this.g.b(null, "getInstallPopType", new java.lang.Object[0]);
        if (b2 instanceof java.lang.Integer) {
            return ((java.lang.Integer) b2).intValue();
        }
        return 0;
    }
}
