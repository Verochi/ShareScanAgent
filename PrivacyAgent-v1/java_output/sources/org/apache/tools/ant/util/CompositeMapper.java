package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class CompositeMapper extends org.apache.tools.ant.util.ContainerMapper {
    @Override // org.apache.tools.ant.util.FileNameMapper
    public java.lang.String[] mapFileName(java.lang.String str) {
        java.lang.String[] mapFileName;
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (org.apache.tools.ant.util.FileNameMapper fileNameMapper : getMappers()) {
            if (fileNameMapper != null && (mapFileName = fileNameMapper.mapFileName(str)) != null) {
                for (java.lang.String str2 : mapFileName) {
                    linkedHashSet.add(str2);
                }
            }
        }
        if (linkedHashSet.size() == 0) {
            return null;
        }
        return (java.lang.String[]) linkedHashSet.toArray(new java.lang.String[linkedHashSet.size()]);
    }
}
