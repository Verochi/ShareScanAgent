package org.apache.tools.ant.taskdefs.optional.vss;

/* loaded from: classes25.dex */
public class MSVSSCP extends org.apache.tools.ant.taskdefs.optional.vss.MSVSS {
    @Override // org.apache.tools.ant.taskdefs.optional.vss.MSVSS
    public org.apache.tools.ant.types.Commandline buildCmdLine() {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        if (getVsspath() == null) {
            throw new org.apache.tools.ant.BuildException("vsspath attribute must be set!", getLocation());
        }
        commandline.setExecutable(getSSCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.COMMAND_CP);
        commandline.createArgument().setValue(getVsspath());
        commandline.createArgument().setValue(getAutoresponse());
        commandline.createArgument().setValue(getLogin());
        return commandline;
    }

    public void setAutoresponse(java.lang.String str) {
        super.setInternalAutoResponse(str);
    }
}
