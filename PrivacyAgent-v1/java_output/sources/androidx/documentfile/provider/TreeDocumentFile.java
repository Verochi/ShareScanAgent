package androidx.documentfile.provider;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes.dex */
class TreeDocumentFile extends androidx.documentfile.provider.DocumentFile {
    private android.content.Context mContext;
    private android.net.Uri mUri;

    public TreeDocumentFile(@androidx.annotation.Nullable androidx.documentfile.provider.DocumentFile documentFile, android.content.Context context, android.net.Uri uri) {
        super(documentFile);
        this.mContext = context;
        this.mUri = uri;
    }

    private static void closeQuietly(@androidx.annotation.Nullable java.lang.AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (java.lang.RuntimeException e) {
                throw e;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    @androidx.annotation.Nullable
    private static android.net.Uri createFile(android.content.Context context, android.net.Uri uri, java.lang.String str, java.lang.String str2) {
        try {
            return android.provider.DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return androidx.documentfile.provider.DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return androidx.documentfile.provider.DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @androidx.annotation.Nullable
    public androidx.documentfile.provider.DocumentFile createDirectory(java.lang.String str) {
        android.net.Uri createFile = createFile(this.mContext, this.mUri, "vnd.android.document/directory", str);
        if (createFile != null) {
            return new androidx.documentfile.provider.TreeDocumentFile(this, this.mContext, createFile);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @androidx.annotation.Nullable
    public androidx.documentfile.provider.DocumentFile createFile(java.lang.String str, java.lang.String str2) {
        android.net.Uri createFile = createFile(this.mContext, this.mUri, str, str2);
        if (createFile != null) {
            return new androidx.documentfile.provider.TreeDocumentFile(this, this.mContext, createFile);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        try {
            return android.provider.DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return androidx.documentfile.provider.DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @androidx.annotation.Nullable
    public java.lang.String getName() {
        return androidx.documentfile.provider.DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @androidx.annotation.Nullable
    public java.lang.String getType() {
        return androidx.documentfile.provider.DocumentsContractApi19.getType(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public android.net.Uri getUri() {
        return this.mUri;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return androidx.documentfile.provider.DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return androidx.documentfile.provider.DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return androidx.documentfile.provider.DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return androidx.documentfile.provider.DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return androidx.documentfile.provider.DocumentsContractApi19.length(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public androidx.documentfile.provider.DocumentFile[] listFiles() {
        android.content.ContentResolver contentResolver = this.mContext.getContentResolver();
        android.net.Uri uri = this.mUri;
        android.net.Uri buildChildDocumentsUriUsingTree = android.provider.DocumentsContract.buildChildDocumentsUriUsingTree(uri, android.provider.DocumentsContract.getDocumentId(uri));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new java.lang.String[]{"document_id"}, null, null, null);
                while (cursor.moveToNext()) {
                    arrayList.add(android.provider.DocumentsContract.buildDocumentUriUsingTree(this.mUri, cursor.getString(0)));
                }
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Failed query: ");
                sb.append(e);
            }
            android.net.Uri[] uriArr = (android.net.Uri[]) arrayList.toArray(new android.net.Uri[arrayList.size()]);
            androidx.documentfile.provider.DocumentFile[] documentFileArr = new androidx.documentfile.provider.DocumentFile[uriArr.length];
            for (int i = 0; i < uriArr.length; i++) {
                documentFileArr[i] = new androidx.documentfile.provider.TreeDocumentFile(this, this.mContext, uriArr[i]);
            }
            return documentFileArr;
        } finally {
            closeQuietly(cursor);
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(java.lang.String str) {
        try {
            android.net.Uri renameDocument = android.provider.DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, str);
            if (renameDocument != null) {
                this.mUri = renameDocument;
                return true;
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }
}
