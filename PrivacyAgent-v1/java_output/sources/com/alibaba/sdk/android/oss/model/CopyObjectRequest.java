package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class CopyObjectRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String destinationBucketName;
    private java.lang.String destinationKey;
    private java.util.Date modifiedSinceConstraint;
    private com.alibaba.sdk.android.oss.model.ObjectMetadata newObjectMetadata;
    private java.lang.String serverSideEncryption;
    private java.lang.String sourceBucketName;
    private java.lang.String sourceKey;
    private java.util.Date unmodifiedSinceConstraint;
    private java.util.List<java.lang.String> matchingETagConstraints = new java.util.ArrayList();
    private java.util.List<java.lang.String> nonmatchingEtagConstraints = new java.util.ArrayList();

    public CopyObjectRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        setSourceBucketName(str);
        setSourceKey(str2);
        setDestinationBucketName(str3);
        setDestinationKey(str4);
    }

    public void clearMatchingETagConstraints() {
        this.matchingETagConstraints.clear();
    }

    public void clearNonmatchingETagConstraints() {
        this.nonmatchingEtagConstraints.clear();
    }

    public java.lang.String getDestinationBucketName() {
        return this.destinationBucketName;
    }

    public java.lang.String getDestinationKey() {
        return this.destinationKey;
    }

    public java.util.List<java.lang.String> getMatchingETagConstraints() {
        return this.matchingETagConstraints;
    }

    public java.util.Date getModifiedSinceConstraint() {
        return this.modifiedSinceConstraint;
    }

    public com.alibaba.sdk.android.oss.model.ObjectMetadata getNewObjectMetadata() {
        return this.newObjectMetadata;
    }

    public java.util.List<java.lang.String> getNonmatchingEtagConstraints() {
        return this.nonmatchingEtagConstraints;
    }

    public java.lang.String getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public java.lang.String getSourceBucketName() {
        return this.sourceBucketName;
    }

    public java.lang.String getSourceKey() {
        return this.sourceKey;
    }

    public java.util.Date getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public void setDestinationBucketName(java.lang.String str) {
        this.destinationBucketName = str;
    }

    public void setDestinationKey(java.lang.String str) {
        this.destinationKey = str;
    }

    public void setMatchingETagConstraints(java.util.List<java.lang.String> list) {
        this.matchingETagConstraints.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.matchingETagConstraints.addAll(list);
    }

    public void setModifiedSinceConstraint(java.util.Date date) {
        this.modifiedSinceConstraint = date;
    }

    public void setNewObjectMetadata(com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        this.newObjectMetadata = objectMetadata;
    }

    public void setNonmatchingETagConstraints(java.util.List<java.lang.String> list) {
        this.nonmatchingEtagConstraints.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.nonmatchingEtagConstraints.addAll(list);
    }

    public void setServerSideEncryption(java.lang.String str) {
        this.serverSideEncryption = str;
    }

    public void setSourceBucketName(java.lang.String str) {
        this.sourceBucketName = str;
    }

    public void setSourceKey(java.lang.String str) {
        this.sourceKey = str;
    }

    public void setUnmodifiedSinceConstraint(java.util.Date date) {
        this.unmodifiedSinceConstraint = date;
    }
}
