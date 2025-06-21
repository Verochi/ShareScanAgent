package moji.com.mjweatherservicebase.list;

@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lmoji/com/mjweatherservicebase/list/RFlowersFootHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "status", "", "bindData", "Lmoji/com/mjweatherservicebase/databinding/RflowersItemFooterBinding;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjweatherservicebase/databinding/RflowersItemFooterBinding;", "binding", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class RFlowersFootHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final moji.com.mjweatherservicebase.databinding.RflowersItemFooterBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFlowersFootHolder(@org.jetbrains.annotations.NotNull android.view.View itemView) {
        super(itemView);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(itemView, "itemView");
        moji.com.mjweatherservicebase.databinding.RflowersItemFooterBinding bind = moji.com.mjweatherservicebase.databinding.RflowersItemFooterBinding.bind(itemView);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bind, "bind(itemView)");
        this.binding = bind;
    }

    public final void bindData(int status) {
        if (status == 1121) {
            this.binding.mMoreView.setVisibility(0);
            this.binding.mDividerView.setVisibility(0);
            this.binding.mFooterView.setVisibility(8);
            return;
        }
        this.binding.mMoreView.setVisibility(8);
        this.binding.mDividerView.setVisibility(8);
        this.binding.mFooterView.setVisibility(0);
        if (status == 3) {
            this.binding.mFooterView.refreshStatus(3, moji.com.mjweatherservicebase.R.string.pull_up_loading_more);
        } else if (status != 4) {
            this.binding.mFooterView.refreshStatus(status);
        } else {
            this.binding.mFooterView.refreshStatus(4, moji.com.mjweatherservicebase.R.string.no_more);
        }
    }
}
