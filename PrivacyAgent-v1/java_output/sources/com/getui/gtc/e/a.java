package com.getui.gtc.e;

/* loaded from: classes22.dex */
public class a extends com.getui.gtc.base.db.AbstractTable {
    private android.util.SparseArray<java.lang.Long> a = new android.util.SparseArray<>();
    private android.util.SparseArray<java.lang.Long> b = new android.util.SparseArray<>();
    private android.util.SparseIntArray c = new android.util.SparseIntArray();

    public final long a(int i) {
        java.lang.Long l = this.a.get(i);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final void a(int i, long j) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.EXPANDABLE_IMAGE_URL, java.lang.Integer.valueOf(i));
        contentValues.put("elt", java.lang.String.valueOf(j));
        if (replace(null, contentValues) != -1) {
            this.a.put(i, java.lang.Long.valueOf(j));
        }
    }

    public final void a(int i, long j, int i2) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.EXPANDABLE_IMAGE_URL, java.lang.Integer.valueOf(i));
        contentValues.put("est", java.lang.String.valueOf(j));
        contentValues.put("esn", java.lang.Integer.valueOf(i2));
        if (replace(null, contentValues) != -1) {
            this.b.put(i, java.lang.Long.valueOf(j));
            this.c.put(i, i2);
        }
    }

    public final long b(int i) {
        java.lang.Long l = this.b.get(i);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final int c(int i) {
        return this.c.get(i);
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String createSql() {
        return "CREATE TABLE IF NOT EXISTS e (ei INTEGER PRIMARY KEY, elt TEXT, est TEXT, esn INTEGER)";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String getTableName() {
        return "e";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public void initCache() {
        android.database.Cursor cursor = null;
        try {
            try {
                android.database.Cursor query = query(new java.lang.String[]{com.meizu.cloud.pushsdk.notification.model.NotificationStyle.EXPANDABLE_IMAGE_URL, "elt", "est", "esn"}, null, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                        return;
                    }
                    return;
                }
                while (query.moveToNext()) {
                    int i = query.getInt(query.getColumnIndex(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.EXPANDABLE_IMAGE_URL));
                    try {
                        this.a.put(i, java.lang.Long.valueOf(java.lang.Long.parseLong(query.getString(query.getColumnIndex("elt")))));
                    } catch (java.lang.Exception unused) {
                    }
                    try {
                        this.b.put(i, java.lang.Long.valueOf(java.lang.Long.parseLong(query.getString(query.getColumnIndex("est")))));
                    } catch (java.lang.Exception unused2) {
                    }
                    this.c.put(i, query.getInt(query.getColumnIndex("esn")));
                }
                query.close();
            } catch (java.lang.Exception e) {
                com.getui.gtc.h.c.a.b(e);
                if (0 != 0) {
                    cursor.close();
                }
            }
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }
}
