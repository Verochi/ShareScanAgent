package org.apache.tools.ant.taskdefs.optional.testing;

/* loaded from: classes25.dex */
public class BuildTimeoutException extends org.apache.tools.ant.BuildException {
    private static final long serialVersionUID = -8057644603246297562L;

    public BuildTimeoutException() {
    }

    public BuildTimeoutException(java.lang.String str) {
        super(str);
    }

    public BuildTimeoutException(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
    }

    public BuildTimeoutException(java.lang.String str, java.lang.Throwable th, org.apache.tools.ant.Location location) {
        super(str, th, location);
    }

    public BuildTimeoutException(java.lang.String str, org.apache.tools.ant.Location location) {
        super(str, location);
    }

    public BuildTimeoutException(java.lang.Throwable th) {
        super(th);
    }

    public BuildTimeoutException(java.lang.Throwable th, org.apache.tools.ant.Location location) {
        super(th, location);
    }
}
