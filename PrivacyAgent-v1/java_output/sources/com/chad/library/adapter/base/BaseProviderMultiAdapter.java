package com.chad.library.adapter.base;

@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002B\u0019\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&¢\u0006\u0004\b'\u0010(J\u001e\u0010\b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H$J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J'\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00028\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004H\u0014¢\u0006\u0004\b\u0014\u0010\u0018J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0003H\u0014J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u0014R'\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "data", "", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "getItemType", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", com.umeng.analytics.pro.f.M, "", "addItemProvider", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateDefViewHolder", "getDefItemViewType", "holder", "item", "convert", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;I)V", "", "payloads", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "viewHolder", "bindViewClickListener", "getItemProvider", "onViewAttachedToWindow", "onViewDetachedFromWindow", "bindClick", "bindChildClick", "Landroid/util/SparseArray;", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "Lkotlin/Lazy;", "s", "()Landroid/util/SparseArray;", "mItemProviders", "", "<init>", "(Ljava/util/List;)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public abstract class BaseProviderMultiAdapter<T> extends com.chad.library.adapter.base.BaseQuickAdapter<T, com.chad.library.adapter.base.viewholder.BaseViewHolder> {

    /* renamed from: S, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mItemProviders;

    public BaseProviderMultiAdapter() {
        this(null, 1, null);
    }

    public BaseProviderMultiAdapter(@org.jetbrains.annotations.Nullable java.util.List<T> list) {
        super(0, list);
        kotlin.Lazy lazy;
        lazy = kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode.NONE, (kotlin.jvm.functions.Function0) com.chad.library.adapter.base.BaseProviderMultiAdapter$mItemProviders$2.INSTANCE);
        this.mItemProviders = lazy;
    }

    public /* synthetic */ BaseProviderMultiAdapter(java.util.List list, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void o(com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder, com.chad.library.adapter.base.BaseProviderMultiAdapter this$0, com.chad.library.adapter.base.provider.BaseItemProvider provider, android.view.View v) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(provider, "$provider");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
            return;
        }
        int headerLayoutCount = bindingAdapterPosition - this$0.getHeaderLayoutCount();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(v, "v");
        provider.onChildClick(viewHolder, v, this$0.getData().get(headerLayoutCount), headerLayoutCount);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
    }

    public static final boolean p(com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder, com.chad.library.adapter.base.BaseProviderMultiAdapter this$0, com.chad.library.adapter.base.provider.BaseItemProvider provider, android.view.View v) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(provider, "$provider");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int headerLayoutCount = bindingAdapterPosition - this$0.getHeaderLayoutCount();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(v, "v");
        return provider.onChildLongClick(viewHolder, v, this$0.getData().get(headerLayoutCount), headerLayoutCount);
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void q(com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder, com.chad.library.adapter.base.BaseProviderMultiAdapter this$0, android.view.View it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(it);
            return;
        }
        int headerLayoutCount = bindingAdapterPosition - this$0.getHeaderLayoutCount();
        com.chad.library.adapter.base.provider.BaseItemProvider<T> baseItemProvider = this$0.s().get(viewHolder.getItemViewType());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "it");
        baseItemProvider.onClick(viewHolder, it, this$0.getData().get(headerLayoutCount), headerLayoutCount);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(it);
    }

    public static final boolean r(com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder, com.chad.library.adapter.base.BaseProviderMultiAdapter this$0, android.view.View it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int headerLayoutCount = bindingAdapterPosition - this$0.getHeaderLayoutCount();
        com.chad.library.adapter.base.provider.BaseItemProvider<T> baseItemProvider = this$0.s().get(viewHolder.getItemViewType());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "it");
        return baseItemProvider.onLongClick(viewHolder, it, this$0.getData().get(headerLayoutCount), headerLayoutCount);
    }

    public void addItemProvider(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.provider.BaseItemProvider<T> provider) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(provider, "provider");
        provider.setAdapter$com_github_CymChad_brvah(this);
        s().put(provider.getItemViewType(), provider);
    }

    public void bindChildClick(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder, int viewType) {
        com.chad.library.adapter.base.provider.BaseItemProvider<T> itemProvider;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (getMOnItemChildClickListener() == null) {
            com.chad.library.adapter.base.provider.BaseItemProvider<T> itemProvider2 = getItemProvider(viewType);
            if (itemProvider2 == null) {
                return;
            }
            java.util.Iterator<T> it = itemProvider2.getChildClickViewIds().iterator();
            while (it.hasNext()) {
                android.view.View findViewById = viewHolder.itemView.findViewById(((java.lang.Number) it.next()).intValue());
                if (findViewById != null) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(id)");
                    if (!findViewById.isClickable()) {
                        findViewById.setClickable(true);
                    }
                    findViewById.setOnClickListener(new defpackage.jh(viewHolder, this, itemProvider2));
                }
            }
        }
        if (getMOnItemChildLongClickListener() != null || (itemProvider = getItemProvider(viewType)) == null) {
            return;
        }
        java.util.Iterator<T> it2 = itemProvider.getChildLongClickViewIds().iterator();
        while (it2.hasNext()) {
            android.view.View findViewById2 = viewHolder.itemView.findViewById(((java.lang.Number) it2.next()).intValue());
            if (findViewById2 != null) {
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<View>(id)");
                if (!findViewById2.isLongClickable()) {
                    findViewById2.setLongClickable(true);
                }
                findViewById2.setOnLongClickListener(new defpackage.kh(viewHolder, this, itemProvider));
            }
        }
    }

    public void bindClick(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (getMOnItemClickListener() == null) {
            viewHolder.itemView.setOnClickListener(new defpackage.lh(viewHolder, this));
        }
        if (getMOnItemLongClickListener() == null) {
            viewHolder.itemView.setOnLongClickListener(new defpackage.mh(viewHolder, this));
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void bindViewClickListener(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.bindViewClickListener(viewHolder, viewType);
        bindClick(viewHolder);
        bindChildClick(viewHolder, viewType);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder, T item, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        com.chad.library.adapter.base.provider.BaseItemProvider<T> itemProvider = getItemProvider(holder.getItemViewType());
        kotlin.jvm.internal.Intrinsics.checkNotNull(itemProvider);
        itemProvider.convert(holder, item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder, T item, @org.jetbrains.annotations.NotNull java.util.List<? extends java.lang.Object> payloads) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(payloads, "payloads");
        com.chad.library.adapter.base.provider.BaseItemProvider<T> itemProvider = getItemProvider(holder.getItemViewType());
        kotlin.jvm.internal.Intrinsics.checkNotNull(itemProvider);
        itemProvider.convert(holder, item, payloads);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int position) {
        return getItemType(getData(), position);
    }

    @org.jetbrains.annotations.Nullable
    public com.chad.library.adapter.base.provider.BaseItemProvider<T> getItemProvider(int viewType) {
        return s().get(viewType);
    }

    public abstract int getItemType(@org.jetbrains.annotations.NotNull java.util.List<? extends T> data, int position);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @org.jetbrains.annotations.NotNull
    public com.chad.library.adapter.base.viewholder.BaseViewHolder onCreateDefViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        com.chad.library.adapter.base.provider.BaseItemProvider<T> itemProvider = getItemProvider(viewType);
        if (itemProvider == null) {
            throw new java.lang.IllegalStateException(("ViewType: " + viewType + " no such provider found，please use addItemProvider() first!").toString());
        }
        android.content.Context context = parent.getContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        itemProvider.setContext(context);
        com.chad.library.adapter.base.viewholder.BaseViewHolder onCreateViewHolder = itemProvider.onCreateViewHolder(parent, viewType);
        itemProvider.onViewHolderCreated(onCreateViewHolder, viewType);
        return onCreateViewHolder;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow((com.chad.library.adapter.base.BaseProviderMultiAdapter<T>) holder);
        com.chad.library.adapter.base.provider.BaseItemProvider<T> itemProvider = getItemProvider(holder.getItemViewType());
        if (itemProvider != null) {
            itemProvider.onViewAttachedToWindow(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow((com.chad.library.adapter.base.BaseProviderMultiAdapter<T>) holder);
        com.chad.library.adapter.base.provider.BaseItemProvider<T> itemProvider = getItemProvider(holder.getItemViewType());
        if (itemProvider != null) {
            itemProvider.onViewDetachedFromWindow(holder);
        }
    }

    public final android.util.SparseArray<com.chad.library.adapter.base.provider.BaseItemProvider<T>> s() {
        return (android.util.SparseArray) this.mItemProviders.getValue();
    }
}
