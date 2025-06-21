package androidx.recyclerview.widget;

/* loaded from: classes.dex */
class MessageThreadUtil<T> implements androidx.recyclerview.widget.ThreadUtil<T> {

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.recyclerview.widget.ThreadUtil.MainThreadCallback<T> {
        static final int ADD_TILE = 2;
        static final int REMOVE_TILE = 3;
        static final int UPDATE_ITEM_COUNT = 1;
        final /* synthetic */ androidx.recyclerview.widget.ThreadUtil.MainThreadCallback val$callback;
        final androidx.recyclerview.widget.MessageThreadUtil.MessageQueue mQueue = new androidx.recyclerview.widget.MessageThreadUtil.MessageQueue();
        private final android.os.Handler mMainThreadHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        private java.lang.Runnable mMainThreadRunnable = new androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass1.RunnableC00031();

        /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00031 implements java.lang.Runnable {
            public RunnableC00031() {
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem next = androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass1.this.mQueue.next();
                while (next != null) {
                    int i = next.what;
                    if (i == 1) {
                        androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass1.this.val$callback.updateItemCount(next.arg1, next.arg2);
                    } else if (i == 2) {
                        androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass1.this.val$callback.addTile(next.arg1, (androidx.recyclerview.widget.TileList.Tile) next.data);
                    } else if (i != 3) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Unsupported message, what=");
                        sb.append(next.what);
                    } else {
                        androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass1.this.val$callback.removeTile(next.arg1, next.arg2);
                    }
                    next = androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass1.this.mQueue.next();
                }
            }
        }

        public AnonymousClass1(androidx.recyclerview.widget.ThreadUtil.MainThreadCallback mainThreadCallback) {
            this.val$callback = mainThreadCallback;
        }

        private void sendMessage(androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem) {
            this.mQueue.sendMessage(syncQueueItem);
            this.mMainThreadHandler.post(this.mMainThreadRunnable);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i, androidx.recyclerview.widget.TileList.Tile<T> tile) {
            sendMessage(androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem.obtainMessage(2, i, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            sendMessage(androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem.obtainMessage(3, i, i2));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            sendMessage(androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem.obtainMessage(1, i, i2));
        }
    }

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.recyclerview.widget.ThreadUtil.BackgroundCallback<T> {
        static final int LOAD_TILE = 3;
        static final int RECYCLE_TILE = 4;
        static final int REFRESH = 1;
        static final int UPDATE_RANGE = 2;
        final /* synthetic */ androidx.recyclerview.widget.ThreadUtil.BackgroundCallback val$callback;
        final androidx.recyclerview.widget.MessageThreadUtil.MessageQueue mQueue = new androidx.recyclerview.widget.MessageThreadUtil.MessageQueue();
        private final java.util.concurrent.Executor mExecutor = android.os.AsyncTask.THREAD_POOL_EXECUTOR;
        java.util.concurrent.atomic.AtomicBoolean mBackgroundRunning = new java.util.concurrent.atomic.AtomicBoolean(false);
        private java.lang.Runnable mBackgroundRunnable = new androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass2.AnonymousClass1();

        /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem next = androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass2.this.mQueue.next();
                    if (next == null) {
                        androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass2.this.mBackgroundRunning.set(false);
                        return;
                    }
                    int i = next.what;
                    if (i == 1) {
                        androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass2.this.mQueue.removeMessages(1);
                        androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass2.this.val$callback.refresh(next.arg1);
                    } else if (i == 2) {
                        androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass2.this.mQueue.removeMessages(2);
                        androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass2.this.mQueue.removeMessages(3);
                        androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass2.this.val$callback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
                    } else if (i == 3) {
                        androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass2.this.val$callback.loadTile(next.arg1, next.arg2);
                    } else if (i != 4) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Unsupported message, what=");
                        sb.append(next.what);
                    } else {
                        androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass2.this.val$callback.recycleTile((androidx.recyclerview.widget.TileList.Tile) next.data);
                    }
                }
            }
        }

        public AnonymousClass2(androidx.recyclerview.widget.ThreadUtil.BackgroundCallback backgroundCallback) {
            this.val$callback = backgroundCallback;
        }

        private void maybeExecuteBackgroundRunnable() {
            if (this.mBackgroundRunning.compareAndSet(false, true)) {
                this.mExecutor.execute(this.mBackgroundRunnable);
            }
        }

        private void sendMessage(androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem) {
            this.mQueue.sendMessage(syncQueueItem);
            maybeExecuteBackgroundRunnable();
        }

        private void sendMessageAtFrontOfQueue(androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem) {
            this.mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
            maybeExecuteBackgroundRunnable();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            sendMessage(androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem.obtainMessage(3, i, i2));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(androidx.recyclerview.widget.TileList.Tile<T> tile) {
            sendMessage(androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem.obtainMessage(4, 0, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            sendMessageAtFrontOfQueue(androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem.obtainMessage(1, i, (java.lang.Object) null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            sendMessageAtFrontOfQueue(androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem.obtainMessage(2, i, i2, i3, i4, i5, null));
        }
    }

    public static class MessageQueue {
        private androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem mRoot;

        public synchronized androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem next() {
            androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem = this.mRoot;
            if (syncQueueItem == null) {
                return null;
            }
            this.mRoot = syncQueueItem.next;
            return syncQueueItem;
        }

        public synchronized void removeMessages(int i) {
            androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem;
            while (true) {
                syncQueueItem = this.mRoot;
                if (syncQueueItem == null || syncQueueItem.what != i) {
                    break;
                }
                this.mRoot = syncQueueItem.next;
                syncQueueItem.recycle();
            }
            if (syncQueueItem != null) {
                androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem2 = syncQueueItem.next;
                while (syncQueueItem2 != null) {
                    androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem3 = syncQueueItem2.next;
                    if (syncQueueItem2.what == i) {
                        syncQueueItem.next = syncQueueItem3;
                        syncQueueItem2.recycle();
                    } else {
                        syncQueueItem = syncQueueItem2;
                    }
                    syncQueueItem2 = syncQueueItem3;
                }
            }
        }

        public synchronized void sendMessage(androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem) {
            androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem2 = this.mRoot;
            if (syncQueueItem2 == null) {
                this.mRoot = syncQueueItem;
                return;
            }
            while (true) {
                androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem3 = syncQueueItem2.next;
                if (syncQueueItem3 == null) {
                    syncQueueItem2.next = syncQueueItem;
                    return;
                }
                syncQueueItem2 = syncQueueItem3;
            }
        }

        public synchronized void sendMessageAtFrontOfQueue(androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem) {
            syncQueueItem.next = this.mRoot;
            this.mRoot = syncQueueItem;
        }
    }

    public static class SyncQueueItem {
        private static androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem sPool;
        private static final java.lang.Object sPoolLock = new java.lang.Object();
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public java.lang.Object data;
        androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem next;
        public int what;

        public static androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem obtainMessage(int i, int i2, int i3) {
            return obtainMessage(i, i2, i3, 0, 0, 0, null);
        }

        public static androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem obtainMessage(int i, int i2, int i3, int i4, int i5, int i6, java.lang.Object obj) {
            androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem;
            synchronized (sPoolLock) {
                syncQueueItem = sPool;
                if (syncQueueItem == null) {
                    syncQueueItem = new androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem();
                } else {
                    sPool = syncQueueItem.next;
                    syncQueueItem.next = null;
                }
                syncQueueItem.what = i;
                syncQueueItem.arg1 = i2;
                syncQueueItem.arg2 = i3;
                syncQueueItem.arg3 = i4;
                syncQueueItem.arg4 = i5;
                syncQueueItem.arg5 = i6;
                syncQueueItem.data = obj;
            }
            return syncQueueItem;
        }

        public static androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem obtainMessage(int i, int i2, java.lang.Object obj) {
            return obtainMessage(i, i2, 0, 0, 0, 0, obj);
        }

        public void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (sPoolLock) {
                androidx.recyclerview.widget.MessageThreadUtil.SyncQueueItem syncQueueItem = sPool;
                if (syncQueueItem != null) {
                    this.next = syncQueueItem;
                }
                sPool = this;
            }
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public androidx.recyclerview.widget.ThreadUtil.BackgroundCallback<T> getBackgroundProxy(androidx.recyclerview.widget.ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass2(backgroundCallback);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public androidx.recyclerview.widget.ThreadUtil.MainThreadCallback<T> getMainThreadProxy(androidx.recyclerview.widget.ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new androidx.recyclerview.widget.MessageThreadUtil.AnonymousClass1(mainThreadCallback);
    }
}
