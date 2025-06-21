package org.apache.tools.ant.taskdefs.optional.sos;

/* loaded from: classes25.dex */
public class SOSGet extends org.apache.tools.ant.taskdefs.optional.sos.SOS {
    @Override // org.apache.tools.ant.taskdefs.optional.sos.SOS
    public org.apache.tools.ant.types.Commandline buildCmdLine() {
        this.commandLine = new org.apache.tools.ant.types.Commandline();
        if (getFilename() != null) {
            this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_COMMAND);
            this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.COMMAND_GET_FILE);
            this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_FILE);
            this.commandLine.createArgument().setValue(getFilename());
            if (getVersion() != null) {
                this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_VERSION);
                this.commandLine.createArgument().setValue(getVersion());
            }
        } else {
            this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_COMMAND);
            this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.COMMAND_GET_PROJECT);
            this.commandLine.createArgument().setValue(getRecursive());
            if (getLabel() != null) {
                this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_LABEL);
                this.commandLine.createArgument().setValue(getLabel());
            }
        }
        getRequiredAttributes();
        getOptionalAttributes();
        return this.commandLine;
    }

    public final void setFile(java.lang.String str) {
        super.setInternalFilename(str);
    }

    public void setLabel(java.lang.String str) {
        super.setInternalLabel(str);
    }

    public void setRecursive(boolean z) {
        super.setInternalRecursive(z);
    }

    public void setVersion(java.lang.String str) {
        super.setInternalVersion(str);
    }
}
