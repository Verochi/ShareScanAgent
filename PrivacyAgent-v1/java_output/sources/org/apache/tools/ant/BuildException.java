package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class BuildException extends java.lang.RuntimeException {
    private static final long serialVersionUID = -5419014565354664240L;
    private org.apache.tools.ant.Location location;

    public BuildException() {
        this.location = org.apache.tools.ant.Location.UNKNOWN_LOCATION;
    }

    public BuildException(java.lang.String str) {
        super(str);
        this.location = org.apache.tools.ant.Location.UNKNOWN_LOCATION;
    }

    public BuildException(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.location = org.apache.tools.ant.Location.UNKNOWN_LOCATION;
    }

    public BuildException(java.lang.String str, java.lang.Throwable th, org.apache.tools.ant.Location location) {
        this(str, th);
        this.location = location;
    }

    public BuildException(java.lang.String str, org.apache.tools.ant.Location location) {
        super(str);
        org.apache.tools.ant.Location location2 = org.apache.tools.ant.Location.UNKNOWN_LOCATION;
        this.location = location;
    }

    public BuildException(java.lang.Throwable th) {
        super(th);
        this.location = org.apache.tools.ant.Location.UNKNOWN_LOCATION;
    }

    public BuildException(java.lang.Throwable th, org.apache.tools.ant.Location location) {
        this(th);
        this.location = location;
    }

    @java.lang.Deprecated
    public java.lang.Throwable getException() {
        return getCause();
    }

    public org.apache.tools.ant.Location getLocation() {
        return this.location;
    }

    public void setLocation(org.apache.tools.ant.Location location) {
        this.location = location;
    }

    @Override // java.lang.Throwable
    public java.lang.String toString() {
        return this.location.toString() + getMessage();
    }
}
