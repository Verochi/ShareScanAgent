package com.badlogic.gdx.backends.android;

/* loaded from: classes12.dex */
public class AndroidFiles implements com.badlogic.gdx.Files {
    public com.badlogic.gdx.backends.android.ZipResourceFile a = null;
    protected final android.content.res.AssetManager assets;
    protected final java.lang.String localpath;
    protected final java.lang.String sdcard;

    public AndroidFiles(android.content.res.AssetManager assetManager, java.lang.String str) {
        this.assets = assetManager;
        this.sdcard = str;
        this.localpath = str;
    }

    public AndroidFiles(android.content.res.AssetManager assetManager, java.lang.String str, java.lang.String str2) {
        this.assets = assetManager;
        if (!str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        this.localpath = str;
        this.sdcard = str2;
    }

    public final com.badlogic.gdx.files.FileHandle a(com.badlogic.gdx.files.FileHandle fileHandle, java.lang.String str) {
        try {
            this.assets.open(str).close();
            return fileHandle;
        } catch (java.lang.Exception unused) {
            com.badlogic.gdx.backends.android.AndroidZipFileHandle androidZipFileHandle = new com.badlogic.gdx.backends.android.AndroidZipFileHandle(str);
            return (androidZipFileHandle.isDirectory() && !androidZipFileHandle.exists()) ? fileHandle : androidZipFileHandle;
        }
    }

    @Override // com.badlogic.gdx.Files
    public com.badlogic.gdx.files.FileHandle absolute(java.lang.String str) {
        return new com.badlogic.gdx.backends.android.AndroidFileHandle((android.content.res.AssetManager) null, str, com.badlogic.gdx.Files.FileType.Absolute);
    }

    @Override // com.badlogic.gdx.Files
    public com.badlogic.gdx.files.FileHandle classpath(java.lang.String str) {
        return new com.badlogic.gdx.backends.android.AndroidFileHandle((android.content.res.AssetManager) null, str, com.badlogic.gdx.Files.FileType.Classpath);
    }

    @Override // com.badlogic.gdx.Files
    public com.badlogic.gdx.files.FileHandle external(java.lang.String str) {
        return new com.badlogic.gdx.backends.android.AndroidFileHandle((android.content.res.AssetManager) null, str, com.badlogic.gdx.Files.FileType.External);
    }

    public com.badlogic.gdx.backends.android.ZipResourceFile getExpansionFile() {
        return this.a;
    }

    @Override // com.badlogic.gdx.Files
    public java.lang.String getExternalStoragePath() {
        return this.sdcard;
    }

    @Override // com.badlogic.gdx.Files
    public com.badlogic.gdx.files.FileHandle getFileHandle(java.lang.String str, com.badlogic.gdx.Files.FileType fileType) {
        com.badlogic.gdx.Files.FileType fileType2 = com.badlogic.gdx.Files.FileType.Internal;
        com.badlogic.gdx.backends.android.AndroidFileHandle androidFileHandle = new com.badlogic.gdx.backends.android.AndroidFileHandle(fileType == fileType2 ? this.assets : null, str, fileType);
        return (this.a == null || fileType != fileType2) ? androidFileHandle : a(androidFileHandle, str);
    }

    @Override // com.badlogic.gdx.Files
    public java.lang.String getLocalStoragePath() {
        return this.localpath;
    }

    @Override // com.badlogic.gdx.Files
    public com.badlogic.gdx.files.FileHandle internal(java.lang.String str) {
        com.badlogic.gdx.backends.android.AndroidFileHandle androidFileHandle = new com.badlogic.gdx.backends.android.AndroidFileHandle(this.assets, str, com.badlogic.gdx.Files.FileType.Internal);
        return this.a != null ? a(androidFileHandle, str) : androidFileHandle;
    }

    @Override // com.badlogic.gdx.Files
    public boolean isExternalStorageAvailable() {
        return android.os.Environment.getExternalStorageState().equals("mounted");
    }

    @Override // com.badlogic.gdx.Files
    public boolean isLocalStorageAvailable() {
        return true;
    }

    @Override // com.badlogic.gdx.Files
    public com.badlogic.gdx.files.FileHandle local(java.lang.String str) {
        return new com.badlogic.gdx.backends.android.AndroidFileHandle((android.content.res.AssetManager) null, str, com.badlogic.gdx.Files.FileType.Local);
    }
}
