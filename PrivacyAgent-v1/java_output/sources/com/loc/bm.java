package com.loc;

/* loaded from: classes23.dex */
public final class bm implements java.io.Closeable {
    static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("[a-z0-9_-]{1,120}");
    public static final java.nio.charset.Charset b = java.nio.charset.Charset.forName("US-ASCII");
    static final java.nio.charset.Charset c = java.nio.charset.Charset.forName("UTF-8");
    static java.util.concurrent.ThreadPoolExecutor d;
    private static final java.util.concurrent.ThreadFactory r;
    private static final java.io.OutputStream t;
    private final java.io.File e;
    private final java.io.File f;
    private final java.io.File g;
    private final java.io.File h;
    private long j;
    private java.io.Writer m;
    private int p;
    private long l = 0;
    private int n = 1000;
    private final java.util.LinkedHashMap<java.lang.String, com.loc.bm.c> o = new java.util.LinkedHashMap<>(0, 0.75f, true);
    private long q = 0;

    /* renamed from: s, reason: collision with root package name */
    private final java.util.concurrent.Callable<java.lang.Void> f399s = new com.loc.bm.AnonymousClass2();
    private final int i = 1;
    private final int k = 1;

    /* renamed from: com.loc.bm$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        private final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "disklrucache#" + this.a.getAndIncrement());
        }
    }

    /* renamed from: com.loc.bm$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.concurrent.Callable<java.lang.Void> {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Void call() throws java.lang.Exception {
            synchronized (com.loc.bm.this) {
                if (com.loc.bm.this.m == null) {
                    return null;
                }
                com.loc.bm.this.l();
                if (com.loc.bm.this.j()) {
                    com.loc.bm.this.i();
                    com.loc.bm.e(com.loc.bm.this);
                }
                return null;
            }
        }
    }

    /* renamed from: com.loc.bm$3, reason: invalid class name */
    public class AnonymousClass3 extends java.io.OutputStream {
        @Override // java.io.OutputStream
        public final void write(int i) throws java.io.IOException {
        }
    }

    public final class a {
        private final com.loc.bm.c b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        /* renamed from: com.loc.bm$a$a, reason: collision with other inner class name */
        public class C0418a extends java.io.FilterOutputStream {
            private C0418a(java.io.OutputStream outputStream) {
                super(outputStream);
            }

            public /* synthetic */ C0418a(com.loc.bm.a aVar, java.io.OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((java.io.FilterOutputStream) this).out.close();
                } catch (java.io.IOException unused) {
                    com.loc.bm.a.c(com.loc.bm.a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((java.io.FilterOutputStream) this).out.flush();
                } catch (java.io.IOException unused) {
                    com.loc.bm.a.c(com.loc.bm.a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((java.io.FilterOutputStream) this).out.write(i);
                } catch (java.io.IOException unused) {
                    com.loc.bm.a.c(com.loc.bm.a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((java.io.FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (java.io.IOException unused) {
                    com.loc.bm.a.c(com.loc.bm.a.this);
                }
            }
        }

        private a(com.loc.bm.c cVar) {
            this.b = cVar;
            this.c = cVar.d ? null : new boolean[com.loc.bm.this.k];
        }

        public /* synthetic */ a(com.loc.bm bmVar, com.loc.bm.c cVar, byte b) {
            this(cVar);
        }

        public static /* synthetic */ boolean c(com.loc.bm.a aVar) {
            aVar.d = true;
            return true;
        }

        public final java.io.OutputStream a() throws java.io.IOException {
            java.io.FileOutputStream fileOutputStream;
            com.loc.bm.a.C0418a c0418a;
            if (com.loc.bm.this.k <= 0) {
                throw new java.lang.IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + com.loc.bm.this.k);
            }
            synchronized (com.loc.bm.this) {
                if (this.b.e != this) {
                    throw new java.lang.IllegalStateException();
                }
                if (!this.b.d) {
                    this.c[0] = true;
                }
                java.io.File b = this.b.b(0);
                try {
                    fileOutputStream = new java.io.FileOutputStream(b);
                } catch (java.io.FileNotFoundException unused) {
                    com.loc.bm.this.e.mkdirs();
                    try {
                        fileOutputStream = new java.io.FileOutputStream(b);
                    } catch (java.io.FileNotFoundException unused2) {
                        return com.loc.bm.t;
                    }
                }
                c0418a = new com.loc.bm.a.C0418a(this, fileOutputStream, (byte) 0);
            }
            return c0418a;
        }

        public final void b() throws java.io.IOException {
            if (this.d) {
                com.loc.bm.this.a(this, false);
                com.loc.bm.this.c(this.b.b);
            } else {
                com.loc.bm.this.a(this, true);
            }
            this.e = true;
        }

        public final void c() throws java.io.IOException {
            com.loc.bm.this.a(this, false);
        }
    }

    public final class b implements java.io.Closeable {
        private final java.lang.String b;
        private final long c;
        private final java.io.InputStream[] d;
        private final long[] e;

        private b(java.lang.String str, long j, java.io.InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
            this.e = jArr;
        }

        public /* synthetic */ b(com.loc.bm bmVar, java.lang.String str, long j, java.io.InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, inputStreamArr, jArr);
        }

        public final java.io.InputStream a() {
            return this.d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (java.io.InputStream inputStream : this.d) {
                com.loc.bm.a(inputStream);
            }
        }
    }

    public final class c {
        private final java.lang.String b;
        private final long[] c;
        private boolean d;
        private com.loc.bm.a e;
        private long f;

        private c(java.lang.String str) {
            this.b = str;
            this.c = new long[com.loc.bm.this.k];
        }

        public /* synthetic */ c(com.loc.bm bmVar, java.lang.String str, byte b) {
            this(str);
        }

        private static java.io.IOException a(java.lang.String[] strArr) throws java.io.IOException {
            throw new java.io.IOException("unexpected journal line: " + java.util.Arrays.toString(strArr));
        }

        public static /* synthetic */ void a(com.loc.bm.c cVar, java.lang.String[] strArr) throws java.io.IOException {
            if (strArr.length != com.loc.bm.this.k) {
                throw a(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    cVar.c[i] = java.lang.Long.parseLong(strArr[i]);
                } catch (java.lang.NumberFormatException unused) {
                    throw a(strArr);
                }
            }
        }

        public static /* synthetic */ boolean a(com.loc.bm.c cVar) {
            cVar.d = true;
            return true;
        }

        public final java.io.File a(int i) {
            return new java.io.File(com.loc.bm.this.e, this.b + "." + i);
        }

        public final java.lang.String a() throws java.io.IOException {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (long j : this.c) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final java.io.File b(int i) {
            return new java.io.File(com.loc.bm.this.e, this.b + "." + i + com.baidu.mobads.sdk.internal.al.k);
        }
    }

    static {
        com.loc.bm.AnonymousClass1 anonymousClass1 = new com.loc.bm.AnonymousClass1();
        r = anonymousClass1;
        d = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), anonymousClass1);
        t = new com.loc.bm.AnonymousClass3();
    }

    private bm(java.io.File file, long j) {
        this.e = file;
        this.f = new java.io.File(file, "journal");
        this.g = new java.io.File(file, "journal.tmp");
        this.h = new java.io.File(file, "journal.bkp");
        this.j = j;
    }

    public static com.loc.bm a(java.io.File file, long j) throws java.io.IOException {
        if (j <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        java.io.File file2 = new java.io.File(file, "journal.bkp");
        if (file2.exists()) {
            java.io.File file3 = new java.io.File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        com.loc.bm bmVar = new com.loc.bm(file, j);
        if (bmVar.f.exists()) {
            try {
                bmVar.g();
                bmVar.h();
                bmVar.m = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(bmVar.f, true), b));
                return bmVar;
            } catch (java.lang.Throwable unused) {
                bmVar.d();
            }
        }
        file.mkdirs();
        com.loc.bm bmVar2 = new com.loc.bm(file, j);
        bmVar2.i();
        return bmVar2;
    }

    public static void a() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = d;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        d.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.loc.bm.a aVar, boolean z) throws java.io.IOException {
        com.loc.bm.c cVar = aVar.b;
        if (cVar.e != aVar) {
            throw new java.lang.IllegalStateException();
        }
        if (z && !cVar.d) {
            for (int i = 0; i < this.k; i++) {
                if (!aVar.c[i]) {
                    aVar.c();
                    throw new java.lang.IllegalStateException("Newly created entry didn't create value for index ".concat(java.lang.String.valueOf(i)));
                }
                if (!cVar.b(i).exists()) {
                    aVar.c();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.k; i2++) {
            java.io.File b2 = cVar.b(i2);
            if (!z) {
                a(b2);
            } else if (b2.exists()) {
                java.io.File a2 = cVar.a(i2);
                b2.renameTo(a2);
                long j = cVar.c[i2];
                long length = a2.length();
                cVar.c[i2] = length;
                this.l = (this.l - j) + length;
            }
        }
        this.p++;
        cVar.e = null;
        if (cVar.d || z) {
            com.loc.bm.c.a(cVar);
            this.m.write("CLEAN " + cVar.b + cVar.a() + '\n');
            if (z) {
                long j2 = this.q;
                this.q = 1 + j2;
                cVar.f = j2;
            }
        } else {
            this.o.remove(cVar.b);
            this.m.write("REMOVE " + cVar.b + '\n');
        }
        this.m.flush();
        if (this.l > this.j || j()) {
            f().submit(this.f399s);
        }
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

    private static void a(java.io.File file) throws java.io.IOException {
        if (file.exists() && !file.delete()) {
            throw new java.io.IOException();
        }
    }

    private static void a(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new java.io.IOException();
        }
    }

    private static void b(java.io.File file) throws java.io.IOException {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new java.io.IOException("not a readable directory: ".concat(java.lang.String.valueOf(file)));
        }
        for (java.io.File file2 : listFiles) {
            if (file2.isDirectory()) {
                b(file2);
            }
            if (!file2.delete()) {
                throw new java.io.IOException("failed to delete file: ".concat(java.lang.String.valueOf(file2)));
            }
        }
    }

    private synchronized com.loc.bm.a d(java.lang.String str) throws java.io.IOException {
        k();
        e(str);
        com.loc.bm.c cVar = this.o.get(str);
        if (cVar == null) {
            cVar = new com.loc.bm.c(this, str, (byte) 0);
            this.o.put(str, cVar);
        } else if (cVar.e != null) {
            return null;
        }
        com.loc.bm.a aVar = new com.loc.bm.a(this, cVar, (byte) 0);
        cVar.e = aVar;
        this.m.write("DIRTY " + str + '\n');
        this.m.flush();
        return aVar;
    }

    public static /* synthetic */ int e(com.loc.bm bmVar) {
        bmVar.p = 0;
        return 0;
    }

    private static void e(java.lang.String str) {
        if (a.matcher(str).matches()) {
            return;
        }
        throw new java.lang.IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private static java.util.concurrent.ThreadPoolExecutor f() {
        try {
            java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = d;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                d = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(256), r);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ed, code lost:
    
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g() throws java.io.IOException {
        java.lang.String substring;
        com.loc.bn bnVar = new com.loc.bn(new java.io.FileInputStream(this.f), b);
        try {
            java.lang.String a2 = bnVar.a();
            java.lang.String a3 = bnVar.a();
            java.lang.String a4 = bnVar.a();
            java.lang.String a5 = bnVar.a();
            java.lang.String a6 = bnVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !java.lang.Integer.toString(this.i).equals(a4) || !java.lang.Integer.toString(this.k).equals(a5) || !"".equals(a6)) {
                throw new java.io.IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    java.lang.String a7 = bnVar.a();
                    int indexOf = a7.indexOf(32);
                    if (indexOf == -1) {
                        throw new java.io.IOException("unexpected journal line: ".concat(a7));
                    }
                    int i2 = indexOf + 1;
                    int indexOf2 = a7.indexOf(32, i2);
                    if (indexOf2 == -1) {
                        substring = a7.substring(i2);
                        if (indexOf == 6 && a7.startsWith("REMOVE")) {
                            this.o.remove(substring);
                            i++;
                        }
                    } else {
                        substring = a7.substring(i2, indexOf2);
                    }
                    com.loc.bm.c cVar = this.o.get(substring);
                    if (cVar == null) {
                        cVar = new com.loc.bm.c(this, substring, (byte) 0);
                        this.o.put(substring, cVar);
                    }
                    if (indexOf2 != -1 && indexOf == 5 && a7.startsWith("CLEAN")) {
                        java.lang.String[] split = a7.substring(indexOf2 + 1).split(" ");
                        com.loc.bm.c.a(cVar);
                        cVar.e = null;
                        com.loc.bm.c.a(cVar, split);
                    } else if (indexOf2 == -1 && indexOf == 5 && a7.startsWith("DIRTY")) {
                        cVar.e = new com.loc.bm.a(this, cVar, (byte) 0);
                    } else if (indexOf2 != -1 || indexOf != 4 || !a7.startsWith("READ")) {
                        break;
                    }
                    i++;
                } catch (java.io.EOFException unused) {
                    this.p = i - this.o.size();
                    a(bnVar);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            a(bnVar);
            throw th;
        }
    }

    private void h() throws java.io.IOException {
        a(this.g);
        java.util.Iterator<com.loc.bm.c> it = this.o.values().iterator();
        while (it.hasNext()) {
            com.loc.bm.c next = it.next();
            int i = 0;
            if (next.e == null) {
                while (i < this.k) {
                    this.l += next.c[i];
                    i++;
                }
            } else {
                next.e = null;
                while (i < this.k) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() throws java.io.IOException {
        java.io.Writer writer = this.m;
        if (writer != null) {
            writer.close();
        }
        java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.g), b));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(java.lang.Integer.toString(this.i));
            bufferedWriter.write("\n");
            bufferedWriter.write(java.lang.Integer.toString(this.k));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (com.loc.bm.c cVar : this.o.values()) {
                bufferedWriter.write(cVar.e != null ? "DIRTY " + cVar.b + '\n' : "CLEAN " + cVar.b + cVar.a() + '\n');
            }
            bufferedWriter.close();
            if (this.f.exists()) {
                a(this.f, this.h, true);
            }
            a(this.g, this.f, false);
            this.h.delete();
            this.m = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.f, true), b));
        } catch (java.lang.Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        int i = this.p;
        return i >= 2000 && i >= this.o.size();
    }

    private void k() {
        if (this.m == null) {
            throw new java.lang.IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() throws java.io.IOException {
        while (true) {
            if (this.l <= this.j && this.o.size() <= this.n) {
                return;
            } else {
                c(this.o.entrySet().iterator().next().getKey());
            }
        }
    }

    public final synchronized com.loc.bm.b a(java.lang.String str) throws java.io.IOException {
        java.io.InputStream inputStream;
        k();
        e(str);
        com.loc.bm.c cVar = this.o.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.d) {
            return null;
        }
        java.io.InputStream[] inputStreamArr = new java.io.InputStream[this.k];
        for (int i = 0; i < this.k; i++) {
            try {
                inputStreamArr[i] = new java.io.FileInputStream(cVar.a(i));
            } catch (java.io.FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.k && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    a(inputStream);
                }
                return null;
            }
        }
        this.p++;
        this.m.append((java.lang.CharSequence) ("READ " + str + '\n'));
        if (j()) {
            f().submit(this.f399s);
        }
        return new com.loc.bm.b(this, str, cVar.f, inputStreamArr, cVar.c, (byte) 0);
    }

    public final void a(int i) {
        if (i < 10) {
            i = 10;
        } else if (i > 10000) {
            i = 10000;
        }
        this.n = i;
    }

    public final com.loc.bm.a b(java.lang.String str) throws java.io.IOException {
        return d(str);
    }

    public final java.io.File b() {
        return this.e;
    }

    public final synchronized void c() throws java.io.IOException {
        k();
        l();
        this.m.flush();
    }

    public final synchronized boolean c(java.lang.String str) throws java.io.IOException {
        k();
        e(str);
        com.loc.bm.c cVar = this.o.get(str);
        if (cVar != null && cVar.e == null) {
            for (int i = 0; i < this.k; i++) {
                java.io.File a2 = cVar.a(i);
                if (a2.exists() && !a2.delete()) {
                    throw new java.io.IOException("failed to delete ".concat(java.lang.String.valueOf(a2)));
                }
                this.l -= cVar.c[i];
                cVar.c[i] = 0;
            }
            this.p++;
            this.m.append((java.lang.CharSequence) ("REMOVE " + str + '\n'));
            this.o.remove(str);
            if (j()) {
                f().submit(this.f399s);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws java.io.IOException {
        if (this.m == null) {
            return;
        }
        java.util.Iterator it = new java.util.ArrayList(this.o.values()).iterator();
        while (it.hasNext()) {
            com.loc.bm.c cVar = (com.loc.bm.c) it.next();
            if (cVar.e != null) {
                cVar.e.c();
            }
        }
        l();
        this.m.close();
        this.m = null;
    }

    public final void d() throws java.io.IOException {
        close();
        b(this.e);
    }
}
