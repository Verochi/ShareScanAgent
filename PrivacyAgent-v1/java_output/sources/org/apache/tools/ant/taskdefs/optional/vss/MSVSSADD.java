package org.apache.tools.ant.taskdefs.optional.vss;

/* loaded from: classes25.dex */
public class MSVSSADD extends org.apache.tools.ant.taskdefs.optional.vss.MSVSS {
    public java.lang.String U = null;

    @Override // org.apache.tools.ant.taskdefs.optional.vss.MSVSS
    public org.apache.tools.ant.types.Commandline buildCmdLine() {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        if (getLocalpath() == null) {
            throw new org.apache.tools.ant.BuildException("localPath attribute must be set!", getLocation());
        }
        commandline.setExecutable(getSSCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.COMMAND_ADD);
        commandline.createArgument().setValue(getLocalpath());
        commandline.createArgument().setValue(getAutoresponse());
        commandline.createArgument().setValue(getRecursive());
        commandline.createArgument().setValue(getWritable());
        commandline.createArgument().setValue(getLogin());
        commandline.createArgument().setValue(getComment());
        return commandline;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.vss.MSVSS
    public java.lang.String getLocalpath() {
        return this.U;
    }

    public void setAutoresponse(java.lang.String str) {
        super.setInternalAutoResponse(str);
    }

    public void setComment(java.lang.String str) {
        super.setInternalComment(str);
    }

    public void setLocalpath(org.apache.tools.ant.types.Path path) {
        this.U = path.toString();
    }

    public void setRecursive(boolean z) {
        super.setInternalRecursive(z);
    }

    public final void setWritable(boolean z) {
        super.setInternalWritable(z);
    }
}
