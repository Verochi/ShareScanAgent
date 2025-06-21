package androidx.constraintlayout.solver.widgets;

/* loaded from: classes.dex */
public class HelperWidget extends androidx.constraintlayout.solver.widgets.ConstraintWidget implements androidx.constraintlayout.solver.widgets.Helper {
    public androidx.constraintlayout.solver.widgets.ConstraintWidget[] mWidgets = new androidx.constraintlayout.solver.widgets.ConstraintWidget[4];
    public int mWidgetsCount = 0;

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void add(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        if (constraintWidget == this || constraintWidget == null) {
            return;
        }
        int i = this.mWidgetsCount + 1;
        androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        if (i > constraintWidgetArr.length) {
            this.mWidgets = (androidx.constraintlayout.solver.widgets.ConstraintWidget[]) java.util.Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
        int i2 = this.mWidgetsCount;
        constraintWidgetArr2[i2] = constraintWidget;
        this.mWidgetsCount = i2 + 1;
    }

    public void addDependents(java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup> arrayList, int i, androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup) {
        for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
            widgetGroup.add(this.mWidgets[i2]);
        }
        for (int i3 = 0; i3 < this.mWidgetsCount; i3++) {
            androidx.constraintlayout.solver.widgets.analyzer.Grouping.findDependents(this.mWidgets[i3], i, arrayList, widgetGroup);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, java.util.HashMap<androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        androidx.constraintlayout.solver.widgets.HelperWidget helperWidget = (androidx.constraintlayout.solver.widgets.HelperWidget) constraintWidget;
        this.mWidgetsCount = 0;
        int i = helperWidget.mWidgetsCount;
        for (int i2 = 0; i2 < i; i2++) {
            add(hashMap.get(helperWidget.mWidgets[i2]));
        }
    }

    public int findGroupInDependents(int i) {
        int i2;
        int i3;
        for (int i4 = 0; i4 < this.mWidgetsCount; i4++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mWidgets[i4];
            if (i == 0 && (i3 = constraintWidget.horizontalGroup) != -1) {
                return i3;
            }
            if (i == 1 && (i2 = constraintWidget.verticalGroup) != -1) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void removeAllIds() {
        this.mWidgetsCount = 0;
        java.util.Arrays.fill(this.mWidgets, (java.lang.Object) null);
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer) {
    }
}
