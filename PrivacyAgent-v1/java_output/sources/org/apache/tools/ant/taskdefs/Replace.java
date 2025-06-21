package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Replace extends org.apache.tools.ant.taskdefs.MatchingTask {
    public static final org.apache.tools.ant.util.FileUtils J = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public int C;
    public int D;
    public org.apache.tools.ant.types.resources.Union G;
    public java.io.File u = null;
    public org.apache.tools.ant.taskdefs.Replace.NestedString v = null;
    public org.apache.tools.ant.taskdefs.Replace.NestedString w = new org.apache.tools.ant.taskdefs.Replace.NestedString();
    public org.apache.tools.ant.types.Resource x = null;
    public org.apache.tools.ant.types.Resource y = null;
    public java.util.Properties z = null;
    public java.util.ArrayList<org.apache.tools.ant.taskdefs.Replace.Replacefilter> A = new java.util.ArrayList<>();
    public java.io.File B = null;
    public boolean E = false;
    public java.lang.String F = null;
    public boolean H = false;
    public boolean I = false;

    /* renamed from: org.apache.tools.ant.taskdefs.Replace$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<java.lang.Object> {
        public AnonymousClass1() {
        }

        public final int a(java.lang.String str, java.lang.String str2) {
            return str2.length() - str.length();
        }

        @Override // java.util.Comparator
        public int compare(java.lang.Object obj, java.lang.Object obj2) {
            return a(obj.toString(), obj2.toString());
        }
    }

    public class FileInput {
        public final java.io.InputStream b;
        public java.io.Reader c;
        public java.lang.StringBuffer a = new java.lang.StringBuffer();
        public char[] d = new char[4096];

        public FileInput(java.io.File file) throws java.io.IOException {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            this.b = fileInputStream;
            try {
                this.c = new java.io.BufferedReader(org.apache.tools.ant.taskdefs.Replace.this.F != null ? new java.io.InputStreamReader(fileInputStream, org.apache.tools.ant.taskdefs.Replace.this.F) : new java.io.InputStreamReader(fileInputStream));
            } catch (java.lang.Throwable th) {
                if (this.c == null) {
                    this.b.close();
                }
                throw th;
            }
        }

        public void a() throws java.io.IOException {
            this.b.close();
        }

        public java.lang.StringBuffer b() {
            return this.a;
        }

        public boolean c() throws java.io.IOException {
            int read = this.c.read(this.d);
            if (read < 0) {
                return false;
            }
            this.a.append(new java.lang.String(this.d, 0, read));
            return true;
        }
    }

    public class FileOutput {
        public java.lang.StringBuffer a;
        public final java.io.OutputStream b;
        public java.io.Writer c;

        public FileOutput(java.io.File file) throws java.io.IOException {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            this.b = fileOutputStream;
            try {
                this.c = new java.io.BufferedWriter(org.apache.tools.ant.taskdefs.Replace.this.F != null ? new java.io.OutputStreamWriter(fileOutputStream, org.apache.tools.ant.taskdefs.Replace.this.F) : new java.io.OutputStreamWriter(fileOutputStream));
            } catch (java.lang.Throwable th) {
                if (this.c == null) {
                    this.b.close();
                }
                throw th;
            }
        }

        public void a() throws java.io.IOException {
            this.b.close();
        }

        public void b() throws java.io.IOException {
            c();
            this.c.flush();
        }

        public boolean c() throws java.io.IOException {
            this.c.write(this.a.toString());
            java.lang.StringBuffer stringBuffer = this.a;
            stringBuffer.delete(0, stringBuffer.length());
            return false;
        }

        public void d(java.lang.StringBuffer stringBuffer) {
            this.a = stringBuffer;
        }
    }

    public class NestedString {
        public boolean a = false;
        public java.lang.StringBuffer b = new java.lang.StringBuffer();

        public NestedString() {
        }

        public void addText(java.lang.String str) {
            this.b.append(str);
        }

        public java.lang.String getText() {
            java.lang.String stringBuffer = this.b.toString();
            return this.a ? org.apache.tools.ant.taskdefs.Replace.this.getProject().replaceProperties(stringBuffer) : stringBuffer;
        }

        public void setExpandProperties(boolean z) {
            this.a = z;
        }
    }

    public class Replacefilter {
        public org.apache.tools.ant.taskdefs.Replace.NestedString a;
        public org.apache.tools.ant.taskdefs.Replace.NestedString b;
        public java.lang.String c;
        public java.lang.String d;
        public java.lang.StringBuffer e;
        public java.lang.StringBuffer f = new java.lang.StringBuffer();

        public Replacefilter() {
        }

        public void a() {
            d();
            this.f.append(this.e);
            java.lang.StringBuffer stringBuffer = this.e;
            stringBuffer.delete(0, stringBuffer.length());
        }

        public java.lang.StringBuffer b() {
            return this.f;
        }

        public boolean c() {
            java.lang.String token = getToken();
            if (this.e.length() <= token.length()) {
                return false;
            }
            int max = java.lang.Math.max(this.e.length() - token.length(), d());
            this.f.append(this.e.substring(0, max));
            this.e.delete(0, max);
            return true;
        }

        public org.apache.tools.ant.taskdefs.Replace.NestedString createReplaceToken() {
            if (this.a == null) {
                this.a = org.apache.tools.ant.taskdefs.Replace.this.new NestedString();
            }
            return this.a;
        }

        public org.apache.tools.ant.taskdefs.Replace.NestedString createReplaceValue() {
            if (this.b == null) {
                this.b = org.apache.tools.ant.taskdefs.Replace.this.new NestedString();
            }
            return this.b;
        }

        public final int d() {
            java.lang.String token = getToken();
            int indexOf = this.e.indexOf(token);
            int length = token.length();
            int length2 = this.c.length();
            int i = -1;
            while (indexOf >= 0) {
                this.e.replace(indexOf, indexOf + length, this.c);
                i = indexOf + length2;
                indexOf = this.e.indexOf(token, i);
                org.apache.tools.ant.taskdefs.Replace.f(org.apache.tools.ant.taskdefs.Replace.this);
            }
            return i;
        }

        public void e(java.lang.StringBuffer stringBuffer) {
            this.e = stringBuffer;
        }

        public java.lang.String getProperty() {
            return this.d;
        }

        public java.lang.String getReplaceValue() {
            if (this.d != null) {
                return org.apache.tools.ant.taskdefs.Replace.this.z.getProperty(this.d);
            }
            org.apache.tools.ant.taskdefs.Replace.NestedString nestedString = this.b;
            return nestedString != null ? nestedString.getText() : org.apache.tools.ant.taskdefs.Replace.this.w != null ? org.apache.tools.ant.taskdefs.Replace.this.w.getText() : "";
        }

        public java.lang.String getToken() {
            return this.a.getText();
        }

        public java.lang.String getValue() {
            return this.b.getText();
        }

        public void setProperty(java.lang.String str) {
            this.d = str;
        }

        public void setToken(java.lang.String str) {
            createReplaceToken().addText(str);
        }

        public void setValue(java.lang.String str) {
            createReplaceValue().addText(str);
        }

        public void validate() throws org.apache.tools.ant.BuildException {
            org.apache.tools.ant.taskdefs.Replace.NestedString nestedString = this.a;
            if (nestedString == null) {
                throw new org.apache.tools.ant.BuildException("token is a mandatory for replacefilter.");
            }
            if ("".equals(nestedString.getText())) {
                throw new org.apache.tools.ant.BuildException("The token must not be an empty string.");
            }
            if (this.b != null && this.d != null) {
                throw new org.apache.tools.ant.BuildException("Either value or property can be specified, but a replacefilter element cannot have both.");
            }
            if (this.d != null) {
                if (org.apache.tools.ant.taskdefs.Replace.this.x == null) {
                    throw new org.apache.tools.ant.BuildException("The replacefilter's property attribute can only be used with the replacetask's propertyFile/Resource attribute.");
                }
                if (org.apache.tools.ant.taskdefs.Replace.this.z == null || org.apache.tools.ant.taskdefs.Replace.this.z.getProperty(this.d) == null) {
                    throw new org.apache.tools.ant.BuildException("property \"" + this.d + "\" was not found in " + org.apache.tools.ant.taskdefs.Replace.this.x.getName());
                }
            }
            this.c = getReplaceValue();
        }
    }

    public static /* synthetic */ int f(org.apache.tools.ant.taskdefs.Replace replace) {
        int i = replace.D + 1;
        replace.D = i;
        return i;
    }

    public void addConfigured(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (!resourceCollection.isFilesystemOnly()) {
            throw new org.apache.tools.ant.BuildException("only filesystem resources are supported");
        }
        if (this.G == null) {
            this.G = new org.apache.tools.ant.types.resources.Union();
        }
        this.G.add(resourceCollection);
    }

    public org.apache.tools.ant.taskdefs.Replace.NestedString createReplaceToken() {
        if (this.v == null) {
            this.v = new org.apache.tools.ant.taskdefs.Replace.NestedString();
        }
        return this.v;
    }

    public org.apache.tools.ant.taskdefs.Replace.NestedString createReplaceValue() {
        return this.w;
    }

    public org.apache.tools.ant.taskdefs.Replace.Replacefilter createReplacefilter() {
        org.apache.tools.ant.taskdefs.Replace.Replacefilter replacefilter = new org.apache.tools.ant.taskdefs.Replace.Replacefilter();
        this.A.add(replacefilter);
        return replacefilter;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.util.ArrayList<org.apache.tools.ant.taskdefs.Replace.Replacefilter> arrayList = (java.util.ArrayList) this.A.clone();
        java.util.Properties properties = this.z;
        java.util.Properties properties2 = properties == null ? null : (java.util.Properties) properties.clone();
        if (this.v != null) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(this.w.getText());
            o(stringBuffer, "\r\n", "\n");
            java.lang.String str = org.apache.tools.ant.util.StringUtils.LINE_SEP;
            o(stringBuffer, "\n", str);
            java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer(this.v.getText());
            o(stringBuffer2, "\r\n", "\n");
            o(stringBuffer2, "\n", str);
            org.apache.tools.ant.taskdefs.Replace.Replacefilter i = i();
            i.setToken(stringBuffer2.toString());
            i.setValue(stringBuffer.toString());
        }
        try {
            org.apache.tools.ant.types.Resource resource = this.y;
            if (resource != null) {
                java.util.Properties properties3 = getProperties(resource);
                java.util.Iterator<java.lang.Object> k = k(properties3);
                while (k.hasNext()) {
                    java.lang.String obj = k.next().toString();
                    org.apache.tools.ant.taskdefs.Replace.Replacefilter createReplacefilter = createReplacefilter();
                    createReplacefilter.setToken(obj);
                    createReplacefilter.setValue(properties3.getProperty(obj));
                }
            }
            validateAttributes();
            org.apache.tools.ant.types.Resource resource2 = this.x;
            if (resource2 != null) {
                this.z = getProperties(resource2);
            }
            validateReplacefilters();
            this.C = 0;
            this.D = 0;
            java.io.File file = this.u;
            if (file != null) {
                m(file);
            }
            java.io.File file2 = this.B;
            if (file2 != null) {
                for (java.lang.String str2 : super.getDirectoryScanner(file2).getIncludedFiles()) {
                    m(new java.io.File(this.B, str2));
                }
            }
            org.apache.tools.ant.types.resources.Union union = this.G;
            if (union != null) {
                java.util.Iterator<org.apache.tools.ant.types.Resource> it = union.iterator();
                while (it.hasNext()) {
                    m(((org.apache.tools.ant.types.resources.FileProvider) it.next().as(org.apache.tools.ant.types.resources.FileProvider.class)).getFile());
                }
            }
            if (this.E) {
                log("Replaced " + this.D + " occurrences in " + this.C + " files.", 2);
            }
            if (this.I && this.D == 0) {
                throw new org.apache.tools.ant.BuildException("didn't replace anything");
            }
        } finally {
            this.A = arrayList;
            this.z = properties2;
        }
    }

    public java.util.Properties getProperties(java.io.File file) throws org.apache.tools.ant.BuildException {
        return getProperties(new org.apache.tools.ant.types.resources.FileResource(getProject(), file));
    }

    public java.util.Properties getProperties(org.apache.tools.ant.types.Resource resource) throws org.apache.tools.ant.BuildException {
        java.util.Properties properties = new java.util.Properties();
        java.io.InputStream inputStream = null;
        try {
            try {
                inputStream = resource.getInputStream();
                properties.load(inputStream);
                return properties;
            } catch (java.io.IOException unused) {
                throw new org.apache.tools.ant.BuildException("Property resource (" + resource.getName() + ") cannot be loaded.");
            }
        } finally {
            org.apache.tools.ant.util.FileUtils.close(inputStream);
        }
    }

    public final java.lang.StringBuffer h(java.lang.StringBuffer stringBuffer) {
        java.util.Iterator<org.apache.tools.ant.taskdefs.Replace.Replacefilter> it = this.A.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.taskdefs.Replace.Replacefilter next = it.next();
            next.e(stringBuffer);
            stringBuffer = next.b();
        }
        return stringBuffer;
    }

    public final org.apache.tools.ant.taskdefs.Replace.Replacefilter i() {
        org.apache.tools.ant.taskdefs.Replace.Replacefilter replacefilter = new org.apache.tools.ant.taskdefs.Replace.Replacefilter();
        this.A.add(0, replacefilter);
        return replacefilter;
    }

    public final void j() {
        int size = this.A.size();
        for (int i = 0; i < size; i++) {
            this.A.get(i).a();
        }
    }

    public final java.util.Iterator<java.lang.Object> k(java.util.Properties properties) {
        java.util.ArrayList arrayList = new java.util.ArrayList(properties.keySet());
        java.util.Collections.sort(arrayList, new org.apache.tools.ant.taskdefs.Replace.AnonymousClass1());
        return arrayList.iterator();
    }

    public final void l(java.lang.String str) {
        int size = this.A.size();
        for (int i = 0; i < size; i++) {
            org.apache.tools.ant.taskdefs.Replace.Replacefilter replacefilter = this.A.get(i);
            log("Replacing in " + str + ": " + replacefilter.getToken() + " --> " + replacefilter.getReplaceValue(), 3);
        }
    }

    public final void m(java.io.File file) throws org.apache.tools.ant.BuildException {
        if (!file.exists()) {
            throw new org.apache.tools.ant.BuildException("Replace: source file " + file.getPath() + " doesn't exist", getLocation());
        }
        int i = this.D;
        l(file.getPath());
        try {
            java.io.File createTempFile = J.createTempFile(getProject(), "rep", com.baidu.mobads.sdk.internal.al.k, file.getParentFile(), false, true);
            try {
                org.apache.tools.ant.taskdefs.Replace.FileInput fileInput = new org.apache.tools.ant.taskdefs.Replace.FileInput(file);
                try {
                    org.apache.tools.ant.taskdefs.Replace.FileOutput fileOutput = new org.apache.tools.ant.taskdefs.Replace.FileOutput(createTempFile);
                    try {
                        fileOutput.d(h(fileInput.b()));
                        while (fileInput.c()) {
                            if (n()) {
                                fileOutput.c();
                            }
                        }
                        j();
                        fileOutput.b();
                        fileInput.a();
                        if (this.D != i) {
                            this.C++;
                            long lastModified = file.lastModified();
                            org.apache.tools.ant.util.FileUtils fileUtils = J;
                            fileUtils.rename(createTempFile, file);
                            if (this.H) {
                                fileUtils.setFileLastModified(file, lastModified);
                            }
                        }
                    } finally {
                        fileOutput.a();
                    }
                } catch (java.lang.Throwable th) {
                    fileInput.a();
                    throw th;
                }
            } finally {
                if (createTempFile.isFile() && !createTempFile.delete()) {
                    createTempFile.deleteOnExit();
                }
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("IOException in " + file + " - " + e.getClass().getName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + e.getMessage(), e, getLocation());
        }
    }

    public final boolean n() {
        int size = this.A.size();
        for (int i = 0; i < size; i++) {
            if (!this.A.get(i).c()) {
                return false;
            }
        }
        return true;
    }

    public final void o(java.lang.StringBuffer stringBuffer, java.lang.String str, java.lang.String str2) {
        int indexOf = stringBuffer.indexOf(str);
        int length = str.length();
        int length2 = str2.length();
        while (indexOf >= 0) {
            stringBuffer.replace(indexOf, indexOf + length, str2);
            indexOf = stringBuffer.indexOf(str, indexOf + length2);
        }
    }

    public void setDir(java.io.File file) {
        this.B = file;
    }

    public void setEncoding(java.lang.String str) {
        this.F = str;
    }

    public void setFailOnNoReplacements(boolean z) {
        this.I = z;
    }

    public void setFile(java.io.File file) {
        this.u = file;
    }

    public void setPreserveLastModified(boolean z) {
        this.H = z;
    }

    public void setPropertyFile(java.io.File file) {
        setPropertyResource(new org.apache.tools.ant.types.resources.FileResource(file));
    }

    public void setPropertyResource(org.apache.tools.ant.types.Resource resource) {
        this.x = resource;
    }

    public void setReplaceFilterFile(java.io.File file) {
        setReplaceFilterResource(new org.apache.tools.ant.types.resources.FileResource(getProject(), file));
    }

    public void setReplaceFilterResource(org.apache.tools.ant.types.Resource resource) {
        this.y = resource;
    }

    public void setSummary(boolean z) {
        this.E = z;
    }

    public void setToken(java.lang.String str) {
        createReplaceToken().addText(str);
    }

    public void setValue(java.lang.String str) {
        createReplaceValue().addText(str);
    }

    public void validateAttributes() throws org.apache.tools.ant.BuildException {
        if (this.u == null && this.B == null && this.G == null) {
            throw new org.apache.tools.ant.BuildException("Either the file or the dir attribute or nested resources must be specified", getLocation());
        }
        org.apache.tools.ant.types.Resource resource = this.x;
        if (resource != null && !resource.isExists()) {
            throw new org.apache.tools.ant.BuildException("Property file " + this.x.getName() + org.apache.tools.ant.DirectoryScanner.DOES_NOT_EXIST_POSTFIX, getLocation());
        }
        if (this.v == null && this.A.size() == 0) {
            throw new org.apache.tools.ant.BuildException("Either token or a nested replacefilter must be specified", getLocation());
        }
        org.apache.tools.ant.taskdefs.Replace.NestedString nestedString = this.v;
        if (nestedString != null && "".equals(nestedString.getText())) {
            throw new org.apache.tools.ant.BuildException("The token attribute must not be an empty string.", getLocation());
        }
    }

    public void validateReplacefilters() throws org.apache.tools.ant.BuildException {
        int size = this.A.size();
        for (int i = 0; i < size; i++) {
            this.A.get(i).validate();
        }
    }
}
