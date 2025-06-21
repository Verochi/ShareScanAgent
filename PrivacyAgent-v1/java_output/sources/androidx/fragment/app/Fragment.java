package androidx.fragment.app;

/* loaded from: classes.dex */
public class Fragment implements android.content.ComponentCallbacks, android.view.View.OnCreateContextMenuListener, androidx.lifecycle.LifecycleOwner, androidx.lifecycle.ViewModelStoreOwner, androidx.lifecycle.HasDefaultViewModelProviderFactory, androidx.savedstate.SavedStateRegistryOwner, androidx.activity.result.ActivityResultCaller {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final java.lang.Object USE_DEFAULT_TRANSITION = new java.lang.Object();
    static final int VIEW_CREATED = 2;
    public static final /* synthetic */ int n = 0;
    boolean mAdded;
    androidx.fragment.app.Fragment.AnimationInfo mAnimationInfo;
    android.os.Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;

    @androidx.annotation.NonNull
    androidx.fragment.app.FragmentManager mChildFragmentManager;
    android.view.ViewGroup mContainer;
    int mContainerId;

    @androidx.annotation.LayoutRes
    private int mContentLayoutId;
    androidx.lifecycle.ViewModelProvider.Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    androidx.fragment.app.FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    androidx.fragment.app.FragmentHostCallback<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private java.lang.Boolean mIsPrimaryNavigationFragment;
    android.view.LayoutInflater mLayoutInflater;
    androidx.lifecycle.LifecycleRegistry mLifecycleRegistry;
    androidx.lifecycle.Lifecycle.State mMaxState;
    boolean mMenuVisible;
    private final java.util.concurrent.atomic.AtomicInteger mNextLocalRequestCode;
    private final java.util.ArrayList<androidx.fragment.app.Fragment.OnPreAttachedListener> mOnPreAttachedListeners;
    androidx.fragment.app.Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    java.lang.Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    android.os.Bundle mSavedFragmentState;
    androidx.savedstate.SavedStateRegistryController mSavedStateRegistryController;

    @androidx.annotation.Nullable
    java.lang.Boolean mSavedUserVisibleHint;
    android.os.Bundle mSavedViewRegistryState;
    android.util.SparseArray<android.os.Parcelable> mSavedViewState;
    int mState;
    java.lang.String mTag;
    androidx.fragment.app.Fragment mTarget;
    int mTargetRequestCode;
    java.lang.String mTargetWho;
    boolean mUserVisibleHint;
    android.view.View mView;

    @androidx.annotation.Nullable
    androidx.fragment.app.FragmentViewLifecycleOwner mViewLifecycleOwner;
    androidx.lifecycle.MutableLiveData<androidx.lifecycle.LifecycleOwner> mViewLifecycleOwnerLiveData;

    @androidx.annotation.NonNull
    java.lang.String mWho;

    /* renamed from: androidx.fragment.app.Fragment$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.fragment.app.Fragment.this.startPostponedEnterTransition();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.fragment.app.Fragment.this.callStartTransitionListener(false);
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ androidx.fragment.app.SpecialEffectsController val$controller;

        public AnonymousClass3(androidx.fragment.app.SpecialEffectsController specialEffectsController) {
            this.val$controller = specialEffectsController;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$controller.executePendingOperations();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$4, reason: invalid class name */
    public class AnonymousClass4 extends androidx.fragment.app.FragmentContainer {
        public AnonymousClass4() {
        }

        @Override // androidx.fragment.app.FragmentContainer
        @androidx.annotation.Nullable
        public android.view.View onFindViewById(int i) {
            android.view.View view = androidx.fragment.app.Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new java.lang.IllegalStateException("Fragment " + androidx.fragment.app.Fragment.this + " does not have a view");
        }

        @Override // androidx.fragment.app.FragmentContainer
        public boolean onHasView() {
            return androidx.fragment.app.Fragment.this.mView != null;
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$5, reason: invalid class name */
    public class AnonymousClass5 implements androidx.lifecycle.LifecycleEventObserver {
        public AnonymousClass5() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
            android.view.View view;
            if (event != androidx.lifecycle.Lifecycle.Event.ON_STOP || (view = androidx.fragment.app.Fragment.this.mView) == null) {
                return;
            }
            view.cancelPendingInputEvents();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$6, reason: invalid class name */
    public class AnonymousClass6 implements androidx.arch.core.util.Function<java.lang.Void, androidx.activity.result.ActivityResultRegistry> {
        public AnonymousClass6() {
        }

        @Override // androidx.arch.core.util.Function
        public androidx.activity.result.ActivityResultRegistry apply(java.lang.Void r3) {
            androidx.fragment.app.Fragment fragment = androidx.fragment.app.Fragment.this;
            java.lang.Object obj = fragment.mHost;
            return obj instanceof androidx.activity.result.ActivityResultRegistryOwner ? ((androidx.activity.result.ActivityResultRegistryOwner) obj).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$7, reason: invalid class name */
    public class AnonymousClass7 implements androidx.arch.core.util.Function<java.lang.Void, androidx.activity.result.ActivityResultRegistry> {
        final /* synthetic */ androidx.activity.result.ActivityResultRegistry val$registry;

        public AnonymousClass7(androidx.activity.result.ActivityResultRegistry activityResultRegistry) {
            this.val$registry = activityResultRegistry;
        }

        @Override // androidx.arch.core.util.Function
        public androidx.activity.result.ActivityResultRegistry apply(java.lang.Void r1) {
            return this.val$registry;
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$8, reason: invalid class name */
    public class AnonymousClass8 extends androidx.fragment.app.Fragment.OnPreAttachedListener {
        final /* synthetic */ androidx.activity.result.ActivityResultCallback val$callback;
        final /* synthetic */ androidx.activity.result.contract.ActivityResultContract val$contract;
        final /* synthetic */ java.util.concurrent.atomic.AtomicReference val$ref;
        final /* synthetic */ androidx.arch.core.util.Function val$registryProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(androidx.arch.core.util.Function function, java.util.concurrent.atomic.AtomicReference atomicReference, androidx.activity.result.contract.ActivityResultContract activityResultContract, androidx.activity.result.ActivityResultCallback activityResultCallback) {
            super(null);
            this.val$registryProvider = function;
            this.val$ref = atomicReference;
            this.val$contract = activityResultContract;
            this.val$callback = activityResultCallback;
        }

        @Override // androidx.fragment.app.Fragment.OnPreAttachedListener
        public void onPreAttached() {
            java.lang.String generateActivityResultKey = androidx.fragment.app.Fragment.this.generateActivityResultKey();
            this.val$ref.set(((androidx.activity.result.ActivityResultRegistry) this.val$registryProvider.apply(null)).register(generateActivityResultKey, androidx.fragment.app.Fragment.this, this.val$contract, this.val$callback));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* renamed from: androidx.fragment.app.Fragment$9, reason: invalid class name */
    public class AnonymousClass9<I> extends androidx.activity.result.ActivityResultLauncher<I> {
        final /* synthetic */ androidx.activity.result.contract.ActivityResultContract val$contract;
        final /* synthetic */ java.util.concurrent.atomic.AtomicReference val$ref;

        public AnonymousClass9(java.util.concurrent.atomic.AtomicReference atomicReference, androidx.activity.result.contract.ActivityResultContract activityResultContract) {
            this.val$ref = atomicReference;
            this.val$contract = activityResultContract;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        @androidx.annotation.NonNull
        public androidx.activity.result.contract.ActivityResultContract<I, ?> getContract() {
            return this.val$contract;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public void launch(I i, @androidx.annotation.Nullable androidx.core.app.ActivityOptionsCompat activityOptionsCompat) {
            androidx.activity.result.ActivityResultLauncher activityResultLauncher = (androidx.activity.result.ActivityResultLauncher) this.val$ref.get();
            if (activityResultLauncher == null) {
                throw new java.lang.IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            activityResultLauncher.launch(i, activityOptionsCompat);
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public void unregister() {
            androidx.activity.result.ActivityResultLauncher activityResultLauncher = (androidx.activity.result.ActivityResultLauncher) this.val$ref.getAndSet(null);
            if (activityResultLauncher != null) {
                activityResultLauncher.unregister();
            }
        }
    }

    public static class AnimationInfo {
        java.lang.Boolean mAllowEnterTransitionOverlap;
        java.lang.Boolean mAllowReturnTransitionOverlap;
        android.view.View mAnimatingAway;
        android.animation.Animator mAnimator;
        int mEnterAnim;
        java.lang.Object mEnterTransition = null;
        androidx.core.app.SharedElementCallback mEnterTransitionCallback;
        boolean mEnterTransitionPostponed;
        int mExitAnim;
        java.lang.Object mExitTransition;
        androidx.core.app.SharedElementCallback mExitTransitionCallback;
        android.view.View mFocusedView;
        boolean mIsHideReplaced;
        boolean mIsPop;
        int mNextTransition;
        int mPopEnterAnim;
        int mPopExitAnim;
        float mPostOnViewCreatedAlpha;
        java.lang.Object mReenterTransition;
        java.lang.Object mReturnTransition;
        java.lang.Object mSharedElementEnterTransition;
        java.lang.Object mSharedElementReturnTransition;
        java.util.ArrayList<java.lang.String> mSharedElementSourceNames;
        java.util.ArrayList<java.lang.String> mSharedElementTargetNames;
        androidx.fragment.app.Fragment.OnStartEnterTransitionListener mStartEnterTransitionListener;

        public AnimationInfo() {
            java.lang.Object obj = androidx.fragment.app.Fragment.USE_DEFAULT_TRANSITION;
            this.mReturnTransition = obj;
            this.mExitTransition = null;
            this.mReenterTransition = obj;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = obj;
            this.mEnterTransitionCallback = null;
            this.mExitTransitionCallback = null;
            this.mPostOnViewCreatedAlpha = 1.0f;
            this.mFocusedView = null;
        }
    }

    public static class InstantiationException extends java.lang.RuntimeException {
        public InstantiationException(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Exception exc) {
            super(str, exc);
        }
    }

    public static abstract class OnPreAttachedListener {
        private OnPreAttachedListener() {
        }

        public /* synthetic */ OnPreAttachedListener(androidx.fragment.app.Fragment.AnonymousClass1 anonymousClass1) {
            this();
        }

        public abstract void onPreAttached();
    }

    public interface OnStartEnterTransitionListener {
        void onStartEnterTransition();

        void startListening();
    }

    @android.annotation.SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements android.os.Parcelable {

        @androidx.annotation.NonNull
        public static final android.os.Parcelable.Creator<androidx.fragment.app.Fragment.SavedState> CREATOR = new androidx.fragment.app.Fragment.SavedState.AnonymousClass1();
        final android.os.Bundle mState;

        /* renamed from: androidx.fragment.app.Fragment$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<androidx.fragment.app.Fragment.SavedState> {
            @Override // android.os.Parcelable.Creator
            public androidx.fragment.app.Fragment.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.fragment.app.Fragment.SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public androidx.fragment.app.Fragment.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new androidx.fragment.app.Fragment.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public androidx.fragment.app.Fragment.SavedState[] newArray(int i) {
                return new androidx.fragment.app.Fragment.SavedState[i];
            }
        }

        public SavedState(android.os.Bundle bundle) {
            this.mState = bundle;
        }

        public SavedState(@androidx.annotation.NonNull android.os.Parcel parcel, @androidx.annotation.Nullable java.lang.ClassLoader classLoader) {
            android.os.Bundle readBundle = parcel.readBundle();
            this.mState = readBundle;
            if (classLoader == null || readBundle == null) {
                return;
            }
            readBundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
            parcel.writeBundle(this.mState);
        }
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = java.util.UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new androidx.fragment.app.FragmentManagerImpl();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new androidx.fragment.app.Fragment.AnonymousClass1();
        this.mMaxState = androidx.lifecycle.Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new androidx.lifecycle.MutableLiveData<>();
        this.mNextLocalRequestCode = new java.util.concurrent.atomic.AtomicInteger();
        this.mOnPreAttachedListeners = new java.util.ArrayList<>();
        initLifecycle();
    }

    @androidx.annotation.ContentView
    public Fragment(@androidx.annotation.LayoutRes int i) {
        this();
        this.mContentLayoutId = i;
    }

    private androidx.fragment.app.Fragment.AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new androidx.fragment.app.Fragment.AnimationInfo();
        }
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        androidx.lifecycle.Lifecycle.State state = this.mMaxState;
        return (state == androidx.lifecycle.Lifecycle.State.INITIALIZED || this.mParentFragment == null) ? state.ordinal() : java.lang.Math.min(state.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new androidx.lifecycle.LifecycleRegistry(this);
        this.mSavedStateRegistryController = androidx.savedstate.SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public static androidx.fragment.app.Fragment instantiate(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
        return instantiate(context, str, null);
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public static androidx.fragment.app.Fragment instantiate(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.os.Bundle bundle) {
        try {
            androidx.fragment.app.Fragment newInstance = androidx.fragment.app.FragmentFactory.loadFragmentClass(context.getClassLoader(), str).getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.setArguments(bundle);
            }
            return newInstance;
        } catch (java.lang.IllegalAccessException e) {
            throw new androidx.fragment.app.Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (java.lang.InstantiationException e2) {
            throw new androidx.fragment.app.Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (java.lang.NoSuchMethodException e3) {
            throw new androidx.fragment.app.Fragment.InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (java.lang.reflect.InvocationTargetException e4) {
            throw new androidx.fragment.app.Fragment.InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    @androidx.annotation.NonNull
    private <I, O> androidx.activity.result.ActivityResultLauncher<I> prepareCallInternal(@androidx.annotation.NonNull androidx.activity.result.contract.ActivityResultContract<I, O> activityResultContract, @androidx.annotation.NonNull androidx.arch.core.util.Function<java.lang.Void, androidx.activity.result.ActivityResultRegistry> function, @androidx.annotation.NonNull androidx.activity.result.ActivityResultCallback<O> activityResultCallback) {
        if (this.mState <= 1) {
            java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
            registerOnPreAttachListener(new androidx.fragment.app.Fragment.AnonymousClass8(function, atomicReference, activityResultContract, activityResultCallback));
            return new androidx.fragment.app.Fragment.AnonymousClass9(atomicReference, activityResultContract);
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void registerOnPreAttachListener(@androidx.annotation.NonNull androidx.fragment.app.Fragment.OnPreAttachedListener onPreAttachedListener) {
        if (this.mState >= 0) {
            onPreAttachedListener.onPreAttached();
        } else {
            this.mOnPreAttachedListeners.add(onPreAttachedListener);
        }
    }

    private void restoreViewState() {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("moveto RESTORE_VIEW_STATE: ");
            sb.append(this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    public void callStartTransitionListener(boolean z) {
        android.view.ViewGroup viewGroup;
        androidx.fragment.app.FragmentManager fragmentManager;
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        androidx.fragment.app.Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener = null;
        if (animationInfo != null) {
            animationInfo.mEnterTransitionPostponed = false;
            androidx.fragment.app.Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener2 = animationInfo.mStartEnterTransitionListener;
            animationInfo.mStartEnterTransitionListener = null;
            onStartEnterTransitionListener = onStartEnterTransitionListener2;
        }
        if (onStartEnterTransitionListener != null) {
            onStartEnterTransitionListener.onStartEnterTransition();
            return;
        }
        if (!androidx.fragment.app.FragmentManager.USE_STATE_MANAGER || this.mView == null || (viewGroup = this.mContainer) == null || (fragmentManager = this.mFragmentManager) == null) {
            return;
        }
        androidx.fragment.app.SpecialEffectsController orCreateController = androidx.fragment.app.SpecialEffectsController.getOrCreateController(viewGroup, fragmentManager);
        orCreateController.markPostponedState();
        if (z) {
            this.mHost.getHandler().post(new androidx.fragment.app.Fragment.AnonymousClass3(orCreateController));
        } else {
            orCreateController.executePendingOperations();
        }
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentContainer createFragmentContainer() {
        return new androidx.fragment.app.Fragment.AnonymousClass4();
    }

    public void dump(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor, @androidx.annotation.NonNull java.io.PrintWriter printWriter, @androidx.annotation.Nullable java.lang.String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(java.lang.Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(java.lang.Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        androidx.fragment.app.Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            androidx.loader.app.LoaderManager.getInstance(this).dump(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        this.mChildFragmentManager.dump(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        return super.equals(obj);
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment findFragmentByWho(@androidx.annotation.NonNull java.lang.String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.findFragmentByWho(str);
    }

    @androidx.annotation.NonNull
    public java.lang.String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    @androidx.annotation.Nullable
    public final androidx.fragment.app.FragmentActivity getActivity() {
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return (androidx.fragment.app.FragmentActivity) fragmentHostCallback.getActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        java.lang.Boolean bool;
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null || (bool = animationInfo.mAllowEnterTransitionOverlap) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        java.lang.Boolean bool;
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null || (bool = animationInfo.mAllowReturnTransitionOverlap) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public android.view.View getAnimatingAway() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mAnimatingAway;
    }

    public android.animation.Animator getAnimator() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mAnimator;
    }

    @androidx.annotation.Nullable
    public final android.os.Bundle getArguments() {
        return this.mArguments;
    }

    @androidx.annotation.NonNull
    public final androidx.fragment.app.FragmentManager getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @androidx.annotation.Nullable
    public android.content.Context getContext() {
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.getContext();
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @androidx.annotation.NonNull
    public androidx.lifecycle.ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        android.app.Application application;
        if (this.mFragmentManager == null) {
            throw new java.lang.IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            android.content.Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof android.content.ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof android.app.Application) {
                    application = (android.app.Application) applicationContext;
                    break;
                }
                applicationContext = ((android.content.ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Could not find Application instance from Context ");
                sb.append(requireContext().getApplicationContext());
                sb.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new androidx.lifecycle.SavedStateViewModelFactory(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public int getEnterAnim() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mEnterAnim;
    }

    @androidx.annotation.Nullable
    public java.lang.Object getEnterTransition() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mEnterTransition;
    }

    public androidx.core.app.SharedElementCallback getEnterTransitionCallback() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mEnterTransitionCallback;
    }

    public int getExitAnim() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mExitAnim;
    }

    @androidx.annotation.Nullable
    public java.lang.Object getExitTransition() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mExitTransition;
    }

    public androidx.core.app.SharedElementCallback getExitTransitionCallback() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mExitTransitionCallback;
    }

    public android.view.View getFocusedView() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mFocusedView;
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public final androidx.fragment.app.FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    @androidx.annotation.Nullable
    public final java.lang.Object getHost() {
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.onGetHost();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @androidx.annotation.NonNull
    public final android.view.LayoutInflater getLayoutInflater() {
        android.view.LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public android.view.LayoutInflater getLayoutInflater(@androidx.annotation.Nullable android.os.Bundle bundle) {
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            throw new java.lang.IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        android.view.LayoutInflater onGetLayoutInflater = fragmentHostCallback.onGetLayoutInflater();
        androidx.core.view.LayoutInflaterCompat.setFactory2(onGetLayoutInflater, this.mChildFragmentManager.getLayoutInflaterFactory());
        return onGetLayoutInflater;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @androidx.annotation.NonNull
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.loader.app.LoaderManager getLoaderManager() {
        return androidx.loader.app.LoaderManager.getInstance(this);
    }

    public int getNextTransition() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mNextTransition;
    }

    @androidx.annotation.Nullable
    public final androidx.fragment.app.Fragment getParentFragment() {
        return this.mParentFragment;
    }

    @androidx.annotation.NonNull
    public final androidx.fragment.app.FragmentManager getParentFragmentManager() {
        androidx.fragment.app.FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public boolean getPopDirection() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.mIsPop;
    }

    public int getPopEnterAnim() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mPopEnterAnim;
    }

    public int getPopExitAnim() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mPopExitAnim;
    }

    public float getPostOnViewCreatedAlpha() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 1.0f;
        }
        return animationInfo.mPostOnViewCreatedAlpha;
    }

    @androidx.annotation.Nullable
    public java.lang.Object getReenterTransition() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        java.lang.Object obj = animationInfo.mReenterTransition;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    @androidx.annotation.NonNull
    public final android.content.res.Resources getResources() {
        return requireContext().getResources();
    }

    @java.lang.Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    @androidx.annotation.Nullable
    public java.lang.Object getReturnTransition() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        java.lang.Object obj = animationInfo.mReturnTransition;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @androidx.annotation.NonNull
    public final androidx.savedstate.SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @androidx.annotation.Nullable
    public java.lang.Object getSharedElementEnterTransition() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mSharedElementEnterTransition;
    }

    @androidx.annotation.Nullable
    public java.lang.Object getSharedElementReturnTransition() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        java.lang.Object obj = animationInfo.mSharedElementReturnTransition;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    @androidx.annotation.NonNull
    public java.util.ArrayList<java.lang.String> getSharedElementSourceNames() {
        java.util.ArrayList<java.lang.String> arrayList;
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        return (animationInfo == null || (arrayList = animationInfo.mSharedElementSourceNames) == null) ? new java.util.ArrayList<>() : arrayList;
    }

    @androidx.annotation.NonNull
    public java.util.ArrayList<java.lang.String> getSharedElementTargetNames() {
        java.util.ArrayList<java.lang.String> arrayList;
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        return (animationInfo == null || (arrayList = animationInfo.mSharedElementTargetNames) == null) ? new java.util.ArrayList<>() : arrayList;
    }

    @androidx.annotation.NonNull
    public final java.lang.String getString(@androidx.annotation.StringRes int i) {
        return getResources().getString(i);
    }

    @androidx.annotation.NonNull
    public final java.lang.String getString(@androidx.annotation.StringRes int i, @androidx.annotation.Nullable java.lang.Object... objArr) {
        return getResources().getString(i, objArr);
    }

    @androidx.annotation.Nullable
    public final java.lang.String getTag() {
        return this.mTag;
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public final androidx.fragment.app.Fragment getTargetFragment() {
        java.lang.String str;
        androidx.fragment.app.Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        androidx.fragment.app.FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return fragmentManager.findActiveFragment(str);
    }

    @java.lang.Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    @androidx.annotation.NonNull
    public final java.lang.CharSequence getText(@androidx.annotation.StringRes int i) {
        return getResources().getText(i);
    }

    @java.lang.Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @androidx.annotation.Nullable
    public android.view.View getView() {
        return this.mView;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public androidx.lifecycle.LifecycleOwner getViewLifecycleOwner() {
        androidx.fragment.app.FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.mViewLifecycleOwner;
        if (fragmentViewLifecycleOwner != null) {
            return fragmentViewLifecycleOwner;
        }
        throw new java.lang.IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @androidx.annotation.NonNull
    public androidx.lifecycle.LiveData<androidx.lifecycle.LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @androidx.annotation.NonNull
    public androidx.lifecycle.ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new java.lang.IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (getMinimumMaxLifecycleState() != androidx.lifecycle.Lifecycle.State.INITIALIZED.ordinal()) {
            return this.mFragmentManager.getViewModelStore(this);
        }
        throw new java.lang.IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    @android.annotation.SuppressLint({"KotlinPropertyAccess"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        initLifecycle();
        this.mWho = java.util.UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new androidx.fragment.app.FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public boolean isHideReplaced() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.mIsHideReplaced;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean isMenuVisible() {
        androidx.fragment.app.FragmentManager fragmentManager;
        return this.mMenuVisible && ((fragmentManager = this.mFragmentManager) == null || fragmentManager.isParentMenuVisible(this.mParentFragment));
    }

    public boolean isPostponed() {
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.mEnterTransitionPostponed;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isRemovingParent() {
        androidx.fragment.app.Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        androidx.fragment.app.FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.isStateSaved();
    }

    public final boolean isVisible() {
        android.view.View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    @java.lang.Deprecated
    public void onActivityCreated(@androidx.annotation.Nullable android.os.Bundle bundle) {
        this.mCalled = true;
    }

    @java.lang.Deprecated
    public void onActivityResult(int i, int i2, @androidx.annotation.Nullable android.content.Intent intent) {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" received the following in onActivityResult(): requestCode: ");
            sb.append(i);
            sb.append(" resultCode: ");
            sb.append(i2);
            sb.append(" data: ");
            sb.append(intent);
        }
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    @java.lang.Deprecated
    public void onAttach(@androidx.annotation.NonNull android.app.Activity activity) {
        this.mCalled = true;
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    public void onAttach(@androidx.annotation.NonNull android.content.Context context) {
        this.mCalled = true;
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        android.app.Activity activity = fragmentHostCallback == null ? null : fragmentHostCallback.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    @androidx.annotation.MainThread
    @java.lang.Deprecated
    public void onAttachFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    @androidx.annotation.CallSuper
    public void onConfigurationChanged(@androidx.annotation.NonNull android.content.res.Configuration configuration) {
        this.mCalled = true;
    }

    @androidx.annotation.MainThread
    public boolean onContextItemSelected(@androidx.annotation.NonNull android.view.MenuItem menuItem) {
        return false;
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.isStateAtLeast(1)) {
            return;
        }
        this.mChildFragmentManager.dispatchCreate();
    }

    @androidx.annotation.Nullable
    @androidx.annotation.MainThread
    public android.view.animation.Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.MainThread
    public android.animation.Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    @androidx.annotation.MainThread
    public void onCreateContextMenu(@androidx.annotation.NonNull android.view.ContextMenu contextMenu, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.view.ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @androidx.annotation.MainThread
    public void onCreateOptionsMenu(@androidx.annotation.NonNull android.view.Menu menu, @androidx.annotation.NonNull android.view.MenuInflater menuInflater) {
    }

    @androidx.annotation.Nullable
    @androidx.annotation.MainThread
    public android.view.View onCreateView(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    public void onDestroy() {
        this.mCalled = true;
    }

    @androidx.annotation.MainThread
    public void onDestroyOptionsMenu() {
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    public void onDestroyView() {
        this.mCalled = true;
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    public void onDetach() {
        this.mCalled = true;
    }

    @androidx.annotation.NonNull
    public android.view.LayoutInflater onGetLayoutInflater(@androidx.annotation.Nullable android.os.Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    @androidx.annotation.MainThread
    public void onHiddenChanged(boolean z) {
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.UiThread
    @java.lang.Deprecated
    public void onInflate(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.os.Bundle bundle) {
        this.mCalled = true;
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.UiThread
    public void onInflate(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.os.Bundle bundle) {
        this.mCalled = true;
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        android.app.Activity activity = fragmentHostCallback == null ? null : fragmentHostCallback.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    @androidx.annotation.MainThread
    public boolean onOptionsItemSelected(@androidx.annotation.NonNull android.view.MenuItem menuItem) {
        return false;
    }

    @androidx.annotation.MainThread
    public void onOptionsMenuClosed(@androidx.annotation.NonNull android.view.Menu menu) {
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    @androidx.annotation.MainThread
    public void onPrepareOptionsMenu(@androidx.annotation.NonNull android.view.Menu menu) {
    }

    @androidx.annotation.MainThread
    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @java.lang.Deprecated
    public void onRequestPermissionsResult(int i, @androidx.annotation.NonNull java.lang.String[] strArr, @androidx.annotation.NonNull int[] iArr) {
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    public void onResume() {
        this.mCalled = true;
    }

    @androidx.annotation.MainThread
    public void onSaveInstanceState(@androidx.annotation.NonNull android.os.Bundle bundle) {
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    public void onStart() {
        this.mCalled = true;
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    public void onStop() {
        this.mCalled = true;
    }

    @androidx.annotation.MainThread
    public void onViewCreated(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.os.Bundle bundle) {
    }

    @androidx.annotation.CallSuper
    @androidx.annotation.MainThread
    public void onViewStateRestored(@androidx.annotation.Nullable android.os.Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(android.os.Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            restoreViewState();
            this.mChildFragmentManager.dispatchActivityCreated();
        } else {
            throw new androidx.fragment.app.SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public void performAttach() {
        java.util.Iterator<androidx.fragment.app.Fragment.OnPreAttachedListener> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().onPreAttached();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.getContext());
        if (this.mCalled) {
            this.mFragmentManager.dispatchOnAttachFragment(this);
            this.mChildFragmentManager.dispatchAttach();
        } else {
            throw new androidx.fragment.app.SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public void performConfigurationChanged(@androidx.annotation.NonNull android.content.res.Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.dispatchConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(@androidx.annotation.NonNull android.view.MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.dispatchContextItemSelected(menuItem);
    }

    public void performCreate(android.os.Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.addObserver(new androidx.fragment.app.Fragment.AnonymousClass5());
        this.mSavedStateRegistryController.performRestore(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
            return;
        }
        throw new androidx.fragment.app.SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    public boolean performCreateOptionsMenu(@androidx.annotation.NonNull android.view.Menu menu, @androidx.annotation.NonNull android.view.MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z = true;
        }
        return z | this.mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public void performCreateView(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new androidx.fragment.app.FragmentViewLifecycleOwner(this, getViewModelStore());
        android.view.View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView == null) {
            if (this.mViewLifecycleOwner.isInitialized()) {
                throw new java.lang.IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
        } else {
            this.mViewLifecycleOwner.initialize();
            androidx.lifecycle.ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
            androidx.lifecycle.ViewTreeViewModelStoreOwner.set(this.mView, this.mViewLifecycleOwner);
            androidx.savedstate.ViewTreeSavedStateRegistryOwner.set(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        }
    }

    public void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new androidx.fragment.app.SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void performDestroyView() {
        this.mChildFragmentManager.dispatchDestroyView();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.CREATED)) {
            this.mViewLifecycleOwner.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            androidx.loader.app.LoaderManager.getInstance(this).markForRedelivery();
            this.mPerformedCreateView = false;
        } else {
            throw new androidx.fragment.app.SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            if (this.mChildFragmentManager.isDestroyed()) {
                return;
            }
            this.mChildFragmentManager.dispatchDestroy();
            this.mChildFragmentManager = new androidx.fragment.app.FragmentManagerImpl();
            return;
        }
        throw new androidx.fragment.app.SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    @androidx.annotation.NonNull
    public android.view.LayoutInflater performGetLayoutInflater(@androidx.annotation.Nullable android.os.Bundle bundle) {
        android.view.LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.dispatchMultiWindowModeChanged(z);
    }

    public boolean performOptionsItemSelected(@androidx.annotation.NonNull android.view.MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem);
    }

    public void performOptionsMenuClosed(@androidx.annotation.NonNull android.view.Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.dispatchOptionsMenuClosed(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.dispatchPause();
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new androidx.fragment.app.SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.dispatchPictureInPictureModeChanged(z);
    }

    public boolean performPrepareOptionsMenu(@androidx.annotation.NonNull android.view.Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z = true;
        }
        return z | this.mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean isPrimaryNavigation = this.mFragmentManager.isPrimaryNavigation(this);
        java.lang.Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != isPrimaryNavigation) {
            this.mIsPrimaryNavigationFragment = java.lang.Boolean.valueOf(isPrimaryNavigation);
            onPrimaryNavigationFragmentChanged(isPrimaryNavigation);
            this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
        }
    }

    public void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new androidx.fragment.app.SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        androidx.lifecycle.Lifecycle.Event event = androidx.lifecycle.Lifecycle.Event.ON_RESUME;
        lifecycleRegistry.handleLifecycleEvent(event);
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(event);
        }
        this.mChildFragmentManager.dispatchResume();
    }

    public void performSaveInstanceState(android.os.Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
        android.os.Parcelable saveAllState = this.mChildFragmentManager.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable("android:support:fragments", saveAllState);
        }
    }

    public void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new androidx.fragment.app.SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        androidx.lifecycle.Lifecycle.Event event = androidx.lifecycle.Lifecycle.Event.ON_START;
        lifecycleRegistry.handleLifecycleEvent(event);
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(event);
        }
        this.mChildFragmentManager.dispatchStart();
    }

    public void performStop() {
        this.mChildFragmentManager.dispatchStop();
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new androidx.fragment.app.SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchViewCreated();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public final void postponeEnterTransition(long j, @androidx.annotation.NonNull java.util.concurrent.TimeUnit timeUnit) {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
        androidx.fragment.app.FragmentManager fragmentManager = this.mFragmentManager;
        android.os.Handler handler = fragmentManager != null ? fragmentManager.getHost().getHandler() : new android.os.Handler(android.os.Looper.getMainLooper());
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public final <I, O> androidx.activity.result.ActivityResultLauncher<I> registerForActivityResult(@androidx.annotation.NonNull androidx.activity.result.contract.ActivityResultContract<I, O> activityResultContract, @androidx.annotation.NonNull androidx.activity.result.ActivityResultCallback<O> activityResultCallback) {
        return prepareCallInternal(activityResultContract, new androidx.fragment.app.Fragment.AnonymousClass6(), activityResultCallback);
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public final <I, O> androidx.activity.result.ActivityResultLauncher<I> registerForActivityResult(@androidx.annotation.NonNull androidx.activity.result.contract.ActivityResultContract<I, O> activityResultContract, @androidx.annotation.NonNull androidx.activity.result.ActivityResultRegistry activityResultRegistry, @androidx.annotation.NonNull androidx.activity.result.ActivityResultCallback<O> activityResultCallback) {
        return prepareCallInternal(activityResultContract, new androidx.fragment.app.Fragment.AnonymousClass7(activityResultRegistry), activityResultCallback);
    }

    public void registerForContextMenu(@androidx.annotation.NonNull android.view.View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @java.lang.Deprecated
    public final void requestPermissions(@androidx.annotation.NonNull java.lang.String[] strArr, int i) {
        if (this.mHost != null) {
            getParentFragmentManager().launchRequestPermissions(this, strArr, i);
            return;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @androidx.annotation.NonNull
    public final androidx.fragment.app.FragmentActivity requireActivity() {
        androidx.fragment.app.FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @androidx.annotation.NonNull
    public final android.os.Bundle requireArguments() {
        android.os.Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    @androidx.annotation.NonNull
    public final android.content.Context requireContext() {
        android.content.Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public final androidx.fragment.app.FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    @androidx.annotation.NonNull
    public final java.lang.Object requireHost() {
        java.lang.Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    @androidx.annotation.NonNull
    public final androidx.fragment.app.Fragment requireParentFragment() {
        androidx.fragment.app.Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new java.lang.IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    @androidx.annotation.NonNull
    public final android.view.View requireView() {
        android.view.View view = getView();
        if (view != null) {
            return view;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public void restoreChildFragmentState(@androidx.annotation.Nullable android.os.Bundle bundle) {
        android.os.Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.restoreSaveState(parcelable);
        this.mChildFragmentManager.dispatchCreate();
    }

    public final void restoreViewState(android.os.Bundle bundle) {
        android.util.SparseArray<android.os.Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.performRestore(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
            }
        } else {
            throw new androidx.fragment.app.SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().mAllowEnterTransitionOverlap = java.lang.Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().mAllowReturnTransitionOverlap = java.lang.Boolean.valueOf(z);
    }

    public void setAnimatingAway(android.view.View view) {
        ensureAnimationInfo().mAnimatingAway = view;
    }

    public void setAnimations(int i, int i2, int i3, int i4) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        ensureAnimationInfo().mEnterAnim = i;
        ensureAnimationInfo().mExitAnim = i2;
        ensureAnimationInfo().mPopEnterAnim = i3;
        ensureAnimationInfo().mPopExitAnim = i4;
    }

    public void setAnimator(android.animation.Animator animator) {
        ensureAnimationInfo().mAnimator = animator;
    }

    public void setArguments(@androidx.annotation.Nullable android.os.Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new java.lang.IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(@androidx.annotation.Nullable androidx.core.app.SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().mEnterTransitionCallback = sharedElementCallback;
    }

    public void setEnterTransition(@androidx.annotation.Nullable java.lang.Object obj) {
        ensureAnimationInfo().mEnterTransition = obj;
    }

    public void setExitSharedElementCallback(@androidx.annotation.Nullable androidx.core.app.SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().mExitTransitionCallback = sharedElementCallback;
    }

    public void setExitTransition(@androidx.annotation.Nullable java.lang.Object obj) {
        ensureAnimationInfo().mExitTransition = obj;
    }

    public void setFocusedView(android.view.View view) {
        ensureAnimationInfo().mFocusedView = view;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.onSupportInvalidateOptionsMenu();
        }
    }

    public void setHideReplaced(boolean z) {
        ensureAnimationInfo().mIsHideReplaced = z;
    }

    public void setInitialSavedState(@androidx.annotation.Nullable androidx.fragment.app.Fragment.SavedState savedState) {
        android.os.Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new java.lang.IllegalStateException("Fragment already added");
        }
        if (savedState == null || (bundle = savedState.mState) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setNextTransition(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = i;
    }

    public void setOnStartEnterTransitionListener(androidx.fragment.app.Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        ensureAnimationInfo();
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        androidx.fragment.app.Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener2 = animationInfo.mStartEnterTransitionListener;
        if (onStartEnterTransitionListener == onStartEnterTransitionListener2) {
            return;
        }
        if (onStartEnterTransitionListener != null && onStartEnterTransitionListener2 != null) {
            throw new java.lang.IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (animationInfo.mEnterTransitionPostponed) {
            animationInfo.mStartEnterTransitionListener = onStartEnterTransitionListener;
        }
        if (onStartEnterTransitionListener != null) {
            onStartEnterTransitionListener.startListening();
        }
    }

    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
            return;
        }
        ensureAnimationInfo().mIsPop = z;
    }

    public void setPostOnViewCreatedAlpha(float f) {
        ensureAnimationInfo().mPostOnViewCreatedAlpha = f;
    }

    public void setReenterTransition(@androidx.annotation.Nullable java.lang.Object obj) {
        ensureAnimationInfo().mReenterTransition = obj;
    }

    @java.lang.Deprecated
    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        androidx.fragment.app.FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            fragmentManager.addRetainedFragment(this);
        } else {
            fragmentManager.removeRetainedFragment(this);
        }
    }

    public void setReturnTransition(@androidx.annotation.Nullable java.lang.Object obj) {
        ensureAnimationInfo().mReturnTransition = obj;
    }

    public void setSharedElementEnterTransition(@androidx.annotation.Nullable java.lang.Object obj) {
        ensureAnimationInfo().mSharedElementEnterTransition = obj;
    }

    public void setSharedElementNames(@androidx.annotation.Nullable java.util.ArrayList<java.lang.String> arrayList, @androidx.annotation.Nullable java.util.ArrayList<java.lang.String> arrayList2) {
        ensureAnimationInfo();
        androidx.fragment.app.Fragment.AnimationInfo animationInfo = this.mAnimationInfo;
        animationInfo.mSharedElementSourceNames = arrayList;
        animationInfo.mSharedElementTargetNames = arrayList2;
    }

    public void setSharedElementReturnTransition(@androidx.annotation.Nullable java.lang.Object obj) {
        ensureAnimationInfo().mSharedElementReturnTransition = obj;
    }

    @java.lang.Deprecated
    public void setTargetFragment(@androidx.annotation.Nullable androidx.fragment.app.Fragment fragment, int i) {
        androidx.fragment.app.FragmentManager fragmentManager = this.mFragmentManager;
        androidx.fragment.app.FragmentManager fragmentManager2 = fragment != null ? fragment.mFragmentManager : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new java.lang.IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (androidx.fragment.app.Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getTargetFragment()) {
            if (fragment2.equals(this)) {
                throw new java.lang.IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i;
    }

    @java.lang.Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            androidx.fragment.app.FragmentManager fragmentManager = this.mFragmentManager;
            fragmentManager.performPendingDeferredStart(fragmentManager.createOrGetFragmentStateManager(this));
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 5 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = java.lang.Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(@androidx.annotation.NonNull java.lang.String str) {
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            return fragmentHostCallback.onShouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public void startActivity(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, @androidx.annotation.Nullable android.os.Bundle bundle) {
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.onStartActivityFromFragment(this, intent, -1, bundle);
            return;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @java.lang.Deprecated
    public void startActivityForResult(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    @java.lang.Deprecated
    public void startActivityForResult(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
        if (this.mHost != null) {
            getParentFragmentManager().launchStartActivityForResult(this, intent, i, bundle);
            return;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @java.lang.Deprecated
    public void startIntentSenderForResult(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.IntentSender intentSender, int i, @androidx.annotation.Nullable android.content.Intent intent, int i2, int i3, int i4, @androidx.annotation.Nullable android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
        if (this.mHost == null) {
            throw new java.lang.IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" received the following in startIntentSenderForResult() requestCode: ");
            sb.append(i);
            sb.append(" IntentSender: ");
            sb.append(intentSender);
            sb.append(" fillInIntent: ");
            sb.append(intent);
            sb.append(" options: ");
            sb.append(bundle);
        }
        getParentFragmentManager().launchStartIntentSenderForResult(this, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !ensureAnimationInfo().mEnterTransitionPostponed) {
            return;
        }
        if (this.mHost == null) {
            ensureAnimationInfo().mEnterTransitionPostponed = false;
        } else if (android.os.Looper.myLooper() != this.mHost.getHandler().getLooper()) {
            this.mHost.getHandler().postAtFrontOfQueue(new androidx.fragment.app.Fragment.AnonymousClass2());
        } else {
            callStartTransitionListener(true);
        }
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        sb.append(com.alipay.sdk.m.u.i.d);
        sb.append(" (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(java.lang.Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(@androidx.annotation.NonNull android.view.View view) {
        view.setOnCreateContextMenuListener(null);
    }
}
