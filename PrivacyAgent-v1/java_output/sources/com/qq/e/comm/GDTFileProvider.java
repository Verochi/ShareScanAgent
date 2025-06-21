package com.qq.e.comm;

/* loaded from: classes19.dex */
public class GDTFileProvider extends android.content.ContentProvider {
    private static final java.lang.String[] b = {"_display_name", "_size"};
    private static final java.io.File c = new java.io.File(java.io.File.separator);
    private static java.util.HashMap<java.lang.String, com.qq.e.comm.GDTFileProvider.a> d = new java.util.HashMap<>();
    private com.qq.e.comm.GDTFileProvider.a a;

    public interface a {
        android.net.Uri a(java.io.File file);

        java.io.File a(android.net.Uri uri);
    }

    public static class b implements com.qq.e.comm.GDTFileProvider.a {
        private final java.lang.String a;
        private final java.util.HashMap<java.lang.String, java.io.File> b = new java.util.HashMap<>();

        public b(java.lang.String str) {
            this.a = str;
        }

        @Override // com.qq.e.comm.GDTFileProvider.a
        public android.net.Uri a(java.io.File file) {
            try {
                java.lang.String canonicalPath = file.getCanonicalPath();
                java.util.Map.Entry<java.lang.String, java.io.File> entry = null;
                for (java.util.Map.Entry<java.lang.String, java.io.File> entry2 : this.b.entrySet()) {
                    java.lang.String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new java.lang.IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                java.lang.String path2 = entry.getValue().getPath();
                boolean endsWith = path2.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                int length = path2.length();
                if (!endsWith) {
                    length++;
                }
                return new android.net.Uri.Builder().scheme("content").authority(this.a).encodedPath(android.net.Uri.encode(entry.getKey()) + '/' + android.net.Uri.encode(canonicalPath.substring(length), net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)).build();
            } catch (java.io.IOException unused) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // com.qq.e.comm.GDTFileProvider.a
        public java.io.File a(android.net.Uri uri) {
            java.lang.String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            java.lang.String decode = android.net.Uri.decode(encodedPath.substring(1, indexOf));
            java.lang.String decode2 = android.net.Uri.decode(encodedPath.substring(indexOf + 1));
            java.io.File file = this.b.get(decode);
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

        public void a(java.lang.String str, java.io.File file) {
            if (android.text.TextUtils.isEmpty(str)) {
                throw new java.lang.IllegalArgumentException("Name must not be empty");
            }
            try {
                this.b.put(str, file.getCanonicalFile());
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for " + file, e);
            }
        }
    }

    private static com.qq.e.comm.GDTFileProvider.a a(android.content.Context context, java.lang.String str) {
        com.qq.e.comm.GDTFileProvider.a aVar;
        synchronized (d) {
            aVar = d.get(str);
            if (aVar == null) {
                try {
                    aVar = b(context, str);
                    d.put(str, aVar);
                } catch (java.io.IOException e) {
                    throw new java.lang.IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (org.xmlpull.v1.XmlPullParserException e2) {
                    throw new java.lang.IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return aVar;
    }

    private static com.qq.e.comm.GDTFileProvider.a b(android.content.Context context, java.lang.String str) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        com.qq.e.comm.GDTFileProvider.b bVar = new com.qq.e.comm.GDTFileProvider.b(str);
        android.content.res.XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData == null) {
            throw new java.lang.IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = loadXmlMetaData.next();
            if (next == 1) {
                loadXmlMetaData.close();
                return bVar;
            }
            if (next == 2) {
                java.lang.String name = loadXmlMetaData.getName();
                java.io.File file = null;
                java.lang.String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                java.lang.String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    file = c;
                } else if ("files-path".equals(name)) {
                    file = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    file = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    file = android.os.Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    java.io.File[] externalFilesDirs = context.getExternalFilesDirs(null);
                    if (externalFilesDirs.length > 0) {
                        file = externalFilesDirs[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    java.io.File[] externalCacheDirs = getExternalCacheDirs(context);
                    if (externalCacheDirs.length > 0) {
                        file = externalCacheDirs[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    java.io.File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        file = externalMediaDirs[0];
                    }
                }
                if (file != null) {
                    if (attributeValue2 != null) {
                        file = new java.io.File(file, attributeValue2);
                    }
                    bVar.a(attributeValue, file);
                }
            }
        }
    }

    public static java.io.File[] getExternalCacheDirs(android.content.Context context) {
        return context.getExternalCacheDirs();
    }

    public static android.net.Uri getUriForFile(android.content.Context context, java.lang.String str, java.io.File file) {
        android.net.Uri uri = android.net.Uri.EMPTY;
        try {
            return a(context, str).a(file);
        } catch (java.lang.Throwable unused) {
            return uri;
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(android.content.Context context, android.content.pm.ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new java.lang.SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new java.lang.SecurityException("Provider must grant uri permissions");
        }
        this.a = a(context, providerInfo.authority);
    }

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        return this.a.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        java.io.File a2 = this.a.a(uri);
        int lastIndexOf = a2.getName().lastIndexOf(46);
        if (lastIndexOf < 0) {
            return com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        }
        java.lang.String mimeTypeFromExtension = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(a2.getName().substring(lastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        throw new java.lang.UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public android.os.ParcelFileDescriptor openFile(android.net.Uri uri, java.lang.String str) throws java.io.FileNotFoundException {
        int i;
        java.io.File a2 = this.a.a(uri);
        if ("r".equals(str)) {
            i = 268435456;
        } else if (com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH.equals(str) || com.anythink.expressad.d.a.b.R.equals(str)) {
            i = 738197504;
        } else if ("wa".equals(str)) {
            i = 704643072;
        } else if ("rw".equals(str)) {
            i = 939524096;
        } else {
            if (!"rwt".equals(str)) {
                throw new java.lang.IllegalArgumentException("Invalid mode: " + str);
            }
            i = 1006632960;
        }
        return android.os.ParcelFileDescriptor.open(a2, i);
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        int i;
        java.io.File a2 = this.a.a(uri);
        if (strArr == null) {
            strArr = b;
        }
        java.lang.String[] strArr3 = new java.lang.String[strArr.length];
        java.lang.Object[] objArr = new java.lang.Object[strArr.length];
        int i2 = 0;
        for (java.lang.String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = a2.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = java.lang.Long.valueOf(a2.length());
            }
            i2 = i;
        }
        java.lang.String[] strArr4 = new java.lang.String[i2];
        java.lang.System.arraycopy(strArr3, 0, strArr4, 0, i2);
        java.lang.Object[] objArr2 = new java.lang.Object[i2];
        java.lang.System.arraycopy(objArr, 0, objArr2, 0, i2);
        android.database.MatrixCursor matrixCursor = new android.database.MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        throw new java.lang.UnsupportedOperationException("No external updates");
    }
}
