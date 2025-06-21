package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class FileUtils {
    public static final long FAT_FILE_TIMESTAMP_GRANULARITY = 2000;
    public static final long NTFS_FILE_TIMESTAMP_GRANULARITY = 1;
    public static final long UNIX_FILE_TIMESTAMP_GRANULARITY = 1000;
    public static final org.apache.tools.ant.util.FileUtils d = new org.apache.tools.ant.util.FileUtils();
    public static java.util.Random e = new java.util.Random(java.lang.System.currentTimeMillis() + java.lang.Runtime.getRuntime().freeMemory());
    public static final boolean f = org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_NETWARE);
    public static final boolean g = org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_DOS);
    public static final boolean h = org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_9X);
    public static final boolean i = org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS);
    public java.lang.Object a = new java.lang.Object();
    public java.lang.String b = null;
    public java.lang.String c = null;

    /* renamed from: org.apache.tools.ant.util.FileUtils$1, reason: invalid class name */
    public class AnonymousClass1 implements java.io.FilenameFilter {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return str.equalsIgnoreCase(this.a) && !str.equals(this.a);
        }
    }

    /* renamed from: org.apache.tools.ant.util.FileUtils$2, reason: invalid class name */
    public class AnonymousClass2 extends java.io.InputStream {
        public AnonymousClass2() {
        }

        @Override // java.io.InputStream
        public int read() {
            return -1;
        }
    }

    public static void close(java.io.InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void close(java.io.OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void close(java.io.Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void close(java.io.Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void close(java.net.URLConnection uRLConnection) {
        if (uRLConnection != null) {
            try {
                if (uRLConnection instanceof java.net.JarURLConnection) {
                    ((java.net.JarURLConnection) uRLConnection).getJarFile().close();
                } else if (uRLConnection instanceof java.net.HttpURLConnection) {
                    ((java.net.HttpURLConnection) uRLConnection).disconnect();
                }
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void close(java.nio.channels.Channel channel) {
        if (channel != null) {
            try {
                channel.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void delete(java.io.File file) {
        if (file != null) {
            file.delete();
        }
    }

    public static org.apache.tools.ant.util.FileUtils getFileUtils() {
        return d;
    }

    public static java.lang.String getPath(java.util.List list) {
        return getPath(list, '/');
    }

    public static java.lang.String getPath(java.util.List list, char c) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.util.Iterator it = list.iterator();
        if (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        while (it.hasNext()) {
            stringBuffer.append(c);
            stringBuffer.append(it.next());
        }
        return stringBuffer.toString();
    }

    public static java.lang.String[] getPathStack(java.lang.String str) {
        return str.replace(java.io.File.separatorChar, '/').split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
    }

    public static java.lang.String getRelativePath(java.io.File file, java.io.File file2) throws java.lang.Exception {
        java.lang.String canonicalPath = file.getCanonicalPath();
        java.lang.String canonicalPath2 = file2.getCanonicalPath();
        java.lang.String[] pathStack = getPathStack(canonicalPath);
        java.lang.String[] pathStack2 = getPathStack(canonicalPath2);
        if (pathStack2.length <= 0 || pathStack.length <= 0) {
            return getPath(java.util.Arrays.asList(pathStack2));
        }
        if (!pathStack[0].equals(pathStack2[0])) {
            return getPath(java.util.Arrays.asList(pathStack2));
        }
        int min = java.lang.Math.min(pathStack.length, pathStack2.length);
        int i2 = 1;
        while (i2 < min && pathStack[i2].equals(pathStack2[i2])) {
            i2++;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i3 = i2; i3 < pathStack.length; i3++) {
            arrayList.add("..");
        }
        while (i2 < pathStack2.length) {
            arrayList.add(pathStack2[i2]);
            i2++;
        }
        return getPath(arrayList);
    }

    public static boolean isAbsolutePath(java.lang.String str) {
        int indexOf;
        int length = str.length();
        if (length == 0) {
            return false;
        }
        char c = java.io.File.separatorChar;
        java.lang.String replace = str.replace('/', c).replace('\\', c);
        char charAt = replace.charAt(0);
        boolean z = g;
        if (!z && !f) {
            return charAt == c;
        }
        if (charAt == c) {
            return z && length > 4 && replace.charAt(1) == c && (indexOf = replace.indexOf(c, 2)) > 2 && indexOf + 1 < length;
        }
        int indexOf2 = replace.indexOf(58);
        return (java.lang.Character.isLetter(charAt) && indexOf2 == 1 && replace.length() > 2 && replace.charAt(2) == c) || (f && indexOf2 > 0);
    }

    public static boolean isContextRelativePath(java.lang.String str) {
        if ((!g && !f) || str.length() == 0) {
            return false;
        }
        char c = java.io.File.separatorChar;
        java.lang.String replace = str.replace('/', c).replace('\\', c);
        char charAt = replace.charAt(0);
        int length = replace.length();
        if (charAt != c || (length != 1 && replace.charAt(1) == c)) {
            if (!java.lang.Character.isLetter(charAt) || length <= 1 || replace.charAt(1) != ':') {
                return false;
            }
            if (length != 2 && replace.charAt(2) == c) {
                return false;
            }
        }
        return true;
    }

    public static org.apache.tools.ant.util.FileUtils newFileUtils() {
        return new org.apache.tools.ant.util.FileUtils();
    }

    public static java.lang.String readFully(java.io.Reader reader) throws java.io.IOException {
        return readFully(reader, 8192);
    }

    public static java.lang.String readFully(java.io.Reader reader, int i2) throws java.io.IOException {
        if (i2 <= 0) {
            throw new java.lang.IllegalArgumentException("Buffer size must be greater than 0");
        }
        char[] cArr = new char[i2];
        java.lang.StringBuffer stringBuffer = null;
        int i3 = 0;
        while (i3 != -1) {
            i3 = reader.read(cArr);
            if (i3 > 0) {
                if (stringBuffer == null) {
                    stringBuffer = new java.lang.StringBuffer();
                }
                stringBuffer.append(new java.lang.String(cArr, 0, i3));
            }
        }
        if (stringBuffer == null) {
            return null;
        }
        return stringBuffer.toString();
    }

    public static java.lang.String safeReadFully(java.io.Reader reader) throws java.io.IOException {
        java.lang.String readFully = readFully(reader);
        return readFully == null ? "" : readFully;
    }

    public static java.lang.String translatePath(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str.length() + 50);
        org.apache.tools.ant.PathTokenizer pathTokenizer = new org.apache.tools.ant.PathTokenizer(str);
        while (pathTokenizer.hasMoreTokens()) {
            java.lang.String replace = pathTokenizer.nextToken().replace('/', java.io.File.separatorChar).replace('\\', java.io.File.separatorChar);
            if (stringBuffer.length() != 0) {
                stringBuffer.append(java.io.File.pathSeparatorChar);
            }
            stringBuffer.append(replace);
        }
        return stringBuffer.toString();
    }

    public boolean areSame(java.io.File file, java.io.File file2) throws java.io.IOException {
        if (file == null && file2 == null) {
            return true;
        }
        if (file == null || file2 == null) {
            return false;
        }
        java.io.File normalize = normalize(file.getAbsolutePath());
        java.io.File normalize2 = normalize(file2.getAbsolutePath());
        return normalize.equals(normalize2) || normalize.getCanonicalFile().equals(normalize2.getCanonicalFile());
    }

    public boolean contentEquals(java.io.File file, java.io.File file2) throws java.io.IOException {
        return contentEquals(file, file2, false);
    }

    public boolean contentEquals(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        return org.apache.tools.ant.util.ResourceUtils.contentEquals(new org.apache.tools.ant.types.resources.FileResource(file), new org.apache.tools.ant.types.resources.FileResource(file2), z);
    }

    public void copyFile(java.io.File file, java.io.File file2) throws java.io.IOException {
        copyFile(file, file2, (org.apache.tools.ant.types.FilterSetCollection) null, false, false);
    }

    public void copyFile(java.io.File file, java.io.File file2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection) throws java.io.IOException {
        copyFile(file, file2, filterSetCollection, false, false);
    }

    public void copyFile(java.io.File file, java.io.File file2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, java.util.Vector vector, boolean z, boolean z2, java.lang.String str, java.lang.String str2, org.apache.tools.ant.Project project) throws java.io.IOException {
        copyFile(file, file2, filterSetCollection, vector, z, z2, false, str, str2, project);
    }

    public void copyFile(java.io.File file, java.io.File file2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, java.util.Vector vector, boolean z, boolean z2, java.lang.String str, org.apache.tools.ant.Project project) throws java.io.IOException {
        copyFile(file, file2, filterSetCollection, vector, z, z2, str, str, project);
    }

    public void copyFile(java.io.File file, java.io.File file2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, java.util.Vector vector, boolean z, boolean z2, boolean z3, java.lang.String str, java.lang.String str2, org.apache.tools.ant.Project project) throws java.io.IOException {
        copyFile(file, file2, filterSetCollection, vector, z, z2, z3, str, str2, project, false);
    }

    public void copyFile(java.io.File file, java.io.File file2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, java.util.Vector vector, boolean z, boolean z2, boolean z3, java.lang.String str, java.lang.String str2, org.apache.tools.ant.Project project, boolean z4) throws java.io.IOException {
        org.apache.tools.ant.util.ResourceUtils.copyResource(new org.apache.tools.ant.types.resources.FileResource(file), new org.apache.tools.ant.types.resources.FileResource(file2), filterSetCollection, vector, z, z2, z3, str, str2, project, z4);
    }

    public void copyFile(java.io.File file, java.io.File file2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, boolean z) throws java.io.IOException {
        copyFile(file, file2, filterSetCollection, z, false);
    }

    public void copyFile(java.io.File file, java.io.File file2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, boolean z, boolean z2) throws java.io.IOException {
        copyFile(file, file2, filterSetCollection, z, z2, (java.lang.String) null);
    }

    public void copyFile(java.io.File file, java.io.File file2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, boolean z, boolean z2, java.lang.String str) throws java.io.IOException {
        copyFile(file, file2, filterSetCollection, (java.util.Vector) null, z, z2, str, (org.apache.tools.ant.Project) null);
    }

    public void copyFile(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        copyFile(new java.io.File(str), new java.io.File(str2), (org.apache.tools.ant.types.FilterSetCollection) null, false, false);
    }

    public void copyFile(java.lang.String str, java.lang.String str2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection) throws java.io.IOException {
        copyFile(new java.io.File(str), new java.io.File(str2), filterSetCollection, false, false);
    }

    public void copyFile(java.lang.String str, java.lang.String str2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, java.util.Vector vector, boolean z, boolean z2, java.lang.String str3, java.lang.String str4, org.apache.tools.ant.Project project) throws java.io.IOException {
        copyFile(new java.io.File(str), new java.io.File(str2), filterSetCollection, vector, z, z2, str3, str4, project);
    }

    public void copyFile(java.lang.String str, java.lang.String str2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, java.util.Vector vector, boolean z, boolean z2, java.lang.String str3, org.apache.tools.ant.Project project) throws java.io.IOException {
        copyFile(new java.io.File(str), new java.io.File(str2), filterSetCollection, vector, z, z2, str3, project);
    }

    public void copyFile(java.lang.String str, java.lang.String str2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, boolean z) throws java.io.IOException {
        copyFile(new java.io.File(str), new java.io.File(str2), filterSetCollection, z, false);
    }

    public void copyFile(java.lang.String str, java.lang.String str2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, boolean z, boolean z2) throws java.io.IOException {
        copyFile(new java.io.File(str), new java.io.File(str2), filterSetCollection, z, z2);
    }

    public void copyFile(java.lang.String str, java.lang.String str2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, boolean z, boolean z2, java.lang.String str3) throws java.io.IOException {
        copyFile(new java.io.File(str), new java.io.File(str2), filterSetCollection, z, z2, str3);
    }

    public boolean createNewFile(java.io.File file) throws java.io.IOException {
        return file.createNewFile();
    }

    public boolean createNewFile(java.io.File file, boolean z) throws java.io.IOException {
        java.io.File parentFile = file.getParentFile();
        if (z && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        return file.createNewFile();
    }

    public java.io.File createTempFile(java.lang.String str, java.lang.String str2, java.io.File file) {
        return createTempFile(str, str2, file, false, false);
    }

    public java.io.File createTempFile(java.lang.String str, java.lang.String str2, java.io.File file, boolean z) {
        return createTempFile(str, str2, file, z, false);
    }

    public java.io.File createTempFile(java.lang.String str, java.lang.String str2, java.io.File file, boolean z, boolean z2) {
        return createTempFile(null, str, str2, file, z, z2);
    }

    public java.io.File createTempFile(org.apache.tools.ant.Project project, java.lang.String str, java.lang.String str2, java.io.File file, boolean z, boolean z2) {
        java.io.File createTempFile;
        java.io.File file2;
        java.lang.String path = file != null ? file.getPath() : (project == null || project.getProperty(org.apache.tools.ant.MagicNames.TMPDIR) == null) ? java.lang.System.getProperty("java.io.tmpdir") : project.getProperty(org.apache.tools.ant.MagicNames.TMPDIR);
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        if (str2 == null) {
            str2 = com.igexin.push.core.b.m;
        }
        if (z2) {
            try {
                createTempFile = java.io.File.createTempFile(str, str2, new java.io.File(path));
            } catch (java.io.IOException e2) {
                throw new org.apache.tools.ant.BuildException("Could not create tempfile in " + path, e2);
            }
        } else {
            java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#####");
            synchronized (e) {
                do {
                    file2 = new java.io.File(path, str + decimalFormat.format(e.nextInt(Integer.MAX_VALUE)) + str2);
                } while (file2.exists());
            }
            createTempFile = file2;
        }
        if (z) {
            createTempFile.deleteOnExit();
        }
        return createTempFile;
    }

    public java.lang.String[] dissect(java.lang.String str) {
        java.lang.String str2;
        java.lang.String substring;
        char c = java.io.File.separatorChar;
        java.lang.String replace = str.replace('/', c).replace('\\', c);
        if (!isAbsolutePath(replace)) {
            throw new org.apache.tools.ant.BuildException(replace + " is not an absolute path");
        }
        int indexOf = replace.indexOf(58);
        if (indexOf > 0 && (g || f)) {
            int i2 = indexOf + 1;
            java.lang.String substring2 = replace.substring(0, i2);
            char[] charArray = replace.toCharArray();
            str2 = substring2 + c;
            if (charArray[i2] == c) {
                i2++;
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            while (i2 < charArray.length) {
                char c2 = charArray[i2];
                if (c2 != c || charArray[i2 - 1] != c) {
                    stringBuffer.append(c2);
                }
                i2++;
            }
            substring = stringBuffer.toString();
        } else if (replace.length() <= 1 || replace.charAt(1) != c) {
            str2 = java.io.File.separator;
            substring = replace.substring(1);
        } else {
            int indexOf2 = replace.indexOf(c, replace.indexOf(c, 2) + 1);
            str2 = indexOf2 > 2 ? replace.substring(0, indexOf2 + 1) : replace;
            substring = replace.substring(str2.length());
        }
        return new java.lang.String[]{str2, substring};
    }

    public boolean fileNameEquals(java.io.File file, java.io.File file2) {
        return normalize(file.getAbsolutePath()).getAbsolutePath().equals(normalize(file2.getAbsolutePath()).getAbsolutePath());
    }

    public java.lang.String fromURI(java.lang.String str) {
        synchronized (this.a) {
            if (str.equals(this.b)) {
                return this.c;
            }
            java.lang.String fromURI = org.apache.tools.ant.launch.Locator.fromURI(str);
            if (isAbsolutePath(fromURI)) {
                fromURI = normalize(fromURI).getAbsolutePath();
            }
            this.b = str;
            this.c = fromURI;
            return fromURI;
        }
    }

    public java.lang.String getDefaultEncoding() {
        java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(new org.apache.tools.ant.util.FileUtils.AnonymousClass2());
        try {
            return inputStreamReader.getEncoding();
        } finally {
            close(inputStreamReader);
        }
    }

    public long getFileTimestampGranularity() {
        if (h) {
            return 2000L;
        }
        if (i) {
            return 1L;
        }
        return g ? 2000L : 1000L;
    }

    public java.net.URL getFileURL(java.io.File file) throws java.net.MalformedURLException {
        return new java.net.URL(file.toURI().toASCIIString());
    }

    public java.io.File getParentFile(java.io.File file) {
        if (file == null) {
            return null;
        }
        return file.getParentFile();
    }

    public boolean hasErrorInCase(java.io.File file) {
        java.io.File normalize = normalize(file.getAbsolutePath());
        if (!normalize.exists()) {
            return false;
        }
        java.lang.String[] list = normalize.getParentFile().list(new org.apache.tools.ant.util.FileUtils.AnonymousClass1(normalize.getName()));
        return list != null && list.length == 1;
    }

    public boolean isLeadingPath(java.io.File file, java.io.File file2) {
        java.lang.String absolutePath = normalize(file.getAbsolutePath()).getAbsolutePath();
        java.lang.String absolutePath2 = normalize(file2.getAbsolutePath()).getAbsolutePath();
        if (absolutePath.equals(absolutePath2)) {
            return true;
        }
        java.lang.String str = java.io.File.separator;
        if (!absolutePath.endsWith(str)) {
            absolutePath = absolutePath + str;
        }
        java.lang.String str2 = str + ".." + str;
        if (absolutePath.contains(str2) || absolutePath2.contains(str2)) {
            return false;
        }
        if ((absolutePath2 + str).contains(str2)) {
            return false;
        }
        return absolutePath2.startsWith(absolutePath);
    }

    public boolean isLeadingPath(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        if (!z) {
            return isLeadingPath(file, file2);
        }
        java.io.File canonicalFile = file.getCanonicalFile();
        java.io.File canonicalFile2 = file2.getCanonicalFile();
        while (!canonicalFile.equals(canonicalFile2)) {
            canonicalFile2 = canonicalFile2.getParentFile();
            if (canonicalFile2 == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isSymbolicLink(java.io.File file, java.lang.String str) throws java.io.IOException {
        org.apache.tools.ant.util.SymbolicLinkUtils symbolicLinkUtils = org.apache.tools.ant.util.SymbolicLinkUtils.getSymbolicLinkUtils();
        return file == null ? symbolicLinkUtils.isSymbolicLink(str) : symbolicLinkUtils.isSymbolicLink(file, str);
    }

    public boolean isUpToDate(long j, long j2) {
        return isUpToDate(j, j2, getFileTimestampGranularity());
    }

    public boolean isUpToDate(long j, long j2, long j3) {
        return j2 != -1 && j2 >= j + j3;
    }

    public boolean isUpToDate(java.io.File file, java.io.File file2) {
        return isUpToDate(file, file2, getFileTimestampGranularity());
    }

    public boolean isUpToDate(java.io.File file, java.io.File file2, long j) {
        if (file2.exists()) {
            return isUpToDate(file.lastModified(), file2.lastModified(), j);
        }
        return false;
    }

    public java.io.File normalize(java.lang.String str) {
        java.util.Stack stack = new java.util.Stack();
        java.lang.String[] dissect = dissect(str);
        stack.push(dissect[0]);
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(dissect[1], java.io.File.separator);
        while (stringTokenizer.hasMoreTokens()) {
            java.lang.String nextToken = stringTokenizer.nextToken();
            if (!".".equals(nextToken)) {
                if (!"..".equals(nextToken)) {
                    stack.push(nextToken);
                } else {
                    if (stack.size() < 2) {
                        return new java.io.File(str);
                    }
                    stack.pop();
                }
            }
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        int size = stack.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 1) {
                stringBuffer.append(java.io.File.separatorChar);
            }
            stringBuffer.append(stack.elementAt(i2));
        }
        return new java.io.File(stringBuffer.toString());
    }

    public java.lang.String removeLeadingPath(java.io.File file, java.io.File file2) {
        java.lang.String absolutePath = normalize(file.getAbsolutePath()).getAbsolutePath();
        java.lang.String absolutePath2 = normalize(file2.getAbsolutePath()).getAbsolutePath();
        if (absolutePath.equals(absolutePath2)) {
            return "";
        }
        java.lang.String str = java.io.File.separator;
        if (!absolutePath.endsWith(str)) {
            absolutePath = absolutePath + str;
        }
        return absolutePath2.startsWith(absolutePath) ? absolutePath2.substring(absolutePath.length()) : absolutePath2;
    }

    public void rename(java.io.File file, java.io.File file2) throws java.io.IOException {
        java.io.File canonicalFile = normalize(file.getAbsolutePath()).getCanonicalFile();
        java.io.File normalize = normalize(file2.getAbsolutePath());
        if (!canonicalFile.exists()) {
            java.lang.System.err.println("Cannot rename nonexistent file " + canonicalFile);
            return;
        }
        if (canonicalFile.getAbsolutePath().equals(normalize.getAbsolutePath())) {
            java.lang.System.err.println("Rename of " + canonicalFile + " to " + normalize + " is a no-op.");
            return;
        }
        if (normalize.exists() && !areSame(canonicalFile, normalize) && !tryHardToDelete(normalize)) {
            throw new java.io.IOException("Failed to delete " + normalize + " while trying to rename " + canonicalFile);
        }
        java.io.File parentFile = normalize.getParentFile();
        if (parentFile != null && !parentFile.isDirectory() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new java.io.IOException("Failed to create directory " + parentFile + " while trying to rename " + canonicalFile);
        }
        if (canonicalFile.renameTo(normalize)) {
            return;
        }
        copyFile(canonicalFile, normalize);
        if (tryHardToDelete(canonicalFile)) {
            return;
        }
        throw new java.io.IOException("Failed to delete " + canonicalFile + " while trying to rename it.");
    }

    public java.io.File resolveFile(java.io.File file, java.lang.String str) {
        if (!isAbsolutePath(str)) {
            char c = java.io.File.separatorChar;
            java.lang.String replace = str.replace('/', c).replace('\\', c);
            if (isContextRelativePath(replace)) {
                java.lang.String property = java.lang.System.getProperty("user.dir");
                if (replace.charAt(0) == c && property.charAt(0) == c) {
                    replace = dissect(property)[0] + replace.substring(1);
                }
                file = null;
            }
            str = new java.io.File(file, replace).getAbsolutePath();
        }
        return normalize(str);
    }

    public void setFileLastModified(java.io.File file, long j) {
        org.apache.tools.ant.util.ResourceUtils.setLastModified(new org.apache.tools.ant.types.resources.FileResource(file), j);
    }

    public java.lang.String toURI(java.lang.String str) {
        return new java.io.File(str).toURI().toASCIIString();
    }

    public java.lang.String toVMSPath(java.io.File file) {
        java.lang.String str;
        int i2;
        java.lang.String substring;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String path = normalize(file.getAbsolutePath()).getPath();
        java.lang.String name = file.getName();
        boolean z = path.charAt(0) == java.io.File.separatorChar;
        boolean z2 = file.isDirectory() && !name.regionMatches(true, name.length() + (-4), ".DIR", 0, 4);
        java.lang.StringBuffer stringBuffer = null;
        if (z) {
            int indexOf = path.indexOf(java.io.File.separatorChar, 1);
            if (indexOf == -1) {
                return path.substring(1) + ":[000000]";
            }
            i2 = indexOf + 1;
            str = path.substring(1, indexOf);
        } else {
            str = null;
            i2 = 0;
        }
        if (z2) {
            stringBuffer = new java.lang.StringBuffer(path.substring(i2).replace(java.io.File.separatorChar, '.'));
            substring = null;
        } else {
            int lastIndexOf = path.lastIndexOf(java.io.File.separatorChar, path.length());
            if (lastIndexOf == -1 || lastIndexOf < i2) {
                substring = path.substring(i2);
            } else {
                java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer(path.substring(i2, lastIndexOf).replace(java.io.File.separatorChar, '.'));
                int i3 = lastIndexOf + 1;
                substring = path.length() > i3 ? path.substring(i3) : null;
                stringBuffer = stringBuffer2;
            }
        }
        if (!z && stringBuffer != null) {
            stringBuffer.insert(0, '.');
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (str != null) {
            str2 = str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR;
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (stringBuffer != null) {
            str3 = "[" + ((java.lang.Object) stringBuffer) + "]";
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (substring == null) {
            substring = "";
        }
        sb.append(substring);
        return sb.toString();
    }

    public boolean tryHardToDelete(java.io.File file) {
        return tryHardToDelete(file, i);
    }

    public boolean tryHardToDelete(java.io.File file, boolean z) {
        if (file.delete()) {
            return true;
        }
        if (z) {
            java.lang.System.gc();
        }
        try {
            java.lang.Thread.sleep(10L);
        } catch (java.lang.InterruptedException unused) {
        }
        return file.delete();
    }
}
