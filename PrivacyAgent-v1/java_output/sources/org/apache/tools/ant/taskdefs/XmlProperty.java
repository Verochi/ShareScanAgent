package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class XmlProperty extends org.apache.tools.ant.Task {
    public static final java.lang.String[] F = {"id", "refid", com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION, "value", "path", "pathid"};
    public static final org.apache.tools.ant.util.FileUtils G = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public org.apache.tools.ant.types.Resource u;
    public java.lang.String v = "";
    public boolean w = true;
    public boolean x = false;
    public boolean y = false;
    public boolean z = false;
    public boolean A = false;
    public java.io.File B = null;
    public java.util.Hashtable C = new java.util.Hashtable();
    public org.apache.tools.ant.types.XMLCatalog D = new org.apache.tools.ant.types.XMLCatalog();
    public java.lang.String E = ",";

    public static boolean g(java.lang.String str) {
        int i = 0;
        while (true) {
            java.lang.String[] strArr = F;
            if (i >= strArr.length) {
                return false;
            }
            if (str.equals(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    public void addConfigured(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (resourceCollection.size() != 1) {
            throw new org.apache.tools.ant.BuildException("only single argument resource collections are supported as archives");
        }
        setSrcResource(resourceCollection.iterator().next());
    }

    public void addConfiguredXMLCatalog(org.apache.tools.ant.types.XMLCatalog xMLCatalog) {
        this.D.addConfiguredXMLCatalog(xMLCatalog);
    }

    public final void c(org.w3c.dom.Node node, java.lang.String str, java.lang.Object obj) {
        if (node.getNodeType() != 3) {
            if (str.trim().length() > 0) {
                str = str + ".";
            }
            str = str + node.getNodeName();
        }
        java.lang.Object processNode = processNode(node, str, obj);
        if (node.hasChildNodes()) {
            org.w3c.dom.NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                c(childNodes.item(i), str, processNode);
            }
        }
    }

    public final void d(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4 = str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2;
        if (str3 != null) {
            str4 = str4 + "(id=" + str3 + ")";
        }
        log(str4, 4);
        if (this.C.containsKey(str)) {
            str2 = ((java.lang.String) this.C.get(str)) + getDelimiter() + str2;
            getProject().setProperty(str, str2);
            this.C.put(str, str2);
        } else if (getProject().getProperty(str) == null) {
            getProject().setNewProperty(str, str2);
            this.C.put(str, str2);
        } else {
            log("Override ignored for property " + str, 3);
        }
        if (str3 != null) {
            getProject().addReference(str3, str2);
        }
    }

    public final java.lang.String e(org.w3c.dom.Node node) {
        java.lang.StringBuilder sb;
        java.lang.String nodeName = node.getNodeName();
        if (this.z) {
            if (nodeName.equals("refid")) {
                return "";
            }
            if (g(nodeName) && !this.A) {
                return "";
            }
            return "." + nodeName;
        }
        if (this.y) {
            sb = new java.lang.StringBuilder();
            sb.append(".");
        } else {
            sb = new java.lang.StringBuilder();
            sb.append("(");
            sb.append(nodeName);
            nodeName = ")";
        }
        sb.append(nodeName);
        return sb.toString();
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Resource resource = getResource();
        if (resource == null) {
            throw new org.apache.tools.ant.BuildException("XmlProperty task requires a source resource");
        }
        try {
            log("Loading " + this.u, 3);
            if (!resource.isExists()) {
                log("Unable to find property resource: " + resource, 3);
                return;
            }
            javax.xml.parsers.DocumentBuilderFactory newInstance = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            newInstance.setValidating(this.x);
            newInstance.setNamespaceAware(false);
            javax.xml.parsers.DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
            newDocumentBuilder.setEntityResolver(getEntityResolver());
            org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) this.u.as(org.apache.tools.ant.types.resources.FileProvider.class);
            org.w3c.dom.Element documentElement = (fileProvider != null ? newDocumentBuilder.parse(fileProvider.getFile()) : newDocumentBuilder.parse(this.u.getInputStream())).getDocumentElement();
            this.C = new java.util.Hashtable();
            if (this.w) {
                c(documentElement, this.v, null);
                return;
            }
            org.w3c.dom.NodeList childNodes = documentElement.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                c(childNodes.item(i), this.v, null);
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Failed to load " + this.u, e);
        } catch (javax.xml.parsers.ParserConfigurationException e2) {
            throw new org.apache.tools.ant.BuildException(e2);
        } catch (org.xml.sax.SAXException e3) {
            java.lang.Exception exception = e3.getException();
            java.lang.Exception exc = e3;
            if (exception != null) {
                exc = e3.getException();
            }
            throw new org.apache.tools.ant.BuildException("Failed to load " + this.u, exc);
        }
    }

    public final java.lang.String f(org.w3c.dom.Node node) {
        java.lang.Object reference;
        java.lang.String trim = node.getNodeValue().trim();
        if (this.z) {
            java.lang.String nodeName = node.getNodeName();
            trim = getProject().replaceProperties(trim);
            if (nodeName.equals(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION)) {
                return h(trim).getPath();
            }
            if (nodeName.equals("refid") && (reference = getProject().getReference(trim)) != null) {
                return reference.toString();
            }
        }
        return trim;
    }

    public boolean getCollapseAttributes() {
        return this.y;
    }

    public java.lang.String getDelimiter() {
        return this.E;
    }

    public org.xml.sax.EntityResolver getEntityResolver() {
        return this.D;
    }

    public java.io.File getFile() {
        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) this.u.as(org.apache.tools.ant.types.resources.FileProvider.class);
        if (fileProvider != null) {
            return fileProvider.getFile();
        }
        return null;
    }

    public boolean getIncludeSemanticAttribute() {
        return this.A;
    }

    @java.lang.Deprecated
    public boolean getIncludeSementicAttribute() {
        return getIncludeSemanticAttribute();
    }

    public boolean getKeeproot() {
        return this.w;
    }

    public java.lang.String getPrefix() {
        return this.v;
    }

    public org.apache.tools.ant.types.Resource getResource() {
        java.io.File file = getFile();
        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) this.u.as(org.apache.tools.ant.types.resources.FileProvider.class);
        return file == null ? this.u : (fileProvider == null || !fileProvider.getFile().equals(file)) ? new org.apache.tools.ant.types.resources.FileResource(file) : this.u;
    }

    public java.io.File getRootDirectory() {
        return this.B;
    }

    public boolean getSemanticAttributes() {
        return this.z;
    }

    public boolean getValidate() {
        return this.x;
    }

    public final java.io.File h(java.lang.String str) {
        org.apache.tools.ant.util.FileUtils fileUtils = G;
        java.io.File file = this.B;
        if (file == null) {
            file = getProject().getBaseDir();
        }
        return fileUtils.resolveFile(file, str);
    }

    @Override // org.apache.tools.ant.Task
    public void init() {
        super.init();
        this.D.setProject(getProject());
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x0166, code lost:
    
        if (r3 == false) goto L100;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Object processNode(org.w3c.dom.Node node, java.lang.String str, java.lang.Object obj) {
        java.lang.String str2;
        org.apache.tools.ant.types.Path path;
        java.lang.String str3;
        org.w3c.dom.NamedNodeMap namedNodeMap;
        java.lang.String str4 = null;
        if (node.hasAttributes()) {
            org.w3c.dom.NamedNodeMap attributes = node.getAttributes();
            org.w3c.dom.Node namedItem = attributes.getNamedItem("id");
            str2 = (!this.z || namedItem == null) ? null : namedItem.getNodeValue();
            path = null;
            int i = 0;
            while (i < attributes.getLength()) {
                org.w3c.dom.Node item = attributes.item(i);
                if (this.z) {
                    java.lang.String nodeName = item.getNodeName();
                    java.lang.String f = f(item);
                    org.apache.tools.ant.types.Path path2 = (obj == null || !(obj instanceof org.apache.tools.ant.types.Path)) ? null : (org.apache.tools.ant.types.Path) obj;
                    if (!nodeName.equals("id")) {
                        if (path2 == null || !nodeName.equals("path")) {
                            namedNodeMap = attributes;
                            if (path2 != null && (obj instanceof org.apache.tools.ant.types.Path) && nodeName.equals("refid")) {
                                path2.setPath(f);
                            } else if (path2 != null && (obj instanceof org.apache.tools.ant.types.Path) && nodeName.equals(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION)) {
                                path2.setLocation(h(f));
                            } else if (!nodeName.equals("pathid")) {
                                d(str + e(item), f, str2);
                            } else {
                                if (obj != null) {
                                    throw new org.apache.tools.ant.BuildException("XmlProperty does not support nested paths");
                                }
                                path = new org.apache.tools.ant.types.Path(getProject());
                                getProject().addReference(f, path);
                            }
                            i++;
                            attributes = namedNodeMap;
                            str4 = null;
                        } else {
                            path2.setPath(f);
                        }
                    }
                } else {
                    java.lang.String e = e(item);
                    d(str + e, f(item), str4);
                }
                namedNodeMap = attributes;
                i++;
                attributes = namedNodeMap;
                str4 = null;
            }
        } else {
            str2 = null;
            path = null;
        }
        boolean z = true;
        boolean z2 = node.getNodeType() == 1 && this.z && node.hasAttributes() && !(node.getAttributes().getNamedItem("value") == null && node.getAttributes().getNamedItem(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION) == null && node.getAttributes().getNamedItem("refid") == null && node.getAttributes().getNamedItem("path") == null && node.getAttributes().getNamedItem("pathid") == null);
        if (node.getNodeType() != 3) {
            if (node.getNodeType() == 1 && node.getChildNodes().getLength() == 1 && node.getFirstChild().getNodeType() == 4) {
                str3 = node.getFirstChild().getNodeValue();
                if ("".equals(str3)) {
                }
            } else if ((node.getNodeType() == 1 && node.getChildNodes().getLength() == 0 && !z2) || (node.getNodeType() == 1 && node.getChildNodes().getLength() == 1 && node.getFirstChild().getNodeType() == 3 && "".equals(node.getFirstChild().getNodeValue()) && !z2)) {
                str3 = "";
            } else {
                z = false;
                str3 = null;
            }
            if (str3 != null) {
                if (this.z && str2 == null && (obj instanceof java.lang.String)) {
                    str2 = (java.lang.String) obj;
                }
                if (str3.trim().length() != 0 || z) {
                    d(str, str3, str2);
                }
            }
            return path == null ? path : str2;
        }
        str3 = f(node);
        z = false;
        if (str3 != null) {
        }
        if (path == null) {
        }
    }

    public void setCollapseAttributes(boolean z) {
        this.y = z;
    }

    public void setDelimiter(java.lang.String str) {
        this.E = str;
    }

    public void setFile(java.io.File file) {
        setSrcResource(new org.apache.tools.ant.types.resources.FileResource(file));
    }

    public void setIncludeSemanticAttribute(boolean z) {
        this.A = z;
    }

    public void setKeeproot(boolean z) {
        this.w = z;
    }

    public void setPrefix(java.lang.String str) {
        this.v = str.trim();
    }

    public void setRootDirectory(java.io.File file) {
        this.B = file;
    }

    public void setSemanticAttributes(boolean z) {
        this.z = z;
    }

    public void setSrcResource(org.apache.tools.ant.types.Resource resource) {
        if (resource.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("the source can't be a directory");
        }
        if (resource.as(org.apache.tools.ant.types.resources.FileProvider.class) == null && !supportsNonFileResources()) {
            throw new org.apache.tools.ant.BuildException("Only FileSystem resources are supported.");
        }
        this.u = resource;
    }

    public void setValidate(boolean z) {
        this.x = z;
    }

    public boolean supportsNonFileResources() {
        return getClass().equals(org.apache.tools.ant.taskdefs.XmlProperty.class);
    }
}
