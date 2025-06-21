package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class b extends com.sijla.mla.a.o {
    public com.sijla.mla.a.b.p c;
    public com.sijla.mla.a.b.a e;
    public com.sijla.mla.a.b.o f;
    public com.sijla.mla.a.b.d g;
    public com.sijla.mla.a.b.d h;
    public com.sijla.mla.a.b.c i;
    public com.sijla.mla.a.b.e j;
    private java.io.InputStream L = null;
    public java.io.PrintStream a = java.lang.System.out;
    public java.io.PrintStream b = java.lang.System.err;
    public com.sijla.mla.a.p d = new com.sijla.mla.a.p(this);

    public static abstract class a extends java.io.InputStream {
        protected int b = 0;
        protected int c = 0;
        protected byte[] a = new byte[128];

        public abstract int a();

        @Override // java.io.InputStream
        public int available() {
            return this.c - this.b;
        }

        @Override // java.io.InputStream
        public int read() {
            if (a() <= 0) {
                return -1;
            }
            byte[] bArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return bArr[i] & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int a = a();
            if (a <= 0) {
                return -1;
            }
            int min = java.lang.Math.min(a, i2);
            java.lang.System.arraycopy(this.a, this.b, bArr, i, min);
            this.b += min;
            return min;
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            long min = java.lang.Math.min(j, this.c - this.b);
            this.b = (int) (this.b + min);
            return min;
        }
    }

    /* renamed from: com.sijla.mla.a.b$b, reason: collision with other inner class name */
    public static class C0458b extends com.sijla.mla.a.b.a {
        private final java.io.InputStream d;

        public C0458b(java.io.InputStream inputStream) {
            this(inputStream, (byte) 0);
        }

        private C0458b(java.io.InputStream inputStream, byte b) {
            this.d = inputStream;
        }

        @Override // com.sijla.mla.a.b.a
        public final int a() {
            int i = this.b;
            int i2 = this.c;
            if (i < i2) {
                return i2 - i;
            }
            byte[] bArr = this.a;
            if (i2 >= bArr.length) {
                this.c = 0;
                this.b = 0;
            }
            java.io.InputStream inputStream = this.d;
            int i3 = this.c;
            int read = inputStream.read(bArr, i3, bArr.length - i3);
            if (read < 0) {
                return -1;
            }
            if (read == 0) {
                int read2 = this.d.read();
                if (read2 < 0) {
                    return -1;
                }
                this.a[this.c] = (byte) read2;
                read = 1;
            }
            this.c += read;
            return read;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.d.close();
        }

        @Override // java.io.InputStream
        public final synchronized void mark(int i) {
            int i2 = this.b;
            if (i2 > 0 || i > this.a.length) {
                byte[] bArr = this.a;
                byte[] bArr2 = i > bArr.length ? new byte[i] : bArr;
                java.lang.System.arraycopy(bArr, i2, bArr2, 0, this.c - i2);
                this.c -= this.b;
                this.b = 0;
                this.a = bArr2;
            }
        }

        @Override // java.io.InputStream
        public final boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public final synchronized void reset() {
            this.b = 0;
        }
    }

    public interface c {
        com.sijla.mla.a.w a(java.io.InputStream inputStream, java.lang.String str);
    }

    public interface d {
        com.sijla.mla.a.j a(com.sijla.mla.a.w wVar, com.sijla.mla.a.r rVar);
    }

    public interface e {
        com.sijla.mla.a.w a(java.io.InputStream inputStream, java.lang.String str);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.b a() {
        return this;
    }

    public final com.sijla.mla.a.r a(java.io.InputStream inputStream, java.lang.String str, java.lang.String str2, com.sijla.mla.a.r rVar) {
        com.sijla.mla.a.w wVar;
        try {
            if (str2.indexOf(98) >= 0) {
                if (this.j == null) {
                    com.sijla.mla.a.r.d("No undumper.");
                }
                if (!inputStream.markSupported()) {
                    inputStream = new com.sijla.mla.a.b.C0458b(inputStream);
                }
                inputStream.mark(4);
                wVar = this.j.a(inputStream, str);
                if (wVar != null) {
                    return this.h.a(wVar, rVar);
                }
                inputStream.reset();
            }
            if (str2.indexOf(116) >= 0) {
                if (this.i == null) {
                    com.sijla.mla.a.r.d("No compiler.");
                }
                wVar = this.i.a(inputStream, str);
            } else {
                com.sijla.mla.a.r.d("Failed to load prototype " + str + " using mode '" + str2 + "'");
                wVar = null;
            }
            return this.h.a(wVar, rVar);
        } catch (com.sijla.mla.a.i e2) {
            throw e2;
        } catch (java.lang.Exception e3) {
            return com.sijla.mla.a.r.d("load " + str + ": " + e3);
        }
    }

    public final com.sijla.mla.a.r a(java.lang.String str) {
        try {
            return a(this.c.a(str), "@".concat(java.lang.String.valueOf(str)), com.sijla.mla.L2.s1110702(), this);
        } catch (java.lang.Exception e2) {
            return com.sijla.mla.a.r.d("load " + str + ": " + e2);
        }
    }
}
