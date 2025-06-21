package moji.com.mjwallet.list;

@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003%&'B\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b#\u0010$J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u0006\u0010\u0011\u001a\u00020\u0005R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001f¨\u0006("}, d2 = {"Lmoji/com/mjwallet/list/RecordListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "boolean", "", "updateHasMore", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "getItemCount", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "getItemViewType", "holder", "onBindViewHolder", "updateLoadingMoreFail", "", "Lcom/moji/http/pcd/BillItem;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/util/List;", "dataList", "t", "I", "itemTypeRecharge", com.umeng.analytics.pro.bo.aN, "itemTypeExtract", "v", "itemTypeBottom", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Z", "mHasMore", "x", "mLoadFail", "<init>", "(Ljava/util/List;)V", "BottomViewHolder", "ExtractViewHolder", "RechargeViewHolder", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes31.dex */
public final class RecordListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.moji.http.pcd.BillItem> dataList;

    /* renamed from: t, reason: from kotlin metadata */
    public final int itemTypeRecharge;

    /* renamed from: u, reason: from kotlin metadata */
    public final int itemTypeExtract;

    /* renamed from: v, reason: from kotlin metadata */
    public final int itemTypeBottom;

    /* renamed from: w, reason: from kotlin metadata */
    public boolean mHasMore;

    /* renamed from: x, reason: from kotlin metadata */
    public boolean mLoadFail;

    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lmoji/com/mjwallet/list/RecordListAdapter$BottomViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "hasMore", "success", "", "update", "Lmoji/com/mjwallet/databinding/LayoutItemBottomBinding;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjwallet/databinding/LayoutItemBottomBinding;", "binding", "<init>", "(Lmoji/com/mjwallet/databinding/LayoutItemBottomBinding;)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes20.dex */
    public static final class BottomViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final moji.com.mjwallet.databinding.LayoutItemBottomBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BottomViewHolder(@org.jetbrains.annotations.NotNull moji.com.mjwallet.databinding.LayoutItemBottomBinding binding) {
            super(binding.getRoot());
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void update(boolean hasMore, boolean success) {
            if (!success) {
                this.binding.vFooter.fail(moji.com.mjwallet.R.string.wallet_list_load_fail);
            } else if (hasMore) {
                this.binding.vFooter.loading();
            } else {
                this.binding.vFooter.noMore(moji.com.mjwallet.R.string.no_more_bill_list);
            }
        }
    }

    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lmoji/com/mjwallet/list/RecordListAdapter$ExtractViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/moji/http/pcd/BillItem;", "billItem", "", "last", "", "bindView", "Lmoji/com/mjwallet/databinding/LayoutItemRechargeBinding;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjwallet/databinding/LayoutItemRechargeBinding;", "binding", "Ljava/text/DecimalFormat;", "t", "Ljava/text/DecimalFormat;", "df", "<init>", "(Lmoji/com/mjwallet/databinding/LayoutItemRechargeBinding;)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes20.dex */
    public static final class ExtractViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final moji.com.mjwallet.databinding.LayoutItemRechargeBinding binding;

        /* renamed from: t, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final java.text.DecimalFormat df;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExtractViewHolder(@org.jetbrains.annotations.NotNull moji.com.mjwallet.databinding.LayoutItemRechargeBinding binding) {
            super(binding.getRoot());
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            this.df = new java.text.DecimalFormat("0.00");
        }

        public final void bindView(@org.jetbrains.annotations.NotNull com.moji.http.pcd.BillItem billItem, boolean last) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(billItem, "billItem");
            this.binding.recordName.setText(billItem.getBusiness_name());
            this.binding.recordDate.setText(billItem.getTimeStr());
            this.binding.recordNo.setText(billItem.getItemNo());
            this.binding.extractStatus.setVisibility(0);
            this.binding.extractStatus.setText(billItem.getStatusStr());
            java.lang.String format = this.df.format(java.lang.Float.valueOf(billItem.getOrder_fee() / 100.0f));
            this.binding.balance.setText(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + format);
            if (billItem.isExtractFail()) {
                this.binding.extractStatus.setBackgroundResource(moji.com.mjwallet.R.drawable.record_fail);
                android.widget.TextView textView = this.binding.extractStatus;
                android.content.Context context = this.itemView.getContext();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                textView.setTextColor(com.moji.theme.AppThemeManager.getColor$default(context, moji.com.mjwallet.R.attr.moji_auto_red_02, 0, 4, (java.lang.Object) null));
                androidx.constraintlayout.widget.ConstraintLayout root = this.binding.getRoot();
                android.content.Context context2 = this.itemView.getContext();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                root.setBackgroundColor(com.moji.theme.AppThemeManager.getColor$default(context2, moji.com.mjwallet.R.attr.moji_auto_light_grey, 0, 4, (java.lang.Object) null));
            } else {
                this.binding.extractStatus.setBackgroundResource(moji.com.mjwallet.R.drawable.record_success);
                android.widget.TextView textView2 = this.binding.extractStatus;
                android.content.Context context3 = this.itemView.getContext();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context3, "itemView.context");
                textView2.setTextColor(com.moji.theme.AppThemeManager.getColor$default(context3, moji.com.mjwallet.R.attr.moji_auto_blue, 0, 4, (java.lang.Object) null));
                androidx.constraintlayout.widget.ConstraintLayout root2 = this.binding.getRoot();
                android.content.Context context4 = this.itemView.getContext();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context4, "itemView.context");
                root2.setBackgroundColor(com.moji.theme.AppThemeManager.getColor$default(context4, moji.com.mjwallet.R.attr.moji_auto_white, 0, 4, (java.lang.Object) null));
            }
            if (last) {
                this.binding.lineBottom.setVisibility(0);
                this.binding.lineNormal.setVisibility(8);
            } else {
                this.binding.lineBottom.setVisibility(8);
                this.binding.lineNormal.setVisibility(0);
            }
        }
    }

    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lmoji/com/mjwallet/list/RecordListAdapter$RechargeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/moji/http/pcd/BillItem;", "billItem", "", "last", "", "bindView", "Lmoji/com/mjwallet/databinding/LayoutItemRechargeBinding;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjwallet/databinding/LayoutItemRechargeBinding;", "binding", "Ljava/text/DecimalFormat;", "t", "Ljava/text/DecimalFormat;", "df", "<init>", "(Lmoji/com/mjwallet/databinding/LayoutItemRechargeBinding;)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes20.dex */
    public static final class RechargeViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final moji.com.mjwallet.databinding.LayoutItemRechargeBinding binding;

        /* renamed from: t, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final java.text.DecimalFormat df;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RechargeViewHolder(@org.jetbrains.annotations.NotNull moji.com.mjwallet.databinding.LayoutItemRechargeBinding binding) {
            super(binding.getRoot());
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            this.df = new java.text.DecimalFormat("0.00");
        }

        public final void bindView(@org.jetbrains.annotations.NotNull com.moji.http.pcd.BillItem billItem, boolean last) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(billItem, "billItem");
            this.binding.recordName.setText(billItem.getBusiness_name());
            this.binding.recordDate.setText(billItem.getTimeStr());
            this.binding.extractStatus.setVisibility(8);
            java.lang.String format = this.df.format(java.lang.Float.valueOf(billItem.getOrder_fee() / 100.0f));
            this.binding.balance.setText("+" + format);
            this.binding.recordNo.setText(billItem.getItemNo());
        }
    }

    public RecordListAdapter(@org.jetbrains.annotations.NotNull java.util.List<com.moji.http.pcd.BillItem> dataList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList = dataList;
        this.itemTypeRecharge = 1;
        this.itemTypeExtract = 2;
        this.itemTypeBottom = 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size() > 10 ? this.dataList.size() + 1 : this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position == this.dataList.size() ? this.itemTypeBottom : this.dataList.get(position).isChargeBill() ? this.itemTypeRecharge : this.itemTypeExtract;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        int itemViewType = getItemViewType(position);
        if (itemViewType == this.itemTypeExtract) {
            ((moji.com.mjwallet.list.RecordListAdapter.ExtractViewHolder) holder).bindView(this.dataList.get(position), position == this.dataList.size() - 1);
        } else if (itemViewType == this.itemTypeRecharge) {
            ((moji.com.mjwallet.list.RecordListAdapter.RechargeViewHolder) holder).bindView(this.dataList.get(position), position == this.dataList.size() - 1);
        } else if (itemViewType == this.itemTypeBottom) {
            ((moji.com.mjwallet.list.RecordListAdapter.BottomViewHolder) holder).update(this.mHasMore, !this.mLoadFail);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @org.jetbrains.annotations.NotNull
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == this.itemTypeRecharge) {
            moji.com.mjwallet.databinding.LayoutItemRechargeBinding inflate = moji.com.mjwallet.databinding.LayoutItemRechargeBinding.inflate(android.view.LayoutInflater.from(parent.getContext()), parent, false);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
            return new moji.com.mjwallet.list.RecordListAdapter.RechargeViewHolder(inflate);
        }
        if (viewType == this.itemTypeExtract) {
            moji.com.mjwallet.databinding.LayoutItemRechargeBinding inflate2 = moji.com.mjwallet.databinding.LayoutItemRechargeBinding.inflate(android.view.LayoutInflater.from(parent.getContext()), parent, false);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(LayoutInflater.f….context), parent, false)");
            return new moji.com.mjwallet.list.RecordListAdapter.ExtractViewHolder(inflate2);
        }
        moji.com.mjwallet.databinding.LayoutItemBottomBinding inflate3 = moji.com.mjwallet.databinding.LayoutItemBottomBinding.inflate(android.view.LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(LayoutInflater.f….context), parent, false)");
        return new moji.com.mjwallet.list.RecordListAdapter.BottomViewHolder(inflate3);
    }

    public final void updateHasMore(boolean r1) {
        this.mHasMore = r1;
        this.mLoadFail = false;
    }

    public final void updateLoadingMoreFail() {
        this.mLoadFail = true;
    }
}
