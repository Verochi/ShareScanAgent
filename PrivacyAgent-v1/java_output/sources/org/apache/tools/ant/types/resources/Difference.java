package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class Difference extends org.apache.tools.ant.types.resources.BaseResourceCollectionContainer {
    @Override // org.apache.tools.ant.types.resources.BaseResourceCollectionContainer
    public java.util.Collection<org.apache.tools.ant.types.Resource> getCollection() {
        java.util.List<org.apache.tools.ant.types.ResourceCollection> resourceCollections = getResourceCollections();
        int size = resourceCollections.size();
        if (size < 2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("The difference of ");
            sb.append(size);
            sb.append(" resource collection");
            sb.append(size == 1 ? "" : "s");
            sb.append(" is undefined.");
            throw new org.apache.tools.ant.BuildException(sb.toString());
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<org.apache.tools.ant.types.ResourceCollection> it = resourceCollections.iterator();
        while (it.hasNext()) {
            for (org.apache.tools.ant.types.Resource resource : it.next()) {
                if (hashSet.add(resource)) {
                    arrayList.add(resource);
                } else {
                    arrayList.remove(resource);
                }
            }
        }
        return arrayList;
    }
}
