package androidx.constraintlayout.solver.widgets;

/* loaded from: classes.dex */
public class WidgetContainer extends androidx.constraintlayout.solver.widgets.ConstraintWidget {
    public java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> mChildren;

    public WidgetContainer() {
        this.mChildren = new java.util.ArrayList<>();
    }

    public WidgetContainer(int i, int i2) {
        super(i, i2);
        this.mChildren = new java.util.ArrayList<>();
    }

    public WidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mChildren = new java.util.ArrayList<>();
    }

    public void add(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        this.mChildren.add(constraintWidget);
        if (constraintWidget.getParent() != null) {
            ((androidx.constraintlayout.solver.widgets.WidgetContainer) constraintWidget.getParent()).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    public void add(androidx.constraintlayout.solver.widgets.ConstraintWidget... constraintWidgetArr) {
        for (androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget : constraintWidgetArr) {
            add(constraintWidget);
        }
    }

    public java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer getRootConstraintContainer() {
        androidx.constraintlayout.solver.widgets.ConstraintWidget parent = getParent();
        androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer = this instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer ? (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) this : null;
        while (parent != null) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget parent2 = parent.getParent();
            if (parent instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) {
                constraintWidgetContainer = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) parent;
            }
            parent = parent2;
        }
        return constraintWidgetContainer;
    }

    public void layout() {
        java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> arrayList = this.mChildren;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.WidgetContainer) {
                ((androidx.constraintlayout.solver.widgets.WidgetContainer) constraintWidget).layout();
            }
        }
    }

    public void remove(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        this.mChildren.remove(constraintWidget);
        constraintWidget.reset();
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void resetSolverVariables(androidx.constraintlayout.solver.Cache cache) {
        super.resetSolverVariables(cache);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).resetSolverVariables(cache);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setOffset(int i, int i2) {
        super.setOffset(i, i2);
        int size = this.mChildren.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mChildren.get(i3).setOffset(getRootX(), getRootY());
        }
    }
}
