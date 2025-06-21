package androidx.vectordrawable.graphics.drawable;

/* loaded from: classes.dex */
public interface Animatable2Compat extends android.graphics.drawable.Animatable {

    public static abstract class AnimationCallback {
        android.graphics.drawable.Animatable2.AnimationCallback mPlatformCallback;

        /* renamed from: androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback$1, reason: invalid class name */
        public class AnonymousClass1 extends android.graphics.drawable.Animatable2.AnimationCallback {
            public AnonymousClass1() {
            }

            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public void onAnimationEnd(android.graphics.drawable.Drawable drawable) {
                androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback.this.onAnimationEnd(drawable);
            }

            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public void onAnimationStart(android.graphics.drawable.Drawable drawable) {
                androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback.this.onAnimationStart(drawable);
            }
        }

        @androidx.annotation.RequiresApi(23)
        public android.graphics.drawable.Animatable2.AnimationCallback getPlatformCallback() {
            if (this.mPlatformCallback == null) {
                this.mPlatformCallback = new androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback.AnonymousClass1();
            }
            return this.mPlatformCallback;
        }

        public void onAnimationEnd(android.graphics.drawable.Drawable drawable) {
        }

        public void onAnimationStart(android.graphics.drawable.Drawable drawable) {
        }
    }

    void clearAnimationCallbacks();

    void registerAnimationCallback(@androidx.annotation.NonNull androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback animationCallback);

    boolean unregisterAnimationCallback(@androidx.annotation.NonNull androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback animationCallback);
}
