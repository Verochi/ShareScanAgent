package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class ZipScanner extends org.apache.tools.ant.types.ArchiveScanner {
    @Override // org.apache.tools.ant.types.ArchiveScanner
    public void fillMapsFromArchive(org.apache.tools.ant.types.Resource resource, java.lang.String str, java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> map, java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> map2, java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> map3, java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> map4) {
        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
        if (fileProvider == null) {
            throw new org.apache.tools.ant.BuildException("Only file provider resources are supported");
        }
        java.io.File file = fileProvider.getFile();
        org.apache.tools.zip.ZipFile zipFile = null;
        try {
            try {
                org.apache.tools.zip.ZipFile zipFile2 = new org.apache.tools.zip.ZipFile(file, str);
                try {
                    java.util.Enumeration<org.apache.tools.zip.ZipEntry> entries = zipFile2.getEntries();
                    while (entries.hasMoreElements()) {
                        org.apache.tools.zip.ZipEntry nextElement = entries.nextElement();
                        org.apache.tools.ant.types.resources.ZipResource zipResource = new org.apache.tools.ant.types.resources.ZipResource(file, str, nextElement);
                        java.lang.String name = nextElement.getName();
                        if (nextElement.isDirectory()) {
                            java.lang.String trimSeparator = org.apache.tools.ant.types.ArchiveScanner.trimSeparator(name);
                            map3.put(trimSeparator, zipResource);
                            if (match(trimSeparator)) {
                                map4.put(trimSeparator, zipResource);
                            }
                        } else {
                            map.put(name, zipResource);
                            if (match(name)) {
                                map2.put(name, zipResource);
                            }
                        }
                    }
                    org.apache.tools.zip.ZipFile.closeQuietly(zipFile2);
                } catch (java.lang.Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    org.apache.tools.zip.ZipFile.closeQuietly(zipFile);
                    throw th;
                }
            } catch (java.util.zip.ZipException e) {
                throw new org.apache.tools.ant.BuildException("Problem reading " + file, e);
            } catch (java.io.IOException e2) {
                throw new org.apache.tools.ant.BuildException("Problem opening " + file, e2);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
