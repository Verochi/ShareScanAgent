package com.badlogic.gdx.backends.android;

/* loaded from: classes12.dex */
public class AndroidZipFileHandle extends com.badlogic.gdx.backends.android.AndroidFileHandle {
    public android.content.res.AssetFileDescriptor b;
    public com.badlogic.gdx.backends.android.ZipResourceFile c;
    public java.lang.String d;

    public AndroidZipFileHandle(java.io.File file, com.badlogic.gdx.Files.FileType fileType) {
        super((android.content.res.AssetManager) null, file, fileType);
        g();
    }

    public AndroidZipFileHandle(java.lang.String str) {
        super((android.content.res.AssetManager) null, str, com.badlogic.gdx.Files.FileType.Internal);
        g();
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle child(java.lang.String str) {
        return this.file.getPath().length() == 0 ? new com.badlogic.gdx.backends.android.AndroidZipFileHandle(new java.io.File(str), this.type) : new com.badlogic.gdx.backends.android.AndroidZipFileHandle(new java.io.File(this.file, str), this.type);
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, com.badlogic.gdx.files.FileHandle
    public boolean exists() {
        return (this.b == null && this.c.b(f()).length == 0) ? false : true;
    }

    public final java.lang.String f() {
        return this.d;
    }

    public final void g() {
        this.d = this.file.getPath().replace('\\', '/');
        com.badlogic.gdx.backends.android.ZipResourceFile expansionFile = ((com.badlogic.gdx.backends.android.AndroidFiles) com.badlogic.gdx.Gdx.files).getExpansionFile();
        this.c = expansionFile;
        this.b = expansionFile.getAssetFileDescriptor(f());
        if (isDirectory()) {
            this.d += net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle
    public android.content.res.AssetFileDescriptor getAssetFileDescriptor() throws java.io.IOException {
        return this.b;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, com.badlogic.gdx.files.FileHandle
    public boolean isDirectory() {
        return this.b == null;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, com.badlogic.gdx.files.FileHandle
    public long length() {
        android.content.res.AssetFileDescriptor assetFileDescriptor = this.b;
        if (assetFileDescriptor != null) {
            return assetFileDescriptor.getLength();
        }
        return 0L;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle[] list() {
        com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO[] b = this.c.b(f());
        int length = b.length;
        com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[length];
        for (int i = 0; i < length; i++) {
            fileHandleArr[i] = new com.badlogic.gdx.backends.android.AndroidZipFileHandle(b[i].mFileName);
        }
        return fileHandleArr;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle[] list(java.io.FileFilter fileFilter) {
        com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO[] b = this.c.b(f());
        com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[b.length];
        int i = 0;
        for (com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO zipEntryRO : b) {
            com.badlogic.gdx.backends.android.AndroidZipFileHandle androidZipFileHandle = new com.badlogic.gdx.backends.android.AndroidZipFileHandle(zipEntryRO.mFileName);
            if (fileFilter.accept(androidZipFileHandle.file())) {
                fileHandleArr[i] = androidZipFileHandle;
                i++;
            }
        }
        if (i >= b.length) {
            return fileHandleArr;
        }
        com.badlogic.gdx.files.FileHandle[] fileHandleArr2 = new com.badlogic.gdx.files.FileHandle[i];
        java.lang.System.arraycopy(fileHandleArr, 0, fileHandleArr2, 0, i);
        return fileHandleArr2;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle[] list(java.io.FilenameFilter filenameFilter) {
        com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO[] b = this.c.b(f());
        com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[b.length];
        int i = 0;
        for (com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO zipEntryRO : b) {
            java.lang.String str = zipEntryRO.mFileName;
            if (filenameFilter.accept(this.file, str)) {
                fileHandleArr[i] = new com.badlogic.gdx.backends.android.AndroidZipFileHandle(str);
                i++;
            }
        }
        if (i >= b.length) {
            return fileHandleArr;
        }
        com.badlogic.gdx.files.FileHandle[] fileHandleArr2 = new com.badlogic.gdx.files.FileHandle[i];
        java.lang.System.arraycopy(fileHandleArr, 0, fileHandleArr2, 0, i);
        return fileHandleArr2;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle[] list(java.lang.String str) {
        com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO[] b = this.c.b(f());
        com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[b.length];
        int i = 0;
        for (com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO zipEntryRO : b) {
            java.lang.String str2 = zipEntryRO.mFileName;
            if (str2.endsWith(str)) {
                fileHandleArr[i] = new com.badlogic.gdx.backends.android.AndroidZipFileHandle(str2);
                i++;
            }
        }
        if (i >= b.length) {
            return fileHandleArr;
        }
        com.badlogic.gdx.files.FileHandle[] fileHandleArr2 = new com.badlogic.gdx.files.FileHandle[i];
        java.lang.System.arraycopy(fileHandleArr, 0, fileHandleArr2, 0, i);
        return fileHandleArr2;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle parent() {
        java.io.File parentFile = this.file.getParentFile();
        if (parentFile == null) {
            parentFile = new java.io.File("");
        }
        return new com.badlogic.gdx.backends.android.AndroidZipFileHandle(parentFile.getPath());
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, com.badlogic.gdx.files.FileHandle
    public java.io.InputStream read() {
        try {
            return this.c.getInputStream(f());
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error reading file: " + this.file + " (ZipResourceFile)", e);
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle sibling(java.lang.String str) {
        if (this.file.getPath().length() != 0) {
            return com.badlogic.gdx.Gdx.files.getFileHandle(new java.io.File(this.file.getParent(), str).getPath(), this.type);
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot get the sibling of the root.");
    }
}
