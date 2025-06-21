package com.bytedance.pangle;

/* loaded from: classes12.dex */
public class f extends android.view.ContextThemeWrapper {
    private java.io.File mCacheDir;
    private java.io.File mCodeCacheDir;
    private java.io.File mDataDir;
    private java.io.File mExternalCacheDir;
    private java.io.File mFilesDir;
    private java.io.File mNoBackupFilesDir;
    private java.io.File mObbDir;
    private final java.lang.Object mSync;

    public f() {
        this.mSync = new java.lang.Object();
    }

    public f(android.content.Context context, int i) {
        super(context, i);
        this.mSync = new java.lang.Object();
    }

    @androidx.annotation.RequiresApi(api = 23)
    public f(android.content.Context context, android.content.res.Resources.Theme theme) {
        super(context, theme);
        this.mSync = new java.lang.Object();
    }

    private static java.io.File ensurePrivateDirExists(java.io.File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static java.io.File makeFilename(java.io.File file, java.lang.String str) {
        if (str.indexOf(java.io.File.separatorChar) < 0) {
            return new java.io.File(file, str);
        }
        throw new java.lang.IllegalArgumentException("File " + str + " contains a path separator");
    }

    private java.lang.String makeSubName(java.lang.String str) {
        return getPluginDirName() + "_" + str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.String[] databaseList() {
        if (getPluginDirName() == null) {
            return super.databaseList();
        }
        java.lang.String[] databaseList = super.databaseList();
        int length = databaseList.length;
        boolean[] zArr = new boolean[length];
        int i = 0;
        for (int i2 = 0; i2 < databaseList.length; i2++) {
            if (databaseList[i2].startsWith(getPluginDirName())) {
                zArr[i2] = true;
                i++;
            } else {
                zArr[i2] = false;
            }
        }
        java.lang.String[] strArr = new java.lang.String[i];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (zArr[i4]) {
                strArr[i3] = databaseList[i4];
                i3++;
            }
        }
        return strArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(java.lang.String str) {
        return getPluginDirName() == null ? super.deleteDatabase(str) : super.deleteDatabase(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(java.lang.String str) {
        return makeFilename(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(java.lang.String str) {
        return getPluginDirName() == null ? super.deleteSharedPreferences(str) : super.deleteSharedPreferences(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getCacheDir() {
        java.io.File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getCacheDir();
        }
        synchronized (this.mSync) {
            if (this.mCacheDir == null) {
                this.mCacheDir = new java.io.File(super.getCacheDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mCacheDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getCodeCacheDir() {
        java.io.File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.mSync) {
            if (this.mCodeCacheDir == null) {
                this.mCodeCacheDir = new java.io.File(super.getCodeCacheDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mCodeCacheDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getDataDir() {
        java.io.File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getDataDir();
        }
        synchronized (this.mSync) {
            if (this.mDataDir == null) {
                this.mDataDir = new java.io.File(getHostDataDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mDataDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getDatabasePath(java.lang.String str) {
        return getPluginDirName() == null ? super.getDatabasePath(str) : super.getDatabasePath(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getDir(java.lang.String str, int i) {
        return (i != 0 || getPluginDirName() == null) ? super.getDir(str, i) : ensurePrivateDirExists(new java.io.File(super.getDir(str, i), getPluginDirName()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getExternalCacheDir() {
        java.io.File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.mSync) {
            if (this.mExternalCacheDir == null) {
                this.mExternalCacheDir = new java.io.File(super.getExternalCacheDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mExternalCacheDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File[] getExternalCacheDirs() {
        if (getPluginDirName() == null) {
            return super.getExternalCacheDirs();
        }
        java.io.File[] externalCacheDirs = super.getExternalCacheDirs();
        java.io.File[] fileArr = new java.io.File[externalCacheDirs.length];
        for (int i = 0; i < externalCacheDirs.length; i++) {
            fileArr[i] = ensurePrivateDirExists(new java.io.File(externalCacheDirs[i], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getExternalFilesDir(java.lang.String str) {
        return getPluginDirName() == null ? super.getExternalFilesDir(str) : ensurePrivateDirExists(new java.io.File(super.getExternalFilesDir(str), getPluginDirName()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File[] getExternalFilesDirs(java.lang.String str) {
        if (getPluginDirName() == null) {
            return super.getExternalFilesDirs(str);
        }
        java.io.File[] externalFilesDirs = super.getExternalFilesDirs(str);
        java.io.File[] fileArr = new java.io.File[externalFilesDirs.length];
        for (int i = 0; i < externalFilesDirs.length; i++) {
            fileArr[i] = ensurePrivateDirExists(new java.io.File(externalFilesDirs[i], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File[] getExternalMediaDirs() {
        if (getPluginDirName() == null) {
            return super.getExternalMediaDirs();
        }
        java.io.File[] externalMediaDirs = super.getExternalMediaDirs();
        java.io.File[] fileArr = new java.io.File[externalMediaDirs.length];
        for (int i = 0; i < externalMediaDirs.length; i++) {
            fileArr[i] = ensurePrivateDirExists(new java.io.File(externalMediaDirs[i], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getFilesDir() {
        java.io.File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getFilesDir();
        }
        synchronized (this.mSync) {
            if (this.mFilesDir == null) {
                this.mFilesDir = new java.io.File(super.getFilesDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mFilesDir);
        }
        return ensurePrivateDirExists;
    }

    public java.io.File getHostDataDir() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getNoBackupFilesDir() {
        java.io.File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.mSync) {
            if (this.mNoBackupFilesDir == null) {
                this.mNoBackupFilesDir = new java.io.File(super.getNoBackupFilesDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mNoBackupFilesDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getObbDir() {
        java.io.File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getObbDir();
        }
        synchronized (this.mSync) {
            if (this.mObbDir == null) {
                this.mObbDir = new java.io.File(super.getObbDir(), getPluginDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mObbDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File[] getObbDirs() {
        if (getPluginDirName() == null) {
            return super.getObbDirs();
        }
        java.io.File[] obbDirs = super.getObbDirs();
        java.io.File[] fileArr = new java.io.File[obbDirs.length];
        for (int i = 0; i < obbDirs.length; i++) {
            fileArr[i] = ensurePrivateDirExists(new java.io.File(obbDirs[i], getPluginDirName()));
        }
        return fileArr;
    }

    public java.lang.String getPluginDirName() {
        return "pangle_" + getPluginPkg();
    }

    public java.lang.String getPluginPkg() {
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.SharedPreferences getSharedPreferences(java.lang.String str, int i) {
        return (i != 0 || getPluginDirName() == null) ? super.getSharedPreferences(str, i) : super.getSharedPreferences(makeSubName(str), i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(android.content.Context context, java.lang.String str) {
        if (getPluginDirName() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new java.lang.UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.FileInputStream openFileInput(java.lang.String str) {
        return getPluginDirName() == null ? super.openFileInput(str) : new java.io.FileInputStream(makeFilename(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.FileOutputStream openFileOutput(java.lang.String str, int i) {
        return (i != 0 || getPluginDirName() == null) ? super.openFileOutput(str, i) : new java.io.FileOutputStream(makeFilename(getFilesDir(), str), false);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.database.sqlite.SQLiteDatabase openOrCreateDatabase(java.lang.String str, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory) {
        return (i != 0 || getPluginDirName() == null) ? super.openOrCreateDatabase(str, i, cursorFactory) : super.openOrCreateDatabase(makeSubName(str), i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.database.sqlite.SQLiteDatabase openOrCreateDatabase(java.lang.String str, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, android.database.DatabaseErrorHandler databaseErrorHandler) {
        return (i != 0 || getPluginDirName() == null) ? super.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler) : super.openOrCreateDatabase(makeSubName(str), i, cursorFactory, databaseErrorHandler);
    }
}
