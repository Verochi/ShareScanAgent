package com.aliyun.svideo.common.baseAdapter.decoration;

/* loaded from: classes.dex */
public class GridSectionAverageGapItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private int eachItemHPaddingPx;
    private float gapHorizontalDp;
    private float gapVerticalDp;
    private com.aliyun.svideo.common.baseAdapter.BaseSectionQuickAdapter mAdapter;
    private float sectionEdgeHPaddingDp;
    private int sectionEdgeHPaddingPx;
    private float sectionEdgeVPaddingDp;
    private int sectionEdgeVPaddingPx;
    private int gapHSizePx = -1;
    private int gapVSizePx = -1;
    private java.util.List<com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.Section> mSectionList = new java.util.ArrayList();
    private androidx.recyclerview.widget.RecyclerView.AdapterDataObserver mDataObserver = new com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.AnonymousClass1();

    /* renamed from: com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.recyclerview.widget.RecyclerView.AdapterDataObserver {
        public AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.this.markSections();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.this.markSections();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, @androidx.annotation.Nullable java.lang.Object obj) {
            com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.this.markSections();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.this.markSections();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.this.markSections();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.this.markSections();
        }
    }

    public class Section {
        public int endPos;
        public int startPos;

        private Section() {
            this.startPos = 0;
            this.endPos = 0;
        }

        public /* synthetic */ Section(com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration gridSectionAverageGapItemDecoration, defpackage.zl0 zl0Var) {
            this();
        }

        public boolean contains(int i) {
            return i >= this.startPos && i <= this.endPos;
        }

        public int getCount() {
            return (this.endPos - this.startPos) + 1;
        }

        public java.lang.String toString() {
            return "Section{startPos=" + this.startPos + ", endPos=" + this.endPos + '}';
        }
    }

    public GridSectionAverageGapItemDecoration(float f, float f2, float f3, float f4) {
        this.gapHorizontalDp = f;
        this.gapVerticalDp = f2;
        this.sectionEdgeHPaddingDp = f3;
        this.sectionEdgeVPaddingDp = f4;
    }

    private com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.Section findSectionLastItemPos(int i) {
        for (com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.Section section : this.mSectionList) {
            if (section.contains(i)) {
                return section;
            }
        }
        return null;
    }

    private boolean isLastRow(int i, int i2, int i3) {
        int i4 = i3 % i2;
        if (i4 != 0) {
            i2 = i4;
        }
        return i > i3 - i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void markSections() {
        com.aliyun.svideo.common.baseAdapter.BaseSectionQuickAdapter baseSectionQuickAdapter = this.mAdapter;
        if (baseSectionQuickAdapter != null) {
            this.mSectionList.clear();
            com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.Section section = new com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.Section(this, null);
            int itemCount = baseSectionQuickAdapter.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                com.aliyun.svideo.common.baseAdapter.entity.SectionEntity sectionEntity = (com.aliyun.svideo.common.baseAdapter.entity.SectionEntity) baseSectionQuickAdapter.getItem(i);
                if (sectionEntity == null || !sectionEntity.isHeader) {
                    section.endPos = i;
                } else {
                    if (i != 0) {
                        section.endPos = i - 1;
                        this.mSectionList.add(section);
                    }
                    section = new com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.Section(this, null);
                    section.startPos = i + 1;
                }
            }
            if (this.mSectionList.contains(section)) {
                return;
            }
            this.mSectionList.add(section);
        }
    }

    private void setUpWithAdapter(com.aliyun.svideo.common.baseAdapter.BaseSectionQuickAdapter<com.aliyun.svideo.common.baseAdapter.entity.SectionEntity, com.aliyun.svideo.common.baseAdapter.BaseViewHolder> baseSectionQuickAdapter) {
        com.aliyun.svideo.common.baseAdapter.BaseSectionQuickAdapter baseSectionQuickAdapter2 = this.mAdapter;
        if (baseSectionQuickAdapter2 != null) {
            baseSectionQuickAdapter2.unregisterAdapterDataObserver(this.mDataObserver);
        }
        this.mAdapter = baseSectionQuickAdapter;
        baseSectionQuickAdapter.registerAdapterDataObserver(this.mDataObserver);
        markSections();
    }

    private void transformGapDefinition(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        recyclerView.getDisplay().getMetrics(displayMetrics);
        this.gapHSizePx = (int) android.util.TypedValue.applyDimension(1, this.gapHorizontalDp, displayMetrics);
        this.gapVSizePx = (int) android.util.TypedValue.applyDimension(1, this.gapVerticalDp, displayMetrics);
        this.sectionEdgeHPaddingPx = (int) android.util.TypedValue.applyDimension(1, this.sectionEdgeHPaddingDp, displayMetrics);
        this.sectionEdgeVPaddingPx = (int) android.util.TypedValue.applyDimension(1, this.sectionEdgeVPaddingDp, displayMetrics);
        this.eachItemHPaddingPx = ((this.sectionEdgeHPaddingPx * 2) + (this.gapHSizePx * (i - 1))) / i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        if (!(recyclerView.getLayoutManager() instanceof androidx.recyclerview.widget.GridLayoutManager) || !(recyclerView.getAdapter() instanceof com.aliyun.svideo.common.baseAdapter.BaseSectionQuickAdapter)) {
            super.getItemOffsets(rect, view, recyclerView, state);
            return;
        }
        androidx.recyclerview.widget.GridLayoutManager gridLayoutManager = (androidx.recyclerview.widget.GridLayoutManager) recyclerView.getLayoutManager();
        com.aliyun.svideo.common.baseAdapter.BaseSectionQuickAdapter<com.aliyun.svideo.common.baseAdapter.entity.SectionEntity, com.aliyun.svideo.common.baseAdapter.BaseViewHolder> baseSectionQuickAdapter = (com.aliyun.svideo.common.baseAdapter.BaseSectionQuickAdapter) recyclerView.getAdapter();
        if (this.mAdapter != baseSectionQuickAdapter) {
            setUpWithAdapter(baseSectionQuickAdapter);
        }
        int spanCount = gridLayoutManager.getSpanCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        com.aliyun.svideo.common.baseAdapter.entity.SectionEntity sectionEntity = (com.aliyun.svideo.common.baseAdapter.entity.SectionEntity) baseSectionQuickAdapter.getItem(childAdapterPosition);
        if (sectionEntity != null && sectionEntity.isHeader) {
            rect.set(0, 0, 0, 0);
            return;
        }
        com.aliyun.svideo.common.baseAdapter.decoration.GridSectionAverageGapItemDecoration.Section findSectionLastItemPos = findSectionLastItemPos(childAdapterPosition);
        if (this.gapHSizePx < 0 || this.gapVSizePx < 0) {
            transformGapDefinition(recyclerView, spanCount);
        }
        rect.top = this.gapVSizePx;
        rect.bottom = 0;
        int i = (childAdapterPosition + 1) - findSectionLastItemPos.startPos;
        int i2 = i % spanCount;
        if (i2 == 1) {
            int i3 = this.sectionEdgeHPaddingPx;
            rect.left = i3;
            rect.right = this.eachItemHPaddingPx - i3;
        } else if (i2 == 0) {
            int i4 = this.eachItemHPaddingPx;
            int i5 = this.sectionEdgeHPaddingPx;
            rect.left = i4 - i5;
            rect.right = i5;
        } else {
            int i6 = this.gapHSizePx;
            int i7 = this.eachItemHPaddingPx;
            int i8 = i6 - (i7 - this.sectionEdgeHPaddingPx);
            rect.left = i8;
            rect.right = i7 - i8;
        }
        if (i - spanCount <= 0) {
            rect.top = this.sectionEdgeVPaddingPx;
        }
        if (isLastRow(i, spanCount, findSectionLastItemPos.getCount())) {
            rect.bottom = this.sectionEdgeVPaddingPx;
        }
    }
}
