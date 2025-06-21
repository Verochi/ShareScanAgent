package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public final class j {
    private android.content.Context a;

    public j(android.content.Context context) {
        this.a = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        try {
            this.a.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        java.lang.String str = null;
        try {
            android.database.Cursor query = this.a.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{"oaid"}, null);
            if (query != null && !query.isClosed()) {
                query.moveToFirst();
                int columnIndex = query.getColumnIndex("value");
                if (columnIndex > 0) {
                    str = query.getString(columnIndex);
                }
            }
            aVar.a(str, false);
            if (query != null) {
                try {
                    query.close();
                } catch (java.lang.Exception unused) {
                }
            }
        } catch (java.lang.Throwable th2) {
            th2.getMessage();
        }
        if (android.text.TextUtils.isEmpty(str)) {
            aVar.a();
        }
    }
}
