package org.apache.tools.ant.helper;

/* loaded from: classes25.dex */
public class ProjectHelper2 extends org.apache.tools.ant.ProjectHelper {
    public static final java.lang.String REFID_TARGETS = "ant.targets";
    public static org.apache.tools.ant.helper.ProjectHelper2.AntHandler f = new org.apache.tools.ant.helper.ProjectHelper2.ElementHandler();
    public static org.apache.tools.ant.helper.ProjectHelper2.AntHandler g = new org.apache.tools.ant.helper.ProjectHelper2.TargetHandler();
    public static org.apache.tools.ant.helper.ProjectHelper2.AntHandler h = new org.apache.tools.ant.helper.ProjectHelper2.MainHandler();
    public static org.apache.tools.ant.helper.ProjectHelper2.AntHandler i = new org.apache.tools.ant.helper.ProjectHelper2.ProjectHandler();
    public static final org.apache.tools.ant.util.FileUtils j = org.apache.tools.ant.util.FileUtils.getFileUtils();

    public static class AntHandler {
        public void characters(char[] cArr, int i, int i2, org.apache.tools.ant.helper.AntXMLContext antXMLContext) throws org.xml.sax.SAXParseException {
            java.lang.String trim = new java.lang.String(cArr, i, i2).trim();
            if (trim.length() <= 0) {
                return;
            }
            throw new org.xml.sax.SAXParseException("Unexpected text \"" + trim + "\"", antXMLContext.getLocator());
        }

        public void checkNamespace(java.lang.String str) {
        }

        public void onEndChild(java.lang.String str, java.lang.String str2, java.lang.String str3, org.apache.tools.ant.helper.AntXMLContext antXMLContext) throws org.xml.sax.SAXParseException {
        }

        public void onEndElement(java.lang.String str, java.lang.String str2, org.apache.tools.ant.helper.AntXMLContext antXMLContext) {
        }

        public org.apache.tools.ant.helper.ProjectHelper2.AntHandler onStartChild(java.lang.String str, java.lang.String str2, java.lang.String str3, org.xml.sax.Attributes attributes, org.apache.tools.ant.helper.AntXMLContext antXMLContext) throws org.xml.sax.SAXParseException {
            throw new org.xml.sax.SAXParseException("Unexpected element \"" + str3 + " \"", antXMLContext.getLocator());
        }

        public void onStartElement(java.lang.String str, java.lang.String str2, java.lang.String str3, org.xml.sax.Attributes attributes, org.apache.tools.ant.helper.AntXMLContext antXMLContext) throws org.xml.sax.SAXParseException {
        }
    }

    public static class ElementHandler extends org.apache.tools.ant.helper.ProjectHelper2.AntHandler {
        @Override // org.apache.tools.ant.helper.ProjectHelper2.AntHandler
        public void characters(char[] cArr, int i, int i2, org.apache.tools.ant.helper.AntXMLContext antXMLContext) throws org.xml.sax.SAXParseException {
            antXMLContext.currentWrapper().addText(cArr, i, i2);
        }

        @Override // org.apache.tools.ant.helper.ProjectHelper2.AntHandler
        public void onEndElement(java.lang.String str, java.lang.String str2, org.apache.tools.ant.helper.AntXMLContext antXMLContext) {
            antXMLContext.popWrapper();
        }

        @Override // org.apache.tools.ant.helper.ProjectHelper2.AntHandler
        public org.apache.tools.ant.helper.ProjectHelper2.AntHandler onStartChild(java.lang.String str, java.lang.String str2, java.lang.String str3, org.xml.sax.Attributes attributes, org.apache.tools.ant.helper.AntXMLContext antXMLContext) throws org.xml.sax.SAXParseException {
            return org.apache.tools.ant.helper.ProjectHelper2.f;
        }

        @Override // org.apache.tools.ant.helper.ProjectHelper2.AntHandler
        public void onStartElement(java.lang.String str, java.lang.String str2, java.lang.String str3, org.xml.sax.Attributes attributes, org.apache.tools.ant.helper.AntXMLContext antXMLContext) throws org.xml.sax.SAXParseException {
            org.apache.tools.ant.RuntimeConfigurable currentWrapper = antXMLContext.currentWrapper();
            java.lang.Object proxy = currentWrapper != null ? currentWrapper.getProxy() : null;
            org.apache.tools.ant.UnknownElement unknownElement = new org.apache.tools.ant.UnknownElement(str2);
            unknownElement.setProject(antXMLContext.getProject());
            unknownElement.setNamespace(str);
            unknownElement.setQName(str3);
            unknownElement.setTaskType(org.apache.tools.ant.ProjectHelper.genComponentName(unknownElement.getNamespace(), str2));
            unknownElement.setTaskName(str3);
            unknownElement.setLocation(new org.apache.tools.ant.Location(antXMLContext.getLocator().getSystemId(), antXMLContext.getLocator().getLineNumber(), antXMLContext.getLocator().getColumnNumber()));
            unknownElement.setOwningTarget(antXMLContext.getCurrentTarget());
            if (proxy != null) {
                ((org.apache.tools.ant.UnknownElement) proxy).addChild(unknownElement);
            } else {
                antXMLContext.getCurrentTarget().addTask(unknownElement);
            }
            antXMLContext.configureId(unknownElement, attributes);
            org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable = new org.apache.tools.ant.RuntimeConfigurable(unknownElement, unknownElement.getTaskName());
            for (int i = 0; i < attributes.getLength(); i++) {
                java.lang.String localName = attributes.getLocalName(i);
                java.lang.String uri = attributes.getURI(i);
                if (uri != null && !uri.equals("") && !uri.equals(str)) {
                    localName = uri + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + attributes.getQName(i);
                }
                java.lang.String value = attributes.getValue(i);
                if (org.apache.tools.ant.ProjectHelper.ANT_TYPE.equals(localName) || (org.apache.tools.ant.ProjectHelper.ANT_CORE_URI.equals(uri) && org.apache.tools.ant.ProjectHelper.ANT_TYPE.equals(attributes.getLocalName(i)))) {
                    int indexOf = value.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    if (indexOf >= 0) {
                        java.lang.String substring = value.substring(0, indexOf);
                        java.lang.String prefixMapping = antXMLContext.getPrefixMapping(substring);
                        if (prefixMapping == null) {
                            throw new org.apache.tools.ant.BuildException("Unable to find XML NS prefix \"" + substring + "\"");
                        }
                        value = org.apache.tools.ant.ProjectHelper.genComponentName(prefixMapping, value.substring(indexOf + 1));
                    }
                    localName = org.apache.tools.ant.ProjectHelper.ANT_TYPE;
                }
                runtimeConfigurable.setAttribute(localName, value);
            }
            if (currentWrapper != null) {
                currentWrapper.addChild(runtimeConfigurable);
            }
            antXMLContext.pushWrapper(runtimeConfigurable);
        }
    }

    public static class MainHandler extends org.apache.tools.ant.helper.ProjectHelper2.AntHandler {
        @Override // org.apache.tools.ant.helper.ProjectHelper2.AntHandler
        public org.apache.tools.ant.helper.ProjectHelper2.AntHandler onStartChild(java.lang.String str, java.lang.String str2, java.lang.String str3, org.xml.sax.Attributes attributes, org.apache.tools.ant.helper.AntXMLContext antXMLContext) throws org.xml.sax.SAXParseException {
            if ("project".equals(str2) && (str.equals("") || str.equals(org.apache.tools.ant.ProjectHelper.ANT_CORE_URI))) {
                return org.apache.tools.ant.helper.ProjectHelper2.i;
            }
            if (!str2.equals(str3)) {
                throw new org.xml.sax.SAXParseException("Unexpected element \"" + str3 + "\" " + str2, antXMLContext.getLocator());
            }
            throw new org.xml.sax.SAXParseException("Unexpected element \"{" + str + com.alipay.sdk.m.u.i.d + str2 + "\" {" + org.apache.tools.ant.ProjectHelper.ANT_CORE_URI + com.alipay.sdk.m.u.i.d + str2, antXMLContext.getLocator());
        }
    }

    public static class ProjectHandler extends org.apache.tools.ant.helper.ProjectHelper2.AntHandler {
        @Override // org.apache.tools.ant.helper.ProjectHelper2.AntHandler
        public org.apache.tools.ant.helper.ProjectHelper2.AntHandler onStartChild(java.lang.String str, java.lang.String str2, java.lang.String str3, org.xml.sax.Attributes attributes, org.apache.tools.ant.helper.AntXMLContext antXMLContext) throws org.xml.sax.SAXParseException {
            return ((str2.equals(com.umeng.ccg.a.A) || str2.equals("extension-point")) && (str.equals("") || str.equals(org.apache.tools.ant.ProjectHelper.ANT_CORE_URI))) ? org.apache.tools.ant.helper.ProjectHelper2.g : org.apache.tools.ant.helper.ProjectHelper2.f;
        }

        @Override // org.apache.tools.ant.helper.ProjectHelper2.AntHandler
        public void onStartElement(java.lang.String str, java.lang.String str2, java.lang.String str3, org.xml.sax.Attributes attributes, org.apache.tools.ant.helper.AntXMLContext antXMLContext) throws org.xml.sax.SAXParseException {
            java.lang.Object url;
            java.lang.Object buildFileURL;
            org.apache.tools.ant.Project project = antXMLContext.getProject();
            antXMLContext.getImplicitTarget().setLocation(new org.apache.tools.ant.Location(antXMLContext.getLocator()));
            java.lang.String str4 = null;
            boolean z = false;
            for (int i = 0; i < attributes.getLength(); i++) {
                java.lang.String uri = attributes.getURI(i);
                if (uri == null || uri.equals("") || uri.equals(str)) {
                    java.lang.String localName = attributes.getLocalName(i);
                    java.lang.String value = attributes.getValue(i);
                    if ("default".equals(localName)) {
                        if (value != null && !value.equals("") && !antXMLContext.isIgnoringProjectTag()) {
                            project.setDefault(value);
                        }
                    } else if ("name".equals(localName)) {
                        if (value != null) {
                            antXMLContext.setCurrentProjectName(value);
                            if (!antXMLContext.isIgnoringProjectTag()) {
                                project.setName(value);
                                project.addReference(value, project);
                            } else if (org.apache.tools.ant.ProjectHelper.isInIncludeMode() && !"".equals(value) && org.apache.tools.ant.ProjectHelper.getCurrentTargetPrefix() != null && org.apache.tools.ant.ProjectHelper.getCurrentTargetPrefix().endsWith(org.apache.tools.ant.ProjectHelper.USE_PROJECT_NAME_AS_TARGET_PREFIX)) {
                                org.apache.tools.ant.ProjectHelper.setCurrentTargetPrefix(org.apache.tools.ant.ProjectHelper.getCurrentTargetPrefix().replace(org.apache.tools.ant.ProjectHelper.USE_PROJECT_NAME_AS_TARGET_PREFIX, value));
                            }
                            z = true;
                        }
                    } else if (!"id".equals(localName)) {
                        if (!org.apache.tools.ant.MagicNames.PROJECT_BASEDIR.equals(localName)) {
                            throw new org.xml.sax.SAXParseException("Unexpected attribute \"" + attributes.getQName(i) + "\"", antXMLContext.getLocator());
                        }
                        if (!antXMLContext.isIgnoringProjectTag()) {
                            str4 = value;
                        }
                    } else if (value != null && !antXMLContext.isIgnoringProjectTag()) {
                        project.addReference(value, project);
                    }
                }
            }
            java.lang.String str5 = "ant.file." + antXMLContext.getCurrentProjectName();
            java.lang.String property = project.getProperty(str5);
            java.lang.String str6 = "ant.file.type." + antXMLContext.getCurrentProjectName();
            java.lang.String property2 = project.getProperty(str6);
            if (property != null && z) {
                if ("url".equals(property2)) {
                    try {
                        url = new java.net.URL(property);
                        buildFileURL = antXMLContext.getBuildFileURL();
                    } catch (java.net.MalformedURLException e) {
                        throw new org.apache.tools.ant.BuildException("failed to parse " + property + " as URL while looking at a duplicate project name.", e);
                    }
                } else {
                    url = new java.io.File(property);
                    buildFileURL = antXMLContext.getBuildFile();
                }
                if (antXMLContext.isIgnoringProjectTag() && !url.equals(buildFileURL)) {
                    project.log("Duplicated project name in import. Project " + antXMLContext.getCurrentProjectName() + " defined first in " + property + " and again in " + buildFileURL, 1);
                }
            }
            if (z) {
                if (antXMLContext.getBuildFile() != null) {
                    project.setUserProperty(str5, antXMLContext.getBuildFile().toString());
                    project.setUserProperty(str6, "file");
                } else if (antXMLContext.getBuildFileURL() != null) {
                    project.setUserProperty(str5, antXMLContext.getBuildFileURL().toString());
                    project.setUserProperty(str6, "url");
                }
            }
            if (antXMLContext.isIgnoringProjectTag()) {
                return;
            }
            if (project.getProperty(org.apache.tools.ant.MagicNames.PROJECT_BASEDIR) != null) {
                project.setBasedir(project.getProperty(org.apache.tools.ant.MagicNames.PROJECT_BASEDIR));
            } else if (str4 == null) {
                project.setBasedir(antXMLContext.getBuildFileParent().getAbsolutePath());
            } else if (new java.io.File(str4).isAbsolute()) {
                project.setBasedir(str4);
            } else {
                project.setBaseDir(org.apache.tools.ant.helper.ProjectHelper2.j.resolveFile(antXMLContext.getBuildFileParent(), str4));
            }
            project.addTarget("", antXMLContext.getImplicitTarget());
            antXMLContext.setCurrentTarget(antXMLContext.getImplicitTarget());
        }
    }

    public static class RootHandler extends org.xml.sax.helpers.DefaultHandler {
        public java.util.Stack<org.apache.tools.ant.helper.ProjectHelper2.AntHandler> n;
        public org.apache.tools.ant.helper.ProjectHelper2.AntHandler t;
        public org.apache.tools.ant.helper.AntXMLContext u;

        public RootHandler(org.apache.tools.ant.helper.AntXMLContext antXMLContext, org.apache.tools.ant.helper.ProjectHelper2.AntHandler antHandler) {
            java.util.Stack<org.apache.tools.ant.helper.ProjectHelper2.AntHandler> stack = new java.util.Stack<>();
            this.n = stack;
            this.t = antHandler;
            stack.push(antHandler);
            this.u = antXMLContext;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws org.xml.sax.SAXParseException {
            this.t.characters(cArr, i, i2, this.u);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(java.lang.String str, java.lang.String str2, java.lang.String str3) throws org.xml.sax.SAXException {
            this.t.onEndElement(str, str2, this.u);
            org.apache.tools.ant.helper.ProjectHelper2.AntHandler pop = this.n.pop();
            this.t = pop;
            if (pop != null) {
                pop.onEndChild(str, str2, str3, this.u);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endPrefixMapping(java.lang.String str) {
            this.u.endPrefixMapping(str);
        }

        public org.apache.tools.ant.helper.ProjectHelper2.AntHandler getCurrentAntHandler() {
            return this.t;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.EntityResolver
        public org.xml.sax.InputSource resolveEntity(java.lang.String str, java.lang.String str2) {
            this.u.getProject().log("resolving systemId: " + str2, 3);
            if (str2.startsWith("file:")) {
                java.lang.String fromURI = org.apache.tools.ant.helper.ProjectHelper2.j.fromURI(str2);
                java.io.File file = new java.io.File(fromURI);
                if (!file.isAbsolute()) {
                    file = org.apache.tools.ant.helper.ProjectHelper2.j.resolveFile(this.u.getBuildFileParent(), fromURI);
                    this.u.getProject().log("Warning: '" + str2 + "' in " + this.u.getBuildFile() + " should be expressed simply as '" + fromURI.replace('\\', '/') + "' for compliance with other XML tools", 1);
                }
                this.u.getProject().log("file=" + file, 4);
                try {
                    org.xml.sax.InputSource inputSource = new org.xml.sax.InputSource(new java.io.FileInputStream(file));
                    inputSource.setSystemId(org.apache.tools.ant.helper.ProjectHelper2.j.toURI(file.getAbsolutePath()));
                    return inputSource;
                } catch (java.io.FileNotFoundException unused) {
                    this.u.getProject().log(file.getAbsolutePath() + " could not be found", 1);
                }
            }
            this.u.getProject().log("could not resolve systemId", 4);
            return null;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void setDocumentLocator(org.xml.sax.Locator locator) {
            this.u.setLocator(locator);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(java.lang.String str, java.lang.String str2, java.lang.String str3, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXParseException {
            org.apache.tools.ant.helper.ProjectHelper2.AntHandler onStartChild = this.t.onStartChild(str, str2, str3, attributes, this.u);
            this.n.push(this.t);
            this.t = onStartChild;
            onStartChild.onStartElement(str, str2, str3, attributes, this.u);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startPrefixMapping(java.lang.String str, java.lang.String str2) {
            this.u.startPrefixMapping(str, str2);
        }
    }

    public static class TargetHandler extends org.apache.tools.ant.helper.ProjectHelper2.AntHandler {
        public final java.lang.String a(org.apache.tools.ant.helper.AntXMLContext antXMLContext) {
            java.lang.String currentTargetPrefix = org.apache.tools.ant.ProjectHelper.getCurrentTargetPrefix();
            if (currentTargetPrefix != null && currentTargetPrefix.length() == 0) {
                currentTargetPrefix = null;
            }
            if (currentTargetPrefix != null) {
                return currentTargetPrefix;
            }
            java.lang.String currentProjectName = antXMLContext.getCurrentProjectName();
            if ("".equals(currentProjectName)) {
                return null;
            }
            return currentProjectName;
        }

        @Override // org.apache.tools.ant.helper.ProjectHelper2.AntHandler
        public void onEndElement(java.lang.String str, java.lang.String str2, org.apache.tools.ant.helper.AntXMLContext antXMLContext) {
            antXMLContext.setCurrentTarget(antXMLContext.getImplicitTarget());
        }

        @Override // org.apache.tools.ant.helper.ProjectHelper2.AntHandler
        public org.apache.tools.ant.helper.ProjectHelper2.AntHandler onStartChild(java.lang.String str, java.lang.String str2, java.lang.String str3, org.xml.sax.Attributes attributes, org.apache.tools.ant.helper.AntXMLContext antXMLContext) throws org.xml.sax.SAXParseException {
            return org.apache.tools.ant.helper.ProjectHelper2.f;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0056, code lost:
        
            if (r15.equals(r18) == false) goto L22;
         */
        @Override // org.apache.tools.ant.helper.ProjectHelper2.AntHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onStartElement(java.lang.String str, java.lang.String str2, java.lang.String str3, org.xml.sax.Attributes attributes, org.apache.tools.ant.helper.AntXMLContext antXMLContext) throws org.xml.sax.SAXParseException {
            java.lang.String str4;
            boolean z;
            java.lang.String str5;
            org.xml.sax.Attributes attributes2 = attributes;
            org.apache.tools.ant.Project project = antXMLContext.getProject();
            org.apache.tools.ant.Target target = com.umeng.ccg.a.A.equals(str2) ? new org.apache.tools.ant.Target() : new org.apache.tools.ant.ExtensionPoint();
            target.setProject(project);
            target.setLocation(new org.apache.tools.ant.Location(antXMLContext.getLocator()));
            antXMLContext.addTarget(target);
            java.lang.String str6 = "";
            int i = 0;
            java.lang.String str7 = null;
            java.lang.String str8 = null;
            org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint onMissingExtensionPoint = null;
            while (i < attributes.getLength()) {
                java.lang.String uri = attributes2.getURI(i);
                if (uri == null || uri.equals("")) {
                    str5 = str8;
                } else {
                    str5 = str8;
                }
                java.lang.String localName = attributes2.getLocalName(i);
                str8 = attributes2.getValue(i);
                if ("name".equals(localName)) {
                    if ("".equals(str8)) {
                        throw new org.apache.tools.ant.BuildException("name attribute must not be empty");
                    }
                    str7 = str8;
                } else if ("depends".equals(localName)) {
                    str6 = str8;
                } else if ("if".equals(localName)) {
                    target.setIf(str8);
                } else if ("unless".equals(localName)) {
                    target.setUnless(str8);
                } else if ("id".equals(localName)) {
                    if (str8 != null && !str8.equals("")) {
                        antXMLContext.getProject().addReference(str8, target);
                    }
                } else if ("description".equals(localName)) {
                    target.setDescription(str8);
                } else if ("extensionOf".equals(localName)) {
                    continue;
                    i++;
                    attributes2 = attributes;
                } else {
                    if (!"onMissingExtensionPoint".equals(localName)) {
                        throw new org.xml.sax.SAXParseException("Unexpected attribute \"" + localName + "\"", antXMLContext.getLocator());
                    }
                    try {
                        onMissingExtensionPoint = org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint.valueOf(str8);
                    } catch (java.lang.IllegalArgumentException unused) {
                        throw new org.apache.tools.ant.BuildException("Invalid onMissingExtensionPoint " + str8);
                    }
                }
                str8 = str5;
                i++;
                attributes2 = attributes;
            }
            java.lang.String str9 = str8;
            if (str7 == null) {
                throw new org.xml.sax.SAXParseException("target element appears without a name attribute", antXMLContext.getLocator());
            }
            boolean z2 = antXMLContext.isIgnoringProjectTag() && org.apache.tools.ant.ProjectHelper.isInIncludeMode();
            java.lang.String currentPrefixSeparator = org.apache.tools.ant.ProjectHelper.getCurrentPrefixSeparator();
            if (z2) {
                str4 = a(antXMLContext);
                if (str4 == null) {
                    throw new org.apache.tools.ant.BuildException("can't include build file " + antXMLContext.getBuildFileURL() + ", no as attribute has been given and the project tag doesn't specify a name attribute");
                }
                str7 = str4 + currentPrefixSeparator + str7;
            } else {
                str4 = null;
            }
            if (antXMLContext.getCurrentTargets().get(str7) != null) {
                throw new org.apache.tools.ant.BuildException("Duplicate target '" + str7 + "'", target.getLocation());
            }
            if (project.getTargets().containsKey(str7)) {
                project.log("Already defined in main or a previous import, ignore " + str7, 3);
                z = false;
            } else {
                target.setName(str7);
                antXMLContext.getCurrentTargets().put(str7, target);
                project.addOrReplaceTarget(str7, target);
                z = true;
            }
            if (str6.length() > 0) {
                if (z2) {
                    java.util.Iterator<java.lang.String> it = org.apache.tools.ant.Target.parseDepends(str6, str7, "depends").iterator();
                    while (it.hasNext()) {
                        target.addDependency(str4 + currentPrefixSeparator + it.next());
                    }
                } else {
                    target.setDepends(str6);
                }
            }
            if (!z2 && antXMLContext.isIgnoringProjectTag() && (str4 = a(antXMLContext)) != null) {
                java.lang.String str10 = str4 + currentPrefixSeparator + str7;
                org.apache.tools.ant.Target target2 = z ? com.umeng.ccg.a.A.equals(str2) ? new org.apache.tools.ant.Target(target) : new org.apache.tools.ant.ExtensionPoint(target) : target;
                target2.setName(str10);
                antXMLContext.getCurrentTargets().put(str10, target2);
                project.addOrReplaceTarget(str10, target2);
            }
            if (onMissingExtensionPoint != null && str9 == null) {
                throw new org.apache.tools.ant.BuildException("onMissingExtensionPoint attribute cannot be specified unless extensionOf is specified", target.getLocation());
            }
            if (str9 != null) {
                org.apache.tools.ant.ProjectHelper projectHelper = (org.apache.tools.ant.ProjectHelper) antXMLContext.getProject().getReference("ant.projectHelper");
                for (java.lang.String str11 : org.apache.tools.ant.Target.parseDepends(str9, str7, "extensionOf")) {
                    if (onMissingExtensionPoint == null) {
                        onMissingExtensionPoint = org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint.FAIL;
                    }
                    if (org.apache.tools.ant.ProjectHelper.isInIncludeMode()) {
                        projectHelper.getExtensionStack().add(new java.lang.String[]{str11, target.getName(), onMissingExtensionPoint.name(), str4 + currentPrefixSeparator});
                    } else {
                        projectHelper.getExtensionStack().add(new java.lang.String[]{str11, target.getName(), onMissingExtensionPoint.name()});
                    }
                }
            }
        }
    }

    public static org.apache.tools.ant.helper.ProjectHelper2.AntHandler getElementHandler() {
        return f;
    }

    public static org.apache.tools.ant.helper.ProjectHelper2.AntHandler getMainHandler() {
        return h;
    }

    public static org.apache.tools.ant.helper.ProjectHelper2.AntHandler getProjectHandler() {
        return i;
    }

    public static org.apache.tools.ant.helper.ProjectHelper2.AntHandler getTargetHandler() {
        return g;
    }

    public static void setElementHandler(org.apache.tools.ant.helper.ProjectHelper2.AntHandler antHandler) {
        f = antHandler;
    }

    public static void setMainHandler(org.apache.tools.ant.helper.ProjectHelper2.AntHandler antHandler) {
        h = antHandler;
    }

    public static void setProjectHandler(org.apache.tools.ant.helper.ProjectHelper2.AntHandler antHandler) {
        i = antHandler;
    }

    public static void setTargetHandler(org.apache.tools.ant.helper.ProjectHelper2.AntHandler antHandler) {
        g = antHandler;
    }

    @Override // org.apache.tools.ant.ProjectHelper
    public boolean canParseAntlibDescriptor(org.apache.tools.ant.types.Resource resource) {
        return true;
    }

    @Override // org.apache.tools.ant.ProjectHelper
    public void parse(org.apache.tools.ant.Project project, java.lang.Object obj) throws org.apache.tools.ant.BuildException {
        getImportStack().addElement(obj);
        org.apache.tools.ant.helper.AntXMLContext antXMLContext = (org.apache.tools.ant.helper.AntXMLContext) project.getReference("ant.parsing.context");
        if (antXMLContext == null) {
            antXMLContext = new org.apache.tools.ant.helper.AntXMLContext(project);
            project.addReference("ant.parsing.context", antXMLContext);
            project.addReference(REFID_TARGETS, antXMLContext.getTargets());
        }
        if (getImportStack().size() <= 1) {
            antXMLContext.setCurrentTargets(new java.util.HashMap());
            parse(project, obj, new org.apache.tools.ant.helper.ProjectHelper2.RootHandler(antXMLContext, h));
            antXMLContext.getImplicitTarget().execute();
            resolveExtensionOfAttributes(project);
            return;
        }
        antXMLContext.setIgnoreProjectTag(true);
        org.apache.tools.ant.Target currentTarget = antXMLContext.getCurrentTarget();
        org.apache.tools.ant.Target implicitTarget = antXMLContext.getImplicitTarget();
        java.util.Map<java.lang.String, org.apache.tools.ant.Target> currentTargets = antXMLContext.getCurrentTargets();
        try {
            org.apache.tools.ant.Target target = new org.apache.tools.ant.Target();
            target.setProject(project);
            target.setName("");
            antXMLContext.setCurrentTarget(target);
            antXMLContext.setCurrentTargets(new java.util.HashMap());
            antXMLContext.setImplicitTarget(target);
            parse(project, obj, new org.apache.tools.ant.helper.ProjectHelper2.RootHandler(antXMLContext, h));
            target.execute();
        } finally {
            antXMLContext.setCurrentTarget(currentTarget);
            antXMLContext.setImplicitTarget(implicitTarget);
            antXMLContext.setCurrentTargets(currentTargets);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0065 A[Catch: all -> 0x0108, IOException -> 0x010c, UnsupportedEncodingException -> 0x0131, FileNotFoundException -> 0x014f, SAXException -> 0x0157, SAXParseException -> 0x0172, TryCatch #6 {FileNotFoundException -> 0x014f, UnsupportedEncodingException -> 0x0131, IOException -> 0x010c, SAXParseException -> 0x0172, SAXException -> 0x0157, all -> 0x0108, blocks: (B:8:0x005f, B:10:0x0065, B:57:0x0078, B:59:0x0084, B:61:0x008d, B:65:0x00a7), top: B:7:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00bd A[Catch: IOException -> 0x00fd, UnsupportedEncodingException -> 0x00ff, FileNotFoundException -> 0x0101, SAXException -> 0x0103, SAXParseException -> 0x0105, all -> 0x01a9, TryCatch #7 {all -> 0x01a9, blocks: (B:11:0x00b6, B:13:0x00bd, B:14:0x00c0, B:17:0x00dc, B:64:0x009a, B:29:0x010e, B:30:0x0130, B:26:0x0133, B:27:0x014e, B:23:0x0151, B:24:0x0156, B:46:0x0159, B:48:0x0161, B:51:0x016b, B:52:0x016e, B:54:0x016f, B:55:0x0171, B:32:0x0174, B:34:0x018d, B:36:0x0197, B:37:0x019a, B:39:0x019b, B:42:0x01a5, B:43:0x01a8), top: B:7:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0078 A[Catch: all -> 0x0108, IOException -> 0x010c, UnsupportedEncodingException -> 0x0131, FileNotFoundException -> 0x014f, SAXException -> 0x0157, SAXParseException -> 0x0172, TryCatch #6 {FileNotFoundException -> 0x014f, UnsupportedEncodingException -> 0x0131, IOException -> 0x010c, SAXParseException -> 0x0172, SAXException -> 0x0157, all -> 0x0108, blocks: (B:8:0x005f, B:10:0x0065, B:57:0x0078, B:59:0x0084, B:61:0x008d, B:65:0x00a7), top: B:7:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0053  */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parse(org.apache.tools.ant.Project project, java.lang.Object obj, org.apache.tools.ant.helper.ProjectHelper2.RootHandler rootHandler) throws org.apache.tools.ant.BuildException {
        java.io.File file;
        org.apache.tools.zip.ZipFile zipFile;
        java.net.URL url;
        java.lang.String url2;
        java.lang.String url3;
        org.apache.tools.zip.ZipFile zipFile2;
        java.io.InputStream inputStream;
        int indexOf;
        org.apache.tools.ant.helper.AntXMLContext antXMLContext = rootHandler.u;
        try {
            try {
                if (!(obj instanceof java.io.File)) {
                    if (!(obj instanceof java.net.URL)) {
                        if (obj instanceof org.apache.tools.ant.types.Resource) {
                            org.apache.tools.ant.types.Resource resource = (org.apache.tools.ant.types.Resource) obj;
                            org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
                            if (fileProvider != null) {
                                file = fileProvider.getFile();
                            } else {
                                org.apache.tools.ant.types.resources.URLProvider uRLProvider = (org.apache.tools.ant.types.resources.URLProvider) resource.as(org.apache.tools.ant.types.resources.URLProvider.class);
                                if (uRLProvider != null) {
                                    url = uRLProvider.getURL();
                                }
                            }
                        }
                        file = null;
                        zipFile = 0;
                        if (file != null) {
                            file = j.normalize(file.getAbsolutePath());
                            antXMLContext.setBuildFile(file);
                            url2 = file.toString();
                        } else {
                            if (zipFile == 0) {
                                throw new org.apache.tools.ant.BuildException("Source " + obj.getClass().getName() + " not supported by this plugin");
                            }
                            try {
                                antXMLContext.setBuildFile((java.io.File) null);
                                antXMLContext.setBuildFile((java.net.URL) zipFile);
                                url2 = zipFile.toString();
                            } catch (java.net.MalformedURLException e) {
                                throw new org.apache.tools.ant.BuildException(e);
                            }
                        }
                        org.xml.sax.XMLReader namespaceXMLReader = org.apache.tools.ant.util.JAXPUtils.getNamespaceXMLReader();
                        if (file != null) {
                            java.lang.String uri = j.toURI(file.getAbsolutePath());
                            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                            url3 = uri;
                            zipFile2 = null;
                            inputStream = fileInputStream;
                        } else {
                            url3 = zipFile.toString();
                            if (!url3.startsWith("jar:file") || (indexOf = url3.indexOf("!/")) <= -1) {
                                java.net.URLConnection openConnection = zipFile.openConnection();
                                openConnection.setUseCaches(false);
                                java.io.InputStream inputStream2 = openConnection.getInputStream();
                                zipFile2 = null;
                                inputStream = inputStream2;
                            } else {
                                zipFile2 = new org.apache.tools.zip.ZipFile(org.apache.tools.ant.launch.Locator.fromJarURI(url3), "UTF-8");
                                try {
                                    inputStream = zipFile2.getInputStream(zipFile2.getEntry(url3.substring(indexOf + 2)));
                                } catch (java.io.FileNotFoundException e2) {
                                    e = e2;
                                    throw new org.apache.tools.ant.BuildException(e);
                                } catch (java.io.UnsupportedEncodingException e3) {
                                    e = e3;
                                    throw new org.apache.tools.ant.BuildException("Encoding of project file " + url2 + " is invalid.", e);
                                } catch (java.io.IOException e4) {
                                    e = e4;
                                    throw new org.apache.tools.ant.BuildException("Error reading project file " + url2 + ": " + e.getMessage(), e);
                                } catch (org.xml.sax.SAXParseException e5) {
                                    e = e5;
                                    org.apache.tools.ant.Location location = new org.apache.tools.ant.Location(e.getSystemId(), e.getLineNumber(), e.getColumnNumber());
                                    java.lang.Exception exception = e.getException();
                                    if (!(exception instanceof org.apache.tools.ant.BuildException)) {
                                        java.lang.String message = e.getMessage();
                                        if (exception != null) {
                                            e = exception;
                                        }
                                        throw new org.apache.tools.ant.BuildException(message, e, location);
                                    }
                                    org.apache.tools.ant.BuildException buildException = (org.apache.tools.ant.BuildException) exception;
                                    if (buildException.getLocation() != org.apache.tools.ant.Location.UNKNOWN_LOCATION) {
                                        throw buildException;
                                    }
                                    buildException.setLocation(location);
                                    throw buildException;
                                } catch (org.xml.sax.SAXException e6) {
                                    e = e6;
                                    java.lang.Exception exception2 = e.getException();
                                    if (exception2 instanceof org.apache.tools.ant.BuildException) {
                                        throw ((org.apache.tools.ant.BuildException) exception2);
                                    }
                                    java.lang.String message2 = e.getMessage();
                                    if (exception2 != null) {
                                        e = exception2;
                                    }
                                    throw new org.apache.tools.ant.BuildException(message2, e);
                                }
                            }
                        }
                        org.xml.sax.InputSource inputSource = new org.xml.sax.InputSource(inputStream);
                        if (url3 != null) {
                            inputSource.setSystemId(url3);
                        }
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("parsing buildfile ");
                        sb.append(url2);
                        sb.append(" with URI = ");
                        sb.append(url3);
                        sb.append(zipFile2 != null ? " from a zip file" : "");
                        project.log(sb.toString(), 3);
                        namespaceXMLReader.setContentHandler(rootHandler);
                        namespaceXMLReader.setEntityResolver(rootHandler);
                        namespaceXMLReader.setErrorHandler(rootHandler);
                        namespaceXMLReader.setDTDHandler(rootHandler);
                        namespaceXMLReader.parse(inputSource);
                        org.apache.tools.ant.util.FileUtils.close(inputStream);
                        org.apache.tools.zip.ZipFile.closeQuietly(zipFile2);
                        return;
                    }
                    url = (java.net.URL) obj;
                    zipFile = url;
                    file = null;
                    if (file != null) {
                    }
                    org.xml.sax.XMLReader namespaceXMLReader2 = org.apache.tools.ant.util.JAXPUtils.getNamespaceXMLReader();
                    if (file != null) {
                    }
                    org.xml.sax.InputSource inputSource2 = new org.xml.sax.InputSource(inputStream);
                    if (url3 != null) {
                    }
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("parsing buildfile ");
                    sb2.append(url2);
                    sb2.append(" with URI = ");
                    sb2.append(url3);
                    sb2.append(zipFile2 != null ? " from a zip file" : "");
                    project.log(sb2.toString(), 3);
                    namespaceXMLReader2.setContentHandler(rootHandler);
                    namespaceXMLReader2.setEntityResolver(rootHandler);
                    namespaceXMLReader2.setErrorHandler(rootHandler);
                    namespaceXMLReader2.setDTDHandler(rootHandler);
                    namespaceXMLReader2.parse(inputSource2);
                    org.apache.tools.ant.util.FileUtils.close(inputStream);
                    org.apache.tools.zip.ZipFile.closeQuietly(zipFile2);
                    return;
                }
                file = (java.io.File) obj;
                org.xml.sax.XMLReader namespaceXMLReader22 = org.apache.tools.ant.util.JAXPUtils.getNamespaceXMLReader();
                if (file != null) {
                }
                org.xml.sax.InputSource inputSource22 = new org.xml.sax.InputSource(inputStream);
                if (url3 != null) {
                }
                java.lang.StringBuilder sb22 = new java.lang.StringBuilder();
                sb22.append("parsing buildfile ");
                sb22.append(url2);
                sb22.append(" with URI = ");
                sb22.append(url3);
                sb22.append(zipFile2 != null ? " from a zip file" : "");
                project.log(sb22.toString(), 3);
                namespaceXMLReader22.setContentHandler(rootHandler);
                namespaceXMLReader22.setEntityResolver(rootHandler);
                namespaceXMLReader22.setErrorHandler(rootHandler);
                namespaceXMLReader22.setDTDHandler(rootHandler);
                namespaceXMLReader22.parse(inputSource22);
                org.apache.tools.ant.util.FileUtils.close(inputStream);
                org.apache.tools.zip.ZipFile.closeQuietly(zipFile2);
                return;
            } catch (java.lang.Throwable th) {
                th = th;
                org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) null);
                org.apache.tools.zip.ZipFile.closeQuietly(zipFile);
                throw th;
            }
        } catch (java.io.FileNotFoundException e7) {
            e = e7;
        } catch (java.io.UnsupportedEncodingException e8) {
            e = e8;
        } catch (java.io.IOException e9) {
            e = e9;
        } catch (org.xml.sax.SAXParseException e10) {
            e = e10;
        } catch (org.xml.sax.SAXException e11) {
            e = e11;
        } catch (java.lang.Throwable th2) {
            th = th2;
            zipFile = 0;
            org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) null);
            org.apache.tools.zip.ZipFile.closeQuietly(zipFile);
            throw th;
        }
        zipFile = 0;
        if (file != null) {
        }
    }

    @Override // org.apache.tools.ant.ProjectHelper
    public org.apache.tools.ant.UnknownElement parseAntlibDescriptor(org.apache.tools.ant.Project project, org.apache.tools.ant.types.Resource resource) {
        org.apache.tools.ant.types.resources.URLProvider uRLProvider = (org.apache.tools.ant.types.resources.URLProvider) resource.as(org.apache.tools.ant.types.resources.URLProvider.class);
        if (uRLProvider != null) {
            return parseUnknownElement(project, uRLProvider.getURL());
        }
        throw new org.apache.tools.ant.BuildException("Unsupported resource type: " + resource);
    }

    public org.apache.tools.ant.UnknownElement parseUnknownElement(org.apache.tools.ant.Project project, java.net.URL url) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.Target target = new org.apache.tools.ant.Target();
        target.setProject(project);
        org.apache.tools.ant.helper.AntXMLContext antXMLContext = new org.apache.tools.ant.helper.AntXMLContext(project);
        antXMLContext.addTarget(target);
        antXMLContext.setImplicitTarget(target);
        parse(antXMLContext.getProject(), url, new org.apache.tools.ant.helper.ProjectHelper2.RootHandler(antXMLContext, f));
        org.apache.tools.ant.Task[] tasks = target.getTasks();
        if (tasks.length == 1) {
            return (org.apache.tools.ant.UnknownElement) tasks[0];
        }
        throw new org.apache.tools.ant.BuildException("No tasks defined");
    }
}
