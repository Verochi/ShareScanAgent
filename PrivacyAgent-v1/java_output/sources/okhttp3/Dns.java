package okhttp3;

/* loaded from: classes23.dex */
public interface Dns {
    public static final okhttp3.Dns SYSTEM = new defpackage.u40();

    java.util.List<java.net.InetAddress> lookup(java.lang.String str) throws java.net.UnknownHostException;
}
