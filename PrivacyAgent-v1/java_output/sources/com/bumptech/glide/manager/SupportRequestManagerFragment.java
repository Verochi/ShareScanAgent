package com.bumptech.glide.manager;

/* loaded from: classes.dex */
public class SupportRequestManagerFragment extends androidx.fragment.app.Fragment {
    private static final java.lang.String TAG = "SupportRMFragment";
    private final java.util.Set<com.bumptech.glide.manager.SupportRequestManagerFragment> childRequestManagerFragments;
    private final com.bumptech.glide.manager.ActivityFragmentLifecycle lifecycle;

    @androidx.annotation.Nullable
    private androidx.fragment.app.Fragment parentFragmentHint;

    @androidx.annotation.Nullable
    private com.bumptech.glide.RequestManager requestManager;
    private final com.bumptech.glide.manager.RequestManagerTreeNode requestManagerTreeNode;

    @androidx.annotation.Nullable
    private com.bumptech.glide.manager.SupportRequestManagerFragment rootRequestManagerFragment;

    public class SupportFragmentRequestManagerTreeNode implements com.bumptech.glide.manager.RequestManagerTreeNode {
        public SupportFragmentRequestManagerTreeNode() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @androidx.annotation.NonNull
        public java.util.Set<com.bumptech.glide.RequestManager> getDescendants() {
            java.util.Set<com.bumptech.glide.manager.SupportRequestManagerFragment> descendantRequestManagerFragments = com.bumptech.glide.manager.SupportRequestManagerFragment.this.getDescendantRequestManagerFragments();
            java.util.HashSet hashSet = new java.util.HashSet(descendantRequestManagerFragments.size());
            for (com.bumptech.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment : descendantRequestManagerFragments) {
                if (supportRequestManagerFragment.getRequestManager() != null) {
                    hashSet.add(supportRequestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        public java.lang.String toString() {
            return super.toString() + "{fragment=" + com.bumptech.glide.manager.SupportRequestManagerFragment.this + com.alipay.sdk.m.u.i.d;
        }
    }

    public SupportRequestManagerFragment() {
        this(new com.bumptech.glide.manager.ActivityFragmentLifecycle());
    }

    @android.annotation.SuppressLint({"ValidFragment"})
    @androidx.annotation.VisibleForTesting
    public SupportRequestManagerFragment(@androidx.annotation.NonNull com.bumptech.glide.manager.ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new com.bumptech.glide.manager.SupportRequestManagerFragment.SupportFragmentRequestManagerTreeNode();
        this.childRequestManagerFragments = new java.util.HashSet();
        this.lifecycle = activityFragmentLifecycle;
    }

    private void addChildRequestManagerFragment(com.bumptech.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.add(supportRequestManagerFragment);
    }

    @androidx.annotation.Nullable
    private androidx.fragment.app.Fragment getParentFragmentUsingHint() {
        androidx.fragment.app.Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.parentFragmentHint;
    }

    @androidx.annotation.Nullable
    private static androidx.fragment.app.FragmentManager getRootFragmentManager(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean isDescendant(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        androidx.fragment.app.Fragment parentFragmentUsingHint = getParentFragmentUsingHint();
        while (true) {
            androidx.fragment.app.Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(parentFragmentUsingHint)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void registerFragmentWithRoot(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager) {
        unregisterFragmentWithRoot();
        com.bumptech.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment = com.bumptech.glide.Glide.get(context).getRequestManagerRetriever().getSupportRequestManagerFragment(context, fragmentManager);
        this.rootRequestManagerFragment = supportRequestManagerFragment;
        if (equals(supportRequestManagerFragment)) {
            return;
        }
        this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
    }

    private void removeChildRequestManagerFragment(com.bumptech.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.remove(supportRequestManagerFragment);
    }

    private void unregisterFragmentWithRoot() {
        com.bumptech.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @androidx.annotation.NonNull
    public java.util.Set<com.bumptech.glide.manager.SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        com.bumptech.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment == null) {
            return java.util.Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return java.util.Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        for (com.bumptech.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment2 : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(supportRequestManagerFragment2.getParentFragmentUsingHint())) {
                hashSet.add(supportRequestManagerFragment2);
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

    @Override // androidx.fragment.app.Fragment
    public void onAttach(android.content.Context context) {
        super.onAttach(context);
        androidx.fragment.app.FragmentManager rootFragmentManager = getRootFragmentManager(this);
        if (rootFragmentManager == null) {
            return;
        }
        try {
            registerFragmentWithRoot(getContext(), rootFragmentManager);
        } catch (java.lang.IllegalStateException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
        unregisterFragmentWithRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.parentFragmentHint = null;
        unregisterFragmentWithRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    public void setParentFragmentHint(@androidx.annotation.Nullable androidx.fragment.app.Fragment fragment) {
        androidx.fragment.app.FragmentManager rootFragmentManager;
        this.parentFragmentHint = fragment;
        if (fragment == null || fragment.getContext() == null || (rootFragmentManager = getRootFragmentManager(fragment)) == null) {
            return;
        }
        registerFragmentWithRoot(fragment.getContext(), rootFragmentManager);
    }

    public void setRequestManager(@androidx.annotation.Nullable com.bumptech.glide.RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override // androidx.fragment.app.Fragment
    public java.lang.String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + com.alipay.sdk.m.u.i.d;
    }
}
