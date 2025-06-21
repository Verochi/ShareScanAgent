package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class AsyncDifferConfig<T> {

    @androidx.annotation.NonNull
    private final java.util.concurrent.Executor mBackgroundThreadExecutor;

    @androidx.annotation.NonNull
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<T> mDiffCallback;

    @androidx.annotation.Nullable
    private final java.util.concurrent.Executor mMainThreadExecutor;

    public static final class Builder<T> {
        private static java.util.concurrent.Executor sDiffExecutor;
        private static final java.lang.Object sExecutorLock = new java.lang.Object();
        private java.util.concurrent.Executor mBackgroundThreadExecutor;
        private final androidx.recyclerview.widget.DiffUtil.ItemCallback<T> mDiffCallback;

        @androidx.annotation.Nullable
        private java.util.concurrent.Executor mMainThreadExecutor;

        public Builder(@androidx.annotation.NonNull androidx.recyclerview.widget.DiffUtil.ItemCallback<T> itemCallback) {
            this.mDiffCallback = itemCallback;
        }

        @androidx.annotation.NonNull
        public androidx.recyclerview.widget.AsyncDifferConfig<T> build() {
            if (this.mBackgroundThreadExecutor == null) {
                synchronized (sExecutorLock) {
                    if (sDiffExecutor == null) {
                        sDiffExecutor = java.util.concurrent.Executors.newFixedThreadPool(2);
                    }
                }
                this.mBackgroundThreadExecutor = sDiffExecutor;
            }
            return new androidx.recyclerview.widget.AsyncDifferConfig<>(this.mMainThreadExecutor, this.mBackgroundThreadExecutor, this.mDiffCallback);
        }

        @androidx.annotation.NonNull
        public androidx.recyclerview.widget.AsyncDifferConfig.Builder<T> setBackgroundThreadExecutor(java.util.concurrent.Executor executor) {
            this.mBackgroundThreadExecutor = executor;
            return this;
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
        public androidx.recyclerview.widget.AsyncDifferConfig.Builder<T> setMainThreadExecutor(java.util.concurrent.Executor executor) {
            this.mMainThreadExecutor = executor;
            return this;
        }
    }

    public AsyncDifferConfig(@androidx.annotation.Nullable java.util.concurrent.Executor executor, @androidx.annotation.NonNull java.util.concurrent.Executor executor2, @androidx.annotation.NonNull androidx.recyclerview.widget.DiffUtil.ItemCallback<T> itemCallback) {
        this.mMainThreadExecutor = executor;
        this.mBackgroundThreadExecutor = executor2;
        this.mDiffCallback = itemCallback;
    }

    @androidx.annotation.NonNull
    public java.util.concurrent.Executor getBackgroundThreadExecutor() {
        return this.mBackgroundThreadExecutor;
    }

    @androidx.annotation.NonNull
    public androidx.recyclerview.widget.DiffUtil.ItemCallback<T> getDiffCallback() {
        return this.mDiffCallback;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public java.util.concurrent.Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }
}
