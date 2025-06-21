package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class CloseResources extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.types.resources.Union u = new org.apache.tools.ant.types.resources.Union();

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        this.u.add(resourceCollection);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = this.u.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.types.resources.URLProvider uRLProvider = (org.apache.tools.ant.types.resources.URLProvider) it.next().as(org.apache.tools.ant.types.resources.URLProvider.class);
            if (uRLProvider != null) {
                try {
                    org.apache.tools.ant.util.FileUtils.close(uRLProvider.getURL().openConnection());
                } catch (java.io.IOException unused) {
                }
            }
        }
    }
}
