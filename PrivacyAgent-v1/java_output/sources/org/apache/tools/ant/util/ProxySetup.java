package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ProxySetup {
    public static final java.lang.String FTP_NON_PROXY_HOSTS = "ftp.nonProxyHosts";
    public static final java.lang.String FTP_PROXY_HOST = "ftp.proxyHost";
    public static final java.lang.String FTP_PROXY_PORT = "ftp.proxyPort";
    public static final java.lang.String HTTPS_NON_PROXY_HOSTS = "https.nonProxyHosts";
    public static final java.lang.String HTTPS_PROXY_HOST = "https.proxyHost";
    public static final java.lang.String HTTPS_PROXY_PORT = "https.proxyPort";
    public static final java.lang.String HTTP_NON_PROXY_HOSTS = "http.nonProxyHosts";
    public static final java.lang.String HTTP_PROXY_HOST = "http.proxyHost";
    public static final java.lang.String HTTP_PROXY_PASSWORD = "http.proxyPassword";
    public static final java.lang.String HTTP_PROXY_PORT = "http.proxyPort";
    public static final java.lang.String HTTP_PROXY_USERNAME = "http.proxyUser";
    public static final java.lang.String SOCKS_PROXY_HOST = "socksProxyHost";
    public static final java.lang.String SOCKS_PROXY_PASSWORD = "java.net.socks.password";
    public static final java.lang.String SOCKS_PROXY_PORT = "socksProxyPort";
    public static final java.lang.String SOCKS_PROXY_USERNAME = "java.net.socks.username";
    public static final java.lang.String USE_SYSTEM_PROXIES = "java.net.useSystemProxies";
    public org.apache.tools.ant.Project a;

    public ProxySetup(org.apache.tools.ant.Project project) {
        this.a = project;
    }

    public static java.lang.String getSystemProxySetting() {
        try {
            return java.lang.System.getProperty(USE_SYSTEM_PROXIES);
        } catch (java.lang.SecurityException unused) {
            return null;
        }
    }

    public void enableProxies() {
        if (getSystemProxySetting() == null) {
            java.lang.String property = this.a.getProperty(USE_SYSTEM_PROXIES);
            if (property == null || org.apache.tools.ant.Project.toBoolean(property)) {
                property = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
            }
            java.lang.String str = "setting java.net.useSystemProxies to " + property;
            try {
                this.a.log(str, 4);
                java.lang.System.setProperty(USE_SYSTEM_PROXIES, property);
            } catch (java.lang.SecurityException unused) {
                this.a.log("Security Exception when " + str);
            }
        }
    }
}
