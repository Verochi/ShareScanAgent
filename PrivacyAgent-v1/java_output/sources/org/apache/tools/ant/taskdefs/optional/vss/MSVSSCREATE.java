package org.apache.tools.ant.taskdefs.optional.vss;

/* loaded from: classes25.dex */
public class MSVSSCREATE extends org.apache.tools.ant.taskdefs.optional.vss.MSVSS {
    @Override // org.apache.tools.ant.taskdefs.optional.vss.MSVSS
    public org.apache.tools.ant.types.Commandline buildCmdLine() {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        if (getVsspath() == null) {
            throw new org.apache.tools.ant.BuildException("vsspath attribute must be set!", getLocation());
        }
        commandline.setExecutable(getSSCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.COMMAND_CREATE);
        commandline.createArgument().setValue(getVsspath());
        commandline.createArgument().setValue(getComment());
        commandline.createArgument().setValue(getAutoresponse());
        commandline.createArgument().setValue(getQuiet());
        commandline.createArgument().setValue(getLogin());
        return commandline;
    }

    public void setAutoresponse(java.lang.String str) {
        super.setInternalAutoResponse(str);
    }

    public void setComment(java.lang.String str) {
        super.setInternalComment(str);
    }

    public final void setQuiet(boolean z) {
        super.setInternalQuiet(z);
    }
}
