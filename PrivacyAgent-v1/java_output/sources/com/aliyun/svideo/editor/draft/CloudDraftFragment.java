package com.aliyun.svideo.editor.draft;

/* loaded from: classes12.dex */
public class CloudDraftFragment extends androidx.fragment.app.Fragment {
    private com.aliyun.svideo.editor.draft.CloudDraftAdapter mDraftAdapter;
    private androidx.recyclerview.widget.RecyclerView mRecyclerView;

    /* renamed from: com.aliyun.svideo.editor.draft.CloudDraftFragment$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            try {
                com.aliyun.svideo.editor.draft.CloudDraftResult cloudDraftResult = (com.aliyun.svideo.editor.draft.CloudDraftResult) new com.google.gson.Gson().fromJson(str, com.aliyun.svideo.editor.draft.CloudDraftResult.class);
                if (cloudDraftResult.code == 0) {
                    com.aliyun.svideo.editor.draft.CloudDraftFragment.this.mDraftAdapter.setData(cloudDraftResult.data);
                    com.aliyun.svideo.editor.draft.CloudDraftFragment.this.mRecyclerView.setAdapter(com.aliyun.svideo.editor.draft.CloudDraftFragment.this.mDraftAdapter);
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void loadData() {
        com.aliyun.common.qupaiokhttp.HttpRequest.get(com.aliyun.svideo.editor.draft.DraftListActivity.SERVER_GET_PROJECTS_URL, new com.aliyun.svideo.editor.draft.CloudDraftFragment.AnonymousClass1());
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.Nullable
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.aliyun_svideo_draft_fragment, (android.view.ViewGroup) null);
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_draft_list);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(inflate.getContext(), 1, false));
        this.mRecyclerView.addItemDecoration(new androidx.recyclerview.widget.DividerItemDecoration(inflate.getContext(), 1));
        this.mDraftAdapter = new com.aliyun.svideo.editor.draft.CloudDraftAdapter();
        loadData();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
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
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
