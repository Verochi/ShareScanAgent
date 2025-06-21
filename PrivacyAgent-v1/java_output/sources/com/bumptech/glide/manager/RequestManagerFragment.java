package com.bumptech.glide.manager;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class RequestManagerFragment extends android.app.Fragment {
    private static final java.lang.String TAG = "RMFragment";
    private final java.util.Set<com.bumptech.glide.manager.RequestManagerFragment> childRequestManagerFragments;
    private final com.bumptech.glide.manager.ActivityFragmentLifecycle lifecycle;

    @androidx.annotation.Nullable
    private android.app.Fragment parentFragmentHint;

    @androidx.annotation.Nullable
    private com.bumptech.glide.RequestManager requestManager;
    private final com.bumptech.glide.manager.RequestManagerTreeNode requestManagerTreeNode;

    @androidx.annotation.Nullable
    private com.bumptech.glide.manager.RequestManagerFragment rootRequestManagerFragment;

    public class FragmentRequestManagerTreeNode implements com.bumptech.glide.manager.RequestManagerTreeNode {
        public FragmentRequestManagerTreeNode() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @androidx.annotation.NonNull
        public java.util.Set<com.bumptech.glide.RequestManager> getDescendants() {
            java.util.Set<com.bumptech.glide.manager.RequestManagerFragment> descendantRequestManagerFragments = com.bumptech.glide.manager.RequestManagerFragment.this.getDescendantRequestManagerFragments();
            java.util.HashSet hashSet = new java.util.HashSet(descendantRequestManagerFragments.size());
            for (com.bumptech.glide.manager.RequestManagerFragment requestManagerFragment : descendantRequestManagerFragments) {
                if (requestManagerFragment.getRequestManager() != null) {
                    hashSet.add(requestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        public java.lang.String toString() {
            return super.toString() + "{fragment=" + com.bumptech.glide.manager.RequestManagerFragment.this + com.alipay.sdk.m.u.i.d;
        }
    }

    public RequestManagerFragment() {
        this(new com.bumptech.glide.manager.ActivityFragmentLifecycle());
    }

    @android.annotation.SuppressLint({"ValidFragment"})
    @androidx.annotation.VisibleForTesting
    public RequestManagerFragment(@androidx.annotation.NonNull com.bumptech.glide.manager.ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new com.bumptech.glide.manager.RequestManagerFragment.FragmentRequestManagerTreeNode();
        this.childRequestManagerFragments = new java.util.HashSet();
        this.lifecycle = activityFragmentLifecycle;
    }

    private void addChildRequestManagerFragment(com.bumptech.glide.manager.RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.add(requestManagerFragment);
    }

    @androidx.annotation.Nullable
    @android.annotation.TargetApi(17)
    private android.app.Fragment getParentFragmentUsingHint() {
        android.app.Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.parentFragmentHint;
    }

    @android.annotation.TargetApi(17)
    private boolean isDescendant(@androidx.annotation.NonNull android.app.Fragment fragment) {
        android.app.Fragment parentFragment = getParentFragment();
        while (true) {
            android.app.Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void registerFragmentWithRoot(@androidx.annotation.NonNull android.app.Activity activity) {
        unregisterFragmentWithRoot();
        com.bumptech.glide.manager.RequestManagerFragment requestManagerFragment = com.bumptech.glide.Glide.get(activity).getRequestManagerRetriever().getRequestManagerFragment(activity);
        this.rootRequestManagerFragment = requestManagerFragment;
        if (equals(requestManagerFragment)) {
            return;
        }
        this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
    }

    private void removeChildRequestManagerFragment(com.bumptech.glide.manager.RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.remove(requestManagerFragment);
    }

    private void unregisterFragmentWithRoot() {
        com.bumptech.glide.manager.RequestManagerFragment requestManagerFragment = this.rootRequestManagerFragment;
        if (requestManagerFragment != null) {
            requestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @androidx.annotation.NonNull
    @android.annotation.TargetApi(17)
    public java.util.Set<com.bumptech.glide.manager.RequestManagerFragment> getDescendantRequestManagerFragments() {
        if (equals(this.rootRequestManagerFragment)) {
            return java.util.Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        if (this.rootRequestManagerFragment == null) {
            return java.util.Collections.emptySet();
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        for (com.bumptech.glide.manager.RequestManagerFragment requestManagerFragment : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(requestManagerFragment.getParentFragment())) {
                hashSet.add(requestManagerFragment);
            }
        }
        return java.util.Collections.unmodifiableSet(hashSet);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.manager.ActivityFragmentLifecycle getGlideLifecycle() {
        return this.lifecycle;
    }

    @androidx.annotation.Nullable
    public com.bumptech.glide.RequestManager getRequestManager() {
        return this.requestManager;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.manager.RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    @Override // android.app.Fragment
    public void onAttach(android.app.Activity activity) {
        super.onAttach(activity);
        try {
            registerFragmentWithRoot(activity);
        } catch (java.lang.IllegalStateException unused) {
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
        unregisterFragmentWithRoot();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        unregisterFragmentWithRoot();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    public void setParentFragmentHint(@androidx.annotation.Nullable android.app.Fragment fragment) {
        this.parentFragmentHint = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        registerFragmentWithRoot(fragment.getActivity());
    }

    public void setRequestManager(@androidx.annotation.Nullable com.bumptech.glide.RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override // android.app.Fragment
    public java.lang.String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + com.alipay.sdk.m.u.i.d;
    }
}
