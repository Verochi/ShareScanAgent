package com.sina.weibo.sdk.c;

/* loaded from: classes19.dex */
public final class b {
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (r7 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
    
        return d(r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r7 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String a(android.content.Context context, android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        android.database.Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new java.lang.String[]{"_data"}, str, strArr, null);
            if (cursor != null && cursor.moveToFirst()) {
                java.lang.String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                cursor.close();
                return string;
            }
        } catch (java.lang.Exception unused) {
        } catch (java.lang.Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static java.lang.String a(java.io.File file) {
        try {
            java.lang.String absolutePath = file.getAbsolutePath();
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(absolutePath, options);
            java.lang.String str = options.outMimeType;
            if (!str.contains(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPG) && !str.contains("gif") && !str.contains(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG)) {
                if (!str.contains(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG)) {
                    return null;
                }
            }
            return "image/*";
        } catch (java.lang.Exception unused) {
            return "*/*";
        }
    }

    public static boolean a(android.content.Context context, android.net.Uri uri) {
        java.lang.String c = c(context, uri);
        if (android.text.TextUtils.isEmpty(c)) {
            throw new java.lang.IllegalArgumentException("get image path is null");
        }
        java.io.File file = new java.io.File(c);
        if (b(file)) {
            return false;
        }
        java.lang.String a = a(file);
        return !android.text.TextUtils.isEmpty(a) && a.startsWith("image/");
    }

    public static boolean b(android.content.Context context, android.net.Uri uri) {
        java.lang.String str;
        java.lang.String c = c(context, uri);
        if (android.text.TextUtils.isEmpty(c)) {
            throw new java.lang.IllegalArgumentException("get video path is null");
        }
        java.io.File file = new java.io.File(c);
        if (b(file)) {
            return false;
        }
        java.lang.String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            java.lang.String substring = name.substring(lastIndexOf);
            if (!android.text.TextUtils.isEmpty(substring) || substring.length() >= 2) {
                str = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring.substring(1).toLowerCase());
                return android.text.TextUtils.isEmpty(str) && str.startsWith("video/");
            }
        }
        str = "*/*";
        if (android.text.TextUtils.isEmpty(str)) {
        }
    }

    private static boolean b(java.io.File file) {
        if (file.getParent() != null) {
            file = new java.io.File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    @android.annotation.TargetApi(19)
    private static java.lang.String c(android.content.Context context, android.net.Uri uri) {
        android.net.Uri uri2 = null;
        if (android.provider.DocumentsContract.isDocumentUri(context, uri)) {
            if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                java.lang.String[] split = android.provider.DocumentsContract.getDocumentId(uri).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                if ("primary".equalsIgnoreCase(split[0])) {
                    return android.os.Environment.getExternalStorageDirectory() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + split[1];
                }
            } else {
                if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                    return a(context, android.content.ContentUris.withAppendedId(android.net.Uri.parse("content://downloads/public_downloads"), java.lang.Long.valueOf(android.provider.DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                    java.lang.String[] split2 = android.provider.DocumentsContract.getDocumentId(uri).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    java.lang.String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return a(context, uri2, "_id=?", new java.lang.String[]{split2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return "com.google.android.apps.photos.content".equals(uri.getAuthority()) ? uri.getLastPathSegment() : d(context, uri);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static java.lang.String d(android.content.Context context, android.net.Uri uri) {
        java.lang.String uri2 = uri.toString();
        return new java.io.File(context.getExternalFilesDir(null), uri2.substring(uri2.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR))).getAbsolutePath();
    }

    public static long e(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || !new java.io.File(str).exists()) {
            return 0L;
        }
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        return java.lang.Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
    }
}
