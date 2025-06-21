package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class FirstMatchMapper extends org.apache.tools.ant.util.ContainerMapper {
    @Override // org.apache.tools.ant.util.FileNameMapper
    public java.lang.String[] mapFileName(java.lang.String str) {
        java.lang.String[] mapFileName;
        for (org.apache.tools.ant.util.FileNameMapper fileNameMapper : getMappers()) {
            if (fileNameMapper != null && (mapFileName = fileNameMapper.mapFileName(str)) != null) {
                return mapFileName;
            }
        }
        return null;
    }
}
