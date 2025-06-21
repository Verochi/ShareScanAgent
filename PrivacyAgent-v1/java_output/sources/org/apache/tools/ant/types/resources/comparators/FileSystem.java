package org.apache.tools.ant.types.resources.comparators;

/* loaded from: classes26.dex */
public class FileSystem extends org.apache.tools.ant.types.resources.comparators.ResourceComparator {
    public static final org.apache.tools.ant.util.FileUtils n = org.apache.tools.ant.util.FileUtils.getFileUtils();

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) {
        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
        if (fileProvider == null) {
            throw new java.lang.ClassCastException(resource.getClass() + " doesn't provide files");
        }
        java.io.File file = fileProvider.getFile();
        org.apache.tools.ant.types.resources.FileProvider fileProvider2 = (org.apache.tools.ant.types.resources.FileProvider) resource2.as(org.apache.tools.ant.types.resources.FileProvider.class);
        if (fileProvider2 == null) {
            throw new java.lang.ClassCastException(resource2.getClass() + " doesn't provide files");
        }
        java.io.File file2 = fileProvider2.getFile();
        if (file.equals(file2)) {
            return 0;
        }
        org.apache.tools.ant.util.FileUtils fileUtils = n;
        if (fileUtils.isLeadingPath(file, file2)) {
            return -1;
        }
        return fileUtils.normalize(file.getAbsolutePath()).compareTo(fileUtils.normalize(file2.getAbsolutePath()));
    }
}
