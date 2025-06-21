package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ChainedMapper extends org.apache.tools.ant.util.ContainerMapper {
    @Override // org.apache.tools.ant.util.FileNameMapper
    public java.lang.String[] mapFileName(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add(str);
        for (org.apache.tools.ant.util.FileNameMapper fileNameMapper : getMappers()) {
            if (fileNameMapper != null) {
                arrayList.clear();
                arrayList.addAll(arrayList2);
                arrayList2.clear();
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    java.lang.String[] mapFileName = fileNameMapper.mapFileName((java.lang.String) it.next());
                    if (mapFileName != null) {
                        arrayList2.addAll(java.util.Arrays.asList(mapFileName));
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            return null;
        }
        return (java.lang.String[]) arrayList2.toArray(new java.lang.String[arrayList2.size()]);
    }
}
