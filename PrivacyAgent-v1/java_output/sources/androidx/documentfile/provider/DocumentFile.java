package androidx.documentfile.provider;

/* loaded from: classes.dex */
public abstract class DocumentFile {
    static final java.lang.String TAG = "DocumentFile";

    @androidx.annotation.Nullable
    private final androidx.documentfile.provider.DocumentFile mParent;

    public DocumentFile(@androidx.annotation.Nullable androidx.documentfile.provider.DocumentFile documentFile) {
        this.mParent = documentFile;
    }

    @androidx.annotation.NonNull
    public static androidx.documentfile.provider.DocumentFile fromFile(@androidx.annotation.NonNull java.io.File file) {
        return new androidx.documentfile.provider.RawDocumentFile(null, file);
    }

    @androidx.annotation.Nullable
    public static androidx.documentfile.provider.DocumentFile fromSingleUri(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri) {
        return new androidx.documentfile.provider.SingleDocumentFile(null, context, uri);
    }

    @androidx.annotation.Nullable
    public static androidx.documentfile.provider.DocumentFile fromTreeUri(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri) {
        return new androidx.documentfile.provider.TreeDocumentFile(null, context, android.provider.DocumentsContract.buildDocumentUriUsingTree(uri, android.provider.DocumentsContract.getTreeDocumentId(uri)));
    }

    public static boolean isDocumentUri(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.net.Uri uri) {
        return android.provider.DocumentsContract.isDocumentUri(context, uri);
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    @androidx.annotation.Nullable
    public abstract androidx.documentfile.provider.DocumentFile createDirectory(@androidx.annotation.NonNull java.lang.String str);

    @androidx.annotation.Nullable
    public abstract androidx.documentfile.provider.DocumentFile createFile(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2);

    public abstract boolean delete();

    public abstract boolean exists();

    @androidx.annotation.Nullable
    public androidx.documentfile.provider.DocumentFile findFile(@androidx.annotation.NonNull java.lang.String str) {
        for (androidx.documentfile.provider.DocumentFile documentFile : listFiles()) {
            if (str.equals(documentFile.getName())) {
                return documentFile;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public abstract java.lang.String getName();

    @androidx.annotation.Nullable
    public androidx.documentfile.provider.DocumentFile getParentFile() {
        return this.mParent;
    }

    @androidx.annotation.Nullable
    public abstract java.lang.String getType();

    @androidx.annotation.NonNull
    public abstract android.net.Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    @androidx.annotation.NonNull
    public abstract androidx.documentfile.provider.DocumentFile[] listFiles();

    public abstract boolean renameTo(@androidx.annotation.NonNull java.lang.String str);
}
