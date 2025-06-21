package org.apache.tools.ant.taskdefs.optional.jlink;

/* loaded from: classes25.dex */
public class jlink {
    public java.lang.String a = null;
    public java.util.Vector b = new java.util.Vector(10);
    public java.util.Vector c = new java.util.Vector(10);
    public boolean d = false;
    public byte[] e = new byte[8192];

    public static void main(java.lang.String[] strArr) {
        if (strArr.length < 2) {
            java.lang.System.out.println("usage: jlink output input1 ... inputN");
            java.lang.System.exit(1);
        }
        org.apache.tools.ant.taskdefs.optional.jlink.jlink jlinkVar = new org.apache.tools.ant.taskdefs.optional.jlink.jlink();
        jlinkVar.setOutfile(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            jlinkVar.addMergeFile(strArr[i]);
        }
        try {
            jlinkVar.link();
        } catch (java.lang.Exception e) {
            java.lang.System.err.print(e.getMessage());
        }
    }

    public final void a(java.util.zip.ZipOutputStream zipOutputStream, java.io.File file, java.lang.String str, boolean z) throws java.io.IOException {
        for (java.lang.String str2 : file.list()) {
            java.io.File file2 = new java.io.File(file, str2);
            if (file2.isDirectory()) {
                a(zipOutputStream, file2, str + str2 + '/', z);
            } else {
                b(zipOutputStream, file2, str, z);
            }
        }
    }

    public void addAddFile(java.lang.String str) {
        if (str == null) {
            return;
        }
        this.c.addElement(str);
    }

    public void addAddFiles(java.lang.String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (java.lang.String str : strArr) {
            addAddFile(str);
        }
    }

    public void addMergeFile(java.lang.String str) {
        if (str == null) {
            return;
        }
        this.b.addElement(str);
    }

    public void addMergeFiles(java.lang.String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (java.lang.String str : strArr) {
            addMergeFile(str);
        }
    }

    public final void b(java.util.zip.ZipOutputStream zipOutputStream, java.io.File file, java.lang.String str, boolean z) throws java.io.IOException {
        if (file.exists()) {
            java.util.zip.ZipEntry zipEntry = new java.util.zip.ZipEntry(f(file, str));
            zipEntry.setTime(file.lastModified());
            zipEntry.setSize(file.length());
            if (!z) {
                zipEntry.setCrc(d(file));
            }
            c(zipOutputStream, new java.io.FileInputStream(file), zipEntry);
        }
    }

    public final void c(java.util.zip.ZipOutputStream zipOutputStream, java.io.InputStream inputStream, java.util.zip.ZipEntry zipEntry) throws java.io.IOException {
        try {
            zipOutputStream.putNextEntry(zipEntry);
            while (true) {
                int read = inputStream.read(this.e);
                if (read <= 0) {
                    zipOutputStream.closeEntry();
                    inputStream.close();
                    return;
                }
                zipOutputStream.write(this.e, 0, read);
            }
        } catch (java.util.zip.ZipException unused) {
            inputStream.close();
        }
    }

    public final long d(java.io.File file) throws java.io.IOException {
        return e(new java.io.BufferedInputStream(new java.io.FileInputStream(file)));
    }

    public final long e(java.io.InputStream inputStream) throws java.io.IOException {
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        int length = this.e.length;
        while (true) {
            int read = inputStream.read(this.e, 0, length);
            if (read <= 0) {
                inputStream.close();
                return crc32.getValue();
            }
            crc32.update(this.e, 0, read);
        }
    }

    public final java.lang.String f(java.io.File file, java.lang.String str) {
        java.lang.String name = file.getName();
        if (!name.endsWith(".class")) {
            java.io.FileInputStream fileInputStream = null;
            try {
                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
                try {
                    java.lang.String className = org.apache.tools.ant.taskdefs.optional.jlink.ClassNameReader.getClassName(fileInputStream2);
                    if (className != null) {
                        java.lang.String str2 = className.replace('.', '/') + ".class";
                        org.apache.tools.ant.util.FileUtils.close(fileInputStream2);
                        return str2;
                    }
                    org.apache.tools.ant.util.FileUtils.close(fileInputStream2);
                } catch (java.io.IOException unused) {
                    fileInputStream = fileInputStream2;
                    org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                    java.lang.System.out.println("From " + file.getPath() + " and prefix " + str + ", creating entry " + str + name);
                    return str + name;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                    throw th;
                }
            } catch (java.io.IOException unused2) {
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        java.lang.System.out.println("From " + file.getPath() + " and prefix " + str + ", creating entry " + str + name);
        return str + name;
    }

    public final void g(java.util.zip.ZipOutputStream zipOutputStream, java.io.File file) throws java.io.IOException {
        if (file.exists()) {
            java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(file);
            try {
                java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    java.util.zip.ZipEntry nextElement = entries.nextElement();
                    if (nextElement.getName().indexOf("META-INF") < 0) {
                        try {
                            zipOutputStream.putNextEntry(h(zipFile, nextElement));
                            java.io.InputStream inputStream = zipFile.getInputStream(nextElement);
                            int length = this.e.length;
                            while (true) {
                                int read = inputStream.read(this.e, 0, length);
                                if (read <= 0) {
                                    break;
                                } else {
                                    zipOutputStream.write(this.e, 0, read);
                                }
                            }
                            inputStream.close();
                            zipOutputStream.closeEntry();
                        } catch (java.util.zip.ZipException e) {
                            if (!e.getMessage().contains("duplicate")) {
                                throw e;
                            }
                        }
                    }
                }
            } finally {
                zipFile.close();
            }
        }
    }

    public final java.util.zip.ZipEntry h(java.util.zip.ZipFile zipFile, java.util.zip.ZipEntry zipEntry) {
        java.lang.String name = zipEntry.getName();
        if (!zipEntry.isDirectory() && !name.endsWith(".class")) {
            try {
                java.io.InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(name));
                java.lang.String className = org.apache.tools.ant.taskdefs.optional.jlink.ClassNameReader.getClassName(inputStream);
                inputStream.close();
                if (className != null) {
                    name = className.replace('.', '/') + ".class";
                }
            } catch (java.io.IOException unused) {
            }
        }
        java.util.zip.ZipEntry zipEntry2 = new java.util.zip.ZipEntry(name);
        zipEntry2.setTime(zipEntry.getTime());
        zipEntry2.setExtra(zipEntry.getExtra());
        zipEntry2.setComment(zipEntry.getComment());
        zipEntry2.setTime(zipEntry.getTime());
        if (this.d) {
            zipEntry2.setMethod(8);
        } else {
            zipEntry2.setMethod(0);
            zipEntry2.setCrc(zipEntry.getCrc());
            zipEntry2.setSize(zipEntry.getSize());
        }
        return zipEntry2;
    }

    public void link() throws java.lang.Exception {
        java.util.zip.ZipOutputStream zipOutputStream = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(this.a));
        if (this.d) {
            zipOutputStream.setMethod(8);
            zipOutputStream.setLevel(-1);
        } else {
            zipOutputStream.setMethod(0);
        }
        java.util.Enumeration elements = this.b.elements();
        while (elements.hasMoreElements()) {
            java.lang.String str = (java.lang.String) elements.nextElement();
            java.io.File file = new java.io.File(str);
            if (file.getName().endsWith(".jar") || file.getName().endsWith(".zip")) {
                g(zipOutputStream, file);
            } else {
                addAddFile(str);
            }
        }
        java.util.Enumeration elements2 = this.c.elements();
        while (elements2.hasMoreElements()) {
            java.io.File file2 = new java.io.File((java.lang.String) elements2.nextElement());
            if (file2.isDirectory()) {
                a(zipOutputStream, file2, file2.getName() + '/', this.d);
            } else {
                b(zipOutputStream, file2, "", this.d);
            }
        }
        org.apache.tools.ant.util.FileUtils.close(zipOutputStream);
    }

    public void setCompression(boolean z) {
        this.d = z;
    }

    public void setOutfile(java.lang.String str) {
        if (str == null) {
            return;
        }
        this.a = str;
    }
}
