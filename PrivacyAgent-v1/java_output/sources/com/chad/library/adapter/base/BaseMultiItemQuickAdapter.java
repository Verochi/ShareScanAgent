package com.chad.library.adapter.base;

@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0019\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u001f\u0010\f\u001a\u00028\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H\u0004R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "VH", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "getDefItemViewType", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateDefViewHolder", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "type", "layoutResId", "", "addItemType", "Landroid/util/SparseIntArray;", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "Lkotlin/Lazy;", "k", "()Landroid/util/SparseIntArray;", "layouts", "", "data", "<init>", "(Ljava/util/List;)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public abstract class BaseMultiItemQuickAdapter<T extends com.chad.library.adapter.base.entity.MultiItemEntity, VH extends com.chad.library.adapter.base.viewholder.BaseViewHolder> extends com.chad.library.adapter.base.BaseQuickAdapter<T, VH> {

    /* renamed from: S, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy layouts;

    public BaseMultiItemQuickAdapter() {
        this(null, 1, null);
    }

    public BaseMultiItemQuickAdapter(@org.jetbrains.annotations.Nullable java.util.List<T> list) {
        super(0, list);
        kotlin.Lazy lazy;
        lazy = kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode.NONE, (kotlin.jvm.functions.Function0) com.chad.library.adapter.base.BaseMultiItemQuickAdapter$layouts$2.INSTANCE);
        this.layouts = lazy;
    }

    public /* synthetic */ BaseMultiItemQuickAdapter(java.util.List list, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final void addItemType(int type, @androidx.annotation.LayoutRes int layoutResId) {
        k().put(type, layoutResId);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int position) {
        return ((com.chad.library.adapter.base.entity.MultiItemEntity) getData().get(position)).getItemType();
    }

    public final android.util.SparseIntArray k() {
        return (android.util.SparseIntArray) this.layouts.getValue();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @org.jetbrains.annotations.NotNull
    public VH onCreateDefViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        int i = k().get(viewType);
        if (i != 0) {
            return createBaseViewHolder(parent, i);
        }
        throw new java.lang.IllegalArgumentException(("ViewType: " + viewType + " found layoutResId，please use addItemType() first!").toString());
    }
}
