package org.apache.tools.ant.taskdefs.optional.vss;

/* loaded from: classes25.dex */
public class MSVSSGET extends org.apache.tools.ant.taskdefs.optional.vss.MSVSS {
    @Override // org.apache.tools.ant.taskdefs.optional.vss.MSVSS
    public org.apache.tools.ant.types.Commandline buildCmdLine() {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        commandline.setExecutable(getSSCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.COMMAND_GET);
        if (getVsspath() == null) {
            throw new org.apache.tools.ant.BuildException("vsspath attribute must be set!", getLocation());
        }
        commandline.createArgument().setValue(getVsspath());
        commandline.createArgument().setValue(getLocalpath());
        commandline.createArgument().setValue(getAutoresponse());
        commandline.createArgument().setValue(getQuiet());
        commandline.createArgument().setValue(getRecursive());
        commandline.createArgument().setValue(getVersionDateLabel());
        commandline.createArgument().setValue(getWritable());
        commandline.createArgument().setValue(getLogin());
        commandline.createArgument().setValue(getFileTimeStamp());
        commandline.createArgument().setValue(getWritableFiles());
        return commandline;
    }

    public void setAutoresponse(java.lang.String str) {
        super.setInternalAutoResponse(str);
    }

    public void setDate(java.lang.String str) {
        super.setInternalDate(str);
    }

    public void setFileTimeStamp(org.apache.tools.ant.taskdefs.optional.vss.MSVSS.CurrentModUpdated currentModUpdated) {
        super.setInternalFileTimeStamp(currentModUpdated);
    }

    public void setLabel(java.lang.String str) {
        super.setInternalLabel(str);
    }

    public void setLocalpath(org.apache.tools.ant.types.Path path) {
        super.setInternalLocalPath(path.toString());
    }

    public final void setQuiet(boolean z) {
        super.setInternalQuiet(z);
    }

    public final void setRecursive(boolean z) {
        super.setInternalRecursive(z);
    }

    public void setVersion(java.lang.String str) {
        super.setInternalVersion(str);
    }

    public final void setWritable(boolean z) {
        super.setInternalWritable(z);
    }

    public void setWritableFiles(org.apache.tools.ant.taskdefs.optional.vss.MSVSS.WritableFiles writableFiles) {
        super.setInternalWritableFiles(writableFiles);
    }
}
