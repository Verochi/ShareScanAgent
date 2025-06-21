package okhttp3;

/* loaded from: classes23.dex */
public abstract class WebSocketListener {
    public void onClosed(okhttp3.WebSocket webSocket, int i, java.lang.String str) {
    }

    public void onClosing(okhttp3.WebSocket webSocket, int i, java.lang.String str) {
    }

    public void onFailure(okhttp3.WebSocket webSocket, java.lang.Throwable th, @javax.annotation.Nullable okhttp3.Response response) {
    }

    public void onMessage(okhttp3.WebSocket webSocket, java.lang.String str) {
    }

    public void onMessage(okhttp3.WebSocket webSocket, okio.ByteString byteString) {
    }

    public void onOpen(okhttp3.WebSocket webSocket, okhttp3.Response response) {
    }
}
