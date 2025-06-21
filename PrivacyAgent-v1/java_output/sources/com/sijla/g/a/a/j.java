package com.sijla.g.a.a;

/* loaded from: classes19.dex */
public final class j {
    private android.content.Context a;

    public j(android.content.Context context) {
        this.a = context;
    }

    public final java.lang.String a() {
        android.net.Uri parse = android.net.Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i = android.os.Build.VERSION.SDK_INT;
            android.content.ContentProviderClient acquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(parse);
            android.os.Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (i >= 24) {
                acquireContentProviderClient.close();
            } else {
                acquireContentProviderClient.release();
            }
            if (call != null && call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
