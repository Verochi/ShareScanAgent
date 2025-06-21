package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Echo extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.types.Resource w;
    protected java.lang.String message = "";
    protected java.io.File file = null;
    protected boolean append = false;
    public java.lang.String u = "";
    public boolean v = false;
    protected int logLevel = 1;

    public static class EchoLevel extends org.apache.tools.ant.types.LogLevel {
    }

    public void addText(java.lang.String str) {
        this.message += getProject().replaceProperties(str);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        try {
            org.apache.tools.ant.types.resources.StringResource stringResource = new org.apache.tools.ant.types.resources.StringResource("".equals(this.message) ? org.apache.tools.ant.util.StringUtils.LINE_SEP : this.message);
            org.apache.tools.ant.types.Resource resource = this.w;
            if (resource == null) {
                resource = new org.apache.tools.ant.types.resources.LogOutputResource(this, this.logLevel);
            }
            org.apache.tools.ant.util.ResourceUtils.copyResource(stringResource, resource, null, null, false, false, this.append, null, "".equals(this.u) ? null : this.u, getProject(), this.v);
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e, getLocation());
        }
    }

    public void setAppend(boolean z) {
        this.append = z;
    }

    public void setEncoding(java.lang.String str) {
        this.u = str;
    }

    public void setFile(java.io.File file) {
        setOutput(new org.apache.tools.ant.types.resources.FileResource(getProject(), file));
    }

    public void setForce(boolean z) {
        this.v = z;
    }

    public void setLevel(org.apache.tools.ant.taskdefs.Echo.EchoLevel echoLevel) {
        this.logLevel = echoLevel.getLevel();
    }

    public void setMessage(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        this.message = str;
    }

    public void setOutput(org.apache.tools.ant.types.Resource resource) {
        if (this.w != null) {
            throw new org.apache.tools.ant.BuildException("Cannot set > 1 output target");
        }
        this.w = resource;
        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
        this.file = fileProvider != null ? fileProvider.getFile() : null;
    }
}
