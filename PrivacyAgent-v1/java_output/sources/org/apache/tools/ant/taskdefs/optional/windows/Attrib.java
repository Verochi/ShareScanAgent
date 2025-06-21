package org.apache.tools.ant.taskdefs.optional.windows;

/* loaded from: classes25.dex */
public class Attrib extends org.apache.tools.ant.taskdefs.ExecuteOn {
    public boolean W = false;

    public Attrib() {
        super.setExecutable("attrib");
        super.setParallel(false);
    }

    public static java.lang.String j(boolean z) {
        return z ? "+" : com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteOn, org.apache.tools.ant.taskdefs.ExecTask
    public void checkConfiguration() {
        if (!k()) {
            throw new org.apache.tools.ant.BuildException("Missing attribute parameter", getLocation());
        }
        super.checkConfiguration();
    }

    public final void i(boolean z, java.lang.String str) {
        createArg().setValue(j(z) + str);
        this.W = true;
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public boolean isValidOs() {
        return (getOs() == null && getOsFamily() == null) ? org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS) : super.isValidOs();
    }

    public final boolean k() {
        return this.W;
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteOn
    public void setAddsourcefile(boolean z) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the addsourcefile attribute", getLocation());
    }

    public void setArchive(boolean z) {
        i(z, androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
    }

    public void setCommand(java.lang.String str) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the command attribute", getLocation());
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public void setExecutable(java.lang.String str) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the executable attribute", getLocation());
    }

    public void setFile(java.io.File file) {
        org.apache.tools.ant.types.FileSet fileSet = new org.apache.tools.ant.types.FileSet();
        fileSet.setFile(file);
        addFileset(fileSet);
    }

    public void setHidden(boolean z) {
        i(z, "H");
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteOn
    public void setMaxParallel(int i) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the maxparallel attribute", getLocation());
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteOn
    public void setParallel(boolean z) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the parallel attribute", getLocation());
    }

    public void setReadonly(boolean z) {
        i(z, "R");
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteOn
    public void setSkipEmptyFilesets(boolean z) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the skipemptyfileset attribute", getLocation());
    }

    public void setSystem(boolean z) {
        i(z, androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH);
    }
}
