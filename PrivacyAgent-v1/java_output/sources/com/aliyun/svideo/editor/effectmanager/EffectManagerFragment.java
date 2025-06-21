package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public class EffectManagerFragment extends androidx.fragment.app.Fragment implements com.aliyun.svideo.editor.effectmanager.StateController.StateAdapter.OnStateChangeListener {
    private static final java.lang.String KEY_EFFECT_TYPE = "effect_type";
    private com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter mAdapter;
    private int mEffectType;
    private java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> mList = new java.util.ArrayList();
    private android.os.AsyncTask<java.lang.Integer, java.lang.Void, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel>> mLoadTask = null;
    private com.aliyun.svideo.editor.effectmanager.EffectLoader mPasterLoader = new com.aliyun.svideo.editor.effectmanager.EffectLoader();
    private androidx.recyclerview.widget.RecyclerView mRv;
    private com.aliyun.svideo.editor.effectmanager.StateController mStateController;

    /* renamed from: com.aliyun.svideo.editor.effectmanager.EffectManagerFragment$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.recyclerview.widget.ItemTouchHelper.Callback {
        public AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
            return androidx.recyclerview.widget.ItemTouchHelper.Callback.makeMovementFlags(3, 12);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder2) {
            java.util.Collections.swap(com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.this.mList, viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.this.mAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.this.mList.remove(viewHolder.getAdapterPosition());
            com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.this.mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.EffectManagerFragment$2, reason: invalid class name */
    public class AnonymousClass2 extends android.os.AsyncTask<java.lang.Integer, java.lang.Void, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel>> {
        public AnonymousClass2() {
        }

        @Override // android.os.AsyncTask
        public java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> doInBackground(java.lang.Integer... numArr) {
            java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> loadLocalEffect = com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.this.mPasterLoader.loadLocalEffect(numArr[0].intValue());
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel : loadLocalEffect) {
                if (!"assets".equals(fileDownloaderModel.getDescription())) {
                    arrayList.add(fileDownloaderModel);
                }
            }
            return arrayList;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
            super.onPostExecute((com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.AnonymousClass2) list);
            if (list != null) {
                com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.this.mList.clear();
                com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.this.mList.addAll(list);
                com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    public static com.aliyun.svideo.editor.effectmanager.EffectManagerFragment newInstance(int i) {
        com.aliyun.svideo.editor.effectmanager.EffectManagerFragment effectManagerFragment = new com.aliyun.svideo.editor.effectmanager.EffectManagerFragment();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt(KEY_EFFECT_TYPE, i);
        effectManagerFragment.setArguments(bundle);
        return effectManagerFragment;
    }

    @Override // com.aliyun.svideo.editor.effectmanager.StateController.StateAdapter.OnStateChangeListener
    public void onCompleteState() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.mEffectType = getArguments().getInt(KEY_EFFECT_TYPE);
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.Nullable
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_fragment_effect, (android.view.ViewGroup) null);
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.rv_view);
        this.mRv = recyclerView;
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getActivity()));
        com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter recycleViewAdapter = new com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter(getContext(), this.mList);
        this.mAdapter = recycleViewAdapter;
        recycleViewAdapter.setStateChangeListener(this);
        this.mRv.setAdapter(this.mAdapter);
        new androidx.recyclerview.widget.ItemTouchHelper(new com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.AnonymousClass1());
        com.aliyun.svideo.editor.effectmanager.StateController stateController = ((com.aliyun.svideo.editor.effectmanager.EffectManagerActivity) getActivity()).getStateController();
        this.mStateController = stateController;
        stateController.addAdatper(this.mAdapter);
        return inflate;
    }

    @Override // com.aliyun.svideo.editor.effectmanager.StateController.StateAdapter.OnStateChangeListener
    public void onEditState() {
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
    @android.annotation.SuppressLint({"StaticFieldLeak"})
    public void onStart() {
        super.onStart();
        com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.AnonymousClass2 anonymousClass2 = new com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.AnonymousClass2();
        this.mLoadTask = anonymousClass2;
        anonymousClass2.execute(java.lang.Integer.valueOf(this.mEffectType));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        android.os.AsyncTask<java.lang.Integer, java.lang.Void, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel>> asyncTask = this.mLoadTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
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
