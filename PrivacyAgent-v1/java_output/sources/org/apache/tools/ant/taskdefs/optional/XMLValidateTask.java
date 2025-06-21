package org.apache.tools.ant.taskdefs.optional;

/* loaded from: classes25.dex */
public class XMLValidateTask extends org.apache.tools.ant.Task {
    protected static final java.lang.String INIT_FAILED_MSG = "Could not start xml validation: ";
    public static final java.lang.String MESSAGE_FILES_VALIDATED = " file(s) have been successfully validated.";
    public static final org.apache.tools.ant.util.FileUtils y = org.apache.tools.ant.util.FileUtils.getFileUtils();
    protected org.apache.tools.ant.types.Path classpath;
    protected boolean failOnError = true;
    protected boolean warn = true;
    protected boolean lenient = false;
    protected java.lang.String readerClassName = null;
    protected java.io.File file = null;
    protected java.util.Vector<org.apache.tools.ant.types.FileSet> filesets = new java.util.Vector<>();
    protected org.xml.sax.XMLReader xmlReader = null;
    protected org.apache.tools.ant.taskdefs.optional.XMLValidateTask.ValidatorErrorHandler errorHandler = new org.apache.tools.ant.taskdefs.optional.XMLValidateTask.ValidatorErrorHandler();
    public java.util.Vector<org.apache.tools.ant.taskdefs.optional.XMLValidateTask.Attribute> u = new java.util.Vector<>();
    public final java.util.Vector<org.apache.tools.ant.taskdefs.optional.XMLValidateTask.Property> v = new java.util.Vector<>();
    public org.apache.tools.ant.types.XMLCatalog w = new org.apache.tools.ant.types.XMLCatalog();
    public org.apache.tools.ant.AntClassLoader x = null;

    public static class Attribute {
        public java.lang.String a = null;
        public boolean b;

        public java.lang.String getName() {
            return this.a;
        }

        public boolean getValue() {
            return this.b;
        }

        public void setName(java.lang.String str) {
            this.a = str;
        }

        public void setValue(boolean z) {
            this.b = z;
        }
    }

    public static final class Property {
        public java.lang.String a;
        public java.lang.String b;

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

    public class ValidatorErrorHandler implements org.xml.sax.ErrorHandler {
        protected java.io.File currentFile = null;
        protected java.lang.String lastErrorMessage = null;
        protected boolean failed = false;

        public ValidatorErrorHandler() {
        }

        public final void a(org.xml.sax.SAXParseException sAXParseException, int i) {
            org.apache.tools.ant.taskdefs.optional.XMLValidateTask.this.log(b(sAXParseException), i);
        }

        public final java.lang.String b(org.xml.sax.SAXParseException sAXParseException) {
            java.lang.String systemId = sAXParseException.getSystemId();
            if (systemId == null) {
                return sAXParseException.getMessage();
            }
            if (systemId.startsWith("file:")) {
                try {
                    systemId = org.apache.tools.ant.taskdefs.optional.XMLValidateTask.y.fromURI(systemId);
                } catch (java.lang.Exception unused) {
                }
            }
            int lineNumber = sAXParseException.getLineNumber();
            int columnNumber = sAXParseException.getColumnNumber();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(systemId);
            java.lang.String str = "";
            if (lineNumber != -1) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb2.append(lineNumber);
                if (columnNumber != -1) {
                    str = com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + columnNumber;
                }
                sb2.append(str);
                str = sb2.toString();
            }
            sb.append(str);
            sb.append(": ");
            sb.append(sAXParseException.getMessage());
            return sb.toString();
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(org.xml.sax.SAXParseException sAXParseException) {
            this.failed = true;
            a(sAXParseException, 0);
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(org.xml.sax.SAXParseException sAXParseException) {
            this.failed = true;
            a(sAXParseException, 0);
        }

        public boolean getFailure() {
            return this.failed;
        }

        public void init(java.io.File file) {
            this.currentFile = file;
            this.failed = false;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(org.xml.sax.SAXParseException sAXParseException) {
            if (org.apache.tools.ant.taskdefs.optional.XMLValidateTask.this.warn) {
                a(sAXParseException, 1);
            }
        }
    }

    public void addConfiguredXMLCatalog(org.apache.tools.ant.types.XMLCatalog xMLCatalog) {
        this.w.addConfiguredXMLCatalog(xMLCatalog);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        this.filesets.addElement(fileSet);
    }

    public void cleanup() {
        org.apache.tools.ant.AntClassLoader antClassLoader = this.x;
        if (antClassLoader != null) {
            antClassLoader.cleanup();
            this.x = null;
        }
    }

    public org.apache.tools.ant.taskdefs.optional.XMLValidateTask.Attribute createAttribute() {
        org.apache.tools.ant.taskdefs.optional.XMLValidateTask.Attribute attribute = new org.apache.tools.ant.taskdefs.optional.XMLValidateTask.Attribute();
        this.u.addElement(attribute);
        return attribute;
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.classpath == null) {
            this.classpath = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.classpath.createPath();
    }

    public org.apache.tools.ant.types.DTDLocation createDTD() {
        org.apache.tools.ant.types.DTDLocation dTDLocation = new org.apache.tools.ant.types.DTDLocation();
        this.w.addDTD(dTDLocation);
        return dTDLocation;
    }

    public org.xml.sax.XMLReader createDefaultReader() {
        return org.apache.tools.ant.util.JAXPUtils.getXMLReader();
    }

    public org.apache.tools.ant.taskdefs.optional.XMLValidateTask.Property createProperty() {
        org.apache.tools.ant.taskdefs.optional.XMLValidateTask.Property property = new org.apache.tools.ant.taskdefs.optional.XMLValidateTask.Property();
        this.v.addElement(property);
        return property;
    }

    public org.xml.sax.XMLReader createXmlReader() {
        java.lang.Class<?> cls;
        java.lang.Object newInstance;
        java.lang.String str = this.readerClassName;
        if (str == null) {
            newInstance = d();
        } else {
            try {
                if (this.classpath != null) {
                    org.apache.tools.ant.AntClassLoader createClassLoader = getProject().createClassLoader(this.classpath);
                    this.x = createClassLoader;
                    cls = java.lang.Class.forName(this.readerClassName, true, createClassLoader);
                } else {
                    cls = java.lang.Class.forName(str);
                }
                newInstance = cls.newInstance();
            } catch (java.lang.ClassNotFoundException e) {
                throw new org.apache.tools.ant.BuildException(INIT_FAILED_MSG + this.readerClassName, e);
            } catch (java.lang.IllegalAccessException e2) {
                throw new org.apache.tools.ant.BuildException(INIT_FAILED_MSG + this.readerClassName, e2);
            } catch (java.lang.InstantiationException e3) {
                throw new org.apache.tools.ant.BuildException(INIT_FAILED_MSG + this.readerClassName, e3);
            }
        }
        if (newInstance instanceof org.xml.sax.XMLReader) {
            org.xml.sax.XMLReader xMLReader = (org.xml.sax.XMLReader) newInstance;
            log("Using SAX2 reader " + newInstance.getClass().getName(), 3);
            return xMLReader;
        }
        if (!(newInstance instanceof org.xml.sax.Parser)) {
            throw new org.apache.tools.ant.BuildException(INIT_FAILED_MSG + newInstance.getClass().getName() + " implements nor SAX1 Parser nor SAX2 XMLReader.");
        }
        org.xml.sax.helpers.ParserAdapter parserAdapter = new org.xml.sax.helpers.ParserAdapter((org.xml.sax.Parser) newInstance);
        log("Using SAX1 parser " + newInstance.getClass().getName(), 3);
        return parserAdapter;
    }

    public final java.lang.Object d() {
        try {
            return createDefaultReader();
        } catch (org.apache.tools.ant.BuildException unused) {
            return org.apache.tools.ant.util.JAXPUtils.getParser();
        }
    }

    public boolean doValidate(java.io.File file) {
        boolean z;
        initValidator();
        try {
            log("Validating " + file.getName() + "... ", 3);
            this.errorHandler.init(file);
            org.xml.sax.InputSource inputSource = new org.xml.sax.InputSource(new java.io.FileInputStream(file));
            inputSource.setSystemId(y.toURI(file.getAbsolutePath()));
            this.xmlReader.parse(inputSource);
            z = true;
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Could not validate document " + file, e);
        } catch (org.xml.sax.SAXException e2) {
            log("Caught when validating: " + e2.toString(), 4);
            if (this.failOnError) {
                throw new org.apache.tools.ant.BuildException("Could not validate document " + file);
            }
            log("Could not validate document " + file + ": " + e2.toString());
            z = false;
        }
        if (!this.errorHandler.getFailure()) {
            return z;
        }
        if (this.failOnError) {
            throw new org.apache.tools.ant.BuildException(file + " is not a valid XML document.");
        }
        log(file + " is not a valid XML document", 0);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006a A[Catch: all -> 0x009e, TryCatch #0 {all -> 0x009e, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000d, B:8:0x0014, B:10:0x0015, B:12:0x001a, B:14:0x0020, B:16:0x0028, B:18:0x0030, B:19:0x005e, B:20:0x0064, B:22:0x006a, B:25:0x0080, B:29:0x0097, B:32:0x0037, B:34:0x0053, B:35:0x0057, B:36:0x005c), top: B:1:0x0000 }] */
    @Override // org.apache.tools.ant.Task
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() throws org.apache.tools.ant.BuildException {
        int i;
        java.util.Iterator<org.apache.tools.ant.types.FileSet> it;
        try {
            if (this.file == null && this.filesets.size() == 0) {
                throw new org.apache.tools.ant.BuildException("Specify at least one source - a file or a fileset.");
            }
            java.io.File file = this.file;
            if (file != null) {
                if (file.exists() && this.file.canRead() && this.file.isFile()) {
                    doValidate(this.file);
                    i = 1;
                    it = this.filesets.iterator();
                    while (it.hasNext()) {
                        org.apache.tools.ant.types.FileSet next = it.next();
                        for (java.lang.String str : next.getDirectoryScanner(getProject()).getIncludedFiles()) {
                            doValidate(new java.io.File(next.getDir(getProject()), str));
                            i++;
                        }
                    }
                    onSuccessfulValidation(i);
                }
                java.lang.String str2 = "File " + this.file + " cannot be read";
                if (this.failOnError) {
                    throw new org.apache.tools.ant.BuildException(str2);
                }
                log(str2, 0);
            }
            i = 0;
            it = this.filesets.iterator();
            while (it.hasNext()) {
            }
            onSuccessfulValidation(i);
        } finally {
            cleanup();
        }
    }

    public org.xml.sax.EntityResolver getEntityResolver() {
        return this.w;
    }

    public org.xml.sax.XMLReader getXmlReader() {
        return this.xmlReader;
    }

    @Override // org.apache.tools.ant.Task
    public void init() throws org.apache.tools.ant.BuildException {
        super.init();
        this.w.setProject(getProject());
    }

    public void initValidator() {
        org.xml.sax.XMLReader createXmlReader = createXmlReader();
        this.xmlReader = createXmlReader;
        createXmlReader.setEntityResolver(getEntityResolver());
        this.xmlReader.setErrorHandler(this.errorHandler);
        if (isSax1Parser()) {
            return;
        }
        if (!this.lenient) {
            setFeature(org.apache.tools.ant.util.XmlConstants.FEATURE_VALIDATION, true);
        }
        java.util.Iterator<org.apache.tools.ant.taskdefs.optional.XMLValidateTask.Attribute> it = this.u.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.taskdefs.optional.XMLValidateTask.Attribute next = it.next();
            setFeature(next.getName(), next.getValue());
        }
        java.util.Iterator<org.apache.tools.ant.taskdefs.optional.XMLValidateTask.Property> it2 = this.v.iterator();
        while (it2.hasNext()) {
            org.apache.tools.ant.taskdefs.optional.XMLValidateTask.Property next2 = it2.next();
            setProperty(next2.getName(), next2.getValue());
        }
    }

    public boolean isSax1Parser() {
        return this.xmlReader instanceof org.xml.sax.helpers.ParserAdapter;
    }

    public void onSuccessfulValidation(int i) {
        log(i + MESSAGE_FILES_VALIDATED);
    }

    public void setClassName(java.lang.String str) {
        this.readerClassName = str;
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.classpath;
        if (path2 == null) {
            this.classpath = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setFailOnError(boolean z) {
        this.failOnError = z;
    }

    public void setFeature(java.lang.String str, boolean z) throws org.apache.tools.ant.BuildException {
        log("Setting feature " + str + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + z, 4);
        try {
            this.xmlReader.setFeature(str, z);
        } catch (org.xml.sax.SAXNotRecognizedException e) {
            throw new org.apache.tools.ant.BuildException("Parser " + this.xmlReader.getClass().getName() + " doesn't recognize feature " + str, e, getLocation());
        } catch (org.xml.sax.SAXNotSupportedException e2) {
            throw new org.apache.tools.ant.BuildException("Parser " + this.xmlReader.getClass().getName() + " doesn't support feature " + str, e2, getLocation());
        }
    }

    public void setFile(java.io.File file) {
        this.file = file;
    }

    public void setLenient(boolean z) {
        this.lenient = z;
    }

    public void setProperty(java.lang.String str, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        if (str == null || str2 == null) {
            throw new org.apache.tools.ant.BuildException("Property name and value must be specified.");
        }
        try {
            this.xmlReader.setProperty(str, str2);
        } catch (org.xml.sax.SAXNotRecognizedException e) {
            throw new org.apache.tools.ant.BuildException("Parser " + this.xmlReader.getClass().getName() + " doesn't recognize property " + str, e, getLocation());
        } catch (org.xml.sax.SAXNotSupportedException e2) {
            throw new org.apache.tools.ant.BuildException("Parser " + this.xmlReader.getClass().getName() + " doesn't support property " + str, e2, getLocation());
        }
    }

    public void setWarn(boolean z) {
        this.warn = z;
    }
}
