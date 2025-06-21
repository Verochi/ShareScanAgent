package androidx.constraintlayout.solver.state;

/* loaded from: classes.dex */
public interface Reference {
    void apply();

    androidx.constraintlayout.solver.widgets.ConstraintWidget getConstraintWidget();

    java.lang.Object getKey();

    void setConstraintWidget(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget);

    void setKey(java.lang.Object obj);
}
