package com.getui.gs.b;

/* loaded from: classes22.dex */
public class b extends com.getui.gtc.base.db.AbstractTable {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public final java.util.Map<java.lang.Integer, java.lang.Long> d = new java.util.HashMap(32);

    public b() {
        for (int i = 2; i <= 30; i++) {
            this.d.put(java.lang.Integer.valueOf(i), 0L);
        }
        this.d.put(3, -1L);
        this.d.put(31, -1L);
    }

    public final long a() {
        return this.d.get(3).longValue();
    }

    public final long a(int i) {
        java.lang.Long l = this.d.get(java.lang.Integer.valueOf(i));
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final void a(int i, long j) {
        if (a(i, java.lang.String.valueOf(j).getBytes())) {
            this.d.put(java.lang.Integer.valueOf(i), java.lang.Long.valueOf(j));
        }
    }

    public final boolean a(int i, byte[] bArr) {
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("a", java.lang.Integer.valueOf(i));
            contentValues.put("b", com.getui.gtc.base.crypt.SecureCryptTools.getInstance().encrypt(bArr));
            return replace(null, contentValues) != -1;
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.w(th);
            return false;
        }
    }

    public final long b() {
        return this.d.get(31).longValue();
    }

    public final long c() {
        return this.d.get(4).longValue();
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String createSql() {
        return "CREATE TABLE IF NOT EXISTS c (a INTEGER PRIMARY KEY, b BLOB)";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String getTableName() {
        return "c";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public void initCache() {
        try {
            android.database.Cursor query = query(new java.lang.String[]{"a", "b"}, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        int i = query.getInt(0);
                        byte[] decrypt = com.getui.gtc.base.crypt.SecureCryptTools.getInstance().decrypt(query.getBlob(1));
                        if (i == 1) {
                            try {
                                this.c = new java.lang.String(decrypt);
                            } catch (java.lang.Throwable th) {
                                com.getui.gs.h.b.a.a.a.w(th);
                            }
                        } else if (i == 50) {
                            this.a = new java.lang.String(decrypt);
                        } else if (i == 51) {
                            this.b = new java.lang.String(decrypt);
                        } else if (this.d.containsKey(java.lang.Integer.valueOf(i))) {
                            this.d.put(java.lang.Integer.valueOf(i), java.lang.Long.valueOf(java.lang.Long.parseLong(new java.lang.String(decrypt))));
                        } else {
                            com.getui.gs.h.b.a.a.a.w("key not parser : ".concat(java.lang.String.valueOf(i)));
                        }
                    } finally {
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (java.lang.Exception e) {
            com.getui.gs.h.b.a.a.a.w(e);
        }
        if (a() == -1) {
            a(3, java.lang.System.currentTimeMillis());
            com.getui.gs.a.d.a = 1;
        }
        if (b() == -1) {
            a(31, java.lang.System.currentTimeMillis());
        }
    }
}
