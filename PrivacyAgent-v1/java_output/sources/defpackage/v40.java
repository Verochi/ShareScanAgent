package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class v40 {
    static {
        okhttp3.Dns dns = okhttp3.Dns.SYSTEM;
    }

    public static /* synthetic */ java.util.List a(java.lang.String str) throws java.net.UnknownHostException {
        if (str == null) {
            throw new java.net.UnknownHostException("hostname == null");
        }
        try {
            return java.util.Arrays.asList(java.net.InetAddress.getAllByName(str));
        } catch (java.lang.NullPointerException e) {
            java.net.UnknownHostException unknownHostException = new java.net.UnknownHostException("Broken system behaviour for dns lookup of " + str);
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
