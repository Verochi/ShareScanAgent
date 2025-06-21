package org.apache.tools.ant.taskdefs.optional.native2ascii;

/* loaded from: classes25.dex */
public class BuiltinNative2Ascii implements org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapter {
    public final java.io.BufferedReader a(java.io.File file, java.lang.String str, boolean z) throws java.io.IOException {
        return (z || str == null) ? new java.io.BufferedReader(new java.io.FileReader(file)) : new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), str));
    }

    public final java.io.Writer b(java.io.File file, java.lang.String str, boolean z) throws java.io.IOException {
        if (!z) {
            str = "ASCII";
        }
        return str != null ? new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file), str)) : new java.io.BufferedWriter(new java.io.FileWriter(file));
    }

    public final void c(java.io.BufferedReader bufferedReader, java.io.Writer writer, boolean z) throws java.io.IOException {
        while (true) {
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            if (z) {
                writer.write(org.apache.tools.ant.util.Native2AsciiUtils.ascii2native(readLine));
            } else {
                writer.write(org.apache.tools.ant.util.Native2AsciiUtils.native2ascii(readLine));
            }
            writer.write(org.apache.tools.ant.util.StringUtils.LINE_SEP);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapter
    public final boolean convert(org.apache.tools.ant.taskdefs.optional.Native2Ascii native2Ascii, java.io.File file, java.io.File file2) throws org.apache.tools.ant.BuildException {
        boolean reverse = native2Ascii.getReverse();
        java.lang.String encoding = native2Ascii.getEncoding();
        try {
            java.io.BufferedReader a = a(file, encoding, reverse);
            try {
                java.io.Writer b = b(file2, encoding, reverse);
                try {
                    c(a, b, reverse);
                    return true;
                } finally {
                    org.apache.tools.ant.util.FileUtils.close(b);
                }
            } finally {
                org.apache.tools.ant.util.FileUtils.close(a);
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Exception trying to translate data", e);
        }
    }
}
