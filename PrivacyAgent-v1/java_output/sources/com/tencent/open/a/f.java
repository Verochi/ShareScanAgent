package com.tencent.open.a;

/* loaded from: classes19.dex */
public class f extends android.database.sqlite.SQLiteOpenHelper {
    protected static final java.lang.String[] a = {"key"};
    protected static com.tencent.open.a.f b;

    public f(android.content.Context context) {
        super(context, "sdk_report.db", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 2);
    }

    public static synchronized com.tencent.open.a.f a() {
        com.tencent.open.a.f fVar;
        synchronized (com.tencent.open.a.f.class) {
            if (b == null) {
                b = new com.tencent.open.a.f(com.tencent.open.utils.f.a());
            }
            fVar = b;
        }
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0077 A[Catch: all -> 0x0081, Exception -> 0x0084, TRY_ENTER, TryCatch #15 {Exception -> 0x0084, all -> 0x0081, blocks: (B:22:0x0030, B:24:0x0036, B:25:0x0039, B:31:0x0053, B:33:0x0056, B:35:0x0077, B:36:0x007a, B:67:0x0062, B:60:0x0065, B:61:0x0068, B:53:0x006c, B:48:0x006f), top: B:21:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized java.util.List<java.io.Serializable> a(java.lang.String str) {
        java.io.ObjectInputStream objectInputStream;
        java.io.Serializable serializable;
        java.util.List<java.io.Serializable> synchronizedList = java.util.Collections.synchronizedList(new java.util.ArrayList());
        if (android.text.TextUtils.isEmpty(str)) {
            return synchronizedList;
        }
        android.database.sqlite.SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return synchronizedList;
        }
        android.database.Cursor cursor = null;
        java.io.ObjectInputStream objectInputStream2 = null;
        cursor = null;
        try {
            try {
                android.database.Cursor query = readableDatabase.query("via_cgi_report", null, "type = ?", new java.lang.String[]{str}, null, null, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            query.moveToFirst();
                            do {
                                java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(query.getBlob(query.getColumnIndex("blob")));
                                try {
                                    objectInputStream = new java.io.ObjectInputStream(byteArrayInputStream);
                                    try {
                                        serializable = (java.io.Serializable) objectInputStream.readObject();
                                        try {
                                            objectInputStream.close();
                                        } catch (java.io.IOException unused) {
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                        } catch (java.io.IOException unused2) {
                                        }
                                    } catch (java.lang.Exception unused3) {
                                        if (objectInputStream != null) {
                                            try {
                                                objectInputStream.close();
                                            } catch (java.io.IOException unused4) {
                                            }
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                        } catch (java.io.IOException unused5) {
                                        }
                                        serializable = null;
                                        if (serializable != null) {
                                        }
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        objectInputStream2 = objectInputStream;
                                        if (objectInputStream2 != null) {
                                            try {
                                                objectInputStream2.close();
                                            } catch (java.io.IOException unused6) {
                                            }
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                            throw th;
                                        } catch (java.io.IOException unused7) {
                                            throw th;
                                        }
                                    }
                                } catch (java.lang.Exception unused8) {
                                    objectInputStream = null;
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                }
                                if (serializable != null) {
                                    synchronizedList.add(serializable);
                                }
                            } while (query.moveToNext());
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        cursor = query;
                        com.tencent.open.log.SLog.e("openSDK_LOG.ReportDatabaseHelper", "getReportItemFromDB has exception.", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        readableDatabase.close();
                        return synchronizedList;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        readableDatabase.close();
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (java.lang.Exception e2) {
                e = e2;
            }
            readableDatabase.close();
            return synchronizedList;
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
    }

    public synchronized void a(java.lang.String str, java.util.List<java.io.Serializable> list) {
        java.io.ObjectOutputStream objectOutputStream;
        int size = list.size();
        if (size == 0) {
            return;
        }
        if (size > 20) {
            size = 20;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        b(str);
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        writableDatabase.beginTransaction();
        try {
            try {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                for (int i = 0; i < size; i++) {
                    java.io.Serializable serializable = list.get(i);
                    if (serializable != null) {
                        contentValues.put("type", str);
                        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(512);
                        java.io.ObjectOutputStream objectOutputStream2 = null;
                        try {
                            objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
                            try {
                                objectOutputStream.writeObject(serializable);
                                try {
                                    objectOutputStream.close();
                                } catch (java.io.IOException unused) {
                                }
                            } catch (java.io.IOException unused2) {
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                byteArrayOutputStream.close();
                                contentValues.put("blob", byteArrayOutputStream.toByteArray());
                                writableDatabase.insert("via_cgi_report", null, contentValues);
                                contentValues.clear();
                            } catch (java.lang.Throwable th) {
                                th = th;
                                objectOutputStream2 = objectOutputStream;
                                if (objectOutputStream2 != null) {
                                    try {
                                        objectOutputStream2.close();
                                    } catch (java.io.IOException unused3) {
                                    }
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (java.io.IOException unused4) {
                                    throw th;
                                }
                            }
                        } catch (java.io.IOException unused5) {
                            objectOutputStream = null;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.io.IOException unused6) {
                        }
                        contentValues.put("blob", byteArrayOutputStream.toByteArray());
                        writableDatabase.insert("via_cgi_report", null, contentValues);
                    }
                    contentValues.clear();
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (java.lang.Throwable th3) {
                writableDatabase.endTransaction();
                writableDatabase.close();
                throw th3;
            }
        } catch (java.lang.Exception unused7) {
            com.tencent.open.log.SLog.e("openSDK_LOG.ReportDatabaseHelper", "saveReportItemToDB has exception.");
            writableDatabase.endTransaction();
        }
        writableDatabase.close();
    }

    public synchronized void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            if (writableDatabase == null) {
                return;
            }
            try {
                writableDatabase.delete("via_cgi_report", "type = ?", new java.lang.String[]{str});
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e);
            }
        } finally {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }
}
