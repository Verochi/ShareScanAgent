package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class LogOutputResource extends org.apache.tools.ant.types.Resource implements org.apache.tools.ant.types.resources.Appendable {
    public org.apache.tools.ant.taskdefs.LogOutputStream y;

    public LogOutputResource(org.apache.tools.ant.ProjectComponent projectComponent) {
        super("[Ant log]");
        this.y = new org.apache.tools.ant.taskdefs.LogOutputStream(projectComponent);
    }

    public LogOutputResource(org.apache.tools.ant.ProjectComponent projectComponent, int i) {
        super("[Ant log]");
        this.y = new org.apache.tools.ant.taskdefs.LogOutputStream(projectComponent, i);
    }

    @Override // org.apache.tools.ant.types.resources.Appendable
    public java.io.OutputStream getAppendOutputStream() throws java.io.IOException {
        return this.y;
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.io.OutputStream getOutputStream() throws java.io.IOException {
        return this.y;
    }
}
