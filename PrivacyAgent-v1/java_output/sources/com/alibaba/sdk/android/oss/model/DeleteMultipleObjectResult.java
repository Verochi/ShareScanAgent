package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class DeleteMultipleObjectResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private java.util.List<java.lang.String> deletedObjects;
    private java.util.List<java.lang.String> failedObjects;
    private boolean isQuiet;

    public void addDeletedObject(java.lang.String str) {
        if (this.deletedObjects == null) {
            this.deletedObjects = new java.util.ArrayList();
        }
        this.deletedObjects.add(str);
    }

    public void addFailedObjects(java.lang.String str) {
        if (this.failedObjects == null) {
            this.failedObjects = new java.util.ArrayList();
        }
        this.failedObjects.add(str);
    }

    public void clear() {
        java.util.List<java.lang.String> list = this.deletedObjects;
        if (list != null) {
            list.clear();
        }
        java.util.List<java.lang.String> list2 = this.failedObjects;
        if (list2 != null) {
            list2.clear();
        }
    }

    public java.util.List<java.lang.String> getDeletedObjects() {
        return this.deletedObjects;
    }

    public java.util.List<java.lang.String> getFailedObjects() {
        return this.failedObjects;
    }

    public boolean getQuiet() {
        return this.isQuiet;
    }

    public void setQuiet(boolean z) {
        this.isQuiet = z;
    }
}
