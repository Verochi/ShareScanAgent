package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class Union extends org.apache.tools.ant.types.resources.BaseResourceCollectionContainer {
    public Union() {
    }

    public Union(org.apache.tools.ant.Project project) {
        super(project);
    }

    public Union(org.apache.tools.ant.Project project, org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        super(project);
        add(resourceCollection);
    }

    public Union(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        this(org.apache.tools.ant.Project.getProject(resourceCollection), resourceCollection);
    }

    public static org.apache.tools.ant.types.resources.Union getInstance(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        return resourceCollection instanceof org.apache.tools.ant.types.resources.Union ? (org.apache.tools.ant.types.resources.Union) resourceCollection : new org.apache.tools.ant.types.resources.Union(resourceCollection);
    }

    public java.util.Set<org.apache.tools.ant.types.Resource> getAllResources() {
        java.util.List<org.apache.tools.ant.types.ResourceCollection> resourceCollections = getResourceCollections();
        if (resourceCollections.isEmpty()) {
            return java.util.Collections.emptySet();
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(resourceCollections.size() * 2);
        java.util.Iterator<org.apache.tools.ant.types.ResourceCollection> it = resourceCollections.iterator();
        while (it.hasNext()) {
            java.util.Iterator<org.apache.tools.ant.types.Resource> it2 = it.next().iterator();
            while (it2.hasNext()) {
                linkedHashSet.add(it2.next());
            }
        }
        return linkedHashSet;
    }

    public java.util.Collection<java.lang.String> getAllToStrings() {
        java.util.Set<org.apache.tools.ant.types.Resource> allResources = getAllResources();
        java.util.ArrayList arrayList = new java.util.ArrayList(allResources.size());
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = allResources.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        return arrayList;
    }

    @Override // org.apache.tools.ant.types.resources.BaseResourceCollectionContainer
    public java.util.Collection<org.apache.tools.ant.types.Resource> getCollection() {
        return getAllResources();
    }

    @java.lang.Deprecated
    public <T> java.util.Collection<T> getCollection(boolean z) {
        return z ? (java.util.Collection<T>) getAllToStrings() : getAllResources();
    }

    public java.lang.String[] list() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.Union) getCheckedRef(org.apache.tools.ant.types.resources.Union.class, getDataTypeName())).list();
        }
        java.util.Collection<java.lang.String> allToStrings = getAllToStrings();
        return (java.lang.String[]) allToStrings.toArray(new java.lang.String[allToStrings.size()]);
    }

    public org.apache.tools.ant.types.Resource[] listResources() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.Union) getCheckedRef(org.apache.tools.ant.types.resources.Union.class, getDataTypeName())).listResources();
        }
        java.util.Set<org.apache.tools.ant.types.Resource> allResources = getAllResources();
        return (org.apache.tools.ant.types.Resource[]) allResources.toArray(new org.apache.tools.ant.types.Resource[allResources.size()]);
    }
}
