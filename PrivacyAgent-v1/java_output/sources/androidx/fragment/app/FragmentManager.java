package androidx.fragment.app;

/* loaded from: classes.dex */
public abstract class FragmentManager implements androidx.fragment.app.FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final java.lang.String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final java.lang.String TAG = "FragmentManager";
    static boolean USE_STATE_MANAGER = true;
    java.util.ArrayList<androidx.fragment.app.BackStackRecord> mBackStack;
    private java.util.ArrayList<androidx.fragment.app.FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
    private androidx.fragment.app.FragmentContainer mContainer;
    private java.util.ArrayList<androidx.fragment.app.Fragment> mCreatedMenus;
    private boolean mDestroyed;
    private boolean mExecutingActions;
    private boolean mHavePendingDeferredStart;
    private androidx.fragment.app.FragmentHostCallback<?> mHost;
    private boolean mNeedMenuInvalidate;
    private androidx.fragment.app.FragmentManagerViewModel mNonConfig;
    private androidx.activity.OnBackPressedDispatcher mOnBackPressedDispatcher;
    private androidx.fragment.app.Fragment mParent;
    private java.util.ArrayList<androidx.fragment.app.FragmentManager.StartEnterTransitionListener> mPostponedTransactions;

    @androidx.annotation.Nullable
    androidx.fragment.app.Fragment mPrimaryNav;
    private androidx.activity.result.ActivityResultLauncher<java.lang.String[]> mRequestPermissions;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> mStartActivityForResult;
    private androidx.activity.result.ActivityResultLauncher<androidx.activity.result.IntentSenderRequest> mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private java.util.ArrayList<androidx.fragment.app.Fragment> mTmpAddedFragments;
    private java.util.ArrayList<java.lang.Boolean> mTmpIsPop;
    private java.util.ArrayList<androidx.fragment.app.BackStackRecord> mTmpRecords;
    private final java.util.ArrayList<androidx.fragment.app.FragmentManager.OpGenerator> mPendingActions = new java.util.ArrayList<>();
    private final androidx.fragment.app.FragmentStore mFragmentStore = new androidx.fragment.app.FragmentStore();
    private final androidx.fragment.app.FragmentLayoutInflaterFactory mLayoutInflaterFactory = new androidx.fragment.app.FragmentLayoutInflaterFactory(this);
    private final androidx.activity.OnBackPressedCallback mOnBackPressedCallback = new androidx.fragment.app.FragmentManager.AnonymousClass1(false);
    private final java.util.concurrent.atomic.AtomicInteger mBackStackIndex = new java.util.concurrent.atomic.AtomicInteger();
    private final java.util.Map<java.lang.String, android.os.Bundle> mResults = java.util.Collections.synchronizedMap(new java.util.HashMap());
    private final java.util.Map<java.lang.String, androidx.fragment.app.FragmentManager.LifecycleAwareResultListener> mResultListeners = java.util.Collections.synchronizedMap(new java.util.HashMap());
    private java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> mExitAnimationCancellationSignals = java.util.Collections.synchronizedMap(new java.util.HashMap());
    private final androidx.fragment.app.FragmentTransition.Callback mFragmentTransitionCallback = new androidx.fragment.app.FragmentManager.AnonymousClass2();
    private final androidx.fragment.app.FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher = new androidx.fragment.app.FragmentLifecycleCallbacksDispatcher(this);
    private final java.util.concurrent.CopyOnWriteArrayList<androidx.fragment.app.FragmentOnAttachListener> mOnAttachListeners = new java.util.concurrent.CopyOnWriteArrayList<>();
    int mCurState = -1;
    private androidx.fragment.app.FragmentFactory mFragmentFactory = null;
    private androidx.fragment.app.FragmentFactory mHostFragmentFactory = new androidx.fragment.app.FragmentManager.AnonymousClass3();
    private androidx.fragment.app.SpecialEffectsControllerFactory mSpecialEffectsControllerFactory = null;
    private androidx.fragment.app.SpecialEffectsControllerFactory mDefaultSpecialEffectsControllerFactory = new androidx.fragment.app.FragmentManager.AnonymousClass4();
    java.util.ArrayDeque<androidx.fragment.app.FragmentManager.LaunchedFragmentInfo> mLaunchedFragments = new java.util.ArrayDeque<>();
    private java.lang.Runnable mExecCommit = new androidx.fragment.app.FragmentManager.AnonymousClass5();

    /* renamed from: androidx.fragment.app.FragmentManager$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.activity.OnBackPressedCallback {
        public AnonymousClass1(boolean z) {
            super(z);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            androidx.fragment.app.FragmentManager.this.handleOnBackPressed();
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$10, reason: invalid class name */
    public class AnonymousClass10 implements androidx.activity.result.ActivityResultCallback<androidx.activity.result.ActivityResult> {
        public AnonymousClass10() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(androidx.activity.result.ActivityResult activityResult) {
            androidx.fragment.app.FragmentManager.LaunchedFragmentInfo pollFirst = androidx.fragment.app.FragmentManager.this.mLaunchedFragments.pollFirst();
            if (pollFirst == null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("No IntentSenders were started for ");
                sb.append(this);
                return;
            }
            java.lang.String str = pollFirst.mWho;
            int i = pollFirst.mRequestCode;
            androidx.fragment.app.Fragment findFragmentByWho = androidx.fragment.app.FragmentManager.this.mFragmentStore.findFragmentByWho(str);
            if (findFragmentByWho != null) {
                findFragmentByWho.onActivityResult(i, activityResult.getResultCode(), activityResult.getData());
                return;
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Intent Sender result delivered for unknown Fragment ");
            sb2.append(str);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$11, reason: invalid class name */
    public class AnonymousClass11 implements androidx.activity.result.ActivityResultCallback<java.util.Map<java.lang.String, java.lang.Boolean>> {
        public AnonymousClass11() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        @android.annotation.SuppressLint({"SyntheticAccessor"})
        public void onActivityResult(java.util.Map<java.lang.String, java.lang.Boolean> map) {
            java.lang.String[] strArr = (java.lang.String[]) map.keySet().toArray(new java.lang.String[0]);
            java.util.ArrayList arrayList = new java.util.ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((java.lang.Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
            }
            androidx.fragment.app.FragmentManager.LaunchedFragmentInfo pollFirst = androidx.fragment.app.FragmentManager.this.mLaunchedFragments.pollFirst();
            if (pollFirst == null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("No permissions were requested for ");
                sb.append(this);
                return;
            }
            java.lang.String str = pollFirst.mWho;
            int i2 = pollFirst.mRequestCode;
            androidx.fragment.app.Fragment findFragmentByWho = androidx.fragment.app.FragmentManager.this.mFragmentStore.findFragmentByWho(str);
            if (findFragmentByWho != null) {
                findFragmentByWho.onRequestPermissionsResult(i2, strArr, iArr);
                return;
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Permission request result delivered for unknown Fragment ");
            sb2.append(str);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.fragment.app.FragmentTransition.Callback {
        public AnonymousClass2() {
        }

        @Override // androidx.fragment.app.FragmentTransition.Callback
        public void onComplete(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal) {
            if (cancellationSignal.isCanceled()) {
                return;
            }
            androidx.fragment.app.FragmentManager.this.removeCancellationSignal(fragment, cancellationSignal);
        }

        @Override // androidx.fragment.app.FragmentTransition.Callback
        public void onStart(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal) {
            androidx.fragment.app.FragmentManager.this.addCancellationSignal(fragment, cancellationSignal);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.fragment.app.FragmentFactory {
        public AnonymousClass3() {
        }

        @Override // androidx.fragment.app.FragmentFactory
        @androidx.annotation.NonNull
        public androidx.fragment.app.Fragment instantiate(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str) {
            return androidx.fragment.app.FragmentManager.this.getHost().instantiate(androidx.fragment.app.FragmentManager.this.getHost().getContext(), str, null);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$4, reason: invalid class name */
    public class AnonymousClass4 implements androidx.fragment.app.SpecialEffectsControllerFactory {
        public AnonymousClass4() {
        }

        @Override // androidx.fragment.app.SpecialEffectsControllerFactory
        @androidx.annotation.NonNull
        public androidx.fragment.app.SpecialEffectsController createController(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
            return new androidx.fragment.app.DefaultSpecialEffectsController(viewGroup);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.fragment.app.FragmentManager.this.execPendingActions(true);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$6, reason: invalid class name */
    public class AnonymousClass6 implements androidx.lifecycle.LifecycleEventObserver {
        final /* synthetic */ androidx.lifecycle.Lifecycle val$lifecycle;
        final /* synthetic */ androidx.fragment.app.FragmentResultListener val$listener;
        final /* synthetic */ java.lang.String val$requestKey;

        public AnonymousClass6(java.lang.String str, androidx.fragment.app.FragmentResultListener fragmentResultListener, androidx.lifecycle.Lifecycle lifecycle) {
            this.val$requestKey = str;
            this.val$listener = fragmentResultListener;
            this.val$lifecycle = lifecycle;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
            android.os.Bundle bundle;
            if (event == androidx.lifecycle.Lifecycle.Event.ON_START && (bundle = (android.os.Bundle) androidx.fragment.app.FragmentManager.this.mResults.get(this.val$requestKey)) != null) {
                this.val$listener.onFragmentResult(this.val$requestKey, bundle);
                androidx.fragment.app.FragmentManager.this.clearFragmentResult(this.val$requestKey);
            }
            if (event == androidx.lifecycle.Lifecycle.Event.ON_DESTROY) {
                this.val$lifecycle.removeObserver(this);
                androidx.fragment.app.FragmentManager.this.mResultListeners.remove(this.val$requestKey);
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$7, reason: invalid class name */
    public class AnonymousClass7 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ android.view.View val$animatingView;
        final /* synthetic */ android.view.ViewGroup val$container;
        final /* synthetic */ androidx.fragment.app.Fragment val$fragment;

        public AnonymousClass7(android.view.ViewGroup viewGroup, android.view.View view, androidx.fragment.app.Fragment fragment) {
            this.val$container = viewGroup;
            this.val$animatingView = view;
            this.val$fragment = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.val$container.endViewTransition(this.val$animatingView);
            animator.removeListener(this);
            androidx.fragment.app.Fragment fragment = this.val$fragment;
            android.view.View view = fragment.mView;
            if (view == null || !fragment.mHidden) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$8, reason: invalid class name */
    public class AnonymousClass8 implements androidx.fragment.app.FragmentOnAttachListener {
        final /* synthetic */ androidx.fragment.app.Fragment val$parent;

        public AnonymousClass8(androidx.fragment.app.Fragment fragment) {
            this.val$parent = fragment;
        }

        @Override // androidx.fragment.app.FragmentOnAttachListener
        public void onAttachFragment(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
            this.val$parent.onAttachFragment(fragment);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$9, reason: invalid class name */
    public class AnonymousClass9 implements androidx.activity.result.ActivityResultCallback<androidx.activity.result.ActivityResult> {
        public AnonymousClass9() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(androidx.activity.result.ActivityResult activityResult) {
            androidx.fragment.app.FragmentManager.LaunchedFragmentInfo pollFirst = androidx.fragment.app.FragmentManager.this.mLaunchedFragments.pollFirst();
            if (pollFirst == null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("No Activities were started for result for ");
                sb.append(this);
                return;
            }
            java.lang.String str = pollFirst.mWho;
            int i = pollFirst.mRequestCode;
            androidx.fragment.app.Fragment findFragmentByWho = androidx.fragment.app.FragmentManager.this.mFragmentStore.findFragmentByWho(str);
            if (findFragmentByWho != null) {
                findFragmentByWho.onActivityResult(i, activityResult.getResultCode(), activityResult.getData());
                return;
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Activity result delivered for unknown Fragment ");
            sb2.append(str);
        }
    }

    public interface BackStackEntry {
        @androidx.annotation.Nullable
        @java.lang.Deprecated
        java.lang.CharSequence getBreadCrumbShortTitle();

        @androidx.annotation.StringRes
        @java.lang.Deprecated
        int getBreadCrumbShortTitleRes();

        @androidx.annotation.Nullable
        @java.lang.Deprecated
        java.lang.CharSequence getBreadCrumbTitle();

        @androidx.annotation.StringRes
        @java.lang.Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        @androidx.annotation.Nullable
        java.lang.String getName();
    }

    public static class FragmentIntentSenderContract extends androidx.activity.result.contract.ActivityResultContract<androidx.activity.result.IntentSenderRequest, androidx.activity.result.ActivityResult> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, androidx.activity.result.IntentSenderRequest intentSenderRequest) {
            android.os.Bundle bundleExtra;
            android.content.Intent intent = new android.content.Intent(androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST);
            android.content.Intent fillInIntent = intentSenderRequest.getFillInIntent();
            if (fillInIntent != null && (bundleExtra = fillInIntent.getBundleExtra(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) != null) {
                intent.putExtra(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundleExtra);
                fillInIntent.removeExtra(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
                if (fillInIntent.getBooleanExtra(androidx.fragment.app.FragmentManager.EXTRA_CREATED_FILLIN_INTENT, false)) {
                    intentSenderRequest = new androidx.activity.result.IntentSenderRequest.Builder(intentSenderRequest.getIntentSender()).setFillInIntent(null).setFlags(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).build();
                }
            }
            intent.putExtra(androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("CreateIntent created the following intent: ");
                sb.append(intent);
            }
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public androidx.activity.result.ActivityResult parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            return new androidx.activity.result.ActivityResult(i, intent);
        }
    }

    public static abstract class FragmentLifecycleCallbacks {
        @java.lang.Deprecated
        public void onFragmentActivityCreated(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.Nullable android.os.Bundle bundle) {
        }

        public void onFragmentAttached(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull android.content.Context context) {
        }

        public void onFragmentCreated(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.Nullable android.os.Bundle bundle) {
        }

        public void onFragmentDestroyed(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        }

        public void onFragmentDetached(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        }

        public void onFragmentPaused(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        }

        public void onFragmentPreAttached(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull android.content.Context context) {
        }

        public void onFragmentPreCreated(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.Nullable android.os.Bundle bundle) {
        }

        public void onFragmentResumed(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull android.os.Bundle bundle) {
        }

        public void onFragmentStarted(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        }

        public void onFragmentStopped(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        }

        public void onFragmentViewCreated(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.os.Bundle bundle) {
        }

        public void onFragmentViewDestroyed(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        }
    }

    @android.annotation.SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<androidx.fragment.app.FragmentManager.LaunchedFragmentInfo> CREATOR = new androidx.fragment.app.FragmentManager.LaunchedFragmentInfo.AnonymousClass1();
        int mRequestCode;
        java.lang.String mWho;

        /* renamed from: androidx.fragment.app.FragmentManager$LaunchedFragmentInfo$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.fragment.app.FragmentManager.LaunchedFragmentInfo> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public androidx.fragment.app.FragmentManager.LaunchedFragmentInfo createFromParcel(android.os.Parcel parcel) {
                return new androidx.fragment.app.FragmentManager.LaunchedFragmentInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public androidx.fragment.app.FragmentManager.LaunchedFragmentInfo[] newArray(int i) {
                return new androidx.fragment.app.FragmentManager.LaunchedFragmentInfo[i];
            }
        }

        public LaunchedFragmentInfo(@androidx.annotation.NonNull android.os.Parcel parcel) {
            this.mWho = parcel.readString();
            this.mRequestCode = parcel.readInt();
        }

        public LaunchedFragmentInfo(@androidx.annotation.NonNull java.lang.String str, int i) {
            this.mWho = str;
            this.mRequestCode = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeString(this.mWho);
            parcel.writeInt(this.mRequestCode);
        }
    }

    public static class LifecycleAwareResultListener implements androidx.fragment.app.FragmentResultListener {
        private final androidx.lifecycle.Lifecycle mLifecycle;
        private final androidx.fragment.app.FragmentResultListener mListener;
        private final androidx.lifecycle.LifecycleEventObserver mObserver;

        public LifecycleAwareResultListener(@androidx.annotation.NonNull androidx.lifecycle.Lifecycle lifecycle, @androidx.annotation.NonNull androidx.fragment.app.FragmentResultListener fragmentResultListener, @androidx.annotation.NonNull androidx.lifecycle.LifecycleEventObserver lifecycleEventObserver) {
            this.mLifecycle = lifecycle;
            this.mListener = fragmentResultListener;
            this.mObserver = lifecycleEventObserver;
        }

        public boolean isAtLeast(androidx.lifecycle.Lifecycle.State state) {
            return this.mLifecycle.getCurrentState().isAtLeast(state);
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void onFragmentResult(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.os.Bundle bundle) {
            this.mListener.onFragmentResult(str, bundle);
        }

        public void removeObserver() {
            this.mLifecycle.removeObserver(this.mObserver);
        }
    }

    public interface OnBackStackChangedListener {
        @androidx.annotation.MainThread
        void onBackStackChanged();
    }

    public interface OpGenerator {
        boolean generateOps(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList, @androidx.annotation.NonNull java.util.ArrayList<java.lang.Boolean> arrayList2);
    }

    public class PopBackStackState implements androidx.fragment.app.FragmentManager.OpGenerator {
        final int mFlags;
        final int mId;
        final java.lang.String mName;

        public PopBackStackState(@androidx.annotation.Nullable java.lang.String str, int i, int i2) {
            this.mName = str;
            this.mId = i;
            this.mFlags = i2;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList, @androidx.annotation.NonNull java.util.ArrayList<java.lang.Boolean> arrayList2) {
            androidx.fragment.app.Fragment fragment = androidx.fragment.app.FragmentManager.this.mPrimaryNav;
            if (fragment == null || this.mId >= 0 || this.mName != null || !fragment.getChildFragmentManager().popBackStackImmediate()) {
                return androidx.fragment.app.FragmentManager.this.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
            }
            return false;
        }
    }

    public static class StartEnterTransitionListener implements androidx.fragment.app.Fragment.OnStartEnterTransitionListener {
        final boolean mIsBack;
        private int mNumPostponed;
        final androidx.fragment.app.BackStackRecord mRecord;

        public StartEnterTransitionListener(@androidx.annotation.NonNull androidx.fragment.app.BackStackRecord backStackRecord, boolean z) {
            this.mIsBack = z;
            this.mRecord = backStackRecord;
        }

        public void cancelTransaction() {
            androidx.fragment.app.BackStackRecord backStackRecord = this.mRecord;
            backStackRecord.mManager.completeExecute(backStackRecord, this.mIsBack, false, false);
        }

        public void completeTransaction() {
            boolean z = this.mNumPostponed > 0;
            for (androidx.fragment.app.Fragment fragment : this.mRecord.mManager.getFragments()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            androidx.fragment.app.BackStackRecord backStackRecord = this.mRecord;
            backStackRecord.mManager.completeExecute(backStackRecord, this.mIsBack, !z, true);
        }

        public boolean isReady() {
            return this.mNumPostponed == 0;
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void onStartEnterTransition() {
            int i = this.mNumPostponed - 1;
            this.mNumPostponed = i;
            if (i != 0) {
                return;
            }
            this.mRecord.mManager.scheduleCommit();
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void startListening() {
            this.mNumPostponed++;
        }
    }

    private void addAddedFragments(@androidx.annotation.NonNull androidx.collection.ArraySet<androidx.fragment.app.Fragment> arraySet) {
        int i = this.mCurState;
        if (i < 1) {
            return;
        }
        int min = java.lang.Math.min(i, 5);
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment.mState < min) {
                moveToState(fragment, min);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    arraySet.add(fragment);
                }
            }
        }
    }

    private void cancelExitAnimation(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        java.util.HashSet<androidx.core.os.CancellationSignal> hashSet = this.mExitAnimationCancellationSignals.get(fragment);
        if (hashSet != null) {
            java.util.Iterator<androidx.core.os.CancellationSignal> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            hashSet.clear();
            destroyFragmentView(fragment);
            this.mExitAnimationCancellationSignals.remove(fragment);
        }
    }

    private void checkStateLoss() {
        if (isStateSaved()) {
            throw new java.lang.IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    private java.util.Set<androidx.fragment.app.SpecialEffectsController> collectAllSpecialEffectsController() {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<androidx.fragment.app.FragmentStateManager> it = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (it.hasNext()) {
            android.view.ViewGroup viewGroup = it.next().getFragment().mContainer;
            if (viewGroup != null) {
                hashSet.add(androidx.fragment.app.SpecialEffectsController.getOrCreateController(viewGroup, getSpecialEffectsControllerFactory()));
            }
        }
        return hashSet;
    }

    private java.util.Set<androidx.fragment.app.SpecialEffectsController> collectChangedControllers(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList, int i, int i2) {
        android.view.ViewGroup viewGroup;
        java.util.HashSet hashSet = new java.util.HashSet();
        while (i < i2) {
            java.util.Iterator<androidx.fragment.app.FragmentTransaction.Op> it = arrayList.get(i).mOps.iterator();
            while (it.hasNext()) {
                androidx.fragment.app.Fragment fragment = it.next().mFragment;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(androidx.fragment.app.SpecialEffectsController.getOrCreateController(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    private void completeShowHideFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        android.animation.Animator animator;
        if (fragment.mView != null) {
            androidx.fragment.app.FragmentAnim.AnimationOrAnimator loadAnimation = androidx.fragment.app.FragmentAnim.loadAnimation(this.mHost.getContext(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (loadAnimation == null || (animator = loadAnimation.animator) == null) {
                if (loadAnimation != null) {
                    fragment.mView.startAnimation(loadAnimation.animation);
                    loadAnimation.animation.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    android.view.ViewGroup viewGroup = fragment.mContainer;
                    android.view.View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    loadAnimation.animator.addListener(new androidx.fragment.app.FragmentManager.AnonymousClass7(viewGroup, view, fragment));
                }
                loadAnimation.animator.start();
            }
        }
        invalidateMenuForFragment(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void destroyFragmentView(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        fragment.performDestroyView();
        this.mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(@androidx.annotation.Nullable androidx.fragment.app.Fragment fragment) {
        if (fragment == null || !fragment.equals(findActiveFragment(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    private void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            this.mFragmentStore.dispatchStateChange(i);
            moveToState(i, false);
            if (USE_STATE_MANAGER) {
                java.util.Iterator<androidx.fragment.app.SpecialEffectsController> it = collectAllSpecialEffectsController().iterator();
                while (it.hasNext()) {
                    it.next().forceCompleteAllOperations();
                }
            }
            this.mExecutingActions = false;
            execPendingActions(true);
        } catch (java.lang.Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    private void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    @java.lang.Deprecated
    public static void enableDebugLogging(boolean z) {
        DEBUG = z;
    }

    @androidx.fragment.app.FragmentStateManagerControl
    public static void enableNewStateManager(boolean z) {
        USE_STATE_MANAGER = z;
    }

    private void endAnimatingAwayFragments() {
        if (USE_STATE_MANAGER) {
            java.util.Iterator<androidx.fragment.app.SpecialEffectsController> it = collectAllSpecialEffectsController().iterator();
            while (it.hasNext()) {
                it.next().forceCompleteAllOperations();
            }
        } else {
            if (this.mExitAnimationCancellationSignals.isEmpty()) {
                return;
            }
            for (androidx.fragment.app.Fragment fragment : this.mExitAnimationCancellationSignals.keySet()) {
                cancelExitAnimation(fragment);
                moveToState(fragment);
            }
        }
    }

    private void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new java.lang.IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.mHost == null) {
            if (!this.mDestroyed) {
                throw new java.lang.IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new java.lang.IllegalStateException("FragmentManager has been destroyed");
        }
        if (android.os.Looper.myLooper() != this.mHost.getHandler().getLooper()) {
            throw new java.lang.IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            checkStateLoss();
        }
        if (this.mTmpRecords == null) {
            this.mTmpRecords = new java.util.ArrayList<>();
            this.mTmpIsPop = new java.util.ArrayList<>();
        }
        this.mExecutingActions = true;
        try {
            executePostponedTransaction(null, null);
        } finally {
            this.mExecutingActions = false;
        }
    }

    private static void executeOps(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList, @androidx.annotation.NonNull java.util.ArrayList<java.lang.Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            androidx.fragment.app.BackStackRecord backStackRecord = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                backStackRecord.bumpBackStackNesting(-1);
                backStackRecord.executePopOps(i == i2 + (-1));
            } else {
                backStackRecord.bumpBackStackNesting(1);
                backStackRecord.executeOps();
            }
            i++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0143  */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void executeOpsTogether(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList, @androidx.annotation.NonNull java.util.ArrayList<java.lang.Boolean> arrayList2, int i, int i2) {
        ?? r1;
        boolean z;
        int i3;
        int i4;
        java.util.ArrayList<java.lang.Boolean> arrayList3;
        int i5;
        int i6;
        java.util.ArrayList<java.lang.Boolean> arrayList4;
        int i7;
        boolean z2;
        int i8;
        boolean z3 = arrayList.get(i).mReorderingAllowed;
        java.util.ArrayList<androidx.fragment.app.Fragment> arrayList5 = this.mTmpAddedFragments;
        if (arrayList5 == null) {
            this.mTmpAddedFragments = new java.util.ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
        androidx.fragment.app.Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        boolean z4 = false;
        for (int i9 = i; i9 < i2; i9++) {
            androidx.fragment.app.BackStackRecord backStackRecord = arrayList.get(i9);
            primaryNavigationFragment = !arrayList2.get(i9).booleanValue() ? backStackRecord.expandOps(this.mTmpAddedFragments, primaryNavigationFragment) : backStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments, primaryNavigationFragment);
            z4 = z4 || backStackRecord.mAddToBackStack;
        }
        this.mTmpAddedFragments.clear();
        if (!z3 && this.mCurState >= 1) {
            if (!USE_STATE_MANAGER) {
                r1 = 1;
                androidx.fragment.app.FragmentTransition.startTransitions(this.mHost.getContext(), this.mContainer, arrayList, arrayList2, i, i2, false, this.mFragmentTransitionCallback);
                executeOps(arrayList, arrayList2, i, i2);
                if (USE_STATE_MANAGER) {
                    if (z3) {
                        androidx.collection.ArraySet arraySet = new androidx.collection.ArraySet();
                        addAddedFragments(arraySet);
                        i5 = 1;
                        z = z3;
                        i3 = i2;
                        i4 = i;
                        arrayList3 = arrayList2;
                        i6 = postponePostponableTransactions(arrayList, arrayList2, i, i2, arraySet);
                        makeRemovedFragmentsInvisible(arraySet);
                    } else {
                        z = z3;
                        i3 = i2;
                        i4 = i;
                        arrayList3 = arrayList2;
                        i5 = 1;
                        i6 = i3;
                    }
                    if (i6 == i4 || !z) {
                        arrayList4 = arrayList3;
                        i7 = i3;
                    } else {
                        if (this.mCurState >= i5) {
                            arrayList4 = arrayList3;
                            int i10 = i6;
                            i7 = i3;
                            z2 = true;
                            androidx.fragment.app.FragmentTransition.startTransitions(this.mHost.getContext(), this.mContainer, arrayList, arrayList2, i, i10, true, this.mFragmentTransitionCallback);
                        } else {
                            arrayList4 = arrayList3;
                            i7 = i3;
                            z2 = true;
                        }
                        moveToState(this.mCurState, z2);
                    }
                } else {
                    boolean booleanValue = arrayList2.get(i2 - 1).booleanValue();
                    for (int i11 = i; i11 < i2; i11++) {
                        androidx.fragment.app.BackStackRecord backStackRecord2 = arrayList.get(i11);
                        if (booleanValue) {
                            for (int size = backStackRecord2.mOps.size() - r1; size >= 0; size--) {
                                androidx.fragment.app.Fragment fragment = backStackRecord2.mOps.get(size).mFragment;
                                if (fragment != null) {
                                    createOrGetFragmentStateManager(fragment).moveToExpectedState();
                                }
                            }
                        } else {
                            java.util.Iterator<androidx.fragment.app.FragmentTransaction.Op> it = backStackRecord2.mOps.iterator();
                            while (it.hasNext()) {
                                androidx.fragment.app.Fragment fragment2 = it.next().mFragment;
                                if (fragment2 != null) {
                                    createOrGetFragmentStateManager(fragment2).moveToExpectedState();
                                }
                            }
                        }
                    }
                    moveToState(this.mCurState, (boolean) r1);
                    for (androidx.fragment.app.SpecialEffectsController specialEffectsController : collectChangedControllers(arrayList, i, i2)) {
                        specialEffectsController.updateOperationDirection(booleanValue);
                        specialEffectsController.markPostponedState();
                        specialEffectsController.executePendingOperations();
                    }
                    i7 = i2;
                    arrayList4 = arrayList2;
                }
                for (i8 = i; i8 < i7; i8++) {
                    androidx.fragment.app.BackStackRecord backStackRecord3 = arrayList.get(i8);
                    if (arrayList4.get(i8).booleanValue() && backStackRecord3.mIndex >= 0) {
                        backStackRecord3.mIndex = -1;
                    }
                    backStackRecord3.runOnCommitRunnables();
                }
                if (z4) {
                    return;
                }
                reportBackStackChanged();
                return;
            }
            for (int i12 = i; i12 < i2; i12++) {
                java.util.Iterator<androidx.fragment.app.FragmentTransaction.Op> it2 = arrayList.get(i12).mOps.iterator();
                while (it2.hasNext()) {
                    androidx.fragment.app.Fragment fragment3 = it2.next().mFragment;
                    if (fragment3 != null && fragment3.mFragmentManager != null) {
                        this.mFragmentStore.makeActive(createOrGetFragmentStateManager(fragment3));
                    }
                }
            }
        }
        r1 = 1;
        executeOps(arrayList, arrayList2, i, i2);
        if (USE_STATE_MANAGER) {
        }
        while (i8 < i7) {
        }
        if (z4) {
        }
    }

    private void executePostponedTransaction(@androidx.annotation.Nullable java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList, @androidx.annotation.Nullable java.util.ArrayList<java.lang.Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        java.util.ArrayList<androidx.fragment.app.FragmentManager.StartEnterTransitionListener> arrayList3 = this.mPostponedTransactions;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            androidx.fragment.app.FragmentManager.StartEnterTransitionListener startEnterTransitionListener = this.mPostponedTransactions.get(i);
            if (arrayList != null && !startEnterTransitionListener.mIsBack && (indexOf2 = arrayList.indexOf(startEnterTransitionListener.mRecord)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                this.mPostponedTransactions.remove(i);
                i--;
                size--;
                startEnterTransitionListener.cancelTransaction();
            } else if (startEnterTransitionListener.isReady() || (arrayList != null && startEnterTransitionListener.mRecord.interactsWith(arrayList, 0, arrayList.size()))) {
                this.mPostponedTransactions.remove(i);
                i--;
                size--;
                if (arrayList == null || startEnterTransitionListener.mIsBack || (indexOf = arrayList.indexOf(startEnterTransitionListener.mRecord)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                    startEnterTransitionListener.completeTransaction();
                } else {
                    startEnterTransitionListener.cancelTransaction();
                }
            }
            i++;
        }
    }

    @androidx.annotation.NonNull
    public static <F extends androidx.fragment.app.Fragment> F findFragment(@androidx.annotation.NonNull android.view.View view) {
        F f = (F) findViewFragment(view);
        if (f != null) {
            return f;
        }
        throw new java.lang.IllegalStateException("View " + view + " does not have a Fragment set");
    }

    @androidx.annotation.NonNull
    public static androidx.fragment.app.FragmentManager findFragmentManager(@androidx.annotation.NonNull android.view.View view) {
        androidx.fragment.app.FragmentActivity fragmentActivity;
        androidx.fragment.app.Fragment findViewFragment = findViewFragment(view);
        if (findViewFragment != null) {
            if (findViewFragment.isAdded()) {
                return findViewFragment.getChildFragmentManager();
            }
            throw new java.lang.IllegalStateException("The Fragment " + findViewFragment + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        android.content.Context context = view.getContext();
        while (true) {
            if (!(context instanceof android.content.ContextWrapper)) {
                fragmentActivity = null;
                break;
            }
            if (context instanceof androidx.fragment.app.FragmentActivity) {
                fragmentActivity = (androidx.fragment.app.FragmentActivity) context;
                break;
            }
            context = ((android.content.ContextWrapper) context).getBaseContext();
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        throw new java.lang.IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    @androidx.annotation.Nullable
    private static androidx.fragment.app.Fragment findViewFragment(@androidx.annotation.NonNull android.view.View view) {
        while (view != null) {
            androidx.fragment.app.Fragment viewFragment = getViewFragment(view);
            if (viewFragment != null) {
                return viewFragment;
            }
            java.lang.Object parent = view.getParent();
            view = parent instanceof android.view.View ? (android.view.View) parent : null;
        }
        return null;
    }

    private void forcePostponedTransactions() {
        if (USE_STATE_MANAGER) {
            java.util.Iterator<androidx.fragment.app.SpecialEffectsController> it = collectAllSpecialEffectsController().iterator();
            while (it.hasNext()) {
                it.next().forcePostponedExecutePendingOperations();
            }
        } else if (this.mPostponedTransactions != null) {
            while (!this.mPostponedTransactions.isEmpty()) {
                this.mPostponedTransactions.remove(0).completeTransaction();
            }
        }
    }

    private boolean generateOpsForPendingActions(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList, @androidx.annotation.NonNull java.util.ArrayList<java.lang.Boolean> arrayList2) {
        synchronized (this.mPendingActions) {
            if (this.mPendingActions.isEmpty()) {
                return false;
            }
            int size = this.mPendingActions.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                z |= this.mPendingActions.get(i).generateOps(arrayList, arrayList2);
            }
            this.mPendingActions.clear();
            this.mHost.getHandler().removeCallbacks(this.mExecCommit);
            return z;
        }
    }

    @androidx.annotation.NonNull
    private androidx.fragment.app.FragmentManagerViewModel getChildNonConfig(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        return this.mNonConfig.getChildNonConfig(fragment);
    }

    private android.view.ViewGroup getFragmentContainer(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        android.view.ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.mContainer.onHasView()) {
            android.view.View onFindViewById = this.mContainer.onFindViewById(fragment.mContainerId);
            if (onFindViewById instanceof android.view.ViewGroup) {
                return (android.view.ViewGroup) onFindViewById;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static androidx.fragment.app.Fragment getViewFragment(@androidx.annotation.NonNull android.view.View view) {
        java.lang.Object tag = view.getTag(androidx.fragment.R.id.fragment_container_view_tag);
        if (tag instanceof androidx.fragment.app.Fragment) {
            return (androidx.fragment.app.Fragment) tag;
        }
        return null;
    }

    public static boolean isLoggingEnabled(int i) {
        return DEBUG || android.util.Log.isLoggable(TAG, i);
    }

    private boolean isMenuAvailable(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.checkForMenus();
    }

    private void makeRemovedFragmentsInvisible(@androidx.annotation.NonNull androidx.collection.ArraySet<androidx.fragment.app.Fragment> arraySet) {
        int size = arraySet.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.Fragment valueAt = arraySet.valueAt(i);
            if (!valueAt.mAdded) {
                android.view.View requireView = valueAt.requireView();
                valueAt.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    private boolean popBackStackImmediate(@androidx.annotation.Nullable java.lang.String str, int i, int i2) {
        execPendingActions(false);
        ensureExecReady(true);
        androidx.fragment.app.Fragment fragment = this.mPrimaryNav;
        if (fragment != null && i < 0 && str == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i, i2);
        if (popBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return popBackStackState;
    }

    private int postponePostponableTransactions(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList, @androidx.annotation.NonNull java.util.ArrayList<java.lang.Boolean> arrayList2, int i, int i2, @androidx.annotation.NonNull androidx.collection.ArraySet<androidx.fragment.app.Fragment> arraySet) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            androidx.fragment.app.BackStackRecord backStackRecord = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (backStackRecord.isPostponed() && !backStackRecord.interactsWith(arrayList, i4 + 1, i2)) {
                if (this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new java.util.ArrayList<>();
                }
                androidx.fragment.app.FragmentManager.StartEnterTransitionListener startEnterTransitionListener = new androidx.fragment.app.FragmentManager.StartEnterTransitionListener(backStackRecord, booleanValue);
                this.mPostponedTransactions.add(startEnterTransitionListener);
                backStackRecord.setOnStartPostponedListener(startEnterTransitionListener);
                if (booleanValue) {
                    backStackRecord.executeOps();
                } else {
                    backStackRecord.executePopOps(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, backStackRecord);
                }
                addAddedFragments(arraySet);
            }
        }
        return i3;
    }

    private void removeRedundantOperationsAndExecute(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList, @androidx.annotation.NonNull java.util.ArrayList<java.lang.Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new java.lang.IllegalStateException("Internal error with the back stack records");
        }
        executePostponedTransaction(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!arrayList.get(i).mReorderingAllowed) {
                if (i2 != i) {
                    executeOpsTogether(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).mReorderingAllowed) {
                        i2++;
                    }
                }
                executeOpsTogether(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            executeOpsTogether(arrayList, arrayList2, i2, size);
        }
    }

    private void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i = 0; i < this.mBackStackChangeListeners.size(); i++) {
                this.mBackStackChangeListeners.get(i).onBackStackChanged();
            }
        }
    }

    public static int reverseTransit(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void setVisibleRemovingFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        android.view.ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        int i = androidx.fragment.R.id.visible_removing_fragment_view_tag;
        if (fragmentContainer.getTag(i) == null) {
            fragmentContainer.setTag(i, fragment);
        }
        ((androidx.fragment.app.Fragment) fragmentContainer.getTag(i)).setPopDirection(fragment.getPopDirection());
    }

    private void startPendingDeferredFragments() {
        java.util.Iterator<androidx.fragment.app.FragmentStateManager> it = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (it.hasNext()) {
            performPendingDeferredStart(it.next());
        }
    }

    private void throwException(java.lang.RuntimeException runtimeException) {
        runtimeException.getMessage();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(new androidx.fragment.app.LogWriter(TAG));
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        try {
            if (fragmentHostCallback != null) {
                fragmentHostCallback.onDump("  ", null, printWriter, new java.lang.String[0]);
            } else {
                dump("  ", null, printWriter, new java.lang.String[0]);
            }
            throw runtimeException;
        } catch (java.lang.Exception unused) {
            throw runtimeException;
        }
    }

    private void updateOnBackPressedCallbackEnabled() {
        synchronized (this.mPendingActions) {
            if (this.mPendingActions.isEmpty()) {
                this.mOnBackPressedCallback.setEnabled(getBackStackEntryCount() > 0 && isPrimaryNavigation(this.mParent));
            } else {
                this.mOnBackPressedCallback.setEnabled(true);
            }
        }
    }

    public void addBackStackState(androidx.fragment.app.BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new java.util.ArrayList<>();
        }
        this.mBackStack.add(backStackRecord);
    }

    public void addCancellationSignal(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal) {
        if (this.mExitAnimationCancellationSignals.get(fragment) == null) {
            this.mExitAnimationCancellationSignals.put(fragment, new java.util.HashSet<>());
        }
        this.mExitAnimationCancellationSignals.get(fragment).add(cancellationSignal);
    }

    public androidx.fragment.app.FragmentStateManager addFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        if (isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("add: ");
            sb.append(fragment);
        }
        androidx.fragment.app.FragmentStateManager createOrGetFragmentStateManager = createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        this.mFragmentStore.makeActive(createOrGetFragmentStateManager);
        if (!fragment.mDetached) {
            this.mFragmentStore.addFragment(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
        return createOrGetFragmentStateManager;
    }

    public void addFragmentOnAttachListener(@androidx.annotation.NonNull androidx.fragment.app.FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.add(fragmentOnAttachListener);
    }

    public void addOnBackStackChangedListener(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new java.util.ArrayList<>();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    public void addRetainedFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        this.mNonConfig.addRetainedFragment(fragment);
    }

    public int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    public void attachController(@androidx.annotation.NonNull androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback, @androidx.annotation.NonNull androidx.fragment.app.FragmentContainer fragmentContainer, @androidx.annotation.Nullable androidx.fragment.app.Fragment fragment) {
        java.lang.String str;
        if (this.mHost != null) {
            throw new java.lang.IllegalStateException("Already attached");
        }
        this.mHost = fragmentHostCallback;
        this.mContainer = fragmentContainer;
        this.mParent = fragment;
        if (fragment != null) {
            addFragmentOnAttachListener(new androidx.fragment.app.FragmentManager.AnonymousClass8(fragment));
        } else if (fragmentHostCallback instanceof androidx.fragment.app.FragmentOnAttachListener) {
            addFragmentOnAttachListener((androidx.fragment.app.FragmentOnAttachListener) fragmentHostCallback);
        }
        if (this.mParent != null) {
            updateOnBackPressedCallbackEnabled();
        }
        if (fragmentHostCallback instanceof androidx.activity.OnBackPressedDispatcherOwner) {
            androidx.activity.OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (androidx.activity.OnBackPressedDispatcherOwner) fragmentHostCallback;
            androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
            this.mOnBackPressedDispatcher = onBackPressedDispatcher;
            androidx.lifecycle.LifecycleOwner lifecycleOwner = onBackPressedDispatcherOwner;
            if (fragment != null) {
                lifecycleOwner = fragment;
            }
            onBackPressedDispatcher.addCallback(lifecycleOwner, this.mOnBackPressedCallback);
        }
        if (fragment != null) {
            this.mNonConfig = fragment.mFragmentManager.getChildNonConfig(fragment);
        } else if (fragmentHostCallback instanceof androidx.lifecycle.ViewModelStoreOwner) {
            this.mNonConfig = androidx.fragment.app.FragmentManagerViewModel.getInstance(((androidx.lifecycle.ViewModelStoreOwner) fragmentHostCallback).getViewModelStore());
        } else {
            this.mNonConfig = new androidx.fragment.app.FragmentManagerViewModel(false);
        }
        this.mNonConfig.setIsStateSaved(isStateSaved());
        this.mFragmentStore.setNonConfig(this.mNonConfig);
        java.lang.Object obj = this.mHost;
        if (obj instanceof androidx.activity.result.ActivityResultRegistryOwner) {
            androidx.activity.result.ActivityResultRegistry activityResultRegistry = ((androidx.activity.result.ActivityResultRegistryOwner) obj).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR;
            } else {
                str = "";
            }
            java.lang.String str2 = "FragmentManager:" + str;
            this.mStartActivityForResult = activityResultRegistry.register(str2 + "StartActivityForResult", new androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult(), new androidx.fragment.app.FragmentManager.AnonymousClass9());
            this.mStartIntentSenderForResult = activityResultRegistry.register(str2 + "StartIntentSenderForResult", new androidx.fragment.app.FragmentManager.FragmentIntentSenderContract(), new androidx.fragment.app.FragmentManager.AnonymousClass10());
            this.mRequestPermissions = activityResultRegistry.register(str2 + "RequestPermissions", new androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions(), new androidx.fragment.app.FragmentManager.AnonymousClass11());
        }
    }

    public void attachFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        if (isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("attach: ");
            sb.append(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.mFragmentStore.addFragment(fragment);
            if (isLoggingEnabled(2)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("add from attach: ");
                sb2.append(fragment);
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction beginTransaction() {
        return new androidx.fragment.app.BackStackRecord(this);
    }

    public boolean checkForMenus() {
        boolean z = false;
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getActiveFragments()) {
            if (fragment != null) {
                z = isMenuAvailable(fragment);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResult(@androidx.annotation.NonNull java.lang.String str) {
        this.mResults.remove(str);
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResultListener(@androidx.annotation.NonNull java.lang.String str) {
        androidx.fragment.app.FragmentManager.LifecycleAwareResultListener remove = this.mResultListeners.remove(str);
        if (remove != null) {
            remove.removeObserver();
        }
    }

    public void completeExecute(@androidx.annotation.NonNull androidx.fragment.app.BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.executePopOps(z3);
        } else {
            backStackRecord.executeOps();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(java.lang.Boolean.valueOf(z));
        if (z2 && this.mCurState >= 1) {
            androidx.fragment.app.FragmentTransition.startTransitions(this.mHost.getContext(), this.mContainer, arrayList, arrayList2, 0, 1, true, this.mFragmentTransitionCallback);
        }
        if (z3) {
            moveToState(this.mCurState, true);
        }
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getActiveFragments()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && backStackRecord.interactsWith(fragment.mContainerId)) {
                float f = fragment.mPostponedAlpha;
                if (f > 0.0f) {
                    fragment.mView.setAlpha(f);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentStateManager createOrGetFragmentStateManager(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        androidx.fragment.app.FragmentStateManager fragmentStateManager = this.mFragmentStore.getFragmentStateManager(fragment.mWho);
        if (fragmentStateManager != null) {
            return fragmentStateManager;
        }
        androidx.fragment.app.FragmentStateManager fragmentStateManager2 = new androidx.fragment.app.FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragment);
        fragmentStateManager2.restoreState(this.mHost.getContext().getClassLoader());
        fragmentStateManager2.setFragmentManagerState(this.mCurState);
        return fragmentStateManager2;
    }

    public void detachFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        if (isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("detach: ");
            sb.append(fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (isLoggingEnabled(2)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("remove from detach: ");
                sb2.append(fragment);
            }
            this.mFragmentStore.removeFragment(fragment);
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            setVisibleRemovingFragment(fragment);
        }
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(4);
    }

    public void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(0);
    }

    public void dispatchConfigurationChanged(@androidx.annotation.NonNull android.content.res.Configuration configuration) {
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean dispatchContextItemSelected(@androidx.annotation.NonNull android.view.MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(1);
    }

    public boolean dispatchCreateOptionsMenu(@androidx.annotation.NonNull android.view.Menu menu, @androidx.annotation.NonNull android.view.MenuInflater menuInflater) {
        if (this.mCurState < 1) {
            return false;
        }
        java.util.ArrayList<androidx.fragment.app.Fragment> arrayList = null;
        boolean z = false;
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && isParentMenuVisible(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i = 0; i < this.mCreatedMenus.size(); i++) {
                androidx.fragment.app.Fragment fragment2 = this.mCreatedMenus.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        dispatchStateChange(-1);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            this.mOnBackPressedCallback.remove();
            this.mOnBackPressedDispatcher = null;
        }
        androidx.activity.result.ActivityResultLauncher<android.content.Intent> activityResultLauncher = this.mStartActivityForResult;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
            this.mStartIntentSenderForResult.unregister();
            this.mRequestPermissions.unregister();
        }
    }

    public void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    public void dispatchLowMemory() {
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public void dispatchOnAttachFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        java.util.Iterator<androidx.fragment.app.FragmentOnAttachListener> it = this.mOnAttachListeners.iterator();
        while (it.hasNext()) {
            it.next().onAttachFragment(this, fragment);
        }
    }

    public boolean dispatchOptionsItemSelected(@androidx.annotation.NonNull android.view.MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(@androidx.annotation.NonNull android.view.Menu menu) {
        if (this.mCurState < 1) {
            return;
        }
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public void dispatchPause() {
        dispatchStateChange(5);
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public boolean dispatchPrepareOptionsMenu(@androidx.annotation.NonNull android.view.Menu menu) {
        boolean z = false;
        if (this.mCurState < 1) {
            return false;
        }
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && isParentMenuVisible(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public void dispatchPrimaryNavigationFragmentChanged() {
        updateOnBackPressedCallbackEnabled();
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(7);
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(5);
    }

    public void dispatchStop() {
        this.mStopped = true;
        this.mNonConfig.setIsStateSaved(true);
        dispatchStateChange(4);
    }

    public void dispatchViewCreated() {
        dispatchStateChange(2);
    }

    public void dump(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor, @androidx.annotation.NonNull java.io.PrintWriter printWriter, @androidx.annotation.Nullable java.lang.String[] strArr) {
        int size;
        int size2;
        java.lang.String str2 = str + "    ";
        this.mFragmentStore.dump(str, fileDescriptor, printWriter, strArr);
        java.util.ArrayList<androidx.fragment.app.Fragment> arrayList = this.mCreatedMenus;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i = 0; i < size2; i++) {
                androidx.fragment.app.Fragment fragment = this.mCreatedMenus.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList2 = this.mBackStack;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i2 = 0; i2 < size; i2++) {
                androidx.fragment.app.BackStackRecord backStackRecord = this.mBackStack.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
        synchronized (this.mPendingActions) {
            int size3 = this.mPendingActions.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i3 = 0; i3 < size3; i3++) {
                    androidx.fragment.app.FragmentManager.OpGenerator opGenerator = this.mPendingActions.get(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(opGenerator);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
    }

    public void enqueueAction(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager.OpGenerator opGenerator, boolean z) {
        if (!z) {
            if (this.mHost == null) {
                if (!this.mDestroyed) {
                    throw new java.lang.IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new java.lang.IllegalStateException("FragmentManager has been destroyed");
            }
            checkStateLoss();
        }
        synchronized (this.mPendingActions) {
            if (this.mHost == null) {
                if (!z) {
                    throw new java.lang.IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.mPendingActions.add(opGenerator);
                scheduleCommit();
            }
        }
    }

    public boolean execPendingActions(boolean z) {
        ensureExecReady(z);
        boolean z2 = false;
        while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            z2 = true;
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return z2;
    }

    public void execSingleAction(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager.OpGenerator opGenerator, boolean z) {
        if (z && (this.mHost == null || this.mDestroyed)) {
            return;
        }
        ensureExecReady(z);
        if (opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
    }

    public boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions(true);
        forcePostponedTransactions();
        return execPendingActions;
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment findActiveFragment(@androidx.annotation.NonNull java.lang.String str) {
        return this.mFragmentStore.findActiveFragment(str);
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment findFragmentById(@androidx.annotation.IdRes int i) {
        return this.mFragmentStore.findFragmentById(i);
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment findFragmentByTag(@androidx.annotation.Nullable java.lang.String str) {
        return this.mFragmentStore.findFragmentByTag(str);
    }

    public androidx.fragment.app.Fragment findFragmentByWho(@androidx.annotation.NonNull java.lang.String str) {
        return this.mFragmentStore.findFragmentByWho(str);
    }

    public int getActiveFragmentCount() {
        return this.mFragmentStore.getActiveFragmentCount();
    }

    @androidx.annotation.NonNull
    public java.util.List<androidx.fragment.app.Fragment> getActiveFragments() {
        return this.mFragmentStore.getActiveFragments();
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentManager.BackStackEntry getBackStackEntryAt(int i) {
        return this.mBackStack.get(i);
    }

    public int getBackStackEntryCount() {
        java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList = this.mBackStack;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentContainer getContainer() {
        return this.mContainer;
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment getFragment(@androidx.annotation.NonNull android.os.Bundle bundle, @androidx.annotation.NonNull java.lang.String str) {
        java.lang.String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        androidx.fragment.app.Fragment findActiveFragment = findActiveFragment(string);
        if (findActiveFragment == null) {
            throwException(new java.lang.IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return findActiveFragment;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentFactory getFragmentFactory() {
        androidx.fragment.app.FragmentFactory fragmentFactory = this.mFragmentFactory;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        androidx.fragment.app.Fragment fragment = this.mParent;
        return fragment != null ? fragment.mFragmentManager.getFragmentFactory() : this.mHostFragmentFactory;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentStore getFragmentStore() {
        return this.mFragmentStore;
    }

    @androidx.annotation.NonNull
    public java.util.List<androidx.fragment.app.Fragment> getFragments() {
        return this.mFragmentStore.getFragments();
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentHostCallback<?> getHost() {
        return this.mHost;
    }

    @androidx.annotation.NonNull
    public android.view.LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment getParent() {
        return this.mParent;
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        androidx.fragment.app.SpecialEffectsControllerFactory specialEffectsControllerFactory = this.mSpecialEffectsControllerFactory;
        if (specialEffectsControllerFactory != null) {
            return specialEffectsControllerFactory;
        }
        androidx.fragment.app.Fragment fragment = this.mParent;
        return fragment != null ? fragment.mFragmentManager.getSpecialEffectsControllerFactory() : this.mDefaultSpecialEffectsControllerFactory;
    }

    @androidx.annotation.NonNull
    public androidx.lifecycle.ViewModelStore getViewModelStore(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        return this.mNonConfig.getViewModelStore(fragment);
    }

    public void handleOnBackPressed() {
        execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled()) {
            popBackStackImmediate();
        } else {
            this.mOnBackPressedDispatcher.onBackPressed();
        }
    }

    public void hideFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        if (isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("hide: ");
            sb.append(fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        setVisibleRemovingFragment(fragment);
    }

    public void invalidateMenuForFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.mAdded && isMenuAvailable(fragment)) {
            this.mNeedMenuInvalidate = true;
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public boolean isParentMenuVisible(@androidx.annotation.Nullable androidx.fragment.app.Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public boolean isPrimaryNavigation(@androidx.annotation.Nullable androidx.fragment.app.Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        androidx.fragment.app.FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.getPrimaryNavigationFragment()) && isPrimaryNavigation(fragmentManager.mParent);
    }

    public boolean isStateAtLeast(int i) {
        return this.mCurState >= i;
    }

    public boolean isStateSaved() {
        return this.mStateSaved || this.mStopped;
    }

    public void launchRequestPermissions(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull java.lang.String[] strArr, int i) {
        if (this.mRequestPermissions == null) {
            this.mHost.onRequestPermissionsFromFragment(fragment, strArr, i);
            return;
        }
        this.mLaunchedFragments.addLast(new androidx.fragment.app.FragmentManager.LaunchedFragmentInfo(fragment.mWho, i));
        this.mRequestPermissions.launch(strArr);
    }

    public void launchStartActivityForResult(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
        if (this.mStartActivityForResult == null) {
            this.mHost.onStartActivityFromFragment(fragment, intent, i, bundle);
            return;
        }
        this.mLaunchedFragments.addLast(new androidx.fragment.app.FragmentManager.LaunchedFragmentInfo(fragment.mWho, i));
        if (intent != null && bundle != null) {
            intent.putExtra(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundle);
        }
        this.mStartActivityForResult.launch(intent);
    }

    public void launchStartIntentSenderForResult(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @android.annotation.SuppressLint({"UnknownNullness"}) android.content.IntentSender intentSender, int i, @androidx.annotation.Nullable android.content.Intent intent, int i2, int i3, int i4, @androidx.annotation.Nullable android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
        android.content.Intent intent2;
        if (this.mStartIntentSenderForResult == null) {
            this.mHost.onStartIntentSenderFromFragment(fragment, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new android.content.Intent();
                intent2.putExtra(EXTRA_CREATED_FILLIN_INTENT, true);
            } else {
                intent2 = intent;
            }
            if (isLoggingEnabled(2)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("ActivityOptions ");
                sb.append(bundle);
                sb.append(" were added to fillInIntent ");
                sb.append(intent2);
                sb.append(" for fragment ");
                sb.append(fragment);
            }
            intent2.putExtra(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundle);
        } else {
            intent2 = intent;
        }
        androidx.activity.result.IntentSenderRequest build = new androidx.activity.result.IntentSenderRequest.Builder(intentSender).setFillInIntent(intent2).setFlags(i3, i2).build();
        this.mLaunchedFragments.addLast(new androidx.fragment.app.FragmentManager.LaunchedFragmentInfo(fragment.mWho, i));
        if (isLoggingEnabled(2)) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Fragment ");
            sb2.append(fragment);
            sb2.append("is launching an IntentSender for result ");
        }
        this.mStartIntentSenderForResult.launch(build);
    }

    public void moveFragmentToExpectedState(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        if (!this.mFragmentStore.containsActiveFragment(fragment.mWho)) {
            if (isLoggingEnabled(3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Ignoring moving ");
                sb.append(fragment);
                sb.append(" to state ");
                sb.append(this.mCurState);
                sb.append("since it is not added to ");
                sb.append(this);
                return;
            }
            return;
        }
        moveToState(fragment);
        android.view.View view = fragment.mView;
        if (view != null && fragment.mIsNewlyAdded && fragment.mContainer != null) {
            float f = fragment.mPostponedAlpha;
            if (f > 0.0f) {
                view.setAlpha(f);
            }
            fragment.mPostponedAlpha = 0.0f;
            fragment.mIsNewlyAdded = false;
            androidx.fragment.app.FragmentAnim.AnimationOrAnimator loadAnimation = androidx.fragment.app.FragmentAnim.loadAnimation(this.mHost.getContext(), fragment, true, fragment.getPopDirection());
            if (loadAnimation != null) {
                android.view.animation.Animation animation = loadAnimation.animation;
                if (animation != null) {
                    fragment.mView.startAnimation(animation);
                } else {
                    loadAnimation.animator.setTarget(fragment.mView);
                    loadAnimation.animator.start();
                }
            }
        }
        if (fragment.mHiddenChanged) {
            completeShowHideFragment(fragment);
        }
    }

    public void moveToState(int i, boolean z) {
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback;
        if (this.mHost == null && i != -1) {
            throw new java.lang.IllegalStateException("No activity");
        }
        if (z || i != this.mCurState) {
            this.mCurState = i;
            if (USE_STATE_MANAGER) {
                this.mFragmentStore.moveToExpectedState();
            } else {
                java.util.Iterator<androidx.fragment.app.Fragment> it = this.mFragmentStore.getFragments().iterator();
                while (it.hasNext()) {
                    moveFragmentToExpectedState(it.next());
                }
                for (androidx.fragment.app.FragmentStateManager fragmentStateManager : this.mFragmentStore.getActiveFragmentStateManagers()) {
                    androidx.fragment.app.Fragment fragment = fragmentStateManager.getFragment();
                    if (!fragment.mIsNewlyAdded) {
                        moveFragmentToExpectedState(fragment);
                    }
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        this.mFragmentStore.makeInactive(fragmentStateManager);
                    }
                }
            }
            startPendingDeferredFragments();
            if (this.mNeedMenuInvalidate && (fragmentHostCallback = this.mHost) != null && this.mCurState == 7) {
                fragmentHostCallback.onSupportInvalidateOptionsMenu();
                this.mNeedMenuInvalidate = false;
            }
        }
    }

    public void moveToState(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        moveToState(fragment, this.mCurState);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        if (r2 != 5) goto L102;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void moveToState(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, int i) {
        android.view.ViewGroup viewGroup;
        androidx.fragment.app.FragmentStateManager fragmentStateManager = this.mFragmentStore.getFragmentStateManager(fragment.mWho);
        int i2 = 1;
        if (fragmentStateManager == null) {
            fragmentStateManager = new androidx.fragment.app.FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragment);
            fragmentStateManager.setFragmentManagerState(1);
        }
        if (fragment.mFromLayout && fragment.mInLayout && fragment.mState == 2) {
            i = java.lang.Math.max(i, 2);
        }
        int min = java.lang.Math.min(i, fragmentStateManager.computeExpectedState());
        int i3 = fragment.mState;
        if (i3 <= min) {
            if (i3 < min && !this.mExitAnimationCancellationSignals.isEmpty()) {
                cancelExitAnimation(fragment);
            }
            int i4 = fragment.mState;
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 4) {
                            }
                            if (min > 4) {
                                fragmentStateManager.start();
                            }
                            if (min > 5) {
                                fragmentStateManager.resume();
                            }
                        }
                        if (min > 2) {
                            fragmentStateManager.activityCreated();
                        }
                        if (min > 4) {
                        }
                        if (min > 5) {
                        }
                    }
                    if (min > -1) {
                        fragmentStateManager.ensureInflatedView();
                    }
                    if (min > 1) {
                        fragmentStateManager.createView();
                    }
                    if (min > 2) {
                    }
                    if (min > 4) {
                    }
                    if (min > 5) {
                    }
                }
            } else if (min > -1) {
                fragmentStateManager.attach();
            }
            if (min > 0) {
                fragmentStateManager.create();
            }
            if (min > -1) {
            }
            if (min > 1) {
            }
            if (min > 2) {
            }
            if (min > 4) {
            }
            if (min > 5) {
            }
        } else if (i3 > min) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 == 7) {
                                    if (min < 7) {
                                        fragmentStateManager.pause();
                                    }
                                }
                            }
                            if (min < 5) {
                                fragmentStateManager.stop();
                            }
                        }
                        if (min < 4) {
                            if (isLoggingEnabled(3)) {
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append("movefrom ACTIVITY_CREATED: ");
                                sb.append(fragment);
                            }
                            if (fragment.mView != null && this.mHost.onShouldSaveFragmentState(fragment) && fragment.mSavedViewState == null) {
                                fragmentStateManager.saveViewState();
                            }
                        }
                    }
                    if (min < 2) {
                        android.view.View view = fragment.mView;
                        if (view != null && (viewGroup = fragment.mContainer) != null) {
                            viewGroup.endViewTransition(view);
                            fragment.mView.clearAnimation();
                            if (!fragment.isRemovingParent()) {
                                androidx.fragment.app.FragmentAnim.AnimationOrAnimator loadAnimation = (this.mCurState <= -1 || this.mDestroyed || fragment.mView.getVisibility() != 0 || fragment.mPostponedAlpha < 0.0f) ? null : androidx.fragment.app.FragmentAnim.loadAnimation(this.mHost.getContext(), fragment, false, fragment.getPopDirection());
                                fragment.mPostponedAlpha = 0.0f;
                                android.view.ViewGroup viewGroup2 = fragment.mContainer;
                                android.view.View view2 = fragment.mView;
                                if (loadAnimation != null) {
                                    androidx.fragment.app.FragmentAnim.animateRemoveFragment(fragment, loadAnimation, this.mFragmentTransitionCallback);
                                }
                                viewGroup2.removeView(view2);
                                if (isLoggingEnabled(2)) {
                                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                    sb2.append("Removing view ");
                                    sb2.append(view2);
                                    sb2.append(" for fragment ");
                                    sb2.append(fragment);
                                    sb2.append(" from container ");
                                    sb2.append(viewGroup2);
                                }
                                if (viewGroup2 != fragment.mContainer) {
                                    return;
                                }
                            }
                        }
                        if (this.mExitAnimationCancellationSignals.get(fragment) == null) {
                            fragmentStateManager.destroyFragmentView();
                        }
                    }
                }
                if (min < 1) {
                    if (this.mExitAnimationCancellationSignals.get(fragment) == null) {
                        fragmentStateManager.destroy();
                    }
                    if (i2 < 0) {
                        fragmentStateManager.detach();
                    }
                    min = i2;
                }
            }
            i2 = min;
            if (i2 < 0) {
            }
            min = i2;
        }
        if (fragment.mState != min) {
            if (isLoggingEnabled(3)) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("moveToState: Fragment state for ");
                sb3.append(fragment);
                sb3.append(" not updated inline; expected state ");
                sb3.append(min);
                sb3.append(" found ");
                sb3.append(fragment.mState);
            }
            fragment.mState = min;
        }
    }

    public void noteStateNotSaved() {
        if (this.mHost == null) {
            return;
        }
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        for (androidx.fragment.app.Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public void onContainerAvailable(@androidx.annotation.NonNull androidx.fragment.app.FragmentContainerView fragmentContainerView) {
        android.view.View view;
        for (androidx.fragment.app.FragmentStateManager fragmentStateManager : this.mFragmentStore.getActiveFragmentStateManagers()) {
            androidx.fragment.app.Fragment fragment = fragmentStateManager.getFragment();
            if (fragment.mContainerId == fragmentContainerView.getId() && (view = fragment.mView) != null && view.getParent() == null) {
                fragment.mContainer = fragmentContainerView;
                fragmentStateManager.addViewToContainer();
            }
        }
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public androidx.fragment.app.FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public void performPendingDeferredStart(@androidx.annotation.NonNull androidx.fragment.app.FragmentStateManager fragmentStateManager) {
        androidx.fragment.app.Fragment fragment = fragmentStateManager.getFragment();
        if (fragment.mDeferStart) {
            if (this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
                return;
            }
            fragment.mDeferStart = false;
            if (USE_STATE_MANAGER) {
                fragmentStateManager.moveToExpectedState();
            } else {
                moveToState(fragment);
            }
        }
    }

    public void popBackStack() {
        enqueueAction(new androidx.fragment.app.FragmentManager.PopBackStackState(null, -1, 0), false);
    }

    public void popBackStack(int i, int i2) {
        if (i >= 0) {
            enqueueAction(new androidx.fragment.app.FragmentManager.PopBackStackState(null, i, i2), false);
            return;
        }
        throw new java.lang.IllegalArgumentException("Bad id: " + i);
    }

    public void popBackStack(@androidx.annotation.Nullable java.lang.String str, int i) {
        enqueueAction(new androidx.fragment.app.FragmentManager.PopBackStackState(str, -1, i), false);
    }

    public boolean popBackStackImmediate() {
        return popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackImmediate(int i, int i2) {
        if (i >= 0) {
            return popBackStackImmediate(null, i, i2);
        }
        throw new java.lang.IllegalArgumentException("Bad id: " + i);
    }

    public boolean popBackStackImmediate(@androidx.annotation.Nullable java.lang.String str, int i) {
        return popBackStackImmediate(str, -1, i);
    }

    public boolean popBackStackState(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList, @androidx.annotation.NonNull java.util.ArrayList<java.lang.Boolean> arrayList2, @androidx.annotation.Nullable java.lang.String str, int i, int i2) {
        int i3;
        java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList3 = this.mBackStack;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.mBackStack.remove(size));
            arrayList2.add(java.lang.Boolean.TRUE);
        } else {
            if (str != null || i >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.BackStackRecord backStackRecord = this.mBackStack.get(size2);
                    if ((str != null && str.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.mIndex)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.BackStackRecord backStackRecord2 = this.mBackStack.get(size2);
                        if (str == null || !str.equals(backStackRecord2.getName())) {
                            if (i < 0 || i != backStackRecord2.mIndex) {
                                break;
                            }
                        }
                    }
                }
                i3 = size2;
            } else {
                i3 = -1;
            }
            if (i3 == this.mBackStack.size() - 1) {
                return false;
            }
            for (int size3 = this.mBackStack.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.mBackStack.remove(size3));
                arrayList2.add(java.lang.Boolean.TRUE);
            }
        }
        return true;
    }

    public void putFragment(@androidx.annotation.NonNull android.os.Bundle bundle, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            throwException(new java.lang.IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public void registerFragmentLifecycleCallbacks(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, z);
    }

    public void removeCancellationSignal(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal) {
        java.util.HashSet<androidx.core.os.CancellationSignal> hashSet = this.mExitAnimationCancellationSignals.get(fragment);
        if (hashSet != null && hashSet.remove(cancellationSignal) && hashSet.isEmpty()) {
            this.mExitAnimationCancellationSignals.remove(fragment);
            if (fragment.mState < 5) {
                destroyFragmentView(fragment);
                moveToState(fragment);
            }
        }
    }

    public void removeFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        if (isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("remove: ");
            sb.append(fragment);
            sb.append(" nesting=");
            sb.append(fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            this.mFragmentStore.removeFragment(fragment);
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mRemoving = true;
            setVisibleRemovingFragment(fragment);
        }
    }

    public void removeFragmentOnAttachListener(@androidx.annotation.NonNull androidx.fragment.app.FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.remove(fragmentOnAttachListener);
    }

    public void removeOnBackStackChangedListener(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        java.util.ArrayList<androidx.fragment.app.FragmentManager.OnBackStackChangedListener> arrayList = this.mBackStackChangeListeners;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    public void removeRetainedFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        this.mNonConfig.removeRetainedFragment(fragment);
    }

    public void restoreAllState(@androidx.annotation.Nullable android.os.Parcelable parcelable, @androidx.annotation.Nullable androidx.fragment.app.FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (this.mHost instanceof androidx.lifecycle.ViewModelStoreOwner) {
            throwException(new java.lang.IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.mNonConfig.restoreFromSnapshot(fragmentManagerNonConfig);
        restoreSaveState(parcelable);
    }

    public void restoreSaveState(@androidx.annotation.Nullable android.os.Parcelable parcelable) {
        androidx.fragment.app.FragmentStateManager fragmentStateManager;
        if (parcelable == null) {
            return;
        }
        androidx.fragment.app.FragmentManagerState fragmentManagerState = (androidx.fragment.app.FragmentManagerState) parcelable;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        this.mFragmentStore.resetActiveFragments();
        java.util.Iterator<androidx.fragment.app.FragmentState> it = fragmentManagerState.mActive.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.FragmentState next = it.next();
            if (next != null) {
                androidx.fragment.app.Fragment findRetainedFragmentByWho = this.mNonConfig.findRetainedFragmentByWho(next.mWho);
                if (findRetainedFragmentByWho != null) {
                    if (isLoggingEnabled(2)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("restoreSaveState: re-attaching retained ");
                        sb.append(findRetainedFragmentByWho);
                    }
                    fragmentStateManager = new androidx.fragment.app.FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, findRetainedFragmentByWho, next);
                } else {
                    fragmentStateManager = new androidx.fragment.app.FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.getContext().getClassLoader(), getFragmentFactory(), next);
                }
                androidx.fragment.app.Fragment fragment = fragmentStateManager.getFragment();
                fragment.mFragmentManager = this;
                if (isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("restoreSaveState: active (");
                    sb2.append(fragment.mWho);
                    sb2.append("): ");
                    sb2.append(fragment);
                }
                fragmentStateManager.restoreState(this.mHost.getContext().getClassLoader());
                this.mFragmentStore.makeActive(fragmentStateManager);
                fragmentStateManager.setFragmentManagerState(this.mCurState);
            }
        }
        for (androidx.fragment.app.Fragment fragment2 : this.mNonConfig.getRetainedFragments()) {
            if (!this.mFragmentStore.containsActiveFragment(fragment2.mWho)) {
                if (isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append("Discarding retained Fragment ");
                    sb3.append(fragment2);
                    sb3.append(" that was not found in the set of active Fragments ");
                    sb3.append(fragmentManagerState.mActive);
                }
                this.mNonConfig.removeRetainedFragment(fragment2);
                fragment2.mFragmentManager = this;
                androidx.fragment.app.FragmentStateManager fragmentStateManager2 = new androidx.fragment.app.FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragment2);
                fragmentStateManager2.setFragmentManagerState(1);
                fragmentStateManager2.moveToExpectedState();
                fragment2.mRemoving = true;
                fragmentStateManager2.moveToExpectedState();
            }
        }
        this.mFragmentStore.restoreAddedFragments(fragmentManagerState.mAdded);
        if (fragmentManagerState.mBackStack != null) {
            this.mBackStack = new java.util.ArrayList<>(fragmentManagerState.mBackStack.length);
            int i = 0;
            while (true) {
                androidx.fragment.app.BackStackState[] backStackStateArr = fragmentManagerState.mBackStack;
                if (i >= backStackStateArr.length) {
                    break;
                }
                androidx.fragment.app.BackStackRecord instantiate = backStackStateArr[i].instantiate(this);
                if (isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                    sb4.append("restoreAllState: back stack #");
                    sb4.append(i);
                    sb4.append(" (index ");
                    sb4.append(instantiate.mIndex);
                    sb4.append("): ");
                    sb4.append(instantiate);
                    java.io.PrintWriter printWriter = new java.io.PrintWriter(new androidx.fragment.app.LogWriter(TAG));
                    instantiate.dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.mBackStack.add(instantiate);
                i++;
            }
        } else {
            this.mBackStack = null;
        }
        this.mBackStackIndex.set(fragmentManagerState.mBackStackIndex);
        java.lang.String str = fragmentManagerState.mPrimaryNavActiveWho;
        if (str != null) {
            androidx.fragment.app.Fragment findActiveFragment = findActiveFragment(str);
            this.mPrimaryNav = findActiveFragment;
            dispatchParentPrimaryNavigationFragmentChanged(findActiveFragment);
        }
        java.util.ArrayList<java.lang.String> arrayList = fragmentManagerState.mResultKeys;
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                android.os.Bundle bundle = fragmentManagerState.mResults.get(i2);
                bundle.setClassLoader(this.mHost.getContext().getClassLoader());
                this.mResults.put(arrayList.get(i2), bundle);
            }
        }
        this.mLaunchedFragments = new java.util.ArrayDeque<>(fragmentManagerState.mLaunchedFragments);
    }

    @java.lang.Deprecated
    public androidx.fragment.app.FragmentManagerNonConfig retainNonConfig() {
        if (this.mHost instanceof androidx.lifecycle.ViewModelStoreOwner) {
            throwException(new java.lang.IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.mNonConfig.getSnapshot();
    }

    public android.os.Parcelable saveAllState() {
        int size;
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.setIsStateSaved(true);
        java.util.ArrayList<androidx.fragment.app.FragmentState> saveActiveFragments = this.mFragmentStore.saveActiveFragments();
        androidx.fragment.app.BackStackState[] backStackStateArr = null;
        if (saveActiveFragments.isEmpty()) {
            isLoggingEnabled(2);
            return null;
        }
        java.util.ArrayList<java.lang.String> saveAddedFragments = this.mFragmentStore.saveAddedFragments();
        java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList = this.mBackStack;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new androidx.fragment.app.BackStackState[size];
            for (int i = 0; i < size; i++) {
                backStackStateArr[i] = new androidx.fragment.app.BackStackState(this.mBackStack.get(i));
                if (isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("saveAllState: adding back stack #");
                    sb.append(i);
                    sb.append(": ");
                    sb.append(this.mBackStack.get(i));
                }
            }
        }
        androidx.fragment.app.FragmentManagerState fragmentManagerState = new androidx.fragment.app.FragmentManagerState();
        fragmentManagerState.mActive = saveActiveFragments;
        fragmentManagerState.mAdded = saveAddedFragments;
        fragmentManagerState.mBackStack = backStackStateArr;
        fragmentManagerState.mBackStackIndex = this.mBackStackIndex.get();
        androidx.fragment.app.Fragment fragment = this.mPrimaryNav;
        if (fragment != null) {
            fragmentManagerState.mPrimaryNavActiveWho = fragment.mWho;
        }
        fragmentManagerState.mResultKeys.addAll(this.mResults.keySet());
        fragmentManagerState.mResults.addAll(this.mResults.values());
        fragmentManagerState.mLaunchedFragments = new java.util.ArrayList<>(this.mLaunchedFragments);
        return fragmentManagerState;
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment.SavedState saveFragmentInstanceState(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        androidx.fragment.app.FragmentStateManager fragmentStateManager = this.mFragmentStore.getFragmentStateManager(fragment.mWho);
        if (fragmentStateManager == null || !fragmentStateManager.getFragment().equals(fragment)) {
            throwException(new java.lang.IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return fragmentStateManager.saveInstanceState();
    }

    public void scheduleCommit() {
        synchronized (this.mPendingActions) {
            java.util.ArrayList<androidx.fragment.app.FragmentManager.StartEnterTransitionListener> arrayList = this.mPostponedTransactions;
            boolean z = (arrayList == null || arrayList.isEmpty()) ? false : true;
            boolean z2 = this.mPendingActions.size() == 1;
            if (z || z2) {
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                this.mHost.getHandler().post(this.mExecCommit);
                updateOnBackPressedCallbackEnabled();
            }
        }
    }

    public void setExitAnimationOrder(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, boolean z) {
        android.view.ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer == null || !(fragmentContainer instanceof androidx.fragment.app.FragmentContainerView)) {
            return;
        }
        ((androidx.fragment.app.FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z);
    }

    public void setFragmentFactory(@androidx.annotation.NonNull androidx.fragment.app.FragmentFactory fragmentFactory) {
        this.mFragmentFactory = fragmentFactory;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResult(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.os.Bundle bundle) {
        androidx.fragment.app.FragmentManager.LifecycleAwareResultListener lifecycleAwareResultListener = this.mResultListeners.get(str);
        if (lifecycleAwareResultListener == null || !lifecycleAwareResultListener.isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)) {
            this.mResults.put(str, bundle);
        } else {
            lifecycleAwareResultListener.onFragmentResult(str, bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    public final void setFragmentResultListener(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.fragment.app.FragmentResultListener fragmentResultListener) {
        androidx.lifecycle.Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() == androidx.lifecycle.Lifecycle.State.DESTROYED) {
            return;
        }
        androidx.fragment.app.FragmentManager.AnonymousClass6 anonymousClass6 = new androidx.fragment.app.FragmentManager.AnonymousClass6(str, fragmentResultListener, lifecycle);
        lifecycle.addObserver(anonymousClass6);
        androidx.fragment.app.FragmentManager.LifecycleAwareResultListener put = this.mResultListeners.put(str, new androidx.fragment.app.FragmentManager.LifecycleAwareResultListener(lifecycle, fragmentResultListener, anonymousClass6));
        if (put != null) {
            put.removeObserver();
        }
    }

    public void setMaxLifecycle(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.State state) {
        if (fragment.equals(findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new java.lang.IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void setPrimaryNavigationFragment(@androidx.annotation.Nullable androidx.fragment.app.Fragment fragment) {
        if (fragment == null || (fragment.equals(findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            androidx.fragment.app.Fragment fragment2 = this.mPrimaryNav;
            this.mPrimaryNav = fragment;
            dispatchParentPrimaryNavigationFragmentChanged(fragment2);
            dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
            return;
        }
        throw new java.lang.IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void setSpecialEffectsControllerFactory(@androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        this.mSpecialEffectsControllerFactory = specialEffectsControllerFactory;
    }

    public void showFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        if (isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("show: ");
            sb.append(fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        sb.append(" in ");
        androidx.fragment.app.Fragment fragment = this.mParent;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this.mParent)));
            sb.append(com.alipay.sdk.m.u.i.d);
        } else {
            androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this.mHost)));
                sb.append(com.alipay.sdk.m.u.i.d);
            } else {
                sb.append(com.igexin.push.core.b.m);
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public void unregisterFragmentLifecycleCallbacks(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallbacks);
    }
}
