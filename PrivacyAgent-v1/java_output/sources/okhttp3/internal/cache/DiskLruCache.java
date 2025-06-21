package okhttp3.internal.cache;

/* loaded from: classes23.dex */
public final class DiskLruCache implements java.io.Closeable, java.io.Flushable {
    public static final java.util.regex.Pattern M = java.util.regex.Pattern.compile("[a-z0-9_-]{1,120}");
    public okio.BufferedSink B;
    public int D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public final java.util.concurrent.Executor K;
    public final okhttp3.internal.io.FileSystem n;
    public final java.io.File t;
    public final java.io.File u;
    public final java.io.File v;
    public final java.io.File w;
    public final int x;
    public long y;
    public final int z;
    public long A = 0;
    public final java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache.Entry> C = new java.util.LinkedHashMap<>(0, 0.75f, true);
    public long J = 0;
    public final java.lang.Runnable L = new okhttp3.internal.cache.DiskLruCache.AnonymousClass1();

    /* renamed from: okhttp3.internal.cache.DiskLruCache$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                okhttp3.internal.cache.DiskLruCache diskLruCache = okhttp3.internal.cache.DiskLruCache.this;
                if ((!diskLruCache.F) || diskLruCache.G) {
                    return;
                }
                try {
                    diskLruCache.o();
                } catch (java.io.IOException unused) {
                    okhttp3.internal.cache.DiskLruCache.this.H = true;
                }
                try {
                    if (okhttp3.internal.cache.DiskLruCache.this.f()) {
                        okhttp3.internal.cache.DiskLruCache.this.m();
                        okhttp3.internal.cache.DiskLruCache.this.D = 0;
                    }
                } catch (java.io.IOException unused2) {
                    okhttp3.internal.cache.DiskLruCache diskLruCache2 = okhttp3.internal.cache.DiskLruCache.this;
                    diskLruCache2.I = true;
                    diskLruCache2.B = okio.Okio.buffer(okio.Okio.blackhole());
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.cache.DiskLruCache$2, reason: invalid class name */
    public class AnonymousClass2 extends okhttp3.internal.cache.FaultHidingSink {
        public AnonymousClass2(okio.Sink sink) {
            super(sink);
        }

        @Override // okhttp3.internal.cache.FaultHidingSink
        public void a(java.io.IOException iOException) {
            okhttp3.internal.cache.DiskLruCache.this.E = true;
        }
    }

    /* renamed from: okhttp3.internal.cache.DiskLruCache$3, reason: invalid class name */
    public class AnonymousClass3 implements java.util.Iterator<okhttp3.internal.cache.DiskLruCache.Snapshot> {
        public final java.util.Iterator<okhttp3.internal.cache.DiskLruCache.Entry> n;
        public okhttp3.internal.cache.DiskLruCache.Snapshot t;
        public okhttp3.internal.cache.DiskLruCache.Snapshot u;

        public AnonymousClass3() {
            this.n = new java.util.ArrayList(okhttp3.internal.cache.DiskLruCache.this.C.values()).iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public okhttp3.internal.cache.DiskLruCache.Snapshot next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            okhttp3.internal.cache.DiskLruCache.Snapshot snapshot = this.t;
            this.u = snapshot;
            this.t = null;
            return snapshot;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            okhttp3.internal.cache.DiskLruCache.Snapshot c;
            if (this.t != null) {
                return true;
            }
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                if (okhttp3.internal.cache.DiskLruCache.this.G) {
                    return false;
                }
                while (this.n.hasNext()) {
                    okhttp3.internal.cache.DiskLruCache.Entry next = this.n.next();
                    if (next.e && (c = next.c()) != null) {
                        this.t = c;
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            okhttp3.internal.cache.DiskLruCache.Snapshot snapshot = this.u;
            if (snapshot == null) {
                throw new java.lang.IllegalStateException("remove() before next()");
            }
            try {
                okhttp3.internal.cache.DiskLruCache.this.remove(snapshot.n);
            } catch (java.io.IOException unused) {
            } catch (java.lang.Throwable th) {
                this.u = null;
                throw th;
            }
            this.u = null;
        }
    }

    public final class Editor {
        public final okhttp3.internal.cache.DiskLruCache.Entry a;
        public final boolean[] b;
        public boolean c;

        /* renamed from: okhttp3.internal.cache.DiskLruCache$Editor$1, reason: invalid class name */
        public class AnonymousClass1 extends okhttp3.internal.cache.FaultHidingSink {
            public AnonymousClass1(okio.Sink sink) {
                super(sink);
            }

            @Override // okhttp3.internal.cache.FaultHidingSink
            public void a(java.io.IOException iOException) {
                synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                    okhttp3.internal.cache.DiskLruCache.Editor.this.a();
                }
            }
        }

        public Editor(okhttp3.internal.cache.DiskLruCache.Entry entry) {
            this.a = entry;
            this.b = entry.e ? null : new boolean[okhttp3.internal.cache.DiskLruCache.this.z];
        }

        public void a() {
            if (this.a.f != this) {
                return;
            }
            int i = 0;
            while (true) {
                okhttp3.internal.cache.DiskLruCache diskLruCache = okhttp3.internal.cache.DiskLruCache.this;
                if (i >= diskLruCache.z) {
                    this.a.f = null;
                    return;
                } else {
                    try {
                        diskLruCache.n.delete(this.a.d[i]);
                    } catch (java.io.IOException unused) {
                    }
                    i++;
                }
            }
        }

        public void abort() throws java.io.IOException {
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                if (this.c) {
                    throw new java.lang.IllegalStateException();
                }
                if (this.a.f == this) {
                    okhttp3.internal.cache.DiskLruCache.this.d(this, false);
                }
                this.c = true;
            }
        }

        public void abortUnlessCommitted() {
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                if (!this.c && this.a.f == this) {
                    try {
                        okhttp3.internal.cache.DiskLruCache.this.d(this, false);
                    } catch (java.io.IOException unused) {
                    }
                }
            }
        }

        public void commit() throws java.io.IOException {
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                if (this.c) {
                    throw new java.lang.IllegalStateException();
                }
                if (this.a.f == this) {
                    okhttp3.internal.cache.DiskLruCache.this.d(this, true);
                }
                this.c = true;
            }
        }

        public okio.Sink newSink(int i) {
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                if (this.c) {
                    throw new java.lang.IllegalStateException();
                }
                okhttp3.internal.cache.DiskLruCache.Entry entry = this.a;
                if (entry.f != this) {
                    return okio.Okio.blackhole();
                }
                if (!entry.e) {
                    this.b[i] = true;
                }
                try {
                    return new okhttp3.internal.cache.DiskLruCache.Editor.AnonymousClass1(okhttp3.internal.cache.DiskLruCache.this.n.sink(entry.d[i]));
                } catch (java.io.FileNotFoundException unused) {
                    return okio.Okio.blackhole();
                }
            }
        }

        public okio.Source newSource(int i) {
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                if (this.c) {
                    throw new java.lang.IllegalStateException();
                }
                okhttp3.internal.cache.DiskLruCache.Entry entry = this.a;
                if (!entry.e || entry.f != this) {
                    return null;
                }
                try {
                    return okhttp3.internal.cache.DiskLruCache.this.n.source(entry.c[i]);
                } catch (java.io.FileNotFoundException unused) {
                    return null;
                }
            }
        }
    }

    public final class Entry {
        public final java.lang.String a;
        public final long[] b;
        public final java.io.File[] c;
        public final java.io.File[] d;
        public boolean e;
        public okhttp3.internal.cache.DiskLruCache.Editor f;
        public long g;

        public Entry(java.lang.String str) {
            this.a = str;
            int i = okhttp3.internal.cache.DiskLruCache.this.z;
            this.b = new long[i];
            this.c = new java.io.File[i];
            this.d = new java.io.File[i];
            java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < okhttp3.internal.cache.DiskLruCache.this.z; i2++) {
                sb.append(i2);
                this.c[i2] = new java.io.File(okhttp3.internal.cache.DiskLruCache.this.t, sb.toString());
                sb.append(com.baidu.mobads.sdk.internal.al.k);
                this.d[i2] = new java.io.File(okhttp3.internal.cache.DiskLruCache.this.t, sb.toString());
                sb.setLength(length);
            }
        }

        public final java.io.IOException a(java.lang.String[] strArr) throws java.io.IOException {
            throw new java.io.IOException("unexpected journal line: " + java.util.Arrays.toString(strArr));
        }

        public void b(java.lang.String[] strArr) throws java.io.IOException {
            if (strArr.length != okhttp3.internal.cache.DiskLruCache.this.z) {
                throw a(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = java.lang.Long.parseLong(strArr[i]);
                } catch (java.lang.NumberFormatException unused) {
                    throw a(strArr);
                }
            }
        }

        public okhttp3.internal.cache.DiskLruCache.Snapshot c() {
            okio.Source source;
            if (!java.lang.Thread.holdsLock(okhttp3.internal.cache.DiskLruCache.this)) {
                throw new java.lang.AssertionError();
            }
            okio.Source[] sourceArr = new okio.Source[okhttp3.internal.cache.DiskLruCache.this.z];
            long[] jArr = (long[]) this.b.clone();
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    okhttp3.internal.cache.DiskLruCache diskLruCache = okhttp3.internal.cache.DiskLruCache.this;
                    if (i2 >= diskLruCache.z) {
                        return diskLruCache.new Snapshot(this.a, this.g, sourceArr, jArr);
                    }
                    sourceArr[i2] = diskLruCache.n.source(this.c[i2]);
                    i2++;
                } catch (java.io.FileNotFoundException unused) {
                    while (true) {
                        okhttp3.internal.cache.DiskLruCache diskLruCache2 = okhttp3.internal.cache.DiskLruCache.this;
                        if (i >= diskLruCache2.z || (source = sourceArr[i]) == null) {
                            try {
                                diskLruCache2.n(this);
                                return null;
                            } catch (java.io.IOException unused2) {
                                return null;
                            }
                        }
                        okhttp3.internal.Util.closeQuietly(source);
                        i++;
                    }
                }
            }
        }

        public void d(okio.BufferedSink bufferedSink) throws java.io.IOException {
            for (long j : this.b) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }
    }

    public final class Snapshot implements java.io.Closeable {
        public final java.lang.String n;
        public final long t;
        public final okio.Source[] u;
        public final long[] v;

        public Snapshot(java.lang.String str, long j, okio.Source[] sourceArr, long[] jArr) {
            this.n = str;
            this.t = j;
            this.u = sourceArr;
            this.v = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (okio.Source source : this.u) {
                okhttp3.internal.Util.closeQuietly(source);
            }
        }

        @javax.annotation.Nullable
        public okhttp3.internal.cache.DiskLruCache.Editor edit() throws java.io.IOException {
            return okhttp3.internal.cache.DiskLruCache.this.e(this.n, this.t);
        }

        public long getLength(int i) {
            return this.v[i];
        }

        public okio.Source getSource(int i) {
            return this.u[i];
        }

        public java.lang.String key() {
            return this.n;
        }
    }

    public DiskLruCache(okhttp3.internal.io.FileSystem fileSystem, java.io.File file, int i, int i2, long j, java.util.concurrent.Executor executor) {
        this.n = fileSystem;
        this.t = file;
        this.x = i;
        this.u = new java.io.File(file, "journal");
        this.v = new java.io.File(file, "journal.tmp");
        this.w = new java.io.File(file, "journal.bkp");
        this.z = i2;
        this.y = j;
        this.K = executor;
    }

    public static /* synthetic */ void a(java.lang.Throwable th, java.lang.AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (java.lang.Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public static okhttp3.internal.cache.DiskLruCache create(okhttp3.internal.io.FileSystem fileSystem, java.io.File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            return new okhttp3.internal.cache.DiskLruCache(fileSystem, file, i, i2, j, new java.util.concurrent.ThreadPoolExecutor(0, 1, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), okhttp3.internal.Util.threadFactory("OkHttp DiskLruCache", true)));
        }
        throw new java.lang.IllegalArgumentException("valueCount <= 0");
    }

    public final synchronized void c() {
        if (isClosed()) {
            throw new java.lang.IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        if (this.F && !this.G) {
            for (okhttp3.internal.cache.DiskLruCache.Entry entry : (okhttp3.internal.cache.DiskLruCache.Entry[]) this.C.values().toArray(new okhttp3.internal.cache.DiskLruCache.Entry[this.C.size()])) {
                okhttp3.internal.cache.DiskLruCache.Editor editor = entry.f;
                if (editor != null) {
                    editor.abort();
                }
            }
            o();
            this.B.close();
            this.B = null;
            this.G = true;
            return;
        }
        this.G = true;
    }

    public synchronized void d(okhttp3.internal.cache.DiskLruCache.Editor editor, boolean z) throws java.io.IOException {
        okhttp3.internal.cache.DiskLruCache.Entry entry = editor.a;
        if (entry.f != editor) {
            throw new java.lang.IllegalStateException();
        }
        if (z && !entry.e) {
            for (int i = 0; i < this.z; i++) {
                if (!editor.b[i]) {
                    editor.abort();
                    throw new java.lang.IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!this.n.exists(entry.d[i])) {
                    editor.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.z; i2++) {
            java.io.File file = entry.d[i2];
            if (!z) {
                this.n.delete(file);
            } else if (this.n.exists(file)) {
                java.io.File file2 = entry.c[i2];
                this.n.rename(file, file2);
                long j = entry.b[i2];
                long size = this.n.size(file2);
                entry.b[i2] = size;
                this.A = (this.A - j) + size;
            }
        }
        this.D++;
        entry.f = null;
        if (entry.e || z) {
            entry.e = true;
            this.B.writeUtf8("CLEAN").writeByte(32);
            this.B.writeUtf8(entry.a);
            entry.d(this.B);
            this.B.writeByte(10);
            if (z) {
                long j2 = this.J;
                this.J = 1 + j2;
                entry.g = j2;
            }
        } else {
            this.C.remove(entry.a);
            this.B.writeUtf8("REMOVE").writeByte(32);
            this.B.writeUtf8(entry.a);
            this.B.writeByte(10);
        }
        this.B.flush();
        if (this.A > this.y || f()) {
            this.K.execute(this.L);
        }
    }

    public void delete() throws java.io.IOException {
        close();
        this.n.deleteContents(this.t);
    }

    public synchronized okhttp3.internal.cache.DiskLruCache.Editor e(java.lang.String str, long j) throws java.io.IOException {
        initialize();
        c();
        p(str);
        okhttp3.internal.cache.DiskLruCache.Entry entry = this.C.get(str);
        if (j != -1 && (entry == null || entry.g != j)) {
            return null;
        }
        if (entry != null && entry.f != null) {
            return null;
        }
        if (!this.H && !this.I) {
            this.B.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
            this.B.flush();
            if (this.E) {
                return null;
            }
            if (entry == null) {
                entry = new okhttp3.internal.cache.DiskLruCache.Entry(str);
                this.C.put(str, entry);
            }
            okhttp3.internal.cache.DiskLruCache.Editor editor = new okhttp3.internal.cache.DiskLruCache.Editor(entry);
            entry.f = editor;
            return editor;
        }
        this.K.execute(this.L);
        return null;
    }

    @javax.annotation.Nullable
    public okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String str) throws java.io.IOException {
        return e(str, -1L);
    }

    public synchronized void evictAll() throws java.io.IOException {
        initialize();
        for (okhttp3.internal.cache.DiskLruCache.Entry entry : (okhttp3.internal.cache.DiskLruCache.Entry[]) this.C.values().toArray(new okhttp3.internal.cache.DiskLruCache.Entry[this.C.size()])) {
            n(entry);
        }
        this.H = false;
    }

    public boolean f() {
        int i = this.D;
        return i >= 2000 && i >= this.C.size();
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws java.io.IOException {
        if (this.F) {
            c();
            o();
            this.B.flush();
        }
    }

    public final okio.BufferedSink g() throws java.io.FileNotFoundException {
        return okio.Okio.buffer(new okhttp3.internal.cache.DiskLruCache.AnonymousClass2(this.n.appendingSink(this.u)));
    }

    public synchronized okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String str) throws java.io.IOException {
        initialize();
        c();
        p(str);
        okhttp3.internal.cache.DiskLruCache.Entry entry = this.C.get(str);
        if (entry != null && entry.e) {
            okhttp3.internal.cache.DiskLruCache.Snapshot c = entry.c();
            if (c == null) {
                return null;
            }
            this.D++;
            this.B.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
            if (f()) {
                this.K.execute(this.L);
            }
            return c;
        }
        return null;
    }

    public java.io.File getDirectory() {
        return this.t;
    }

    public synchronized long getMaxSize() {
        return this.y;
    }

    public synchronized void initialize() throws java.io.IOException {
        if (this.F) {
            return;
        }
        if (this.n.exists(this.w)) {
            if (this.n.exists(this.u)) {
                this.n.delete(this.w);
            } else {
                this.n.rename(this.w, this.u);
            }
        }
        if (this.n.exists(this.u)) {
            try {
                k();
                j();
                this.F = true;
                return;
            } catch (java.io.IOException e) {
                okhttp3.internal.platform.Platform.get().log(5, "DiskLruCache " + this.t + " is corrupt: " + e.getMessage() + ", removing", e);
                try {
                    delete();
                    this.G = false;
                } catch (java.lang.Throwable th) {
                    this.G = false;
                    throw th;
                }
            }
        }
        m();
        this.F = true;
    }

    public synchronized boolean isClosed() {
        return this.G;
    }

    public final void j() throws java.io.IOException {
        this.n.delete(this.v);
        java.util.Iterator<okhttp3.internal.cache.DiskLruCache.Entry> it = this.C.values().iterator();
        while (it.hasNext()) {
            okhttp3.internal.cache.DiskLruCache.Entry next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.z) {
                    this.A += next.b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.z) {
                    this.n.delete(next.c[i]);
                    this.n.delete(next.d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    public final void k() throws java.io.IOException {
        okio.BufferedSource buffer = okio.Okio.buffer(this.n.source(this.u));
        try {
            java.lang.String readUtf8LineStrict = buffer.readUtf8LineStrict();
            java.lang.String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            java.lang.String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            java.lang.String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            java.lang.String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(readUtf8LineStrict) || !"1".equals(readUtf8LineStrict2) || !java.lang.Integer.toString(this.x).equals(readUtf8LineStrict3) || !java.lang.Integer.toString(this.z).equals(readUtf8LineStrict4) || !"".equals(readUtf8LineStrict5)) {
                throw new java.io.IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    l(buffer.readUtf8LineStrict());
                    i++;
                } catch (java.io.EOFException unused) {
                    this.D = i - this.C.size();
                    if (buffer.exhausted()) {
                        this.B = g();
                    } else {
                        m();
                    }
                    a(null, buffer);
                    return;
                }
            }
        } finally {
        }
    }

    public final void l(java.lang.String str) throws java.io.IOException {
        java.lang.String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new java.io.IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.C.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        okhttp3.internal.cache.DiskLruCache.Entry entry = this.C.get(substring);
        if (entry == null) {
            entry = new okhttp3.internal.cache.DiskLruCache.Entry(substring);
            this.C.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            java.lang.String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.e = true;
            entry.f = null;
            entry.b(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            entry.f = new okhttp3.internal.cache.DiskLruCache.Editor(entry);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new java.io.IOException("unexpected journal line: " + str);
    }

    public synchronized void m() throws java.io.IOException {
        okio.BufferedSink bufferedSink = this.B;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        okio.BufferedSink buffer = okio.Okio.buffer(this.n.sink(this.v));
        try {
            buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
            buffer.writeUtf8("1").writeByte(10);
            buffer.writeDecimalLong(this.x).writeByte(10);
            buffer.writeDecimalLong(this.z).writeByte(10);
            buffer.writeByte(10);
            for (okhttp3.internal.cache.DiskLruCache.Entry entry : this.C.values()) {
                if (entry.f != null) {
                    buffer.writeUtf8("DIRTY").writeByte(32);
                    buffer.writeUtf8(entry.a);
                    buffer.writeByte(10);
                } else {
                    buffer.writeUtf8("CLEAN").writeByte(32);
                    buffer.writeUtf8(entry.a);
                    entry.d(buffer);
                    buffer.writeByte(10);
                }
            }
            a(null, buffer);
            if (this.n.exists(this.u)) {
                this.n.rename(this.u, this.w);
            }
            this.n.rename(this.v, this.u);
            this.n.delete(this.w);
            this.B = g();
            this.E = false;
            this.I = false;
        } finally {
        }
    }

    public boolean n(okhttp3.internal.cache.DiskLruCache.Entry entry) throws java.io.IOException {
        okhttp3.internal.cache.DiskLruCache.Editor editor = entry.f;
        if (editor != null) {
            editor.a();
        }
        for (int i = 0; i < this.z; i++) {
            this.n.delete(entry.c[i]);
            long j = this.A;
            long[] jArr = entry.b;
            this.A = j - jArr[i];
            jArr[i] = 0;
        }
        this.D++;
        this.B.writeUtf8("REMOVE").writeByte(32).writeUtf8(entry.a).writeByte(10);
        this.C.remove(entry.a);
        if (f()) {
            this.K.execute(this.L);
        }
        return true;
    }

    public void o() throws java.io.IOException {
        while (this.A > this.y) {
            n(this.C.values().iterator().next());
        }
        this.H = false;
    }

    public final void p(java.lang.String str) {
        if (M.matcher(str).matches()) {
            return;
        }
        throw new java.lang.IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized boolean remove(java.lang.String str) throws java.io.IOException {
        initialize();
        c();
        p(str);
        okhttp3.internal.cache.DiskLruCache.Entry entry = this.C.get(str);
        if (entry == null) {
            return false;
        }
        boolean n = n(entry);
        if (n && this.A <= this.y) {
            this.H = false;
        }
        return n;
    }

    public synchronized void setMaxSize(long j) {
        this.y = j;
        if (this.F) {
            this.K.execute(this.L);
        }
    }

    public synchronized long size() throws java.io.IOException {
        initialize();
        return this.A;
    }

    public synchronized java.util.Iterator<okhttp3.internal.cache.DiskLruCache.Snapshot> snapshots() throws java.io.IOException {
        initialize();
        return new okhttp3.internal.cache.DiskLruCache.AnonymousClass3();
    }
}
