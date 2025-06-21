package org.apache.tools.ant.taskdefs.optional.vss;

/* loaded from: classes25.dex */
public class MSVSSLABEL extends org.apache.tools.ant.taskdefs.optional.vss.MSVSS {
    @Override // org.apache.tools.ant.taskdefs.optional.vss.MSVSS
    public org.apache.tools.ant.types.Commandline buildCmdLine() {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        if (getVsspath() == null) {
            throw new org.apache.tools.ant.BuildException("vsspath attribute must be set!", getLocation());
        }
        java.lang.String label = getLabel();
        if (label.equals("")) {
            throw new org.apache.tools.ant.BuildException("label attribute must be set!", getLocation());
        }
        commandline.setExecutable(getSSCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.COMMAND_LABEL);
        commandline.createArgument().setValue(getVsspath());
        commandline.createArgument().setValue(getComment());
        commandline.createArgument().setValue(getAutoresponse());
        commandline.createArgument().setValue(label);
        commandline.createArgument().setValue(getVersion());
        commandline.createArgument().setValue(getLogin());
        return commandline;
    }

    public void setAutoresponse(java.lang.String str) {
        super.setInternalAutoResponse(str);
    }

    public void setComment(java.lang.String str) {
        super.setInternalComment(str);
    }

    public void setLabel(java.lang.String str) {
        super.setInternalLabel(str);
    }

    public void setVersion(java.lang.String str) {
        super.setInternalVersion(str);
    }
}
