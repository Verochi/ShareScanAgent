package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class as {
    private static final java.lang.String a = com.baidu.mobads.sdk.internal.z.o;
    private static final java.lang.String b = "pauseDlByPk";
    private static final java.lang.String c = "cancelDlByPk";
    private static final java.lang.String d = "resumeDownload";
    private static final java.lang.String e = "getDownloadStatus";
    private static com.baidu.mobads.sdk.internal.as g;
    private com.baidu.mobads.sdk.internal.at f;

    private as(android.content.Context context) {
        this.f = com.baidu.mobads.sdk.internal.at.a(context, a);
    }

    public static com.baidu.mobads.sdk.internal.as a(android.content.Context context) {
        if (g == null) {
            synchronized (com.baidu.mobads.sdk.internal.as.class) {
                if (g == null) {
                    g = new com.baidu.mobads.sdk.internal.as(context);
                }
            }
        }
        return g;
    }

    public int a(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        if (com.baidu.mobads.sdk.internal.bu.a(context, str)) {
            return 103;
        }
        java.lang.Object b2 = this.f.b(null, e, str);
        if (b2 instanceof java.lang.Integer) {
            return ((java.lang.Integer) b2).intValue();
        }
        return -1;
    }

    public void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.f.a(null, b, str, 1);
    }

    public boolean a(android.content.Context context, org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2) {
        if (context != null && jSONObject != null) {
            java.lang.Object b2 = this.f.b(null, d, context, jSONObject, str, str2);
            if (b2 instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) b2).booleanValue();
            }
        }
        return false;
    }

    public void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.f.a(null, c, str);
    }
}
