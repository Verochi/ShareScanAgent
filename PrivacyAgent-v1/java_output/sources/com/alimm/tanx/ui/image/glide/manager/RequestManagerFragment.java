package com.alimm.tanx.ui.image.glide.manager;

@android.annotation.TargetApi(11)
/* loaded from: classes.dex */
public class RequestManagerFragment extends android.app.Fragment {
    private static final java.lang.String TAG = "RMFragment";
    private final java.util.HashSet<com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment> childRequestManagerFragments;
    private final com.alimm.tanx.ui.image.glide.manager.ActivityFragmentLifecycle lifecycle;
    private com.alimm.tanx.ui.image.glide.RequestManager requestManager;
    private final com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode requestManagerTreeNode;
    private com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment rootRequestManagerFragment;

    public class FragmentRequestManagerTreeNode implements com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode {
        private FragmentRequestManagerTreeNode() {
        }

        public /* synthetic */ FragmentRequestManagerTreeNode(com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment.AnonymousClass1 anonymousClass1) {
        }

        @Override // com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode
        public java.util.Set<com.alimm.tanx.ui.image.glide.RequestManager> getDescendants() {
            java.util.Set<com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment> descendantRequestManagerFragments = com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment.this.getDescendantRequestManagerFragments();
            java.util.HashSet hashSet = new java.util.HashSet(descendantRequestManagerFragments.size());
            for (com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment requestManagerFragment : descendantRequestManagerFragments) {
                if (requestManagerFragment.getRequestManager() != null) {
                    hashSet.add(requestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }
    }

    public RequestManagerFragment() {
        this(new com.alimm.tanx.ui.image.glide.manager.ActivityFragmentLifecycle());
    }

    @android.annotation.SuppressLint({"ValidFragment"})
    public RequestManagerFragment(com.alimm.tanx.ui.image.glide.manager.ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment.FragmentRequestManagerTreeNode(null);
        this.childRequestManagerFragments = new java.util.HashSet<>();
        this.lifecycle = activityFragmentLifecycle;
    }

    private void addChildRequestManagerFragment(com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.add(requestManagerFragment);
    }

    @android.annotation.TargetApi(17)
    private boolean isDescendant(android.app.Fragment fragment) {
        android.app.Fragment parentFragment = getParentFragment();
        while (fragment.getParentFragment() != null) {
            if (fragment.getParentFragment() == parentFragment) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
        return false;
    }

    private void removeChildRequestManagerFragment(com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.remove(requestManagerFragment);
    }

    @android.annotation.TargetApi(17)
    public java.util.Set<com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment> getDescendantRequestManagerFragments() {
        com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment requestManagerFragment = this.rootRequestManagerFragment;
        if (requestManagerFragment == this) {
            return java.util.Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        if (requestManagerFragment == null) {
            return java.util.Collections.emptySet();
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        for (com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment requestManagerFragment2 : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(requestManagerFragment2.getParentFragment())) {
                hashSet.add(requestManagerFragment2);
            }
        }
        return java.util.Collections.unmodifiableSet(hashSet);
    }

    public com.alimm.tanx.ui.image.glide.manager.ActivityFragmentLifecycle getLifecycle() {
        return this.lifecycle;
    }

    public com.alimm.tanx.ui.image.glide.RequestManager getRequestManager() {
        return this.requestManager;
    }

    public com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    @Override // android.app.Fragment
    public void onAttach(android.app.Activity activity) {
        super.onAttach(activity);
        try {
            com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment requestManagerFragment = com.alimm.tanx.ui.image.glide.manager.RequestManagerRetriever.get().getRequestManagerFragment(getActivity().getFragmentManager());
            this.rootRequestManagerFragment = requestManagerFragment;
            if (requestManagerFragment != this) {
                requestManagerFragment.childRequestManagerFragments.add(this);
            }
        } catch (java.lang.IllegalStateException unused) {
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment requestManagerFragment = this.rootRequestManagerFragment;
        if (requestManagerFragment != null) {
            requestManagerFragment.childRequestManagerFragments.remove(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        com.alimm.tanx.ui.image.glide.RequestManager requestManager = this.requestManager;
        if (requestManager != null) {
            requestManager.onLowMemory();
        }
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
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

    @Override // android.app.Fragment, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        com.alimm.tanx.ui.image.glide.RequestManager requestManager = this.requestManager;
        if (requestManager != null) {
            requestManager.onTrimMemory(i);
        }
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setRequestManager(com.alimm.tanx.ui.image.glide.RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
