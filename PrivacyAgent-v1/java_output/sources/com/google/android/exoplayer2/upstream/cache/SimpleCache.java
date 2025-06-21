package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public final class SimpleCache implements com.google.android.exoplayer2.upstream.cache.Cache {
    public static final java.util.HashSet<java.io.File> l = new java.util.HashSet<>();
    public final java.io.File a;
    public final com.google.android.exoplayer2.upstream.cache.CacheEvictor b;
    public final com.google.android.exoplayer2.upstream.cache.CachedContentIndex c;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.cache.CacheFileMetadataIndex d;
    public final java.util.HashMap<java.lang.String, java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.Listener>> e;
    public final java.util.Random f;
    public final boolean g;
    public long h;
    public long i;
    public boolean j;
    public com.google.android.exoplayer2.upstream.cache.Cache.CacheException k;

    /* renamed from: com.google.android.exoplayer2.upstream.cache.SimpleCache$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        public final /* synthetic */ android.os.ConditionVariable n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, android.os.ConditionVariable conditionVariable) {
            super(str);
            this.n = conditionVariable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (com.google.android.exoplayer2.upstream.cache.SimpleCache.this) {
                this.n.open();
                com.google.android.exoplayer2.upstream.cache.SimpleCache.this.f();
                com.google.android.exoplayer2.upstream.cache.SimpleCache.this.b.onCacheInitialized();
            }
        }
    }

    @java.lang.Deprecated
    public SimpleCache(java.io.File file, com.google.android.exoplayer2.upstream.cache.CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, (byte[]) null, false);
    }

    public SimpleCache(java.io.File file, com.google.android.exoplayer2.upstream.cache.CacheEvictor cacheEvictor, com.google.android.exoplayer2.database.DatabaseProvider databaseProvider) {
        this(file, cacheEvictor, databaseProvider, null, false, false);
    }

    public SimpleCache(java.io.File file, com.google.android.exoplayer2.upstream.cache.CacheEvictor cacheEvictor, @androidx.annotation.Nullable com.google.android.exoplayer2.database.DatabaseProvider databaseProvider, @androidx.annotation.Nullable byte[] bArr, boolean z, boolean z2) {
        this(file, cacheEvictor, new com.google.android.exoplayer2.upstream.cache.CachedContentIndex(databaseProvider, file, bArr, z, z2), (databaseProvider == null || z2) ? null : new com.google.android.exoplayer2.upstream.cache.CacheFileMetadataIndex(databaseProvider));
    }

    public SimpleCache(java.io.File file, com.google.android.exoplayer2.upstream.cache.CacheEvictor cacheEvictor, com.google.android.exoplayer2.upstream.cache.CachedContentIndex cachedContentIndex, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CacheFileMetadataIndex cacheFileMetadataIndex) {
        if (!i(file)) {
            java.lang.String valueOf = java.lang.String.valueOf(file);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 46);
            sb.append("Another SimpleCache instance uses the folder: ");
            sb.append(valueOf);
            throw new java.lang.IllegalStateException(sb.toString());
        }
        this.a = file;
        this.b = cacheEvictor;
        this.c = cachedContentIndex;
        this.d = cacheFileMetadataIndex;
        this.e = new java.util.HashMap<>();
        this.f = new java.util.Random();
        this.g = cacheEvictor.requiresCacheSpanTouches();
        this.h = -1L;
        android.os.ConditionVariable conditionVariable = new android.os.ConditionVariable();
        new com.google.android.exoplayer2.upstream.cache.SimpleCache.AnonymousClass1("ExoPlayer:SimpleCacheInit", conditionVariable).start();
        conditionVariable.block();
    }

    @java.lang.Deprecated
    public SimpleCache(java.io.File file, com.google.android.exoplayer2.upstream.cache.CacheEvictor cacheEvictor, @androidx.annotation.Nullable byte[] bArr) {
        this(file, cacheEvictor, bArr, bArr != null);
    }

    @java.lang.Deprecated
    public SimpleCache(java.io.File file, com.google.android.exoplayer2.upstream.cache.CacheEvictor cacheEvictor, @androidx.annotation.Nullable byte[] bArr, boolean z) {
        this(file, cacheEvictor, null, bArr, z, true);
    }

    public static long d(java.io.File file) throws java.io.IOException {
        long nextLong = new java.security.SecureRandom().nextLong();
        long abs = nextLong == Long.MIN_VALUE ? 0L : java.lang.Math.abs(nextLong);
        java.lang.String valueOf = java.lang.String.valueOf(java.lang.Long.toString(abs, 16));
        java.io.File file2 = new java.io.File(file, ".uid".length() != 0 ? valueOf.concat(".uid") : new java.lang.String(valueOf));
        if (file2.createNewFile()) {
            return abs;
        }
        java.lang.String valueOf2 = java.lang.String.valueOf(file2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf2.length() + 27);
        sb.append("Failed to create UID file: ");
        sb.append(valueOf2);
        throw new java.io.IOException(sb.toString());
    }

    @androidx.annotation.WorkerThread
    public static void delete(java.io.File file, @androidx.annotation.Nullable com.google.android.exoplayer2.database.DatabaseProvider databaseProvider) {
        if (file.exists()) {
            java.io.File[] listFiles = file.listFiles();
            if (listFiles == null) {
                file.delete();
                return;
            }
            if (databaseProvider != null) {
                long h = h(listFiles);
                if (h != -1) {
                    try {
                        com.google.android.exoplayer2.upstream.cache.CacheFileMetadataIndex.delete(databaseProvider, h);
                    } catch (com.google.android.exoplayer2.database.DatabaseIOException unused) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(52);
                        sb.append("Failed to delete file metadata: ");
                        sb.append(h);
                        com.google.android.exoplayer2.util.Log.w("SimpleCache", sb.toString());
                    }
                    try {
                        com.google.android.exoplayer2.upstream.cache.CachedContentIndex.delete(databaseProvider, h);
                    } catch (com.google.android.exoplayer2.database.DatabaseIOException unused2) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(52);
                        sb2.append("Failed to delete file metadata: ");
                        sb2.append(h);
                        com.google.android.exoplayer2.util.Log.w("SimpleCache", sb2.toString());
                    }
                }
            }
            com.google.android.exoplayer2.util.Util.recursiveDelete(file);
        }
    }

    public static long h(java.io.File[] fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            java.io.File file = fileArr[i];
            java.lang.String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return m(name);
                } catch (java.lang.NumberFormatException unused) {
                    java.lang.String valueOf = java.lang.String.valueOf(file);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 20);
                    sb.append("Malformed UID file: ");
                    sb.append(valueOf);
                    com.google.android.exoplayer2.util.Log.e("SimpleCache", sb.toString());
                    file.delete();
                }
            }
        }
        return -1L;
    }

    public static synchronized boolean i(java.io.File file) {
        boolean add;
        synchronized (com.google.android.exoplayer2.upstream.cache.SimpleCache.class) {
            add = l.add(file.getAbsoluteFile());
        }
        return add;
    }

    public static synchronized boolean isCacheFolderLocked(java.io.File file) {
        boolean contains;
        synchronized (com.google.android.exoplayer2.upstream.cache.SimpleCache.class) {
            contains = l.contains(file.getAbsoluteFile());
        }
        return contains;
    }

    public static long m(java.lang.String str) {
        return java.lang.Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    public static synchronized void q(java.io.File file) {
        synchronized (com.google.android.exoplayer2.upstream.cache.SimpleCache.class) {
            l.remove(file.getAbsoluteFile());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized java.util.NavigableSet<com.google.android.exoplayer2.upstream.cache.CacheSpan> addListener(java.lang.String str, com.google.android.exoplayer2.upstream.cache.Cache.Listener listener) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(listener);
        java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.Listener> arrayList = this.e.get(str);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            this.e.put(str, arrayList);
        }
        arrayList.add(listener);
        return getCachedSpans(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void applyContentMetadataMutations(java.lang.String str, com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        checkInitialization();
        this.c.e(str, contentMetadataMutations);
        try {
            this.c.t();
        } catch (java.io.IOException e) {
            throw new com.google.android.exoplayer2.upstream.cache.Cache.CacheException(e);
        }
    }

    public final void c(com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan) {
        this.c.n(simpleCacheSpan.key).a(simpleCacheSpan);
        this.i += simpleCacheSpan.length;
        j(simpleCacheSpan);
    }

    public synchronized void checkInitialization() throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        com.google.android.exoplayer2.upstream.cache.Cache.CacheException cacheException = this.k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void commitFile(java.io.File file, long j) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        boolean z = true;
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan = (com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.c(file, j, this.c));
            com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = (com.google.android.exoplayer2.upstream.cache.CachedContent) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c.g(simpleCacheSpan.key));
            com.google.android.exoplayer2.util.Assertions.checkState(cachedContent.h(simpleCacheSpan.position, simpleCacheSpan.length));
            long a = defpackage.js.a(cachedContent.d());
            if (a != -1) {
                if (simpleCacheSpan.position + simpleCacheSpan.length > a) {
                    z = false;
                }
                com.google.android.exoplayer2.util.Assertions.checkState(z);
            }
            if (this.d != null) {
                try {
                    this.d.h(file.getName(), simpleCacheSpan.length, simpleCacheSpan.lastTouchTimestamp);
                } catch (java.io.IOException e) {
                    throw new com.google.android.exoplayer2.upstream.cache.Cache.CacheException(e);
                }
            }
            c(simpleCacheSpan);
            try {
                this.c.t();
                notifyAll();
            } catch (java.io.IOException e2) {
                throw new com.google.android.exoplayer2.upstream.cache.Cache.CacheException(e2);
            }
        }
    }

    public final com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan e(java.lang.String str, long j, long j2) {
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan e;
        com.google.android.exoplayer2.upstream.cache.CachedContent g = this.c.g(str);
        if (g == null) {
            return com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.d(str, j, j2);
        }
        while (true) {
            e = g.e(j, j2);
            if (!e.isCached || e.file.length() == e.length) {
                break;
            }
            o();
        }
        return e;
    }

    public final void f() {
        if (!this.a.exists() && !this.a.mkdirs()) {
            java.lang.String valueOf = java.lang.String.valueOf(this.a);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 34);
            sb.append("Failed to create cache directory: ");
            sb.append(valueOf);
            java.lang.String sb2 = sb.toString();
            com.google.android.exoplayer2.util.Log.e("SimpleCache", sb2);
            this.k = new com.google.android.exoplayer2.upstream.cache.Cache.CacheException(sb2);
            return;
        }
        java.io.File[] listFiles = this.a.listFiles();
        if (listFiles == null) {
            java.lang.String valueOf2 = java.lang.String.valueOf(this.a);
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder(valueOf2.length() + 38);
            sb3.append("Failed to list cache directory files: ");
            sb3.append(valueOf2);
            java.lang.String sb4 = sb3.toString();
            com.google.android.exoplayer2.util.Log.e("SimpleCache", sb4);
            this.k = new com.google.android.exoplayer2.upstream.cache.Cache.CacheException(sb4);
            return;
        }
        long h = h(listFiles);
        this.h = h;
        if (h == -1) {
            try {
                this.h = d(this.a);
            } catch (java.io.IOException e) {
                java.lang.String valueOf3 = java.lang.String.valueOf(this.a);
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder(valueOf3.length() + 28);
                sb5.append("Failed to create cache UID: ");
                sb5.append(valueOf3);
                java.lang.String sb6 = sb5.toString();
                com.google.android.exoplayer2.util.Log.e("SimpleCache", sb6, e);
                this.k = new com.google.android.exoplayer2.upstream.cache.Cache.CacheException(sb6, e);
                return;
            }
        }
        try {
            this.c.o(this.h);
            com.google.android.exoplayer2.upstream.cache.CacheFileMetadataIndex cacheFileMetadataIndex = this.d;
            if (cacheFileMetadataIndex != null) {
                cacheFileMetadataIndex.e(this.h);
                java.util.Map<java.lang.String, com.google.android.exoplayer2.upstream.cache.CacheFileMetadata> b = this.d.b();
                g(this.a, true, listFiles, b);
                this.d.g(b.keySet());
            } else {
                g(this.a, true, listFiles, null);
            }
            this.c.s();
            try {
                this.c.t();
            } catch (java.io.IOException e2) {
                com.google.android.exoplayer2.util.Log.e("SimpleCache", "Storing index file failed", e2);
            }
        } catch (java.io.IOException e3) {
            java.lang.String valueOf4 = java.lang.String.valueOf(this.a);
            java.lang.StringBuilder sb7 = new java.lang.StringBuilder(valueOf4.length() + 36);
            sb7.append("Failed to initialize cache indices: ");
            sb7.append(valueOf4);
            java.lang.String sb8 = sb7.toString();
            com.google.android.exoplayer2.util.Log.e("SimpleCache", sb8, e3);
            this.k = new com.google.android.exoplayer2.upstream.cache.Cache.CacheException(sb8, e3);
        }
    }

    public final void g(java.io.File file, boolean z, @androidx.annotation.Nullable java.io.File[] fileArr, @androidx.annotation.Nullable java.util.Map<java.lang.String, com.google.android.exoplayer2.upstream.cache.CacheFileMetadata> map) {
        long j;
        long j2;
        if (fileArr == null || fileArr.length == 0) {
            if (z) {
                return;
            }
            file.delete();
            return;
        }
        for (java.io.File file2 : fileArr) {
            java.lang.String name = file2.getName();
            if (z && name.indexOf(46) == -1) {
                g(file2, false, file2.listFiles(), map);
            } else if (!z || (!com.google.android.exoplayer2.upstream.cache.CachedContentIndex.p(name) && !name.endsWith(".uid"))) {
                com.google.android.exoplayer2.upstream.cache.CacheFileMetadata remove = map != null ? map.remove(name) : null;
                if (remove != null) {
                    j2 = remove.a;
                    j = remove.b;
                } else {
                    j = -9223372036854775807L;
                    j2 = -1;
                }
                com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan b = com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.b(file2, j2, j, this.c);
                if (b != null) {
                    c(b);
                } else {
                    file2.delete();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCacheSpace() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        return this.i;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCachedBytes(java.lang.String str, long j, long j2) {
        long j3;
        long j4 = j2 == -1 ? Long.MAX_VALUE : j2 + j;
        long j5 = j4 >= 0 ? j4 : Long.MAX_VALUE;
        j3 = 0;
        while (j < j5) {
            long cachedLength = getCachedLength(str, j, j5 - j);
            if (cachedLength > 0) {
                j3 += cachedLength;
            } else {
                cachedLength = -cachedLength;
            }
            j += cachedLength;
        }
        return j3;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCachedLength(java.lang.String str, long j, long j2) {
        com.google.android.exoplayer2.upstream.cache.CachedContent g;
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        if (j2 == -1) {
            j2 = Long.MAX_VALUE;
        }
        g = this.c.g(str);
        return g != null ? g.c(j, j2) : -j2;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized java.util.NavigableSet<com.google.android.exoplayer2.upstream.cache.CacheSpan> getCachedSpans(java.lang.String str) {
        java.util.TreeSet treeSet;
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        com.google.android.exoplayer2.upstream.cache.CachedContent g = this.c.g(str);
        if (g != null && !g.g()) {
            treeSet = new java.util.TreeSet((java.util.Collection) g.f());
        }
        treeSet = new java.util.TreeSet();
        return treeSet;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized com.google.android.exoplayer2.upstream.cache.ContentMetadata getContentMetadata(java.lang.String str) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        return this.c.j(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized java.util.Set<java.lang.String> getKeys() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        return new java.util.HashSet(this.c.l());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getUid() {
        return this.h;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (r4.c(r5, r7) >= r7) goto L14;
     */
    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isCached(java.lang.String str, long j, long j2) {
        boolean z;
        z = true;
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        com.google.android.exoplayer2.upstream.cache.CachedContent g = this.c.g(str);
        if (g != null) {
        }
        z = false;
        return z;
    }

    public final void j(com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan) {
        java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.Listener> arrayList = this.e.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanAdded(this, simpleCacheSpan);
            }
        }
        this.b.onSpanAdded(this, simpleCacheSpan);
    }

    public final void k(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.Listener> arrayList = this.e.get(cacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanRemoved(this, cacheSpan);
            }
        }
        this.b.onSpanRemoved(this, cacheSpan);
    }

    public final void l(com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.Listener> arrayList = this.e.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanTouched(this, simpleCacheSpan, cacheSpan);
            }
        }
        this.b.onSpanTouched(this, simpleCacheSpan, cacheSpan);
    }

    public final void n(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        com.google.android.exoplayer2.upstream.cache.CachedContent g = this.c.g(cacheSpan.key);
        if (g == null || !g.k(cacheSpan)) {
            return;
        }
        this.i -= cacheSpan.length;
        if (this.d != null) {
            java.lang.String name = cacheSpan.file.getName();
            try {
                this.d.f(name);
            } catch (java.io.IOException unused) {
                java.lang.String valueOf = java.lang.String.valueOf(name);
                com.google.android.exoplayer2.util.Log.w("SimpleCache", valueOf.length() != 0 ? "Failed to remove file index entry for: ".concat(valueOf) : new java.lang.String("Failed to remove file index entry for: "));
            }
        }
        this.c.q(g.b);
        k(cacheSpan);
    }

    public final void o() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.google.android.exoplayer2.upstream.cache.CachedContent> it = this.c.h().iterator();
        while (it.hasNext()) {
            java.util.Iterator<com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan> it2 = it.next().f().iterator();
            while (it2.hasNext()) {
                com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan next = it2.next();
                if (next.file.length() != next.length) {
                    arrayList.add(next);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            n((com.google.android.exoplayer2.upstream.cache.CacheSpan) arrayList.get(i));
        }
    }

    public final com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan p(java.lang.String str, com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan) {
        boolean z;
        if (!this.g) {
            return simpleCacheSpan;
        }
        java.lang.String name = ((java.io.File) com.google.android.exoplayer2.util.Assertions.checkNotNull(simpleCacheSpan.file)).getName();
        long j = simpleCacheSpan.length;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        com.google.android.exoplayer2.upstream.cache.CacheFileMetadataIndex cacheFileMetadataIndex = this.d;
        if (cacheFileMetadataIndex != null) {
            try {
                cacheFileMetadataIndex.h(name, j, currentTimeMillis);
            } catch (java.io.IOException unused) {
                com.google.android.exoplayer2.util.Log.w("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z = false;
        } else {
            z = true;
        }
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan l2 = this.c.g(str).l(simpleCacheSpan, currentTimeMillis, z);
        l(simpleCacheSpan, l2);
        return l2;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void release() {
        if (this.j) {
            return;
        }
        this.e.clear();
        o();
        try {
            try {
                this.c.t();
                q(this.a);
            } catch (java.io.IOException e) {
                com.google.android.exoplayer2.util.Log.e("SimpleCache", "Storing index file failed", e);
                q(this.a);
            }
            this.j = true;
        } catch (java.lang.Throwable th) {
            q(this.a);
            this.j = true;
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void releaseHoleSpan(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = (com.google.android.exoplayer2.upstream.cache.CachedContent) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c.g(cacheSpan.key));
        cachedContent.m(cacheSpan.position);
        this.c.q(cachedContent.b);
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeListener(java.lang.String str, com.google.android.exoplayer2.upstream.cache.Cache.Listener listener) {
        if (this.j) {
            return;
        }
        java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.Listener> arrayList = this.e.get(str);
        if (arrayList != null) {
            arrayList.remove(listener);
            if (arrayList.isEmpty()) {
                this.e.remove(str);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeResource(java.lang.String str) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        java.util.Iterator<com.google.android.exoplayer2.upstream.cache.CacheSpan> it = getCachedSpans(str).iterator();
        while (it.hasNext()) {
            n(it.next());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeSpan(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        n(cacheSpan);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized java.io.File startFile(java.lang.String str, long j, long j2) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        com.google.android.exoplayer2.upstream.cache.CachedContent g;
        java.io.File file;
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        checkInitialization();
        g = this.c.g(str);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(g);
        com.google.android.exoplayer2.util.Assertions.checkState(g.h(j, j2));
        if (!this.a.exists()) {
            this.a.mkdirs();
            o();
        }
        this.b.onStartFile(this, str, j, j2);
        file = new java.io.File(this.a, java.lang.Integer.toString(this.f.nextInt(10)));
        if (!file.exists()) {
            file.mkdir();
        }
        return com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.f(file, g.a, j, java.lang.System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized com.google.android.exoplayer2.upstream.cache.CacheSpan startReadWrite(java.lang.String str, long j, long j2) throws java.lang.InterruptedException, com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        com.google.android.exoplayer2.upstream.cache.CacheSpan startReadWriteNonBlocking;
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        checkInitialization();
        while (true) {
            startReadWriteNonBlocking = startReadWriteNonBlocking(str, j, j2);
            if (startReadWriteNonBlocking == null) {
                wait();
            }
        }
        return startReadWriteNonBlocking;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    @androidx.annotation.Nullable
    public synchronized com.google.android.exoplayer2.upstream.cache.CacheSpan startReadWriteNonBlocking(java.lang.String str, long j, long j2) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        checkInitialization();
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan e = e(str, j, j2);
        if (e.isCached) {
            return p(str, e);
        }
        if (this.c.n(str).j(j, e.length)) {
            return e;
        }
        return null;
    }
}
