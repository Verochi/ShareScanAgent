package androidx.constraintlayout.solver.state;

/* loaded from: classes.dex */
public class HelperReference {
    private androidx.constraintlayout.solver.widgets.HelperWidget mHelperWidget;
    protected java.util.ArrayList<java.lang.Object> mReferences = new java.util.ArrayList<>();
    protected final androidx.constraintlayout.solver.state.State mState;
    final androidx.constraintlayout.solver.state.State.Helper mType;

    public HelperReference(androidx.constraintlayout.solver.state.State state, androidx.constraintlayout.solver.state.State.Helper helper) {
        this.mState = state;
        this.mType = helper;
    }

    public androidx.constraintlayout.solver.state.HelperReference add(java.lang.Object... objArr) {
        for (java.lang.Object obj : objArr) {
            this.mReferences.add(obj);
        }
        return this;
    }

    public void apply() {
    }

    public androidx.constraintlayout.solver.widgets.HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }

    public androidx.constraintlayout.solver.state.State.Helper getType() {
        return this.mType;
    }

    public void setHelperWidget(androidx.constraintlayout.solver.widgets.HelperWidget helperWidget) {
        this.mHelperWidget = helperWidget;
    }
}
