package androidx.databinding;

/* loaded from: classes.dex */
public abstract class ViewDataBinding extends androidx.databinding.BaseObservable implements androidx.viewbinding.ViewBinding {
    private static final int BINDING_NUMBER_START = 8;
    public static final java.lang.String BINDING_TAG_PREFIX = "binding_";
    private static final int HALTED = 2;
    private static final int REBIND = 1;
    private static final int REBOUND = 3;
    protected final androidx.databinding.DataBindingComponent mBindingComponent;
    private android.view.Choreographer mChoreographer;
    private androidx.databinding.ViewDataBinding mContainingBinding;
    private final android.view.Choreographer.FrameCallback mFrameCallback;
    private boolean mInLiveDataRegisterObserver;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mInStateFlowRegisterObserver;
    private boolean mIsExecutingPendingBindings;
    private androidx.lifecycle.LifecycleOwner mLifecycleOwner;
    private androidx.databinding.WeakListener[] mLocalFieldObservers;
    private androidx.databinding.ViewDataBinding.OnStartListener mOnStartListener;
    private boolean mPendingRebind;
    private androidx.databinding.CallbackRegistry<androidx.databinding.OnRebindCallback, androidx.databinding.ViewDataBinding, java.lang.Void> mRebindCallbacks;
    private boolean mRebindHalted;
    private final java.lang.Runnable mRebindRunnable;
    private final android.view.View mRoot;
    private android.os.Handler mUIThreadHandler;
    static int SDK_INT = android.os.Build.VERSION.SDK_INT;
    private static final boolean USE_CHOREOGRAPHER = true;
    private static final androidx.databinding.CreateWeakListener CREATE_PROPERTY_LISTENER = new androidx.databinding.ViewDataBinding.AnonymousClass1();
    private static final androidx.databinding.CreateWeakListener CREATE_LIST_LISTENER = new androidx.databinding.ViewDataBinding.AnonymousClass2();
    private static final androidx.databinding.CreateWeakListener CREATE_MAP_LISTENER = new androidx.databinding.ViewDataBinding.AnonymousClass3();
    private static final androidx.databinding.CreateWeakListener CREATE_LIVE_DATA_LISTENER = new androidx.databinding.ViewDataBinding.AnonymousClass4();
    private static final androidx.databinding.CallbackRegistry.NotifierCallback<androidx.databinding.OnRebindCallback, androidx.databinding.ViewDataBinding, java.lang.Void> REBIND_NOTIFIER = new androidx.databinding.ViewDataBinding.AnonymousClass5();
    private static final java.lang.ref.ReferenceQueue<androidx.databinding.ViewDataBinding> sReferenceQueue = new java.lang.ref.ReferenceQueue<>();
    private static final android.view.View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER = new androidx.databinding.ViewDataBinding.AnonymousClass6();

    /* renamed from: androidx.databinding.ViewDataBinding$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.databinding.CreateWeakListener {
        @Override // androidx.databinding.CreateWeakListener
        public androidx.databinding.WeakListener create(androidx.databinding.ViewDataBinding viewDataBinding, int i, java.lang.ref.ReferenceQueue<androidx.databinding.ViewDataBinding> referenceQueue) {
            return new androidx.databinding.ViewDataBinding.WeakPropertyListener(viewDataBinding, i, referenceQueue).getListener();
        }
    }

    /* renamed from: androidx.databinding.ViewDataBinding$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.databinding.CreateWeakListener {
        @Override // androidx.databinding.CreateWeakListener
        public androidx.databinding.WeakListener create(androidx.databinding.ViewDataBinding viewDataBinding, int i, java.lang.ref.ReferenceQueue<androidx.databinding.ViewDataBinding> referenceQueue) {
            return new androidx.databinding.ViewDataBinding.WeakListListener(viewDataBinding, i, referenceQueue).getListener();
        }
    }

    /* renamed from: androidx.databinding.ViewDataBinding$3, reason: invalid class name */
    public class AnonymousClass3 implements androidx.databinding.CreateWeakListener {
        @Override // androidx.databinding.CreateWeakListener
        public androidx.databinding.WeakListener create(androidx.databinding.ViewDataBinding viewDataBinding, int i, java.lang.ref.ReferenceQueue<androidx.databinding.ViewDataBinding> referenceQueue) {
            return new androidx.databinding.ViewDataBinding.WeakMapListener(viewDataBinding, i, referenceQueue).getListener();
        }
    }

    /* renamed from: androidx.databinding.ViewDataBinding$4, reason: invalid class name */
    public class AnonymousClass4 implements androidx.databinding.CreateWeakListener {
        @Override // androidx.databinding.CreateWeakListener
        public androidx.databinding.WeakListener create(androidx.databinding.ViewDataBinding viewDataBinding, int i, java.lang.ref.ReferenceQueue<androidx.databinding.ViewDataBinding> referenceQueue) {
            return new androidx.databinding.ViewDataBinding.LiveDataListener(viewDataBinding, i, referenceQueue).getListener();
        }
    }

    /* renamed from: androidx.databinding.ViewDataBinding$5, reason: invalid class name */
    public class AnonymousClass5 extends androidx.databinding.CallbackRegistry.NotifierCallback<androidx.databinding.OnRebindCallback, androidx.databinding.ViewDataBinding, java.lang.Void> {
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(androidx.databinding.OnRebindCallback onRebindCallback, androidx.databinding.ViewDataBinding viewDataBinding, int i, java.lang.Void r4) {
            if (i == 1) {
                if (onRebindCallback.onPreBind(viewDataBinding)) {
                    return;
                }
                viewDataBinding.mRebindHalted = true;
            } else if (i == 2) {
                onRebindCallback.onCanceled(viewDataBinding);
            } else {
                if (i != 3) {
                    return;
                }
                onRebindCallback.onBound(viewDataBinding);
            }
        }
    }

    /* renamed from: androidx.databinding.ViewDataBinding$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        @android.annotation.TargetApi(19)
        public void onViewAttachedToWindow(android.view.View view) {
            androidx.databinding.ViewDataBinding.getBinding(view).mRebindRunnable.run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
        }
    }

    /* renamed from: androidx.databinding.ViewDataBinding$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                androidx.databinding.ViewDataBinding.this.mPendingRebind = false;
            }
            androidx.databinding.ViewDataBinding.processReferenceQueue();
            if (androidx.databinding.ViewDataBinding.this.mRoot.isAttachedToWindow()) {
                androidx.databinding.ViewDataBinding.this.executePendingBindings();
            } else {
                androidx.databinding.ViewDataBinding.this.mRoot.removeOnAttachStateChangeListener(androidx.databinding.ViewDataBinding.ROOT_REATTACHED_LISTENER);
                androidx.databinding.ViewDataBinding.this.mRoot.addOnAttachStateChangeListener(androidx.databinding.ViewDataBinding.ROOT_REATTACHED_LISTENER);
            }
        }
    }

    /* renamed from: androidx.databinding.ViewDataBinding$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.Choreographer.FrameCallback {
        public AnonymousClass8() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            androidx.databinding.ViewDataBinding.this.mRebindRunnable.run();
        }
    }

    public static class IncludedLayouts {
        public final int[][] indexes;
        public final int[][] layoutIds;
        public final java.lang.String[][] layouts;

        public IncludedLayouts(int i) {
            this.layouts = new java.lang.String[i][];
            this.indexes = new int[i][];
            this.layoutIds = new int[i][];
        }

        public void setIncludes(int i, java.lang.String[] strArr, int[] iArr, int[] iArr2) {
            this.layouts[i] = strArr;
            this.indexes[i] = iArr;
            this.layoutIds[i] = iArr2;
        }
    }

    public static class LiveDataListener implements androidx.lifecycle.Observer, androidx.databinding.ObservableReference<androidx.lifecycle.LiveData<?>> {

        @androidx.annotation.Nullable
        java.lang.ref.WeakReference<androidx.lifecycle.LifecycleOwner> mLifecycleOwnerRef = null;
        final androidx.databinding.WeakListener<androidx.lifecycle.LiveData<?>> mListener;

        public LiveDataListener(androidx.databinding.ViewDataBinding viewDataBinding, int i, java.lang.ref.ReferenceQueue<androidx.databinding.ViewDataBinding> referenceQueue) {
            this.mListener = new androidx.databinding.WeakListener<>(viewDataBinding, i, this, referenceQueue);
        }

        @androidx.annotation.Nullable
        private androidx.lifecycle.LifecycleOwner getLifecycleOwner() {
            java.lang.ref.WeakReference<androidx.lifecycle.LifecycleOwner> weakReference = this.mLifecycleOwnerRef;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(androidx.lifecycle.LiveData<?> liveData) {
            androidx.lifecycle.LifecycleOwner lifecycleOwner = getLifecycleOwner();
            if (lifecycleOwner != null) {
                liveData.observe(lifecycleOwner, this);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public androidx.databinding.WeakListener<androidx.lifecycle.LiveData<?>> getListener() {
            return this.mListener;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@androidx.annotation.Nullable java.lang.Object obj) {
            androidx.databinding.ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null) {
                androidx.databinding.WeakListener<androidx.lifecycle.LiveData<?>> weakListener = this.mListener;
                binder.handleFieldChange(weakListener.mLocalFieldId, weakListener.getTarget(), 0);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(androidx.lifecycle.LiveData<?> liveData) {
            liveData.removeObserver(this);
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(@androidx.annotation.Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
            androidx.lifecycle.LiveData<?> target = this.mListener.getTarget();
            if (target != null) {
                if (lifecycleOwner2 != null) {
                    target.removeObserver(this);
                }
                if (lifecycleOwner != null) {
                    target.observe(lifecycleOwner, this);
                }
            }
            if (lifecycleOwner != null) {
                this.mLifecycleOwnerRef = new java.lang.ref.WeakReference<>(lifecycleOwner);
            }
        }
    }

    public static class OnStartListener implements androidx.lifecycle.LifecycleObserver {
        final java.lang.ref.WeakReference<androidx.databinding.ViewDataBinding> mBinding;

        private OnStartListener(androidx.databinding.ViewDataBinding viewDataBinding) {
            this.mBinding = new java.lang.ref.WeakReference<>(viewDataBinding);
        }

        public /* synthetic */ OnStartListener(androidx.databinding.ViewDataBinding viewDataBinding, androidx.databinding.ViewDataBinding.AnonymousClass1 anonymousClass1) {
            this(viewDataBinding);
        }

        @androidx.lifecycle.OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START)
        public void onStart() {
            androidx.databinding.ViewDataBinding viewDataBinding = this.mBinding.get();
            if (viewDataBinding != null) {
                viewDataBinding.executePendingBindings();
            }
        }
    }

    public static abstract class PropertyChangedInverseListener extends androidx.databinding.Observable.OnPropertyChangedCallback implements androidx.databinding.InverseBindingListener {
        final int mPropertyId;

        public PropertyChangedInverseListener(int i) {
            this.mPropertyId = i;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(androidx.databinding.Observable observable, int i) {
            if (i == this.mPropertyId || i == 0) {
                onChange();
            }
        }
    }

    public static class WeakListListener extends androidx.databinding.ObservableList.OnListChangedCallback implements androidx.databinding.ObservableReference<androidx.databinding.ObservableList> {
        final androidx.databinding.WeakListener<androidx.databinding.ObservableList> mListener;

        public WeakListListener(androidx.databinding.ViewDataBinding viewDataBinding, int i, java.lang.ref.ReferenceQueue<androidx.databinding.ViewDataBinding> referenceQueue) {
            this.mListener = new androidx.databinding.WeakListener<>(viewDataBinding, i, this, referenceQueue);
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(androidx.databinding.ObservableList observableList) {
            observableList.addOnListChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableReference
        public androidx.databinding.WeakListener<androidx.databinding.ObservableList> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onChanged(androidx.databinding.ObservableList observableList) {
            androidx.databinding.ObservableList target;
            androidx.databinding.ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && (target = this.mListener.getTarget()) == observableList) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, target, 0);
            }
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeChanged(androidx.databinding.ObservableList observableList, int i, int i2) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeInserted(androidx.databinding.ObservableList observableList, int i, int i2) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeMoved(androidx.databinding.ObservableList observableList, int i, int i2, int i3) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeRemoved(androidx.databinding.ObservableList observableList, int i, int i2) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(androidx.databinding.ObservableList observableList) {
            observableList.removeOnListChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        }
    }

    public static class WeakMapListener extends androidx.databinding.ObservableMap.OnMapChangedCallback implements androidx.databinding.ObservableReference<androidx.databinding.ObservableMap> {
        final androidx.databinding.WeakListener<androidx.databinding.ObservableMap> mListener;

        public WeakMapListener(androidx.databinding.ViewDataBinding viewDataBinding, int i, java.lang.ref.ReferenceQueue<androidx.databinding.ViewDataBinding> referenceQueue) {
            this.mListener = new androidx.databinding.WeakListener<>(viewDataBinding, i, this, referenceQueue);
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(androidx.databinding.ObservableMap observableMap) {
            observableMap.addOnMapChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableReference
        public androidx.databinding.WeakListener<androidx.databinding.ObservableMap> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.ObservableMap.OnMapChangedCallback
        public void onMapChanged(androidx.databinding.ObservableMap observableMap, java.lang.Object obj) {
            androidx.databinding.ViewDataBinding binder = this.mListener.getBinder();
            if (binder == null || observableMap != this.mListener.getTarget()) {
                return;
            }
            binder.handleFieldChange(this.mListener.mLocalFieldId, observableMap, 0);
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(androidx.databinding.ObservableMap observableMap) {
            observableMap.removeOnMapChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        }
    }

    public static class WeakPropertyListener extends androidx.databinding.Observable.OnPropertyChangedCallback implements androidx.databinding.ObservableReference<androidx.databinding.Observable> {
        final androidx.databinding.WeakListener<androidx.databinding.Observable> mListener;

        public WeakPropertyListener(androidx.databinding.ViewDataBinding viewDataBinding, int i, java.lang.ref.ReferenceQueue<androidx.databinding.ViewDataBinding> referenceQueue) {
            this.mListener = new androidx.databinding.WeakListener<>(viewDataBinding, i, this, referenceQueue);
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(androidx.databinding.Observable observable) {
            observable.addOnPropertyChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableReference
        public androidx.databinding.WeakListener<androidx.databinding.Observable> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(androidx.databinding.Observable observable, int i) {
            androidx.databinding.ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && this.mListener.getTarget() == observable) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, observable, i);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(androidx.databinding.Observable observable) {
            observable.removeOnPropertyChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        }
    }

    public ViewDataBinding(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, int i) {
        this.mRebindRunnable = new androidx.databinding.ViewDataBinding.AnonymousClass7();
        this.mPendingRebind = false;
        this.mRebindHalted = false;
        this.mBindingComponent = dataBindingComponent;
        this.mLocalFieldObservers = new androidx.databinding.WeakListener[i];
        this.mRoot = view;
        if (android.os.Looper.myLooper() == null) {
            throw new java.lang.IllegalStateException("DataBinding must be created in view's UI Thread");
        }
        if (USE_CHOREOGRAPHER) {
            this.mChoreographer = android.view.Choreographer.getInstance();
            this.mFrameCallback = new androidx.databinding.ViewDataBinding.AnonymousClass8();
        } else {
            this.mFrameCallback = null;
            this.mUIThreadHandler = new android.os.Handler(android.os.Looper.myLooper());
        }
    }

    public ViewDataBinding(java.lang.Object obj, android.view.View view, int i) {
        this(checkAndCastToBindingComponent(obj), view, i);
    }

    public static androidx.databinding.ViewDataBinding bind(java.lang.Object obj, android.view.View view, int i) {
        return androidx.databinding.DataBindingUtil.bind(checkAndCastToBindingComponent(obj), view, i);
    }

    private static androidx.databinding.DataBindingComponent checkAndCastToBindingComponent(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof androidx.databinding.DataBindingComponent) {
            return (androidx.databinding.DataBindingComponent) obj;
        }
        throw new java.lang.IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private void executeBindingsInternal() {
        if (this.mIsExecutingPendingBindings) {
            requestRebind();
            return;
        }
        if (hasPendingBindings()) {
            this.mIsExecutingPendingBindings = true;
            this.mRebindHalted = false;
            androidx.databinding.CallbackRegistry<androidx.databinding.OnRebindCallback, androidx.databinding.ViewDataBinding, java.lang.Void> callbackRegistry = this.mRebindCallbacks;
            if (callbackRegistry != null) {
                callbackRegistry.notifyCallbacks(this, 1, null);
                if (this.mRebindHalted) {
                    this.mRebindCallbacks.notifyCallbacks(this, 2, null);
                }
            }
            if (!this.mRebindHalted) {
                executeBindings();
                androidx.databinding.CallbackRegistry<androidx.databinding.OnRebindCallback, androidx.databinding.ViewDataBinding, java.lang.Void> callbackRegistry2 = this.mRebindCallbacks;
                if (callbackRegistry2 != null) {
                    callbackRegistry2.notifyCallbacks(this, 3, null);
                }
            }
            this.mIsExecutingPendingBindings = false;
        }
    }

    public static void executeBindingsOn(androidx.databinding.ViewDataBinding viewDataBinding) {
        viewDataBinding.executeBindingsInternal();
    }

    private static int findIncludeIndex(java.lang.String str, int i, androidx.databinding.ViewDataBinding.IncludedLayouts includedLayouts, int i2) {
        java.lang.CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        java.lang.String[] strArr = includedLayouts.layouts[i2];
        int length = strArr.length;
        while (i < length) {
            if (android.text.TextUtils.equals(subSequence, strArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static int findLastMatching(android.view.ViewGroup viewGroup, int i) {
        java.lang.String str = (java.lang.String) viewGroup.getChildAt(i).getTag();
        java.lang.String substring = str.substring(0, str.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i2 = i + 1; i2 < childCount; i2++) {
            android.view.View childAt = viewGroup.getChildAt(i2);
            java.lang.String str2 = childAt.getTag() instanceof java.lang.String ? (java.lang.String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(substring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i;
                }
                if (isNumeric(str2, length)) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public static androidx.databinding.ViewDataBinding getBinding(android.view.View view) {
        if (view != null) {
            return (androidx.databinding.ViewDataBinding) view.getTag(androidx.databinding.library.R.id.dataBinding);
        }
        return null;
    }

    public static int getBuildSdkInt() {
        return SDK_INT;
    }

    public static int getColorFromResource(android.view.View view, int i) {
        int color;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return view.getResources().getColor(i);
        }
        color = view.getContext().getColor(i);
        return color;
    }

    public static android.content.res.ColorStateList getColorStateListFromResource(android.view.View view, int i) {
        android.content.res.ColorStateList colorStateList;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return view.getResources().getColorStateList(i);
        }
        colorStateList = view.getContext().getColorStateList(i);
        return colorStateList;
    }

    public static android.graphics.drawable.Drawable getDrawableFromResource(android.view.View view, int i) {
        return view.getContext().getDrawable(i);
    }

    public static <K, T> T getFrom(java.util.Map<K, T> map, K k) {
        if (map == null) {
            return null;
        }
        return map.get(k);
    }

    public static byte getFromArray(byte[] bArr, int i) {
        if (bArr == null || i < 0 || i >= bArr.length) {
            return (byte) 0;
        }
        return bArr[i];
    }

    public static char getFromArray(char[] cArr, int i) {
        if (cArr == null || i < 0 || i >= cArr.length) {
            return (char) 0;
        }
        return cArr[i];
    }

    public static double getFromArray(double[] dArr, int i) {
        if (dArr == null || i < 0 || i >= dArr.length) {
            return 0.0d;
        }
        return dArr[i];
    }

    public static float getFromArray(float[] fArr, int i) {
        if (fArr == null || i < 0 || i >= fArr.length) {
            return 0.0f;
        }
        return fArr[i];
    }

    public static int getFromArray(int[] iArr, int i) {
        if (iArr == null || i < 0 || i >= iArr.length) {
            return 0;
        }
        return iArr[i];
    }

    public static long getFromArray(long[] jArr, int i) {
        if (jArr == null || i < 0 || i >= jArr.length) {
            return 0L;
        }
        return jArr[i];
    }

    public static <T> T getFromArray(T[] tArr, int i) {
        if (tArr == null || i < 0 || i >= tArr.length) {
            return null;
        }
        return tArr[i];
    }

    public static short getFromArray(short[] sArr, int i) {
        if (sArr == null || i < 0 || i >= sArr.length) {
            return (short) 0;
        }
        return sArr[i];
    }

    public static boolean getFromArray(boolean[] zArr, int i) {
        if (zArr == null || i < 0 || i >= zArr.length) {
            return false;
        }
        return zArr[i];
    }

    public static int getFromList(android.util.SparseIntArray sparseIntArray, int i) {
        if (sparseIntArray == null || i < 0) {
            return 0;
        }
        return sparseIntArray.get(i);
    }

    @android.annotation.TargetApi(18)
    public static long getFromList(android.util.SparseLongArray sparseLongArray, int i) {
        if (sparseLongArray == null || i < 0) {
            return 0L;
        }
        return sparseLongArray.get(i);
    }

    @android.annotation.TargetApi(16)
    public static <T> T getFromList(android.util.LongSparseArray<T> longSparseArray, int i) {
        if (longSparseArray == null || i < 0) {
            return null;
        }
        return longSparseArray.get(i);
    }

    public static <T> T getFromList(android.util.SparseArray<T> sparseArray, int i) {
        if (sparseArray == null || i < 0) {
            return null;
        }
        return sparseArray.get(i);
    }

    public static <T> T getFromList(androidx.collection.LongSparseArray<T> longSparseArray, int i) {
        if (longSparseArray == null || i < 0) {
            return null;
        }
        return longSparseArray.get(i);
    }

    public static <T> T getFromList(java.util.List<T> list, int i) {
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static boolean getFromList(android.util.SparseBooleanArray sparseBooleanArray, int i) {
        if (sparseBooleanArray == null || i < 0) {
            return false;
        }
        return sparseBooleanArray.get(i);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static <T extends androidx.databinding.ViewDataBinding> T inflateInternal(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, int i, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z, @androidx.annotation.Nullable java.lang.Object obj) {
        return (T) androidx.databinding.DataBindingUtil.inflate(layoutInflater, i, viewGroup, z, checkAndCastToBindingComponent(obj));
    }

    private static boolean isNumeric(java.lang.String str, int i) {
        int length = str.length();
        if (length == i) {
            return false;
        }
        while (i < length) {
            if (!java.lang.Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void mapBindings(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr, androidx.databinding.ViewDataBinding.IncludedLayouts includedLayouts, android.util.SparseIntArray sparseIntArray, boolean z) {
        boolean z2;
        int i;
        int i2;
        int i3;
        boolean z3;
        int findIncludeIndex;
        int id;
        int i4;
        int i5;
        if (getBinding(view) != null) {
            return;
        }
        java.lang.Object tag = view.getTag();
        java.lang.String str = tag instanceof java.lang.String ? (java.lang.String) tag : null;
        int i6 = 1;
        if (z && str != null && str.startsWith("layout")) {
            int lastIndexOf = str.lastIndexOf(95);
            if (lastIndexOf > 0) {
                int i7 = lastIndexOf + 1;
                if (isNumeric(str, i7)) {
                    i5 = parseTagInt(str, i7);
                    if (objArr[i5] == null) {
                        objArr[i5] = view;
                    }
                    if (includedLayouts == null) {
                        i5 = -1;
                    }
                    z2 = true;
                    i = i5;
                }
            }
            i5 = -1;
            z2 = false;
            i = i5;
        } else if (str == null || !str.startsWith(BINDING_TAG_PREFIX)) {
            z2 = false;
            i = -1;
        } else {
            int parseTagInt = parseTagInt(str, BINDING_NUMBER_START);
            if (objArr[parseTagInt] == null) {
                objArr[parseTagInt] = view;
            }
            if (includedLayouts == null) {
                parseTagInt = -1;
            }
            i = parseTagInt;
            z2 = true;
        }
        if (!z2 && (id = view.getId()) > 0 && sparseIntArray != null && (i4 = sparseIntArray.get(id, -1)) >= 0 && objArr[i4] == null) {
            objArr[i4] = view;
        }
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            int i8 = 0;
            int i9 = 0;
            while (i8 < childCount) {
                android.view.View childAt = viewGroup.getChildAt(i8);
                if (i >= 0 && (childAt.getTag() instanceof java.lang.String)) {
                    java.lang.String str2 = (java.lang.String) childAt.getTag();
                    if (str2.endsWith("_0") && str2.startsWith("layout") && str2.indexOf(47) > 0 && (findIncludeIndex = findIncludeIndex(str2, i9, includedLayouts, i)) >= 0) {
                        int i10 = findIncludeIndex + 1;
                        int i11 = includedLayouts.indexes[i][findIncludeIndex];
                        int i12 = includedLayouts.layoutIds[i][findIncludeIndex];
                        int findLastMatching = findLastMatching(viewGroup, i8);
                        if (findLastMatching == i8) {
                            objArr[i11] = androidx.databinding.DataBindingUtil.bind(dataBindingComponent, childAt, i12);
                        } else {
                            int i13 = (findLastMatching - i8) + i6;
                            android.view.View[] viewArr = new android.view.View[i13];
                            for (int i14 = 0; i14 < i13; i14++) {
                                viewArr[i14] = viewGroup.getChildAt(i8 + i14);
                            }
                            objArr[i11] = androidx.databinding.DataBindingUtil.bind(dataBindingComponent, viewArr, i12);
                            i8 += i13 - 1;
                        }
                        i2 = i8;
                        i3 = i10;
                        z3 = true;
                        if (z3) {
                            mapBindings(dataBindingComponent, childAt, objArr, includedLayouts, sparseIntArray, false);
                        }
                        i8 = i2 + 1;
                        i9 = i3;
                        i6 = 1;
                    }
                }
                i2 = i8;
                i3 = i9;
                z3 = false;
                if (z3) {
                }
                i8 = i2 + 1;
                i9 = i3;
                i6 = 1;
            }
        }
    }

    public static java.lang.Object[] mapBindings(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, int i, androidx.databinding.ViewDataBinding.IncludedLayouts includedLayouts, android.util.SparseIntArray sparseIntArray) {
        java.lang.Object[] objArr = new java.lang.Object[i];
        mapBindings(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        return objArr;
    }

    public static java.lang.Object[] mapBindings(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View[] viewArr, int i, androidx.databinding.ViewDataBinding.IncludedLayouts includedLayouts, android.util.SparseIntArray sparseIntArray) {
        java.lang.Object[] objArr = new java.lang.Object[i];
        for (android.view.View view : viewArr) {
            mapBindings(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        }
        return objArr;
    }

    public static byte parse(java.lang.String str, byte b) {
        try {
            return java.lang.Byte.parseByte(str);
        } catch (java.lang.NumberFormatException unused) {
            return b;
        }
    }

    public static char parse(java.lang.String str, char c) {
        return (str == null || str.isEmpty()) ? c : str.charAt(0);
    }

    public static double parse(java.lang.String str, double d) {
        try {
            return java.lang.Double.parseDouble(str);
        } catch (java.lang.NumberFormatException unused) {
            return d;
        }
    }

    public static float parse(java.lang.String str, float f) {
        try {
            return java.lang.Float.parseFloat(str);
        } catch (java.lang.NumberFormatException unused) {
            return f;
        }
    }

    public static int parse(java.lang.String str, int i) {
        try {
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.NumberFormatException unused) {
            return i;
        }
    }

    public static long parse(java.lang.String str, long j) {
        try {
            return java.lang.Long.parseLong(str);
        } catch (java.lang.NumberFormatException unused) {
            return j;
        }
    }

    public static short parse(java.lang.String str, short s2) {
        try {
            return java.lang.Short.parseShort(str);
        } catch (java.lang.NumberFormatException unused) {
            return s2;
        }
    }

    public static boolean parse(java.lang.String str, boolean z) {
        return str == null ? z : java.lang.Boolean.parseBoolean(str);
    }

    private static int parseTagInt(java.lang.String str, int i) {
        int i2 = 0;
        while (i < str.length()) {
            i2 = (i2 * 10) + (str.charAt(i) - '0');
            i++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processReferenceQueue() {
        while (true) {
            java.lang.ref.Reference<? extends androidx.databinding.ViewDataBinding> poll = sReferenceQueue.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof androidx.databinding.WeakListener) {
                ((androidx.databinding.WeakListener) poll).unregister();
            }
        }
    }

    public static byte safeUnbox(java.lang.Byte b) {
        if (b == null) {
            return (byte) 0;
        }
        return b.byteValue();
    }

    public static char safeUnbox(java.lang.Character ch) {
        if (ch == null) {
            return (char) 0;
        }
        return ch.charValue();
    }

    public static double safeUnbox(java.lang.Double d) {
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    public static float safeUnbox(java.lang.Float f) {
        if (f == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    public static int safeUnbox(java.lang.Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static long safeUnbox(java.lang.Long l) {
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public static short safeUnbox(java.lang.Short sh) {
        if (sh == null) {
            return (short) 0;
        }
        return sh.shortValue();
    }

    public static boolean safeUnbox(java.lang.Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void setBindingInverseListener(androidx.databinding.ViewDataBinding viewDataBinding, androidx.databinding.InverseBindingListener inverseBindingListener, androidx.databinding.ViewDataBinding.PropertyChangedInverseListener propertyChangedInverseListener) {
        if (inverseBindingListener != propertyChangedInverseListener) {
            if (inverseBindingListener != null) {
                viewDataBinding.removeOnPropertyChangedCallback((androidx.databinding.ViewDataBinding.PropertyChangedInverseListener) inverseBindingListener);
            }
            if (propertyChangedInverseListener != null) {
                viewDataBinding.addOnPropertyChangedCallback(propertyChangedInverseListener);
            }
        }
    }

    @android.annotation.TargetApi(16)
    public static <T> void setTo(android.util.LongSparseArray<T> longSparseArray, int i, T t) {
        if (longSparseArray == null || i < 0 || i >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i, t);
    }

    public static <T> void setTo(android.util.SparseArray<T> sparseArray, int i, T t) {
        if (sparseArray == null || i < 0 || i >= sparseArray.size()) {
            return;
        }
        sparseArray.put(i, t);
    }

    public static void setTo(android.util.SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        if (sparseBooleanArray == null || i < 0 || i >= sparseBooleanArray.size()) {
            return;
        }
        sparseBooleanArray.put(i, z);
    }

    public static void setTo(android.util.SparseIntArray sparseIntArray, int i, int i2) {
        if (sparseIntArray == null || i < 0 || i >= sparseIntArray.size()) {
            return;
        }
        sparseIntArray.put(i, i2);
    }

    @android.annotation.TargetApi(18)
    public static void setTo(android.util.SparseLongArray sparseLongArray, int i, long j) {
        if (sparseLongArray == null || i < 0 || i >= sparseLongArray.size()) {
            return;
        }
        sparseLongArray.put(i, j);
    }

    public static <T> void setTo(androidx.collection.LongSparseArray<T> longSparseArray, int i, T t) {
        if (longSparseArray == null || i < 0 || i >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i, t);
    }

    public static <T> void setTo(java.util.List<T> list, int i, T t) {
        if (list == null || i < 0 || i >= list.size()) {
            return;
        }
        list.set(i, t);
    }

    public static <K, T> void setTo(java.util.Map<K, T> map, K k, T t) {
        if (map == null) {
            return;
        }
        map.put(k, t);
    }

    public static void setTo(byte[] bArr, int i, byte b) {
        if (bArr == null || i < 0 || i >= bArr.length) {
            return;
        }
        bArr[i] = b;
    }

    public static void setTo(char[] cArr, int i, char c) {
        if (cArr == null || i < 0 || i >= cArr.length) {
            return;
        }
        cArr[i] = c;
    }

    public static void setTo(double[] dArr, int i, double d) {
        if (dArr == null || i < 0 || i >= dArr.length) {
            return;
        }
        dArr[i] = d;
    }

    public static void setTo(float[] fArr, int i, float f) {
        if (fArr == null || i < 0 || i >= fArr.length) {
            return;
        }
        fArr[i] = f;
    }

    public static void setTo(int[] iArr, int i, int i2) {
        if (iArr == null || i < 0 || i >= iArr.length) {
            return;
        }
        iArr[i] = i2;
    }

    public static void setTo(long[] jArr, int i, long j) {
        if (jArr == null || i < 0 || i >= jArr.length) {
            return;
        }
        jArr[i] = j;
    }

    public static <T> void setTo(T[] tArr, int i, T t) {
        if (tArr == null || i < 0 || i >= tArr.length) {
            return;
        }
        tArr[i] = t;
    }

    public static void setTo(short[] sArr, int i, short s2) {
        if (sArr == null || i < 0 || i >= sArr.length) {
            return;
        }
        sArr[i] = s2;
    }

    public static void setTo(boolean[] zArr, int i, boolean z) {
        if (zArr == null || i < 0 || i >= zArr.length) {
            return;
        }
        zArr[i] = z;
    }

    public void addOnRebindCallback(@androidx.annotation.NonNull androidx.databinding.OnRebindCallback onRebindCallback) {
        if (this.mRebindCallbacks == null) {
            this.mRebindCallbacks = new androidx.databinding.CallbackRegistry<>(REBIND_NOTIFIER);
        }
        this.mRebindCallbacks.add(onRebindCallback);
    }

    public void ensureBindingComponentIsNotNull(java.lang.Class<?> cls) {
        if (this.mBindingComponent != null) {
            return;
        }
        throw new java.lang.IllegalStateException("Required DataBindingComponent is null in class " + getClass().getSimpleName() + ". A BindingAdapter in " + cls.getCanonicalName() + " is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
    }

    public abstract void executeBindings();

    public void executePendingBindings() {
        androidx.databinding.ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding == null) {
            executeBindingsInternal();
        } else {
            viewDataBinding.executePendingBindings();
        }
    }

    public void forceExecuteBindings() {
        executeBindings();
    }

    @androidx.annotation.Nullable
    public androidx.lifecycle.LifecycleOwner getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    public java.lang.Object getObservedField(int i) {
        androidx.databinding.WeakListener weakListener = this.mLocalFieldObservers[i];
        if (weakListener == null) {
            return null;
        }
        return weakListener.getTarget();
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.mRoot;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void handleFieldChange(int i, java.lang.Object obj, int i2) {
        if (this.mInLiveDataRegisterObserver || this.mInStateFlowRegisterObserver || !onFieldChange(i, obj, i2)) {
            return;
        }
        requestRebind();
    }

    public abstract boolean hasPendingBindings();

    public abstract void invalidateAll();

    public abstract boolean onFieldChange(int i, java.lang.Object obj, int i2);

    public void registerTo(int i, java.lang.Object obj, androidx.databinding.CreateWeakListener createWeakListener) {
        if (obj == null) {
            return;
        }
        androidx.databinding.WeakListener weakListener = this.mLocalFieldObservers[i];
        if (weakListener == null) {
            weakListener = createWeakListener.create(this, i, sReferenceQueue);
            this.mLocalFieldObservers[i] = weakListener;
            androidx.lifecycle.LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            if (lifecycleOwner != null) {
                weakListener.setLifecycleOwner(lifecycleOwner);
            }
        }
        weakListener.setTarget(obj);
    }

    public void removeOnRebindCallback(@androidx.annotation.NonNull androidx.databinding.OnRebindCallback onRebindCallback) {
        androidx.databinding.CallbackRegistry<androidx.databinding.OnRebindCallback, androidx.databinding.ViewDataBinding, java.lang.Void> callbackRegistry = this.mRebindCallbacks;
        if (callbackRegistry != null) {
            callbackRegistry.remove(onRebindCallback);
        }
    }

    public void requestRebind() {
        androidx.databinding.ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding != null) {
            viewDataBinding.requestRebind();
            return;
        }
        androidx.lifecycle.LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        if (lifecycleOwner == null || lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)) {
            synchronized (this) {
                if (this.mPendingRebind) {
                    return;
                }
                this.mPendingRebind = true;
                if (USE_CHOREOGRAPHER) {
                    this.mChoreographer.postFrameCallback(this.mFrameCallback);
                } else {
                    this.mUIThreadHandler.post(this.mRebindRunnable);
                }
            }
        }
    }

    public void setContainedBinding(androidx.databinding.ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.mContainingBinding = this;
        }
    }

    @androidx.annotation.MainThread
    public void setLifecycleOwner(@androidx.annotation.Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        boolean z = lifecycleOwner instanceof androidx.fragment.app.Fragment;
        androidx.lifecycle.LifecycleOwner lifecycleOwner2 = this.mLifecycleOwner;
        if (lifecycleOwner2 == lifecycleOwner) {
            return;
        }
        if (lifecycleOwner2 != null) {
            lifecycleOwner2.getLifecycle().removeObserver(this.mOnStartListener);
        }
        this.mLifecycleOwner = lifecycleOwner;
        if (lifecycleOwner != null) {
            if (this.mOnStartListener == null) {
                this.mOnStartListener = new androidx.databinding.ViewDataBinding.OnStartListener(this, null);
            }
            lifecycleOwner.getLifecycle().addObserver(this.mOnStartListener);
        }
        for (androidx.databinding.WeakListener weakListener : this.mLocalFieldObservers) {
            if (weakListener != null) {
                weakListener.setLifecycleOwner(lifecycleOwner);
            }
        }
    }

    public void setRootTag(android.view.View view) {
        view.setTag(androidx.databinding.library.R.id.dataBinding, this);
    }

    public void setRootTag(android.view.View[] viewArr) {
        for (android.view.View view : viewArr) {
            view.setTag(androidx.databinding.library.R.id.dataBinding, this);
        }
    }

    public abstract boolean setVariable(int i, @androidx.annotation.Nullable java.lang.Object obj);

    public void unbind() {
        for (androidx.databinding.WeakListener weakListener : this.mLocalFieldObservers) {
            if (weakListener != null) {
                weakListener.unregister();
            }
        }
    }

    public boolean unregisterFrom(int i) {
        androidx.databinding.WeakListener weakListener = this.mLocalFieldObservers[i];
        if (weakListener != null) {
            return weakListener.unregister();
        }
        return false;
    }

    public boolean updateLiveDataRegistration(int i, androidx.lifecycle.LiveData<?> liveData) {
        this.mInLiveDataRegisterObserver = true;
        try {
            return updateRegistration(i, liveData, CREATE_LIVE_DATA_LISTENER);
        } finally {
            this.mInLiveDataRegisterObserver = false;
        }
    }

    public boolean updateRegistration(int i, androidx.databinding.Observable observable) {
        return updateRegistration(i, observable, CREATE_PROPERTY_LISTENER);
    }

    public boolean updateRegistration(int i, androidx.databinding.ObservableList observableList) {
        return updateRegistration(i, observableList, CREATE_LIST_LISTENER);
    }

    public boolean updateRegistration(int i, androidx.databinding.ObservableMap observableMap) {
        return updateRegistration(i, observableMap, CREATE_MAP_LISTENER);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean updateRegistration(int i, java.lang.Object obj, androidx.databinding.CreateWeakListener createWeakListener) {
        if (obj == null) {
            return unregisterFrom(i);
        }
        androidx.databinding.WeakListener weakListener = this.mLocalFieldObservers[i];
        if (weakListener == null) {
            registerTo(i, obj, createWeakListener);
            return true;
        }
        if (weakListener.getTarget() == obj) {
            return false;
        }
        unregisterFrom(i);
        registerTo(i, obj, createWeakListener);
        return true;
    }
}
