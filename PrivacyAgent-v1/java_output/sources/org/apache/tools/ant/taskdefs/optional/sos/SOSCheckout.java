package org.apache.tools.ant.taskdefs.optional.sos;

/* loaded from: classes25.dex */
public class SOSCheckout extends org.apache.tools.ant.taskdefs.optional.sos.SOS {
    @Override // org.apache.tools.ant.taskdefs.optional.sos.SOS
    public org.apache.tools.ant.types.Commandline buildCmdLine() {
        this.commandLine = new org.apache.tools.ant.types.Commandline();
        if (getFilename() != null) {
            this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_COMMAND);
            this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.COMMAND_CHECKOUT_FILE);
            this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_FILE);
            this.commandLine.createArgument().setValue(getFilename());
        } else {
            this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_COMMAND);
            this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.COMMAND_CHECKOUT_PROJECT);
            this.commandLine.createArgument().setValue(getRecursive());
        }
        getRequiredAttributes();
        getOptionalAttributes();
        return this.commandLine;
    }

    public final void setFile(java.lang.String str) {
        super.setInternalFilename(str);
    }

    public void setRecursive(boolean z) {
        super.setInternalRecursive(z);
    }
}
