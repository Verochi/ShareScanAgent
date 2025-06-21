package androidx.fragment.app;

/* loaded from: classes.dex */
abstract class SpecialEffectsController {
    private final android.view.ViewGroup mContainer;
    final java.util.ArrayList<androidx.fragment.app.SpecialEffectsController.Operation> mPendingOperations = new java.util.ArrayList<>();
    final java.util.ArrayList<androidx.fragment.app.SpecialEffectsController.Operation> mRunningOperations = new java.util.ArrayList<>();
    boolean mOperationDirectionIsPop = false;
    boolean mIsContainerPostponed = false;

    /* renamed from: androidx.fragment.app.SpecialEffectsController$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ androidx.fragment.app.SpecialEffectsController.FragmentStateManagerOperation val$operation;

        public AnonymousClass1(androidx.fragment.app.SpecialEffectsController.FragmentStateManagerOperation fragmentStateManagerOperation) {
            this.val$operation = fragmentStateManagerOperation;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (androidx.fragment.app.SpecialEffectsController.this.mPendingOperations.contains(this.val$operation)) {
                this.val$operation.getFinalState().applyState(this.val$operation.getFragment().mView);
            }
        }
    }

    /* renamed from: androidx.fragment.app.SpecialEffectsController$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ androidx.fragment.app.SpecialEffectsController.FragmentStateManagerOperation val$operation;

        public AnonymousClass2(androidx.fragment.app.SpecialEffectsController.FragmentStateManagerOperation fragmentStateManagerOperation) {
            this.val$operation = fragmentStateManagerOperation;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.fragment.app.SpecialEffectsController.this.mPendingOperations.remove(this.val$operation);
            androidx.fragment.app.SpecialEffectsController.this.mRunningOperations.remove(this.val$operation);
        }
    }

    /* renamed from: androidx.fragment.app.SpecialEffectsController$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact;
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            int[] iArr = new int[androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = iArr;
            try {
                iArr[androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[androidx.fragment.app.SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr2;
            try {
                iArr2[androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[androidx.fragment.app.SpecialEffectsController.Operation.State.GONE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    public static class FragmentStateManagerOperation extends androidx.fragment.app.SpecialEffectsController.Operation {

        @androidx.annotation.NonNull
        private final androidx.fragment.app.FragmentStateManager mFragmentStateManager;

        public FragmentStateManagerOperation(@androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation.State state, @androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact, @androidx.annotation.NonNull androidx.fragment.app.FragmentStateManager fragmentStateManager, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal) {
            super(state, lifecycleImpact, fragmentStateManager.getFragment(), cancellationSignal);
            this.mFragmentStateManager = fragmentStateManager;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void complete() {
            super.complete();
            this.mFragmentStateManager.moveToExpectedState();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void onStart() {
            if (getLifecycleImpact() == androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
                androidx.fragment.app.Fragment fragment = this.mFragmentStateManager.getFragment();
                android.view.View findFocus = fragment.mView.findFocus();
                if (findFocus != null) {
                    fragment.setFocusedView(findFocus);
                    if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("requestFocus: Saved focused view ");
                        sb.append(findFocus);
                        sb.append(" for Fragment ");
                        sb.append(fragment);
                    }
                }
                android.view.View requireView = getFragment().requireView();
                if (requireView.getParent() == null) {
                    this.mFragmentStateManager.addViewToContainer();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
            }
        }
    }

    public static class Operation {

        @androidx.annotation.NonNull
        private androidx.fragment.app.SpecialEffectsController.Operation.State mFinalState;

        @androidx.annotation.NonNull
        private final androidx.fragment.app.Fragment mFragment;

        @androidx.annotation.NonNull
        private androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact mLifecycleImpact;

        @androidx.annotation.NonNull
        private final java.util.List<java.lang.Runnable> mCompletionListeners = new java.util.ArrayList();

        @androidx.annotation.NonNull
        private final java.util.HashSet<androidx.core.os.CancellationSignal> mSpecialEffectsSignals = new java.util.HashSet<>();
        private boolean mIsCanceled = false;
        private boolean mIsComplete = false;

        /* renamed from: androidx.fragment.app.SpecialEffectsController$Operation$1, reason: invalid class name */
        public class AnonymousClass1 implements androidx.core.os.CancellationSignal.OnCancelListener {
            public AnonymousClass1() {
            }

            @Override // androidx.core.os.CancellationSignal.OnCancelListener
            public void onCancel() {
                androidx.fragment.app.SpecialEffectsController.Operation.this.cancel();
            }
        }

        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            @androidx.annotation.NonNull
            public static androidx.fragment.app.SpecialEffectsController.Operation.State from(int i) {
                if (i == 0) {
                    return VISIBLE;
                }
                if (i == 4) {
                    return INVISIBLE;
                }
                if (i == 8) {
                    return GONE;
                }
                throw new java.lang.IllegalArgumentException("Unknown visibility " + i);
            }

            @androidx.annotation.NonNull
            public static androidx.fragment.app.SpecialEffectsController.Operation.State from(@androidx.annotation.NonNull android.view.View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : from(view.getVisibility());
            }

            public void applyState(@androidx.annotation.NonNull android.view.View view) {
                int i = androidx.fragment.app.SpecialEffectsController.AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[ordinal()];
                if (i == 1) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append("SpecialEffectsController: Removing view ");
                            sb.append(view);
                            sb.append(" from container ");
                            sb.append(viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("SpecialEffectsController: Setting view ");
                        sb2.append(view);
                        sb2.append(" to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i == 3) {
                    if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append("SpecialEffectsController: Setting view ");
                        sb3.append(view);
                        sb3.append(" to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i != 4) {
                    return;
                }
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                    sb4.append("SpecialEffectsController: Setting view ");
                    sb4.append(view);
                    sb4.append(" to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        public Operation(@androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation.State state, @androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal) {
            this.mFinalState = state;
            this.mLifecycleImpact = lifecycleImpact;
            this.mFragment = fragment;
            cancellationSignal.setOnCancelListener(new androidx.fragment.app.SpecialEffectsController.Operation.AnonymousClass1());
        }

        public final void addCompletionListener(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            this.mCompletionListeners.add(runnable);
        }

        public final void cancel() {
            if (isCanceled()) {
                return;
            }
            this.mIsCanceled = true;
            if (this.mSpecialEffectsSignals.isEmpty()) {
                complete();
                return;
            }
            java.util.Iterator it = new java.util.ArrayList(this.mSpecialEffectsSignals).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.CancellationSignal) it.next()).cancel();
            }
        }

        @androidx.annotation.CallSuper
        public void complete() {
            if (this.mIsComplete) {
                return;
            }
            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("SpecialEffectsController: ");
                sb.append(this);
                sb.append(" has called complete.");
            }
            this.mIsComplete = true;
            java.util.Iterator<java.lang.Runnable> it = this.mCompletionListeners.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        public final void completeSpecialEffect(@androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal) {
            if (this.mSpecialEffectsSignals.remove(cancellationSignal) && this.mSpecialEffectsSignals.isEmpty()) {
                complete();
            }
        }

        @androidx.annotation.NonNull
        public androidx.fragment.app.SpecialEffectsController.Operation.State getFinalState() {
            return this.mFinalState;
        }

        @androidx.annotation.NonNull
        public final androidx.fragment.app.Fragment getFragment() {
            return this.mFragment;
        }

        @androidx.annotation.NonNull
        public androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact getLifecycleImpact() {
            return this.mLifecycleImpact;
        }

        public final boolean isCanceled() {
            return this.mIsCanceled;
        }

        public final boolean isComplete() {
            return this.mIsComplete;
        }

        public final void markStartedSpecialEffect(@androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal) {
            onStart();
            this.mSpecialEffectsSignals.add(cancellationSignal);
        }

        public final void mergeWith(@androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation.State state, @androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact) {
            int i = androidx.fragment.app.SpecialEffectsController.AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[lifecycleImpact.ordinal()];
            if (i == 1) {
                if (this.mFinalState == androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED) {
                    if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("SpecialEffectsController: For fragment ");
                        sb.append(this.mFragment);
                        sb.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                        sb.append(this.mLifecycleImpact);
                        sb.append(" to ADDING.");
                    }
                    this.mFinalState = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE;
                    this.mLifecycleImpact = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING;
                    return;
                }
                return;
            }
            if (i == 2) {
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("SpecialEffectsController: For fragment ");
                    sb2.append(this.mFragment);
                    sb2.append(" mFinalState = ");
                    sb2.append(this.mFinalState);
                    sb2.append(" -> REMOVED. mLifecycleImpact  = ");
                    sb2.append(this.mLifecycleImpact);
                    sb2.append(" to REMOVING.");
                }
                this.mFinalState = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED;
                this.mLifecycleImpact = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING;
                return;
            }
            if (i == 3 && this.mFinalState != androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED) {
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append("SpecialEffectsController: For fragment ");
                    sb3.append(this.mFragment);
                    sb3.append(" mFinalState = ");
                    sb3.append(this.mFinalState);
                    sb3.append(" -> ");
                    sb3.append(state);
                    sb3.append(". ");
                }
                this.mFinalState = state;
            }
        }

        public void onStart() {
        }

        @androidx.annotation.NonNull
        public java.lang.String toString() {
            return "Operation {" + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + "} {mFinalState = " + this.mFinalState + "} {mLifecycleImpact = " + this.mLifecycleImpact + "} {mFragment = " + this.mFragment + com.alipay.sdk.m.u.i.d;
        }
    }

    public SpecialEffectsController(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    private void enqueue(@androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation.State state, @androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact, @androidx.annotation.NonNull androidx.fragment.app.FragmentStateManager fragmentStateManager) {
        synchronized (this.mPendingOperations) {
            androidx.core.os.CancellationSignal cancellationSignal = new androidx.core.os.CancellationSignal();
            androidx.fragment.app.SpecialEffectsController.Operation findPendingOperation = findPendingOperation(fragmentStateManager.getFragment());
            if (findPendingOperation != null) {
                findPendingOperation.mergeWith(state, lifecycleImpact);
                return;
            }
            androidx.fragment.app.SpecialEffectsController.FragmentStateManagerOperation fragmentStateManagerOperation = new androidx.fragment.app.SpecialEffectsController.FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager, cancellationSignal);
            this.mPendingOperations.add(fragmentStateManagerOperation);
            fragmentStateManagerOperation.addCompletionListener(new androidx.fragment.app.SpecialEffectsController.AnonymousClass1(fragmentStateManagerOperation));
            fragmentStateManagerOperation.addCompletionListener(new androidx.fragment.app.SpecialEffectsController.AnonymousClass2(fragmentStateManagerOperation));
        }
    }

    @androidx.annotation.Nullable
    private androidx.fragment.app.SpecialEffectsController.Operation findPendingOperation(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        java.util.Iterator<androidx.fragment.app.SpecialEffectsController.Operation> it = this.mPendingOperations.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.SpecialEffectsController.Operation next = it.next();
            if (next.getFragment().equals(fragment) && !next.isCanceled()) {
                return next;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    private androidx.fragment.app.SpecialEffectsController.Operation findRunningOperation(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        java.util.Iterator<androidx.fragment.app.SpecialEffectsController.Operation> it = this.mRunningOperations.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.SpecialEffectsController.Operation next = it.next();
            if (next.getFragment().equals(fragment) && !next.isCanceled()) {
                return next;
            }
        }
        return null;
    }

    @androidx.annotation.NonNull
    public static androidx.fragment.app.SpecialEffectsController getOrCreateController(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager) {
        return getOrCreateController(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
    }

    @androidx.annotation.NonNull
    public static androidx.fragment.app.SpecialEffectsController getOrCreateController(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        int i = androidx.fragment.R.id.special_effects_controller_view_tag;
        java.lang.Object tag = viewGroup.getTag(i);
        if (tag instanceof androidx.fragment.app.SpecialEffectsController) {
            return (androidx.fragment.app.SpecialEffectsController) tag;
        }
        androidx.fragment.app.SpecialEffectsController createController = specialEffectsControllerFactory.createController(viewGroup);
        viewGroup.setTag(i, createController);
        return createController;
    }

    private void updateFinalState() {
        java.util.Iterator<androidx.fragment.app.SpecialEffectsController.Operation> it = this.mPendingOperations.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.SpecialEffectsController.Operation next = it.next();
            if (next.getLifecycleImpact() == androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
                next.mergeWith(androidx.fragment.app.SpecialEffectsController.Operation.State.from(next.getFragment().requireView().getVisibility()), androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE);
            }
        }
    }

    public void enqueueAdd(@androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation.State state, @androidx.annotation.NonNull androidx.fragment.app.FragmentStateManager fragmentStateManager) {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing add operation for fragment ");
            sb.append(fragmentStateManager.getFragment());
        }
        enqueue(state, androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    public void enqueueHide(@androidx.annotation.NonNull androidx.fragment.app.FragmentStateManager fragmentStateManager) {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            sb.append(fragmentStateManager.getFragment());
        }
        enqueue(androidx.fragment.app.SpecialEffectsController.Operation.State.GONE, androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public void enqueueRemove(@androidx.annotation.NonNull androidx.fragment.app.FragmentStateManager fragmentStateManager) {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            sb.append(fragmentStateManager.getFragment());
        }
        enqueue(androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED, androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    public void enqueueShow(@androidx.annotation.NonNull androidx.fragment.app.FragmentStateManager fragmentStateManager) {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing show operation for fragment ");
            sb.append(fragmentStateManager.getFragment());
        }
        enqueue(androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE, androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public abstract void executeOperations(@androidx.annotation.NonNull java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> list, boolean z);

    public void executePendingOperations() {
        if (this.mIsContainerPostponed) {
            return;
        }
        if (!androidx.core.view.ViewCompat.isAttachedToWindow(this.mContainer)) {
            forceCompleteAllOperations();
            this.mOperationDirectionIsPop = false;
            return;
        }
        synchronized (this.mPendingOperations) {
            if (!this.mPendingOperations.isEmpty()) {
                java.util.ArrayList arrayList = new java.util.ArrayList(this.mRunningOperations);
                this.mRunningOperations.clear();
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    androidx.fragment.app.SpecialEffectsController.Operation operation = (androidx.fragment.app.SpecialEffectsController.Operation) it.next();
                    if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("SpecialEffectsController: Cancelling operation ");
                        sb.append(operation);
                    }
                    operation.cancel();
                    if (!operation.isComplete()) {
                        this.mRunningOperations.add(operation);
                    }
                }
                updateFinalState();
                java.util.ArrayList arrayList2 = new java.util.ArrayList(this.mPendingOperations);
                this.mPendingOperations.clear();
                this.mRunningOperations.addAll(arrayList2);
                java.util.Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((androidx.fragment.app.SpecialEffectsController.Operation) it2.next()).onStart();
                }
                executeOperations(arrayList2, this.mOperationDirectionIsPop);
                this.mOperationDirectionIsPop = false;
            }
        }
    }

    public void forceCompleteAllOperations() {
        java.lang.String str;
        java.lang.String str2;
        boolean isAttachedToWindow = androidx.core.view.ViewCompat.isAttachedToWindow(this.mContainer);
        synchronized (this.mPendingOperations) {
            updateFinalState();
            java.util.Iterator<androidx.fragment.app.SpecialEffectsController.Operation> it = this.mPendingOperations.iterator();
            while (it.hasNext()) {
                it.next().onStart();
            }
            java.util.Iterator it2 = new java.util.ArrayList(this.mRunningOperations).iterator();
            while (it2.hasNext()) {
                androidx.fragment.app.SpecialEffectsController.Operation operation = (androidx.fragment.app.SpecialEffectsController.Operation) it2.next();
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.mContainer + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(operation);
                }
                operation.cancel();
            }
            java.util.Iterator it3 = new java.util.ArrayList(this.mPendingOperations).iterator();
            while (it3.hasNext()) {
                androidx.fragment.app.SpecialEffectsController.Operation operation2 = (androidx.fragment.app.SpecialEffectsController.Operation) it3.next();
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
                        str = "";
                    } else {
                        str = "Container " + this.mContainer + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(operation2);
                }
                operation2.cancel();
            }
        }
    }

    public void forcePostponedExecutePendingOperations() {
        if (this.mIsContainerPostponed) {
            this.mIsContainerPostponed = false;
            executePendingOperations();
        }
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(@androidx.annotation.NonNull androidx.fragment.app.FragmentStateManager fragmentStateManager) {
        androidx.fragment.app.SpecialEffectsController.Operation findPendingOperation = findPendingOperation(fragmentStateManager.getFragment());
        if (findPendingOperation != null) {
            return findPendingOperation.getLifecycleImpact();
        }
        androidx.fragment.app.SpecialEffectsController.Operation findRunningOperation = findRunningOperation(fragmentStateManager.getFragment());
        if (findRunningOperation != null) {
            return findRunningOperation.getLifecycleImpact();
        }
        return null;
    }

    @androidx.annotation.NonNull
    public android.view.ViewGroup getContainer() {
        return this.mContainer;
    }

    public void markPostponedState() {
        synchronized (this.mPendingOperations) {
            updateFinalState();
            this.mIsContainerPostponed = false;
            int size = this.mPendingOperations.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                androidx.fragment.app.SpecialEffectsController.Operation operation = this.mPendingOperations.get(size);
                androidx.fragment.app.SpecialEffectsController.Operation.State from = androidx.fragment.app.SpecialEffectsController.Operation.State.from(operation.getFragment().mView);
                androidx.fragment.app.SpecialEffectsController.Operation.State finalState = operation.getFinalState();
                androidx.fragment.app.SpecialEffectsController.Operation.State state = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE;
                if (finalState == state && from != state) {
                    this.mIsContainerPostponed = operation.getFragment().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    public void updateOperationDirection(boolean z) {
        this.mOperationDirectionIsPop = z;
    }
}
