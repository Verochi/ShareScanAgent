package moji.com.mjwallet.progress;

@com.moji.router.annotation.Router(path = "wallet/extract_progress")
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lmoji/com/mjwallet/progress/ExtractProgressActivity;", "Lcom/moji/base/MJActivity;", "Landroidx/lifecycle/Observer;", "Lmoji/com/mjwallet/progress/ExtractProgressViewModel$DataResult;", "", "needTransparentStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "result", "onChanged", "i", "", "errorCode", "showErrorView", "", "Lcom/moji/http/pcd/Extract;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/util/List;", "mutableList", "t", "Z", "hasMore", "Lmoji/com/mjwallet/databinding/ActivityExtractProgressBinding;", com.umeng.analytics.pro.bo.aN, "Lmoji/com/mjwallet/databinding/ActivityExtractProgressBinding;", "binding", "<init>", "()V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes30.dex */
public final class ExtractProgressActivity extends com.moji.base.MJActivity implements androidx.lifecycle.Observer<moji.com.mjwallet.progress.ExtractProgressViewModel.DataResult> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.moji.http.pcd.Extract> mutableList = new java.util.ArrayList();

    /* renamed from: t, reason: from kotlin metadata */
    public boolean hasMore;

    /* renamed from: u, reason: from kotlin metadata */
    public moji.com.mjwallet.databinding.ActivityExtractProgressBinding binding;

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void j(moji.com.mjwallet.progress.ExtractProgressActivity this$0, moji.com.mjwallet.progress.ExtractProgressViewModel viewModel, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding = this$0.binding;
        if (activityExtractProgressBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityExtractProgressBinding = null;
        }
        activityExtractProgressBinding.statusLayout.showLoadingView();
        moji.com.mjwallet.progress.ExtractProgressViewModel.load$default(viewModel, false, 1, null);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: i, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public boolean needTransparentStatusBar() {
        return false;
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(@org.jetbrains.annotations.NotNull moji.com.mjwallet.progress.ExtractProgressViewModel.DataResult result) {
        java.util.List<com.moji.http.pcd.Extract> extract_list;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding = null;
        if (!result.success()) {
            if (!result.getCom.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_APPEND java.lang.String()) {
                showErrorView(result.getErrorCode());
                return;
            }
            moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding2 = this.binding;
            if (activityExtractProgressBinding2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityExtractProgressBinding = activityExtractProgressBinding2;
            }
            androidx.recyclerview.widget.RecyclerView.Adapter adapter = activityExtractProgressBinding.extractProgressList.getAdapter();
            if (adapter != null) {
                ((moji.com.mjwallet.progress.ProgressAdapter) adapter).showLoadMoreFail();
                adapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        com.moji.http.pcd.ExtractDetailResp cashExtractInfoResp = result.getCashExtractInfoResp();
        if (cashExtractInfoResp != null && (extract_list = cashExtractInfoResp.getExtract_list()) != null) {
            for (com.moji.http.pcd.Extract extract : extract_list) {
                if (!this.mutableList.contains(extract)) {
                    this.mutableList.add(extract);
                }
            }
        }
        boolean z = false;
        if (this.mutableList.isEmpty()) {
            moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding3 = this.binding;
            if (activityExtractProgressBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityExtractProgressBinding3 = null;
            }
            activityExtractProgressBinding3.statusLayout.showEmptyView(moji.com.mjwallet.R.string.no_bill_list);
            moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding4 = this.binding;
            if (activityExtractProgressBinding4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityExtractProgressBinding4 = null;
            }
            activityExtractProgressBinding4.progressTip.setVisibility(0);
        } else {
            moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding5 = this.binding;
            if (activityExtractProgressBinding5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityExtractProgressBinding5 = null;
            }
            activityExtractProgressBinding5.statusLayout.showContentView();
            moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding6 = this.binding;
            if (activityExtractProgressBinding6 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityExtractProgressBinding6 = null;
            }
            activityExtractProgressBinding6.progressTip.setVisibility(0);
        }
        com.moji.http.pcd.ExtractDetailResp cashExtractInfoResp2 = result.getCashExtractInfoResp();
        this.hasMore = cashExtractInfoResp2 != null && cashExtractInfoResp2.getHas_more() == 1;
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding7 = this.binding;
        if (activityExtractProgressBinding7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityExtractProgressBinding7 = null;
        }
        androidx.recyclerview.widget.RecyclerView.Adapter adapter2 = activityExtractProgressBinding7.extractProgressList.getAdapter();
        if (adapter2 != null) {
            moji.com.mjwallet.progress.ProgressAdapter progressAdapter = (moji.com.mjwallet.progress.ProgressAdapter) adapter2;
            com.moji.http.pcd.ExtractDetailResp cashExtractInfoResp3 = result.getCashExtractInfoResp();
            if (cashExtractInfoResp3 != null && cashExtractInfoResp3.getHas_more() == 1) {
                z = true;
            }
            progressAdapter.updateHasMore(z);
        }
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding8 = this.binding;
        if (activityExtractProgressBinding8 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityExtractProgressBinding = activityExtractProgressBinding8;
        }
        androidx.recyclerview.widget.RecyclerView.Adapter adapter3 = activityExtractProgressBinding.extractProgressList.getAdapter();
        if (adapter3 != null) {
            adapter3.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding inflate = moji.com.mjwallet.databinding.ActivityExtractProgressBinding.inflate(getLayoutInflater());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding = null;
        if (inflate == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setStatusBarDarkText();
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding2 = this.binding;
        if (activityExtractProgressBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityExtractProgressBinding2 = null;
        }
        activityExtractProgressBinding2.extractProgressList.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding3 = this.binding;
        if (activityExtractProgressBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityExtractProgressBinding3 = null;
        }
        activityExtractProgressBinding3.extractProgressList.setAdapter(new moji.com.mjwallet.progress.ProgressAdapter(this.mutableList));
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding4 = this.binding;
        if (activityExtractProgressBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityExtractProgressBinding4 = null;
        }
        activityExtractProgressBinding4.extractProgressList.addItemDecoration(new moji.com.mjwallet.view.RecyclerViewMargin(com.moji.tool.DeviceTool.dp2px(14.0f)));
        moji.com.mjwallet.progress.ExtractProgressViewModel extractProgressViewModel = (moji.com.mjwallet.progress.ExtractProgressViewModel) androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.FragmentActivity) this).get(moji.com.mjwallet.progress.ExtractProgressViewModel.class);
        moji.com.mjwallet.progress.ExtractProgressViewModel.load$default(extractProgressViewModel, false, 1, null);
        extractProgressViewModel.getListLiveData().observe(this, this);
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding5 = this.binding;
        if (activityExtractProgressBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityExtractProgressBinding5 = null;
        }
        activityExtractProgressBinding5.statusLayout.showLoadingView();
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding6 = this.binding;
        if (activityExtractProgressBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityExtractProgressBinding6 = null;
        }
        activityExtractProgressBinding6.statusLayout.setOnRetryClickListener(new defpackage.pa0(this, extractProgressViewModel));
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding7 = this.binding;
        if (activityExtractProgressBinding7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityExtractProgressBinding = activityExtractProgressBinding7;
        }
        activityExtractProgressBinding.extractProgressList.addOnScrollListener(new moji.com.mjwallet.progress.ExtractProgressActivity$onCreate$2(this, extractProgressViewModel));
    }

    public final void showErrorView(int errorCode) {
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding = null;
        if (errorCode != 1001 && errorCode != 1002) {
            switch (errorCode) {
                case 600:
                case 601:
                case 602:
                    moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding2 = this.binding;
                    if (activityExtractProgressBinding2 == null) {
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityExtractProgressBinding2 = null;
                    }
                    activityExtractProgressBinding2.statusLayout.showServerErrorView();
                    break;
                default:
                    moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding3 = this.binding;
                    if (activityExtractProgressBinding3 == null) {
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityExtractProgressBinding3 = null;
                    }
                    activityExtractProgressBinding3.statusLayout.showNoNetworkView();
                    break;
            }
        } else {
            moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding4 = this.binding;
            if (activityExtractProgressBinding4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityExtractProgressBinding4 = null;
            }
            activityExtractProgressBinding4.statusLayout.showNetworkUnaviable();
        }
        moji.com.mjwallet.databinding.ActivityExtractProgressBinding activityExtractProgressBinding5 = this.binding;
        if (activityExtractProgressBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityExtractProgressBinding = activityExtractProgressBinding5;
        }
        activityExtractProgressBinding.progressTip.setVisibility(8);
    }
}
