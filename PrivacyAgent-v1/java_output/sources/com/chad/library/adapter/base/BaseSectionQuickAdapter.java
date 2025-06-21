package com.chad.library.adapter.base;

@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B%\b\u0007\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u000f\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b¢\u0006\u0004\b\u001d\u0010\u001eB/\b\u0016\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u000f\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b¢\u0006\u0004\b\u001d\u0010\u001fJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u0000H$¢\u0006\u0004\b\t\u0010\nJ-\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014¢\u0006\u0004\b\t\u0010\u000eJ\u0012\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\u000fH\u0004J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u001f\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001a¨\u0006 "}, d2 = {"Lcom/chad/library/adapter/base/BaseSectionQuickAdapter;", "Lcom/chad/library/adapter/base/entity/SectionEntity;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "VH", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "helper", "item", "", "convertHeader", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/chad/library/adapter/base/entity/SectionEntity;)V", "", "", "payloads", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/chad/library/adapter/base/entity/SectionEntity;Ljava/util/List;)V", "", "layoutResId", "setNormalLayout", "type", "", "isFixedViewType", "holder", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "onBindViewHolder", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;ILjava/util/List;)V", "I", "sectionHeadResId", "data", "<init>", "(ILjava/util/List;)V", "(IILjava/util/List;)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public abstract class BaseSectionQuickAdapter<T extends com.chad.library.adapter.base.entity.SectionEntity, VH extends com.chad.library.adapter.base.viewholder.BaseViewHolder> extends com.chad.library.adapter.base.BaseMultiItemQuickAdapter<T, VH> {

    /* renamed from: T, reason: from kotlin metadata */
    public final int sectionHeadResId;

    @kotlin.jvm.JvmOverloads
    public BaseSectionQuickAdapter(@androidx.annotation.LayoutRes int i) {
        this(i, null, 2, null);
    }

    public BaseSectionQuickAdapter(@androidx.annotation.LayoutRes int i, @androidx.annotation.LayoutRes int i2, @org.jetbrains.annotations.Nullable java.util.List<T> list) {
        this(i, list);
        setNormalLayout(i2);
    }

    public /* synthetic */ BaseSectionQuickAdapter(int i, int i2, java.util.List list, int i3, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? null : list);
    }

    @kotlin.jvm.JvmOverloads
    public BaseSectionQuickAdapter(@androidx.annotation.LayoutRes int i, @org.jetbrains.annotations.Nullable java.util.List<T> list) {
        super(list);
        this.sectionHeadResId = i;
        addItemType(-99, i);
    }

    public /* synthetic */ BaseSectionQuickAdapter(int i, java.util.List list, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : list);
    }

    public abstract void convertHeader(@org.jetbrains.annotations.NotNull VH helper, @org.jetbrains.annotations.NotNull T item);

    public void convertHeader(@org.jetbrains.annotations.NotNull VH helper, @org.jetbrains.annotations.NotNull T item, @org.jetbrains.annotations.NotNull java.util.List<java.lang.Object> payloads) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(helper, "helper");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(item, "item");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(payloads, "payloads");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int type) {
        return super.isFixedViewType(type) || type == -99;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i, java.util.List list) {
        onBindViewHolder((com.chad.library.adapter.base.BaseSectionQuickAdapter<T, VH>) viewHolder, i, (java.util.List<java.lang.Object>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull VH holder, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder.getItemViewType() == -99) {
            convertHeader(holder, (com.chad.library.adapter.base.entity.SectionEntity) getItem(position - getHeaderLayoutCount()));
        } else {
            super.onBindViewHolder((com.chad.library.adapter.base.BaseSectionQuickAdapter<T, VH>) holder, position);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull VH holder, int position, @org.jetbrains.annotations.NotNull java.util.List<java.lang.Object> payloads) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder((com.chad.library.adapter.base.BaseSectionQuickAdapter<T, VH>) holder, position);
        } else if (holder.getItemViewType() == -99) {
            convertHeader(holder, (com.chad.library.adapter.base.entity.SectionEntity) getItem(position - getHeaderLayoutCount()), payloads);
        } else {
            super.onBindViewHolder((com.chad.library.adapter.base.BaseSectionQuickAdapter<T, VH>) holder, position, payloads);
        }
    }

    public final void setNormalLayout(@androidx.annotation.LayoutRes int layoutResId) {
        addItemType(-100, layoutResId);
    }
}
