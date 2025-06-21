package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
class CachedContentIndex {
    public final java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> a;
    public final android.util.SparseArray<java.lang.String> b;
    public final android.util.SparseBooleanArray c;
    public final android.util.SparseBooleanArray d;
    public com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage e;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage f;

    public static final class DatabaseStorage implements com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage {
        public static final java.lang.String[] e = {"id", "key", "metadata"};
        public final com.google.android.exoplayer2.database.DatabaseProvider a;
        public final android.util.SparseArray<com.google.android.exoplayer2.upstream.cache.CachedContent> b = new android.util.SparseArray<>();
        public java.lang.String c;
        public java.lang.String d;

        public DatabaseStorage(com.google.android.exoplayer2.database.DatabaseProvider databaseProvider) {
            this.a = databaseProvider;
        }

        public static void delete(com.google.android.exoplayer2.database.DatabaseProvider databaseProvider, long j) throws com.google.android.exoplayer2.database.DatabaseIOException {
            delete(databaseProvider, java.lang.Long.toHexString(j));
        }

        private static void delete(com.google.android.exoplayer2.database.DatabaseProvider databaseProvider, java.lang.String str) throws com.google.android.exoplayer2.database.DatabaseIOException {
            try {
                java.lang.String l = l(str);
                android.database.sqlite.SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    com.google.android.exoplayer2.database.VersionTable.removeVersion(writableDatabase, 1, str);
                    j(writableDatabase, l);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (android.database.SQLException e2) {
                throw new com.google.android.exoplayer2.database.DatabaseIOException(e2);
            }
        }

        public static void j(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            sQLiteDatabase.execSQL(valueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(valueOf) : new java.lang.String("DROP TABLE IF EXISTS "));
        }

        public static java.lang.String l(java.lang.String str) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            return valueOf.length() != 0 ? "ExoPlayerCacheIndex".concat(valueOf) : new java.lang.String("ExoPlayerCacheIndex");
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void a(long j) {
            java.lang.String hexString = java.lang.Long.toHexString(j);
            this.c = hexString;
            this.d = l(hexString);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void b(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> hashMap) throws java.io.IOException {
            try {
                android.database.sqlite.SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    m(writableDatabase);
                    java.util.Iterator<com.google.android.exoplayer2.upstream.cache.CachedContent> it = hashMap.values().iterator();
                    while (it.hasNext()) {
                        h(writableDatabase, it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.b.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (android.database.SQLException e2) {
                throw new com.google.android.exoplayer2.database.DatabaseIOException(e2);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void c(com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent, boolean z) {
            if (z) {
                this.b.delete(cachedContent.a);
            } else {
                this.b.put(cachedContent.a, null);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public boolean d() throws com.google.android.exoplayer2.database.DatabaseIOException {
            return com.google.android.exoplayer2.database.VersionTable.getVersion(this.a.getReadableDatabase(), 1, (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c)) != -1;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void delete() throws com.google.android.exoplayer2.database.DatabaseIOException {
            delete(this.a, (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c));
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void e(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> hashMap) throws java.io.IOException {
            if (this.b.size() == 0) {
                return;
            }
            try {
                android.database.sqlite.SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i = 0; i < this.b.size(); i++) {
                    try {
                        com.google.android.exoplayer2.upstream.cache.CachedContent valueAt = this.b.valueAt(i);
                        if (valueAt == null) {
                            i(writableDatabase, this.b.keyAt(i));
                        } else {
                            h(writableDatabase, valueAt);
                        }
                    } finally {
                        writableDatabase.endTransaction();
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.b.clear();
            } catch (android.database.SQLException e2) {
                throw new com.google.android.exoplayer2.database.DatabaseIOException(e2);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void f(com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent) {
            this.b.put(cachedContent.a, cachedContent);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void g(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> hashMap, android.util.SparseArray<java.lang.String> sparseArray) throws java.io.IOException {
            com.google.android.exoplayer2.util.Assertions.checkState(this.b.size() == 0);
            try {
                if (com.google.android.exoplayer2.database.VersionTable.getVersion(this.a.getReadableDatabase(), 1, (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c)) != 1) {
                    android.database.sqlite.SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        m(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (java.lang.Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                android.database.Cursor k = k();
                while (k.moveToNext()) {
                    try {
                        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = new com.google.android.exoplayer2.upstream.cache.CachedContent(k.getInt(0), k.getString(1), com.google.android.exoplayer2.upstream.cache.CachedContentIndex.r(new java.io.DataInputStream(new java.io.ByteArrayInputStream(k.getBlob(2)))));
                        hashMap.put(cachedContent.b, cachedContent);
                        sparseArray.put(cachedContent.a, cachedContent.b);
                    } finally {
                    }
                }
                k.close();
            } catch (android.database.sqlite.SQLiteException e2) {
                hashMap.clear();
                sparseArray.clear();
                throw new com.google.android.exoplayer2.database.DatabaseIOException(e2);
            }
        }

        public final void h(android.database.sqlite.SQLiteDatabase sQLiteDatabase, com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent) throws java.io.IOException {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            com.google.android.exoplayer2.upstream.cache.CachedContentIndex.u(cachedContent.d(), new java.io.DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("id", java.lang.Integer.valueOf(cachedContent.a));
            contentValues.put("key", cachedContent.b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.d), null, contentValues);
        }

        public final void i(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i) {
            sQLiteDatabase.delete((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.d), "id = ?", new java.lang.String[]{java.lang.Integer.toString(i)});
        }

        public final android.database.Cursor k() {
            return this.a.getReadableDatabase().query((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.d), e, null, null, null, null, null);
        }

        public final void m(android.database.sqlite.SQLiteDatabase sQLiteDatabase) throws com.google.android.exoplayer2.database.DatabaseIOException {
            com.google.android.exoplayer2.database.VersionTable.setVersion(sQLiteDatabase, 1, (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c), 1);
            j(sQLiteDatabase, (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.d));
            java.lang.String str = this.d;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 88);
            sb.append("CREATE TABLE ");
            sb.append(str);
            sb.append(" ");
            sb.append("(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
            sQLiteDatabase.execSQL(sb.toString());
        }
    }

    public static class LegacyStorage implements com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage {
        public final boolean a;

        @androidx.annotation.Nullable
        public final javax.crypto.Cipher b;

        @androidx.annotation.Nullable
        public final javax.crypto.spec.SecretKeySpec c;

        @androidx.annotation.Nullable
        public final java.security.SecureRandom d;
        public final com.google.android.exoplayer2.util.AtomicFile e;
        public boolean f;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.util.ReusableBufferedOutputStream g;

        public LegacyStorage(java.io.File file, @androidx.annotation.Nullable byte[] bArr, boolean z) {
            javax.crypto.Cipher cipher;
            javax.crypto.spec.SecretKeySpec secretKeySpec;
            com.google.android.exoplayer2.util.Assertions.checkState((bArr == null && z) ? false : true);
            if (bArr != null) {
                com.google.android.exoplayer2.util.Assertions.checkArgument(bArr.length == 16);
                try {
                    cipher = com.google.android.exoplayer2.upstream.cache.CachedContentIndex.i();
                    secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
                } catch (java.security.NoSuchAlgorithmException | javax.crypto.NoSuchPaddingException e) {
                    throw new java.lang.IllegalStateException(e);
                }
            } else {
                com.google.android.exoplayer2.util.Assertions.checkArgument(!z);
                cipher = null;
                secretKeySpec = null;
            }
            this.a = z;
            this.b = cipher;
            this.c = secretKeySpec;
            this.d = z ? new java.security.SecureRandom() : null;
            this.e = new com.google.android.exoplayer2.util.AtomicFile(file);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void a(long j) {
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void b(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> hashMap) throws java.io.IOException {
            l(hashMap);
            this.f = false;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void c(com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent, boolean z) {
            this.f = true;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public boolean d() {
            return this.e.exists();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void delete() {
            this.e.delete();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void e(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> hashMap) throws java.io.IOException {
            if (this.f) {
                b(hashMap);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void f(com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent) {
            this.f = true;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void g(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> hashMap, android.util.SparseArray<java.lang.String> sparseArray) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.f);
            if (j(hashMap, sparseArray)) {
                return;
            }
            hashMap.clear();
            sparseArray.clear();
            this.e.delete();
        }

        public final int h(com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent, int i) {
            int hashCode = (cachedContent.a * 31) + cachedContent.b.hashCode();
            if (i >= 2) {
                return (hashCode * 31) + cachedContent.d().hashCode();
            }
            long a = defpackage.js.a(cachedContent.d());
            return (hashCode * 31) + ((int) (a ^ (a >>> 32)));
        }

        public final com.google.android.exoplayer2.upstream.cache.CachedContent i(int i, java.io.DataInputStream dataInputStream) throws java.io.IOException {
            com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata r;
            int readInt = dataInputStream.readInt();
            java.lang.String readUTF = dataInputStream.readUTF();
            if (i < 2) {
                long readLong = dataInputStream.readLong();
                com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations = new com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations();
                com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations.setContentLength(contentMetadataMutations, readLong);
                r = com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata.EMPTY.copyWithMutationsApplied(contentMetadataMutations);
            } else {
                r = com.google.android.exoplayer2.upstream.cache.CachedContentIndex.r(dataInputStream);
            }
            return new com.google.android.exoplayer2.upstream.cache.CachedContent(readInt, readUTF, r);
        }

        public final boolean j(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> hashMap, android.util.SparseArray<java.lang.String> sparseArray) {
            java.io.BufferedInputStream bufferedInputStream;
            java.io.DataInputStream dataInputStream;
            if (!this.e.exists()) {
                return true;
            }
            java.io.DataInputStream dataInputStream2 = null;
            try {
                bufferedInputStream = new java.io.BufferedInputStream(this.e.openRead());
                dataInputStream = new java.io.DataInputStream(bufferedInputStream);
            } catch (java.io.IOException unused) {
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                int readInt = dataInputStream.readInt();
                if (readInt >= 0 && readInt <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.b == null) {
                            com.google.android.exoplayer2.util.Util.closeQuietly(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.b.init(2, (java.security.Key) com.google.android.exoplayer2.util.Util.castNonNull(this.c), new javax.crypto.spec.IvParameterSpec(bArr));
                            dataInputStream = new java.io.DataInputStream(new javax.crypto.CipherInputStream(bufferedInputStream, this.b));
                        } catch (java.security.InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new java.lang.IllegalStateException(e);
                        } catch (java.security.InvalidKeyException e2) {
                            e = e2;
                            throw new java.lang.IllegalStateException(e);
                        }
                    } else if (this.a) {
                        this.f = true;
                    }
                    int readInt2 = dataInputStream.readInt();
                    int i = 0;
                    for (int i2 = 0; i2 < readInt2; i2++) {
                        com.google.android.exoplayer2.upstream.cache.CachedContent i3 = i(readInt, dataInputStream);
                        hashMap.put(i3.b, i3);
                        sparseArray.put(i3.a, i3.b);
                        i += h(i3, readInt);
                    }
                    int readInt3 = dataInputStream.readInt();
                    boolean z = dataInputStream.read() == -1;
                    if (readInt3 == i && z) {
                        com.google.android.exoplayer2.util.Util.closeQuietly(dataInputStream);
                        return true;
                    }
                    com.google.android.exoplayer2.util.Util.closeQuietly(dataInputStream);
                    return false;
                }
                com.google.android.exoplayer2.util.Util.closeQuietly(dataInputStream);
                return false;
            } catch (java.io.IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    com.google.android.exoplayer2.util.Util.closeQuietly(dataInputStream2);
                }
                return false;
            } catch (java.lang.Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    com.google.android.exoplayer2.util.Util.closeQuietly(dataInputStream2);
                }
                throw th;
            }
        }

        public final void k(com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent, java.io.DataOutputStream dataOutputStream) throws java.io.IOException {
            dataOutputStream.writeInt(cachedContent.a);
            dataOutputStream.writeUTF(cachedContent.b);
            com.google.android.exoplayer2.upstream.cache.CachedContentIndex.u(cachedContent.d(), dataOutputStream);
        }

        public final void l(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> hashMap) throws java.io.IOException {
            java.io.DataOutputStream dataOutputStream = null;
            try {
                java.io.OutputStream startWrite = this.e.startWrite();
                com.google.android.exoplayer2.util.ReusableBufferedOutputStream reusableBufferedOutputStream = this.g;
                if (reusableBufferedOutputStream == null) {
                    this.g = new com.google.android.exoplayer2.util.ReusableBufferedOutputStream(startWrite);
                } else {
                    reusableBufferedOutputStream.reset(startWrite);
                }
                com.google.android.exoplayer2.util.ReusableBufferedOutputStream reusableBufferedOutputStream2 = this.g;
                java.io.DataOutputStream dataOutputStream2 = new java.io.DataOutputStream(reusableBufferedOutputStream2);
                try {
                    dataOutputStream2.writeInt(2);
                    int i = 0;
                    dataOutputStream2.writeInt(this.a ? 1 : 0);
                    if (this.a) {
                        byte[] bArr = new byte[16];
                        ((java.security.SecureRandom) com.google.android.exoplayer2.util.Util.castNonNull(this.d)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            ((javax.crypto.Cipher) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).init(1, (java.security.Key) com.google.android.exoplayer2.util.Util.castNonNull(this.c), new javax.crypto.spec.IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new java.io.DataOutputStream(new javax.crypto.CipherOutputStream(reusableBufferedOutputStream2, this.b));
                        } catch (java.security.InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new java.lang.IllegalStateException(e);
                        } catch (java.security.InvalidKeyException e2) {
                            e = e2;
                            throw new java.lang.IllegalStateException(e);
                        }
                    }
                    dataOutputStream2.writeInt(hashMap.size());
                    for (com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent : hashMap.values()) {
                        k(cachedContent, dataOutputStream2);
                        i += h(cachedContent, 2);
                    }
                    dataOutputStream2.writeInt(i);
                    this.e.endWrite(dataOutputStream2);
                    com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) null);
                } catch (java.lang.Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    com.google.android.exoplayer2.util.Util.closeQuietly(dataOutputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    public interface Storage {
        void a(long j);

        void b(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> hashMap) throws java.io.IOException;

        void c(com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent, boolean z);

        boolean d() throws java.io.IOException;

        void delete() throws java.io.IOException;

        void e(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> hashMap) throws java.io.IOException;

        void f(com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent);

        void g(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> hashMap, android.util.SparseArray<java.lang.String> sparseArray) throws java.io.IOException;
    }

    public CachedContentIndex(@androidx.annotation.Nullable com.google.android.exoplayer2.database.DatabaseProvider databaseProvider, @androidx.annotation.Nullable java.io.File file, @androidx.annotation.Nullable byte[] bArr, boolean z, boolean z2) {
        com.google.android.exoplayer2.util.Assertions.checkState((databaseProvider == null && file == null) ? false : true);
        this.a = new java.util.HashMap<>();
        this.b = new android.util.SparseArray<>();
        this.c = new android.util.SparseBooleanArray();
        this.d = new android.util.SparseBooleanArray();
        com.google.android.exoplayer2.upstream.cache.CachedContentIndex.DatabaseStorage databaseStorage = databaseProvider != null ? new com.google.android.exoplayer2.upstream.cache.CachedContentIndex.DatabaseStorage(databaseProvider) : null;
        com.google.android.exoplayer2.upstream.cache.CachedContentIndex.LegacyStorage legacyStorage = file != null ? new com.google.android.exoplayer2.upstream.cache.CachedContentIndex.LegacyStorage(new java.io.File(file, com.anythink.expressad.exoplayer.j.a.h.a), bArr, z) : null;
        if (databaseStorage == null || (legacyStorage != null && z2)) {
            this.e = (com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage) com.google.android.exoplayer2.util.Util.castNonNull(legacyStorage);
            this.f = databaseStorage;
        } else {
            this.e = databaseStorage;
            this.f = legacyStorage;
        }
    }

    @androidx.annotation.WorkerThread
    public static void delete(com.google.android.exoplayer2.database.DatabaseProvider databaseProvider, long j) throws com.google.android.exoplayer2.database.DatabaseIOException {
        com.google.android.exoplayer2.upstream.cache.CachedContentIndex.DatabaseStorage.delete(databaseProvider, j);
    }

    @android.annotation.SuppressLint({"GetInstance"})
    public static javax.crypto.Cipher i() throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException {
        if (com.google.android.exoplayer2.util.Util.SDK_INT == 18) {
            try {
                return javax.crypto.Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (java.lang.Throwable unused) {
            }
        }
        return javax.crypto.Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    @androidx.annotation.VisibleForTesting
    public static int m(android.util.SparseArray<java.lang.String> sparseArray) {
        int size = sparseArray.size();
        int i = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt >= 0) {
            return keyAt;
        }
        while (i < size && i == sparseArray.keyAt(i)) {
            i++;
        }
        return i;
    }

    public static boolean p(java.lang.String str) {
        return str.startsWith(com.anythink.expressad.exoplayer.j.a.h.a);
    }

    public static com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata r(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        int readInt = dataInputStream.readInt();
        java.util.HashMap hashMap = new java.util.HashMap();
        for (int i = 0; i < readInt; i++) {
            java.lang.String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 < 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(31);
                sb.append("Invalid value size: ");
                sb.append(readInt2);
                throw new java.io.IOException(sb.toString());
            }
            int min = java.lang.Math.min(readInt2, 10485760);
            byte[] bArr = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
            int i2 = 0;
            while (i2 != readInt2) {
                int i3 = i2 + min;
                bArr = java.util.Arrays.copyOf(bArr, i3);
                dataInputStream.readFully(bArr, i2, min);
                min = java.lang.Math.min(readInt2 - i3, 10485760);
                i2 = i3;
            }
            hashMap.put(readUTF, bArr);
        }
        return new com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata(hashMap);
    }

    public static void u(com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata defaultContentMetadata, java.io.DataOutputStream dataOutputStream) throws java.io.IOException {
        java.util.Set<java.util.Map.Entry<java.lang.String, byte[]>> entrySet = defaultContentMetadata.entrySet();
        dataOutputStream.writeInt(entrySet.size());
        for (java.util.Map.Entry<java.lang.String, byte[]> entry : entrySet) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    public final com.google.android.exoplayer2.upstream.cache.CachedContent d(java.lang.String str) {
        int m = m(this.b);
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = new com.google.android.exoplayer2.upstream.cache.CachedContent(m, str);
        this.a.put(str, cachedContent);
        this.b.put(m, str);
        this.d.put(m, true);
        this.e.f(cachedContent);
        return cachedContent;
    }

    public void e(java.lang.String str, com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) {
        com.google.android.exoplayer2.upstream.cache.CachedContent n = n(str);
        if (n.b(contentMetadataMutations)) {
            this.e.f(n);
        }
    }

    public int f(java.lang.String str) {
        return n(str).a;
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.cache.CachedContent g(java.lang.String str) {
        return this.a.get(str);
    }

    public java.util.Collection<com.google.android.exoplayer2.upstream.cache.CachedContent> h() {
        return java.util.Collections.unmodifiableCollection(this.a.values());
    }

    public com.google.android.exoplayer2.upstream.cache.ContentMetadata j(java.lang.String str) {
        com.google.android.exoplayer2.upstream.cache.CachedContent g = g(str);
        return g != null ? g.d() : com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata.EMPTY;
    }

    @androidx.annotation.Nullable
    public java.lang.String k(int i) {
        return this.b.get(i);
    }

    public java.util.Set<java.lang.String> l() {
        return this.a.keySet();
    }

    public com.google.android.exoplayer2.upstream.cache.CachedContent n(java.lang.String str) {
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = this.a.get(str);
        return cachedContent == null ? d(str) : cachedContent;
    }

    @androidx.annotation.WorkerThread
    public void o(long j) throws java.io.IOException {
        com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage storage;
        this.e.a(j);
        com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage storage2 = this.f;
        if (storage2 != null) {
            storage2.a(j);
        }
        if (this.e.d() || (storage = this.f) == null || !storage.d()) {
            this.e.g(this.a, this.b);
        } else {
            this.f.g(this.a, this.b);
            this.e.b(this.a);
        }
        com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage storage3 = this.f;
        if (storage3 != null) {
            storage3.delete();
            this.f = null;
        }
    }

    public void q(java.lang.String str) {
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = this.a.get(str);
        if (cachedContent != null && cachedContent.g() && cachedContent.i()) {
            this.a.remove(str);
            int i = cachedContent.a;
            boolean z = this.d.get(i);
            this.e.c(cachedContent, z);
            if (z) {
                this.b.remove(i);
                this.d.delete(i);
            } else {
                this.b.put(i, null);
                this.c.put(i, true);
            }
        }
    }

    public void s() {
        int size = this.a.size();
        java.lang.String[] strArr = new java.lang.String[size];
        this.a.keySet().toArray(strArr);
        for (int i = 0; i < size; i++) {
            q(strArr[i]);
        }
    }

    @androidx.annotation.WorkerThread
    public void t() throws java.io.IOException {
        this.e.e(this.a);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.b.remove(this.c.keyAt(i));
        }
        this.c.clear();
        this.d.clear();
    }
}
