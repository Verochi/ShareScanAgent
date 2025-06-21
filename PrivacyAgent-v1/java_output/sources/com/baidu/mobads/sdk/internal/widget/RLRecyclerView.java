package com.baidu.mobads.sdk.internal.widget;

/* loaded from: classes.dex */
public class RLRecyclerView extends androidx.swiperefreshlayout.widget.SwipeRefreshLayout {
    private androidx.recyclerview.widget.RecyclerView a;
    private int[] b;
    private int[] c;
    private int[] d;

    public static class NormalItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
        private final int a;
        private final int b;
        private final int c;
        private final int d;

        public NormalItemDecoration(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
            rect.left = this.a;
            rect.top = this.b;
            rect.right = this.c;
            rect.bottom = this.d;
        }
    }

    public RLRecyclerView(android.content.Context context) {
        super(context);
        this.c = new int[2];
        this.d = new int[2];
        a(context);
    }

    public RLRecyclerView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new int[2];
        this.d = new int[2];
        a(context);
    }

    private int a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 < i) {
                i = i2;
            }
        }
        return i;
    }

    private void a(android.content.Context context) {
        this.a = new androidx.recyclerview.widget.RecyclerView(context);
        addView(this.a, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    private int b(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    public void addOnScrollListener(androidx.recyclerview.widget.RecyclerView.OnScrollListener onScrollListener) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }

    public int[] findVisibleItemPositions() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView == null) {
            return null;
        }
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof androidx.recyclerview.widget.GridLayoutManager) {
            androidx.recyclerview.widget.GridLayoutManager gridLayoutManager = (androidx.recyclerview.widget.GridLayoutManager) layoutManager;
            this.d[0] = gridLayoutManager.findFirstVisibleItemPosition();
            this.d[1] = gridLayoutManager.findLastVisibleItemPosition();
            return this.d;
        }
        if (layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) {
            androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = (androidx.recyclerview.widget.LinearLayoutManager) layoutManager;
            this.d[0] = linearLayoutManager.findFirstVisibleItemPosition();
            this.d[1] = linearLayoutManager.findLastVisibleItemPosition();
            return this.d;
        }
        if (!(layoutManager instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager)) {
            return null;
        }
        androidx.recyclerview.widget.StaggeredGridLayoutManager staggeredGridLayoutManager = (androidx.recyclerview.widget.StaggeredGridLayoutManager) layoutManager;
        if (this.b == null) {
            this.b = new int[staggeredGridLayoutManager.getSpanCount()];
        }
        staggeredGridLayoutManager.findFirstVisibleItemPositions(this.b);
        this.d[0] = a(this.b);
        staggeredGridLayoutManager.findLastVisibleItemPositions(this.b);
        this.d[1] = b(this.b);
        return this.d;
    }

    public int getChildAdapterPosition(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            return recyclerView.getChildAdapterPosition(view);
        }
        return -1;
    }

    public int[] getLayoutManagerCounts() {
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return null;
        }
        this.c[0] = layoutManager.getItemCount();
        this.c[1] = layoutManager.getChildCount();
        return this.c;
    }

    public android.view.View getRvChildAt(int i) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            return recyclerView.getChildAt(i);
        }
        return null;
    }

    public int getRvChildCount() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            return recyclerView.getChildCount();
        }
        return 0;
    }

    public int indexOfRvChild(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            return recyclerView.indexOfChild(view);
        }
        return -1;
    }

    public void scrollToPosition(int i) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(i);
        }
    }

    public void setAdapter(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter adapter) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    public void setItemDecoration(int i, int i2, int i3, int i4) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new com.baidu.mobads.sdk.internal.widget.RLRecyclerView.NormalItemDecoration(i, i2, i3, i4));
        }
    }

    public void setLayoutManager(int i, int i2, int i3) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            if (1 == i) {
                recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext()));
            } else if (2 == i) {
                recyclerView.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(getContext(), i2));
            } else if (3 == i) {
                recyclerView.setLayoutManager(new androidx.recyclerview.widget.StaggeredGridLayoutManager(i2, i3));
            }
        }
    }

    public void setRecyclerViewPadding(int i, int i2, int i3, int i4) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            recyclerView.setPadding(i, i2, i3, i4);
        }
    }
}
