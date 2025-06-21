package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class XMLFragment extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.DynamicElementNS {
    public org.w3c.dom.Document n;
    public org.w3c.dom.DocumentFragment t;

    public class Child implements org.apache.tools.ant.DynamicConfiguratorNS {
        public org.w3c.dom.Element n;

        public Child(org.w3c.dom.Element element) {
            this.n = element;
        }

        public void addText(java.lang.String str) {
            org.apache.tools.ant.util.XMLFragment.this.c(this.n, str);
        }

        @Override // org.apache.tools.ant.DynamicElementNS
        public java.lang.Object createDynamicElement(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            org.w3c.dom.Element createElement = str.equals("") ? org.apache.tools.ant.util.XMLFragment.this.n.createElement(str2) : org.apache.tools.ant.util.XMLFragment.this.n.createElementNS(str, str3);
            this.n.appendChild(createElement);
            return org.apache.tools.ant.util.XMLFragment.this.new Child(createElement);
        }

        @Override // org.apache.tools.ant.DynamicAttributeNS
        public void setDynamicAttribute(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            if (str.equals("")) {
                this.n.setAttribute(str2, str4);
            } else {
                this.n.setAttributeNS(str, str3, str4);
            }
        }
    }

    public XMLFragment() {
        org.w3c.dom.Document newDocument = org.apache.tools.ant.util.JAXPUtils.getDocumentBuilder().newDocument();
        this.n = newDocument;
        this.t = newDocument.createDocumentFragment();
    }

    public void addText(java.lang.String str) {
        c(this.t, str);
    }

    public final void c(org.w3c.dom.Node node, java.lang.String str) {
        java.lang.String replaceProperties = getProject().replaceProperties(str);
        if (replaceProperties == null || replaceProperties.trim().equals("")) {
            return;
        }
        node.appendChild(this.n.createTextNode(replaceProperties.trim()));
    }

    @Override // org.apache.tools.ant.DynamicElementNS
    public java.lang.Object createDynamicElement(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        org.w3c.dom.Element createElement = str.equals("") ? this.n.createElement(str2) : this.n.createElementNS(str, str3);
        this.t.appendChild(createElement);
        return new org.apache.tools.ant.util.XMLFragment.Child(createElement);
    }

    public org.w3c.dom.DocumentFragment getFragment() {
        return this.t;
    }
}
