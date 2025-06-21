package moji.com.mjweatherservicebase.view.sliderbanner;

@kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u000b\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0003J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u001a\u0010\u001a\u001a\u00020\u00038\u0006X\u0086D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R+\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u001bj\b\u0012\u0004\u0012\u00020\u0003`\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R+\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001bj\b\u0012\u0004\u0012\u00020\u0006`\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R#\u0010*\u001a\n &*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00062"}, d2 = {"Lmoji/com/mjweatherservicebase/view/sliderbanner/BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "dataSize", "", "Lcom/moji/http/me/MeServiceEntity$EntranceRegionResListBean$EntranceResListBean;", org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, "Lcom/moji/opevent/OperationEventPage;", "type", "", "replaceData", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "getData", "getItemViewType", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "getItemCount", "holder", "onBindViewHolder", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "getBANNER", "()I", "BANNER", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "t", "Lkotlin/Lazy;", "a", "()Ljava/util/ArrayList;", "mAlreadyStatistics", com.umeng.analytics.pro.bo.aN, "getMList", "mList", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "v", "getMInflater", "()Landroid/view/LayoutInflater;", "mInflater", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Lcom/moji/opevent/OperationEventPage;", "mType", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class BannerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {

    /* renamed from: n, reason: from kotlin metadata */
    public final int BANNER;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mAlreadyStatistics;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mList;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mInflater;

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public com.moji.opevent.OperationEventPage mType;

    public BannerAdapter(@org.jetbrains.annotations.NotNull android.content.Context context) {
        kotlin.Lazy lazy;
        kotlin.Lazy lazy2;
        kotlin.Lazy lazy3;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        this.BANNER = 1;
        lazy = kotlin.LazyKt__LazyJVMKt.lazy(moji.com.mjweatherservicebase.view.sliderbanner.BannerAdapter$mAlreadyStatistics$2.INSTANCE);
        this.mAlreadyStatistics = lazy;
        lazy2 = kotlin.LazyKt__LazyJVMKt.lazy(moji.com.mjweatherservicebase.view.sliderbanner.BannerAdapter$mList$2.INSTANCE);
        this.mList = lazy2;
        lazy3 = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.view.sliderbanner.BannerAdapter$mInflater$2(context));
        this.mInflater = lazy3;
    }

    public final java.util.ArrayList<java.lang.Integer> a() {
        return (java.util.ArrayList) this.mAlreadyStatistics.getValue();
    }

    public final int dataSize() {
        return getMList().size();
    }

    public final int getBANNER() {
        return this.BANNER;
    }

    @org.jetbrains.annotations.Nullable
    public final com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean getData(int position) {
        return (com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean) kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(getMList(), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = getMList().size();
        if (size != 0) {
            return size != 1 ? 10000 : 1;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.BANNER;
    }

    public final android.view.LayoutInflater getMInflater() {
        return (android.view.LayoutInflater) this.mInflater.getValue();
    }

    public final java.util.ArrayList<com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean> getMList() {
        return (java.util.ArrayList) this.mList.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof moji.com.mjweatherservicebase.view.sliderbanner.BannerHolder) {
            com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean entranceResListBean = (com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean) kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(getMList(), position % getMList().size());
            if (entranceResListBean != null) {
                ((moji.com.mjweatherservicebase.view.sliderbanner.BannerHolder) holder).bindData(entranceResListBean, this.mType);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @org.jetbrains.annotations.NotNull
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        android.view.View inflate = getMInflater().inflate(moji.com.mjweatherservicebase.R.layout.item_banner_pager, parent, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "mInflater.inflate(R.layo…ner_pager, parent, false)");
        return new moji.com.mjweatherservicebase.view.sliderbanner.BannerHolder(inflate);
    }

    public final void replaceData(@org.jetbrains.annotations.NotNull java.util.List<? extends com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean> list, @org.jetbrains.annotations.Nullable com.moji.opevent.OperationEventPage type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
        this.mType = type;
        a().clear();
        getMList().clear();
        getMList().addAll(list);
        notifyDataSetChanged();
    }
}
