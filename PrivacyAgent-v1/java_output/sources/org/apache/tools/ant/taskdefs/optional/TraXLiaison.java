package org.apache.tools.ant.taskdefs.optional;

/* loaded from: classes25.dex */
public class TraXLiaison implements org.apache.tools.ant.taskdefs.XSLTLiaison4, javax.xml.transform.ErrorListener, org.apache.tools.ant.taskdefs.XSLTLoggerAware {
    public static final org.apache.tools.ant.util.FileUtils q = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public org.apache.tools.ant.Project a;
    public org.apache.tools.ant.types.Resource d;
    public org.apache.tools.ant.taskdefs.XSLTLogger e;
    public org.xml.sax.EntityResolver f;
    public javax.xml.transform.Transformer g;
    public javax.xml.transform.Templates h;
    public long i;
    public javax.xml.transform.URIResolver j;
    public java.lang.String b = null;
    public javax.xml.transform.TransformerFactory c = null;
    public final java.util.Vector<java.lang.String[]> k = new java.util.Vector<>();
    public final java.util.Hashtable<java.lang.String, java.lang.Object> l = new java.util.Hashtable<>();
    public final java.util.List<java.lang.Object[]> m = new java.util.ArrayList();
    public final java.util.Map<java.lang.String, java.lang.Boolean> n = new java.util.HashMap();
    public boolean o = false;
    public org.apache.tools.ant.taskdefs.XSLTProcess.TraceConfiguration p = null;

    public final void a() {
        if (!org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7) || org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion("9")) {
            return;
        }
        try {
            java.lang.reflect.Field declaredField = this.c.getClass().getDeclaredField("_isNotSecureProcessing");
            declaredField.setAccessible(true);
            declaredField.set(this.c, java.lang.Boolean.TRUE);
        } catch (java.lang.Exception e) {
            org.apache.tools.ant.Project project = this.a;
            if (project != null) {
                project.log(e.toString(), 4);
            }
        }
    }

    @Override // org.apache.tools.ant.taskdefs.XSLTLiaison4
    public void addParam(java.lang.String str, java.lang.Object obj) {
        this.l.put(str, obj);
    }

    @Override // org.apache.tools.ant.taskdefs.XSLTLiaison
    public void addParam(java.lang.String str, java.lang.String str2) {
        this.l.put(str, str2);
    }

    public final void b() throws java.io.IOException, javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException, javax.xml.transform.TransformerException {
        if (this.h == null) {
            g();
        }
        javax.xml.transform.Transformer newTransformer = this.h.newTransformer();
        this.g = newTransformer;
        newTransformer.setErrorListener(this);
        javax.xml.transform.URIResolver uRIResolver = this.j;
        if (uRIResolver != null) {
            this.g.setURIResolver(uRIResolver);
        }
        java.util.Iterator<java.lang.String[]> it = this.k.iterator();
        while (it.hasNext()) {
            java.lang.String[] next = it.next();
            this.g.setOutputProperty(next[0], next[1]);
        }
        if (this.p != null) {
            if (!"org.apache.xalan.transformer.TransformerImpl".equals(this.g.getClass().getName())) {
                java.lang.String str = "Not enabling trace support for transformer implementation" + this.g.getClass().getName();
                org.apache.tools.ant.Project project = this.a;
                if (project != null) {
                    project.log(str, 1);
                    return;
                } else {
                    java.lang.System.err.println(str);
                    return;
                }
            }
            try {
                ((org.apache.tools.ant.taskdefs.optional.XSLTTraceSupport) java.lang.Class.forName("org.apache.tools.ant.taskdefs.optional.Xalan2TraceSupport", true, java.lang.Thread.currentThread().getContextClassLoader()).newInstance()).configureTrace(this.g, this.p);
            } catch (java.lang.Exception e) {
                java.lang.String str2 = "Failed to enable tracing because of " + e;
                org.apache.tools.ant.Project project2 = this.a;
                if (project2 != null) {
                    project2.log(str2, 1);
                } else {
                    java.lang.System.err.println(str2);
                }
            }
        }
    }

    public final javax.xml.transform.TransformerFactory c() throws org.apache.tools.ant.BuildException {
        java.lang.Class<?> cls;
        javax.xml.transform.TransformerFactory transformerFactory = this.c;
        if (transformerFactory != null) {
            return transformerFactory;
        }
        java.lang.String str = this.b;
        try {
            if (str == null) {
                this.c = javax.xml.transform.TransformerFactory.newInstance();
            } else {
                try {
                    cls = java.lang.Class.forName(str, true, java.lang.Thread.currentThread().getContextClassLoader());
                } catch (java.lang.ClassNotFoundException unused) {
                    java.lang.String str2 = "Failed to load " + this.b + " via the configured classpath, will try Ant's classpath instead.";
                    org.apache.tools.ant.taskdefs.XSLTLogger xSLTLogger = this.e;
                    if (xSLTLogger != null) {
                        xSLTLogger.log(str2);
                    } else {
                        org.apache.tools.ant.Project project = this.a;
                        if (project != null) {
                            project.log(str2, 1);
                        } else {
                            java.lang.System.err.println(str2);
                        }
                    }
                    cls = null;
                }
                if (cls == null) {
                    cls = java.lang.Class.forName(this.b);
                }
                this.c = (javax.xml.transform.TransformerFactory) cls.newInstance();
            }
            a();
            this.c.setErrorListener(this);
            this.m.size();
            for (java.lang.Object[] objArr : this.m) {
                this.c.setAttribute((java.lang.String) objArr[0], objArr[1]);
            }
            for (java.util.Map.Entry<java.lang.String, java.lang.Boolean> entry : this.n.entrySet()) {
                try {
                    this.c.setFeature(entry.getKey(), entry.getValue().booleanValue());
                } catch (javax.xml.transform.TransformerConfigurationException e) {
                    throw new org.apache.tools.ant.BuildException(e);
                }
            }
            javax.xml.transform.URIResolver uRIResolver = this.j;
            if (uRIResolver != null) {
                this.c.setURIResolver(uRIResolver);
            }
            return this.c;
        } catch (java.lang.Exception e2) {
            throw new org.apache.tools.ant.BuildException(e2);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.XSLTLiaison2
    public void configure(org.apache.tools.ant.taskdefs.XSLTProcess xSLTProcess) {
        this.a = xSLTProcess.getProject();
        org.apache.tools.ant.taskdefs.XSLTProcess.Factory factory = xSLTProcess.getFactory();
        if (factory != null) {
            setFactory(factory.getName());
            java.util.Iterator it = java.util.Collections.list(factory.getAttributes()).iterator();
            while (it.hasNext()) {
                org.apache.tools.ant.taskdefs.XSLTProcess.Factory.Attribute attribute = (org.apache.tools.ant.taskdefs.XSLTProcess.Factory.Attribute) it.next();
                setAttribute(attribute.getName(), attribute.getValue());
            }
            for (org.apache.tools.ant.taskdefs.XSLTProcess.Factory.Feature feature : factory.getFeatures()) {
                setFeature(feature.getName(), feature.getValue());
            }
        }
        org.apache.tools.ant.types.XMLCatalog xMLCatalog = xSLTProcess.getXMLCatalog();
        if (xMLCatalog != null) {
            setEntityResolver(xMLCatalog);
            setURIResolver(xMLCatalog);
        }
        java.util.Iterator it2 = java.util.Collections.list(xSLTProcess.getOutputProperties()).iterator();
        while (it2.hasNext()) {
            org.apache.tools.ant.taskdefs.XSLTProcess.OutputProperty outputProperty = (org.apache.tools.ant.taskdefs.XSLTProcess.OutputProperty) it2.next();
            setOutputProperty(outputProperty.getName(), outputProperty.getValue());
        }
        this.o = xSLTProcess.getSuppressWarnings();
        this.p = xSLTProcess.getTraceConfiguration();
    }

    public final javax.xml.transform.Source d(java.io.InputStream inputStream, java.io.File file) throws javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {
        javax.xml.transform.Source streamSource;
        if (this.f == null) {
            streamSource = new javax.xml.transform.stream.StreamSource(inputStream);
        } else {
            if (!c().getFeature("http://javax.xml.transform.sax.SAXSource/feature")) {
                throw new java.lang.IllegalStateException("xcatalog specified, but parser doesn't support SAX");
            }
            javax.xml.parsers.SAXParserFactory newInstance = javax.xml.parsers.SAXParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            org.xml.sax.XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
            xMLReader.setEntityResolver(this.f);
            streamSource = new javax.xml.transform.sax.SAXSource(xMLReader, new org.xml.sax.InputSource(inputStream));
        }
        streamSource.setSystemId(org.apache.tools.ant.util.JAXPUtils.getSystemId(file));
        return streamSource;
    }

    public final javax.xml.transform.Source e(java.io.InputStream inputStream, org.apache.tools.ant.types.Resource resource) throws javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {
        javax.xml.transform.Source streamSource;
        if (this.f == null) {
            streamSource = new javax.xml.transform.stream.StreamSource(inputStream);
        } else {
            if (!c().getFeature("http://javax.xml.transform.sax.SAXSource/feature")) {
                throw new java.lang.IllegalStateException("xcatalog specified, but parser doesn't support SAX");
            }
            javax.xml.parsers.SAXParserFactory newInstance = javax.xml.parsers.SAXParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            org.xml.sax.XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
            xMLReader.setEntityResolver(this.f);
            streamSource = new javax.xml.transform.sax.SAXSource(xMLReader, new org.xml.sax.InputSource(inputStream));
        }
        streamSource.setSystemId(h(resource));
        return streamSource;
    }

    @Override // javax.xml.transform.ErrorListener
    public void error(javax.xml.transform.TransformerException transformerException) {
        f(transformerException, "Error");
    }

    public final void f(javax.xml.transform.TransformerException transformerException, java.lang.String str) {
        if (this.e == null) {
            return;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        javax.xml.transform.SourceLocator locator = transformerException.getLocator();
        if (locator != null) {
            java.lang.String systemId = locator.getSystemId();
            if (systemId != null) {
                if (systemId.startsWith("file:")) {
                    systemId = org.apache.tools.ant.util.FileUtils.getFileUtils().fromURI(systemId);
                }
                stringBuffer.append(systemId);
            } else {
                stringBuffer.append("Unknown file");
            }
            int lineNumber = locator.getLineNumber();
            if (lineNumber != -1) {
                stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                stringBuffer.append(lineNumber);
                int columnNumber = locator.getColumnNumber();
                if (columnNumber != -1) {
                    stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    stringBuffer.append(columnNumber);
                }
            }
        }
        stringBuffer.append(": ");
        stringBuffer.append(str);
        stringBuffer.append("! ");
        stringBuffer.append(transformerException.getMessage());
        if (transformerException.getCause() != null) {
            stringBuffer.append(" Cause: ");
            stringBuffer.append(transformerException.getCause());
        }
        this.e.log(stringBuffer.toString());
    }

    @Override // javax.xml.transform.ErrorListener
    public void fatalError(javax.xml.transform.TransformerException transformerException) {
        f(transformerException, "Fatal Error");
        throw new org.apache.tools.ant.BuildException("Fatal error during transformation using " + this.d + ": " + transformerException.getMessageAndLocation(), transformerException);
    }

    public final void g() throws java.io.IOException, javax.xml.transform.TransformerConfigurationException, javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {
        java.io.BufferedInputStream bufferedInputStream;
        java.lang.Throwable th;
        try {
            bufferedInputStream = new java.io.BufferedInputStream(this.d.getInputStream());
            try {
                this.i = this.d.getLastModified();
                this.h = c().newTemplates(e(bufferedInputStream, this.d));
                bufferedInputStream.close();
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            bufferedInputStream = null;
            th = th3;
        }
    }

    @java.lang.Deprecated
    public java.lang.String getSystemId(java.io.File file) {
        return org.apache.tools.ant.util.JAXPUtils.getSystemId(file);
    }

    public final java.lang.String h(org.apache.tools.ant.types.Resource resource) {
        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
        if (fileProvider != null) {
            return q.toURI(fileProvider.getFile().getAbsolutePath());
        }
        org.apache.tools.ant.types.resources.URLProvider uRLProvider = (org.apache.tools.ant.types.resources.URLProvider) resource.as(org.apache.tools.ant.types.resources.URLProvider.class);
        return uRLProvider != null ? java.lang.String.valueOf(uRLProvider.getURL()) : resource.getName();
    }

    public final void i() {
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : this.l.entrySet()) {
            this.g.setParameter(entry.getKey(), entry.getValue());
        }
    }

    public void setAttribute(java.lang.String str, java.lang.Object obj) {
        this.m.add(new java.lang.Object[]{str, obj});
    }

    public void setEntityResolver(org.xml.sax.EntityResolver entityResolver) {
        this.f = entityResolver;
    }

    public void setFactory(java.lang.String str) {
        this.b = str;
    }

    public void setFeature(java.lang.String str, boolean z) {
        this.n.put(str, java.lang.Boolean.valueOf(z));
    }

    @Override // org.apache.tools.ant.taskdefs.XSLTLoggerAware
    public void setLogger(org.apache.tools.ant.taskdefs.XSLTLogger xSLTLogger) {
        this.e = xSLTLogger;
    }

    public void setOutputProperty(java.lang.String str, java.lang.String str2) {
        this.k.addElement(new java.lang.String[]{str, str2});
    }

    @Override // org.apache.tools.ant.taskdefs.XSLTLiaison
    public void setStylesheet(java.io.File file) throws java.lang.Exception {
        org.apache.tools.ant.types.resources.FileResource fileResource = new org.apache.tools.ant.types.resources.FileResource();
        fileResource.setProject(this.a);
        fileResource.setFile(file);
        setStylesheet(fileResource);
    }

    @Override // org.apache.tools.ant.taskdefs.XSLTLiaison3
    public void setStylesheet(org.apache.tools.ant.types.Resource resource) throws java.lang.Exception {
        org.apache.tools.ant.types.Resource resource2 = this.d;
        if (resource2 != null) {
            this.g = null;
            if (!resource2.equals(resource) || resource.getLastModified() != this.i) {
                this.h = null;
            }
        }
        this.d = resource;
    }

    public void setURIResolver(javax.xml.transform.URIResolver uRIResolver) {
        this.j = uRIResolver;
    }

    @Override // org.apache.tools.ant.taskdefs.XSLTLiaison
    public void transform(java.io.File file, java.io.File file2) throws java.lang.Exception {
        java.io.BufferedOutputStream bufferedOutputStream;
        if (this.g == null) {
            b();
        }
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
            try {
                bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file2));
                try {
                    javax.xml.transform.stream.StreamResult streamResult = new javax.xml.transform.stream.StreamResult(bufferedOutputStream);
                    streamResult.setSystemId(org.apache.tools.ant.util.JAXPUtils.getSystemId(file2));
                    javax.xml.transform.Source d = d(bufferedInputStream2, file);
                    i();
                    this.g.transform(d, streamResult);
                    org.apache.tools.ant.util.FileUtils.close(bufferedInputStream2);
                    org.apache.tools.ant.util.FileUtils.close(bufferedOutputStream);
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    org.apache.tools.ant.util.FileUtils.close(bufferedInputStream);
                    org.apache.tools.ant.util.FileUtils.close(bufferedOutputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    @Override // javax.xml.transform.ErrorListener
    public void warning(javax.xml.transform.TransformerException transformerException) {
        if (this.o) {
            return;
        }
        f(transformerException, com.google.common.net.HttpHeaders.WARNING);
    }
}
