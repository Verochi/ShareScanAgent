package androidx.fragment.app;

/* loaded from: classes.dex */
class DefaultSpecialEffectsController extends androidx.fragment.app.SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.List val$awaitingContainerChanges;
        final /* synthetic */ androidx.fragment.app.SpecialEffectsController.Operation val$operation;

        public AnonymousClass1(java.util.List list, androidx.fragment.app.SpecialEffectsController.Operation operation) {
            this.val$awaitingContainerChanges = list;
            this.val$operation = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$awaitingContainerChanges.contains(this.val$operation)) {
                this.val$awaitingContainerChanges.remove(this.val$operation);
                androidx.fragment.app.DefaultSpecialEffectsController.this.applyContainerChanges(this.val$operation);
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            int[] iArr = new int[androidx.fragment.app.SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            try {
                iArr[androidx.fragment.app.SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$2, reason: invalid class name */
    public class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo val$animationInfo;
        final /* synthetic */ android.view.ViewGroup val$container;
        final /* synthetic */ boolean val$isHideOperation;
        final /* synthetic */ androidx.fragment.app.SpecialEffectsController.Operation val$operation;
        final /* synthetic */ android.view.View val$viewToAnimate;

        public AnonymousClass2(android.view.ViewGroup viewGroup, android.view.View view, boolean z, androidx.fragment.app.SpecialEffectsController.Operation operation, androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo animationInfo) {
            this.val$container = viewGroup;
            this.val$viewToAnimate = view;
            this.val$isHideOperation = z;
            this.val$operation = operation;
            this.val$animationInfo = animationInfo;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.val$container.endViewTransition(this.val$viewToAnimate);
            if (this.val$isHideOperation) {
                this.val$operation.getFinalState().applyState(this.val$viewToAnimate);
            }
            this.val$animationInfo.completeSpecialEffect();
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$3, reason: invalid class name */
    public class AnonymousClass3 implements androidx.core.os.CancellationSignal.OnCancelListener {
        final /* synthetic */ android.animation.Animator val$animator;

        public AnonymousClass3(android.animation.Animator animator) {
            this.val$animator = animator;
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            this.val$animator.end();
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.animation.Animation.AnimationListener {
        final /* synthetic */ androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo val$animationInfo;
        final /* synthetic */ android.view.ViewGroup val$container;
        final /* synthetic */ android.view.View val$viewToAnimate;

        /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass4 anonymousClass4 = androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass4.this;
                anonymousClass4.val$container.endViewTransition(anonymousClass4.val$viewToAnimate);
                androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass4.this.val$animationInfo.completeSpecialEffect();
            }
        }

        public AnonymousClass4(android.view.ViewGroup viewGroup, android.view.View view, androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo animationInfo) {
            this.val$container = viewGroup;
            this.val$viewToAnimate = view;
            this.val$animationInfo = animationInfo;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            this.val$container.post(new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass4.AnonymousClass1());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$5, reason: invalid class name */
    public class AnonymousClass5 implements androidx.core.os.CancellationSignal.OnCancelListener {
        final /* synthetic */ androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo val$animationInfo;
        final /* synthetic */ android.view.ViewGroup val$container;
        final /* synthetic */ android.view.View val$viewToAnimate;

        public AnonymousClass5(android.view.View view, android.view.ViewGroup viewGroup, androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo animationInfo) {
            this.val$viewToAnimate = view;
            this.val$container = viewGroup;
            this.val$animationInfo = animationInfo;
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            this.val$viewToAnimate.clearAnimation();
            this.val$container.endViewTransition(this.val$viewToAnimate);
            this.val$animationInfo.completeSpecialEffect();
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ androidx.fragment.app.SpecialEffectsController.Operation val$firstOut;
        final /* synthetic */ boolean val$isPop;
        final /* synthetic */ androidx.fragment.app.SpecialEffectsController.Operation val$lastIn;
        final /* synthetic */ androidx.collection.ArrayMap val$lastInViews;

        public AnonymousClass6(androidx.fragment.app.SpecialEffectsController.Operation operation, androidx.fragment.app.SpecialEffectsController.Operation operation2, boolean z, androidx.collection.ArrayMap arrayMap) {
            this.val$lastIn = operation;
            this.val$firstOut = operation2;
            this.val$isPop = z;
            this.val$lastInViews = arrayMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.fragment.app.FragmentTransition.callSharedElementStartEnd(this.val$lastIn.getFragment(), this.val$firstOut.getFragment(), this.val$isPop, this.val$lastInViews, false);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ androidx.fragment.app.FragmentTransitionImpl val$impl;
        final /* synthetic */ android.graphics.Rect val$lastInEpicenterRect;
        final /* synthetic */ android.view.View val$lastInEpicenterView;

        public AnonymousClass7(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, android.view.View view, android.graphics.Rect rect) {
            this.val$impl = fragmentTransitionImpl;
            this.val$lastInEpicenterView = view;
            this.val$lastInEpicenterRect = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$impl.getBoundsOnScreen(this.val$lastInEpicenterView, this.val$lastInEpicenterRect);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ java.util.ArrayList val$transitioningViews;

        public AnonymousClass8(java.util.ArrayList arrayList) {
            this.val$transitioningViews = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.fragment.app.FragmentTransition.setViewVisibility(this.val$transitioningViews, 4);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo val$transitionInfo;

        public AnonymousClass9(androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo transitionInfo) {
            this.val$transitionInfo = transitionInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$transitionInfo.completeSpecialEffect();
        }
    }

    public static class AnimationInfo extends androidx.fragment.app.DefaultSpecialEffectsController.SpecialEffectsInfo {

        @androidx.annotation.Nullable
        private androidx.fragment.app.FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        public AnimationInfo(@androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation operation, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
            this.mIsPop = z;
        }

        @androidx.annotation.Nullable
        public androidx.fragment.app.FragmentAnim.AnimationOrAnimator getAnimation(@androidx.annotation.NonNull android.content.Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            androidx.fragment.app.FragmentAnim.AnimationOrAnimator loadAnimation = androidx.fragment.app.FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    public static class SpecialEffectsInfo {

        @androidx.annotation.NonNull
        private final androidx.fragment.app.SpecialEffectsController.Operation mOperation;

        @androidx.annotation.NonNull
        private final androidx.core.os.CancellationSignal mSignal;

        public SpecialEffectsInfo(@androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation operation, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @androidx.annotation.NonNull
        public androidx.fragment.app.SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @androidx.annotation.NonNull
        public androidx.core.os.CancellationSignal getSignal() {
            return this.mSignal;
        }

        public boolean isVisibilityUnchanged() {
            androidx.fragment.app.SpecialEffectsController.Operation.State state;
            androidx.fragment.app.SpecialEffectsController.Operation.State from = androidx.fragment.app.SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            androidx.fragment.app.SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            return from == finalState || !(from == (state = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE) || finalState == state);
        }
    }

    public static class TransitionInfo extends androidx.fragment.app.DefaultSpecialEffectsController.SpecialEffectsInfo {
        private final boolean mOverlapAllowed;

        @androidx.annotation.Nullable
        private final java.lang.Object mSharedElementTransition;

        @androidx.annotation.Nullable
        private final java.lang.Object mTransition;

        public TransitionInfo(@androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation operation, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            if (operation.getFinalState() == androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE) {
                this.mTransition = z ? operation.getFragment().getReenterTransition() : operation.getFragment().getEnterTransition();
                this.mOverlapAllowed = z ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            } else {
                this.mTransition = z ? operation.getFragment().getReturnTransition() : operation.getFragment().getExitTransition();
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        @androidx.annotation.Nullable
        private androidx.fragment.app.FragmentTransitionImpl getHandlingImpl(java.lang.Object obj) {
            if (obj == null) {
                return null;
            }
            androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl = androidx.fragment.app.FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl2 = androidx.fragment.app.FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new java.lang.IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }

        @androidx.annotation.Nullable
        public androidx.fragment.app.FragmentTransitionImpl getHandlingImpl() {
            androidx.fragment.app.FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            androidx.fragment.app.FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new java.lang.IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        @androidx.annotation.Nullable
        public java.lang.Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @androidx.annotation.Nullable
        public java.lang.Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }
    }

    public DefaultSpecialEffectsController(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@androidx.annotation.NonNull java.util.List<androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo> list, @androidx.annotation.NonNull java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> list2, boolean z, @androidx.annotation.NonNull java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> map) {
        android.view.ViewGroup container = getContainer();
        android.content.Context context = container.getContext();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        boolean z2 = false;
        for (androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo animationInfo : list) {
            if (animationInfo.isVisibilityUnchanged()) {
                animationInfo.completeSpecialEffect();
            } else {
                androidx.fragment.app.FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
                if (animation == null) {
                    animationInfo.completeSpecialEffect();
                } else {
                    android.animation.Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(animationInfo);
                    } else {
                        androidx.fragment.app.SpecialEffectsController.Operation operation = animationInfo.getOperation();
                        androidx.fragment.app.Fragment fragment = operation.getFragment();
                        if (java.lang.Boolean.TRUE.equals(map.get(operation))) {
                            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append("Ignoring Animator set on ");
                                sb.append(fragment);
                                sb.append(" as this Fragment was involved in a Transition.");
                            }
                            animationInfo.completeSpecialEffect();
                        } else {
                            boolean z3 = operation.getFinalState() == androidx.fragment.app.SpecialEffectsController.Operation.State.GONE;
                            if (z3) {
                                list2.remove(operation);
                            }
                            android.view.View view = fragment.mView;
                            container.startViewTransition(view);
                            animator.addListener(new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass2(container, view, z3, operation, animationInfo));
                            animator.setTarget(view);
                            animator.start();
                            animationInfo.getSignal().setOnCancelListener(new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass3(animator));
                            z2 = true;
                        }
                    }
                }
            }
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo animationInfo2 = (androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo) it.next();
            androidx.fragment.app.SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            androidx.fragment.app.Fragment fragment2 = operation2.getFragment();
            if (z) {
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Ignoring Animation set on ");
                    sb2.append(fragment2);
                    sb2.append(" as Animations cannot run alongside Transitions.");
                }
                animationInfo2.completeSpecialEffect();
            } else if (z2) {
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append("Ignoring Animation set on ");
                    sb3.append(fragment2);
                    sb3.append(" as Animations cannot run alongside Animators.");
                }
                animationInfo2.completeSpecialEffect();
            } else {
                android.view.View view2 = fragment2.mView;
                android.view.animation.Animation animation2 = (android.view.animation.Animation) androidx.core.util.Preconditions.checkNotNull(((androidx.fragment.app.FragmentAnim.AnimationOrAnimator) androidx.core.util.Preconditions.checkNotNull(animationInfo2.getAnimation(context))).animation);
                if (operation2.getFinalState() != androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation2);
                    animationInfo2.completeSpecialEffect();
                } else {
                    container.startViewTransition(view2);
                    androidx.fragment.app.FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new androidx.fragment.app.FragmentAnim.EndViewTransitionAnimation(animation2, container, view2);
                    endViewTransitionAnimation.setAnimationListener(new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass4(container, view2, animationInfo2));
                    view2.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.getSignal().setOnCancelListener(new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass5(view2, container, animationInfo2));
            }
        }
    }

    @androidx.annotation.NonNull
    private java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> startTransitions(@androidx.annotation.NonNull java.util.List<androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo> list, @androidx.annotation.NonNull java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> list2, boolean z, @androidx.annotation.Nullable androidx.fragment.app.SpecialEffectsController.Operation operation, @androidx.annotation.Nullable androidx.fragment.app.SpecialEffectsController.Operation operation2) {
        java.util.Iterator<androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo> it;
        android.view.View view;
        java.lang.Object obj;
        java.util.ArrayList<android.view.View> arrayList;
        java.lang.Object obj2;
        java.util.ArrayList<android.view.View> arrayList2;
        androidx.fragment.app.SpecialEffectsController.Operation operation3;
        androidx.fragment.app.SpecialEffectsController.Operation operation4;
        android.view.View view2;
        java.lang.Object mergeTransitionsTogether;
        androidx.collection.ArrayMap arrayMap;
        java.util.ArrayList<android.view.View> arrayList3;
        androidx.fragment.app.SpecialEffectsController.Operation operation5;
        java.util.ArrayList<android.view.View> arrayList4;
        android.graphics.Rect rect;
        androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl;
        androidx.fragment.app.SpecialEffectsController.Operation operation6;
        android.view.View view3;
        androidx.core.app.SharedElementCallback enterTransitionCallback;
        androidx.core.app.SharedElementCallback exitTransitionCallback;
        java.util.ArrayList<java.lang.String> arrayList5;
        android.view.View view4;
        android.view.View view5;
        java.lang.String findKeyForValue;
        java.util.ArrayList<java.lang.String> arrayList6;
        boolean z2 = z;
        androidx.fragment.app.SpecialEffectsController.Operation operation7 = operation;
        androidx.fragment.app.SpecialEffectsController.Operation operation8 = operation2;
        java.util.HashMap hashMap = new java.util.HashMap();
        androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                androidx.fragment.app.FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl2 != handlingImpl) {
                    throw new java.lang.IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo transitionInfo2 : list) {
                hashMap.put(transitionInfo2.getOperation(), java.lang.Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            return hashMap;
        }
        android.view.View view6 = new android.view.View(getContainer().getContext());
        android.graphics.Rect rect2 = new android.graphics.Rect();
        java.util.ArrayList<android.view.View> arrayList7 = new java.util.ArrayList<>();
        java.util.ArrayList<android.view.View> arrayList8 = new java.util.ArrayList<>();
        androidx.collection.ArrayMap arrayMap2 = new androidx.collection.ArrayMap();
        java.lang.Object obj3 = null;
        android.view.View view7 = null;
        boolean z3 = false;
        for (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo transitionInfo3 : list) {
            if (!transitionInfo3.hasSharedElementTransition() || operation7 == null || operation8 == null) {
                arrayMap = arrayMap2;
                arrayList3 = arrayList8;
                operation5 = operation7;
                arrayList4 = arrayList7;
                rect = rect2;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                operation6 = operation8;
                view3 = view6;
                view7 = view7;
            } else {
                java.lang.Object wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(transitionInfo3.getSharedElementTransition()));
                java.util.ArrayList<java.lang.String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                java.util.ArrayList<java.lang.String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                java.util.ArrayList<java.lang.String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                android.view.View view8 = view7;
                int i = 0;
                while (i < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i));
                    java.util.ArrayList<java.lang.String> arrayList9 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i));
                    }
                    i++;
                    sharedElementTargetNames = arrayList9;
                }
                java.util.ArrayList<java.lang.String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                if (z2) {
                    enterTransitionCallback = operation.getFragment().getEnterTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getExitTransitionCallback();
                } else {
                    enterTransitionCallback = operation.getFragment().getExitTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getEnterTransitionCallback();
                }
                int i2 = 0;
                for (int size = sharedElementSourceNames.size(); i2 < size; size = size) {
                    arrayMap2.put(sharedElementSourceNames.get(i2), sharedElementTargetNames2.get(i2));
                    i2++;
                }
                androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap3 = new androidx.collection.ArrayMap<>();
                findNamedViews(arrayMap3, operation.getFragment().mView);
                arrayMap3.retainAll(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    enterTransitionCallback.onMapSharedElements(sharedElementSourceNames, arrayMap3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        java.lang.String str = sharedElementSourceNames.get(size2);
                        android.view.View view9 = arrayMap3.get(str);
                        if (view9 == null) {
                            arrayMap2.remove(str);
                            arrayList6 = sharedElementSourceNames;
                        } else {
                            arrayList6 = sharedElementSourceNames;
                            if (!str.equals(androidx.core.view.ViewCompat.getTransitionName(view9))) {
                                arrayMap2.put(androidx.core.view.ViewCompat.getTransitionName(view9), (java.lang.String) arrayMap2.remove(str));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList6;
                    }
                    arrayList5 = sharedElementSourceNames;
                } else {
                    arrayList5 = sharedElementSourceNames;
                    arrayMap2.retainAll(arrayMap3.keySet());
                }
                androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap4 = new androidx.collection.ArrayMap<>();
                findNamedViews(arrayMap4, operation2.getFragment().mView);
                arrayMap4.retainAll(sharedElementTargetNames2);
                arrayMap4.retainAll(arrayMap2.values());
                if (exitTransitionCallback != null) {
                    exitTransitionCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        java.lang.String str2 = sharedElementTargetNames2.get(size3);
                        android.view.View view10 = arrayMap4.get(str2);
                        if (view10 == null) {
                            java.lang.String findKeyForValue2 = androidx.fragment.app.FragmentTransition.findKeyForValue(arrayMap2, str2);
                            if (findKeyForValue2 != null) {
                                arrayMap2.remove(findKeyForValue2);
                            }
                        } else if (!str2.equals(androidx.core.view.ViewCompat.getTransitionName(view10)) && (findKeyForValue = androidx.fragment.app.FragmentTransition.findKeyForValue(arrayMap2, str2)) != null) {
                            arrayMap2.put(findKeyForValue, androidx.core.view.ViewCompat.getTransitionName(view10));
                        }
                    }
                } else {
                    androidx.fragment.app.FragmentTransition.retainValues(arrayMap2, arrayMap4);
                }
                retainMatchingViews(arrayMap3, arrayMap2.keySet());
                retainMatchingViews(arrayMap4, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    arrayList7.clear();
                    arrayList8.clear();
                    operation5 = operation;
                    arrayMap = arrayMap2;
                    arrayList3 = arrayList8;
                    arrayList4 = arrayList7;
                    rect = rect2;
                    view3 = view6;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    view7 = view8;
                    obj3 = null;
                    operation6 = operation2;
                } else {
                    androidx.fragment.app.FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z2, arrayMap3, true);
                    java.util.ArrayList<java.lang.String> arrayList10 = arrayList5;
                    java.util.HashMap hashMap2 = hashMap;
                    android.view.View view11 = view6;
                    android.graphics.Rect rect3 = rect2;
                    arrayMap = arrayMap2;
                    java.util.ArrayList<android.view.View> arrayList11 = arrayList8;
                    androidx.core.view.OneShotPreDrawListener.add(getContainer(), new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass6(operation2, operation, z, arrayMap4));
                    java.util.Iterator<android.view.View> it2 = arrayMap3.values().iterator();
                    while (it2.hasNext()) {
                        captureTransitioningViews(arrayList7, it2.next());
                    }
                    if (arrayList10.isEmpty()) {
                        view7 = view8;
                    } else {
                        android.view.View view12 = arrayMap3.get(arrayList10.get(0));
                        fragmentTransitionImpl2.setEpicenter(wrapTransitionInSet, view12);
                        view7 = view12;
                    }
                    java.util.Iterator<android.view.View> it3 = arrayMap4.values().iterator();
                    while (it3.hasNext()) {
                        captureTransitioningViews(arrayList11, it3.next());
                    }
                    arrayList3 = arrayList11;
                    if (sharedElementTargetNames2.isEmpty() || (view5 = arrayMap4.get(sharedElementTargetNames2.get(0))) == null) {
                        rect = rect3;
                        view4 = view11;
                    } else {
                        rect = rect3;
                        androidx.core.view.OneShotPreDrawListener.add(getContainer(), new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass7(fragmentTransitionImpl2, view5, rect));
                        view4 = view11;
                        z3 = true;
                    }
                    fragmentTransitionImpl2.setSharedElementTargets(wrapTransitionInSet, view4, arrayList7);
                    arrayList4 = arrayList7;
                    view3 = view4;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.scheduleRemoveTargets(wrapTransitionInSet, null, null, null, null, wrapTransitionInSet, arrayList3);
                    java.lang.Boolean bool = java.lang.Boolean.TRUE;
                    operation5 = operation;
                    hashMap = hashMap2;
                    hashMap.put(operation5, bool);
                    operation6 = operation2;
                    hashMap.put(operation6, bool);
                    obj3 = wrapTransitionInSet;
                }
            }
            z2 = z;
            operation7 = operation5;
            arrayList7 = arrayList4;
            rect2 = rect;
            view6 = view3;
            operation8 = operation6;
            arrayMap2 = arrayMap;
            arrayList8 = arrayList3;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
        }
        android.view.View view13 = view7;
        androidx.collection.ArrayMap arrayMap5 = arrayMap2;
        java.util.ArrayList<android.view.View> arrayList12 = arrayList8;
        androidx.fragment.app.SpecialEffectsController.Operation operation9 = operation7;
        java.util.ArrayList<android.view.View> arrayList13 = arrayList7;
        android.graphics.Rect rect4 = rect2;
        androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        androidx.fragment.app.SpecialEffectsController.Operation operation10 = operation8;
        android.view.View view14 = view6;
        java.util.ArrayList arrayList14 = new java.util.ArrayList();
        java.util.Iterator<androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo> it4 = list.iterator();
        java.lang.Object obj4 = null;
        java.lang.Object obj5 = null;
        while (it4.hasNext()) {
            androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo next = it4.next();
            if (next.isVisibilityUnchanged()) {
                hashMap.put(next.getOperation(), java.lang.Boolean.FALSE);
                next.completeSpecialEffect();
            } else {
                java.lang.Object cloneTransition = fragmentTransitionImpl3.cloneTransition(next.getTransition());
                androidx.fragment.app.SpecialEffectsController.Operation operation11 = next.getOperation();
                boolean z4 = obj3 != null && (operation11 == operation9 || operation11 == operation10);
                if (cloneTransition == null) {
                    if (!z4) {
                        hashMap.put(operation11, java.lang.Boolean.FALSE);
                        next.completeSpecialEffect();
                    }
                    arrayList2 = arrayList12;
                    arrayList = arrayList13;
                    it = it4;
                    view = view14;
                    mergeTransitionsTogether = obj4;
                    operation3 = operation10;
                    view2 = view13;
                } else {
                    it = it4;
                    java.util.ArrayList<android.view.View> arrayList15 = new java.util.ArrayList<>();
                    java.lang.Object obj6 = obj4;
                    captureTransitioningViews(arrayList15, operation11.getFragment().mView);
                    if (z4) {
                        if (operation11 == operation9) {
                            arrayList15.removeAll(arrayList13);
                        } else {
                            arrayList15.removeAll(arrayList12);
                        }
                    }
                    if (arrayList15.isEmpty()) {
                        fragmentTransitionImpl3.addTarget(cloneTransition, view14);
                        arrayList2 = arrayList12;
                        arrayList = arrayList13;
                        view = view14;
                        operation4 = operation11;
                        obj2 = obj5;
                        operation3 = operation10;
                        obj = obj6;
                    } else {
                        fragmentTransitionImpl3.addTargets(cloneTransition, arrayList15);
                        view = view14;
                        obj = obj6;
                        arrayList = arrayList13;
                        obj2 = obj5;
                        arrayList2 = arrayList12;
                        operation3 = operation10;
                        fragmentTransitionImpl3.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList15, null, null, null, null);
                        if (operation11.getFinalState() == androidx.fragment.app.SpecialEffectsController.Operation.State.GONE) {
                            operation4 = operation11;
                            list2.remove(operation4);
                            fragmentTransitionImpl3.scheduleHideFragmentView(cloneTransition, operation4.getFragment().mView, arrayList15);
                            androidx.core.view.OneShotPreDrawListener.add(getContainer(), new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass8(arrayList15));
                        } else {
                            operation4 = operation11;
                        }
                    }
                    if (operation4.getFinalState() == androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList14.addAll(arrayList15);
                        if (z3) {
                            fragmentTransitionImpl3.setEpicenter(cloneTransition, rect4);
                        }
                        view2 = view13;
                    } else {
                        view2 = view13;
                        fragmentTransitionImpl3.setEpicenter(cloneTransition, view2);
                    }
                    hashMap.put(operation4, java.lang.Boolean.TRUE);
                    if (next.isOverlapAllowed()) {
                        obj5 = fragmentTransitionImpl3.mergeTransitionsTogether(obj2, cloneTransition, null);
                        mergeTransitionsTogether = obj;
                    } else {
                        mergeTransitionsTogether = fragmentTransitionImpl3.mergeTransitionsTogether(obj, cloneTransition, null);
                        obj5 = obj2;
                    }
                }
                operation10 = operation3;
                view13 = view2;
                obj4 = mergeTransitionsTogether;
                view14 = view;
                arrayList13 = arrayList;
                arrayList12 = arrayList2;
                it4 = it;
            }
        }
        java.util.ArrayList<android.view.View> arrayList16 = arrayList12;
        java.util.ArrayList<android.view.View> arrayList17 = arrayList13;
        androidx.fragment.app.SpecialEffectsController.Operation operation12 = operation10;
        java.lang.Object mergeTransitionsInSequence = fragmentTransitionImpl3.mergeTransitionsInSequence(obj5, obj4, obj3);
        for (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo transitionInfo4 : list) {
            if (!transitionInfo4.isVisibilityUnchanged()) {
                java.lang.Object transition = transitionInfo4.getTransition();
                androidx.fragment.app.SpecialEffectsController.Operation operation13 = transitionInfo4.getOperation();
                boolean z5 = obj3 != null && (operation13 == operation9 || operation13 == operation12);
                if (transition != null || z5) {
                    if (androidx.core.view.ViewCompat.isLaidOut(getContainer())) {
                        fragmentTransitionImpl3.setListenerForTransitionEnd(transitionInfo4.getOperation().getFragment(), mergeTransitionsInSequence, transitionInfo4.getSignal(), new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass9(transitionInfo4));
                    } else {
                        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append("SpecialEffectsController: Container ");
                            sb.append(getContainer());
                            sb.append(" has not been laid out. Completing operation ");
                            sb.append(operation13);
                        }
                        transitionInfo4.completeSpecialEffect();
                    }
                }
            }
        }
        if (!androidx.core.view.ViewCompat.isLaidOut(getContainer())) {
            return hashMap;
        }
        androidx.fragment.app.FragmentTransition.setViewVisibility(arrayList14, 4);
        java.util.ArrayList<java.lang.String> prepareSetNameOverridesReordered = fragmentTransitionImpl3.prepareSetNameOverridesReordered(arrayList16);
        fragmentTransitionImpl3.beginDelayedTransition(getContainer(), mergeTransitionsInSequence);
        fragmentTransitionImpl3.setNameOverridesReordered(getContainer(), arrayList17, arrayList16, prepareSetNameOverridesReordered, arrayMap5);
        androidx.fragment.app.FragmentTransition.setViewVisibility(arrayList14, 0);
        fragmentTransitionImpl3.swapSharedElementTargets(obj3, arrayList17, arrayList16);
        return hashMap;
    }

    public void applyContainerChanges(@androidx.annotation.NonNull androidx.fragment.app.SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    public void captureTransitioningViews(java.util.ArrayList<android.view.View> arrayList, android.view.View view) {
        if (!(view instanceof android.view.ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        if (!arrayList.contains(view) && androidx.core.view.ViewCompat.getTransitionName(view) != null) {
            arrayList.add(view);
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(arrayList, childAt);
            }
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void executeOperations(@androidx.annotation.NonNull java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> list, boolean z) {
        androidx.fragment.app.SpecialEffectsController.Operation operation = null;
        androidx.fragment.app.SpecialEffectsController.Operation operation2 = null;
        for (androidx.fragment.app.SpecialEffectsController.Operation operation3 : list) {
            androidx.fragment.app.SpecialEffectsController.Operation.State from = androidx.fragment.app.SpecialEffectsController.Operation.State.from(operation3.getFragment().mView);
            int i = androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[operation3.getFinalState().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                if (from == androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = operation3;
                }
            } else if (i == 4 && from != androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = operation3;
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList(list);
        for (androidx.fragment.app.SpecialEffectsController.Operation operation4 : list) {
            androidx.core.os.CancellationSignal cancellationSignal = new androidx.core.os.CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo(operation4, cancellationSignal, z));
            androidx.core.os.CancellationSignal cancellationSignal2 = new androidx.core.os.CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal2);
            boolean z2 = false;
            if (z) {
                if (operation4 != operation) {
                    arrayList2.add(new androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo(operation4, cancellationSignal2, z, z2));
                    operation4.addCompletionListener(new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass1(arrayList3, operation4));
                }
                z2 = true;
                arrayList2.add(new androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo(operation4, cancellationSignal2, z, z2));
                operation4.addCompletionListener(new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass1(arrayList3, operation4));
            } else {
                if (operation4 != operation2) {
                    arrayList2.add(new androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo(operation4, cancellationSignal2, z, z2));
                    operation4.addCompletionListener(new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass1(arrayList3, operation4));
                }
                z2 = true;
                arrayList2.add(new androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo(operation4, cancellationSignal2, z, z2));
                operation4.addCompletionListener(new androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass1(arrayList3, operation4));
            }
        }
        java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> startTransitions = startTransitions(arrayList2, arrayList3, z, operation, operation2);
        startAnimations(arrayList, arrayList3, startTransitions.containsValue(java.lang.Boolean.TRUE), startTransitions);
        java.util.Iterator<androidx.fragment.app.SpecialEffectsController.Operation> it = arrayList3.iterator();
        while (it.hasNext()) {
            applyContainerChanges(it.next());
        }
        arrayList3.clear();
    }

    public void findNamedViews(java.util.Map<java.lang.String, android.view.View> map, @androidx.annotation.NonNull android.view.View view) {
        java.lang.String transitionName = androidx.core.view.ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                android.view.View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    public void retainMatchingViews(@androidx.annotation.NonNull androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap, @androidx.annotation.NonNull java.util.Collection<java.lang.String> collection) {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, android.view.View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(androidx.core.view.ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
