package androidx.core.content;

/* loaded from: classes.dex */
public class FileProvider extends android.content.ContentProvider {
    private static final java.lang.String ATTR_NAME = "name";
    private static final java.lang.String ATTR_PATH = "path";
    private static final java.lang.String DISPLAYNAME_FIELD = "displayName";
    private static final java.lang.String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final java.lang.String TAG_CACHE_PATH = "cache-path";
    private static final java.lang.String TAG_EXTERNAL = "external-path";
    private static final java.lang.String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final java.lang.String TAG_EXTERNAL_FILES = "external-files-path";
    private static final java.lang.String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final java.lang.String TAG_FILES_PATH = "files-path";
    private static final java.lang.String TAG_ROOT_PATH = "root-path";
    private androidx.core.content.FileProvider.PathStrategy mStrategy;
    private static final java.lang.String[] COLUMNS = {"_display_name", "_size"};
    private static final java.io.File DEVICE_ROOT = new java.io.File(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);

    @androidx.annotation.GuardedBy("sCache")
    private static java.util.HashMap<java.lang.String, androidx.core.content.FileProvider.PathStrategy> sCache = new java.util.HashMap<>();

    public interface PathStrategy {
        java.io.File getFileForUri(android.net.Uri uri);

        android.net.Uri getUriForFile(java.io.File file);
    }

    public static class SimplePathStrategy implements androidx.core.content.FileProvider.PathStrategy {
        private final java.lang.String mAuthority;
        private final java.util.HashMap<java.lang.String, java.io.File> mRoots = new java.util.HashMap<>();

        public SimplePathStrategy(java.lang.String str) {
            this.mAuthority = str;
        }

        public void addRoot(java.lang.String str, java.io.File file) {
            if (android.text.TextUtils.isEmpty(str)) {
                throw new java.lang.IllegalArgumentException("Name must not be empty");
            }
            try {
                this.mRoots.put(str, file.getCanonicalFile());
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for " + file, e);
            }
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public java.io.File getFileForUri(android.net.Uri uri) {
            java.lang.String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            java.lang.String decode = android.net.Uri.decode(encodedPath.substring(1, indexOf));
            java.lang.String decode2 = android.net.Uri.decode(encodedPath.substring(indexOf + 1));
            java.io.File file = this.mRoots.get(decode);
            if (file == null) {
                throw new java.lang.IllegalArgumentException("Unable to find configured root for " + uri);
            }
            java.io.File file2 = new java.io.File(file, decode2);
            try {
                java.io.File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new java.lang.SecurityException("Resolved path jumped beyond configured root");
            } catch (java.io.IOException unused) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public android.net.Uri getUriForFile(java.io.File file) {
            try {
                java.lang.String canonicalPath = file.getCanonicalPath();
                java.util.Map.Entry<java.lang.String, java.io.File> entry = null;
                for (java.util.Map.Entry<java.lang.String, java.io.File> entry2 : this.mRoots.entrySet()) {
                    java.lang.String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new java.lang.IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                java.lang.String path2 = entry.getValue().getPath();
                return new android.net.Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(android.net.Uri.encode(entry.getKey()) + '/' + android.net.Uri.encode(path2.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)).build();
            } catch (java.io.IOException unused) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }
    }

    private static java.io.File buildPath(java.io.File file, java.lang.String... strArr) {
        for (java.lang.String str : strArr) {
            if (str != null) {
                file = new java.io.File(file, str);
            }
        }
        return file;
    }

    private static java.lang.Object[] copyOf(java.lang.Object[] objArr, int i) {
        java.lang.Object[] objArr2 = new java.lang.Object[i];
        java.lang.System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    private static java.lang.String[] copyOf(java.lang.String[] strArr, int i) {
        java.lang.String[] strArr2 = new java.lang.String[i];
        java.lang.System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    private static androidx.core.content.FileProvider.PathStrategy getPathStrategy(android.content.Context context, java.lang.String str) {
        androidx.core.content.FileProvider.PathStrategy pathStrategy;
        synchronized (sCache) {
            pathStrategy = sCache.get(str);
            if (pathStrategy == null) {
                try {
                    pathStrategy = parsePathStrategy(context, str);
                    sCache.put(str, pathStrategy);
                } catch (java.io.IOException e) {
                    throw new java.lang.IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (org.xmlpull.v1.XmlPullParserException e2) {
                    throw new java.lang.IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return pathStrategy;
    }

    public static android.net.Uri getUriForFile(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.io.File file) {
        return getPathStrategy(context, str).getUriForFile(file);
    }

    @androidx.annotation.NonNull
    @android.annotation.SuppressLint({"StreamFiles"})
    public static android.net.Uri getUriForFile(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull java.lang.String str2) {
        return getUriForFile(context, str, file).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, str2).build();
    }

    private static int modeToMode(java.lang.String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if (com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH.equals(str) || com.anythink.expressad.d.a.b.R.equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new java.lang.IllegalArgumentException("Invalid mode: " + str);
    }

    private static androidx.core.content.FileProvider.PathStrategy parsePathStrategy(android.content.Context context, java.lang.String str) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        androidx.core.content.FileProvider.SimplePathStrategy simplePathStrategy = new androidx.core.content.FileProvider.SimplePathStrategy(str);
        android.content.pm.ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (resolveContentProvider == null) {
            throw new java.lang.IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
        android.content.res.XmlResourceParser loadXmlMetaData = resolveContentProvider.loadXmlMetaData(context.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (loadXmlMetaData == null) {
            throw new java.lang.IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = loadXmlMetaData.next();
            if (next == 1) {
                return simplePathStrategy;
            }
            if (next == 2) {
                java.lang.String name = loadXmlMetaData.getName();
                java.io.File file = null;
                java.lang.String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                java.lang.String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                if (TAG_ROOT_PATH.equals(name)) {
                    file = DEVICE_ROOT;
                } else if (TAG_FILES_PATH.equals(name)) {
                    file = context.getFilesDir();
                } else if (TAG_CACHE_PATH.equals(name)) {
                    file = context.getCacheDir();
                } else if (TAG_EXTERNAL.equals(name)) {
                    file = android.os.Environment.getExternalStorageDirectory();
                } else if (TAG_EXTERNAL_FILES.equals(name)) {
                    java.io.File[] externalFilesDirs = androidx.core.content.ContextCompat.getExternalFilesDirs(context, null);
                    if (externalFilesDirs.length > 0) {
                        file = externalFilesDirs[0];
                    }
                } else if (TAG_EXTERNAL_CACHE.equals(name)) {
                    java.io.File[] externalCacheDirs = androidx.core.content.ContextCompat.getExternalCacheDirs(context);
                    if (externalCacheDirs.length > 0) {
                        file = externalCacheDirs[0];
                    }
                } else if (TAG_EXTERNAL_MEDIA.equals(name)) {
                    java.io.File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        file = externalMediaDirs[0];
                    }
                }
                if (file != null) {
                    simplePathStrategy.addRoot(attributeValue, buildPath(file, attributeValue2));
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.pm.ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new java.lang.SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new java.lang.SecurityException("Provider must grant uri permissions");
        }
        this.mStrategy = getPathStrategy(context, providerInfo.authority.split(com.alipay.sdk.m.u.i.b)[0]);
    }

    @Override // android.content.ContentProvider
    public int delete(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        return this.mStrategy.getFileForUri(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(@androidx.annotation.NonNull android.net.Uri uri) {
        java.io.File fileForUri = this.mStrategy.getFileForUri(uri);
        int lastIndexOf = fileForUri.getName().lastIndexOf(46);
        if (lastIndexOf < 0) {
            return com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        }
        java.lang.String mimeTypeFromExtension = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(lastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(@androidx.annotation.NonNull android.net.Uri uri, android.content.ContentValues contentValues) {
        throw new java.lang.UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @android.annotation.SuppressLint({"UnknownNullness"})
    public android.os.ParcelFileDescriptor openFile(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String str) throws java.io.FileNotFoundException {
        return android.os.ParcelFileDescriptor.open(this.mStrategy.getFileForUri(uri), modeToMode(str));
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr2, @androidx.annotation.Nullable java.lang.String str2) {
        int i;
        java.io.File fileForUri = this.mStrategy.getFileForUri(uri);
        java.lang.String queryParameter = uri.getQueryParameter(DISPLAYNAME_FIELD);
        if (strArr == null) {
            strArr = COLUMNS;
        }
        java.lang.String[] strArr3 = new java.lang.String[strArr.length];
        java.lang.Object[] objArr = new java.lang.Object[strArr.length];
        int i2 = 0;
        for (java.lang.String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = queryParameter == null ? fileForUri.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = java.lang.Long.valueOf(fileForUri.length());
            }
            i2 = i;
        }
        java.lang.String[] copyOf = copyOf(strArr3, i2);
        java.lang.Object[] copyOf2 = copyOf(objArr, i2);
        android.database.MatrixCursor matrixCursor = new android.database.MatrixCursor(copyOf, 1);
        matrixCursor.addRow(copyOf2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(@androidx.annotation.NonNull android.net.Uri uri, android.content.ContentValues contentValues, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        throw new java.lang.UnsupportedOperationException("No external updates");
    }
}
