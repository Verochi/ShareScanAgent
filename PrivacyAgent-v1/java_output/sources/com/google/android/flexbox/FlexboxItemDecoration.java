package com.google.android.flexbox;

/* loaded from: classes22.dex */
public class FlexboxItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    public static final int BOTH = 3;
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    public static final int[] u = {android.R.attr.listDivider};
    public android.graphics.drawable.Drawable n;
    public int t;

    public FlexboxItemDecoration(android.content.Context context) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(u);
        this.n = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setOrientation(3);
    }

    public final void a(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView) {
        int top;
        int intrinsicHeight;
        int left;
        int right;
        int i;
        int i2;
        int i3;
        if (d()) {
            com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager = (com.google.android.flexbox.FlexboxLayoutManager) recyclerView.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left2 = recyclerView.getLeft() - recyclerView.getPaddingLeft();
            int right2 = recyclerView.getRight() + recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                android.view.View childAt = recyclerView.getChildAt(i4);
                androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams = (androidx.recyclerview.widget.RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    top = this.n.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top = childAt.getTop() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    intrinsicHeight = top - this.n.getIntrinsicHeight();
                }
                if (!flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    left = childAt.getLeft() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    right = childAt.getRight();
                    i = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else if (flexboxLayoutManager.z()) {
                    i2 = java.lang.Math.min(childAt.getRight() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin + this.n.getIntrinsicWidth(), right2);
                    i3 = childAt.getLeft() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    this.n.setBounds(i3, intrinsicHeight, i2, top);
                    this.n.draw(canvas);
                } else {
                    left = java.lang.Math.max((childAt.getLeft() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.n.getIntrinsicWidth(), left2);
                    right = childAt.getRight();
                    i = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                int i5 = left;
                i2 = right + i;
                i3 = i5;
                this.n.setBounds(i3, intrinsicHeight, i2, top);
                this.n.draw(canvas);
            }
        }
    }

    public final void b(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView) {
        int left;
        int intrinsicWidth;
        int max;
        int bottom;
        int i;
        int i2;
        if (e()) {
            com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager = (com.google.android.flexbox.FlexboxLayoutManager) recyclerView.getLayoutManager();
            int top = recyclerView.getTop() - recyclerView.getPaddingTop();
            int bottom2 = recyclerView.getBottom() + recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i3 = 0; i3 < childCount; i3++) {
                android.view.View childAt = recyclerView.getChildAt(i3);
                androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams = (androidx.recyclerview.widget.RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexboxLayoutManager.z()) {
                    intrinsicWidth = childAt.getRight() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    left = this.n.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    intrinsicWidth = left - this.n.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    max = childAt.getTop() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    bottom = childAt.getBottom();
                    i = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                } else if (flexDirection == 3) {
                    int min = java.lang.Math.min(childAt.getBottom() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + this.n.getIntrinsicHeight(), bottom2);
                    max = childAt.getTop() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    i2 = min;
                    this.n.setBounds(intrinsicWidth, max, left, i2);
                    this.n.draw(canvas);
                } else {
                    max = java.lang.Math.max((childAt.getTop() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.n.getIntrinsicHeight(), top);
                    bottom = childAt.getBottom();
                    i = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                }
                i2 = bottom + i;
                this.n.setBounds(intrinsicWidth, max, left, i2);
                this.n.draw(canvas);
            }
        }
    }

    public final boolean c(int i, java.util.List<com.google.android.flexbox.FlexLine> list, com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager) {
        int w = flexboxLayoutManager.w(i);
        if ((w == -1 || w >= flexboxLayoutManager.getFlexLinesInternal().size() || flexboxLayoutManager.getFlexLinesInternal().get(w).o != i) && i != 0) {
            return list.size() != 0 && list.get(list.size() - 1).p == i - 1;
        }
        return true;
    }

    public final boolean d() {
        return (this.t & 1) > 0;
    }

    public final boolean e() {
        return (this.t & 2) > 0;
    }

    public final void f(android.graphics.Rect rect, int i, com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager, java.util.List<com.google.android.flexbox.FlexLine> list) {
        if (list.size() == 0 || flexboxLayoutManager.w(i) == 0) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (d()) {
                rect.top = this.n.getIntrinsicHeight();
                rect.bottom = 0;
                return;
            } else {
                rect.top = 0;
                rect.bottom = 0;
                return;
            }
        }
        if (e()) {
            if (flexboxLayoutManager.z()) {
                rect.right = this.n.getIntrinsicWidth();
                rect.left = 0;
            } else {
                rect.left = this.n.getIntrinsicWidth();
                rect.right = 0;
            }
        }
    }

    public final void g(android.graphics.Rect rect, int i, com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager, java.util.List<com.google.android.flexbox.FlexLine> list, int i2) {
        if (c(i, list, flexboxLayoutManager)) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (!e()) {
                rect.left = 0;
                rect.right = 0;
                return;
            } else if (flexboxLayoutManager.z()) {
                rect.right = this.n.getIntrinsicWidth();
                rect.left = 0;
                return;
            } else {
                rect.left = this.n.getIntrinsicWidth();
                rect.right = 0;
                return;
            }
        }
        if (!d()) {
            rect.top = 0;
            rect.bottom = 0;
        } else if (i2 == 3) {
            rect.bottom = this.n.getIntrinsicHeight();
            rect.top = 0;
        } else {
            rect.top = this.n.getIntrinsicHeight();
            rect.bottom = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@androidx.annotation.NonNull android.graphics.Rect rect, @androidx.annotation.NonNull android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!d() && !e()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager = (com.google.android.flexbox.FlexboxLayoutManager) recyclerView.getLayoutManager();
        java.util.List<com.google.android.flexbox.FlexLine> flexLines = flexboxLayoutManager.getFlexLines();
        g(rect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
        f(rect, childAdapterPosition, flexboxLayoutManager, flexLines);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state) {
        a(canvas, recyclerView);
        b(canvas, recyclerView);
    }

    public void setDrawable(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            throw new java.lang.IllegalArgumentException("Drawable cannot be null.");
        }
        this.n = drawable;
    }

    public void setOrientation(int i) {
        this.t = i;
    }
}
