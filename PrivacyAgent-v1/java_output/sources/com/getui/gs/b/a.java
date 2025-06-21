package com.getui.gs.b;

/* loaded from: classes22.dex */
public class a extends com.getui.gtc.base.db.AbstractTable {
    private com.getui.gs.g.a a(android.database.Cursor cursor) {
        com.getui.gs.g.a aVar = new com.getui.gs.g.a();
        try {
            aVar.a = cursor.getInt(cursor.getColumnIndex("a"));
            aVar.c = java.lang.Integer.parseInt(cursor.getString(cursor.getColumnIndex("b")));
            aVar.b = java.lang.Long.parseLong(cursor.getString(cursor.getColumnIndex("c")));
            aVar.d = cursor.getString(cursor.getColumnIndex("s"));
            aVar.e = java.lang.Long.parseLong(cursor.getString(cursor.getColumnIndex("ts")));
            aVar.f = java.lang.Long.parseLong(cursor.getString(cursor.getColumnIndex("te")));
            return aVar;
        } catch (java.lang.Throwable unused) {
            com.getui.gs.h.b.a.a.a.e("removed invalid offline active data: id = " + aVar.a + ", type = " + aVar.c);
            a(aVar.a);
            return null;
        }
    }

    private com.getui.gs.g.a a(java.lang.String str, int i) {
        try {
            android.database.Cursor query = getReadableDatabase().query(getTableName(), null, "s=? and b=?", new java.lang.String[]{str, java.lang.String.valueOf(i)}, null, null, null);
            try {
                if (!query.moveToNext()) {
                    query.close();
                    return null;
                }
                com.getui.gs.g.a a = a(query);
                query.close();
                return a;
            } finally {
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.getui.gs.h.b.a.a.a.e(th);
            return null;
        }
    }

    private boolean a(long j) {
        try {
            return delete("a=?", new java.lang.String[]{java.lang.String.valueOf(j)}) > 0;
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
            return false;
        }
    }

    private synchronized void b(long j) {
        try {
            delete("ts<?", new java.lang.String[]{java.lang.String.valueOf(j)});
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
    }

    public final long a(com.getui.gs.g.a aVar, long j) {
        try {
            b(j);
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("b", java.lang.Integer.valueOf(aVar.c));
            contentValues.put("c", java.lang.Long.valueOf(aVar.b));
            contentValues.put("s", aVar.d);
            contentValues.put("ts", java.lang.Long.valueOf(aVar.e));
            contentValues.put("te", java.lang.Long.valueOf(aVar.f));
            com.getui.gs.g.a a = a(aVar.d, aVar.c);
            if (a == null) {
                return insert(contentValues);
            }
            update(contentValues, "a=?", new java.lang.String[]{java.lang.String.valueOf(a.a)});
            return -1L;
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
            return -1L;
        }
    }

    public final java.util.List<com.getui.gs.g.a> a() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            android.database.Cursor query = query(null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    com.getui.gs.g.a a = a(query);
                    if (a != null) {
                        arrayList.add(a);
                    }
                } finally {
                }
            }
            query.close();
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
        return arrayList;
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String createSql() {
        return "CREATE TABLE IF NOT EXISTS avt (a INTEGER PRIMARY KEY AUTOINCREMENT, b TEXT, c TEXT, s TEXT, ts TEXT, te TEXT)";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String getTableName() {
        return "avt";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i <= 3) {
            try {
                sQLiteDatabase.execSQL(createSql());
            } catch (java.lang.Throwable th) {
                com.getui.gs.h.b.a.a.a.e(th);
            }
        }
    }
}
