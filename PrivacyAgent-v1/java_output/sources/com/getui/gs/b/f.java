package com.getui.gs.b;

/* loaded from: classes22.dex */
public class f extends com.getui.gtc.base.db.AbstractTable {
    private com.getui.gs.g.e a(android.database.Cursor cursor) {
        com.getui.gs.g.e eVar = new com.getui.gs.g.e();
        try {
            eVar.a = cursor.getInt(cursor.getColumnIndex("a"));
            eVar.c = java.lang.Integer.parseInt(cursor.getString(cursor.getColumnIndex("b")));
            eVar.b = java.lang.Long.parseLong(cursor.getString(cursor.getColumnIndex("c")));
            eVar.e = cursor.getString(cursor.getColumnIndex("s"));
            eVar.f = cursor.getString(cursor.getColumnIndex("e"));
            eVar.g = cursor.getString(cursor.getColumnIndex("f"));
            eVar.h = cursor.getString(cursor.getColumnIndex("g"));
            eVar.i = cursor.getString(cursor.getColumnIndex("h"));
            eVar.j = cursor.getString(cursor.getColumnIndex("i"));
            eVar.d = cursor.getString(cursor.getColumnIndex("d"));
            eVar.a(new org.json.JSONObject(cursor.getString(cursor.getColumnIndex("inn"))));
            return eVar;
        } catch (java.lang.Throwable unused) {
            com.getui.gs.h.b.a.a.a.e("removed invalid offline data: id = " + eVar.a + ", type = " + eVar.c);
            a(eVar.a);
            return null;
        }
    }

    private synchronized void a() {
        try {
            android.database.Cursor query = getReadableDatabase().query(getTableName(), new java.lang.String[]{"COUNT(*)"}, null, null, null, null, null);
            query.moveToNext();
            long j = query.getLong(0);
            query.close();
            long h = j - com.getui.gs.ias.core.a.h();
            if (h > 0) {
                getWritableDatabase().delete(getTableName(), "a IN(SELECT a FROM " + getTableName() + " ORDER BY c ASC LIMIT " + h + ")", null);
                com.getui.gs.h.b.a.a.a.d("delete old expired type data from type data table");
            }
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
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

    private long b(com.getui.gs.g.e eVar) {
        try {
            a();
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("b", java.lang.String.valueOf(eVar.c));
            contentValues.put("c", java.lang.String.valueOf(eVar.b));
            contentValues.put("s", eVar.e);
            contentValues.put("e", eVar.f);
            contentValues.put("f", eVar.g);
            contentValues.put("g", eVar.h);
            contentValues.put("h", eVar.i);
            contentValues.put("i", eVar.j);
            contentValues.put("d", eVar.d);
            contentValues.put("inn", eVar.k.toString());
            return insert(contentValues);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
            return -1L;
        }
    }

    public final long a(com.getui.gs.g.e eVar, com.getui.gs.g.e eVar2) {
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("b", java.lang.String.valueOf(eVar2.c));
            contentValues.put("c", java.lang.String.valueOf(eVar2.b));
            contentValues.put("s", eVar2.e);
            contentValues.put("e", eVar2.f);
            contentValues.put("f", eVar2.g);
            contentValues.put("g", eVar2.h);
            contentValues.put("h", eVar2.i);
            contentValues.put("i", eVar2.j);
            contentValues.put("d", eVar2.d);
            contentValues.put("inn", eVar.k.toString());
            java.lang.String str = eVar.d;
            java.lang.String str2 = eVar2.d;
            java.lang.String[] split = str.split("\\|");
            java.lang.String[] split2 = str2.split("\\|");
            java.lang.String str3 = split2[0] + "|" + split[1] + "|" + split2[2];
            eVar2.d = str3;
            contentValues.put("d", str3);
            return update(contentValues, "a=?", new java.lang.String[]{java.lang.String.valueOf(eVar.a)});
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
            return -1L;
        }
    }

    public final com.getui.gs.g.e a(java.lang.String str, int i) {
        try {
            android.database.Cursor query = getReadableDatabase().query(getTableName(), null, "s=? and b=?", new java.lang.String[]{str, java.lang.String.valueOf(i)}, null, null, null);
            try {
                if (!query.moveToNext()) {
                    query.close();
                    return null;
                }
                com.getui.gs.g.e a = a(query);
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

    public final java.util.List<com.getui.gs.g.e> a(int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursor = null;
        try {
            cursor = getReadableDatabase().query(getTableName(), null, "b =".concat(java.lang.String.valueOf(i)), null, null, null, null);
            while (cursor.moveToNext()) {
                com.getui.gs.g.e a = a(cursor);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                com.getui.gs.h.b.a.a.a.e(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return arrayList;
    }

    public final void a(com.getui.gs.g.e eVar) {
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            int i = eVar.c;
            if (i == 8) {
                jSONObject.put(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL, com.getui.gs.g.c.d());
                jSONObject.put("s11", com.getui.gs.h.e.a());
            } else {
                if (i != 11) {
                    throw new java.lang.IllegalArgumentException("typeData illegal type : ".concat(java.lang.String.valueOf(i)));
                }
                jSONObject.put(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL, com.getui.gs.g.c.e());
            }
            eVar.a(jSONObject);
            b(eVar);
            writableDatabase.setTransactionSuccessful();
        } catch (java.lang.Throwable th) {
            try {
                com.getui.gs.h.b.a.a.a.e(th);
            } finally {
                writableDatabase.endTransaction();
            }
        }
    }

    public final boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            java.lang.String tableName = getTableName();
            java.lang.StringBuilder sb = new java.lang.StringBuilder("a IN (");
            sb.append(str);
            sb.append(")");
            return writableDatabase.delete(tableName, sb.toString(), null) > 0;
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
            return false;
        }
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String createSql() {
        return "CREATE TABLE IF NOT EXISTS t (a INTEGER PRIMARY KEY AUTOINCREMENT, b TEXT, c TEXT, s TEXT, e TEXT, f TEXT, g TEXT, h TEXT, i TEXT, j TEXT, inn TEXT, d TEXT)";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String getTableName() {
        return "t";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            com.getui.gs.b.d.a(sQLiteDatabase, getTableName(), "s TEXT ");
        }
        if (i < 3) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add("e TEXT ");
            arrayList.add("f TEXT ");
            arrayList.add("g TEXT ");
            arrayList.add("h TEXT ");
            arrayList.add("i TEXT ");
            com.getui.gs.b.d.a(sQLiteDatabase, getTableName(), arrayList);
        }
        if (i < 4) {
            com.getui.gs.b.d.a(sQLiteDatabase, getTableName(), "inn TEXT ");
        }
    }
}
