package com.sijla.mla.a;

/* loaded from: classes19.dex */
public abstract class y {

    public static final class a extends com.sijla.mla.a.y {
        private final int a;
        private final com.sijla.mla.a.r[] b;
        private final int c;
        private final com.sijla.mla.a.y d;

        public a(com.sijla.mla.a.r[] rVarArr, int i, int i2, com.sijla.mla.a.y yVar) {
            this.b = rVarArr;
            this.a = i;
            this.c = i2;
            this.d = yVar;
        }

        @Override // com.sijla.mla.a.y
        public final void b(com.sijla.mla.a.r[] rVarArr, int i, int i2) {
            int min = java.lang.Math.min(this.c, i2);
            java.lang.System.arraycopy(this.b, this.a, rVarArr, i, min);
            this.d.b(rVarArr, i + min, i2 - min);
        }

        @Override // com.sijla.mla.a.y
        public final com.sijla.mla.a.y b_(int i) {
            if (i <= 0) {
                com.sijla.mla.a.r.a(1, "start must be > 0");
            }
            if (i == 1) {
                return this;
            }
            int i2 = this.c;
            return i > i2 ? this.d.b_(i - i2) : com.sijla.mla.a.r.a(this.b, (this.a + i) - 1, i2 - (i - 1), this.d);
        }

        @Override // com.sijla.mla.a.y
        public final com.sijla.mla.a.r c(int i) {
            if (i <= 0) {
                return com.sijla.mla.a.r.k;
            }
            int i2 = this.c;
            return i <= i2 ? this.b[(this.a + i) - 1] : this.d.c(i - i2);
        }

        @Override // com.sijla.mla.a.y
        public final int e() {
            return this.c + this.d.e();
        }

        @Override // com.sijla.mla.a.y
        public final com.sijla.mla.a.r h() {
            return this.c > 0 ? this.b[this.a] : this.d.h();
        }
    }

    public static final class b extends com.sijla.mla.a.y {
        private final com.sijla.mla.a.r[] a;
        private final com.sijla.mla.a.y b;

        public b(com.sijla.mla.a.r[] rVarArr, com.sijla.mla.a.y yVar) {
            this.a = rVarArr;
            this.b = yVar;
        }

        @Override // com.sijla.mla.a.y
        public final void b(com.sijla.mla.a.r[] rVarArr, int i, int i2) {
            int min = java.lang.Math.min(this.a.length, i2);
            java.lang.System.arraycopy(this.a, 0, rVarArr, i, min);
            this.b.b(rVarArr, i + min, i2 - min);
        }

        @Override // com.sijla.mla.a.y
        public final com.sijla.mla.a.y b_(int i) {
            if (i <= 0) {
                com.sijla.mla.a.r.a(1, "start must be > 0");
            }
            if (i == 1) {
                return this;
            }
            com.sijla.mla.a.r[] rVarArr = this.a;
            if (i > rVarArr.length) {
                return this.b.b_(i - rVarArr.length);
            }
            int i2 = i - 1;
            return com.sijla.mla.a.r.a(rVarArr, i2, rVarArr.length - i2, this.b);
        }

        @Override // com.sijla.mla.a.y
        public final com.sijla.mla.a.r c(int i) {
            if (i <= 0) {
                return com.sijla.mla.a.r.k;
            }
            com.sijla.mla.a.r[] rVarArr = this.a;
            return i <= rVarArr.length ? rVarArr[i - 1] : this.b.c(i - rVarArr.length);
        }

        @Override // com.sijla.mla.a.y
        public final int e() {
            return this.a.length + this.b.e();
        }

        @Override // com.sijla.mla.a.y
        public final com.sijla.mla.a.r h() {
            com.sijla.mla.a.r[] rVarArr = this.a;
            return rVarArr.length > 0 ? rVarArr[0] : this.b.h();
        }
    }

    public static final class c extends com.sijla.mla.a.y {
        private final com.sijla.mla.a.r a;
        private final com.sijla.mla.a.y b;

        public c(com.sijla.mla.a.r rVar, com.sijla.mla.a.y yVar) {
            this.a = rVar;
            this.b = yVar;
        }

        @Override // com.sijla.mla.a.y
        public final com.sijla.mla.a.y b_(int i) {
            return i == 1 ? this : i == 2 ? this.b : i > 2 ? this.b.b_(i - 1) : com.sijla.mla.a.r.a(1, "start must be > 0");
        }

        @Override // com.sijla.mla.a.y
        public final com.sijla.mla.a.r c(int i) {
            return i == 1 ? this.a : this.b.c(i - 1);
        }

        @Override // com.sijla.mla.a.y
        public final int e() {
            return this.b.e() + 1;
        }

        @Override // com.sijla.mla.a.y
        public final com.sijla.mla.a.r h() {
            return this.a;
        }
    }

    private static void a(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        java.util.zip.GZIPInputStream gZIPInputStream = new java.util.zip.GZIPInputStream(inputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                gZIPInputStream.close();
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void a(boolean z, java.lang.String str) {
        if (z) {
            return;
        }
        com.sijla.mla.a.r.a(1, str);
    }

    public static boolean a(java.io.File file) {
        java.io.FileOutputStream fileOutputStream;
        java.lang.Exception e;
        java.io.FileInputStream fileInputStream;
        boolean z = true;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                fileOutputStream = new java.io.FileOutputStream(file.getPath().replace(".gz", ""));
                try {
                    try {
                        a(fileInputStream, fileOutputStream);
                        fileOutputStream.flush();
                        com.sijla.h.c.a(fileInputStream, fileOutputStream);
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        com.sijla.h.c.a(fileInputStream, fileOutputStream);
                        z = false;
                        file.delete();
                        return z;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    com.sijla.h.c.a(fileInputStream2, fileOutputStream);
                    throw th;
                }
            } catch (java.lang.Exception e3) {
                fileOutputStream = null;
                e = e3;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                com.sijla.h.c.a(fileInputStream2, fileOutputStream);
                throw th;
            }
        } catch (java.lang.Exception e4) {
            fileOutputStream = null;
            e = e4;
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
            com.sijla.h.c.a(fileInputStream2, fileOutputStream);
            throw th;
        }
        file.delete();
        return z;
    }

    public static boolean b(java.io.File file) {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new java.io.FileInputStream(file);
            } catch (java.lang.Exception e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[2];
            fileInputStream.read(bArr);
            boolean z = (((bArr[1] & 255) << 8) | bArr[0]) == 35615;
            try {
                fileInputStream.close();
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
            return z;
        } catch (java.lang.Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            }
            return false;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (java.io.IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static java.lang.String c(java.lang.String str, java.lang.String str2) {
        java.io.Closeable closeable;
        java.io.FileInputStream fileInputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.io.File file = new java.io.File(str);
        java.io.FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            try {
                fileInputStream = new java.io.FileInputStream(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                gZIPOutputStream = new java.util.zip.GZIPOutputStream(new java.io.FileOutputStream(str2));
                try {
                    byte[] bArr = new byte[10240];
                    while (fileInputStream.available() > 10240 && fileInputStream.read(bArr) > 0) {
                        gZIPOutputStream.write(bArr);
                    }
                    int available = fileInputStream.available();
                    fileInputStream.read(bArr, 0, available);
                    gZIPOutputStream.write(bArr, 0, available);
                    gZIPOutputStream.flush();
                    if (file.exists()) {
                        file.delete();
                    }
                    com.sijla.h.c.a(fileInputStream);
                    com.sijla.h.c.a(gZIPOutputStream);
                    return str2;
                } catch (java.lang.Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.sijla.h.c.a(fileInputStream);
                    com.sijla.h.c.a(gZIPOutputStream);
                    return null;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                gZIPOutputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                closeable = null;
                fileInputStream2 = fileInputStream;
                com.sijla.h.c.a(fileInputStream2);
                com.sijla.h.c.a(closeable);
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            fileInputStream = null;
            gZIPOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            closeable = null;
            com.sijla.h.c.a(fileInputStream2);
            com.sijla.h.c.a(closeable);
            throw th;
        }
    }

    public final boolean Z() {
        return c(1).J();
    }

    public final com.sijla.mla.a.n a(int i, com.sijla.mla.a.n nVar) {
        return c(i).b(nVar);
    }

    public final boolean aa() {
        return c(1).v();
    }

    public final boolean ab() {
        return c(1).R();
    }

    public final com.sijla.mla.a.o ac() {
        return c(1).Q();
    }

    public final com.sijla.mla.a.p ad() {
        return c(1).S();
    }

    public com.sijla.mla.a.y b() {
        return this;
    }

    public final java.lang.String b(int i, java.lang.String str) {
        return c(i).a_(str);
    }

    public void b(com.sijla.mla.a.r[] rVarArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i + i3;
            i3++;
            rVarArr[i4] = c(i3);
        }
    }

    public abstract com.sijla.mla.a.y b_(int i);

    public final int c(int i, int i2) {
        return c(i).a(i2);
    }

    public abstract com.sijla.mla.a.r c(int i);

    public final com.sijla.mla.a.r d(int i, com.sijla.mla.a.r rVar) {
        return (i <= 0 || i > e()) ? rVar : c(i);
    }

    public abstract int e();

    public boolean f_() {
        return false;
    }

    public java.lang.String g() {
        com.sijla.mla.a.a aVar = new com.sijla.mla.a.a();
        aVar.a("(");
        int e = e();
        for (int i = 1; i <= e; i++) {
            if (i > 1) {
                aVar.a(",");
            }
            aVar.a(c(i).g());
        }
        aVar.a(")");
        return aVar.c();
    }

    public abstract com.sijla.mla.a.r h();

    public final boolean p(int i) {
        return c(i).d_();
    }

    public final com.sijla.mla.a.o q(int i) {
        return c(i).L();
    }

    public final com.sijla.mla.a.g r(int i) {
        return c(i).l();
    }

    public final double s(int i) {
        return c(i).z().o();
    }

    public final com.sijla.mla.a.j t(int i) {
        return c(i).F();
    }

    public java.lang.String toString() {
        return g();
    }

    public final int u(int i) {
        return c(i).z().p();
    }

    public final java.lang.String v(int i) {
        return c(i).B();
    }

    public final com.sijla.mla.a.n w(int i) {
        return c(i).C();
    }

    public final com.sijla.mla.a.r x(int i) {
        return i <= e() ? c(i) : com.sijla.mla.a.r.a(i, "value expected");
    }

    public final java.lang.String y(int i) {
        return c(i).g();
    }
}
