package androidx.dynamicanimation.animation;

/* loaded from: classes.dex */
class AnimationHandler {
    private static final long FRAME_DELAY_MS = 10;
    public static final java.lang.ThreadLocal<androidx.dynamicanimation.animation.AnimationHandler> sAnimatorHandler = new java.lang.ThreadLocal<>();
    private androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider mProvider;
    private final androidx.collection.SimpleArrayMap<androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback, java.lang.Long> mDelayedCallbackStartTime = new androidx.collection.SimpleArrayMap<>();
    final java.util.ArrayList<androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback> mAnimationCallbacks = new java.util.ArrayList<>();
    private final androidx.dynamicanimation.animation.AnimationHandler.AnimationCallbackDispatcher mCallbackDispatcher = new androidx.dynamicanimation.animation.AnimationHandler.AnimationCallbackDispatcher();
    long mCurrentFrameTime = 0;
    private boolean mListDirty = false;

    public class AnimationCallbackDispatcher {
        public AnimationCallbackDispatcher() {
        }

        public void dispatchAnimationFrame() {
            androidx.dynamicanimation.animation.AnimationHandler.this.mCurrentFrameTime = android.os.SystemClock.uptimeMillis();
            androidx.dynamicanimation.animation.AnimationHandler animationHandler = androidx.dynamicanimation.animation.AnimationHandler.this;
            animationHandler.doAnimationFrame(animationHandler.mCurrentFrameTime);
            if (androidx.dynamicanimation.animation.AnimationHandler.this.mAnimationCallbacks.size() > 0) {
                androidx.dynamicanimation.animation.AnimationHandler.this.getProvider().postFrameCallback();
            }
        }
    }

    public interface AnimationFrameCallback {
        boolean doAnimationFrame(long j);
    }

    public static abstract class AnimationFrameCallbackProvider {
        final androidx.dynamicanimation.animation.AnimationHandler.AnimationCallbackDispatcher mDispatcher;

        public AnimationFrameCallbackProvider(androidx.dynamicanimation.animation.AnimationHandler.AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.mDispatcher = animationCallbackDispatcher;
        }

        public abstract void postFrameCallback();
    }

    public static class FrameCallbackProvider14 extends androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider {
        private final android.os.Handler mHandler;
        long mLastFrameTime;
        private final java.lang.Runnable mRunnable;

        /* renamed from: androidx.dynamicanimation.animation.AnimationHandler$FrameCallbackProvider14$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider14.this.mLastFrameTime = android.os.SystemClock.uptimeMillis();
                androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider14.this.mDispatcher.dispatchAnimationFrame();
            }
        }

        public FrameCallbackProvider14(androidx.dynamicanimation.animation.AnimationHandler.AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
            this.mLastFrameTime = -1L;
            this.mRunnable = new androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider14.AnonymousClass1();
            this.mHandler = new android.os.Handler(android.os.Looper.myLooper());
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        public void postFrameCallback() {
            this.mHandler.postDelayed(this.mRunnable, java.lang.Math.max(10 - (android.os.SystemClock.uptimeMillis() - this.mLastFrameTime), 0L));
        }
    }

    @androidx.annotation.RequiresApi(16)
    public static class FrameCallbackProvider16 extends androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider {
        private final android.view.Choreographer mChoreographer;
        private final android.view.Choreographer.FrameCallback mChoreographerCallback;

        /* renamed from: androidx.dynamicanimation.animation.AnimationHandler$FrameCallbackProvider16$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.Choreographer.FrameCallback {
            public AnonymousClass1() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider16.this.mDispatcher.dispatchAnimationFrame();
            }
        }

        public FrameCallbackProvider16(androidx.dynamicanimation.animation.AnimationHandler.AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
            this.mChoreographer = android.view.Choreographer.getInstance();
            this.mChoreographerCallback = new androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider16.AnonymousClass1();
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        public void postFrameCallback() {
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }

    private void cleanUpList() {
        if (this.mListDirty) {
            for (int size = this.mAnimationCallbacks.size() - 1; size >= 0; size--) {
                if (this.mAnimationCallbacks.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            this.mListDirty = false;
        }
    }

    public static long getFrameTime() {
        java.lang.ThreadLocal<androidx.dynamicanimation.animation.AnimationHandler> threadLocal = sAnimatorHandler;
        if (threadLocal.get() == null) {
            return 0L;
        }
        return threadLocal.get().mCurrentFrameTime;
    }

    public static androidx.dynamicanimation.animation.AnimationHandler getInstance() {
        java.lang.ThreadLocal<androidx.dynamicanimation.animation.AnimationHandler> threadLocal = sAnimatorHandler;
        if (threadLocal.get() == null) {
            threadLocal.set(new androidx.dynamicanimation.animation.AnimationHandler());
        }
        return threadLocal.get();
    }

    private boolean isCallbackDue(androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback animationFrameCallback, long j) {
        java.lang.Long l = this.mDelayedCallbackStartTime.get(animationFrameCallback);
        if (l == null) {
            return true;
        }
        if (l.longValue() >= j) {
            return false;
        }
        this.mDelayedCallbackStartTime.remove(animationFrameCallback);
        return true;
    }

    public void addAnimationFrameCallback(androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback animationFrameCallback, long j) {
        if (this.mAnimationCallbacks.size() == 0) {
            getProvider().postFrameCallback();
        }
        if (!this.mAnimationCallbacks.contains(animationFrameCallback)) {
            this.mAnimationCallbacks.add(animationFrameCallback);
        }
        if (j > 0) {
            this.mDelayedCallbackStartTime.put(animationFrameCallback, java.lang.Long.valueOf(android.os.SystemClock.uptimeMillis() + j));
        }
    }

    public void doAnimationFrame(long j) {
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        for (int i = 0; i < this.mAnimationCallbacks.size(); i++) {
            androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback animationFrameCallback = this.mAnimationCallbacks.get(i);
            if (animationFrameCallback != null && isCallbackDue(animationFrameCallback, uptimeMillis)) {
                animationFrameCallback.doAnimationFrame(j);
            }
        }
        cleanUpList();
    }

    public androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider getProvider() {
        if (this.mProvider == null) {
            this.mProvider = new androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider16(this.mCallbackDispatcher);
        }
        return this.mProvider;
    }

    public void removeCallback(androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback animationFrameCallback) {
        this.mDelayedCallbackStartTime.remove(animationFrameCallback);
        int indexOf = this.mAnimationCallbacks.indexOf(animationFrameCallback);
        if (indexOf >= 0) {
            this.mAnimationCallbacks.set(indexOf, null);
            this.mListDirty = true;
        }
    }

    public void setProvider(androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider animationFrameCallbackProvider) {
        this.mProvider = animationFrameCallbackProvider;
    }
}
