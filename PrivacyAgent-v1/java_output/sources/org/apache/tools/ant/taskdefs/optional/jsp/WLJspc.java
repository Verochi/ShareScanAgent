package org.apache.tools.ant.taskdefs.optional.jsp;

/* loaded from: classes25.dex */
public class WLJspc extends org.apache.tools.ant.taskdefs.MatchingTask {
    public java.io.File u;
    public java.io.File v;
    public java.lang.String w;
    public org.apache.tools.ant.types.Path x;
    public java.lang.String y = "";
    public java.util.Vector z = new java.util.Vector();

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.x == null) {
            this.x = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.x;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (!this.u.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("destination directory " + this.u.getPath() + " is not valid");
        }
        if (!this.v.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("src directory " + this.v.getPath() + " is not valid");
        }
        java.lang.String str = this.w;
        if (str == null) {
            throw new org.apache.tools.ant.BuildException("package attribute must be present.", getLocation());
        }
        this.y = str.replace('.', java.io.File.separatorChar);
        org.apache.tools.ant.DirectoryScanner directoryScanner = super.getDirectoryScanner(this.v);
        if (this.x == null) {
            this.x = new org.apache.tools.ant.types.Path(getProject());
        }
        this.x = this.x.concatSystemClasspath();
        java.lang.String[] includedFiles = directoryScanner.getIncludedFiles();
        org.apache.tools.ant.taskdefs.Java java = new org.apache.tools.ant.taskdefs.Java(this);
        java.setFork(true);
        java.setClassname("weblogic.jspc");
        java.setTaskName(getTaskName());
        java.lang.String[] strArr = new java.lang.String[12];
        strArr[0] = "-d";
        strArr[1] = this.u.getAbsolutePath().trim();
        strArr[2] = "-docroot";
        strArr[3] = this.v.getAbsolutePath().trim();
        strArr[4] = "-keepgenerated";
        strArr[5] = "-compilerclass";
        strArr[6] = "sun.tools.javac.Main";
        strArr[7] = "-classpath";
        strArr[8] = this.x.toString();
        scanDir(includedFiles);
        log("Compiling " + this.z.size() + " JSP files");
        int size = this.z.size();
        for (int i = 0; i < size; i++) {
            java.lang.String str2 = (java.lang.String) this.z.elementAt(i);
            java.io.File file = new java.io.File(str2);
            strArr[9] = "-package";
            java.lang.String parent = file.getParent();
            if (parent == null || "".equals(parent)) {
                strArr[10] = this.w;
            } else {
                strArr[10] = this.w + "._" + replaceString(parent, java.io.File.separator, "_.");
            }
            strArr[11] = this.v + java.io.File.separator + str2;
            java.clearArgs();
            for (int i2 = 0; i2 < 12; i2++) {
                java.createArg().setValue(strArr[i2]);
            }
            java.setClasspath(this.x);
            if (java.executeJava() != 0) {
                log(str2 + " failed to compile", 1);
            }
        }
    }

    public java.lang.String replaceString(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, str2, true);
        int countTokens = stringTokenizer.countTokens();
        java.lang.String str4 = "";
        for (int i = 0; i < countTokens; i++) {
            java.lang.String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals(str2)) {
                nextToken = str3;
            }
            str4 = str4 + nextToken;
        }
        return str4;
    }

    public void scanDir(java.lang.String[] strArr) {
        java.lang.String str;
        long time = new java.util.Date().getTime();
        for (int i = 0; i < strArr.length; i++) {
            java.io.File file = new java.io.File(this.v, strArr[i]);
            java.lang.String parent = new java.io.File(strArr[i]).getParent();
            if (parent == null || "".equals(parent)) {
                str = this.y;
            } else {
                java.lang.String str2 = java.io.File.separator;
                str = this.y + str2 + "_" + replaceString(parent, str2, "_/");
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            java.lang.String str3 = java.io.File.separator;
            sb.append(str3);
            sb.append("_");
            java.lang.String sb2 = sb.toString();
            int lastIndexOf = strArr[i].lastIndexOf(str3) != -1 ? strArr[i].lastIndexOf(str3) + 1 : 0;
            int indexOf = strArr[i].indexOf(".jsp");
            if (indexOf == -1) {
                log("Skipping " + strArr[i] + ". Not a JSP", 3);
            } else {
                java.io.File file2 = new java.io.File(this.u, (sb2 + strArr[i].substring(lastIndexOf, indexOf)) + ".class");
                if (file.lastModified() > time) {
                    log("Warning: file modified in the future: " + strArr[i], 1);
                }
                if (file.lastModified() > file2.lastModified()) {
                    this.z.addElement(strArr[i]);
                    log("Recompiling File " + strArr[i], 3);
                }
            }
        }
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.x;
        if (path2 == null) {
            this.x = path;
        } else {
            path2.append(path);
        }
    }

    public void setDest(java.io.File file) {
        this.u = file;
    }

    public void setPackage(java.lang.String str) {
        this.w = str;
    }

    public void setSrc(java.io.File file) {
        this.v = file;
    }
}
