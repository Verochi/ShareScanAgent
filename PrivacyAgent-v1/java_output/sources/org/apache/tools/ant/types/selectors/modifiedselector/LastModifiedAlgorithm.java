package org.apache.tools.ant.types.selectors.modifiedselector;

/* loaded from: classes26.dex */
public class LastModifiedAlgorithm implements org.apache.tools.ant.types.selectors.modifiedselector.Algorithm {
    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Algorithm
    public java.lang.String getValue(java.io.File file) {
        long lastModified = file.lastModified();
        if (lastModified == 0) {
            return null;
        }
        return java.lang.Long.toString(lastModified);
    }

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Algorithm
    public boolean isValid() {
        return true;
    }
}
