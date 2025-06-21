package org.apache.tools.ant.helper;

/* loaded from: classes25.dex */
public class ProjectHelperImpl extends org.apache.tools.ant.ProjectHelper {
    public static final org.apache.tools.ant.util.FileUtils l = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public org.xml.sax.Parser f;
    public org.apache.tools.ant.Project g;
    public java.io.File h;
    public java.io.File i;
    public org.xml.sax.Locator j;
    public org.apache.tools.ant.Target k;

    public static class AbstractHandler extends org.xml.sax.HandlerBase {
        public org.xml.sax.DocumentHandler n;
        public org.apache.tools.ant.helper.ProjectHelperImpl t;

        public AbstractHandler(org.apache.tools.ant.helper.ProjectHelperImpl projectHelperImpl, org.xml.sax.DocumentHandler documentHandler) {
            this.n = documentHandler;
            this.t = projectHelperImpl;
            projectHelperImpl.f.setDocumentHandler(this);
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void characters(char[] cArr, int i, int i2) throws org.xml.sax.SAXParseException {
            java.lang.String trim = new java.lang.String(cArr, i, i2).trim();
            if (trim.length() <= 0) {
                return;
            }
            throw new org.xml.sax.SAXParseException("Unexpected text \"" + trim + "\"", this.t.j);
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void endElement(java.lang.String str) throws org.xml.sax.SAXException {
            this.t.f.setDocumentHandler(this.n);
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void startElement(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            throw new org.xml.sax.SAXParseException("Unexpected element \"" + str + "\"", this.t.j);
        }
    }

    public static class DataTypeHandler extends org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler {
        public org.apache.tools.ant.Target u;
        public java.lang.Object v;
        public org.apache.tools.ant.RuntimeConfigurable w;

        public DataTypeHandler(org.apache.tools.ant.helper.ProjectHelperImpl projectHelperImpl, org.xml.sax.DocumentHandler documentHandler, org.apache.tools.ant.Target target) {
            super(projectHelperImpl, documentHandler);
            this.w = null;
            this.u = target;
        }

        public void a(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            try {
                java.lang.Object createDataType = this.t.g.createDataType(str);
                this.v = createDataType;
                if (createDataType == null) {
                    throw new org.apache.tools.ant.BuildException("Unknown data type " + str);
                }
                org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable = new org.apache.tools.ant.RuntimeConfigurable(this.v, str);
                this.w = runtimeConfigurable;
                runtimeConfigurable.setAttributes(attributeList);
                this.u.addDataType(this.w);
            } catch (org.apache.tools.ant.BuildException e) {
                throw new org.xml.sax.SAXParseException(e.getMessage(), this.t.j, e);
            }
        }

        @Override // org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler, org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void characters(char[] cArr, int i, int i2) {
            this.w.addText(cArr, i, i2);
        }

        @Override // org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler, org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void startElement(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            new org.apache.tools.ant.helper.ProjectHelperImpl.NestedElementHandler(this.t, this, this.v, this.w, this.u).a(str, attributeList);
        }
    }

    public static class DescriptionHandler extends org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler {
        public DescriptionHandler(org.apache.tools.ant.helper.ProjectHelperImpl projectHelperImpl, org.xml.sax.DocumentHandler documentHandler) {
            super(projectHelperImpl, documentHandler);
        }

        @Override // org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler, org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void characters(char[] cArr, int i, int i2) {
            java.lang.String str = new java.lang.String(cArr, i, i2);
            java.lang.String description = this.t.g.getDescription();
            if (description == null) {
                this.t.g.setDescription(str);
                return;
            }
            this.t.g.setDescription(description + str);
        }
    }

    public static class NestedElementHandler extends org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler {
        public java.lang.Object u;
        public java.lang.Object v;
        public org.apache.tools.ant.RuntimeConfigurable w;
        public org.apache.tools.ant.RuntimeConfigurable x;
        public org.apache.tools.ant.Target y;

        public NestedElementHandler(org.apache.tools.ant.helper.ProjectHelperImpl projectHelperImpl, org.xml.sax.DocumentHandler documentHandler, java.lang.Object obj, org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable, org.apache.tools.ant.Target target) {
            super(projectHelperImpl, documentHandler);
            this.x = null;
            if (obj instanceof org.apache.tools.ant.TypeAdapter) {
                this.u = ((org.apache.tools.ant.TypeAdapter) obj).getProxy();
            } else {
                this.u = obj;
            }
            this.w = runtimeConfigurable;
            this.y = target;
        }

        public void a(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            org.apache.tools.ant.IntrospectionHelper helper = org.apache.tools.ant.IntrospectionHelper.getHelper(this.t.g, this.u.getClass());
            try {
                java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ENGLISH);
                if (this.u instanceof org.apache.tools.ant.UnknownElement) {
                    org.apache.tools.ant.UnknownElement unknownElement = new org.apache.tools.ant.UnknownElement(lowerCase);
                    unknownElement.setProject(this.t.g);
                    ((org.apache.tools.ant.UnknownElement) this.u).addChild(unknownElement);
                    this.v = unknownElement;
                } else {
                    this.v = helper.createElement(this.t.g, this.u, lowerCase);
                }
                this.t.k(this.v, attributeList);
                org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable = new org.apache.tools.ant.RuntimeConfigurable(this.v, str);
                this.x = runtimeConfigurable;
                runtimeConfigurable.setAttributes(attributeList);
                this.w.addChild(this.x);
            } catch (org.apache.tools.ant.BuildException e) {
                throw new org.xml.sax.SAXParseException(e.getMessage(), this.t.j, e);
            }
        }

        @Override // org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler, org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void characters(char[] cArr, int i, int i2) {
            this.x.addText(cArr, i, i2);
        }

        @Override // org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler, org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void startElement(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            java.lang.Object obj = this.v;
            if (obj instanceof org.apache.tools.ant.TaskContainer) {
                new org.apache.tools.ant.helper.ProjectHelperImpl.TaskHandler(this.t, this, (org.apache.tools.ant.TaskContainer) obj, this.x, this.y).a(str, attributeList);
            } else {
                new org.apache.tools.ant.helper.ProjectHelperImpl.NestedElementHandler(this.t, this, obj, this.x, this.y).a(str, attributeList);
            }
        }
    }

    public static class ProjectHandler extends org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler {
        public ProjectHandler(org.apache.tools.ant.helper.ProjectHelperImpl projectHelperImpl, org.xml.sax.DocumentHandler documentHandler) {
            super(projectHelperImpl, documentHandler);
        }

        public final void a(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            new org.apache.tools.ant.helper.ProjectHelperImpl.TargetHandler(this.t, this).a(str, attributeList);
        }

        public void b(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            java.lang.String str2 = null;
            java.lang.String str3 = null;
            java.lang.String str4 = null;
            java.lang.String str5 = null;
            for (int i = 0; i < attributeList.getLength(); i++) {
                java.lang.String name = attributeList.getName(i);
                java.lang.String value = attributeList.getValue(i);
                if ("default".equals(name)) {
                    str2 = value;
                } else if ("name".equals(name)) {
                    str3 = value;
                } else if ("id".equals(name)) {
                    str4 = value;
                } else {
                    if (!org.apache.tools.ant.MagicNames.PROJECT_BASEDIR.equals(name)) {
                        throw new org.xml.sax.SAXParseException("Unexpected attribute \"" + attributeList.getName(i) + "\"", this.t.j);
                    }
                    str5 = value;
                }
            }
            if (str2 == null || str2.equals("")) {
                throw new org.apache.tools.ant.BuildException("The default attribute is required");
            }
            this.t.g.setDefault(str2);
            if (str3 != null) {
                this.t.g.setName(str3);
                this.t.g.addReference(str3, this.t.g);
            }
            if (str4 != null) {
                this.t.g.addReference(str4, this.t.g);
            }
            if (this.t.g.getProperty(org.apache.tools.ant.MagicNames.PROJECT_BASEDIR) != null) {
                this.t.g.setBasedir(this.t.g.getProperty(org.apache.tools.ant.MagicNames.PROJECT_BASEDIR));
            } else if (str5 == null) {
                this.t.g.setBasedir(this.t.i.getAbsolutePath());
            } else if (new java.io.File(str5).isAbsolute()) {
                this.t.g.setBasedir(str5);
            } else {
                this.t.g.setBaseDir(org.apache.tools.ant.helper.ProjectHelperImpl.l.resolveFile(this.t.i, str5));
            }
            this.t.g.addTarget("", this.t.k);
        }

        @Override // org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler, org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void startElement(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            if (com.umeng.ccg.a.A.equals(str)) {
                a(str, attributeList);
            } else {
                org.apache.tools.ant.helper.ProjectHelperImpl projectHelperImpl = this.t;
                org.apache.tools.ant.helper.ProjectHelperImpl.l(projectHelperImpl, this, projectHelperImpl.k, str, attributeList);
            }
        }
    }

    public static class RootHandler extends org.xml.sax.HandlerBase {
        public org.apache.tools.ant.helper.ProjectHelperImpl n;

        public RootHandler(org.apache.tools.ant.helper.ProjectHelperImpl projectHelperImpl) {
            this.n = projectHelperImpl;
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.EntityResolver
        public org.xml.sax.InputSource resolveEntity(java.lang.String str, java.lang.String str2) {
            this.n.g.log("resolving systemId: " + str2, 3);
            if (!str2.startsWith("file:")) {
                return null;
            }
            java.lang.String fromURI = org.apache.tools.ant.helper.ProjectHelperImpl.l.fromURI(str2);
            java.io.File file = new java.io.File(fromURI);
            if (!file.isAbsolute()) {
                file = org.apache.tools.ant.helper.ProjectHelperImpl.l.resolveFile(this.n.i, fromURI);
                this.n.g.log("Warning: '" + str2 + "' in " + this.n.h + " should be expressed simply as '" + fromURI.replace('\\', '/') + "' for compliance with other XML tools", 1);
            }
            try {
                org.xml.sax.InputSource inputSource = new org.xml.sax.InputSource(new java.io.FileInputStream(file));
                inputSource.setSystemId(org.apache.tools.ant.helper.ProjectHelperImpl.l.toURI(file.getAbsolutePath()));
                return inputSource;
            } catch (java.io.FileNotFoundException unused) {
                this.n.g.log(file.getAbsolutePath() + " could not be found", 1);
                return null;
            }
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void setDocumentLocator(org.xml.sax.Locator locator) {
            this.n.j = locator;
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void startElement(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            if (!"project".equals(str)) {
                throw new org.xml.sax.SAXParseException("Config file is not of expected XML type", this.n.j);
            }
            new org.apache.tools.ant.helper.ProjectHelperImpl.ProjectHandler(this.n, this).b(str, attributeList);
        }
    }

    public static class TargetHandler extends org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler {
        public org.apache.tools.ant.Target u;

        public TargetHandler(org.apache.tools.ant.helper.ProjectHelperImpl projectHelperImpl, org.xml.sax.DocumentHandler documentHandler) {
            super(projectHelperImpl, documentHandler);
        }

        public void a(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            java.lang.String str2 = null;
            java.lang.String str3 = null;
            java.lang.String str4 = null;
            java.lang.String str5 = null;
            java.lang.String str6 = null;
            java.lang.String str7 = "";
            for (int i = 0; i < attributeList.getLength(); i++) {
                java.lang.String name = attributeList.getName(i);
                java.lang.String value = attributeList.getValue(i);
                if ("name".equals(name)) {
                    if (value.equals("")) {
                        throw new org.apache.tools.ant.BuildException("name attribute must not be empty", new org.apache.tools.ant.Location(this.t.j));
                    }
                    str2 = value;
                } else if ("depends".equals(name)) {
                    str7 = value;
                } else if ("if".equals(name)) {
                    str3 = value;
                } else if ("unless".equals(name)) {
                    str4 = value;
                } else if ("id".equals(name)) {
                    str6 = value;
                } else {
                    if (!"description".equals(name)) {
                        throw new org.xml.sax.SAXParseException("Unexpected attribute \"" + name + "\"", this.t.j);
                    }
                    str5 = value;
                }
            }
            if (str2 == null) {
                throw new org.xml.sax.SAXParseException("target element appears without a name attribute", this.t.j);
            }
            org.apache.tools.ant.Target target = new org.apache.tools.ant.Target();
            this.u = target;
            target.addDependency("");
            this.u.setName(str2);
            this.u.setIf(str3);
            this.u.setUnless(str4);
            this.u.setDescription(str5);
            this.t.g.addTarget(str2, this.u);
            if (str6 != null && !str6.equals("")) {
                this.t.g.addReference(str6, this.u);
            }
            if (str7.length() > 0) {
                this.u.setDepends(str7);
            }
        }

        @Override // org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler, org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void startElement(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            org.apache.tools.ant.helper.ProjectHelperImpl.l(this.t, this, this.u, str, attributeList);
        }
    }

    public static class TaskHandler extends org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler {
        public org.apache.tools.ant.Target u;
        public org.apache.tools.ant.TaskContainer v;
        public org.apache.tools.ant.Task w;
        public org.apache.tools.ant.RuntimeConfigurable x;
        public org.apache.tools.ant.RuntimeConfigurable y;

        public TaskHandler(org.apache.tools.ant.helper.ProjectHelperImpl projectHelperImpl, org.xml.sax.DocumentHandler documentHandler, org.apache.tools.ant.TaskContainer taskContainer, org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable, org.apache.tools.ant.Target target) {
            super(projectHelperImpl, documentHandler);
            this.y = null;
            this.v = taskContainer;
            this.x = runtimeConfigurable;
            this.u = target;
        }

        public void a(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            try {
                this.w = this.t.g.createTask(str);
            } catch (org.apache.tools.ant.BuildException unused) {
            }
            if (this.w == null) {
                org.apache.tools.ant.UnknownElement unknownElement = new org.apache.tools.ant.UnknownElement(str);
                this.w = unknownElement;
                unknownElement.setProject(this.t.g);
                this.w.setTaskName(str);
            }
            this.w.setLocation(new org.apache.tools.ant.Location(this.t.j));
            this.t.k(this.w, attributeList);
            this.w.setOwningTarget(this.u);
            this.v.addTask(this.w);
            this.w.init();
            org.apache.tools.ant.RuntimeConfigurable runtimeConfigurableWrapper = this.w.getRuntimeConfigurableWrapper();
            this.y = runtimeConfigurableWrapper;
            runtimeConfigurableWrapper.setAttributes(attributeList);
            org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable = this.x;
            if (runtimeConfigurable != null) {
                runtimeConfigurable.addChild(this.y);
            }
        }

        @Override // org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler, org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void characters(char[] cArr, int i, int i2) {
            this.y.addText(cArr, i, i2);
        }

        @Override // org.apache.tools.ant.helper.ProjectHelperImpl.AbstractHandler, org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void startElement(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
            java.lang.Cloneable cloneable = this.w;
            if (cloneable instanceof org.apache.tools.ant.TaskContainer) {
                new org.apache.tools.ant.helper.ProjectHelperImpl.TaskHandler(this.t, this, (org.apache.tools.ant.TaskContainer) cloneable, this.y, this.u).a(str, attributeList);
            } else {
                new org.apache.tools.ant.helper.ProjectHelperImpl.NestedElementHandler(this.t, this, cloneable, this.y, this.u).a(str, attributeList);
            }
        }
    }

    public ProjectHelperImpl() {
        org.apache.tools.ant.Target target = new org.apache.tools.ant.Target();
        this.k = target;
        target.setName("");
    }

    public static void l(org.apache.tools.ant.helper.ProjectHelperImpl projectHelperImpl, org.xml.sax.DocumentHandler documentHandler, org.apache.tools.ant.Target target, java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXParseException {
        if ("description".equals(str)) {
            new org.apache.tools.ant.helper.ProjectHelperImpl.DescriptionHandler(projectHelperImpl, documentHandler);
        } else if (projectHelperImpl.g.getDataTypeDefinitions().get(str) != null) {
            new org.apache.tools.ant.helper.ProjectHelperImpl.DataTypeHandler(projectHelperImpl, documentHandler, target).a(str, attributeList);
        } else {
            new org.apache.tools.ant.helper.ProjectHelperImpl.TaskHandler(projectHelperImpl, documentHandler, target, null, target).a(str, attributeList);
        }
    }

    public final void k(java.lang.Object obj, org.xml.sax.AttributeList attributeList) {
        java.lang.String value = attributeList.getValue("id");
        if (value != null) {
            this.g.addReference(value, obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0105 A[Catch: all -> 0x0028, TryCatch #5 {all -> 0x0028, blocks: (B:6:0x0021, B:7:0x0045, B:25:0x00ae, B:26:0x00c8, B:21:0x00c9, B:22:0x00d0, B:17:0x00d1, B:18:0x00d6, B:40:0x00d7, B:42:0x00df, B:43:0x00e1, B:44:0x00e2, B:45:0x00eb, B:29:0x00ec, B:31:0x0105, B:33:0x010f, B:34:0x0112, B:36:0x0113, B:37:0x011c, B:51:0x003a), top: B:4:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0113 A[Catch: all -> 0x0028, TryCatch #5 {all -> 0x0028, blocks: (B:6:0x0021, B:7:0x0045, B:25:0x00ae, B:26:0x00c8, B:21:0x00c9, B:22:0x00d0, B:17:0x00d1, B:18:0x00d6, B:40:0x00d7, B:42:0x00df, B:43:0x00e1, B:44:0x00e2, B:45:0x00eb, B:29:0x00ec, B:31:0x0105, B:33:0x010f, B:34:0x0112, B:36:0x0113, B:37:0x011c, B:51:0x003a), top: B:4:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00df A[Catch: all -> 0x0028, TryCatch #5 {all -> 0x0028, blocks: (B:6:0x0021, B:7:0x0045, B:25:0x00ae, B:26:0x00c8, B:21:0x00c9, B:22:0x00d0, B:17:0x00d1, B:18:0x00d6, B:40:0x00d7, B:42:0x00df, B:43:0x00e1, B:44:0x00e2, B:45:0x00eb, B:29:0x00ec, B:31:0x0105, B:33:0x010f, B:34:0x0112, B:36:0x0113, B:37:0x011c, B:51:0x003a), top: B:4:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e2 A[Catch: all -> 0x0028, TryCatch #5 {all -> 0x0028, blocks: (B:6:0x0021, B:7:0x0045, B:25:0x00ae, B:26:0x00c8, B:21:0x00c9, B:22:0x00d0, B:17:0x00d1, B:18:0x00d6, B:40:0x00d7, B:42:0x00df, B:43:0x00e1, B:44:0x00e2, B:45:0x00eb, B:29:0x00ec, B:31:0x0105, B:33:0x010f, B:34:0x0112, B:36:0x0113, B:37:0x011c, B:51:0x003a), top: B:4:0x0021 }] */
    @Override // org.apache.tools.ant.ProjectHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parse(org.apache.tools.ant.Project project, java.lang.Object obj) throws org.apache.tools.ant.BuildException {
        java.lang.Exception exception;
        java.lang.Exception exception2;
        java.lang.String uri;
        java.io.FileInputStream fileInputStream;
        if (!(obj instanceof java.io.File)) {
            throw new org.apache.tools.ant.BuildException("Only File source supported by default plugin");
        }
        java.io.File file = (java.io.File) obj;
        this.g = project;
        this.h = new java.io.File(file.getAbsolutePath());
        this.i = new java.io.File(this.h.getParent());
        java.io.FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    this.f = org.apache.tools.ant.util.JAXPUtils.getParser();
                } catch (org.apache.tools.ant.BuildException unused) {
                    this.f = new org.xml.sax.helpers.XMLReaderAdapter(org.apache.tools.ant.util.JAXPUtils.getXMLReader());
                }
                uri = l.toURI(file.getAbsolutePath());
                fileInputStream = new java.io.FileInputStream(file);
            } catch (java.io.FileNotFoundException e) {
                e = e;
                throw new org.apache.tools.ant.BuildException(e);
            } catch (java.io.UnsupportedEncodingException e2) {
                e = e2;
                throw new org.apache.tools.ant.BuildException("Encoding of project file is invalid.", e);
            } catch (java.io.IOException e3) {
                e = e3;
                throw new org.apache.tools.ant.BuildException("Error reading project file: " + e.getMessage(), e);
            } catch (org.xml.sax.SAXParseException e4) {
                e = e4;
                org.apache.tools.ant.Location location = new org.apache.tools.ant.Location(e.getSystemId(), e.getLineNumber(), e.getColumnNumber());
                exception2 = e.getException();
                if (exception2 instanceof org.apache.tools.ant.BuildException) {
                    throw new org.apache.tools.ant.BuildException(e.getMessage(), exception2, location);
                }
                org.apache.tools.ant.BuildException buildException = (org.apache.tools.ant.BuildException) exception2;
                if (buildException.getLocation() != org.apache.tools.ant.Location.UNKNOWN_LOCATION) {
                    throw buildException;
                }
                buildException.setLocation(location);
                throw buildException;
            } catch (org.xml.sax.SAXException e5) {
                e = e5;
                exception = e.getException();
                if (!(exception instanceof org.apache.tools.ant.BuildException)) {
                    throw ((org.apache.tools.ant.BuildException) exception);
                }
                throw new org.apache.tools.ant.BuildException(e.getMessage(), exception);
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            org.xml.sax.InputSource inputSource = new org.xml.sax.InputSource(fileInputStream);
            inputSource.setSystemId(uri);
            project.log("parsing buildfile " + file + " with URI = " + uri, 3);
            org.apache.tools.ant.helper.ProjectHelperImpl.RootHandler rootHandler = new org.apache.tools.ant.helper.ProjectHelperImpl.RootHandler(this);
            this.f.setDocumentHandler(rootHandler);
            this.f.setEntityResolver(rootHandler);
            this.f.setErrorHandler(rootHandler);
            this.f.setDTDHandler(rootHandler);
            this.f.parse(inputSource);
            org.apache.tools.ant.util.FileUtils.close(fileInputStream);
        } catch (java.io.FileNotFoundException e6) {
            e = e6;
            throw new org.apache.tools.ant.BuildException(e);
        } catch (java.io.UnsupportedEncodingException e7) {
            e = e7;
            throw new org.apache.tools.ant.BuildException("Encoding of project file is invalid.", e);
        } catch (java.io.IOException e8) {
            e = e8;
            throw new org.apache.tools.ant.BuildException("Error reading project file: " + e.getMessage(), e);
        } catch (org.xml.sax.SAXParseException e9) {
            e = e9;
            org.apache.tools.ant.Location location2 = new org.apache.tools.ant.Location(e.getSystemId(), e.getLineNumber(), e.getColumnNumber());
            exception2 = e.getException();
            if (exception2 instanceof org.apache.tools.ant.BuildException) {
            }
        } catch (org.xml.sax.SAXException e10) {
            e = e10;
            exception = e.getException();
            if (!(exception instanceof org.apache.tools.ant.BuildException)) {
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            org.apache.tools.ant.util.FileUtils.close(fileInputStream2);
            throw th;
        }
    }
}
