package com.getui.gtc.dim.a;

/* loaded from: classes22.dex */
public class b extends com.getui.gtc.base.db.AbstractTable {
    public final com.getui.gtc.dim.b.h a(java.lang.String str) {
        com.getui.gtc.dim.b.h hVar;
        android.database.Cursor cursor = null;
        r2 = null;
        com.getui.gtc.dim.b.h hVar2 = null;
        try {
            android.database.Cursor query = getReadableDatabase().query("d", new java.lang.String[]{"t", "b"}, "a=?", new java.lang.String[]{java.lang.String.valueOf(str)}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        java.lang.String string = query.getString(query.getColumnIndex("b"));
                        hVar = new com.getui.gtc.dim.b.h(null, query.getLong(query.getColumnIndex("t")));
                        try {
                            if (!android.text.TextUtils.isEmpty(string)) {
                                if (string.equals("-1")) {
                                    java.io.File file = new java.io.File(com.getui.gtc.base.GtcProvider.context().getCacheDir(), com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", (str + com.umeng.analytics.process.a.d).getBytes()));
                                    if (file.exists()) {
                                        string = new java.lang.String(com.getui.gtc.dim.e.c.a(file));
                                    }
                                }
                                hVar.a = com.getui.gtc.dim.e.c.a(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().decrypt(android.util.Base64.decode(string, 0)));
                            }
                            hVar2 = hVar;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            cursor = query;
                            try {
                                com.getui.gtc.dim.e.b.a(th);
                                return hVar;
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    hVar = null;
                }
            }
            if (query == null) {
                return hVar2;
            }
            query.close();
            return hVar2;
        } catch (java.lang.Throwable th3) {
            th = th3;
            hVar = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066 A[Catch: all -> 0x00ec, TRY_ENTER, TryCatch #1 {all -> 0x00ec, blocks: (B:47:0x003d, B:49:0x0043, B:6:0x005a, B:13:0x0066, B:16:0x0089, B:18:0x008f, B:20:0x0094, B:23:0x0097, B:26:0x00d4), top: B:46:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        java.lang.String string;
        java.lang.String str = android.os.Build.BRAND + "#" + android.os.Build.VERSION.SDK_INT + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + android.os.Build.VERSION.RELEASE;
        android.database.Cursor cursor = null;
        try {
            android.database.Cursor query = query(new java.lang.String[]{"a", "t", "b"}, "a=?", new java.lang.String[]{"dim-key-android-rom-version"});
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        string = query.getString(query.getColumnIndex("b"));
                        com.getui.gtc.dim.e.b.a("dim storage query dbRomVersion = ".concat(java.lang.String.valueOf(string)));
                        if (!str.equals(string)) {
                            if (query != null) {
                                query.close();
                                return;
                            }
                            return;
                        }
                        com.getui.gtc.dim.e.b.a("dim storage will delete parcelable data");
                        java.lang.String[] strArr = {com.getui.gtc.extension.distribution.gbd.f.e.b.E, com.getui.gtc.extension.distribution.gbd.f.e.b.F, com.getui.gtc.extension.distribution.gbd.f.e.b.A, com.getui.gtc.extension.distribution.gbd.f.e.b.B, com.getui.gtc.extension.distribution.gbd.f.e.b.L, com.getui.gtc.extension.distribution.gbd.f.e.b.M, com.getui.gtc.extension.distribution.gbd.f.e.b.O, com.getui.gtc.extension.distribution.gbd.f.e.b.K};
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (int i = 0; i < 8; i++) {
                            sb.append("a=?");
                            if (i != 7) {
                                sb.append(" or ");
                            }
                        }
                        android.content.ContentValues contentValues = new android.content.ContentValues();
                        contentValues.put("b", "");
                        update(contentValues, sb.toString(), strArr);
                        android.content.ContentValues contentValues2 = new android.content.ContentValues();
                        contentValues2.put("a", "dim-key-android-rom-version");
                        contentValues2.put("t", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                        contentValues2.put("b", str);
                        long replace = replace(null, contentValues2);
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("dim storage update dbRomVersion ");
                        sb2.append(replace != -1 ? "success" : com.alipay.sdk.m.u.h.j);
                        sb2.append(",currentRomVersion = ");
                        sb2.append(str);
                        com.getui.gtc.dim.e.b.a(sb2.toString());
                        if (query != null) {
                            query.close();
                            return;
                        }
                        return;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    cursor = query;
                    try {
                        com.getui.gtc.dim.e.b.a(new java.lang.Exception("dim storage delete parcelable data failed: currentRomVersion = ".concat(java.lang.String.valueOf(str)), th));
                        if (cursor != null) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            string = null;
            if (!str.equals(string)) {
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final boolean a(java.lang.String str, java.lang.Object obj) {
        java.lang.String str2;
        try {
            try {
                str2 = android.util.Base64.encodeToString(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().encrypt(com.getui.gtc.dim.e.c.b(obj)), 0);
                if (str2.length() > 5120) {
                    com.getui.gtc.dim.e.c.a(str2.getBytes(), new java.io.File(com.getui.gtc.base.GtcProvider.context().getCacheDir(), com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", (str + com.umeng.analytics.process.a.d).getBytes())));
                    str2 = "-1";
                }
            } catch (java.lang.Throwable unused) {
                str2 = "";
                com.getui.gtc.dim.e.b.b("dim storage save failed: ".concat(java.lang.String.valueOf(obj)));
            }
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("a", str);
            contentValues.put("t", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            contentValues.put("b", str2);
            com.getui.gtc.dim.e.b.a(str + " update dim storage cache = " + str2);
            return replace(null, contentValues) != -1;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return false;
        }
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String createSql() {
        return "CREATE TABLE IF NOT EXISTS d (a TEXT PRIMARY KEY, t TEXT, b TEXT)";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String getTableName() {
        return "d";
    }
}
