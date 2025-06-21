package androidx.fragment.app;

/* loaded from: classes.dex */
class FragmentStore {
    private static final java.lang.String TAG = "FragmentManager";
    private androidx.fragment.app.FragmentManagerViewModel mNonConfig;
    private final java.util.ArrayList<androidx.fragment.app.Fragment> mAdded = new java.util.ArrayList<>();
    private final java.util.HashMap<java.lang.String, androidx.fragment.app.FragmentStateManager> mActive = new java.util.HashMap<>();

    public void addFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        if (this.mAdded.contains(fragment)) {
            throw new java.lang.IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.mAdded) {
            this.mAdded.add(fragment);
        }
        fragment.mAdded = true;
    }

    public void burpActive() {
        this.mActive.values().removeAll(java.util.Collections.singleton(null));
    }

    public boolean containsActiveFragment(@androidx.annotation.NonNull java.lang.String str) {
        return this.mActive.get(str) != null;
    }

    public void dispatchStateChange(int i) {
        for (androidx.fragment.app.FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null) {
                fragmentStateManager.setFragmentManagerState(i);
            }
        }
    }

    public void dump(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor, @androidx.annotation.NonNull java.io.PrintWriter printWriter, @androidx.annotation.Nullable java.lang.String[] strArr) {
        java.lang.String str2 = str + "    ";
        if (!this.mActive.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (androidx.fragment.app.FragmentStateManager fragmentStateManager : this.mActive.values()) {
                printWriter.print(str);
                if (fragmentStateManager != null) {
                    androidx.fragment.app.Fragment fragment = fragmentStateManager.getFragment();
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println(com.igexin.push.core.b.m);
                }
            }
        }
        int size = this.mAdded.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; i++) {
                androidx.fragment.app.Fragment fragment2 = this.mAdded.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment findActiveFragment(@androidx.annotation.NonNull java.lang.String str) {
        androidx.fragment.app.FragmentStateManager fragmentStateManager = this.mActive.get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.getFragment();
        }
        return null;
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment findFragmentById(@androidx.annotation.IdRes int i) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            androidx.fragment.app.Fragment fragment = this.mAdded.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (androidx.fragment.app.FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null) {
                androidx.fragment.app.Fragment fragment2 = fragmentStateManager.getFragment();
                if (fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment findFragmentByTag(@androidx.annotation.Nullable java.lang.String str) {
        if (str != null) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                androidx.fragment.app.Fragment fragment = this.mAdded.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (androidx.fragment.app.FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null) {
                androidx.fragment.app.Fragment fragment2 = fragmentStateManager.getFragment();
                if (str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment findFragmentByWho(@androidx.annotation.NonNull java.lang.String str) {
        androidx.fragment.app.Fragment findFragmentByWho;
        for (androidx.fragment.app.FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null && (findFragmentByWho = fragmentStateManager.getFragment().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public int findFragmentIndexInContainer(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        android.view.View view;
        android.view.View view2;
        android.view.ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.mAdded.indexOf(fragment);
        for (int i = indexOf - 1; i >= 0; i--) {
            androidx.fragment.app.Fragment fragment2 = this.mAdded.get(i);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.mAdded.size()) {
                return -1;
            }
            androidx.fragment.app.Fragment fragment3 = this.mAdded.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public int getActiveFragmentCount() {
        return this.mActive.size();
    }

    @androidx.annotation.NonNull
    public java.util.List<androidx.fragment.app.FragmentStateManager> getActiveFragmentStateManagers() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (androidx.fragment.app.FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager);
            }
        }
        return arrayList;
    }

    @androidx.annotation.NonNull
    public java.util.List<androidx.fragment.app.Fragment> getActiveFragments() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (androidx.fragment.app.FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager.getFragment());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.FragmentStateManager getFragmentStateManager(@androidx.annotation.NonNull java.lang.String str) {
        return this.mActive.get(str);
    }

    @androidx.annotation.NonNull
    public java.util.List<androidx.fragment.app.Fragment> getFragments() {
        java.util.ArrayList arrayList;
        if (this.mAdded.isEmpty()) {
            return java.util.Collections.emptyList();
        }
        synchronized (this.mAdded) {
            arrayList = new java.util.ArrayList(this.mAdded);
        }
        return arrayList;
    }

    public androidx.fragment.app.FragmentManagerViewModel getNonConfig() {
        return this.mNonConfig;
    }

    public void makeActive(@androidx.annotation.NonNull androidx.fragment.app.FragmentStateManager fragmentStateManager) {
        androidx.fragment.app.Fragment fragment = fragmentStateManager.getFragment();
        if (containsActiveFragment(fragment.mWho)) {
            return;
        }
        this.mActive.put(fragment.mWho, fragmentStateManager);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                this.mNonConfig.addRetainedFragment(fragment);
            } else {
                this.mNonConfig.removeRetainedFragment(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Added fragment to active set ");
            sb.append(fragment);
        }
    }

    public void makeInactive(@androidx.annotation.NonNull androidx.fragment.app.FragmentStateManager fragmentStateManager) {
        androidx.fragment.app.Fragment fragment = fragmentStateManager.getFragment();
        if (fragment.mRetainInstance) {
            this.mNonConfig.removeRetainedFragment(fragment);
        }
        if (this.mActive.put(fragment.mWho, null) != null && androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Removed fragment from active set ");
            sb.append(fragment);
        }
    }

    public void moveToExpectedState() {
        java.util.Iterator<androidx.fragment.app.Fragment> it = this.mAdded.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.FragmentStateManager fragmentStateManager = this.mActive.get(it.next().mWho);
            if (fragmentStateManager != null) {
                fragmentStateManager.moveToExpectedState();
            }
        }
        for (androidx.fragment.app.FragmentStateManager fragmentStateManager2 : this.mActive.values()) {
            if (fragmentStateManager2 != null) {
                fragmentStateManager2.moveToExpectedState();
                androidx.fragment.app.Fragment fragment = fragmentStateManager2.getFragment();
                if (fragment.mRemoving && !fragment.isInBackStack()) {
                    makeInactive(fragmentStateManager2);
                }
            }
        }
    }

    public void removeFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        synchronized (this.mAdded) {
            this.mAdded.remove(fragment);
        }
        fragment.mAdded = false;
    }

    public void resetActiveFragments() {
        this.mActive.clear();
    }

    public void restoreAddedFragments(@androidx.annotation.Nullable java.util.List<java.lang.String> list) {
        this.mAdded.clear();
        if (list != null) {
            for (java.lang.String str : list) {
                androidx.fragment.app.Fragment findActiveFragment = findActiveFragment(str);
                if (findActiveFragment == null) {
                    throw new java.lang.IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("restoreSaveState: added (");
                    sb.append(str);
                    sb.append("): ");
                    sb.append(findActiveFragment);
                }
                addFragment(findActiveFragment);
            }
        }
    }

    @androidx.annotation.NonNull
    public java.util.ArrayList<androidx.fragment.app.FragmentState> saveActiveFragments() {
        java.util.ArrayList<androidx.fragment.app.FragmentState> arrayList = new java.util.ArrayList<>(this.mActive.size());
        for (androidx.fragment.app.FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null) {
                androidx.fragment.app.Fragment fragment = fragmentStateManager.getFragment();
                androidx.fragment.app.FragmentState saveState = fragmentStateManager.saveState();
                arrayList.add(saveState);
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Saved state of ");
                    sb.append(fragment);
                    sb.append(": ");
                    sb.append(saveState.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    @androidx.annotation.Nullable
    public java.util.ArrayList<java.lang.String> saveAddedFragments() {
        synchronized (this.mAdded) {
            if (this.mAdded.isEmpty()) {
                return null;
            }
            java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>(this.mAdded.size());
            java.util.Iterator<androidx.fragment.app.Fragment> it = this.mAdded.iterator();
            while (it.hasNext()) {
                androidx.fragment.app.Fragment next = it.next();
                arrayList.add(next.mWho);
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("saveAllState: adding fragment (");
                    sb.append(next.mWho);
                    sb.append("): ");
                    sb.append(next);
                }
            }
            return arrayList;
        }
    }

    public void setNonConfig(@androidx.annotation.NonNull androidx.fragment.app.FragmentManagerViewModel fragmentManagerViewModel) {
        this.mNonConfig = fragmentManagerViewModel;
    }
}
