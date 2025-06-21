package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public final class p {
    private android.content.Context b;
    private boolean c = false;
    java.lang.String a = null;

    public p(android.content.Context context) {
        this.b = context;
    }

    public final java.lang.String a() {
        try {
            android.database.Cursor query = this.b.getContentResolver().query(android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (query != null) {
                r0 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                query.close();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return r0;
    }
}
