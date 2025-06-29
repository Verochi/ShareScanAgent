package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure measure = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure();

    private static boolean canMeasure(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
        androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer = constraintWidget.getParent() != null ? (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) constraintWidget.getParent() : null;
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.getHorizontalDimensionBehaviour();
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.getVerticalDimensionBehaviour();
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        boolean z = horizontalDimensionBehaviour == dimensionBehaviour3 || horizontalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (horizontalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(0)) || constraintWidget.isResolvedHorizontally();
        boolean z2 = verticalDimensionBehaviour == dimensionBehaviour3 || verticalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (verticalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(1)) || constraintWidget.isResolvedVertically();
        if (constraintWidget.mDimensionRatio <= 0.0f || !(z || z2)) {
            return z && z2;
        }
        return true;
    }

    private static void horizontalSolvingPass(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer, boolean z) {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor5;
        if (!(constraintWidget instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) && constraintWidget.isMeasureRequested() && canMeasure(constraintWidget)) {
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.measure(constraintWidget, measurer, new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure(), androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS);
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor = constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT);
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor2 = constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT);
        int finalValue = anchor.getFinalValue();
        int finalValue2 = anchor2.getFinalValue();
        if (anchor.getDependents() != null && anchor.hasFinalValue()) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it = anchor.getDependents().iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor next = it.next();
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = next.mOwner;
                boolean canMeasure = canMeasure(constraintWidget2);
                if (constraintWidget2.isMeasureRequested() && canMeasure) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.measure(constraintWidget2, measurer, new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure(), androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget2.getHorizontalDimensionBehaviour();
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (horizontalDimensionBehaviour != dimensionBehaviour || canMeasure) {
                    if (!constraintWidget2.isMeasureRequested()) {
                        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor6 = constraintWidget2.mLeft;
                        if (next == constraintAnchor6 && constraintWidget2.mRight.mTarget == null) {
                            int margin = constraintAnchor6.getMargin() + finalValue;
                            constraintWidget2.setFinalHorizontal(margin, constraintWidget2.getWidth() + margin);
                            horizontalSolvingPass(constraintWidget2, measurer, z);
                        } else {
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor7 = constraintWidget2.mRight;
                            if (next == constraintAnchor7 && constraintAnchor6.mTarget == null) {
                                int margin2 = finalValue - constraintAnchor7.getMargin();
                                constraintWidget2.setFinalHorizontal(margin2 - constraintWidget2.getWidth(), margin2);
                                horizontalSolvingPass(constraintWidget2, measurer, z);
                            } else if (next == constraintAnchor6 && (constraintAnchor3 = constraintAnchor7.mTarget) != null && constraintAnchor3.hasFinalValue() && !constraintWidget2.isInHorizontalChain()) {
                                solveHorizontalCenterConstraints(measurer, constraintWidget2, z);
                            }
                        }
                    }
                } else if (constraintWidget2.getHorizontalDimensionBehaviour() == dimensionBehaviour && constraintWidget2.mMatchConstraintMaxWidth >= 0 && constraintWidget2.mMatchConstraintMinWidth >= 0 && (constraintWidget2.getVisibility() == 8 || (constraintWidget2.mMatchConstraintDefaultWidth == 0 && constraintWidget2.getDimensionRatio() == 0.0f))) {
                    if (!constraintWidget2.isInHorizontalChain() && !constraintWidget2.isInVirtualLayout()) {
                        if (((next == constraintWidget2.mLeft && (constraintAnchor5 = constraintWidget2.mRight.mTarget) != null && constraintAnchor5.hasFinalValue()) || (next == constraintWidget2.mRight && (constraintAnchor4 = constraintWidget2.mLeft.mTarget) != null && constraintAnchor4.hasFinalValue())) && !constraintWidget2.isInHorizontalChain()) {
                            solveHorizontalMatchConstraint(constraintWidget, measurer, constraintWidget2, z);
                        }
                    }
                }
            }
        }
        if ((constraintWidget instanceof androidx.constraintlayout.solver.widgets.Guideline) || anchor2.getDependents() == null || !anchor2.hasFinalValue()) {
            return;
        }
        java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it2 = anchor2.getDependents().iterator();
        while (it2.hasNext()) {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor next2 = it2.next();
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = next2.mOwner;
            boolean canMeasure2 = canMeasure(constraintWidget3);
            if (constraintWidget3.isMeasureRequested() && canMeasure2) {
                androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.measure(constraintWidget3, measurer, new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure(), androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS);
            }
            boolean z2 = (next2 == constraintWidget3.mLeft && (constraintAnchor2 = constraintWidget3.mRight.mTarget) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintWidget3.mRight && (constraintAnchor = constraintWidget3.mLeft.mTarget) != null && constraintAnchor.hasFinalValue());
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidget3.getHorizontalDimensionBehaviour();
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (horizontalDimensionBehaviour2 != dimensionBehaviour2 || canMeasure2) {
                if (!constraintWidget3.isMeasureRequested()) {
                    androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor8 = constraintWidget3.mLeft;
                    if (next2 == constraintAnchor8 && constraintWidget3.mRight.mTarget == null) {
                        int margin3 = constraintAnchor8.getMargin() + finalValue2;
                        constraintWidget3.setFinalHorizontal(margin3, constraintWidget3.getWidth() + margin3);
                        horizontalSolvingPass(constraintWidget3, measurer, z);
                    } else {
                        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor9 = constraintWidget3.mRight;
                        if (next2 == constraintAnchor9 && constraintAnchor8.mTarget == null) {
                            int margin4 = finalValue2 - constraintAnchor9.getMargin();
                            constraintWidget3.setFinalHorizontal(margin4 - constraintWidget3.getWidth(), margin4);
                            horizontalSolvingPass(constraintWidget3, measurer, z);
                        } else if (z2 && !constraintWidget3.isInHorizontalChain()) {
                            solveHorizontalCenterConstraints(measurer, constraintWidget3, z);
                        }
                    }
                }
            } else if (constraintWidget3.getHorizontalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget3.mMatchConstraintMaxWidth >= 0 && constraintWidget3.mMatchConstraintMinWidth >= 0 && (constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultWidth == 0 && constraintWidget3.getDimensionRatio() == 0.0f))) {
                if (!constraintWidget3.isInHorizontalChain() && !constraintWidget3.isInVirtualLayout() && z2 && !constraintWidget3.isInHorizontalChain()) {
                    solveHorizontalMatchConstraint(constraintWidget, measurer, constraintWidget3, z);
                }
            }
        }
    }

    private static void solveBarrier(androidx.constraintlayout.solver.widgets.Barrier barrier, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer, int i, boolean z) {
        if (barrier.allSolved()) {
            if (i == 0) {
                horizontalSolvingPass(barrier, measurer, z);
            } else {
                verticalSolvingPass(barrier, measurer);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cd, code lost:
    
        if (r6.mOwner == r2) goto L108;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean solveChain(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem linearSystem, int i, int i2, androidx.constraintlayout.solver.widgets.ChainHead chainHead, boolean z, boolean z2, boolean z3) {
        int finalValue;
        int finalValue2;
        int finalValue3;
        int i3;
        int height;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget;
        if (z3) {
            return false;
        }
        if (i == 0) {
            if (!constraintWidgetContainer.isResolvedHorizontally()) {
                return false;
            }
        } else if (!constraintWidgetContainer.isResolvedVertically()) {
            return false;
        }
        boolean isRtl = constraintWidgetContainer.isRtl();
        androidx.constraintlayout.solver.widgets.ConstraintWidget first = chainHead.getFirst();
        androidx.constraintlayout.solver.widgets.ConstraintWidget last = chainHead.getLast();
        androidx.constraintlayout.solver.widgets.ConstraintWidget firstVisibleWidget = chainHead.getFirstVisibleWidget();
        androidx.constraintlayout.solver.widgets.ConstraintWidget lastVisibleWidget = chainHead.getLastVisibleWidget();
        androidx.constraintlayout.solver.widgets.ConstraintWidget head = chainHead.getHead();
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor = first.mListAnchors[i2];
        int i4 = i2 + 1;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2 = last.mListAnchors[i4];
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3 = constraintAnchor.mTarget;
        if (constraintAnchor3 == null || constraintAnchor2.mTarget == null || !constraintAnchor3.hasFinalValue() || !constraintAnchor2.mTarget.hasFinalValue() || firstVisibleWidget == null || lastVisibleWidget == null || (finalValue3 = (finalValue2 = constraintAnchor2.mTarget.getFinalValue() - lastVisibleWidget.mListAnchors[i4].getMargin()) - (finalValue = constraintAnchor.mTarget.getFinalValue() + firstVisibleWidget.mListAnchors[i2].getMargin())) <= 0) {
            return false;
        }
        androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure measure2 = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure();
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = first;
        boolean z4 = false;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = null;
            if (z4) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = first;
                if (i5 == 0 || i5 != i6 || finalValue3 < i7) {
                    return false;
                }
                int i8 = finalValue3 - i7;
                if (z) {
                    i8 /= i5 + 1;
                } else if (z2 && i5 > 2) {
                    i3 = 1;
                    i8 = (i8 / i5) - 1;
                    if (i5 != i3) {
                        int horizontalBiasPercent = (int) (finalValue + 0.5f + (i8 * (i == 0 ? head.getHorizontalBiasPercent() : head.getVerticalBiasPercent())));
                        if (i == 0) {
                            firstVisibleWidget.setFinalHorizontal(horizontalBiasPercent, firstVisibleWidget.getWidth() + horizontalBiasPercent);
                        } else {
                            firstVisibleWidget.setFinalVertical(horizontalBiasPercent, firstVisibleWidget.getHeight() + horizontalBiasPercent);
                        }
                        horizontalSolvingPass(firstVisibleWidget, constraintWidgetContainer.getMeasurer(), isRtl);
                        return true;
                    }
                    if (z) {
                        int i9 = finalValue + i8;
                        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5 = constraintWidget4;
                        boolean z5 = false;
                        while (!z5) {
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4 = constraintWidget5.mListAnchors[i2];
                            if (constraintWidget5.getVisibility() != 8) {
                                int margin = i9 + constraintWidget5.mListAnchors[i2].getMargin();
                                if (i == 0) {
                                    constraintWidget5.setFinalHorizontal(margin, constraintWidget5.getWidth() + margin);
                                    horizontalSolvingPass(constraintWidget5, constraintWidgetContainer.getMeasurer(), isRtl);
                                    height = constraintWidget5.getWidth();
                                } else {
                                    constraintWidget5.setFinalVertical(margin, constraintWidget5.getHeight() + margin);
                                    verticalSolvingPass(constraintWidget5, constraintWidgetContainer.getMeasurer());
                                    height = constraintWidget5.getHeight();
                                }
                                i9 = margin + height + constraintWidget5.mListAnchors[i4].getMargin() + i8;
                            } else if (i == 0) {
                                constraintWidget5.setFinalHorizontal(i9, i9);
                                horizontalSolvingPass(constraintWidget5, constraintWidgetContainer.getMeasurer(), isRtl);
                            } else {
                                constraintWidget5.setFinalVertical(i9, i9);
                                verticalSolvingPass(constraintWidget5, constraintWidgetContainer.getMeasurer());
                            }
                            constraintWidget5.addToSolver(linearSystem, false);
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor5 = constraintWidget5.mListAnchors[i4].mTarget;
                            if (constraintAnchor5 != null) {
                                constraintWidget = constraintAnchor5.mOwner;
                                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor6 = constraintWidget.mListAnchors[i2].mTarget;
                                if (constraintAnchor6 != null) {
                                }
                            }
                            constraintWidget = null;
                            if (constraintWidget != null) {
                                constraintWidget5 = constraintWidget;
                            } else {
                                z5 = true;
                            }
                        }
                    } else if (z2) {
                        if (i5 != 2) {
                            return false;
                        }
                        if (i == 0) {
                            firstVisibleWidget.setFinalHorizontal(finalValue, firstVisibleWidget.getWidth() + finalValue);
                            lastVisibleWidget.setFinalHorizontal(finalValue2 - lastVisibleWidget.getWidth(), finalValue2);
                            horizontalSolvingPass(firstVisibleWidget, constraintWidgetContainer.getMeasurer(), isRtl);
                            horizontalSolvingPass(lastVisibleWidget, constraintWidgetContainer.getMeasurer(), isRtl);
                            return true;
                        }
                        firstVisibleWidget.setFinalVertical(finalValue, firstVisibleWidget.getHeight() + finalValue);
                        lastVisibleWidget.setFinalVertical(finalValue2 - lastVisibleWidget.getHeight(), finalValue2);
                        verticalSolvingPass(firstVisibleWidget, constraintWidgetContainer.getMeasurer());
                        verticalSolvingPass(lastVisibleWidget, constraintWidgetContainer.getMeasurer());
                        return true;
                    }
                    return true;
                }
                i3 = 1;
                if (i5 != i3) {
                }
            } else {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor7 = constraintWidget2.mListAnchors[i2];
                if (!canMeasure(constraintWidget2)) {
                    return false;
                }
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget6 = first;
                if (constraintWidget2.mListDimensionBehaviors[i] == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    return false;
                }
                if (constraintWidget2.isMeasureRequested()) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.measure(constraintWidget2, constraintWidgetContainer.getMeasurer(), measure2, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                i7 = i7 + constraintWidget2.mListAnchors[i2].getMargin() + (i == 0 ? constraintWidget2.getWidth() : constraintWidget2.getHeight()) + constraintWidget2.mListAnchors[i4].getMargin();
                i6++;
                if (constraintWidget2.getVisibility() != 8) {
                    i5++;
                }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor8 = constraintWidget2.mListAnchors[i4].mTarget;
                if (constraintAnchor8 != null) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget7 = constraintAnchor8.mOwner;
                    androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor9 = constraintWidget7.mListAnchors[i2].mTarget;
                    if (constraintAnchor9 != null && constraintAnchor9.mOwner == constraintWidget2) {
                        constraintWidget3 = constraintWidget7;
                    }
                }
                if (constraintWidget3 != null) {
                    constraintWidget2 = constraintWidget3;
                } else {
                    z4 = true;
                }
                first = constraintWidget6;
            }
        }
    }

    private static void solveHorizontalCenterConstraints(androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer, androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, boolean z) {
        float horizontalBiasPercent = constraintWidget.getHorizontalBiasPercent();
        int finalValue = constraintWidget.mLeft.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mRight.mTarget.getFinalValue();
        int margin = constraintWidget.mLeft.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mRight.getMargin();
        if (finalValue == finalValue2) {
            horizontalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int width = constraintWidget.getWidth();
        int i = (finalValue2 - finalValue) - width;
        if (finalValue > finalValue2) {
            i = (finalValue - finalValue2) - width;
        }
        int i2 = ((int) ((horizontalBiasPercent * i) + 0.5f)) + finalValue;
        int i3 = i2 + width;
        if (finalValue > finalValue2) {
            i3 = i2 - width;
        }
        constraintWidget.setFinalHorizontal(i2, i3);
        horizontalSolvingPass(constraintWidget, measurer, z);
    }

    private static void solveHorizontalMatchConstraint(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer, androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2, boolean z) {
        float horizontalBiasPercent = constraintWidget2.getHorizontalBiasPercent();
        int finalValue = constraintWidget2.mLeft.mTarget.getFinalValue() + constraintWidget2.mLeft.getMargin();
        int finalValue2 = constraintWidget2.mRight.mTarget.getFinalValue() - constraintWidget2.mRight.getMargin();
        if (finalValue2 >= finalValue) {
            int width = constraintWidget2.getWidth();
            if (constraintWidget2.getVisibility() != 8) {
                int i = constraintWidget2.mMatchConstraintDefaultWidth;
                if (i == 2) {
                    width = (int) (constraintWidget2.getHorizontalBiasPercent() * 0.5f * (constraintWidget instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer ? constraintWidget.getWidth() : constraintWidget.getParent().getWidth()));
                } else if (i == 0) {
                    width = finalValue2 - finalValue;
                }
                width = java.lang.Math.max(constraintWidget2.mMatchConstraintMinWidth, width);
                int i2 = constraintWidget2.mMatchConstraintMaxWidth;
                if (i2 > 0) {
                    width = java.lang.Math.min(i2, width);
                }
            }
            int i3 = finalValue + ((int) ((horizontalBiasPercent * ((finalValue2 - finalValue) - width)) + 0.5f));
            constraintWidget2.setFinalHorizontal(i3, width + i3);
            horizontalSolvingPass(constraintWidget2, measurer, z);
        }
    }

    private static void solveVerticalCenterConstraints(androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer, androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        float verticalBiasPercent = constraintWidget.getVerticalBiasPercent();
        int finalValue = constraintWidget.mTop.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mBottom.mTarget.getFinalValue();
        int margin = constraintWidget.mTop.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mBottom.getMargin();
        if (finalValue == finalValue2) {
            verticalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int height = constraintWidget.getHeight();
        int i = (finalValue2 - finalValue) - height;
        if (finalValue > finalValue2) {
            i = (finalValue - finalValue2) - height;
        }
        int i2 = (int) ((verticalBiasPercent * i) + 0.5f);
        int i3 = finalValue + i2;
        int i4 = i3 + height;
        if (finalValue > finalValue2) {
            i3 = finalValue - i2;
            i4 = i3 - height;
        }
        constraintWidget.setFinalVertical(i3, i4);
        verticalSolvingPass(constraintWidget, measurer);
    }

    private static void solveVerticalMatchConstraint(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer, androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2) {
        float verticalBiasPercent = constraintWidget2.getVerticalBiasPercent();
        int finalValue = constraintWidget2.mTop.mTarget.getFinalValue() + constraintWidget2.mTop.getMargin();
        int finalValue2 = constraintWidget2.mBottom.mTarget.getFinalValue() - constraintWidget2.mBottom.getMargin();
        if (finalValue2 >= finalValue) {
            int height = constraintWidget2.getHeight();
            if (constraintWidget2.getVisibility() != 8) {
                int i = constraintWidget2.mMatchConstraintDefaultHeight;
                if (i == 2) {
                    height = (int) (verticalBiasPercent * 0.5f * (constraintWidget instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer ? constraintWidget.getHeight() : constraintWidget.getParent().getHeight()));
                } else if (i == 0) {
                    height = finalValue2 - finalValue;
                }
                height = java.lang.Math.max(constraintWidget2.mMatchConstraintMinHeight, height);
                int i2 = constraintWidget2.mMatchConstraintMaxHeight;
                if (i2 > 0) {
                    height = java.lang.Math.min(i2, height);
                }
            }
            int i3 = finalValue + ((int) ((verticalBiasPercent * ((finalValue2 - finalValue) - height)) + 0.5f));
            constraintWidget2.setFinalVertical(i3, height + i3);
            verticalSolvingPass(constraintWidget2, measurer);
        }
    }

    public static void solvingPass(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer) {
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidgetContainer.getVerticalDimensionBehaviour();
        constraintWidgetContainer.resetFinalResolution();
        java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i = 0; i < size; i++) {
            children.get(i).resetFinalResolution();
        }
        boolean isRtl = constraintWidgetContainer.isRtl();
        if (horizontalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalHorizontal(0, constraintWidgetContainer.getWidth());
        } else {
            constraintWidgetContainer.setFinalLeft(0);
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = children.get(i2);
            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                androidx.constraintlayout.solver.widgets.Guideline guideline = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    if (guideline.getRelativeBegin() != -1) {
                        guideline.setFinalValue(guideline.getRelativeBegin());
                    } else if (guideline.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue(constraintWidgetContainer.getWidth() - guideline.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue((int) ((guideline.getRelativePercent() * constraintWidgetContainer.getWidth()) + 0.5f));
                    }
                    z = true;
                }
            } else if ((constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) && ((androidx.constraintlayout.solver.widgets.Barrier) constraintWidget).getOrientation() == 0) {
                z2 = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = children.get(i3);
                if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                    androidx.constraintlayout.solver.widgets.Guideline guideline2 = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget2;
                    if (guideline2.getOrientation() == 1) {
                        horizontalSolvingPass(guideline2, measurer, isRtl);
                    }
                }
            }
        }
        horizontalSolvingPass(constraintWidgetContainer, measurer, isRtl);
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = children.get(i4);
                if (constraintWidget3 instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                    androidx.constraintlayout.solver.widgets.Barrier barrier = (androidx.constraintlayout.solver.widgets.Barrier) constraintWidget3;
                    if (barrier.getOrientation() == 0) {
                        solveBarrier(barrier, measurer, 0, isRtl);
                    }
                }
            }
        }
        if (verticalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalVertical(0, constraintWidgetContainer.getHeight());
        } else {
            constraintWidgetContainer.setFinalTop(0);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i5 = 0; i5 < size; i5++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = children.get(i5);
            if (constraintWidget4 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                androidx.constraintlayout.solver.widgets.Guideline guideline3 = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget4;
                if (guideline3.getOrientation() == 0) {
                    if (guideline3.getRelativeBegin() != -1) {
                        guideline3.setFinalValue(guideline3.getRelativeBegin());
                    } else if (guideline3.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue(constraintWidgetContainer.getHeight() - guideline3.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue((int) ((guideline3.getRelativePercent() * constraintWidgetContainer.getHeight()) + 0.5f));
                    }
                    z3 = true;
                }
            } else if ((constraintWidget4 instanceof androidx.constraintlayout.solver.widgets.Barrier) && ((androidx.constraintlayout.solver.widgets.Barrier) constraintWidget4).getOrientation() == 1) {
                z4 = true;
            }
        }
        if (z3) {
            for (int i6 = 0; i6 < size; i6++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5 = children.get(i6);
                if (constraintWidget5 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                    androidx.constraintlayout.solver.widgets.Guideline guideline4 = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget5;
                    if (guideline4.getOrientation() == 0) {
                        verticalSolvingPass(guideline4, measurer);
                    }
                }
            }
        }
        verticalSolvingPass(constraintWidgetContainer, measurer);
        if (z4) {
            for (int i7 = 0; i7 < size; i7++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget6 = children.get(i7);
                if (constraintWidget6 instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                    androidx.constraintlayout.solver.widgets.Barrier barrier2 = (androidx.constraintlayout.solver.widgets.Barrier) constraintWidget6;
                    if (barrier2.getOrientation() == 1) {
                        solveBarrier(barrier2, measurer, 1, isRtl);
                    }
                }
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget7 = children.get(i8);
            if (constraintWidget7.isMeasureRequested() && canMeasure(constraintWidget7)) {
                androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.measure(constraintWidget7, measurer, measure, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS);
                horizontalSolvingPass(constraintWidget7, measurer, isRtl);
                verticalSolvingPass(constraintWidget7, measurer);
            }
        }
    }

    private static void verticalSolvingPass(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer) {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor5;
        if (!(constraintWidget instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) && constraintWidget.isMeasureRequested() && canMeasure(constraintWidget)) {
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.measure(constraintWidget, measurer, new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure(), androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS);
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor = constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP);
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor2 = constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM);
        int finalValue = anchor.getFinalValue();
        int finalValue2 = anchor2.getFinalValue();
        if (anchor.getDependents() != null && anchor.hasFinalValue()) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it = anchor.getDependents().iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor next = it.next();
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = next.mOwner;
                boolean canMeasure = canMeasure(constraintWidget2);
                if (constraintWidget2.isMeasureRequested() && canMeasure) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.measure(constraintWidget2, measurer, new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure(), androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget2.getVerticalDimensionBehaviour();
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (verticalDimensionBehaviour != dimensionBehaviour || canMeasure) {
                    if (!constraintWidget2.isMeasureRequested()) {
                        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor6 = constraintWidget2.mTop;
                        if (next == constraintAnchor6 && constraintWidget2.mBottom.mTarget == null) {
                            int margin = constraintAnchor6.getMargin() + finalValue;
                            constraintWidget2.setFinalVertical(margin, constraintWidget2.getHeight() + margin);
                            verticalSolvingPass(constraintWidget2, measurer);
                        } else {
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor7 = constraintWidget2.mBottom;
                            if (next == constraintAnchor7 && constraintAnchor7.mTarget == null) {
                                int margin2 = finalValue - constraintAnchor7.getMargin();
                                constraintWidget2.setFinalVertical(margin2 - constraintWidget2.getHeight(), margin2);
                                verticalSolvingPass(constraintWidget2, measurer);
                            } else if (next == constraintAnchor6 && (constraintAnchor3 = constraintAnchor7.mTarget) != null && constraintAnchor3.hasFinalValue()) {
                                solveVerticalCenterConstraints(measurer, constraintWidget2);
                            }
                        }
                    }
                } else if (constraintWidget2.getVerticalDimensionBehaviour() == dimensionBehaviour && constraintWidget2.mMatchConstraintMaxHeight >= 0 && constraintWidget2.mMatchConstraintMinHeight >= 0 && (constraintWidget2.getVisibility() == 8 || (constraintWidget2.mMatchConstraintDefaultHeight == 0 && constraintWidget2.getDimensionRatio() == 0.0f))) {
                    if (!constraintWidget2.isInVerticalChain() && !constraintWidget2.isInVirtualLayout()) {
                        if (((next == constraintWidget2.mTop && (constraintAnchor5 = constraintWidget2.mBottom.mTarget) != null && constraintAnchor5.hasFinalValue()) || (next == constraintWidget2.mBottom && (constraintAnchor4 = constraintWidget2.mTop.mTarget) != null && constraintAnchor4.hasFinalValue())) && !constraintWidget2.isInVerticalChain()) {
                            solveVerticalMatchConstraint(constraintWidget, measurer, constraintWidget2);
                        }
                    }
                }
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Guideline) {
            return;
        }
        if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it2 = anchor2.getDependents().iterator();
            while (it2.hasNext()) {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor next2 = it2.next();
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = next2.mOwner;
                boolean canMeasure2 = canMeasure(constraintWidget3);
                if (constraintWidget3.isMeasureRequested() && canMeasure2) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.measure(constraintWidget3, measurer, new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure(), androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                boolean z = (next2 == constraintWidget3.mTop && (constraintAnchor2 = constraintWidget3.mBottom.mTarget) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintWidget3.mBottom && (constraintAnchor = constraintWidget3.mTop.mTarget) != null && constraintAnchor.hasFinalValue());
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour2 = constraintWidget3.getVerticalDimensionBehaviour();
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (verticalDimensionBehaviour2 != dimensionBehaviour2 || canMeasure2) {
                    if (!constraintWidget3.isMeasureRequested()) {
                        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor8 = constraintWidget3.mTop;
                        if (next2 == constraintAnchor8 && constraintWidget3.mBottom.mTarget == null) {
                            int margin3 = constraintAnchor8.getMargin() + finalValue2;
                            constraintWidget3.setFinalVertical(margin3, constraintWidget3.getHeight() + margin3);
                            verticalSolvingPass(constraintWidget3, measurer);
                        } else {
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor9 = constraintWidget3.mBottom;
                            if (next2 == constraintAnchor9 && constraintAnchor8.mTarget == null) {
                                int margin4 = finalValue2 - constraintAnchor9.getMargin();
                                constraintWidget3.setFinalVertical(margin4 - constraintWidget3.getHeight(), margin4);
                                verticalSolvingPass(constraintWidget3, measurer);
                            } else if (z && !constraintWidget3.isInVerticalChain()) {
                                solveVerticalCenterConstraints(measurer, constraintWidget3);
                            }
                        }
                    }
                } else if (constraintWidget3.getVerticalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget3.mMatchConstraintMaxHeight >= 0 && constraintWidget3.mMatchConstraintMinHeight >= 0 && (constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultHeight == 0 && constraintWidget3.getDimensionRatio() == 0.0f))) {
                    if (!constraintWidget3.isInVerticalChain() && !constraintWidget3.isInVirtualLayout() && z && !constraintWidget3.isInVerticalChain()) {
                        solveVerticalMatchConstraint(constraintWidget, measurer, constraintWidget3);
                    }
                }
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor3 = constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE);
        if (anchor3.getDependents() == null || !anchor3.hasFinalValue()) {
            return;
        }
        int finalValue3 = anchor3.getFinalValue();
        java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it3 = anchor3.getDependents().iterator();
        while (it3.hasNext()) {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor next3 = it3.next();
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = next3.mOwner;
            boolean canMeasure3 = canMeasure(constraintWidget4);
            if (constraintWidget4.isMeasureRequested() && canMeasure3) {
                androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.measure(constraintWidget4, measurer, new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure(), androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS);
            }
            if (constraintWidget4.getVerticalDimensionBehaviour() != androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || canMeasure3) {
                if (!constraintWidget4.isMeasureRequested() && next3 == constraintWidget4.mBaseline) {
                    constraintWidget4.setFinalBaseline(finalValue3);
                    verticalSolvingPass(constraintWidget4, measurer);
                }
            }
        }
    }
}
