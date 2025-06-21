package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ListMultipartUploadsResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private java.lang.String bucketName;
    private java.lang.String delimiter;
    private boolean isTruncated;
    private java.lang.String keyMarker;
    private int maxUploads;
    private java.lang.String nextKeyMarker;
    private java.lang.String nextUploadIdMarker;
    private java.lang.String prefix;
    private java.lang.String uploadIdMarker;
    private java.util.List<com.alibaba.sdk.android.oss.model.MultipartUpload> multipartUploads = new java.util.ArrayList();
    private java.util.List<java.lang.String> commonPrefixes = new java.util.ArrayList();

    public void addCommonPrefix(java.lang.String str) {
        this.commonPrefixes.add(str);
    }

    public void addMultipartUpload(com.alibaba.sdk.android.oss.model.MultipartUpload multipartUpload) {
        this.multipartUploads.add(multipartUpload);
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.util.List<java.lang.String> getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public java.lang.String getDelimiter() {
        return this.delimiter;
    }

    public java.lang.String getKeyMarker() {
        return this.keyMarker;
    }

    public int getMaxUploads() {
        return this.maxUploads;
    }

    public java.util.List<com.alibaba.sdk.android.oss.model.MultipartUpload> getMultipartUploads() {
        return this.multipartUploads;
    }

    public java.lang.String getNextKeyMarker() {
        return this.nextKeyMarker;
    }

    public java.lang.String getNextUploadIdMarker() {
        return this.nextUploadIdMarker;
    }

    public java.lang.String getPrefix() {
        return this.prefix;
    }

    public java.lang.String getUploadIdMarker() {
        return this.uploadIdMarker;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage) throws java.lang.Exception {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(responseMessage.getContent(), "utf-8");
        int eventType = newPullParser.getEventType();
        com.alibaba.sdk.android.oss.model.MultipartUpload multipartUpload = null;
        boolean z = false;
        while (eventType != 1) {
            if (eventType == 2) {
                java.lang.String name = newPullParser.getName();
                if ("Bucket".equals(name)) {
                    setBucketName(newPullParser.nextText());
                } else if ("Delimiter".equals(name)) {
                    setDelimiter(newPullParser.nextText());
                } else if ("Prefix".equals(name)) {
                    if (z) {
                        java.lang.String nextText = newPullParser.nextText();
                        if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText)) {
                            addCommonPrefix(nextText);
                        }
                    } else {
                        setPrefix(newPullParser.nextText());
                    }
                } else if ("MaxUploads".equals(name)) {
                    java.lang.String nextText2 = newPullParser.nextText();
                    if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText2)) {
                        setMaxUploads(java.lang.Integer.valueOf(nextText2).intValue());
                    }
                } else if ("IsTruncated".equals(name)) {
                    java.lang.String nextText3 = newPullParser.nextText();
                    if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText3)) {
                        setTruncated(java.lang.Boolean.valueOf(nextText3).booleanValue());
                    }
                } else if ("KeyMarker".equals(name)) {
                    setKeyMarker(newPullParser.nextText());
                } else if ("UploadIdMarker".equals(name)) {
                    setUploadIdMarker(newPullParser.nextText());
                } else if ("NextKeyMarker".equals(name)) {
                    setNextKeyMarker(newPullParser.nextText());
                } else if ("NextUploadIdMarker".equals(name)) {
                    setNextUploadIdMarker(newPullParser.nextText());
                } else if ("Upload".equals(name)) {
                    multipartUpload = new com.alibaba.sdk.android.oss.model.MultipartUpload();
                } else if ("Key".equals(name)) {
                    multipartUpload.setKey(newPullParser.nextText());
                } else if ("UploadId".equals(name)) {
                    multipartUpload.setUploadId(newPullParser.nextText());
                } else if ("Initiated".equals(name)) {
                    multipartUpload.setInitiated(com.alibaba.sdk.android.oss.common.utils.DateUtil.parseIso8601Date(newPullParser.nextText()));
                } else if (com.alibaba.sdk.android.oss.model.CreateBucketRequest.TAB_STORAGECLASS.equals(name)) {
                    multipartUpload.setStorageClass(newPullParser.nextText());
                } else if ("CommonPrefixes".equals(name)) {
                    z = true;
                }
            } else if (eventType == 3) {
                if ("Upload".equals(newPullParser.getName())) {
                    arrayList.add(multipartUpload);
                } else if ("CommonPrefixes".equals(newPullParser.getName())) {
                    z = false;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        if (arrayList.size() > 0) {
            setMultipartUploads(arrayList);
        }
        return this;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setCommonPrefixes(java.util.List<java.lang.String> list) {
        this.commonPrefixes.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.commonPrefixes.addAll(list);
    }

    public void setDelimiter(java.lang.String str) {
        this.delimiter = str;
    }

    public void setKeyMarker(java.lang.String str) {
        this.keyMarker = str;
    }

    public void setMaxUploads(int i) {
        this.maxUploads = i;
    }

    public void setMultipartUploads(java.util.List<com.alibaba.sdk.android.oss.model.MultipartUpload> list) {
        this.multipartUploads.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.multipartUploads.addAll(list);
    }

    public void setNextKeyMarker(java.lang.String str) {
        this.nextKeyMarker = str;
    }

    public void setNextUploadIdMarker(java.lang.String str) {
        this.nextUploadIdMarker = str;
    }

    public void setPrefix(java.lang.String str) {
        this.prefix = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public void setUploadIdMarker(java.lang.String str) {
        this.uploadIdMarker = str;
    }
}
