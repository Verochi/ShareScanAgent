package org.apache.tools.ant.types.resources.selectors;

/* loaded from: classes26.dex */
public class Exists implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        return resource.isExists();
    }
}
