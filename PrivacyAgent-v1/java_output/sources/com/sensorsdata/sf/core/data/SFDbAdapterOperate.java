package com.sensorsdata.sf.core.data;

/* loaded from: classes19.dex */
public class SFDbAdapterOperate implements com.sensorsdata.sf.core.data.IDataOperate {
    private static final java.lang.String TAG = "SFDbAdapterOperate";
    private android.content.ContentResolver mContentResolver;
    private android.content.Context mContext;
    private com.sensorsdata.sf.core.data.SFDbParams mDbParams;

    public static class SingleHolder {

        @android.annotation.SuppressLint({"StaticFieldLeak"})
        private static final com.sensorsdata.sf.core.data.SFDbAdapterOperate INSTANCE = new com.sensorsdata.sf.core.data.SFDbAdapterOperate(null);

        private SingleHolder() {
        }
    }

    private SFDbAdapterOperate() {
    }

    public /* synthetic */ SFDbAdapterOperate(com.sensorsdata.sf.core.data.SFDbAdapterOperate.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.sensorsdata.sf.core.data.SFDbAdapterOperate getInstance() {
        return com.sensorsdata.sf.core.data.SFDbAdapterOperate.SingleHolder.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.data.SFDbAdapterOperate.TAG, "query has user,distinct id is:" + r11 + ",result is:" + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005e, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r0 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean hasUser(java.lang.String str) {
        boolean z = false;
        if (android.text.TextUtils.isEmpty(str)) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "query has user,distinctId is null");
            return false;
        }
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = this.mContentResolver.query(this.mDbParams.getUserUri(), new java.lang.String[]{"distinct_id"}, "distinct_id=?", new java.lang.String[]{str}, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        z = true;
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void insertOrUpdatePlanColumn(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "insert or update plan,userId or column is null");
            return;
        }
        try {
            if (hasPlan(str)) {
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "update plan");
                updatePlanColumn(str, str2, str3);
            } else {
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "insert plan");
                insertPlanColumn(str, str2, str3);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private void insertPlanColumn(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "insert plan column,userId or column is null");
            return;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("user_id", str);
            contentValues.put(str2, str3);
            contentValues.put("update_time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            this.mContentResolver.insert(this.mDbParams.getPlanUri(), contentValues);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "insert plan data,userId:" + str + ",column:" + str2 + "value:" + str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0050, code lost:
    
        com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.data.SFDbAdapterOperate.TAG, "query local plan,userId:" + r11 + ",local plan:" + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006c, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r1 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0040, code lost:
    
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String queryPlanLocal(java.lang.String str) {
        android.database.Cursor cursor;
        android.database.Cursor cursor2 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        java.lang.String str2 = null;
        if (android.text.TextUtils.isEmpty(str)) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "query local plan,userId is null");
            return null;
        }
        try {
            cursor = this.mContentResolver.query(this.mDbParams.getPlanUri(), new java.lang.String[]{"user_id", "local_plan"}, "user_id=?", new java.lang.String[]{str}, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            str2 = cursor.getString(cursor.getColumnIndex("local_plan"));
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            cursor = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0050, code lost:
    
        com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.data.SFDbAdapterOperate.TAG, "query remote plan,user id:" + r11 + "remote:" + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006c, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r1 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0040, code lost:
    
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String queryPlanRemote(java.lang.String str) {
        android.database.Cursor cursor;
        android.database.Cursor cursor2 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        java.lang.String str2 = null;
        if (android.text.TextUtils.isEmpty(str)) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "query remote plan,user id is null");
            return null;
        }
        try {
            cursor = this.mContentResolver.query(this.mDbParams.getPlanUri(), new java.lang.String[]{"user_id", "remote_plan"}, "user_id=?", new java.lang.String[]{str}, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            str2 = cursor.getString(cursor.getColumnIndex("remote_plan"));
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            cursor = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    private void updatePlanColumn(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "update plan column,userId or column is null");
            return;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put(str2, str3);
            contentValues.put("update_time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            this.mContentResolver.update(this.mDbParams.getPlanUri(), contentValues, "user_id =? ", new java.lang.String[]{str});
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "update plan data,userId:" + str + ",column:" + str2 + "value:" + str3);
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void deletePlan(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "delete plan,user id is null");
            return;
        }
        try {
            this.mContentResolver.delete(this.mDbParams.getPlanUri(), "user_id =? ", new java.lang.String[]{str});
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "delete plan,user id:" + str);
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void deletePlanOutTime(long j) {
        try {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "delete plan rows:" + this.mContentResolver.delete(this.mDbParams.getPlanUri(), "update_time < ?", new java.lang.String[]{java.lang.String.valueOf(j - com.sensorsdata.sf.core.SFContextManger.LOCAL_PLAN_OUT_TIME)}));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public java.lang.String getGlobalPopupLimit() {
        return com.sensorsdata.sf.core.utils.Utils.loadJsonFromFile(new java.io.File(this.mContext.getFilesDir(), com.sensorsdata.sf.core.entity.GlobalPopupLimit.GLOBAL_POPUP_LIMIT_FILE_NAME));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public java.lang.String getPlanLocal(java.lang.String str) {
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "get plan local,user id:" + str);
        return queryPlanLocal(str);
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public java.lang.String getPlanRemote(java.lang.String str) {
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "get plan remote,user id:" + str);
        return queryPlanRemote(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        if (r0 == null) goto L18;
     */
    @Override // com.sensorsdata.sf.core.data.IDataOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String getSPValue(java.lang.String str, java.lang.String str2) {
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = this.mContentResolver.query(this.mDbParams.getSPUri().buildUpon().appendQueryParameter("sp_parameter_get", str).build(), null, null, null, null);
                if (cursor != null && cursor.moveToNext()) {
                    java.lang.String string = cursor.getString(0);
                    cursor.close();
                    return string;
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
        } catch (java.lang.Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r2 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0032, code lost:
    
        if (r2 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0034, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0042, code lost:
    
        com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.data.SFDbAdapterOperate.TAG, "query user id,distinctId:" + r9 + ",userId:" + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0060, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    @Override // com.sensorsdata.sf.core.data.IDataOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String getUserId(java.lang.String str) {
        android.database.Cursor cursor;
        android.database.Cursor cursor2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        java.lang.String str2 = null;
        try {
            cursor = this.mContentResolver.query(this.mDbParams.getUserUri(), new java.lang.String[]{"distinct_id", "user_id"}, "distinct_id=?", new java.lang.String[]{str}, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            str2 = cursor.getString(cursor.getColumnIndex("user_id"));
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            cursor = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.data.SFDbAdapterOperate.TAG, "query has plan,user id is:" + r11 + ",result is:" + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005e, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r0 == null) goto L20;
     */
    @Override // com.sensorsdata.sf.core.data.IDataOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hasPlan(java.lang.String str) {
        boolean z = false;
        if (android.text.TextUtils.isEmpty(str)) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "query has plan,userId is null");
            return false;
        }
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = this.mContentResolver.query(this.mDbParams.getPlanUri(), new java.lang.String[]{"user_id"}, "user_id=?", new java.lang.String[]{str}, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        z = true;
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void init(android.content.Context context) {
        this.mContext = context;
        this.mDbParams = com.sensorsdata.sf.core.data.SFDbParams.getInstance(context.getPackageName());
        this.mContentResolver = context.getContentResolver();
    }

    public void migrationData() {
        this.mContentResolver.insert(this.mDbParams.getUserUri().buildUpon().appendQueryParameter("insert_action", "migration_data").build(), null);
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void next(com.sensorsdata.sf.core.data.IDataOperate iDataOperate) {
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void saveGlobalPopupLimit(java.lang.String str) {
        com.sensorsdata.sf.core.utils.Utils.saveJsonToFile(str, new java.io.File(this.mContext.getFilesDir(), com.sensorsdata.sf.core.entity.GlobalPopupLimit.GLOBAL_POPUP_LIMIT_FILE_NAME));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void savePlanLocal(java.lang.String str, java.lang.String str2) {
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "save plan local,user id:" + str);
        insertOrUpdatePlanColumn(str, "local_plan", str2);
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void savePlanRemote(java.lang.String str, java.lang.String str2) {
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "save plan remote,user id:" + str);
        insertOrUpdatePlanColumn(str, "remote_plan", str2);
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void savePlanUserId(java.lang.String str, java.lang.String str2) {
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "save plan user id,old user id:" + str);
        insertOrUpdatePlanColumn(str, "user_id", str2);
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void saveUser(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "save user,distinct id is null");
            return;
        }
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "save user,distinct id:" + str + ",user id:" + str2);
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("distinct_id", str);
        contentValues.put("user_id", str2);
        if (hasUser(str)) {
            this.mContentResolver.update(this.mDbParams.getUserUri(), contentValues, "distinct_id=?", new java.lang.String[]{str});
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "update user");
        } else {
            this.mContentResolver.insert(this.mDbParams.getUserUri(), contentValues);
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "insert user");
        }
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void setSPValue(java.lang.String str, java.lang.String str2) {
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("sp_parameter_set", str2);
            this.mContentResolver.insert(this.mDbParams.getSPUri().buildUpon().appendQueryParameter("sp_parameter_set", str).build(), contentValues);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void updatePlanTime(java.lang.String str, long j) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "update plan column,userId is null");
            return;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("update_time", java.lang.Long.valueOf(j));
            this.mContentResolver.update(this.mDbParams.getPlanUri(), contentValues, "user_id =? ", new java.lang.String[]{str});
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "update plan time,userId:" + str + ",time:" + j);
    }
}
