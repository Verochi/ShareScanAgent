package com.anythink.core.common.res;

/* loaded from: classes12.dex */
public final class a implements java.io.Closeable {
    static final java.lang.String a = "journal";
    static final java.lang.String b = "journal.tmp";
    static final java.lang.String c = "libcore.io.DiskLruCache";
    static final java.lang.String d = "1";
    static final long e = -1;
    private static final java.lang.String f = "CLEAN";
    private static final java.lang.String g = "DIRTY";
    private static final java.lang.String h = "REMOVE";
    private static final java.lang.String i = "READ";
    private static final java.nio.charset.Charset j = java.nio.charset.Charset.forName("UTF-8");
    private static final int k = 8192;
    private final java.io.File l;
    private final java.io.File m;
    private final java.io.File n;
    private final long p;

    /* renamed from: s, reason: collision with root package name */
    private java.io.Writer f184s;
    private int u;
    private long r = 0;
    private final java.util.LinkedHashMap<java.lang.String, com.anythink.core.common.res.a.b> t = new java.util.LinkedHashMap<>(0, 0.75f, true);
    private long v = 0;
    private final java.util.concurrent.ExecutorService w = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
    private final java.util.concurrent.Callable<java.lang.Void> x = new com.anythink.core.common.res.a.AnonymousClass1();
    private final int o = 1;
    private final int q = 1;

    /* renamed from: com.anythink.core.common.res.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.Callable<java.lang.Void> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Void call() {
            synchronized (com.anythink.core.common.res.a.this) {
                if (com.anythink.core.common.res.a.this.f184s == null) {
                    return null;
                }
                com.anythink.core.common.res.a.this.l();
                if (com.anythink.core.common.res.a.this.h()) {
                    com.anythink.core.common.res.a.this.d();
                    com.anythink.core.common.res.a.e(com.anythink.core.common.res.a.this);
                }
                return null;
            }
        }
    }

    /* renamed from: com.anythink.core.common.res.a$a, reason: collision with other inner class name */
    public final class C0169a {
        private final com.anythink.core.common.res.a.b b;
        private boolean c;

        /* renamed from: com.anythink.core.common.res.a$a$a, reason: collision with other inner class name */
        public class C0170a extends java.io.FilterOutputStream {
            private C0170a(java.io.OutputStream outputStream) {
                super(outputStream);
            }

            public /* synthetic */ C0170a(com.anythink.core.common.res.a.C0169a c0169a, java.io.OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((java.io.FilterOutputStream) this).out.close();
                } catch (java.io.IOException unused) {
                    com.anythink.core.common.res.a.C0169a.b(com.anythink.core.common.res.a.C0169a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((java.io.FilterOutputStream) this).out.flush();
                } catch (java.io.IOException unused) {
                    com.anythink.core.common.res.a.C0169a.b(com.anythink.core.common.res.a.C0169a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((java.io.FilterOutputStream) this).out.write(i);
                } catch (java.io.IOException unused) {
                    com.anythink.core.common.res.a.C0169a.b(com.anythink.core.common.res.a.C0169a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((java.io.FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (java.io.IOException unused) {
                    com.anythink.core.common.res.a.C0169a.b(com.anythink.core.common.res.a.C0169a.this);
                }
            }
        }

        private C0169a(com.anythink.core.common.res.a.b bVar) {
            this.b = bVar;
        }

        public /* synthetic */ C0169a(com.anythink.core.common.res.a aVar, com.anythink.core.common.res.a.b bVar, byte b) {
            this(bVar);
        }

        private void a(int i, java.lang.String str) {
            java.io.OutputStreamWriter outputStreamWriter = null;
            try {
                java.io.OutputStreamWriter outputStreamWriter2 = new java.io.OutputStreamWriter(a(i), com.anythink.core.common.res.a.j);
                try {
                    outputStreamWriter2.write(str);
                    com.anythink.core.common.res.a.a(outputStreamWriter2);
                } catch (java.lang.Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    com.anythink.core.common.res.a.a(outputStreamWriter);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }

        private java.io.InputStream b(int i) {
            synchronized (com.anythink.core.common.res.a.this) {
                if (this.b.e != this) {
                    throw new java.lang.IllegalStateException();
                }
                if (!this.b.d) {
                    return null;
                }
                return new java.io.FileInputStream(this.b.a(i));
            }
        }

        public static /* synthetic */ boolean b(com.anythink.core.common.res.a.C0169a c0169a) {
            c0169a.c = true;
            return true;
        }

        private java.lang.String c(int i) {
            java.io.InputStream b = b(i);
            if (b != null) {
                return com.anythink.core.common.res.a.a(b);
            }
            return null;
        }

        public final java.io.OutputStream a(int i) {
            com.anythink.core.common.res.a.C0169a.C0170a c0170a;
            synchronized (com.anythink.core.common.res.a.this) {
                if (this.b.e != this) {
                    throw new java.lang.IllegalStateException();
                }
                c0170a = new com.anythink.core.common.res.a.C0169a.C0170a(this, new java.io.FileOutputStream(this.b.b(i)), (byte) 0);
            }
            return c0170a;
        }

        public final void a() {
            if (!this.c) {
                com.anythink.core.common.res.a.this.a(this, true);
            } else {
                com.anythink.core.common.res.a.this.a(this, false);
                com.anythink.core.common.res.a.this.c(this.b.b);
            }
        }

        public final void b() {
            com.anythink.core.common.res.a.this.a(this, false);
        }
    }

    public final class b {
        private final java.lang.String b;
        private final long[] c;
        private boolean d;
        private com.anythink.core.common.res.a.C0169a e;
        private long f;

        private b(java.lang.String str) {
            this.b = str;
            this.c = new long[com.anythink.core.common.res.a.this.q];
        }

        public /* synthetic */ b(com.anythink.core.common.res.a aVar, java.lang.String str, byte b) {
            this(str);
        }

        public static /* synthetic */ void a(com.anythink.core.common.res.a.b bVar, java.lang.String[] strArr) {
            if (strArr.length != com.anythink.core.common.res.a.this.q) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    bVar.c[i] = java.lang.Long.parseLong(strArr[i]);
                } catch (java.lang.NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private void a(java.lang.String[] strArr) {
            if (strArr.length != com.anythink.core.common.res.a.this.q) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.c[i] = java.lang.Long.parseLong(strArr[i]);
                } catch (java.lang.NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        public static /* synthetic */ boolean a(com.anythink.core.common.res.a.b bVar) {
            bVar.d = true;
            return true;
        }

        private static java.io.IOException b(java.lang.String[] strArr) {
            throw new java.io.IOException("unexpected journal line: " + java.util.Arrays.toString(strArr));
        }

        public final java.io.File a(int i) {
            return new java.io.File(com.anythink.core.common.res.a.this.l, this.b + "." + i);
        }

        public final java.lang.String a() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (long j : this.c) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final java.io.File b(int i) {
            return new java.io.File(com.anythink.core.common.res.a.this.l, this.b + "." + i + com.baidu.mobads.sdk.internal.al.k);
        }
    }

    public final class c implements java.io.Closeable {
        private final java.lang.String b;
        private final long c;
        private final java.io.InputStream[] d;

        private c(java.lang.String str, long j, java.io.InputStream[] inputStreamArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
        }

        public /* synthetic */ c(com.anythink.core.common.res.a aVar, java.lang.String str, long j, java.io.InputStream[] inputStreamArr, byte b) {
            this(str, j, inputStreamArr);
        }

        private java.lang.String a(int i) {
            return com.anythink.core.common.res.a.a(this.d[i]);
        }

        private com.anythink.core.common.res.a.C0169a b() {
            return com.anythink.core.common.res.a.this.a(this.b, this.c);
        }

        public final java.io.InputStream a() {
            return this.d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (java.io.InputStream inputStream : this.d) {
                com.anythink.core.common.res.a.a((java.io.Closeable) inputStream);
            }
        }
    }

    private a(java.io.File file, long j2) {
        this.l = file;
        this.m = new java.io.File(file, a);
        this.n = new java.io.File(file, b);
        this.p = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized com.anythink.core.common.res.a.C0169a a(java.lang.String str, long j2) {
        j();
        e(str);
        com.anythink.core.common.res.a.b bVar = this.t.get(str);
        if (j2 != -1 && (bVar == null || bVar.f != j2)) {
            return null;
        }
        if (bVar == null) {
            bVar = new com.anythink.core.common.res.a.b(this, str, (byte) 0);
            this.t.put(str, bVar);
        } else if (bVar.e != null) {
            return null;
        }
        com.anythink.core.common.res.a.C0169a c0169a = new com.anythink.core.common.res.a.C0169a(this, bVar, (byte) 0);
        bVar.e = c0169a;
        this.f184s.write("DIRTY " + str + '\n');
        this.f184s.flush();
        return c0169a;
    }

    public static com.anythink.core.common.res.a a(java.io.File file, long j2) {
        if (j2 <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        com.anythink.core.common.res.a aVar = new com.anythink.core.common.res.a(file, j2);
        if (aVar.m.exists()) {
            try {
                aVar.b();
                aVar.c();
                aVar.f184s = new java.io.BufferedWriter(new java.io.FileWriter(aVar.m, true), 8192);
                return aVar;
            } catch (java.io.IOException unused) {
                aVar.close();
                a(aVar.l);
            }
        }
        file.mkdirs();
        com.anythink.core.common.res.a aVar2 = new com.anythink.core.common.res.a(file, j2);
        aVar2.d();
        return aVar2;
    }

    public static /* synthetic */ java.lang.String a(java.io.InputStream inputStream) {
        return a((java.io.Reader) new java.io.InputStreamReader(inputStream, j));
    }

    private static java.lang.String a(java.io.Reader reader) {
        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, read);
            }
        } finally {
            reader.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.anythink.core.common.res.a.C0169a c0169a, boolean z) {
        com.anythink.core.common.res.a.b bVar = c0169a.b;
        if (bVar.e != c0169a) {
            throw new java.lang.IllegalStateException();
        }
        if (z && !bVar.d) {
            for (int i2 = 0; i2 < this.q; i2++) {
                if (!bVar.b(i2).exists()) {
                    c0169a.b();
                    throw new java.lang.IllegalStateException("edit didn't create file ".concat(java.lang.String.valueOf(i2)));
                }
            }
        }
        for (int i3 = 0; i3 < this.q; i3++) {
            java.io.File b2 = bVar.b(i3);
            if (!z) {
                b(b2);
            } else if (b2.exists()) {
                java.io.File a2 = bVar.a(i3);
                b2.renameTo(a2);
                long j2 = bVar.c[i3];
                long length = a2.length();
                bVar.c[i3] = length;
                this.r = (this.r - j2) + length;
            }
        }
        this.u++;
        bVar.e = null;
        if (bVar.d || z) {
            com.anythink.core.common.res.a.b.a(bVar);
            this.f184s.write("CLEAN " + bVar.b + bVar.a() + '\n');
            if (z) {
                long j3 = this.v;
                this.v = 1 + j3;
                bVar.f = j3;
            }
        } else {
            this.t.remove(bVar.b);
            this.f184s.write("REMOVE " + bVar.b + '\n');
        }
        this.f184s.flush();
        if (this.r > this.p || h()) {
            this.w.submit(this.x);
        }
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e2) {
                throw e2;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private static void a(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new java.lang.IllegalArgumentException("not a directory: ".concat(java.lang.String.valueOf(file)));
        }
        for (java.io.File file2 : listFiles) {
            if (file2.isDirectory()) {
                a(file2);
            }
            if (!file2.delete()) {
                throw new java.io.IOException("failed to delete file: ".concat(java.lang.String.valueOf(file2)));
            }
        }
    }

    private static <T> T[] a(T[] tArr, int i2) {
        int length = tArr.length;
        if (2 > i2) {
            throw new java.lang.IllegalArgumentException();
        }
        if (2 > length) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - 2;
        int min = java.lang.Math.min(i3, length - 2);
        T[] tArr2 = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), i3));
        java.lang.System.arraycopy(tArr, 2, tArr2, 0, min);
        return tArr2;
    }

    private static java.lang.String b(java.io.InputStream inputStream) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(80);
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                throw new java.io.EOFException();
            }
            if (read == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i2 = length - 1;
                    if (sb.charAt(i2) == '\r') {
                        sb.setLength(i2);
                    }
                }
                return sb.toString();
            }
            sb.append((char) read);
        }
    }

    private void b() {
        java.lang.String b2;
        java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(this.m), 8192);
        try {
            java.lang.String b3 = b(bufferedInputStream);
            java.lang.String b4 = b(bufferedInputStream);
            java.lang.String b5 = b(bufferedInputStream);
            java.lang.String b6 = b(bufferedInputStream);
            java.lang.String b7 = b(bufferedInputStream);
            if (!c.equals(b3) || !"1".equals(b4) || !java.lang.Integer.toString(this.o).equals(b5) || !java.lang.Integer.toString(this.q).equals(b6) || !"".equals(b7)) {
                throw new java.io.IOException("unexpected journal header: [" + b3 + ", " + b4 + ", " + b6 + ", " + b7 + "]");
            }
            while (true) {
                try {
                    b2 = b(bufferedInputStream);
                    java.lang.String[] split = b2.split(" ");
                    if (split.length < 2) {
                        throw new java.io.IOException("unexpected journal line: ".concat(b2));
                    }
                    java.lang.String str = split[1];
                    if (split[0].equals(h) && split.length == 2) {
                        this.t.remove(str);
                    } else {
                        com.anythink.core.common.res.a.b bVar = this.t.get(str);
                        if (bVar == null) {
                            bVar = new com.anythink.core.common.res.a.b(this, str, (byte) 0);
                            this.t.put(str, bVar);
                        }
                        if (split[0].equals(f) && split.length == this.q + 2) {
                            com.anythink.core.common.res.a.b.a(bVar);
                            bVar.e = null;
                            int length = split.length;
                            int length2 = split.length;
                            if (2 > length) {
                                throw new java.lang.IllegalArgumentException();
                            }
                            if (2 > length2) {
                                throw new java.lang.ArrayIndexOutOfBoundsException();
                            }
                            int i2 = length - 2;
                            int min = java.lang.Math.min(i2, length2 - 2);
                            java.lang.Object[] objArr = (java.lang.Object[]) java.lang.reflect.Array.newInstance(split.getClass().getComponentType(), i2);
                            java.lang.System.arraycopy(split, 2, objArr, 0, min);
                            com.anythink.core.common.res.a.b.a(bVar, (java.lang.String[]) objArr);
                        } else if (split[0].equals(g) && split.length == 2) {
                            bVar.e = new com.anythink.core.common.res.a.C0169a(this, bVar, (byte) 0);
                        } else if (!split[0].equals(i) || split.length != 2) {
                            break;
                        }
                    }
                } catch (java.io.EOFException unused) {
                    return;
                }
            }
            throw new java.io.IOException("unexpected journal line: ".concat(b2));
        } finally {
            a((java.io.Closeable) bufferedInputStream);
        }
    }

    private static void b(java.io.File file) {
        if (file.exists() && !file.delete()) {
            throw new java.io.IOException();
        }
    }

    private static java.lang.String c(java.io.InputStream inputStream) {
        return a((java.io.Reader) new java.io.InputStreamReader(inputStream, j));
    }

    private void c() {
        b(this.n);
        java.util.Iterator<com.anythink.core.common.res.a.b> it = this.t.values().iterator();
        while (it.hasNext()) {
            com.anythink.core.common.res.a.b next = it.next();
            int i2 = 0;
            if (next.e == null) {
                while (i2 < this.q) {
                    this.r += next.c[i2];
                    i2++;
                }
            } else {
                next.e = null;
                while (i2 < this.q) {
                    b(next.a(i2));
                    b(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        java.io.Writer writer = this.f184s;
        if (writer != null) {
            writer.close();
        }
        java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(this.n), 8192);
        bufferedWriter.write(c);
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(java.lang.Integer.toString(this.o));
        bufferedWriter.write("\n");
        bufferedWriter.write(java.lang.Integer.toString(this.q));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (com.anythink.core.common.res.a.b bVar : this.t.values()) {
            if (bVar.e != null) {
                bufferedWriter.write("DIRTY " + bVar.b + '\n');
            } else {
                bufferedWriter.write("CLEAN " + bVar.b + bVar.a() + '\n');
            }
        }
        bufferedWriter.close();
        this.n.renameTo(this.m);
        this.f184s = new java.io.BufferedWriter(new java.io.FileWriter(this.m, true), 8192);
    }

    private void d(java.lang.String str) {
        java.lang.String[] split = str.split(" ");
        if (split.length < 2) {
            throw new java.io.IOException("unexpected journal line: ".concat(str));
        }
        java.lang.String str2 = split[1];
        if (split[0].equals(h) && split.length == 2) {
            this.t.remove(str2);
            return;
        }
        com.anythink.core.common.res.a.b bVar = this.t.get(str2);
        if (bVar == null) {
            bVar = new com.anythink.core.common.res.a.b(this, str2, (byte) 0);
            this.t.put(str2, bVar);
        }
        if (!split[0].equals(f) || split.length != this.q + 2) {
            if (split[0].equals(g) && split.length == 2) {
                bVar.e = new com.anythink.core.common.res.a.C0169a(this, bVar, (byte) 0);
                return;
            } else {
                if (!split[0].equals(i) || split.length != 2) {
                    throw new java.io.IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        com.anythink.core.common.res.a.b.a(bVar);
        bVar.e = null;
        int length = split.length;
        int length2 = split.length;
        if (2 > length) {
            throw new java.lang.IllegalArgumentException();
        }
        if (2 > length2) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        int i2 = length - 2;
        int min = java.lang.Math.min(i2, length2 - 2);
        java.lang.Object[] objArr = (java.lang.Object[]) java.lang.reflect.Array.newInstance(split.getClass().getComponentType(), i2);
        java.lang.System.arraycopy(split, 2, objArr, 0, min);
        com.anythink.core.common.res.a.b.a(bVar, (java.lang.String[]) objArr);
    }

    public static /* synthetic */ int e(com.anythink.core.common.res.a aVar) {
        aVar.u = 0;
        return 0;
    }

    private java.io.File e() {
        return this.l;
    }

    private static void e(java.lang.String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new java.lang.IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    private long f() {
        return this.p;
    }

    private synchronized long g() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        int i2 = this.u;
        return i2 >= 2000 && i2 >= this.t.size();
    }

    private boolean i() {
        return this.f184s == null;
    }

    private void j() {
        if (this.f184s == null) {
            throw new java.lang.IllegalStateException("cache is closed");
        }
    }

    private synchronized void k() {
        j();
        l();
        this.f184s.flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        while (this.r > this.p) {
            c(this.t.entrySet().iterator().next().getKey());
        }
    }

    private void m() {
        close();
        a(this.l);
    }

    public final synchronized com.anythink.core.common.res.a.c a(java.lang.String str) {
        j();
        e(str);
        com.anythink.core.common.res.a.b bVar = this.t.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.d) {
            return null;
        }
        java.io.InputStream[] inputStreamArr = new java.io.InputStream[this.q];
        for (int i2 = 0; i2 < this.q; i2++) {
            try {
                inputStreamArr[i2] = new java.io.FileInputStream(bVar.a(i2));
            } catch (java.io.FileNotFoundException unused) {
                return null;
            }
        }
        this.u++;
        this.f184s.append((java.lang.CharSequence) ("READ " + str + '\n'));
        if (h()) {
            this.w.submit(this.x);
        }
        this.f184s.flush();
        return new com.anythink.core.common.res.a.c(this, str, bVar.f, inputStreamArr, (byte) 0);
    }

    public final com.anythink.core.common.res.a.C0169a b(java.lang.String str) {
        return a(str, -1L);
    }

    public final synchronized boolean c(java.lang.String str) {
        j();
        e(str);
        com.anythink.core.common.res.a.b bVar = this.t.get(str);
        if (bVar != null && bVar.e == null) {
            for (int i2 = 0; i2 < this.q; i2++) {
                java.io.File a2 = bVar.a(i2);
                if (!a2.delete()) {
                    throw new java.io.IOException("failed to delete ".concat(java.lang.String.valueOf(a2)));
                }
                this.r -= bVar.c[i2];
                bVar.c[i2] = 0;
            }
            this.u++;
            this.f184s.append((java.lang.CharSequence) ("REMOVE " + str + '\n'));
            this.t.remove(str);
            if (h()) {
                this.w.submit(this.x);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f184s == null) {
            return;
        }
        java.util.Iterator it = new java.util.ArrayList(this.t.values()).iterator();
        while (it.hasNext()) {
            com.anythink.core.common.res.a.b bVar = (com.anythink.core.common.res.a.b) it.next();
            if (bVar.e != null) {
                bVar.e.b();
            }
        }
        l();
        this.f184s.close();
        this.f184s = null;
    }
}
