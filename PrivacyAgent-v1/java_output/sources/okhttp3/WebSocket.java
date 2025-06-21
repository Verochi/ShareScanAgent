package okhttp3;

/* loaded from: classes23.dex */
public interface WebSocket {

    public interface Factory {
        okhttp3.WebSocket newWebSocket(okhttp3.Request request, okhttp3.WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i, @javax.annotation.Nullable java.lang.String str);

    long queueSize();

    okhttp3.Request request();

    boolean send(java.lang.String str);

    boolean send(okio.ByteString byteString);
}
