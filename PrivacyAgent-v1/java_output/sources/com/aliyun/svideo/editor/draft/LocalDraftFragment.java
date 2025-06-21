package com.aliyun.svideo.editor.draft;

/* loaded from: classes12.dex */
public class LocalDraftFragment extends androidx.fragment.app.Fragment {
    private boolean isTemplateDraft = false;
    private com.aliyun.svideo.editor.draft.LocalDraftAdapter mDraftAdapter;
    private androidx.recyclerview.widget.RecyclerView mRecyclerView;

    /* renamed from: com.aliyun.svideo.editor.draft.LocalDraftFragment$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideosdk.editor.draft.AliyunDraftListCallback {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftListCallback
        public void onFailure(java.lang.String str) {
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftListCallback
        public void onSuccess(java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraft> list) {
            com.aliyun.svideo.editor.draft.LocalDraftFragment.this.mDraftAdapter.setData(list);
            com.aliyun.svideo.editor.draft.LocalDraftFragment.this.mRecyclerView.setAdapter(com.aliyun.svideo.editor.draft.LocalDraftFragment.this.mDraftAdapter);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.draft.LocalDraftFragment$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideosdk.editor.draft.AliyunDraftListCallback {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftListCallback
        public void onFailure(java.lang.String str) {
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftListCallback
        public void onSuccess(java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraft> list) {
            com.aliyun.svideo.editor.draft.LocalDraftFragment.this.mDraftAdapter.setData(list);
            com.aliyun.svideo.editor.draft.LocalDraftFragment.this.mRecyclerView.setAdapter(com.aliyun.svideo.editor.draft.LocalDraftFragment.this.mDraftAdapter);
        }
    }

    public void loadData() {
        if (this.isTemplateDraft) {
            com.aliyun.svideosdk.editor.draft.AliyunTemplateDraftManager.getInstance(this.mRecyclerView.getContext()).getDraftListByAsync(new com.aliyun.svideo.editor.draft.LocalDraftFragment.AnonymousClass1());
        } else {
            com.aliyun.svideosdk.editor.draft.AliyunDraftManager.getInstance(this.mRecyclerView.getContext()).getDraftListByAsync(new com.aliyun.svideo.editor.draft.LocalDraftFragment.AnonymousClass2());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.Nullable
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.aliyun_svideo_draft_fragment, (android.view.ViewGroup) null);
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_draft_list);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(inflate.getContext(), 1, false));
        this.mRecyclerView.addItemDecoration(new androidx.recyclerview.widget.DividerItemDecoration(inflate.getContext(), 1));
        boolean z = getArguments().getInt("TAB_INDEX") == 1;
        this.isTemplateDraft = z;
        this.mDraftAdapter = new com.aliyun.svideo.editor.draft.LocalDraftAdapter(z);
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
