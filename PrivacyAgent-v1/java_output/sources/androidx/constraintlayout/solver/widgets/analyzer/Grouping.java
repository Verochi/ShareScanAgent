package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
public class Grouping {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_GROUPING = false;

    public static androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup findDependents(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, int i, java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup> arrayList, androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup) {
        int findGroupInDependents;
        int i2 = i == 0 ? constraintWidget.horizontalGroup : constraintWidget.verticalGroup;
        if (i2 != -1 && (widgetGroup == null || i2 != widgetGroup.id)) {
            int i3 = 0;
            while (true) {
                if (i3 >= arrayList.size()) {
                    break;
                }
                androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup2 = arrayList.get(i3);
                if (widgetGroup2.getId() == i2) {
                    if (widgetGroup != null) {
                        widgetGroup.moveTo(i, widgetGroup2);
                        arrayList.remove(widgetGroup);
                    }
                    widgetGroup = widgetGroup2;
                } else {
                    i3++;
                }
            }
        } else if (i2 != -1) {
            return widgetGroup;
        }
        if (widgetGroup == null) {
            if ((constraintWidget instanceof androidx.constraintlayout.solver.widgets.HelperWidget) && (findGroupInDependents = ((androidx.constraintlayout.solver.widgets.HelperWidget) constraintWidget).findGroupInDependents(i)) != -1) {
                int i4 = 0;
                while (true) {
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup3 = arrayList.get(i4);
                    if (widgetGroup3.getId() == findGroupInDependents) {
                        widgetGroup = widgetGroup3;
                        break;
                    }
                    i4++;
                }
            }
            if (widgetGroup == null) {
                widgetGroup = new androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup(i);
            }
            arrayList.add(widgetGroup);
        }
        if (widgetGroup.add(constraintWidget)) {
            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                androidx.constraintlayout.solver.widgets.Guideline guideline = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget;
                guideline.getAnchor().findDependents(guideline.getOrientation() == 0 ? 1 : 0, arrayList, widgetGroup);
            }
            if (i == 0) {
                constraintWidget.horizontalGroup = widgetGroup.getId();
                constraintWidget.mLeft.findDependents(i, arrayList, widgetGroup);
                constraintWidget.mRight.findDependents(i, arrayList, widgetGroup);
            } else {
                constraintWidget.verticalGroup = widgetGroup.getId();
                constraintWidget.mTop.findDependents(i, arrayList, widgetGroup);
                constraintWidget.mBaseline.findDependents(i, arrayList, widgetGroup);
                constraintWidget.mBottom.findDependents(i, arrayList, widgetGroup);
            }
            constraintWidget.mCenter.findDependents(i, arrayList, widgetGroup);
        }
        return widgetGroup;
    }

    private static androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup findGroup(java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup> arrayList, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup = arrayList.get(i2);
            if (i == widgetGroup.id) {
                return widgetGroup;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:214:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0390 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x038c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean simpleSolvingPass(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer) {
        androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup;
        androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup2;
        java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i = 0; i < size; i++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = children.get(i);
            if (!validInGroup(constraintWidgetContainer.getHorizontalDimensionBehaviour(), constraintWidgetContainer.getVerticalDimensionBehaviour(), constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getVerticalDimensionBehaviour()) || (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Flow)) {
                return false;
            }
        }
        androidx.constraintlayout.solver.Metrics metrics = constraintWidgetContainer.mMetrics;
        if (metrics != null) {
            metrics.grouping++;
        }
        java.util.ArrayList arrayList = null;
        java.util.ArrayList arrayList2 = null;
        java.util.ArrayList arrayList3 = null;
        java.util.ArrayList arrayList4 = null;
        java.util.ArrayList arrayList5 = null;
        java.util.ArrayList arrayList6 = null;
        for (int i2 = 0; i2 < size; i2++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = children.get(i2);
            if (!validInGroup(constraintWidgetContainer.getHorizontalDimensionBehaviour(), constraintWidgetContainer.getVerticalDimensionBehaviour(), constraintWidget2.getHorizontalDimensionBehaviour(), constraintWidget2.getVerticalDimensionBehaviour())) {
                androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.measure(constraintWidget2, measurer, constraintWidgetContainer.mMeasure, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS);
            }
            boolean z = constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline;
            if (z) {
                androidx.constraintlayout.solver.widgets.Guideline guideline = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget2;
                if (guideline.getOrientation() == 0) {
                    if (arrayList3 == null) {
                        arrayList3 = new java.util.ArrayList();
                    }
                    arrayList3.add(guideline);
                }
                if (guideline.getOrientation() == 1) {
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList();
                    }
                    arrayList.add(guideline);
                }
            }
            if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.HelperWidget) {
                if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                    androidx.constraintlayout.solver.widgets.Barrier barrier = (androidx.constraintlayout.solver.widgets.Barrier) constraintWidget2;
                    if (barrier.getOrientation() == 0) {
                        if (arrayList2 == null) {
                            arrayList2 = new java.util.ArrayList();
                        }
                        arrayList2.add(barrier);
                    }
                    if (barrier.getOrientation() == 1) {
                        if (arrayList4 == null) {
                            arrayList4 = new java.util.ArrayList();
                        }
                        arrayList4.add(barrier);
                    }
                } else {
                    androidx.constraintlayout.solver.widgets.HelperWidget helperWidget = (androidx.constraintlayout.solver.widgets.HelperWidget) constraintWidget2;
                    if (arrayList2 == null) {
                        arrayList2 = new java.util.ArrayList();
                    }
                    arrayList2.add(helperWidget);
                    if (arrayList4 == null) {
                        arrayList4 = new java.util.ArrayList();
                    }
                    arrayList4.add(helperWidget);
                }
            }
            if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null && !z && !(constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Barrier)) {
                if (arrayList5 == null) {
                    arrayList5 = new java.util.ArrayList();
                }
                arrayList5.add(constraintWidget2);
            }
            if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null && constraintWidget2.mBaseline.mTarget == null && !z && !(constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Barrier)) {
                if (arrayList6 == null) {
                    arrayList6 = new java.util.ArrayList();
                }
                arrayList6.add(constraintWidget2);
            }
        }
        java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup> arrayList7 = new java.util.ArrayList<>();
        if (arrayList != null) {
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                findDependents((androidx.constraintlayout.solver.widgets.Guideline) it.next(), 0, arrayList7, null);
            }
        }
        androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup3 = null;
        int i3 = 0;
        if (arrayList2 != null) {
            java.util.Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                androidx.constraintlayout.solver.widgets.HelperWidget helperWidget2 = (androidx.constraintlayout.solver.widgets.HelperWidget) it2.next();
                androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup findDependents = findDependents(helperWidget2, i3, arrayList7, widgetGroup3);
                helperWidget2.addDependents(arrayList7, i3, findDependents);
                findDependents.cleanup(arrayList7);
                widgetGroup3 = null;
                i3 = 0;
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT);
        if (anchor.getDependents() != null) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it3 = anchor.getDependents().iterator();
            while (it3.hasNext()) {
                findDependents(it3.next().mOwner, 0, arrayList7, null);
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT);
        if (anchor2.getDependents() != null) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it4 = anchor2.getDependents().iterator();
            while (it4.hasNext()) {
                findDependents(it4.next().mOwner, 0, arrayList7, null);
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor3 = constraintWidgetContainer.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER);
        if (anchor3.getDependents() != null) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it5 = anchor3.getDependents().iterator();
            while (it5.hasNext()) {
                findDependents(it5.next().mOwner, 0, arrayList7, null);
            }
        }
        androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup4 = null;
        if (arrayList5 != null) {
            java.util.Iterator it6 = arrayList5.iterator();
            while (it6.hasNext()) {
                findDependents((androidx.constraintlayout.solver.widgets.ConstraintWidget) it6.next(), 0, arrayList7, null);
            }
        }
        if (arrayList3 != null) {
            java.util.Iterator it7 = arrayList3.iterator();
            while (it7.hasNext()) {
                findDependents((androidx.constraintlayout.solver.widgets.Guideline) it7.next(), 1, arrayList7, null);
            }
        }
        if (arrayList4 != null) {
            java.util.Iterator it8 = arrayList4.iterator();
            while (it8.hasNext()) {
                androidx.constraintlayout.solver.widgets.HelperWidget helperWidget3 = (androidx.constraintlayout.solver.widgets.HelperWidget) it8.next();
                androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup findDependents2 = findDependents(helperWidget3, 1, arrayList7, widgetGroup4);
                helperWidget3.addDependents(arrayList7, 1, findDependents2);
                findDependents2.cleanup(arrayList7);
                widgetGroup4 = null;
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor4 = constraintWidgetContainer.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP);
        if (anchor4.getDependents() != null) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it9 = anchor4.getDependents().iterator();
            while (it9.hasNext()) {
                findDependents(it9.next().mOwner, 1, arrayList7, null);
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor5 = constraintWidgetContainer.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE);
        if (anchor5.getDependents() != null) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it10 = anchor5.getDependents().iterator();
            while (it10.hasNext()) {
                findDependents(it10.next().mOwner, 1, arrayList7, null);
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor6 = constraintWidgetContainer.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM);
        if (anchor6.getDependents() != null) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it11 = anchor6.getDependents().iterator();
            while (it11.hasNext()) {
                findDependents(it11.next().mOwner, 1, arrayList7, null);
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor7 = constraintWidgetContainer.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER);
        if (anchor7.getDependents() != null) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it12 = anchor7.getDependents().iterator();
            while (it12.hasNext()) {
                findDependents(it12.next().mOwner, 1, arrayList7, null);
            }
        }
        if (arrayList6 != null) {
            java.util.Iterator it13 = arrayList6.iterator();
            while (it13.hasNext()) {
                findDependents((androidx.constraintlayout.solver.widgets.ConstraintWidget) it13.next(), 1, arrayList7, null);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = children.get(i4);
            if (constraintWidget3.oppositeDimensionsTied()) {
                androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup findGroup = findGroup(arrayList7, constraintWidget3.horizontalGroup);
                androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup findGroup2 = findGroup(arrayList7, constraintWidget3.verticalGroup);
                if (findGroup != null && findGroup2 != null) {
                    findGroup.moveTo(0, findGroup2);
                    findGroup2.setOrientation(2);
                    arrayList7.remove(findGroup);
                }
            }
        }
        if (arrayList7.size() <= 1) {
            return false;
        }
        if (constraintWidgetContainer.getHorizontalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup> it14 = arrayList7.iterator();
            widgetGroup = null;
            int i5 = 0;
            while (it14.hasNext()) {
                androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup next = it14.next();
                if (next.getOrientation() != 1) {
                    next.setAuthoritative(false);
                    int measureWrap = next.measureWrap(constraintWidgetContainer.getSystem(), 0);
                    if (measureWrap > i5) {
                        widgetGroup = next;
                        i5 = measureWrap;
                    }
                }
            }
            if (widgetGroup != null) {
                constraintWidgetContainer.setHorizontalDimensionBehaviour(androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidgetContainer.setWidth(i5);
                widgetGroup.setAuthoritative(true);
                if (constraintWidgetContainer.getVerticalDimensionBehaviour() != androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup> it15 = arrayList7.iterator();
                    androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup5 = null;
                    int i6 = 0;
                    while (it15.hasNext()) {
                        androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup next2 = it15.next();
                        if (next2.getOrientation() != 0) {
                            next2.setAuthoritative(false);
                            int measureWrap2 = next2.measureWrap(constraintWidgetContainer.getSystem(), 1);
                            if (measureWrap2 > i6) {
                                widgetGroup5 = next2;
                                i6 = measureWrap2;
                            }
                        }
                    }
                    if (widgetGroup5 != null) {
                        constraintWidgetContainer.setVerticalDimensionBehaviour(androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED);
                        constraintWidgetContainer.setHeight(i6);
                        widgetGroup5.setAuthoritative(true);
                        widgetGroup2 = widgetGroup5;
                        return widgetGroup == null || widgetGroup2 != null;
                    }
                }
                widgetGroup2 = null;
                if (widgetGroup == null) {
                }
            }
        }
        widgetGroup = null;
        if (constraintWidgetContainer.getVerticalDimensionBehaviour() != androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        }
        widgetGroup2 = null;
        if (widgetGroup == null) {
        }
    }

    public static boolean validInGroup(androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        return (dimensionBehaviour3 == dimensionBehaviour7 || dimensionBehaviour3 == (dimensionBehaviour6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour3 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != dimensionBehaviour6)) || (dimensionBehaviour4 == dimensionBehaviour7 || dimensionBehaviour4 == (dimensionBehaviour5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour4 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != dimensionBehaviour5));
    }
}
