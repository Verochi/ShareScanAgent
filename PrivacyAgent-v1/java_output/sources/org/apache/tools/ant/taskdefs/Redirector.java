package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Redirector {
    public static final java.lang.String I = java.lang.System.getProperty("file.encoding");
    public java.lang.String A;
    public boolean B;
    public final java.lang.ThreadGroup C;
    public boolean D;
    public final java.lang.Object E;
    public final java.lang.Object F;
    public final java.lang.Object G;
    public boolean H;
    public java.io.File[] a;
    public java.io.File[] b;
    public java.io.File[] c;
    public boolean d;
    public org.apache.tools.ant.taskdefs.Redirector.PropertyOutputStream e;
    public org.apache.tools.ant.taskdefs.Redirector.PropertyOutputStream f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final org.apache.tools.ant.ProjectComponent p;
    public java.io.OutputStream q;
    public java.io.OutputStream r;

    /* renamed from: s, reason: collision with root package name */
    public java.io.InputStream f504s;
    public java.io.PrintStream t;
    public java.io.PrintStream u;
    public java.util.Vector<org.apache.tools.ant.types.FilterChain> v;
    public java.util.Vector<org.apache.tools.ant.types.FilterChain> w;
    public java.util.Vector<org.apache.tools.ant.types.FilterChain> x;
    public java.lang.String y;
    public java.lang.String z;

    public class PropertyOutputStream extends java.io.ByteArrayOutputStream {
        public final java.lang.String n;
        public boolean t = false;

        public PropertyOutputStream(java.lang.String str) {
            this.n = str;
        }

        @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            synchronized (org.apache.tools.ant.taskdefs.Redirector.this.F) {
                if (!this.t && (!org.apache.tools.ant.taskdefs.Redirector.this.j || !org.apache.tools.ant.taskdefs.Redirector.this.B)) {
                    org.apache.tools.ant.taskdefs.Redirector.this.i(this, this.n);
                    this.t = true;
                }
            }
        }
    }

    public Redirector(org.apache.tools.ant.ProjectComponent projectComponent) {
        this.d = false;
        this.e = null;
        this.f = null;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = true;
        this.q = null;
        this.r = null;
        this.f504s = null;
        this.t = null;
        this.u = null;
        java.lang.String str = I;
        this.y = str;
        this.z = str;
        this.A = str;
        this.B = true;
        this.C = new java.lang.ThreadGroup("redirector");
        this.D = true;
        this.E = new java.lang.Object();
        this.F = new java.lang.Object();
        this.G = new java.lang.Object();
        this.H = false;
        this.p = projectComponent;
    }

    public Redirector(org.apache.tools.ant.Task task) {
        this((org.apache.tools.ant.ProjectComponent) task);
    }

    public void complete() throws java.io.IOException {
        java.lang.System.out.flush();
        java.lang.System.err.flush();
        synchronized (this.E) {
            java.io.InputStream inputStream = this.f504s;
            if (inputStream != null) {
                inputStream.close();
            }
        }
        synchronized (this.F) {
            this.q.flush();
            this.q.close();
        }
        synchronized (this.G) {
            this.r.flush();
            this.r.close();
        }
        synchronized (this) {
            while (this.C.activeCount() > 0) {
                try {
                    this.p.log("waiting for " + this.C.activeCount() + " Threads:", 4);
                    int activeCount = this.C.activeCount();
                    java.lang.Thread[] threadArr = new java.lang.Thread[activeCount];
                    this.C.enumerate(threadArr);
                    for (int i = 0; i < activeCount; i++) {
                        java.lang.Thread thread = threadArr[i];
                        if (thread == null) {
                            break;
                        }
                        try {
                            this.p.log(thread.toString(), 4);
                        } catch (java.lang.NullPointerException unused) {
                        }
                    }
                    wait(1000L);
                } catch (java.lang.InterruptedException unused2) {
                    int activeCount2 = this.C.activeCount();
                    java.lang.Thread[] threadArr2 = new java.lang.Thread[activeCount2];
                    this.C.enumerate(threadArr2);
                    for (int i2 = 0; i2 < activeCount2; i2++) {
                        java.lang.Thread thread2 = threadArr2[i2];
                        if (thread2 != null) {
                            thread2.interrupt();
                        }
                    }
                }
            }
        }
        setProperties();
        synchronized (this.E) {
            this.f504s = null;
        }
        synchronized (this.F) {
            this.q = null;
            this.t = null;
        }
        synchronized (this.G) {
            this.r = null;
            this.u = null;
        }
    }

    public org.apache.tools.ant.taskdefs.ExecuteStreamHandler createHandler() throws org.apache.tools.ant.BuildException {
        createStreams();
        return new org.apache.tools.ant.taskdefs.PumpStreamHandler(getOutputStream(), getErrorStream(), getInputStream(), this.a == null && this.i == null);
    }

    public void createStreams() {
        java.util.Vector<org.apache.tools.ant.types.FilterChain> vector;
        synchronized (this.F) {
            g();
            if (this.l || this.q == null) {
                java.io.OutputStream logOutputStream = new org.apache.tools.ant.taskdefs.LogOutputStream(this.p, 2);
                if (this.q != null) {
                    logOutputStream = new org.apache.tools.ant.util.TeeOutputStream(logOutputStream, this.q);
                }
                this.q = logOutputStream;
            }
            java.util.Vector<org.apache.tools.ant.types.FilterChain> vector2 = this.v;
            if ((vector2 != null && vector2.size() > 0) || !this.y.equalsIgnoreCase(this.A)) {
                try {
                    org.apache.tools.ant.util.LeadPipeInputStream leadPipeInputStream = new org.apache.tools.ant.util.LeadPipeInputStream();
                    leadPipeInputStream.setManagingComponent(this.p);
                    java.io.Reader inputStreamReader = new java.io.InputStreamReader(leadPipeInputStream, this.A);
                    java.util.Vector<org.apache.tools.ant.types.FilterChain> vector3 = this.v;
                    if (vector3 != null && vector3.size() > 0) {
                        org.apache.tools.ant.filters.util.ChainReaderHelper chainReaderHelper = new org.apache.tools.ant.filters.util.ChainReaderHelper();
                        chainReaderHelper.setProject(this.p.getProject());
                        chainReaderHelper.setPrimaryReader(inputStreamReader);
                        chainReaderHelper.setFilterChains(this.v);
                        inputStreamReader = chainReaderHelper.getAssembledReader();
                    }
                    java.lang.Thread thread = new java.lang.Thread(this.C, new org.apache.tools.ant.taskdefs.StreamPumper(new org.apache.tools.ant.util.ReaderInputStream(inputStreamReader, this.y), this.q, true), "output pumper");
                    thread.setPriority(10);
                    this.q = new java.io.PipedOutputStream(leadPipeInputStream);
                    thread.start();
                } catch (java.io.IOException e) {
                    throw new org.apache.tools.ant.BuildException("error setting up output stream", e);
                }
            }
        }
        synchronized (this.G) {
            e();
            if (this.m || this.r == null) {
                java.io.OutputStream logOutputStream2 = new org.apache.tools.ant.taskdefs.LogOutputStream(this.p, 1);
                if (this.r != null) {
                    logOutputStream2 = new org.apache.tools.ant.util.TeeOutputStream(logOutputStream2, this.r);
                }
                this.r = logOutputStream2;
            }
            java.util.Vector<org.apache.tools.ant.types.FilterChain> vector4 = this.w;
            if ((vector4 != null && vector4.size() > 0) || !this.z.equalsIgnoreCase(this.A)) {
                try {
                    org.apache.tools.ant.util.LeadPipeInputStream leadPipeInputStream2 = new org.apache.tools.ant.util.LeadPipeInputStream();
                    leadPipeInputStream2.setManagingComponent(this.p);
                    java.io.Reader inputStreamReader2 = new java.io.InputStreamReader(leadPipeInputStream2, this.A);
                    java.util.Vector<org.apache.tools.ant.types.FilterChain> vector5 = this.w;
                    if (vector5 != null && vector5.size() > 0) {
                        org.apache.tools.ant.filters.util.ChainReaderHelper chainReaderHelper2 = new org.apache.tools.ant.filters.util.ChainReaderHelper();
                        chainReaderHelper2.setProject(this.p.getProject());
                        chainReaderHelper2.setPrimaryReader(inputStreamReader2);
                        chainReaderHelper2.setFilterChains(this.w);
                        inputStreamReader2 = chainReaderHelper2.getAssembledReader();
                    }
                    java.lang.Thread thread2 = new java.lang.Thread(this.C, new org.apache.tools.ant.taskdefs.StreamPumper(new org.apache.tools.ant.util.ReaderInputStream(inputStreamReader2, this.z), this.r, true), "error pumper");
                    thread2.setPriority(10);
                    this.r = new java.io.PipedOutputStream(leadPipeInputStream2);
                    thread2.start();
                } catch (java.io.IOException e2) {
                    throw new org.apache.tools.ant.BuildException("error setting up error stream", e2);
                }
            }
        }
        synchronized (this.E) {
            java.io.File[] fileArr = this.a;
            if (fileArr != null && fileArr.length > 0) {
                org.apache.tools.ant.ProjectComponent projectComponent = this.p;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Redirecting input from file");
                sb.append(this.a.length == 1 ? "" : "s");
                projectComponent.log(sb.toString(), 3);
                try {
                    org.apache.tools.ant.util.ConcatFileInputStream concatFileInputStream = new org.apache.tools.ant.util.ConcatFileInputStream(this.a);
                    this.f504s = concatFileInputStream;
                    concatFileInputStream.setManagingComponent(this.p);
                } catch (java.io.IOException e3) {
                    throw new org.apache.tools.ant.BuildException(e3);
                }
            } else if (this.i != null) {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("Using input ");
                if (this.D) {
                    stringBuffer.append(kotlin.text.Typography.quote);
                    stringBuffer.append(this.i);
                    stringBuffer.append(kotlin.text.Typography.quote);
                } else {
                    stringBuffer.append(com.anythink.expressad.foundation.h.i.g);
                }
                this.p.log(stringBuffer.toString(), 3);
                this.f504s = new java.io.ByteArrayInputStream(this.i.getBytes());
            }
            if (this.f504s != null && (vector = this.x) != null && vector.size() > 0) {
                org.apache.tools.ant.filters.util.ChainReaderHelper chainReaderHelper3 = new org.apache.tools.ant.filters.util.ChainReaderHelper();
                chainReaderHelper3.setProject(this.p.getProject());
                try {
                    chainReaderHelper3.setPrimaryReader(new java.io.InputStreamReader(this.f504s, this.A));
                    chainReaderHelper3.setFilterChains(this.x);
                    this.f504s = new org.apache.tools.ant.util.ReaderInputStream(chainReaderHelper3.getAssembledReader(), this.A);
                } catch (java.io.IOException e4) {
                    throw new org.apache.tools.ant.BuildException("error setting up input stream", e4);
                }
            }
        }
    }

    public final void e() {
        java.io.OutputStream outputStream;
        java.io.File[] fileArr = this.c;
        if (fileArr != null && fileArr.length > 0) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("Error ");
            stringBuffer.append(this.k ? "appended" : "redirected");
            stringBuffer.append(" to ");
            this.r = f(this.c, stringBuffer.toString(), 3, this.k, this.o);
        } else if (!this.d && (outputStream = this.q) != null && this.h == null) {
            org.apache.tools.ant.util.OutputStreamFunneler outputStreamFunneler = new org.apache.tools.ant.util.OutputStreamFunneler(outputStream, 0L);
            try {
                this.q = outputStreamFunneler.getFunnelInstance();
                this.r = outputStreamFunneler.getFunnelInstance();
                if (!this.H) {
                    this.q = new org.apache.tools.ant.util.LineOrientedOutputStreamRedirector(this.q);
                    this.r = new org.apache.tools.ant.util.LineOrientedOutputStreamRedirector(this.r);
                }
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException("error splitting output/error streams", e);
            }
        }
        if (this.h == null) {
            this.f = null;
            return;
        }
        if (this.f == null) {
            this.f = new org.apache.tools.ant.taskdefs.Redirector.PropertyOutputStream(this.h);
            this.p.log("Error redirected to property: " + this.h, 3);
        }
        java.io.OutputStream keepAliveOutputStream = new org.apache.tools.ant.util.KeepAliveOutputStream(this.f);
        java.io.File[] fileArr2 = this.c;
        if (fileArr2 != null && fileArr2.length != 0) {
            keepAliveOutputStream = new org.apache.tools.ant.util.TeeOutputStream(this.r, keepAliveOutputStream);
        }
        this.r = keepAliveOutputStream;
    }

    public final java.io.OutputStream f(java.io.File[] fileArr, java.lang.String str, int i, boolean z, boolean z2) {
        org.apache.tools.ant.util.LazyFileOutputStream lazyFileOutputStream = new org.apache.tools.ant.util.LazyFileOutputStream(fileArr[0], z, z2);
        this.p.log(str + fileArr[0], i);
        char[] cArr = new char[str.length()];
        java.util.Arrays.fill(cArr, ' ');
        java.lang.String str2 = new java.lang.String(cArr);
        for (int i2 = 1; i2 < fileArr.length; i2++) {
            this.q = new org.apache.tools.ant.util.TeeOutputStream(this.q, new org.apache.tools.ant.util.LazyFileOutputStream(fileArr[i2], z, z2));
            this.p.log(str2 + fileArr[i2], i);
        }
        return lazyFileOutputStream;
    }

    public final void g() {
        java.io.File[] fileArr = this.b;
        if (fileArr != null && fileArr.length > 0) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("Output ");
            stringBuffer.append(this.j ? "appended" : "redirected");
            stringBuffer.append(" to ");
            this.q = f(this.b, stringBuffer.toString(), 3, this.j, this.n);
        }
        if (this.g == null) {
            this.e = null;
            return;
        }
        if (this.e == null) {
            this.e = new org.apache.tools.ant.taskdefs.Redirector.PropertyOutputStream(this.g);
            this.p.log("Output redirected to property: " + this.g, 3);
        }
        java.io.OutputStream keepAliveOutputStream = new org.apache.tools.ant.util.KeepAliveOutputStream(this.e);
        if (this.q != null) {
            keepAliveOutputStream = new org.apache.tools.ant.util.TeeOutputStream(this.q, keepAliveOutputStream);
        }
        this.q = keepAliveOutputStream;
    }

    public java.io.OutputStream getErrorStream() {
        java.io.OutputStream outputStream;
        synchronized (this.G) {
            outputStream = this.r;
        }
        return outputStream;
    }

    public java.io.InputStream getInputStream() {
        java.io.InputStream inputStream;
        synchronized (this.E) {
            inputStream = this.f504s;
        }
        return inputStream;
    }

    public java.io.OutputStream getOutputStream() {
        java.io.OutputStream outputStream;
        synchronized (this.F) {
            outputStream = this.q;
        }
        return outputStream;
    }

    public void h(java.io.InputStream inputStream) {
        synchronized (this.E) {
            this.f504s = inputStream;
        }
    }

    public void handleErrorFlush(java.lang.String str) {
        synchronized (this.G) {
            if (this.u == null) {
                this.u = new java.io.PrintStream(this.r);
            }
            this.u.print(str);
            this.u.flush();
        }
    }

    public void handleErrorOutput(java.lang.String str) {
        synchronized (this.G) {
            if (this.u == null) {
                this.u = new java.io.PrintStream(this.r);
            }
            this.u.print(str);
        }
    }

    public void handleFlush(java.lang.String str) {
        synchronized (this.F) {
            if (this.t == null) {
                this.t = new java.io.PrintStream(this.q);
            }
            this.t.print(str);
            this.t.flush();
        }
    }

    public int handleInput(byte[] bArr, int i, int i2) throws java.io.IOException {
        synchronized (this.E) {
            java.io.InputStream inputStream = this.f504s;
            if (inputStream == null) {
                return this.p.getProject().defaultInput(bArr, i, i2);
            }
            return inputStream.read(bArr, i, i2);
        }
    }

    public void handleOutput(java.lang.String str) {
        synchronized (this.F) {
            if (this.t == null) {
                this.t = new java.io.PrintStream(this.q);
            }
            this.t.print(str);
        }
    }

    public final void i(java.io.ByteArrayOutputStream byteArrayOutputStream, java.lang.String str) throws java.io.IOException {
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.StringReader(org.apache.tools.ant.taskdefs.Execute.toString(byteArrayOutputStream)));
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (true) {
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine == null) {
                this.p.getProject().setNewProperty(str, stringBuffer.toString());
                return;
            } else {
                if (stringBuffer.length() != 0) {
                    stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
                }
                stringBuffer.append(readLine);
            }
        }
    }

    public void setAlwaysLog(boolean z) {
        synchronized (this.F) {
            this.l = z;
        }
        synchronized (this.G) {
            this.m = z;
        }
    }

    public void setAppend(boolean z) {
        synchronized (this.F) {
            this.j = z;
        }
        synchronized (this.G) {
            this.k = z;
        }
    }

    public void setAppendProperties(boolean z) {
        synchronized (this.F) {
            this.B = z;
        }
    }

    public void setBinaryOutput(boolean z) {
        this.H = z;
    }

    public void setCreateEmptyFiles(boolean z) {
        synchronized (this.F) {
            this.n = z;
        }
        synchronized (this.F) {
            this.o = z;
        }
    }

    public void setError(java.io.File file) {
        setError(file == null ? null : new java.io.File[]{file});
    }

    public void setError(java.io.File[] fileArr) {
        synchronized (this.G) {
            if (fileArr == null) {
                this.c = null;
            } else {
                this.c = (java.io.File[]) fileArr.clone();
            }
        }
    }

    public void setErrorEncoding(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("errorEncoding must not be null");
        }
        synchronized (this.G) {
            this.z = str;
        }
    }

    public void setErrorFilterChains(java.util.Vector<org.apache.tools.ant.types.FilterChain> vector) {
        synchronized (this.G) {
            this.w = vector;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x000b, code lost:
    
        if (r3.equals(r2.h) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setErrorProperty(java.lang.String str) {
        synchronized (this.G) {
            if (str != null) {
            }
            this.h = str;
            this.f = null;
        }
    }

    public void setInput(java.io.File file) {
        setInput(file == null ? null : new java.io.File[]{file});
    }

    public void setInput(java.io.File[] fileArr) {
        synchronized (this.E) {
            if (fileArr == null) {
                this.a = null;
            } else {
                this.a = (java.io.File[]) fileArr.clone();
            }
        }
    }

    public void setInputEncoding(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("inputEncoding must not be null");
        }
        synchronized (this.E) {
            this.A = str;
        }
    }

    public void setInputFilterChains(java.util.Vector<org.apache.tools.ant.types.FilterChain> vector) {
        synchronized (this.E) {
            this.x = vector;
        }
    }

    public void setInputString(java.lang.String str) {
        synchronized (this.E) {
            this.i = str;
        }
    }

    public void setLogError(boolean z) {
        synchronized (this.G) {
            this.d = z;
        }
    }

    public void setLogInputString(boolean z) {
        this.D = z;
    }

    public void setOutput(java.io.File file) {
        setOutput(file == null ? null : new java.io.File[]{file});
    }

    public void setOutput(java.io.File[] fileArr) {
        synchronized (this.F) {
            if (fileArr == null) {
                this.b = null;
            } else {
                this.b = (java.io.File[]) fileArr.clone();
            }
        }
    }

    public void setOutputEncoding(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("outputEncoding must not be null");
        }
        synchronized (this.F) {
            this.y = str;
        }
    }

    public void setOutputFilterChains(java.util.Vector<org.apache.tools.ant.types.FilterChain> vector) {
        synchronized (this.F) {
            this.v = vector;
        }
    }

    public void setOutputProperty(java.lang.String str) {
        if (str == null || !str.equals(this.g)) {
            synchronized (this.F) {
                this.g = str;
                this.e = null;
            }
        }
    }

    public void setProperties() {
        synchronized (this.F) {
            org.apache.tools.ant.util.FileUtils.close(this.e);
        }
        synchronized (this.G) {
            org.apache.tools.ant.util.FileUtils.close(this.f);
        }
    }
}
