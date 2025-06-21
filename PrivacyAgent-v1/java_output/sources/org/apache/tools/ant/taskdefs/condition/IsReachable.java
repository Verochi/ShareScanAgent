package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class IsReachable extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public static final int DEFAULT_TIMEOUT = 30;
    public static final java.lang.String ERROR_BAD_TIMEOUT = "Invalid timeout value";
    public static final java.lang.String ERROR_BAD_URL = "Bad URL ";
    public static final java.lang.String ERROR_BOTH_TARGETS = "Both url and host have been specified";
    public static final java.lang.String ERROR_NO_HOSTNAME = "No hostname defined";
    public static final java.lang.String ERROR_NO_HOST_IN_URL = "No hostname in URL ";
    public static final java.lang.String ERROR_ON_NETWORK = "network error to ";

    @java.lang.Deprecated
    public static final java.lang.String METHOD_NAME = "isReachable";
    public static final java.lang.String MSG_NO_REACHABLE_TEST = "cannot do a proper reachability test on this Java version";
    public java.lang.String n;
    public java.lang.String t;
    public int u = 30;

    public final boolean a(java.lang.String str) {
        return str == null || str.length() == 0;
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        if (a(this.n) && a(this.t)) {
            throw new org.apache.tools.ant.BuildException(ERROR_NO_HOSTNAME);
        }
        if (this.u < 0) {
            throw new org.apache.tools.ant.BuildException(ERROR_BAD_TIMEOUT);
        }
        java.lang.String str = this.n;
        if (!a(this.t)) {
            if (!a(this.n)) {
                throw new org.apache.tools.ant.BuildException(ERROR_BOTH_TARGETS);
            }
            try {
                str = new java.net.URL(this.t).getHost();
                if (a(str)) {
                    throw new org.apache.tools.ant.BuildException(ERROR_NO_HOST_IN_URL + this.t);
                }
            } catch (java.net.MalformedURLException e) {
                throw new org.apache.tools.ant.BuildException(ERROR_BAD_URL + this.t, e);
            }
        }
        log("Probing host " + str, 3);
        boolean z = false;
        try {
            java.net.InetAddress byName = java.net.InetAddress.getByName(str);
            log("Host address = " + byName.getHostAddress(), 3);
            try {
                z = byName.isReachable(this.u * 1000);
            } catch (java.io.IOException e2) {
                log(ERROR_ON_NETWORK + str + ": " + e2.toString());
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("host is");
            sb.append(z ? "" : " not");
            sb.append(" reachable");
            log(sb.toString(), 3);
            return z;
        } catch (java.net.UnknownHostException unused) {
            log("Unknown host: " + str);
            return false;
        }
    }

    public void setHost(java.lang.String str) {
        this.n = str;
    }

    public void setTimeout(int i) {
        this.u = i;
    }

    public void setUrl(java.lang.String str) {
        this.t = str;
    }
}
