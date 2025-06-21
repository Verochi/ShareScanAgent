package com.jd.ad.sdk.jad_mz;

/* loaded from: classes23.dex */
public class jad_an extends com.jd.ad.sdk.jad_sf.jad_an {
    public static com.jd.ad.sdk.jad_mz.jad_an jad_dq;
    public int jad_bo;
    public com.jd.ad.sdk.jad_pc.jad_an jad_cp;

    /* renamed from: com.jd.ad.sdk.jad_mz.jad_an$jad_an, reason: collision with other inner class name */
    public class RunnableC0394jad_an implements java.lang.Runnable {
        public final /* synthetic */ java.util.List jad_an;
        public final /* synthetic */ java.util.List jad_bo;

        public RunnableC0394jad_an(java.util.List list, java.util.List list2) {
            this.jad_an = list;
            this.jad_bo = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_mz.jad_an.jad_an(com.jd.ad.sdk.jad_mz.jad_an.this, this.jad_an);
            com.jd.ad.sdk.jad_mz.jad_an.jad_bo(com.jd.ad.sdk.jad_mz.jad_an.this, this.jad_bo);
        }
    }

    public class jad_bo implements java.lang.Runnable {
        public final /* synthetic */ java.util.List jad_an;
        public final /* synthetic */ java.util.List jad_bo;

        public jad_bo(java.util.List list, java.util.List list2) {
            this.jad_an = list;
            this.jad_bo = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_mz.jad_an.jad_an(com.jd.ad.sdk.jad_mz.jad_an.this, this.jad_an);
            com.jd.ad.sdk.jad_mz.jad_an.jad_bo(com.jd.ad.sdk.jad_mz.jad_an.this, this.jad_bo);
        }
    }

    public jad_an(android.content.Context context, java.lang.String str, int i) {
        super(context, str, i);
        this.jad_bo = 40;
    }

    public static synchronized com.jd.ad.sdk.jad_mz.jad_an jad_an(android.content.Context context, java.lang.String str, int i) {
        com.jd.ad.sdk.jad_mz.jad_an jad_anVar;
        synchronized (com.jd.ad.sdk.jad_mz.jad_an.class) {
            if (jad_dq == null) {
                jad_dq = new com.jd.ad.sdk.jad_mz.jad_an(context, str, i);
            }
            jad_anVar = jad_dq;
        }
        return jad_anVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        if (r8.inTransaction() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        r8 = r7.jad_an;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
    
        if (r8.inTransaction() != false) goto L32;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void jad_an(com.jd.ad.sdk.jad_mz.jad_an jad_anVar, java.util.List list) {
        synchronized (jad_anVar) {
            if (list != null) {
                if (list.size() != 0) {
                    try {
                        jad_anVar.getWritableDatabase();
                    } catch (java.lang.Throwable th) {
                        try {
                            com.jd.ad.sdk.logger.Logger.w("Exception while clearing video:", th.getMessage());
                            android.database.sqlite.SQLiteDatabase sQLiteDatabase = jad_anVar.jad_an;
                            if (sQLiteDatabase != null) {
                            }
                        } catch (java.lang.Throwable th2) {
                            android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = jad_anVar.jad_an;
                            if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                                jad_anVar.jad_an.endTransaction();
                            }
                            throw th2;
                        }
                    }
                    if (jad_anVar.jad_bo()) {
                        jad_anVar.jad_an.beginTransaction();
                        java.util.Iterator it = list.iterator();
                        while (it.hasNext()) {
                            jad_anVar.jad_an.delete("splashVideo", "_id=?", new java.lang.String[]{java.lang.String.valueOf(((java.lang.Integer) it.next()).intValue())});
                        }
                        jad_anVar.jad_an.setTransactionSuccessful();
                        android.database.sqlite.SQLiteDatabase sQLiteDatabase3 = jad_anVar.jad_an;
                        if (sQLiteDatabase3 != null) {
                        }
                    } else {
                        android.database.sqlite.SQLiteDatabase sQLiteDatabase4 = jad_anVar.jad_an;
                        if (sQLiteDatabase4 != null && sQLiteDatabase4.inTransaction()) {
                            android.database.sqlite.SQLiteDatabase sQLiteDatabase5 = jad_anVar.jad_an;
                            sQLiteDatabase5.endTransaction();
                        }
                    }
                }
            }
        }
    }

    public static void jad_bo(com.jd.ad.sdk.jad_mz.jad_an jad_anVar, java.util.List list) {
        jad_anVar.getClass();
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    java.io.File file = new java.io.File((java.lang.String) it.next());
                    if (!file.exists()) {
                        com.jd.ad.sdk.logger.Logger.d("File does not exist");
                    } else if (file.delete()) {
                        com.jd.ad.sdk.logger.Logger.d("File deleted successfully");
                    } else {
                        com.jd.ad.sdk.logger.Logger.d("Failed to delete the file");
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.jd.ad.sdk.logger.Logger.w("Exception while delete video:", e.getMessage());
            }
        }
    }

    public final android.content.ContentValues jad_an(com.jd.ad.sdk.jad_ly.jad_cp jad_cpVar) {
        android.content.ContentValues contentValues;
        try {
            contentValues = new android.content.ContentValues();
        } catch (java.lang.Exception e) {
            e = e;
            contentValues = null;
        }
        try {
            contentValues.put("appIdPid", jad_cpVar.jad_bo);
            java.lang.String ja = com.jd.ad.sdk.fdt.utils.ANEProxy.ja(jad_cpVar.jad_cp);
            java.lang.String ja2 = com.jd.ad.sdk.fdt.utils.ANEProxy.ja(jad_cpVar.jad_dq);
            contentValues.put("videoUrl", ja);
            contentValues.put("videoLocalPath", ja2);
            contentValues.put("timeStampInterval", jad_cpVar.jad_er);
        } catch (java.lang.Exception e2) {
            e = e2;
            com.jd.ad.sdk.logger.Logger.w("Exception while add video:", e.getMessage());
            return contentValues;
        }
        return contentValues;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x009d, code lost:
    
        if (r10.isClosed() == false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void jad_an(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.database.Cursor cursor = null;
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return;
            }
            cursor = this.jad_an.query("splashVideo", null, null, null, null, null, "timeStampInterval ASC");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            int count = cursor.getCount();
            if (this.jad_cp == null) {
                this.jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_an();
            }
            com.jd.ad.sdk.jad_pc.jad_an jad_anVar = this.jad_cp;
            if (jad_anVar != null) {
                this.jad_bo = jad_anVar.jad_re;
            }
            if (count > this.jad_bo) {
                if (jad_anVar == null) {
                    this.jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_an();
                }
                com.jd.ad.sdk.jad_pc.jad_an jad_anVar2 = this.jad_cp;
                if (jad_anVar2 != null) {
                    this.jad_bo = jad_anVar2.jad_re;
                }
                for (int i = count - this.jad_bo; cursor.moveToNext() && i > 0; i--) {
                    int i2 = cursor.getInt(cursor.getColumnIndex("_id"));
                    java.lang.String jb = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(cursor.getString(cursor.getColumnIndex("videoLocalPath")));
                    arrayList.add(java.lang.Integer.valueOf(i2));
                    if (!android.text.TextUtils.isEmpty(jb)) {
                        arrayList2.add(jb);
                    }
                }
            }
            cursor.close();
            com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_mz.jad_an.RunnableC0394jad_an(arrayList, arrayList2));
        } catch (java.lang.Throwable th) {
            try {
                com.jd.ad.sdk.logger.Logger.w("Exception while query video: " + th.getMessage(), new java.lang.Object[0]);
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_VIDEO_RENDER_QUERY_DB_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(th.getMessage()));
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d7, code lost:
    
        if (r6.isClosed() == false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized java.util.List<com.jd.ad.sdk.jad_ly.jad_cp> jad_bo(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        android.database.Cursor cursor = null;
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return arrayList;
            }
            cursor = this.jad_an.query("splashVideo", null, "appIdPid =?", new java.lang.String[]{java.lang.String.valueOf(str)}, null, null, "timeStampInterval DESC");
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                long currentTimeMillis = java.lang.System.currentTimeMillis() - com.sensorsdata.sf.core.SFContextManger.LOCAL_PLAN_OUT_TIME;
                while (!cursor.isAfterLast()) {
                    int i = cursor.getInt(cursor.getColumnIndex("_id"));
                    java.lang.String jb = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(cursor.getString(cursor.getColumnIndex("videoUrl")));
                    java.lang.String jb2 = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(cursor.getString(cursor.getColumnIndex("videoLocalPath")));
                    java.lang.String string = cursor.getString(cursor.getColumnIndex("timeStampInterval"));
                    if (!android.text.TextUtils.isEmpty(jb2) && !android.text.TextUtils.isEmpty(jb) && (arrayList.size() <= 1 || java.lang.Long.parseLong(string) >= currentTimeMillis)) {
                        if (!android.text.TextUtils.isEmpty(jb2) ? new java.io.File(jb2).exists() : false) {
                            arrayList.add(new com.jd.ad.sdk.jad_ly.jad_cp(i, str, jb, jb2, string));
                            cursor.moveToNext();
                        }
                    }
                    arrayList2.add(java.lang.Integer.valueOf(i));
                    arrayList3.add(jb2);
                    cursor.moveToNext();
                }
                cursor.close();
                com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_mz.jad_an.jad_bo(arrayList2, arrayList3));
            }
        } catch (java.lang.Throwable th) {
            try {
                com.jd.ad.sdk.logger.Logger.w("Exception while query video: " + th.getMessage(), new java.lang.Object[0]);
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_QUERY_TEMPLATE_DB_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
                return arrayList;
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
    }

    public void jad_cp() {
        try {
            getWritableDatabase();
            if (jad_bo()) {
                this.jad_an.execSQL(java.lang.String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,  %s TEXT, %s TEXT, %s TEXT, %s TEXT)", "splashVideo", "appIdPid", "videoUrl", "videoLocalPath", "timeStampInterval"));
            }
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("video render video sql create error:");
            jad_an.append(android.util.Log.getStackTraceString(e));
            com.jd.ad.sdk.logger.Logger.d(jad_an.toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(java.lang.String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT,  %s TEXT, %s TEXT, %s TEXT)", "splashVideo", "appIdPid", "videoUrl", "videoLocalPath", "timeStampInterval"));
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("video render template sql create error:");
            jad_an.append(android.util.Log.getStackTraceString(e));
            com.jd.ad.sdk.logger.Logger.d(jad_an.toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS splashVideo");
        onCreate(sQLiteDatabase);
    }
}
