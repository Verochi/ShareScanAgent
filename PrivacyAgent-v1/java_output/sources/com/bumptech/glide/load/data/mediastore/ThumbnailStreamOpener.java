package com.bumptech.glide.load.data.mediastore;

/* loaded from: classes.dex */
class ThumbnailStreamOpener {
    private static final com.bumptech.glide.load.data.mediastore.FileService DEFAULT_SERVICE = new com.bumptech.glide.load.data.mediastore.FileService();
    private static final java.lang.String TAG = "ThumbStreamOpener";
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
    private final android.content.ContentResolver contentResolver;
    private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;
    private final com.bumptech.glide.load.data.mediastore.ThumbnailQuery query;
    private final com.bumptech.glide.load.data.mediastore.FileService service;

    public ThumbnailStreamOpener(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.data.mediastore.FileService fileService, com.bumptech.glide.load.data.mediastore.ThumbnailQuery thumbnailQuery, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, android.content.ContentResolver contentResolver) {
        this.service = fileService;
        this.query = thumbnailQuery;
        this.byteArrayPool = arrayPool;
        this.contentResolver = contentResolver;
        this.parsers = list;
    }

    public ThumbnailStreamOpener(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.data.mediastore.ThumbnailQuery thumbnailQuery, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, android.content.ContentResolver contentResolver) {
        this(list, DEFAULT_SERVICE, thumbnailQuery, arrayPool, contentResolver);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String getPath(@androidx.annotation.NonNull android.net.Uri uri) {
        android.database.Cursor cursor;
        android.database.Cursor cursor2 = null;
        try {
            cursor = this.query.query(uri);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            java.lang.String string = cursor.getString(0);
                            cursor.close();
                            return string;
                        }
                    } catch (java.lang.SecurityException unused) {
                        if (android.util.Log.isLoggable(TAG, 3)) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append("Failed to query for thumbnail for Uri: ");
                            sb.append(uri);
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (java.lang.SecurityException unused2) {
            cursor = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    private boolean isValid(java.io.File file) {
        return this.service.exists(file) && 0 < this.service.length(file);
    }

    public int getOrientation(android.net.Uri uri) {
        java.io.InputStream inputStream = null;
        try {
            try {
                inputStream = this.contentResolver.openInputStream(uri);
                int orientation = com.bumptech.glide.load.ImageHeaderParserUtils.getOrientation(this.parsers, inputStream, this.byteArrayPool);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                return orientation;
            } catch (java.io.IOException | java.lang.NullPointerException unused2) {
                if (android.util.Log.isLoggable(TAG, 3)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Failed to open uri: ");
                    sb.append(uri);
                }
                if (inputStream == null) {
                    return -1;
                }
                try {
                    inputStream.close();
                    return -1;
                } catch (java.io.IOException unused3) {
                    return -1;
                }
            }
        } catch (java.lang.Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (java.io.IOException unused4) {
                }
            }
            throw th;
        }
    }

    public java.io.InputStream open(android.net.Uri uri) throws java.io.FileNotFoundException {
        java.lang.String path = getPath(uri);
        if (android.text.TextUtils.isEmpty(path)) {
            return null;
        }
        java.io.File file = this.service.get(path);
        if (!isValid(file)) {
            return null;
        }
        android.net.Uri fromFile = android.net.Uri.fromFile(file);
        try {
            return this.contentResolver.openInputStream(fromFile);
        } catch (java.lang.NullPointerException e) {
            throw ((java.io.FileNotFoundException) new java.io.FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e));
        }
    }
}
