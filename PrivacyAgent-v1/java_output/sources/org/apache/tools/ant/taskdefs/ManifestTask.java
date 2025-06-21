package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class ManifestTask extends org.apache.tools.ant.Task {
    public static final java.lang.String VALID_ATTRIBUTE_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";
    public java.io.File v;
    public org.apache.tools.ant.taskdefs.ManifestTask.Mode w;
    public java.lang.String x;
    public org.apache.tools.ant.taskdefs.Manifest u = new org.apache.tools.ant.taskdefs.Manifest();
    public boolean y = false;
    public boolean z = false;

    public static class Mode extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"update", org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_REPLACE};
        }
    }

    public ManifestTask() {
        org.apache.tools.ant.taskdefs.ManifestTask.Mode mode = new org.apache.tools.ant.taskdefs.ManifestTask.Mode();
        this.w = mode;
        mode.setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_REPLACE);
    }

    public void addConfiguredAttribute(org.apache.tools.ant.taskdefs.Manifest.Attribute attribute) throws org.apache.tools.ant.taskdefs.ManifestException {
        c(attribute);
        this.u.addConfiguredAttribute(attribute);
    }

    public void addConfiguredSection(org.apache.tools.ant.taskdefs.Manifest.Section section) throws org.apache.tools.ant.taskdefs.ManifestException {
        java.util.Enumeration<java.lang.String> attributeKeys = section.getAttributeKeys();
        while (attributeKeys.hasMoreElements()) {
            c(section.getAttribute(attributeKeys.nextElement()));
        }
        this.u.addConfiguredSection(section);
    }

    public final void c(org.apache.tools.ant.taskdefs.Manifest.Attribute attribute) throws org.apache.tools.ant.BuildException {
        java.lang.String name = attribute.getName();
        char charAt = name.charAt(0);
        if (charAt == '-' || charAt == '_') {
            throw new org.apache.tools.ant.BuildException("Manifest attribute names must not start with '" + charAt + "'.");
        }
        for (int i = 0; i < name.length(); i++) {
            char charAt2 = name.charAt(i);
            if (VALID_ATTRIBUTE_CHARS.indexOf(charAt2) < 0) {
                throw new org.apache.tools.ant.BuildException("Manifest attribute names must not contain '" + charAt2 + "'");
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0083: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:74:0x0083 */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0096 A[LOOP:0: B:8:0x0090->B:10:0x0096, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c1 A[Catch: ManifestException -> 0x013b, TryCatch #4 {ManifestException -> 0x013b, blocks: (B:12:0x00b2, B:14:0x00c1, B:17:0x00cb, B:20:0x00d4, B:22:0x00d5), top: B:11:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cb A[Catch: ManifestException -> 0x013b, TryCatch #4 {ManifestException -> 0x013b, blocks: (B:12:0x00b2, B:14:0x00c1, B:17:0x00cb, B:20:0x00d4, B:22:0x00d5), top: B:11:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // org.apache.tools.ant.Task
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.Reader reader;
        java.io.InputStreamReader inputStreamReader;
        org.apache.tools.ant.BuildException buildException;
        org.apache.tools.ant.taskdefs.Manifest manifest;
        java.util.Enumeration<java.lang.String> warnings;
        java.io.PrintWriter printWriter;
        if (this.v == null) {
            throw new org.apache.tools.ant.BuildException("the file attribute is required");
        }
        org.apache.tools.ant.taskdefs.Manifest defaultManifest = org.apache.tools.ant.taskdefs.Manifest.getDefaultManifest();
        java.io.Reader reader2 = null;
        r3 = null;
        java.io.PrintWriter printWriter2 = null;
        try {
            if (this.v.exists()) {
                try {
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(this.v);
                    inputStreamReader = this.x == null ? new java.io.InputStreamReader(fileInputStream, "UTF-8") : new java.io.InputStreamReader(fileInputStream, this.x);
                    try {
                        manifest = new org.apache.tools.ant.taskdefs.Manifest(inputStreamReader);
                        org.apache.tools.ant.util.FileUtils.close(inputStreamReader);
                        buildException = null;
                    } catch (java.io.IOException e) {
                        e = e;
                        buildException = new org.apache.tools.ant.BuildException("Failed to read " + this.v, e, getLocation());
                        org.apache.tools.ant.util.FileUtils.close(inputStreamReader);
                        manifest = null;
                        warnings = this.u.getWarnings();
                        while (warnings.hasMoreElements()) {
                        }
                        if (this.w.getValue().equals("update")) {
                            if (manifest == null) {
                            }
                        }
                        defaultManifest.merge(this.u, false, this.y);
                        if (defaultManifest.equals(manifest)) {
                        }
                    } catch (org.apache.tools.ant.taskdefs.ManifestException e2) {
                        e = e2;
                        buildException = new org.apache.tools.ant.BuildException("Existing manifest " + this.v + " is invalid", e, getLocation());
                        org.apache.tools.ant.util.FileUtils.close(inputStreamReader);
                        manifest = null;
                        warnings = this.u.getWarnings();
                        while (warnings.hasMoreElements()) {
                        }
                        if (this.w.getValue().equals("update")) {
                        }
                        defaultManifest.merge(this.u, false, this.y);
                        if (defaultManifest.equals(manifest)) {
                        }
                    }
                } catch (java.io.IOException e3) {
                    e = e3;
                    inputStreamReader = null;
                } catch (org.apache.tools.ant.taskdefs.ManifestException e4) {
                    e = e4;
                    inputStreamReader = null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    org.apache.tools.ant.util.FileUtils.close(reader2);
                    throw th;
                }
            } else {
                manifest = null;
                buildException = null;
            }
            warnings = this.u.getWarnings();
            while (warnings.hasMoreElements()) {
                log("Manifest warning: " + warnings.nextElement(), 1);
            }
            try {
                if (this.w.getValue().equals("update") && this.v.exists()) {
                    if (manifest == null) {
                        defaultManifest.merge(manifest, false, this.y);
                    } else if (buildException != null) {
                        throw buildException;
                    }
                }
                defaultManifest.merge(this.u, false, this.y);
                if (defaultManifest.equals(manifest)) {
                    log("Manifest has not changed, do not recreate", 3);
                    return;
                }
                try {
                    try {
                        printWriter = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.v), "UTF-8"));
                    } catch (java.io.IOException e5) {
                        e = e5;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
                try {
                    defaultManifest.write(printWriter, this.z);
                    if (printWriter.checkError()) {
                        throw new java.io.IOException("Encountered an error writing manifest");
                    }
                    org.apache.tools.ant.util.FileUtils.close(printWriter);
                } catch (java.io.IOException e6) {
                    e = e6;
                    printWriter2 = printWriter;
                    throw new org.apache.tools.ant.BuildException("Failed to write " + this.v, e, getLocation());
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    printWriter2 = printWriter;
                    org.apache.tools.ant.util.FileUtils.close(printWriter2);
                    throw th;
                }
            } catch (org.apache.tools.ant.taskdefs.ManifestException e7) {
                throw new org.apache.tools.ant.BuildException("Manifest is invalid", e7, getLocation());
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            reader2 = reader;
        }
    }

    public void setEncoding(java.lang.String str) {
        this.x = str;
    }

    public void setFile(java.io.File file) {
        this.v = file;
    }

    public void setFlattenAttributes(boolean z) {
        this.z = z;
    }

    public void setMergeClassPathAttributes(boolean z) {
        this.y = z;
    }

    public void setMode(org.apache.tools.ant.taskdefs.ManifestTask.Mode mode) {
        this.w = mode;
    }
}
