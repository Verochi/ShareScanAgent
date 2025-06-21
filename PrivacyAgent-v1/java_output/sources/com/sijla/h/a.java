package com.sijla.h;

/* loaded from: classes19.dex */
public class a {
    private static java.util.Map<java.lang.String, com.sijla.h.a> a = new java.util.HashMap();
    private static /* synthetic */ boolean c = true;
    private com.sijla.h.a.C0454a b;

    /* renamed from: com.sijla.h.a$a, reason: collision with other inner class name */
    public class C0454a {
        protected java.io.File a;
        private final java.util.concurrent.atomic.AtomicLong b;
        private final java.util.concurrent.atomic.AtomicInteger c;
        private final long d;
        private final int e;
        private final java.util.Map<java.io.File, java.lang.Long> f;

        private C0454a(java.io.File file) {
            this.f = java.util.Collections.synchronizedMap(new java.util.HashMap());
            this.a = file;
            this.d = 50000000L;
            this.e = Integer.MAX_VALUE;
            this.b = new java.util.concurrent.atomic.AtomicLong();
            this.c = new java.util.concurrent.atomic.AtomicInteger();
            new java.lang.Thread(new com.sijla.h.b(this)).start();
        }

        public /* synthetic */ C0454a(com.sijla.h.a aVar, java.io.File file, byte b) {
            this(file);
        }

        private long a() {
            java.io.File file;
            if (this.f.isEmpty()) {
                return 0L;
            }
            java.util.Set<java.util.Map.Entry<java.io.File, java.lang.Long>> entrySet = this.f.entrySet();
            synchronized (this.f) {
                file = null;
                java.lang.Long l = null;
                for (java.util.Map.Entry<java.io.File, java.lang.Long> entry : entrySet) {
                    if (file == null) {
                        file = entry.getKey();
                        l = entry.getValue();
                    } else {
                        java.lang.Long value = entry.getValue();
                        if (value.longValue() < l.longValue()) {
                            file = entry.getKey();
                            l = value;
                        }
                    }
                }
            }
            long length = file.length();
            if (file.delete()) {
                this.f.remove(file);
            }
            return length;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public java.io.File a(java.lang.String str) {
            java.io.File b = b(str);
            java.lang.Long valueOf = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
            b.setLastModified(valueOf.longValue());
            this.f.put(b, valueOf);
            return b;
        }

        public static /* synthetic */ void a(com.sijla.h.a.C0454a c0454a, java.io.File file) {
            int i = c0454a.c.get();
            while (i + 1 > Integer.MAX_VALUE) {
                c0454a.b.addAndGet(-c0454a.a());
                i = c0454a.c.addAndGet(-1);
            }
            c0454a.c.addAndGet(1);
            long length = file.length();
            long j = c0454a.b.get();
            while (j + length > 50000000) {
                j = c0454a.b.addAndGet(-c0454a.a());
            }
            c0454a.b.addAndGet(length);
            java.lang.Long valueOf = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            c0454a.f.put(file, valueOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public java.io.File b(java.lang.String str) {
            if (this.a.getAbsolutePath().contains("../")) {
                return null;
            }
            return new java.io.File(this.a, java.lang.String.valueOf(str.hashCode()));
        }

        public static /* synthetic */ boolean c(com.sijla.h.a.C0454a c0454a, java.lang.String str) {
            return c0454a.a(str).delete();
        }
    }

    public static class b {
        public static /* synthetic */ boolean a(java.lang.String str) {
            return c(str.getBytes());
        }

        private static byte[] a(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                java.lang.System.arraycopy(bArr, i, bArr2, 0, java.lang.Math.min(bArr.length - i, i3));
                return bArr2;
            }
            throw new java.lang.IllegalArgumentException(i + " > " + i2);
        }

        public static /* synthetic */ java.lang.String b(java.lang.String str) {
            return (str == null || !d(str.getBytes())) ? str : str.substring(str.indexOf(32) + 1, str.length());
        }

        public static /* synthetic */ byte[] b(byte[] bArr) {
            return d(bArr) ? a(bArr, e(bArr) + 1, bArr.length) : bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean c(byte[] bArr) {
            java.lang.String[] strArr = d(bArr) ? new java.lang.String[]{new java.lang.String(a(bArr, 0, 13)), new java.lang.String(a(bArr, 14, e(bArr)))} : null;
            if (strArr != null) {
                java.lang.String str = strArr[0];
                while (str.startsWith("0")) {
                    str = str.substring(1, str.length());
                }
                if (java.lang.System.currentTimeMillis() > java.lang.Long.valueOf(str).longValue() + (java.lang.Long.valueOf(strArr[1]).longValue() * 1000)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean d(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && e(bArr) > 14;
        }

        private static int e(byte[] bArr) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] == 32) {
                    return i;
                }
            }
            return -1;
        }
    }

    private a(java.io.File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        this.b = new com.sijla.h.a.C0454a(this, file, (byte) 0);
    }

    public static com.sijla.h.a a(android.content.Context context) {
        java.io.File file = new java.io.File(context.getCacheDir(), "QCahe");
        com.sijla.h.a aVar = a.get(file.getAbsoluteFile() + a());
        if (aVar != null) {
            return aVar;
        }
        com.sijla.h.a aVar2 = new com.sijla.h.a(file);
        a.put(file.getAbsolutePath() + a(), aVar2);
        return aVar2;
    }

    private static java.lang.String a() {
        return "_" + android.os.Process.myPid();
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0053: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:37:0x0053 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] c(java.lang.String str) {
        java.io.RandomAccessFile randomAccessFile;
        java.io.RandomAccessFile randomAccessFile2;
        java.io.RandomAccessFile randomAccessFile3 = null;
        try {
            try {
                java.io.File a2 = this.b.a(str);
                if (!a2.exists()) {
                    return null;
                }
                randomAccessFile = new java.io.RandomAccessFile(a2, "r");
                try {
                    byte[] bArr = new byte[(int) randomAccessFile.length()];
                    randomAccessFile.read(bArr);
                    if (com.sijla.h.a.b.c(bArr)) {
                        try {
                            randomAccessFile.close();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                        d(str);
                        return null;
                    }
                    byte[] b2 = com.sijla.h.a.b.b(bArr);
                    try {
                        randomAccessFile.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                    return b2;
                } catch (java.lang.Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                randomAccessFile3 = randomAccessFile2;
                if (randomAccessFile3 != null) {
                    try {
                        randomAccessFile3.close();
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e6) {
            e = e6;
            randomAccessFile = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (randomAccessFile3 != null) {
            }
            throw th;
        }
    }

    private boolean d(java.lang.String str) {
        return com.sijla.h.a.C0454a.c(this.b, str);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    public final java.lang.String a(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.io.File a2 = this.b.a(str);
        ?? exists = a2.exists();
        java.io.BufferedReader bufferedReader2 = null;
        try {
            if (exists == 0) {
                return null;
            }
            try {
                if (a2.getAbsolutePath().contains("../")) {
                    return null;
                }
                bufferedReader = new java.io.BufferedReader(new java.io.FileReader(a2));
                java.lang.String str2 = "";
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str2 = str2 + readLine;
                    } catch (java.io.IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
                if (com.sijla.h.a.b.a(str2)) {
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                    d(str);
                    return null;
                }
                java.lang.String b2 = com.sijla.h.a.b.b(str2);
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
                return b2;
            } catch (java.io.IOException e5) {
                e = e5;
                bufferedReader = null;
            } catch (java.lang.Throwable th) {
                th = th;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedReader2 = exists;
        }
    }

    public final void a(java.lang.String str, java.io.Serializable serializable) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ObjectOutputStream objectOutputStream;
        com.sijla.h.a.C0454a c0454a;
        java.io.FileOutputStream fileOutputStream;
        java.io.ObjectOutputStream objectOutputStream2 = null;
        r0 = null;
        java.io.FileOutputStream fileOutputStream2 = null;
        objectOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
            } catch (java.lang.Exception e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(serializable);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            java.io.File b2 = this.b.b(str);
            if (!b2.exists()) {
                b2.getParentFile().mkdirs();
            }
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(b2);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
            }
            try {
                try {
                    fileOutputStream.write(byteArray);
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                    c0454a = this.b;
                } catch (java.lang.Exception e4) {
                    e = e4;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (java.io.IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    c0454a = this.b;
                    com.sijla.h.a.C0454a.a(c0454a, b2);
                    objectOutputStream.close();
                    return;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (java.io.IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    com.sijla.h.a.C0454a.a(this.b, b2);
                    throw th;
                }
                objectOutputStream.close();
                return;
            } catch (java.io.IOException unused) {
                return;
            }
            com.sijla.h.a.C0454a.a(c0454a, b2);
        } catch (java.lang.Exception e7) {
            e = e7;
            objectOutputStream2 = objectOutputStream;
            e.printStackTrace();
            try {
                if (!c && objectOutputStream2 == null) {
                    throw new java.lang.AssertionError();
                }
                objectOutputStream2.close();
            } catch (java.io.IOException unused2) {
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            objectOutputStream2 = objectOutputStream;
            if (!c && objectOutputStream2 == null) {
                throw new java.lang.AssertionError();
            }
            objectOutputStream2.close();
            throw th;
        }
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        java.io.BufferedWriter bufferedWriter;
        java.io.File b2 = this.b.b(str);
        if (!b2.exists()) {
            b2.getParentFile().mkdirs();
        }
        java.io.BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(b2), 1024);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            bufferedWriter.write(str2);
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (java.io.IOException e2) {
                e = e2;
                e.printStackTrace();
                com.sijla.h.a.C0454a.a(this.b, b2);
            }
        } catch (java.io.IOException e3) {
            e = e3;
            bufferedWriter2 = bufferedWriter;
            e.printStackTrace();
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                } catch (java.io.IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    com.sijla.h.a.C0454a.a(this.b, b2);
                }
            }
            com.sijla.h.a.C0454a.a(this.b, b2);
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                } catch (java.io.IOException e5) {
                    e5.printStackTrace();
                }
            }
            com.sijla.h.a.C0454a.a(this.b, b2);
            throw th;
        }
        com.sijla.h.a.C0454a.a(this.b, b2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r5v5 */
    public final java.lang.Object b(java.lang.String str) {
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.io.ObjectInputStream objectInputStream;
        ?? c2 = c(str);
        try {
            if (c2 == 0) {
                return null;
            }
            try {
                byteArrayInputStream = new java.io.ByteArrayInputStream(c2);
            } catch (java.lang.Exception e) {
                e = e;
                objectInputStream = null;
                byteArrayInputStream = null;
            } catch (java.lang.Throwable th) {
                byteArrayInputStream = null;
                th = th;
                c2 = 0;
            }
            try {
                objectInputStream = new java.io.ObjectInputStream(byteArrayInputStream);
                try {
                    java.lang.Object readObject = objectInputStream.readObject();
                    try {
                        byteArrayInputStream.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        objectInputStream.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                    return readObject;
                } catch (java.lang.Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (java.io.IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (java.io.IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (java.lang.Exception e7) {
                e = e7;
                objectInputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                c2 = 0;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (java.io.IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (c2 == 0) {
                    throw th;
                }
                try {
                    c2.close();
                    throw th;
                } catch (java.io.IOException e9) {
                    e9.printStackTrace();
                    throw th;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }
}
