package okhttp3;

/* loaded from: classes23.dex */
public interface Connection {
    @javax.annotation.Nullable
    okhttp3.Handshake handshake();

    okhttp3.Protocol protocol();

    okhttp3.Route route();

    java.net.Socket socket();
}
