package com.ss.android.socialbase.downloader.utils;

/* loaded from: classes19.dex */
public class SqlUtils {
    public static java.lang.StringBuilder appendColumn(java.lang.StringBuilder sb, java.lang.String str) {
        sb.append(kotlin.text.Typography.quote);
        sb.append(str);
        sb.append(kotlin.text.Typography.quote);
        return sb;
    }

    public static java.lang.StringBuilder appendColumn(java.lang.StringBuilder sb, java.lang.String str, java.lang.String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append(kotlin.text.Typography.quote);
        return sb;
    }

    public static java.lang.StringBuilder appendColumns(java.lang.StringBuilder sb, java.lang.String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(kotlin.text.Typography.quote);
            sb.append(strArr[i]);
            sb.append(kotlin.text.Typography.quote);
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static java.lang.StringBuilder appendColumnsEqValue(java.lang.StringBuilder sb, java.lang.String str, java.lang.String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            appendColumn(sb, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static java.lang.StringBuilder appendColumnsEqualPlaceholders(java.lang.StringBuilder sb, java.lang.String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            appendColumn(sb, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static java.lang.StringBuilder appendPlaceholders(java.lang.StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static java.lang.String createSqlDelete(java.lang.String str, java.lang.String[] strArr) {
        java.lang.String str2 = "\"" + str + kotlin.text.Typography.quote;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            appendColumnsEqValue(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static java.lang.String createSqlInsert(java.lang.String str, java.lang.String str2, java.lang.String[] strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
        sb.append(kotlin.text.Typography.quote);
        sb.append(str2);
        sb.append(kotlin.text.Typography.quote);
        sb.append(" (");
        appendColumns(sb, strArr);
        sb.append(") VALUES (");
        appendPlaceholders(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static java.lang.String createSqlInsertOrReplace(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("INSERT OR REPLACE INTO ");
        sb.append("\"" + str + kotlin.text.Typography.quote);
        sb.append(" (");
        appendColumns(sb, strArr);
        sb.append(") VALUES (");
        appendPlaceholders(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static java.lang.String createSqlUpdate(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2) {
        java.lang.String str2 = "\"" + str + kotlin.text.Typography.quote;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        appendColumnsEqualPlaceholders(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            appendColumnsEqValue(sb, str2, strArr2);
        }
        return sb.toString();
    }
}
