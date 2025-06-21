package com.sijla.g.a.a;

/* loaded from: classes19.dex */
public final class q {
    private android.content.Context a;
    private boolean b = false;
    private java.lang.String c = null;

    public q(android.content.Context context) {
        this.a = context;
    }

    public final java.lang.String a() {
        android.database.Cursor query = this.a.getContentResolver().query(android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        if (query != null) {
            r1 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
            query.close();
        }
        return r1;
    }
}
