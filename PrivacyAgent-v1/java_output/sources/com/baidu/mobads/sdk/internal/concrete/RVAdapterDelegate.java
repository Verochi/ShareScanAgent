package com.baidu.mobads.sdk.internal.concrete;

/* loaded from: classes.dex */
public class RVAdapterDelegate extends androidx.recyclerview.widget.RecyclerView.Adapter<com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate> implements com.baidu.mobads.sdk.internal.a.a {
    private final com.baidu.mobads.sdk.internal.a.c a;
    private final com.baidu.mobads.sdk.internal.a.b b;

    /* renamed from: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate$1, reason: invalid class name */
    class AnonymousClass1 extends com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.this.a.a("onChanged");
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate$2, reason: invalid class name */
    class AnonymousClass2 extends com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate {
        public AnonymousClass2(com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener, android.view.View view) {
            super(iAdInterListener, view);
        }
    }

    public RVAdapterDelegate(@androidx.annotation.NonNull com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener) {
        this.a = com.baidu.mobads.sdk.internal.a.c.a(iAdInterListener, this);
        registerAdapterDataObserver(new com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.AnonymousClass1());
        this.b = new com.baidu.mobads.sdk.internal.a.b();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.util.Map<java.lang.String, java.lang.Object> getData() {
        return this.a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @androidx.annotation.NonNull
    public com.baidu.mobads.sdk.api.IAdInterListener getDelegator() {
        return this.a.getDelegator();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        java.lang.Object a = this.a.a("getItemCount", new java.lang.Object[0]);
        if (a instanceof java.lang.Integer) {
            return ((java.lang.Integer) a).intValue();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.a.a("getItemId", java.lang.Integer.valueOf(i)) instanceof java.lang.Integer ? ((java.lang.Integer) r0).intValue() : super.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        java.lang.Object a = this.a.a("getItemType", java.lang.Integer.valueOf(i));
        return a instanceof java.lang.Integer ? ((java.lang.Integer) a).intValue() : super.getItemViewType(i);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.String getMessage() {
        return this.a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.Object getTarget() {
        return this.a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.String getType() {
        return this.a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public java.lang.Object handleEvent(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
        if ("notifyItemChanged".equals(str2)) {
            notifyItemChanged(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, (java.lang.Object) null));
        } else if ("notifyRangeInserted".equals(str2)) {
            notifyItemRangeInserted(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, 0));
        } else if ("notifyRangeRemoved".equals(str2)) {
            notifyItemRangeRemoved(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, 0));
        } else if ("notifyItemRangeChanged".equals(str2)) {
            notifyItemRangeChanged(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, 0));
        } else if ("notifyDataSetChanged".equals(str2)) {
            notifyDataSetChanged();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.a.a("onAttachedToRecyclerView", recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@androidx.annotation.NonNull com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate rVViewHolderDelegate, int i) {
        this.a.a("onBindViewHolder", rVViewHolderDelegate.getDelegator(), java.lang.Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @androidx.annotation.NonNull
    public com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate onCreateViewHolder(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, int i) {
        java.lang.Object a = this.a.a("onCreateViewHolder", viewGroup, java.lang.Integer.valueOf(i));
        return a instanceof com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate ? (com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate) a : new com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.AnonymousClass2(this.a.getDelegator(), viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.a.a("onDetachedFromRecyclerView", recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@androidx.annotation.NonNull com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate rVViewHolderDelegate) {
        java.lang.Object a = this.a.a("onFailedToRecycleView", rVViewHolderDelegate.getDelegator());
        return a instanceof java.lang.Boolean ? ((java.lang.Boolean) a).booleanValue() : super.onFailedToRecycleView((com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate) rVViewHolderDelegate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@androidx.annotation.NonNull com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewAttachedToWindow((com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate) rVViewHolderDelegate);
        this.a.a("onViewAttachedToWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@androidx.annotation.NonNull com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewDetachedFromWindow((com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate) rVViewHolderDelegate);
        this.a.a("onViewDetachedFromWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@androidx.annotation.NonNull com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewRecycled((com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate) rVViewHolderDelegate);
        this.a.a("onViewRecycled", rVViewHolderDelegate.getDelegator());
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(java.lang.Object obj) {
        this.a.setTarget(obj);
    }
}
