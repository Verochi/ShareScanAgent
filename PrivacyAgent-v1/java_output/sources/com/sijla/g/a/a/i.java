package com.sijla.g.a.a;

/* loaded from: classes19.dex */
public final class i {
    private android.content.Context a;

    public i(android.content.Context context) {
        this.a = context;
    }

    public final void a(com.sijla.g.a.a.c.a aVar) {
        try {
            this.a.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        try {
            android.database.Cursor query = this.a.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{"oaid"}, null);
            if (query != null) {
                if (!query.isClosed()) {
                    query.moveToFirst();
                    int columnIndex = query.getColumnIndex("value");
                    r2 = columnIndex > 0 ? query.getString(columnIndex) : null;
                    int columnIndex2 = query.getColumnIndex("code");
                    if (columnIndex2 > 0) {
                        query.getInt(columnIndex2);
                    }
                    int columnIndex3 = query.getColumnIndex("expired");
                    if (columnIndex3 > 0) {
                        query.getLong(columnIndex3);
                    }
                }
                if (aVar != null) {
                    aVar.a(r2);
                }
                query.close();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
