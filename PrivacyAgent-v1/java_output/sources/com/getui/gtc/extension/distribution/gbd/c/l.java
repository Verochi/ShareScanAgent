package com.getui.gtc.extension.distribution.gbd.c;

/* loaded from: classes22.dex */
public final class l {
    private static final java.lang.String d = "117Bean";
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    private java.lang.String e;
    private int f;

    public l(android.net.nsd.NsdServiceInfo nsdServiceInfo) {
        this.a = "";
        this.e = "";
        this.b = "";
        this.f = 0;
        this.c = "";
        try {
            this.a = nsdServiceInfo.getServiceName();
            this.e = nsdServiceInfo.getServiceType();
            this.f = nsdServiceInfo.getPort();
            java.net.InetAddress host = nsdServiceInfo.getHost();
            if (host != null) {
                java.lang.String a = com.getui.gtc.extension.distribution.gbd.n.l.a(host);
                this.b = android.text.TextUtils.isEmpty(a) ? "" : a;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.Map<java.lang.String, byte[]> attributes = nsdServiceInfo.getAttributes();
            for (java.lang.String str : attributes.keySet()) {
                java.lang.String replace = new java.lang.String(attributes.get(str)).replace("&", "");
                sb.append(str);
                sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(replace);
                sb.append("&");
            }
            if (sb.toString().endsWith("&")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            this.c = sb.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, th.toString());
        }
    }

    private java.lang.String a() {
        return this.a;
    }

    private java.lang.String b() {
        return this.e;
    }

    private java.lang.String c() {
        return this.b;
    }

    private int d() {
        return this.f;
    }

    private java.lang.String e() {
        return this.c;
    }

    public final java.lang.String toString() {
        return "MdnsBean{serviceName='" + this.a + "', serviceType='" + this.e + "', host='" + this.b + "', port=" + this.f + ", txtRecord='" + this.c + "'}";
    }
}
