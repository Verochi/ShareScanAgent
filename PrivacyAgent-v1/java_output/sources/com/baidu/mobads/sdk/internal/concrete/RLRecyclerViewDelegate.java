package com.baidu.mobads.sdk.internal.concrete;

/* loaded from: classes.dex */
public class RLRecyclerViewDelegate extends com.baidu.mobads.sdk.internal.widget.RLRecyclerView implements com.baidu.mobads.sdk.internal.a.a {
    private final com.baidu.mobads.sdk.internal.a.c a;
    private final com.baidu.mobads.sdk.internal.a.b b;

    /* renamed from: com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate$1, reason: invalid class name */
    class AnonymousClass1 extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
        final /* synthetic */ java.lang.Object a;

        public AnonymousClass1(java.lang.Object obj) {
            this.a = obj;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.this.a.a("onScrollStateChanged", this.a, java.lang.Integer.valueOf(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.this.a.a("onScrolled", this.a, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate$2, reason: invalid class name */
    class AnonymousClass2 implements androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener {
        public AnonymousClass2() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.this.a.a(com.alipay.sdk.m.x.d.p);
        }
    }

    public RLRecyclerViewDelegate(com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener, java.lang.Object[] objArr) {
        super((android.content.Context) objArr[0]);
        com.baidu.mobads.sdk.internal.a.b bVar = new com.baidu.mobads.sdk.internal.a.b();
        this.b = bVar;
        setLayoutManager(bVar.a(objArr, 1, 1), bVar.a(objArr, 2, 1), bVar.a(objArr, 3, 0));
        this.a = com.baidu.mobads.sdk.internal.a.c.a(iAdInterListener, this);
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
        if ("setAdapter".equals(str2)) {
            setAdapter((androidx.recyclerview.widget.RecyclerView.Adapter) objArr[0]);
            return null;
        }
        if ("setRefreshing".equals(str2)) {
            setRefreshing(((java.lang.Boolean) objArr[0]).booleanValue());
            return null;
        }
        if ("setItemDecoration".equals(str2)) {
            setItemDecoration(this.b.a(objArr, 0, 4), this.b.a(objArr, 1, 10), this.b.a(objArr, 2, 4), this.b.a(objArr, 3, 10));
            return null;
        }
        if ("setRvPadding".equals(str2)) {
            setRecyclerViewPadding(this.b.a(objArr, 0, 6), this.b.a(objArr, 1, 0), this.b.a(objArr, 2, 6), this.b.a(objArr, 3, 0));
            return null;
        }
        if ("setRefreshEnable".equals(str2)) {
            setEnabled(((java.lang.Boolean) objArr[0]).booleanValue());
            return null;
        }
        if ("scrollToPosition".equals(str2)) {
            scrollToPosition(this.b.a(objArr, 0, 0));
            return null;
        }
        if ("addOnScrollListener".equals(str2)) {
            addOnScrollListener(new com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.AnonymousClass1(objArr[0]));
            return null;
        }
        if ("setOnRefreshListener".equals(str2)) {
            setOnRefreshListener(new com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.AnonymousClass2());
            return null;
        }
        if ("findVisibleItemPositions".equals(str2)) {
            return findVisibleItemPositions();
        }
        if ("getLayoutManagerCounts".equals(str2)) {
            return getLayoutManagerCounts();
        }
        if ("getRvChildAt".equals(str2)) {
            return getRvChildAt(this.b.a(objArr, 0, -1));
        }
        if ("getRvChildCount".equals(str2)) {
            return java.lang.Integer.valueOf(getRvChildCount());
        }
        if ("indexOfRvChild".equals(str2)) {
            return java.lang.Integer.valueOf(indexOfRvChild((android.view.View) objArr[0]));
        }
        if ("getChildAdapterPosition".equals(str2)) {
            return java.lang.Integer.valueOf(getChildAdapterPosition((android.view.View) objArr[0]));
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(java.lang.Object obj) {
        this.a.setTarget(obj);
    }
}
