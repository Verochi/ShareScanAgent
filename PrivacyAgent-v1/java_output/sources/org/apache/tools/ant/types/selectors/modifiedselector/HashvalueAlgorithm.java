package org.apache.tools.ant.types.selectors.modifiedselector;

/* loaded from: classes26.dex */
public class HashvalueAlgorithm implements org.apache.tools.ant.types.selectors.modifiedselector.Algorithm {
    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Algorithm
    public java.lang.String getValue(java.io.File file) {
        java.io.FileReader fileReader;
        java.io.FileReader fileReader2 = null;
        try {
            if (!file.canRead()) {
                org.apache.tools.ant.util.FileUtils.close((java.io.Reader) null);
                return null;
            }
            fileReader = new java.io.FileReader(file);
            try {
                java.lang.String num = java.lang.Integer.toString(org.apache.tools.ant.util.FileUtils.readFully(fileReader).hashCode());
                org.apache.tools.ant.util.FileUtils.close(fileReader);
                return num;
            } catch (java.lang.Exception unused) {
                org.apache.tools.ant.util.FileUtils.close(fileReader);
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                fileReader2 = fileReader;
                org.apache.tools.ant.util.FileUtils.close(fileReader2);
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            fileReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Algorithm
    public boolean isValid() {
        return true;
    }

    public java.lang.String toString() {
        return "HashvalueAlgorithm";
    }
}
