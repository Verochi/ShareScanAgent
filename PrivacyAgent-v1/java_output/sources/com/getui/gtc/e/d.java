package com.getui.gtc.e;

/* loaded from: classes22.dex */
public class d extends com.getui.gtc.base.db.AbstractTable {
    public java.lang.String a;
    public java.lang.String b;
    public long c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public long j;
    public long k;
    public long l;
    public long m;
    public final java.util.Set<java.lang.String> n = new java.util.HashSet();

    private java.lang.String b() {
        android.database.Cursor cursor = null;
        try {
            cursor = getReadableDatabase().query("r", new java.lang.String[]{"a", "b"}, "a=?", new java.lang.String[]{"18"}, null, null, null);
        } catch (java.lang.Throwable th) {
            try {
                com.getui.gtc.h.c.a.b(th);
                if (cursor == null) {
                    return "";
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (cursor == null || !cursor.moveToNext()) {
            if (cursor == null) {
                return "";
            }
            return "";
        }
        java.lang.String string = cursor.getString(1);
        cursor.close();
        return string;
    }

    public final org.json.JSONObject a() {
        try {
            java.lang.String b = b();
            if (android.text.TextUtils.isEmpty(b)) {
                return null;
            }
            return new org.json.JSONObject(new java.lang.String(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().decrypt(android.util.Base64.decode(b, 0))));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
            return null;
        }
    }

    public final void a(java.lang.String str) {
        if (a(10, str)) {
            this.f = str;
        }
    }

    public final void a(java.util.Collection<java.lang.String> collection) {
        if (collection.size() <= 0) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.n);
        arrayList.addAll(collection);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append((java.lang.String) arrayList.get(i));
            if (i < size - 1) {
                sb.append(",");
            }
        }
        if (a(8, sb.toString())) {
            this.n.addAll(collection);
        }
    }

    public final void a(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    a(18, android.util.Base64.encodeToString(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().encrypt(jSONObject.toString().getBytes()), 0));
                    return;
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.h.c.a.c(th);
                return;
            }
        }
        a(18, "");
    }

    public final boolean a(int i, long j) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("a", java.lang.Integer.valueOf(i));
        contentValues.put("b", java.lang.Long.valueOf(j));
        return replace(null, contentValues) != -1;
    }

    public final boolean a(int i, java.lang.String str) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("a", java.lang.Integer.valueOf(i));
        contentValues.put("b", str);
        return replace(null, contentValues) != -1;
    }

    public final void b(java.lang.String str) {
        try {
            if (a(11, android.util.Base64.encodeToString(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().encrypt(str.getBytes()), 0))) {
                this.g = str;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
        }
    }

    public final void c(java.lang.String str) {
        try {
            if (a(12, android.util.Base64.encodeToString(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().encrypt(str.getBytes()), 0))) {
                this.h = str;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
        }
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String createSql() {
        return "CREATE TABLE IF NOT EXISTS r (a TEXT PRIMARY KEY, b TEXT)";
    }

    public final void d(java.lang.String str) {
        if (a(7, str)) {
            this.a = str;
        }
    }

    public final void e(java.lang.String str) {
        if (a(20, str)) {
            this.b = str;
        }
    }

    public final void f(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || !this.n.contains(str)) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.n);
        arrayList.remove(str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append((java.lang.String) arrayList.get(i));
            if (i < size - 1) {
                sb.append(",");
            }
        }
        if (a(8, sb.toString())) {
            this.n.remove(str);
        }
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String getTableName() {
        return "r";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public void initCache() {
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = getReadableDatabase().query("r", new java.lang.String[]{"a", "b"}, null, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        switch (cursor.getInt(0)) {
                            case 4:
                                this.d = cursor.getString(1);
                                break;
                            case 6:
                                this.c = cursor.getLong(1);
                                break;
                            case 7:
                                this.a = cursor.getString(1);
                                break;
                            case 8:
                                java.lang.String string = cursor.getString(1);
                                if (!android.text.TextUtils.isEmpty(string)) {
                                    this.n.addAll(java.util.Arrays.asList(string.split(",")));
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                this.e = cursor.getString(1);
                                break;
                            case 10:
                                this.f = cursor.getString(1);
                                break;
                            case 11:
                                try {
                                    java.lang.String string2 = cursor.getString(1);
                                    if (!android.text.TextUtils.isEmpty(string2)) {
                                        this.g = new java.lang.String(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().decrypt(android.util.Base64.decode(string2, 0)));
                                    }
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    com.getui.gtc.h.c.a.c(th);
                                }
                            case 12:
                                try {
                                    java.lang.String string3 = cursor.getString(1);
                                    if (!android.text.TextUtils.isEmpty(string3)) {
                                        this.h = new java.lang.String(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().decrypt(android.util.Base64.decode(string3, 0)));
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    com.getui.gtc.h.c.a.c(th);
                                }
                            case 13:
                                try {
                                    java.lang.String string4 = cursor.getString(1);
                                    if (!android.text.TextUtils.isEmpty(string4)) {
                                        this.i = new java.lang.String(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().decrypt(android.util.Base64.decode(string4, 0)));
                                    }
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    com.getui.gtc.h.c.a.c(th);
                                }
                            case 14:
                                this.j = cursor.getLong(1);
                                break;
                            case 15:
                                this.k = cursor.getLong(1);
                                break;
                            case 16:
                                this.l = cursor.getLong(1);
                                break;
                            case 19:
                                this.m = cursor.getLong(1);
                                this.l = cursor.getLong(1);
                                break;
                            case 20:
                                this.b = cursor.getString(1);
                                break;
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (java.lang.Exception e) {
                com.getui.gtc.h.c.a.b(e);
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (java.lang.Throwable th4) {
            if (cursor != null) {
                cursor.close();
            }
            throw th4;
        }
    }
}
