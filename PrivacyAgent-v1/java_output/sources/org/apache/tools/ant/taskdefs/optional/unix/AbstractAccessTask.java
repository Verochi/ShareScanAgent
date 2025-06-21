package org.apache.tools.ant.taskdefs.optional.unix;

/* loaded from: classes25.dex */
public abstract class AbstractAccessTask extends org.apache.tools.ant.taskdefs.ExecuteOn {
    public AbstractAccessTask() {
        super.setParallel(true);
        super.setSkipEmptyFilesets(true);
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public boolean isValidOs() {
        return (getOs() == null && getOsFamily() == null) ? org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX) : super.isValidOs();
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteOn
    public void setAddsourcefile(boolean z) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the addsourcefile attribute", getLocation());
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public void setCommand(org.apache.tools.ant.types.Commandline commandline) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the command attribute", getLocation());
    }

    public void setFile(java.io.File file) {
        org.apache.tools.ant.types.FileSet fileSet = new org.apache.tools.ant.types.FileSet();
        fileSet.setFile(file);
        addFileset(fileSet);
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteOn
    public void setSkipEmptyFilesets(boolean z) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the skipemptyfileset attribute", getLocation());
    }
}
