package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class MeizuImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context a;

    public MeizuImpl(android.content.Context context) {
        this.a = context;
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (this.a == null || iGetter == null) {
            return;
        }
        try {
            android.database.Cursor query = this.a.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{"oaid"}, null);
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
        android.content.Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return false;
        }
    }
}
