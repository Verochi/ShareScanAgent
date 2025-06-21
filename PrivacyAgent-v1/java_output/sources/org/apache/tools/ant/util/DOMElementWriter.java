package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class DOMElementWriter {
    public static final java.lang.String[] f = new java.lang.String[5];
    public static java.lang.String g;
    public boolean a;
    public org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy b;
    public java.util.HashMap c;
    public int d;
    public java.util.HashMap e;
    protected java.lang.String[] knownEntities;

    public static class XmlNamespacePolicy {
        public static final org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy IGNORE = new org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy(false, false);
        public static final org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy ONLY_QUALIFY_ELEMENTS = new org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy(true, false);
        public static final org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy QUALIFY_ALL = new org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy(true, true);
        public boolean a;
        public boolean b;

        public XmlNamespacePolicy(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }
    }

    static {
        for (int i = 9; i < 14; i++) {
            f[i - 9] = "&#x" + java.lang.Integer.toHexString(i) + com.alipay.sdk.m.u.i.b;
        }
        g = java.lang.System.getProperty("line.separator");
    }

    public DOMElementWriter() {
        this.a = true;
        this.b = org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy.IGNORE;
        this.c = new java.util.HashMap();
        this.d = 0;
        this.e = new java.util.HashMap();
        this.knownEntities = new java.lang.String[]{"gt", "amp", "lt", "apos", "quot"};
    }

    public DOMElementWriter(boolean z) {
        this(z, org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy.IGNORE);
    }

    public DOMElementWriter(boolean z, org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy xmlNamespacePolicy) {
        this.a = true;
        this.b = org.apache.tools.ant.util.DOMElementWriter.XmlNamespacePolicy.IGNORE;
        this.c = new java.util.HashMap();
        this.d = 0;
        this.e = new java.util.HashMap();
        this.knownEntities = new java.lang.String[]{"gt", "amp", "lt", "apos", "quot"};
        this.a = z;
        this.b = xmlNamespacePolicy;
    }

    public static java.lang.String c(org.w3c.dom.Node node) {
        java.lang.String namespaceURI = node.getNamespaceURI();
        return namespaceURI == null ? "" : namespaceURI;
    }

    public final void a(org.w3c.dom.Element element, java.lang.String str) {
        java.util.ArrayList arrayList = (java.util.ArrayList) this.e.get(element);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList();
            this.e.put(element, arrayList);
        }
        arrayList.add(str);
    }

    public final java.lang.String b(java.lang.String str, boolean z) {
        int length = str.length();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\t' || charAt == '\n' || charAt == '\r') {
                if (z) {
                    stringBuffer.append(f[charAt - '\t']);
                } else {
                    stringBuffer.append(charAt);
                }
            } else if (charAt == '\"') {
                stringBuffer.append("&quot;");
            } else if (charAt == '<') {
                stringBuffer.append("&lt;");
            } else if (charAt == '>') {
                stringBuffer.append("&gt;");
            } else if (charAt == '&') {
                stringBuffer.append("&amp;");
            } else if (charAt == '\'') {
                stringBuffer.append("&apos;");
            } else if (isLegalCharacter(charAt)) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.substring(0);
    }

    public void closeElement(org.w3c.dom.Element element, java.io.Writer writer, int i, java.lang.String str, boolean z) throws java.io.IOException {
        if (z) {
            for (int i2 = 0; i2 < i; i2++) {
                writer.write(str);
            }
        }
        writer.write("</");
        if (this.b.a) {
            java.lang.String str2 = (java.lang.String) this.c.get(c(element));
            if (str2 != null && !"".equals(str2)) {
                writer.write(str2);
                writer.write(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            }
            d(element);
        }
        writer.write(element.getTagName());
        writer.write(">");
        writer.write(g);
        writer.flush();
    }

    public final void d(org.w3c.dom.Element element) {
        java.util.ArrayList arrayList = (java.util.ArrayList) this.e.get(element);
        if (arrayList != null) {
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.c.remove(it.next());
            }
            this.e.remove(element);
        }
    }

    public java.lang.String encode(java.lang.String str) {
        return b(str, false);
    }

    public java.lang.String encodeAttributeValue(java.lang.String str) {
        return b(str, true);
    }

    public java.lang.String encodedata(java.lang.String str) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        try {
            encodedata(stringWriter, str);
            return stringWriter.toString();
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public void encodedata(java.io.Writer writer, java.lang.String str) throws java.io.IOException {
        int length = str.length();
        int indexOf = str.indexOf("]]>");
        int i = 0;
        while (i < length) {
            int i2 = indexOf < 0 ? length : indexOf;
            while (i < i2) {
                int i3 = i;
                while (i3 < i2 && isLegalCharacter(str.charAt(i3))) {
                    i3++;
                }
                writer.write(str, i, i3 - i);
                i = i3 + 1;
            }
            if (indexOf >= 0) {
                writer.write("]]]]><![CDATA[>");
                int i4 = indexOf + 3;
                i = i4;
                indexOf = str.indexOf("]]>", i4);
            } else {
                i = i2;
            }
        }
    }

    public boolean isLegalCharacter(char c) {
        if (c == '\t' || c == '\n' || c == '\r') {
            return true;
        }
        if (c < ' ') {
            return false;
        }
        if (c <= 55295) {
            return true;
        }
        return c >= 57344 && c <= 65533;
    }

    public boolean isReference(java.lang.String str) {
        if (str.charAt(0) == '&' && str.endsWith(com.alipay.sdk.m.u.i.b)) {
            if (str.charAt(1) == '#') {
                if (str.charAt(2) == 'x') {
                    try {
                        java.lang.Integer.parseInt(str.substring(3, str.length() - 1), 16);
                        return true;
                    } catch (java.lang.NumberFormatException unused) {
                        return false;
                    }
                }
                try {
                    java.lang.Integer.parseInt(str.substring(2, str.length() - 1));
                    return true;
                } catch (java.lang.NumberFormatException unused2) {
                    return false;
                }
            }
            java.lang.String substring = str.substring(1, str.length() - 1);
            for (java.lang.String str2 : this.knownEntities) {
                if (substring.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void openElement(org.w3c.dom.Element element, java.io.Writer writer, int i, java.lang.String str) throws java.io.IOException {
        openElement(element, writer, i, str, true);
    }

    public void openElement(org.w3c.dom.Element element, java.io.Writer writer, int i, java.lang.String str, boolean z) throws java.io.IOException {
        for (int i2 = 0; i2 < i; i2++) {
            writer.write(str);
        }
        writer.write("<");
        if (this.b.a) {
            java.lang.String c = c(element);
            java.lang.String str2 = (java.lang.String) this.c.get(c);
            if (str2 == null) {
                if (this.c.isEmpty()) {
                    str2 = "";
                } else {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.NOTIFICATION_STYLE);
                    int i3 = this.d;
                    this.d = i3 + 1;
                    sb.append(i3);
                    str2 = sb.toString();
                }
                this.c.put(c, str2);
                a(element, c);
            }
            if (!"".equals(str2)) {
                writer.write(str2);
                writer.write(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            }
        }
        writer.write(element.getTagName());
        org.w3c.dom.NamedNodeMap attributes = element.getAttributes();
        for (int i4 = 0; i4 < attributes.getLength(); i4++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attributes.item(i4);
            writer.write(" ");
            if (this.b.b) {
                java.lang.String c2 = c(attr);
                java.lang.String str3 = (java.lang.String) this.c.get(c2);
                if (str3 == null) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.NOTIFICATION_STYLE);
                    int i5 = this.d;
                    this.d = i5 + 1;
                    sb2.append(i5);
                    str3 = sb2.toString();
                    this.c.put(c2, str3);
                    a(element, c2);
                }
                writer.write(str3);
                writer.write(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            }
            writer.write(attr.getName());
            writer.write("=\"");
            writer.write(encodeAttributeValue(attr.getValue()));
            writer.write("\"");
        }
        java.util.ArrayList arrayList = (java.util.ArrayList) this.e.get(element);
        if (arrayList != null) {
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                java.lang.String str4 = (java.lang.String) it.next();
                java.lang.String str5 = (java.lang.String) this.c.get(str4);
                writer.write(" xmlns");
                if (!"".equals(str5)) {
                    writer.write(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    writer.write(str5);
                }
                writer.write("=\"");
                writer.write(str4);
                writer.write("\"");
            }
        }
        if (z) {
            writer.write(">");
            return;
        }
        d(element);
        writer.write(" />");
        writer.write(g);
        writer.flush();
    }

    public void write(org.w3c.dom.Element element, java.io.OutputStream outputStream) throws java.io.IOException {
        java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(outputStream, net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8);
        writeXMLDeclaration(outputStreamWriter);
        write(element, outputStreamWriter, 0, "  ");
        outputStreamWriter.flush();
    }

    public void write(org.w3c.dom.Element element, java.io.Writer writer, int i, java.lang.String str) throws java.io.IOException {
        org.w3c.dom.NodeList childNodes = element.getChildNodes();
        boolean z = childNodes.getLength() > 0;
        openElement(element, writer, i, str, z);
        if (z) {
            boolean z2 = false;
            for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                org.w3c.dom.Node item = childNodes.item(i2);
                short nodeType = item.getNodeType();
                if (nodeType == 1) {
                    if (i2 == 0) {
                        writer.write(g);
                    }
                    write((org.w3c.dom.Element) item, writer, i + 1, str);
                    z2 = true;
                } else if (nodeType == 3) {
                    writer.write(encode(item.getNodeValue()));
                } else if (nodeType == 4) {
                    writer.write("<![CDATA[");
                    encodedata(writer, ((org.w3c.dom.Text) item).getData());
                    writer.write("]]>");
                } else if (nodeType == 5) {
                    writer.write(38);
                    writer.write(item.getNodeName());
                    writer.write(59);
                } else if (nodeType == 7) {
                    writer.write("<?");
                    writer.write(item.getNodeName());
                    java.lang.String nodeValue = item.getNodeValue();
                    if (nodeValue != null && nodeValue.length() > 0) {
                        writer.write(32);
                        writer.write(nodeValue);
                    }
                    writer.write("?>");
                } else if (nodeType == 8) {
                    writer.write("<!--");
                    writer.write(encode(item.getNodeValue()));
                    writer.write("-->");
                }
            }
            closeElement(element, writer, i, str, z2);
        }
    }

    public void writeXMLDeclaration(java.io.Writer writer) throws java.io.IOException {
        if (this.a) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        }
    }
}
