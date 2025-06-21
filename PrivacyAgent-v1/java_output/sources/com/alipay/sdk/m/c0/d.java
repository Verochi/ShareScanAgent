package com.alipay.sdk.m.c0;

/* loaded from: classes.dex */
public final class d {
    public static java.lang.String a = "";
    public static java.lang.String b = "";
    public static java.lang.String c = "";

    public static synchronized void a(java.lang.String str) {
        synchronized (com.alipay.sdk.m.c0.d.class) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(str);
            a(arrayList);
        }
    }

    public static synchronized void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        synchronized (com.alipay.sdk.m.c0.d.class) {
            a = str;
            b = str2;
            c = str3;
        }
    }

    public static synchronized void a(java.lang.Throwable th) {
        java.lang.String str;
        synchronized (com.alipay.sdk.m.c0.d.class) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (th != null) {
                java.io.StringWriter stringWriter = new java.io.StringWriter();
                th.printStackTrace(new java.io.PrintWriter(stringWriter));
                str = stringWriter.toString();
            } else {
                str = "";
            }
            arrayList.add(str);
            a(arrayList);
        }
    }

    public static synchronized void a(java.util.List<java.lang.String> list) {
        synchronized (com.alipay.sdk.m.c0.d.class) {
            if (!com.alipay.sdk.m.z.a.a(b) && !com.alipay.sdk.m.z.a.a(c)) {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                stringBuffer.append(c);
                java.util.Iterator<java.lang.String> it = list.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(", " + it.next());
                }
                stringBuffer.append("\n");
                try {
                    java.io.File file = new java.io.File(a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    java.io.File file2 = new java.io.File(a, b);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    java.io.FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new java.io.FileWriter(file2, true) : new java.io.FileWriter(file2);
                    fileWriter.write(stringBuffer.toString());
                    fileWriter.flush();
                    fileWriter.close();
                } catch (java.lang.Exception unused) {
                }
            }
        }
    }
}
