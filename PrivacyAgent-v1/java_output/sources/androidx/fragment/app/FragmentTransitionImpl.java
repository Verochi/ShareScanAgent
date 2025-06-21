package androidx.fragment.app;

@android.annotation.SuppressLint({"UnknownNullness"})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class FragmentTransitionImpl {

    /* renamed from: androidx.fragment.app.FragmentTransitionImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.ArrayList val$inNames;
        final /* synthetic */ int val$numSharedElements;
        final /* synthetic */ java.util.ArrayList val$outNames;
        final /* synthetic */ java.util.ArrayList val$sharedElementsIn;
        final /* synthetic */ java.util.ArrayList val$sharedElementsOut;

        public AnonymousClass1(int i, java.util.ArrayList arrayList, java.util.ArrayList arrayList2, java.util.ArrayList arrayList3, java.util.ArrayList arrayList4) {
            this.val$numSharedElements = i;
            this.val$sharedElementsIn = arrayList;
            this.val$inNames = arrayList2;
            this.val$sharedElementsOut = arrayList3;
            this.val$outNames = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.val$numSharedElements; i++) {
                androidx.core.view.ViewCompat.setTransitionName((android.view.View) this.val$sharedElementsIn.get(i), (java.lang.String) this.val$inNames.get(i));
                androidx.core.view.ViewCompat.setTransitionName((android.view.View) this.val$sharedElementsOut.get(i), (java.lang.String) this.val$outNames.get(i));
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransitionImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.util.Map val$nameOverrides;
        final /* synthetic */ java.util.ArrayList val$sharedElementsIn;

        public AnonymousClass2(java.util.ArrayList arrayList, java.util.Map map) {
            this.val$sharedElementsIn = arrayList;
            this.val$nameOverrides = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.val$sharedElementsIn.size();
            for (int i = 0; i < size; i++) {
                android.view.View view = (android.view.View) this.val$sharedElementsIn.get(i);
                java.lang.String transitionName = androidx.core.view.ViewCompat.getTransitionName(view);
                if (transitionName != null) {
                    androidx.core.view.ViewCompat.setTransitionName(view, androidx.fragment.app.FragmentTransitionImpl.findKeyForValue(this.val$nameOverrides, transitionName));
                }
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransitionImpl$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.util.Map val$nameOverrides;
        final /* synthetic */ java.util.ArrayList val$sharedElementsIn;

        public AnonymousClass3(java.util.ArrayList arrayList, java.util.Map map) {
            this.val$sharedElementsIn = arrayList;
            this.val$nameOverrides = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.val$sharedElementsIn.size();
            for (int i = 0; i < size; i++) {
                android.view.View view = (android.view.View) this.val$sharedElementsIn.get(i);
                androidx.core.view.ViewCompat.setTransitionName(view, (java.lang.String) this.val$nameOverrides.get(androidx.core.view.ViewCompat.getTransitionName(view)));
            }
        }
    }

    public static void bfsAddViewChildren(java.util.List<android.view.View> list, android.view.View view) {
        int size = list.size();
        if (containedBeforeIndex(list, view, size)) {
            return;
        }
        if (androidx.core.view.ViewCompat.getTransitionName(view) != null) {
            list.add(view);
        }
        for (int i = size; i < list.size(); i++) {
            android.view.View view2 = list.get(i);
            if (view2 instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    android.view.View childAt = viewGroup.getChildAt(i2);
                    if (!containedBeforeIndex(list, childAt, size) && androidx.core.view.ViewCompat.getTransitionName(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean containedBeforeIndex(java.util.List<android.view.View> list, android.view.View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static java.lang.String findKeyForValue(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static boolean isNullOrEmpty(java.util.List list) {
        return list == null || list.isEmpty();
    }

    public abstract void addTarget(java.lang.Object obj, android.view.View view);

    public abstract void addTargets(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList);

    public abstract void beginDelayedTransition(android.view.ViewGroup viewGroup, java.lang.Object obj);

    public abstract boolean canHandle(java.lang.Object obj);

    public void captureTransitioningViews(java.util.ArrayList<android.view.View> arrayList, android.view.View view) {
        if (view.getVisibility() == 0) {
            if (!(view instanceof android.view.ViewGroup)) {
                arrayList.add(view);
                return;
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            if (androidx.core.view.ViewGroupCompat.isTransitionGroup(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                captureTransitioningViews(arrayList, viewGroup.getChildAt(i));
            }
        }
    }

    public abstract java.lang.Object cloneTransition(java.lang.Object obj);

    public void findNamedViews(java.util.Map<java.lang.String, android.view.View> map, @androidx.annotation.NonNull android.view.View view) {
        if (view.getVisibility() == 0) {
            java.lang.String transitionName = androidx.core.view.ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    findNamedViews(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public void getBoundsOnScreen(android.view.View view, android.graphics.Rect rect) {
        if (androidx.core.view.ViewCompat.isAttachedToWindow(view)) {
            android.graphics.RectF rectF = new android.graphics.RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            java.lang.Object parent = view.getParent();
            while (parent instanceof android.view.View) {
                android.view.View view2 = (android.view.View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r1[0], r1[1]);
            rect.set(java.lang.Math.round(rectF.left), java.lang.Math.round(rectF.top), java.lang.Math.round(rectF.right), java.lang.Math.round(rectF.bottom));
        }
    }

    public abstract java.lang.Object mergeTransitionsInSequence(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3);

    public abstract java.lang.Object mergeTransitionsTogether(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3);

    public java.util.ArrayList<java.lang.String> prepareSetNameOverridesReordered(java.util.ArrayList<android.view.View> arrayList) {
        java.util.ArrayList<java.lang.String> arrayList2 = new java.util.ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            android.view.View view = arrayList.get(i);
            arrayList2.add(androidx.core.view.ViewCompat.getTransitionName(view));
            androidx.core.view.ViewCompat.setTransitionName(view, null);
        }
        return arrayList2;
    }

    public abstract void removeTarget(java.lang.Object obj, android.view.View view);

    public abstract void replaceTargets(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2);

    public abstract void scheduleHideFragmentView(java.lang.Object obj, android.view.View view, java.util.ArrayList<android.view.View> arrayList);

    public void scheduleNameReset(android.view.ViewGroup viewGroup, java.util.ArrayList<android.view.View> arrayList, java.util.Map<java.lang.String, java.lang.String> map) {
        androidx.core.view.OneShotPreDrawListener.add(viewGroup, new androidx.fragment.app.FragmentTransitionImpl.AnonymousClass3(arrayList, map));
    }

    public abstract void scheduleRemoveTargets(java.lang.Object obj, java.lang.Object obj2, java.util.ArrayList<android.view.View> arrayList, java.lang.Object obj3, java.util.ArrayList<android.view.View> arrayList2, java.lang.Object obj4, java.util.ArrayList<android.view.View> arrayList3);

    public abstract void setEpicenter(java.lang.Object obj, android.graphics.Rect rect);

    public abstract void setEpicenter(java.lang.Object obj, android.view.View view);

    public void setListenerForTransitionEnd(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull java.lang.Runnable runnable) {
        runnable.run();
    }

    public void setNameOverridesOrdered(android.view.View view, java.util.ArrayList<android.view.View> arrayList, java.util.Map<java.lang.String, java.lang.String> map) {
        androidx.core.view.OneShotPreDrawListener.add(view, new androidx.fragment.app.FragmentTransitionImpl.AnonymousClass2(arrayList, map));
    }

    public void setNameOverridesReordered(android.view.View view, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2, java.util.ArrayList<java.lang.String> arrayList3, java.util.Map<java.lang.String, java.lang.String> map) {
        int size = arrayList2.size();
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        for (int i = 0; i < size; i++) {
            android.view.View view2 = arrayList.get(i);
            java.lang.String transitionName = androidx.core.view.ViewCompat.getTransitionName(view2);
            arrayList4.add(transitionName);
            if (transitionName != null) {
                androidx.core.view.ViewCompat.setTransitionName(view2, null);
                java.lang.String str = map.get(transitionName);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i2))) {
                        androidx.core.view.ViewCompat.setTransitionName(arrayList2.get(i2), transitionName);
                        break;
                    }
                    i2++;
                }
            }
        }
        androidx.core.view.OneShotPreDrawListener.add(view, new androidx.fragment.app.FragmentTransitionImpl.AnonymousClass1(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void setSharedElementTargets(java.lang.Object obj, android.view.View view, java.util.ArrayList<android.view.View> arrayList);

    public abstract void swapSharedElementTargets(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2);

    public abstract java.lang.Object wrapTransitionInSet(java.lang.Object obj);
}
