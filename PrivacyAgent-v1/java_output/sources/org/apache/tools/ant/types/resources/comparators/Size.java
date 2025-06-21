package org.apache.tools.ant.types.resources.comparators;

/* loaded from: classes26.dex */
public class Size extends org.apache.tools.ant.types.resources.comparators.ResourceComparator {
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) {
        long size = resource.getSize() - resource2.getSize();
        if (size > 0) {
            return 1;
        }
        return size == 0 ? 0 : -1;
    }
}
