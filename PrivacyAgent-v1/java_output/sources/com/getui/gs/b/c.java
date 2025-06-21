package com.getui.gs.b;

/* loaded from: classes22.dex */
public class c extends com.getui.gtc.base.db.AbstractTable {
    private com.getui.gs.d.a a(android.database.Cursor cursor) {
        com.getui.gs.d.a aVar = new com.getui.gs.d.a();
        try {
            aVar.a = cursor.getInt(cursor.getColumnIndex("id"));
            aVar.b = cursor.getString(cursor.getColumnIndex("i"));
            aVar.c = java.lang.Long.parseLong(cursor.getString(cursor.getColumnIndex("t")));
            int parseInt = java.lang.Integer.parseInt(cursor.getString(cursor.getColumnIndex("y")));
            com.getui.gs.d.a.EnumC0289a[] values = com.getui.gs.d.a.EnumC0289a.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.getui.gs.d.a.EnumC0289a enumC0289a = values[i];
                if (enumC0289a.ordinal() == parseInt) {
                    aVar.d = enumC0289a;
                    break;
                }
                i++;
            }
            aVar.f = cursor.getString(cursor.getColumnIndex("s"));
            aVar.g = cursor.getString(cursor.getColumnIndex("f"));
            aVar.a(cursor.getString(cursor.getColumnIndex("e")));
            aVar.a(new org.json.JSONObject(new java.lang.String(android.util.Base64.decode(cursor.getString(cursor.getColumnIndex("p")), 0))));
            aVar.i = new org.json.JSONObject(cursor.getString(cursor.getColumnIndex("inn")));
            return aVar;
        } catch (java.lang.Throwable unused) {
            com.getui.gs.h.b.a.a.a.e("removed invalid offline event: id = " + aVar.a + ", eventId = " + aVar.b);
            a(aVar.a);
            return null;
        }
    }

    private boolean a(long j) {
        try {
            return delete("id=?", new java.lang.String[]{java.lang.String.valueOf(j)}) > 0;
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
            return false;
        }
    }

    private long b(com.getui.gs.d.a aVar) {
        try {
            e();
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("i", aVar.b);
            contentValues.put("t", java.lang.String.valueOf(aVar.c));
            contentValues.put("y", java.lang.String.valueOf(aVar.d.ordinal()));
            contentValues.put("s", aVar.f);
            contentValues.put("f", aVar.g);
            contentValues.put("e", aVar.h);
            contentValues.put("p", android.util.Base64.encodeToString(aVar.e.toString().getBytes(), 0));
            contentValues.put("inn", aVar.i.toString());
            return insert(contentValues);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
            return -1L;
        }
    }

    private synchronized void e() {
        try {
            android.database.Cursor query = getReadableDatabase().query(getTableName(), new java.lang.String[]{"COUNT(*)"}, null, null, null, null, null);
            query.moveToNext();
            long j = query.getLong(0);
            query.close();
            long h = j - com.getui.gs.ias.core.a.h();
            if (h > 0) {
                getWritableDatabase().delete(getTableName(), "id IN(SELECT id FROM " + getTableName() + " ORDER BY t ASC LIMIT " + h + ")", null);
                com.getui.gs.h.b.a.a.a.d("delete old expired event from event table");
            }
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
    }

    public final long a() {
        android.database.Cursor cursor = null;
        try {
            cursor = getReadableDatabase().query(getTableName(), new java.lang.String[]{"COUNT(*)"}, "y IN(" + (com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL.ordinal() + ", " + com.getui.gs.d.a.EnumC0289a.TYPE_DURATION.ordinal()) + ")", null, null, null, null);
            cursor.moveToNext();
            long j = cursor.getLong(0);
            cursor.close();
            return j;
        } catch (java.lang.Throwable th) {
            try {
                com.getui.gs.h.b.a.a.a.e(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    public final void a(com.getui.gs.d.a aVar) {
        java.lang.String f;
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            org.json.JSONObject jSONObject = aVar.i;
            if (jSONObject == null) {
                jSONObject = new org.json.JSONObject();
                aVar.i = jSONObject;
            }
            com.getui.gs.d.a.EnumC0289a enumC0289a = aVar.d;
            if (enumC0289a == com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE) {
                f = com.getui.gs.g.c.g();
            } else {
                if (enumC0289a != com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL && enumC0289a != com.getui.gs.d.a.EnumC0289a.TYPE_DURATION) {
                    throw new java.lang.IllegalArgumentException("eventData illegal type : ".concat(java.lang.String.valueOf(enumC0289a)));
                }
                f = com.getui.gs.g.c.f();
            }
            jSONObject.put(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL, f);
            b(aVar);
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
            java.lang.StringBuilder sb = new java.lang.StringBuilder("id IN (");
            sb.append(str);
            sb.append(")");
            return writableDatabase.delete(tableName, sb.toString(), null) > 0;
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
            return false;
        }
    }

    public final java.util.List<com.getui.gs.d.a> b() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursor = null;
        try {
            java.lang.String str = com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL.ordinal() + ", " + com.getui.gs.d.a.EnumC0289a.TYPE_DURATION.ordinal();
            cursor = getReadableDatabase().query(getTableName(), null, "y IN(" + str + ")", null, null, null, null);
            while (cursor.moveToNext()) {
                com.getui.gs.d.a a = a(cursor);
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

    public final long c() {
        android.database.Cursor cursor = null;
        try {
            cursor = getReadableDatabase().query(getTableName(), new java.lang.String[]{"COUNT(*)"}, "y=".concat(java.lang.String.valueOf(java.lang.String.valueOf(com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE.ordinal()))), null, null, null, null);
            cursor.moveToNext();
            long j = cursor.getLong(0);
            cursor.close();
            return j;
        } catch (java.lang.Throwable th) {
            try {
                com.getui.gs.h.b.a.a.a.e(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String createSql() {
        return "CREATE TABLE IF NOT EXISTS e (id INTEGER PRIMARY KEY AUTOINCREMENT, i TEXT, t TEXT, y TEXT, s TEXT, e TEXT, f TEXT, inn TEXT, p BLOB)";
    }

    public final java.util.List<com.getui.gs.d.a> d() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursor = null;
        try {
            cursor = getReadableDatabase().query(getTableName(), null, "y =".concat(java.lang.String.valueOf(java.lang.String.valueOf(com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE.ordinal()))), null, null, null, null);
            while (cursor.moveToNext()) {
                com.getui.gs.d.a a = a(cursor);
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

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String getTableName() {
        return "e";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            com.getui.gs.b.d.a(sQLiteDatabase, getTableName(), "s TEXT");
            com.getui.gs.b.d.a(sQLiteDatabase, getTableName(), "e TEXT");
        }
        if (i < 3) {
            com.getui.gs.b.d.a(sQLiteDatabase, getTableName(), "f TEXT");
        }
        if (i < 4) {
            com.getui.gs.b.d.a(sQLiteDatabase, getTableName(), "inn TEXT");
        }
    }
}
