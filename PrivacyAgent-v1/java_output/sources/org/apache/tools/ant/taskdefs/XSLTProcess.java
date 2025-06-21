package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class XSLTProcess extends org.apache.tools.ant.taskdefs.MatchingTask implements org.apache.tools.ant.taskdefs.XSLTLogger {
    public static final java.lang.String PROCESSOR_TRAX = "trax";
    public static final org.apache.tools.ant.util.FileUtils a0 = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.lang.String E;
    public org.apache.tools.ant.taskdefs.XSLTLiaison G;
    public javax.xml.xpath.XPathFactory W;
    public javax.xml.xpath.XPath X;
    public org.apache.tools.ant.taskdefs.XSLTProcess.TraceConfiguration Z;
    public java.io.File u = null;
    public java.io.File v = null;
    public java.lang.String w = null;
    public org.apache.tools.ant.types.Resource x = null;
    public java.lang.String y = ".html";
    public java.lang.String z = null;
    public java.lang.String A = null;
    public final java.util.List<org.apache.tools.ant.taskdefs.XSLTProcess.Param> B = new java.util.ArrayList();
    public java.io.File C = null;
    public java.io.File D = null;
    public org.apache.tools.ant.types.Path F = null;
    public boolean H = false;
    public boolean I = false;
    public final java.util.Vector<org.apache.tools.ant.taskdefs.XSLTProcess.OutputProperty> J = new java.util.Vector<>();
    public final org.apache.tools.ant.types.XMLCatalog K = new org.apache.tools.ant.types.XMLCatalog();
    public boolean L = true;
    public org.apache.tools.ant.taskdefs.XSLTProcess.Factory M = null;
    public boolean N = true;
    public org.apache.tools.ant.AntClassLoader O = null;
    public org.apache.tools.ant.types.Mapper P = null;
    public final org.apache.tools.ant.types.resources.Union Q = new org.apache.tools.ant.types.resources.Union();
    public boolean R = true;
    public boolean S = false;
    public boolean T = true;
    public boolean U = true;
    public boolean V = true;
    public final org.apache.tools.ant.types.CommandlineJava.SysProperties Y = new org.apache.tools.ant.types.CommandlineJava.SysProperties();

    /* renamed from: org.apache.tools.ant.taskdefs.XSLTProcess$1, reason: invalid class name */
    public class AnonymousClass1 implements javax.xml.xpath.XPathVariableResolver {
        public AnonymousClass1() {
        }

        @Override // javax.xml.xpath.XPathVariableResolver
        public java.lang.Object resolveVariable(javax.xml.namespace.QName qName) {
            return org.apache.tools.ant.taskdefs.XSLTProcess.this.getProject().getProperty(qName.toString());
        }
    }

    /* renamed from: org.apache.tools.ant.taskdefs.XSLTProcess$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[org.apache.tools.ant.taskdefs.XSLTProcess.ParamType.values().length];
            a = iArr;
            try {
                iArr[org.apache.tools.ant.taskdefs.XSLTProcess.ParamType.STRING.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[org.apache.tools.ant.taskdefs.XSLTProcess.ParamType.BOOLEAN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[org.apache.tools.ant.taskdefs.XSLTProcess.ParamType.DOUBLE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[org.apache.tools.ant.taskdefs.XSLTProcess.ParamType.INT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[org.apache.tools.ant.taskdefs.XSLTProcess.ParamType.LONG.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public static class Factory {
        public java.lang.String a;
        public final java.util.List<org.apache.tools.ant.taskdefs.XSLTProcess.Factory.Attribute> b = new java.util.ArrayList();
        public final java.util.List<org.apache.tools.ant.taskdefs.XSLTProcess.Factory.Feature> c = new java.util.ArrayList();

        public static class Attribute extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.DynamicConfigurator {
            public java.lang.String n;
            public java.lang.Object t;

            @Override // org.apache.tools.ant.DynamicElement
            public java.lang.Object createDynamicElement(java.lang.String str) throws org.apache.tools.ant.BuildException {
                return null;
            }

            public java.lang.String getName() {
                return this.n;
            }

            public java.lang.Object getValue() {
                return this.t;
            }

            @Override // org.apache.tools.ant.DynamicAttribute
            public void setDynamicAttribute(java.lang.String str, java.lang.String str2) throws org.apache.tools.ant.BuildException {
                if ("name".equalsIgnoreCase(str)) {
                    this.n = str2;
                    return;
                }
                if ("value".equalsIgnoreCase(str)) {
                    if (com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equalsIgnoreCase(str2)) {
                        this.t = java.lang.Boolean.TRUE;
                        return;
                    } else {
                        if (com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equalsIgnoreCase(str2)) {
                            this.t = java.lang.Boolean.FALSE;
                            return;
                        }
                        try {
                            this.t = new java.lang.Integer(str2);
                            return;
                        } catch (java.lang.NumberFormatException unused) {
                            this.t = str2;
                            return;
                        }
                    }
                }
                if ("valueref".equalsIgnoreCase(str)) {
                    this.t = getProject().getReference(str2);
                } else {
                    if ("classloaderforpath".equalsIgnoreCase(str)) {
                        this.t = org.apache.tools.ant.util.ClasspathUtils.getClassLoaderForPath(getProject(), new org.apache.tools.ant.types.Reference(getProject(), str2));
                        return;
                    }
                    throw new org.apache.tools.ant.BuildException("Unsupported attribute: " + str);
                }
            }
        }

        public static class Feature {
            public java.lang.String a;
            public boolean b;

            public Feature() {
            }

            public Feature(java.lang.String str, boolean z) {
                this.a = str;
                this.b = z;
            }

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

        public void addAttribute(org.apache.tools.ant.taskdefs.XSLTProcess.Factory.Attribute attribute) {
            this.b.add(attribute);
        }

        public void addFeature(org.apache.tools.ant.taskdefs.XSLTProcess.Factory.Feature feature) {
            this.c.add(feature);
        }

        public java.util.Enumeration<org.apache.tools.ant.taskdefs.XSLTProcess.Factory.Attribute> getAttributes() {
            return java.util.Collections.enumeration(this.b);
        }

        public java.lang.Iterable<org.apache.tools.ant.taskdefs.XSLTProcess.Factory.Feature> getFeatures() {
            return this.c;
        }

        public java.lang.String getName() {
            return this.a;
        }

        public void setName(java.lang.String str) {
            this.a = str;
        }
    }

    public static class OutputProperty {
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

    public static class Param {
        public java.lang.String a = null;
        public java.lang.String b = null;
        public java.lang.String c;
        public java.lang.Object d;
        public java.lang.Object e;
        public org.apache.tools.ant.Project f;

        public java.lang.String getExpression() throws org.apache.tools.ant.BuildException {
            java.lang.String str = this.b;
            if (str != null) {
                return str;
            }
            throw new org.apache.tools.ant.BuildException("Expression attribute is missing.");
        }

        public java.lang.String getName() throws org.apache.tools.ant.BuildException {
            java.lang.String str = this.a;
            if (str != null) {
                return str;
            }
            throw new org.apache.tools.ant.BuildException("Name attribute is missing.");
        }

        public java.lang.String getType() {
            return this.c;
        }

        public void setExpression(java.lang.String str) {
            this.b = str;
        }

        public void setIf(java.lang.Object obj) {
            this.d = obj;
        }

        public void setIf(java.lang.String str) {
            setIf((java.lang.Object) str);
        }

        public void setName(java.lang.String str) {
            this.a = str;
        }

        public void setProject(org.apache.tools.ant.Project project) {
            this.f = project;
        }

        public void setType(java.lang.String str) {
            this.c = str;
        }

        public void setUnless(java.lang.Object obj) {
            this.e = obj;
        }

        public void setUnless(java.lang.String str) {
            setUnless((java.lang.Object) str);
        }

        public boolean shouldUse() {
            org.apache.tools.ant.PropertyHelper propertyHelper = org.apache.tools.ant.PropertyHelper.getPropertyHelper(this.f);
            return propertyHelper.testIfCondition(this.d) && propertyHelper.testUnlessCondition(this.e);
        }
    }

    public enum ParamType {
        STRING,
        BOOLEAN,
        INT,
        LONG,
        DOUBLE,
        XPATH_STRING,
        XPATH_BOOLEAN,
        XPATH_NUMBER,
        XPATH_NODE,
        XPATH_NODESET;

        public static final java.util.Map<org.apache.tools.ant.taskdefs.XSLTProcess.ParamType, javax.xml.namespace.QName> XPATH_TYPES;

        static {
            org.apache.tools.ant.taskdefs.XSLTProcess.ParamType paramType = XPATH_STRING;
            org.apache.tools.ant.taskdefs.XSLTProcess.ParamType paramType2 = XPATH_BOOLEAN;
            org.apache.tools.ant.taskdefs.XSLTProcess.ParamType paramType3 = XPATH_NUMBER;
            org.apache.tools.ant.taskdefs.XSLTProcess.ParamType paramType4 = XPATH_NODE;
            org.apache.tools.ant.taskdefs.XSLTProcess.ParamType paramType5 = XPATH_NODESET;
            java.util.EnumMap enumMap = new java.util.EnumMap(org.apache.tools.ant.taskdefs.XSLTProcess.ParamType.class);
            enumMap.put((java.util.EnumMap) paramType, (org.apache.tools.ant.taskdefs.XSLTProcess.ParamType) javax.xml.xpath.XPathConstants.STRING);
            enumMap.put((java.util.EnumMap) paramType2, (org.apache.tools.ant.taskdefs.XSLTProcess.ParamType) javax.xml.xpath.XPathConstants.BOOLEAN);
            enumMap.put((java.util.EnumMap) paramType3, (org.apache.tools.ant.taskdefs.XSLTProcess.ParamType) javax.xml.xpath.XPathConstants.NUMBER);
            enumMap.put((java.util.EnumMap) paramType4, (org.apache.tools.ant.taskdefs.XSLTProcess.ParamType) javax.xml.xpath.XPathConstants.NODE);
            enumMap.put((java.util.EnumMap) paramType5, (org.apache.tools.ant.taskdefs.XSLTProcess.ParamType) javax.xml.xpath.XPathConstants.NODESET);
            XPATH_TYPES = java.util.Collections.unmodifiableMap(enumMap);
        }
    }

    public class StyleMapper implements org.apache.tools.ant.util.FileNameMapper {
        public StyleMapper() {
        }

        public /* synthetic */ StyleMapper(org.apache.tools.ant.taskdefs.XSLTProcess xSLTProcess, org.apache.tools.ant.taskdefs.XSLTProcess.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.apache.tools.ant.util.FileNameMapper
        public java.lang.String[] mapFileName(java.lang.String str) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf > 0) {
                str = str.substring(0, lastIndexOf);
            }
            return new java.lang.String[]{str + org.apache.tools.ant.taskdefs.XSLTProcess.this.y};
        }

        @Override // org.apache.tools.ant.util.FileNameMapper
        public void setFrom(java.lang.String str) {
        }

        @Override // org.apache.tools.ant.util.FileNameMapper
        public void setTo(java.lang.String str) {
        }
    }

    public final class TraceConfiguration {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;

        public TraceConfiguration() {
        }

        public boolean getElements() {
            return this.a;
        }

        public boolean getExtension() {
            return this.b;
        }

        public boolean getGeneration() {
            return this.c;
        }

        public java.io.OutputStream getOutputStream() {
            return new org.apache.tools.ant.taskdefs.LogOutputStream(org.apache.tools.ant.taskdefs.XSLTProcess.this);
        }

        public boolean getSelection() {
            return this.d;
        }

        public boolean getTemplates() {
            return this.e;
        }

        public void setElements(boolean z) {
            this.a = z;
        }

        public void setExtension(boolean z) {
            this.b = z;
        }

        public void setGeneration(boolean z) {
            this.c = z;
        }

        public void setSelection(boolean z) {
            this.d = z;
        }

        public void setTemplates(boolean z) {
            this.e = z;
        }
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        this.Q.add(resourceCollection);
    }

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Mapper mapper = new org.apache.tools.ant.types.Mapper(getProject());
        mapper.add(fileNameMapper);
        addMapper(mapper);
    }

    public void addConfiguredStyle(org.apache.tools.ant.types.resources.Resources resources) {
        if (resources.size() != 1) {
            handleError("The style element must be specified with exactly one nested resource.");
        } else {
            setXslResource(resources.iterator().next());
        }
    }

    public void addConfiguredXMLCatalog(org.apache.tools.ant.types.XMLCatalog xMLCatalog) {
        this.K.addConfiguredXMLCatalog(xMLCatalog);
    }

    public void addMapper(org.apache.tools.ant.types.Mapper mapper) {
        if (this.P != null) {
            handleError(org.apache.tools.ant.taskdefs.Expand.ERROR_MULTIPLE_MAPPERS);
        } else {
            this.P = mapper;
        }
    }

    public void addSysproperty(org.apache.tools.ant.types.Environment.Variable variable) {
        this.Y.addVariable(variable);
    }

    public void addSyspropertyset(org.apache.tools.ant.types.PropertySet propertySet) {
        this.Y.addSyspropertyset(propertySet);
    }

    @java.lang.Deprecated
    public void configureLiaison(java.io.File file) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.resources.FileResource fileResource = new org.apache.tools.ant.types.resources.FileResource();
        fileResource.setProject(getProject());
        fileResource.setFile(file);
        configureLiaison(fileResource);
    }

    public void configureLiaison(org.apache.tools.ant.types.Resource resource) throws org.apache.tools.ant.BuildException {
        if (this.H && this.N) {
            return;
        }
        this.H = true;
        try {
            log("Loading stylesheet " + resource, 2);
            org.apache.tools.ant.taskdefs.XSLTLiaison xSLTLiaison = this.G;
            if (xSLTLiaison instanceof org.apache.tools.ant.taskdefs.XSLTLiaison2) {
                ((org.apache.tools.ant.taskdefs.XSLTLiaison2) xSLTLiaison).configure(this);
            }
            org.apache.tools.ant.taskdefs.XSLTLiaison xSLTLiaison2 = this.G;
            if (xSLTLiaison2 instanceof org.apache.tools.ant.taskdefs.XSLTLiaison3) {
                ((org.apache.tools.ant.taskdefs.XSLTLiaison3) xSLTLiaison2).setStylesheet(resource);
            } else {
                org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
                if (fileProvider == null) {
                    handleError(this.G.getClass().toString() + " accepts the stylesheet only as a file");
                    return;
                }
                this.G.setStylesheet(fileProvider.getFile());
            }
            for (org.apache.tools.ant.taskdefs.XSLTProcess.Param param : this.B) {
                if (param.shouldUse()) {
                    java.lang.Object f = f(param);
                    org.apache.tools.ant.taskdefs.XSLTLiaison xSLTLiaison3 = this.G;
                    if (xSLTLiaison3 instanceof org.apache.tools.ant.taskdefs.XSLTLiaison4) {
                        ((org.apache.tools.ant.taskdefs.XSLTLiaison4) xSLTLiaison3).addParam(param.getName(), f);
                    } else {
                        if (f != null && !(f instanceof java.lang.String)) {
                            log("XSLTLiaison '" + this.G.getClass().getName() + "' supports only String parameters. Converting parameter '" + param.getName() + "' to its String value '" + f, 1);
                            this.G.addParam(param.getName(), java.lang.String.valueOf(f));
                        }
                        xSLTLiaison3.addParam(param.getName(), (java.lang.String) f);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            log("Failed to transform using stylesheet " + resource, 2);
            handleTransformationError(e);
        }
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.F == null) {
            this.F = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.F.createPath();
    }

    public org.apache.tools.ant.taskdefs.XSLTProcess.Factory createFactory() throws org.apache.tools.ant.BuildException {
        if (this.M != null) {
            handleError("'factory' element must be unique");
        } else {
            this.M = new org.apache.tools.ant.taskdefs.XSLTProcess.Factory();
        }
        return this.M;
    }

    public org.apache.tools.ant.taskdefs.XSLTProcess.OutputProperty createOutputProperty() {
        org.apache.tools.ant.taskdefs.XSLTProcess.OutputProperty outputProperty = new org.apache.tools.ant.taskdefs.XSLTProcess.OutputProperty();
        this.J.addElement(outputProperty);
        return outputProperty;
    }

    public org.apache.tools.ant.taskdefs.XSLTProcess.Param createParam() {
        org.apache.tools.ant.taskdefs.XSLTProcess.Param param = new org.apache.tools.ant.taskdefs.XSLTProcess.Param();
        this.B.add(param);
        return param;
    }

    public org.apache.tools.ant.taskdefs.XSLTProcess.TraceConfiguration createTrace() {
        if (this.Z != null) {
            throw new org.apache.tools.ant.BuildException("can't have more than one trace configuration");
        }
        org.apache.tools.ant.taskdefs.XSLTProcess.TraceConfiguration traceConfiguration = new org.apache.tools.ant.taskdefs.XSLTProcess.TraceConfiguration();
        this.Z = traceConfiguration;
        return traceConfiguration;
    }

    public final void d() {
        if (this.u == null) {
            handleError("destdir attributes must be set!");
        }
    }

    public final void e(java.io.File file) throws org.apache.tools.ant.BuildException {
        java.io.File parentFile = file.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs() || parentFile.isDirectory()) {
            return;
        }
        handleError("Unable to create directory: " + parentFile.getAbsolutePath());
    }

    /* JADX WARN: Finally extract failed */
    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Resource resource;
        java.io.File file;
        if (com.anythink.expressad.foundation.h.i.e.equals(getTaskType())) {
            log("Warning: the task name <style> is deprecated. Use <xslt> instead.", 1);
        }
        java.io.File file2 = this.v;
        org.apache.tools.ant.types.Resource resource2 = this.x;
        if (resource2 == null && this.w == null) {
            handleError("specify the stylesheet either as a filename in style attribute or as a nested resource");
            return;
        }
        if (resource2 != null && this.w != null) {
            handleError("specify the stylesheet either as a filename in style attribute or as a nested resource but not as both");
            return;
        }
        java.io.File file3 = this.C;
        if (file3 != null && !file3.exists()) {
            handleError("input file " + this.C + " does not exist");
            return;
        }
        try {
            m();
            if (this.Y.size() > 0) {
                this.Y.setSystem();
            }
            if (this.v == null) {
                this.v = getProject().getBaseDir();
            }
            org.apache.tools.ant.taskdefs.XSLTLiaison liaison = getLiaison();
            this.G = liaison;
            if (liaison instanceof org.apache.tools.ant.taskdefs.XSLTLoggerAware) {
                ((org.apache.tools.ant.taskdefs.XSLTLoggerAware) liaison).setLogger(this);
            }
            log("Using " + this.G.getClass().toString(), 3);
            if (this.w != null) {
                java.io.File resolveFile = getProject().resolveFile(this.w);
                if (!resolveFile.exists()) {
                    java.io.File resolveFile2 = a0.resolveFile(this.v, this.w);
                    if (resolveFile2.exists()) {
                        log("DEPRECATED - the 'style' attribute should be relative to the project's");
                        log("             basedir, not the tasks's basedir.");
                        resolveFile = resolveFile2;
                    }
                }
                org.apache.tools.ant.types.resources.FileResource fileResource = new org.apache.tools.ant.types.resources.FileResource();
                fileResource.setProject(getProject());
                fileResource.setFile(resolveFile);
                resource = fileResource;
            } else {
                resource = this.x;
            }
            if (!resource.isExists()) {
                handleError("stylesheet " + resource + " doesn't exist.");
                org.apache.tools.ant.AntClassLoader antClassLoader = this.O;
                if (antClassLoader != null) {
                    antClassLoader.resetThreadContextLoader();
                    this.O.cleanup();
                    this.O = null;
                }
                if (this.Y.size() > 0) {
                    this.Y.restoreSystem();
                }
                this.G = null;
                this.H = false;
                this.v = file2;
                return;
            }
            java.io.File file4 = this.C;
            if (file4 != null && (file = this.D) != null) {
                h(file4, file, resource);
                org.apache.tools.ant.AntClassLoader antClassLoader2 = this.O;
                if (antClassLoader2 != null) {
                    antClassLoader2.resetThreadContextLoader();
                    this.O.cleanup();
                    this.O = null;
                }
                if (this.Y.size() > 0) {
                    this.Y.restoreSystem();
                }
                this.G = null;
                this.H = false;
                this.v = file2;
                return;
            }
            d();
            if (this.R) {
                org.apache.tools.ant.DirectoryScanner directoryScanner = getDirectoryScanner(this.v);
                log("Transforming into " + this.u, 2);
                for (java.lang.String str : directoryScanner.getIncludedFiles()) {
                    i(this.v, str, this.u, resource);
                }
                if (this.L) {
                    java.lang.String[] includedDirectories = directoryScanner.getIncludedDirectories();
                    for (int i = 0; i < includedDirectories.length; i++) {
                        for (java.lang.String str2 : new java.io.File(this.v, includedDirectories[i]).list()) {
                            i(this.v, includedDirectories[i] + java.io.File.separator + str2, this.u, resource);
                        }
                    }
                }
            } else if (this.Q.size() == 0) {
                if (this.V) {
                    handleError("no resources specified");
                }
                org.apache.tools.ant.AntClassLoader antClassLoader3 = this.O;
                if (antClassLoader3 != null) {
                    antClassLoader3.resetThreadContextLoader();
                    this.O.cleanup();
                    this.O = null;
                }
                if (this.Y.size() > 0) {
                    this.Y.restoreSystem();
                }
                this.G = null;
                this.H = false;
                this.v = file2;
                return;
            }
            j(resource);
            org.apache.tools.ant.AntClassLoader antClassLoader4 = this.O;
            if (antClassLoader4 != null) {
                antClassLoader4.resetThreadContextLoader();
                this.O.cleanup();
                this.O = null;
            }
            if (this.Y.size() > 0) {
                this.Y.restoreSystem();
            }
            this.G = null;
            this.H = false;
            this.v = file2;
        } catch (java.lang.Throwable th) {
            org.apache.tools.ant.AntClassLoader antClassLoader5 = this.O;
            if (antClassLoader5 != null) {
                antClassLoader5.resetThreadContextLoader();
                this.O.cleanup();
                this.O = null;
            }
            if (this.Y.size() > 0) {
                this.Y.restoreSystem();
            }
            this.G = null;
            this.H = false;
            this.v = file2;
            throw th;
        }
    }

    public final java.lang.Object f(org.apache.tools.ant.taskdefs.XSLTProcess.Param param) throws javax.xml.xpath.XPathExpressionException {
        org.apache.tools.ant.taskdefs.XSLTProcess.ParamType paramType;
        java.lang.String type = param.getType();
        java.lang.String expression = param.getExpression();
        if (type == null || "".equals(type)) {
            paramType = org.apache.tools.ant.taskdefs.XSLTProcess.ParamType.STRING;
        } else {
            try {
                paramType = org.apache.tools.ant.taskdefs.XSLTProcess.ParamType.valueOf(type);
            } catch (java.lang.IllegalArgumentException e) {
                throw new java.lang.IllegalArgumentException("Invalid XSLT parameter type: " + type, e);
            }
        }
        int i = org.apache.tools.ant.taskdefs.XSLTProcess.AnonymousClass2.a[paramType.ordinal()];
        if (i == 1) {
            return expression;
        }
        if (i == 2) {
            return java.lang.Boolean.valueOf(java.lang.Boolean.parseBoolean(expression));
        }
        if (i == 3) {
            return java.lang.Double.valueOf(java.lang.Double.parseDouble(expression));
        }
        if (i == 4) {
            return java.lang.Integer.valueOf(java.lang.Integer.parseInt(expression));
        }
        if (i == 5) {
            return java.lang.Long.valueOf(java.lang.Long.parseLong(expression));
        }
        javax.xml.namespace.QName qName = org.apache.tools.ant.taskdefs.XSLTProcess.ParamType.XPATH_TYPES.get(paramType);
        if (qName != null) {
            return this.X.compile(expression).evaluate((java.lang.Object) null, qName);
        }
        throw new java.lang.IllegalArgumentException("Invalid XSLT parameter type: " + type);
    }

    public final java.lang.Class g(java.lang.String str) throws java.lang.ClassNotFoundException {
        m();
        org.apache.tools.ant.AntClassLoader antClassLoader = this.O;
        return antClassLoader == null ? java.lang.Class.forName(str) : java.lang.Class.forName(str, true, antClassLoader);
    }

    public org.apache.tools.ant.taskdefs.XSLTProcess.Factory getFactory() {
        return this.M;
    }

    public org.apache.tools.ant.taskdefs.XSLTLiaison getLiaison() {
        if (this.G == null) {
            java.lang.String str = this.E;
            if (str != null) {
                try {
                    k(str);
                } catch (java.lang.Exception e) {
                    handleError(e);
                }
            } else {
                try {
                    k(PROCESSOR_TRAX);
                } catch (java.lang.Throwable th) {
                    log(org.apache.tools.ant.util.StringUtils.getStackTrace(th), 0);
                    handleError(th);
                }
            }
        }
        return this.G;
    }

    public java.util.Enumeration<org.apache.tools.ant.taskdefs.XSLTProcess.OutputProperty> getOutputProperties() {
        return this.J.elements();
    }

    public boolean getSuppressWarnings() {
        return this.S;
    }

    public org.apache.tools.ant.taskdefs.XSLTProcess.TraceConfiguration getTraceConfiguration() {
        return this.Z;
    }

    public org.apache.tools.ant.types.XMLCatalog getXMLCatalog() {
        this.K.setProject(getProject());
        return this.K;
    }

    public final void h(java.io.File file, java.io.File file2, org.apache.tools.ant.types.Resource resource) throws org.apache.tools.ant.BuildException {
        try {
            long lastModified = resource.getLastModified();
            log("In file " + file + " time: " + file.lastModified(), 4);
            log("Out file " + file2 + " time: " + file2.lastModified(), 4);
            log("Style file " + this.w + " time: " + lastModified, 4);
            if (!this.I && file.lastModified() < file2.lastModified() && lastModified < file2.lastModified()) {
                log("Skipping input file " + file + " because it is older than output file " + file2 + " and so is the stylesheet " + resource, 4);
            }
            e(file2);
            log("Processing " + file + " to " + file2, 2);
            configureLiaison(resource);
            l(this.G, file);
            this.G.transform(file, file2);
        } catch (java.lang.Exception e) {
            log("Failed to process " + file, 2);
            if (file2 != null) {
                file2.delete();
            }
            handleTransformationError(e);
        }
    }

    public void handleError(java.lang.String str) {
        if (this.U) {
            throw new org.apache.tools.ant.BuildException(str, getLocation());
        }
        log(str, 1);
    }

    public void handleError(java.lang.Throwable th) {
        if (this.U) {
            throw new org.apache.tools.ant.BuildException(th);
        }
        log("Caught an exception: " + th, 1);
    }

    public void handleTransformationError(java.lang.Exception exc) {
        if (this.U && this.T) {
            throw new org.apache.tools.ant.BuildException(exc);
        }
        log("Caught an error during transformation: " + exc, 1);
    }

    public final void i(java.io.File file, java.lang.String str, java.io.File file2, org.apache.tools.ant.types.Resource resource) throws org.apache.tools.ant.BuildException {
        java.io.File file3 = null;
        try {
            long lastModified = resource.getLastModified();
            java.io.File file4 = new java.io.File(file, str);
            if (file4.isDirectory()) {
                log("Skipping " + file4 + " it is a directory.", 3);
                return;
            }
            org.apache.tools.ant.types.Mapper mapper = this.P;
            java.lang.String[] mapFileName = (mapper != null ? mapper.getImplementation() : new org.apache.tools.ant.taskdefs.XSLTProcess.StyleMapper(this, null)).mapFileName(str);
            if (mapFileName != null && mapFileName.length != 0) {
                if (mapFileName.length > 1) {
                    log("Skipping " + this.C + " its mapping is ambiguos.", 3);
                    return;
                }
                java.io.File file5 = new java.io.File(file2, mapFileName[0]);
                try {
                    if (this.I || file4.lastModified() > file5.lastModified() || lastModified > file5.lastModified()) {
                        e(file5);
                        log("Processing " + file4 + " to " + file5);
                        configureLiaison(resource);
                        l(this.G, file4);
                        this.G.transform(file4, file5);
                        return;
                    }
                    return;
                } catch (java.lang.Exception e) {
                    e = e;
                    file3 = file5;
                    log("Failed to process " + this.C, 2);
                    if (file3 != null) {
                        file3.delete();
                    }
                    handleTransformationError(e);
                    return;
                }
            }
            log("Skipping " + this.C + " it cannot get mapped to output.", 3);
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    @Override // org.apache.tools.ant.Task
    public void init() throws org.apache.tools.ant.BuildException {
        super.init();
        this.K.setProject(getProject());
        javax.xml.xpath.XPathFactory newInstance = javax.xml.xpath.XPathFactory.newInstance();
        this.W = newInstance;
        javax.xml.xpath.XPath newXPath = newInstance.newXPath();
        this.X = newXPath;
        newXPath.setXPathVariableResolver(new org.apache.tools.ant.taskdefs.XSLTProcess.AnonymousClass1());
    }

    public final void j(org.apache.tools.ant.types.Resource resource) {
        org.apache.tools.ant.types.resources.FileResource asFileResource;
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = this.Q.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.types.Resource next = it.next();
            if (next.isExists()) {
                java.io.File file = this.v;
                java.lang.String name = next.getName();
                org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) next.as(org.apache.tools.ant.types.resources.FileProvider.class);
                if (fileProvider != null && (file = (asFileResource = org.apache.tools.ant.util.ResourceUtils.asFileResource(fileProvider)).getBaseDir()) == null) {
                    name = asFileResource.getFile().getAbsolutePath();
                }
                i(file, name, this.u, resource);
            }
        }
    }

    public final void k(java.lang.String str) throws java.lang.Exception {
        if (str.equals(PROCESSOR_TRAX)) {
            this.G = new org.apache.tools.ant.taskdefs.optional.TraXLiaison();
        } else {
            this.G = (org.apache.tools.ant.taskdefs.XSLTLiaison) g(str).newInstance();
        }
    }

    public final void l(org.apache.tools.ant.taskdefs.XSLTLiaison xSLTLiaison, java.io.File file) throws java.lang.Exception {
        java.lang.String str = this.z;
        if (str != null) {
            xSLTLiaison.addParam(str, file.getName());
        }
        if (this.A != null) {
            java.io.File file2 = new java.io.File(org.apache.tools.ant.util.FileUtils.getRelativePath(this.v, file));
            xSLTLiaison.addParam(this.A, file2.getParent() != null ? file2.getParent().replace('\\', '/') : ".");
        }
    }

    public final void m() {
        if (this.F == null || this.O != null) {
            return;
        }
        org.apache.tools.ant.AntClassLoader createClassLoader = getProject().createClassLoader(this.F);
        this.O = createClassLoader;
        createClassLoader.setThreadContextLoader();
    }

    public void setBasedir(java.io.File file) {
        this.v = file;
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        createClasspath().append(path);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setDestdir(java.io.File file) {
        this.u = file;
    }

    public void setExtension(java.lang.String str) {
        this.y = str;
    }

    public void setFailOnError(boolean z) {
        this.U = z;
    }

    public void setFailOnNoResources(boolean z) {
        this.V = z;
    }

    public void setFailOnTransformationError(boolean z) {
        this.T = z;
    }

    public void setFileDirParameter(java.lang.String str) {
        this.A = str;
    }

    public void setFileNameParameter(java.lang.String str) {
        this.z = str;
    }

    public void setForce(boolean z) {
        this.I = z;
    }

    public void setIn(java.io.File file) {
        this.C = file;
    }

    public void setOut(java.io.File file) {
        this.D = file;
    }

    public void setProcessor(java.lang.String str) {
        this.E = str;
    }

    public void setReloadStylesheet(boolean z) {
        this.N = !z;
    }

    public void setScanIncludedDirectories(boolean z) {
        this.L = z;
    }

    public void setStyle(java.lang.String str) {
        this.w = str;
    }

    public void setSuppressWarnings(boolean z) {
        this.S = z;
    }

    public void setUseImplicitFileset(boolean z) {
        this.R = z;
    }

    public void setXslResource(org.apache.tools.ant.types.Resource resource) {
        this.x = resource;
    }
}
