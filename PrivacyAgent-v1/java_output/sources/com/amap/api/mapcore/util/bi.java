package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class bi {
    private com.amap.api.mapcore.util.bi.b a;

    /* renamed from: com.amap.api.mapcore.util.bi$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.amap.api.mapcore.util.bi.c {
        final /* synthetic */ com.amap.api.mapcore.util.be a;

        public AnonymousClass1(com.amap.api.mapcore.util.be beVar) {
            this.a = beVar;
        }

        @Override // com.amap.api.mapcore.util.bi.c
        public final void a() {
            com.amap.api.mapcore.util.be beVar = this.a;
            if (beVar != null) {
                beVar.q();
            }
        }

        @Override // com.amap.api.mapcore.util.bi.c
        public final void a(long j) {
            try {
                com.amap.api.mapcore.util.be beVar = this.a;
                if (beVar != null) {
                    beVar.a(j);
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static class a {
        public boolean a = false;
    }

    public static class b {
        private java.lang.String a;
        private java.lang.String b;
        private com.amap.api.mapcore.util.be c;
        private com.amap.api.mapcore.util.bi.a d = new com.amap.api.mapcore.util.bi.a();
        private java.lang.String e;

        public b(com.amap.api.mapcore.util.bf bfVar, com.amap.api.mapcore.util.be beVar) {
            this.c = null;
            this.a = bfVar.x();
            this.b = bfVar.y();
            this.c = beVar;
        }

        public final java.lang.String a() {
            return this.a;
        }

        public final void a(java.lang.String str) {
            if (str.length() > 1) {
                this.e = str;
            }
        }

        public final java.lang.String b() {
            return this.b;
        }

        public final java.lang.String c() {
            return this.e;
        }

        public final com.amap.api.mapcore.util.be d() {
            return this.c;
        }

        public final com.amap.api.mapcore.util.bi.a e() {
            return this.d;
        }

        public final void f() {
            this.d.a = true;
        }
    }

    public interface c {
        void a();

        void a(long j);
    }

    public bi(com.amap.api.mapcore.util.bf bfVar, com.amap.api.mapcore.util.be beVar) {
        this.a = new com.amap.api.mapcore.util.bi.b(bfVar, beVar);
    }

    private static int a(java.io.File file, java.util.zip.ZipInputStream zipInputStream, long j, long j2, com.amap.api.mapcore.util.bi.c cVar, com.amap.api.mapcore.util.bi.a aVar) throws java.lang.Exception {
        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i;
            }
            if (aVar != null && aVar.a) {
                bufferedOutputStream.close();
                return i;
            }
            bufferedOutputStream.write(bArr, 0, read);
            i += read;
            if (j2 > 0 && cVar != null) {
                long j3 = ((i + j) * 100) / j2;
                if (aVar == null || !aVar.a) {
                    cVar.a(j3);
                }
            }
        }
    }

    private static void a(com.amap.api.mapcore.util.bi.b bVar) {
        if (bVar == null) {
            return;
        }
        com.amap.api.mapcore.util.be d = bVar.d();
        if (d != null) {
            d.p();
        }
        java.lang.String a2 = bVar.a();
        java.lang.String b2 = bVar.b();
        if (android.text.TextUtils.isEmpty(a2) || android.text.TextUtils.isEmpty(b2)) {
            if (bVar.e().a) {
                if (d != null) {
                    d.r();
                    return;
                }
                return;
            } else {
                if (d != null) {
                    d.q();
                    return;
                }
                return;
            }
        }
        java.io.File file = new java.io.File(a2);
        if (!file.exists()) {
            if (bVar.e().a) {
                if (d != null) {
                    d.r();
                    return;
                }
                return;
            } else {
                if (d != null) {
                    d.q();
                    return;
                }
                return;
            }
        }
        java.io.File file2 = new java.io.File(b2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        com.amap.api.mapcore.util.bi.AnonymousClass1 anonymousClass1 = new com.amap.api.mapcore.util.bi.AnonymousClass1(d);
        try {
            if (bVar.e().a && d != null) {
                d.r();
            }
            a(file, file2, anonymousClass1, bVar);
            if (bVar.e().a) {
                if (d != null) {
                    d.r();
                }
            } else if (d != null) {
                d.b(bVar.c());
            }
        } catch (java.lang.Throwable unused) {
            if (bVar.e().a) {
                if (d != null) {
                    d.r();
                }
            } else if (d != null) {
                d.q();
            }
        }
    }

    private static void a(java.io.File file) {
        java.io.File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        a(parentFile);
        parentFile.mkdir();
    }

    private static void a(java.io.File file, java.io.File file2, com.amap.api.mapcore.util.bi.c cVar, com.amap.api.mapcore.util.bi.b bVar) throws java.lang.Exception {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        com.amap.api.mapcore.util.bi.a e = bVar.e();
        long j = 0;
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            java.util.zip.CheckedInputStream checkedInputStream = new java.util.zip.CheckedInputStream(fileInputStream, new java.util.zip.CRC32());
            java.util.zip.ZipInputStream zipInputStream = new java.util.zip.ZipInputStream(checkedInputStream);
            while (true) {
                java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (e != null && e.a) {
                        zipInputStream.closeEntry();
                        zipInputStream.close();
                        checkedInputStream.close();
                        fileInputStream.close();
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        if (!a(nextEntry.getName())) {
                            cVar.a();
                            break;
                        } else {
                            stringBuffer.append(nextEntry.getName());
                            stringBuffer.append(com.alipay.sdk.m.u.i.b);
                        }
                    }
                    j += nextEntry.getSize();
                    zipInputStream.closeEntry();
                } else {
                    break;
                }
            }
            bVar.a(stringBuffer.toString());
            zipInputStream.close();
            checkedInputStream.close();
            fileInputStream.close();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
        java.util.zip.CheckedInputStream checkedInputStream2 = new java.util.zip.CheckedInputStream(fileInputStream2, new java.util.zip.CRC32());
        java.util.zip.ZipInputStream zipInputStream2 = new java.util.zip.ZipInputStream(checkedInputStream2);
        a(file2, zipInputStream2, j, cVar, e);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    private static void a(java.io.File file, java.util.zip.ZipInputStream zipInputStream, long j, com.amap.api.mapcore.util.bi.c cVar, com.amap.api.mapcore.util.bi.a aVar) throws java.lang.Exception {
        int i = 0;
        while (true) {
            java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (aVar != null && aVar.a) {
                zipInputStream.closeEntry();
                return;
            }
            java.lang.String str = file.getPath() + java.io.File.separator + nextEntry.getName();
            if (!a(nextEntry.getName())) {
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            } else {
                java.io.File file2 = new java.io.File(str);
                a(file2);
                if (nextEntry.isDirectory()) {
                    file2.mkdirs();
                } else {
                    i += a(file2, zipInputStream, i, j, cVar, aVar);
                }
                zipInputStream.closeEntry();
            }
        }
    }

    private static boolean a(java.lang.String str) {
        return (str.contains("..") || str.contains(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) || str.contains("\\") || str.contains("%")) ? false : true;
    }

    public final void a() {
        com.amap.api.mapcore.util.bi.b bVar = this.a;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void b() {
        com.amap.api.mapcore.util.bi.b bVar = this.a;
        if (bVar != null) {
            a(bVar);
        }
    }
}
