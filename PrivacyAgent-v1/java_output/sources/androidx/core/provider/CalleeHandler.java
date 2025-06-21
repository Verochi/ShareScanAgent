package androidx.core.provider;

/* loaded from: classes.dex */
class CalleeHandler {
    private CalleeHandler() {
    }

    @androidx.annotation.NonNull
    public static android.os.Handler create() {
        return android.os.Looper.myLooper() == null ? new android.os.Handler(android.os.Looper.getMainLooper()) : new android.os.Handler();
    }
}
