package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class DescriptorHandler extends org.xml.sax.HandlerBase {
    public org.apache.tools.ant.Task n;
    public java.io.File z;
    public java.lang.String t = null;
    public int u = 1;
    protected java.lang.String currentElement = null;
    protected java.lang.String currentText = null;
    protected java.util.Hashtable ejbFiles = null;
    protected java.lang.String ejbName = null;
    public java.util.Hashtable v = new java.util.Hashtable();
    public java.util.Hashtable w = new java.util.Hashtable();
    public boolean x = false;
    public java.util.Hashtable y = new java.util.Hashtable();

    public DescriptorHandler(org.apache.tools.ant.Task task, java.io.File file) {
        this.n = task;
        this.z = file;
    }

    @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
    public void characters(char[] cArr, int i, int i2) throws org.xml.sax.SAXException {
        this.currentText += new java.lang.String(cArr, i, i2);
    }

    @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
    public void endElement(java.lang.String str) throws org.xml.sax.SAXException {
        processElement();
        this.currentText = "";
        this.currentElement = "";
        if (str.equals("ejb-ref") || str.equals("ejb-local-ref")) {
            this.x = false;
            return;
        }
        if (this.u == 5 && str.equals("entity")) {
            this.u = 3;
            return;
        }
        if (this.u == 4 && str.equals(com.umeng.analytics.pro.f.aC)) {
            this.u = 3;
            return;
        }
        if (this.u == 6 && str.equals("message-driven")) {
            this.u = 3;
            return;
        }
        if (this.u == 3 && str.equals("enterprise-beans")) {
            this.u = 2;
        } else if (this.u == 2 && str.equals("ejb-jar")) {
            this.u = 1;
        }
    }

    public java.lang.String getEjbName() {
        return this.ejbName;
    }

    public java.util.Hashtable getFiles() {
        java.util.Hashtable hashtable = this.ejbFiles;
        return hashtable == null ? new java.util.Hashtable() : hashtable;
    }

    public java.lang.String getPublicId() {
        return this.t;
    }

    public void processElement() {
        if (this.x) {
            return;
        }
        int i = this.u;
        if (i == 5 || i == 4 || i == 6) {
            if ("home".equals(this.currentElement) || "remote".equals(this.currentElement) || "local".equals(this.currentElement) || "local-home".equals(this.currentElement) || "ejb-class".equals(this.currentElement) || "prim-key-class".equals(this.currentElement)) {
                java.lang.String trim = this.currentText.trim();
                if (!trim.startsWith("java.") && !trim.startsWith("javax.")) {
                    java.lang.String str = trim.replace('.', java.io.File.separatorChar) + ".class";
                    this.ejbFiles.put(str, new java.io.File(this.z, str));
                }
            }
            if (this.currentElement.equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.EJB_NAME) && this.ejbName == null) {
                this.ejbName = this.currentText.trim();
            }
        }
    }

    public void registerDTD(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            return;
        }
        java.io.File file = new java.io.File(str2);
        if (!file.exists()) {
            file = this.n.getProject().resolveFile(str2);
        }
        if (file.exists()) {
            if (str != null) {
                this.v.put(str, file);
                this.n.log("Mapped publicId " + str + " to file " + file, 3);
                return;
            }
            return;
        }
        if (getClass().getResource(str2) != null && str != null) {
            this.w.put(str, str2);
            this.n.log("Mapped publicId " + str + " to resource " + str2, 3);
        }
        if (str != null) {
            try {
                this.y.put(str, new java.net.URL(str2));
            } catch (java.net.MalformedURLException unused) {
            }
        }
    }

    @Override // org.xml.sax.HandlerBase, org.xml.sax.EntityResolver
    public org.xml.sax.InputSource resolveEntity(java.lang.String str, java.lang.String str2) throws org.xml.sax.SAXException {
        java.io.InputStream resourceAsStream;
        this.t = str;
        java.io.File file = (java.io.File) this.v.get(str);
        if (file != null) {
            try {
                this.n.log("Resolved " + str + " to local file " + file, 3);
                return new org.xml.sax.InputSource(new java.io.FileInputStream(file));
            } catch (java.io.FileNotFoundException unused) {
            }
        }
        java.lang.String str3 = (java.lang.String) this.w.get(str);
        if (str3 != null && (resourceAsStream = getClass().getResourceAsStream(str3)) != null) {
            this.n.log("Resolved " + str + " to local resource " + str3, 3);
            return new org.xml.sax.InputSource(resourceAsStream);
        }
        java.net.URL url = (java.net.URL) this.y.get(str);
        if (url != null) {
            try {
                java.io.InputStream openStream = url.openStream();
                this.n.log("Resolved " + str + " to url " + url, 3);
                return new org.xml.sax.InputSource(openStream);
            } catch (java.io.IOException unused2) {
            }
        }
        this.n.log("Could not resolve (publicId: " + str + ", systemId: " + str2 + ") to a local entity", 2);
        return null;
    }

    @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
    public void startDocument() throws org.xml.sax.SAXException {
        this.ejbFiles = new java.util.Hashtable(10, 1.0f);
        this.currentElement = null;
        this.x = false;
    }

    @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
    public void startElement(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXException {
        this.currentElement = str;
        this.currentText = "";
        if (str.equals("ejb-ref") || str.equals("ejb-local-ref")) {
            this.x = true;
            return;
        }
        if (this.u == 1 && str.equals("ejb-jar")) {
            this.u = 2;
            return;
        }
        if (this.u == 2 && str.equals("enterprise-beans")) {
            this.u = 3;
            return;
        }
        if (this.u == 3 && str.equals(com.umeng.analytics.pro.f.aC)) {
            this.u = 4;
            return;
        }
        if (this.u == 3 && str.equals("entity")) {
            this.u = 5;
        } else if (this.u == 3 && str.equals("message-driven")) {
            this.u = 6;
        }
    }
}
