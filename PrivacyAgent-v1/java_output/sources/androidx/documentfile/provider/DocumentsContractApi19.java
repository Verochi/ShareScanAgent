package androidx.documentfile.provider;

@androidx.annotation.RequiresApi(19)
/* loaded from: classes.dex */
class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final java.lang.String TAG = "DocumentFile";

    private DocumentsContractApi19() {
    }

    public static boolean canRead(android.content.Context context, android.net.Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !android.text.TextUtils.isEmpty(getRawType(context, uri));
    }

    public static boolean canWrite(android.content.Context context, android.net.Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        java.lang.String rawType = getRawType(context, uri);
        int queryForInt = queryForInt(context, uri, "flags", 0);
        if (android.text.TextUtils.isEmpty(rawType)) {
            return false;
        }
        if ((queryForInt & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(rawType) || (queryForInt & 8) == 0) {
            return (android.text.TextUtils.isEmpty(rawType) || (queryForInt & 2) == 0) ? false : true;
        }
        return true;
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

    public static boolean exists(android.content.Context context, android.net.Uri uri) {
        android.database.Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new java.lang.String[]{"document_id"}, null, null, null);
            return cursor.getCount() > 0;
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Failed query: ");
            sb.append(e);
            return false;
        } finally {
            closeQuietly(cursor);
        }
    }

    public static long getFlags(android.content.Context context, android.net.Uri uri) {
        return queryForLong(context, uri, "flags", 0L);
    }

    @androidx.annotation.Nullable
    public static java.lang.String getName(android.content.Context context, android.net.Uri uri) {
        return queryForString(context, uri, "_display_name", null);
    }

    @androidx.annotation.Nullable
    private static java.lang.String getRawType(android.content.Context context, android.net.Uri uri) {
        return queryForString(context, uri, "mime_type", null);
    }

    @androidx.annotation.Nullable
    public static java.lang.String getType(android.content.Context context, android.net.Uri uri) {
        java.lang.String rawType = getRawType(context, uri);
        if ("vnd.android.document/directory".equals(rawType)) {
            return null;
        }
        return rawType;
    }

    public static boolean isDirectory(android.content.Context context, android.net.Uri uri) {
        return "vnd.android.document/directory".equals(getRawType(context, uri));
    }

    public static boolean isFile(android.content.Context context, android.net.Uri uri) {
        java.lang.String rawType = getRawType(context, uri);
        return ("vnd.android.document/directory".equals(rawType) || android.text.TextUtils.isEmpty(rawType)) ? false : true;
    }

    public static boolean isVirtual(android.content.Context context, android.net.Uri uri) {
        return android.provider.DocumentsContract.isDocumentUri(context, uri) && (getFlags(context, uri) & 512) != 0;
    }

    public static long lastModified(android.content.Context context, android.net.Uri uri) {
        return queryForLong(context, uri, "last_modified", 0L);
    }

    public static long length(android.content.Context context, android.net.Uri uri) {
        return queryForLong(context, uri, "_size", 0L);
    }

    private static int queryForInt(android.content.Context context, android.net.Uri uri, java.lang.String str, int i) {
        return (int) queryForLong(context, uri, str, i);
    }

    private static long queryForLong(android.content.Context context, android.net.Uri uri, java.lang.String str, long j) {
        android.database.Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new java.lang.String[]{str}, null, null, null);
            return (!cursor.moveToFirst() || cursor.isNull(0)) ? j : cursor.getLong(0);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Failed query: ");
            sb.append(e);
            return j;
        } finally {
            closeQuietly(cursor);
        }
    }

    @androidx.annotation.Nullable
    private static java.lang.String queryForString(android.content.Context context, android.net.Uri uri, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        android.database.Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new java.lang.String[]{str}, null, null, null);
            return (!cursor.moveToFirst() || cursor.isNull(0)) ? str2 : cursor.getString(0);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Failed query: ");
            sb.append(e);
            return str2;
        } finally {
            closeQuietly(cursor);
        }
    }
}
