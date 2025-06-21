package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class ExitStatusException extends org.apache.tools.ant.BuildException {
    private static final long serialVersionUID = 7760846806886585968L;
    private int status;

    public ExitStatusException(int i) {
        this.status = i;
    }

    public ExitStatusException(java.lang.String str, int i) {
        super(str);
        this.status = i;
    }

    public ExitStatusException(java.lang.String str, int i, org.apache.tools.ant.Location location) {
        super(str, location);
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }
}
