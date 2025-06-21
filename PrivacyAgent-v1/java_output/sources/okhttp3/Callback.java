package okhttp3;

/* loaded from: classes23.dex */
public interface Callback {
    void onFailure(okhttp3.Call call, java.io.IOException iOException);

    void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.io.IOException;
}
