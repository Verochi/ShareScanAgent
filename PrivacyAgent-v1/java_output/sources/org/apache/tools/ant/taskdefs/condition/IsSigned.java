package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class IsSigned extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String n;
    public java.io.File t;

    public static java.lang.String b(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = false;
        for (char c : str.toCharArray()) {
            if (org.apache.tools.ant.taskdefs.ManifestTask.VALID_ATTRIBUTE_CHARS.indexOf(c) < 0) {
                sb.append("_");
                z = true;
            } else {
                sb.append(c);
            }
        }
        return z ? sb.toString() : str;
    }

    public static boolean isSigned(java.io.File file, java.lang.String str) throws java.io.IOException {
        org.apache.tools.zip.ZipFile zipFile;
        boolean z;
        boolean z2;
        org.apache.tools.zip.ZipFile zipFile2 = null;
        try {
            zipFile = new org.apache.tools.zip.ZipFile(file);
            z = true;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            if (str == null) {
                java.util.Enumeration<org.apache.tools.zip.ZipEntry> entries = zipFile.getEntries();
                while (entries.hasMoreElements()) {
                    java.lang.String name = entries.nextElement().getName();
                    if (name.startsWith("META-INF/") && name.endsWith(".SF")) {
                        org.apache.tools.zip.ZipFile.closeQuietly(zipFile);
                        return true;
                    }
                }
                org.apache.tools.zip.ZipFile.closeQuietly(zipFile);
                return false;
            }
            java.lang.String b = b(str);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("META-INF/");
            sb.append(b.toUpperCase());
            sb.append(".SF");
            boolean z3 = zipFile.getEntry(sb.toString()) != null;
            if (b.length() > 8) {
                if (zipFile.getEntry("META-INF/" + b.substring(0, 8).toUpperCase() + ".SF") != null) {
                    z2 = true;
                    if (!z3 && !z2) {
                        z = false;
                    }
                    org.apache.tools.zip.ZipFile.closeQuietly(zipFile);
                    return z;
                }
            }
            z2 = false;
            if (!z3) {
                z = false;
            }
            org.apache.tools.zip.ZipFile.closeQuietly(zipFile);
            return z;
        } catch (java.lang.Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            org.apache.tools.zip.ZipFile.closeQuietly(zipFile2);
            throw th;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() {
        java.io.File file = this.t;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("The file attribute must be set.");
        }
        boolean z = false;
        if (!file.exists()) {
            log("The file \"" + this.t.getAbsolutePath() + "\" does not exist.", 3);
            return false;
        }
        try {
            z = isSigned(this.t, this.n);
        } catch (java.io.IOException e) {
            log("Got IOException reading file \"" + this.t.getAbsolutePath() + "\"" + e, 1);
        }
        if (z) {
            log("File \"" + this.t.getAbsolutePath() + "\" is signed.", 3);
        }
        return z;
    }

    public void setFile(java.io.File file) {
        this.t = file;
    }

    public void setName(java.lang.String str) {
        this.n = str;
    }
}
