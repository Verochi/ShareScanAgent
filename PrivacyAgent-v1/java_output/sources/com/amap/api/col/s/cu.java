package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class cu implements java.io.Closeable {
    public static final java.util.concurrent.ThreadFactory I;
    public static java.util.concurrent.ThreadPoolExecutor J;
    public static final java.io.OutputStream K;
    public java.io.Writer A;
    public int D;
    public final java.io.File n;
    public final java.io.File t;
    public final java.io.File u;
    public final java.io.File v;
    public long x;
    public static final java.util.regex.Pattern G = java.util.regex.Pattern.compile("[a-z0-9_-]{1,120}");
    public static final java.nio.charset.Charset b = java.nio.charset.Charset.forName("US-ASCII");
    public static final java.nio.charset.Charset H = java.nio.charset.Charset.forName("UTF-8");
    public long z = 0;
    public int B = 1000;
    public final java.util.LinkedHashMap<java.lang.String, com.amap.api.col.s.cu.c> C = new java.util.LinkedHashMap<>(0, 0.75f, true);
    public long E = 0;
    public final java.util.concurrent.Callable<java.lang.Void> F = new com.amap.api.col.s.cu.AnonymousClass2();
    public final int w = 1;
    public final int y = 1;

    /* renamed from: com.amap.api.col.s.cu$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        public final java.util.concurrent.atomic.AtomicInteger n = new java.util.concurrent.atomic.AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "disklrucache#" + this.n.getAndIncrement());
        }
    }

    /* renamed from: com.amap.api.col.s.cu$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.concurrent.Callable<java.lang.Void> {
        public AnonymousClass2() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final java.lang.Void call() throws java.lang.Exception {
            synchronized (com.amap.api.col.s.cu.this) {
                if (com.amap.api.col.s.cu.this.A == null) {
                    return null;
                }
                com.amap.api.col.s.cu.this.w();
                if (com.amap.api.col.s.cu.this.u()) {
                    com.amap.api.col.s.cu.this.t();
                    com.amap.api.col.s.cu.m(com.amap.api.col.s.cu.this);
                }
                return null;
            }
        }
    }

    /* renamed from: com.amap.api.col.s.cu$3, reason: invalid class name */
    public static class AnonymousClass3 extends java.io.OutputStream {
        @Override // java.io.OutputStream
        public final void write(int i) throws java.io.IOException {
        }
    }

    public final class a {
        public final com.amap.api.col.s.cu.c a;
        public final boolean[] b;
        public boolean c;
        public boolean d;

        /* renamed from: com.amap.api.col.s.cu$a$a, reason: collision with other inner class name */
        public class C0116a extends java.io.FilterOutputStream {
            public C0116a(java.io.OutputStream outputStream) {
                super(outputStream);
            }

            public /* synthetic */ C0116a(com.amap.api.col.s.cu.a aVar, java.io.OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((java.io.FilterOutputStream) this).out.close();
                } catch (java.io.IOException unused) {
                    com.amap.api.col.s.cu.a.d(com.amap.api.col.s.cu.a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((java.io.FilterOutputStream) this).out.flush();
                } catch (java.io.IOException unused) {
                    com.amap.api.col.s.cu.a.d(com.amap.api.col.s.cu.a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((java.io.FilterOutputStream) this).out.write(i);
                } catch (java.io.IOException unused) {
                    com.amap.api.col.s.cu.a.d(com.amap.api.col.s.cu.a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((java.io.FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (java.io.IOException unused) {
                    com.amap.api.col.s.cu.a.d(com.amap.api.col.s.cu.a.this);
                }
            }
        }

        public a(com.amap.api.col.s.cu.c cVar) {
            this.a = cVar;
            this.b = cVar.c ? null : new boolean[com.amap.api.col.s.cu.this.y];
        }

        public /* synthetic */ a(com.amap.api.col.s.cu cuVar, com.amap.api.col.s.cu.c cVar, byte b) {
            this(cVar);
        }

        public static /* synthetic */ boolean d(com.amap.api.col.s.cu.a aVar) {
            aVar.c = true;
            return true;
        }

        public final java.io.OutputStream a() throws java.io.IOException {
            java.io.FileOutputStream fileOutputStream;
            com.amap.api.col.s.cu.a.C0116a c0116a;
            if (com.amap.api.col.s.cu.this.y <= 0) {
                throw new java.lang.IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + com.amap.api.col.s.cu.this.y);
            }
            synchronized (com.amap.api.col.s.cu.this) {
                if (this.a.d != this) {
                    throw new java.lang.IllegalStateException();
                }
                if (!this.a.c) {
                    this.b[0] = true;
                }
                java.io.File i = this.a.i(0);
                try {
                    fileOutputStream = new java.io.FileOutputStream(i);
                } catch (java.io.FileNotFoundException unused) {
                    com.amap.api.col.s.cu.this.n.mkdirs();
                    try {
                        fileOutputStream = new java.io.FileOutputStream(i);
                    } catch (java.io.FileNotFoundException unused2) {
                        return com.amap.api.col.s.cu.K;
                    }
                }
                c0116a = new com.amap.api.col.s.cu.a.C0116a(this, fileOutputStream, (byte) 0);
            }
            return c0116a;
        }

        public final void b() throws java.io.IOException {
            if (this.c) {
                com.amap.api.col.s.cu.this.c(this, false);
                com.amap.api.col.s.cu.this.c(this.a.a);
            } else {
                com.amap.api.col.s.cu.this.c(this, true);
            }
            this.d = true;
        }

        public final void c() throws java.io.IOException {
            com.amap.api.col.s.cu.this.c(this, false);
        }
    }

    public final class b implements java.io.Closeable {
        public final java.lang.String n;
        public final long t;
        public final java.io.InputStream[] u;
        public final long[] v;

        public b(java.lang.String str, long j, java.io.InputStream[] inputStreamArr, long[] jArr) {
            this.n = str;
            this.t = j;
            this.u = inputStreamArr;
            this.v = jArr;
        }

        public /* synthetic */ b(com.amap.api.col.s.cu cuVar, java.lang.String str, long j, java.io.InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, inputStreamArr, jArr);
        }

        public final java.io.InputStream a() {
            return this.u[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (java.io.InputStream inputStream : this.u) {
                com.amap.api.col.s.cu.a(inputStream);
            }
        }
    }

    public final class c {
        public final java.lang.String a;
        public final long[] b;
        public boolean c;
        public com.amap.api.col.s.cu.a d;
        public long e;

        public c(java.lang.String str) {
            this.a = str;
            this.b = new long[com.amap.api.col.s.cu.this.y];
        }

        public /* synthetic */ c(com.amap.api.col.s.cu cuVar, java.lang.String str, byte b) {
            this(str);
        }

        public static java.io.IOException d(java.lang.String[] strArr) throws java.io.IOException {
            throw new java.io.IOException("unexpected journal line: " + java.util.Arrays.toString(strArr));
        }

        public static /* synthetic */ void f(com.amap.api.col.s.cu.c cVar, java.lang.String[] strArr) throws java.io.IOException {
            if (strArr.length != com.amap.api.col.s.cu.this.y) {
                throw d(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    cVar.b[i] = java.lang.Long.parseLong(strArr[i]);
                } catch (java.lang.NumberFormatException unused) {
                    throw d(strArr);
                }
            }
        }

        public static /* synthetic */ boolean g(com.amap.api.col.s.cu.c cVar) {
            cVar.c = true;
            return true;
        }

        public final java.io.File c(int i) {
            return new java.io.File(com.amap.api.col.s.cu.this.n, this.a + "." + i);
        }

        public final java.lang.String e() throws java.io.IOException {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (long j : this.b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final java.io.File i(int i) {
            return new java.io.File(com.amap.api.col.s.cu.this.n, this.a + "." + i + com.baidu.mobads.sdk.internal.al.k);
        }
    }

    static {
        com.amap.api.col.s.cu.AnonymousClass1 anonymousClass1 = new com.amap.api.col.s.cu.AnonymousClass1();
        I = anonymousClass1;
        J = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), anonymousClass1);
        K = new com.amap.api.col.s.cu.AnonymousClass3();
    }

    public cu(java.io.File file, long j) {
        this.n = file;
        this.t = new java.io.File(file, "journal");
        this.u = new java.io.File(file, "journal.tmp");
        this.v = new java.io.File(file, "journal.bkp");
        this.x = j;
    }

    public static com.amap.api.col.s.cu a(java.io.File file, long j) throws java.io.IOException {
        if (j <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        java.io.File file2 = new java.io.File(file, "journal.bkp");
        if (file2.exists()) {
            java.io.File file3 = new java.io.File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                f(file2, file3, false);
            }
        }
        com.amap.api.col.s.cu cuVar = new com.amap.api.col.s.cu(file, j);
        if (cuVar.t.exists()) {
            try {
                cuVar.q();
                cuVar.s();
                cuVar.A = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(cuVar.t, true), b));
                return cuVar;
            } catch (java.lang.Throwable unused) {
                cuVar.c();
            }
        }
        file.mkdirs();
        com.amap.api.col.s.cu cuVar2 = new com.amap.api.col.s.cu(file, j);
        cuVar2.t();
        return cuVar2;
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e) {
                throw e;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void e(java.io.File file) throws java.io.IOException {
        if (file.exists() && !file.delete()) {
            throw new java.io.IOException();
        }
    }

    public static void f(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        if (z) {
            e(file2);
        }
        if (!file.renameTo(file2)) {
            throw new java.io.IOException();
        }
    }

    public static void h(java.io.File file) throws java.io.IOException {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new java.io.IOException("not a readable directory: ".concat(java.lang.String.valueOf(file)));
        }
        for (java.io.File file2 : listFiles) {
            if (file2.isDirectory()) {
                h(file2);
            }
            if (!file2.delete()) {
                throw new java.io.IOException("failed to delete file: ".concat(java.lang.String.valueOf(file2)));
            }
        }
    }

    public static /* synthetic */ int m(com.amap.api.col.s.cu cuVar) {
        cuVar.D = 0;
        return 0;
    }

    public static java.util.concurrent.ThreadPoolExecutor n() {
        try {
            java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = J;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                J = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(256), I);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return J;
    }

    public static void o(java.lang.String str) {
        if (G.matcher(str).matches()) {
            return;
        }
        throw new java.lang.IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public final synchronized com.amap.api.col.s.cu.b a(java.lang.String str) throws java.io.IOException {
        java.io.InputStream inputStream;
        v();
        o(str);
        com.amap.api.col.s.cu.c cVar = this.C.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.c) {
            return null;
        }
        java.io.InputStream[] inputStreamArr = new java.io.InputStream[this.y];
        for (int i = 0; i < this.y; i++) {
            try {
                inputStreamArr[i] = new java.io.FileInputStream(cVar.c(i));
            } catch (java.io.FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.y && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    a(inputStream);
                }
                return null;
            }
        }
        this.D++;
        this.A.append((java.lang.CharSequence) ("READ " + str + '\n'));
        if (u()) {
            n().submit(this.F);
        }
        return new com.amap.api.col.s.cu.b(this, str, cVar.e, inputStreamArr, cVar.b, (byte) 0);
    }

    public final java.io.File a() {
        return this.n;
    }

    public final void a(int i) {
        if (i < 10) {
            i = 10;
        } else if (i > 10000) {
            i = 10000;
        }
        this.B = i;
    }

    public final com.amap.api.col.s.cu.a b(java.lang.String str) throws java.io.IOException {
        return j(str);
    }

    public final synchronized void b() throws java.io.IOException {
        v();
        w();
        this.A.flush();
    }

    public final void c() throws java.io.IOException {
        close();
        h(this.n);
    }

    public final synchronized void c(com.amap.api.col.s.cu.a aVar, boolean z) throws java.io.IOException {
        com.amap.api.col.s.cu.c cVar = aVar.a;
        if (cVar.d != aVar) {
            throw new java.lang.IllegalStateException();
        }
        if (z && !cVar.c) {
            for (int i = 0; i < this.y; i++) {
                if (!aVar.b[i]) {
                    aVar.c();
                    throw new java.lang.IllegalStateException("Newly created entry didn't create value for index ".concat(java.lang.String.valueOf(i)));
                }
                if (!cVar.i(i).exists()) {
                    aVar.c();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.y; i2++) {
            java.io.File i3 = cVar.i(i2);
            if (!z) {
                e(i3);
            } else if (i3.exists()) {
                java.io.File c2 = cVar.c(i2);
                i3.renameTo(c2);
                long j = cVar.b[i2];
                long length = c2.length();
                cVar.b[i2] = length;
                this.z = (this.z - j) + length;
            }
        }
        this.D++;
        cVar.d = null;
        if (cVar.c || z) {
            com.amap.api.col.s.cu.c.g(cVar);
            this.A.write("CLEAN " + cVar.a + cVar.e() + '\n');
            if (z) {
                long j2 = this.E;
                this.E = 1 + j2;
                cVar.e = j2;
            }
        } else {
            this.C.remove(cVar.a);
            this.A.write("REMOVE " + cVar.a + '\n');
        }
        this.A.flush();
        if (this.z > this.x || u()) {
            n().submit(this.F);
        }
    }

    public final synchronized boolean c(java.lang.String str) throws java.io.IOException {
        v();
        o(str);
        com.amap.api.col.s.cu.c cVar = this.C.get(str);
        if (cVar != null && cVar.d == null) {
            for (int i = 0; i < this.y; i++) {
                java.io.File c2 = cVar.c(i);
                if (c2.exists() && !c2.delete()) {
                    throw new java.io.IOException("failed to delete ".concat(java.lang.String.valueOf(c2)));
                }
                this.z -= cVar.b[i];
                cVar.b[i] = 0;
            }
            this.D++;
            this.A.append((java.lang.CharSequence) ("REMOVE " + str + '\n'));
            this.C.remove(str);
            if (u()) {
                n().submit(this.F);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws java.io.IOException {
        if (this.A == null) {
            return;
        }
        java.util.Iterator it = new java.util.ArrayList(this.C.values()).iterator();
        while (it.hasNext()) {
            com.amap.api.col.s.cu.c cVar = (com.amap.api.col.s.cu.c) it.next();
            if (cVar.d != null) {
                cVar.d.c();
            }
        }
        w();
        this.A.close();
        this.A = null;
    }

    public final synchronized com.amap.api.col.s.cu.a j(java.lang.String str) throws java.io.IOException {
        v();
        o(str);
        com.amap.api.col.s.cu.c cVar = this.C.get(str);
        if (cVar == null) {
            cVar = new com.amap.api.col.s.cu.c(this, str, (byte) 0);
            this.C.put(str, cVar);
        } else if (cVar.d != null) {
            return null;
        }
        com.amap.api.col.s.cu.a aVar = new com.amap.api.col.s.cu.a(this, cVar, (byte) 0);
        cVar.d = aVar;
        this.A.write("DIRTY " + str + '\n');
        this.A.flush();
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ed, code lost:
    
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q() throws java.io.IOException {
        java.lang.String substring;
        com.amap.api.col.s.cv cvVar = new com.amap.api.col.s.cv(new java.io.FileInputStream(this.t), b);
        try {
            java.lang.String a2 = cvVar.a();
            java.lang.String a3 = cvVar.a();
            java.lang.String a4 = cvVar.a();
            java.lang.String a5 = cvVar.a();
            java.lang.String a6 = cvVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !java.lang.Integer.toString(this.w).equals(a4) || !java.lang.Integer.toString(this.y).equals(a5) || !"".equals(a6)) {
                throw new java.io.IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    java.lang.String a7 = cvVar.a();
                    int indexOf = a7.indexOf(32);
                    if (indexOf == -1) {
                        throw new java.io.IOException("unexpected journal line: ".concat(a7));
                    }
                    int i2 = indexOf + 1;
                    int indexOf2 = a7.indexOf(32, i2);
                    if (indexOf2 == -1) {
                        substring = a7.substring(i2);
                        if (indexOf == 6 && a7.startsWith("REMOVE")) {
                            this.C.remove(substring);
                            i++;
                        }
                    } else {
                        substring = a7.substring(i2, indexOf2);
                    }
                    com.amap.api.col.s.cu.c cVar = this.C.get(substring);
                    if (cVar == null) {
                        cVar = new com.amap.api.col.s.cu.c(this, substring, (byte) 0);
                        this.C.put(substring, cVar);
                    }
                    if (indexOf2 != -1 && indexOf == 5 && a7.startsWith("CLEAN")) {
                        java.lang.String[] split = a7.substring(indexOf2 + 1).split(" ");
                        com.amap.api.col.s.cu.c.g(cVar);
                        cVar.d = null;
                        com.amap.api.col.s.cu.c.f(cVar, split);
                    } else if (indexOf2 == -1 && indexOf == 5 && a7.startsWith("DIRTY")) {
                        cVar.d = new com.amap.api.col.s.cu.a(this, cVar, (byte) 0);
                    } else if (indexOf2 != -1 || indexOf != 4 || !a7.startsWith("READ")) {
                        break;
                    }
                    i++;
                } catch (java.io.EOFException unused) {
                    this.D = i - this.C.size();
                    a(cvVar);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            a(cvVar);
            throw th;
        }
    }

    public final void s() throws java.io.IOException {
        e(this.u);
        java.util.Iterator<com.amap.api.col.s.cu.c> it = this.C.values().iterator();
        while (it.hasNext()) {
            com.amap.api.col.s.cu.c next = it.next();
            int i = 0;
            if (next.d == null) {
                while (i < this.y) {
                    this.z += next.b[i];
                    i++;
                }
            } else {
                next.d = null;
                while (i < this.y) {
                    e(next.c(i));
                    e(next.i(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public final synchronized void t() throws java.io.IOException {
        java.io.Writer writer = this.A;
        if (writer != null) {
            writer.close();
        }
        java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.u), b));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(java.lang.Integer.toString(this.w));
            bufferedWriter.write("\n");
            bufferedWriter.write(java.lang.Integer.toString(this.y));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (com.amap.api.col.s.cu.c cVar : this.C.values()) {
                if (cVar.d != null) {
                    bufferedWriter.write("DIRTY " + cVar.a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.a + cVar.e() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.t.exists()) {
                f(this.t, this.v, true);
            }
            f(this.u, this.t, false);
            this.v.delete();
            this.A = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.t, true), b));
        } catch (java.lang.Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    public final boolean u() {
        int i = this.D;
        return i >= 2000 && i >= this.C.size();
    }

    public final void v() {
        if (this.A == null) {
            throw new java.lang.IllegalStateException("cache is closed");
        }
    }

    public final void w() throws java.io.IOException {
        while (true) {
            if (this.z <= this.x && this.C.size() <= this.B) {
                return;
            } else {
                c(this.C.entrySet().iterator().next().getKey());
            }
        }
    }
}
