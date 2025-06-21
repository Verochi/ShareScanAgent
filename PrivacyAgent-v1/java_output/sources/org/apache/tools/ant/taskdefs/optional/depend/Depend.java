package org.apache.tools.ant.taskdefs.optional.depend;

/* loaded from: classes25.dex */
public class Depend extends org.apache.tools.ant.taskdefs.MatchingTask {
    public java.util.Hashtable A;
    public java.util.Hashtable B;
    public boolean C = false;
    public boolean D = true;
    public boolean E = false;
    public org.apache.tools.ant.types.Path F;
    public org.apache.tools.ant.types.Path u;
    public org.apache.tools.ant.types.Path v;
    public java.io.File w;
    public java.lang.String[] x;
    public java.util.Hashtable y;
    public java.util.Hashtable z;

    public static class ClassFileInfo {
        public java.io.File a;
        public java.lang.String b;
        public java.io.File c;
        public boolean d;

        public ClassFileInfo() {
            this.d = false;
        }

        public /* synthetic */ ClassFileInfo(org.apache.tools.ant.taskdefs.optional.depend.Depend.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public final void c(java.util.Vector vector, java.io.File file, java.io.File file2) {
        java.lang.String[] list = file.list();
        if (list == null) {
            return;
        }
        int length = list.length;
        int length2 = file2.getPath().length();
        java.io.File file3 = null;
        for (int i = 0; i < length; i++) {
            java.io.File file4 = new java.io.File(file, list[i]);
            if (list[i].endsWith(".class")) {
                org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo classFileInfo = new org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo(null);
                classFileInfo.a = file4;
                java.lang.String substring = file4.getPath().substring(length2 + 1, file4.getPath().length() - 6);
                classFileInfo.b = org.apache.tools.ant.taskdefs.optional.depend.ClassFileUtils.convertSlashName(substring);
                file3 = i(substring, file3);
                classFileInfo.c = file3;
                vector.addElement(classFileInfo);
            } else {
                c(vector, file4, file2);
            }
        }
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.F == null) {
            this.F = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.F.createPath();
    }

    public final int d(java.lang.String str) {
        int d;
        java.util.Hashtable hashtable = (java.util.Hashtable) this.y.get(str);
        if (hashtable == null) {
            return 0;
        }
        java.util.Enumeration keys = hashtable.keys();
        int i = 0;
        while (keys.hasMoreElements()) {
            java.lang.String str2 = (java.lang.String) keys.nextElement();
            org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo classFileInfo = (org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo) hashtable.get(str2);
            if (classFileInfo.a.exists()) {
                if (classFileInfo.c == null) {
                    o(classFileInfo, str2, str);
                } else {
                    log("Deleting file " + classFileInfo.a.getPath() + " since " + str + " out of date", 3);
                    classFileInfo.a.delete();
                    i++;
                    if (this.C) {
                        d = d(str2);
                    } else if (str2.contains("$")) {
                        java.lang.String substring = str2.substring(0, str2.indexOf("$"));
                        log("Top level class = " + substring, 3);
                        org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo classFileInfo2 = (org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo) this.z.get(substring);
                        if (classFileInfo2 != null && classFileInfo2.a.exists()) {
                            log("Deleting file " + classFileInfo2.a.getPath() + " since one of its inner classes was removed", 3);
                            classFileInfo2.a.delete();
                            i++;
                            if (this.C) {
                                d = d(substring);
                            }
                        }
                    }
                    i += d;
                }
            }
        }
        return i;
    }

    public final int e() {
        java.util.Enumeration elements = this.B.elements();
        int i = 0;
        while (elements.hasMoreElements()) {
            java.lang.String str = (java.lang.String) elements.nextElement();
            i += d(str);
            org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo classFileInfo = (org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo) this.z.get(str);
            if (classFileInfo != null && classFileInfo.a.exists()) {
                if (classFileInfo.c == null) {
                    o(classFileInfo, str, str);
                } else {
                    classFileInfo.a.delete();
                    i++;
                }
            }
        }
        return i;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            org.apache.tools.ant.types.Path path = this.u;
            if (path == null) {
                throw new org.apache.tools.ant.BuildException("srcdir attribute must be set", getLocation());
            }
            java.lang.String[] list = path.list();
            this.x = list;
            if (list.length == 0) {
                throw new org.apache.tools.ant.BuildException("srcdir attribute must be non-empty", getLocation());
            }
            if (this.v == null) {
                this.v = this.u;
            }
            java.io.File file = this.w;
            if (file != null && file.exists() && !this.w.isDirectory()) {
                throw new org.apache.tools.ant.BuildException("The cache, if specified, must point to a directory");
            }
            java.io.File file2 = this.w;
            if (file2 != null && !file2.exists()) {
                this.w.mkdirs();
            }
            f();
            if (this.E) {
                h();
            }
            g();
            int e = e();
            long currentTimeMillis2 = (java.lang.System.currentTimeMillis() - currentTimeMillis) / 1000;
            log("Deleted " + e + " out of date files in " + currentTimeMillis2 + " seconds", e > 0 ? 2 : 4);
        } catch (java.lang.Exception e2) {
            throw new org.apache.tools.ant.BuildException(e2);
        }
    }

    public final void f() throws java.io.IOException {
        long j;
        boolean z;
        org.apache.tools.ant.AntClassLoader antClassLoader;
        int i;
        java.lang.Object obj;
        this.y = new java.util.Hashtable();
        this.z = new java.util.Hashtable();
        java.util.Hashtable hashtable = new java.util.Hashtable();
        if (this.w != null) {
            java.io.File file = new java.io.File(this.w, "dependencies.txt");
            z = file.exists();
            j = file.lastModified();
            if (z) {
                hashtable = n(file);
            }
        } else {
            j = Long.MAX_VALUE;
            z = true;
        }
        java.util.Enumeration elements = k(this.v).elements();
        boolean z2 = false;
        while (true) {
            antClassLoader = null;
            r12 = null;
            r12 = null;
            java.util.Vector vector = null;
            i = 4;
            if (!elements.hasMoreElements()) {
                break;
            }
            org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo classFileInfo = (org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo) elements.nextElement();
            log("Adding class info for " + classFileInfo.b, 4);
            this.z.put(classFileInfo.b, classFileInfo);
            if (this.w != null && z && j > classFileInfo.a.lastModified()) {
                vector = (java.util.Vector) hashtable.get(classFileInfo.b);
            }
            if (vector == null) {
                org.apache.tools.ant.taskdefs.optional.depend.AntAnalyzer antAnalyzer = new org.apache.tools.ant.taskdefs.optional.depend.AntAnalyzer();
                antAnalyzer.addRootClass(classFileInfo.b);
                antAnalyzer.addClassPath(this.v);
                antAnalyzer.setClosure(false);
                vector = new java.util.Vector();
                java.util.Enumeration<java.lang.String> classDependencies = antAnalyzer.getClassDependencies();
                while (classDependencies.hasMoreElements()) {
                    java.lang.String nextElement = classDependencies.nextElement();
                    vector.addElement(nextElement);
                    log("Class " + classFileInfo.b + " depends on " + ((java.lang.Object) nextElement), 4);
                }
                hashtable.put(classFileInfo.b, vector);
                z2 = true;
            }
            java.util.Enumeration elements2 = vector.elements();
            while (elements2.hasMoreElements()) {
                java.lang.String str = (java.lang.String) elements2.nextElement();
                java.util.Hashtable hashtable2 = (java.util.Hashtable) this.y.get(str);
                if (hashtable2 == null) {
                    hashtable2 = new java.util.Hashtable();
                    this.y.put(str, hashtable2);
                }
                hashtable2.put(classFileInfo.b, classFileInfo);
                log(str + " affects " + classFileInfo.b, 4);
            }
        }
        this.A = null;
        org.apache.tools.ant.types.Path j2 = j();
        if (j2 != null) {
            this.A = new java.util.Hashtable();
            try {
                antClassLoader = getProject().createClassLoader(j2);
                java.util.Hashtable hashtable3 = new java.util.Hashtable();
                java.lang.Object obj2 = new java.lang.Object();
                java.util.Enumeration keys = hashtable.keys();
                while (keys.hasMoreElements()) {
                    java.lang.String str2 = (java.lang.String) keys.nextElement();
                    log("Determining classpath dependencies for " + str2, i);
                    java.util.Vector vector2 = (java.util.Vector) hashtable.get(str2);
                    java.util.Hashtable hashtable4 = new java.util.Hashtable();
                    this.A.put(str2, hashtable4);
                    java.util.Enumeration elements3 = vector2.elements();
                    while (elements3.hasMoreElements()) {
                        java.lang.String str3 = (java.lang.String) elements3.nextElement();
                        log("Looking for " + str3, i);
                        java.lang.Object obj3 = hashtable3.get(str3);
                        if (obj3 == null) {
                            if (str3.startsWith("java.") || str3.startsWith("javax.")) {
                                log("Ignoring base classlib dependency " + str3, 4);
                                obj3 = obj2;
                            } else {
                                java.net.URL resource = antClassLoader.getResource(str3.replace('.', '/') + ".class");
                                log("URL is " + resource, 4);
                                if (resource != null) {
                                    if (resource.getProtocol().equals("jar")) {
                                        java.lang.String file2 = resource.getFile();
                                        java.lang.String substring = file2.substring(0, file2.indexOf(33));
                                        if (!substring.startsWith("file:")) {
                                            throw new java.io.IOException("Bizarre nested path in jar: protocol: " + substring);
                                        }
                                        obj = new java.io.File(org.apache.tools.ant.util.FileUtils.getFileUtils().fromURI(substring));
                                    } else {
                                        obj = resource.getProtocol().equals("file") ? new java.io.File(org.apache.tools.ant.util.FileUtils.getFileUtils().fromURI(resource.toExternalForm())) : obj2;
                                    }
                                    log("Class " + str2 + " depends on " + obj + " due to " + str3, 4);
                                } else {
                                    obj = obj2;
                                }
                                obj3 = obj;
                            }
                            hashtable3.put(str3, obj3);
                        }
                        if (obj3 != obj2) {
                            java.io.File file3 = (java.io.File) obj3;
                            log("Adding a classpath dependency on " + file3, 4);
                            hashtable4.put(file3, file3);
                        }
                        i = 4;
                    }
                }
            } finally {
                if (antClassLoader != null) {
                    antClassLoader.cleanup();
                }
            }
        } else {
            log("No classpath to check", 4);
        }
        if (this.w == null || !z2) {
            return;
        }
        p(hashtable);
    }

    public final void g() {
        org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo classFileInfo;
        this.B = new java.util.Hashtable();
        for (int i = 0; i < this.x.length; i++) {
            java.io.File resolveFile = getProject().resolveFile(this.x[i]);
            if (resolveFile.exists()) {
                scanDir(resolveFile, getDirectoryScanner(resolveFile).getIncludedFiles());
            }
        }
        java.util.Hashtable hashtable = this.A;
        if (hashtable == null) {
            return;
        }
        java.util.Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            java.lang.String str = (java.lang.String) keys.nextElement();
            if (!this.B.containsKey(str) && (classFileInfo = (org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo) this.z.get(str)) != null) {
                java.util.Enumeration elements = ((java.util.Hashtable) this.A.get(str)).elements();
                while (true) {
                    if (elements.hasMoreElements()) {
                        java.io.File file = (java.io.File) elements.nextElement();
                        if (file.lastModified() > classFileInfo.a.lastModified()) {
                            log("Class " + str + " is out of date with respect to " + file, 4);
                            this.B.put(str, str);
                            break;
                        }
                    }
                }
            }
        }
    }

    public org.apache.tools.ant.types.Path getClasspath() {
        return this.F;
    }

    public final void h() {
        log("Reverse Dependency Dump for " + this.y.size() + " classes:", 4);
        java.util.Enumeration keys = this.y.keys();
        while (keys.hasMoreElements()) {
            java.lang.String str = (java.lang.String) keys.nextElement();
            log(" Class " + str + " affects:", 4);
            java.util.Hashtable hashtable = (java.util.Hashtable) this.y.get(str);
            java.util.Enumeration keys2 = hashtable.keys();
            while (keys2.hasMoreElements()) {
                java.lang.String str2 = (java.lang.String) keys2.nextElement();
                log("    " + str2 + " in " + ((org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo) hashtable.get(str2)).a.getPath(), 4);
            }
        }
        if (this.A != null) {
            log("Classpath file dependencies (Forward):", 4);
            java.util.Enumeration keys3 = this.A.keys();
            while (keys3.hasMoreElements()) {
                java.lang.String str3 = (java.lang.String) keys3.nextElement();
                log(" Class " + str3 + " depends on:", 4);
                java.util.Enumeration elements = ((java.util.Hashtable) this.A.get(str3)).elements();
                while (elements.hasMoreElements()) {
                    log("    " + ((java.io.File) elements.nextElement()).getPath(), 4);
                }
            }
        }
    }

    public final java.io.File i(java.lang.String str, java.io.File file) {
        int indexOf = str.indexOf("$");
        java.lang.String str2 = indexOf != -1 ? str.substring(0, indexOf) + ".java" : str + ".java";
        for (int i = 0; i < this.x.length; i++) {
            java.io.File file2 = new java.io.File(this.x[i], str2);
            if (file2.equals(file) || file2.exists()) {
                return file2;
            }
        }
        return null;
    }

    public final org.apache.tools.ant.types.Path j() {
        if (this.F == null) {
            return null;
        }
        java.lang.String[] list = this.v.list();
        java.lang.String str = "";
        for (java.lang.String str2 : this.F.list()) {
            boolean z = false;
            for (int i = 0; i < list.length && !z; i++) {
                z = list[i].equals(str2);
            }
            if (!z) {
                str = str.length() == 0 ? str2 : str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2;
            }
        }
        org.apache.tools.ant.types.Path path = str.length() > 0 ? new org.apache.tools.ant.types.Path(getProject(), str) : null;
        log("Classpath without dest dir is " + path, 4);
        return path;
    }

    public final java.util.Vector k(org.apache.tools.ant.types.Path path) {
        java.lang.String[] list = path.list();
        java.util.Vector vector = new java.util.Vector();
        for (java.lang.String str : list) {
            java.io.File file = new java.io.File(str);
            if (file.isDirectory()) {
                c(vector, file, file);
            }
        }
        return vector;
    }

    public final boolean l(java.lang.String str, java.lang.String str2) {
        return m(str, str2, org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.RMI_STUB_SUFFIX) || m(str, str2, org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.RMI_SKEL_SUFFIX) || m(str, str2, org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.RMI_STUB_SUFFIX) || m(str, str2, org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.RMI_SKEL_SUFFIX);
    }

    public final boolean m(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return (str2 + str3).equals(str);
    }

    public final java.util.Hashtable n(java.io.File file) throws java.io.IOException {
        java.util.Hashtable hashtable = new java.util.Hashtable();
        java.io.BufferedReader bufferedReader = null;
        java.util.Vector vector = null;
        try {
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader(file));
            while (true) {
                try {
                    java.lang.String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        org.apache.tools.ant.util.FileUtils.close(bufferedReader2);
                        return hashtable;
                    }
                    if (readLine.startsWith("||:")) {
                        vector = new java.util.Vector();
                        hashtable.put(readLine.substring(3), vector);
                    } else if (vector != null) {
                        vector.addElement(readLine);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                    throw th;
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final void o(org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo classFileInfo, java.lang.String str, java.lang.String str2) {
        if (classFileInfo.d) {
            return;
        }
        log("The class " + str + " in file " + classFileInfo.a.getPath() + " is out of date due to " + str2 + " but has not been deleted because its source file could not be determined", (this.D || !l(str, str2)) ? 1 : 3);
        classFileInfo.d = true;
    }

    public final void p(java.util.Hashtable hashtable) throws java.io.IOException {
        java.io.File file = this.w;
        if (file == null) {
            return;
        }
        java.io.BufferedWriter bufferedWriter = null;
        try {
            file.mkdirs();
            java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(this.w, "dependencies.txt")));
            try {
                java.util.Enumeration keys = hashtable.keys();
                while (keys.hasMoreElements()) {
                    java.lang.String str = (java.lang.String) keys.nextElement();
                    bufferedWriter2.write("||:" + str);
                    bufferedWriter2.newLine();
                    java.util.Vector vector = (java.util.Vector) hashtable.get(str);
                    int size = vector.size();
                    for (int i = 0; i < size; i++) {
                        bufferedWriter2.write(java.lang.String.valueOf(vector.elementAt(i)));
                        bufferedWriter2.newLine();
                    }
                }
                org.apache.tools.ant.util.FileUtils.close(bufferedWriter2);
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public void scanDir(java.io.File file, java.lang.String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            java.io.File file2 = new java.io.File(file, strArr[i]);
            if (strArr[i].endsWith(".java")) {
                java.lang.String convertSlashName = org.apache.tools.ant.taskdefs.optional.depend.ClassFileUtils.convertSlashName(file2.getPath().substring(file.getPath().length() + 1, r2.length() - 5));
                org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo classFileInfo = (org.apache.tools.ant.taskdefs.optional.depend.Depend.ClassFileInfo) this.z.get(convertSlashName);
                if (classFileInfo == null) {
                    this.B.put(convertSlashName, convertSlashName);
                } else if (file2.lastModified() > classFileInfo.a.lastModified()) {
                    this.B.put(convertSlashName, convertSlashName);
                }
            }
        }
    }

    public void setCache(java.io.File file) {
        this.w = file;
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.F;
        if (path2 == null) {
            this.F = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setClosure(boolean z) {
        this.C = z;
    }

    public void setDestDir(org.apache.tools.ant.types.Path path) {
        this.v = path;
    }

    public void setDump(boolean z) {
        this.E = z;
    }

    public void setSrcdir(org.apache.tools.ant.types.Path path) {
        this.u = path;
    }

    public void setWarnOnRmiStubs(boolean z) {
        this.D = z;
    }
}
