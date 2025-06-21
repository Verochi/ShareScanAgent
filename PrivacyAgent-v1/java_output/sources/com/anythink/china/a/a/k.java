package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public final class k {
    private android.content.Context a;

    public k(android.content.Context context) {
        this.a = context;
    }

    public final java.lang.String a() {
        try {
            android.net.Uri parse = android.net.Uri.parse("content://cn.nubia.identity/identity");
            int i = android.os.Build.VERSION.SDK_INT;
            android.content.ContentProviderClient acquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(parse);
            android.os.Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (i >= 24) {
                acquireContentProviderClient.close();
            } else {
                acquireContentProviderClient.release();
            }
            return (call != null ? call.getInt("code", -1) : -1) == 0 ? call.getString("id") : "";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
