package org.apache.tools.ant.types.resources.comparators;

/* loaded from: classes26.dex */
public class Name extends org.apache.tools.ant.types.resources.comparators.ResourceComparator {
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) {
        return resource.getName().compareTo(resource2.getName());
    }
}
