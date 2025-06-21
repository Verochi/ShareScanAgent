package com.bytedance.pangle.util.a;

/* loaded from: classes.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String[] a(java.io.File file) {
        java.lang.String str;
        java.lang.String str2;
        java.util.zip.ZipFile zipFile = null;
        try {
            java.util.zip.ZipFile zipFile2 = new java.util.zip.ZipFile(file);
            try {
                java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile2.entries();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                while (entries.hasMoreElements()) {
                    java.util.zip.ZipEntry nextElement = entries.nextElement();
                    if (nextElement.getName().startsWith("META-INF/")) {
                        if (nextElement.getName().endsWith("MANIFEST.MF")) {
                            z3 = true;
                        } else if (nextElement.getName().endsWith(".SF")) {
                            z = true;
                        } else if (nextElement.getName().endsWith(".RSA")) {
                            z2 = true;
                        }
                        arrayList.add(java.lang.Long.valueOf(nextElement.getCrc()));
                    }
                }
                java.util.Collections.sort(arrayList, java.util.Collections.reverseOrder());
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb.append((java.lang.Long) it.next());
                }
                if (z3 && z && z2) {
                    str = com.bytedance.pangle.util.f.a(sb.toString());
                    str2 = "";
                } else {
                    str2 = "without v1 signature.";
                    str = "";
                }
                com.bytedance.pangle.util.a.c.a(zipFile2);
            } catch (java.lang.Exception unused) {
                zipFile = zipFile2;
                com.bytedance.pangle.util.a.c.a(zipFile);
                str = "";
                str2 = str;
                java.lang.String[] strArr = new java.lang.String[3];
                strArr[0] = str;
                strArr[1] = android.text.TextUtils.isEmpty(str) ? "" : com.igexin.push.core.g.e;
                strArr[2] = str2;
                return strArr;
            } catch (java.lang.Throwable th) {
                th = th;
                zipFile = zipFile2;
                com.bytedance.pangle.util.a.c.a(zipFile);
                throw th;
            }
        } catch (java.lang.Exception unused2) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        java.lang.String[] strArr2 = new java.lang.String[3];
        strArr2[0] = str;
        strArr2[1] = android.text.TextUtils.isEmpty(str) ? "" : com.igexin.push.core.g.e;
        strArr2[2] = str2;
        return strArr2;
    }
}
