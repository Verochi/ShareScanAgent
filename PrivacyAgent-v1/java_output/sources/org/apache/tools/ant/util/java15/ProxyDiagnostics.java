package org.apache.tools.ant.util.java15;

/* loaded from: classes26.dex */
public class ProxyDiagnostics {
    public static final java.lang.String DEFAULT_DESTINATION = "http://ant.apache.org/";
    public java.lang.String a;
    public java.net.URI b;

    public ProxyDiagnostics() {
        this(DEFAULT_DESTINATION);
    }

    public ProxyDiagnostics(java.lang.String str) {
        this.a = str;
        try {
            this.b = new java.net.URI(str);
        } catch (java.net.URISyntaxException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public java.lang.String toString() {
        java.util.List<java.net.Proxy> select = java.net.ProxySelector.getDefault().select(this.b);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.util.ListIterator<java.net.Proxy> listIterator = select.listIterator();
        while (listIterator.hasNext()) {
            java.net.Proxy next = listIterator.next();
            java.net.SocketAddress address = next.address();
            if (address == null) {
                stringBuffer.append("Direct connection\n");
            } else {
                stringBuffer.append(next.toString());
                if (address instanceof java.net.InetSocketAddress) {
                    java.net.InetSocketAddress inetSocketAddress = (java.net.InetSocketAddress) address;
                    stringBuffer.append(' ');
                    stringBuffer.append(inetSocketAddress.getHostName());
                    stringBuffer.append(':');
                    stringBuffer.append(inetSocketAddress.getPort());
                    if (inetSocketAddress.isUnresolved()) {
                        stringBuffer.append(" [unresolved]");
                    } else {
                        java.net.InetAddress address2 = inetSocketAddress.getAddress();
                        stringBuffer.append(" [");
                        stringBuffer.append(address2.getHostAddress());
                        stringBuffer.append(']');
                    }
                }
                stringBuffer.append('\n');
            }
        }
        return stringBuffer.toString();
    }
}
