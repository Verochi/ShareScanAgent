package org.repackage.com.vivo.identifier;

/* loaded from: classes26.dex */
public class DataBaseOperation {
    public android.content.Context a;

    public DataBaseOperation(android.content.Context context) {
        this.a = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
    
        if (r8 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0095, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a4, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
    
        if (r8 == null) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String a(int i, java.lang.String str) {
        android.net.Uri parse;
        android.net.Uri uri;
        android.database.Cursor cursor;
        android.database.Cursor cursor2 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        java.lang.String str2 = null;
        if (i == 0) {
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i == 1) {
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else if (i == 2) {
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        } else if (i == 3) {
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/UDID");
        } else if (i == 4) {
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_" + str);
        } else if (i != 5) {
            uri = null;
            if (uri != null) {
                return null;
            }
            try {
                cursor = this.a.getContentResolver().query(uri, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            str2 = cursor.getString(cursor.getColumnIndex("value"));
                        }
                    } catch (java.lang.Exception unused) {
                    } catch (java.lang.Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            } catch (java.lang.Exception unused2) {
                cursor = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } else {
            parse = android.net.Uri.parse("content://com.vivo.abe.exidentifier/guid");
        }
        uri = parse;
        if (uri != null) {
        }
    }

    public boolean b(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.net.Uri parse;
        int delete;
        if (i != 6) {
            parse = null;
        } else {
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            delete = this.a.getContentResolver().delete(parse, "packageName=? and uid=?", new java.lang.String[]{str2, str3});
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("delete:");
            sb.append(delete);
        } catch (java.lang.Exception unused) {
        }
        return delete != 0;
    }

    public boolean c(int i, java.lang.String str, android.content.ContentValues[] contentValuesArr) {
        android.net.Uri parse;
        int bulkInsert;
        if (i == 6) {
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i != 7) {
            parse = null;
        } else {
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            bulkInsert = this.a.getContentResolver().bulkInsert(parse, contentValuesArr);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("insert:");
            sb.append(bulkInsert);
        } catch (java.lang.Exception unused) {
        }
        return bulkInsert != 0;
    }
}
