package androidx.room;

/* loaded from: classes.dex */
class MultiInstanceInvalidationClient {
    final android.content.Context mAppContext;
    int mClientId;
    final java.util.concurrent.Executor mExecutor;
    final androidx.room.InvalidationTracker mInvalidationTracker;
    final java.lang.String mName;
    final androidx.room.InvalidationTracker.Observer mObserver;
    final java.lang.Runnable mRemoveObserverRunnable;

    @androidx.annotation.Nullable
    androidx.room.IMultiInstanceInvalidationService mService;
    final android.content.ServiceConnection mServiceConnection;
    final java.lang.Runnable mSetUpRunnable;
    final androidx.room.IMultiInstanceInvalidationCallback mCallback = new androidx.room.MultiInstanceInvalidationClient.AnonymousClass1();
    final java.util.concurrent.atomic.AtomicBoolean mStopped = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* renamed from: androidx.room.MultiInstanceInvalidationClient$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.room.IMultiInstanceInvalidationCallback.Stub {

        /* renamed from: androidx.room.MultiInstanceInvalidationClient$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00041 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String[] val$tables;

            public RunnableC00041(java.lang.String[] strArr) {
                this.val$tables = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.room.MultiInstanceInvalidationClient.this.mInvalidationTracker.notifyObserversByTableNames(this.val$tables);
            }
        }

        public AnonymousClass1() {
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void onInvalidation(java.lang.String[] strArr) {
            androidx.room.MultiInstanceInvalidationClient.this.mExecutor.execute(new androidx.room.MultiInstanceInvalidationClient.AnonymousClass1.RunnableC00041(strArr));
        }
    }

    /* renamed from: androidx.room.MultiInstanceInvalidationClient$2, reason: invalid class name */
    public class AnonymousClass2 implements android.content.ServiceConnection {
        public AnonymousClass2() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            androidx.room.MultiInstanceInvalidationClient.this.mService = androidx.room.IMultiInstanceInvalidationService.Stub.asInterface(iBinder);
            androidx.room.MultiInstanceInvalidationClient multiInstanceInvalidationClient = androidx.room.MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mExecutor.execute(multiInstanceInvalidationClient.mSetUpRunnable);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            androidx.room.MultiInstanceInvalidationClient multiInstanceInvalidationClient = androidx.room.MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mExecutor.execute(multiInstanceInvalidationClient.mRemoveObserverRunnable);
            androidx.room.MultiInstanceInvalidationClient.this.mService = null;
        }
    }

    /* renamed from: androidx.room.MultiInstanceInvalidationClient$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.room.MultiInstanceInvalidationClient multiInstanceInvalidationClient = androidx.room.MultiInstanceInvalidationClient.this;
                androidx.room.IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.mService;
                if (iMultiInstanceInvalidationService != null) {
                    multiInstanceInvalidationClient.mClientId = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.mCallback, multiInstanceInvalidationClient.mName);
                    androidx.room.MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = androidx.room.MultiInstanceInvalidationClient.this;
                    multiInstanceInvalidationClient2.mInvalidationTracker.addObserver(multiInstanceInvalidationClient2.mObserver);
                }
            } catch (android.os.RemoteException unused) {
            }
        }
    }

    /* renamed from: androidx.room.MultiInstanceInvalidationClient$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.room.MultiInstanceInvalidationClient multiInstanceInvalidationClient = androidx.room.MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mInvalidationTracker.removeObserver(multiInstanceInvalidationClient.mObserver);
        }
    }

    /* renamed from: androidx.room.MultiInstanceInvalidationClient$5, reason: invalid class name */
    public class AnonymousClass5 extends androidx.room.InvalidationTracker.Observer {
        public AnonymousClass5(java.lang.String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public boolean isRemote() {
            return true;
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@androidx.annotation.NonNull java.util.Set<java.lang.String> set) {
            if (androidx.room.MultiInstanceInvalidationClient.this.mStopped.get()) {
                return;
            }
            try {
                androidx.room.MultiInstanceInvalidationClient multiInstanceInvalidationClient = androidx.room.MultiInstanceInvalidationClient.this;
                androidx.room.IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.mService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.broadcastInvalidation(multiInstanceInvalidationClient.mClientId, (java.lang.String[]) set.toArray(new java.lang.String[0]));
                }
            } catch (android.os.RemoteException unused) {
            }
        }
    }

    public MultiInstanceInvalidationClient(android.content.Context context, java.lang.String str, androidx.room.InvalidationTracker invalidationTracker, java.util.concurrent.Executor executor) {
        androidx.room.MultiInstanceInvalidationClient.AnonymousClass2 anonymousClass2 = new androidx.room.MultiInstanceInvalidationClient.AnonymousClass2();
        this.mServiceConnection = anonymousClass2;
        this.mSetUpRunnable = new androidx.room.MultiInstanceInvalidationClient.AnonymousClass3();
        this.mRemoveObserverRunnable = new androidx.room.MultiInstanceInvalidationClient.AnonymousClass4();
        android.content.Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mName = str;
        this.mInvalidationTracker = invalidationTracker;
        this.mExecutor = executor;
        this.mObserver = new androidx.room.MultiInstanceInvalidationClient.AnonymousClass5((java.lang.String[]) invalidationTracker.mTableIdLookup.keySet().toArray(new java.lang.String[0]));
        applicationContext.bindService(new android.content.Intent(applicationContext, (java.lang.Class<?>) androidx.room.MultiInstanceInvalidationService.class), anonymousClass2, 1);
    }

    public void stop() {
        if (this.mStopped.compareAndSet(false, true)) {
            this.mInvalidationTracker.removeObserver(this.mObserver);
            try {
                androidx.room.IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.mService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.mCallback, this.mClientId);
                }
            } catch (android.os.RemoteException unused) {
            }
            this.mAppContext.unbindService(this.mServiceConnection);
        }
    }
}
