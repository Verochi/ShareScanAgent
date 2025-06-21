package org.apache.tools.ant.types.resources.selectors;

/* loaded from: classes26.dex */
public class Or extends org.apache.tools.ant.types.resources.selectors.ResourceSelectorContainer implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public Or() {
    }

    public Or(org.apache.tools.ant.types.resources.selectors.ResourceSelector[] resourceSelectorArr) {
        super(resourceSelectorArr);
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        java.util.Iterator<org.apache.tools.ant.types.resources.selectors.ResourceSelector> selectors = getSelectors();
        while (selectors.hasNext()) {
            if (selectors.next().isSelected(resource)) {
                return true;
            }
        }
        return false;
    }
}
