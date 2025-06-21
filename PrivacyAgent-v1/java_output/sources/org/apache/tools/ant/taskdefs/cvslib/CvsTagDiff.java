package org.apache.tools.ant.taskdefs.cvslib;

/* loaded from: classes25.dex */
public class CvsTagDiff extends org.apache.tools.ant.taskdefs.AbstractCvsTask {
    public static final org.apache.tools.ant.util.FileUtils a0 = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final org.apache.tools.ant.util.DOMElementWriter b0 = new org.apache.tools.ant.util.DOMElementWriter();
    public static final int c0 = 5;
    public java.lang.String Q;
    public java.lang.String R;
    public java.lang.String S;
    public java.lang.String T;
    public java.lang.String U;
    public java.io.File V;
    public boolean W = false;
    public java.util.List X = new java.util.ArrayList();
    public java.lang.String[] Y = null;
    public int[] Z = null;

    public static java.lang.String j(java.lang.String str, java.lang.String[] strArr, int[] iArr) {
        if (str.length() < c0) {
            return null;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= strArr.length) {
                break;
            }
            if (str.startsWith(strArr[i])) {
                str = str.substring(iArr[i]);
                z = true;
                break;
            }
            i++;
        }
        return !z ? str.substring(c0) : str;
    }

    public final boolean e(java.util.Vector vector, java.lang.String str) {
        int indexOf = str.indexOf(" changed from revision ");
        if (indexOf == -1) {
            return false;
        }
        java.lang.String substring = str.substring(0, indexOf);
        int indexOf2 = str.indexOf(" to ", indexOf);
        org.apache.tools.ant.taskdefs.cvslib.CvsTagEntry cvsTagEntry = new org.apache.tools.ant.taskdefs.cvslib.CvsTagEntry(substring, str.substring(indexOf2 + 4), str.substring(indexOf + 23, indexOf2));
        vector.addElement(cvsTagEntry);
        log(cvsTagEntry.toString(), 3);
        return true;
    }

    @Override // org.apache.tools.ant.taskdefs.AbstractCvsTask, org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.File file;
        validate();
        addCommandArgument("rdiff");
        addCommandArgument("-s");
        if (this.R != null) {
            addCommandArgument("-r");
            addCommandArgument(this.R);
        } else {
            addCommandArgument(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_CODEDIFF);
            addCommandArgument(this.T);
        }
        if (this.S != null) {
            addCommandArgument("-r");
            addCommandArgument(this.S);
        } else {
            addCommandArgument(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_CODEDIFF);
            addCommandArgument(this.U);
        }
        setCommand("");
        try {
            h();
            file = a0.createTempFile(getProject(), "cvstagdiff", com.anythink.china.common.a.a.f, null, true, true);
            try {
                setOutput(file);
                super.execute();
                k(i(file));
                this.Y = null;
                this.Z = null;
                this.X.clear();
                if (file != null) {
                    file.delete();
                }
            } catch (java.lang.Throwable th) {
                th = th;
                this.Y = null;
                this.Z = null;
                this.X.clear();
                if (file != null) {
                    file.delete();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            file = null;
        }
    }

    public final boolean f(java.util.Vector vector, java.lang.String str) {
        int indexOf = str.indexOf(" is new;");
        if (indexOf == -1) {
            return false;
        }
        java.lang.String substring = str.substring(0, indexOf);
        int indexOf2 = str.indexOf("revision ", indexOf);
        org.apache.tools.ant.taskdefs.cvslib.CvsTagEntry cvsTagEntry = new org.apache.tools.ant.taskdefs.cvslib.CvsTagEntry(substring, indexOf2 != -1 ? str.substring(indexOf2 + 9) : null);
        vector.addElement(cvsTagEntry);
        log(cvsTagEntry.toString(), 3);
        return true;
    }

    public final boolean g(java.util.Vector vector, java.lang.String str) {
        int indexOf;
        if (this.W || (indexOf = str.indexOf(" is removed")) == -1) {
            return false;
        }
        java.lang.String substring = str.substring(0, indexOf);
        int indexOf2 = str.indexOf("revision ", indexOf);
        org.apache.tools.ant.taskdefs.cvslib.CvsTagEntry cvsTagEntry = new org.apache.tools.ant.taskdefs.cvslib.CvsTagEntry(substring, null, indexOf2 != -1 ? str.substring(indexOf2 + 9) : null);
        vector.addElement(cvsTagEntry);
        log(cvsTagEntry.toString(), 3);
        return true;
    }

    public final void h() {
        if (this.Q != null) {
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(this.Q);
            while (stringTokenizer.hasMoreTokens()) {
                java.lang.String nextToken = stringTokenizer.nextToken();
                this.X.add(nextToken);
                addCommandArgument(nextToken);
            }
        }
        java.util.Iterator<org.apache.tools.ant.taskdefs.AbstractCvsTask.Module> it = getModules().iterator();
        while (it.hasNext()) {
            this.X.add(it.next().getName());
        }
        this.Y = new java.lang.String[this.X.size()];
        this.Z = new int[this.X.size()];
        int i = 0;
        while (true) {
            java.lang.String[] strArr = this.Y;
            if (i >= strArr.length) {
                return;
            }
            strArr[i] = "File " + this.X.get(i) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
            this.Z[i] = this.Y[i].length();
            i++;
        }
    }

    public final org.apache.tools.ant.taskdefs.cvslib.CvsTagEntry[] i(java.io.File file) throws org.apache.tools.ant.BuildException {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file));
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            java.util.Vector vector = new java.util.Vector();
            for (java.lang.String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                java.lang.String j = j(readLine, this.Y, this.Z);
                if (j != null && !f(vector, j) && !e(vector, j)) {
                    g(vector, j);
                }
            }
            org.apache.tools.ant.taskdefs.cvslib.CvsTagEntry[] cvsTagEntryArr = new org.apache.tools.ant.taskdefs.cvslib.CvsTagEntry[vector.size()];
            vector.copyInto(cvsTagEntryArr);
            try {
                bufferedReader.close();
            } catch (java.io.IOException e2) {
                log(e2.toString(), 0);
            }
            return cvsTagEntryArr;
        } catch (java.io.IOException e3) {
            e = e3;
            throw new org.apache.tools.ant.BuildException("Error in parsing", e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (java.io.IOException e4) {
                    log(e4.toString(), 0);
                }
            }
            throw th;
        }
    }

    public final void k(org.apache.tools.ant.taskdefs.cvslib.CvsTagEntry[] cvsTagEntryArr) throws org.apache.tools.ant.BuildException {
        java.io.FileOutputStream fileOutputStream;
        java.io.PrintWriter printWriter;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(this.V);
                    try {
                        printWriter = new java.io.PrintWriter(new java.io.OutputStreamWriter(fileOutputStream, "UTF-8"));
                        printWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                        org.w3c.dom.Document newDocument = org.apache.tools.ant.util.DOMUtils.newDocument();
                        org.w3c.dom.Element createElement = newDocument.createElement("tagdiff");
                        java.lang.String str = this.R;
                        if (str != null) {
                            createElement.setAttribute("startTag", str);
                        } else {
                            createElement.setAttribute(com.heytap.mcssdk.constant.b.f375s, this.T);
                        }
                        java.lang.String str2 = this.S;
                        if (str2 != null) {
                            createElement.setAttribute("endTag", str2);
                        } else {
                            createElement.setAttribute(com.heytap.mcssdk.constant.b.t, this.U);
                        }
                        createElement.setAttribute("cvsroot", getCvsRoot());
                        createElement.setAttribute("package", org.apache.tools.ant.util.CollectionUtils.flattenToString(this.X));
                        b0.openElement(createElement, printWriter, 0, "\t");
                        printWriter.println();
                        for (org.apache.tools.ant.taskdefs.cvslib.CvsTagEntry cvsTagEntry : cvsTagEntryArr) {
                            l(newDocument, printWriter, cvsTagEntry);
                        }
                        b0.closeElement(createElement, printWriter, 0, "\t", true);
                        printWriter.flush();
                    } catch (java.io.UnsupportedEncodingException e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        log(e.toString(), 0);
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        return;
                    } catch (java.io.IOException e2) {
                        e = e2;
                        throw new org.apache.tools.ant.BuildException(e.toString(), e);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (java.io.IOException e3) {
                                log(e3.toString(), 0);
                            }
                        }
                        throw th;
                    }
                } catch (java.io.IOException e4) {
                    log(e4.toString(), 0);
                    return;
                }
            } catch (java.io.UnsupportedEncodingException e5) {
                e = e5;
            } catch (java.io.IOException e6) {
                e = e6;
            }
            if (printWriter.checkError()) {
                throw new java.io.IOException("Encountered an error writing tagdiff");
            }
            printWriter.close();
            fileOutputStream.close();
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final void l(org.w3c.dom.Document document, java.io.PrintWriter printWriter, org.apache.tools.ant.taskdefs.cvslib.CvsTagEntry cvsTagEntry) throws java.io.IOException {
        org.w3c.dom.Element createElement = document.createElement(com.anythink.expressad.foundation.g.a.aj);
        org.w3c.dom.Element createChildElement = org.apache.tools.ant.util.DOMUtils.createChildElement(createElement, "file");
        org.apache.tools.ant.util.DOMUtils.appendCDATAElement(createChildElement, "name", cvsTagEntry.getFile());
        if (cvsTagEntry.getRevision() != null) {
            org.apache.tools.ant.util.DOMUtils.appendTextElement(createChildElement, "revision", cvsTagEntry.getRevision());
        }
        if (cvsTagEntry.getPreviousRevision() != null) {
            org.apache.tools.ant.util.DOMUtils.appendTextElement(createChildElement, "prevrevision", cvsTagEntry.getPreviousRevision());
        }
        b0.write(createElement, printWriter, 1, "\t");
    }

    public void setDestFile(java.io.File file) {
        this.V = file;
    }

    public void setEndDate(java.lang.String str) {
        this.U = str;
    }

    public void setEndTag(java.lang.String str) {
        this.S = str;
    }

    public void setIgnoreRemoved(boolean z) {
        this.W = z;
    }

    @Override // org.apache.tools.ant.taskdefs.AbstractCvsTask
    public void setPackage(java.lang.String str) {
        this.Q = str;
    }

    public void setStartDate(java.lang.String str) {
        this.T = str;
    }

    public void setStartTag(java.lang.String str) {
        this.R = str;
    }

    public final void validate() throws org.apache.tools.ant.BuildException {
        if (this.Q == null && getModules().size() == 0) {
            throw new org.apache.tools.ant.BuildException("Package/module must be set.");
        }
        if (this.V == null) {
            throw new org.apache.tools.ant.BuildException("Destfile must be set.");
        }
        java.lang.String str = this.R;
        if (str == null && this.T == null) {
            throw new org.apache.tools.ant.BuildException("Start tag or start date must be set.");
        }
        if (str != null && this.T != null) {
            throw new org.apache.tools.ant.BuildException("Only one of start tag and start date must be set.");
        }
        java.lang.String str2 = this.S;
        if (str2 == null && this.U == null) {
            throw new org.apache.tools.ant.BuildException("End tag or end date must be set.");
        }
        if (str2 != null && this.U != null) {
            throw new org.apache.tools.ant.BuildException("Only one of end tag and end date must be set.");
        }
    }
}
