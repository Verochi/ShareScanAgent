package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class FixCrLfFilter extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public boolean A;
    public boolean B;
    public int v;
    public org.apache.tools.ant.filters.FixCrLfFilter.CrLf w;
    public org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove x;
    public org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove y;
    public boolean z;

    public static class AddAsisRemove extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove b = newInstance("asis");
        public static final org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove c = newInstance(com.anythink.expressad.d.a.b.ay);
        public static final org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove d = newInstance("remove");

        public static org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove newInstance(java.lang.String str) {
            org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove addAsisRemove = new org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove();
            addAsisRemove.setValue(str);
            return addAsisRemove;
        }

        public final org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove e() {
            return newInstance(getValue());
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove) && getIndex() == ((org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove) obj).getIndex();
        }

        public org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove f() throws java.lang.IllegalStateException {
            org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove addAsisRemove = b;
            if (equals(addAsisRemove)) {
                return addAsisRemove;
            }
            org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove addAsisRemove2 = c;
            if (equals(addAsisRemove2)) {
                return addAsisRemove2;
            }
            org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove addAsisRemove3 = d;
            if (equals(addAsisRemove3)) {
                return addAsisRemove3;
            }
            throw new java.lang.IllegalStateException("No replacement for " + this);
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{com.anythink.expressad.d.a.b.ay, "asis", "remove"};
        }

        public int hashCode() {
            return getIndex();
        }
    }

    public static class AddEofFilter extends org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader {
        public int v;

        public AddEofFilter(java.io.Reader reader) {
            super(reader);
            this.v = -1;
        }

        @Override // org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader, java.io.Reader
        public int read() throws java.io.IOException {
            int read = super.read();
            if (read != -1) {
                this.v = read;
            } else if (this.v != 26) {
                this.v = 26;
                return 26;
            }
            return read;
        }
    }

    public static class AddTabFilter extends org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader {
        public int v;
        public int w;

        public AddTabFilter(java.io.Reader reader, int i) {
            super(reader);
            this.v = 0;
            this.w = i;
        }

        @Override // org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader, java.io.Reader
        public int read() throws java.io.IOException {
            int i;
            int read = super.read();
            if (read == 9) {
                int i2 = this.v;
                int i3 = this.w;
                this.v = (((i2 + i3) - 1) / i3) * i3;
            } else if (read == 10 || read == 13) {
                this.v = 0;
            } else if (read != 32) {
                this.v++;
            } else {
                this.v++;
                if (!a()) {
                    int i4 = this.v;
                    int i5 = this.w;
                    int i6 = (((i4 + i5) - 1) / i5) * i5;
                    int i7 = 0;
                    int i8 = 1;
                    while (true) {
                        int read2 = super.read();
                        if (read2 == -1) {
                            break;
                        }
                        if (read2 == 9) {
                            this.v = i6;
                            i7++;
                            i = this.w;
                        } else {
                            if (read2 != 32) {
                                c(read2);
                                break;
                            }
                            int i9 = this.v + 1;
                            this.v = i9;
                            if (i9 == i6) {
                                i7++;
                                i = this.w;
                            } else {
                                i8++;
                            }
                        }
                        i6 += i;
                        i8 = 0;
                    }
                    while (true) {
                        int i10 = i8 - 1;
                        if (i8 <= 0) {
                            break;
                        }
                        b(' ');
                        this.v--;
                        i8 = i10;
                    }
                    while (true) {
                        int i11 = i7 - 1;
                        if (i7 <= 0) {
                            break;
                        }
                        b('\t');
                        this.v -= this.w;
                        i7 = i11;
                    }
                    read = super.read();
                    if (read == 9) {
                        this.v += this.w;
                    } else if (read == 32) {
                        this.v++;
                    }
                }
            }
            return read;
        }
    }

    public static class CrLf extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final org.apache.tools.ant.filters.FixCrLfFilter.CrLf b = newInstance("asis");
        public static final org.apache.tools.ant.filters.FixCrLfFilter.CrLf c = newInstance(com.getui.gtc.extension.distribution.gbd.f.h.p);
        public static final org.apache.tools.ant.filters.FixCrLfFilter.CrLf d = newInstance("crlf");
        public static final org.apache.tools.ant.filters.FixCrLfFilter.CrLf e = newInstance(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_DOS);
        public static final org.apache.tools.ant.filters.FixCrLfFilter.CrLf f = newInstance("lf");
        public static final org.apache.tools.ant.filters.FixCrLfFilter.CrLf g = newInstance("mac");
        public static final org.apache.tools.ant.filters.FixCrLfFilter.CrLf h = newInstance(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX);

        public static org.apache.tools.ant.filters.FixCrLfFilter.CrLf newInstance(java.lang.String str) {
            org.apache.tools.ant.filters.FixCrLfFilter.CrLf crLf = new org.apache.tools.ant.filters.FixCrLfFilter.CrLf();
            crLf.setValue(str);
            return crLf;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof org.apache.tools.ant.filters.FixCrLfFilter.CrLf) && getIndex() == ((org.apache.tools.ant.filters.FixCrLfFilter.CrLf) obj).getIndex();
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"asis", com.getui.gtc.extension.distribution.gbd.f.h.p, "lf", "crlf", "mac", org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX, org.apache.tools.ant.taskdefs.condition.Os.FAMILY_DOS};
        }

        public final org.apache.tools.ant.filters.FixCrLfFilter.CrLf h() {
            return newInstance(getValue());
        }

        public int hashCode() {
            return getIndex();
        }

        public org.apache.tools.ant.filters.FixCrLfFilter.CrLf i() {
            org.apache.tools.ant.filters.FixCrLfFilter.CrLf crLf = b;
            if (equals(crLf)) {
                return crLf;
            }
            org.apache.tools.ant.filters.FixCrLfFilter.CrLf crLf2 = c;
            if (!equals(crLf2) && !equals(g)) {
                crLf2 = d;
                if (!equals(crLf2) && !equals(e)) {
                    crLf2 = f;
                    if (!equals(crLf2) && !equals(h)) {
                        throw new java.lang.IllegalStateException("No replacement for " + this);
                    }
                }
            }
            return crLf2;
        }
    }

    public static class MaskJavaTabLiteralsFilter extends org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader {
        public boolean v;
        public int w;

        public MaskJavaTabLiteralsFilter(java.io.Reader reader) {
            super(reader);
            this.v = false;
            this.w = 1;
        }

        @Override // org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader
        public boolean a() {
            return this.v || super.a();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:
        
            return r0;
         */
        @Override // org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader, java.io.Reader
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int read() throws java.io.IOException {
            int read = super.read();
            int i = this.w;
            this.v = i == 2 || i == 3;
            switch (i) {
                case 1:
                    if (read == 34) {
                        this.w = 3;
                        break;
                    } else if (read == 39) {
                        this.w = 2;
                        break;
                    } else if (read == 47) {
                        this.w = 6;
                        break;
                    }
                    break;
                case 2:
                    if (read == 39) {
                        this.w = 1;
                        break;
                    }
                    break;
                case 3:
                    if (read == 34) {
                        this.w = 1;
                        break;
                    }
                    break;
                case 4:
                    if (read == 10 || read == 13) {
                        this.w = 1;
                        break;
                    }
                    break;
                case 5:
                    if (read == 42) {
                        this.w = 8;
                        break;
                    }
                    break;
                case 6:
                    if (read == 34) {
                        this.w = 3;
                        break;
                    } else if (read == 39) {
                        this.w = 2;
                        break;
                    } else if (read == 42) {
                        this.w = 5;
                        break;
                    } else if (read == 47) {
                        this.w = 4;
                        break;
                    } else {
                        this.w = 1;
                        break;
                    }
                case 8:
                    if (read == 47) {
                        this.w = 1;
                        break;
                    }
                    break;
            }
        }
    }

    public static class NormalizeEolFilter extends org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader {
        public boolean v;
        public boolean w;
        public int x;
        public char[] y;

        public NormalizeEolFilter(java.io.Reader reader, java.lang.String str, boolean z) {
            super(reader);
            this.x = 0;
            this.y = null;
            this.y = str.toCharArray();
            this.w = z;
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x005a, code lost:
        
            if (r7.v == false) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[LOOP:0: B:21:0x0062->B:23:0x0066, LOOP_START, PHI: r1
  0x0062: PHI (r1v7 int) = (r1v6 int), (r1v11 int) binds: [B:20:0x0060, B:23:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
        @Override // org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader, java.io.Reader
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int read() throws java.io.IOException {
            int i;
            boolean z;
            int read = super.read();
            int i2 = this.x;
            if (i2 != 0) {
                this.x = i2 - 1;
                return read;
            }
            if (read != -1) {
                if (read != 10) {
                    if (read != 13) {
                        if (read == 26) {
                            int read2 = super.read();
                            if (read2 == -1) {
                                if (this.w && !this.v) {
                                    c(read);
                                    i = 1;
                                }
                                i = 0;
                            } else {
                                c(read2);
                            }
                        }
                        i = 0;
                    } else {
                        int read3 = super.read();
                        int read4 = super.read();
                        if (read3 != 13 || read4 != 10) {
                            if (read3 == 13) {
                                c(read4);
                                i = 2;
                            } else if (read3 == 10) {
                                c(read4);
                            } else {
                                c(read4);
                                c(read3);
                            }
                        }
                    }
                    z = false;
                    if (i <= 0) {
                        if (z) {
                            return read;
                        }
                        this.v = false;
                        return read;
                    }
                    while (true) {
                        int i3 = i - 1;
                        if (i <= 0) {
                            this.v = true;
                            return read();
                        }
                        d(this.y);
                        this.x += this.y.length;
                        i = i3;
                    }
                }
                i = 1;
                z = false;
                if (i <= 0) {
                }
            } else {
                if (this.w) {
                }
                i = 0;
            }
            z = true;
            if (i <= 0) {
            }
        }
    }

    public static class RemoveEofFilter extends org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader {
        public int v;

        public RemoveEofFilter(java.io.Reader reader) {
            super(reader);
            this.v = -1;
            try {
                this.v = reader.read();
            } catch (java.io.IOException unused) {
                this.v = -1;
            }
        }

        @Override // org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader, java.io.Reader
        public int read() throws java.io.IOException {
            int read = super.read();
            if (read == -1 && this.v == 26) {
                return -1;
            }
            int i = this.v;
            this.v = read;
            return i;
        }
    }

    public static class RemoveTabFilter extends org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader {
        public int v;
        public int w;

        public RemoveTabFilter(java.io.Reader reader, int i) {
            super(reader);
            this.v = 0;
            this.w = i;
        }

        @Override // org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader, java.io.Reader
        public int read() throws java.io.IOException {
            int read = super.read();
            if (read == 9) {
                int i = this.w;
                int i2 = i - (this.v % i);
                if (!a()) {
                    while (true) {
                        read = 32;
                        if (i2 <= 1) {
                            break;
                        }
                        b(' ');
                        i2--;
                    }
                }
                this.v += i2;
            } else if (read == 10 || read == 13) {
                this.v = 0;
            } else {
                this.v++;
            }
            return read;
        }
    }

    public static class SimpleFilterReader extends java.io.Reader {
        public java.io.Reader n;
        public int[] t = new int[16];
        public int u = 0;

        public SimpleFilterReader(java.io.Reader reader) {
            this.n = reader;
        }

        public boolean a() {
            java.io.Reader reader = this.n;
            return (reader instanceof org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader) && ((org.apache.tools.ant.filters.FixCrLfFilter.SimpleFilterReader) reader).a();
        }

        public void b(char c) {
            c(c);
        }

        public void c(int i) {
            try {
                int[] iArr = this.t;
                int i2 = this.u;
                this.u = i2 + 1;
                iArr[i2] = i;
            } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                int[] iArr2 = this.t;
                int[] iArr3 = new int[iArr2.length * 2];
                java.lang.System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
                this.t = iArr3;
                c(i);
            }
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.n.close();
        }

        public void d(char[] cArr) {
            e(cArr, 0, cArr.length);
        }

        public void e(char[] cArr, int i, int i2) {
            for (int i3 = (i2 + i) - 1; i3 >= i; i3--) {
                b(cArr[i3]);
            }
        }

        @Override // java.io.Reader
        public void mark(int i) throws java.io.IOException {
            this.n.mark(i);
        }

        @Override // java.io.Reader
        public boolean markSupported() {
            return this.n.markSupported();
        }

        @Override // java.io.Reader
        public int read() throws java.io.IOException {
            int i = this.u;
            if (i <= 0) {
                return this.n.read();
            }
            int[] iArr = this.t;
            int i2 = i - 1;
            this.u = i2;
            return iArr[i2];
        }

        @Override // java.io.Reader
        public int read(char[] cArr) throws java.io.IOException {
            return read(cArr, 0, cArr.length);
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws java.io.IOException {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i2 - 1;
                if (i2 <= 0 || (i4 = read()) == -1) {
                    break;
                }
                cArr[i] = (char) i4;
                i3++;
                i++;
                i2 = i5;
            }
            if (i3 == 0 && i4 == -1) {
                return -1;
            }
            return i3;
        }

        @Override // java.io.Reader
        public boolean ready() throws java.io.IOException {
            return this.n.ready();
        }

        @Override // java.io.Reader
        public void reset() throws java.io.IOException {
            this.n.reset();
        }

        @Override // java.io.Reader
        public long skip(long j) throws java.io.IOException {
            return this.n.skip(j);
        }
    }

    public FixCrLfFilter() {
        this.v = 8;
        this.z = false;
        this.A = true;
        this.B = false;
        this.y = org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.b;
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily("mac") && !org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX)) {
            this.x = org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.d;
            setEol(org.apache.tools.ant.filters.FixCrLfFilter.CrLf.g);
        } else if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_DOS)) {
            this.x = org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.b;
            setEol(org.apache.tools.ant.filters.FixCrLfFilter.CrLf.e);
        } else {
            this.x = org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.d;
            setEol(org.apache.tools.ant.filters.FixCrLfFilter.CrLf.h);
        }
    }

    public FixCrLfFilter(java.io.Reader reader) throws java.io.IOException {
        super(reader);
        this.v = 8;
        this.z = false;
        this.A = true;
        this.B = false;
        this.y = org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.b;
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily("mac") && !org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX)) {
            this.x = org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.d;
            setEol(org.apache.tools.ant.filters.FixCrLfFilter.CrLf.g);
        } else if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_DOS)) {
            this.x = org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.b;
            setEol(org.apache.tools.ant.filters.FixCrLfFilter.CrLf.e);
        } else {
            this.x = org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.d;
            setEol(org.apache.tools.ant.filters.FixCrLfFilter.CrLf.h);
        }
    }

    public static java.lang.String a(org.apache.tools.ant.filters.FixCrLfFilter.CrLf crLf) {
        return (crLf == org.apache.tools.ant.filters.FixCrLfFilter.CrLf.c || crLf == org.apache.tools.ant.filters.FixCrLfFilter.CrLf.g) ? "\r" : (crLf == org.apache.tools.ant.filters.FixCrLfFilter.CrLf.d || crLf == org.apache.tools.ant.filters.FixCrLfFilter.CrLf.e) ? "\r\n" : "\n";
    }

    public final void c() {
        ((java.io.FilterReader) this).in = this.x == org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.d ? new org.apache.tools.ant.filters.FixCrLfFilter.RemoveEofFilter(((java.io.FilterReader) this).in) : ((java.io.FilterReader) this).in;
        if (this.w != org.apache.tools.ant.filters.FixCrLfFilter.CrLf.b) {
            ((java.io.FilterReader) this).in = new org.apache.tools.ant.filters.FixCrLfFilter.NormalizeEolFilter(((java.io.FilterReader) this).in, a(this.w), getFixlast());
        }
        if (this.y != org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.b) {
            if (getJavafiles()) {
                ((java.io.FilterReader) this).in = new org.apache.tools.ant.filters.FixCrLfFilter.MaskJavaTabLiteralsFilter(((java.io.FilterReader) this).in);
            }
            ((java.io.FilterReader) this).in = this.y == org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.c ? new org.apache.tools.ant.filters.FixCrLfFilter.AddTabFilter(((java.io.FilterReader) this).in, getTablength()) : new org.apache.tools.ant.filters.FixCrLfFilter.RemoveTabFilter(((java.io.FilterReader) this).in, getTablength());
        }
        ((java.io.FilterReader) this).in = this.x == org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.c ? new org.apache.tools.ant.filters.FixCrLfFilter.AddEofFilter(((java.io.FilterReader) this).in) : ((java.io.FilterReader) this).in;
        this.B = true;
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        try {
            org.apache.tools.ant.filters.FixCrLfFilter fixCrLfFilter = new org.apache.tools.ant.filters.FixCrLfFilter(reader);
            fixCrLfFilter.setJavafiles(getJavafiles());
            fixCrLfFilter.setEol(getEol());
            fixCrLfFilter.setTab(getTab());
            fixCrLfFilter.setTablength(getTablength());
            fixCrLfFilter.setEof(getEof());
            fixCrLfFilter.setFixlast(getFixlast());
            fixCrLfFilter.c();
            return fixCrLfFilter;
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove getEof() {
        return this.x.e();
    }

    public org.apache.tools.ant.filters.FixCrLfFilter.CrLf getEol() {
        return this.w.h();
    }

    public boolean getFixlast() {
        return this.A;
    }

    public boolean getJavafiles() {
        return this.z;
    }

    public org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove getTab() {
        return this.y.e();
    }

    public int getTablength() {
        return this.v;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized int read() throws java.io.IOException {
        if (!this.B) {
            c();
        }
        return ((java.io.FilterReader) this).in.read();
    }

    public void setEof(org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove addAsisRemove) {
        this.x = addAsisRemove.f();
    }

    public void setEol(org.apache.tools.ant.filters.FixCrLfFilter.CrLf crLf) {
        this.w = crLf.i();
    }

    public void setFixlast(boolean z) {
        this.A = z;
    }

    public void setJavafiles(boolean z) {
        this.z = z;
    }

    public void setTab(org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove addAsisRemove) {
        this.y = addAsisRemove.f();
    }

    public void setTablength(int i) throws java.io.IOException {
        if (i < 2 || i > 80) {
            throw new java.io.IOException("tablength must be between 2 and 80");
        }
        this.v = i;
    }
}
