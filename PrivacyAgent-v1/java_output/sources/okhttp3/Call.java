package okhttp3;

/* loaded from: classes23.dex */
public interface Call extends java.lang.Cloneable {

    public interface Factory {
        okhttp3.Call newCall(okhttp3.Request request);
    }

    void cancel();

    /* renamed from: clone */
    okhttp3.Call mo839clone();

    void enqueue(okhttp3.Callback callback);

    okhttp3.Response execute() throws java.io.IOException;

    boolean isCanceled();

    boolean isExecuted();

    okhttp3.Request request();

    okio.Timeout timeout();
}
