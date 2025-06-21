package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class VivoImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context a;

    public VivoImpl(android.content.Context context) {
        this.a = context;
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (this.a == null || iGetter == null) {
            return;
        }
        try {
            android.database.Cursor query = this.a.getContentResolver().query(android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                java.util.Objects.requireNonNull(query);
                query.moveToFirst();
                java.lang.String string = query.getString(query.getColumnIndex("value"));
                if (string == null || string.length() == 0) {
                    throw new com.tanx.onlyid.api.OAIDException("OAID query failed");
                }
                com.tanx.onlyid.api.OAIDLog.print("OAID query success: " + string);
                iGetter.oaidSucc(string);
                query.close();
            } finally {
            }
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            iGetter.oaidError(e);
        }
    }

    @Override // com.tanx.onlyid.api.IOAID
    public boolean supported() {
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.tanx.onlyid.api.OAIDRom.sysProperty(com.alipay.sdk.m.p0.c.c, "0").equals("1");
    }
}
