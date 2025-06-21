package androidx.databinding;

/* loaded from: classes.dex */
public class ListChangeRegistry extends androidx.databinding.CallbackRegistry<androidx.databinding.ObservableList.OnListChangedCallback, androidx.databinding.ObservableList, androidx.databinding.ListChangeRegistry.ListChanges> {
    private static final int ALL = 0;
    private static final int CHANGED = 1;
    private static final int INSERTED = 2;
    private static final int MOVED = 3;
    private static final int REMOVED = 4;
    private static final androidx.core.util.Pools.SynchronizedPool<androidx.databinding.ListChangeRegistry.ListChanges> sListChanges = new androidx.core.util.Pools.SynchronizedPool<>(10);
    private static final androidx.databinding.CallbackRegistry.NotifierCallback<androidx.databinding.ObservableList.OnListChangedCallback, androidx.databinding.ObservableList, androidx.databinding.ListChangeRegistry.ListChanges> NOTIFIER_CALLBACK = new androidx.databinding.ListChangeRegistry.AnonymousClass1();

    /* renamed from: androidx.databinding.ListChangeRegistry$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.databinding.CallbackRegistry.NotifierCallback<androidx.databinding.ObservableList.OnListChangedCallback, androidx.databinding.ObservableList, androidx.databinding.ListChangeRegistry.ListChanges> {
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(androidx.databinding.ObservableList.OnListChangedCallback onListChangedCallback, androidx.databinding.ObservableList observableList, int i, androidx.databinding.ListChangeRegistry.ListChanges listChanges) {
            if (i == 1) {
                onListChangedCallback.onItemRangeChanged(observableList, listChanges.start, listChanges.count);
                return;
            }
            if (i == 2) {
                onListChangedCallback.onItemRangeInserted(observableList, listChanges.start, listChanges.count);
                return;
            }
            if (i == 3) {
                onListChangedCallback.onItemRangeMoved(observableList, listChanges.start, listChanges.to, listChanges.count);
            } else if (i != 4) {
                onListChangedCallback.onChanged(observableList);
            } else {
                onListChangedCallback.onItemRangeRemoved(observableList, listChanges.start, listChanges.count);
            }
        }
    }

    public static class ListChanges {
        public int count;
        public int start;
        public int to;
    }

    public ListChangeRegistry() {
        super(NOTIFIER_CALLBACK);
    }

    private static androidx.databinding.ListChangeRegistry.ListChanges acquire(int i, int i2, int i3) {
        androidx.databinding.ListChangeRegistry.ListChanges acquire = sListChanges.acquire();
        if (acquire == null) {
            acquire = new androidx.databinding.ListChangeRegistry.ListChanges();
        }
        acquire.start = i;
        acquire.to = i2;
        acquire.count = i3;
        return acquire;
    }

    @Override // androidx.databinding.CallbackRegistry
    public synchronized void notifyCallbacks(@androidx.annotation.NonNull androidx.databinding.ObservableList observableList, int i, androidx.databinding.ListChangeRegistry.ListChanges listChanges) {
        super.notifyCallbacks((androidx.databinding.ListChangeRegistry) observableList, i, (int) listChanges);
        if (listChanges != null) {
            sListChanges.release(listChanges);
        }
    }

    public void notifyChanged(@androidx.annotation.NonNull androidx.databinding.ObservableList observableList) {
        notifyCallbacks(observableList, 0, (androidx.databinding.ListChangeRegistry.ListChanges) null);
    }

    public void notifyChanged(@androidx.annotation.NonNull androidx.databinding.ObservableList observableList, int i, int i2) {
        notifyCallbacks(observableList, 1, acquire(i, 0, i2));
    }

    public void notifyInserted(@androidx.annotation.NonNull androidx.databinding.ObservableList observableList, int i, int i2) {
        notifyCallbacks(observableList, 2, acquire(i, 0, i2));
    }

    public void notifyMoved(@androidx.annotation.NonNull androidx.databinding.ObservableList observableList, int i, int i2, int i3) {
        notifyCallbacks(observableList, 3, acquire(i, i2, i3));
    }

    public void notifyRemoved(@androidx.annotation.NonNull androidx.databinding.ObservableList observableList, int i, int i2) {
        notifyCallbacks(observableList, 4, acquire(i, 0, i2));
    }
}
