package com.umeng.analytics.process;

/* loaded from: classes19.dex */
public class UMProcessDBHelper {
    private static com.umeng.analytics.process.UMProcessDBHelper mInstance;
    private android.content.Context mContext;
    private com.umeng.commonsdk.utils.FileLockUtil mFileLock = new com.umeng.commonsdk.utils.FileLockUtil();
    private com.umeng.analytics.process.UMProcessDBHelper.InsertEventCallback ekvCallBack = new com.umeng.analytics.process.UMProcessDBHelper.InsertEventCallback(this, null);

    /* renamed from: com.umeng.analytics.process.UMProcessDBHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements com.umeng.analytics.process.DBFileTraversalUtil.a {
        public AnonymousClass1() {
        }

        @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
        public void a() {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.SUB_PROCESS_EVENT) {
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(com.umeng.analytics.process.UMProcessDBHelper.this.mContext, com.umeng.analytics.process.UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, com.umeng.analytics.process.UMProcessDBDatasSender.getInstance(com.umeng.analytics.process.UMProcessDBHelper.this.mContext), null);
            }
        }
    }

    public class InsertEventCallback implements com.umeng.commonsdk.utils.FileLockCallback {
        private InsertEventCallback() {
        }

        public /* synthetic */ InsertEventCallback(com.umeng.analytics.process.UMProcessDBHelper uMProcessDBHelper, com.umeng.analytics.process.UMProcessDBHelper.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(java.io.File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(java.lang.String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(java.lang.String str, java.lang.Object obj) {
            if (android.text.TextUtils.isEmpty(str)) {
                return true;
            }
            java.lang.String str2 = com.umeng.analytics.process.a.c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            com.umeng.analytics.process.UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.d, ""), (org.json.JSONArray) obj);
            return true;
        }
    }

    public class ProcessToMainCallback implements com.umeng.commonsdk.utils.FileLockCallback {
        private ProcessToMainCallback() {
        }

        public /* synthetic */ ProcessToMainCallback(com.umeng.analytics.process.UMProcessDBHelper uMProcessDBHelper, com.umeng.analytics.process.UMProcessDBHelper.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(java.io.File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return true;
            }
            java.lang.String str2 = com.umeng.analytics.process.a.c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            com.umeng.analytics.process.UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.d, ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(java.lang.String str, java.lang.Object obj) {
            return false;
        }
    }

    public class a implements java.io.Serializable {
        int a;
        java.lang.String b;
        java.lang.String c;
        java.lang.String d;
        int e;
        java.lang.String f;
        java.lang.String g;
        java.lang.String h;

        private a() {
        }

        public /* synthetic */ a(com.umeng.analytics.process.UMProcessDBHelper uMProcessDBHelper, com.umeng.analytics.process.UMProcessDBHelper.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private UMProcessDBHelper() {
    }

    private UMProcessDBHelper(android.content.Context context) {
        com.umeng.common.a.a().a(context);
    }

    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> datasAdapter(java.lang.String str, org.json.JSONArray jSONArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (android.text.TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.umeng.analytics.process.UMProcessDBHelper.a aVar = new com.umeng.analytics.process.UMProcessDBHelper.a(this, null);
                aVar.c = jSONObject.optString("id");
                aVar.g = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(this.mContext);
                aVar.h = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(this.mContext);
                aVar.b = jSONObject.optString("__i");
                aVar.e = jSONObject.optInt("__t");
                aVar.f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (java.lang.Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(java.lang.String str) {
        try {
            return new java.io.File(com.umeng.analytics.process.b.b(this.mContext, str)).exists();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static com.umeng.analytics.process.UMProcessDBHelper getInstance(android.content.Context context) {
        if (mInstance == null) {
            synchronized (com.umeng.analytics.process.UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new com.umeng.analytics.process.UMProcessDBHelper(context);
                }
            }
        }
        com.umeng.analytics.process.UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(java.lang.String str, java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> list) {
        if (android.text.TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            android.database.sqlite.SQLiteDatabase a2 = com.umeng.analytics.process.c.a(this.mContext).a(str);
            try {
                try {
                    a2.beginTransaction();
                    for (com.umeng.analytics.process.UMProcessDBHelper.a aVar : list) {
                        try {
                            android.content.ContentValues contentValues = new android.content.ContentValues();
                            contentValues.put("__i", aVar.b);
                            contentValues.put("__e", aVar.c);
                            contentValues.put("__t", java.lang.Integer.valueOf(aVar.e));
                            contentValues.put(com.umeng.analytics.process.a.InterfaceC0516a.f, aVar.f);
                            contentValues.put("__av", aVar.g);
                            contentValues.put("__vc", aVar.h);
                            contentValues.put("__s", aVar.d);
                            a2.insert(com.umeng.analytics.process.a.InterfaceC0516a.a, null, contentValues);
                        } catch (java.lang.Exception unused) {
                        }
                    }
                    a2.setTransactionSuccessful();
                    try {
                        a2.endTransaction();
                    } catch (java.lang.Throwable unused2) {
                    }
                    com.umeng.analytics.process.c.a(this.mContext).b(str);
                    return true;
                } catch (java.lang.Exception unused3) {
                    sQLiteDatabase = a2;
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (java.lang.Throwable unused4) {
                        }
                    }
                    com.umeng.analytics.process.c.a(this.mContext).b(str);
                    return false;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                sQLiteDatabase = a2;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (java.lang.Throwable unused5) {
                    }
                }
                com.umeng.analytics.process.c.a(this.mContext).b(str);
                throw th;
            }
        } catch (java.lang.Exception unused6) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private boolean processIsService(android.content.Context context) {
        return context.getPackageManager().getServiceInfo(new android.content.ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(java.lang.String str) {
        if (dbIsExists(str)) {
            java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.h, readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00aa, code lost:
    
        if (r2 != null) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c2 A[Catch: Exception -> 0x00c5, TRY_LEAVE, TryCatch #6 {Exception -> 0x00c5, blocks: (B:37:0x00bd, B:31:0x00c2), top: B:36:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        android.database.Cursor cursor;
        java.lang.Exception e;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursor2 = null;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.process.c.a(this.mContext).a(str);
            } catch (java.lang.Exception unused) {
            }
        } catch (java.lang.Exception e2) {
            cursor = null;
            e = e2;
            sQLiteDatabase = null;
        } catch (java.lang.Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            sQLiteDatabase.beginTransaction();
            cursor = sQLiteDatabase.query(com.umeng.analytics.process.a.InterfaceC0516a.a, null, null, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            com.umeng.analytics.process.UMProcessDBHelper.a aVar = new com.umeng.analytics.process.UMProcessDBHelper.a(this, null);
                            aVar.a = cursor.getInt(0);
                            aVar.b = cursor.getString(cursor.getColumnIndex("__i"));
                            aVar.c = cursor.getString(cursor.getColumnIndex("__e"));
                            aVar.d = cursor.getString(cursor.getColumnIndex("__s"));
                            aVar.e = cursor.getInt(cursor.getColumnIndex("__t"));
                            aVar.f = cursor.getString(cursor.getColumnIndex(com.umeng.analytics.process.a.InterfaceC0516a.f));
                            aVar.g = cursor.getString(cursor.getColumnIndex("__av"));
                            aVar.h = cursor.getString(cursor.getColumnIndex("__vc"));
                            arrayList.add(aVar);
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (java.lang.Exception unused2) {
                                com.umeng.analytics.process.c.a(this.mContext).b(str);
                                throw th;
                            }
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        com.umeng.analytics.process.c.a(this.mContext).b(str);
                        throw th;
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (java.lang.Exception e4) {
            cursor = null;
            e = e4;
        } catch (java.lang.Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            if (sQLiteDatabase != null) {
            }
            com.umeng.analytics.process.c.a(this.mContext).b(str);
            throw th;
        }
        sQLiteDatabase.endTransaction();
        com.umeng.analytics.process.c.a(this.mContext).b(str);
        return arrayList;
    }

    public void createDBByProcess(java.lang.String str) {
        try {
            com.umeng.analytics.process.c.a(this.mContext).a(str);
            com.umeng.analytics.process.c.a(this.mContext).b(str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEventDatas(java.lang.String str, java.lang.String str2, java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> list) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        java.lang.Throwable th;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = com.umeng.analytics.process.c.a(this.mContext).a(str);
        } catch (java.lang.Exception unused) {
        } catch (java.lang.Throwable th2) {
            sQLiteDatabase = null;
            th = th2;
        }
        try {
            sQLiteDatabase.beginTransaction();
            int size = list.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    sQLiteDatabase.execSQL("delete from __et_p where rowid=" + list.get(i).a);
                }
            } else {
                sQLiteDatabase.delete(com.umeng.analytics.process.a.InterfaceC0516a.a, null, null);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (java.lang.Exception unused2) {
            sQLiteDatabase2 = sQLiteDatabase;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
            com.umeng.analytics.process.c.a(this.mContext).b(str);
        } catch (java.lang.Throwable th3) {
            th = th3;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            com.umeng.analytics.process.c.a(this.mContext).b(str);
            throw th;
        }
        com.umeng.analytics.process.c.a(this.mContext).b(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
    
        if (r1 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void deleteMainProcessEventDatasByIds(java.util.List<java.lang.Integer> list) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = com.umeng.analytics.process.c.a(this.mContext).a(com.umeng.analytics.process.a.h);
            sQLiteDatabase.beginTransaction();
            java.util.Iterator<java.lang.Integer> it = list.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.delete(com.umeng.analytics.process.a.InterfaceC0516a.a, "id=?", new java.lang.String[]{java.lang.String.valueOf(it.next())});
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (java.lang.Exception unused) {
        } catch (java.lang.Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            com.umeng.analytics.process.c.a(this.mContext).b(com.umeng.analytics.process.a.h);
            throw th;
        }
        sQLiteDatabase.endTransaction();
        com.umeng.analytics.process.c.a(this.mContext).b(com.umeng.analytics.process.a.h);
    }

    public void insertEvents(java.lang.String str, org.json.JSONArray jSONArray) {
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.SUB_PROCESS_EVENT && !android.text.TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(java.lang.String str, org.json.JSONArray jSONArray) {
        if (com.umeng.commonsdk.statistics.AnalyticsConstants.SUB_PROCESS_EVENT && !android.text.TextUtils.isEmpty(str)) {
            java.io.File file = new java.io.File(com.umeng.analytics.process.b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            com.umeng.analytics.process.DBFileTraversalUtil.traverseDBFiles(com.umeng.analytics.process.b.a(this.mContext), new com.umeng.analytics.process.UMProcessDBHelper.ProcessToMainCallback(this, null), new com.umeng.analytics.process.UMProcessDBHelper.AnonymousClass1());
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public org.json.JSONObject readMainEvents(long j, java.util.List<java.lang.Integer> list) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        android.database.Cursor cursor;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        android.database.Cursor cursor2 = null;
        cursor2 = null;
        cursor2 = null;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = null;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.process.c.a(this.mContext).a(com.umeng.analytics.process.a.h);
            } catch (java.lang.Throwable unused) {
            }
            try {
                sQLiteDatabase.beginTransaction();
                cursor2 = sQLiteDatabase.query(com.umeng.analytics.process.a.InterfaceC0516a.a, null, null, null, null, null, null);
                if (cursor2 != null) {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    java.lang.String str = "";
                    while (cursor2.moveToNext()) {
                        int i = cursor2.getInt(cursor2.getColumnIndex("id"));
                        int i2 = cursor2.getInt(cursor2.getColumnIndex("__t"));
                        java.lang.String string = cursor2.getString(cursor2.getColumnIndex("__i"));
                        java.lang.String string2 = cursor2.getString(cursor2.getColumnIndex("__s"));
                        java.lang.String string3 = cursor2.getString(cursor2.getColumnIndex(com.umeng.analytics.process.a.InterfaceC0516a.f));
                        java.lang.String string4 = cursor2.getString(cursor2.getColumnIndex("__av"));
                        if (!android.text.TextUtils.isEmpty(string)) {
                            if (android.text.TextUtils.isEmpty(str)) {
                                str = string4;
                            }
                            if (!android.text.TextUtils.isEmpty(string2) && i2 == 2049) {
                                org.json.JSONObject jSONObject3 = new org.json.JSONObject(com.umeng.common.a.a().b(string2));
                                java.lang.String optString = jSONObject3.optString("pn");
                                if (android.text.TextUtils.isEmpty(optString) || "unknown".equals(optString)) {
                                    jSONObject3.put("pn", this.mContext.getPackageName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + string3);
                                }
                                org.json.JSONArray optJSONArray = jSONObject2.has(string) ? jSONObject2.optJSONArray(string) : new org.json.JSONArray();
                                if (com.umeng.analytics.pro.s.a(jSONObject3) + com.umeng.analytics.pro.s.a(optJSONArray) <= j && str.equalsIgnoreCase(string4)) {
                                    list.add(java.lang.Integer.valueOf(i));
                                    optJSONArray.put(jSONObject3);
                                    jSONObject2.put(string, optJSONArray);
                                }
                            }
                        }
                    }
                    if (jSONObject2.length() > 0) {
                        org.json.JSONArray jSONArray = new org.json.JSONArray();
                        java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                            java.lang.String next = keys.next();
                            jSONObject4.put(next, new org.json.JSONArray(jSONObject2.optString(next)));
                            if (jSONObject4.length() > 0) {
                                jSONArray.put(jSONObject4);
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put("ekv", jSONArray);
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (cursor2 != null) {
                    cursor2.close();
                }
                sQLiteDatabase.endTransaction();
            } catch (java.lang.Exception unused2) {
                cursor = cursor2;
                sQLiteDatabase2 = sQLiteDatabase;
                try {
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 构建子进程事件数据异常，清除数据库数据。");
                    sQLiteDatabase2.execSQL("delete from __et_p");
                    sQLiteDatabase2.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                    sQLiteDatabase2.endTransaction();
                    com.umeng.analytics.process.c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                    return jSONObject;
                } catch (java.lang.Throwable th) {
                    th = th;
                    android.database.Cursor cursor3 = cursor;
                    sQLiteDatabase = sQLiteDatabase2;
                    cursor2 = cursor3;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (java.lang.Throwable unused3) {
                        }
                    }
                    com.umeng.analytics.process.c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                com.umeng.analytics.process.c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                throw th;
            }
        } catch (java.lang.Exception unused4) {
            cursor = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
        com.umeng.analytics.process.c.a(this.mContext).b(com.umeng.analytics.process.a.h);
        return jSONObject;
    }

    public org.json.JSONObject readVersionInfoFromColumId(java.lang.Integer num) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        org.json.JSONObject jSONObject;
        android.database.Cursor cursor = null;
        r3 = null;
        org.json.JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabase = com.umeng.analytics.process.c.a(this.mContext).a(com.umeng.analytics.process.a.h);
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    android.database.Cursor query = sQLiteDatabase.query(com.umeng.analytics.process.a.InterfaceC0516a.a, null, "rowid=?", new java.lang.String[]{java.lang.String.valueOf(num)}, null, null, null);
                    if (query != null) {
                        try {
                            try {
                                if (query.moveToNext()) {
                                    jSONObject = new org.json.JSONObject();
                                    try {
                                        java.lang.String string = query.getString(query.getColumnIndex("__av"));
                                        java.lang.String string2 = query.getString(query.getColumnIndex("__vc"));
                                        if (!android.text.TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!android.text.TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (java.lang.Exception e) {
                                        e = e;
                                        cursor = query;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (java.lang.Exception unused) {
                                                com.umeng.analytics.process.c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        com.umeng.analytics.process.c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                        return jSONObject;
                                    }
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                cursor = query;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (java.lang.Exception unused2) {
                                        com.umeng.analytics.process.c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                }
                                com.umeng.analytics.process.c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                throw th;
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            jSONObject = null;
                        }
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (java.lang.Exception unused3) {
                        }
                    }
                    sQLiteDatabase.endTransaction();
                    com.umeng.analytics.process.c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                    return jSONObject2;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                jSONObject = null;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }
}
