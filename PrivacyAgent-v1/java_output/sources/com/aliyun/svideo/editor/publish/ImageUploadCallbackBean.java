package com.aliyun.svideo.editor.publish;

/* loaded from: classes12.dex */
public class ImageUploadCallbackBean {
    private java.lang.String code;
    private com.aliyun.svideo.editor.publish.ImageUploadCallbackBean.DataBean data;
    private java.lang.String message;
    private java.lang.String requestId;
    private java.lang.String result;

    public static class DataBean {
        private java.lang.String imageId;
        private java.lang.String imageURL;
        private java.lang.String uploadAddress;
        private java.lang.String uploadAuth;

        public java.lang.String getImageId() {
            return this.imageId;
        }

        public java.lang.String getImageURL() {
            return this.imageURL;
        }

        public java.lang.String getUploadAddress() {
            return this.uploadAddress;
        }

        public java.lang.String getUploadAuth() {
            return this.uploadAuth;
        }

        public void setImageId(java.lang.String str) {
            this.imageId = str;
        }

        public void setImageURL(java.lang.String str) {
            this.imageURL = str;
        }

        public void setUploadAddress(java.lang.String str) {
            this.uploadAddress = str;
        }

        public void setUploadAuth(java.lang.String str) {
            this.uploadAuth = str;
        }
    }

    public java.lang.String getCode() {
        return this.code;
    }

    public com.aliyun.svideo.editor.publish.ImageUploadCallbackBean.DataBean getData() {
        return this.data;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public java.lang.String getRequestId() {
        return this.requestId;
    }

    public java.lang.String getResult() {
        return this.result;
    }

    public void setCode(java.lang.String str) {
        this.code = str;
    }

    public void setData(com.aliyun.svideo.editor.publish.ImageUploadCallbackBean.DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMessage(java.lang.String str) {
        this.message = str;
    }

    public void setRequestId(java.lang.String str) {
        this.requestId = str;
    }

    public void setResult(java.lang.String str) {
        this.result = str;
    }
}
