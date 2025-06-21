package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class WritableSelector implements org.apache.tools.ant.types.selectors.FileSelector, org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    @Override // org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        return file2 != null && file2.canWrite();
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
        return fileProvider != null && isSelected(null, null, fileProvider.getFile());
    }
}
