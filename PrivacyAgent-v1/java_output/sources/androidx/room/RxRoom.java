package androidx.room;

/* loaded from: classes.dex */
public class RxRoom {
    public static final java.lang.Object NOTHING = new java.lang.Object();

    /* renamed from: androidx.room.RxRoom$1, reason: invalid class name */
    public class AnonymousClass1 implements io.reactivex.FlowableOnSubscribe<java.lang.Object> {
        final /* synthetic */ androidx.room.RoomDatabase val$database;
        final /* synthetic */ java.lang.String[] val$tableNames;

        /* renamed from: androidx.room.RxRoom$1$1, reason: invalid class name and collision with other inner class name */
        public class C00051 extends androidx.room.InvalidationTracker.Observer {
            final /* synthetic */ io.reactivex.FlowableEmitter val$emitter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00051(java.lang.String[] strArr, io.reactivex.FlowableEmitter flowableEmitter) {
                super(strArr);
                this.val$emitter = flowableEmitter;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@androidx.annotation.NonNull java.util.Set<java.lang.String> set) {
                if (this.val$emitter.isCancelled()) {
                    return;
                }
                this.val$emitter.onNext(androidx.room.RxRoom.NOTHING);
            }
        }

        /* renamed from: androidx.room.RxRoom$1$2, reason: invalid class name */
        public class AnonymousClass2 implements io.reactivex.functions.Action {
            final /* synthetic */ androidx.room.InvalidationTracker.Observer val$observer;

            public AnonymousClass2(androidx.room.InvalidationTracker.Observer observer) {
                this.val$observer = observer;
            }

            @Override // io.reactivex.functions.Action
            public void run() throws java.lang.Exception {
                androidx.room.RxRoom.AnonymousClass1.this.val$database.getInvalidationTracker().removeObserver(this.val$observer);
            }
        }

        public AnonymousClass1(java.lang.String[] strArr, androidx.room.RoomDatabase roomDatabase) {
            this.val$tableNames = strArr;
            this.val$database = roomDatabase;
        }

        @Override // io.reactivex.FlowableOnSubscribe
        public void subscribe(io.reactivex.FlowableEmitter<java.lang.Object> flowableEmitter) throws java.lang.Exception {
            androidx.room.RxRoom.AnonymousClass1.C00051 c00051 = new androidx.room.RxRoom.AnonymousClass1.C00051(this.val$tableNames, flowableEmitter);
            if (!flowableEmitter.isCancelled()) {
                this.val$database.getInvalidationTracker().addObserver(c00051);
                flowableEmitter.setDisposable(io.reactivex.disposables.Disposables.fromAction(new androidx.room.RxRoom.AnonymousClass1.AnonymousClass2(c00051)));
            }
            if (flowableEmitter.isCancelled()) {
                return;
            }
            flowableEmitter.onNext(androidx.room.RxRoom.NOTHING);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: androidx.room.RxRoom$2, reason: invalid class name */
    public class AnonymousClass2<T> implements io.reactivex.functions.Function<java.lang.Object, io.reactivex.MaybeSource<T>> {
        final /* synthetic */ io.reactivex.Maybe val$maybe;

        public AnonymousClass2(io.reactivex.Maybe maybe) {
            this.val$maybe = maybe;
        }

        @Override // io.reactivex.functions.Function
        public io.reactivex.MaybeSource<T> apply(java.lang.Object obj) throws java.lang.Exception {
            return this.val$maybe;
        }
    }

    /* renamed from: androidx.room.RxRoom$3, reason: invalid class name */
    public class AnonymousClass3 implements io.reactivex.ObservableOnSubscribe<java.lang.Object> {
        final /* synthetic */ androidx.room.RoomDatabase val$database;
        final /* synthetic */ java.lang.String[] val$tableNames;

        /* renamed from: androidx.room.RxRoom$3$1, reason: invalid class name */
        public class AnonymousClass1 extends androidx.room.InvalidationTracker.Observer {
            final /* synthetic */ io.reactivex.ObservableEmitter val$emitter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(java.lang.String[] strArr, io.reactivex.ObservableEmitter observableEmitter) {
                super(strArr);
                this.val$emitter = observableEmitter;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@androidx.annotation.NonNull java.util.Set<java.lang.String> set) {
                this.val$emitter.onNext(androidx.room.RxRoom.NOTHING);
            }
        }

        /* renamed from: androidx.room.RxRoom$3$2, reason: invalid class name */
        public class AnonymousClass2 implements io.reactivex.functions.Action {
            final /* synthetic */ androidx.room.InvalidationTracker.Observer val$observer;

            public AnonymousClass2(androidx.room.InvalidationTracker.Observer observer) {
                this.val$observer = observer;
            }

            @Override // io.reactivex.functions.Action
            public void run() throws java.lang.Exception {
                androidx.room.RxRoom.AnonymousClass3.this.val$database.getInvalidationTracker().removeObserver(this.val$observer);
            }
        }

        public AnonymousClass3(java.lang.String[] strArr, androidx.room.RoomDatabase roomDatabase) {
            this.val$tableNames = strArr;
            this.val$database = roomDatabase;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(io.reactivex.ObservableEmitter<java.lang.Object> observableEmitter) throws java.lang.Exception {
            androidx.room.RxRoom.AnonymousClass3.AnonymousClass1 anonymousClass1 = new androidx.room.RxRoom.AnonymousClass3.AnonymousClass1(this.val$tableNames, observableEmitter);
            this.val$database.getInvalidationTracker().addObserver(anonymousClass1);
            observableEmitter.setDisposable(io.reactivex.disposables.Disposables.fromAction(new androidx.room.RxRoom.AnonymousClass3.AnonymousClass2(anonymousClass1)));
            observableEmitter.onNext(androidx.room.RxRoom.NOTHING);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: androidx.room.RxRoom$4, reason: invalid class name */
    public class AnonymousClass4<T> implements io.reactivex.functions.Function<java.lang.Object, io.reactivex.MaybeSource<T>> {
        final /* synthetic */ io.reactivex.Maybe val$maybe;

        public AnonymousClass4(io.reactivex.Maybe maybe) {
            this.val$maybe = maybe;
        }

        @Override // io.reactivex.functions.Function
        public io.reactivex.MaybeSource<T> apply(java.lang.Object obj) throws java.lang.Exception {
            return this.val$maybe;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: androidx.room.RxRoom$5, reason: invalid class name */
    public class AnonymousClass5<T> implements io.reactivex.SingleOnSubscribe<T> {
        final /* synthetic */ java.util.concurrent.Callable val$callable;

        public AnonymousClass5(java.util.concurrent.Callable callable) {
            this.val$callable = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.SingleOnSubscribe
        public void subscribe(io.reactivex.SingleEmitter<T> singleEmitter) throws java.lang.Exception {
            try {
                singleEmitter.onSuccess(this.val$callable.call());
            } catch (androidx.room.EmptyResultSetException e) {
                singleEmitter.tryOnError(e);
            }
        }
    }

    @java.lang.Deprecated
    public RxRoom() {
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> io.reactivex.Flowable<T> createFlowable(androidx.room.RoomDatabase roomDatabase, boolean z, java.lang.String[] strArr, java.util.concurrent.Callable<T> callable) {
        io.reactivex.Scheduler from = io.reactivex.schedulers.Schedulers.from(getExecutor(roomDatabase, z));
        return (io.reactivex.Flowable<T>) createFlowable(roomDatabase, strArr).subscribeOn(from).unsubscribeOn(from).observeOn(from).flatMapMaybe(new androidx.room.RxRoom.AnonymousClass2(io.reactivex.Maybe.fromCallable(callable)));
    }

    public static io.reactivex.Flowable<java.lang.Object> createFlowable(androidx.room.RoomDatabase roomDatabase, java.lang.String... strArr) {
        return io.reactivex.Flowable.create(new androidx.room.RxRoom.AnonymousClass1(strArr, roomDatabase), io.reactivex.BackpressureStrategy.LATEST);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public static <T> io.reactivex.Flowable<T> createFlowable(androidx.room.RoomDatabase roomDatabase, java.lang.String[] strArr, java.util.concurrent.Callable<T> callable) {
        return createFlowable(roomDatabase, false, strArr, callable);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> io.reactivex.Observable<T> createObservable(androidx.room.RoomDatabase roomDatabase, boolean z, java.lang.String[] strArr, java.util.concurrent.Callable<T> callable) {
        io.reactivex.Scheduler from = io.reactivex.schedulers.Schedulers.from(getExecutor(roomDatabase, z));
        return (io.reactivex.Observable<T>) createObservable(roomDatabase, strArr).subscribeOn(from).unsubscribeOn(from).observeOn(from).flatMapMaybe(new androidx.room.RxRoom.AnonymousClass4(io.reactivex.Maybe.fromCallable(callable)));
    }

    public static io.reactivex.Observable<java.lang.Object> createObservable(androidx.room.RoomDatabase roomDatabase, java.lang.String... strArr) {
        return io.reactivex.Observable.create(new androidx.room.RxRoom.AnonymousClass3(strArr, roomDatabase));
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public static <T> io.reactivex.Observable<T> createObservable(androidx.room.RoomDatabase roomDatabase, java.lang.String[] strArr, java.util.concurrent.Callable<T> callable) {
        return createObservable(roomDatabase, false, strArr, callable);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> io.reactivex.Single<T> createSingle(java.util.concurrent.Callable<T> callable) {
        return io.reactivex.Single.create(new androidx.room.RxRoom.AnonymousClass5(callable));
    }

    private static java.util.concurrent.Executor getExecutor(androidx.room.RoomDatabase roomDatabase, boolean z) {
        return z ? roomDatabase.getTransactionExecutor() : roomDatabase.getQueryExecutor();
    }
}
