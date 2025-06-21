package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class Path extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.ResourceCollection {
    public java.lang.Boolean n;
    public org.apache.tools.ant.types.resources.Union t;
    public boolean u;
    public static org.apache.tools.ant.types.Path systemClasspath = new org.apache.tools.ant.types.Path(null, java.lang.System.getProperty("java.class.path"));
    public static final org.apache.tools.ant.types.Path systemBootClasspath = new org.apache.tools.ant.types.Path(null, java.lang.System.getProperty("sun.boot.class.path"));

    public class PathElement implements org.apache.tools.ant.types.ResourceCollection {
        public java.lang.String[] n;

        public PathElement() {
        }

        public java.lang.String[] getParts() {
            return this.n;
        }

        @Override // org.apache.tools.ant.types.ResourceCollection
        public boolean isFilesystemOnly() {
            return true;
        }

        @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
        public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
            return new org.apache.tools.ant.types.resources.FileResourceIterator(org.apache.tools.ant.types.Path.this.getProject(), null, this.n);
        }

        public void setLocation(java.io.File file) {
            this.n = new java.lang.String[]{org.apache.tools.ant.types.Path.translateFile(file.getAbsolutePath())};
        }

        public void setPath(java.lang.String str) {
            this.n = org.apache.tools.ant.types.Path.translatePath(org.apache.tools.ant.types.Path.this.getProject(), str);
        }

        @Override // org.apache.tools.ant.types.ResourceCollection
        public int size() {
            java.lang.String[] strArr = this.n;
            if (strArr == null) {
                return 0;
            }
            return strArr.length;
        }
    }

    public Path(org.apache.tools.ant.Project project) {
        this.t = null;
        this.u = false;
        setProject(project);
    }

    public Path(org.apache.tools.ant.Project project, java.lang.String str) {
        this(project);
        createPathElement().setPath(str);
    }

    public static boolean c(java.lang.String str) {
        return str != null && (str.contains("*") || str.contains("?"));
    }

    public static java.io.File e(org.apache.tools.ant.Project project, java.lang.String str) {
        return org.apache.tools.ant.util.FileUtils.getFileUtils().resolveFile(project == null ? null : project.getBaseDir(), str);
    }

    public static java.lang.String translateFile(java.lang.String str) {
        if (str == null) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str);
        for (int i = 0; i < stringBuffer.length(); i++) {
            translateFileSep(stringBuffer, i);
        }
        return stringBuffer.toString();
    }

    public static boolean translateFileSep(java.lang.StringBuffer stringBuffer, int i) {
        if (stringBuffer.charAt(i) != '/' && stringBuffer.charAt(i) != '\\') {
            return false;
        }
        stringBuffer.setCharAt(i, java.io.File.separatorChar);
        return true;
    }

    public static java.lang.String[] translatePath(org.apache.tools.ant.Project project, java.lang.String str) {
        java.util.Vector vector = new java.util.Vector();
        if (str == null) {
            return new java.lang.String[0];
        }
        org.apache.tools.ant.PathTokenizer pathTokenizer = new org.apache.tools.ant.PathTokenizer(str);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (pathTokenizer.hasMoreTokens()) {
            java.lang.String nextToken = pathTokenizer.nextToken();
            try {
                stringBuffer.append(e(project, nextToken).getPath());
            } catch (org.apache.tools.ant.BuildException unused) {
                project.log("Dropping path element " + nextToken + " as it is not valid relative to the project", 3);
            }
            for (int i = 0; i < stringBuffer.length(); i++) {
                translateFileSep(stringBuffer, i);
            }
            vector.addElement(stringBuffer.toString());
            stringBuffer = new java.lang.StringBuffer();
        }
        return (java.lang.String[]) vector.toArray(new java.lang.String[vector.size()]);
    }

    public void add(org.apache.tools.ant.types.Path path) throws org.apache.tools.ant.BuildException {
        if (path == this) {
            throw circularReference();
        }
        if (path.getProject() == null) {
            path.setProject(getProject());
        }
        add((org.apache.tools.ant.types.ResourceCollection) path);
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        checkChildrenAllowed();
        if (resourceCollection == null) {
            return;
        }
        if (this.t == null) {
            org.apache.tools.ant.types.resources.Union union = new org.apache.tools.ant.types.resources.Union();
            this.t = union;
            union.setProject(getProject());
            this.t.setCache(this.u);
        }
        this.t.add(resourceCollection);
        setChecked(false);
    }

    public void addDirset(org.apache.tools.ant.types.DirSet dirSet) throws org.apache.tools.ant.BuildException {
        if (dirSet.getProject() == null) {
            dirSet.setProject(getProject());
        }
        add(dirSet);
    }

    public void addExisting(org.apache.tools.ant.types.Path path) {
        addExisting(path, false);
    }

    public void addExisting(org.apache.tools.ant.types.Path path, boolean z) {
        java.io.File file = z ? new java.io.File(java.lang.System.getProperty("user.dir")) : null;
        for (java.lang.String str : path.list()) {
            java.io.File e = e(getProject(), str);
            if (z && !e.exists()) {
                e = new java.io.File(file, str);
            }
            if (e.exists()) {
                setLocation(e);
            } else if (e.getParentFile() != null && e.getParentFile().exists() && c(e.getName())) {
                setLocation(e);
                log("adding " + e + " which contains wildcards and may not do what you intend it to do depending on your OS or version of Java", 3);
            } else {
                log("dropping " + e + " from path as it doesn't exist", 3);
            }
        }
    }

    public void addExtdirs(org.apache.tools.ant.types.Path path) {
        if (path == null) {
            java.lang.String property = java.lang.System.getProperty("java.ext.dirs");
            if (property == null) {
                return;
            } else {
                path = new org.apache.tools.ant.types.Path(getProject(), property);
            }
        }
        for (java.lang.String str : path.list()) {
            java.io.File e = e(getProject(), str);
            if (e.exists() && e.isDirectory()) {
                org.apache.tools.ant.types.FileSet fileSet = new org.apache.tools.ant.types.FileSet();
                fileSet.setDir(e);
                fileSet.setIncludes("*");
                addFileset(fileSet);
            }
        }
    }

    public void addFilelist(org.apache.tools.ant.types.FileList fileList) throws org.apache.tools.ant.BuildException {
        if (fileList.getProject() == null) {
            fileList.setProject(getProject());
        }
        add(fileList);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) throws org.apache.tools.ant.BuildException {
        if (fileSet.getProject() == null) {
            fileSet.setProject(getProject());
        }
        add(fileSet);
    }

    public void addJavaRuntime() {
        if (org.apache.tools.ant.util.JavaEnvUtils.isKaffe()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.getProperty("java.home"));
            java.lang.String str = java.io.File.separator;
            sb.append(str);
            sb.append("share");
            sb.append(str);
            sb.append("kaffe");
            java.io.File file = new java.io.File(sb.toString());
            if (file.isDirectory()) {
                org.apache.tools.ant.types.FileSet fileSet = new org.apache.tools.ant.types.FileSet();
                fileSet.setDir(file);
                fileSet.setIncludes("*.jar");
                addFileset(fileSet);
            }
        } else if ("GNU libgcj".equals(java.lang.System.getProperty("java.vm.name"))) {
            addExisting(systemBootClasspath);
        }
        if (java.lang.System.getProperty("java.vendor").toLowerCase(java.util.Locale.ENGLISH).contains("microsoft")) {
            org.apache.tools.ant.types.FileSet fileSet2 = new org.apache.tools.ant.types.FileSet();
            fileSet2.setDir(new java.io.File(java.lang.System.getProperty("java.home") + java.io.File.separator + "Packages"));
            fileSet2.setIncludes("*.ZIP");
            addFileset(fileSet2);
            return;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(java.lang.System.getProperty("java.home"));
        java.lang.String str2 = java.io.File.separator;
        sb2.append(str2);
        sb2.append("lib");
        sb2.append(str2);
        sb2.append("rt.jar");
        addExisting(new org.apache.tools.ant.types.Path(null, sb2.toString()));
        addExisting(new org.apache.tools.ant.types.Path(null, java.lang.System.getProperty("java.home") + str2 + "jre" + str2 + "lib" + str2 + "rt.jar"));
        for (java.lang.String str3 : java.util.Arrays.asList("jce", "jsse")) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(java.lang.System.getProperty("java.home"));
            java.lang.String str4 = java.io.File.separator;
            sb3.append(str4);
            sb3.append("lib");
            sb3.append(str4);
            sb3.append(str3);
            sb3.append(".jar");
            addExisting(new org.apache.tools.ant.types.Path(null, sb3.toString()));
            addExisting(new org.apache.tools.ant.types.Path(null, java.lang.System.getProperty("java.home") + str4 + ".." + str4 + "Classes" + str4 + str3 + ".jar"));
        }
        for (java.lang.String str5 : java.util.Arrays.asList("core", "graphics", "security", "server", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML)) {
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append(java.lang.System.getProperty("java.home"));
            java.lang.String str6 = java.io.File.separator;
            sb4.append(str6);
            sb4.append("lib");
            sb4.append(str6);
            sb4.append(str5);
            sb4.append(".jar");
            addExisting(new org.apache.tools.ant.types.Path(null, sb4.toString()));
        }
        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
        sb5.append(java.lang.System.getProperty("java.home"));
        java.lang.String str7 = java.io.File.separator;
        sb5.append(str7);
        sb5.append("..");
        sb5.append(str7);
        sb5.append("Classes");
        sb5.append(str7);
        sb5.append("classes.jar");
        addExisting(new org.apache.tools.ant.types.Path(null, sb5.toString()));
        addExisting(new org.apache.tools.ant.types.Path(null, java.lang.System.getProperty("java.home") + str7 + ".." + str7 + "Classes" + str7 + "ui.jar"));
    }

    public void append(org.apache.tools.ant.types.Path path) {
        if (path == null) {
            return;
        }
        add(path);
    }

    public org.apache.tools.ant.types.ResourceCollection assertFilesystemOnly(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (resourceCollection == null || resourceCollection.isFilesystemOnly()) {
            return resourceCollection;
        }
        throw new org.apache.tools.ant.BuildException(getDataTypeName() + " allows only filesystem resources.");
    }

    public final org.apache.tools.ant.types.Path b(java.lang.String str, org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = new org.apache.tools.ant.types.Path(getProject());
        java.lang.String property = getProject() != null ? getProject().getProperty(org.apache.tools.ant.MagicNames.BUILD_SYSCLASSPATH) : java.lang.System.getProperty(org.apache.tools.ant.MagicNames.BUILD_SYSCLASSPATH);
        if (property != null) {
            str = property;
        }
        if (str.equals(com.tencent.open.SocialConstants.PARAM_ONLY)) {
            path2.addExisting(path, true);
        } else if (str.equals("first")) {
            path2.addExisting(path, true);
            path2.addExisting(this);
        } else if (str.equals(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE)) {
            path2.addExisting(this);
        } else {
            if (!str.equals("last")) {
                log("invalid value for build.sysclasspath: " + str, 1);
            }
            path2.addExisting(this);
            path2.addExisting(path, true);
        }
        return path2;
    }

    @Override // org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        try {
            org.apache.tools.ant.types.Path path = (org.apache.tools.ant.types.Path) super.clone();
            org.apache.tools.ant.types.resources.Union union = this.t;
            if (union != null) {
                union = (org.apache.tools.ant.types.resources.Union) union.clone();
            }
            path.t = union;
            return path;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public org.apache.tools.ant.types.Path concatSystemBootClasspath(java.lang.String str) {
        return b(str, systemBootClasspath);
    }

    public org.apache.tools.ant.types.Path concatSystemClasspath() {
        return concatSystemClasspath("last");
    }

    public org.apache.tools.ant.types.Path concatSystemClasspath(java.lang.String str) {
        return b(str, systemClasspath);
    }

    public org.apache.tools.ant.types.Path createPath() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(getProject());
        add(path);
        return path;
    }

    public org.apache.tools.ant.types.Path.PathElement createPathElement() throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        org.apache.tools.ant.types.Path.PathElement pathElement = new org.apache.tools.ant.types.Path.PathElement();
        add(pathElement);
        return pathElement;
    }

    public final synchronized boolean d() {
        if (this.n == null) {
            this.n = delegateIteratorToList() ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
        }
        return this.n.booleanValue();
    }

    public boolean delegateIteratorToList() {
        if (getClass().equals(org.apache.tools.ant.types.Path.class)) {
            return false;
        }
        try {
            return !getClass().getMethod(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, null).getDeclaringClass().equals(org.apache.tools.ant.types.Path.class);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            org.apache.tools.ant.types.resources.Union union = this.t;
            if (union != null) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(union, stack, project);
            }
            setChecked(true);
        }
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public synchronized boolean isFilesystemOnly() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Path) getCheckedRef()).isFilesystemOnly();
        }
        dieOnCircularReference();
        assertFilesystemOnly(this.t);
        return true;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public final synchronized java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Path) getCheckedRef()).iterator();
        }
        dieOnCircularReference();
        if (d()) {
            return new org.apache.tools.ant.types.resources.FileResourceIterator(getProject(), null, list());
        }
        org.apache.tools.ant.types.resources.Union union = this.t;
        return union == null ? java.util.Collections.emptySet().iterator() : assertFilesystemOnly(union).iterator();
    }

    public java.lang.String[] list() {
        return isReference() ? ((org.apache.tools.ant.types.Path) getCheckedRef()).list() : assertFilesystemOnly(this.t) == null ? new java.lang.String[0] : this.t.list();
    }

    public void setCache(boolean z) {
        checkAttributesAllowed();
        this.u = z;
        org.apache.tools.ant.types.resources.Union union = this.t;
        if (union != null) {
            union.setCache(z);
        }
    }

    public void setLocation(java.io.File file) throws org.apache.tools.ant.BuildException {
        checkAttributesAllowed();
        createPathElement().setLocation(file);
    }

    public void setPath(java.lang.String str) throws org.apache.tools.ant.BuildException {
        checkAttributesAllowed();
        createPathElement().setPath(str);
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (this.t != null) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public synchronized int size() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Path) getCheckedRef()).size();
        }
        dieOnCircularReference();
        org.apache.tools.ant.types.resources.Union union = this.t;
        return union == null ? 0 : assertFilesystemOnly(union).size();
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        org.apache.tools.ant.types.resources.Union union = this.t;
        return union == null ? "" : union.toString();
    }
}
