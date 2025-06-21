package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
public class ChainRun extends androidx.constraintlayout.solver.widgets.analyzer.WidgetRun {
    private int chainStyle;
    java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> widgets;

    public ChainRun(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.widgets = new java.util.ArrayList<>();
        this.orientation = i;
        build();
    }

    private void build() {
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = this.widget;
        androidx.constraintlayout.solver.widgets.ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        androidx.constraintlayout.solver.widgets.ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun next = it.next();
            int i = this.orientation;
            if (i == 0) {
                next.widget.horizontalChainRun = this;
            } else if (i == 1) {
                next.widget.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) this.widget.getParent()).isRtl()) && this.widgets.size() > 1) {
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    private androidx.constraintlayout.solver.widgets.ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun = this.widgets.get(i);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private androidx.constraintlayout.solver.widgets.ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size < 1) {
            return;
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.widgets.get(0).widget;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
        if (this.orientation == 0) {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            androidx.constraintlayout.solver.widgets.ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            androidx.constraintlayout.solver.widgets.ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            androidx.constraintlayout.solver.widgets.ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            androidx.constraintlayout.solver.widgets.ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            j = j + r4.start.margin + this.widgets.get(i).getWrapDimension() + r4.end.margin;
        }
        return j;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i = 0; i < size; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        java.lang.String sb2 = sb.toString();
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            java.lang.String str = sb2 + "<";
            sb2 = (str + it.next()) + "> ";
        }
        return sb2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x01a6, code lost:
    
        if (r1 != r7) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01d1, code lost:
    
        r9.dimension.resolve(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01ce, code lost:
    
        r13 = r13 + 1;
        r7 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01cc, code lost:
    
        if (r1 != r7) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x041a, code lost:
    
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00eb  */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        boolean z;
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        float f2;
        int i11;
        int max;
        int i12;
        int i13;
        if (this.start.resolved && this.end.resolved) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget parent = this.widget.getParent();
            boolean isRtl = (parent == null || !(parent instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer)) ? false : ((androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) parent).isRtl();
            int i14 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i15 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i15 >= size) {
                    i15 = -1;
                    break;
                } else if (this.widgets.get(i15).widget.getVisibility() != 8) {
                    break;
                } else {
                    i15++;
                }
            }
            int i16 = size - 1;
            int i17 = i16;
            while (true) {
                if (i17 < 0) {
                    break;
                }
                if (this.widgets.get(i17).widget.getVisibility() != 8) {
                    i = i17;
                    break;
                }
                i17--;
            }
            int i18 = 0;
            while (i18 < 2) {
                int i19 = 0;
                i4 = 0;
                i5 = 0;
                int i20 = 0;
                f = 0.0f;
                while (i19 < size) {
                    androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun = this.widgets.get(i19);
                    if (widgetRun.widget.getVisibility() != i2) {
                        i20++;
                        if (i19 > 0 && i19 >= i15) {
                            i4 += widgetRun.start.margin;
                        }
                        androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency = widgetRun.dimension;
                        int i21 = dimensionDependency.value;
                        boolean z3 = widgetRun.dimensionBehavior != androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z3) {
                            int i22 = this.orientation;
                            if (i22 == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (i22 == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            } else {
                                i12 = i21;
                            }
                        } else {
                            i12 = i21;
                            if (widgetRun.matchConstraintsType == 1 && i18 == 0) {
                                i13 = dimensionDependency.wrapValue;
                                i5++;
                            } else if (dimensionDependency.resolved) {
                                i13 = i12;
                            }
                            z3 = true;
                            if (z3) {
                                i5++;
                                float f3 = widgetRun.widget.mWeight[this.orientation];
                                if (f3 >= 0.0f) {
                                    f += f3;
                                }
                            } else {
                                i4 += i13;
                            }
                            if (i19 < i16 && i19 < i) {
                                i4 += -widgetRun.end.margin;
                            }
                        }
                        i13 = i12;
                        if (z3) {
                        }
                        if (i19 < i16) {
                            i4 += -widgetRun.end.margin;
                        }
                    }
                    i19++;
                    i2 = 8;
                }
                if (i4 < i14 || i5 == 0) {
                    i3 = i20;
                    break;
                } else {
                    i18++;
                    i2 = 8;
                }
            }
            i3 = 0;
            i4 = 0;
            i5 = 0;
            f = 0.0f;
            int i23 = this.start.value;
            if (isRtl) {
                i23 = this.end.value;
            }
            if (i4 > i14) {
                i23 = isRtl ? i23 + ((int) (((i4 - i14) / 2.0f) + 0.5f)) : i23 - ((int) (((i4 - i14) / 2.0f) + 0.5f));
            }
            if (i5 > 0) {
                float f4 = i14 - i4;
                int i24 = (int) ((f4 / i5) + 0.5f);
                int i25 = 0;
                int i26 = 0;
                while (i25 < size) {
                    androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun2 = this.widgets.get(i25);
                    int i27 = i24;
                    int i28 = i4;
                    if (widgetRun2.widget.getVisibility() != 8 && widgetRun2.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency2 = widgetRun2.dimension;
                        if (!dimensionDependency2.resolved) {
                            if (f > 0.0f) {
                                i10 = i23;
                                i11 = (int) (((widgetRun2.widget.mWeight[this.orientation] * f4) / f) + 0.5f);
                            } else {
                                i10 = i23;
                                i11 = i27;
                            }
                            if (this.orientation == 0) {
                                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = widgetRun2.widget;
                                f2 = f4;
                                int i29 = constraintWidget.mMatchConstraintMaxWidth;
                                z2 = isRtl;
                                i9 = i3;
                                max = java.lang.Math.max(constraintWidget.mMatchConstraintMinWidth, widgetRun2.matchConstraintsType == 1 ? java.lang.Math.min(i11, dimensionDependency2.wrapValue) : i11);
                                if (i29 > 0) {
                                    max = java.lang.Math.min(i29, max);
                                }
                            } else {
                                z2 = isRtl;
                                i9 = i3;
                                f2 = f4;
                                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = widgetRun2.widget;
                                int i30 = constraintWidget2.mMatchConstraintMaxHeight;
                                max = java.lang.Math.max(constraintWidget2.mMatchConstraintMinHeight, widgetRun2.matchConstraintsType == 1 ? java.lang.Math.min(i11, dimensionDependency2.wrapValue) : i11);
                                if (i30 > 0) {
                                    max = java.lang.Math.min(i30, max);
                                }
                            }
                        }
                    }
                    z2 = isRtl;
                    i9 = i3;
                    i10 = i23;
                    f2 = f4;
                    i25++;
                    i24 = i27;
                    i4 = i28;
                    i23 = i10;
                    f4 = f2;
                    isRtl = z2;
                    i3 = i9;
                }
                z = isRtl;
                i6 = i3;
                i7 = i23;
                int i31 = i4;
                if (i26 > 0) {
                    i5 -= i26;
                    int i32 = 0;
                    for (int i33 = 0; i33 < size; i33++) {
                        androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun3 = this.widgets.get(i33);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i33 > 0 && i33 >= i15) {
                                i32 += widgetRun3.start.margin;
                            }
                            i32 += widgetRun3.dimension.value;
                            if (i33 < i16 && i33 < i) {
                                i32 += -widgetRun3.end.margin;
                            }
                        }
                    }
                    i4 = i32;
                } else {
                    i4 = i31;
                }
                i8 = 2;
                if (this.chainStyle == 2 && i26 == 0) {
                    this.chainStyle = 0;
                }
            } else {
                z = isRtl;
                i6 = i3;
                i7 = i23;
                i8 = 2;
            }
            if (i4 > i14) {
                this.chainStyle = i8;
            }
            if (i6 > 0 && i5 == 0 && i15 == i) {
                this.chainStyle = i8;
            }
            int i34 = this.chainStyle;
            if (i34 == 1) {
                int i35 = i6;
                int i36 = i35 > 1 ? (i14 - i4) / (i35 - 1) : i35 == 1 ? (i14 - i4) / 2 : 0;
                if (i5 > 0) {
                    i36 = 0;
                }
                int i37 = i7;
                for (int i38 = 0; i38 < size; i38++) {
                    androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun4 = this.widgets.get(z ? size - (i38 + 1) : i38);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i37);
                        widgetRun4.end.resolve(i37);
                    } else {
                        if (i38 > 0) {
                            i37 = z ? i37 - i36 : i37 + i36;
                        }
                        if (i38 > 0 && i38 >= i15) {
                            i37 = z ? i37 - widgetRun4.start.margin : i37 + widgetRun4.start.margin;
                        }
                        if (z) {
                            widgetRun4.end.resolve(i37);
                        } else {
                            widgetRun4.start.resolve(i37);
                        }
                        androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency3 = widgetRun4.dimension;
                        int i39 = dimensionDependency3.value;
                        if (widgetRun4.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i39 = dimensionDependency3.wrapValue;
                        }
                        i37 = z ? i37 - i39 : i37 + i39;
                        if (z) {
                            widgetRun4.start.resolve(i37);
                        } else {
                            widgetRun4.end.resolve(i37);
                        }
                        widgetRun4.resolved = true;
                        if (i38 < i16 && i38 < i) {
                            i37 = z ? i37 - (-widgetRun4.end.margin) : i37 + (-widgetRun4.end.margin);
                        }
                    }
                }
                return;
            }
            int i40 = i6;
            if (i34 == 0) {
                int i41 = (i14 - i4) / (i40 + 1);
                if (i5 > 0) {
                    i41 = 0;
                }
                int i42 = i7;
                for (int i43 = 0; i43 < size; i43++) {
                    androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun5 = this.widgets.get(z ? size - (i43 + 1) : i43);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i42);
                        widgetRun5.end.resolve(i42);
                    } else {
                        int i44 = z ? i42 - i41 : i42 + i41;
                        if (i43 > 0 && i43 >= i15) {
                            i44 = z ? i44 - widgetRun5.start.margin : i44 + widgetRun5.start.margin;
                        }
                        if (z) {
                            widgetRun5.end.resolve(i44);
                        } else {
                            widgetRun5.start.resolve(i44);
                        }
                        androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency4 = widgetRun5.dimension;
                        int i45 = dimensionDependency4.value;
                        if (widgetRun5.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            i45 = java.lang.Math.min(i45, dimensionDependency4.wrapValue);
                        }
                        i42 = z ? i44 - i45 : i44 + i45;
                        if (z) {
                            widgetRun5.start.resolve(i42);
                        } else {
                            widgetRun5.end.resolve(i42);
                        }
                        if (i43 < i16 && i43 < i) {
                            i42 = z ? i42 - (-widgetRun5.end.margin) : i42 + (-widgetRun5.end.margin);
                        }
                    }
                }
                return;
            }
            if (i34 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.widget.getHorizontalBiasPercent() : this.widget.getVerticalBiasPercent();
                if (z) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i46 = (int) (((i14 - i4) * horizontalBiasPercent) + 0.5f);
                if (i46 < 0 || i5 > 0) {
                    i46 = 0;
                }
                int i47 = z ? i7 - i46 : i7 + i46;
                for (int i48 = 0; i48 < size; i48++) {
                    androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun6 = this.widgets.get(z ? size - (i48 + 1) : i48);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i47);
                        widgetRun6.end.resolve(i47);
                    } else {
                        if (i48 > 0 && i48 >= i15) {
                            i47 = z ? i47 - widgetRun6.start.margin : i47 + widgetRun6.start.margin;
                        }
                        if (z) {
                            widgetRun6.end.resolve(i47);
                        } else {
                            widgetRun6.start.resolve(i47);
                        }
                        androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency5 = widgetRun6.dimension;
                        int i49 = dimensionDependency5.value;
                        if (widgetRun6.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i49 = dimensionDependency5.wrapValue;
                        }
                        i47 += i49;
                        if (z) {
                            widgetRun6.start.resolve(i47);
                        } else {
                            widgetRun6.end.resolve(i47);
                        }
                        if (i48 < i16 && i48 < i) {
                            i47 = z ? i47 - (-widgetRun6.end.margin) : i47 + (-widgetRun6.end.margin);
                        }
                    }
                }
            }
        }
    }
}
