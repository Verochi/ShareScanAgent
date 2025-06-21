package androidx.core.util;

/* loaded from: classes.dex */
public class AtomicFile {
    private static final java.lang.String LOG_TAG = "AtomicFile";
    private final java.io.File mBaseName;
    private final java.io.File mLegacyBackupName;
    private final java.io.File mNewName;

    public AtomicFile(@androidx.annotation.NonNull java.io.File file) {
        this.mBaseName = file;
        this.mNewName = new java.io.File(file.getPath() + ".new");
        this.mLegacyBackupName = new java.io.File(file.getPath() + ".bak");
    }

    private static void rename(@androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull java.io.File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Failed to delete file which is a directory ");
            sb.append(file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("Failed to rename ");
        sb2.append(file);
        sb2.append(" to ");
        sb2.append(file2);
    }

    private static boolean sync(@androidx.annotation.NonNull java.io.FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public void failWrite(@androidx.annotation.Nullable java.io.FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        sync(fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (java.io.IOException unused) {
        }
        if (this.mNewName.delete()) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Failed to delete new file ");
        sb.append(this.mNewName);
    }

    public void finishWrite(@androidx.annotation.Nullable java.io.FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        sync(fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (java.io.IOException unused) {
        }
        rename(this.mNewName, this.mBaseName);
    }

    @androidx.annotation.NonNull
    public java.io.File getBaseFile() {
        return this.mBaseName;
    }

    @androidx.annotation.NonNull
    public java.io.FileInputStream openRead() throws java.io.FileNotFoundException {
        if (this.mLegacyBackupName.exists()) {
            rename(this.mLegacyBackupName, this.mBaseName);
        }
        if (this.mNewName.exists() && this.mBaseName.exists() && !this.mNewName.delete()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Failed to delete outdated new file ");
            sb.append(this.mNewName);
        }
        return new java.io.FileInputStream(this.mBaseName);
    }

    @androidx.annotation.NonNull
    public byte[] readFully() throws java.io.IOException {
        java.io.FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i = 0;
            while (true) {
                int read = openRead.read(bArr, i, bArr.length - i);
                if (read <= 0) {
                    return bArr;
                }
                i += read;
                int available = openRead.available();
                if (available > bArr.length - i) {
                    byte[] bArr2 = new byte[available + i];
                    java.lang.System.arraycopy(bArr, 0, bArr2, 0, i);
                    bArr = bArr2;
                }
            }
        } finally {
            openRead.close();
        }
    }

    @androidx.annotation.NonNull
    public java.io.FileOutputStream startWrite() throws java.io.IOException {
        if (this.mLegacyBackupName.exists()) {
            rename(this.mLegacyBackupName, this.mBaseName);
        }
        try {
            return new java.io.FileOutputStream(this.mNewName);
        } catch (java.io.FileNotFoundException unused) {
            if (!this.mNewName.getParentFile().mkdirs()) {
                throw new java.io.IOException("Failed to create directory for " + this.mNewName);
            }
            try {
                return new java.io.FileOutputStream(this.mNewName);
            } catch (java.io.FileNotFoundException e) {
                throw new java.io.IOException("Failed to create new file " + this.mNewName, e);
            }
        }
    }
}
