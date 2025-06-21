package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Javadoc extends org.apache.tools.ant.Task {
    public static final boolean h0 = !org.apache.tools.ant.util.JavaEnvUtils.isJavaVersion("1.4");
    public static final int i0 = 23;
    public static final org.apache.tools.ant.util.FileUtils j0 = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final java.lang.String[] k0 = {"overview", "packages", "types", "constructors", "methods", "fields"};
    public java.lang.String Y;
    public final org.apache.tools.ant.types.Commandline u = new org.apache.tools.ant.types.Commandline();
    public boolean v = false;
    public boolean w = false;
    public org.apache.tools.ant.types.Path x = null;
    public java.io.File y = null;
    public final java.util.Vector<org.apache.tools.ant.taskdefs.Javadoc.SourceFile> z = new java.util.Vector<>();
    public final java.util.Vector<org.apache.tools.ant.taskdefs.Javadoc.PackageName> A = new java.util.Vector<>();
    public final java.util.Vector<org.apache.tools.ant.taskdefs.Javadoc.PackageName> B = new java.util.Vector<>(1);
    public final java.util.List<org.apache.tools.ant.taskdefs.Javadoc.PackageName> C = new java.util.ArrayList();
    public boolean D = true;
    public boolean E = true;
    public org.apache.tools.ant.taskdefs.Javadoc.DocletInfo F = null;
    public org.apache.tools.ant.types.Path G = null;
    public org.apache.tools.ant.types.Path H = null;
    public org.apache.tools.ant.types.Path I = null;
    public org.apache.tools.ant.types.Path J = null;
    public java.lang.String K = null;
    public java.lang.String L = null;
    public final java.util.Vector<org.apache.tools.ant.taskdefs.Javadoc.LinkArgument> M = new java.util.Vector<>();
    public final java.util.Vector<org.apache.tools.ant.taskdefs.Javadoc.GroupArgument> N = new java.util.Vector<>();
    public final java.util.Vector<java.lang.Object> O = new java.util.Vector<>();
    public boolean P = true;
    public org.apache.tools.ant.taskdefs.Javadoc.Html Q = null;
    public org.apache.tools.ant.taskdefs.Javadoc.Html R = null;
    public org.apache.tools.ant.taskdefs.Javadoc.Html S = null;
    public org.apache.tools.ant.taskdefs.Javadoc.Html T = null;
    public boolean U = false;
    public java.lang.String V = null;
    public boolean W = false;
    public boolean X = false;
    public boolean Z = false;
    public java.lang.String a0 = null;
    public boolean b0 = false;
    public java.lang.String c0 = null;
    public java.lang.String d0 = null;
    public boolean e0 = true;
    public final org.apache.tools.ant.taskdefs.Javadoc.ResourceCollectionContainer f0 = new org.apache.tools.ant.taskdefs.Javadoc.ResourceCollectionContainer();
    public final java.util.Vector<org.apache.tools.ant.types.DirSet> g0 = new java.util.Vector<>();

    /* renamed from: org.apache.tools.ant.taskdefs.Javadoc$1, reason: invalid class name */
    public class AnonymousClass1 implements java.io.FilenameFilter {
        public AnonymousClass1() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return str.endsWith(".java") || (org.apache.tools.ant.taskdefs.Javadoc.this.Z && str.equals("package.html"));
        }
    }

    public static class AccessType extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"protected", "public", "package", com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE};
        }
    }

    public class DocletInfo extends org.apache.tools.ant.taskdefs.Javadoc.ExtensionInfo {
        public final java.util.Vector<org.apache.tools.ant.taskdefs.Javadoc.DocletParam> u = new java.util.Vector<>();

        public DocletInfo() {
        }

        public org.apache.tools.ant.taskdefs.Javadoc.DocletParam createParam() {
            org.apache.tools.ant.taskdefs.Javadoc.DocletParam docletParam = org.apache.tools.ant.taskdefs.Javadoc.this.new DocletParam();
            this.u.addElement(docletParam);
            return docletParam;
        }

        public java.util.Enumeration<org.apache.tools.ant.taskdefs.Javadoc.DocletParam> getParams() {
            return this.u.elements();
        }
    }

    public class DocletParam {
        public java.lang.String a;
        public java.lang.String b;

        public DocletParam() {
        }

        public java.lang.String getName() {
            return this.a;
        }

        public java.lang.String getValue() {
            return this.b;
        }

        public void setName(java.lang.String str) {
            this.a = str;
        }

        public void setValue(java.lang.String str) {
            this.b = str;
        }
    }

    public static class ExtensionInfo extends org.apache.tools.ant.ProjectComponent {
        public java.lang.String n;
        public org.apache.tools.ant.types.Path t;

        public org.apache.tools.ant.types.Path createPath() {
            if (this.t == null) {
                this.t = new org.apache.tools.ant.types.Path(getProject());
            }
            return this.t.createPath();
        }

        public java.lang.String getName() {
            return this.n;
        }

        public org.apache.tools.ant.types.Path getPath() {
            return this.t;
        }

        public void setName(java.lang.String str) {
            this.n = str;
        }

        public void setPath(org.apache.tools.ant.types.Path path) {
            org.apache.tools.ant.types.Path path2 = this.t;
            if (path2 == null) {
                this.t = path;
            } else {
                path2.append(path);
            }
        }

        public void setPathRef(org.apache.tools.ant.types.Reference reference) {
            createPath().setRefid(reference);
        }
    }

    public class GroupArgument {
        public org.apache.tools.ant.taskdefs.Javadoc.Html a;
        public final java.util.Vector<org.apache.tools.ant.taskdefs.Javadoc.PackageName> b = new java.util.Vector<>();

        public GroupArgument() {
        }

        public void addPackage(org.apache.tools.ant.taskdefs.Javadoc.PackageName packageName) {
            this.b.addElement(packageName);
        }

        public void addTitle(org.apache.tools.ant.taskdefs.Javadoc.Html html) {
            this.a = html;
        }

        public java.lang.String getPackages() {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                }
                stringBuffer.append(this.b.elementAt(i).toString());
            }
            return stringBuffer.toString();
        }

        public java.lang.String getTitle() {
            org.apache.tools.ant.taskdefs.Javadoc.Html html = this.a;
            if (html != null) {
                return html.getText();
            }
            return null;
        }

        public void setPackages(java.lang.String str) {
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreTokens()) {
                java.lang.String nextToken = stringTokenizer.nextToken();
                org.apache.tools.ant.taskdefs.Javadoc.PackageName packageName = new org.apache.tools.ant.taskdefs.Javadoc.PackageName();
                packageName.setName(nextToken);
                addPackage(packageName);
            }
        }

        public void setTitle(java.lang.String str) {
            org.apache.tools.ant.taskdefs.Javadoc.Html html = new org.apache.tools.ant.taskdefs.Javadoc.Html();
            html.addText(str);
            addTitle(html);
        }
    }

    public static class Html {
        public final java.lang.StringBuffer a = new java.lang.StringBuffer();

        public void addText(java.lang.String str) {
            this.a.append(str);
        }

        public java.lang.String getText() {
            return this.a.substring(0);
        }
    }

    public class JavadocOutputStream extends org.apache.tools.ant.taskdefs.LogOutputStream {
        public java.lang.String w;
        public boolean x;

        public JavadocOutputStream(int i) {
            super((org.apache.tools.ant.Task) org.apache.tools.ant.taskdefs.Javadoc.this, i);
            this.w = null;
            this.x = false;
        }

        public void a() {
            java.lang.String str = this.w;
            if (str != null) {
                super.processLine(str, 3);
                this.w = null;
            }
        }

        public boolean c() {
            return this.x;
        }

        @Override // org.apache.tools.ant.taskdefs.LogOutputStream
        public void processLine(java.lang.String str, int i) {
            if (str.contains("warning")) {
                this.x = true;
            }
            if (i == 2 && str.startsWith("Generating ")) {
                java.lang.String str2 = this.w;
                if (str2 != null) {
                    super.processLine(str2, 3);
                }
                this.w = str;
                return;
            }
            if (this.w != null) {
                if (str.startsWith("Building ")) {
                    super.processLine(this.w, 3);
                } else {
                    super.processLine(this.w, 2);
                }
                this.w = null;
            }
            super.processLine(str, i);
        }
    }

    public class LinkArgument {
        public java.lang.String a;
        public java.io.File c;
        public java.net.URL d;
        public boolean b = false;
        public boolean e = false;

        public LinkArgument() {
        }

        public java.lang.String getHref() {
            return this.a;
        }

        public java.io.File getPackagelistLoc() {
            return this.c;
        }

        public java.net.URL getPackagelistURL() {
            return this.d;
        }

        public boolean isLinkOffline() {
            return this.b;
        }

        public void setHref(java.lang.String str) {
            this.a = str;
        }

        public void setOffline(boolean z) {
            this.b = z;
        }

        public void setPackagelistLoc(java.io.File file) {
            this.c = file;
        }

        public void setPackagelistURL(java.net.URL url) {
            this.d = url;
        }

        public void setResolveLink(boolean z) {
            this.e = z;
        }

        public boolean shouldResolveLink() {
            return this.e;
        }
    }

    public static class PackageName {
        public java.lang.String a;

        public java.lang.String getName() {
            return this.a;
        }

        public void setName(java.lang.String str) {
            this.a = str.trim();
        }

        public java.lang.String toString() {
            return getName();
        }
    }

    public class ResourceCollectionContainer {
        public final java.util.ArrayList<org.apache.tools.ant.types.ResourceCollection> a = new java.util.ArrayList<>();

        public ResourceCollectionContainer() {
        }

        public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
            this.a.add(resourceCollection);
        }

        public final java.util.Iterator<org.apache.tools.ant.types.ResourceCollection> b() {
            return this.a.iterator();
        }
    }

    public static class SourceFile {
        public java.io.File a;

        public SourceFile() {
        }

        public SourceFile(java.io.File file) {
            this.a = file;
        }

        public java.io.File getFile() {
            return this.a;
        }

        public void setFile(java.io.File file) {
            this.a = file;
        }
    }

    public class TagArgument extends org.apache.tools.ant.types.FileSet {
        public java.lang.String D = null;
        public boolean E = true;
        public java.lang.String F = "a";

        public TagArgument() {
        }

        public java.lang.String getParameter() throws org.apache.tools.ant.BuildException {
            java.lang.String str = this.D;
            if (str != null) {
                if (!str.equals("")) {
                    if (getDescription() != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(this.D);
                        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                        sb.append(this.E ? "" : "X");
                        sb.append(this.F);
                        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                        sb.append(getDescription());
                        return sb.toString();
                    }
                    if (this.E && "a".equals(this.F)) {
                        return this.D;
                    }
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(this.D);
                    sb2.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    sb2.append(this.E ? "" : "X");
                    sb2.append(this.F);
                    return sb2.toString();
                }
            }
            throw new org.apache.tools.ant.BuildException("No name specified for custom tag.");
        }

        public void setEnabled(boolean z) {
            this.E = z;
        }

        public void setName(java.lang.String str) {
            this.D = str;
        }

        public void setScope(java.lang.String str) throws org.apache.tools.ant.BuildException {
            java.lang.String[] strArr;
            java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ENGLISH);
            int length = org.apache.tools.ant.taskdefs.Javadoc.k0.length;
            boolean[] zArr = new boolean[length];
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(lowerCase, ",");
            boolean z = false;
            boolean z2 = false;
            while (stringTokenizer.hasMoreTokens()) {
                java.lang.String trim = stringTokenizer.nextToken().trim();
                if (trim.equals("all")) {
                    if (z2) {
                        getProject().log("Repeated tag scope element: all", 3);
                    }
                    z2 = true;
                } else {
                    int i = 0;
                    while (true) {
                        strArr = org.apache.tools.ant.taskdefs.Javadoc.k0;
                        if (i >= strArr.length || trim.equals(strArr[i])) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i == strArr.length) {
                        throw new org.apache.tools.ant.BuildException("Unrecognised scope element: " + trim);
                    }
                    if (zArr[i]) {
                        getProject().log("Repeated tag scope element: " + trim, 3);
                    }
                    zArr[i] = true;
                    z = true;
                }
            }
            if (z && z2) {
                throw new org.apache.tools.ant.BuildException("Mixture of \"all\" and other scope elements in tag parameter.");
            }
            if (!z && !z2) {
                throw new org.apache.tools.ant.BuildException("No scope elements specified in tag parameter.");
            }
            if (z2) {
                this.F = "a";
                return;
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(length);
            for (int i2 = 0; i2 < length; i2++) {
                if (zArr[i2]) {
                    stringBuffer.append(org.apache.tools.ant.taskdefs.Javadoc.k0[i2].charAt(0));
                }
            }
            this.F = stringBuffer.toString();
        }
    }

    public final void A() throws java.io.IOException {
        if (this.e0) {
            java.io.File file = this.y;
            if (file != null && !file.isDirectory()) {
                log("No javadoc created, no need to post-process anything", 3);
                return;
            }
            java.io.InputStream resourceAsStream = org.apache.tools.ant.taskdefs.Javadoc.class.getResourceAsStream("javadoc-frame-injections-fix.txt");
            if (resourceAsStream == null) {
                throw new java.io.FileNotFoundException("Missing resource 'javadoc-frame-injections-fix.txt' in classpath.");
            }
            try {
                java.lang.String trim = v(org.apache.tools.ant.util.FileUtils.readFully(new java.io.InputStreamReader(resourceAsStream, "US-ASCII"))).trim();
                org.apache.tools.ant.util.FileUtils.close(resourceAsStream);
                org.apache.tools.ant.DirectoryScanner directoryScanner = new org.apache.tools.ant.DirectoryScanner();
                directoryScanner.setBasedir(this.y);
                directoryScanner.setCaseSensitive(false);
                directoryScanner.setIncludes(new java.lang.String[]{"**/index.html", "**/index.htm", "**/toc.html", "**/toc.htm"});
                directoryScanner.addDefaultExcludes();
                directoryScanner.scan();
                int i = 0;
                for (java.lang.String str : directoryScanner.getIncludedFiles()) {
                    i += z(new java.io.File(this.y, str), trim);
                }
                if (i > 0) {
                    log("Patched " + i + " link injection vulnerable javadocs", 2);
                }
            } catch (java.lang.Throwable th) {
                org.apache.tools.ant.util.FileUtils.close(resourceAsStream);
                throw th;
            }
        }
    }

    public final java.lang.String B(java.lang.String str) {
        return (!k(str) && str.indexOf(39) == -1 && str.indexOf(34) == -1) ? str : str.indexOf(39) == -1 ? C(str, '\'') : C(str, kotlin.text.Typography.quote);
    }

    public final java.lang.String C(java.lang.String str, char c) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str.length() * 2);
        stringBuffer.append(c);
        boolean z = false;
        for (char c2 : str.toCharArray()) {
            if (c2 == c) {
                stringBuffer.append('\\');
                stringBuffer.append(c2);
            } else if (c2 != '\n') {
                if (c2 == '\r') {
                    stringBuffer.append("\\\r");
                    z = true;
                } else if (c2 != '\\') {
                    stringBuffer.append(c2);
                } else {
                    stringBuffer.append("\\\\");
                }
            } else if (z) {
                stringBuffer.append("\n");
            } else {
                stringBuffer.append("\\\n");
            }
            z = false;
        }
        stringBuffer.append(c);
        return stringBuffer.toString();
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x009b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:44:0x009b */
    public final void D(org.apache.tools.ant.types.Commandline commandline) {
        java.io.Writer writer;
        java.io.Writer writer2 = null;
        java.io.File file = null;
        try {
            try {
                try {
                    java.io.File createTempFile = j0.createTempFile(getProject(), "javadocOptions", "", null, true, true);
                    try {
                        java.lang.String[] arguments = commandline.getArguments();
                        commandline.clearArgs();
                        commandline.createArgument().setValue("@" + createTempFile.getAbsolutePath());
                        java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(createTempFile.getAbsolutePath(), true));
                        for (java.lang.String str : arguments) {
                            try {
                                if (str.startsWith("-J-")) {
                                    commandline.createArgument().setValue(str);
                                } else if (str.startsWith(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                                    bufferedWriter.write(str);
                                    bufferedWriter.write(" ");
                                } else {
                                    bufferedWriter.write(B(str));
                                    bufferedWriter.newLine();
                                }
                            } catch (java.io.IOException e) {
                                e = e;
                                file = createTempFile;
                                if (file != null) {
                                    file.delete();
                                }
                                throw new org.apache.tools.ant.BuildException("Error creating or writing temporary file for javadoc options", e, getLocation());
                            }
                        }
                        bufferedWriter.close();
                        org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                    } catch (java.io.IOException e2) {
                        e = e2;
                    }
                } catch (java.io.IOException e3) {
                    e = e3;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                org.apache.tools.ant.util.FileUtils.close(writer2);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            writer2 = writer;
        }
    }

    public void addBottom(org.apache.tools.ant.taskdefs.Javadoc.Html html) {
        this.T = html;
    }

    public void addDoctitle(org.apache.tools.ant.taskdefs.Javadoc.Html html) {
        this.Q = html;
    }

    public void addExcludePackage(org.apache.tools.ant.taskdefs.Javadoc.PackageName packageName) {
        this.B.addElement(packageName);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        createSourceFiles().add(fileSet);
    }

    public void addFooter(org.apache.tools.ant.taskdefs.Javadoc.Html html) {
        this.S = html;
    }

    public void addHeader(org.apache.tools.ant.taskdefs.Javadoc.Html html) {
        this.R = html;
    }

    public void addModule(org.apache.tools.ant.taskdefs.Javadoc.PackageName packageName) {
        this.C.add(packageName);
    }

    public void addPackage(org.apache.tools.ant.taskdefs.Javadoc.PackageName packageName) {
        this.A.addElement(packageName);
    }

    public void addPackageset(org.apache.tools.ant.types.DirSet dirSet) {
        this.g0.addElement(dirSet);
    }

    public void addSource(org.apache.tools.ant.taskdefs.Javadoc.SourceFile sourceFile) {
        this.z.addElement(sourceFile);
    }

    public void addTaglet(org.apache.tools.ant.taskdefs.Javadoc.ExtensionInfo extensionInfo) {
        this.O.addElement(extensionInfo);
    }

    public org.apache.tools.ant.types.Commandline.Argument createArg() {
        return this.u.createArgument();
    }

    public org.apache.tools.ant.types.Path createBootclasspath() {
        if (this.H == null) {
            this.H = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.H.createPath();
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.G == null) {
            this.G = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.G.createPath();
    }

    public org.apache.tools.ant.taskdefs.Javadoc.DocletInfo createDoclet() {
        if (this.F == null) {
            this.F = new org.apache.tools.ant.taskdefs.Javadoc.DocletInfo();
        }
        return this.F;
    }

    public org.apache.tools.ant.taskdefs.Javadoc.GroupArgument createGroup() {
        org.apache.tools.ant.taskdefs.Javadoc.GroupArgument groupArgument = new org.apache.tools.ant.taskdefs.Javadoc.GroupArgument();
        this.N.addElement(groupArgument);
        return groupArgument;
    }

    public org.apache.tools.ant.taskdefs.Javadoc.LinkArgument createLink() {
        org.apache.tools.ant.taskdefs.Javadoc.LinkArgument linkArgument = new org.apache.tools.ant.taskdefs.Javadoc.LinkArgument();
        this.M.addElement(linkArgument);
        return linkArgument;
    }

    public org.apache.tools.ant.types.Path createModulePath() {
        if (this.I == null) {
            this.I = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.I.createPath();
    }

    public org.apache.tools.ant.types.Path createModuleSourcePath() {
        if (this.J == null) {
            this.J = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.J.createPath();
    }

    public org.apache.tools.ant.taskdefs.Javadoc.ResourceCollectionContainer createSourceFiles() {
        return this.f0;
    }

    public org.apache.tools.ant.types.Path createSourcepath() {
        if (this.x == null) {
            this.x = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.x.createPath();
    }

    public org.apache.tools.ant.taskdefs.Javadoc.TagArgument createTag() {
        org.apache.tools.ant.taskdefs.Javadoc.TagArgument tagArgument = new org.apache.tools.ant.taskdefs.Javadoc.TagArgument();
        this.O.addElement(tagArgument);
        return tagArgument;
    }

    public final void d(boolean z, java.lang.String str) {
        if (z) {
            this.u.createArgument().setValue(str);
        }
    }

    public final void e(java.lang.String str, java.lang.String str2) {
        if (str2 != null && str2.length() != 0) {
            this.u.createArgument().setValue(str);
            this.u.createArgument().setValue(str2);
            return;
        }
        log("Warning: Leaving out empty argument '" + str + "'", 1);
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x01c9: MOVE (r11 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:86:0x01c9 */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d4 A[Catch: all -> 0x01c8, TRY_ENTER, TryCatch #4 {all -> 0x01c8, blocks: (B:31:0x00e4, B:33:0x00f2, B:72:0x01d4, B:73:0x01d7, B:74:0x01e2), top: B:18:0x008d }] */
    @Override // org.apache.tools.ant.Task
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.FileWriter fileWriter;
        java.io.BufferedWriter bufferedWriter;
        java.io.File file;
        java.io.FileWriter fileWriter2;
        java.io.FileWriter fileWriter3;
        j();
        java.util.Vector<java.lang.String> vector = new java.util.Vector<>();
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(getProject());
        g();
        org.apache.tools.ant.types.Path path2 = this.x;
        if (path2 != null) {
            path.addExisting(path2);
        }
        x(vector, path);
        h(vector, path);
        java.util.Vector<org.apache.tools.ant.taskdefs.Javadoc.SourceFile> vector2 = (java.util.Vector) this.z.clone();
        f(vector2);
        i(vector, vector2);
        log("Generating Javadoc", 2);
        org.apache.tools.ant.types.Commandline commandline = (org.apache.tools.ant.types.Commandline) this.u.clone();
        java.lang.String str = this.a0;
        if (str != null) {
            commandline.setExecutable(str);
        } else {
            commandline.setExecutable(org.apache.tools.ant.util.JavaEnvUtils.getJdkExecutable("javadoc"));
        }
        w(commandline);
        u(commandline, path);
        n(commandline);
        l(commandline);
        r(commandline);
        o(commandline);
        p(commandline);
        m(commandline);
        s(commandline);
        q(commandline);
        if (this.X && (this.F == null || h0)) {
            commandline.createArgument().setValue("-breakiterator");
        }
        if (this.U) {
            D(commandline);
        }
        java.io.FileWriter fileWriter4 = null;
        java.io.File file2 = null;
        try {
            try {
                try {
                    if (this.U) {
                        java.io.File createTempFile = j0.createTempFile(getProject(), "javadoc", "", null, true, true);
                        try {
                            commandline.createArgument().setValue("@" + createTempFile.getAbsolutePath());
                            fileWriter3 = new java.io.FileWriter(createTempFile.getAbsolutePath(), true);
                        } catch (java.io.IOException e) {
                            e = e;
                            file2 = createTempFile;
                        }
                        try {
                            bufferedWriter = new java.io.BufferedWriter(fileWriter3);
                            file = createTempFile;
                            fileWriter2 = fileWriter3;
                        } catch (java.io.IOException e2) {
                            e = e2;
                            file2 = createTempFile;
                            if (file2 != null) {
                            }
                            throw new org.apache.tools.ant.BuildException("Error creating temporary file", e, getLocation());
                        } catch (java.lang.Throwable th) {
                            th = th;
                            fileWriter4 = fileWriter3;
                            org.apache.tools.ant.util.FileUtils.close(fileWriter4);
                            throw th;
                        }
                    } else {
                        bufferedWriter = null;
                        file = null;
                        fileWriter2 = null;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileWriter4 = fileWriter;
                }
            } catch (java.io.IOException e3) {
                e = e3;
            }
            try {
                t(commandline, vector, vector2, this.U, file, bufferedWriter);
                if (this.U) {
                    bufferedWriter.flush();
                }
                org.apache.tools.ant.util.FileUtils.close(fileWriter2);
                if (this.L != null) {
                    commandline.createArgument().setValue("@" + this.L);
                }
                log(commandline.describeCommand(), 3);
                log("Javadoc execution", 2);
                org.apache.tools.ant.taskdefs.Javadoc.JavadocOutputStream javadocOutputStream = new org.apache.tools.ant.taskdefs.Javadoc.JavadocOutputStream(2);
                org.apache.tools.ant.taskdefs.Javadoc.JavadocOutputStream javadocOutputStream2 = new org.apache.tools.ant.taskdefs.Javadoc.JavadocOutputStream(1);
                org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.PumpStreamHandler(javadocOutputStream, javadocOutputStream2));
                execute.setAntRun(getProject());
                execute.setWorkingDirectory(null);
                try {
                    try {
                        execute.setCommandline(commandline.getCommandline());
                        int execute2 = execute.execute();
                        if (execute2 != 0 && this.v) {
                            throw new org.apache.tools.ant.BuildException("Javadoc returned " + execute2, getLocation());
                        }
                        if (javadocOutputStream.c() && this.w) {
                            throw new org.apache.tools.ant.BuildException("Javadoc issued warnings.", getLocation());
                        }
                        A();
                    } catch (java.io.IOException e4) {
                        throw new org.apache.tools.ant.BuildException("Javadoc failed: " + e4, e4, getLocation());
                    }
                } finally {
                    if (file != null) {
                        file.delete();
                    }
                    javadocOutputStream.a();
                    javadocOutputStream2.a();
                    org.apache.tools.ant.util.FileUtils.close(javadocOutputStream);
                    org.apache.tools.ant.util.FileUtils.close(javadocOutputStream2);
                }
            } catch (java.io.IOException e5) {
                e = e5;
                file2 = file;
                if (file2 != null) {
                    file2.delete();
                }
                throw new org.apache.tools.ant.BuildException("Error creating temporary file", e, getLocation());
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    public java.lang.String expand(java.lang.String str) {
        return getProject().replaceProperties(str);
    }

    public final void f(java.util.Vector<org.apache.tools.ant.taskdefs.Javadoc.SourceFile> vector) {
        java.util.Iterator b = this.f0.b();
        while (b.hasNext()) {
            org.apache.tools.ant.types.ResourceCollection resourceCollection = (org.apache.tools.ant.types.ResourceCollection) b.next();
            if (!resourceCollection.isFilesystemOnly()) {
                throw new org.apache.tools.ant.BuildException("only file system based resources are supported by javadoc");
            }
            boolean z = resourceCollection instanceof org.apache.tools.ant.types.FileSet;
            org.apache.tools.ant.types.ResourceCollection resourceCollection2 = resourceCollection;
            if (z) {
                org.apache.tools.ant.types.FileSet fileSet = (org.apache.tools.ant.types.FileSet) resourceCollection;
                resourceCollection2 = resourceCollection;
                if (!fileSet.hasPatterns()) {
                    resourceCollection2 = resourceCollection;
                    if (!fileSet.hasSelectors()) {
                        org.apache.tools.ant.types.FileSet fileSet2 = (org.apache.tools.ant.types.FileSet) fileSet.clone();
                        fileSet2.createInclude().setName("**/*.java");
                        resourceCollection2 = fileSet2;
                        if (this.Z) {
                            fileSet2.createInclude().setName("**/package.html");
                            resourceCollection2 = fileSet2;
                        }
                    }
                }
            }
            java.util.Iterator<org.apache.tools.ant.types.Resource> it = resourceCollection2.iterator();
            while (it.hasNext()) {
                vector.addElement(new org.apache.tools.ant.taskdefs.Javadoc.SourceFile(((org.apache.tools.ant.types.resources.FileProvider) it.next().as(org.apache.tools.ant.types.resources.FileProvider.class)).getFile()));
            }
        }
    }

    public final void g() {
        if (this.L != null && this.x == null) {
            throw new org.apache.tools.ant.BuildException("sourcePath attribute must be set when specifying packagelist.");
        }
    }

    public final void h(java.util.Vector<java.lang.String> vector, org.apache.tools.ant.types.Path path) {
        if (vector.size() != 0 && path.size() == 0) {
            throw new org.apache.tools.ant.BuildException("sourcePath attribute must be set when specifying package names.");
        }
    }

    public final void i(java.util.Vector<java.lang.String> vector, java.util.Vector<org.apache.tools.ant.taskdefs.Javadoc.SourceFile> vector2) {
        if (this.L == null && vector.size() == 0 && vector2.size() == 0 && this.C.isEmpty()) {
            throw new org.apache.tools.ant.BuildException("No source files, no packages and no modules have been specified.");
        }
    }

    public final void j() {
        if ("javadoc2".equals(getTaskType())) {
            log("Warning: the task name <javadoc2> is deprecated. Use <javadoc> instead.", 1);
        }
    }

    public final boolean k(java.lang.String str) {
        for (char c : str.toCharArray()) {
            if (java.lang.Character.isWhitespace(c)) {
                return true;
            }
        }
        return false;
    }

    public final void l(org.apache.tools.ant.types.Commandline commandline) {
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(getProject());
        org.apache.tools.ant.types.Path path2 = this.H;
        if (path2 != null) {
            path.append(path2);
        }
        org.apache.tools.ant.types.Path concatSystemBootClasspath = path.concatSystemBootClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
        if (concatSystemBootClasspath.size() > 0) {
            commandline.createArgument().setValue("-bootclasspath");
            commandline.createArgument().setPath(concatSystemBootClasspath);
        }
    }

    public final void m(org.apache.tools.ant.types.Commandline commandline) {
        if (this.b0) {
            commandline.createArgument().setValue("-docfilessubdirs");
            java.lang.String str = this.c0;
            if (str == null || str.trim().length() <= 0) {
                return;
            }
            commandline.createArgument().setValue("-excludedocfilessubdir");
            commandline.createArgument().setValue(this.c0);
        }
    }

    public final void n(org.apache.tools.ant.types.Commandline commandline) {
        org.apache.tools.ant.taskdefs.Javadoc.DocletInfo docletInfo = this.F;
        if (docletInfo != null) {
            if (docletInfo.getName() == null) {
                throw new org.apache.tools.ant.BuildException("The doclet name must be specified.", getLocation());
            }
            commandline.createArgument().setValue("-doclet");
            commandline.createArgument().setValue(this.F.getName());
            if (this.F.getPath() != null) {
                org.apache.tools.ant.types.Path concatSystemClasspath = this.F.getPath().concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
                if (concatSystemClasspath.size() != 0) {
                    commandline.createArgument().setValue("-docletpath");
                    commandline.createArgument().setPath(concatSystemClasspath);
                }
            }
            java.util.Iterator it = java.util.Collections.list(this.F.getParams()).iterator();
            while (it.hasNext()) {
                org.apache.tools.ant.taskdefs.Javadoc.DocletParam docletParam = (org.apache.tools.ant.taskdefs.Javadoc.DocletParam) it.next();
                if (docletParam.getName() == null) {
                    throw new org.apache.tools.ant.BuildException("Doclet parameters must have a name");
                }
                commandline.createArgument().setValue(docletParam.getName());
                if (docletParam.getValue() != null) {
                    commandline.createArgument().setValue(docletParam.getValue());
                }
            }
        }
    }

    public final void o(org.apache.tools.ant.types.Commandline commandline) {
        if (this.K != null) {
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(this.K, ",", false);
            while (stringTokenizer.hasMoreTokens()) {
                java.lang.String trim = stringTokenizer.nextToken().trim();
                int indexOf = trim.indexOf(" ");
                if (indexOf > 0) {
                    java.lang.String substring = trim.substring(0, indexOf);
                    java.lang.String substring2 = trim.substring(indexOf + 1);
                    commandline.createArgument().setValue("-group");
                    commandline.createArgument().setValue(substring);
                    commandline.createArgument().setValue(substring2);
                }
            }
        }
    }

    public final void p(org.apache.tools.ant.types.Commandline commandline) {
        if (this.N.size() != 0) {
            java.util.Enumeration<org.apache.tools.ant.taskdefs.Javadoc.GroupArgument> elements = this.N.elements();
            while (elements.hasMoreElements()) {
                org.apache.tools.ant.taskdefs.Javadoc.GroupArgument nextElement = elements.nextElement();
                java.lang.String title = nextElement.getTitle();
                java.lang.String packages = nextElement.getPackages();
                if (title == null || packages == null) {
                    throw new org.apache.tools.ant.BuildException("The title and packages must be specified for group elements.");
                }
                commandline.createArgument().setValue("-group");
                commandline.createArgument().setValue(expand(title));
                commandline.createArgument().setValue(packages);
            }
        }
    }

    public final void q(org.apache.tools.ant.types.Commandline commandline) {
        java.util.Enumeration<java.lang.Object> elements = this.O.elements();
        while (elements.hasMoreElements()) {
            java.lang.Object nextElement = elements.nextElement();
            if (nextElement instanceof org.apache.tools.ant.taskdefs.Javadoc.TagArgument) {
                org.apache.tools.ant.taskdefs.Javadoc.TagArgument tagArgument = (org.apache.tools.ant.taskdefs.Javadoc.TagArgument) nextElement;
                java.io.File dir = tagArgument.getDir(getProject());
                if (dir == null) {
                    commandline.createArgument().setValue("-tag");
                    commandline.createArgument().setValue(tagArgument.getParameter());
                } else {
                    for (java.lang.String str : tagArgument.getDirectoryScanner(getProject()).getIncludedFiles()) {
                        java.io.File file = new java.io.File(dir, str);
                        try {
                            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file));
                            while (true) {
                                java.lang.String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                commandline.createArgument().setValue("-tag");
                                commandline.createArgument().setValue(readLine);
                            }
                            bufferedReader.close();
                        } catch (java.io.IOException e) {
                            throw new org.apache.tools.ant.BuildException("Couldn't read  tag file from " + file.getAbsolutePath(), e);
                        }
                    }
                }
            } else {
                org.apache.tools.ant.taskdefs.Javadoc.ExtensionInfo extensionInfo = (org.apache.tools.ant.taskdefs.Javadoc.ExtensionInfo) nextElement;
                commandline.createArgument().setValue("-taglet");
                commandline.createArgument().setValue(extensionInfo.getName());
                if (extensionInfo.getPath() != null) {
                    org.apache.tools.ant.types.Path concatSystemClasspath = extensionInfo.getPath().concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
                    if (concatSystemClasspath.size() != 0) {
                        commandline.createArgument().setValue("-tagletpath");
                        commandline.createArgument().setPath(concatSystemClasspath);
                    }
                }
            }
        }
        java.lang.String str2 = this.V;
        if (str2 == null) {
            str2 = getProject().getProperty(org.apache.tools.ant.MagicNames.BUILD_JAVAC_SOURCE);
        }
        if (str2 != null) {
            commandline.createArgument().setValue("-source");
            commandline.createArgument().setValue(str2);
        }
        if (this.W && this.F == null) {
            commandline.createArgument().setValue("-linksource");
        }
        if (this.Y == null || this.F != null) {
            return;
        }
        commandline.createArgument().setValue("-noqualifier");
        commandline.createArgument().setValue(this.Y);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(org.apache.tools.ant.types.Commandline commandline) {
        java.lang.String str;
        if (this.M.size() != 0) {
            java.util.Enumeration<org.apache.tools.ant.taskdefs.Javadoc.LinkArgument> elements = this.M.elements();
            while (elements.hasMoreElements()) {
                org.apache.tools.ant.taskdefs.Javadoc.LinkArgument nextElement = elements.nextElement();
                if (nextElement.getHref() == null || nextElement.getHref().length() == 0) {
                    log("No href was given for the link - skipping", 3);
                } else {
                    if (nextElement.shouldResolveLink()) {
                        java.io.File resolveFile = getProject().resolveFile(nextElement.getHref());
                        if (resolveFile.exists()) {
                            try {
                                str = j0.getFileURL(resolveFile).toExternalForm();
                            } catch (java.net.MalformedURLException unused) {
                                log("Warning: link location was invalid " + resolveFile, 1);
                            }
                            if (str != null) {
                                try {
                                    new java.net.URL(new java.net.URL("file://."), nextElement.getHref());
                                    str = nextElement.getHref();
                                } catch (java.net.MalformedURLException unused2) {
                                    log("Link href \"" + nextElement.getHref() + "\" is not a valid url - skipping link", 1);
                                }
                            }
                            if (nextElement.isLinkOffline()) {
                                commandline.createArgument().setValue("-link");
                                commandline.createArgument().setValue(str);
                            } else {
                                java.io.File packagelistLoc = nextElement.getPackagelistLoc();
                                java.net.URL packagelistURL = nextElement.getPackagelistURL();
                                if (packagelistLoc == null && packagelistURL == null) {
                                    throw new org.apache.tools.ant.BuildException("The package list location for link " + nextElement.getHref() + " must be provided because the link is offline");
                                }
                                if (packagelistLoc != null) {
                                    if (new java.io.File(packagelistLoc, "package-list").exists()) {
                                        try {
                                            packagelistURL = j0.getFileURL(packagelistLoc);
                                        } catch (java.net.MalformedURLException unused3) {
                                            log("Warning: Package list location was invalid " + packagelistLoc, 1);
                                        }
                                    } else {
                                        log("Warning: No package list was found at " + packagelistLoc, 3);
                                    }
                                }
                                if (packagelistURL != null) {
                                    commandline.createArgument().setValue("-linkoffline");
                                    commandline.createArgument().setValue(str);
                                    commandline.createArgument().setValue(packagelistURL.toExternalForm());
                                }
                            }
                        }
                    }
                    str = null;
                    if (str != null) {
                    }
                    if (nextElement.isLinkOffline()) {
                    }
                }
            }
        }
    }

    public final void s(org.apache.tools.ant.types.Commandline commandline) {
        if (!this.C.isEmpty()) {
            java.lang.StringBuilder sb = null;
            for (org.apache.tools.ant.taskdefs.Javadoc.PackageName packageName : this.C) {
                if (sb == null) {
                    sb = new java.lang.StringBuilder(packageName.getName());
                } else {
                    sb.append(",");
                    sb.append(packageName.getName());
                }
            }
            commandline.createArgument().setValue("--module");
            commandline.createArgument().setValue(sb.toString());
        }
        if (this.I != null) {
            commandline.createArgument().setValue("--module-path");
            commandline.createArgument().setPath(this.I);
        }
        if (this.J != null) {
            commandline.createArgument().setValue("--module-source-path");
            commandline.createArgument().setPath(this.J);
        }
    }

    public void setAccess(org.apache.tools.ant.taskdefs.Javadoc.AccessType accessType) {
        this.u.createArgument().setValue(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + accessType.getValue());
    }

    public void setAdditionalparam(java.lang.String str) {
        this.u.createArgument().setLine(str);
    }

    public void setAuthor(boolean z) {
        this.D = z;
    }

    public void setBootClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createBootclasspath().setRefid(reference);
    }

    public void setBootclasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.H;
        if (path2 == null) {
            this.H = path;
        } else {
            path2.append(path);
        }
    }

    public void setBottom(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Javadoc.Html html = new org.apache.tools.ant.taskdefs.Javadoc.Html();
        html.addText(str);
        addBottom(html);
    }

    public void setBreakiterator(boolean z) {
        this.X = z;
    }

    public void setCharset(java.lang.String str) {
        e("-charset", str);
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.G;
        if (path2 == null) {
            this.G = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setDefaultexcludes(boolean z) {
        this.P = z;
    }

    public void setDestdir(java.io.File file) {
        this.y = file;
        this.u.createArgument().setValue("-d");
        this.u.createArgument().setFile(this.y);
    }

    public void setDocFilesSubDirs(boolean z) {
        this.b0 = z;
    }

    public void setDocencoding(java.lang.String str) {
        this.u.createArgument().setValue("-docencoding");
        this.u.createArgument().setValue(str);
        this.d0 = str;
    }

    public void setDoclet(java.lang.String str) {
        if (this.F == null) {
            org.apache.tools.ant.taskdefs.Javadoc.DocletInfo docletInfo = new org.apache.tools.ant.taskdefs.Javadoc.DocletInfo();
            this.F = docletInfo;
            docletInfo.setProject(getProject());
        }
        this.F.setName(str);
    }

    public void setDocletPath(org.apache.tools.ant.types.Path path) {
        if (this.F == null) {
            org.apache.tools.ant.taskdefs.Javadoc.DocletInfo docletInfo = new org.apache.tools.ant.taskdefs.Javadoc.DocletInfo();
            this.F = docletInfo;
            docletInfo.setProject(getProject());
        }
        this.F.setPath(path);
    }

    public void setDocletPathRef(org.apache.tools.ant.types.Reference reference) {
        if (this.F == null) {
            org.apache.tools.ant.taskdefs.Javadoc.DocletInfo docletInfo = new org.apache.tools.ant.taskdefs.Javadoc.DocletInfo();
            this.F = docletInfo;
            docletInfo.setProject(getProject());
        }
        this.F.createPath().setRefid(reference);
    }

    public void setDoctitle(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Javadoc.Html html = new org.apache.tools.ant.taskdefs.Javadoc.Html();
        html.addText(str);
        addDoctitle(html);
    }

    public void setEncoding(java.lang.String str) {
        this.u.createArgument().setValue("-encoding");
        this.u.createArgument().setValue(str);
    }

    public void setExcludeDocFilesSubDir(java.lang.String str) {
        this.c0 = str;
    }

    public void setExcludePackageNames(java.lang.String str) {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            java.lang.String nextToken = stringTokenizer.nextToken();
            org.apache.tools.ant.taskdefs.Javadoc.PackageName packageName = new org.apache.tools.ant.taskdefs.Javadoc.PackageName();
            packageName.setName(nextToken);
            addExcludePackage(packageName);
        }
    }

    public void setExecutable(java.lang.String str) {
        this.a0 = str;
    }

    @java.lang.Deprecated
    public void setExtdirs(java.lang.String str) {
        this.u.createArgument().setValue("-extdirs");
        this.u.createArgument().setValue(str);
    }

    public void setExtdirs(org.apache.tools.ant.types.Path path) {
        this.u.createArgument().setValue("-extdirs");
        this.u.createArgument().setPath(path);
    }

    public void setFailonerror(boolean z) {
        this.v = z;
    }

    public void setFailonwarning(boolean z) {
        this.w = z;
    }

    public void setFooter(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Javadoc.Html html = new org.apache.tools.ant.taskdefs.Javadoc.Html();
        html.addText(str);
        addFooter(html);
    }

    public void setGroup(java.lang.String str) {
        this.K = str;
    }

    public void setHeader(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Javadoc.Html html = new org.apache.tools.ant.taskdefs.Javadoc.Html();
        html.addText(str);
        addHeader(html);
    }

    public void setHelpfile(java.io.File file) {
        this.u.createArgument().setValue("-helpfile");
        this.u.createArgument().setFile(file);
    }

    public void setIncludeNoSourcePackages(boolean z) {
        this.Z = z;
    }

    public void setLink(java.lang.String str) {
        createLink().setHref(str);
    }

    public void setLinkoffline(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Javadoc.LinkArgument createLink = createLink();
        createLink.setOffline(true);
        if (str.trim().length() == 0) {
            throw new org.apache.tools.ant.BuildException("The linkoffline attribute must include a URL and a package-list file location separated by a space");
        }
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, " ", false);
        createLink.setHref(stringTokenizer.nextToken());
        if (!stringTokenizer.hasMoreTokens()) {
            throw new org.apache.tools.ant.BuildException("The linkoffline attribute must include a URL and a package-list file location separated by a space");
        }
        createLink.setPackagelistLoc(getProject().resolveFile(stringTokenizer.nextToken()));
    }

    public void setLinksource(boolean z) {
        this.W = z;
    }

    public void setLocale(java.lang.String str) {
        this.u.createArgument(true).setValue(str);
        this.u.createArgument(true).setValue("-locale");
    }

    public void setMaxmemory(java.lang.String str) {
        this.u.createArgument().setValue("-J-Xmx" + str);
    }

    public void setModulePath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.I;
        if (path2 == null) {
            this.I = path;
        } else {
            path2.append(path);
        }
    }

    public void setModulePathref(org.apache.tools.ant.types.Reference reference) {
        createModulePath().setRefid(reference);
    }

    public void setModuleSourcePath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.J;
        if (path2 == null) {
            this.J = path;
        } else {
            path2.append(path);
        }
    }

    public void setModuleSourcePathref(org.apache.tools.ant.types.Reference reference) {
        createModuleSourcePath().setRefid(reference);
    }

    public void setModulenames(java.lang.String str) {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            java.lang.String nextToken = stringTokenizer.nextToken();
            org.apache.tools.ant.taskdefs.Javadoc.PackageName packageName = new org.apache.tools.ant.taskdefs.Javadoc.PackageName();
            packageName.setName(nextToken);
            addModule(packageName);
        }
    }

    public void setNodeprecated(boolean z) {
        d(z, "-nodeprecated");
    }

    public void setNodeprecatedlist(boolean z) {
        d(z, "-nodeprecatedlist");
    }

    public void setNohelp(boolean z) {
        d(z, "-nohelp");
    }

    public void setNoindex(boolean z) {
        d(z, "-noindex");
    }

    public void setNonavbar(boolean z) {
        d(z, "-nonavbar");
    }

    public void setNoqualifier(java.lang.String str) {
        this.Y = str;
    }

    public void setNotree(boolean z) {
        d(z, "-notree");
    }

    public void setOld(boolean z) {
        log("Javadoc 1.4 doesn't support the -1.1 switch anymore", 1);
    }

    public void setOverview(java.io.File file) {
        this.u.createArgument().setValue("-overview");
        this.u.createArgument().setFile(file);
    }

    public void setPackage(boolean z) {
        d(z, "-package");
    }

    public void setPackageList(java.lang.String str) {
        this.L = str;
    }

    public void setPackagenames(java.lang.String str) {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            java.lang.String nextToken = stringTokenizer.nextToken();
            org.apache.tools.ant.taskdefs.Javadoc.PackageName packageName = new org.apache.tools.ant.taskdefs.Javadoc.PackageName();
            packageName.setName(nextToken);
            addPackage(packageName);
        }
    }

    public void setPostProcessGeneratedJavadocs(boolean z) {
        this.e0 = z;
    }

    public void setPrivate(boolean z) {
        d(z, "-private");
    }

    public void setProtected(boolean z) {
        d(z, "-protected");
    }

    public void setPublic(boolean z) {
        d(z, "-public");
    }

    public void setSerialwarn(boolean z) {
        d(z, "-serialwarn");
    }

    public void setSource(java.lang.String str) {
        this.V = str;
    }

    public void setSourcefiles(java.lang.String str) {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            java.lang.String nextToken = stringTokenizer.nextToken();
            org.apache.tools.ant.taskdefs.Javadoc.SourceFile sourceFile = new org.apache.tools.ant.taskdefs.Javadoc.SourceFile();
            sourceFile.setFile(getProject().resolveFile(nextToken.trim()));
            addSource(sourceFile);
        }
    }

    public void setSourcepath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.x;
        if (path2 == null) {
            this.x = path;
        } else {
            path2.append(path);
        }
    }

    public void setSourcepathRef(org.apache.tools.ant.types.Reference reference) {
        createSourcepath().setRefid(reference);
    }

    public void setSplitindex(boolean z) {
        d(z, "-splitindex");
    }

    public void setStylesheetfile(java.io.File file) {
        this.u.createArgument().setValue("-stylesheetfile");
        this.u.createArgument().setFile(file);
    }

    public void setUse(boolean z) {
        d(z, "-use");
    }

    public void setUseExternalFile(boolean z) {
        this.U = z;
    }

    public void setVerbose(boolean z) {
        d(z, org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_VERBOSE);
    }

    public void setVersion(boolean z) {
        this.E = z;
    }

    public void setWindowtitle(java.lang.String str) {
        e("-windowtitle", str);
    }

    public final void t(org.apache.tools.ant.types.Commandline commandline, java.util.Vector<java.lang.String> vector, java.util.Vector<org.apache.tools.ant.taskdefs.Javadoc.SourceFile> vector2, boolean z, java.io.File file, java.io.BufferedWriter bufferedWriter) throws java.io.IOException {
        java.util.Iterator<java.lang.String> it = vector.iterator();
        while (it.hasNext()) {
            java.lang.String next = it.next();
            if (z) {
                bufferedWriter.write(next);
                bufferedWriter.newLine();
            } else {
                commandline.createArgument().setValue(next);
            }
        }
        java.util.Iterator<org.apache.tools.ant.taskdefs.Javadoc.SourceFile> it2 = vector2.iterator();
        while (it2.hasNext()) {
            java.lang.String absolutePath = it2.next().getFile().getAbsolutePath();
            if (z) {
                if (absolutePath.contains(" ")) {
                    char c = java.io.File.separatorChar;
                    if (c == '\\') {
                        absolutePath = absolutePath.replace(c, '/');
                    }
                    bufferedWriter.write("\"" + absolutePath + "\"");
                } else {
                    bufferedWriter.write(absolutePath);
                }
                bufferedWriter.newLine();
            } else {
                commandline.createArgument().setValue(absolutePath);
            }
        }
    }

    public final void u(org.apache.tools.ant.types.Commandline commandline, org.apache.tools.ant.types.Path path) {
        if (path.size() > 0) {
            commandline.createArgument().setValue("-sourcepath");
            commandline.createArgument().setPath(path);
        }
    }

    public final java.lang.String v(java.lang.String str) {
        return str.replace("\r\n", "\n").replace("\n", org.apache.tools.ant.util.StringUtils.LINE_SEP);
    }

    public final void w(org.apache.tools.ant.types.Commandline commandline) {
        if (this.Q != null) {
            commandline.createArgument().setValue("-doctitle");
            commandline.createArgument().setValue(expand(this.Q.getText()));
        }
        if (this.R != null) {
            commandline.createArgument().setValue("-header");
            commandline.createArgument().setValue(expand(this.R.getText()));
        }
        if (this.S != null) {
            commandline.createArgument().setValue("-footer");
            commandline.createArgument().setValue(expand(this.S.getText()));
        }
        if (this.T != null) {
            commandline.createArgument().setValue("-bottom");
            commandline.createArgument().setValue(expand(this.T.getText()));
        }
        org.apache.tools.ant.types.Path path = this.G;
        if (path == null) {
            this.G = new org.apache.tools.ant.types.Path(getProject()).concatSystemClasspath("last");
        } else {
            this.G = path.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
        }
        if (this.G.size() > 0) {
            commandline.createArgument().setValue("-classpath");
            commandline.createArgument().setPath(this.G);
        }
        if (this.E && this.F == null) {
            commandline.createArgument().setValue("-version");
        }
        if (this.D && this.F == null) {
            commandline.createArgument().setValue("-author");
        }
        if (this.F == null && this.y == null) {
            throw new org.apache.tools.ant.BuildException("destdir attribute must be set!");
        }
    }

    public final void x(java.util.Vector<java.lang.String> vector, org.apache.tools.ant.types.Path path) {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Vector vector2 = (java.util.Vector) this.g0.clone();
        if (this.x != null) {
            org.apache.tools.ant.types.PatternSet patternSet = new org.apache.tools.ant.types.PatternSet();
            patternSet.setProject(getProject());
            if (this.A.size() > 0) {
                java.util.Enumeration<org.apache.tools.ant.taskdefs.Javadoc.PackageName> elements = this.A.elements();
                while (elements.hasMoreElements()) {
                    java.lang.String replace = elements.nextElement().getName().replace('.', '/');
                    if (replace.endsWith("*")) {
                        replace = replace + "*";
                    }
                    patternSet.createInclude().setName(replace);
                }
            } else {
                patternSet.createInclude().setName(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH);
            }
            java.util.Enumeration<org.apache.tools.ant.taskdefs.Javadoc.PackageName> elements2 = this.B.elements();
            while (elements2.hasMoreElements()) {
                java.lang.String replace2 = elements2.nextElement().getName().replace('.', '/');
                if (replace2.endsWith("*")) {
                    replace2 = replace2 + "*";
                }
                patternSet.createExclude().setName(replace2);
            }
            java.lang.String[] list = this.x.list();
            for (int i = 0; i < list.length; i++) {
                java.io.File file = new java.io.File(list[i]);
                if (file.isDirectory()) {
                    org.apache.tools.ant.types.DirSet dirSet = new org.apache.tools.ant.types.DirSet();
                    dirSet.setProject(getProject());
                    dirSet.setDefaultexcludes(this.P);
                    dirSet.setDir(file);
                    dirSet.createPatternSet().addConfiguredPatternset(patternSet);
                    vector2.addElement(dirSet);
                } else {
                    log("Skipping " + list[i] + " since it is no directory.", 1);
                }
            }
        }
        java.util.Enumeration elements3 = vector2.elements();
        while (elements3.hasMoreElements()) {
            org.apache.tools.ant.types.DirSet dirSet2 = (org.apache.tools.ant.types.DirSet) elements3.nextElement();
            java.io.File dir = dirSet2.getDir(getProject());
            log("scanning " + dir + " for packages.", 4);
            boolean z = false;
            for (java.lang.String str : dirSet2.getDirectoryScanner(getProject()).getIncludedDirectories()) {
                if (new java.io.File(dir, str).list(new org.apache.tools.ant.taskdefs.Javadoc.AnonymousClass1()).length > 0) {
                    if ("".equals(str)) {
                        log(dir + " contains source files in the default package, you must specify them as source files not packages.", 1);
                    } else {
                        java.lang.String replace3 = str.replace(java.io.File.separatorChar, '.');
                        if (!hashSet.contains(replace3)) {
                            hashSet.add(replace3);
                            vector.addElement(replace3);
                        }
                        z = true;
                    }
                }
            }
            if (z) {
                path.createPathElement().setLocation(dir);
            } else {
                log(dir + " doesn't contain any packages, dropping it.", 3);
            }
        }
    }

    public final java.lang.String y(java.lang.String str, java.lang.String str2) {
        int indexOf = str.indexOf("function loadFrames() {");
        if (indexOf < 0) {
            return str;
        }
        return str.substring(0, indexOf) + str2 + str.substring(indexOf + i0);
    }

    public final int z(java.io.File file, java.lang.String str) throws java.io.IOException {
        java.lang.String str2 = this.d0;
        if (str2 == null) {
            str2 = j0.getDefaultEncoding();
        }
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        try {
            java.lang.String v = v(org.apache.tools.ant.util.FileUtils.safeReadFully(new java.io.InputStreamReader(fileInputStream, str2)));
            org.apache.tools.ant.util.FileUtils.close(fileInputStream);
            if (v.contains("function validURL(url) {")) {
                return 0;
            }
            java.lang.String y = y(v, str);
            if (y.equals(v)) {
                return 0;
            }
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            try {
                java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(fileOutputStream, str2);
                outputStreamWriter.write(y);
                outputStreamWriter.close();
                org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                return 1;
            } catch (java.lang.Throwable th) {
                org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            org.apache.tools.ant.util.FileUtils.close(fileInputStream);
            throw th2;
        }
    }
}
