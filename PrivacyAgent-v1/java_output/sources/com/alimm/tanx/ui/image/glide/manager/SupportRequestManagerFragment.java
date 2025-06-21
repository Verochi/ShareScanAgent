package com.alimm.tanx.ui.image.glide.manager;

/* loaded from: classes.dex */
public class SupportRequestManagerFragment extends androidx.fragment.app.Fragment {
    private static final java.lang.String TAG = "SupportRMFragment";
    private final java.util.HashSet<com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment> childRequestManagerFragments;
    private com.alimm.tanx.ui.image.glide.RequestManager requestManager;
    private final com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode requestManagerTreeNode;
    private com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment rootRequestManagerFragment;
    private final com.alimm.tanx.ui.image.glide.manager.ActivityFragmentLifecycle tanxLifecycle;

    public class SupportFragmentRequestManagerTreeNode implements com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode {
        private SupportFragmentRequestManagerTreeNode() {
        }

        public /* synthetic */ SupportFragmentRequestManagerTreeNode(com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment.AnonymousClass1 anonymousClass1) {
        }

        @Override // com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode
        public java.util.Set<com.alimm.tanx.ui.image.glide.RequestManager> getDescendants() {
            java.util.Set<com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment> descendantRequestManagerFragments = com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment.this.getDescendantRequestManagerFragments();
            java.util.HashSet hashSet = new java.util.HashSet(descendantRequestManagerFragments.size());
            for (com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment : descendantRequestManagerFragments) {
                if (supportRequestManagerFragment.getRequestManager() != null) {
                    hashSet.add(supportRequestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }
    }

    public SupportRequestManagerFragment() {
        this(new com.alimm.tanx.ui.image.glide.manager.ActivityFragmentLifecycle());
    }

    @android.annotation.SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(com.alimm.tanx.ui.image.glide.manager.ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment.SupportFragmentRequestManagerTreeNode(null);
        this.childRequestManagerFragments = new java.util.HashSet<>();
        this.tanxLifecycle = activityFragmentLifecycle;
    }

    private void addChildRequestManagerFragment(com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.add(supportRequestManagerFragment);
    }

    private boolean isDescendant(androidx.fragment.app.Fragment fragment) {
        androidx.fragment.app.Fragment parentFragment = getParentFragment();
        while (fragment.getParentFragment() != null) {
            if (fragment.getParentFragment() == parentFragment) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
        return false;
    }

    private void removeChildRequestManagerFragment(com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.remove(supportRequestManagerFragment);
    }

    public java.util.Set<com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment == null) {
            return java.util.Collections.emptySet();
        }
        if (supportRequestManagerFragment == this) {
            return java.util.Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        for (com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment2 : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(supportRequestManagerFragment2.getParentFragment())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return java.util.Collections.unmodifiableSet(hashSet);
    }

    public com.alimm.tanx.ui.image.glide.RequestManager getRequestManager() {
        return this.requestManager;
    }

    public com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    public com.alimm.tanx.ui.image.glide.manager.ActivityFragmentLifecycle getTanxLifecycle() {
        return this.tanxLifecycle;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(android.app.Activity activity) {
        super.onAttach(activity);
        try {
            com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment = com.alimm.tanx.ui.image.glide.manager.RequestManagerRetriever.get().getSupportRequestManagerFragment(getActivity().getSupportFragmentManager());
            this.rootRequestManagerFragment = supportRequestManagerFragment;
            if (supportRequestManagerFragment != this) {
                supportRequestManagerFragment.childRequestManagerFragments.add(this);
            }
        } catch (java.lang.IllegalStateException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.tanxLifecycle.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.childRequestManagerFragments.remove(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        com.alimm.tanx.ui.image.glide.RequestManager requestManager = this.requestManager;
        if (requestManager != null) {
            requestManager.onLowMemory();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.tanxLifecycle.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.tanxLifecycle.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setRequestManager(com.alimm.tanx.ui.image.glide.RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
