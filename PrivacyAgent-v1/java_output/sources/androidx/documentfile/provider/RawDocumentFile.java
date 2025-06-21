package androidx.documentfile.provider;

/* loaded from: classes.dex */
class RawDocumentFile extends androidx.documentfile.provider.DocumentFile {
    private java.io.File mFile;

    public RawDocumentFile(@androidx.annotation.Nullable androidx.documentfile.provider.DocumentFile documentFile, java.io.File file) {
        super(documentFile);
        this.mFile = file;
    }

    private static boolean deleteContents(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (java.io.File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= deleteContents(file2);
                }
                if (!file2.delete()) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Failed to delete ");
                    sb.append(file2);
                    z = false;
                }
            }
        }
        return z;
    }

    private static java.lang.String getTypeForName(java.lang.String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        }
        java.lang.String mimeTypeFromExtension = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1).toLowerCase());
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return this.mFile.canRead();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @androidx.annotation.Nullable
    public androidx.documentfile.provider.DocumentFile createDirectory(java.lang.String str) {
        java.io.File file = new java.io.File(this.mFile, str);
        if (file.isDirectory() || file.mkdir()) {
            return new androidx.documentfile.provider.RawDocumentFile(this, file);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @androidx.annotation.Nullable
    public androidx.documentfile.provider.DocumentFile createFile(java.lang.String str, java.lang.String str2) {
        java.lang.String extensionFromMimeType = android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + "." + extensionFromMimeType;
        }
        java.io.File file = new java.io.File(this.mFile, str2);
        try {
            file.createNewFile();
            return new androidx.documentfile.provider.RawDocumentFile(this, file);
        } catch (java.io.IOException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Failed to createFile: ");
            sb.append(e);
            return null;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        deleteContents(this.mFile);
        return this.mFile.delete();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return this.mFile.exists();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public java.lang.String getName() {
        return this.mFile.getName();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @androidx.annotation.Nullable
    public java.lang.String getType() {
        if (this.mFile.isDirectory()) {
            return null;
        }
        return getTypeForName(this.mFile.getName());
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public android.net.Uri getUri() {
        return android.net.Uri.fromFile(this.mFile);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return this.mFile.isFile();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return false;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return this.mFile.lastModified();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return this.mFile.length();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public androidx.documentfile.provider.DocumentFile[] listFiles() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.File[] listFiles = this.mFile.listFiles();
        if (listFiles != null) {
            for (java.io.File file : listFiles) {
                arrayList.add(new androidx.documentfile.provider.RawDocumentFile(this, file));
            }
        }
        return (androidx.documentfile.provider.DocumentFile[]) arrayList.toArray(new androidx.documentfile.provider.DocumentFile[arrayList.size()]);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(java.lang.String str) {
        java.io.File file = new java.io.File(this.mFile.getParentFile(), str);
        if (!this.mFile.renameTo(file)) {
            return false;
        }
        this.mFile = file;
        return true;
    }
}
