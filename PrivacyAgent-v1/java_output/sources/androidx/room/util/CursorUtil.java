package androidx.room.util;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class CursorUtil {
    private CursorUtil() {
    }

    @androidx.annotation.NonNull
    public static android.database.Cursor copyAndClose(@androidx.annotation.NonNull android.database.Cursor cursor) {
        try {
            android.database.MatrixCursor matrixCursor = new android.database.MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                java.lang.Object[] objArr = new java.lang.Object[cursor.getColumnCount()];
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    int type = cursor.getType(i);
                    if (type == 0) {
                        objArr[i] = null;
                    } else if (type == 1) {
                        objArr[i] = java.lang.Long.valueOf(cursor.getLong(i));
                    } else if (type == 2) {
                        objArr[i] = java.lang.Double.valueOf(cursor.getDouble(i));
                    } else if (type == 3) {
                        objArr[i] = cursor.getString(i);
                    } else {
                        if (type != 4) {
                            throw new java.lang.IllegalStateException();
                        }
                        objArr[i] = cursor.getBlob(i);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            cursor.close();
        }
    }

    private static int findColumnIndexBySuffix(@androidx.annotation.NonNull android.database.Cursor cursor, @androidx.annotation.NonNull java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
            return findColumnIndexBySuffix(cursor.getColumnNames(), str);
        }
        return -1;
    }

    @androidx.annotation.VisibleForTesting(otherwise = 2)
    public static int findColumnIndexBySuffix(java.lang.String[] strArr, java.lang.String str) {
        java.lang.String str2 = "." + str;
        java.lang.String str3 = "." + str + "`";
        for (int i = 0; i < strArr.length; i++) {
            java.lang.String str4 = strArr[i];
            if (str4.length() >= str.length() + 2) {
                if (str4.endsWith(str2)) {
                    return i;
                }
                if (str4.charAt(0) == '`' && str4.endsWith(str3)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int getColumnIndex(@androidx.annotation.NonNull android.database.Cursor cursor, @androidx.annotation.NonNull java.lang.String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + "`");
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(cursor, str);
    }

    public static int getColumnIndexOrThrow(@androidx.annotation.NonNull android.database.Cursor cursor, @androidx.annotation.NonNull java.lang.String str) {
        java.lang.String str2;
        int columnIndex = getColumnIndex(cursor, str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            str2 = java.util.Arrays.toString(cursor.getColumnNames());
        } catch (java.lang.Exception unused) {
            str2 = "";
        }
        throw new java.lang.IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }
}
