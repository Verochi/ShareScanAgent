package com.bytedance.pangle;

/* loaded from: classes12.dex */
public class FileProvider extends android.content.ContentProvider {
    private static final java.lang.String[] a = {"_display_name", "_size"};
    private static final java.io.File b = new java.io.File(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
    private static com.bytedance.pangle.FileProvider.a c;

    public interface a {
        android.net.Uri a(java.io.File file);

        java.io.File a(android.net.Uri uri);
    }

    public static class b implements com.bytedance.pangle.FileProvider.a {
        final java.util.HashMap<java.lang.String, java.io.File> a = new java.util.HashMap<>();
        private final java.lang.String b;

        public b(java.lang.String str) {
            this.b = str;
        }

        @Override // com.bytedance.pangle.FileProvider.a
        public final android.net.Uri a(java.io.File file) {
            try {
                java.lang.String canonicalPath = file.getCanonicalPath();
                java.util.Map.Entry<java.lang.String, java.io.File> entry = null;
                for (java.util.Map.Entry<java.lang.String, java.io.File> entry2 : this.a.entrySet()) {
                    java.lang.String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new java.lang.IllegalArgumentException("Failed to find configured root that contains ".concat(java.lang.String.valueOf(canonicalPath)));
                }
                java.lang.String path2 = entry.getValue().getPath();
                return new android.net.Uri.Builder().scheme("content").authority(this.b).encodedPath(android.net.Uri.encode(entry.getKey()) + '/' + android.net.Uri.encode(path2.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)).build();
            } catch (java.io.IOException unused) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for ".concat(java.lang.String.valueOf(file)));
            }
        }

        @Override // com.bytedance.pangle.FileProvider.a
        public final java.io.File a(android.net.Uri uri) {
            java.lang.String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            java.lang.String decode = android.net.Uri.decode(encodedPath.substring(1, indexOf));
            java.lang.String decode2 = android.net.Uri.decode(encodedPath.substring(indexOf + 1));
            java.io.File file = this.a.get(decode);
            if (file == null) {
                throw new java.lang.IllegalArgumentException("Unable to find configured root for ".concat(java.lang.String.valueOf(uri)));
            }
            java.io.File file2 = new java.io.File(file, decode2);
            try {
                java.io.File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new java.lang.SecurityException("Resolved path jumped beyond configured root");
            } catch (java.io.IOException unused) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for ".concat(java.lang.String.valueOf(file2)));
            }
        }
    }

    private static java.io.File a(java.io.File file, java.lang.String... strArr) {
        for (int i = 0; i <= 0; i++) {
            java.lang.String str = strArr[0];
            if (str != null) {
                file = new java.io.File(file, str);
            }
        }
        return file;
    }

    public static void a(com.bytedance.pangle.plugin.Plugin plugin, android.content.res.XmlResourceParser xmlResourceParser) {
        try {
            try {
                java.lang.String str = plugin.mPkgName;
                android.content.Context wrapperContext = com.bytedance.pangle.transform.ZeusTransformUtils.wrapperContext(com.bytedance.pangle.Zeus.getAppApplication(), plugin.mPkgName);
                com.bytedance.pangle.FileProvider.b bVar = (com.bytedance.pangle.FileProvider.b) c;
                while (true) {
                    int next = xmlResourceParser.next();
                    if (next == 1) {
                        return;
                    }
                    if (next == 2) {
                        java.lang.String name = xmlResourceParser.getName();
                        java.io.File file = null;
                        java.lang.String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        java.lang.String attributeValue2 = xmlResourceParser.getAttributeValue(null, "path");
                        if ("root-path".equals(name)) {
                            file = b;
                        } else if ("files-path".equals(name)) {
                            file = wrapperContext.getFilesDir();
                        } else if ("cache-path".equals(name)) {
                            file = wrapperContext.getCacheDir();
                        } else if ("external-files-path".equals(name)) {
                            java.io.File[] externalFilesDirs = wrapperContext.getExternalFilesDirs(null);
                            if (externalFilesDirs.length > 0) {
                                file = externalFilesDirs[0];
                            }
                        } else if ("external-cache-path".equals(name)) {
                            java.io.File[] externalCacheDirs = wrapperContext.getExternalCacheDirs();
                            if (externalCacheDirs.length > 0) {
                                file = externalCacheDirs[0];
                            }
                        } else if ("external-media-path".equals(name)) {
                            java.io.File[] externalMediaDirs = wrapperContext.getExternalMediaDirs();
                            if (externalMediaDirs.length > 0) {
                                file = externalMediaDirs[0];
                            }
                        }
                        if (file != null) {
                            java.lang.String str2 = str + "_" + attributeValue;
                            java.io.File a2 = a(file, attributeValue2);
                            if (android.text.TextUtils.isEmpty(str2)) {
                                throw new java.lang.IllegalArgumentException("Name must not be empty");
                            }
                            try {
                                bVar.a.put(str2, a2.getCanonicalFile());
                            } catch (java.io.IOException e) {
                                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for ".concat(java.lang.String.valueOf(a2)), e);
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (org.xmlpull.v1.XmlPullParserException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (java.io.IOException e3) {
            e = e3;
            e.printStackTrace();
        }
    }

    @androidx.annotation.Keep
    public static android.net.Uri getUriForFile(@androidx.annotation.NonNull java.io.File file) {
        return c.a(file);
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
        if (c != null) {
            throw new java.lang.SecurityException("仅允许定义一个FileProvider");
        }
        c = new com.bytedance.pangle.FileProvider.b(providerInfo.authority);
    }

    @Override // android.content.ContentProvider
    public int delete(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        return c.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(@androidx.annotation.NonNull android.net.Uri uri) {
        java.io.File a2 = c.a(uri);
        int lastIndexOf = a2.getName().lastIndexOf(46);
        if (lastIndexOf < 0) {
            return com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        }
        java.lang.String mimeTypeFromExtension = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(a2.getName().substring(lastIndexOf + 1));
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
    public android.os.ParcelFileDescriptor openFile(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String str) {
        int i;
        java.io.File a2 = c.a(uri);
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
                throw new java.lang.IllegalArgumentException("Invalid mode: ".concat(java.lang.String.valueOf(str)));
            }
            i = 1006632960;
        }
        return android.os.ParcelFileDescriptor.open(a2, i);
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr2, @androidx.annotation.Nullable java.lang.String str2) {
        int i;
        java.io.File a2 = c.a(uri);
        if (strArr == null) {
            strArr = a;
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
    public int update(@androidx.annotation.NonNull android.net.Uri uri, android.content.ContentValues contentValues, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        throw new java.lang.UnsupportedOperationException("No external updates");
    }
}
