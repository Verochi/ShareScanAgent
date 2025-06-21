package com.bumptech.glide.request.target;

/* loaded from: classes.dex */
public final class PreloadTarget<Z> extends com.bumptech.glide.request.target.CustomTarget<Z> {
    private static final android.os.Handler HANDLER = new android.os.Handler(android.os.Looper.getMainLooper(), new com.bumptech.glide.request.target.PreloadTarget.AnonymousClass1());
    private static final int MESSAGE_CLEAR = 1;
    private final com.bumptech.glide.RequestManager requestManager;

    /* renamed from: com.bumptech.glide.request.target.PreloadTarget$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return false;
            }
            ((com.bumptech.glide.request.target.PreloadTarget) message.obj).clear();
            return true;
        }
    }

    private PreloadTarget(com.bumptech.glide.RequestManager requestManager, int i, int i2) {
        super(i, i2);
        this.requestManager = requestManager;
    }

    public static <Z> com.bumptech.glide.request.target.PreloadTarget<Z> obtain(com.bumptech.glide.RequestManager requestManager, int i, int i2) {
        return new com.bumptech.glide.request.target.PreloadTarget<>(requestManager, i, i2);
    }

    public void clear() {
        this.requestManager.clear(this);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(@androidx.annotation.NonNull Z z, @androidx.annotation.Nullable com.bumptech.glide.request.transition.Transition<? super Z> transition) {
        HANDLER.obtainMessage(1, this).sendToTarget();
    }
}
