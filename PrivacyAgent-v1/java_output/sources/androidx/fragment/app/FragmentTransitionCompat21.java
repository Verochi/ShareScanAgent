package androidx.fragment.app;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes.dex */
class FragmentTransitionCompat21 extends androidx.fragment.app.FragmentTransitionImpl {

    /* renamed from: androidx.fragment.app.FragmentTransitionCompat21$1, reason: invalid class name */
    public class AnonymousClass1 extends android.transition.Transition.EpicenterCallback {
        final /* synthetic */ android.graphics.Rect val$epicenter;

        public AnonymousClass1(android.graphics.Rect rect) {
            this.val$epicenter = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public android.graphics.Rect onGetEpicenter(android.transition.Transition transition) {
            return this.val$epicenter;
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransitionCompat21$2, reason: invalid class name */
    public class AnonymousClass2 implements android.transition.Transition.TransitionListener {
        final /* synthetic */ java.util.ArrayList val$exitingViews;
        final /* synthetic */ android.view.View val$fragmentView;

        public AnonymousClass2(android.view.View view, java.util.ArrayList arrayList) {
            this.val$fragmentView = view;
            this.val$exitingViews = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(android.transition.Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(android.transition.Transition transition) {
            transition.removeListener(this);
            this.val$fragmentView.setVisibility(8);
            int size = this.val$exitingViews.size();
            for (int i = 0; i < size; i++) {
                ((android.view.View) this.val$exitingViews.get(i)).setVisibility(0);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(android.transition.Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(android.transition.Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(android.transition.Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransitionCompat21$3, reason: invalid class name */
    public class AnonymousClass3 implements android.transition.Transition.TransitionListener {
        final /* synthetic */ java.lang.Object val$enterTransition;
        final /* synthetic */ java.util.ArrayList val$enteringViews;
        final /* synthetic */ java.lang.Object val$exitTransition;
        final /* synthetic */ java.util.ArrayList val$exitingViews;
        final /* synthetic */ java.lang.Object val$sharedElementTransition;
        final /* synthetic */ java.util.ArrayList val$sharedElementsIn;

        public AnonymousClass3(java.lang.Object obj, java.util.ArrayList arrayList, java.lang.Object obj2, java.util.ArrayList arrayList2, java.lang.Object obj3, java.util.ArrayList arrayList3) {
            this.val$enterTransition = obj;
            this.val$enteringViews = arrayList;
            this.val$exitTransition = obj2;
            this.val$exitingViews = arrayList2;
            this.val$sharedElementTransition = obj3;
            this.val$sharedElementsIn = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(android.transition.Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(android.transition.Transition transition) {
            transition.removeListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(android.transition.Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(android.transition.Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(android.transition.Transition transition) {
            java.lang.Object obj = this.val$enterTransition;
            if (obj != null) {
                androidx.fragment.app.FragmentTransitionCompat21.this.replaceTargets(obj, this.val$enteringViews, null);
            }
            java.lang.Object obj2 = this.val$exitTransition;
            if (obj2 != null) {
                androidx.fragment.app.FragmentTransitionCompat21.this.replaceTargets(obj2, this.val$exitingViews, null);
            }
            java.lang.Object obj3 = this.val$sharedElementTransition;
            if (obj3 != null) {
                androidx.fragment.app.FragmentTransitionCompat21.this.replaceTargets(obj3, this.val$sharedElementsIn, null);
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransitionCompat21$4, reason: invalid class name */
    public class AnonymousClass4 implements android.transition.Transition.TransitionListener {
        final /* synthetic */ java.lang.Runnable val$transitionCompleteRunnable;

        public AnonymousClass4(java.lang.Runnable runnable) {
            this.val$transitionCompleteRunnable = runnable;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(android.transition.Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(android.transition.Transition transition) {
            this.val$transitionCompleteRunnable.run();
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(android.transition.Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(android.transition.Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(android.transition.Transition transition) {
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransitionCompat21$5, reason: invalid class name */
    public class AnonymousClass5 extends android.transition.Transition.EpicenterCallback {
        final /* synthetic */ android.graphics.Rect val$epicenter;

        public AnonymousClass5(android.graphics.Rect rect) {
            this.val$epicenter = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public android.graphics.Rect onGetEpicenter(android.transition.Transition transition) {
            android.graphics.Rect rect = this.val$epicenter;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.val$epicenter;
        }
    }

    private static boolean hasSimpleTarget(android.transition.Transition transition) {
        return (androidx.fragment.app.FragmentTransitionImpl.isNullOrEmpty(transition.getTargetIds()) && androidx.fragment.app.FragmentTransitionImpl.isNullOrEmpty(transition.getTargetNames()) && androidx.fragment.app.FragmentTransitionImpl.isNullOrEmpty(transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(java.lang.Object obj, android.view.View view) {
        if (obj != null) {
            ((android.transition.Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList) {
        android.transition.Transition transition = (android.transition.Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof android.transition.TransitionSet) {
            android.transition.TransitionSet transitionSet = (android.transition.TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                addTargets(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
            return;
        }
        if (hasSimpleTarget(transition) || !androidx.fragment.app.FragmentTransitionImpl.isNullOrEmpty(transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transition.addTarget(arrayList.get(i));
            i++;
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void beginDelayedTransition(android.view.ViewGroup viewGroup, java.lang.Object obj) {
        android.transition.TransitionManager.beginDelayedTransition(viewGroup, (android.transition.Transition) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(java.lang.Object obj) {
        return obj instanceof android.transition.Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public java.lang.Object cloneTransition(java.lang.Object obj) {
        if (obj != null) {
            return ((android.transition.Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public java.lang.Object mergeTransitionsInSequence(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        android.transition.Transition transition = (android.transition.Transition) obj;
        android.transition.Transition transition2 = (android.transition.Transition) obj2;
        android.transition.Transition transition3 = (android.transition.Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new android.transition.TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        android.transition.TransitionSet transitionSet = new android.transition.TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public java.lang.Object mergeTransitionsTogether(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        android.transition.TransitionSet transitionSet = new android.transition.TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((android.transition.Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((android.transition.Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((android.transition.Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(java.lang.Object obj, android.view.View view) {
        if (obj != null) {
            ((android.transition.Transition) obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2) {
        java.util.List<android.view.View> targets;
        android.transition.Transition transition = (android.transition.Transition) obj;
        int i = 0;
        if (transition instanceof android.transition.TransitionSet) {
            android.transition.TransitionSet transitionSet = (android.transition.TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                replaceTargets(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (hasSimpleTarget(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i < size) {
            transition.addTarget(arrayList2.get(i));
            i++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget(arrayList.get(size2));
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(java.lang.Object obj, android.view.View view, java.util.ArrayList<android.view.View> arrayList) {
        ((android.transition.Transition) obj).addListener(new androidx.fragment.app.FragmentTransitionCompat21.AnonymousClass2(view, arrayList));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(java.lang.Object obj, java.lang.Object obj2, java.util.ArrayList<android.view.View> arrayList, java.lang.Object obj3, java.util.ArrayList<android.view.View> arrayList2, java.lang.Object obj4, java.util.ArrayList<android.view.View> arrayList3) {
        ((android.transition.Transition) obj).addListener(new androidx.fragment.app.FragmentTransitionCompat21.AnonymousClass3(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(java.lang.Object obj, android.graphics.Rect rect) {
        if (obj != null) {
            ((android.transition.Transition) obj).setEpicenterCallback(new androidx.fragment.app.FragmentTransitionCompat21.AnonymousClass5(rect));
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(java.lang.Object obj, android.view.View view) {
        if (view != null) {
            android.graphics.Rect rect = new android.graphics.Rect();
            getBoundsOnScreen(view, rect);
            ((android.transition.Transition) obj).setEpicenterCallback(new androidx.fragment.app.FragmentTransitionCompat21.AnonymousClass1(rect));
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setListenerForTransitionEnd(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull java.lang.Runnable runnable) {
        ((android.transition.Transition) obj).addListener(new androidx.fragment.app.FragmentTransitionCompat21.AnonymousClass4(runnable));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(java.lang.Object obj, android.view.View view, java.util.ArrayList<android.view.View> arrayList) {
        android.transition.TransitionSet transitionSet = (android.transition.TransitionSet) obj;
        java.util.List<android.view.View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.FragmentTransitionImpl.bfsAddViewChildren(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        addTargets(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void swapSharedElementTargets(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2) {
        android.transition.TransitionSet transitionSet = (android.transition.TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            replaceTargets(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public java.lang.Object wrapTransitionInSet(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        android.transition.TransitionSet transitionSet = new android.transition.TransitionSet();
        transitionSet.addTransition((android.transition.Transition) obj);
        return transitionSet;
    }
}
