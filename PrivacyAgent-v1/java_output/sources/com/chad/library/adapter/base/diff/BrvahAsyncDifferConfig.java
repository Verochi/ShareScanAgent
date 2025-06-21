package com.chad.library.adapter.base.diff;

@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0014B'\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/util/concurrent/Executor;", "a", "Ljava/util/concurrent/Executor;", "getMainThreadExecutor", "()Ljava/util/concurrent/Executor;", "mainThreadExecutor", "b", "getBackgroundThreadExecutor", "backgroundThreadExecutor", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "c", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "getDiffCallback", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "<init>", "(Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "Builder", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public final class BrvahAsyncDifferConfig<T> {

    /* renamed from: a, reason: from kotlin metadata */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    @org.jetbrains.annotations.Nullable
    public final java.util.concurrent.Executor mainThreadExecutor;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.Executor backgroundThreadExecutor;

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.DiffUtil.ItemCallback<T> diffCallback;

    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u0014*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0001\u0014B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig$Builder;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/util/concurrent/Executor;", "executor", "setMainThreadExecutor", "setBackgroundThreadExecutor", "Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", "build", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "mDiffCallback", "b", "Ljava/util/concurrent/Executor;", "mMainThreadExecutor", "c", "mBackgroundThreadExecutor", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
    public static final class Builder<T> {

        @org.jetbrains.annotations.NotNull
        public static final java.lang.Object d = new java.lang.Object();

        @org.jetbrains.annotations.Nullable
        public static java.util.concurrent.Executor e;

        /* renamed from: a, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<T> mDiffCallback;

        /* renamed from: b, reason: from kotlin metadata */
        @org.jetbrains.annotations.Nullable
        public java.util.concurrent.Executor mMainThreadExecutor;

        /* renamed from: c, reason: from kotlin metadata */
        @org.jetbrains.annotations.Nullable
        public java.util.concurrent.Executor mBackgroundThreadExecutor;

        public Builder(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.DiffUtil.ItemCallback<T> mDiffCallback) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mDiffCallback, "mDiffCallback");
            this.mDiffCallback = mDiffCallback;
        }

        @org.jetbrains.annotations.NotNull
        public final com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig<T> build() {
            if (this.mBackgroundThreadExecutor == null) {
                synchronized (d) {
                    if (e == null) {
                        e = java.util.concurrent.Executors.newFixedThreadPool(2);
                    }
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                }
                this.mBackgroundThreadExecutor = e;
            }
            java.util.concurrent.Executor executor = this.mMainThreadExecutor;
            java.util.concurrent.Executor executor2 = this.mBackgroundThreadExecutor;
            kotlin.jvm.internal.Intrinsics.checkNotNull(executor2);
            return new com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig<>(executor, executor2, this.mDiffCallback);
        }

        @org.jetbrains.annotations.NotNull
        public final com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig.Builder<T> setBackgroundThreadExecutor(@org.jetbrains.annotations.Nullable java.util.concurrent.Executor executor) {
            this.mBackgroundThreadExecutor = executor;
            return this;
        }

        @org.jetbrains.annotations.NotNull
        public final com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig.Builder<T> setMainThreadExecutor(@org.jetbrains.annotations.Nullable java.util.concurrent.Executor executor) {
            this.mMainThreadExecutor = executor;
            return this;
        }
    }

    public BrvahAsyncDifferConfig(@org.jetbrains.annotations.Nullable java.util.concurrent.Executor executor, @org.jetbrains.annotations.NotNull java.util.concurrent.Executor backgroundThreadExecutor, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.DiffUtil.ItemCallback<T> diffCallback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(backgroundThreadExecutor, "backgroundThreadExecutor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        this.mainThreadExecutor = executor;
        this.backgroundThreadExecutor = backgroundThreadExecutor;
        this.diffCallback = diffCallback;
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.Executor getBackgroundThreadExecutor() {
        return this.backgroundThreadExecutor;
    }

    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.DiffUtil.ItemCallback<T> getDiffCallback() {
        return this.diffCallback;
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.concurrent.Executor getMainThreadExecutor() {
        return this.mainThreadExecutor;
    }
}
