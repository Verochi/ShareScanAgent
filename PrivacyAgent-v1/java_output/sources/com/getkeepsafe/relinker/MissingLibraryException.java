package com.getkeepsafe.relinker;

/* loaded from: classes22.dex */
public class MissingLibraryException extends java.lang.RuntimeException {
    public MissingLibraryException(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2) {
        super("Could not find '" + str + "'. Looked for: " + java.util.Arrays.toString(strArr) + ", but only found: " + java.util.Arrays.toString(strArr2) + ".");
    }
}
