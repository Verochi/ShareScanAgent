package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Taskdef extends org.apache.tools.ant.taskdefs.Typedef {
    public Taskdef() {
        setAdapterClass(org.apache.tools.ant.TaskAdapter.class);
        setAdaptToClass(org.apache.tools.ant.Task.class);
    }
}
