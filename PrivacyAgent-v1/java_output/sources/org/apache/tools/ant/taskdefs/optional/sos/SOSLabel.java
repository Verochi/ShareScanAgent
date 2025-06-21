package org.apache.tools.ant.taskdefs.optional.sos;

/* loaded from: classes25.dex */
public class SOSLabel extends org.apache.tools.ant.taskdefs.optional.sos.SOS {
    @Override // org.apache.tools.ant.taskdefs.optional.sos.SOS
    public org.apache.tools.ant.types.Commandline buildCmdLine() {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        this.commandLine = commandline;
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_COMMAND);
        this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.COMMAND_LABEL);
        getRequiredAttributes();
        if (getLabel() == null) {
            throw new org.apache.tools.ant.BuildException("label attribute must be set!", getLocation());
        }
        this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_LABEL);
        this.commandLine.createArgument().setValue(getLabel());
        this.commandLine.createArgument().setValue(getVerbose());
        if (getComment() != null) {
            this.commandLine.createArgument().setValue("-log");
            this.commandLine.createArgument().setValue(getComment());
        }
        return this.commandLine;
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
