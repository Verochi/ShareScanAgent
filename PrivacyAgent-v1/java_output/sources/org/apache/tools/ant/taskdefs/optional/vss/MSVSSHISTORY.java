package org.apache.tools.ant.taskdefs.optional.vss;

/* loaded from: classes25.dex */
public class MSVSSHISTORY extends org.apache.tools.ant.taskdefs.optional.vss.MSVSS {

    public static class BriefCodediffNofile extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.STYLE_BRIEF, org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.STYLE_CODEDIFF, org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.STYLE_NOFILE, "default"};
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.vss.MSVSS
    public org.apache.tools.ant.types.Commandline buildCmdLine() {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        if (getVsspath() == null) {
            throw new org.apache.tools.ant.BuildException("vsspath attribute must be set!", getLocation());
        }
        commandline.setExecutable(getSSCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.COMMAND_HISTORY);
        commandline.createArgument().setValue(getVsspath());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_AUTORESPONSE_DEF);
        commandline.createArgument().setValue(getVersionDate());
        commandline.createArgument().setValue(getVersionLabel());
        commandline.createArgument().setValue(getRecursive());
        commandline.createArgument().setValue(getStyle());
        commandline.createArgument().setValue(getLogin());
        commandline.createArgument().setValue(getOutput());
        return commandline;
    }

    public void setDateFormat(java.lang.String str) {
        super.setInternalDateFormat(new java.text.SimpleDateFormat(str));
    }

    public void setFromDate(java.lang.String str) {
        super.setInternalFromDate(str);
    }

    public void setFromLabel(java.lang.String str) {
        super.setInternalFromLabel(str);
    }

    public void setNumdays(int i) {
        super.setInternalNumDays(i);
    }

    public void setOutput(java.io.File file) {
        if (file != null) {
            super.setInternalOutputFilename(file.getAbsolutePath());
        }
    }

    public void setRecursive(boolean z) {
        super.setInternalRecursive(z);
    }

    public void setStyle(org.apache.tools.ant.taskdefs.optional.vss.MSVSSHISTORY.BriefCodediffNofile briefCodediffNofile) {
        java.lang.String value = briefCodediffNofile.getValue();
        if (value.equals(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.STYLE_BRIEF)) {
            super.setInternalStyle(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_BRIEF);
            return;
        }
        if (value.equals(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.STYLE_CODEDIFF)) {
            super.setInternalStyle(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_CODEDIFF);
            return;
        }
        if (value.equals("default")) {
            super.setInternalStyle("");
            return;
        }
        if (value.equals(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.STYLE_NOFILE)) {
            super.setInternalStyle(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_NO_FILE);
            return;
        }
        throw new org.apache.tools.ant.BuildException("Style " + briefCodediffNofile + " unknown.", getLocation());
    }

    public void setToDate(java.lang.String str) {
        super.setInternalToDate(str);
    }

    public void setToLabel(java.lang.String str) {
        super.setInternalToLabel(str);
    }

    public void setUser(java.lang.String str) {
        super.setInternalUser(str);
    }
}
