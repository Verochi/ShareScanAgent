package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class BuildEvent extends java.util.EventObject {
    private static final long serialVersionUID = 4538050075952288486L;
    private java.lang.Throwable exception;
    private java.lang.String message;
    private int priority;
    private final org.apache.tools.ant.Project project;
    private final org.apache.tools.ant.Target target;
    private final org.apache.tools.ant.Task task;

    public BuildEvent(org.apache.tools.ant.Project project) {
        super(project);
        this.priority = 3;
        this.project = project;
        this.target = null;
        this.task = null;
    }

    public BuildEvent(org.apache.tools.ant.Target target) {
        super(target);
        this.priority = 3;
        this.project = target.getProject();
        this.target = target;
        this.task = null;
    }

    public BuildEvent(org.apache.tools.ant.Task task) {
        super(task);
        this.priority = 3;
        this.project = task.getProject();
        this.target = task.getOwningTarget();
        this.task = task;
    }

    public java.lang.Throwable getException() {
        return this.exception;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public int getPriority() {
        return this.priority;
    }

    public org.apache.tools.ant.Project getProject() {
        return this.project;
    }

    public org.apache.tools.ant.Target getTarget() {
        return this.target;
    }

    public org.apache.tools.ant.Task getTask() {
        return this.task;
    }

    public void setException(java.lang.Throwable th) {
        this.exception = th;
    }

    public void setMessage(java.lang.String str, int i) {
        this.message = str;
        this.priority = i;
    }
}
