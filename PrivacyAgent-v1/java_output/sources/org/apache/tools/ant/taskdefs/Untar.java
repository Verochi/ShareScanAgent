package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Untar extends org.apache.tools.ant.taskdefs.Expand {
    public org.apache.tools.ant.taskdefs.Untar.UntarCompressionMethod H;

    public static final class UntarCompressionMethod extends org.apache.tools.ant.types.EnumeratedAttribute {
        public UntarCompressionMethod() {
            setValue("none");
        }

        public java.io.InputStream decompress(java.lang.String str, java.io.InputStream inputStream) throws java.io.IOException, org.apache.tools.ant.BuildException {
            java.lang.String value = getValue();
            if ("gzip".equals(value)) {
                return new java.util.zip.GZIPInputStream(inputStream);
            }
            if (!"bzip2".equals(value)) {
                return inputStream;
            }
            char[] cArr = {'B', 'Z'};
            for (int i = 0; i < 2; i++) {
                if (inputStream.read() != cArr[i]) {
                    throw new org.apache.tools.ant.BuildException("Invalid bz2 file." + str);
                }
            }
            return new org.apache.tools.bzip2.CBZip2InputStream(inputStream);
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"none", "gzip", "bzip2"};
        }
    }

    public Untar() {
        super(null);
        this.H = new org.apache.tools.ant.taskdefs.Untar.UntarCompressionMethod();
    }

    public final void c(java.lang.String str, java.io.InputStream inputStream, java.io.File file) throws java.io.IOException {
        org.apache.tools.tar.TarInputStream tarInputStream = null;
        try {
            org.apache.tools.tar.TarInputStream tarInputStream2 = new org.apache.tools.tar.TarInputStream(this.H.decompress(str, new java.io.BufferedInputStream(inputStream)), getEncoding());
            try {
                log("Expanding: " + str + " into " + file, 2);
                org.apache.tools.ant.util.FileNameMapper mapper = getMapper();
                boolean z = true;
                while (true) {
                    org.apache.tools.tar.TarEntry nextEntry = tarInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    extractFile(org.apache.tools.ant.util.FileUtils.getFileUtils(), null, file, tarInputStream2, nextEntry.getName(), nextEntry.getModTime(), nextEntry.isDirectory(), mapper);
                    z = false;
                }
                if (z && getFailOnEmptyArchive()) {
                    throw new org.apache.tools.ant.BuildException("archive '" + str + "' is empty");
                }
                log("expand complete", 3);
                org.apache.tools.ant.util.FileUtils.close(tarInputStream2);
            } catch (java.lang.Throwable th) {
                th = th;
                tarInputStream = tarInputStream2;
                org.apache.tools.ant.util.FileUtils.close(tarInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.Expand
    public void expandFile(org.apache.tools.ant.util.FileUtils fileUtils, java.io.File file, java.io.File file2) {
        java.io.FileInputStream fileInputStream;
        java.lang.Throwable th;
        java.io.IOException e;
        if (!file.exists()) {
            throw new org.apache.tools.ant.BuildException("Unable to untar " + file + " as the file does not exist", getLocation());
        }
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                try {
                    c(file.getPath(), fileInputStream, file2);
                    org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                } catch (java.io.IOException e2) {
                    e = e2;
                    throw new org.apache.tools.ant.BuildException("Error while expanding " + file.getPath() + "\n" + e.toString(), e, getLocation());
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                throw th;
            }
        } catch (java.io.IOException e3) {
            fileInputStream = null;
            e = e3;
        } catch (java.lang.Throwable th3) {
            fileInputStream = null;
            th = th3;
            org.apache.tools.ant.util.FileUtils.close(fileInputStream);
            throw th;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.Expand
    public void expandResource(org.apache.tools.ant.types.Resource resource, java.io.File file) {
        if (!resource.isExists()) {
            throw new org.apache.tools.ant.BuildException("Unable to untar " + resource.getName() + " as the it does not exist", getLocation());
        }
        java.io.InputStream inputStream = null;
        try {
            try {
                inputStream = resource.getInputStream();
                c(resource.getName(), inputStream, file);
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException("Error while expanding " + resource.getName(), e, getLocation());
            }
        } finally {
            org.apache.tools.ant.util.FileUtils.close(inputStream);
        }
    }

    public void setCompression(org.apache.tools.ant.taskdefs.Untar.UntarCompressionMethod untarCompressionMethod) {
        this.H = untarCompressionMethod;
    }

    @Override // org.apache.tools.ant.taskdefs.Expand
    public void setScanForUnicodeExtraFields(boolean z) {
        throw new org.apache.tools.ant.BuildException("The " + getTaskName() + " task doesn't support the encoding attribute", getLocation());
    }
}
