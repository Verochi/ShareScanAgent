package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
public class WidgetGroup {
    private static final boolean DEBUG = false;
    static int count;
    int id;
    int orientation;
    java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> widgets = new java.util.ArrayList<>();
    boolean authoritative = false;
    java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup.MeasureResult> results = null;
    private int moveTo = -1;

    public class MeasureResult {
        int baseline;
        int bottom;
        int left;
        int orientation;
        int right;
        int top;
        java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintWidget> widgetRef;

        public MeasureResult(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.LinearSystem linearSystem, int i) {
            this.widgetRef = new java.lang.ref.WeakReference<>(constraintWidget);
            this.left = linearSystem.getObjectVariableValue(constraintWidget.mLeft);
            this.top = linearSystem.getObjectVariableValue(constraintWidget.mTop);
            this.right = linearSystem.getObjectVariableValue(constraintWidget.mRight);
            this.bottom = linearSystem.getObjectVariableValue(constraintWidget.mBottom);
            this.baseline = linearSystem.getObjectVariableValue(constraintWidget.mBaseline);
            this.orientation = i;
        }

        public void apply() {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.widgetRef.get();
            if (constraintWidget != null) {
                constraintWidget.setFinalFrame(this.left, this.top, this.right, this.bottom, this.baseline, this.orientation);
            }
        }
    }

    public WidgetGroup(int i) {
        int i2 = count;
        count = i2 + 1;
        this.id = i2;
        this.orientation = i;
    }

    private boolean contains(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        return this.widgets.contains(constraintWidget);
    }

    private java.lang.String getOrientationString() {
        int i = this.orientation;
        return i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown";
    }

    private int measureWrap(int i, androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(i);
        if (dimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED) {
            return i == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight();
        }
        return -1;
    }

    private int solverMeasure(androidx.constraintlayout.solver.LinearSystem linearSystem, java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> arrayList, int i) {
        int objectVariableValue;
        int objectVariableValue2;
        androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) arrayList.get(0).getParent();
        linearSystem.reset();
        constraintWidgetContainer.addToSolver(linearSystem, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).addToSolver(linearSystem, false);
        }
        if (i == 0 && constraintWidgetContainer.mHorizontalChainsSize > 0) {
            androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i == 1 && constraintWidgetContainer.mVerticalChainsSize > 0) {
            androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.minimize();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        this.results = new java.util.ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.results.add(new androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup.MeasureResult(arrayList.get(i3), linearSystem, i));
        }
        if (i == 0) {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mLeft);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mRight);
            linearSystem.reset();
        } else {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mTop);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mBottom);
            linearSystem.reset();
        }
        return objectVariableValue2 - objectVariableValue;
    }

    public boolean add(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        if (this.widgets.contains(constraintWidget)) {
            return false;
        }
        this.widgets.add(constraintWidget);
        return true;
    }

    public void apply() {
        if (this.results != null && this.authoritative) {
            for (int i = 0; i < this.results.size(); i++) {
                this.results.get(i).apply();
            }
        }
    }

    public void cleanup(java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup> arrayList) {
        int size = this.widgets.size();
        if (this.moveTo != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup = arrayList.get(i);
                if (this.moveTo == widgetGroup.id) {
                    moveTo(this.orientation, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void clear() {
        this.widgets.clear();
    }

    public int getId() {
        return this.id;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean intersectWith(androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup) {
        for (int i = 0; i < this.widgets.size(); i++) {
            if (widgetGroup.contains(this.widgets.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isAuthoritative() {
        return this.authoritative;
    }

    public int measureWrap(androidx.constraintlayout.solver.LinearSystem linearSystem, int i) {
        if (this.widgets.size() == 0) {
            return 0;
        }
        return solverMeasure(linearSystem, this.widgets, i);
    }

    public void moveTo(int i, androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup widgetGroup) {
        java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it = this.widgets.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget next = it.next();
            widgetGroup.add(next);
            if (i == 0) {
                next.horizontalGroup = widgetGroup.getId();
            } else {
                next.verticalGroup = widgetGroup.getId();
            }
        }
        this.moveTo = widgetGroup.id;
    }

    public void setAuthoritative(boolean z) {
        this.authoritative = z;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public int size() {
        return this.widgets.size();
    }

    public java.lang.String toString() {
        java.lang.String str = getOrientationString() + " [" + this.id + "] <";
        java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it = this.widgets.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().getDebugName();
        }
        return str + " >";
    }
}
