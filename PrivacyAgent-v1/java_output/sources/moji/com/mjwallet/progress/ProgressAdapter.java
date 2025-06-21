package moji.com.mjwallet.progress;

@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002+,B\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b)\u0010*J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0006\u0010\u0011\u001a\u00020\u000bR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010%¨\u0006-"}, d2 = {"Lmoji/com/mjwallet/progress/ProgressAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "getItemCount", "", "hasMore", "", "updateHasMore", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "getItemViewType", "holder", "onBindViewHolder", "showLoadMoreFail", "", "Lcom/moji/http/pcd/Extract;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/util/List;", "dataList", "Ljava/text/DecimalFormat;", "t", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "setDf", "(Ljava/text/DecimalFormat;)V", "df", com.umeng.analytics.pro.bo.aN, "I", "TYPE_VIEW", "v", "TYPE_FOOTER", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Z", "mHasMore", "x", "loadSuccess", "<init>", "(Ljava/util/List;)V", "FooterViewHolder", "ItemViewHolder", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes31.dex */
public final class ProgressAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.moji.http.pcd.Extract> dataList;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public java.text.DecimalFormat df;

    /* renamed from: u, reason: from kotlin metadata */
    public final int TYPE_VIEW;

    /* renamed from: v, reason: from kotlin metadata */
    public final int TYPE_FOOTER;

    /* renamed from: w, reason: from kotlin metadata */
    public boolean mHasMore;

    /* renamed from: x, reason: from kotlin metadata */
    public boolean loadSuccess;

    @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lmoji/com/mjwallet/progress/ProgressAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "bindView", "Lmoji/com/mjwallet/databinding/LayoutItemBottomBinding;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjwallet/databinding/LayoutItemBottomBinding;", "binding", "<init>", "(Lmoji/com/mjwallet/progress/ProgressAdapter;Lmoji/com/mjwallet/databinding/LayoutItemBottomBinding;)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes20.dex */
    public final class FooterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final moji.com.mjwallet.databinding.LayoutItemBottomBinding binding;
        public final /* synthetic */ moji.com.mjwallet.progress.ProgressAdapter t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FooterViewHolder(@org.jetbrains.annotations.NotNull moji.com.mjwallet.progress.ProgressAdapter progressAdapter, moji.com.mjwallet.databinding.LayoutItemBottomBinding binding) {
            super(binding.getRoot());
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(binding, "binding");
            this.t = progressAdapter;
            this.binding = binding;
        }

        public final void bindView() {
            if (!this.t.loadSuccess) {
                this.binding.vFooter.fail(moji.com.mjwallet.R.string.wallet_list_load_fail);
            } else if (this.t.mHasMore) {
                this.binding.vFooter.loading();
            } else {
                this.binding.vFooter.noMore(moji.com.mjwallet.R.string.no_more_bill_list);
            }
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lmoji/com/mjwallet/progress/ProgressAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/moji/http/pcd/Extract;", "extract", "", "bindView", "Lmoji/com/mjwallet/databinding/ExtractProgressItemBinding;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjwallet/databinding/ExtractProgressItemBinding;", "binding", "<init>", "(Lmoji/com/mjwallet/progress/ProgressAdapter;Lmoji/com/mjwallet/databinding/ExtractProgressItemBinding;)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes20.dex */
    public final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final moji.com.mjwallet.databinding.ExtractProgressItemBinding binding;
        public final /* synthetic */ moji.com.mjwallet.progress.ProgressAdapter t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(@org.jetbrains.annotations.NotNull moji.com.mjwallet.progress.ProgressAdapter progressAdapter, moji.com.mjwallet.databinding.ExtractProgressItemBinding binding) {
            super(binding.getRoot());
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(binding, "binding");
            this.t = progressAdapter;
            this.binding = binding;
        }

        public final void bindView(@org.jetbrains.annotations.NotNull com.moji.http.pcd.Extract extract) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(extract, "extract");
            this.binding.progressView.setCurrentProgress(extract.getExtract_status());
            this.binding.tvCashExtractRight.setText(com.moji.tool.AppDelegate.getAppContext().getString(moji.com.mjwallet.R.string.extract_yuan, this.t.getDf().format(java.lang.Float.valueOf(extract.getExtract_fee() / 100.0f))));
            this.binding.tvCashExtractAccountNameRight.setText(extract.getReal_name());
            this.binding.tvCashExtractReceivingBankRight.setText(extract.getExtractTypeStr());
            this.binding.tvCashExtractReceivingAccountRight.setText(extract.getAccount_number());
            this.binding.tvCashExtractOrderNoRight.setText(extract.getExtract_no());
            this.binding.tvCashExtractOrderDateRight.setText(extract.getExtractDate());
            if (extract.isFail()) {
                this.binding.progressTime1.setTextColor(android.graphics.Color.parseColor("#FFE95E5E"));
                this.binding.progressTime2.setTextColor(android.graphics.Color.parseColor("#FFE95E5E"));
            } else {
                android.widget.TextView textView = this.binding.progressTime1;
                android.content.Context context = this.itemView.getContext();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                int i = moji.com.mjwallet.R.attr.moji_auto_blue;
                textView.setTextColor(com.moji.theme.AppThemeManager.getColor$default(context, i, 0, 4, (java.lang.Object) null));
                android.widget.TextView textView2 = this.binding.progressTime2;
                android.content.Context context2 = this.itemView.getContext();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                textView2.setTextColor(com.moji.theme.AppThemeManager.getColor$default(context2, i, 0, 4, (java.lang.Object) null));
            }
            if (!extract.isComplete()) {
                this.binding.progressTime3.setVisibility(8);
                this.binding.progressTime4.setVisibility(8);
                this.binding.progressTime1.setText(((com.moji.http.pcd.Schedule) extract.getSchedule_list().get(0)).getTimeStr());
                this.binding.progressTime2.setText(((com.moji.http.pcd.Schedule) extract.getSchedule_list().get(0)).getDesc());
                return;
            }
            this.binding.progressTime3.setVisibility(0);
            this.binding.progressTime4.setVisibility(0);
            this.binding.progressTime1.setText(((com.moji.http.pcd.Schedule) extract.getSchedule_list().get(1)).getTimeStr());
            this.binding.progressTime2.setText(((com.moji.http.pcd.Schedule) extract.getSchedule_list().get(1)).getDesc());
            this.binding.progressTime3.setText(((com.moji.http.pcd.Schedule) extract.getSchedule_list().get(0)).getTimeStr());
            this.binding.progressTime4.setText(((com.moji.http.pcd.Schedule) extract.getSchedule_list().get(0)).getDesc());
        }
    }

    public ProgressAdapter(@org.jetbrains.annotations.NotNull java.util.List<com.moji.http.pcd.Extract> dataList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList = dataList;
        this.df = new java.text.DecimalFormat("0.00");
        this.TYPE_FOOTER = 1;
        this.loadSuccess = true;
    }

    @org.jetbrains.annotations.NotNull
    public final java.text.DecimalFormat getDf() {
        return this.df;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size() > 5 ? this.dataList.size() + 1 : this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position == this.dataList.size() ? this.TYPE_FOOTER : this.TYPE_VIEW;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        int itemViewType = getItemViewType(position);
        if (itemViewType == this.TYPE_FOOTER) {
            ((moji.com.mjwallet.progress.ProgressAdapter.FooterViewHolder) holder).bindView();
        } else if (itemViewType == this.TYPE_VIEW) {
            ((moji.com.mjwallet.progress.ProgressAdapter.ItemViewHolder) holder).bindView(this.dataList.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @org.jetbrains.annotations.NotNull
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == this.TYPE_VIEW) {
            moji.com.mjwallet.databinding.ExtractProgressItemBinding inflate = moji.com.mjwallet.databinding.ExtractProgressItemBinding.inflate(android.view.LayoutInflater.from(parent.getContext()), parent, false);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
            return new moji.com.mjwallet.progress.ProgressAdapter.ItemViewHolder(this, inflate);
        }
        moji.com.mjwallet.databinding.LayoutItemBottomBinding inflate2 = moji.com.mjwallet.databinding.LayoutItemBottomBinding.inflate(android.view.LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(LayoutInflater.f….context), parent, false)");
        return new moji.com.mjwallet.progress.ProgressAdapter.FooterViewHolder(this, inflate2);
    }

    public final void setDf(@org.jetbrains.annotations.NotNull java.text.DecimalFormat decimalFormat) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(decimalFormat, "<set-?>");
        this.df = decimalFormat;
    }

    public final void showLoadMoreFail() {
        this.loadSuccess = false;
    }

    public final void updateHasMore(boolean hasMore) {
        this.mHasMore = hasMore;
        this.loadSuccess = true;
    }
}
