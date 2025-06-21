package org.apache.tools.ant.types.resources.comparators;

/* loaded from: classes26.dex */
public class Date extends org.apache.tools.ant.types.resources.comparators.ResourceComparator {
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) {
        long lastModified = resource.getLastModified() - resource2.getLastModified();
        if (lastModified > 0) {
            return 1;
        }
        return lastModified < 0 ? -1 : 0;
    }
}
