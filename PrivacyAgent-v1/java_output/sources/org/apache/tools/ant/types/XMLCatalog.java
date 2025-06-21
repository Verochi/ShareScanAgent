package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class XMLCatalog extends org.apache.tools.ant.types.DataType implements org.xml.sax.EntityResolver, javax.xml.transform.URIResolver {
    public static final java.lang.String APACHE_RESOLVER = "org.apache.tools.ant.types.resolver.ApacheCatalogResolver";
    public static final java.lang.String CATALOG_RESOLVER = "org.apache.xml.resolver.tools.CatalogResolver";
    public static final org.apache.tools.ant.util.FileUtils w = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public org.apache.tools.ant.types.Path t;
    public org.apache.tools.ant.types.Path u;
    public java.util.Vector<org.apache.tools.ant.types.ResourceLocation> n = new java.util.Vector<>();
    public org.apache.tools.ant.types.XMLCatalog.CatalogResolver v = null;

    public interface CatalogResolver extends javax.xml.transform.URIResolver, org.xml.sax.EntityResolver {
        @Override // javax.xml.transform.URIResolver
        javax.xml.transform.Source resolve(java.lang.String str, java.lang.String str2) throws javax.xml.transform.TransformerException;

        @Override // org.xml.sax.EntityResolver
        org.xml.sax.InputSource resolveEntity(java.lang.String str, java.lang.String str2);
    }

    public class ExternalResolver implements org.apache.tools.ant.types.XMLCatalog.CatalogResolver {
        public java.lang.reflect.Method n;
        public java.lang.reflect.Method t;
        public java.lang.reflect.Method u;
        public java.lang.reflect.Method v;
        public java.lang.Object w;
        public boolean x = false;

        public ExternalResolver(java.lang.Class<?> cls, java.lang.Object obj) {
            this.n = null;
            this.t = null;
            this.u = null;
            this.v = null;
            this.w = obj;
            try {
                this.n = cls.getMethod("setXMLCatalog", org.apache.tools.ant.types.XMLCatalog.class);
                this.t = cls.getMethod("parseCatalog", java.lang.String.class);
                this.u = cls.getMethod("resolveEntity", java.lang.String.class, java.lang.String.class);
                this.v = cls.getMethod("resolve", java.lang.String.class, java.lang.String.class);
                org.apache.tools.ant.types.XMLCatalog.this.log("Apache resolver library found, xml-commons resolver will be used", 3);
            } catch (java.lang.NoSuchMethodException e) {
                throw new org.apache.tools.ant.BuildException(e);
            }
        }

        public final void a() {
            if (!this.x) {
                try {
                    this.n.invoke(this.w, org.apache.tools.ant.types.XMLCatalog.this);
                    if (org.apache.tools.ant.types.XMLCatalog.this.getCatalogPath() != null) {
                        org.apache.tools.ant.types.XMLCatalog.this.log("Using catalogpath '" + org.apache.tools.ant.types.XMLCatalog.this.getCatalogPath() + "'", 4);
                        for (java.lang.String str : org.apache.tools.ant.types.XMLCatalog.this.getCatalogPath().list()) {
                            java.io.File file = new java.io.File(str);
                            org.apache.tools.ant.types.XMLCatalog.this.log("Parsing " + file, 4);
                            try {
                                this.t.invoke(this.w, file.getPath());
                            } catch (java.lang.Exception e) {
                                throw new org.apache.tools.ant.BuildException(e);
                            }
                        }
                    }
                } catch (java.lang.Exception e2) {
                    throw new org.apache.tools.ant.BuildException(e2);
                }
            }
            this.x = true;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0064  */
        @Override // org.apache.tools.ant.types.XMLCatalog.CatalogResolver, javax.xml.transform.URIResolver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public javax.xml.transform.Source resolve(java.lang.String str, java.lang.String str2) throws javax.xml.transform.TransformerException {
            org.apache.tools.ant.types.ResourceLocation resourceLocation;
            org.xml.sax.InputSource h;
            a();
            org.apache.tools.ant.types.ResourceLocation i = org.apache.tools.ant.types.XMLCatalog.this.i(str);
            if (i == null) {
                if (str2 == null) {
                    try {
                        str2 = org.apache.tools.ant.types.XMLCatalog.w.getFileURL(org.apache.tools.ant.types.XMLCatalog.this.getProject().getBaseDir()).toString();
                    } catch (java.net.MalformedURLException e) {
                        throw new javax.xml.transform.TransformerException(e);
                    }
                }
                try {
                    return (javax.xml.transform.sax.SAXSource) this.v.invoke(this.w, str, str2);
                } catch (java.lang.Exception e2) {
                    throw new org.apache.tools.ant.BuildException(e2);
                }
            }
            org.apache.tools.ant.types.XMLCatalog.this.log("Matching catalog entry found for uri: '" + i.getPublicId() + "' location: '" + i.getLocation() + "'", 4);
            if (str2 != null) {
                try {
                    java.net.URL url = new java.net.URL(str2);
                    resourceLocation = new org.apache.tools.ant.types.ResourceLocation();
                    try {
                        resourceLocation.setBase(url);
                    } catch (java.net.MalformedURLException unused) {
                    }
                } catch (java.net.MalformedURLException unused2) {
                }
                resourceLocation.setPublicId(i.getPublicId());
                resourceLocation.setLocation(i.getLocation());
                h = org.apache.tools.ant.types.XMLCatalog.this.h(resourceLocation);
                if (h == null) {
                    h = org.apache.tools.ant.types.XMLCatalog.this.g(resourceLocation);
                }
                if (h == null) {
                    return new javax.xml.transform.sax.SAXSource(h);
                }
                try {
                    return (javax.xml.transform.sax.SAXSource) this.v.invoke(this.w, str, str2);
                } catch (java.lang.Exception e3) {
                    throw new org.apache.tools.ant.BuildException(e3);
                }
            }
            resourceLocation = i;
            resourceLocation.setPublicId(i.getPublicId());
            resourceLocation.setLocation(i.getLocation());
            h = org.apache.tools.ant.types.XMLCatalog.this.h(resourceLocation);
            if (h == null) {
            }
            if (h == null) {
            }
        }

        @Override // org.apache.tools.ant.types.XMLCatalog.CatalogResolver, org.xml.sax.EntityResolver
        public org.xml.sax.InputSource resolveEntity(java.lang.String str, java.lang.String str2) {
            a();
            org.apache.tools.ant.types.ResourceLocation i = org.apache.tools.ant.types.XMLCatalog.this.i(str);
            if (i == null) {
                try {
                    return (org.xml.sax.InputSource) this.u.invoke(this.w, str, str2);
                } catch (java.lang.Exception e) {
                    throw new org.apache.tools.ant.BuildException(e);
                }
            }
            org.apache.tools.ant.types.XMLCatalog.this.log("Matching catalog entry found for publicId: '" + i.getPublicId() + "' location: '" + i.getLocation() + "'", 4);
            org.xml.sax.InputSource h = org.apache.tools.ant.types.XMLCatalog.this.h(i);
            if (h == null) {
                h = org.apache.tools.ant.types.XMLCatalog.this.g(i);
            }
            if (h != null) {
                return h;
            }
            try {
                return (org.xml.sax.InputSource) this.u.invoke(this.w, str, str2);
            } catch (java.lang.Exception e2) {
                throw new org.apache.tools.ant.BuildException(e2);
            }
        }
    }

    public class InternalResolver implements org.apache.tools.ant.types.XMLCatalog.CatalogResolver {
        public InternalResolver() {
            org.apache.tools.ant.types.XMLCatalog.this.log("Apache resolver library not found, internal resolver will be used", 3);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x005e  */
        @Override // org.apache.tools.ant.types.XMLCatalog.CatalogResolver, javax.xml.transform.URIResolver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public javax.xml.transform.Source resolve(java.lang.String str, java.lang.String str2) throws javax.xml.transform.TransformerException {
            org.apache.tools.ant.types.ResourceLocation resourceLocation;
            org.xml.sax.InputSource h;
            org.apache.tools.ant.types.ResourceLocation i = org.apache.tools.ant.types.XMLCatalog.this.i(str);
            if (i != null) {
                org.apache.tools.ant.types.XMLCatalog.this.log("Matching catalog entry found for uri: '" + i.getPublicId() + "' location: '" + i.getLocation() + "'", 4);
                if (str2 != null) {
                    try {
                        java.net.URL url = new java.net.URL(str2);
                        resourceLocation = new org.apache.tools.ant.types.ResourceLocation();
                        try {
                            resourceLocation.setBase(url);
                        } catch (java.net.MalformedURLException unused) {
                        }
                    } catch (java.net.MalformedURLException unused2) {
                    }
                    resourceLocation.setPublicId(i.getPublicId());
                    resourceLocation.setLocation(i.getLocation());
                    h = org.apache.tools.ant.types.XMLCatalog.this.h(resourceLocation);
                    if (h == null) {
                        h = org.apache.tools.ant.types.XMLCatalog.this.g(resourceLocation);
                    }
                    if (h == null) {
                        h = org.apache.tools.ant.types.XMLCatalog.this.o(resourceLocation);
                    }
                    if (h != null) {
                        return new javax.xml.transform.sax.SAXSource(h);
                    }
                }
                resourceLocation = i;
                resourceLocation.setPublicId(i.getPublicId());
                resourceLocation.setLocation(i.getLocation());
                h = org.apache.tools.ant.types.XMLCatalog.this.h(resourceLocation);
                if (h == null) {
                }
                if (h == null) {
                }
                if (h != null) {
                }
            }
            return null;
        }

        @Override // org.apache.tools.ant.types.XMLCatalog.CatalogResolver, org.xml.sax.EntityResolver
        public org.xml.sax.InputSource resolveEntity(java.lang.String str, java.lang.String str2) {
            org.apache.tools.ant.types.ResourceLocation i = org.apache.tools.ant.types.XMLCatalog.this.i(str);
            if (i == null) {
                return null;
            }
            org.apache.tools.ant.types.XMLCatalog.this.log("Matching catalog entry found for publicId: '" + i.getPublicId() + "' location: '" + i.getLocation() + "'", 4);
            org.xml.sax.InputSource h = org.apache.tools.ant.types.XMLCatalog.this.h(i);
            if (h == null) {
                h = org.apache.tools.ant.types.XMLCatalog.this.g(i);
            }
            return h == null ? org.apache.tools.ant.types.XMLCatalog.this.o(i) : h;
        }
    }

    public XMLCatalog() {
        setChecked(false);
    }

    public void addConfiguredXMLCatalog(org.apache.tools.ant.types.XMLCatalog xMLCatalog) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        k().addAll(xMLCatalog.k());
        createClasspath().append(xMLCatalog.getClasspath());
        createCatalogPath().append(xMLCatalog.getCatalogPath());
        setChecked(false);
    }

    public void addDTD(org.apache.tools.ant.types.ResourceLocation resourceLocation) throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        k().addElement(resourceLocation);
        setChecked(false);
    }

    public void addEntity(org.apache.tools.ant.types.ResourceLocation resourceLocation) throws org.apache.tools.ant.BuildException {
        addDTD(resourceLocation);
    }

    public org.apache.tools.ant.types.Path createCatalogPath() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.u == null) {
            this.u = new org.apache.tools.ant.types.Path(getProject());
        }
        setChecked(false);
        return this.u.createPath();
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.t == null) {
            this.t = new org.apache.tools.ant.types.Path(getProject());
        }
        setChecked(false);
        return this.t.createPath();
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            org.apache.tools.ant.types.Path path = this.t;
            if (path != null) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(path, stack, project);
            }
            org.apache.tools.ant.types.Path path2 = this.u;
            if (path2 != null) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(path2, stack, project);
            }
            setChecked(true);
        }
    }

    public final org.xml.sax.InputSource g(org.apache.tools.ant.types.ResourceLocation resourceLocation) {
        org.apache.tools.ant.types.Path path = this.t;
        org.apache.tools.ant.AntClassLoader createClassLoader = getProject().createClassLoader(path != null ? path.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE) : new org.apache.tools.ant.types.Path(getProject()).concatSystemClasspath("last"));
        java.io.InputStream resourceAsStream = createClassLoader.getResourceAsStream(resourceLocation.getLocation());
        if (resourceAsStream == null) {
            return null;
        }
        org.xml.sax.InputSource inputSource = new org.xml.sax.InputSource(resourceAsStream);
        java.lang.String externalForm = createClassLoader.getResource(resourceLocation.getLocation()).toExternalForm();
        inputSource.setSystemId(externalForm);
        log("catalog entry matched a resource in the classpath: '" + externalForm + "'", 4);
        return inputSource;
    }

    public org.apache.tools.ant.types.Path getCatalogPath() {
        return l().u;
    }

    public final org.apache.tools.ant.types.Path getClasspath() {
        return l().t;
    }

    public final org.xml.sax.InputSource h(org.apache.tools.ant.types.ResourceLocation resourceLocation) {
        java.net.URL fileURL;
        java.net.URL url;
        java.lang.String fromURI;
        java.lang.String replace = resourceLocation.getLocation().replace(java.io.File.separatorChar, '/');
        if (resourceLocation.getBase() != null) {
            fileURL = resourceLocation.getBase();
        } else {
            try {
                fileURL = w.getFileURL(getProject().getBaseDir());
            } catch (java.net.MalformedURLException unused) {
                throw new org.apache.tools.ant.BuildException("Project basedir cannot be converted to a URL");
            }
        }
        try {
            url = new java.net.URL(fileURL, replace);
        } catch (java.net.MalformedURLException unused2) {
            java.io.File file = new java.io.File(replace);
            if (file.exists() && file.canRead()) {
                log("uri : '" + replace + "' matches a readable file", 4);
                try {
                    url = w.getFileURL(file);
                } catch (java.net.MalformedURLException unused3) {
                    throw new org.apache.tools.ant.BuildException("could not find an URL for :" + file.getAbsolutePath());
                }
            } else {
                log("uri : '" + replace + "' does not match a readable file", 4);
                url = null;
            }
        }
        if (url == null || !url.getProtocol().equals("file") || (fromURI = w.fromURI(url.toString())) == null) {
            return null;
        }
        log("fileName " + fromURI, 4);
        java.io.File file2 = new java.io.File(fromURI);
        if (!file2.exists() || !file2.canRead()) {
            return null;
        }
        try {
            org.xml.sax.InputSource inputSource = new org.xml.sax.InputSource(new java.io.FileInputStream(file2));
            try {
                java.lang.String systemId = org.apache.tools.ant.util.JAXPUtils.getSystemId(file2);
                inputSource.setSystemId(systemId);
                log("catalog entry matched a readable file: '" + systemId + "'", 4);
            } catch (java.io.IOException unused4) {
            }
            return inputSource;
        } catch (java.io.IOException unused5) {
            return null;
        }
    }

    public final org.apache.tools.ant.types.ResourceLocation i(java.lang.String str) {
        java.util.Iterator<org.apache.tools.ant.types.ResourceLocation> it = k().iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.types.ResourceLocation next = it.next();
            if (next.getPublicId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public final org.apache.tools.ant.types.XMLCatalog.CatalogResolver j() {
        if (this.v == null) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(APACHE_RESOLVER, true, java.lang.Class.forName(CATALOG_RESOLVER, true, java.lang.Class.forName(APACHE_RESOLVER, true, getProject().createClassLoader(org.apache.tools.ant.types.Path.systemClasspath)).getClassLoader()).getClassLoader());
                this.v = new org.apache.tools.ant.types.XMLCatalog.ExternalResolver(cls, cls.newInstance());
            } catch (java.lang.Throwable th) {
                this.v = new org.apache.tools.ant.types.XMLCatalog.InternalResolver();
                if (getCatalogPath() != null && getCatalogPath().list().length != 0) {
                    log("Warning: XML resolver not found; external catalogs will be ignored", 1);
                }
                log("Failed to load Apache resolver: " + th, 4);
            }
        }
        return this.v;
    }

    public final java.util.Vector<org.apache.tools.ant.types.ResourceLocation> k() {
        return l().n;
    }

    public final org.apache.tools.ant.types.XMLCatalog l() {
        return !isReference() ? this : (org.apache.tools.ant.types.XMLCatalog) getCheckedRef(org.apache.tools.ant.types.XMLCatalog.class, "xmlcatalog");
    }

    public final java.lang.String m(java.lang.String str) {
        int indexOf = str.indexOf("#");
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }

    public final void n(javax.xml.transform.sax.SAXSource sAXSource) throws javax.xml.transform.TransformerException {
        org.xml.sax.XMLReader xMLReader = sAXSource.getXMLReader();
        if (xMLReader == null) {
            javax.xml.parsers.SAXParserFactory newInstance = javax.xml.parsers.SAXParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            try {
                xMLReader = newInstance.newSAXParser().getXMLReader();
            } catch (javax.xml.parsers.ParserConfigurationException e) {
                throw new javax.xml.transform.TransformerException(e);
            } catch (org.xml.sax.SAXException e2) {
                throw new javax.xml.transform.TransformerException(e2);
            }
        }
        xMLReader.setEntityResolver(this);
        sAXSource.setXMLReader(xMLReader);
    }

    public final org.xml.sax.InputSource o(org.apache.tools.ant.types.ResourceLocation resourceLocation) {
        java.net.URL fileURL;
        java.net.URL url;
        java.io.InputStream inputStream;
        java.lang.String location = resourceLocation.getLocation();
        if (resourceLocation.getBase() != null) {
            fileURL = resourceLocation.getBase();
        } else {
            try {
                fileURL = w.getFileURL(getProject().getBaseDir());
            } catch (java.net.MalformedURLException unused) {
                throw new org.apache.tools.ant.BuildException("Project basedir cannot be converted to a URL");
            }
        }
        try {
            url = new java.net.URL(fileURL, location);
        } catch (java.net.MalformedURLException unused2) {
            url = null;
        }
        if (url == null) {
            return null;
        }
        try {
            java.net.URLConnection openConnection = url.openConnection();
            if (openConnection != null) {
                openConnection.setUseCaches(false);
                inputStream = openConnection.getInputStream();
            } else {
                inputStream = null;
            }
            if (inputStream == null) {
                return null;
            }
            org.xml.sax.InputSource inputSource = new org.xml.sax.InputSource(inputStream);
            try {
                java.lang.String externalForm = url.toExternalForm();
                inputSource.setSystemId(externalForm);
                log("catalog entry matched as a URL: '" + externalForm + "'", 4);
            } catch (java.io.IOException unused3) {
            }
            return inputSource;
        } catch (java.io.IOException unused4) {
            return null;
        }
    }

    @Override // javax.xml.transform.URIResolver
    public javax.xml.transform.Source resolve(java.lang.String str, java.lang.String str2) throws javax.xml.transform.TransformerException {
        if (isReference()) {
            return l().resolve(str, str2);
        }
        dieOnCircularReference();
        java.lang.String m = m(str);
        log("resolve: '" + m + "' with base: '" + str2 + "'", 4);
        javax.xml.transform.sax.SAXSource sAXSource = (javax.xml.transform.sax.SAXSource) j().resolve(m, str2);
        if (sAXSource == null) {
            log("No matching catalog entry found, parser will use: '" + str + "'", 4);
            sAXSource = new javax.xml.transform.sax.SAXSource();
            try {
                java.net.URL fileURL = str2 == null ? w.getFileURL(getProject().getBaseDir()) : new java.net.URL(str2);
                if (m.length() != 0) {
                    fileURL = new java.net.URL(fileURL, m);
                }
                sAXSource.setInputSource(new org.xml.sax.InputSource(fileURL.toString()));
            } catch (java.net.MalformedURLException unused) {
                sAXSource.setInputSource(new org.xml.sax.InputSource(m));
            }
        }
        n(sAXSource);
        return sAXSource;
    }

    @Override // org.xml.sax.EntityResolver
    public org.xml.sax.InputSource resolveEntity(java.lang.String str, java.lang.String str2) throws org.xml.sax.SAXException, java.io.IOException {
        if (isReference()) {
            return l().resolveEntity(str, str2);
        }
        dieOnCircularReference();
        log("resolveEntity: '" + str + "': '" + str2 + "'", 4);
        org.xml.sax.InputSource resolveEntity = j().resolveEntity(str, str2);
        if (resolveEntity == null) {
            log("No matching catalog entry found, parser will use: '" + str2 + "'", 4);
        }
        return resolveEntity;
    }

    public void setCatalogPathRef(org.apache.tools.ant.types.Reference reference) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        createCatalogPath().setRefid(reference);
        setChecked(false);
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        org.apache.tools.ant.types.Path path2 = this.t;
        if (path2 == null) {
            this.t = path;
        } else {
            path2.append(path);
        }
        setChecked(false);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        createClasspath().setRefid(reference);
        setChecked(false);
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (!this.n.isEmpty()) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }
}
