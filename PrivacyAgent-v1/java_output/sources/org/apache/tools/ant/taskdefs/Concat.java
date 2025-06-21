package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Concat extends org.apache.tools.ant.Task implements org.apache.tools.ant.types.ResourceCollection {
    public static final org.apache.tools.ant.util.FileUtils N = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final org.apache.tools.ant.types.resources.selectors.ResourceSelector O;
    public static final org.apache.tools.ant.types.resources.selectors.ResourceSelector P;
    public org.apache.tools.ant.types.resources.Resources A;
    public java.util.Vector<org.apache.tools.ant.types.FilterChain> B;
    public org.apache.tools.ant.taskdefs.Concat.TextElement E;
    public org.apache.tools.ant.taskdefs.Concat.TextElement F;
    public java.lang.String H;
    public java.lang.String K;
    public org.apache.tools.ant.types.Resource u;
    public boolean v;
    public java.lang.String w;
    public java.lang.String x;
    public boolean y;
    public java.lang.StringBuffer z;
    public boolean C = true;
    public boolean D = false;
    public boolean G = false;
    public java.io.Writer I = null;
    public boolean J = true;
    public org.apache.tools.ant.taskdefs.Concat.ReaderFactory<org.apache.tools.ant.types.Resource> L = new org.apache.tools.ant.taskdefs.Concat.AnonymousClass1();
    public org.apache.tools.ant.taskdefs.Concat.ReaderFactory<java.io.Reader> M = new org.apache.tools.ant.taskdefs.Concat.AnonymousClass2();

    /* renamed from: org.apache.tools.ant.taskdefs.Concat$1, reason: invalid class name */
    public class AnonymousClass1 implements org.apache.tools.ant.taskdefs.Concat.ReaderFactory<org.apache.tools.ant.types.Resource> {
        public AnonymousClass1() {
        }

        @Override // org.apache.tools.ant.taskdefs.Concat.ReaderFactory
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.io.Reader a(org.apache.tools.ant.types.Resource resource) throws java.io.IOException {
            java.io.InputStream inputStream = resource.getInputStream();
            return new java.io.BufferedReader(org.apache.tools.ant.taskdefs.Concat.this.w == null ? new java.io.InputStreamReader(inputStream) : new java.io.InputStreamReader(inputStream, org.apache.tools.ant.taskdefs.Concat.this.w));
        }
    }

    /* renamed from: org.apache.tools.ant.taskdefs.Concat$2, reason: invalid class name */
    public class AnonymousClass2 implements org.apache.tools.ant.taskdefs.Concat.ReaderFactory<java.io.Reader> {
        public AnonymousClass2() {
        }

        @Override // org.apache.tools.ant.taskdefs.Concat.ReaderFactory
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.io.Reader a(java.io.Reader reader) {
            return reader;
        }
    }

    public final class ConcatResource extends org.apache.tools.ant.types.Resource {
        public org.apache.tools.ant.types.ResourceCollection y;

        public ConcatResource(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
            this.y = resourceCollection;
        }

        public /* synthetic */ ConcatResource(org.apache.tools.ant.taskdefs.Concat concat, org.apache.tools.ant.types.ResourceCollection resourceCollection, org.apache.tools.ant.taskdefs.Concat.AnonymousClass1 anonymousClass1) {
            this(resourceCollection);
        }

        @Override // org.apache.tools.ant.types.Resource
        public java.io.InputStream getInputStream() {
            if (org.apache.tools.ant.taskdefs.Concat.this.y) {
                org.apache.tools.ant.util.ConcatResourceInputStream concatResourceInputStream = new org.apache.tools.ant.util.ConcatResourceInputStream(this.y);
                concatResourceInputStream.setManagingComponent(this);
                return concatResourceInputStream;
            }
            java.io.Reader o = org.apache.tools.ant.taskdefs.Concat.this.o(new org.apache.tools.ant.taskdefs.Concat.MultiReader(org.apache.tools.ant.taskdefs.Concat.this, this.y.iterator(), org.apache.tools.ant.taskdefs.Concat.this.L, null));
            if (org.apache.tools.ant.taskdefs.Concat.this.F != null || org.apache.tools.ant.taskdefs.Concat.this.E != null) {
                int i = 1;
                int i2 = org.apache.tools.ant.taskdefs.Concat.this.F != null ? 2 : 1;
                if (org.apache.tools.ant.taskdefs.Concat.this.E != null) {
                    i2++;
                }
                java.io.Reader[] readerArr = new java.io.Reader[i2];
                if (org.apache.tools.ant.taskdefs.Concat.this.F != null) {
                    readerArr[0] = new java.io.StringReader(org.apache.tools.ant.taskdefs.Concat.this.F.getValue());
                    if (org.apache.tools.ant.taskdefs.Concat.this.F.getFiltering()) {
                        readerArr[0] = org.apache.tools.ant.taskdefs.Concat.this.o(readerArr[0]);
                    }
                } else {
                    i = 0;
                }
                int i3 = i + 1;
                readerArr[i] = o;
                if (org.apache.tools.ant.taskdefs.Concat.this.E != null) {
                    readerArr[i3] = new java.io.StringReader(org.apache.tools.ant.taskdefs.Concat.this.E.getValue());
                    if (org.apache.tools.ant.taskdefs.Concat.this.E.getFiltering()) {
                        readerArr[i3] = org.apache.tools.ant.taskdefs.Concat.this.o(readerArr[i3]);
                    }
                }
                o = new org.apache.tools.ant.taskdefs.Concat.MultiReader(org.apache.tools.ant.taskdefs.Concat.this, java.util.Arrays.asList(readerArr).iterator(), org.apache.tools.ant.taskdefs.Concat.this.M, null);
            }
            return org.apache.tools.ant.taskdefs.Concat.this.x == null ? new org.apache.tools.ant.util.ReaderInputStream(o) : new org.apache.tools.ant.util.ReaderInputStream(o, org.apache.tools.ant.taskdefs.Concat.this.x);
        }

        @Override // org.apache.tools.ant.types.Resource
        public java.lang.String getName() {
            if (org.apache.tools.ant.taskdefs.Concat.this.K != null) {
                return org.apache.tools.ant.taskdefs.Concat.this.K;
            }
            return "concat (" + java.lang.String.valueOf(this.y) + ")";
        }
    }

    public final class MultiReader<S> extends java.io.Reader {
        public java.io.Reader n;
        public int t;
        public char[] u;
        public boolean v;
        public java.util.Iterator<S> w;
        public org.apache.tools.ant.taskdefs.Concat.ReaderFactory<S> x;

        public MultiReader(java.util.Iterator<S> it, org.apache.tools.ant.taskdefs.Concat.ReaderFactory<S> readerFactory) {
            this.n = null;
            this.t = 0;
            this.u = new char[org.apache.tools.ant.taskdefs.Concat.this.H.length()];
            this.v = false;
            this.w = it;
            this.x = readerFactory;
        }

        public /* synthetic */ MultiReader(org.apache.tools.ant.taskdefs.Concat concat, java.util.Iterator it, org.apache.tools.ant.taskdefs.Concat.ReaderFactory readerFactory, org.apache.tools.ant.taskdefs.Concat.AnonymousClass1 anonymousClass1) {
            this(it, readerFactory);
        }

        public final void a(char c) {
            for (int length = this.u.length - 2; length >= 0; length--) {
                char[] cArr = this.u;
                cArr[length] = cArr[length + 1];
            }
            this.u[r0.length - 1] = c;
        }

        public final java.io.Reader c() throws java.io.IOException {
            if (this.n == null && this.w.hasNext()) {
                this.n = this.x.a(this.w.next());
                java.util.Arrays.fill(this.u, (char) 0);
            }
            return this.n;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            java.io.Reader reader = this.n;
            if (reader != null) {
                reader.close();
            }
        }

        public final boolean e() {
            return org.apache.tools.ant.taskdefs.Concat.this.G && org.apache.tools.ant.taskdefs.Concat.this.z == null;
        }

        public final boolean f() {
            int i = 0;
            while (true) {
                char[] cArr = this.u;
                if (i >= cArr.length) {
                    return false;
                }
                if (cArr[i] != org.apache.tools.ant.taskdefs.Concat.this.H.charAt(i)) {
                    return true;
                }
                i++;
            }
        }

        public final void g() throws java.io.IOException {
            close();
            this.n = null;
        }

        @Override // java.io.Reader
        public int read() throws java.io.IOException {
            if (this.v) {
                if (this.t < org.apache.tools.ant.taskdefs.Concat.this.H.length()) {
                    java.lang.String str = org.apache.tools.ant.taskdefs.Concat.this.H;
                    int i = this.t;
                    this.t = i + 1;
                    return str.charAt(i);
                }
                this.t = 0;
                this.v = false;
            }
            while (c() != null) {
                int read = c().read();
                if (read != -1) {
                    a((char) read);
                    return read;
                }
                g();
                if (e() && f()) {
                    this.v = true;
                    this.t = 1;
                    return org.apache.tools.ant.taskdefs.Concat.this.H.charAt(0);
                }
            }
            return -1;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws java.io.IOException {
            int i3 = 0;
            while (true) {
                if (c() == null && !this.v) {
                    if (i3 == 0) {
                        return -1;
                    }
                    return i3;
                }
                if (this.v) {
                    java.lang.String str = org.apache.tools.ant.taskdefs.Concat.this.H;
                    int i4 = this.t;
                    this.t = i4 + 1;
                    cArr[i] = str.charAt(i4);
                    if (this.t >= org.apache.tools.ant.taskdefs.Concat.this.H.length()) {
                        this.t = 0;
                        this.v = false;
                    }
                    i2--;
                    i++;
                    i3++;
                    if (i2 == 0) {
                        return i3;
                    }
                } else {
                    int read = c().read(cArr, i, i2);
                    if (read == -1 || read == 0) {
                        g();
                        if (e() && f()) {
                            this.v = true;
                            this.t = 0;
                        }
                    } else {
                        if (e()) {
                            for (int i5 = read; i5 > read - this.u.length && i5 > 0; i5--) {
                                a(cArr[(i + i5) - 1]);
                            }
                        }
                        i2 -= read;
                        i += read;
                        i3 += read;
                        if (i2 == 0) {
                            return i3;
                        }
                    }
                }
            }
        }
    }

    public interface ReaderFactory<S> {
        java.io.Reader a(S s2) throws java.io.IOException;
    }

    public static class TextElement extends org.apache.tools.ant.ProjectComponent {
        public java.lang.String n = "";
        public boolean t = false;
        public boolean u = false;
        public boolean v = true;
        public java.lang.String w = null;

        public void addText(java.lang.String str) {
            this.n += getProject().replaceProperties(str);
        }

        public final boolean getFiltering() {
            return this.v;
        }

        public java.lang.String getValue() {
            if (this.n == null) {
                this.n = "";
            }
            if (this.n.trim().length() == 0) {
                this.n = "";
            }
            if (this.t) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                boolean z = true;
                for (char c : this.n.toCharArray()) {
                    if (z) {
                        if (c != ' ' && c != '\t') {
                            z = false;
                        }
                    }
                    sb.append(c);
                    if (c == '\n' || c == '\r') {
                        z = true;
                    }
                }
                this.n = sb.toString();
            }
            if (this.u) {
                this.n = this.n.trim();
            }
            return this.n;
        }

        public void setEncoding(java.lang.String str) {
            this.w = str;
        }

        public void setFile(java.io.File file) throws org.apache.tools.ant.BuildException {
            if (!file.exists()) {
                throw new org.apache.tools.ant.BuildException("File " + file + org.apache.tools.ant.DirectoryScanner.DOES_NOT_EXIST_POSTFIX);
            }
            java.io.BufferedReader bufferedReader = null;
            try {
                try {
                    bufferedReader = this.w == null ? new java.io.BufferedReader(new java.io.FileReader(file)) : new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), this.w));
                    this.n = org.apache.tools.ant.util.FileUtils.safeReadFully(bufferedReader);
                } catch (java.io.IOException e) {
                    throw new org.apache.tools.ant.BuildException(e);
                }
            } finally {
                org.apache.tools.ant.util.FileUtils.close(bufferedReader);
            }
        }

        public void setFiltering(boolean z) {
            this.v = z;
        }

        public void setTrim(boolean z) {
            this.u = z;
        }

        public void setTrimLeading(boolean z) {
            this.t = z;
        }
    }

    static {
        org.apache.tools.ant.types.resources.selectors.Exists exists = new org.apache.tools.ant.types.resources.selectors.Exists();
        O = exists;
        P = new org.apache.tools.ant.types.resources.selectors.Not(exists);
    }

    public Concat() {
        reset();
    }

    private org.apache.tools.ant.types.ResourceCollection getResources() {
        if (this.A == null) {
            return new org.apache.tools.ant.types.resources.StringResource(getProject(), this.z.toString());
        }
        if (this.u != null) {
            org.apache.tools.ant.types.resources.Intersect intersect = new org.apache.tools.ant.types.resources.Intersect();
            intersect.setProject(getProject());
            intersect.add(this.A);
            intersect.add(this.u);
            if (intersect.size() > 0) {
                throw new org.apache.tools.ant.BuildException("Destination resource " + this.u + " was specified as an input resource.");
            }
        }
        org.apache.tools.ant.types.resources.Restrict restrict = new org.apache.tools.ant.types.resources.Restrict();
        restrict.add(P);
        restrict.add(this.A);
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = restrict.iterator();
        while (it.hasNext()) {
            log(it.next() + org.apache.tools.ant.DirectoryScanner.DOES_NOT_EXIST_POSTFIX, 0);
        }
        org.apache.tools.ant.types.resources.Restrict restrict2 = new org.apache.tools.ant.types.resources.Restrict();
        restrict2.add(O);
        restrict2.add(this.A);
        return restrict2;
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        synchronized (this) {
            if (this.A == null) {
                org.apache.tools.ant.types.resources.Resources resources = new org.apache.tools.ant.types.resources.Resources();
                this.A = resources;
                resources.setProject(getProject());
                this.A.setCache(true);
            }
        }
        this.A.add(resourceCollection);
    }

    public void addFilelist(org.apache.tools.ant.types.FileList fileList) {
        add(fileList);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        add(fileSet);
    }

    public void addFilterChain(org.apache.tools.ant.types.FilterChain filterChain) {
        if (this.B == null) {
            this.B = new java.util.Vector<>();
        }
        this.B.addElement(filterChain);
    }

    public void addFooter(org.apache.tools.ant.taskdefs.Concat.TextElement textElement) {
        this.E = textElement;
    }

    public void addHeader(org.apache.tools.ant.taskdefs.Concat.TextElement textElement) {
        this.F = textElement;
    }

    public void addText(java.lang.String str) {
        if (this.z == null) {
            this.z = new java.lang.StringBuffer(str.length());
        }
        this.z.append(str);
    }

    public org.apache.tools.ant.types.Path createPath() {
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(getProject());
        add(path);
        return path;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        validate();
        if (this.y && this.u == null) {
            throw new org.apache.tools.ant.BuildException("dest|destfile attribute is required for binary concatenation");
        }
        org.apache.tools.ant.types.ResourceCollection resources = getResources();
        if (p(resources)) {
            log(this.u + " is up-to-date.", 3);
            return;
        }
        if (resources.size() == 0 && this.J) {
            return;
        }
        try {
            org.apache.tools.ant.taskdefs.Concat.ConcatResource concatResource = new org.apache.tools.ant.taskdefs.Concat.ConcatResource(this, resources, null);
            org.apache.tools.ant.types.Resource resource = this.u;
            if (resource == null) {
                resource = new org.apache.tools.ant.types.resources.LogOutputResource(this, 1);
            }
            org.apache.tools.ant.util.ResourceUtils.copyResource(concatResource, resource, null, null, true, false, this.v, null, null, getProject(), this.D);
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("error concatenating content to " + this.u, e);
        }
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        return false;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        validate();
        return java.util.Collections.singletonList(new org.apache.tools.ant.taskdefs.Concat.ConcatResource(this, getResources(), null)).iterator();
    }

    public final java.io.Reader o(java.io.Reader reader) {
        if (this.B == null) {
            return reader;
        }
        org.apache.tools.ant.filters.util.ChainReaderHelper chainReaderHelper = new org.apache.tools.ant.filters.util.ChainReaderHelper();
        chainReaderHelper.setBufferSize(8192);
        chainReaderHelper.setPrimaryReader(reader);
        chainReaderHelper.setFilterChains(this.B);
        chainReaderHelper.setProject(getProject());
        return chainReaderHelper.getAssembledReader();
    }

    public final boolean p(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (this.u == null || this.C) {
            return false;
        }
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = resourceCollection.iterator();
        while (it.hasNext()) {
            if (org.apache.tools.ant.types.selectors.SelectorUtils.isOutOfDate(it.next(), this.u, N.getFileTimestampGranularity())) {
                return false;
            }
        }
        return true;
    }

    public final void q() {
        java.lang.StringBuffer stringBuffer = this.z;
        if (stringBuffer == null || !"".equals(stringBuffer.toString().trim())) {
            return;
        }
        this.z = null;
    }

    public void reset() {
        this.v = false;
        this.C = true;
        this.u = null;
        this.w = null;
        this.x = null;
        this.G = false;
        this.B = null;
        this.E = null;
        this.F = null;
        this.y = false;
        this.I = null;
        this.z = null;
        this.H = org.apache.tools.ant.util.StringUtils.LINE_SEP;
        this.A = null;
        this.J = true;
        this.D = false;
    }

    public void setAppend(boolean z) {
        this.v = z;
    }

    public void setBinary(boolean z) {
        this.y = z;
    }

    public void setDest(org.apache.tools.ant.types.Resource resource) {
        this.u = resource;
    }

    public void setDestfile(java.io.File file) {
        setDest(new org.apache.tools.ant.types.resources.FileResource(file));
    }

    public void setEncoding(java.lang.String str) {
        this.w = str;
        if (this.x == null) {
            this.x = str;
        }
    }

    public void setEol(org.apache.tools.ant.taskdefs.FixCRLF.CrLf crLf) {
        java.lang.String value = crLf.getValue();
        if (value.equals(com.getui.gtc.extension.distribution.gbd.f.h.p) || value.equals("mac")) {
            this.H = "\r";
            return;
        }
        if (value.equals("lf") || value.equals(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX)) {
            this.H = "\n";
        } else if (value.equals("crlf") || value.equals(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_DOS)) {
            this.H = "\r\n";
        }
    }

    public void setFixLastLine(boolean z) {
        this.G = z;
    }

    public void setForce(boolean z) {
        this.C = z;
    }

    public void setForceReadOnly(boolean z) {
        this.D = z;
    }

    public void setIgnoreEmpty(boolean z) {
        this.J = z;
    }

    public void setOutputEncoding(java.lang.String str) {
        this.x = str;
    }

    public void setOverwrite(boolean z) {
        setForce(z);
    }

    public void setResourceName(java.lang.String str) {
        this.K = str;
    }

    public void setWriter(java.io.Writer writer) {
        this.I = writer;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public int size() {
        return 1;
    }

    public final void validate() {
        q();
        if (this.y) {
            if (this.z != null) {
                throw new org.apache.tools.ant.BuildException("Nested text is incompatible with binary concatenation");
            }
            if (this.w != null || this.x != null) {
                throw new org.apache.tools.ant.BuildException("Setting input or output encoding is incompatible with binary concatenation");
            }
            if (this.B != null) {
                throw new org.apache.tools.ant.BuildException("Setting filters is incompatible with binary concatenation");
            }
            if (this.G) {
                throw new org.apache.tools.ant.BuildException("Setting fixlastline is incompatible with binary concatenation");
            }
            if (this.F != null || this.E != null) {
                throw new org.apache.tools.ant.BuildException("Nested header or footer is incompatible with binary concatenation");
            }
        }
        if (this.u != null && this.I != null) {
            throw new org.apache.tools.ant.BuildException("Cannot specify both a destination resource and an output writer");
        }
        org.apache.tools.ant.types.resources.Resources resources = this.A;
        if (resources == null && this.z == null) {
            throw new org.apache.tools.ant.BuildException("At least one resource must be provided, or some text.");
        }
        if (resources != null && this.z != null) {
            throw new org.apache.tools.ant.BuildException("Cannot include inline text when using resources.");
        }
    }
}
