package org.apache.tools.ant.taskdefs.optional.vss;

/* loaded from: classes25.dex */
public abstract class MSVSS extends org.apache.tools.ant.Task implements org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants {
    public java.lang.String u = null;
    public java.lang.String v = null;
    public java.lang.String w = null;
    public java.lang.String x = null;
    public java.lang.String y = null;
    public java.lang.String z = null;
    public java.lang.String A = null;
    public java.lang.String B = null;
    public java.lang.String C = null;
    public java.lang.String D = null;
    public java.lang.String E = null;
    public java.lang.String F = null;
    public java.lang.String G = null;
    public java.lang.String H = null;
    public java.lang.String I = null;
    public java.lang.String J = null;
    public java.lang.String K = null;
    public boolean L = false;
    public boolean M = false;
    public boolean N = false;
    public boolean O = true;
    public boolean P = true;
    public int Q = Integer.MIN_VALUE;
    public java.text.DateFormat R = java.text.DateFormat.getDateInstance(3);
    public org.apache.tools.ant.taskdefs.optional.vss.MSVSS.CurrentModUpdated S = null;
    public org.apache.tools.ant.taskdefs.optional.vss.MSVSS.WritableFiles T = null;

    public static class CurrentModUpdated extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.TIME_CURRENT, org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.TIME_MODIFIED, org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.TIME_UPDATED};
        }
    }

    public static class WritableFiles extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_REPLACE, org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP, "fail"};
        }
    }

    public abstract org.apache.tools.ant.types.Commandline buildCmdLine();

    public final java.lang.String c(java.lang.String str, int i) throws java.text.ParseException {
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar();
        gregorianCalendar.setTime(this.R.parse(str));
        gregorianCalendar.add(5, i);
        return this.R.format(gregorianCalendar.getTime());
    }

    public final java.lang.String d(org.apache.tools.ant.types.Commandline commandline) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(commandline.toString());
        int indexOf = stringBuffer.substring(0).indexOf("-Y");
        if (indexOf > 0) {
            int indexOf2 = stringBuffer.substring(0).indexOf(",", indexOf);
            int indexOf3 = stringBuffer.substring(0).indexOf(" ", indexOf2);
            while (true) {
                indexOf2++;
                if (indexOf2 >= indexOf3) {
                    break;
                }
                stringBuffer.setCharAt(indexOf2, '*');
            }
        }
        return stringBuffer.toString();
    }

    public final boolean e() {
        if (getWritableFiles().equals(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP)) {
            return false;
        }
        return this.O;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Commandline buildCmdLine = buildCmdLine();
        int run = run(buildCmdLine);
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run) && e()) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + d(buildCmdLine) + " With a return code of " + run, getLocation());
        }
    }

    public final java.lang.String f() {
        java.lang.String str = this.A;
        if (str == null || str.length() <= 31) {
            return this.A;
        }
        java.lang.String substring = this.A.substring(0, 30);
        log("Label is longer than 31 characters, truncated to: " + substring, 1);
        return substring;
    }

    public java.lang.String getAutoresponse() {
        java.lang.String str = this.B;
        return str == null ? org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_AUTORESPONSE_DEF : str.equalsIgnoreCase("Y") ? org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_AUTORESPONSE_YES : this.B.equalsIgnoreCase("N") ? org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_AUTORESPONSE_NO : org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_AUTORESPONSE_DEF;
    }

    public java.lang.String getComment() {
        if (this.D == null) {
            return "-C-";
        }
        return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_COMMENT + this.D;
    }

    public java.lang.String getFileTimeStamp() {
        org.apache.tools.ant.taskdefs.optional.vss.MSVSS.CurrentModUpdated currentModUpdated = this.S;
        return currentModUpdated == null ? "" : currentModUpdated.getValue().equals(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.TIME_MODIFIED) ? org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_FILETIME_MODIFIED : this.S.getValue().equals(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.TIME_UPDATED) ? org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_FILETIME_UPDATED : org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_FILETIME_DEF;
    }

    public java.lang.String getGetLocalCopy() {
        return !this.P ? org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_NO_GET : "";
    }

    public java.lang.String getLabel() {
        java.lang.String str = this.A;
        if (str == null || str.length() <= 0) {
            return "";
        }
        return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_LABEL + f();
    }

    public java.lang.String getLocalpath() {
        if (this.C == null) {
            return "";
        }
        java.io.File resolveFile = getProject().resolveFile(this.C);
        if (!resolveFile.exists()) {
            if (!(resolveFile.mkdirs() || resolveFile.exists())) {
                throw new org.apache.tools.ant.BuildException("Directory " + this.C + " creation was not successful for an unknown reason", getLocation());
            }
            getProject().log("Created dir: " + resolveFile.getAbsolutePath());
        }
        return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_OVERRIDE_WORKING_DIR + this.C;
    }

    public java.lang.String getLogin() {
        if (this.v == null) {
            return "";
        }
        return "-Y" + this.v;
    }

    public java.lang.String getOutput() {
        if (this.G == null) {
            return "";
        }
        return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_OUTPUT + this.G;
    }

    public java.lang.String getQuiet() {
        return this.L ? org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_QUIET : "";
    }

    public java.lang.String getRecursive() {
        return this.M ? org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_RECURSION : "";
    }

    public java.lang.String getSSCommand() {
        java.lang.StringBuilder sb;
        java.lang.String str = this.u;
        if (str == null) {
            return "ss";
        }
        java.lang.String str2 = java.io.File.separator;
        if (str.endsWith(str2)) {
            sb = new java.lang.StringBuilder();
            str2 = this.u;
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(this.u);
        }
        sb.append(str2);
        sb.append("ss");
        return sb.toString();
    }

    public java.lang.String getStyle() {
        java.lang.String str = this.K;
        return str != null ? str : "";
    }

    public java.lang.String getUser() {
        if (this.H == null) {
            return "";
        }
        return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_USER + this.H;
    }

    public java.lang.String getVersion() {
        if (this.y == null) {
            return "";
        }
        return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_VERSION + this.y;
    }

    public java.lang.String getVersionDate() throws org.apache.tools.ant.BuildException {
        java.lang.StringBuilder sb;
        java.lang.String str;
        java.lang.String str2 = this.I;
        if (str2 == null && this.J == null && this.Q == Integer.MIN_VALUE) {
            return "";
        }
        if (str2 != null && this.J != null) {
            return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_VERSION_DATE + this.J + org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.VALUE_FROMDATE + this.I;
        }
        if (this.J != null && this.Q != Integer.MIN_VALUE) {
            try {
                return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_VERSION_DATE + this.J + org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.VALUE_FROMDATE + c(this.J, this.Q);
            } catch (java.text.ParseException unused) {
                throw new org.apache.tools.ant.BuildException("Error parsing date: " + this.J, getLocation());
            }
        }
        if (str2 == null || this.Q == Integer.MIN_VALUE) {
            if (str2 != null) {
                sb = new java.lang.StringBuilder();
                sb.append("-V~d");
                str = this.I;
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_VERSION_DATE);
                str = this.J;
            }
            sb.append(str);
            return sb.toString();
        }
        try {
            return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_VERSION_DATE + c(this.I, this.Q) + org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.VALUE_FROMDATE + this.I;
        } catch (java.text.ParseException unused2) {
            throw new org.apache.tools.ant.BuildException("Error parsing date: " + this.I, getLocation());
        }
    }

    public java.lang.String getVersionDateLabel() {
        if (this.y != null) {
            return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_VERSION + this.y;
        }
        if (this.z != null) {
            return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_VERSION_DATE + this.z;
        }
        java.lang.String f = f();
        if (f == null || f.equals("")) {
            return "";
        }
        return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_VERSION_LABEL + f;
    }

    public java.lang.String getVersionLabel() {
        java.lang.String str = this.E;
        if (str == null && this.F == null) {
            return "";
        }
        if (str != null && this.F != null) {
            if (str.length() > 31) {
                this.E = this.E.substring(0, 30);
                log("FromLabel is longer than 31 characters, truncated to: " + this.E, 1);
            }
            if (this.F.length() > 31) {
                this.F = this.F.substring(0, 30);
                log("ToLabel is longer than 31 characters, truncated to: " + this.F, 1);
            }
            return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_VERSION_LABEL + this.F + org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.VALUE_FROMLABEL + this.E;
        }
        if (str != null) {
            if (str.length() > 31) {
                this.E = this.E.substring(0, 30);
                log("FromLabel is longer than 31 characters, truncated to: " + this.E, 1);
            }
            return "-V~L" + this.E;
        }
        if (this.F.length() > 31) {
            this.F = this.F.substring(0, 30);
            log("ToLabel is longer than 31 characters, truncated to: " + this.F, 1);
        }
        return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_VERSION_LABEL + this.F;
    }

    public java.lang.String getVsspath() {
        return this.w;
    }

    public java.lang.String getWritable() {
        return this.N ? org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_WRITABLE : "";
    }

    public java.lang.String getWritableFiles() {
        org.apache.tools.ant.taskdefs.optional.vss.MSVSS.WritableFiles writableFiles = this.T;
        if (writableFiles == null) {
            return "";
        }
        if (writableFiles.getValue().equals(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_REPLACE)) {
            return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_REPLACE_WRITABLE;
        }
        if (!this.T.getValue().equals(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP)) {
            return "";
        }
        this.O = false;
        return org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_SKIP_WRITABLE;
    }

    public final int run(org.apache.tools.ant.types.Commandline commandline) {
        try {
            org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) this, 2, 1));
            if (this.x != null) {
                java.lang.String[] environment = execute.getEnvironment();
                if (environment == null) {
                    environment = new java.lang.String[0];
                }
                java.lang.String[] strArr = new java.lang.String[environment.length + 1];
                java.lang.System.arraycopy(environment, 0, strArr, 0, environment.length);
                strArr[environment.length] = "SSDIR=" + this.x;
                execute.setEnvironment(strArr);
            }
            execute.setAntRun(getProject());
            execute.setWorkingDirectory(getProject().getBaseDir());
            execute.setCommandline(commandline.getCommandline());
            execute.setVMLauncher(false);
            return execute.execute();
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e, getLocation());
        }
    }

    public final void setFailOnError(boolean z) {
        this.O = z;
    }

    public void setInternalAutoResponse(java.lang.String str) {
        this.B = str;
    }

    public void setInternalComment(java.lang.String str) {
        this.D = str;
    }

    public void setInternalDate(java.lang.String str) {
        this.z = str;
    }

    public void setInternalDateFormat(java.text.DateFormat dateFormat) {
        this.R = dateFormat;
    }

    public void setInternalFailOnError(boolean z) {
        this.O = z;
    }

    public void setInternalFileTimeStamp(org.apache.tools.ant.taskdefs.optional.vss.MSVSS.CurrentModUpdated currentModUpdated) {
        this.S = currentModUpdated;
    }

    public void setInternalFromDate(java.lang.String str) {
        this.I = str;
    }

    public void setInternalFromLabel(java.lang.String str) {
        this.E = str;
    }

    public void setInternalGetLocalCopy(boolean z) {
        this.P = z;
    }

    public void setInternalLabel(java.lang.String str) {
        this.A = str;
    }

    public void setInternalLocalPath(java.lang.String str) {
        this.C = str;
    }

    public void setInternalNumDays(int i) {
        this.Q = i;
    }

    public void setInternalOutputFilename(java.lang.String str) {
        this.G = str;
    }

    public void setInternalQuiet(boolean z) {
        this.L = z;
    }

    public void setInternalRecursive(boolean z) {
        this.M = z;
    }

    public void setInternalStyle(java.lang.String str) {
        this.K = str;
    }

    public void setInternalToDate(java.lang.String str) {
        this.J = str;
    }

    public void setInternalToLabel(java.lang.String str) {
        this.F = str;
    }

    public void setInternalUser(java.lang.String str) {
        this.H = str;
    }

    public void setInternalVersion(java.lang.String str) {
        this.y = str;
    }

    public void setInternalWritable(boolean z) {
        this.N = z;
    }

    public void setInternalWritableFiles(org.apache.tools.ant.taskdefs.optional.vss.MSVSS.WritableFiles writableFiles) {
        this.T = writableFiles;
    }

    public final void setLogin(java.lang.String str) {
        this.v = str;
    }

    public final void setServerpath(java.lang.String str) {
        this.x = str;
    }

    public final void setSsdir(java.lang.String str) {
        this.u = org.apache.tools.ant.util.FileUtils.translatePath(str);
    }

    public final void setVsspath(java.lang.String str) {
        if (str.startsWith("vss://")) {
            str = str.substring(5);
        }
        if (str.startsWith("$")) {
            this.w = str;
            return;
        }
        this.w = "$" + str;
    }
}
