package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class TarScanner extends org.apache.tools.ant.types.ArchiveScanner {
    @Override // org.apache.tools.ant.types.ArchiveScanner
    public void fillMapsFromArchive(org.apache.tools.ant.types.Resource resource, java.lang.String str, java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> map, java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> map2, java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> map3, java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> map4) {
        org.apache.tools.tar.TarInputStream tarInputStream = null;
        try {
            try {
                org.apache.tools.tar.TarInputStream tarInputStream2 = new org.apache.tools.tar.TarInputStream(resource.getInputStream(), str);
                while (true) {
                    try {
                        org.apache.tools.tar.TarEntry nextEntry = tarInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            org.apache.tools.ant.util.FileUtils.close(tarInputStream2);
                            return;
                        }
                        org.apache.tools.ant.types.resources.TarResource tarResource = new org.apache.tools.ant.types.resources.TarResource(resource, nextEntry);
                        java.lang.String name = nextEntry.getName();
                        if (nextEntry.isDirectory()) {
                            java.lang.String trimSeparator = org.apache.tools.ant.types.ArchiveScanner.trimSeparator(name);
                            map3.put(trimSeparator, tarResource);
                            if (match(trimSeparator)) {
                                map4.put(trimSeparator, tarResource);
                            }
                        } else {
                            map.put(name, tarResource);
                            if (match(name)) {
                                map2.put(name, tarResource);
                            }
                        }
                    } catch (java.io.IOException e) {
                        e = e;
                        tarInputStream = tarInputStream2;
                        throw new org.apache.tools.ant.BuildException("problem reading " + this.srcFile, e);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        tarInputStream = tarInputStream2;
                        org.apache.tools.ant.util.FileUtils.close(tarInputStream);
                        throw th;
                    }
                }
            } catch (java.io.IOException e2) {
                try {
                    throw new org.apache.tools.ant.BuildException("problem opening " + this.srcFile, e2);
                } catch (java.io.IOException e3) {
                    e = e3;
                    throw new org.apache.tools.ant.BuildException("problem reading " + this.srcFile, e);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
