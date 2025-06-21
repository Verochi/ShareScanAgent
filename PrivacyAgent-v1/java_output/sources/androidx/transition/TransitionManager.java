package androidx.transition;

/* loaded from: classes.dex */
public class TransitionManager {
    private static final java.lang.String LOG_TAG = "TransitionManager";
    private static androidx.transition.Transition sDefaultTransition = new androidx.transition.AutoTransition();
    private static java.lang.ThreadLocal<java.lang.ref.WeakReference<androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.Transition>>>> sRunningTransitions = new java.lang.ThreadLocal<>();
    static java.util.ArrayList<android.view.ViewGroup> sPendingTransitions = new java.util.ArrayList<>();
    private androidx.collection.ArrayMap<androidx.transition.Scene, androidx.transition.Transition> mSceneTransitions = new androidx.collection.ArrayMap<>();
    private androidx.collection.ArrayMap<androidx.transition.Scene, androidx.collection.ArrayMap<androidx.transition.Scene, androidx.transition.Transition>> mScenePairTransitions = new androidx.collection.ArrayMap<>();

    public static class MultiListener implements android.view.ViewTreeObserver.OnPreDrawListener, android.view.View.OnAttachStateChangeListener {
        android.view.ViewGroup mSceneRoot;
        androidx.transition.Transition mTransition;

        /* renamed from: androidx.transition.TransitionManager$MultiListener$1, reason: invalid class name */
        public class AnonymousClass1 extends androidx.transition.TransitionListenerAdapter {
            final /* synthetic */ androidx.collection.ArrayMap val$runningTransitions;

            public AnonymousClass1(androidx.collection.ArrayMap arrayMap) {
                this.val$runningTransitions = arrayMap;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@androidx.annotation.NonNull androidx.transition.Transition transition) {
                ((java.util.ArrayList) this.val$runningTransitions.get(androidx.transition.TransitionManager.MultiListener.this.mSceneRoot)).remove(transition);
                transition.removeListener(this);
            }
        }

        public MultiListener(androidx.transition.Transition transition, android.view.ViewGroup viewGroup) {
            this.mTransition = transition;
            this.mSceneRoot = viewGroup;
        }

        private void removeListeners() {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            removeListeners();
            if (!androidx.transition.TransitionManager.sPendingTransitions.remove(this.mSceneRoot)) {
                return true;
            }
            androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.Transition>> runningTransitions = androidx.transition.TransitionManager.getRunningTransitions();
            java.util.ArrayList<androidx.transition.Transition> arrayList = runningTransitions.get(this.mSceneRoot);
            java.util.ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>();
                runningTransitions.put(this.mSceneRoot, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new java.util.ArrayList(arrayList);
            }
            arrayList.add(this.mTransition);
            this.mTransition.addListener(new androidx.transition.TransitionManager.MultiListener.AnonymousClass1(runningTransitions));
            this.mTransition.captureValues(this.mSceneRoot, false);
            if (arrayList2 != null) {
                java.util.Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((androidx.transition.Transition) it.next()).resume(this.mSceneRoot);
                }
            }
            this.mTransition.playTransition(this.mSceneRoot);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            removeListeners();
            androidx.transition.TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
            java.util.ArrayList<androidx.transition.Transition> arrayList = androidx.transition.TransitionManager.getRunningTransitions().get(this.mSceneRoot);
            if (arrayList != null && arrayList.size() > 0) {
                java.util.Iterator<androidx.transition.Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.mSceneRoot);
                }
            }
            this.mTransition.clearValues(true);
        }
    }

    public static void beginDelayedTransition(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        beginDelayedTransition(viewGroup, null);
    }

    public static void beginDelayedTransition(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.Nullable androidx.transition.Transition transition) {
        if (sPendingTransitions.contains(viewGroup) || !androidx.core.view.ViewCompat.isLaidOut(viewGroup)) {
            return;
        }
        sPendingTransitions.add(viewGroup);
        if (transition == null) {
            transition = sDefaultTransition;
        }
        androidx.transition.Transition mo8clone = transition.mo8clone();
        sceneChangeSetup(viewGroup, mo8clone);
        androidx.transition.Scene.setCurrentScene(viewGroup, null);
        sceneChangeRunTransition(viewGroup, mo8clone);
    }

    private static void changeScene(androidx.transition.Scene scene, androidx.transition.Transition transition) {
        android.view.ViewGroup sceneRoot = scene.getSceneRoot();
        if (sPendingTransitions.contains(sceneRoot)) {
            return;
        }
        androidx.transition.Scene currentScene = androidx.transition.Scene.getCurrentScene(sceneRoot);
        if (transition == null) {
            if (currentScene != null) {
                currentScene.exit();
            }
            scene.enter();
            return;
        }
        sPendingTransitions.add(sceneRoot);
        androidx.transition.Transition mo8clone = transition.mo8clone();
        mo8clone.setSceneRoot(sceneRoot);
        if (currentScene != null && currentScene.isCreatedFromLayoutResource()) {
            mo8clone.setCanRemoveViews(true);
        }
        sceneChangeSetup(sceneRoot, mo8clone);
        scene.enter();
        sceneChangeRunTransition(sceneRoot, mo8clone);
    }

    public static void endTransitions(android.view.ViewGroup viewGroup) {
        sPendingTransitions.remove(viewGroup);
        java.util.ArrayList<androidx.transition.Transition> arrayList = getRunningTransitions().get(viewGroup);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList(arrayList);
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            ((androidx.transition.Transition) arrayList2.get(size)).forceToEnd(viewGroup);
        }
    }

    public static androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.Transition>> getRunningTransitions() {
        androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.Transition>> arrayMap;
        java.lang.ref.WeakReference<androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.Transition>>> weakReference = sRunningTransitions.get();
        if (weakReference != null && (arrayMap = weakReference.get()) != null) {
            return arrayMap;
        }
        androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.Transition>> arrayMap2 = new androidx.collection.ArrayMap<>();
        sRunningTransitions.set(new java.lang.ref.WeakReference<>(arrayMap2));
        return arrayMap2;
    }

    private androidx.transition.Transition getTransition(androidx.transition.Scene scene) {
        androidx.transition.Scene currentScene;
        androidx.collection.ArrayMap<androidx.transition.Scene, androidx.transition.Transition> arrayMap;
        androidx.transition.Transition transition;
        android.view.ViewGroup sceneRoot = scene.getSceneRoot();
        if (sceneRoot != null && (currentScene = androidx.transition.Scene.getCurrentScene(sceneRoot)) != null && (arrayMap = this.mScenePairTransitions.get(scene)) != null && (transition = arrayMap.get(currentScene)) != null) {
            return transition;
        }
        androidx.transition.Transition transition2 = this.mSceneTransitions.get(scene);
        return transition2 != null ? transition2 : sDefaultTransition;
    }

    public static void go(@androidx.annotation.NonNull androidx.transition.Scene scene) {
        changeScene(scene, sDefaultTransition);
    }

    public static void go(@androidx.annotation.NonNull androidx.transition.Scene scene, @androidx.annotation.Nullable androidx.transition.Transition transition) {
        changeScene(scene, transition);
    }

    private static void sceneChangeRunTransition(android.view.ViewGroup viewGroup, androidx.transition.Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        androidx.transition.TransitionManager.MultiListener multiListener = new androidx.transition.TransitionManager.MultiListener(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(multiListener);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
    }

    private static void sceneChangeSetup(android.view.ViewGroup viewGroup, androidx.transition.Transition transition) {
        java.util.ArrayList<androidx.transition.Transition> arrayList = getRunningTransitions().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            java.util.Iterator<androidx.transition.Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.captureValues(viewGroup, true);
        }
        androidx.transition.Scene currentScene = androidx.transition.Scene.getCurrentScene(viewGroup);
        if (currentScene != null) {
            currentScene.exit();
        }
    }

    public void setTransition(@androidx.annotation.NonNull androidx.transition.Scene scene, @androidx.annotation.NonNull androidx.transition.Scene scene2, @androidx.annotation.Nullable androidx.transition.Transition transition) {
        androidx.collection.ArrayMap<androidx.transition.Scene, androidx.transition.Transition> arrayMap = this.mScenePairTransitions.get(scene2);
        if (arrayMap == null) {
            arrayMap = new androidx.collection.ArrayMap<>();
            this.mScenePairTransitions.put(scene2, arrayMap);
        }
        arrayMap.put(scene, transition);
    }

    public void setTransition(@androidx.annotation.NonNull androidx.transition.Scene scene, @androidx.annotation.Nullable androidx.transition.Transition transition) {
        this.mSceneTransitions.put(scene, transition);
    }

    public void transitionTo(@androidx.annotation.NonNull androidx.transition.Scene scene) {
        changeScene(scene, getTransition(scene));
    }
}
