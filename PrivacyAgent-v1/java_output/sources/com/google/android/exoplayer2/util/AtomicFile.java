package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class AtomicFile {
    public final java.io.File a;
    public final java.io.File b;

    public static final class AtomicFileOutputStream extends java.io.OutputStream {
        public final java.io.FileOutputStream n;
        public boolean t = false;

        public AtomicFileOutputStream(java.io.File file) throws java.io.FileNotFoundException {
            this.n = new java.io.FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.t) {
                return;
            }
            this.t = true;
            flush();
            try {
                this.n.getFD().sync();
            } catch (java.io.IOException e) {
                com.google.android.exoplayer2.util.Log.w("AtomicFile", "Failed to sync file descriptor:", e);
            }
            this.n.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws java.io.IOException {
            this.n.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws java.io.IOException {
            this.n.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws java.io.IOException {
            this.n.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
            this.n.write(bArr, i, i2);
        }
    }

    public AtomicFile(java.io.File file) {
        this.a = file;
        this.b = new java.io.File(java.lang.String.valueOf(file.getPath()).concat(".bak"));
    }

    public final void a() {
        if (this.b.exists()) {
            this.a.delete();
            this.b.renameTo(this.a);
        }
    }

    public void delete() {
        this.a.delete();
        this.b.delete();
    }

    public void endWrite(java.io.OutputStream outputStream) throws java.io.IOException {
        outputStream.close();
        this.b.delete();
    }

    public boolean exists() {
        return this.a.exists() || this.b.exists();
    }

    public java.io.InputStream openRead() throws java.io.FileNotFoundException {
        a();
        return new java.io.FileInputStream(this.a);
    }

    public java.io.OutputStream startWrite() throws java.io.IOException {
        if (this.a.exists()) {
            if (this.b.exists()) {
                this.a.delete();
            } else if (!this.a.renameTo(this.b)) {
                java.lang.String valueOf = java.lang.String.valueOf(this.a);
                java.lang.String valueOf2 = java.lang.String.valueOf(this.b);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 37 + valueOf2.length());
                sb.append("Couldn't rename file ");
                sb.append(valueOf);
                sb.append(" to backup file ");
                sb.append(valueOf2);
                com.google.android.exoplayer2.util.Log.w("AtomicFile", sb.toString());
            }
        }
        try {
            return new com.google.android.exoplayer2.util.AtomicFile.AtomicFileOutputStream(this.a);
        } catch (java.io.FileNotFoundException e) {
            java.io.File parentFile = this.a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                java.lang.String valueOf3 = java.lang.String.valueOf(this.a);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(valueOf3.length() + 16);
                sb2.append("Couldn't create ");
                sb2.append(valueOf3);
                throw new java.io.IOException(sb2.toString(), e);
            }
            try {
                return new com.google.android.exoplayer2.util.AtomicFile.AtomicFileOutputStream(this.a);
            } catch (java.io.FileNotFoundException e2) {
                java.lang.String valueOf4 = java.lang.String.valueOf(this.a);
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder(valueOf4.length() + 16);
                sb3.append("Couldn't create ");
                sb3.append(valueOf4);
                throw new java.io.IOException(sb3.toString(), e2);
            }
        }
    }
}
