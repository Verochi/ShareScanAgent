package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class HostInfo extends org.apache.tools.ant.Task {
    public java.lang.String u = "";
    public java.lang.String v;
    public java.net.InetAddress w;
    public java.net.InetAddress x;
    public java.net.InetAddress y;
    public java.util.List<java.net.InetAddress> z;

    public final void c() {
        try {
            this.z = new java.util.LinkedList();
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.util.Enumeration<java.net.InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    this.z.add(inetAddresses.nextElement());
                }
            }
            f();
            java.net.InetAddress inetAddress = this.w;
            if (inetAddress == null || !e(inetAddress)) {
                setProperty("DOMAIN", "localdomain");
                setProperty("NAME", org.apache.tools.mail.MailMessage.DEFAULT_HOST);
            } else {
                h(this.w.getCanonicalHostName());
            }
            java.net.InetAddress inetAddress2 = this.y;
            if (inetAddress2 != null) {
                setProperty("ADDR4", inetAddress2.getHostAddress());
            } else {
                setProperty("ADDR4", "127.0.0.1");
            }
            java.net.InetAddress inetAddress3 = this.x;
            if (inetAddress3 != null) {
                setProperty("ADDR6", inetAddress3.getHostAddress());
            } else {
                setProperty("ADDR6", "::1");
            }
        } catch (java.lang.Exception e) {
            log("Error retrieving local host information", e, 1);
            setProperty("DOMAIN", "localdomain");
            setProperty("NAME", org.apache.tools.mail.MailMessage.DEFAULT_HOST);
            setProperty("ADDR4", "127.0.0.1");
            setProperty("ADDR6", "::1");
        }
    }

    public final void d() {
        try {
            this.z = java.util.Arrays.asList(java.net.InetAddress.getAllByName(this.v));
            f();
            java.net.InetAddress inetAddress = this.w;
            if (inetAddress == null || !e(inetAddress)) {
                h(this.v);
            } else {
                h(this.w.getCanonicalHostName());
            }
            java.net.InetAddress inetAddress2 = this.y;
            if (inetAddress2 != null) {
                setProperty("ADDR4", inetAddress2.getHostAddress());
            } else {
                setProperty("ADDR4", "0.0.0.0");
            }
            java.net.InetAddress inetAddress3 = this.x;
            if (inetAddress3 != null) {
                setProperty("ADDR6", inetAddress3.getHostAddress());
            } else {
                setProperty("ADDR6", "::");
            }
        } catch (java.lang.Exception e) {
            log("Error retrieving remote host information for host:" + this.v + ".", e, 1);
            h(this.v);
            setProperty("ADDR4", "0.0.0.0");
            setProperty("ADDR6", "::");
        }
    }

    public final boolean e(java.net.InetAddress inetAddress) {
        return !inetAddress.getHostAddress().equals(inetAddress.getCanonicalHostName());
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.lang.String str = this.v;
        if (str == null || "".equals(str)) {
            c();
        } else {
            d();
        }
    }

    public final void f() {
        for (java.net.InetAddress inetAddress : this.z) {
            if (!inetAddress.isMulticastAddress()) {
                if (inetAddress instanceof java.net.Inet4Address) {
                    this.y = g(this.y, inetAddress);
                } else if (inetAddress instanceof java.net.Inet6Address) {
                    this.x = g(this.x, inetAddress);
                }
            }
        }
        this.w = g(this.y, this.x);
    }

    public final java.net.InetAddress g(java.net.InetAddress inetAddress, java.net.InetAddress inetAddress2) {
        if (inetAddress != null) {
            if (inetAddress2 == null || inetAddress2.isLoopbackAddress()) {
                return inetAddress;
            }
            if (inetAddress2.isLinkLocalAddress()) {
                if (!inetAddress.isLoopbackAddress()) {
                    return inetAddress;
                }
            } else if (inetAddress2.isSiteLocalAddress()) {
                if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && (!inetAddress.isSiteLocalAddress() || e(inetAddress))) {
                    return inetAddress;
                }
            } else if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && !inetAddress.isSiteLocalAddress() && e(inetAddress)) {
                return inetAddress;
            }
        }
        return inetAddress2;
    }

    public final void h(java.lang.String str) {
        int indexOf = str.indexOf(46);
        if (indexOf > 0) {
            setProperty("NAME", str.substring(0, indexOf));
            setProperty("DOMAIN", str.substring(indexOf + 1));
        } else {
            setProperty("NAME", str);
            setProperty("DOMAIN", "localdomain");
        }
    }

    public void setHost(java.lang.String str) {
        this.v = str;
    }

    public void setPrefix(java.lang.String str) {
        this.u = str;
        if (str.endsWith(".")) {
            return;
        }
        this.u += ".";
    }

    public final void setProperty(java.lang.String str, java.lang.String str2) {
        getProject().setNewProperty(this.u + str, str2);
    }
}
