package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class FileBackedOutputStream extends java.io.OutputStream {
    public final int n;
    public final boolean t;
    public final com.google.common.io.ByteSource u;
    public java.io.OutputStream v;
    public com.google.common.io.FileBackedOutputStream.MemoryOutput w;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.io.File x;

    /* renamed from: com.google.common.io.FileBackedOutputStream$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.io.ByteSource {
        public AnonymousClass1() {
        }

        public void finalize() {
            try {
                com.google.common.io.FileBackedOutputStream.this.reset();
            } catch (java.lang.Throwable th) {
                th.printStackTrace(java.lang.System.err);
            }
        }

        @Override // com.google.common.io.ByteSource
        public java.io.InputStream openStream() throws java.io.IOException {
            return com.google.common.io.FileBackedOutputStream.this.c();
        }
    }

    /* renamed from: com.google.common.io.FileBackedOutputStream$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.io.ByteSource {
        public AnonymousClass2() {
        }

        @Override // com.google.common.io.ByteSource
        public java.io.InputStream openStream() throws java.io.IOException {
            return com.google.common.io.FileBackedOutputStream.this.c();
        }
    }

    public static class MemoryOutput extends java.io.ByteArrayOutputStream {
        public MemoryOutput() {
        }

        public /* synthetic */ MemoryOutput(com.google.common.io.FileBackedOutputStream.AnonymousClass1 anonymousClass1) {
            this();
        }

        public byte[] a() {
            return ((java.io.ByteArrayOutputStream) this).buf;
        }

        public int getCount() {
            return ((java.io.ByteArrayOutputStream) this).count;
        }
    }

    public FileBackedOutputStream(int i) {
        this(i, false);
    }

    public FileBackedOutputStream(int i, boolean z) {
        this.n = i;
        this.t = z;
        com.google.common.io.FileBackedOutputStream.MemoryOutput memoryOutput = new com.google.common.io.FileBackedOutputStream.MemoryOutput(null);
        this.w = memoryOutput;
        this.v = memoryOutput;
        if (z) {
            this.u = new com.google.common.io.FileBackedOutputStream.AnonymousClass1();
        } else {
            this.u = new com.google.common.io.FileBackedOutputStream.AnonymousClass2();
        }
    }

    private void update(int i) throws java.io.IOException {
        if (this.x != null || this.w.getCount() + i <= this.n) {
            return;
        }
        java.io.File createTempFile = java.io.File.createTempFile("FileBackedOutputStream", null);
        if (this.t) {
            createTempFile.deleteOnExit();
        }
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(createTempFile);
        fileOutputStream.write(this.w.a(), 0, this.w.getCount());
        fileOutputStream.flush();
        this.v = fileOutputStream;
        this.x = createTempFile;
        this.w = null;
    }

    public com.google.common.io.ByteSource asByteSource() {
        return this.u;
    }

    public final synchronized java.io.InputStream c() throws java.io.IOException {
        if (this.x != null) {
            return new java.io.FileInputStream(this.x);
        }
        return new java.io.ByteArrayInputStream(this.w.a(), 0, this.w.getCount());
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        this.v.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws java.io.IOException {
        this.v.flush();
    }

    public synchronized void reset() throws java.io.IOException {
        try {
            close();
            com.google.common.io.FileBackedOutputStream.MemoryOutput memoryOutput = this.w;
            if (memoryOutput == null) {
                this.w = new com.google.common.io.FileBackedOutputStream.MemoryOutput(null);
            } else {
                memoryOutput.reset();
            }
            this.v = this.w;
            java.io.File file = this.x;
            if (file != null) {
                this.x = null;
                if (!file.delete()) {
                    throw new java.io.IOException("Could not delete: " + file);
                }
            }
        } catch (java.lang.Throwable th) {
            if (this.w == null) {
                this.w = new com.google.common.io.FileBackedOutputStream.MemoryOutput(null);
            } else {
                this.w.reset();
            }
            this.v = this.w;
            java.io.File file2 = this.x;
            if (file2 != null) {
                this.x = null;
                if (!file2.delete()) {
                    throw new java.io.IOException("Could not delete: " + file2);
                }
            }
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws java.io.IOException {
        update(1);
        this.v.write(i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        update(i2);
        this.v.write(bArr, i, i2);
    }
}
