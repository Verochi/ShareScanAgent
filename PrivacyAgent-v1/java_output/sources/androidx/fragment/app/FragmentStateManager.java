package androidx.fragment.app;

/* loaded from: classes.dex */
class FragmentStateManager {
    private static final java.lang.String TAG = "FragmentManager";
    private static final java.lang.String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    private static final java.lang.String TARGET_STATE_TAG = "android:target_state";
    private static final java.lang.String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    private static final java.lang.String VIEW_REGISTRY_STATE_TAG = "android:view_registry_state";
    private static final java.lang.String VIEW_STATE_TAG = "android:view_state";
    private final androidx.fragment.app.FragmentLifecycleCallbacksDispatcher mDispatcher;

    @androidx.annotation.NonNull
    private final androidx.fragment.app.Fragment mFragment;
    private final androidx.fragment.app.FragmentStore mFragmentStore;
    private boolean mMovingToState = false;
    private int mFragmentManagerState = -1;

    /* renamed from: androidx.fragment.app.FragmentStateManager$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnAttachStateChangeListener {
        final /* synthetic */ android.view.View val$fragmentView;

        public AnonymousClass1(android.view.View view) {
            this.val$fragmentView = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
            this.val$fragmentView.removeOnAttachStateChangeListener(this);
            androidx.core.view.ViewCompat.requestApplyInsets(this.val$fragmentView);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
        }
    }

    /* renamed from: androidx.fragment.app.FragmentStateManager$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        static {
            int[] iArr = new int[androidx.lifecycle.Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr;
            try {
                iArr[androidx.lifecycle.Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[androidx.lifecycle.Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[androidx.lifecycle.Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[androidx.lifecycle.Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public FragmentStateManager(@androidx.annotation.NonNull androidx.fragment.app.FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @androidx.annotation.NonNull androidx.fragment.app.FragmentStore fragmentStore, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
    }

    public FragmentStateManager(@androidx.annotation.NonNull androidx.fragment.app.FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @androidx.annotation.NonNull androidx.fragment.app.FragmentStore fragmentStore, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull androidx.fragment.app.FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        androidx.fragment.app.Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        android.os.Bundle bundle = fragmentState.mSavedFragmentState;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new android.os.Bundle();
        }
    }

    public FragmentStateManager(@androidx.annotation.NonNull androidx.fragment.app.FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @androidx.annotation.NonNull androidx.fragment.app.FragmentStore fragmentStore, @androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull androidx.fragment.app.FragmentFactory fragmentFactory, @androidx.annotation.NonNull androidx.fragment.app.FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        androidx.fragment.app.Fragment instantiate = fragmentFactory.instantiate(classLoader, fragmentState.mClassName);
        this.mFragment = instantiate;
        android.os.Bundle bundle = fragmentState.mArguments;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        instantiate.setArguments(fragmentState.mArguments);
        instantiate.mWho = fragmentState.mWho;
        instantiate.mFromLayout = fragmentState.mFromLayout;
        instantiate.mRestored = true;
        instantiate.mFragmentId = fragmentState.mFragmentId;
        instantiate.mContainerId = fragmentState.mContainerId;
        instantiate.mTag = fragmentState.mTag;
        instantiate.mRetainInstance = fragmentState.mRetainInstance;
        instantiate.mRemoving = fragmentState.mRemoving;
        instantiate.mDetached = fragmentState.mDetached;
        instantiate.mHidden = fragmentState.mHidden;
        instantiate.mMaxState = androidx.lifecycle.Lifecycle.State.values()[fragmentState.mMaxLifecycleState];
        android.os.Bundle bundle2 = fragmentState.mSavedFragmentState;
        if (bundle2 != null) {
            instantiate.mSavedFragmentState = bundle2;
        } else {
            instantiate.mSavedFragmentState = new android.os.Bundle();
        }
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Instantiated fragment ");
            sb.append(instantiate);
        }
    }

    private boolean isFragmentViewChild(@androidx.annotation.NonNull android.view.View view) {
        if (view == this.mFragment.mView) {
            return true;
        }
        for (android.view.ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.mFragment.mView) {
                return true;
            }
        }
        return false;
    }

    private android.os.Bundle saveBasicState() {
        android.os.Bundle bundle = new android.os.Bundle();
        this.mFragment.performSaveInstanceState(bundle);
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.mFragment.mView != null) {
            saveViewState();
        }
        if (this.mFragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new android.os.Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, this.mFragment.mSavedViewState);
        }
        if (this.mFragment.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new android.os.Bundle();
            }
            bundle.putBundle(VIEW_REGISTRY_STATE_TAG, this.mFragment.mSavedViewRegistryState);
        }
        if (!this.mFragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new android.os.Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, this.mFragment.mUserVisibleHint);
        }
        return bundle;
    }

    public void activityCreated() {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("moveto ACTIVITY_CREATED: ");
            sb.append(this.mFragment);
        }
        androidx.fragment.app.Fragment fragment = this.mFragment;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        androidx.fragment.app.FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
        androidx.fragment.app.Fragment fragment2 = this.mFragment;
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentActivityCreated(fragment2, fragment2.mSavedFragmentState, false);
    }

    public void addViewToContainer() {
        int findFragmentIndexInContainer = this.mFragmentStore.findFragmentIndexInContainer(this.mFragment);
        androidx.fragment.app.Fragment fragment = this.mFragment;
        fragment.mContainer.addView(fragment.mView, findFragmentIndexInContainer);
    }

    public void attach() {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("moveto ATTACHED: ");
            sb.append(this.mFragment);
        }
        androidx.fragment.app.Fragment fragment = this.mFragment;
        androidx.fragment.app.Fragment fragment2 = fragment.mTarget;
        androidx.fragment.app.FragmentStateManager fragmentStateManager = null;
        if (fragment2 != null) {
            androidx.fragment.app.FragmentStateManager fragmentStateManager2 = this.mFragmentStore.getFragmentStateManager(fragment2.mWho);
            if (fragmentStateManager2 == null) {
                throw new java.lang.IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTarget + " that does not belong to this FragmentManager!");
            }
            androidx.fragment.app.Fragment fragment3 = this.mFragment;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            fragmentStateManager = fragmentStateManager2;
        } else {
            java.lang.String str = fragment.mTargetWho;
            if (str != null && (fragmentStateManager = this.mFragmentStore.getFragmentStateManager(str)) == null) {
                throw new java.lang.IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (fragmentStateManager != null && (androidx.fragment.app.FragmentManager.USE_STATE_MANAGER || fragmentStateManager.getFragment().mState < 1)) {
            fragmentStateManager.moveToExpectedState();
        }
        androidx.fragment.app.Fragment fragment4 = this.mFragment;
        fragment4.mHost = fragment4.mFragmentManager.getHost();
        androidx.fragment.app.Fragment fragment5 = this.mFragment;
        fragment5.mParentFragment = fragment5.mFragmentManager.getParent();
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, false);
        this.mFragment.performAttach();
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, false);
    }

    public int computeExpectedState() {
        androidx.fragment.app.Fragment fragment;
        android.view.ViewGroup viewGroup;
        androidx.fragment.app.Fragment fragment2 = this.mFragment;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i = this.mFragmentManagerState;
        int i2 = androidx.fragment.app.FragmentStateManager.AnonymousClass2.$SwitchMap$androidx$lifecycle$Lifecycle$State[fragment2.mMaxState.ordinal()];
        if (i2 != 1) {
            i = i2 != 2 ? i2 != 3 ? i2 != 4 ? java.lang.Math.min(i, -1) : java.lang.Math.min(i, 0) : java.lang.Math.min(i, 1) : java.lang.Math.min(i, 5);
        }
        androidx.fragment.app.Fragment fragment3 = this.mFragment;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i = java.lang.Math.max(this.mFragmentManagerState, 2);
                android.view.View view = this.mFragment.mView;
                if (view != null && view.getParent() == null) {
                    i = java.lang.Math.min(i, 2);
                }
            } else {
                i = this.mFragmentManagerState < 4 ? java.lang.Math.min(i, fragment3.mState) : java.lang.Math.min(i, 1);
            }
        }
        if (!this.mFragment.mAdded) {
            i = java.lang.Math.min(i, 1);
        }
        androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact awaitingCompletionLifecycleImpact = (!androidx.fragment.app.FragmentManager.USE_STATE_MANAGER || (viewGroup = (fragment = this.mFragment).mContainer) == null) ? null : androidx.fragment.app.SpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager()).getAwaitingCompletionLifecycleImpact(this);
        if (awaitingCompletionLifecycleImpact == androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i = java.lang.Math.min(i, 6);
        } else if (awaitingCompletionLifecycleImpact == androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i = java.lang.Math.max(i, 3);
        } else {
            androidx.fragment.app.Fragment fragment4 = this.mFragment;
            if (fragment4.mRemoving) {
                i = fragment4.isInBackStack() ? java.lang.Math.min(i, 1) : java.lang.Math.min(i, -1);
            }
        }
        androidx.fragment.app.Fragment fragment5 = this.mFragment;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i = java.lang.Math.min(i, 4);
        }
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("computeExpectedState() of ");
            sb.append(i);
            sb.append(" for ");
            sb.append(this.mFragment);
        }
        return i;
    }

    public void create() {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("moveto CREATED: ");
            sb.append(this.mFragment);
        }
        androidx.fragment.app.Fragment fragment = this.mFragment;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.mFragment.mState = 1;
            return;
        }
        this.mDispatcher.dispatchOnFragmentPreCreated(fragment, fragment.mSavedFragmentState, false);
        androidx.fragment.app.Fragment fragment2 = this.mFragment;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        androidx.fragment.app.FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
        androidx.fragment.app.Fragment fragment3 = this.mFragment;
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(fragment3, fragment3.mSavedFragmentState, false);
    }

    public void createView() {
        java.lang.String str;
        if (this.mFragment.mFromLayout) {
            return;
        }
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("moveto CREATE_VIEW: ");
            sb.append(this.mFragment);
        }
        androidx.fragment.app.Fragment fragment = this.mFragment;
        android.view.LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        androidx.fragment.app.Fragment fragment2 = this.mFragment;
        android.view.ViewGroup viewGroup = fragment2.mContainer;
        if (viewGroup == null) {
            int i = fragment2.mContainerId;
            if (i == 0) {
                viewGroup = null;
            } else {
                if (i == -1) {
                    throw new java.lang.IllegalArgumentException("Cannot create fragment " + this.mFragment + " for a container view with no id");
                }
                viewGroup = (android.view.ViewGroup) fragment2.mFragmentManager.getContainer().onFindViewById(this.mFragment.mContainerId);
                if (viewGroup == null) {
                    androidx.fragment.app.Fragment fragment3 = this.mFragment;
                    if (!fragment3.mRestored) {
                        try {
                            str = fragment3.getResources().getResourceName(this.mFragment.mContainerId);
                        } catch (android.content.res.Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new java.lang.IllegalArgumentException("No view found for id 0x" + java.lang.Integer.toHexString(this.mFragment.mContainerId) + " (" + str + ") for fragment " + this.mFragment);
                    }
                }
            }
        }
        androidx.fragment.app.Fragment fragment4 = this.mFragment;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        android.view.View view = this.mFragment.mView;
        if (view != null) {
            boolean z = false;
            view.setSaveFromParentEnabled(false);
            androidx.fragment.app.Fragment fragment5 = this.mFragment;
            fragment5.mView.setTag(androidx.fragment.R.id.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                addViewToContainer();
            }
            androidx.fragment.app.Fragment fragment6 = this.mFragment;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (androidx.core.view.ViewCompat.isAttachedToWindow(this.mFragment.mView)) {
                androidx.core.view.ViewCompat.requestApplyInsets(this.mFragment.mView);
            } else {
                android.view.View view2 = this.mFragment.mView;
                view2.addOnAttachStateChangeListener(new androidx.fragment.app.FragmentStateManager.AnonymousClass1(view2));
            }
            this.mFragment.performViewCreated();
            androidx.fragment.app.FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
            androidx.fragment.app.Fragment fragment7 = this.mFragment;
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.mFragment.mView.getVisibility();
            float alpha = this.mFragment.mView.getAlpha();
            if (androidx.fragment.app.FragmentManager.USE_STATE_MANAGER) {
                this.mFragment.setPostOnViewCreatedAlpha(alpha);
                androidx.fragment.app.Fragment fragment8 = this.mFragment;
                if (fragment8.mContainer != null && visibility == 0) {
                    android.view.View findFocus = fragment8.mView.findFocus();
                    if (findFocus != null) {
                        this.mFragment.setFocusedView(findFocus);
                        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                            sb2.append("requestFocus: Saved focused view ");
                            sb2.append(findFocus);
                            sb2.append(" for Fragment ");
                            sb2.append(this.mFragment);
                        }
                    }
                    this.mFragment.mView.setAlpha(0.0f);
                }
            } else {
                androidx.fragment.app.Fragment fragment9 = this.mFragment;
                if (visibility == 0 && fragment9.mContainer != null) {
                    z = true;
                }
                fragment9.mIsNewlyAdded = z;
            }
        }
        this.mFragment.mState = 2;
    }

    public void destroy() {
        androidx.fragment.app.Fragment findActiveFragment;
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("movefrom CREATED: ");
            sb.append(this.mFragment);
        }
        androidx.fragment.app.Fragment fragment = this.mFragment;
        boolean z = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (!(z2 || this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment))) {
            java.lang.String str = this.mFragment.mTargetWho;
            if (str != null && (findActiveFragment = this.mFragmentStore.findActiveFragment(str)) != null && findActiveFragment.mRetainInstance) {
                this.mFragment.mTarget = findActiveFragment;
            }
            this.mFragment.mState = 0;
            return;
        }
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mFragment.mHost;
        if (fragmentHostCallback instanceof androidx.lifecycle.ViewModelStoreOwner) {
            z = this.mFragmentStore.getNonConfig().isCleared();
        } else if (fragmentHostCallback.getContext() instanceof android.app.Activity) {
            z = true ^ ((android.app.Activity) fragmentHostCallback.getContext()).isChangingConfigurations();
        }
        if (z2 || z) {
            this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment);
        }
        this.mFragment.performDestroy();
        this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
        for (androidx.fragment.app.FragmentStateManager fragmentStateManager : this.mFragmentStore.getActiveFragmentStateManagers()) {
            if (fragmentStateManager != null) {
                androidx.fragment.app.Fragment fragment2 = fragmentStateManager.getFragment();
                if (this.mFragment.mWho.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = this.mFragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        androidx.fragment.app.Fragment fragment3 = this.mFragment;
        java.lang.String str2 = fragment3.mTargetWho;
        if (str2 != null) {
            fragment3.mTarget = this.mFragmentStore.findActiveFragment(str2);
        }
        this.mFragmentStore.makeInactive(this);
    }

    public void destroyFragmentView() {
        android.view.View view;
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("movefrom CREATE_VIEW: ");
            sb.append(this.mFragment);
        }
        androidx.fragment.app.Fragment fragment = this.mFragment;
        android.view.ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.mFragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(this.mFragment, false);
        androidx.fragment.app.Fragment fragment2 = this.mFragment;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.setValue(null);
        this.mFragment.mInLayout = false;
    }

    public void detach() {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("movefrom ATTACHED: ");
            sb.append(this.mFragment);
        }
        this.mFragment.performDetach();
        boolean z = false;
        this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
        androidx.fragment.app.Fragment fragment = this.mFragment;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z = true;
        }
        if (z || this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment)) {
            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("initState called for fragment: ");
                sb2.append(this.mFragment);
            }
            this.mFragment.initState();
        }
    }

    public void ensureInflatedView() {
        androidx.fragment.app.Fragment fragment = this.mFragment;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("moveto CREATE_VIEW: ");
                sb.append(this.mFragment);
            }
            androidx.fragment.app.Fragment fragment2 = this.mFragment;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.mFragment.mSavedFragmentState);
            android.view.View view = this.mFragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                androidx.fragment.app.Fragment fragment3 = this.mFragment;
                fragment3.mView.setTag(androidx.fragment.R.id.fragment_container_view_tag, fragment3);
                androidx.fragment.app.Fragment fragment4 = this.mFragment;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.mFragment.performViewCreated();
                androidx.fragment.app.FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
                androidx.fragment.app.Fragment fragment5 = this.mFragment;
                fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.mFragment.mState = 2;
            }
        }
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.Fragment getFragment() {
        return this.mFragment;
    }

    public void moveToExpectedState() {
        android.view.ViewGroup viewGroup;
        android.view.ViewGroup viewGroup2;
        android.view.ViewGroup viewGroup3;
        if (this.mMovingToState) {
            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Ignoring re-entrant call to moveToExpectedState() for ");
                sb.append(getFragment());
                return;
            }
            return;
        }
        try {
            this.mMovingToState = true;
            while (true) {
                int computeExpectedState = computeExpectedState();
                androidx.fragment.app.Fragment fragment = this.mFragment;
                int i = fragment.mState;
                if (computeExpectedState == i) {
                    if (androidx.fragment.app.FragmentManager.USE_STATE_MANAGER && fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            androidx.fragment.app.SpecialEffectsController orCreateController = androidx.fragment.app.SpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager());
                            if (this.mFragment.mHidden) {
                                orCreateController.enqueueHide(this);
                            } else {
                                orCreateController.enqueueShow(this);
                            }
                        }
                        androidx.fragment.app.Fragment fragment2 = this.mFragment;
                        androidx.fragment.app.FragmentManager fragmentManager = fragment2.mFragmentManager;
                        if (fragmentManager != null) {
                            fragmentManager.invalidateMenuForFragment(fragment2);
                        }
                        androidx.fragment.app.Fragment fragment3 = this.mFragment;
                        fragment3.mHiddenChanged = false;
                        fragment3.onHiddenChanged(fragment3.mHidden);
                    }
                    return;
                }
                if (computeExpectedState <= i) {
                    switch (i - 1) {
                        case -1:
                            detach();
                            break;
                        case 0:
                            destroy();
                            break;
                        case 1:
                            destroyFragmentView();
                            this.mFragment.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
                                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                sb2.append("movefrom ACTIVITY_CREATED: ");
                                sb2.append(this.mFragment);
                            }
                            androidx.fragment.app.Fragment fragment4 = this.mFragment;
                            if (fragment4.mView != null && fragment4.mSavedViewState == null) {
                                saveViewState();
                            }
                            androidx.fragment.app.Fragment fragment5 = this.mFragment;
                            if (fragment5.mView != null && (viewGroup3 = fragment5.mContainer) != null) {
                                androidx.fragment.app.SpecialEffectsController.getOrCreateController(viewGroup3, fragment5.getParentFragmentManager()).enqueueRemove(this);
                            }
                            this.mFragment.mState = 3;
                            break;
                        case 4:
                            stop();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            pause();
                            break;
                    }
                } else {
                    switch (i + 1) {
                        case 0:
                            attach();
                            break;
                        case 1:
                            create();
                            break;
                        case 2:
                            ensureInflatedView();
                            createView();
                            break;
                        case 3:
                            activityCreated();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                androidx.fragment.app.SpecialEffectsController.getOrCreateController(viewGroup2, fragment.getParentFragmentManager()).enqueueAdd(androidx.fragment.app.SpecialEffectsController.Operation.State.from(this.mFragment.mView.getVisibility()), this);
                            }
                            this.mFragment.mState = 4;
                            break;
                        case 5:
                            start();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            resume();
                            break;
                    }
                }
            }
        } finally {
            this.mMovingToState = false;
        }
    }

    public void pause() {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("movefrom RESUMED: ");
            sb.append(this.mFragment);
        }
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    public void restoreState(@androidx.annotation.NonNull java.lang.ClassLoader classLoader) {
        android.os.Bundle bundle = this.mFragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        androidx.fragment.app.Fragment fragment = this.mFragment;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
        androidx.fragment.app.Fragment fragment2 = this.mFragment;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle(VIEW_REGISTRY_STATE_TAG);
        androidx.fragment.app.Fragment fragment3 = this.mFragment;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString(TARGET_STATE_TAG);
        androidx.fragment.app.Fragment fragment4 = this.mFragment;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
        }
        androidx.fragment.app.Fragment fragment5 = this.mFragment;
        java.lang.Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.mFragment.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
        }
        androidx.fragment.app.Fragment fragment6 = this.mFragment;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    public void resume() {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("moveto RESUMED: ");
            sb.append(this.mFragment);
        }
        android.view.View focusedView = this.mFragment.getFocusedView();
        if (focusedView != null && isFragmentViewChild(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(focusedView);
                sb2.append(" ");
                sb2.append(requestFocus ? "succeeded" : com.alipay.sdk.m.u.h.j);
                sb2.append(" on Fragment ");
                sb2.append(this.mFragment);
                sb2.append(" resulting in focused view ");
                sb2.append(this.mFragment.mView.findFocus());
            }
        }
        this.mFragment.setFocusedView(null);
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        androidx.fragment.app.Fragment fragment = this.mFragment;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment.SavedState saveInstanceState() {
        android.os.Bundle saveBasicState;
        if (this.mFragment.mState <= -1 || (saveBasicState = saveBasicState()) == null) {
            return null;
        }
        return new androidx.fragment.app.Fragment.SavedState(saveBasicState);
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentState saveState() {
        androidx.fragment.app.FragmentState fragmentState = new androidx.fragment.app.FragmentState(this.mFragment);
        androidx.fragment.app.Fragment fragment = this.mFragment;
        if (fragment.mState <= -1 || fragmentState.mSavedFragmentState != null) {
            fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
        } else {
            android.os.Bundle saveBasicState = saveBasicState();
            fragmentState.mSavedFragmentState = saveBasicState;
            if (this.mFragment.mTargetWho != null) {
                if (saveBasicState == null) {
                    fragmentState.mSavedFragmentState = new android.os.Bundle();
                }
                fragmentState.mSavedFragmentState.putString(TARGET_STATE_TAG, this.mFragment.mTargetWho);
                int i = this.mFragment.mTargetRequestCode;
                if (i != 0) {
                    fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, i);
                }
            }
        }
        return fragmentState;
    }

    public void saveViewState() {
        if (this.mFragment.mView == null) {
            return;
        }
        android.util.SparseArray<android.os.Parcelable> sparseArray = new android.util.SparseArray<>();
        this.mFragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.mFragment.mSavedViewState = sparseArray;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        this.mFragment.mViewLifecycleOwner.performSave(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.mFragment.mSavedViewRegistryState = bundle;
    }

    public void setFragmentManagerState(int i) {
        this.mFragmentManagerState = i;
    }

    public void start() {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("moveto STARTED: ");
            sb.append(this.mFragment);
        }
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    public void stop() {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("movefrom STARTED: ");
            sb.append(this.mFragment);
        }
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }
}
