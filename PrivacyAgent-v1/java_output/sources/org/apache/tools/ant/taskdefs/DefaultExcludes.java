package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class DefaultExcludes extends org.apache.tools.ant.Task {
    public java.lang.String u = "";
    public java.lang.String v = "";
    public boolean w = false;
    public boolean x = false;
    public int y = 1;

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (!this.w && this.u.equals("") && this.v.equals("") && !this.x) {
            throw new org.apache.tools.ant.BuildException("<defaultexcludes> task must set at least one attribute (echo=\"false\" doesn't count since that is the default");
        }
        if (this.w) {
            org.apache.tools.ant.DirectoryScanner.resetDefaultExcludes();
        }
        if (!this.u.equals("")) {
            org.apache.tools.ant.DirectoryScanner.addDefaultExclude(this.u);
        }
        if (!this.v.equals("")) {
            org.apache.tools.ant.DirectoryScanner.removeDefaultExclude(this.v);
        }
        if (this.x) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("Current Default Excludes:");
            stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
            for (java.lang.String str : org.apache.tools.ant.DirectoryScanner.getDefaultExcludes()) {
                stringBuffer.append("  ");
                stringBuffer.append(str);
                stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
            }
            log(stringBuffer.toString(), this.y);
        }
    }

    public void setAdd(java.lang.String str) {
        this.u = str;
    }

    public void setDefault(boolean z) {
        this.w = z;
    }

    public void setEcho(boolean z) {
        this.x = z;
    }

    public void setRemove(java.lang.String str) {
        this.v = str;
    }
}
