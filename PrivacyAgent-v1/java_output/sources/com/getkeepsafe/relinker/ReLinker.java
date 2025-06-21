package com.getkeepsafe.relinker;

/* loaded from: classes22.dex */
public class ReLinker {

    public interface LibraryInstaller {
        void installLibrary(android.content.Context context, java.lang.String[] strArr, java.lang.String str, java.io.File file, com.getkeepsafe.relinker.ReLinkerInstance reLinkerInstance);
    }

    public interface LibraryLoader {
        void loadLibrary(java.lang.String str);

        void loadPath(java.lang.String str);

        java.lang.String mapLibraryName(java.lang.String str);

        java.lang.String[] supportedAbis();

        java.lang.String unmapLibraryName(java.lang.String str);
    }

    public interface LoadListener {
        void failure(java.lang.Throwable th);

        void success();
    }

    public interface Logger {
        void log(java.lang.String str);
    }

    public static com.getkeepsafe.relinker.ReLinkerInstance force() {
        return new com.getkeepsafe.relinker.ReLinkerInstance().force();
    }

    public static void loadLibrary(android.content.Context context, java.lang.String str) {
        loadLibrary(context, str, null, null);
    }

    public static void loadLibrary(android.content.Context context, java.lang.String str, com.getkeepsafe.relinker.ReLinker.LoadListener loadListener) {
        loadLibrary(context, str, null, loadListener);
    }

    public static void loadLibrary(android.content.Context context, java.lang.String str, java.lang.String str2) {
        loadLibrary(context, str, str2, null);
    }

    public static void loadLibrary(android.content.Context context, java.lang.String str, java.lang.String str2, com.getkeepsafe.relinker.ReLinker.LoadListener loadListener) {
        new com.getkeepsafe.relinker.ReLinkerInstance().loadLibrary(context, str, str2, loadListener);
    }

    public static com.getkeepsafe.relinker.ReLinkerInstance log(com.getkeepsafe.relinker.ReLinker.Logger logger) {
        return new com.getkeepsafe.relinker.ReLinkerInstance().log(logger);
    }

    public static com.getkeepsafe.relinker.ReLinkerInstance recursively() {
        return new com.getkeepsafe.relinker.ReLinkerInstance().recursively();
    }
}
