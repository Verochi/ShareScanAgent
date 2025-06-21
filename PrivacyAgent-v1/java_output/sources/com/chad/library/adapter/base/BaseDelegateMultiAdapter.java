package com.chad.library.adapter.base;

@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u0019\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005J\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005J\u001f\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0014R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/chad/library/adapter/base/BaseDelegateMultiAdapter;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "VH", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/delegate/BaseMultiTypeDelegate;", "multiTypeDelegate", "", "setMultiTypeDelegate", "getMultiTypeDelegate", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateDefViewHolder", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "getDefItemViewType", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "Lcom/chad/library/adapter/base/delegate/BaseMultiTypeDelegate;", "mMultiTypeDelegate", "", "data", "<init>", "(Ljava/util/List;)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public abstract class BaseDelegateMultiAdapter<T, VH extends com.chad.library.adapter.base.viewholder.BaseViewHolder> extends com.chad.library.adapter.base.BaseQuickAdapter<T, VH> {

    /* renamed from: S, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate<T> mMultiTypeDelegate;

    public BaseDelegateMultiAdapter() {
        this(null, 1, null);
    }

    public BaseDelegateMultiAdapter(@org.jetbrains.annotations.Nullable java.util.List<T> list) {
        super(0, list);
    }

    public /* synthetic */ BaseDelegateMultiAdapter(java.util.List list, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int position) {
        com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate<T> multiTypeDelegate = getMultiTypeDelegate();
        if (multiTypeDelegate != null) {
            return multiTypeDelegate.getItemType(getData(), position);
        }
        throw new java.lang.IllegalStateException("Please use setMultiTypeDelegate first!".toString());
    }

    @org.jetbrains.annotations.Nullable
    public final com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate<T> getMultiTypeDelegate() {
        return this.mMultiTypeDelegate;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @org.jetbrains.annotations.NotNull
    public VH onCreateDefViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate<T> multiTypeDelegate = getMultiTypeDelegate();
        if (multiTypeDelegate != null) {
            return createBaseViewHolder(parent, multiTypeDelegate.getLayoutId(viewType));
        }
        throw new java.lang.IllegalStateException("Please use setMultiTypeDelegate first!".toString());
    }

    public final void setMultiTypeDelegate(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate<T> multiTypeDelegate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(multiTypeDelegate, "multiTypeDelegate");
        this.mMultiTypeDelegate = multiTypeDelegate;
    }
}
