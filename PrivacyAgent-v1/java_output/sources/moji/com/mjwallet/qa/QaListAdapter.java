package moji.com.mjwallet.qa;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lmoji/com/mjwallet/qa/QaListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lmoji/com/mjwallet/qa/QaListAdapter$QaViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "getItemCount", "holder", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "", "onBindViewHolder", "", "Lmoji/com/mjwallet/qa/QAModel;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/util/List;", "modelList", "<init>", "(Ljava/util/List;)V", "QaViewHolder", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class QaListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<moji.com.mjwallet.qa.QaListAdapter.QaViewHolder> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<moji.com.mjwallet.qa.QAModel> modelList;

    @kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lmoji/com/mjwallet/qa/QaListAdapter$QaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lmoji/com/mjwallet/databinding/QaItemBinding;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjwallet/databinding/QaItemBinding;", "getBinding", "()Lmoji/com/mjwallet/databinding/QaItemBinding;", "binding", "<init>", "(Lmoji/com/mjwallet/databinding/QaItemBinding;)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
    public static final class QaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final moji.com.mjwallet.databinding.QaItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QaViewHolder(@org.jetbrains.annotations.NotNull moji.com.mjwallet.databinding.QaItemBinding binding) {
            super(binding.getRoot());
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        @org.jetbrains.annotations.NotNull
        public final moji.com.mjwallet.databinding.QaItemBinding getBinding() {
            return this.binding;
        }
    }

    public QaListAdapter(@org.jetbrains.annotations.NotNull java.util.List<moji.com.mjwallet.qa.QAModel> modelList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modelList, "modelList");
        this.modelList = modelList;
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void b(moji.com.mjwallet.qa.QaListAdapter this$0, int i, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.modelList.get(i).setSpread(!this$0.modelList.get(i).getSpread());
        this$0.notifyItemChanged(i);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.modelList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull moji.com.mjwallet.qa.QaListAdapter.QaViewHolder holder, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getBinding().qaQ.setText(com.moji.tool.AppDelegate.getAppContext().getString(moji.com.mjwallet.R.string.qa_prefix, java.lang.Integer.valueOf(position + 1), this.modelList.get(position).getQ()));
        holder.getBinding().qaA.setText(this.modelList.get(position).getA());
        if (this.modelList.get(position).getSpread()) {
            holder.getBinding().qaA.setVisibility(0);
            holder.getBinding().qaToogle.setImageResource(moji.com.mjwallet.R.drawable.icon_qa_rotate);
        } else {
            holder.getBinding().qaA.setVisibility(8);
            holder.getBinding().qaToogle.setImageResource(moji.com.mjwallet.R.drawable.icon_qa);
        }
        holder.getBinding().getRoot().setOnClickListener(new defpackage.u62(this, position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @org.jetbrains.annotations.NotNull
    public moji.com.mjwallet.qa.QaListAdapter.QaViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        moji.com.mjwallet.databinding.QaItemBinding inflate = moji.com.mjwallet.databinding.QaItemBinding.inflate(android.view.LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new moji.com.mjwallet.qa.QaListAdapter.QaViewHolder(inflate);
    }
}
