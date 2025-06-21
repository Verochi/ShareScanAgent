package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class b {
    private static final java.lang.String a = "AtomicFile";
    private final java.io.File b;
    private final java.io.File c;

    public static final class a extends java.io.OutputStream {
        private final java.io.FileOutputStream a;
        private boolean b = false;

        public a(java.io.File file) {
            this.a = new java.io.FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.b) {
                return;
            }
            this.b = true;
            flush();
            try {
                this.a.getFD().sync();
            } catch (java.io.IOException unused) {
            }
            this.a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() {
            this.a.flush();
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
            this.a.write(i);
        }

        @Override // java.io.OutputStream
        public final void write(@androidx.annotation.NonNull byte[] bArr) {
            this.a.write(bArr);
        }

        @Override // java.io.OutputStream
        public final void write(@androidx.annotation.NonNull byte[] bArr, int i, int i2) {
            this.a.write(bArr, i, i2);
        }
    }

    public b(java.io.File file) {
        this.b = file;
        this.c = new java.io.File(file.getPath() + ".bak");
    }

    private void d() {
        if (this.c.exists()) {
            this.b.delete();
            this.c.renameTo(this.b);
        }
    }

    public final void a() {
        this.b.delete();
        this.c.delete();
    }

    public final void a(java.io.OutputStream outputStream) {
        outputStream.close();
        this.c.delete();
    }

    public final java.io.OutputStream b() {
        if (this.b.exists()) {
            if (this.c.exists()) {
                this.b.delete();
            } else if (!this.b.renameTo(this.c)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("Couldn't rename file ");
                sb.append(this.b);
                sb.append(" to backup file ");
                sb.append(this.c);
            }
        }
        try {
            return new com.anythink.expressad.exoplayer.k.b.a(this.b);
        } catch (java.io.FileNotFoundException e) {
            if (!this.b.getParentFile().mkdirs()) {
                throw new java.io.IOException("Couldn't create directory " + this.b, e);
            }
            try {
                return new com.anythink.expressad.exoplayer.k.b.a(this.b);
            } catch (java.io.FileNotFoundException e2) {
                throw new java.io.IOException("Couldn't create " + this.b, e2);
            }
        }
    }

    public final java.io.InputStream c() {
        if (this.c.exists()) {
            this.b.delete();
            this.c.renameTo(this.b);
        }
        return new java.io.FileInputStream(this.b);
    }
}
