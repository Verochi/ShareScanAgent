package okhttp3.internal.http2;

/* loaded from: classes24.dex */
public interface PushObserver {
    public static final okhttp3.internal.http2.PushObserver CANCEL = new okhttp3.internal.http2.PushObserver.AnonymousClass1();

    /* renamed from: okhttp3.internal.http2.PushObserver$1, reason: invalid class name */
    public class AnonymousClass1 implements okhttp3.internal.http2.PushObserver {
        @Override // okhttp3.internal.http2.PushObserver
        public boolean onData(int i, okio.BufferedSource bufferedSource, int i2, boolean z) throws java.io.IOException {
            bufferedSource.skip(i2);
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean onHeaders(int i, java.util.List<okhttp3.internal.http2.Header> list, boolean z) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean onRequest(int i, java.util.List<okhttp3.internal.http2.Header> list) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public void onReset(int i, okhttp3.internal.http2.ErrorCode errorCode) {
        }
    }

    boolean onData(int i, okio.BufferedSource bufferedSource, int i2, boolean z) throws java.io.IOException;

    boolean onHeaders(int i, java.util.List<okhttp3.internal.http2.Header> list, boolean z);

    boolean onRequest(int i, java.util.List<okhttp3.internal.http2.Header> list);

    void onReset(int i, okhttp3.internal.http2.ErrorCode errorCode);
}
