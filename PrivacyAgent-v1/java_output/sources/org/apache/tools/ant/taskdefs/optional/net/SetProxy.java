package org.apache.tools.ant.taskdefs.optional.net;

/* loaded from: classes25.dex */
public class SetProxy extends org.apache.tools.ant.Task {
    protected java.lang.String proxyHost = null;
    protected int proxyPort = 80;
    public java.lang.String u = null;
    public int v = com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
    public java.lang.String w = null;
    public java.lang.String x = null;
    public java.lang.String y = null;

    public static final class ProxyAuth extends java.net.Authenticator {
        public java.net.PasswordAuthentication a;

        public ProxyAuth(java.lang.String str, java.lang.String str2) {
            this.a = new java.net.PasswordAuthentication(str, str2.toCharArray());
        }

        public /* synthetic */ ProxyAuth(java.lang.String str, java.lang.String str2, org.apache.tools.ant.taskdefs.optional.net.SetProxy.AnonymousClass1 anonymousClass1) {
            this(str, str2);
        }

        @Override // java.net.Authenticator
        public java.net.PasswordAuthentication getPasswordAuthentication() {
            return this.a;
        }
    }

    public void applyWebProxySettings() {
        boolean z;
        java.util.Properties properties = java.lang.System.getProperties();
        java.lang.String str = this.proxyHost;
        boolean z2 = true;
        boolean z3 = false;
        if (str != null) {
            if (str.length() != 0) {
                c();
                properties.put(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_HOST, this.proxyHost);
                java.lang.String num = java.lang.Integer.toString(this.proxyPort);
                properties.put(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_PORT, num);
                properties.put(org.apache.tools.ant.util.ProxySetup.HTTPS_PROXY_HOST, this.proxyHost);
                properties.put(org.apache.tools.ant.util.ProxySetup.HTTPS_PROXY_PORT, num);
                properties.put(org.apache.tools.ant.util.ProxySetup.FTP_PROXY_HOST, this.proxyHost);
                properties.put(org.apache.tools.ant.util.ProxySetup.FTP_PROXY_PORT, num);
                java.lang.String str2 = this.w;
                if (str2 != null) {
                    properties.put(org.apache.tools.ant.util.ProxySetup.HTTP_NON_PROXY_HOSTS, str2);
                    properties.put(org.apache.tools.ant.util.ProxySetup.HTTPS_NON_PROXY_HOSTS, this.w);
                    properties.put(org.apache.tools.ant.util.ProxySetup.FTP_NON_PROXY_HOSTS, this.w);
                }
                java.lang.String str3 = this.x;
                if (str3 != null) {
                    properties.put(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_USERNAME, str3);
                    properties.put(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_PASSWORD, this.y);
                }
                z = true;
            } else {
                log("resetting http proxy", 3);
                properties.remove(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_HOST);
                properties.remove(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_PORT);
                properties.remove(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_USERNAME);
                properties.remove(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_PASSWORD);
                properties.remove(org.apache.tools.ant.util.ProxySetup.HTTPS_PROXY_HOST);
                properties.remove(org.apache.tools.ant.util.ProxySetup.HTTPS_PROXY_PORT);
                properties.remove(org.apache.tools.ant.util.ProxySetup.FTP_PROXY_HOST);
                properties.remove(org.apache.tools.ant.util.ProxySetup.FTP_PROXY_PORT);
                z = false;
            }
            z3 = true;
        } else {
            z = false;
        }
        java.lang.String str4 = this.u;
        if (str4 != null) {
            if (str4.length() != 0) {
                properties.put(org.apache.tools.ant.util.ProxySetup.SOCKS_PROXY_HOST, this.u);
                properties.put(org.apache.tools.ant.util.ProxySetup.SOCKS_PROXY_PORT, java.lang.Integer.toString(this.v));
                java.lang.String str5 = this.x;
                if (str5 != null) {
                    properties.put(org.apache.tools.ant.util.ProxySetup.SOCKS_PROXY_USERNAME, str5);
                    properties.put(org.apache.tools.ant.util.ProxySetup.SOCKS_PROXY_PASSWORD, this.y);
                }
            } else {
                log("resetting socks proxy", 3);
                properties.remove(org.apache.tools.ant.util.ProxySetup.SOCKS_PROXY_HOST);
                properties.remove(org.apache.tools.ant.util.ProxySetup.SOCKS_PROXY_PORT);
                properties.remove(org.apache.tools.ant.util.ProxySetup.SOCKS_PROXY_USERNAME);
                properties.remove(org.apache.tools.ant.util.ProxySetup.SOCKS_PROXY_PASSWORD);
                z2 = z;
            }
            z3 = true;
        } else {
            z2 = z;
        }
        if (this.x != null) {
            if (z2) {
                java.net.Authenticator.setDefault(new org.apache.tools.ant.taskdefs.optional.net.SetProxy.ProxyAuth(this.x, this.y, null));
            } else if (z3) {
                java.net.Authenticator.setDefault(new org.apache.tools.ant.taskdefs.optional.net.SetProxy.ProxyAuth("", "", null));
            }
        }
    }

    public final void c() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Setting proxy to ");
        java.lang.String str = this.proxyHost;
        if (str == null) {
            str = "''";
        }
        sb.append(str);
        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        sb.append(this.proxyPort);
        log(sb.toString(), 3);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        applyWebProxySettings();
    }

    public void setNonProxyHosts(java.lang.String str) {
        this.w = str;
    }

    public void setProxyHost(java.lang.String str) {
        this.proxyHost = str;
    }

    public void setProxyPassword(java.lang.String str) {
        this.y = str;
    }

    public void setProxyPort(int i) {
        this.proxyPort = i;
    }

    public void setProxyUser(java.lang.String str) {
        this.x = str;
    }

    public void setSocksProxyHost(java.lang.String str) {
        this.u = str;
    }

    public void setSocksProxyPort(int i) {
        this.v = i;
    }
}
