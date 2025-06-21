package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class u3 extends com.zx.a.I8b7.c {
    public android.database.sqlite.SQLiteDatabase b = null;

    @Override // com.zx.a.I8b7.c
    public java.lang.String a() {
        return "CREATE TABLE IF NOT EXISTS zx_table (key integer primary key, value text)";
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004c, code lost:
    
        if (r2 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0056, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
    
        if (r2 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String a(int i) {
        java.lang.String str = "";
        android.database.Cursor cursor = null;
        try {
            java.lang.String concat = "key=".concat(java.lang.String.valueOf(i));
            cursor = b().query(c(), new java.lang.String[]{"key", "value"}, concat, null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                str = cursor.getString(cursor.getColumnIndex("value"));
                str = new java.lang.String(com.zx.a.I8b7.p.a("AES/CBC/PKCS5Padding", com.zx.a.I8b7.m3.v, com.zx.a.I8b7.m3.w, android.util.Base64.decode(str, 0)), java.nio.charset.StandardCharsets.UTF_8);
            }
        } catch (java.lang.Throwable th) {
            try {
                com.zx.a.I8b7.r2.a(th);
            } catch (java.lang.Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0046, code lost:
    
        if (r2 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0053, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public org.json.JSONObject a(javax.crypto.spec.IvParameterSpec ivParameterSpec, javax.crypto.SecretKey secretKey) {
        android.database.Cursor cursor;
        try {
            cursor = b().query("zx_table", new java.lang.String[]{"key", "value"}, "key=18", null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(com.zx.a.I8b7.p.a("AES/CBC/PKCS5Padding", secretKey, ivParameterSpec, android.util.Base64.decode(cursor.getString(cursor.getColumnIndex("value")), 0)), java.nio.charset.StandardCharsets.UTF_8));
                        cursor.close();
                        return jSONObject;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        com.zx.a.I8b7.r2.a(th);
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public final void a(int i, java.lang.String str, boolean z) {
        java.lang.String str2;
        if (this.b == null) {
            this.b = d();
        }
        if (z) {
            try {
                str2 = new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.p.b("AES/CBC/PKCS5Padding", com.zx.a.I8b7.m3.v, com.zx.a.I8b7.m3.w, str.getBytes()), 0), java.nio.charset.StandardCharsets.UTF_8);
            } catch (java.lang.Exception e) {
                com.zx.a.I8b7.r2.b("ZXID updateDBValue valueID:" + i + ",value:" + str + ",error:" + e.toString());
                return;
            }
        } else {
            str2 = str;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("key", java.lang.Integer.valueOf(i));
        contentValues.put("value", str2);
        com.zx.a.I8b7.r2.a("replace resultId = ".concat(java.lang.String.valueOf(this.b.replace("zx_table", null, contentValues))));
    }

    @Override // com.zx.a.I8b7.c
    public void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.zx.a.I8b7.r2.a("ZXID数据库升级, drop zx_table表");
        try {
            sQLiteDatabase.execSQL("drop table if exists zx_table");
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.r2.a(e);
        }
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS zx_table (key integer primary key, value text)");
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void a(java.lang.String str) {
        javax.crypto.spec.IvParameterSpec g;
        javax.crypto.SecretKey i;
        org.json.JSONObject a;
        android.database.Cursor cursor = null;
        try {
            g = g();
            i = i();
            a = a(g, i);
        } catch (java.lang.Throwable th) {
            try {
                com.zx.a.I8b7.r2.a(th);
                if (cursor == null) {
                    return;
                }
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
        if (a == null) {
            return;
        }
        java.lang.String string = a.getString("mainVersion");
        java.lang.String string2 = a.getString("checksum");
        if (android.text.TextUtils.equals(string, str)) {
            cursor = b().query("zx_table", new java.lang.String[]{"key", "value"}, "key=17", null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                byte[] a2 = com.zx.a.I8b7.p.a("AES/CBC/PKCS5Padding", i, g, android.util.Base64.decode(cursor.getString(cursor.getColumnIndex("value")), 0));
                if (!android.text.TextUtils.equals(string2, com.zx.a.I8b7.p.a("SHA256", a2))) {
                    throw new java.io.IOException("zx checksum1 exception");
                }
                a(str, a2);
            }
            if (cursor == null) {
            }
        }
    }

    public final void a(java.lang.String str, byte[] bArr) throws java.lang.Exception {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        java.io.File file = new java.io.File(com.zx.a.I8b7.m3.a.getFilesDir().getAbsolutePath() + java.io.File.separator + "zx-core-" + str + ".zip");
        if (!file.createNewFile()) {
            throw new java.io.IOException("zx createNewFile exception");
        }
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file, true);
        byte[] bArr2 = new byte[2048];
        while (true) {
            int read = byteArrayInputStream.read(bArr2);
            if (read == -1) {
                fileOutputStream.close();
                byteArrayInputStream.close();
                return;
            }
            fileOutputStream.write(bArr2, 0, read);
        }
    }

    public void a(byte[] bArr) {
        java.lang.String str = new java.lang.String(android.util.Base64.encode(bArr, 0), java.nio.charset.StandardCharsets.UTF_8);
        a(9, str, false);
        com.zx.a.I8b7.r2.a("ZXID saveSecretKey secretStr:".concat(str));
    }

    public void b(int i) {
        if (i != com.zx.a.I8b7.m3.r) {
            com.zx.a.I8b7.m3.r = i;
            com.zx.a.I8b7.m3.t = -1;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.zx.a.I8b7.m3.r);
            a(14, sb.toString(), false);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(com.zx.a.I8b7.m3.t);
            a(7, sb2.toString(), false);
        }
    }

    @Override // com.zx.a.I8b7.c
    public java.lang.String c() {
        return "zx_table";
    }

    public void c(int i) {
        if (i != com.zx.a.I8b7.m3.t) {
            com.zx.a.I8b7.m3.t = i;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.zx.a.I8b7.m3.t);
            a(7, sb.toString(), false);
        }
    }

    public void d(int i) {
        if (i != com.zx.a.I8b7.m3.n) {
            com.zx.a.I8b7.m3.n = i;
            com.zx.a.I8b7.u3 u3Var = com.zx.a.I8b7.l2.a.a.a;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.zx.a.I8b7.m3.n);
            u3Var.a(3, sb.toString(), false);
            com.zx.a.I8b7.r2.a("syncId had changed refresh:".concat(java.lang.String.valueOf(i)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
    
        return com.zx.a.I8b7.m3.f490s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
    
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e() {
        android.database.Cursor cursor = null;
        try {
            cursor = b().query(c(), new java.lang.String[]{"key", "value"}, "key=20", null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                com.zx.a.I8b7.m3.f490s = java.lang.Integer.parseInt(cursor.getString(cursor.getColumnIndex("value")));
            }
        } catch (java.lang.Throwable th) {
            try {
                com.zx.a.I8b7.r2.a(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
    
        return com.zx.a.I8b7.m3.r;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
    
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int f() {
        android.database.Cursor cursor = null;
        try {
            cursor = b().query(c(), new java.lang.String[]{"key", "value"}, "key=14", null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                com.zx.a.I8b7.m3.r = java.lang.Integer.parseInt(cursor.getString(cursor.getColumnIndex("value")));
            }
        } catch (java.lang.Throwable th) {
            try {
                com.zx.a.I8b7.r2.a(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r2 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0039, code lost:
    
        if (r2 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0047, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0044, code lost:
    
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public javax.crypto.spec.IvParameterSpec g() {
        android.database.Cursor cursor;
        javax.crypto.spec.IvParameterSpec ivParameterSpec = null;
        try {
            cursor = b().query(c(), new java.lang.String[]{"key", "value"}, "key=10", null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        ivParameterSpec = new javax.crypto.spec.IvParameterSpec(android.util.Base64.decode(cursor.getString(cursor.getColumnIndex("value")), 0));
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        com.zx.a.I8b7.r2.a(th);
                    } catch (java.lang.Throwable th2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th2;
                    }
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
    
        return com.zx.a.I8b7.m3.t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
    
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int h() {
        android.database.Cursor cursor = null;
        try {
            cursor = b().query(c(), new java.lang.String[]{"key", "value"}, "key=7", null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                com.zx.a.I8b7.m3.t = java.lang.Integer.parseInt(cursor.getString(cursor.getColumnIndex("value")));
            }
        } catch (java.lang.Throwable th) {
            try {
                com.zx.a.I8b7.r2.a(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (r2 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x003d, code lost:
    
        if (r2 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x004b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0048, code lost:
    
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public javax.crypto.SecretKey i() {
        android.database.Cursor cursor;
        javax.crypto.spec.SecretKeySpec secretKeySpec = null;
        try {
            cursor = b().query(c(), new java.lang.String[]{"key", "value"}, "key=9", null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        byte[] decode = android.util.Base64.decode(cursor.getString(cursor.getColumnIndex("value")), 0);
                        java.security.SecureRandom secureRandom = com.zx.a.I8b7.p.a;
                        secretKeySpec = new javax.crypto.spec.SecretKeySpec(decode, "AES");
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        com.zx.a.I8b7.r2.a(th);
                    } catch (java.lang.Throwable th2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th2;
                    }
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            cursor = null;
        }
    }
}
