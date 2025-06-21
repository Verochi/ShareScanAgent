package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
public final class h extends com.sijla.mla.a.b.g {

    public final class a extends com.sijla.mla.a.b.g.a {
        private final java.io.RandomAccessFile a;
        private final java.io.InputStream b;
        private final java.io.OutputStream c;
        private boolean d;
        private boolean e;

        private a(com.sijla.mla.a.b.h hVar, java.io.InputStream inputStream) {
            this(null, inputStream, null);
        }

        public /* synthetic */ a(com.sijla.mla.a.b.h hVar, java.io.InputStream inputStream, byte b) {
            this(hVar, inputStream);
        }

        private a(com.sijla.mla.a.b.h hVar, java.io.OutputStream outputStream) {
            this(null, null, outputStream);
        }

        public /* synthetic */ a(com.sijla.mla.a.b.h hVar, java.io.OutputStream outputStream, byte b) {
            this(hVar, outputStream);
        }

        private a(com.sijla.mla.a.b.h hVar, java.io.RandomAccessFile randomAccessFile) {
            this(randomAccessFile, null, null);
        }

        public /* synthetic */ a(com.sijla.mla.a.b.h hVar, java.io.RandomAccessFile randomAccessFile, byte b) {
            this(hVar, randomAccessFile);
        }

        private a(java.io.RandomAccessFile randomAccessFile, java.io.InputStream inputStream, java.io.OutputStream outputStream) {
            super();
            this.d = false;
            this.e = false;
            this.a = randomAccessFile;
            if (inputStream == null) {
                inputStream = null;
            } else if (!inputStream.markSupported()) {
                inputStream = new java.io.BufferedInputStream(inputStream);
            }
            this.b = inputStream;
            this.c = outputStream;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int a(byte[] bArr, int i) {
            java.io.RandomAccessFile randomAccessFile = this.a;
            if (randomAccessFile != null) {
                return randomAccessFile.read(bArr, 0, i);
            }
            java.io.InputStream inputStream = this.b;
            if (inputStream != null) {
                return inputStream.read(bArr, 0, i);
            }
            com.sijla.mla.a.b.h.ak();
            return i;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final void ae() {
            java.io.OutputStream outputStream = this.c;
            if (outputStream != null) {
                outputStream.flush();
            }
        }

        @Override // com.sijla.mla.a.b.g.a
        public final boolean af() {
            return this.a == null;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final void ag() {
            this.d = true;
            java.io.RandomAccessFile randomAccessFile = this.a;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }

        @Override // com.sijla.mla.a.b.g.a
        public final boolean ah() {
            return this.d;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int ai() {
            java.io.RandomAccessFile randomAccessFile = this.a;
            if (randomAccessFile != null) {
                return (int) (randomAccessFile.length() - this.a.getFilePointer());
            }
            return -1;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int aj() {
            java.io.InputStream inputStream = this.b;
            if (inputStream != null) {
                inputStream.mark(1);
                int read = this.b.read();
                this.b.reset();
                return read;
            }
            java.io.RandomAccessFile randomAccessFile = this.a;
            if (randomAccessFile == null) {
                com.sijla.mla.a.b.h.ak();
                return 0;
            }
            long filePointer = randomAccessFile.getFilePointer();
            int read2 = this.a.read();
            this.a.seek(filePointer);
            return read2;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int ak() {
            java.io.InputStream inputStream = this.b;
            if (inputStream != null) {
                return inputStream.read();
            }
            java.io.RandomAccessFile randomAccessFile = this.a;
            if (randomAccessFile != null) {
                return randomAccessFile.read();
            }
            com.sijla.mla.a.b.h.ak();
            return 0;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int b(java.lang.String str, int i) {
            java.io.RandomAccessFile randomAccessFile;
            long filePointer;
            long j;
            if (this.a == null) {
                com.sijla.mla.a.b.h.ak();
                return 0;
            }
            if ("set".equals(str)) {
                randomAccessFile = this.a;
                j = i;
            } else {
                if ("end".equals(str)) {
                    randomAccessFile = this.a;
                    filePointer = randomAccessFile.length();
                } else {
                    randomAccessFile = this.a;
                    filePointer = randomAccessFile.getFilePointer();
                }
                j = filePointer + i;
            }
            randomAccessFile.seek(j);
            return (int) this.a.getFilePointer();
        }

        @Override // com.sijla.mla.a.b.g.a
        public final void c(java.lang.String str) {
            this.e = "no".equals(str);
        }

        @Override // com.sijla.mla.a.b.g.a
        public final void e(com.sijla.mla.a.n nVar) {
            java.io.OutputStream outputStream = this.c;
            if (outputStream != null) {
                outputStream.write(nVar.b, nVar.c, nVar.d);
            } else {
                java.io.RandomAccessFile randomAccessFile = this.a;
                if (randomAccessFile != null) {
                    randomAccessFile.write(nVar.b, nVar.c, nVar.d);
                } else {
                    com.sijla.mla.a.b.h.ak();
                }
            }
            if (this.e) {
                ae();
            }
        }

        @Override // com.sijla.mla.a.b.g.a, com.sijla.mla.a.r, com.sijla.mla.a.y
        public final java.lang.String g() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("file (");
            sb.append(this.d ? "closed" : java.lang.String.valueOf(hashCode()));
            sb.append(")");
            return sb.toString();
        }
    }

    public final class b extends com.sijla.mla.a.b.g.a {
        private b() {
            super();
        }

        public /* synthetic */ b(com.sijla.mla.a.b.h hVar, byte b) {
            this();
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int a(byte[] bArr, int i) {
            throw null;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final void ae() {
        }

        @Override // com.sijla.mla.a.b.g.a
        public final boolean af() {
            return true;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final void ag() {
        }

        @Override // com.sijla.mla.a.b.g.a
        public final boolean ah() {
            return false;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int ai() {
            return -1;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int aj() {
            throw null;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int ak() {
            throw null;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int b(java.lang.String str, int i) {
            return 0;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final void c(java.lang.String str) {
        }

        @Override // com.sijla.mla.a.b.g.a
        public final void e(com.sijla.mla.a.n nVar) {
        }

        @Override // com.sijla.mla.a.b.g.a, com.sijla.mla.a.r, com.sijla.mla.a.y
        public final java.lang.String g() {
            return "file (" + hashCode() + ")";
        }
    }

    public final class c extends com.sijla.mla.a.b.g.a {
        private final int a;

        private c(int i) {
            super();
            this.a = i;
        }

        public /* synthetic */ c(com.sijla.mla.a.b.h hVar, int i, byte b) {
            this(i);
        }

        private final java.io.PrintStream al() {
            return this.a == 2 ? com.sijla.mla.a.b.h.this.b.b : com.sijla.mla.a.b.h.this.b.a;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int a(byte[] bArr, int i) {
            return 0;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final void ae() {
            al().flush();
        }

        @Override // com.sijla.mla.a.b.g.a
        public final boolean af() {
            return true;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final void ag() {
        }

        @Override // com.sijla.mla.a.b.g.a
        public final boolean ah() {
            return false;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int ai() {
            return 0;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int aj() {
            return 0;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int ak() {
            return 0;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final int b(java.lang.String str, int i) {
            return 0;
        }

        @Override // com.sijla.mla.a.b.g.a
        public final void c(java.lang.String str) {
        }

        @Override // com.sijla.mla.a.b.g.a
        public final void e(com.sijla.mla.a.n nVar) {
            al().write(nVar.b, nVar.c, nVar.d);
        }

        @Override // com.sijla.mla.a.b.g.a, com.sijla.mla.a.r, com.sijla.mla.a.y
        public final java.lang.String g() {
            return "file (" + hashCode() + ")";
        }
    }

    public static /* synthetic */ void ak() {
        throw new com.sijla.mla.a.i("not implemented");
    }

    @Override // com.sijla.mla.a.b.g
    public final com.sijla.mla.a.b.g.a a(java.lang.String str, boolean z, boolean z2) {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str, z ? "r" : "rw");
        if (z2) {
            randomAccessFile.seek(randomAccessFile.length());
        } else if (!z) {
            randomAccessFile.setLength(0L);
        }
        return new com.sijla.mla.a.b.h.a(this, randomAccessFile, (byte) 0);
    }

    @Override // com.sijla.mla.a.b.g
    public final com.sijla.mla.a.b.g.a ae() {
        return new com.sijla.mla.a.b.h.b(this, (byte) 0);
    }

    @Override // com.sijla.mla.a.b.g
    public final com.sijla.mla.a.b.g.a af() {
        return new com.sijla.mla.a.b.h.c(this, 1, (byte) 0);
    }

    @Override // com.sijla.mla.a.b.g
    public final com.sijla.mla.a.b.g.a ag() {
        return new com.sijla.mla.a.b.h.c(this, 2, (byte) 0);
    }

    @Override // com.sijla.mla.a.b.g
    public final com.sijla.mla.a.b.g.a ah() {
        java.io.File createTempFile = java.io.File.createTempFile(".mla", "bin");
        createTempFile.deleteOnExit();
        return new com.sijla.mla.a.b.h.a(this, new java.io.RandomAccessFile(createTempFile, "rw"), (byte) 0);
    }

    @Override // com.sijla.mla.a.b.g
    public final com.sijla.mla.a.b.g.a d(java.lang.String str, java.lang.String str2) {
        java.lang.Process exec = java.lang.Runtime.getRuntime().exec(str);
        return com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH.equals(str2) ? new com.sijla.mla.a.b.h.a(this, exec.getOutputStream(), (byte) 0) : new com.sijla.mla.a.b.h.a(this, exec.getInputStream(), (byte) 0);
    }
}
