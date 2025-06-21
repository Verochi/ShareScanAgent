package androidx.transition;

@android.annotation.SuppressLint({"RestrictedApi"})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FragmentTransitionSupport extends androidx.fragment.app.FragmentTransitionImpl {

    /* renamed from: androidx.transition.FragmentTransitionSupport$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.transition.Transition.EpicenterCallback {
        final /* synthetic */ android.graphics.Rect val$epicenter;

        public AnonymousClass1(android.graphics.Rect rect) {
            this.val$epicenter = rect;
        }

        @Override // androidx.transition.Transition.EpicenterCallback
        public android.graphics.Rect onGetEpicenter(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            return this.val$epicenter;
        }
    }

    /* renamed from: androidx.transition.FragmentTransitionSupport$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.transition.Transition.TransitionListener {
        final /* synthetic */ java.util.ArrayList val$exitingViews;
        final /* synthetic */ android.view.View val$fragmentView;

        public AnonymousClass2(android.view.View view, java.util.ArrayList arrayList) {
            this.val$fragmentView = view;
            this.val$exitingViews = arrayList;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@androidx.annotation.NonNull androidx.transition.Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            transition.removeListener(this);
            this.val$fragmentView.setVisibility(8);
            int size = this.val$exitingViews.size();
            for (int i = 0; i < size; i++) {
                ((android.view.View) this.val$exitingViews.get(i)).setVisibility(0);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@androidx.annotation.NonNull androidx.transition.Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@androidx.annotation.NonNull androidx.transition.Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@androidx.annotation.NonNull androidx.transition.Transition transition) {
        }
    }

    /* renamed from: androidx.transition.FragmentTransitionSupport$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.transition.TransitionListenerAdapter {
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

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            java.lang.Object obj = this.val$enterTransition;
            if (obj != null) {
                androidx.transition.FragmentTransitionSupport.this.replaceTargets(obj, this.val$enteringViews, null);
            }
            java.lang.Object obj2 = this.val$exitTransition;
            if (obj2 != null) {
                androidx.transition.FragmentTransitionSupport.this.replaceTargets(obj2, this.val$exitingViews, null);
            }
            java.lang.Object obj3 = this.val$sharedElementTransition;
            if (obj3 != null) {
                androidx.transition.FragmentTransitionSupport.this.replaceTargets(obj3, this.val$sharedElementsIn, null);
            }
        }
    }

    /* renamed from: androidx.transition.FragmentTransitionSupport$4, reason: invalid class name */
    public class AnonymousClass4 extends androidx.transition.Transition.EpicenterCallback {
        final /* synthetic */ android.graphics.Rect val$epicenter;

        public AnonymousClass4(android.graphics.Rect rect) {
            this.val$epicenter = rect;
        }

        @Override // androidx.transition.Transition.EpicenterCallback
        public android.graphics.Rect onGetEpicenter(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            android.graphics.Rect rect = this.val$epicenter;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.val$epicenter;
        }
    }

    private static boolean hasSimpleTarget(androidx.transition.Transition transition) {
        return (androidx.fragment.app.FragmentTransitionImpl.isNullOrEmpty(transition.getTargetIds()) && androidx.fragment.app.FragmentTransitionImpl.isNullOrEmpty(transition.getTargetNames()) && androidx.fragment.app.FragmentTransitionImpl.isNullOrEmpty(transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(java.lang.Object obj, android.view.View view) {
        if (obj != null) {
            ((androidx.transition.Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList) {
        androidx.transition.Transition transition = (androidx.transition.Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof androidx.transition.TransitionSet) {
            androidx.transition.TransitionSet transitionSet = (androidx.transition.TransitionSet) transition;
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
        androidx.transition.TransitionManager.beginDelayedTransition(viewGroup, (androidx.transition.Transition) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(java.lang.Object obj) {
        return obj instanceof androidx.transition.Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public java.lang.Object cloneTransition(java.lang.Object obj) {
        if (obj != null) {
            return ((androidx.transition.Transition) obj).mo8clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public java.lang.Object mergeTransitionsInSequence(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        androidx.transition.Transition transition = (androidx.transition.Transition) obj;
        androidx.transition.Transition transition2 = (androidx.transition.Transition) obj2;
        androidx.transition.Transition transition3 = (androidx.transition.Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new androidx.transition.TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        androidx.transition.TransitionSet transitionSet = new androidx.transition.TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public java.lang.Object mergeTransitionsTogether(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        androidx.transition.TransitionSet transitionSet = new androidx.transition.TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((androidx.transition.Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((androidx.transition.Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((androidx.transition.Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(java.lang.Object obj, android.view.View view) {
        if (obj != null) {
            ((androidx.transition.Transition) obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2) {
        androidx.transition.Transition transition = (androidx.transition.Transition) obj;
        int i = 0;
        if (transition instanceof androidx.transition.TransitionSet) {
            androidx.transition.TransitionSet transitionSet = (androidx.transition.TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                replaceTargets(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (hasSimpleTarget(transition)) {
            return;
        }
        java.util.List<android.view.View> targets = transition.getTargets();
        if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                transition.addTarget(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.removeTarget(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(java.lang.Object obj, android.view.View view, java.util.ArrayList<android.view.View> arrayList) {
        ((androidx.transition.Transition) obj).addListener(new androidx.transition.FragmentTransitionSupport.AnonymousClass2(view, arrayList));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(java.lang.Object obj, java.lang.Object obj2, java.util.ArrayList<android.view.View> arrayList, java.lang.Object obj3, java.util.ArrayList<android.view.View> arrayList2, java.lang.Object obj4, java.util.ArrayList<android.view.View> arrayList3) {
        ((androidx.transition.Transition) obj).addListener(new androidx.transition.FragmentTransitionSupport.AnonymousClass3(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(java.lang.Object obj, android.graphics.Rect rect) {
        if (obj != null) {
            ((androidx.transition.Transition) obj).setEpicenterCallback(new androidx.transition.FragmentTransitionSupport.AnonymousClass4(rect));
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(java.lang.Object obj, android.view.View view) {
        if (view != null) {
            android.graphics.Rect rect = new android.graphics.Rect();
            getBoundsOnScreen(view, rect);
            ((androidx.transition.Transition) obj).setEpicenterCallback(new androidx.transition.FragmentTransitionSupport.AnonymousClass1(rect));
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(java.lang.Object obj, android.view.View view, java.util.ArrayList<android.view.View> arrayList) {
        androidx.transition.TransitionSet transitionSet = (androidx.transition.TransitionSet) obj;
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
        androidx.transition.TransitionSet transitionSet = (androidx.transition.TransitionSet) obj;
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
        androidx.transition.TransitionSet transitionSet = new androidx.transition.TransitionSet();
        transitionSet.addTransition((androidx.transition.Transition) obj);
        return transitionSet;
    }
}
