package com.aliyun.svideo.common.baseAdapter;

/* loaded from: classes.dex */
public abstract class BaseSectionQuickAdapter<T extends com.aliyun.svideo.common.baseAdapter.entity.SectionEntity, K extends com.aliyun.svideo.common.baseAdapter.BaseViewHolder> extends com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter<T, K> {
    protected static final int SECTION_HEADER_VIEW = 1092;
    protected int mSectionHeadResId;

    public BaseSectionQuickAdapter(int i, int i2, java.util.List<T> list) {
        super(i, list);
        this.mSectionHeadResId = i2;
    }

    public abstract void convertHead(K k, T t);

    @Override // com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
    public int getDefItemViewType(int i) {
        if (((com.aliyun.svideo.common.baseAdapter.entity.SectionEntity) this.mData.get(i)).isHeader) {
            return SECTION_HEADER_VIEW;
        }
        return 0;
    }

    @Override // com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
    public boolean isFixedViewType(int i) {
        return super.isFixedViewType(i) || i == SECTION_HEADER_VIEW;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(K k, int i) {
        if (k.getItemViewType() != SECTION_HEADER_VIEW) {
            super.onBindViewHolder((com.aliyun.svideo.common.baseAdapter.BaseSectionQuickAdapter<T, K>) k, i);
        } else {
            setFullSpan(k);
            convertHead(k, (com.aliyun.svideo.common.baseAdapter.entity.SectionEntity) getItem(i - getHeaderLayoutCount()));
        }
    }

    @Override // com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
    public K onCreateDefViewHolder(android.view.ViewGroup viewGroup, int i) {
        return i == SECTION_HEADER_VIEW ? createBaseViewHolder(getItemView(this.mSectionHeadResId, viewGroup)) : (K) super.onCreateDefViewHolder(viewGroup, i);
    }
}
