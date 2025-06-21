package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class ExtensionPoint extends org.apache.tools.ant.Target {
    public ExtensionPoint() {
    }

    public ExtensionPoint(org.apache.tools.ant.Target target) {
        super(target);
    }

    @Override // org.apache.tools.ant.Target
    public final void addDataType(org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable) {
        throw new org.apache.tools.ant.BuildException("you must not nest child elements into an extension-point");
    }

    @Override // org.apache.tools.ant.Target, org.apache.tools.ant.TaskContainer
    public final void addTask(org.apache.tools.ant.Task task) {
        throw new org.apache.tools.ant.BuildException("you must not nest child elements into an extension-point");
    }
}
