package cn.fly.verify;

/* loaded from: classes.dex */
public class fk {
    public static long a(java.lang.String str) {
        java.nio.file.FileSystem fileSystem;
        java.nio.file.Path path;
        java.nio.file.attribute.BasicFileAttributes readAttributes;
        java.nio.file.attribute.FileTime lastAccessTime;
        long millis;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return -1L;
        }
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                return -1L;
            }
            fileSystem = java.nio.file.FileSystems.getDefault();
            path = fileSystem.getPath(file.getAbsolutePath(), new java.lang.String[0]);
            readAttributes = java.nio.file.Files.readAttributes(path, (java.lang.Class<java.nio.file.attribute.BasicFileAttributes>) java.nio.file.attribute.BasicFileAttributes.class, new java.nio.file.LinkOption[0]);
            lastAccessTime = readAttributes.lastAccessTime();
            millis = lastAccessTime.toMillis();
            return millis;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return -1L;
        }
    }

    public static boolean a(java.io.File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        java.io.File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (java.io.File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !a(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean a(java.io.File file, java.io.FileFilter fileFilter) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        java.io.File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (java.io.File file2 : listFiles) {
                if (fileFilter.accept(file2)) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory() && !a(file2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
