package com.google.android.flexbox;

/* loaded from: classes22.dex */
public class FlexLine {
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public float j;
    public float k;
    public int l;
    public int m;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public int a = Integer.MAX_VALUE;
    public int b = Integer.MAX_VALUE;
    public int c = Integer.MIN_VALUE;
    public int d = Integer.MIN_VALUE;
    public java.util.List<java.lang.Integer> n = new java.util.ArrayList();

    public void a(android.view.View view, int i, int i2, int i3, int i4) {
        com.google.android.flexbox.FlexItem flexItem = (com.google.android.flexbox.FlexItem) view.getLayoutParams();
        this.a = java.lang.Math.min(this.a, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.b = java.lang.Math.min(this.b, (view.getTop() - flexItem.getMarginTop()) - i2);
        this.c = java.lang.Math.max(this.c, view.getRight() + flexItem.getMarginRight() + i3);
        this.d = java.lang.Math.max(this.d, view.getBottom() + flexItem.getMarginBottom() + i4);
    }

    public int getCrossSize() {
        return this.g;
    }

    public int getFirstIndex() {
        return this.o;
    }

    public int getItemCount() {
        return this.h;
    }

    public int getItemCountNotGone() {
        return this.h - this.i;
    }

    public int getMainSize() {
        return this.e;
    }

    public float getTotalFlexGrow() {
        return this.j;
    }

    public float getTotalFlexShrink() {
        return this.k;
    }
}
