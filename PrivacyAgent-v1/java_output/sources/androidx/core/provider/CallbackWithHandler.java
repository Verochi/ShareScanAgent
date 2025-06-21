package androidx.core.provider;

/* loaded from: classes.dex */
class CallbackWithHandler {

    @androidx.annotation.NonNull
    private final androidx.core.provider.FontsContractCompat.FontRequestCallback mCallback;

    @androidx.annotation.NonNull
    private final android.os.Handler mCallbackHandler;

    /* renamed from: androidx.core.provider.CallbackWithHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ androidx.core.provider.FontsContractCompat.FontRequestCallback val$callback;
        final /* synthetic */ android.graphics.Typeface val$typeface;

        public AnonymousClass1(androidx.core.provider.FontsContractCompat.FontRequestCallback fontRequestCallback, android.graphics.Typeface typeface) {
            this.val$callback = fontRequestCallback;
            this.val$typeface = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callback.onTypefaceRetrieved(this.val$typeface);
        }
    }

    /* renamed from: androidx.core.provider.CallbackWithHandler$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ androidx.core.provider.FontsContractCompat.FontRequestCallback val$callback;
        final /* synthetic */ int val$reason;

        public AnonymousClass2(androidx.core.provider.FontsContractCompat.FontRequestCallback fontRequestCallback, int i) {
            this.val$callback = fontRequestCallback;
            this.val$reason = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callback.onTypefaceRequestFailed(this.val$reason);
        }
    }

    public CallbackWithHandler(@androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontRequestCallback fontRequestCallback) {
        this.mCallback = fontRequestCallback;
        this.mCallbackHandler = androidx.core.provider.CalleeHandler.create();
    }

    public CallbackWithHandler(@androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontRequestCallback fontRequestCallback, @androidx.annotation.NonNull android.os.Handler handler) {
        this.mCallback = fontRequestCallback;
        this.mCallbackHandler = handler;
    }

    private void onTypefaceRequestFailed(int i) {
        this.mCallbackHandler.post(new androidx.core.provider.CallbackWithHandler.AnonymousClass2(this.mCallback, i));
    }

    private void onTypefaceRetrieved(@androidx.annotation.NonNull android.graphics.Typeface typeface) {
        this.mCallbackHandler.post(new androidx.core.provider.CallbackWithHandler.AnonymousClass1(this.mCallback, typeface));
    }

    public void onTypefaceResult(@androidx.annotation.NonNull androidx.core.provider.FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.isSuccess()) {
            onTypefaceRetrieved(typefaceResult.mTypeface);
        } else {
            onTypefaceRequestFailed(typefaceResult.mResult);
        }
    }
}
