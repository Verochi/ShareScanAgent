package org.apache.tools.ant.taskdefs.optional;

/* loaded from: classes25.dex */
public class ReplaceRegExp extends org.apache.tools.ant.Task {
    public static final org.apache.tools.ant.util.FileUtils C = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public org.apache.tools.ant.types.resources.Union x;
    public boolean A = false;
    public java.lang.String B = null;
    public java.io.File u = null;
    public java.lang.String v = "";
    public boolean w = false;
    public org.apache.tools.ant.types.RegularExpression y = null;
    public org.apache.tools.ant.types.Substitution z = null;

    public void addConfigured(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (!resourceCollection.isFilesystemOnly()) {
            throw new org.apache.tools.ant.BuildException("only filesystem resources are supported");
        }
        if (this.x == null) {
            this.x = new org.apache.tools.ant.types.resources.Union();
        }
        this.x.add(resourceCollection);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        addConfigured(fileSet);
    }

    public final boolean c(java.io.Reader reader, java.io.Writer writer, int i) throws java.io.IOException {
        return d(org.apache.tools.ant.util.FileUtils.safeReadFully(reader), writer, i);
    }

    public org.apache.tools.ant.types.RegularExpression createRegexp() {
        if (this.y != null) {
            throw new org.apache.tools.ant.BuildException("Only one regular expression is allowed.");
        }
        org.apache.tools.ant.types.RegularExpression regularExpression = new org.apache.tools.ant.types.RegularExpression();
        this.y = regularExpression;
        return regularExpression;
    }

    public org.apache.tools.ant.types.Substitution createSubstitution() {
        if (this.z != null) {
            throw new org.apache.tools.ant.BuildException("Only one substitution expression is allowed");
        }
        org.apache.tools.ant.types.Substitution substitution = new org.apache.tools.ant.types.Substitution();
        this.z = substitution;
        return substitution;
    }

    public final boolean d(java.lang.String str, java.io.Writer writer, int i) throws java.io.IOException {
        writer.write(doReplace(this.y, this.z, str, i));
        return !r5.equals(str);
    }

    public java.lang.String doReplace(org.apache.tools.ant.types.RegularExpression regularExpression, org.apache.tools.ant.types.Substitution substitution, java.lang.String str, int i) {
        org.apache.tools.ant.util.regexp.Regexp regexp = regularExpression.getRegexp(getProject());
        if (!regexp.matches(str, i)) {
            return str;
        }
        log("Found match; substituting", 4);
        return regexp.substitute(str, substitution.getExpression(getProject()), i);
    }

    public void doReplace(java.io.File file, int i) throws java.io.IOException {
        boolean c;
        int read;
        java.io.File createTempFile = C.createTempFile(getProject(), org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_REPLACE, ".txt", null, true, true);
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            try {
                java.io.Reader inputStreamReader = this.B != null ? new java.io.InputStreamReader(fileInputStream, this.B) : new java.io.InputStreamReader(fileInputStream);
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(createTempFile);
                try {
                    java.io.Writer outputStreamWriter = this.B != null ? new java.io.OutputStreamWriter(fileOutputStream, this.B) : new java.io.OutputStreamWriter(fileOutputStream);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Replacing pattern '");
                    sb.append(this.y.getPattern(getProject()));
                    sb.append("' with '");
                    sb.append(this.z.getExpression(getProject()));
                    sb.append("' in '");
                    sb.append(file.getPath());
                    sb.append("'");
                    java.lang.String str = "";
                    sb.append(this.w ? " by line" : "");
                    if (this.v.length() > 0) {
                        str = " with flags: '" + this.v + "'";
                    }
                    sb.append(str);
                    sb.append(".");
                    log(sb.toString(), 3);
                    if (this.w) {
                        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(inputStreamReader);
                        java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(outputStreamWriter);
                        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                        boolean z = false;
                        c = false;
                        do {
                            read = bufferedReader.read();
                            if (read == 13) {
                                if (z) {
                                    c |= d(stringBuffer.toString(), bufferedWriter, i);
                                    bufferedWriter.write(13);
                                    stringBuffer = new java.lang.StringBuffer();
                                } else {
                                    z = true;
                                }
                            } else if (read == 10) {
                                c |= d(stringBuffer.toString(), bufferedWriter, i);
                                if (z) {
                                    bufferedWriter.write(13);
                                    z = false;
                                }
                                bufferedWriter.write(10);
                                stringBuffer = new java.lang.StringBuffer();
                            } else {
                                if (z || read < 0) {
                                    c |= d(stringBuffer.toString(), bufferedWriter, i);
                                    if (z) {
                                        bufferedWriter.write(13);
                                        z = false;
                                    }
                                    stringBuffer = new java.lang.StringBuffer();
                                }
                                if (read >= 0) {
                                    stringBuffer.append((char) read);
                                }
                            }
                        } while (read >= 0);
                        outputStreamWriter = bufferedWriter;
                        inputStreamReader = bufferedReader;
                    } else {
                        c = c(inputStreamReader, outputStreamWriter, i);
                    }
                    inputStreamReader.close();
                    outputStreamWriter.close();
                    if (c) {
                        log("File has changed; saving the updated file", 3);
                        try {
                            long lastModified = file.lastModified();
                            org.apache.tools.ant.util.FileUtils fileUtils = C;
                            fileUtils.rename(createTempFile, file);
                            if (this.A) {
                                fileUtils.setFileLastModified(file, lastModified);
                            }
                            createTempFile = null;
                        } catch (java.io.IOException e) {
                            throw new org.apache.tools.ant.BuildException("Couldn't rename temporary file " + createTempFile, e, getLocation());
                        }
                    } else {
                        log("No change made", 4);
                    }
                } finally {
                    fileOutputStream.close();
                }
            } finally {
                fileInputStream.close();
            }
        } finally {
            if (createTempFile != null) {
                createTempFile.delete();
            }
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.y == null) {
            throw new org.apache.tools.ant.BuildException("No expression to match.");
        }
        if (this.z == null) {
            throw new org.apache.tools.ant.BuildException("Nothing to replace expression with.");
        }
        if (this.u != null && this.x != null) {
            throw new org.apache.tools.ant.BuildException("You cannot supply the 'file' attribute and resource collections at the same time.");
        }
        int asOptions = org.apache.tools.ant.util.regexp.RegexpUtil.asOptions(this.v);
        java.io.File file = this.u;
        if (file != null && file.exists()) {
            try {
                doReplace(this.u, asOptions);
            } catch (java.io.IOException e) {
                log("An error occurred processing file: '" + this.u.getAbsolutePath() + "': " + e.toString(), 0);
            }
        } else if (this.u != null) {
            log("The following file is missing: '" + this.u.getAbsolutePath() + "'", 0);
        }
        org.apache.tools.ant.types.resources.Union union = this.x;
        if (union != null) {
            java.util.Iterator<org.apache.tools.ant.types.Resource> it = union.iterator();
            while (it.hasNext()) {
                java.io.File file2 = ((org.apache.tools.ant.types.resources.FileProvider) it.next().as(org.apache.tools.ant.types.resources.FileProvider.class)).getFile();
                if (file2.exists()) {
                    try {
                        doReplace(file2, asOptions);
                    } catch (java.lang.Exception e2) {
                        log("An error occurred processing file: '" + file2.getAbsolutePath() + "': " + e2.toString(), 0);
                    }
                } else {
                    log("The following file is missing: '" + file2.getAbsolutePath() + "'", 0);
                }
            }
        }
    }

    @java.lang.Deprecated
    public void setByLine(java.lang.String str) {
        java.lang.Boolean valueOf = java.lang.Boolean.valueOf(str);
        if (valueOf == null) {
            valueOf = java.lang.Boolean.FALSE;
        }
        this.w = valueOf.booleanValue();
    }

    public void setByLine(boolean z) {
        this.w = z;
    }

    public void setEncoding(java.lang.String str) {
        this.B = str;
    }

    public void setFile(java.io.File file) {
        this.u = file;
    }

    public void setFlags(java.lang.String str) {
        this.v = str;
    }

    public void setMatch(java.lang.String str) {
        if (this.y != null) {
            throw new org.apache.tools.ant.BuildException("Only one regular expression is allowed");
        }
        org.apache.tools.ant.types.RegularExpression regularExpression = new org.apache.tools.ant.types.RegularExpression();
        this.y = regularExpression;
        regularExpression.setPattern(str);
    }

    public void setPreserveLastModified(boolean z) {
        this.A = z;
    }

    public void setReplace(java.lang.String str) {
        if (this.z != null) {
            throw new org.apache.tools.ant.BuildException("Only one substitution expression is allowed");
        }
        org.apache.tools.ant.types.Substitution substitution = new org.apache.tools.ant.types.Substitution();
        this.z = substitution;
        substitution.setExpression(str);
    }
}
