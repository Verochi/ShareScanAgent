package com.getkeepsafe.relinker;

/* loaded from: classes22.dex */
public class ApkLibraryInstaller implements com.getkeepsafe.relinker.ReLinker.LibraryInstaller {

    public static class ZipFileInZipEntry {
        public java.util.zip.ZipFile a;
        public java.util.zip.ZipEntry b;

        public ZipFileInZipEntry(java.util.zip.ZipFile zipFile, java.util.zip.ZipEntry zipEntry) {
            this.a = zipFile;
            this.b = zipEntry;
        }
    }

    public final void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public final long b(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public final com.getkeepsafe.relinker.ApkLibraryInstaller.ZipFileInZipEntry c(android.content.Context context, java.lang.String[] strArr, java.lang.String str, com.getkeepsafe.relinker.ReLinkerInstance reLinkerInstance) {
        java.lang.String[] e = e(context);
        int length = e.length;
        char c = 0;
        int i = 0;
        while (true) {
            java.util.zip.ZipFile zipFile = null;
            if (i >= length) {
                return null;
            }
            java.lang.String str2 = e[i];
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 5) {
                    break;
                }
                try {
                    zipFile = new java.util.zip.ZipFile(new java.io.File(str2), 1);
                    break;
                } catch (java.io.IOException unused) {
                    i2 = i3;
                }
            }
            if (zipFile != null) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i4 < 5) {
                        int length2 = strArr.length;
                        int i6 = 0;
                        while (i6 < length2) {
                            java.lang.String str3 = "lib" + java.io.File.separatorChar + strArr[i6] + java.io.File.separatorChar + str;
                            java.lang.Object[] objArr = new java.lang.Object[2];
                            objArr[c] = str3;
                            objArr[1] = str2;
                            reLinkerInstance.log("Looking for %s in APK %s...", objArr);
                            java.util.zip.ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new com.getkeepsafe.relinker.ApkLibraryInstaller.ZipFileInZipEntry(zipFile, entry);
                            }
                            i6++;
                            c = 0;
                        }
                        i4 = i5;
                        c = 0;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (java.io.IOException unused2) {
                        }
                    }
                }
            }
            i++;
            c = 0;
        }
    }

    public final java.lang.String[] d(android.content.Context context, java.lang.String str) {
        java.util.regex.Pattern compile = java.util.regex.Pattern.compile("lib" + java.io.File.separatorChar + "([^\\" + java.io.File.separatorChar + "]*)" + java.io.File.separatorChar + str);
        java.util.HashSet hashSet = new java.util.HashSet();
        for (java.lang.String str2 : e(context)) {
            try {
                java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = new java.util.zip.ZipFile(new java.io.File(str2), 1).entries();
                while (entries.hasMoreElements()) {
                    java.util.regex.Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (java.io.IOException unused) {
            }
        }
        return (java.lang.String[]) hashSet.toArray(new java.lang.String[hashSet.size()]);
    }

    public final java.lang.String[] e(android.content.Context context) {
        android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
        java.lang.String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new java.lang.String[]{applicationInfo.sourceDir};
        }
        java.lang.String[] strArr2 = new java.lang.String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        java.lang.System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    @Override // com.getkeepsafe.relinker.ReLinker.LibraryInstaller
    public void installLibrary(android.content.Context context, java.lang.String[] strArr, java.lang.String str, java.io.File file, com.getkeepsafe.relinker.ReLinkerInstance reLinkerInstance) {
        com.getkeepsafe.relinker.ApkLibraryInstaller.ZipFileInZipEntry c;
        java.lang.String[] strArr2;
        java.io.FileOutputStream fileOutputStream;
        java.io.InputStream inputStream;
        long b;
        com.getkeepsafe.relinker.ApkLibraryInstaller.ZipFileInZipEntry zipFileInZipEntry = null;
        java.io.Closeable closeable = null;
        try {
            c = c(context, strArr, str, reLinkerInstance);
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            if (c == null) {
                try {
                    strArr2 = d(context, str);
                } catch (java.lang.Exception e) {
                    strArr2 = new java.lang.String[]{e.toString()};
                }
                throw new com.getkeepsafe.relinker.MissingLibraryException(str, strArr, strArr2);
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= 5) {
                    reLinkerInstance.log("FATAL! Couldn't extract the library from the APK!");
                    try {
                        java.util.zip.ZipFile zipFile = c.a;
                        if (zipFile != null) {
                            zipFile.close();
                            return;
                        }
                        return;
                    } catch (java.io.IOException unused) {
                        return;
                    }
                }
                reLinkerInstance.log("Found %s! Extracting...", str);
                try {
                    if (file.exists() || file.createNewFile()) {
                        try {
                            inputStream = c.a.getInputStream(c.b);
                            try {
                                fileOutputStream = new java.io.FileOutputStream(file);
                                try {
                                    b = b(inputStream, fileOutputStream);
                                    fileOutputStream.getFD().sync();
                                } catch (java.io.FileNotFoundException unused2) {
                                    a(inputStream);
                                    a(fileOutputStream);
                                    i = i2;
                                } catch (java.io.IOException unused3) {
                                    a(inputStream);
                                    a(fileOutputStream);
                                    i = i2;
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    closeable = inputStream;
                                    a(closeable);
                                    a(fileOutputStream);
                                    throw th;
                                }
                            } catch (java.io.FileNotFoundException unused4) {
                                fileOutputStream = null;
                            } catch (java.io.IOException unused5) {
                                fileOutputStream = null;
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                            }
                        } catch (java.io.FileNotFoundException unused6) {
                            inputStream = null;
                            fileOutputStream = null;
                        } catch (java.io.IOException unused7) {
                            inputStream = null;
                            fileOutputStream = null;
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            fileOutputStream = null;
                        }
                        if (b == file.length()) {
                            a(inputStream);
                            a(fileOutputStream);
                            file.setReadable(true, false);
                            file.setExecutable(true, false);
                            file.setWritable(true);
                            try {
                                java.util.zip.ZipFile zipFile2 = c.a;
                                if (zipFile2 != null) {
                                    zipFile2.close();
                                    return;
                                }
                                return;
                            } catch (java.io.IOException unused8) {
                                return;
                            }
                        }
                        a(inputStream);
                        a(fileOutputStream);
                    }
                } catch (java.io.IOException unused9) {
                }
                i = i2;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            zipFileInZipEntry = c;
            if (zipFileInZipEntry != null) {
                try {
                    java.util.zip.ZipFile zipFile3 = zipFileInZipEntry.a;
                    if (zipFile3 != null) {
                        zipFile3.close();
                    }
                } catch (java.io.IOException unused10) {
                }
            }
            throw th;
        }
    }
}
