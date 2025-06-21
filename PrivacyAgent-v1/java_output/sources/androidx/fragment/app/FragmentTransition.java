package androidx.fragment.app;

/* loaded from: classes.dex */
class FragmentTransition {
    private static final int[] INVERSE_OPS = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    static final androidx.fragment.app.FragmentTransitionImpl PLATFORM_IMPL = new androidx.fragment.app.FragmentTransitionCompat21();
    static final androidx.fragment.app.FragmentTransitionImpl SUPPORT_IMPL = resolveSupportImpl();

    /* renamed from: androidx.fragment.app.FragmentTransition$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ androidx.fragment.app.FragmentTransition.Callback val$callback;
        final /* synthetic */ androidx.fragment.app.Fragment val$outFragment;
        final /* synthetic */ androidx.core.os.CancellationSignal val$signal;

        public AnonymousClass1(androidx.fragment.app.FragmentTransition.Callback callback, androidx.fragment.app.Fragment fragment, androidx.core.os.CancellationSignal cancellationSignal) {
            this.val$callback = callback;
            this.val$outFragment = fragment;
            this.val$signal = cancellationSignal;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callback.onComplete(this.val$outFragment, this.val$signal);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransition$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.util.ArrayList val$exitingViews;

        public AnonymousClass2(java.util.ArrayList arrayList) {
            this.val$exitingViews = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.fragment.app.FragmentTransition.setViewVisibility(this.val$exitingViews, 4);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransition$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ androidx.fragment.app.FragmentTransition.Callback val$callback;
        final /* synthetic */ androidx.fragment.app.Fragment val$outFragment;
        final /* synthetic */ androidx.core.os.CancellationSignal val$signal;

        public AnonymousClass3(androidx.fragment.app.FragmentTransition.Callback callback, androidx.fragment.app.Fragment fragment, androidx.core.os.CancellationSignal cancellationSignal) {
            this.val$callback = callback;
            this.val$outFragment = fragment;
            this.val$signal = cancellationSignal;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callback.onComplete(this.val$outFragment, this.val$signal);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransition$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object val$enterTransition;
        final /* synthetic */ java.util.ArrayList val$enteringViews;
        final /* synthetic */ java.lang.Object val$exitTransition;
        final /* synthetic */ java.util.ArrayList val$exitingViews;
        final /* synthetic */ androidx.fragment.app.FragmentTransitionImpl val$impl;
        final /* synthetic */ androidx.fragment.app.Fragment val$inFragment;
        final /* synthetic */ android.view.View val$nonExistentView;
        final /* synthetic */ java.util.ArrayList val$sharedElementsIn;

        public AnonymousClass4(java.lang.Object obj, androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, android.view.View view, androidx.fragment.app.Fragment fragment, java.util.ArrayList arrayList, java.util.ArrayList arrayList2, java.util.ArrayList arrayList3, java.lang.Object obj2) {
            this.val$enterTransition = obj;
            this.val$impl = fragmentTransitionImpl;
            this.val$nonExistentView = view;
            this.val$inFragment = fragment;
            this.val$sharedElementsIn = arrayList;
            this.val$enteringViews = arrayList2;
            this.val$exitingViews = arrayList3;
            this.val$exitTransition = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Object obj = this.val$enterTransition;
            if (obj != null) {
                this.val$impl.removeTarget(obj, this.val$nonExistentView);
                this.val$enteringViews.addAll(androidx.fragment.app.FragmentTransition.configureEnteringExitingViews(this.val$impl, this.val$enterTransition, this.val$inFragment, this.val$sharedElementsIn, this.val$nonExistentView));
            }
            if (this.val$exitingViews != null) {
                if (this.val$exitTransition != null) {
                    java.util.ArrayList<android.view.View> arrayList = new java.util.ArrayList<>();
                    arrayList.add(this.val$nonExistentView);
                    this.val$impl.replaceTargets(this.val$exitTransition, this.val$exitingViews, arrayList);
                }
                this.val$exitingViews.clear();
                this.val$exitingViews.add(this.val$nonExistentView);
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransition$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ android.graphics.Rect val$epicenter;
        final /* synthetic */ android.view.View val$epicenterView;
        final /* synthetic */ androidx.fragment.app.FragmentTransitionImpl val$impl;
        final /* synthetic */ androidx.fragment.app.Fragment val$inFragment;
        final /* synthetic */ boolean val$inIsPop;
        final /* synthetic */ androidx.collection.ArrayMap val$inSharedElements;
        final /* synthetic */ androidx.fragment.app.Fragment val$outFragment;

        public AnonymousClass5(androidx.fragment.app.Fragment fragment, androidx.fragment.app.Fragment fragment2, boolean z, androidx.collection.ArrayMap arrayMap, android.view.View view, androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, android.graphics.Rect rect) {
            this.val$inFragment = fragment;
            this.val$outFragment = fragment2;
            this.val$inIsPop = z;
            this.val$inSharedElements = arrayMap;
            this.val$epicenterView = view;
            this.val$impl = fragmentTransitionImpl;
            this.val$epicenter = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.fragment.app.FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, this.val$inSharedElements, false);
            android.view.View view = this.val$epicenterView;
            if (view != null) {
                this.val$impl.getBoundsOnScreen(view, this.val$epicenter);
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransition$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object val$enterTransition;
        final /* synthetic */ java.lang.Object val$finalSharedElementTransition;
        final /* synthetic */ androidx.fragment.app.FragmentTransition.FragmentContainerTransition val$fragments;
        final /* synthetic */ androidx.fragment.app.FragmentTransitionImpl val$impl;
        final /* synthetic */ android.graphics.Rect val$inEpicenter;
        final /* synthetic */ androidx.fragment.app.Fragment val$inFragment;
        final /* synthetic */ boolean val$inIsPop;
        final /* synthetic */ androidx.collection.ArrayMap val$nameOverrides;
        final /* synthetic */ android.view.View val$nonExistentView;
        final /* synthetic */ androidx.fragment.app.Fragment val$outFragment;
        final /* synthetic */ java.util.ArrayList val$sharedElementsIn;
        final /* synthetic */ java.util.ArrayList val$sharedElementsOut;

        public AnonymousClass6(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, androidx.collection.ArrayMap arrayMap, java.lang.Object obj, androidx.fragment.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, java.util.ArrayList arrayList, android.view.View view, androidx.fragment.app.Fragment fragment, androidx.fragment.app.Fragment fragment2, boolean z, java.util.ArrayList arrayList2, java.lang.Object obj2, android.graphics.Rect rect) {
            this.val$impl = fragmentTransitionImpl;
            this.val$nameOverrides = arrayMap;
            this.val$finalSharedElementTransition = obj;
            this.val$fragments = fragmentContainerTransition;
            this.val$sharedElementsIn = arrayList;
            this.val$nonExistentView = view;
            this.val$inFragment = fragment;
            this.val$outFragment = fragment2;
            this.val$inIsPop = z;
            this.val$sharedElementsOut = arrayList2;
            this.val$enterTransition = obj2;
            this.val$inEpicenter = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.collection.ArrayMap<java.lang.String, android.view.View> captureInSharedElements = androidx.fragment.app.FragmentTransition.captureInSharedElements(this.val$impl, this.val$nameOverrides, this.val$finalSharedElementTransition, this.val$fragments);
            if (captureInSharedElements != null) {
                this.val$sharedElementsIn.addAll(captureInSharedElements.values());
                this.val$sharedElementsIn.add(this.val$nonExistentView);
            }
            androidx.fragment.app.FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, captureInSharedElements, false);
            java.lang.Object obj = this.val$finalSharedElementTransition;
            if (obj != null) {
                this.val$impl.swapSharedElementTargets(obj, this.val$sharedElementsOut, this.val$sharedElementsIn);
                android.view.View inEpicenterView = androidx.fragment.app.FragmentTransition.getInEpicenterView(captureInSharedElements, this.val$fragments, this.val$enterTransition, this.val$inIsPop);
                if (inEpicenterView != null) {
                    this.val$impl.getBoundsOnScreen(inEpicenterView, this.val$inEpicenter);
                }
            }
        }
    }

    public interface Callback {
        void onComplete(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal);

        void onStart(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull androidx.core.os.CancellationSignal cancellationSignal);
    }

    public static class FragmentContainerTransition {
        public androidx.fragment.app.Fragment firstOut;
        public boolean firstOutIsPop;
        public androidx.fragment.app.BackStackRecord firstOutTransaction;
        public androidx.fragment.app.Fragment lastIn;
        public boolean lastInIsPop;
        public androidx.fragment.app.BackStackRecord lastInTransaction;
    }

    private FragmentTransition() {
    }

    private static void addSharedElementsWithMatchingNames(java.util.ArrayList<android.view.View> arrayList, androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap, java.util.Collection<java.lang.String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            android.view.View valueAt = arrayMap.valueAt(size);
            if (collection.contains(androidx.core.view.ViewCompat.getTransitionName(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0039, code lost:
    
        if (r0.mAdded != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x008c, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x006e, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x008a, code lost:
    
        if (r0.mHidden == false) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void addToFirstInLastOut(androidx.fragment.app.BackStackRecord backStackRecord, androidx.fragment.app.FragmentTransaction.Op op, android.util.SparseArray<androidx.fragment.app.FragmentTransition.FragmentContainerTransition> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        androidx.fragment.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition;
        androidx.fragment.app.Fragment fragment = op.mFragment;
        if (fragment == null || (i = fragment.mContainerId) == 0) {
            return;
        }
        int i2 = z ? INVERSE_OPS[op.mCmd] : op.mCmd;
        boolean z6 = false;
        boolean z7 = true;
        if (i2 != 1) {
            if (i2 != 3) {
                if (i2 == 4) {
                    boolean z8 = !z2 ? false : false;
                    z5 = z8;
                    z4 = true;
                    z7 = false;
                    fragmentContainerTransition = sparseArray.get(i);
                    if (z6) {
                    }
                    if (!z2) {
                    }
                    if (z5) {
                    }
                    if (z2) {
                    }
                } else if (i2 != 5) {
                    if (i2 != 6) {
                        if (i2 != 7) {
                            z4 = false;
                            z7 = false;
                            z5 = false;
                            fragmentContainerTransition = sparseArray.get(i);
                            if (z6) {
                                fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i);
                                fragmentContainerTransition.lastIn = fragment;
                                fragmentContainerTransition.lastInIsPop = z;
                                fragmentContainerTransition.lastInTransaction = backStackRecord;
                            }
                            if (!z2 && z7) {
                                if (fragmentContainerTransition != null && fragmentContainerTransition.firstOut == fragment) {
                                    fragmentContainerTransition.firstOut = null;
                                }
                                if (!backStackRecord.mReorderingAllowed) {
                                    androidx.fragment.app.FragmentManager fragmentManager = backStackRecord.mManager;
                                    fragmentManager.getFragmentStore().makeActive(fragmentManager.createOrGetFragmentStateManager(fragment));
                                    fragmentManager.moveToState(fragment);
                                }
                            }
                            if (z5 && (fragmentContainerTransition == null || fragmentContainerTransition.firstOut == null)) {
                                fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i);
                                fragmentContainerTransition.firstOut = fragment;
                                fragmentContainerTransition.firstOutIsPop = z;
                                fragmentContainerTransition.firstOutTransaction = backStackRecord;
                            }
                            if (z2 || !z4 || fragmentContainerTransition == null || fragmentContainerTransition.lastIn != fragment) {
                                return;
                            }
                            fragmentContainerTransition.lastIn = null;
                            return;
                        }
                    }
                } else {
                    if (z2) {
                        if (fragment.mHiddenChanged) {
                            if (!fragment.mHidden) {
                            }
                        }
                        z3 = false;
                        z6 = z3;
                        z4 = false;
                        z5 = false;
                        fragmentContainerTransition = sparseArray.get(i);
                        if (z6) {
                        }
                        if (!z2) {
                            if (fragmentContainerTransition != null) {
                                fragmentContainerTransition.firstOut = null;
                            }
                            if (!backStackRecord.mReorderingAllowed) {
                            }
                        }
                        if (z5) {
                            fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i);
                            fragmentContainerTransition.firstOut = fragment;
                            fragmentContainerTransition.firstOutIsPop = z;
                            fragmentContainerTransition.firstOutTransaction = backStackRecord;
                        }
                        if (z2) {
                            return;
                        } else {
                            return;
                        }
                    }
                    z3 = fragment.mHidden;
                    z6 = z3;
                    z4 = false;
                    z5 = false;
                    fragmentContainerTransition = sparseArray.get(i);
                    if (z6) {
                    }
                    if (!z2) {
                    }
                    if (z5) {
                    }
                    if (z2) {
                    }
                }
            }
            if (!z2) {
            }
            z5 = z8;
            z4 = true;
            z7 = false;
            fragmentContainerTransition = sparseArray.get(i);
            if (z6) {
            }
            if (!z2) {
            }
            if (z5) {
            }
            if (z2) {
            }
        }
        if (z2) {
            z3 = fragment.mIsNewlyAdded;
            z6 = z3;
            z4 = false;
            z5 = false;
            fragmentContainerTransition = sparseArray.get(i);
            if (z6) {
            }
            if (!z2) {
            }
            if (z5) {
            }
            if (z2) {
            }
        } else {
            if (!fragment.mAdded) {
            }
            z3 = false;
            z6 = z3;
            z4 = false;
            z5 = false;
            fragmentContainerTransition = sparseArray.get(i);
            if (z6) {
            }
            if (!z2) {
            }
            if (z5) {
            }
            if (z2) {
            }
        }
    }

    public static void calculateFragments(androidx.fragment.app.BackStackRecord backStackRecord, android.util.SparseArray<androidx.fragment.app.FragmentTransition.FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.mOps.size();
        for (int i = 0; i < size; i++) {
            addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(i), sparseArray, false, z);
        }
    }

    private static androidx.collection.ArrayMap<java.lang.String, java.lang.String> calculateNameOverrides(int i, java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, int i2, int i3) {
        java.util.ArrayList<java.lang.String> arrayList3;
        java.util.ArrayList<java.lang.String> arrayList4;
        androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap = new androidx.collection.ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            androidx.fragment.app.BackStackRecord backStackRecord = arrayList.get(i4);
            if (backStackRecord.interactsWith(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                java.util.ArrayList<java.lang.String> arrayList5 = backStackRecord.mSharedElementSourceNames;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.mSharedElementSourceNames;
                        arrayList4 = backStackRecord.mSharedElementTargetNames;
                    } else {
                        java.util.ArrayList<java.lang.String> arrayList6 = backStackRecord.mSharedElementSourceNames;
                        arrayList3 = backStackRecord.mSharedElementTargetNames;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        java.lang.String str = arrayList4.get(i5);
                        java.lang.String str2 = arrayList3.get(i5);
                        java.lang.String remove = arrayMap.remove(str2);
                        if (remove != null) {
                            arrayMap.put(str, remove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    public static void calculatePopFragments(androidx.fragment.app.BackStackRecord backStackRecord, android.util.SparseArray<androidx.fragment.app.FragmentTransition.FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.mManager.getContainer().onHasView()) {
            for (int size = backStackRecord.mOps.size() - 1; size >= 0; size--) {
                addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(size), sparseArray, true, z);
            }
        }
    }

    public static void callSharedElementStartEnd(androidx.fragment.app.Fragment fragment, androidx.fragment.app.Fragment fragment2, boolean z, androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap, boolean z2) {
        androidx.core.app.SharedElementCallback enterTransitionCallback = z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(arrayMap.keyAt(i));
                arrayList.add(arrayMap.valueAt(i));
            }
            if (z2) {
                enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    private static boolean canHandleAll(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, java.util.List<java.lang.Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!fragmentTransitionImpl.canHandle(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static androidx.collection.ArrayMap<java.lang.String, android.view.View> captureInSharedElements(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, java.lang.Object obj, androidx.fragment.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition) {
        androidx.core.app.SharedElementCallback enterTransitionCallback;
        java.util.ArrayList<java.lang.String> arrayList;
        java.lang.String findKeyForValue;
        androidx.fragment.app.Fragment fragment = fragmentContainerTransition.lastIn;
        android.view.View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap2 = new androidx.collection.ArrayMap<>();
        fragmentTransitionImpl.findNamedViews(arrayMap2, view);
        androidx.fragment.app.BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (fragmentContainerTransition.lastInIsPop) {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
            arrayMap2.retainAll(arrayMap.values());
        }
        if (enterTransitionCallback != null) {
            enterTransitionCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                java.lang.String str = arrayList.get(size);
                android.view.View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    java.lang.String findKeyForValue2 = findKeyForValue(arrayMap, str);
                    if (findKeyForValue2 != null) {
                        arrayMap.remove(findKeyForValue2);
                    }
                } else if (!str.equals(androidx.core.view.ViewCompat.getTransitionName(view2)) && (findKeyForValue = findKeyForValue(arrayMap, str)) != null) {
                    arrayMap.put(findKeyForValue, androidx.core.view.ViewCompat.getTransitionName(view2));
                }
            }
        } else {
            retainValues(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static androidx.collection.ArrayMap<java.lang.String, android.view.View> captureOutSharedElements(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, java.lang.Object obj, androidx.fragment.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition) {
        androidx.core.app.SharedElementCallback exitTransitionCallback;
        java.util.ArrayList<java.lang.String> arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        androidx.fragment.app.Fragment fragment = fragmentContainerTransition.firstOut;
        androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap2 = new androidx.collection.ArrayMap<>();
        fragmentTransitionImpl.findNamedViews(arrayMap2, fragment.requireView());
        androidx.fragment.app.BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
        if (fragmentContainerTransition.firstOutIsPop) {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        } else {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
        }
        if (exitTransitionCallback != null) {
            exitTransitionCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                java.lang.String str = arrayList.get(size);
                android.view.View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(androidx.core.view.ViewCompat.getTransitionName(view))) {
                    arrayMap.put(androidx.core.view.ViewCompat.getTransitionName(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    private static androidx.fragment.app.FragmentTransitionImpl chooseImpl(androidx.fragment.app.Fragment fragment, androidx.fragment.app.Fragment fragment2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (fragment != null) {
            java.lang.Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            java.lang.Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            java.lang.Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            java.lang.Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            java.lang.Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            java.lang.Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl = PLATFORM_IMPL;
        if (fragmentTransitionImpl != null && canHandleAll(fragmentTransitionImpl, arrayList)) {
            return fragmentTransitionImpl;
        }
        androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl2 = SUPPORT_IMPL;
        if (fragmentTransitionImpl2 != null && canHandleAll(fragmentTransitionImpl2, arrayList)) {
            return fragmentTransitionImpl2;
        }
        if (fragmentTransitionImpl == null && fragmentTransitionImpl2 == null) {
            return null;
        }
        throw new java.lang.IllegalArgumentException("Invalid Transition types");
    }

    public static java.util.ArrayList<android.view.View> configureEnteringExitingViews(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, java.lang.Object obj, androidx.fragment.app.Fragment fragment, java.util.ArrayList<android.view.View> arrayList, android.view.View view) {
        if (obj == null) {
            return null;
        }
        java.util.ArrayList<android.view.View> arrayList2 = new java.util.ArrayList<>();
        android.view.View view2 = fragment.getView();
        if (view2 != null) {
            fragmentTransitionImpl.captureTransitioningViews(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        fragmentTransitionImpl.addTargets(obj, arrayList2);
        return arrayList2;
    }

    private static java.lang.Object configureSharedElementsOrdered(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, android.view.ViewGroup viewGroup, android.view.View view, androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, androidx.fragment.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2, java.lang.Object obj, java.lang.Object obj2) {
        java.lang.Object sharedElementTransition;
        androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap2;
        java.lang.Object obj3;
        android.graphics.Rect rect;
        androidx.fragment.app.Fragment fragment = fragmentContainerTransition.lastIn;
        androidx.fragment.app.Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            sharedElementTransition = null;
        } else {
            sharedElementTransition = getSharedElementTransition(fragmentTransitionImpl, fragment, fragment2, z);
            arrayMap2 = arrayMap;
        }
        androidx.collection.ArrayMap<java.lang.String, android.view.View> captureOutSharedElements = captureOutSharedElements(fragmentTransitionImpl, arrayMap2, sharedElementTransition, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(captureOutSharedElements.values());
            obj3 = sharedElementTransition;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj3 != null) {
            rect = new android.graphics.Rect();
            fragmentTransitionImpl.setSharedElementTargets(obj3, view, arrayList);
            setOutEpicenter(fragmentTransitionImpl, obj3, obj2, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            if (obj != null) {
                fragmentTransitionImpl.setEpicenter(obj, rect);
            }
        } else {
            rect = null;
        }
        androidx.core.view.OneShotPreDrawListener.add(viewGroup, new androidx.fragment.app.FragmentTransition.AnonymousClass6(fragmentTransitionImpl, arrayMap, obj3, fragmentContainerTransition, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    private static java.lang.Object configureSharedElementsReordered(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, android.view.ViewGroup viewGroup, android.view.View view, androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, androidx.fragment.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2, java.lang.Object obj, java.lang.Object obj2) {
        java.lang.Object obj3;
        android.view.View view2;
        android.graphics.Rect rect;
        androidx.fragment.app.Fragment fragment = fragmentContainerTransition.lastIn;
        androidx.fragment.app.Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        java.lang.Object sharedElementTransition = arrayMap.isEmpty() ? null : getSharedElementTransition(fragmentTransitionImpl, fragment, fragment2, z);
        androidx.collection.ArrayMap<java.lang.String, android.view.View> captureOutSharedElements = captureOutSharedElements(fragmentTransitionImpl, arrayMap, sharedElementTransition, fragmentContainerTransition);
        androidx.collection.ArrayMap<java.lang.String, android.view.View> captureInSharedElements = captureInSharedElements(fragmentTransitionImpl, arrayMap, sharedElementTransition, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            if (captureOutSharedElements != null) {
                captureOutSharedElements.clear();
            }
            if (captureInSharedElements != null) {
                captureInSharedElements.clear();
            }
            obj3 = null;
        } else {
            addSharedElementsWithMatchingNames(arrayList, captureOutSharedElements, arrayMap.keySet());
            addSharedElementsWithMatchingNames(arrayList2, captureInSharedElements, arrayMap.values());
            obj3 = sharedElementTransition;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj3 != null) {
            arrayList2.add(view);
            fragmentTransitionImpl.setSharedElementTargets(obj3, view, arrayList);
            setOutEpicenter(fragmentTransitionImpl, obj3, obj2, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            android.graphics.Rect rect2 = new android.graphics.Rect();
            android.view.View inEpicenterView = getInEpicenterView(captureInSharedElements, fragmentContainerTransition, obj, z);
            if (inEpicenterView != null) {
                fragmentTransitionImpl.setEpicenter(obj, rect2);
            }
            rect = rect2;
            view2 = inEpicenterView;
        } else {
            view2 = null;
            rect = null;
        }
        androidx.core.view.OneShotPreDrawListener.add(viewGroup, new androidx.fragment.app.FragmentTransition.AnonymousClass5(fragment, fragment2, z, captureInSharedElements, view2, fragmentTransitionImpl, rect));
        return obj3;
    }

    private static void configureTransitionsOrdered(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, androidx.fragment.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, android.view.View view, androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, androidx.fragment.app.FragmentTransition.Callback callback) {
        java.lang.Object obj;
        androidx.fragment.app.Fragment fragment = fragmentContainerTransition.lastIn;
        androidx.fragment.app.Fragment fragment2 = fragmentContainerTransition.firstOut;
        androidx.fragment.app.FragmentTransitionImpl chooseImpl = chooseImpl(fragment2, fragment);
        if (chooseImpl == null) {
            return;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        boolean z2 = fragmentContainerTransition.firstOutIsPop;
        java.lang.Object enterTransition = getEnterTransition(chooseImpl, fragment, z);
        java.lang.Object exitTransition = getExitTransition(chooseImpl, fragment2, z2);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList<android.view.View> arrayList2 = new java.util.ArrayList<>();
        java.lang.Object configureSharedElementsOrdered = configureSharedElementsOrdered(chooseImpl, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList, arrayList2, enterTransition, exitTransition);
        if (enterTransition == null && configureSharedElementsOrdered == null) {
            obj = exitTransition;
            if (obj == null) {
                return;
            }
        } else {
            obj = exitTransition;
        }
        java.util.ArrayList<android.view.View> configureEnteringExitingViews = configureEnteringExitingViews(chooseImpl, obj, fragment2, arrayList, view);
        if (configureEnteringExitingViews == null || configureEnteringExitingViews.isEmpty()) {
            obj = null;
        }
        java.lang.Object obj2 = obj;
        chooseImpl.addTarget(enterTransition, view);
        java.lang.Object mergeTransitions = mergeTransitions(chooseImpl, enterTransition, obj2, configureSharedElementsOrdered, fragment, fragmentContainerTransition.lastInIsPop);
        if (fragment2 != null && configureEnteringExitingViews != null && (configureEnteringExitingViews.size() > 0 || arrayList.size() > 0)) {
            androidx.core.os.CancellationSignal cancellationSignal = new androidx.core.os.CancellationSignal();
            callback.onStart(fragment2, cancellationSignal);
            chooseImpl.setListenerForTransitionEnd(fragment2, mergeTransitions, cancellationSignal, new androidx.fragment.app.FragmentTransition.AnonymousClass3(callback, fragment2, cancellationSignal));
        }
        if (mergeTransitions != null) {
            java.util.ArrayList<android.view.View> arrayList3 = new java.util.ArrayList<>();
            chooseImpl.scheduleRemoveTargets(mergeTransitions, enterTransition, arrayList3, obj2, configureEnteringExitingViews, configureSharedElementsOrdered, arrayList2);
            scheduleTargetChange(chooseImpl, viewGroup, fragment, view, arrayList2, enterTransition, arrayList3, obj2, configureEnteringExitingViews);
            chooseImpl.setNameOverridesOrdered(viewGroup, arrayList2, arrayMap);
            chooseImpl.beginDelayedTransition(viewGroup, mergeTransitions);
            chooseImpl.scheduleNameReset(viewGroup, arrayList2, arrayMap);
        }
    }

    private static void configureTransitionsReordered(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, androidx.fragment.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, android.view.View view, androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, androidx.fragment.app.FragmentTransition.Callback callback) {
        java.lang.Object obj;
        androidx.fragment.app.Fragment fragment = fragmentContainerTransition.lastIn;
        androidx.fragment.app.Fragment fragment2 = fragmentContainerTransition.firstOut;
        androidx.fragment.app.FragmentTransitionImpl chooseImpl = chooseImpl(fragment2, fragment);
        if (chooseImpl == null) {
            return;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        boolean z2 = fragmentContainerTransition.firstOutIsPop;
        java.util.ArrayList<android.view.View> arrayList = new java.util.ArrayList<>();
        java.util.ArrayList<android.view.View> arrayList2 = new java.util.ArrayList<>();
        java.lang.Object enterTransition = getEnterTransition(chooseImpl, fragment, z);
        java.lang.Object exitTransition = getExitTransition(chooseImpl, fragment2, z2);
        java.lang.Object configureSharedElementsReordered = configureSharedElementsReordered(chooseImpl, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList2, arrayList, enterTransition, exitTransition);
        if (enterTransition == null && configureSharedElementsReordered == null) {
            obj = exitTransition;
            if (obj == null) {
                return;
            }
        } else {
            obj = exitTransition;
        }
        java.util.ArrayList<android.view.View> configureEnteringExitingViews = configureEnteringExitingViews(chooseImpl, obj, fragment2, arrayList2, view);
        java.util.ArrayList<android.view.View> configureEnteringExitingViews2 = configureEnteringExitingViews(chooseImpl, enterTransition, fragment, arrayList, view);
        setViewVisibility(configureEnteringExitingViews2, 4);
        java.lang.Object mergeTransitions = mergeTransitions(chooseImpl, enterTransition, obj, configureSharedElementsReordered, fragment, z);
        if (fragment2 != null && configureEnteringExitingViews != null && (configureEnteringExitingViews.size() > 0 || arrayList2.size() > 0)) {
            androidx.core.os.CancellationSignal cancellationSignal = new androidx.core.os.CancellationSignal();
            callback.onStart(fragment2, cancellationSignal);
            chooseImpl.setListenerForTransitionEnd(fragment2, mergeTransitions, cancellationSignal, new androidx.fragment.app.FragmentTransition.AnonymousClass1(callback, fragment2, cancellationSignal));
        }
        if (mergeTransitions != null) {
            replaceHide(chooseImpl, obj, fragment2, configureEnteringExitingViews);
            java.util.ArrayList<java.lang.String> prepareSetNameOverridesReordered = chooseImpl.prepareSetNameOverridesReordered(arrayList);
            chooseImpl.scheduleRemoveTargets(mergeTransitions, enterTransition, configureEnteringExitingViews2, obj, configureEnteringExitingViews, configureSharedElementsReordered, arrayList);
            chooseImpl.beginDelayedTransition(viewGroup, mergeTransitions);
            chooseImpl.setNameOverridesReordered(viewGroup, arrayList2, arrayList, prepareSetNameOverridesReordered, arrayMap);
            setViewVisibility(configureEnteringExitingViews2, 0);
            chooseImpl.swapSharedElementTargets(configureSharedElementsReordered, arrayList2, arrayList);
        }
    }

    private static androidx.fragment.app.FragmentTransition.FragmentContainerTransition ensureContainer(androidx.fragment.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, android.util.SparseArray<androidx.fragment.app.FragmentTransition.FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition != null) {
            return fragmentContainerTransition;
        }
        androidx.fragment.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition2 = new androidx.fragment.app.FragmentTransition.FragmentContainerTransition();
        sparseArray.put(i, fragmentContainerTransition2);
        return fragmentContainerTransition2;
    }

    public static java.lang.String findKeyForValue(androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, java.lang.String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return arrayMap.keyAt(i);
            }
        }
        return null;
    }

    private static java.lang.Object getEnterTransition(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, androidx.fragment.app.Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return fragmentTransitionImpl.cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static java.lang.Object getExitTransition(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, androidx.fragment.app.Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return fragmentTransitionImpl.cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    public static android.view.View getInEpicenterView(androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap, androidx.fragment.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, java.lang.Object obj, boolean z) {
        java.util.ArrayList<java.lang.String> arrayList;
        androidx.fragment.app.BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj == null || arrayMap == null || (arrayList = backStackRecord.mSharedElementSourceNames) == null || arrayList.isEmpty()) {
            return null;
        }
        return arrayMap.get(z ? backStackRecord.mSharedElementSourceNames.get(0) : backStackRecord.mSharedElementTargetNames.get(0));
    }

    private static java.lang.Object getSharedElementTransition(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, androidx.fragment.app.Fragment fragment, androidx.fragment.app.Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static java.lang.Object mergeTransitions(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, androidx.fragment.app.Fragment fragment, boolean z) {
        return (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3) : fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    private static void replaceHide(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, java.lang.Object obj, androidx.fragment.app.Fragment fragment, java.util.ArrayList<android.view.View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fragmentTransitionImpl.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            androidx.core.view.OneShotPreDrawListener.add(fragment.mContainer, new androidx.fragment.app.FragmentTransition.AnonymousClass2(arrayList));
        }
    }

    private static androidx.fragment.app.FragmentTransitionImpl resolveSupportImpl() {
        try {
            return (androidx.fragment.app.FragmentTransitionImpl) androidx.transition.FragmentTransitionSupport.class.getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static void retainValues(@androidx.annotation.NonNull androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, @androidx.annotation.NonNull androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    private static void scheduleTargetChange(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, android.view.ViewGroup viewGroup, androidx.fragment.app.Fragment fragment, android.view.View view, java.util.ArrayList<android.view.View> arrayList, java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList2, java.lang.Object obj2, java.util.ArrayList<android.view.View> arrayList3) {
        androidx.core.view.OneShotPreDrawListener.add(viewGroup, new androidx.fragment.app.FragmentTransition.AnonymousClass4(obj, fragmentTransitionImpl, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void setOutEpicenter(androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl, java.lang.Object obj, java.lang.Object obj2, androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap, boolean z, androidx.fragment.app.BackStackRecord backStackRecord) {
        java.util.ArrayList<java.lang.String> arrayList = backStackRecord.mSharedElementSourceNames;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        android.view.View view = arrayMap.get(z ? backStackRecord.mSharedElementTargetNames.get(0) : backStackRecord.mSharedElementSourceNames.get(0));
        fragmentTransitionImpl.setEpicenter(obj, view);
        if (obj2 != null) {
            fragmentTransitionImpl.setEpicenter(obj2, view);
        }
    }

    public static void setViewVisibility(java.util.ArrayList<android.view.View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    public static void startTransitions(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.fragment.app.FragmentContainer fragmentContainer, java.util.ArrayList<androidx.fragment.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, int i, int i2, boolean z, androidx.fragment.app.FragmentTransition.Callback callback) {
        android.view.ViewGroup viewGroup;
        android.util.SparseArray sparseArray = new android.util.SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            androidx.fragment.app.BackStackRecord backStackRecord = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                calculatePopFragments(backStackRecord, sparseArray, z);
            } else {
                calculateFragments(backStackRecord, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            android.view.View view = new android.view.View(context);
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                androidx.collection.ArrayMap<java.lang.String, java.lang.String> calculateNameOverrides = calculateNameOverrides(keyAt, arrayList, arrayList2, i, i2);
                androidx.fragment.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition = (androidx.fragment.app.FragmentTransition.FragmentContainerTransition) sparseArray.valueAt(i4);
                if (fragmentContainer.onHasView() && (viewGroup = (android.view.ViewGroup) fragmentContainer.onFindViewById(keyAt)) != null) {
                    if (z) {
                        configureTransitionsReordered(viewGroup, fragmentContainerTransition, view, calculateNameOverrides, callback);
                    } else {
                        configureTransitionsOrdered(viewGroup, fragmentContainerTransition, view, calculateNameOverrides, callback);
                    }
                }
            }
        }
    }

    public static boolean supportsTransition() {
        return (PLATFORM_IMPL == null && SUPPORT_IMPL == null) ? false : true;
    }
}
