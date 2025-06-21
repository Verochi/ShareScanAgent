package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ResourceUtils {
    public static final java.lang.String ISO_8859_1 = "ISO-8859-1";
    public static final org.apache.tools.ant.util.FileUtils a = org.apache.tools.ant.util.FileUtils.getFileUtils();

    /* renamed from: org.apache.tools.ant.util.ResourceUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements org.apache.tools.ant.util.ResourceUtils.ResourceSelectorProvider {
        public final /* synthetic */ long a;

        /* renamed from: org.apache.tools.ant.util.ResourceUtils$1$1, reason: invalid class name and collision with other inner class name */
        public class C05421 implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
            public final /* synthetic */ org.apache.tools.ant.types.Resource n;

            public C05421(org.apache.tools.ant.types.Resource resource) {
                this.n = resource;
            }

            @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
            public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
                return org.apache.tools.ant.types.selectors.SelectorUtils.isOutOfDate(this.n, resource, org.apache.tools.ant.util.ResourceUtils.AnonymousClass1.this.a);
            }
        }

        public AnonymousClass1(long j) {
            this.a = j;
        }

        @Override // org.apache.tools.ant.util.ResourceUtils.ResourceSelectorProvider
        public org.apache.tools.ant.types.resources.selectors.ResourceSelector getTargetSelectorForSource(org.apache.tools.ant.types.Resource resource) {
            return new org.apache.tools.ant.util.ResourceUtils.AnonymousClass1.C05421(resource);
        }
    }

    public static class ReadOnlyTargetFileException extends java.io.IOException {
        private static final long serialVersionUID = 1;

        public ReadOnlyTargetFileException(java.io.File file) {
            super("can't write to read-only destination file " + file);
        }
    }

    public interface ResourceSelectorProvider {
        org.apache.tools.ant.types.resources.selectors.ResourceSelector getTargetSelectorForSource(org.apache.tools.ant.types.Resource resource);
    }

    public static boolean a(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) throws java.io.IOException {
        org.apache.tools.ant.types.resources.FileProvider fileProvider;
        org.apache.tools.ant.types.resources.FileProvider fileProvider2;
        if (resource == null || resource2 == null || (fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class)) == null || (fileProvider2 = (org.apache.tools.ant.types.resources.FileProvider) resource2.as(org.apache.tools.ant.types.resources.FileProvider.class)) == null) {
            return false;
        }
        return org.apache.tools.ant.util.FileUtils.getFileUtils().areSame(fileProvider.getFile(), fileProvider2.getFile());
    }

    public static org.apache.tools.ant.types.resources.FileResource asFileResource(org.apache.tools.ant.types.resources.FileProvider fileProvider) {
        if ((fileProvider instanceof org.apache.tools.ant.types.resources.FileResource) || fileProvider == null) {
            return (org.apache.tools.ant.types.resources.FileResource) fileProvider;
        }
        org.apache.tools.ant.types.resources.FileResource fileResource = new org.apache.tools.ant.types.resources.FileResource(fileProvider.getFile());
        fileResource.setProject(org.apache.tools.ant.Project.getProject(fileProvider));
        return fileResource;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if (r3.read() != (-1)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        r0 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) throws java.io.IOException {
        java.io.BufferedInputStream bufferedInputStream;
        int i;
        java.io.BufferedInputStream bufferedInputStream2 = null;
        try {
            java.io.BufferedInputStream bufferedInputStream3 = new java.io.BufferedInputStream(resource.getInputStream());
            try {
                bufferedInputStream = new java.io.BufferedInputStream(resource2.getInputStream());
                while (true) {
                    try {
                        int read = bufferedInputStream3.read();
                        i = -1;
                        if (read == -1) {
                            break;
                        }
                        int read2 = bufferedInputStream.read();
                        if (read != read2) {
                            if (read > read2) {
                                i = 1;
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedInputStream2 = bufferedInputStream3;
                        org.apache.tools.ant.util.FileUtils.close(bufferedInputStream2);
                        org.apache.tools.ant.util.FileUtils.close(bufferedInputStream);
                        throw th;
                    }
                }
                org.apache.tools.ant.util.FileUtils.close(bufferedInputStream3);
                org.apache.tools.ant.util.FileUtils.close(bufferedInputStream);
                return i;
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
    }

    public static void c(java.io.File file, java.io.File file2, org.apache.tools.ant.Project project) throws java.io.IOException {
        java.nio.channels.FileChannel fileChannel;
        java.io.FileOutputStream fileOutputStream;
        java.io.FileInputStream fileInputStream;
        if (org.apache.tools.ant.util.FileUtils.getFileUtils().areSame(file, file2)) {
            h(project, "Skipping (self) copy of " + file + " to " + file2);
            return;
        }
        java.io.File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.isDirectory() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new java.io.IOException("failed to create the parent directory for " + file2);
        }
        java.nio.channels.FileChannel fileChannel2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file2);
                try {
                    java.nio.channels.FileChannel channel = fileInputStream.getChannel();
                    try {
                        fileChannel2 = fileOutputStream2.getChannel();
                        long size = channel.size();
                        for (long j = 0; j < size; j += fileChannel2.transferFrom(channel, j, java.lang.Math.min(16777216L, size - j))) {
                        }
                        org.apache.tools.ant.util.FileUtils.close(channel);
                        org.apache.tools.ant.util.FileUtils.close(fileChannel2);
                        org.apache.tools.ant.util.FileUtils.close(fileOutputStream2);
                        org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        fileChannel = fileChannel2;
                        fileChannel2 = channel;
                        org.apache.tools.ant.util.FileUtils.close(fileChannel2);
                        org.apache.tools.ant.util.FileUtils.close(fileChannel);
                        org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                        org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    fileChannel = null;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileChannel = null;
                fileOutputStream = null;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileChannel = null;
            fileOutputStream = null;
            fileInputStream = null;
        }
    }

    public static int compareContent(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2, boolean z) throws java.io.IOException {
        if (resource.equals(resource2)) {
            return 0;
        }
        boolean isExists = resource.isExists();
        boolean isExists2 = resource2.isExists();
        if (!isExists && !isExists2) {
            return 0;
        }
        if (isExists != isExists2) {
            return isExists ? 1 : -1;
        }
        boolean isDirectory = resource.isDirectory();
        boolean isDirectory2 = resource2.isDirectory();
        if (isDirectory && isDirectory2) {
            return 0;
        }
        return (isDirectory || isDirectory2) ? isDirectory ? -1 : 1 : z ? k(resource, resource2) : b(resource, resource2);
    }

    public static boolean contentEquals(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2, boolean z) throws java.io.IOException {
        if (resource.isExists() != resource2.isExists()) {
            return false;
        }
        if (!resource.isExists()) {
            return true;
        }
        if (resource.isDirectory() || resource2.isDirectory()) {
            return false;
        }
        if (resource.equals(resource2)) {
            return true;
        }
        if (!z) {
            long size = resource.getSize();
            long size2 = resource2.getSize();
            if (size != -1 && size2 != -1 && size != size2) {
                return false;
            }
        }
        return compareContent(resource, resource2, z) == 0;
    }

    public static void copyResource(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) throws java.io.IOException {
        copyResource(resource, resource2, null);
    }

    public static void copyResource(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2, org.apache.tools.ant.Project project) throws java.io.IOException {
        copyResource(resource, resource2, null, null, false, false, null, null, project);
    }

    public static void copyResource(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, java.util.Vector vector, boolean z, boolean z2, java.lang.String str, java.lang.String str2, org.apache.tools.ant.Project project) throws java.io.IOException {
        copyResource(resource, resource2, filterSetCollection, vector, z, z2, false, str, str2, project);
    }

    public static void copyResource(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, java.util.Vector vector, boolean z, boolean z2, boolean z3, java.lang.String str, java.lang.String str2, org.apache.tools.ant.Project project) throws java.io.IOException {
        copyResource(resource, resource2, filterSetCollection, vector, z, z2, z3, str, str2, project, false);
    }

    public static void copyResource(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, java.util.Vector vector, boolean z, boolean z2, boolean z3, java.lang.String str, java.lang.String str2, org.apache.tools.ant.Project project, boolean z4) throws java.io.IOException {
        org.apache.tools.ant.types.resources.Touchable touchable;
        if (z || org.apache.tools.ant.types.selectors.SelectorUtils.isOutOfDate(resource, resource2, org.apache.tools.ant.util.FileUtils.getFileUtils().getFileTimestampGranularity())) {
            boolean z5 = false;
            boolean z6 = filterSetCollection != null && filterSetCollection.hasFilters();
            boolean z7 = vector != null && vector.size() > 0;
            java.lang.String encoding = resource instanceof org.apache.tools.ant.types.resources.StringResource ? ((org.apache.tools.ant.types.resources.StringResource) resource).getEncoding() : str;
            java.io.File file = resource2.as(org.apache.tools.ant.types.resources.FileProvider.class) != null ? ((org.apache.tools.ant.types.resources.FileProvider) resource2.as(org.apache.tools.ant.types.resources.FileProvider.class)).getFile() : null;
            if (file != null && file.isFile() && !file.canWrite()) {
                if (!z4) {
                    throw new org.apache.tools.ant.util.ResourceUtils.ReadOnlyTargetFileException(file);
                }
                if (!a.tryHardToDelete(file)) {
                    throw new java.io.IOException("failed to delete read-only destination file " + file);
                }
            }
            if (z6) {
                f(resource, resource2, filterSetCollection, vector, z7, z3, encoding, str2, project);
            } else if (z7 || (!(encoding == null || encoding.equals(str2)) || (encoding == null && str2 != null))) {
                e(resource, resource2, vector, z7, z3, encoding, str2, project);
            } else {
                if (resource.as(org.apache.tools.ant.types.resources.FileProvider.class) != null && file != null && !z3) {
                    java.io.File file2 = ((org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class)).getFile();
                    try {
                        c(file2, file, project);
                        z5 = true;
                    } catch (java.io.IOException e) {
                        java.lang.String str3 = "Attempt to copy " + file2 + " to " + file + " using NIO Channels failed due to '" + e.getMessage() + "'.  Falling back to streams.";
                        if (project != null) {
                            project.log(str3, 1);
                        } else {
                            java.lang.System.err.println(str3);
                        }
                    }
                }
                if (!z5) {
                    d(resource, resource2, z3, project);
                }
            }
            if (!z2 || (touchable = (org.apache.tools.ant.types.resources.Touchable) resource2.as(org.apache.tools.ant.types.resources.Touchable.class)) == null) {
                return;
            }
            setLastModified(touchable, resource.getLastModified());
        }
    }

    public static void d(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2, boolean z, org.apache.tools.ant.Project project) throws java.io.IOException {
        java.io.InputStream inputStream;
        if (a(resource, resource2)) {
            h(project, "Skipping (self) copy of " + resource + " to " + resource2);
            return;
        }
        java.io.OutputStream outputStream = null;
        try {
            inputStream = resource.getInputStream();
            try {
                outputStream = g(resource2, z, project);
                byte[] bArr = new byte[8192];
                int i = 0;
                do {
                    outputStream.write(bArr, 0, i);
                    i = inputStream.read(bArr, 0, 8192);
                } while (i != -1);
                org.apache.tools.ant.util.FileUtils.close(outputStream);
                org.apache.tools.ant.util.FileUtils.close(inputStream);
            } catch (java.lang.Throwable th) {
                th = th;
                org.apache.tools.ant.util.FileUtils.close(outputStream);
                org.apache.tools.ant.util.FileUtils.close(inputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static void e(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2, java.util.Vector vector, boolean z, boolean z2, java.lang.String str, java.lang.String str2, org.apache.tools.ant.Project project) throws java.io.IOException {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2;
        if (a(resource, resource2)) {
            h(project, "Skipping (self) copy of " + resource + " to " + resource2);
            return;
        }
        java.io.BufferedWriter bufferedWriter = null;
        try {
            java.io.BufferedReader bufferedReader3 = new java.io.BufferedReader(str == null ? new java.io.InputStreamReader(resource.getInputStream()) : new java.io.InputStreamReader(resource.getInputStream(), str));
            try {
                java.io.OutputStream g = g(resource2, z2, project);
                java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(str2 == null ? new java.io.OutputStreamWriter(g) : new java.io.OutputStreamWriter(g, str2));
                if (z) {
                    try {
                        org.apache.tools.ant.filters.util.ChainReaderHelper chainReaderHelper = new org.apache.tools.ant.filters.util.ChainReaderHelper();
                        chainReaderHelper.setBufferSize(8192);
                        chainReaderHelper.setPrimaryReader(bufferedReader3);
                        chainReaderHelper.setFilterChains(vector);
                        chainReaderHelper.setProject(project);
                        bufferedReader2 = new java.io.BufferedReader(chainReaderHelper.getAssembledReader());
                    } catch (java.lang.Throwable th) {
                        bufferedWriter = bufferedWriter2;
                        bufferedReader = bufferedReader3;
                        th = th;
                        org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                        org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                        throw th;
                    }
                } else {
                    bufferedReader2 = bufferedReader3;
                }
                try {
                    char[] cArr = new char[8192];
                    while (true) {
                        int read = bufferedReader2.read(cArr, 0, 8192);
                        if (read == -1) {
                            org.apache.tools.ant.util.FileUtils.close(bufferedWriter2);
                            org.apache.tools.ant.util.FileUtils.close(bufferedReader2);
                            return;
                        }
                        bufferedWriter2.write(cArr, 0, read);
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    java.io.BufferedReader bufferedReader4 = bufferedReader2;
                    bufferedWriter = bufferedWriter2;
                    bufferedReader = bufferedReader4;
                    org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                bufferedReader = bufferedReader3;
                th = th3;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public static void f(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2, org.apache.tools.ant.types.FilterSetCollection filterSetCollection, java.util.Vector vector, boolean z, boolean z2, java.lang.String str, java.lang.String str2, org.apache.tools.ant.Project project) throws java.io.IOException {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2;
        if (a(resource, resource2)) {
            h(project, "Skipping (self) copy of " + resource + " to " + resource2);
            return;
        }
        java.io.BufferedWriter bufferedWriter = null;
        try {
            java.io.BufferedReader bufferedReader3 = new java.io.BufferedReader(str == null ? new java.io.InputStreamReader(resource.getInputStream()) : new java.io.InputStreamReader(resource.getInputStream(), str));
            try {
                java.io.OutputStream g = g(resource2, z2, project);
                java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(str2 == null ? new java.io.OutputStreamWriter(g) : new java.io.OutputStreamWriter(g, str2));
                if (z) {
                    try {
                        org.apache.tools.ant.filters.util.ChainReaderHelper chainReaderHelper = new org.apache.tools.ant.filters.util.ChainReaderHelper();
                        chainReaderHelper.setBufferSize(8192);
                        chainReaderHelper.setPrimaryReader(bufferedReader3);
                        chainReaderHelper.setFilterChains(vector);
                        chainReaderHelper.setProject(project);
                        bufferedReader2 = new java.io.BufferedReader(chainReaderHelper.getAssembledReader());
                    } catch (java.lang.Throwable th) {
                        bufferedWriter = bufferedWriter2;
                        bufferedReader = bufferedReader3;
                        th = th;
                        org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                        org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                        throw th;
                    }
                } else {
                    bufferedReader2 = bufferedReader3;
                }
                try {
                    org.apache.tools.ant.util.LineTokenizer lineTokenizer = new org.apache.tools.ant.util.LineTokenizer();
                    lineTokenizer.setIncludeDelims(true);
                    for (java.lang.String token = lineTokenizer.getToken(bufferedReader2); token != null; token = lineTokenizer.getToken(bufferedReader2)) {
                        if (token.length() == 0) {
                            bufferedWriter2.newLine();
                        } else {
                            bufferedWriter2.write(filterSetCollection.replaceTokens(token));
                        }
                    }
                    org.apache.tools.ant.util.FileUtils.close(bufferedWriter2);
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader2);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    java.io.BufferedReader bufferedReader4 = bufferedReader2;
                    bufferedWriter = bufferedWriter2;
                    bufferedReader = bufferedReader4;
                    org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                bufferedReader = bufferedReader3;
                th = th3;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public static java.io.OutputStream g(org.apache.tools.ant.types.Resource resource, boolean z, org.apache.tools.ant.Project project) throws java.io.IOException {
        if (z) {
            org.apache.tools.ant.types.resources.Appendable appendable = (org.apache.tools.ant.types.resources.Appendable) resource.as(org.apache.tools.ant.types.resources.Appendable.class);
            if (appendable != null) {
                return appendable.getAppendOutputStream();
            }
            java.lang.String str = "Appendable OutputStream not available for non-appendable resource " + resource + "; using plain OutputStream";
            if (project != null) {
                project.log(str, 3);
            } else {
                java.lang.System.out.println(str);
            }
        }
        return resource.getOutputStream();
    }

    public static void h(org.apache.tools.ant.Project project, java.lang.String str) {
        i(project, str, 3);
    }

    public static void i(org.apache.tools.ant.Project project, java.lang.String str, int i) {
        if (project == null) {
            java.lang.System.out.println(str);
        } else {
            project.log(str, i);
        }
    }

    public static void j(org.apache.tools.ant.ProjectComponent projectComponent, org.apache.tools.ant.types.ResourceCollection resourceCollection, long j) {
        long currentTimeMillis = java.lang.System.currentTimeMillis() + j;
        org.apache.tools.ant.types.resources.selectors.Date date = new org.apache.tools.ant.types.resources.selectors.Date();
        date.setMillis(currentTimeMillis);
        date.setWhen(org.apache.tools.ant.types.TimeComparison.AFTER);
        org.apache.tools.ant.types.resources.Restrict restrict = new org.apache.tools.ant.types.resources.Restrict();
        restrict.add(date);
        restrict.add(resourceCollection);
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = restrict.iterator();
        while (it.hasNext()) {
            projectComponent.log("Warning: " + it.next().getName() + " modified in the future.", 1);
        }
    }

    public static int k(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) throws java.io.IOException {
        java.io.BufferedReader bufferedReader;
        int i;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            java.io.BufferedReader bufferedReader3 = new java.io.BufferedReader(new java.io.InputStreamReader(resource.getInputStream()));
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(resource2.getInputStream()));
                try {
                    java.lang.String readLine = bufferedReader3.readLine();
                    while (true) {
                        if (readLine != null) {
                            java.lang.String readLine2 = bufferedReader.readLine();
                            if (readLine.equals(readLine2)) {
                                readLine = bufferedReader3.readLine();
                            } else {
                                if (readLine2 == null) {
                                    org.apache.tools.ant.util.FileUtils.close(bufferedReader3);
                                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                                    return 1;
                                }
                                i = readLine.compareTo(readLine2);
                            }
                        } else {
                            i = bufferedReader.readLine() == null ? 0 : -1;
                        }
                    }
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader3);
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                    return i;
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader3;
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader2);
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    public static org.apache.tools.ant.types.ResourceCollection selectOutOfDateSources(org.apache.tools.ant.ProjectComponent projectComponent, org.apache.tools.ant.types.ResourceCollection resourceCollection, org.apache.tools.ant.util.FileNameMapper fileNameMapper, org.apache.tools.ant.types.ResourceFactory resourceFactory, long j) {
        j(projectComponent, resourceCollection, j);
        return selectSources(projectComponent, resourceCollection, fileNameMapper, resourceFactory, new org.apache.tools.ant.util.ResourceUtils.AnonymousClass1(j));
    }

    public static org.apache.tools.ant.types.Resource[] selectOutOfDateSources(org.apache.tools.ant.ProjectComponent projectComponent, org.apache.tools.ant.types.Resource[] resourceArr, org.apache.tools.ant.util.FileNameMapper fileNameMapper, org.apache.tools.ant.types.ResourceFactory resourceFactory) {
        return selectOutOfDateSources(projectComponent, resourceArr, fileNameMapper, resourceFactory, a.getFileTimestampGranularity());
    }

    public static org.apache.tools.ant.types.Resource[] selectOutOfDateSources(org.apache.tools.ant.ProjectComponent projectComponent, org.apache.tools.ant.types.Resource[] resourceArr, org.apache.tools.ant.util.FileNameMapper fileNameMapper, org.apache.tools.ant.types.ResourceFactory resourceFactory, long j) {
        org.apache.tools.ant.types.resources.Union union = new org.apache.tools.ant.types.resources.Union();
        union.addAll(java.util.Arrays.asList(resourceArr));
        org.apache.tools.ant.types.ResourceCollection selectOutOfDateSources = selectOutOfDateSources(projectComponent, union, fileNameMapper, resourceFactory, j);
        return selectOutOfDateSources.size() == 0 ? new org.apache.tools.ant.types.Resource[0] : ((org.apache.tools.ant.types.resources.Union) selectOutOfDateSources).listResources();
    }

    public static org.apache.tools.ant.types.ResourceCollection selectSources(org.apache.tools.ant.ProjectComponent projectComponent, org.apache.tools.ant.types.ResourceCollection resourceCollection, org.apache.tools.ant.util.FileNameMapper fileNameMapper, org.apache.tools.ant.types.ResourceFactory resourceFactory, org.apache.tools.ant.util.ResourceUtils.ResourceSelectorProvider resourceSelectorProvider) {
        java.lang.String[] strArr;
        if (resourceCollection.size() == 0) {
            projectComponent.log("No sources found.", 3);
            return org.apache.tools.ant.types.resources.Resources.NONE;
        }
        org.apache.tools.ant.types.resources.Union union = org.apache.tools.ant.types.resources.Union.getInstance(resourceCollection);
        org.apache.tools.ant.types.resources.Union union2 = new org.apache.tools.ant.types.resources.Union();
        for (org.apache.tools.ant.types.Resource resource : union) {
            java.lang.String name = resource.getName();
            if (name != null) {
                name = name.replace('/', java.io.File.separatorChar);
            }
            try {
                strArr = fileNameMapper.mapFileName(name);
            } catch (java.lang.Exception e) {
                projectComponent.log("Caught " + e + " mapping resource " + resource, 3);
                strArr = null;
            }
            if (strArr == null || strArr.length == 0) {
                projectComponent.log(resource + " skipped - don't know how to handle it", 3);
            } else {
                org.apache.tools.ant.types.resources.Union union3 = new org.apache.tools.ant.types.resources.Union();
                for (java.lang.String str : strArr) {
                    if (str == null) {
                        str = "(no name)";
                    }
                    union3.add(resourceFactory.getResource(str.replace(java.io.File.separatorChar, '/')));
                }
                org.apache.tools.ant.types.resources.Restrict restrict = new org.apache.tools.ant.types.resources.Restrict();
                restrict.add(resourceSelectorProvider.getTargetSelectorForSource(resource));
                restrict.add(union3);
                if (restrict.size() > 0) {
                    union2.add(resource);
                    org.apache.tools.ant.types.Resource next = restrict.iterator().next();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(resource.getName());
                    sb.append(" added as ");
                    sb.append(next.getName());
                    sb.append(next.isExists() ? " is outdated." : " doesn't exist.");
                    projectComponent.log(sb.toString(), 3);
                } else {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(resource.getName());
                    sb2.append(" omitted as ");
                    sb2.append(union3.toString());
                    sb2.append(union3.size() == 1 ? " is" : " are ");
                    sb2.append(" up to date.");
                    projectComponent.log(sb2.toString(), 3);
                }
            }
        }
        return union2;
    }

    public static void setLastModified(org.apache.tools.ant.types.resources.Touchable touchable, long j) {
        if (j < 0) {
            j = java.lang.System.currentTimeMillis();
        }
        touchable.touch(j);
    }
}
