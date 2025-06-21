package com.xiaomi.push;

/* loaded from: classes19.dex */
final class ae implements com.xiaomi.push.u {
    private static java.lang.String a = "content://com.vivo.vms.IdProvider/IdentifierId/";
    private static java.lang.String b = a + "OAID";
    private static java.lang.String c = a + "VAID_";
    private static java.lang.String d = a + "AAID_";
    private static java.lang.String e = a + com.alipay.sdk.m.p0.b.h;
    private static java.lang.String f = com.alipay.sdk.m.p0.c.c;
    private android.content.Context g;

    public ae(android.content.Context context) {
        this.g = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        if (r10 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002a, code lost:
    
        if (r10 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002c, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003f, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String a(java.lang.String str) {
        java.lang.Throwable th;
        android.database.Cursor cursor;
        java.lang.String str2 = null;
        try {
            cursor = this.g.getContentResolver().query(android.net.Uri.parse(str), null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        str2 = cursor.getString(cursor.getColumnIndex("value"));
                    }
                } catch (java.lang.Exception unused) {
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (java.lang.Exception unused2) {
            cursor = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public static boolean a(android.content.Context context) {
        try {
            android.content.pm.ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(android.net.Uri.parse(a).getAuthority(), 128);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    @Override // com.xiaomi.push.u
    public final boolean a() {
        return "1".equals(com.xiaomi.push.jb.a(f, "0"));
    }

    @Override // com.xiaomi.push.u
    public final java.lang.String b() {
        return a(b);
    }
}
