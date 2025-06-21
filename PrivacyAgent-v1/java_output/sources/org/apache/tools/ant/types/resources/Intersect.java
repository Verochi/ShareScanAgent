package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class Intersect extends org.apache.tools.ant.types.resources.BaseResourceCollectionContainer {
    public final java.util.Set<org.apache.tools.ant.types.Resource> c(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = resourceCollection.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    @Override // org.apache.tools.ant.types.resources.BaseResourceCollectionContainer
    public java.util.Collection<org.apache.tools.ant.types.Resource> getCollection() {
        java.util.List<org.apache.tools.ant.types.ResourceCollection> resourceCollections = getResourceCollections();
        int size = resourceCollections.size();
        if (size >= 2) {
            java.util.Iterator<org.apache.tools.ant.types.ResourceCollection> it = resourceCollections.iterator();
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(c(it.next()));
            while (it.hasNext()) {
                linkedHashSet.retainAll(c(it.next()));
            }
            return linkedHashSet;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("The intersection of ");
        sb.append(size);
        sb.append(" resource collection");
        sb.append(size == 1 ? "" : "s");
        sb.append(" is undefined.");
        throw new org.apache.tools.ant.BuildException(sb.toString());
    }
}
