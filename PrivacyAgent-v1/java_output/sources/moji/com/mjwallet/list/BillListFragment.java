package moji.com.mjwallet.list;

@kotlin.Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\u00020\u00012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0002:\u0001.B\u0007¢\u0006\u0004\b,\u0010-J\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0019\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002R\u0016\u0010\u001f\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lmoji/com/mjwallet/list/BillListFragment;", "Landroidx/fragment/app/Fragment;", "Landroidx/lifecycle/Observer;", "Lmoji/com/mjwallet/list/ResponsWraper;", "Lcom/moji/http/pcd/BillListResp;", "result", "", "onChanged", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", com.anythink.expressad.a.B, "onViewCreated", "", "errorCode", "e", "(Ljava/lang/Integer;)V", "", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "b", "d", "t", "Z", "hasMore", "Lmoji/com/mjwallet/databinding/FragmentBillListBinding;", com.umeng.analytics.pro.bo.aN, "Lmoji/com/mjwallet/databinding/FragmentBillListBinding;", "binding", "", "Lcom/moji/http/pcd/BillItem;", "v", "Ljava/util/List;", "mutableList", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "I", "type", "<init>", "()V", "Companion", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class BillListFragment extends androidx.fragment.app.Fragment implements androidx.lifecycle.Observer<moji.com.mjwallet.list.ResponsWraper<com.moji.http.pcd.BillListResp>> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final moji.com.mjwallet.list.BillListFragment.Companion INSTANCE = new moji.com.mjwallet.list.BillListFragment.Companion(null);

    /* renamed from: t, reason: from kotlin metadata */
    public boolean hasMore;

    /* renamed from: u, reason: from kotlin metadata */
    public moji.com.mjwallet.databinding.FragmentBillListBinding binding;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.moji.http.pcd.BillItem> mutableList = new java.util.ArrayList();

    /* renamed from: w, reason: from kotlin metadata */
    public int type;

    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lmoji/com/mjwallet/list/BillListFragment$Companion;", "", "()V", "newInstance", "Lmoji/com/mjwallet/list/BillListFragment;", "typeBILL", "", "MJWallet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public final moji.com.mjwallet.list.BillListFragment newInstance(int typeBILL) {
            moji.com.mjwallet.list.BillListFragment billListFragment = new moji.com.mjwallet.list.BillListFragment();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("type", typeBILL);
            billListFragment.setArguments(bundle);
            return billListFragment;
        }
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void f(moji.com.mjwallet.list.BillListFragment this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding = this$0.binding;
        if (fragmentBillListBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBillListBinding = null;
        }
        fragmentBillListBinding.statusLayout.showLoadingView();
        ((moji.com.mjwallet.list.RecordListViewModel) androidx.lifecycle.ViewModelProviders.of(this$0).get(moji.com.mjwallet.list.RecordListViewModel.class)).requestData(null, this$0.type);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    public static final moji.com.mjwallet.list.BillListFragment newInstance(int i) {
        return INSTANCE.newInstance(i);
    }

    public final int b(androidx.recyclerview.widget.RecyclerView recyclerView) {
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            return ((androidx.recyclerview.widget.LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        throw new java.lang.NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    /* renamed from: c, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final boolean d(androidx.recyclerview.widget.RecyclerView recyclerView) {
        int b = b(recyclerView);
        if (b != -1) {
            androidx.recyclerview.widget.RecyclerView.Adapter adapter = recyclerView.getAdapter();
            kotlin.jvm.internal.Intrinsics.checkNotNull(adapter);
            if (b == adapter.getItemCount() - 1) {
                return true;
            }
        }
        return false;
    }

    public final void e(java.lang.Integer errorCode) {
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding = this.binding;
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding2 = null;
        if (fragmentBillListBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBillListBinding = null;
        }
        fragmentBillListBinding.statusLayout.showServerErrorView();
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding3 = this.binding;
        if (fragmentBillListBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBillListBinding3 = null;
        }
        fragmentBillListBinding3.statusLayout.setOnRetryClickListener(new defpackage.zh(this));
        boolean z = false;
        if ((errorCode != null && errorCode.intValue() == 1002) || (errorCode != null && errorCode.intValue() == 1001)) {
            moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding4 = this.binding;
            if (fragmentBillListBinding4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentBillListBinding2 = fragmentBillListBinding4;
            }
            fragmentBillListBinding2.statusLayout.showNetworkUnaviable();
            return;
        }
        if (((errorCode != null && errorCode.intValue() == 602) || (errorCode != null && errorCode.intValue() == 601)) || (errorCode != null && errorCode.intValue() == 600)) {
            z = true;
        }
        if (z) {
            moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding5 = this.binding;
            if (fragmentBillListBinding5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentBillListBinding2 = fragmentBillListBinding5;
            }
            fragmentBillListBinding2.statusLayout.showServerErrorView();
            return;
        }
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding6 = this.binding;
        if (fragmentBillListBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBillListBinding2 = fragmentBillListBinding6;
        }
        fragmentBillListBinding2.statusLayout.showNoNetworkView();
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(@org.jetbrains.annotations.NotNull moji.com.mjwallet.list.ResponsWraper<com.moji.http.pcd.BillListResp> result) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding = null;
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding2 = null;
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding3 = null;
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding4 = null;
        if (result.getData() == null) {
            if (this.mutableList.isEmpty()) {
                com.moji.requestcore.MJException error = result.getError();
                e(error != null ? java.lang.Integer.valueOf(error.getCode()) : null);
                return;
            }
            moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding5 = this.binding;
            if (fragmentBillListBinding5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentBillListBinding = fragmentBillListBinding5;
            }
            androidx.recyclerview.widget.RecyclerView.Adapter adapter = fragmentBillListBinding.recyclerView.getAdapter();
            if (adapter != null) {
                ((moji.com.mjwallet.list.RecordListAdapter) adapter).updateLoadingMoreFail();
                adapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        com.moji.http.pcd.BillListResp data = result.getData();
        if (!data.OK()) {
            moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding6 = this.binding;
            if (fragmentBillListBinding6 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentBillListBinding4 = fragmentBillListBinding6;
            }
            fragmentBillListBinding4.statusLayout.showServerErrorView();
            return;
        }
        for (com.moji.http.pcd.BillItem billItem : data.getBill_list()) {
            if (!this.mutableList.contains(billItem)) {
                this.mutableList.add(billItem);
            }
        }
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding7 = this.binding;
        if (fragmentBillListBinding7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBillListBinding7 = null;
        }
        androidx.recyclerview.widget.RecyclerView.Adapter adapter2 = fragmentBillListBinding7.recyclerView.getAdapter();
        if (adapter2 != null) {
            this.hasMore = result.getData().hasMore();
            ((moji.com.mjwallet.list.RecordListAdapter) adapter2).updateHasMore(result.getData().hasMore());
            adapter2.notifyDataSetChanged();
        }
        if (this.mutableList.size() > 0) {
            moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding8 = this.binding;
            if (fragmentBillListBinding8 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentBillListBinding2 = fragmentBillListBinding8;
            }
            fragmentBillListBinding2.statusLayout.showContentView();
            return;
        }
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding9 = this.binding;
        if (fragmentBillListBinding9 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBillListBinding3 = fragmentBillListBinding9;
        }
        fragmentBillListBinding3.statusLayout.showEmptyView(getString(moji.com.mjwallet.R.string.no_bill_list));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.os.Bundle arguments = getArguments();
        if (arguments != null) {
            this.type = arguments.getInt("type");
        }
        moji.com.mjwallet.list.RecordListViewModel recordListViewModel = (moji.com.mjwallet.list.RecordListViewModel) androidx.lifecycle.ViewModelProviders.of(this).get(moji.com.mjwallet.list.RecordListViewModel.class);
        recordListViewModel.requestData(null, this.type);
        recordListViewModel.getListLiveData().observe(this, this);
    }

    @Override // androidx.fragment.app.Fragment
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable android.view.ViewGroup container, @org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inflater, "inflater");
        moji.com.mjwallet.databinding.FragmentBillListBinding inflate = moji.com.mjwallet.databinding.FragmentBillListBinding.inflate(inflater, container, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        return inflate.getRoot();
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
    public void onViewCreated(@org.jetbrains.annotations.NotNull android.view.View view, @org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding = this.binding;
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding2 = null;
        if (fragmentBillListBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBillListBinding = null;
        }
        fragmentBillListBinding.recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(view.getContext()));
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding3 = this.binding;
        if (fragmentBillListBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBillListBinding3 = null;
        }
        fragmentBillListBinding3.recyclerView.setAdapter(new moji.com.mjwallet.list.RecordListAdapter(this.mutableList));
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding4 = this.binding;
        if (fragmentBillListBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBillListBinding4 = null;
        }
        fragmentBillListBinding4.recyclerView.addOnScrollListener(new moji.com.mjwallet.list.BillListFragment$onViewCreated$1(this));
        moji.com.mjwallet.databinding.FragmentBillListBinding fragmentBillListBinding5 = this.binding;
        if (fragmentBillListBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBillListBinding2 = fragmentBillListBinding5;
        }
        fragmentBillListBinding2.statusLayout.showLoadingView();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
