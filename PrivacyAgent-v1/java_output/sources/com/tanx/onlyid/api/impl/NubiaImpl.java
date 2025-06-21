package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class NubiaImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context a;

    public NubiaImpl(android.content.Context context) {
        this.a = context;
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (this.a == null || iGetter == null) {
            return;
        }
        if (!supported()) {
            com.tanx.onlyid.api.OAIDLog.print("Only supports Android 10.0 and above for Nubia");
            iGetter.oaidError(new com.tanx.onlyid.api.OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            android.content.ContentProviderClient acquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(android.net.Uri.parse("content://cn.nubia.identity/identity"));
            if (acquireContentProviderClient == null) {
                return;
            }
            android.os.Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                acquireContentProviderClient.close();
            } else {
                acquireContentProviderClient.release();
            }
            if (call == null) {
                throw new com.tanx.onlyid.api.OAIDException("OAID query failed: bundle is null");
            }
            java.lang.String string = call.getInt("code", -1) == 0 ? call.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new com.tanx.onlyid.api.OAIDException("OAID query failed: " + call.getString("message"));
            }
            com.tanx.onlyid.api.OAIDLog.print("OAID query success: " + string);
            iGetter.oaidSucc(string);
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            iGetter.oaidError(e);
        }
    }

    @Override // com.tanx.onlyid.api.IOAID
    @android.annotation.SuppressLint({"AnnotateVersionCheck"})
    public boolean supported() {
        return android.os.Build.VERSION.SDK_INT >= 29;
    }
}
