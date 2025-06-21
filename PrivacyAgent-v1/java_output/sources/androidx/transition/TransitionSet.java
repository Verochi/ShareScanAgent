package androidx.transition;

/* loaded from: classes.dex */
public class TransitionSet extends androidx.transition.Transition {
    private static final int FLAG_CHANGE_EPICENTER = 8;
    private static final int FLAG_CHANGE_INTERPOLATOR = 1;
    private static final int FLAG_CHANGE_PATH_MOTION = 4;
    private static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private int mChangeFlags;
    int mCurrentListeners;
    private boolean mPlayTogether;
    boolean mStarted;
    private java.util.ArrayList<androidx.transition.Transition> mTransitions;

    /* renamed from: androidx.transition.TransitionSet$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.transition.TransitionListenerAdapter {
        final /* synthetic */ androidx.transition.Transition val$nextTransition;

        public AnonymousClass1(androidx.transition.Transition transition) {
            this.val$nextTransition = transition;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            this.val$nextTransition.runAnimators();
            transition.removeListener(this);
        }
    }

    public static class TransitionSetListener extends androidx.transition.TransitionListenerAdapter {
        androidx.transition.TransitionSet mTransitionSet;

        public TransitionSetListener(androidx.transition.TransitionSet transitionSet) {
            this.mTransitionSet = transitionSet;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            androidx.transition.TransitionSet transitionSet = this.mTransitionSet;
            int i = transitionSet.mCurrentListeners - 1;
            transitionSet.mCurrentListeners = i;
            if (i == 0) {
                transitionSet.mStarted = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            androidx.transition.TransitionSet transitionSet = this.mTransitionSet;
            if (transitionSet.mStarted) {
                return;
            }
            transitionSet.start();
            this.mTransitionSet.mStarted = true;
        }
    }

    public TransitionSet() {
        this.mTransitions = new java.util.ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    public TransitionSet(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTransitions = new java.util.ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.transition.Styleable.TRANSITION_SET);
        setOrdering(androidx.core.content.res.TypedArrayUtils.getNamedInt(obtainStyledAttributes, (android.content.res.XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    private void addTransitionInternal(@androidx.annotation.NonNull androidx.transition.Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
    }

    private void setupStartEndListeners() {
        androidx.transition.TransitionSet.TransitionSetListener transitionSetListener = new androidx.transition.TransitionSet.TransitionSetListener(this);
        java.util.Iterator<androidx.transition.Transition> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet addListener(@androidx.annotation.NonNull androidx.transition.Transition.TransitionListener transitionListener) {
        return (androidx.transition.TransitionSet) super.addListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public /* bridge */ /* synthetic */ androidx.transition.Transition addTarget(@androidx.annotation.NonNull java.lang.Class cls) {
        return addTarget((java.lang.Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet addTarget(@androidx.annotation.IdRes int i) {
        for (int i2 = 0; i2 < this.mTransitions.size(); i2++) {
            this.mTransitions.get(i2).addTarget(i);
        }
        return (androidx.transition.TransitionSet) super.addTarget(i);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet addTarget(@androidx.annotation.NonNull android.view.View view) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).addTarget(view);
        }
        return (androidx.transition.TransitionSet) super.addTarget(view);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet addTarget(@androidx.annotation.NonNull java.lang.Class<?> cls) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).addTarget(cls);
        }
        return (androidx.transition.TransitionSet) super.addTarget(cls);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet addTarget(@androidx.annotation.NonNull java.lang.String str) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).addTarget(str);
        }
        return (androidx.transition.TransitionSet) super.addTarget(str);
    }

    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet addTransition(@androidx.annotation.NonNull androidx.transition.Transition transition) {
        addTransitionInternal(transition);
        long j = this.mDuration;
        if (j >= 0) {
            transition.setDuration(j);
        }
        if ((this.mChangeFlags & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.mChangeFlags & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.mChangeFlags & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.mChangeFlags & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            java.util.Iterator<androidx.transition.Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                androidx.transition.Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void capturePropagationValues(androidx.transition.TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).capturePropagationValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            java.util.Iterator<androidx.transition.Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                androidx.transition.Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public androidx.transition.Transition mo8clone() {
        androidx.transition.TransitionSet transitionSet = (androidx.transition.TransitionSet) super.mo8clone();
        transitionSet.mTransitions = new java.util.ArrayList<>();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            transitionSet.addTransitionInternal(this.mTransitions.get(i).mo8clone());
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void createAnimators(android.view.ViewGroup viewGroup, androidx.transition.TransitionValuesMaps transitionValuesMaps, androidx.transition.TransitionValuesMaps transitionValuesMaps2, java.util.ArrayList<androidx.transition.TransitionValues> arrayList, java.util.ArrayList<androidx.transition.TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            androidx.transition.Transition transition = this.mTransitions.get(i);
            if (startDelay > 0 && (this.mPlayTogether || i == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.Transition excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.mTransitions.size(); i2++) {
            this.mTransitions.get(i2).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.Transition excludeTarget(@androidx.annotation.NonNull android.view.View view, boolean z) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.Transition excludeTarget(@androidx.annotation.NonNull java.lang.Class<?> cls, boolean z) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.Transition excludeTarget(@androidx.annotation.NonNull java.lang.String str, boolean z) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(android.view.ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).forceToEnd(viewGroup);
        }
    }

    public int getOrdering() {
        return !this.mPlayTogether ? 1 : 0;
    }

    @androidx.annotation.Nullable
    public androidx.transition.Transition getTransitionAt(int i) {
        if (i < 0 || i >= this.mTransitions.size()) {
            return null;
        }
        return this.mTransitions.get(i);
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(android.view.View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).pause(view);
        }
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet removeListener(@androidx.annotation.NonNull androidx.transition.Transition.TransitionListener transitionListener) {
        return (androidx.transition.TransitionSet) super.removeListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public /* bridge */ /* synthetic */ androidx.transition.Transition removeTarget(@androidx.annotation.NonNull java.lang.Class cls) {
        return removeTarget((java.lang.Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet removeTarget(@androidx.annotation.IdRes int i) {
        for (int i2 = 0; i2 < this.mTransitions.size(); i2++) {
            this.mTransitions.get(i2).removeTarget(i);
        }
        return (androidx.transition.TransitionSet) super.removeTarget(i);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet removeTarget(@androidx.annotation.NonNull android.view.View view) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).removeTarget(view);
        }
        return (androidx.transition.TransitionSet) super.removeTarget(view);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet removeTarget(@androidx.annotation.NonNull java.lang.Class<?> cls) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).removeTarget(cls);
        }
        return (androidx.transition.TransitionSet) super.removeTarget(cls);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet removeTarget(@androidx.annotation.NonNull java.lang.String str) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i).removeTarget(str);
        }
        return (androidx.transition.TransitionSet) super.removeTarget(str);
    }

    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet removeTransition(@androidx.annotation.NonNull androidx.transition.Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(android.view.View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).resume(view);
        }
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        setupStartEndListeners();
        if (this.mPlayTogether) {
            java.util.Iterator<androidx.transition.Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                it.next().runAnimators();
            }
            return;
        }
        for (int i = 1; i < this.mTransitions.size(); i++) {
            this.mTransitions.get(i - 1).addListener(new androidx.transition.TransitionSet.AnonymousClass1(this.mTransitions.get(i)));
        }
        androidx.transition.Transition transition = this.mTransitions.get(0);
        if (transition != null) {
            transition.runAnimators();
        }
    }

    @Override // androidx.transition.Transition
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setCanRemoveViews(z);
        }
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet setDuration(long j) {
        java.util.ArrayList<androidx.transition.Transition> arrayList;
        super.setDuration(j);
        if (this.mDuration >= 0 && (arrayList = this.mTransitions) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).setDuration(j);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(androidx.transition.Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.mChangeFlags |= 8;
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setEpicenterCallback(epicenterCallback);
        }
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet setInterpolator(@androidx.annotation.Nullable android.animation.TimeInterpolator timeInterpolator) {
        this.mChangeFlags |= 1;
        java.util.ArrayList<androidx.transition.Transition> arrayList = this.mTransitions;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).setInterpolator(timeInterpolator);
            }
        }
        return (androidx.transition.TransitionSet) super.setInterpolator(timeInterpolator);
    }

    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet setOrdering(int i) {
        if (i == 0) {
            this.mPlayTogether = true;
        } else {
            if (i != 1) {
                throw new android.util.AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
            }
            this.mPlayTogether = false;
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(androidx.transition.PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.mChangeFlags |= 4;
        if (this.mTransitions != null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                this.mTransitions.get(i).setPathMotion(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(androidx.transition.TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.mChangeFlags |= 2;
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setPropagation(transitionPropagation);
        }
    }

    @Override // androidx.transition.Transition
    public androidx.transition.TransitionSet setSceneRoot(android.view.ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.NonNull
    public androidx.transition.TransitionSet setStartDelay(long j) {
        return (androidx.transition.TransitionSet) super.setStartDelay(j);
    }

    @Override // androidx.transition.Transition
    public java.lang.String toString(java.lang.String str) {
        java.lang.String transition = super.toString(str);
        for (int i = 0; i < this.mTransitions.size(); i++) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(transition);
            sb.append("\n");
            sb.append(this.mTransitions.get(i).toString(str + "  "));
            transition = sb.toString();
        }
        return transition;
    }
}
