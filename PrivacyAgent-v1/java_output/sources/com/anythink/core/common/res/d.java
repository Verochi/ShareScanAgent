package com.anythink.core.common.res;

/* loaded from: classes12.dex */
public class d {
    public static final java.lang.String a = "about:blank";
    private static final java.lang.String e = "anythink_internal_resouce";
    private static final java.lang.String f = "anythink_custom_resouce";
    private static final java.lang.String g = "anythink_internal_extra_resource";
    private static final java.lang.String h = "anythink_internal_video_resource";
    private static final java.lang.String i = "anythink_internal_html_resouce";
    private static volatile com.anythink.core.common.res.d j;
    private android.content.Context k;
    private java.io.File l;
    private final java.lang.String d = getClass().getSimpleName();
    java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.anythink.core.common.res.a> b = new java.util.concurrent.ConcurrentHashMap<>();
    final long c = com.baidu.mobads.sdk.internal.bm.e;

    private d(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.k = applicationContext;
        this.l = com.anythink.core.common.o.k.a(applicationContext);
    }

    private synchronized com.anythink.core.common.res.a a(int i2, java.io.File file) {
        com.anythink.core.common.res.a aVar;
        aVar = this.b.get(java.lang.Integer.valueOf(i2));
        if (aVar == null) {
            try {
                aVar = com.anythink.core.common.res.a.a(file, com.anythink.core.common.b.o.a().d(i2));
                this.b.put(java.lang.Integer.valueOf(i2), aVar);
            } catch (java.lang.Throwable th) {
                if (com.anythink.core.common.b.o.a().A()) {
                    th.printStackTrace();
                }
            }
        }
        return aVar;
    }

    public static com.anythink.core.common.res.d a(android.content.Context context) {
        if (j == null) {
            synchronized (com.anythink.core.common.res.d.class) {
                if (j == null) {
                    j = new com.anythink.core.common.res.d(context);
                }
            }
        }
        return j;
    }

    public static void c() {
        try {
            long d = com.anythink.core.common.b.o.a().d(1);
            java.lang.String a2 = a(com.anythink.core.common.b.o.a().f()).a(1);
            long a3 = com.anythink.core.common.o.k.a(a2);
            if (a3 <= 0 || a3 <= d * 1.5d) {
                return;
            }
            java.io.File[] listFiles = new java.io.File(a2).listFiles();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (listFiles != null) {
                java.util.Collections.addAll(arrayList, listFiles);
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (arrayList.size() > 0) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    java.io.File file = (java.io.File) arrayList.get(i2);
                    if (currentTimeMillis - file.lastModified() > com.baidu.mobads.sdk.internal.bm.e) {
                        try {
                            file.delete();
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final java.io.FileInputStream a(int i2, java.lang.String str) {
        java.io.InputStream a2;
        if (i2 == 4) {
            try {
                return new java.io.FileInputStream(new java.io.File(c(4, str)));
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }
        java.lang.String a3 = a(i2);
        if (android.text.TextUtils.isEmpty(a3)) {
            return null;
        }
        java.io.File file = new java.io.File(a3);
        if (!file.exists()) {
            file.mkdirs();
        }
        com.anythink.core.common.res.a a4 = a(i2, file);
        if (a4 != null) {
            try {
                com.anythink.core.common.res.a.c a5 = a4.a(str);
                if (a5 != null && (a2 = a5.a()) != null) {
                    return (java.io.FileInputStream) a2;
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public final java.lang.String a() {
        return this.l.getAbsolutePath();
    }

    public final java.lang.String a(int i2) {
        return new java.io.File(this.l, i2 != 1 ? i2 != 3 ? i2 != 4 ? f : h : g : e).getAbsolutePath();
    }

    public final java.lang.String a(java.lang.String str, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar) {
        java.io.FileOutputStream fileOutputStream;
        byte[] bytes;
        java.io.File file = new java.io.File(this.l, i);
        if (!file.exists()) {
            file.mkdirs();
        }
        java.io.File file2 = new java.io.File(file, mVar.d + "_" + lVar.s() + ".html");
        try {
            bytes = str.getBytes("utf-8");
            fileOutputStream = new java.io.FileOutputStream(file2);
        } catch (java.lang.Throwable unused) {
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bytes, 0, bytes.length);
            java.lang.String url = file2.toURL().toString();
            try {
                fileOutputStream.close();
                return url;
            } catch (java.lang.Throwable unused2) {
                return url;
            }
        } catch (java.lang.Throwable unused3) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (java.lang.Throwable unused4) {
                }
            }
            return "";
        }
    }

    public final void a(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar) {
        try {
            java.io.File file = new java.io.File(new java.io.File(this.l, i), mVar.d + "_" + lVar.s() + ".html");
            if (file.exists()) {
                file.delete();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new java.io.File(a(3) + java.io.File.separator + str + ".0").delete();
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(int i2, java.lang.String str, java.io.InputStream inputStream) {
        java.io.OutputStream outputStream;
        if (str == null || inputStream == null) {
            return false;
        }
        java.lang.String a2 = a(i2);
        if (android.text.TextUtils.isEmpty(a2)) {
            return false;
        }
        java.io.File file = new java.io.File(a2);
        if (!file.exists()) {
            file.mkdirs();
        }
        com.anythink.core.common.res.a a3 = a(i2, file);
        if (a3 == null) {
            return false;
        }
        com.anythink.core.common.res.a.C0169a c0169a = null;
        r1 = null;
        r1 = null;
        java.io.OutputStream outputStream2 = null;
        java.io.OutputStream outputStream3 = null;
        try {
            try {
                com.anythink.core.common.res.a.c a4 = a3.a(str);
                if (a4 == null) {
                    com.anythink.core.common.res.a.C0169a b = a3.b(str);
                    if (b != null) {
                        try {
                            outputStream2 = b.a(0);
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                outputStream2.write(bArr, 0, read);
                            }
                            b.a();
                            outputStream2.close();
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            java.io.OutputStream outputStream4 = outputStream2;
                            c0169a = b;
                            outputStream = outputStream4;
                            try {
                                e.toString();
                                if (c0169a != null) {
                                    try {
                                        c0169a.b();
                                    } catch (java.lang.Exception e3) {
                                        e3.printStackTrace();
                                        if (outputStream != null) {
                                            return false;
                                        }
                                        try {
                                            outputStream.close();
                                            return false;
                                        } catch (java.io.IOException unused) {
                                            return false;
                                        }
                                    }
                                }
                                if (outputStream != null) {
                                }
                            } catch (java.lang.Throwable th) {
                                outputStream3 = outputStream;
                                th = th;
                                if (outputStream3 != null) {
                                }
                                throw th;
                            }
                        }
                    }
                } else {
                    a4.a().close();
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
                return true;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (outputStream3 != null) {
                    try {
                        outputStream3.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            outputStream = null;
        }
    }

    public final java.io.File b(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar) {
        java.io.File file = new java.io.File(new java.io.File(this.l, i), mVar.d + "_" + lVar.s() + ".html");
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public final void b() {
        java.io.File[] listFiles;
        try {
            java.io.File file = new java.io.File(this.l, i);
            if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                return;
            }
            for (java.io.File file2 : listFiles) {
                try {
                    if (file2.isFile() && java.lang.System.currentTimeMillis() - file2.lastModified() > 86400000) {
                        file2.delete();
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public final boolean b(int i2, java.lang.String str) {
        java.io.File file;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        if (i2 != 4) {
            file = new java.io.File(a(i2) + java.io.File.separator + str + ".0");
        } else {
            file = new java.io.File(a(i2) + java.io.File.separator + str);
        }
        return file.exists();
    }

    public final java.lang.String c(int i2, java.lang.String str) {
        if (i2 == 4) {
            return a(i2) + java.io.File.separator + str;
        }
        return a(i2) + java.io.File.separator + str + ".0";
    }
}
