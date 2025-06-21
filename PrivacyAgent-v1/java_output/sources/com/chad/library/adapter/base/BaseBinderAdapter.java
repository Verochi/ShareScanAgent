package com.chad.library.adapter.base;

@kotlin.Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00012B\u0019\u0012\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010.¢\u0006\u0004\b0\u00101JF\u0010\u000b\u001a\u00020\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00052\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tH\u0007J9\u0010\u000b\u001a\u00020\u0000\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tH\u0086\bJ\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0014J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0014J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001e\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0014J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0014\u0010!\u001a\u00020\u000e2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0004J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0003H\u0014J\u0018\u0010#\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0014RH\u0010(\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t0$j\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t`%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R8\u0010)\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u000e0$j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u000e`%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010'R$\u0010-\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u00070*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00063"}, d2 = {"Lcom/chad/library/adapter/base/BaseBinderAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "baseItemBinder", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "callback", "addItemBinder", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateDefViewHolder", "holder", "item", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "", "convert", "", "payloads", "getItemBinder", "getItemBinderOrNull", "getDefItemViewType", "viewHolder", "bindViewClickListener", "onViewAttachedToWindow", "onViewDetachedFromWindow", "", "onFailedToRecycleView", "findViewType", "bindClick", "bindChildClick", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "Ljava/util/HashMap;", "classDiffMap", "mTypeMap", "Landroid/util/SparseArray;", "U", "Landroid/util/SparseArray;", "mBinderArray", "", org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, "<init>", "(Ljava/util/List;)V", "ItemCallback", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public class BaseBinderAdapter extends com.chad.library.adapter.base.BaseQuickAdapter<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> {

    /* renamed from: S, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.Class<?>, androidx.recyclerview.widget.DiffUtil.ItemCallback<java.lang.Object>> classDiffMap;

    /* renamed from: T, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.Class<?>, java.lang.Integer> mTypeMap;

    /* renamed from: U, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final android.util.SparseArray<com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, ?>> mBinderArray;

    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/chad/library/adapter/base/BaseBinderAdapter$ItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "(Lcom/chad/library/adapter/base/BaseBinderAdapter;)V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "getChangePayload", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ItemCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<java.lang.Object> {
        public ItemCallback() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @android.annotation.SuppressLint({"DiffUtilEquals"})
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull java.lang.Object oldItem, @org.jetbrains.annotations.NotNull java.lang.Object newItem) {
            androidx.recyclerview.widget.DiffUtil.ItemCallback itemCallback;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (!kotlin.jvm.internal.Intrinsics.areEqual(oldItem.getClass(), newItem.getClass()) || (itemCallback = (androidx.recyclerview.widget.DiffUtil.ItemCallback) com.chad.library.adapter.base.BaseBinderAdapter.this.classDiffMap.get(oldItem.getClass())) == null) {
                return true;
            }
            return itemCallback.areContentsTheSame(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull java.lang.Object oldItem, @org.jetbrains.annotations.NotNull java.lang.Object newItem) {
            androidx.recyclerview.widget.DiffUtil.ItemCallback itemCallback;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newItem, "newItem");
            return (!kotlin.jvm.internal.Intrinsics.areEqual(oldItem.getClass(), newItem.getClass()) || (itemCallback = (androidx.recyclerview.widget.DiffUtil.ItemCallback) com.chad.library.adapter.base.BaseBinderAdapter.this.classDiffMap.get(oldItem.getClass())) == null) ? kotlin.jvm.internal.Intrinsics.areEqual(oldItem, newItem) : itemCallback.areItemsTheSame(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @org.jetbrains.annotations.Nullable
        public java.lang.Object getChangePayload(@org.jetbrains.annotations.NotNull java.lang.Object oldItem, @org.jetbrains.annotations.NotNull java.lang.Object newItem) {
            androidx.recyclerview.widget.DiffUtil.ItemCallback itemCallback;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (!kotlin.jvm.internal.Intrinsics.areEqual(oldItem.getClass(), newItem.getClass()) || (itemCallback = (androidx.recyclerview.widget.DiffUtil.ItemCallback) com.chad.library.adapter.base.BaseBinderAdapter.this.classDiffMap.get(oldItem.getClass())) == null) {
                return null;
            }
            return itemCallback.getChangePayload(oldItem, newItem);
        }
    }

    public BaseBinderAdapter() {
        this(null, 1, null);
    }

    public BaseBinderAdapter(@org.jetbrains.annotations.Nullable java.util.List<java.lang.Object> list) {
        super(0, list);
        this.classDiffMap = new java.util.HashMap<>();
        this.mTypeMap = new java.util.HashMap<>();
        this.mBinderArray = new android.util.SparseArray<>();
        setDiffCallback(new com.chad.library.adapter.base.BaseBinderAdapter.ItemCallback());
    }

    public /* synthetic */ BaseBinderAdapter(java.util.List list, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public static /* synthetic */ com.chad.library.adapter.base.BaseBinderAdapter addItemBinder$default(com.chad.library.adapter.base.BaseBinderAdapter baseBinderAdapter, com.chad.library.adapter.base.binder.BaseItemBinder baseItemBinder, androidx.recyclerview.widget.DiffUtil.ItemCallback itemCallback, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
        }
        if ((i & 2) != 0) {
            itemCallback = null;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseItemBinder, "baseItemBinder");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE);
        baseBinderAdapter.addItemBinder(java.lang.Object.class, baseItemBinder, itemCallback);
        return baseBinderAdapter;
    }

    public static /* synthetic */ com.chad.library.adapter.base.BaseBinderAdapter addItemBinder$default(com.chad.library.adapter.base.BaseBinderAdapter baseBinderAdapter, java.lang.Class cls, com.chad.library.adapter.base.binder.BaseItemBinder baseItemBinder, androidx.recyclerview.widget.DiffUtil.ItemCallback itemCallback, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
        }
        if ((i & 4) != 0) {
            itemCallback = null;
        }
        return baseBinderAdapter.addItemBinder(cls, baseItemBinder, itemCallback);
    }

    public static final boolean o(com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder, com.chad.library.adapter.base.BaseBinderAdapter this$0, com.chad.library.adapter.base.binder.BaseItemBinder provider, android.view.View v) {
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
    public static final void p(com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder, com.chad.library.adapter.base.BaseBinderAdapter this$0, com.chad.library.adapter.base.binder.BaseItemBinder provider, android.view.View v) {
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

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void q(com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder, com.chad.library.adapter.base.BaseBinderAdapter this$0, android.view.View it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(it);
            return;
        }
        int headerLayoutCount = bindingAdapterPosition - this$0.getHeaderLayoutCount();
        com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> itemBinder = this$0.getItemBinder(viewHolder.getItemViewType());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "it");
        itemBinder.onClick(viewHolder, it, this$0.getData().get(headerLayoutCount), headerLayoutCount);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(it);
    }

    public static final boolean r(com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder, com.chad.library.adapter.base.BaseBinderAdapter this$0, android.view.View it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int headerLayoutCount = bindingAdapterPosition - this$0.getHeaderLayoutCount();
        com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> itemBinder = this$0.getItemBinder(viewHolder.getItemViewType());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "it");
        return itemBinder.onLongClick(viewHolder, it, this$0.getData().get(headerLayoutCount), headerLayoutCount);
    }

    public final /* synthetic */ <T> com.chad.library.adapter.base.BaseBinderAdapter addItemBinder(com.chad.library.adapter.base.binder.BaseItemBinder<T, ?> baseItemBinder, androidx.recyclerview.widget.DiffUtil.ItemCallback<T> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseItemBinder, "baseItemBinder");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE);
        addItemBinder(java.lang.Object.class, baseItemBinder, callback);
        return this;
    }

    @kotlin.jvm.JvmOverloads
    @org.jetbrains.annotations.NotNull
    public final <T> com.chad.library.adapter.base.BaseBinderAdapter addItemBinder(@org.jetbrains.annotations.NotNull java.lang.Class<? extends T> clazz, @org.jetbrains.annotations.NotNull com.chad.library.adapter.base.binder.BaseItemBinder<T, ?> baseItemBinder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(clazz, "clazz");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseItemBinder, "baseItemBinder");
        return addItemBinder$default(this, clazz, baseItemBinder, null, 4, null);
    }

    @kotlin.jvm.JvmOverloads
    @org.jetbrains.annotations.NotNull
    public final <T> com.chad.library.adapter.base.BaseBinderAdapter addItemBinder(@org.jetbrains.annotations.NotNull java.lang.Class<? extends T> clazz, @org.jetbrains.annotations.NotNull com.chad.library.adapter.base.binder.BaseItemBinder<T, ?> baseItemBinder, @org.jetbrains.annotations.Nullable androidx.recyclerview.widget.DiffUtil.ItemCallback<T> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(clazz, "clazz");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseItemBinder, "baseItemBinder");
        int size = this.mTypeMap.size() + 1;
        this.mTypeMap.put(clazz, java.lang.Integer.valueOf(size));
        this.mBinderArray.append(size, baseItemBinder);
        baseItemBinder.set_adapter$com_github_CymChad_brvah(this);
        if (callback != null) {
            this.classDiffMap.put(clazz, callback);
        }
        return this;
    }

    public void bindChildClick(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (getMOnItemChildClickListener() == null) {
            com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> itemBinder = getItemBinder(viewType);
            java.util.Iterator<T> it = itemBinder.getChildClickViewIds().iterator();
            while (it.hasNext()) {
                android.view.View findViewById = viewHolder.itemView.findViewById(((java.lang.Number) it.next()).intValue());
                if (findViewById != null) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(id)");
                    if (!findViewById.isClickable()) {
                        findViewById.setClickable(true);
                    }
                    findViewById.setOnClickListener(new defpackage.rg(viewHolder, this, itemBinder));
                }
            }
        }
        if (getMOnItemChildLongClickListener() == null) {
            com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> itemBinder2 = getItemBinder(viewType);
            java.util.Iterator<T> it2 = itemBinder2.getChildLongClickViewIds().iterator();
            while (it2.hasNext()) {
                android.view.View findViewById2 = viewHolder.itemView.findViewById(((java.lang.Number) it2.next()).intValue());
                if (findViewById2 != null) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<View>(id)");
                    if (!findViewById2.isLongClickable()) {
                        findViewById2.setLongClickable(true);
                    }
                    findViewById2.setOnLongClickListener(new defpackage.sg(viewHolder, this, itemBinder2));
                }
            }
        }
    }

    public void bindClick(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder viewHolder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (getMOnItemClickListener() == null) {
            viewHolder.itemView.setOnClickListener(new defpackage.pg(viewHolder, this));
        }
        if (getMOnItemLongClickListener() == null) {
            viewHolder.itemView.setOnLongClickListener(new defpackage.qg(viewHolder, this));
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
    public void convert(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder, @org.jetbrains.annotations.NotNull java.lang.Object item, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(item, "item");
        getItemBinder(holder.getItemViewType()).convert(holder, item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder, @org.jetbrains.annotations.NotNull java.lang.Object item, @org.jetbrains.annotations.NotNull java.util.List<? extends java.lang.Object> payloads) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(item, "item");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(payloads, "payloads");
        getItemBinder(holder.getItemViewType()).convert(holder, item, payloads);
    }

    public final int findViewType(@org.jetbrains.annotations.NotNull java.lang.Class<?> clazz) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(clazz, "clazz");
        java.lang.Integer num = this.mTypeMap.get(clazz);
        if (num != null) {
            return num.intValue();
        }
        throw new java.lang.IllegalStateException(("findViewType: ViewType: " + clazz + " Not Find!").toString());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int position) {
        return findViewType(getData().get(position).getClass());
    }

    @org.jetbrains.annotations.NotNull
    public com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> getItemBinder(int viewType) {
        com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> baseItemBinder = (com.chad.library.adapter.base.binder.BaseItemBinder) this.mBinderArray.get(viewType);
        if (baseItemBinder != null) {
            return baseItemBinder;
        }
        throw new java.lang.IllegalStateException(("getItemBinder: viewType '" + viewType + "' no such Binder found，please use addItemBinder() first!").toString());
    }

    @org.jetbrains.annotations.Nullable
    public com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> getItemBinderOrNull(int viewType) {
        com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> baseItemBinder = (com.chad.library.adapter.base.binder.BaseItemBinder) this.mBinderArray.get(viewType);
        if (baseItemBinder == null) {
            return null;
        }
        return baseItemBinder;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @org.jetbrains.annotations.NotNull
    public com.chad.library.adapter.base.viewholder.BaseViewHolder onCreateDefViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> itemBinder = getItemBinder(viewType);
        itemBinder.set_context$com_github_CymChad_brvah(getContext());
        return itemBinder.onCreateViewHolder(parent, viewType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> itemBinderOrNull = getItemBinderOrNull(holder.getItemViewType());
        if (itemBinderOrNull != null) {
            return itemBinderOrNull.onFailedToRecycleView(holder);
        }
        return false;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow((com.chad.library.adapter.base.BaseBinderAdapter) holder);
        com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> itemBinderOrNull = getItemBinderOrNull(holder.getItemViewType());
        if (itemBinderOrNull != null) {
            itemBinderOrNull.onViewAttachedToWindow(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow((com.chad.library.adapter.base.BaseBinderAdapter) holder);
        com.chad.library.adapter.base.binder.BaseItemBinder<java.lang.Object, com.chad.library.adapter.base.viewholder.BaseViewHolder> itemBinderOrNull = getItemBinderOrNull(holder.getItemViewType());
        if (itemBinderOrNull != null) {
            itemBinderOrNull.onViewDetachedFromWindow(holder);
        }
    }
}
