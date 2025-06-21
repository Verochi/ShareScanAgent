package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class AntClassLoader extends java.lang.ClassLoader implements org.apache.tools.ant.SubBuildListener, java.io.Closeable {
    public static final org.apache.tools.ant.util.FileUtils C = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static java.util.Map<java.lang.String, java.lang.String> D = java.util.Collections.synchronizedMap(new java.util.HashMap());
    public static final org.apache.tools.zip.ZipLong E = new org.apache.tools.zip.ZipLong(net.lingala.zip4j.util.InternalZipConstants.ENDSIG);
    public static final org.apache.tools.zip.ZipLong F = new org.apache.tools.zip.ZipLong(808471376);
    public java.lang.ClassLoader A;
    public boolean B;
    public final java.util.Vector<java.io.File> n;
    public org.apache.tools.ant.Project t;
    public boolean u;
    public final java.util.Vector<java.lang.String> v;
    public final java.util.Vector<java.lang.String> w;
    public boolean x;
    public java.lang.ClassLoader y;
    public java.util.Hashtable<java.io.File, java.util.jar.JarFile> z;

    public class ResourceEnumeration implements java.util.Enumeration<java.net.URL> {
        public final java.lang.String a;
        public int b = 0;
        public java.net.URL c;

        public ResourceEnumeration(java.lang.String str) {
            this.a = str;
            a();
        }

        public final void a() {
            java.net.URL url = null;
            while (this.b < org.apache.tools.ant.AntClassLoader.this.n.size() && url == null) {
                try {
                    url = org.apache.tools.ant.AntClassLoader.this.getResourceURL((java.io.File) org.apache.tools.ant.AntClassLoader.this.n.elementAt(this.b), this.a);
                    this.b++;
                } catch (org.apache.tools.ant.BuildException unused) {
                }
            }
            this.c = url;
        }

        @Override // java.util.Enumeration
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.net.URL nextElement() {
            java.net.URL url = this.c;
            if (url == null) {
                throw new java.util.NoSuchElementException();
            }
            a();
            return url;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.c != null;
        }
    }

    public AntClassLoader() {
        this.n = new org.apache.tools.ant.util.VectorSet();
        this.u = true;
        this.v = new java.util.Vector<>();
        this.w = new java.util.Vector<>();
        this.x = false;
        this.y = null;
        this.z = new java.util.Hashtable<>();
        this.A = null;
        this.B = false;
        setParent(null);
    }

    public AntClassLoader(java.lang.ClassLoader classLoader, org.apache.tools.ant.Project project, org.apache.tools.ant.types.Path path) {
        this.n = new org.apache.tools.ant.util.VectorSet();
        this.u = true;
        this.v = new java.util.Vector<>();
        this.w = new java.util.Vector<>();
        this.x = false;
        this.y = null;
        this.z = new java.util.Hashtable<>();
        this.A = null;
        this.B = false;
        setParent(classLoader);
        setClassPath(path);
        setProject(project);
    }

    public AntClassLoader(java.lang.ClassLoader classLoader, org.apache.tools.ant.Project project, org.apache.tools.ant.types.Path path, boolean z) {
        this(project, path);
        if (classLoader != null) {
            setParent(classLoader);
        }
        setParentFirst(z);
        addJavaLibraries();
    }

    public AntClassLoader(java.lang.ClassLoader classLoader, boolean z) {
        this.n = new org.apache.tools.ant.util.VectorSet();
        this.u = true;
        this.v = new java.util.Vector<>();
        this.w = new java.util.Vector<>();
        this.x = false;
        this.y = null;
        this.z = new java.util.Hashtable<>();
        this.A = null;
        this.B = false;
        setParent(classLoader);
        this.t = null;
        this.u = z;
    }

    public AntClassLoader(org.apache.tools.ant.Project project, org.apache.tools.ant.types.Path path) {
        this.n = new org.apache.tools.ant.util.VectorSet();
        this.u = true;
        this.v = new java.util.Vector<>();
        this.w = new java.util.Vector<>();
        this.x = false;
        this.y = null;
        this.z = new java.util.Hashtable<>();
        this.A = null;
        this.B = false;
        setParent(null);
        setProject(project);
        setClassPath(path);
    }

    public AntClassLoader(org.apache.tools.ant.Project project, org.apache.tools.ant.types.Path path, boolean z) {
        this(null, project, path, z);
    }

    @java.lang.Deprecated
    public static void initializeClass(java.lang.Class<?> cls) {
        java.lang.reflect.Constructor<?> constructor;
        java.lang.reflect.Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length <= 0 || (constructor = declaredConstructors[0]) == null) {
            return;
        }
        try {
            constructor.newInstance(new java.lang.String[256]);
        } catch (java.lang.Exception unused) {
        }
    }

    public static boolean l(java.io.File file) throws java.io.IOException {
        byte[] bArr = new byte[4];
        if (!o(file, bArr)) {
            return false;
        }
        org.apache.tools.zip.ZipLong zipLong = new org.apache.tools.zip.ZipLong(bArr);
        return org.apache.tools.zip.ZipLong.LFH_SIG.equals(zipLong) || E.equals(zipLong) || org.apache.tools.zip.ZipLong.DD_SIG.equals(zipLong) || F.equals(zipLong);
    }

    public static org.apache.tools.ant.AntClassLoader newAntClassLoader(java.lang.ClassLoader classLoader, org.apache.tools.ant.Project project, org.apache.tools.ant.types.Path path, boolean z) {
        return new org.apache.tools.ant.AntClassLoader(classLoader, project, path, z);
    }

    public static boolean o(java.io.File file, byte[] bArr) throws java.io.IOException {
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        try {
            int length = bArr.length;
            int i = 0;
            while (i != length) {
                int read = fileInputStream.read(bArr, i, length - i);
                if (read == -1) {
                    break;
                }
                i += read;
            }
            return i == length;
        } finally {
            fileInputStream.close();
        }
    }

    public void addJavaLibraries() {
        java.util.Enumeration<java.lang.String> elements = org.apache.tools.ant.util.JavaEnvUtils.getJrePackages().elements();
        while (elements.hasMoreElements()) {
            addSystemPackageRoot(elements.nextElement());
        }
    }

    public void addLoaderPackageRoot(java.lang.String str) {
        java.util.Vector<java.lang.String> vector = this.w;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(str.endsWith(".") ? "" : ".");
        vector.addElement(sb.toString());
    }

    public void addPathComponent(java.io.File file) {
        if (this.n.contains(file)) {
            return;
        }
        this.n.addElement(file);
    }

    public void addPathElement(java.lang.String str) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.Project project = this.t;
        try {
            addPathFile(project != null ? project.resolveFile(str) : new java.io.File(str));
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public void addPathFile(java.io.File file) throws java.io.IOException {
        if (!this.n.contains(file)) {
            this.n.addElement(file);
        }
        if (file.isDirectory()) {
            return;
        }
        java.lang.String str = file.getAbsolutePath() + file.lastModified() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + file.length();
        java.lang.String str2 = D.get(str);
        if (str2 == null) {
            java.util.jar.JarFile jarFile = null;
            try {
                java.util.jar.JarFile jarFile2 = new java.util.jar.JarFile(file);
                try {
                    java.util.jar.Manifest manifest = jarFile2.getManifest();
                    if (manifest == null) {
                        jarFile2.close();
                        return;
                    }
                    str2 = manifest.getMainAttributes().getValue(java.util.jar.Attributes.Name.CLASS_PATH);
                    jarFile2.close();
                    if (str2 == null) {
                        str2 = "";
                    }
                    D.put(str, str2);
                } catch (java.lang.Throwable th) {
                    th = th;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        if ("".equals(str2)) {
            return;
        }
        java.net.URL fileURL = C.getFileURL(file);
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str2);
        while (stringTokenizer.hasMoreTokens()) {
            java.lang.String nextToken = stringTokenizer.nextToken();
            java.net.URL url = new java.net.URL(fileURL, nextToken);
            if (url.getProtocol().equals("file")) {
                java.io.File file2 = new java.io.File(org.apache.tools.ant.launch.Locator.decodeUri(url.getFile()));
                if (file2.exists() && !isInPath(file2)) {
                    addPathFile(file2);
                }
            } else {
                log("Skipping jar library " + nextToken + " since only relative URLs are supported by this loader", 3);
            }
        }
    }

    public void addSystemPackageRoot(java.lang.String str) {
        java.util.Vector<java.lang.String> vector = this.v;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(str.endsWith(".") ? "" : ".");
        vector.addElement(sb.toString());
    }

    @Override // org.apache.tools.ant.BuildListener
    public void buildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        cleanup();
    }

    @Override // org.apache.tools.ant.BuildListener
    public void buildStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    public final java.lang.Class<?> c(java.lang.String str) throws java.lang.ClassNotFoundException {
        java.lang.ClassLoader classLoader = this.y;
        return classLoader == null ? findSystemClass(str) : classLoader.loadClass(str);
    }

    public synchronized void cleanup() {
        java.util.Enumeration<java.util.jar.JarFile> elements = this.z.elements();
        while (elements.hasMoreElements()) {
            try {
                elements.nextElement().close();
            } catch (java.io.IOException unused) {
            }
        }
        this.z = new java.util.Hashtable<>();
        org.apache.tools.ant.Project project = this.t;
        if (project != null) {
            project.removeBuildListener(this);
        }
        this.t = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        cleanup();
    }

    public final java.lang.Class<?> d(java.lang.String str) throws java.lang.ClassNotFoundException {
        java.lang.String f = f(str);
        java.util.Enumeration<java.io.File> elements = this.n.elements();
        while (elements.hasMoreElements()) {
            java.io.File nextElement = elements.nextElement();
            java.io.InputStream inputStream = null;
            try {
                try {
                    inputStream = i(nextElement, f);
                } catch (java.io.IOException e) {
                    log("Exception reading component " + nextElement + " (reason: " + e.getMessage() + ")", 3);
                } catch (java.lang.SecurityException e2) {
                    throw e2;
                }
                if (inputStream != null) {
                    log("Loaded from " + nextElement + " " + f, 4);
                    return g(inputStream, str, nextElement);
                }
                continue;
            } finally {
                org.apache.tools.ant.util.FileUtils.close(inputStream);
            }
        }
        throw new java.lang.ClassNotFoundException(str);
    }

    public java.lang.Class<?> defineClassFromData(java.io.File file, byte[] bArr, java.lang.String str) throws java.io.IOException {
        definePackage(file, str);
        java.security.ProtectionDomain protectionDomain = org.apache.tools.ant.Project.class.getProtectionDomain();
        return defineClass(str, bArr, 0, bArr.length, new java.security.ProtectionDomain(new java.security.CodeSource(C.getFileURL(file), e(file, f(str))), protectionDomain.getPermissions(), this, protectionDomain.getPrincipals()));
    }

    public void definePackage(java.io.File file, java.lang.String str) throws java.io.IOException {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return;
        }
        java.lang.String substring = str.substring(0, lastIndexOf);
        if (getPackage(substring) != null) {
            return;
        }
        java.util.jar.Manifest h = h(file);
        if (h == null) {
            definePackage(substring, null, null, null, null, null, null, null);
        } else {
            definePackage(file, substring, h);
        }
    }

    public void definePackage(java.io.File file, java.lang.String str, java.util.jar.Manifest manifest) {
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        java.net.URL url;
        java.util.jar.Attributes attributes = manifest.getAttributes(str.replace('.', '/') + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (attributes != null) {
            str3 = attributes.getValue(java.util.jar.Attributes.Name.SPECIFICATION_TITLE);
            str4 = attributes.getValue(java.util.jar.Attributes.Name.SPECIFICATION_VENDOR);
            str5 = attributes.getValue(java.util.jar.Attributes.Name.SPECIFICATION_VERSION);
            str6 = attributes.getValue(java.util.jar.Attributes.Name.IMPLEMENTATION_TITLE);
            str7 = attributes.getValue(java.util.jar.Attributes.Name.IMPLEMENTATION_VENDOR);
            str8 = attributes.getValue(java.util.jar.Attributes.Name.IMPLEMENTATION_VERSION);
            str2 = attributes.getValue(java.util.jar.Attributes.Name.SEALED);
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
        }
        java.util.jar.Attributes mainAttributes = manifest.getMainAttributes();
        if (mainAttributes != null) {
            if (str3 == null) {
                str3 = mainAttributes.getValue(java.util.jar.Attributes.Name.SPECIFICATION_TITLE);
            }
            if (str4 == null) {
                str4 = mainAttributes.getValue(java.util.jar.Attributes.Name.SPECIFICATION_VENDOR);
            }
            if (str5 == null) {
                str5 = mainAttributes.getValue(java.util.jar.Attributes.Name.SPECIFICATION_VERSION);
            }
            if (str6 == null) {
                str6 = mainAttributes.getValue(java.util.jar.Attributes.Name.IMPLEMENTATION_TITLE);
            }
            if (str7 == null) {
                str7 = mainAttributes.getValue(java.util.jar.Attributes.Name.IMPLEMENTATION_VENDOR);
            }
            if (str8 == null) {
                str8 = mainAttributes.getValue(java.util.jar.Attributes.Name.IMPLEMENTATION_VERSION);
            }
            if (str2 == null) {
                str2 = mainAttributes.getValue(java.util.jar.Attributes.Name.SEALED);
            }
        }
        java.lang.String str9 = str7;
        java.lang.String str10 = str8;
        java.lang.String str11 = str4;
        java.lang.String str12 = str6;
        java.lang.String str13 = str5;
        java.lang.String str14 = str3;
        if (str2 != null && str2.equalsIgnoreCase(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE)) {
            try {
                url = new java.net.URL(org.apache.tools.ant.util.FileUtils.getFileUtils().toURI(file.getAbsolutePath()));
            } catch (java.net.MalformedURLException unused) {
            }
            definePackage(str, str14, str13, str11, str12, str10, str9, url);
        }
        url = null;
        definePackage(str, str14, str13, str11, str12, str10, str9, url);
    }

    public final java.security.cert.Certificate[] e(java.io.File file, java.lang.String str) {
        java.util.jar.JarFile jarFile;
        java.util.jar.JarEntry jarEntry;
        if (file.isDirectory() || (jarFile = this.z.get(file)) == null || (jarEntry = jarFile.getJarEntry(str)) == null) {
            return null;
        }
        return jarEntry.getCertificates();
    }

    public final java.lang.String f(java.lang.String str) {
        return str.replace('.', '/') + ".class";
    }

    @Override // java.lang.ClassLoader
    public java.lang.Class<?> findClass(java.lang.String str) throws java.lang.ClassNotFoundException {
        log("Finding class " + str, 4);
        return d(str);
    }

    @Override // java.lang.ClassLoader
    public java.util.Enumeration<java.net.URL> findResources(java.lang.String str) throws java.io.IOException {
        return findResources(str, true);
    }

    public java.util.Enumeration<java.net.URL> findResources(java.lang.String str, boolean z) throws java.io.IOException {
        org.apache.tools.ant.AntClassLoader.ResourceEnumeration resourceEnumeration = new org.apache.tools.ant.AntClassLoader.ResourceEnumeration(str);
        java.lang.ClassLoader classLoader = this.y;
        java.util.Enumeration<java.net.URL> emptyEnumeration = (classLoader == null || (z && classLoader == getParent())) ? new org.apache.tools.ant.util.CollectionUtils.EmptyEnumeration<>() : this.y.getResources(str);
        return k(str) ? org.apache.tools.ant.util.CollectionUtils.append(emptyEnumeration, resourceEnumeration) : this.x ? j() == null ? resourceEnumeration : org.apache.tools.ant.util.CollectionUtils.append(resourceEnumeration, j().getResources(str)) : org.apache.tools.ant.util.CollectionUtils.append(resourceEnumeration, emptyEnumeration);
    }

    public java.lang.Class<?> forceLoadClass(java.lang.String str) throws java.lang.ClassNotFoundException {
        log("force loading " + str, 4);
        java.lang.Class<?> findLoadedClass = findLoadedClass(str);
        return findLoadedClass == null ? findClass(str) : findLoadedClass;
    }

    public java.lang.Class<?> forceLoadSystemClass(java.lang.String str) throws java.lang.ClassNotFoundException {
        log("force system loading " + str, 4);
        java.lang.Class<?> findLoadedClass = findLoadedClass(str);
        return findLoadedClass == null ? c(str) : findLoadedClass;
    }

    public final java.lang.Class<?> g(java.io.InputStream inputStream, java.lang.String str, java.io.File file) throws java.io.IOException, java.lang.SecurityException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read == -1) {
                return defineClassFromData(file, byteArrayOutputStream.toByteArray(), str);
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public java.lang.String getClasspath() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Enumeration<java.io.File> elements = this.n.elements();
        boolean z = true;
        while (elements.hasMoreElements()) {
            if (z) {
                z = false;
            } else {
                sb.append(java.lang.System.getProperty("path.separator"));
            }
            sb.append(elements.nextElement().getAbsolutePath());
        }
        return sb.toString();
    }

    public java.lang.ClassLoader getConfiguredParent() {
        return this.y;
    }

    public java.util.Enumeration<java.net.URL> getNamedResources(java.lang.String str) throws java.io.IOException {
        return findResources(str, false);
    }

    @Override // java.lang.ClassLoader
    public java.net.URL getResource(java.lang.String str) {
        java.net.URL url;
        if (k(str)) {
            java.lang.ClassLoader classLoader = this.y;
            url = classLoader == null ? super.getResource(str) : classLoader.getResource(str);
        } else {
            url = null;
        }
        if (url != null) {
            log("Resource " + str + " loaded from parent loader", 4);
        } else {
            java.util.Enumeration<java.io.File> elements = this.n.elements();
            while (elements.hasMoreElements() && url == null) {
                url = getResourceURL(elements.nextElement(), str);
                if (url != null) {
                    log("Resource " + str + " loaded from ant loader", 4);
                }
            }
        }
        if (url == null && !k(str)) {
            if (this.x) {
                url = j() != null ? j().getResource(str) : null;
            } else {
                java.lang.ClassLoader classLoader2 = this.y;
                url = classLoader2 == null ? super.getResource(str) : classLoader2.getResource(str);
            }
            if (url != null) {
                log("Resource " + str + " loaded from parent loader", 4);
            }
        }
        if (url == null) {
            log("Couldn't load Resource " + str, 4);
        }
        return url;
    }

    @Override // java.lang.ClassLoader
    public java.io.InputStream getResourceAsStream(java.lang.String str) {
        java.io.InputStream m = k(str) ? m(str) : null;
        if (m != null) {
            log("ResourceStream for " + str + " loaded from parent loader", 4);
        } else {
            m = n(str);
            if (m != null) {
                log("ResourceStream for " + str + " loaded from ant loader", 4);
            }
        }
        if (m == null && !k(str)) {
            if (this.x) {
                m = j() != null ? j().getResourceAsStream(str) : null;
            } else {
                m = m(str);
            }
            if (m != null) {
                log("ResourceStream for " + str + " loaded from parent loader", 4);
            }
        }
        if (m == null) {
            log("Couldn't load ResourceStream for " + str, 4);
        }
        return m;
    }

    public java.net.URL getResourceURL(java.io.File file, java.lang.String str) {
        try {
            java.util.jar.JarFile jarFile = this.z.get(file);
            if (jarFile == null && file.isDirectory()) {
                java.io.File file2 = new java.io.File(file, str);
                if (file2.exists()) {
                    try {
                        return C.getFileURL(file2);
                    } catch (java.net.MalformedURLException unused) {
                        return null;
                    }
                }
            } else {
                if (jarFile == null) {
                    if (!file.exists()) {
                        return null;
                    }
                    if (!l(file)) {
                        log("CLASSPATH element " + file + " is not a JAR.", 1);
                        return null;
                    }
                    this.z.put(file, new java.util.jar.JarFile(file));
                    jarFile = this.z.get(file);
                }
                java.util.jar.JarEntry jarEntry = jarFile.getJarEntry(str);
                if (jarEntry != null) {
                    try {
                        return new java.net.URL("jar:" + C.getFileURL(file) + "!/" + jarEntry);
                    } catch (java.net.MalformedURLException unused2) {
                        return null;
                    }
                }
            }
        } catch (java.lang.Exception e) {
            log(("Unable to obtain resource from " + file + ": ") + e, 1);
            log(org.apache.tools.ant.util.StringUtils.getStackTrace(e), 1);
        }
        return null;
    }

    @Override // java.lang.ClassLoader
    public java.util.Enumeration<java.net.URL> getResources(java.lang.String str) throws java.io.IOException {
        return getNamedResources(str);
    }

    public final java.util.jar.Manifest h(java.io.File file) throws java.io.IOException {
        java.util.jar.JarFile jarFile;
        if (file.isDirectory() || (jarFile = this.z.get(file)) == null) {
            return null;
        }
        return jarFile.getManifest();
    }

    public final java.io.InputStream i(java.io.File file, java.lang.String str) {
        try {
            java.util.jar.JarFile jarFile = this.z.get(file);
            if (jarFile == null && file.isDirectory()) {
                java.io.File file2 = new java.io.File(file, str);
                if (file2.exists()) {
                    return new java.io.FileInputStream(file2);
                }
            } else {
                if (jarFile == null) {
                    if (!file.exists()) {
                        return null;
                    }
                    this.z.put(file, new java.util.jar.JarFile(file));
                    jarFile = this.z.get(file);
                }
                java.util.jar.JarEntry jarEntry = jarFile.getJarEntry(str);
                if (jarEntry != null) {
                    return jarFile.getInputStream(jarEntry);
                }
            }
        } catch (java.lang.Exception e) {
            log("Ignoring Exception " + e.getClass().getName() + ": " + e.getMessage() + " reading resource " + str + " from " + file, 3);
        }
        return null;
    }

    public boolean isInPath(java.io.File file) {
        return this.n.contains(file);
    }

    public final java.lang.ClassLoader j() {
        java.lang.ClassLoader classLoader = getClass().getClassLoader();
        while (classLoader != null && classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
        }
        return classLoader;
    }

    public final boolean k(java.lang.String str) {
        boolean z = this.u;
        java.util.Enumeration<java.lang.String> elements = this.v.elements();
        while (true) {
            if (!elements.hasMoreElements()) {
                break;
            }
            if (str.startsWith(elements.nextElement())) {
                z = true;
                break;
            }
        }
        java.util.Enumeration<java.lang.String> elements2 = this.w.elements();
        while (elements2.hasMoreElements()) {
            if (str.startsWith(elements2.nextElement())) {
                return false;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008e A[Catch: all -> 0x0094, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0009, B:12:0x0010, B:14:0x008e, B:20:0x004c, B:18:0x002e, B:23:0x006b, B:25:0x006f, B:26:0x0093), top: B:2:0x0001, inners: #1, #2 }] */
    @Override // java.lang.ClassLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized java.lang.Class<?> loadClass(java.lang.String str, boolean z) throws java.lang.ClassNotFoundException {
        java.lang.Class<?> c;
        java.lang.Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        if (k(str)) {
            try {
                c = c(str);
                log("Class " + str + " loaded from parent loader (parentFirst)", 4);
            } catch (java.lang.ClassNotFoundException unused) {
                c = findClass(str);
                log("Class " + str + " loaded from ant loader (parentFirst)", 4);
            }
            if (z) {
                resolveClass(c);
            }
            return c;
        }
        try {
            c = findClass(str);
            log("Class " + str + " loaded from ant loader", 4);
        } catch (java.lang.ClassNotFoundException e) {
            if (this.x) {
                throw e;
            }
            c = c(str);
            log("Class " + str + " loaded from parent loader", 4);
        }
        if (z) {
        }
        return c;
    }

    public void log(java.lang.String str, int i) {
        org.apache.tools.ant.Project project = this.t;
        if (project != null) {
            project.log(str, i);
        } else if (i < 2) {
            java.lang.System.err.println(str);
        }
    }

    public final java.io.InputStream m(java.lang.String str) {
        java.lang.ClassLoader classLoader = this.y;
        return classLoader == null ? super.getResourceAsStream(str) : classLoader.getResourceAsStream(str);
    }

    @Override // org.apache.tools.ant.BuildListener
    public void messageLogged(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    public final java.io.InputStream n(java.lang.String str) {
        java.util.Enumeration<java.io.File> elements = this.n.elements();
        java.io.InputStream inputStream = null;
        while (elements.hasMoreElements() && inputStream == null) {
            inputStream = i(elements.nextElement(), str);
        }
        return inputStream;
    }

    public void resetThreadContextLoader() {
        if (org.apache.tools.ant.util.LoaderUtils.isContextLoaderAvailable() && this.B) {
            org.apache.tools.ant.util.LoaderUtils.setContextClassLoader(this.A);
            this.A = null;
            this.B = false;
        }
    }

    public void setClassPath(org.apache.tools.ant.types.Path path) {
        this.n.removeAllElements();
        if (path != null) {
            for (java.lang.String str : path.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE).list()) {
                try {
                    addPathElement(str);
                } catch (org.apache.tools.ant.BuildException e) {
                    log("Ignoring path element " + str + " from classpath due to exception " + e, 4);
                }
            }
        }
    }

    public synchronized void setIsolated(boolean z) {
        this.x = z;
    }

    public void setParent(java.lang.ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = org.apache.tools.ant.AntClassLoader.class.getClassLoader();
        }
        this.y = classLoader;
    }

    public void setParentFirst(boolean z) {
        this.u = z;
    }

    public void setProject(org.apache.tools.ant.Project project) {
        this.t = project;
        if (project != null) {
            project.addBuildListener(this);
        }
    }

    public void setThreadContextLoader() {
        if (this.B) {
            throw new org.apache.tools.ant.BuildException("Context loader has not been reset");
        }
        if (org.apache.tools.ant.util.LoaderUtils.isContextLoaderAvailable()) {
            this.A = org.apache.tools.ant.util.LoaderUtils.getContextClassLoader();
            org.apache.tools.ant.Project project = this.t;
            org.apache.tools.ant.util.LoaderUtils.setContextClassLoader((project == null || !com.tencent.open.SocialConstants.PARAM_ONLY.equals(project.getProperty(org.apache.tools.ant.MagicNames.BUILD_SYSCLASSPATH))) ? this : getClass().getClassLoader());
            this.B = true;
        }
    }

    @Override // org.apache.tools.ant.SubBuildListener
    public void subBuildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        if (buildEvent.getProject() == this.t) {
            cleanup();
        }
    }

    @Override // org.apache.tools.ant.SubBuildListener
    public void subBuildStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void targetFinished(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void targetStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void taskFinished(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void taskStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    public java.lang.String toString() {
        return "AntClassLoader[" + getClasspath() + "]";
    }
}
