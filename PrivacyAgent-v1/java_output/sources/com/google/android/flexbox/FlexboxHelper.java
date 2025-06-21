package com.google.android.flexbox;

/* loaded from: classes22.dex */
class FlexboxHelper {
    public final com.google.android.flexbox.FlexContainer a;
    public boolean[] b;

    @androidx.annotation.Nullable
    public int[] c;

    @androidx.annotation.Nullable
    public long[] d;

    @androidx.annotation.Nullable
    public long[] e;

    public static class FlexLinesResult {
        public java.util.List<com.google.android.flexbox.FlexLine> a;
        public int b;

        public void a() {
            this.a = null;
            this.b = 0;
        }
    }

    public static class Order implements java.lang.Comparable<com.google.android.flexbox.FlexboxHelper.Order> {
        public int n;
        public int t;

        public Order() {
        }

        public /* synthetic */ Order(com.google.android.flexbox.FlexboxHelper.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@androidx.annotation.NonNull com.google.android.flexbox.FlexboxHelper.Order order) {
            int i = this.t;
            int i2 = order.t;
            return i != i2 ? i - i2 : this.n - order.n;
        }

        @androidx.annotation.NonNull
        public java.lang.String toString() {
            return "Order{order=" + this.t + ", index=" + this.n + '}';
        }
    }

    public FlexboxHelper(com.google.android.flexbox.FlexContainer flexContainer) {
        this.a = flexContainer;
    }

    public final int A(int i, com.google.android.flexbox.FlexItem flexItem, int i2) {
        com.google.android.flexbox.FlexContainer flexContainer = this.a;
        int childWidthMeasureSpec = flexContainer.getChildWidthMeasureSpec(i, flexContainer.getPaddingLeft() + this.a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
        int size = android.view.View.MeasureSpec.getSize(childWidthMeasureSpec);
        return size > flexItem.getMaxWidth() ? android.view.View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), android.view.View.MeasureSpec.getMode(childWidthMeasureSpec)) : size < flexItem.getMinWidth() ? android.view.View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), android.view.View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    public final int B(com.google.android.flexbox.FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginBottom() : flexItem.getMarginRight();
    }

    public final int C(com.google.android.flexbox.FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.getMarginBottom();
    }

    public final int D(com.google.android.flexbox.FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginTop() : flexItem.getMarginLeft();
    }

    public final int E(com.google.android.flexbox.FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginLeft() : flexItem.getMarginTop();
    }

    public final int F(com.google.android.flexbox.FlexItem flexItem, boolean z) {
        return z ? flexItem.getHeight() : flexItem.getWidth();
    }

    public final int G(com.google.android.flexbox.FlexItem flexItem, boolean z) {
        return z ? flexItem.getWidth() : flexItem.getHeight();
    }

    public final int H(boolean z) {
        return z ? this.a.getPaddingBottom() : this.a.getPaddingEnd();
    }

    public final int I(boolean z) {
        return z ? this.a.getPaddingEnd() : this.a.getPaddingBottom();
    }

    public final int J(boolean z) {
        return z ? this.a.getPaddingTop() : this.a.getPaddingStart();
    }

    public final int K(boolean z) {
        return z ? this.a.getPaddingStart() : this.a.getPaddingTop();
    }

    public final int L(android.view.View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    public final int M(android.view.View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public final boolean N(int i, int i2, com.google.android.flexbox.FlexLine flexLine) {
        return i == i2 - 1 && flexLine.getItemCountNotGone() != 0;
    }

    public boolean O(android.util.SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            android.view.View flexItemAt = this.a.getFlexItemAt(i);
            if (flexItemAt != null && ((com.google.android.flexbox.FlexItem) flexItemAt.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    public final boolean P(android.view.View view, int i, int i2, int i3, int i4, com.google.android.flexbox.FlexItem flexItem, int i5, int i6, int i7) {
        if (this.a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.a.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.a.getDecorationLengthMainAxis(view, i5, i6);
        if (decorationLengthMainAxis > 0) {
            i4 += decorationLengthMainAxis;
        }
        return i2 < i3 + i4;
    }

    public void Q(android.view.View view, com.google.android.flexbox.FlexLine flexLine, int i, int i2, int i3, int i4) {
        com.google.android.flexbox.FlexItem flexItem = (com.google.android.flexbox.FlexItem) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i5 = flexLine.g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.a.getFlexWrap() == 2) {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.getMarginTop(), i3, (i4 - i5) + view.getMeasuredHeight() + flexItem.getMarginTop());
                    return;
                } else {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i3, i6 - flexItem.getMarginBottom());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.a.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.a.getFlexWrap() != 2) {
                    int max = java.lang.Math.max(flexLine.l - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(i, i2 + max, i3, i4 + max);
                    return;
                } else {
                    int max2 = java.lang.Math.max((flexLine.l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                    view.layout(i, i2 - max2, i3, i4 - max2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.a.getFlexWrap() != 2) {
            view.layout(i, i2 + flexItem.getMarginTop(), i3, i4 + flexItem.getMarginTop());
        } else {
            view.layout(i, i2 - flexItem.getMarginBottom(), i3, i4 - flexItem.getMarginBottom());
        }
    }

    public void R(android.view.View view, com.google.android.flexbox.FlexLine flexLine, boolean z, int i, int i2, int i3, int i4) {
        com.google.android.flexbox.FlexItem flexItem = (com.google.android.flexbox.FlexItem) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i5 = flexLine.g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (z) {
                    view.layout((i - i5) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i2, (i3 - i5) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i4);
                    return;
                } else {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i2, ((i3 + i5) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + androidx.core.view.MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - androidx.core.view.MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (z) {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                } else {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z) {
            view.layout(i - flexItem.getMarginRight(), i2, i3 - flexItem.getMarginRight(), i4);
        } else {
            view.layout(i + flexItem.getMarginLeft(), i2, i3 + flexItem.getMarginLeft(), i4);
        }
    }

    @androidx.annotation.VisibleForTesting
    public long S(int i, int i2) {
        return (i & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) | (i2 << 32);
    }

    public final void T(int i, int i2, com.google.android.flexbox.FlexLine flexLine, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        int i8 = flexLine.e;
        float f = flexLine.k;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 > i8) {
            return;
        }
        float f3 = (i8 - i3) / f;
        flexLine.e = i4 + flexLine.f;
        if (!z) {
            flexLine.g = Integer.MIN_VALUE;
        }
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        float f4 = 0.0f;
        while (i9 < flexLine.h) {
            int i11 = flexLine.o + i9;
            android.view.View reorderedFlexItemAt = this.a.getReorderedFlexItemAt(i11);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i5 = i8;
                i6 = i9;
            } else {
                com.google.android.flexbox.FlexItem flexItem = (com.google.android.flexbox.FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i5 = i8;
                    int i12 = i9;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i11]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.e;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i11]);
                    }
                    if (this.b[i11] || flexItem.getFlexShrink() <= 0.0f) {
                        i6 = i12;
                    } else {
                        float flexShrink = measuredWidth - (flexItem.getFlexShrink() * f3);
                        i6 = i12;
                        if (i6 == flexLine.h - 1) {
                            flexShrink += f4;
                            f4 = 0.0f;
                        }
                        int round = java.lang.Math.round(flexShrink);
                        if (round < flexItem.getMinWidth()) {
                            round = flexItem.getMinWidth();
                            this.b[i11] = true;
                            flexLine.k -= flexItem.getFlexShrink();
                            z2 = true;
                        } else {
                            f4 += flexShrink - round;
                            double d = f4;
                            if (d > 1.0d) {
                                round++;
                                f4 -= 1.0f;
                            } else if (d < -1.0d) {
                                round--;
                                f4 += 1.0f;
                            }
                        }
                        int z3 = z(i2, flexItem, flexLine.m);
                        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        reorderedFlexItemAt.measure(makeMeasureSpec, z3);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i11, makeMeasureSpec, z3, reorderedFlexItemAt);
                        this.a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = java.lang.Math.max(i10, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    i7 = max;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i11]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i11]);
                    }
                    if (this.b[i11] || flexItem.getFlexShrink() <= f2) {
                        i5 = i8;
                        i6 = i9;
                    } else {
                        float flexShrink2 = measuredHeight3 - (flexItem.getFlexShrink() * f3);
                        if (i9 == flexLine.h - 1) {
                            flexShrink2 += f4;
                            f4 = 0.0f;
                        }
                        int round2 = java.lang.Math.round(flexShrink2);
                        if (round2 < flexItem.getMinHeight()) {
                            round2 = flexItem.getMinHeight();
                            this.b[i11] = true;
                            flexLine.k -= flexItem.getFlexShrink();
                            i5 = i8;
                            i6 = i9;
                            z2 = true;
                        } else {
                            f4 += flexShrink2 - round2;
                            i5 = i8;
                            i6 = i9;
                            double d2 = f4;
                            if (d2 > 1.0d) {
                                round2++;
                                f4 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                round2--;
                                f4 += 1.0f;
                            }
                        }
                        int A = A(i, flexItem, flexLine.m);
                        int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        reorderedFlexItemAt.measure(A, makeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i11, A, makeMeasureSpec2, reorderedFlexItemAt);
                        this.a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    i7 = java.lang.Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                }
                flexLine.g = java.lang.Math.max(flexLine.g, i7);
                i10 = i7;
            }
            i9 = i6 + 1;
            i8 = i5;
            f2 = 0.0f;
        }
        int i13 = i8;
        if (!z2 || i13 == flexLine.e) {
            return;
        }
        T(i, i2, flexLine, i3, i4, true);
    }

    public final int[] U(int i, java.util.List<com.google.android.flexbox.FlexboxHelper.Order> list, android.util.SparseIntArray sparseIntArray) {
        java.util.Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (com.google.android.flexbox.FlexboxHelper.Order order : list) {
            int i3 = order.n;
            iArr[i2] = i3;
            sparseIntArray.append(i3, order.t);
            i2++;
        }
        return iArr;
    }

    public final void V(android.view.View view, int i, int i2) {
        com.google.android.flexbox.FlexItem flexItem = (com.google.android.flexbox.FlexItem) view.getLayoutParams();
        int min = java.lang.Math.min(java.lang.Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.a.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.e;
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(jArr != null ? x(jArr[i2]) : view.getMeasuredHeight(), 1073741824);
        int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        Z(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.a.updateViewCache(i2, view);
    }

    public final void W(android.view.View view, int i, int i2) {
        com.google.android.flexbox.FlexItem flexItem = (com.google.android.flexbox.FlexItem) view.getLayoutParams();
        int min = java.lang.Math.min(java.lang.Math.max(((i - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.a.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.e;
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(jArr != null ? y(jArr[i2]) : view.getMeasuredWidth(), 1073741824);
        int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        Z(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.a.updateViewCache(i2, view);
    }

    public void X() {
        Y(0);
    }

    public void Y(int i) {
        android.view.View reorderedFlexItemAt;
        if (i >= this.a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.a.getFlexDirection();
        if (this.a.getAlignItems() != 4) {
            for (com.google.android.flexbox.FlexLine flexLine : this.a.getFlexLinesInternal()) {
                for (java.lang.Integer num : flexLine.n) {
                    android.view.View reorderedFlexItemAt2 = this.a.getReorderedFlexItemAt(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        W(reorderedFlexItemAt2, flexLine.g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new java.lang.IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                        V(reorderedFlexItemAt2, flexLine.g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.c;
        java.util.List<com.google.android.flexbox.FlexLine> flexLinesInternal = this.a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
            com.google.android.flexbox.FlexLine flexLine2 = flexLinesInternal.get(i2);
            int i3 = flexLine2.h;
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = flexLine2.o + i4;
                if (i4 < this.a.getFlexItemCount() && (reorderedFlexItemAt = this.a.getReorderedFlexItemAt(i5)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                    com.google.android.flexbox.FlexItem flexItem = (com.google.android.flexbox.FlexItem) reorderedFlexItemAt.getLayoutParams();
                    if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            W(reorderedFlexItemAt, flexLine2.g, i5);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new java.lang.IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                            V(reorderedFlexItemAt, flexLine2.g, i5);
                        }
                    }
                }
            }
        }
    }

    public final void Z(int i, int i2, int i3, android.view.View view) {
        long[] jArr = this.d;
        if (jArr != null) {
            jArr[i] = S(i2, i3);
        }
        long[] jArr2 = this.e;
        if (jArr2 != null) {
            jArr2[i] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public final void a(java.util.List<com.google.android.flexbox.FlexLine> list, com.google.android.flexbox.FlexLine flexLine, int i, int i2) {
        flexLine.m = i2;
        this.a.onNewFlexLineAdded(flexLine);
        flexLine.p = i;
        list.add(flexLine);
    }

    public void b(com.google.android.flexbox.FlexboxHelper.FlexLinesResult flexLinesResult, int i, int i2, int i3, int i4, int i5, @androidx.annotation.Nullable java.util.List<com.google.android.flexbox.FlexLine> list) {
        int i6;
        com.google.android.flexbox.FlexboxHelper.FlexLinesResult flexLinesResult2;
        int i7;
        int i8;
        int i9;
        java.util.List<com.google.android.flexbox.FlexLine> list2;
        int i10;
        android.view.View view;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        com.google.android.flexbox.FlexLine flexLine;
        int i18;
        int i19 = i;
        int i20 = i2;
        int i21 = i5;
        boolean isMainAxisDirectionHorizontal = this.a.isMainAxisDirectionHorizontal();
        int mode = android.view.View.MeasureSpec.getMode(i);
        int size = android.view.View.MeasureSpec.getSize(i);
        java.util.List<com.google.android.flexbox.FlexLine> arrayList = list == null ? new java.util.ArrayList() : list;
        flexLinesResult.a = arrayList;
        boolean z = i21 == -1;
        int K = K(isMainAxisDirectionHorizontal);
        int I = I(isMainAxisDirectionHorizontal);
        int J = J(isMainAxisDirectionHorizontal);
        int H = H(isMainAxisDirectionHorizontal);
        com.google.android.flexbox.FlexLine flexLine2 = new com.google.android.flexbox.FlexLine();
        int i22 = i4;
        flexLine2.o = i22;
        int i23 = I + K;
        flexLine2.e = i23;
        int flexItemCount = this.a.getFlexItemCount();
        boolean z2 = z;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = Integer.MIN_VALUE;
        while (true) {
            if (i22 >= flexItemCount) {
                i6 = i25;
                flexLinesResult2 = flexLinesResult;
                break;
            }
            android.view.View reorderedFlexItemAt = this.a.getReorderedFlexItemAt(i22);
            if (reorderedFlexItemAt != null) {
                if (reorderedFlexItemAt.getVisibility() != 8) {
                    if (reorderedFlexItemAt instanceof android.widget.CompoundButton) {
                        v((android.widget.CompoundButton) reorderedFlexItemAt);
                    }
                    com.google.android.flexbox.FlexItem flexItem = (com.google.android.flexbox.FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int i28 = flexItemCount;
                    if (flexItem.getAlignSelf() == 4) {
                        flexLine2.n.add(java.lang.Integer.valueOf(i22));
                    }
                    int G = G(flexItem, isMainAxisDirectionHorizontal);
                    if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                        G = java.lang.Math.round(size * flexItem.getFlexBasisPercent());
                    }
                    if (isMainAxisDirectionHorizontal) {
                        int childWidthMeasureSpec = this.a.getChildWidthMeasureSpec(i19, i23 + E(flexItem, true) + C(flexItem, true), G);
                        i7 = size;
                        i8 = mode;
                        int childHeightMeasureSpec = this.a.getChildHeightMeasureSpec(i20, J + H + D(flexItem, true) + B(flexItem, true) + i24, F(flexItem, true));
                        reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        Z(i22, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                        i9 = childWidthMeasureSpec;
                    } else {
                        i7 = size;
                        i8 = mode;
                        int childWidthMeasureSpec2 = this.a.getChildWidthMeasureSpec(i20, J + H + D(flexItem, false) + B(flexItem, false) + i24, F(flexItem, false));
                        int childHeightMeasureSpec2 = this.a.getChildHeightMeasureSpec(i19, E(flexItem, false) + i23 + C(flexItem, false), G);
                        reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                        Z(i22, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                        i9 = childHeightMeasureSpec2;
                    }
                    this.a.updateViewCache(i22, reorderedFlexItemAt);
                    i(reorderedFlexItemAt, i22);
                    i25 = android.view.View.combineMeasuredStates(i25, reorderedFlexItemAt.getMeasuredState());
                    int i29 = i24;
                    int i30 = i23;
                    com.google.android.flexbox.FlexLine flexLine3 = flexLine2;
                    int i31 = i22;
                    list2 = arrayList;
                    int i32 = i9;
                    if (P(reorderedFlexItemAt, i8, i7, flexLine2.e, C(flexItem, isMainAxisDirectionHorizontal) + M(reorderedFlexItemAt, isMainAxisDirectionHorizontal) + E(flexItem, isMainAxisDirectionHorizontal), flexItem, i31, i26, arrayList.size())) {
                        if (flexLine3.getItemCountNotGone() > 0) {
                            if (i31 > 0) {
                                i18 = i31 - 1;
                                flexLine = flexLine3;
                            } else {
                                flexLine = flexLine3;
                                i18 = 0;
                            }
                            a(list2, flexLine, i18, i29);
                            i24 = flexLine.g + i29;
                        } else {
                            i24 = i29;
                        }
                        if (!isMainAxisDirectionHorizontal) {
                            i10 = i2;
                            view = reorderedFlexItemAt;
                            i22 = i31;
                            if (flexItem.getWidth() == -1) {
                                com.google.android.flexbox.FlexContainer flexContainer = this.a;
                                view.measure(flexContainer.getChildWidthMeasureSpec(i10, flexContainer.getPaddingLeft() + this.a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i24, flexItem.getWidth()), i32);
                                i(view, i22);
                            }
                        } else if (flexItem.getHeight() == -1) {
                            com.google.android.flexbox.FlexContainer flexContainer2 = this.a;
                            i10 = i2;
                            i22 = i31;
                            view = reorderedFlexItemAt;
                            view.measure(i32, flexContainer2.getChildHeightMeasureSpec(i10, flexContainer2.getPaddingTop() + this.a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i24, flexItem.getHeight()));
                            i(view, i22);
                        } else {
                            i10 = i2;
                            view = reorderedFlexItemAt;
                            i22 = i31;
                        }
                        flexLine2 = new com.google.android.flexbox.FlexLine();
                        i12 = 1;
                        flexLine2.h = 1;
                        i11 = i30;
                        flexLine2.e = i11;
                        flexLine2.o = i22;
                        i13 = 0;
                        i14 = Integer.MIN_VALUE;
                    } else {
                        i10 = i2;
                        view = reorderedFlexItemAt;
                        i22 = i31;
                        flexLine2 = flexLine3;
                        i11 = i30;
                        i12 = 1;
                        flexLine2.h++;
                        i13 = i26 + 1;
                        i24 = i29;
                        i14 = i27;
                    }
                    flexLine2.q |= flexItem.getFlexGrow() != 0.0f;
                    flexLine2.r |= flexItem.getFlexShrink() != 0.0f;
                    int[] iArr = this.c;
                    if (iArr != null) {
                        iArr[i22] = list2.size();
                    }
                    flexLine2.e += M(view, isMainAxisDirectionHorizontal) + E(flexItem, isMainAxisDirectionHorizontal) + C(flexItem, isMainAxisDirectionHorizontal);
                    flexLine2.j += flexItem.getFlexGrow();
                    flexLine2.k += flexItem.getFlexShrink();
                    this.a.onNewFlexItemAdded(view, i22, i13, flexLine2);
                    int max = java.lang.Math.max(i14, L(view, isMainAxisDirectionHorizontal) + D(flexItem, isMainAxisDirectionHorizontal) + B(flexItem, isMainAxisDirectionHorizontal) + this.a.getDecorationLengthCrossAxis(view));
                    flexLine2.g = java.lang.Math.max(flexLine2.g, max);
                    if (isMainAxisDirectionHorizontal) {
                        if (this.a.getFlexWrap() != 2) {
                            flexLine2.l = java.lang.Math.max(flexLine2.l, view.getBaseline() + flexItem.getMarginTop());
                        } else {
                            flexLine2.l = java.lang.Math.max(flexLine2.l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    i15 = i28;
                    if (N(i22, i15, flexLine2)) {
                        a(list2, flexLine2, i22, i24);
                        i24 += flexLine2.g;
                    }
                    i16 = i5;
                    if (i16 == -1 || list2.size() <= 0 || list2.get(list2.size() - i12).p < i16 || i22 < i16 || z2) {
                        i17 = i3;
                    } else {
                        i24 = -flexLine2.getCrossSize();
                        i17 = i3;
                        z2 = true;
                    }
                    if (i24 > i17 && z2) {
                        flexLinesResult2 = flexLinesResult;
                        i6 = i25;
                        break;
                    }
                    i26 = i13;
                    i27 = max;
                    i22++;
                    i19 = i;
                    flexItemCount = i15;
                    i20 = i10;
                    i23 = i11;
                    arrayList = list2;
                    size = i7;
                    i21 = i16;
                    mode = i8;
                } else {
                    flexLine2.i++;
                    flexLine2.h++;
                    if (N(i22, flexItemCount, flexLine2)) {
                        a(arrayList, flexLine2, i22, i24);
                    }
                }
            } else if (N(i22, flexItemCount, flexLine2)) {
                a(arrayList, flexLine2, i22, i24);
            }
            i7 = size;
            i8 = mode;
            i10 = i20;
            i16 = i21;
            list2 = arrayList;
            i11 = i23;
            i15 = flexItemCount;
            i22++;
            i19 = i;
            flexItemCount = i15;
            i20 = i10;
            i23 = i11;
            arrayList = list2;
            size = i7;
            i21 = i16;
            mode = i8;
        }
        flexLinesResult2.b = i6;
    }

    public void c(com.google.android.flexbox.FlexboxHelper.FlexLinesResult flexLinesResult, int i, int i2) {
        b(flexLinesResult, i, i2, Integer.MAX_VALUE, 0, -1, null);
    }

    public void d(com.google.android.flexbox.FlexboxHelper.FlexLinesResult flexLinesResult, int i, int i2, int i3, int i4, @androidx.annotation.Nullable java.util.List<com.google.android.flexbox.FlexLine> list) {
        b(flexLinesResult, i, i2, i3, i4, -1, list);
    }

    public void e(com.google.android.flexbox.FlexboxHelper.FlexLinesResult flexLinesResult, int i, int i2, int i3, int i4, java.util.List<com.google.android.flexbox.FlexLine> list) {
        b(flexLinesResult, i, i2, i3, 0, i4, list);
    }

    public void f(com.google.android.flexbox.FlexboxHelper.FlexLinesResult flexLinesResult, int i, int i2) {
        b(flexLinesResult, i2, i, Integer.MAX_VALUE, 0, -1, null);
    }

    public void g(com.google.android.flexbox.FlexboxHelper.FlexLinesResult flexLinesResult, int i, int i2, int i3, int i4, @androidx.annotation.Nullable java.util.List<com.google.android.flexbox.FlexLine> list) {
        b(flexLinesResult, i2, i, i3, i4, -1, list);
    }

    public void h(com.google.android.flexbox.FlexboxHelper.FlexLinesResult flexLinesResult, int i, int i2, int i3, int i4, java.util.List<com.google.android.flexbox.FlexLine> list) {
        b(flexLinesResult, i2, i, i3, 0, i4, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(android.view.View view, int i) {
        boolean z;
        com.google.android.flexbox.FlexItem flexItem = (com.google.android.flexbox.FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < flexItem.getMinWidth()) {
            measuredWidth = flexItem.getMinWidth();
        } else {
            if (measuredWidth <= flexItem.getMaxWidth()) {
                z = false;
                if (measuredHeight >= flexItem.getMinHeight()) {
                    measuredHeight = flexItem.getMinHeight();
                } else if (measuredHeight > flexItem.getMaxHeight()) {
                    measuredHeight = flexItem.getMaxHeight();
                } else {
                    z2 = z;
                }
                if (z2) {
                    return;
                }
                int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                Z(i, makeMeasureSpec, makeMeasureSpec2, view);
                this.a.updateViewCache(i, view);
                return;
            }
            measuredWidth = flexItem.getMaxWidth();
        }
        z = true;
        if (measuredHeight >= flexItem.getMinHeight()) {
        }
        if (z2) {
        }
    }

    public void j(java.util.List<com.google.android.flexbox.FlexLine> list, int i) {
        int i2 = this.c[i];
        if (i2 == -1) {
            i2 = 0;
        }
        if (list.size() > i2) {
            list.subList(i2, list.size()).clear();
        }
        int[] iArr = this.c;
        int length = iArr.length - 1;
        if (i > length) {
            java.util.Arrays.fill(iArr, -1);
        } else {
            java.util.Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.d;
        int length2 = jArr.length - 1;
        if (i > length2) {
            java.util.Arrays.fill(jArr, 0L);
        } else {
            java.util.Arrays.fill(jArr, i, length2, 0L);
        }
    }

    public final java.util.List<com.google.android.flexbox.FlexLine> k(java.util.List<com.google.android.flexbox.FlexLine> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.google.android.flexbox.FlexLine flexLine = new com.google.android.flexbox.FlexLine();
        flexLine.g = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(flexLine);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @androidx.annotation.NonNull
    public final java.util.List<com.google.android.flexbox.FlexboxHelper.Order> l(int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.google.android.flexbox.FlexItem flexItem = (com.google.android.flexbox.FlexItem) this.a.getFlexItemAt(i2).getLayoutParams();
            com.google.android.flexbox.FlexboxHelper.Order order = new com.google.android.flexbox.FlexboxHelper.Order(null);
            order.t = flexItem.getOrder();
            order.n = i2;
            arrayList.add(order);
        }
        return arrayList;
    }

    public int[] m(android.util.SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] n(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams, android.util.SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        java.util.List<com.google.android.flexbox.FlexboxHelper.Order> l = l(flexItemCount);
        com.google.android.flexbox.FlexboxHelper.Order order = new com.google.android.flexbox.FlexboxHelper.Order(null);
        if (view == null || !(layoutParams instanceof com.google.android.flexbox.FlexItem)) {
            order.t = 1;
        } else {
            order.t = ((com.google.android.flexbox.FlexItem) layoutParams).getOrder();
        }
        if (i == -1 || i == flexItemCount) {
            order.n = flexItemCount;
        } else if (i < this.a.getFlexItemCount()) {
            order.n = i;
            while (i < flexItemCount) {
                l.get(i).n++;
                i++;
            }
        } else {
            order.n = flexItemCount;
        }
        l.add(order);
        return U(flexItemCount + 1, l, sparseIntArray);
    }

    public void o(int i, int i2, int i3) {
        int i4;
        int i5;
        int flexDirection = this.a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = android.view.View.MeasureSpec.getMode(i2);
            int size = android.view.View.MeasureSpec.getSize(i2);
            i4 = mode;
            i5 = size;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new java.lang.IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            i4 = android.view.View.MeasureSpec.getMode(i);
            i5 = android.view.View.MeasureSpec.getSize(i);
        }
        java.util.List<com.google.android.flexbox.FlexLine> flexLinesInternal = this.a.getFlexLinesInternal();
        if (i4 == 1073741824) {
            int sumOfCrossSize = this.a.getSumOfCrossSize() + i3;
            int i6 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).g = i5 - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.a.getAlignContent();
                if (alignContent == 1) {
                    int i7 = i5 - sumOfCrossSize;
                    com.google.android.flexbox.FlexLine flexLine = new com.google.android.flexbox.FlexLine();
                    flexLine.g = i7;
                    flexLinesInternal.add(0, flexLine);
                    return;
                }
                if (alignContent == 2) {
                    this.a.setFlexLines(k(flexLinesInternal, i5, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= i5) {
                        return;
                    }
                    float size2 = (i5 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    int size3 = flexLinesInternal.size();
                    float f = 0.0f;
                    while (i6 < size3) {
                        arrayList.add(flexLinesInternal.get(i6));
                        if (i6 != flexLinesInternal.size() - 1) {
                            com.google.android.flexbox.FlexLine flexLine2 = new com.google.android.flexbox.FlexLine();
                            if (i6 == flexLinesInternal.size() - 2) {
                                flexLine2.g = java.lang.Math.round(f + size2);
                                f = 0.0f;
                            } else {
                                flexLine2.g = java.lang.Math.round(size2);
                            }
                            int i8 = flexLine2.g;
                            f += size2 - i8;
                            if (f > 1.0f) {
                                flexLine2.g = i8 + 1;
                                f -= 1.0f;
                            } else if (f < -1.0f) {
                                flexLine2.g = i8 - 1;
                                f += 1.0f;
                            }
                            arrayList.add(flexLine2);
                        }
                        i6++;
                    }
                    this.a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= i5) {
                        this.a.setFlexLines(k(flexLinesInternal, i5, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i5 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    com.google.android.flexbox.FlexLine flexLine3 = new com.google.android.flexbox.FlexLine();
                    flexLine3.g = size4;
                    for (com.google.android.flexbox.FlexLine flexLine4 : flexLinesInternal) {
                        arrayList2.add(flexLine3);
                        arrayList2.add(flexLine4);
                        arrayList2.add(flexLine3);
                    }
                    this.a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < i5) {
                    float size5 = (i5 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i6 < size6) {
                        com.google.android.flexbox.FlexLine flexLine5 = flexLinesInternal.get(i6);
                        float f3 = flexLine5.g + size5;
                        if (i6 == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int round = java.lang.Math.round(f3);
                        f2 += f3 - round;
                        if (f2 > 1.0f) {
                            round++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            round--;
                            f2 += 1.0f;
                        }
                        flexLine5.g = round;
                        i6++;
                    }
                }
            }
        }
    }

    public void p(int i, int i2) {
        q(i, i2, 0);
    }

    public void q(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.a.getFlexItemCount());
        if (i3 >= this.a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.a.getFlexDirection();
        int flexDirection2 = this.a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = android.view.View.MeasureSpec.getMode(i);
            size = android.view.View.MeasureSpec.getSize(i);
            int largestMainSize = this.a.getLargestMainSize();
            if (mode != 1073741824) {
                size = java.lang.Math.min(largestMainSize, size);
            }
            paddingLeft = this.a.getPaddingLeft();
            paddingRight = this.a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new java.lang.IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = android.view.View.MeasureSpec.getMode(i2);
            size = android.view.View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.a.getLargestMainSize();
            }
            paddingLeft = this.a.getPaddingTop();
            paddingRight = this.a.getPaddingBottom();
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.c;
        java.util.List<com.google.android.flexbox.FlexLine> flexLinesInternal = this.a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            com.google.android.flexbox.FlexLine flexLine = flexLinesInternal.get(i5);
            int i6 = flexLine.e;
            if (i6 < size && flexLine.q) {
                w(i, i2, flexLine, size, i4, false);
            } else if (i6 > size && flexLine.r) {
                T(i, i2, flexLine, size, i4, false);
            }
        }
    }

    public final void r(int i) {
        boolean[] zArr = this.b;
        if (zArr == null) {
            this.b = new boolean[java.lang.Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.b = new boolean[java.lang.Math.max(zArr.length * 2, i)];
        } else {
            java.util.Arrays.fill(zArr, false);
        }
    }

    public void s(int i) {
        int[] iArr = this.c;
        if (iArr == null) {
            this.c = new int[java.lang.Math.max(i, 10)];
        } else if (iArr.length < i) {
            this.c = java.util.Arrays.copyOf(this.c, java.lang.Math.max(iArr.length * 2, i));
        }
    }

    public void t(int i) {
        long[] jArr = this.d;
        if (jArr == null) {
            this.d = new long[java.lang.Math.max(i, 10)];
        } else if (jArr.length < i) {
            this.d = java.util.Arrays.copyOf(this.d, java.lang.Math.max(jArr.length * 2, i));
        }
    }

    public void u(int i) {
        long[] jArr = this.e;
        if (jArr == null) {
            this.e = new long[java.lang.Math.max(i, 10)];
        } else if (jArr.length < i) {
            this.e = java.util.Arrays.copyOf(this.e, java.lang.Math.max(jArr.length * 2, i));
        }
    }

    public final void v(android.widget.CompoundButton compoundButton) {
        com.google.android.flexbox.FlexItem flexItem = (com.google.android.flexbox.FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        android.graphics.drawable.Drawable buttonDrawable = androidx.core.widget.CompoundButtonCompat.getButtonDrawable(compoundButton);
        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
        int minimumHeight = buttonDrawable != null ? buttonDrawable.getMinimumHeight() : 0;
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = minimumHeight;
        }
        flexItem.setMinHeight(minHeight);
    }

    public final void w(int i, int i2, com.google.android.flexbox.FlexLine flexLine, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        double d;
        int i8;
        double d2;
        float f = flexLine.j;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 < (i5 = flexLine.e)) {
            return;
        }
        float f3 = (i3 - i5) / f;
        flexLine.e = i4 + flexLine.f;
        if (!z) {
            flexLine.g = Integer.MIN_VALUE;
        }
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        float f4 = 0.0f;
        while (i9 < flexLine.h) {
            int i11 = flexLine.o + i9;
            android.view.View reorderedFlexItemAt = this.a.getReorderedFlexItemAt(i11);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i6 = i5;
            } else {
                com.google.android.flexbox.FlexItem flexItem = (com.google.android.flexbox.FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i12 = i5;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i11]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.e;
                    i6 = i12;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i11]);
                    }
                    if (!this.b[i11] && flexItem.getFlexGrow() > 0.0f) {
                        float flexGrow = measuredWidth + (flexItem.getFlexGrow() * f3);
                        if (i9 == flexLine.h - 1) {
                            flexGrow += f4;
                            f4 = 0.0f;
                        }
                        int round = java.lang.Math.round(flexGrow);
                        if (round > flexItem.getMaxWidth()) {
                            round = flexItem.getMaxWidth();
                            this.b[i11] = true;
                            flexLine.j -= flexItem.getFlexGrow();
                            z2 = true;
                        } else {
                            f4 += flexGrow - round;
                            double d3 = f4;
                            if (d3 > 1.0d) {
                                round++;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                round--;
                                d = d3 + 1.0d;
                            }
                            f4 = (float) d;
                        }
                        int z3 = z(i2, flexItem, flexLine.m);
                        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        reorderedFlexItemAt.measure(makeMeasureSpec, z3);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i11, makeMeasureSpec, z3, reorderedFlexItemAt);
                        this.a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = java.lang.Math.max(i10, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    i7 = max;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i11]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i11]);
                    }
                    if (this.b[i11] || flexItem.getFlexGrow() <= f2) {
                        i8 = i5;
                    } else {
                        float flexGrow2 = measuredHeight3 + (flexItem.getFlexGrow() * f3);
                        if (i9 == flexLine.h - 1) {
                            flexGrow2 += f4;
                            f4 = 0.0f;
                        }
                        int round2 = java.lang.Math.round(flexGrow2);
                        if (round2 > flexItem.getMaxHeight()) {
                            round2 = flexItem.getMaxHeight();
                            this.b[i11] = true;
                            flexLine.j -= flexItem.getFlexGrow();
                            i8 = i5;
                            z2 = true;
                        } else {
                            f4 += flexGrow2 - round2;
                            i8 = i5;
                            double d4 = f4;
                            if (d4 > 1.0d) {
                                round2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                round2--;
                                d2 = d4 + 1.0d;
                            }
                            f4 = (float) d2;
                        }
                        int A = A(i, flexItem, flexLine.m);
                        int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        reorderedFlexItemAt.measure(A, makeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i11, A, makeMeasureSpec2, reorderedFlexItemAt);
                        this.a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    i7 = java.lang.Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    i6 = i8;
                }
                flexLine.g = java.lang.Math.max(flexLine.g, i7);
                i10 = i7;
            }
            i9++;
            i5 = i6;
            f2 = 0.0f;
        }
        int i13 = i5;
        if (!z2 || i13 == flexLine.e) {
            return;
        }
        w(i, i2, flexLine, i3, i4, true);
    }

    public int x(long j) {
        return (int) (j >> 32);
    }

    public int y(long j) {
        return (int) j;
    }

    public final int z(int i, com.google.android.flexbox.FlexItem flexItem, int i2) {
        com.google.android.flexbox.FlexContainer flexContainer = this.a;
        int childHeightMeasureSpec = flexContainer.getChildHeightMeasureSpec(i, flexContainer.getPaddingTop() + this.a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i2, flexItem.getHeight());
        int size = android.view.View.MeasureSpec.getSize(childHeightMeasureSpec);
        return size > flexItem.getMaxHeight() ? android.view.View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), android.view.View.MeasureSpec.getMode(childHeightMeasureSpec)) : size < flexItem.getMinHeight() ? android.view.View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), android.view.View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }
}
