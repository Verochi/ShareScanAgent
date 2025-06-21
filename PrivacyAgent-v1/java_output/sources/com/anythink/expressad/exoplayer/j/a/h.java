package com.anythink.expressad.exoplayer.j.a;

/* loaded from: classes12.dex */
final class h {
    public static final java.lang.String a = "cached_content_index.exi";
    private static final int b = 2;
    private static final int c = 1;
    private final java.util.HashMap<java.lang.String, com.anythink.expressad.exoplayer.j.a.g> d;
    private final android.util.SparseArray<java.lang.String> e;
    private final com.anythink.expressad.exoplayer.k.b f;
    private final javax.crypto.Cipher g;
    private final javax.crypto.spec.SecretKeySpec h;
    private final boolean i;
    private boolean j;
    private com.anythink.expressad.exoplayer.k.x k;

    private h(java.io.File file) {
        this(file, null);
    }

    private h(java.io.File file, byte[] bArr) {
        this(file, bArr, bArr != null);
    }

    public h(java.io.File file, byte[] bArr, boolean z) {
        this.i = z;
        if (bArr != null) {
            com.anythink.expressad.exoplayer.k.a.a(bArr.length == 16);
            try {
                this.g = h();
                this.h = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
            } catch (java.security.NoSuchAlgorithmException | javax.crypto.NoSuchPaddingException e) {
                throw new java.lang.IllegalStateException(e);
            }
        } else {
            com.anythink.expressad.exoplayer.k.a.b(!z);
            this.g = null;
            this.h = null;
        }
        this.d = new java.util.HashMap<>();
        this.e = new android.util.SparseArray<>();
        this.f = new com.anythink.expressad.exoplayer.k.b(new java.io.File(file, a));
    }

    private static int a(android.util.SparseArray<java.lang.String> sparseArray) {
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

    private void a(com.anythink.expressad.exoplayer.j.a.g gVar) {
        this.d.put(gVar.b, gVar);
        this.e.put(gVar.a, gVar.b);
    }

    private com.anythink.expressad.exoplayer.j.a.g f(java.lang.String str) {
        android.util.SparseArray<java.lang.String> sparseArray = this.e;
        int size = sparseArray.size();
        int i = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            keyAt = i;
        }
        com.anythink.expressad.exoplayer.j.a.g gVar = new com.anythink.expressad.exoplayer.j.a.g(keyAt, str);
        a(gVar);
        this.j = true;
        return gVar;
    }

    private boolean f() {
        java.io.DataInputStream dataInputStream = null;
        try {
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(this.f.c());
            java.io.DataInputStream dataInputStream2 = new java.io.DataInputStream(bufferedInputStream);
            try {
                int readInt = dataInputStream2.readInt();
                if (readInt >= 0 && readInt <= 2) {
                    if ((dataInputStream2.readInt() & 1) != 0) {
                        if (this.g == null) {
                            com.anythink.expressad.exoplayer.k.af.a((java.io.Closeable) dataInputStream2);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream2.readFully(bArr);
                        try {
                            this.g.init(2, this.h, new javax.crypto.spec.IvParameterSpec(bArr));
                            dataInputStream2 = new java.io.DataInputStream(new javax.crypto.CipherInputStream(bufferedInputStream, this.g));
                        } catch (java.security.InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new java.lang.IllegalStateException(e);
                        } catch (java.security.InvalidKeyException e2) {
                            e = e2;
                            throw new java.lang.IllegalStateException(e);
                        }
                    } else if (this.i) {
                        this.j = true;
                    }
                    int readInt2 = dataInputStream2.readInt();
                    int i = 0;
                    for (int i2 = 0; i2 < readInt2; i2++) {
                        com.anythink.expressad.exoplayer.j.a.g a2 = com.anythink.expressad.exoplayer.j.a.g.a(readInt, dataInputStream2);
                        a(a2);
                        i += a2.a(readInt);
                    }
                    int readInt3 = dataInputStream2.readInt();
                    boolean z = dataInputStream2.read() == -1;
                    if (readInt3 == i && z) {
                        com.anythink.expressad.exoplayer.k.af.a((java.io.Closeable) dataInputStream2);
                        return true;
                    }
                    com.anythink.expressad.exoplayer.k.af.a((java.io.Closeable) dataInputStream2);
                    return false;
                }
                com.anythink.expressad.exoplayer.k.af.a((java.io.Closeable) dataInputStream2);
                return false;
            } catch (java.io.IOException unused) {
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    com.anythink.expressad.exoplayer.k.af.a((java.io.Closeable) dataInputStream);
                }
                return false;
            } catch (java.lang.Throwable th) {
                th = th;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    com.anythink.expressad.exoplayer.k.af.a((java.io.Closeable) dataInputStream);
                }
                throw th;
            }
        } catch (java.io.IOException unused2) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private void g() {
        java.io.DataOutputStream dataOutputStream;
        java.io.DataOutputStream dataOutputStream2 = null;
        try {
            try {
                java.io.OutputStream b2 = this.f.b();
                com.anythink.expressad.exoplayer.k.x xVar = this.k;
                if (xVar == null) {
                    this.k = new com.anythink.expressad.exoplayer.k.x(b2);
                } else {
                    xVar.a(b2);
                }
                dataOutputStream = new java.io.DataOutputStream(this.k);
            } catch (java.io.IOException e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            dataOutputStream.writeInt(2);
            int i = 0;
            dataOutputStream.writeInt(this.i ? 1 : 0);
            if (this.i) {
                byte[] bArr = new byte[16];
                new java.util.Random().nextBytes(bArr);
                dataOutputStream.write(bArr);
                try {
                    this.g.init(1, this.h, new javax.crypto.spec.IvParameterSpec(bArr));
                    dataOutputStream.flush();
                    dataOutputStream = new java.io.DataOutputStream(new javax.crypto.CipherOutputStream(this.k, this.g));
                } catch (java.security.InvalidAlgorithmParameterException e2) {
                    e = e2;
                    throw new java.lang.IllegalStateException(e);
                } catch (java.security.InvalidKeyException e3) {
                    e = e3;
                    throw new java.lang.IllegalStateException(e);
                }
            }
            dataOutputStream.writeInt(this.d.size());
            for (com.anythink.expressad.exoplayer.j.a.g gVar : this.d.values()) {
                gVar.a(dataOutputStream);
                i += gVar.a(2);
            }
            dataOutputStream.writeInt(i);
            this.f.a(dataOutputStream);
            com.anythink.expressad.exoplayer.k.af.a((java.io.Closeable) null);
        } catch (java.io.IOException e4) {
            e = e4;
            dataOutputStream2 = dataOutputStream;
            throw new com.anythink.expressad.exoplayer.j.a.a.C0203a(e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            com.anythink.expressad.exoplayer.k.af.a(dataOutputStream2);
            throw th;
        }
    }

    private static javax.crypto.Cipher h() {
        if (com.anythink.expressad.exoplayer.k.af.a == 18) {
            try {
                return javax.crypto.Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (java.lang.Throwable unused) {
            }
        }
        return javax.crypto.Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public final com.anythink.expressad.exoplayer.j.a.g a(java.lang.String str) {
        com.anythink.expressad.exoplayer.j.a.g gVar = this.d.get(str);
        if (gVar != null) {
            return gVar;
        }
        android.util.SparseArray<java.lang.String> sparseArray = this.e;
        int size = sparseArray.size();
        int i = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            keyAt = i;
        }
        com.anythink.expressad.exoplayer.j.a.g gVar2 = new com.anythink.expressad.exoplayer.j.a.g(keyAt, str);
        a(gVar2);
        this.j = true;
        return gVar2;
    }

    public final java.lang.String a(int i) {
        return this.e.get(i);
    }

    public final void a() {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        if (f()) {
            return;
        }
        this.f.a();
        this.d.clear();
        this.e.clear();
    }

    public final void a(java.lang.String str, com.anythink.expressad.exoplayer.j.a.k kVar) {
        if (a(str).a(kVar)) {
            this.j = true;
        }
    }

    public final com.anythink.expressad.exoplayer.j.a.g b(java.lang.String str) {
        return this.d.get(str);
    }

    public final void b() {
        java.io.DataOutputStream dataOutputStream;
        if (this.j) {
            java.io.DataOutputStream dataOutputStream2 = null;
            try {
                try {
                    java.io.OutputStream b2 = this.f.b();
                    com.anythink.expressad.exoplayer.k.x xVar = this.k;
                    if (xVar == null) {
                        this.k = new com.anythink.expressad.exoplayer.k.x(b2);
                    } else {
                        xVar.a(b2);
                    }
                    dataOutputStream = new java.io.DataOutputStream(this.k);
                } catch (java.io.IOException e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.writeInt(2);
                dataOutputStream.writeInt(this.i ? 1 : 0);
                if (this.i) {
                    byte[] bArr = new byte[16];
                    new java.util.Random().nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        this.g.init(1, this.h, new javax.crypto.spec.IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new java.io.DataOutputStream(new javax.crypto.CipherOutputStream(this.k, this.g));
                    } catch (java.security.InvalidAlgorithmParameterException e2) {
                        e = e2;
                        throw new java.lang.IllegalStateException(e);
                    } catch (java.security.InvalidKeyException e3) {
                        e = e3;
                        throw new java.lang.IllegalStateException(e);
                    }
                }
                dataOutputStream.writeInt(this.d.size());
                int i = 0;
                for (com.anythink.expressad.exoplayer.j.a.g gVar : this.d.values()) {
                    gVar.a(dataOutputStream);
                    i += gVar.a(2);
                }
                dataOutputStream.writeInt(i);
                this.f.a(dataOutputStream);
                com.anythink.expressad.exoplayer.k.af.a((java.io.Closeable) null);
                this.j = false;
            } catch (java.io.IOException e4) {
                e = e4;
                dataOutputStream2 = dataOutputStream;
                throw new com.anythink.expressad.exoplayer.j.a.a.C0203a(e);
            } catch (java.lang.Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                com.anythink.expressad.exoplayer.k.af.a(dataOutputStream2);
                throw th;
            }
        }
    }

    public final int c(java.lang.String str) {
        return a(str).a;
    }

    public final java.util.Collection<com.anythink.expressad.exoplayer.j.a.g> c() {
        return this.d.values();
    }

    public final void d() {
        int size = this.d.size();
        java.lang.String[] strArr = new java.lang.String[size];
        this.d.keySet().toArray(strArr);
        for (int i = 0; i < size; i++) {
            d(strArr[i]);
        }
    }

    public final void d(java.lang.String str) {
        com.anythink.expressad.exoplayer.j.a.g gVar = this.d.get(str);
        if (gVar == null || !gVar.d() || gVar.b()) {
            return;
        }
        this.d.remove(str);
        this.e.remove(gVar.a);
        this.j = true;
    }

    public final com.anythink.expressad.exoplayer.j.a.i e(java.lang.String str) {
        com.anythink.expressad.exoplayer.j.a.g b2 = b(str);
        return b2 != null ? b2.a() : com.anythink.expressad.exoplayer.j.a.l.b;
    }

    public final java.util.Set<java.lang.String> e() {
        return this.d.keySet();
    }
}
