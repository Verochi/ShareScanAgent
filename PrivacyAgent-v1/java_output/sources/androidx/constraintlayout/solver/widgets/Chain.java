package androidx.constraintlayout.solver.widgets;

/* loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r7 == 2) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x003e, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x003c, code lost:
    
        if (r7 == 2) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x024e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04bf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x038d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0395 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c8  */
    /* JADX WARN: Type inference failed for: r2v56, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem linearSystem, int i, int i2, androidx.constraintlayout.solver.widgets.ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> arrayList;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3;
        int i3;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2;
        int i4;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4;
        androidx.constraintlayout.solver.SolverVariable solverVariable;
        androidx.constraintlayout.solver.SolverVariable solverVariable2;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor5;
        androidx.constraintlayout.solver.SolverVariable solverVariable3;
        androidx.constraintlayout.solver.SolverVariable solverVariable4;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4;
        androidx.constraintlayout.solver.SolverVariable solverVariable5;
        int size;
        int i5;
        java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> arrayList2;
        boolean z4;
        boolean z5;
        boolean z6;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget6;
        int i6;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget7 = chainHead.mFirst;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget8 = chainHead.mLast;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget9 = chainHead.mFirstVisibleWidget;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget10 = chainHead.mLastVisibleWidget;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget11 = chainHead.mHead;
        float f = chainHead.mTotalWeight;
        boolean z7 = constraintWidgetContainer.mListDimensionBehaviors[i] == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            int i7 = constraintWidget11.mHorizontalChainStyle;
            z = i7 == 0;
            z2 = i7 == 1;
        } else {
            int i8 = constraintWidget11.mVerticalChainStyle;
            z = i8 == 0;
            z2 = i8 == 1;
        }
        boolean z8 = z2;
        boolean z9 = false;
        boolean z10 = z;
        ?? r8 = constraintWidget7;
        while (true) {
            if (z9) {
                break;
            }
            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor6 = r8.mListAnchors[i2];
            int i9 = z3 ? 1 : 4;
            int margin = constraintAnchor6.getMargin();
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = r8.mListDimensionBehaviors[i];
            float f2 = f;
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && r8.mResolvedMatchConstraintDefault[i] == 0) {
                z4 = z9;
                z5 = true;
            } else {
                z4 = z9;
                z5 = false;
            }
            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor7 = constraintAnchor6.mTarget;
            if (constraintAnchor7 != null && r8 != constraintWidget7) {
                margin += constraintAnchor7.getMargin();
            }
            int i10 = margin;
            if (!z3 || r8 == constraintWidget7 || r8 == constraintWidget9) {
                z6 = z10;
            } else {
                z6 = z10;
                i9 = 8;
            }
            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor8 = constraintAnchor6.mTarget;
            if (constraintAnchor8 != null) {
                if (r8 == constraintWidget9) {
                    constraintWidget5 = constraintWidget11;
                    constraintWidget6 = constraintWidget7;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor8.mSolverVariable, i10, 6);
                } else {
                    constraintWidget5 = constraintWidget11;
                    constraintWidget6 = constraintWidget7;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor8.mSolverVariable, i10, 8);
                }
                linearSystem.addEquality(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i10, (!z5 || z3) ? i9 : 5);
            } else {
                constraintWidget5 = constraintWidget11;
                constraintWidget6 = constraintWidget7;
            }
            if (z7) {
                if (r8.getVisibility() == 8 || r8.mListDimensionBehaviors[i] != dimensionBehaviour2) {
                    i6 = 0;
                } else {
                    androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr = r8.mListAnchors;
                    i6 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i2 + 1].mSolverVariable, constraintAnchorArr[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(r8.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i6, 8);
            }
            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor9 = r8.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor9 != null) {
                ?? r2 = constraintAnchor9.mOwner;
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor10 = r2.mListAnchors[i2].mTarget;
                if (constraintAnchor10 != null && constraintAnchor10.mOwner == r8) {
                    r20 = r2;
                }
            }
            if (r20 != null) {
                r8 = r20;
                z9 = z4;
            } else {
                z9 = true;
            }
            z10 = z6;
            f = f2;
            constraintWidget11 = constraintWidget5;
            constraintWidget7 = constraintWidget6;
            r8 = r8;
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget12 = constraintWidget11;
        float f3 = f;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget13 = constraintWidget7;
        boolean z11 = z10;
        if (constraintWidget10 != null) {
            int i11 = i2 + 1;
            if (constraintWidget8.mListAnchors[i11].mTarget != null) {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor11 = constraintWidget10.mListAnchors[i11];
                if ((constraintWidget10.mListDimensionBehaviors[i] == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget10.mResolvedMatchConstraintDefault[i] == 0) && !z3) {
                    androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor12 = constraintAnchor11.mTarget;
                    if (constraintAnchor12.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor11.mSolverVariable, constraintAnchor12.mSolverVariable, -constraintAnchor11.getMargin(), 5);
                        linearSystem.addLowerThan(constraintAnchor11.mSolverVariable, constraintWidget8.mListAnchors[i11].mTarget.mSolverVariable, -constraintAnchor11.getMargin(), 6);
                        if (z7) {
                            int i12 = i2 + 1;
                            androidx.constraintlayout.solver.SolverVariable solverVariable6 = constraintWidgetContainer.mListAnchors[i12].mSolverVariable;
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor13 = constraintWidget8.mListAnchors[i12];
                            linearSystem.addGreaterThan(solverVariable6, constraintAnchor13.mSolverVariable, constraintAnchor13.getMargin(), 8);
                        }
                        arrayList = chainHead.mWeightedMatchConstraintsWidgets;
                        if (arrayList != null && (size = arrayList.size()) > 1) {
                            float f4 = (chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f3 : chainHead.mWidgetsMatchCount;
                            float f5 = 0.0f;
                            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget14 = null;
                            i5 = 0;
                            float f6 = 0.0f;
                            while (i5 < size) {
                                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget15 = arrayList.get(i5);
                                float f7 = constraintWidget15.mWeight[i];
                                if (f7 < f5) {
                                    if (chainHead.mHasComplexMatchWeights) {
                                        androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr2 = constraintWidget15.mListAnchors;
                                        linearSystem.addEquality(constraintAnchorArr2[i2 + 1].mSolverVariable, constraintAnchorArr2[i2].mSolverVariable, 0, 4);
                                        arrayList2 = arrayList;
                                        i5++;
                                        arrayList = arrayList2;
                                        f5 = 0.0f;
                                    } else {
                                        f7 = 1.0f;
                                    }
                                }
                                if (f7 == f5) {
                                    androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr3 = constraintWidget15.mListAnchors;
                                    linearSystem.addEquality(constraintAnchorArr3[i2 + 1].mSolverVariable, constraintAnchorArr3[i2].mSolverVariable, 0, 8);
                                    arrayList2 = arrayList;
                                    i5++;
                                    arrayList = arrayList2;
                                    f5 = 0.0f;
                                } else {
                                    if (constraintWidget14 != null) {
                                        androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr4 = constraintWidget14.mListAnchors;
                                        androidx.constraintlayout.solver.SolverVariable solverVariable7 = constraintAnchorArr4[i2].mSolverVariable;
                                        int i13 = i2 + 1;
                                        androidx.constraintlayout.solver.SolverVariable solverVariable8 = constraintAnchorArr4[i13].mSolverVariable;
                                        androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr5 = constraintWidget15.mListAnchors;
                                        androidx.constraintlayout.solver.SolverVariable solverVariable9 = constraintAnchorArr5[i2].mSolverVariable;
                                        androidx.constraintlayout.solver.SolverVariable solverVariable10 = constraintAnchorArr5[i13].mSolverVariable;
                                        arrayList2 = arrayList;
                                        androidx.constraintlayout.solver.ArrayRow createRow = linearSystem.createRow();
                                        createRow.createRowEqualMatchDimensions(f6, f4, f7, solverVariable7, solverVariable8, solverVariable9, solverVariable10);
                                        linearSystem.addConstraint(createRow);
                                    } else {
                                        arrayList2 = arrayList;
                                    }
                                    constraintWidget14 = constraintWidget15;
                                    f6 = f7;
                                    i5++;
                                    arrayList = arrayList2;
                                    f5 = 0.0f;
                                }
                            }
                        }
                        if (constraintWidget9 == null && (constraintWidget9 == constraintWidget10 || z3)) {
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor14 = constraintWidget13.mListAnchors[i2];
                            int i14 = i2 + 1;
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor15 = constraintWidget8.mListAnchors[i14];
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor16 = constraintAnchor14.mTarget;
                            androidx.constraintlayout.solver.SolverVariable solverVariable11 = constraintAnchor16 != null ? constraintAnchor16.mSolverVariable : null;
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor17 = constraintAnchor15.mTarget;
                            androidx.constraintlayout.solver.SolverVariable solverVariable12 = constraintAnchor17 != null ? constraintAnchor17.mSolverVariable : null;
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor18 = constraintWidget9.mListAnchors[i2];
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor19 = constraintWidget10.mListAnchors[i14];
                            if (solverVariable11 != null && solverVariable12 != null) {
                                linearSystem.addCentering(constraintAnchor18.mSolverVariable, solverVariable11, constraintAnchor18.getMargin(), i == 0 ? constraintWidget12.mHorizontalBiasPercent : constraintWidget12.mVerticalBiasPercent, solverVariable12, constraintAnchor19.mSolverVariable, constraintAnchor19.getMargin(), 7);
                            }
                        } else if (z11 || constraintWidget9 == null) {
                            int i15 = 8;
                            if (z8 && constraintWidget9 != null) {
                                int i16 = chainHead.mWidgetsMatchCount;
                                boolean z12 = i16 <= 0 && chainHead.mWidgetsCount == i16;
                                constraintWidget = constraintWidget9;
                                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget16 = constraintWidget;
                                while (constraintWidget != null) {
                                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget17 = constraintWidget.mNextChainWidget[i];
                                    while (constraintWidget17 != null && constraintWidget17.getVisibility() == i15) {
                                        constraintWidget17 = constraintWidget17.mNextChainWidget[i];
                                    }
                                    if (constraintWidget == constraintWidget9 || constraintWidget == constraintWidget10 || constraintWidget17 == null) {
                                        constraintWidget2 = constraintWidget16;
                                        i4 = 8;
                                    } else {
                                        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget18 = constraintWidget17 == constraintWidget10 ? null : constraintWidget17;
                                        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor20 = constraintWidget.mListAnchors[i2];
                                        androidx.constraintlayout.solver.SolverVariable solverVariable13 = constraintAnchor20.mSolverVariable;
                                        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor21 = constraintAnchor20.mTarget;
                                        if (constraintAnchor21 != null) {
                                            androidx.constraintlayout.solver.SolverVariable solverVariable14 = constraintAnchor21.mSolverVariable;
                                        }
                                        int i17 = i2 + 1;
                                        androidx.constraintlayout.solver.SolverVariable solverVariable15 = constraintWidget16.mListAnchors[i17].mSolverVariable;
                                        int margin2 = constraintAnchor20.getMargin();
                                        int margin3 = constraintWidget.mListAnchors[i17].getMargin();
                                        if (constraintWidget18 != null) {
                                            constraintAnchor4 = constraintWidget18.mListAnchors[i2];
                                            solverVariable = constraintAnchor4.mSolverVariable;
                                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor22 = constraintAnchor4.mTarget;
                                            solverVariable2 = constraintAnchor22 != null ? constraintAnchor22.mSolverVariable : null;
                                        } else {
                                            constraintAnchor4 = constraintWidget10.mListAnchors[i2];
                                            solverVariable = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                                            solverVariable2 = constraintWidget.mListAnchors[i17].mSolverVariable;
                                        }
                                        if (constraintAnchor4 != null) {
                                            margin3 += constraintAnchor4.getMargin();
                                        }
                                        int i18 = margin3;
                                        int margin4 = constraintWidget16.mListAnchors[i17].getMargin() + margin2;
                                        int i19 = z12 ? 8 : 4;
                                        if (solverVariable13 == null || solverVariable15 == null || solverVariable == null || solverVariable2 == null) {
                                            constraintWidget3 = constraintWidget18;
                                            constraintWidget2 = constraintWidget16;
                                            i4 = 8;
                                        } else {
                                            constraintWidget3 = constraintWidget18;
                                            constraintWidget2 = constraintWidget16;
                                            i4 = 8;
                                            linearSystem.addCentering(solverVariable13, solverVariable15, margin4, 0.5f, solverVariable, solverVariable2, i18, i19);
                                        }
                                        constraintWidget17 = constraintWidget3;
                                    }
                                    if (constraintWidget.getVisibility() == i4) {
                                        constraintWidget = constraintWidget2;
                                    }
                                    constraintWidget16 = constraintWidget;
                                    i15 = 8;
                                    constraintWidget = constraintWidget17;
                                }
                                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor23 = constraintWidget9.mListAnchors[i2];
                                constraintAnchor = constraintWidget13.mListAnchors[i2].mTarget;
                                int i20 = i2 + 1;
                                constraintAnchor2 = constraintWidget10.mListAnchors[i20];
                                constraintAnchor3 = constraintWidget8.mListAnchors[i20].mTarget;
                                if (constraintAnchor != null) {
                                    i3 = 5;
                                } else if (constraintWidget9 != constraintWidget10) {
                                    i3 = 5;
                                    linearSystem.addEquality(constraintAnchor23.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor23.getMargin(), 5);
                                } else {
                                    i3 = 5;
                                    if (constraintAnchor3 != null) {
                                        linearSystem.addCentering(constraintAnchor23.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor23.getMargin(), 0.5f, constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor2.getMargin(), 5);
                                    }
                                }
                                if (constraintAnchor3 != null && constraintWidget9 != constraintWidget10) {
                                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
                                }
                            }
                        } else {
                            int i21 = chainHead.mWidgetsMatchCount;
                            boolean z13 = i21 > 0 && chainHead.mWidgetsCount == i21;
                            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget19 = constraintWidget9;
                            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget20 = constraintWidget19;
                            while (constraintWidget19 != null) {
                                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget21 = constraintWidget19.mNextChainWidget[i];
                                while (constraintWidget21 != null && constraintWidget21.getVisibility() == 8) {
                                    constraintWidget21 = constraintWidget21.mNextChainWidget[i];
                                }
                                if (constraintWidget21 != null || constraintWidget19 == constraintWidget10) {
                                    androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor24 = constraintWidget19.mListAnchors[i2];
                                    androidx.constraintlayout.solver.SolverVariable solverVariable16 = constraintAnchor24.mSolverVariable;
                                    androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor25 = constraintAnchor24.mTarget;
                                    androidx.constraintlayout.solver.SolverVariable solverVariable17 = constraintAnchor25 != null ? constraintAnchor25.mSolverVariable : null;
                                    if (constraintWidget20 != constraintWidget19) {
                                        solverVariable17 = constraintWidget20.mListAnchors[i2 + 1].mSolverVariable;
                                    } else if (constraintWidget19 == constraintWidget9 && constraintWidget20 == constraintWidget19) {
                                        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor26 = constraintWidget13.mListAnchors[i2].mTarget;
                                        solverVariable17 = constraintAnchor26 != null ? constraintAnchor26.mSolverVariable : null;
                                    }
                                    int margin5 = constraintAnchor24.getMargin();
                                    int i22 = i2 + 1;
                                    int margin6 = constraintWidget19.mListAnchors[i22].getMargin();
                                    if (constraintWidget21 != null) {
                                        constraintAnchor5 = constraintWidget21.mListAnchors[i2];
                                        androidx.constraintlayout.solver.SolverVariable solverVariable18 = constraintAnchor5.mSolverVariable;
                                        solverVariable4 = constraintWidget19.mListAnchors[i22].mSolverVariable;
                                        solverVariable3 = solverVariable18;
                                    } else {
                                        constraintAnchor5 = constraintWidget8.mListAnchors[i22].mTarget;
                                        solverVariable3 = constraintAnchor5 != null ? constraintAnchor5.mSolverVariable : null;
                                        solverVariable4 = constraintWidget19.mListAnchors[i22].mSolverVariable;
                                    }
                                    if (constraintAnchor5 != null) {
                                        margin6 += constraintAnchor5.getMargin();
                                    }
                                    if (constraintWidget20 != null) {
                                        margin5 += constraintWidget20.mListAnchors[i22].getMargin();
                                    }
                                    if (solverVariable16 != null && solverVariable17 != null && solverVariable3 != null && solverVariable4 != null) {
                                        if (constraintWidget19 == constraintWidget9) {
                                            margin5 = constraintWidget9.mListAnchors[i2].getMargin();
                                        }
                                        int i23 = margin5;
                                        constraintWidget4 = constraintWidget21;
                                        linearSystem.addCentering(solverVariable16, solverVariable17, i23, 0.5f, solverVariable3, solverVariable4, constraintWidget19 == constraintWidget10 ? constraintWidget10.mListAnchors[i22].getMargin() : margin6, z13 ? 8 : 5);
                                        if (constraintWidget19.getVisibility() == 8) {
                                            constraintWidget20 = constraintWidget19;
                                        }
                                        constraintWidget19 = constraintWidget4;
                                    }
                                }
                                constraintWidget4 = constraintWidget21;
                                if (constraintWidget19.getVisibility() == 8) {
                                }
                                constraintWidget19 = constraintWidget4;
                            }
                        }
                        if ((z11 && !z8) || constraintWidget9 == null || constraintWidget9 == constraintWidget10) {
                            return;
                        }
                        androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr6 = constraintWidget9.mListAnchors;
                        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor27 = constraintAnchorArr6[i2];
                        int i24 = i2 + 1;
                        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor28 = constraintWidget10.mListAnchors[i24];
                        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor29 = constraintAnchor27.mTarget;
                        solverVariable5 = constraintAnchor29 != null ? constraintAnchor29.mSolverVariable : null;
                        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor30 = constraintAnchor28.mTarget;
                        androidx.constraintlayout.solver.SolverVariable solverVariable19 = constraintAnchor30 != null ? constraintAnchor30.mSolverVariable : null;
                        if (constraintWidget8 != constraintWidget10) {
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor31 = constraintWidget8.mListAnchors[i24].mTarget;
                            solverVariable19 = constraintAnchor31 != null ? constraintAnchor31.mSolverVariable : null;
                        }
                        if (constraintWidget9 == constraintWidget10) {
                            constraintAnchor28 = constraintAnchorArr6[i24];
                        }
                        if (solverVariable5 == null || solverVariable19 == null) {
                            return;
                        }
                        linearSystem.addCentering(constraintAnchor27.mSolverVariable, solverVariable5, constraintAnchor27.getMargin(), 0.5f, solverVariable19, constraintAnchor28.mSolverVariable, constraintWidget10.mListAnchors[i24].getMargin(), 5);
                        return;
                    }
                }
                if (z3) {
                    androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor32 = constraintAnchor11.mTarget;
                    if (constraintAnchor32.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor11.mSolverVariable, constraintAnchor32.mSolverVariable, -constraintAnchor11.getMargin(), 4);
                    }
                }
                linearSystem.addLowerThan(constraintAnchor11.mSolverVariable, constraintWidget8.mListAnchors[i11].mTarget.mSolverVariable, -constraintAnchor11.getMargin(), 6);
                if (z7) {
                }
                arrayList = chainHead.mWeightedMatchConstraintsWidgets;
                if (arrayList != null) {
                    if (chainHead.mHasUndefinedWeights) {
                    }
                    float f52 = 0.0f;
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget142 = null;
                    i5 = 0;
                    float f62 = 0.0f;
                    while (i5 < size) {
                    }
                }
                if (constraintWidget9 == null) {
                }
                if (z11) {
                }
                int i152 = 8;
                if (z8) {
                    int i162 = chainHead.mWidgetsMatchCount;
                    if (i162 <= 0) {
                    }
                    constraintWidget = constraintWidget9;
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget162 = constraintWidget;
                    while (constraintWidget != null) {
                    }
                    androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor232 = constraintWidget9.mListAnchors[i2];
                    constraintAnchor = constraintWidget13.mListAnchors[i2].mTarget;
                    int i202 = i2 + 1;
                    constraintAnchor2 = constraintWidget10.mListAnchors[i202];
                    constraintAnchor3 = constraintWidget8.mListAnchors[i202].mTarget;
                    if (constraintAnchor != null) {
                    }
                    if (constraintAnchor3 != null) {
                        linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
                    }
                }
                if (z11) {
                }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr62 = constraintWidget9.mListAnchors;
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor272 = constraintAnchorArr62[i2];
                int i242 = i2 + 1;
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor282 = constraintWidget10.mListAnchors[i242];
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor292 = constraintAnchor272.mTarget;
                if (constraintAnchor292 != null) {
                }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor302 = constraintAnchor282.mTarget;
                if (constraintAnchor302 != null) {
                }
                if (constraintWidget8 != constraintWidget10) {
                }
                if (constraintWidget9 == constraintWidget10) {
                }
                if (solverVariable5 == null) {
                    return;
                } else {
                    return;
                }
            }
        }
        if (z7) {
        }
        arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null) {
        }
        if (constraintWidget9 == null) {
        }
        if (z11) {
        }
        int i1522 = 8;
        if (z8) {
        }
        if (z11) {
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr622 = constraintWidget9.mListAnchors;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2722 = constraintAnchorArr622[i2];
        int i2422 = i2 + 1;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2822 = constraintWidget10.mListAnchors[i2422];
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2922 = constraintAnchor2722.mTarget;
        if (constraintAnchor2922 != null) {
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3022 = constraintAnchor2822.mTarget;
        if (constraintAnchor3022 != null) {
        }
        if (constraintWidget8 != constraintWidget10) {
        }
        if (constraintWidget9 == constraintWidget10) {
        }
        if (solverVariable5 == null) {
        }
    }

    public static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem linearSystem, java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> arrayList, int i) {
        int i2;
        androidx.constraintlayout.solver.widgets.ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i3 = 2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            androidx.constraintlayout.solver.widgets.ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }
}
