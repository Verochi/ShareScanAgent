package org.apache.tools.ant.dispatch;

/* loaded from: classes25.dex */
public abstract class DispatchTask extends org.apache.tools.ant.Task implements org.apache.tools.ant.dispatch.Dispatchable {
    public java.lang.String u;

    public java.lang.String getAction() {
        return this.u;
    }

    @Override // org.apache.tools.ant.dispatch.Dispatchable
    public java.lang.String getActionParameterName() {
        return "action";
    }

    public void setAction(java.lang.String str) {
        this.u = str;
    }
}
