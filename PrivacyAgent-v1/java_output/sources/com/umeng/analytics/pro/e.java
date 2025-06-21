package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
class e extends android.content.ContextWrapper {
    private java.lang.String a;

    public e(android.content.Context context, java.lang.String str) {
        super(context);
        this.a = str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getDatabasePath(java.lang.String str) {
        java.io.File file = new java.io.File(this.a + str);
        if (!file.getParentFile().exists() && !file.getParentFile().isDirectory()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.database.sqlite.SQLiteDatabase openOrCreateDatabase(java.lang.String str, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory) {
        return android.database.sqlite.SQLiteDatabase.openDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory, 268435472);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.database.sqlite.SQLiteDatabase openOrCreateDatabase(java.lang.String str, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, android.database.DatabaseErrorHandler databaseErrorHandler) {
        return android.database.sqlite.SQLiteDatabase.openDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory, 268435472);
    }
}
