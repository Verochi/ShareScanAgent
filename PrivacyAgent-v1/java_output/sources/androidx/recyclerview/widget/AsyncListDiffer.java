package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public class AsyncListDiffer<T> {
    private static final java.util.concurrent.Executor sMainThreadExecutor = new androidx.recyclerview.widget.AsyncListDiffer.MainThreadExecutor();
    final androidx.recyclerview.widget.AsyncDifferConfig<T> mConfig;

    @androidx.annotation.Nullable
    private java.util.List<T> mList;
    private final java.util.List<androidx.recyclerview.widget.AsyncListDiffer.ListListener<T>> mListeners;
    java.util.concurrent.Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;

    @androidx.annotation.NonNull
    private java.util.List<T> mReadOnlyList;
    private final androidx.recyclerview.widget.ListUpdateCallback mUpdateCallback;

    /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Runnable val$commitCallback;
        final /* synthetic */ java.util.List val$newList;
        final /* synthetic */ java.util.List val$oldList;
        final /* synthetic */ int val$runGeneration;

        /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$1, reason: invalid class name and collision with other inner class name */
        public class C00021 extends androidx.recyclerview.widget.DiffUtil.Callback {
            public C00021() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                java.lang.Object obj = androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.this.val$oldList.get(i);
                java.lang.Object obj2 = androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.this.val$newList.get(i2);
                if (obj != null && obj2 != null) {
                    return androidx.recyclerview.widget.AsyncListDiffer.this.mConfig.getDiffCallback().areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new java.lang.AssertionError();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                java.lang.Object obj = androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.this.val$oldList.get(i);
                java.lang.Object obj2 = androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.this.val$newList.get(i2);
                return (obj == null || obj2 == null) ? obj == null && obj2 == null : androidx.recyclerview.widget.AsyncListDiffer.this.mConfig.getDiffCallback().areItemsTheSame(obj, obj2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            @androidx.annotation.Nullable
            public java.lang.Object getChangePayload(int i, int i2) {
                java.lang.Object obj = androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.this.val$oldList.get(i);
                java.lang.Object obj2 = androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.this.val$newList.get(i2);
                if (obj == null || obj2 == null) {
                    throw new java.lang.AssertionError();
                }
                return androidx.recyclerview.widget.AsyncListDiffer.this.mConfig.getDiffCallback().getChangePayload(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.this.val$newList.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.this.val$oldList.size();
            }
        }

        /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ androidx.recyclerview.widget.DiffUtil.DiffResult val$result;

            public AnonymousClass2(androidx.recyclerview.widget.DiffUtil.DiffResult diffResult) {
                this.val$result = diffResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1 anonymousClass1 = androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.this;
                androidx.recyclerview.widget.AsyncListDiffer asyncListDiffer = androidx.recyclerview.widget.AsyncListDiffer.this;
                if (asyncListDiffer.mMaxScheduledGeneration == anonymousClass1.val$runGeneration) {
                    asyncListDiffer.latchList(anonymousClass1.val$newList, this.val$result, anonymousClass1.val$commitCallback);
                }
            }
        }

        public AnonymousClass1(java.util.List list, java.util.List list2, int i, java.lang.Runnable runnable) {
            this.val$oldList = list;
            this.val$newList = list2;
            this.val$runGeneration = i;
            this.val$commitCallback = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.recyclerview.widget.AsyncListDiffer.this.mMainThreadExecutor.execute(new androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.AnonymousClass2(androidx.recyclerview.widget.DiffUtil.calculateDiff(new androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1.C00021())));
        }
    }

    public interface ListListener<T> {
        void onCurrentListChanged(@androidx.annotation.NonNull java.util.List<T> list, @androidx.annotation.NonNull java.util.List<T> list2);
    }

    public static class MainThreadExecutor implements java.util.concurrent.Executor {
        final android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            this.mHandler.post(runnable);
        }
    }

    public AsyncListDiffer(@androidx.annotation.NonNull androidx.recyclerview.widget.ListUpdateCallback listUpdateCallback, @androidx.annotation.NonNull androidx.recyclerview.widget.AsyncDifferConfig<T> asyncDifferConfig) {
        this.mListeners = new java.util.concurrent.CopyOnWriteArrayList();
        this.mReadOnlyList = java.util.Collections.emptyList();
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
        if (asyncDifferConfig.getMainThreadExecutor() != null) {
            this.mMainThreadExecutor = asyncDifferConfig.getMainThreadExecutor();
        } else {
            this.mMainThreadExecutor = sMainThreadExecutor;
        }
    }

    public AsyncListDiffer(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.Adapter adapter, @androidx.annotation.NonNull androidx.recyclerview.widget.DiffUtil.ItemCallback<T> itemCallback) {
        this(new androidx.recyclerview.widget.AdapterListUpdateCallback(adapter), new androidx.recyclerview.widget.AsyncDifferConfig.Builder(itemCallback).build());
    }

    private void onCurrentListChanged(@androidx.annotation.NonNull java.util.List<T> list, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        java.util.Iterator<androidx.recyclerview.widget.AsyncListDiffer.ListListener<T>> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onCurrentListChanged(list, this.mReadOnlyList);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addListListener(@androidx.annotation.NonNull androidx.recyclerview.widget.AsyncListDiffer.ListListener<T> listListener) {
        this.mListeners.add(listListener);
    }

    @androidx.annotation.NonNull
    public java.util.List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    public void latchList(@androidx.annotation.NonNull java.util.List<T> list, @androidx.annotation.NonNull androidx.recyclerview.widget.DiffUtil.DiffResult diffResult, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        java.util.List<T> list2 = this.mReadOnlyList;
        this.mList = list;
        this.mReadOnlyList = java.util.Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
        onCurrentListChanged(list2, runnable);
    }

    public void removeListListener(@androidx.annotation.NonNull androidx.recyclerview.widget.AsyncListDiffer.ListListener<T> listListener) {
        this.mListeners.remove(listListener);
    }

    public void submitList(@androidx.annotation.Nullable java.util.List<T> list) {
        submitList(list, null);
    }

    public void submitList(@androidx.annotation.Nullable java.util.List<T> list, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        int i = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = i;
        java.util.List<T> list2 = this.mList;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        java.util.List<T> list3 = this.mReadOnlyList;
        if (list == null) {
            int size = list2.size();
            this.mList = null;
            this.mReadOnlyList = java.util.Collections.emptyList();
            this.mUpdateCallback.onRemoved(0, size);
            onCurrentListChanged(list3, runnable);
            return;
        }
        if (list2 != null) {
            this.mConfig.getBackgroundThreadExecutor().execute(new androidx.recyclerview.widget.AsyncListDiffer.AnonymousClass1(list2, list, i, runnable));
            return;
        }
        this.mList = list;
        this.mReadOnlyList = java.util.Collections.unmodifiableList(list);
        this.mUpdateCallback.onInserted(0, list.size());
        onCurrentListChanged(list3, runnable);
    }
}
