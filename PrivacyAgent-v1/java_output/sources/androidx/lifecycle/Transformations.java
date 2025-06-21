package androidx.lifecycle;

/* loaded from: classes.dex */
public class Transformations {

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* renamed from: androidx.lifecycle.Transformations$1, reason: invalid class name */
    public class AnonymousClass1<X> implements androidx.lifecycle.Observer<X> {
        final /* synthetic */ androidx.arch.core.util.Function val$mapFunction;
        final /* synthetic */ androidx.lifecycle.MediatorLiveData val$result;

        public AnonymousClass1(androidx.lifecycle.MediatorLiveData mediatorLiveData, androidx.arch.core.util.Function function) {
            this.val$result = mediatorLiveData;
            this.val$mapFunction = function;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@androidx.annotation.Nullable X x) {
            this.val$result.setValue(this.val$mapFunction.apply(x));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* renamed from: androidx.lifecycle.Transformations$2, reason: invalid class name */
    public class AnonymousClass2<X> implements androidx.lifecycle.Observer<X> {
        androidx.lifecycle.LiveData<Y> mSource;
        final /* synthetic */ androidx.lifecycle.MediatorLiveData val$result;
        final /* synthetic */ androidx.arch.core.util.Function val$switchMapFunction;

        /* JADX INFO: Add missing generic type declarations: [Y] */
        /* renamed from: androidx.lifecycle.Transformations$2$1, reason: invalid class name */
        public class AnonymousClass1<Y> implements androidx.lifecycle.Observer<Y> {
            public AnonymousClass1() {
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(@androidx.annotation.Nullable Y y) {
                androidx.lifecycle.Transformations.AnonymousClass2.this.val$result.setValue(y);
            }
        }

        public AnonymousClass2(androidx.arch.core.util.Function function, androidx.lifecycle.MediatorLiveData mediatorLiveData) {
            this.val$switchMapFunction = function;
            this.val$result = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@androidx.annotation.Nullable X x) {
            androidx.lifecycle.LiveData<Y> liveData = (androidx.lifecycle.LiveData) this.val$switchMapFunction.apply(x);
            java.lang.Object obj = this.mSource;
            if (obj == liveData) {
                return;
            }
            if (obj != null) {
                this.val$result.removeSource(obj);
            }
            this.mSource = liveData;
            if (liveData != 0) {
                this.val$result.addSource(liveData, new androidx.lifecycle.Transformations.AnonymousClass2.AnonymousClass1());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* renamed from: androidx.lifecycle.Transformations$3, reason: invalid class name */
    public class AnonymousClass3<X> implements androidx.lifecycle.Observer<X> {
        boolean mFirstTime = true;
        final /* synthetic */ androidx.lifecycle.MediatorLiveData val$outputLiveData;

        public AnonymousClass3(androidx.lifecycle.MediatorLiveData mediatorLiveData) {
            this.val$outputLiveData = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(X x) {
            T value = this.val$outputLiveData.getValue();
            if (this.mFirstTime || ((value == 0 && x != null) || !(value == 0 || value.equals(x)))) {
                this.mFirstTime = false;
                this.val$outputLiveData.setValue(x);
            }
        }
    }

    private Transformations() {
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public static <X> androidx.lifecycle.LiveData<X> distinctUntilChanged(@androidx.annotation.NonNull androidx.lifecycle.LiveData<X> liveData) {
        androidx.lifecycle.MediatorLiveData mediatorLiveData = new androidx.lifecycle.MediatorLiveData();
        mediatorLiveData.addSource(liveData, new androidx.lifecycle.Transformations.AnonymousClass3(mediatorLiveData));
        return mediatorLiveData;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public static <X, Y> androidx.lifecycle.LiveData<Y> map(@androidx.annotation.NonNull androidx.lifecycle.LiveData<X> liveData, @androidx.annotation.NonNull androidx.arch.core.util.Function<X, Y> function) {
        androidx.lifecycle.MediatorLiveData mediatorLiveData = new androidx.lifecycle.MediatorLiveData();
        mediatorLiveData.addSource(liveData, new androidx.lifecycle.Transformations.AnonymousClass1(mediatorLiveData, function));
        return mediatorLiveData;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public static <X, Y> androidx.lifecycle.LiveData<Y> switchMap(@androidx.annotation.NonNull androidx.lifecycle.LiveData<X> liveData, @androidx.annotation.NonNull androidx.arch.core.util.Function<X, androidx.lifecycle.LiveData<Y>> function) {
        androidx.lifecycle.MediatorLiveData mediatorLiveData = new androidx.lifecycle.MediatorLiveData();
        mediatorLiveData.addSource(liveData, new androidx.lifecycle.Transformations.AnonymousClass2(function, mediatorLiveData));
        return mediatorLiveData;
    }
}
