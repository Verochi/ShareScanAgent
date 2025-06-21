package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Sequential extends org.apache.tools.ant.Task implements org.apache.tools.ant.TaskContainer {
    public java.util.Vector u = new java.util.Vector();

    @Override // org.apache.tools.ant.TaskContainer
    public void addTask(org.apache.tools.ant.Task task) {
        this.u.addElement(task);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.property.LocalProperties localProperties = org.apache.tools.ant.property.LocalProperties.get(getProject());
        localProperties.enterScope();
        try {
            java.util.Iterator it = this.u.iterator();
            while (it.hasNext()) {
                ((org.apache.tools.ant.Task) it.next()).perform();
            }
        } finally {
            localProperties.exitScope();
        }
    }
}
