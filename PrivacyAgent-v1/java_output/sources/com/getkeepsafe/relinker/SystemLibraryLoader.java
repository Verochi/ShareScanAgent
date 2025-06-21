package com.getkeepsafe.relinker;

/* loaded from: classes22.dex */
final class SystemLibraryLoader implements com.getkeepsafe.relinker.ReLinker.LibraryLoader {
    @Override // com.getkeepsafe.relinker.ReLinker.LibraryLoader
    public void loadLibrary(java.lang.String str) {
        java.lang.System.loadLibrary(str);
    }

    @Override // com.getkeepsafe.relinker.ReLinker.LibraryLoader
    public void loadPath(java.lang.String str) {
        java.lang.System.load(str);
    }

    @Override // com.getkeepsafe.relinker.ReLinker.LibraryLoader
    public java.lang.String mapLibraryName(java.lang.String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : java.lang.System.mapLibraryName(str);
    }

    @Override // com.getkeepsafe.relinker.ReLinker.LibraryLoader
    public java.lang.String[] supportedAbis() {
        java.lang.String[] strArr = android.os.Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        java.lang.String str = android.os.Build.CPU_ABI2;
        return !com.getkeepsafe.relinker.TextUtils.a(str) ? new java.lang.String[]{android.os.Build.CPU_ABI, str} : new java.lang.String[]{android.os.Build.CPU_ABI};
    }

    @Override // com.getkeepsafe.relinker.ReLinker.LibraryLoader
    public java.lang.String unmapLibraryName(java.lang.String str) {
        return str.substring(3, str.length() - 3);
    }
}
