package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public final class ResponseParsers {

    public static final class AbortMultipartUploadResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult abortMultipartUploadResult) throws java.lang.Exception {
            return abortMultipartUploadResult;
        }
    }

    public static final class AppendObjectResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.AppendObjectResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.AppendObjectResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.AppendObjectResult appendObjectResult) throws java.io.IOException {
            java.lang.String str = (java.lang.String) responseMessage.getHeaders().get(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_NEXT_APPEND_POSITION);
            if (str != null) {
                appendObjectResult.setNextPosition(java.lang.Long.valueOf(str));
            }
            appendObjectResult.setObjectCRC64((java.lang.String) responseMessage.getHeaders().get(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_HASH_CRC64_ECMA));
            return appendObjectResult;
        }
    }

    public static final class CompleteMultipartUploadResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult completeMultipartUploadResult) throws java.lang.Exception {
            if (((java.lang.String) responseMessage.getHeaders().get("Content-Type")).equals("application/xml")) {
                return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseCompleteMultipartUploadResponseXML(responseMessage.getContent(), completeMultipartUploadResult);
            }
            java.lang.String string = responseMessage.getResponse().body().string();
            if (android.text.TextUtils.isEmpty(string)) {
                return completeMultipartUploadResult;
            }
            completeMultipartUploadResult.setServerCallbackReturnBody(string);
            return completeMultipartUploadResult;
        }
    }

    public static final class CopyObjectResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.CopyObjectResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.CopyObjectResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.CopyObjectResult copyObjectResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseCopyObjectResponseXML(responseMessage.getContent(), copyObjectResult);
        }
    }

    public static final class CreateBucketResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.CreateBucketResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.CreateBucketResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.CreateBucketResult createBucketResult) throws java.lang.Exception {
            if (createBucketResult.getResponseHeader().containsKey("Location")) {
                createBucketResult.bucketLocation = createBucketResult.getResponseHeader().get("Location");
            }
            return createBucketResult;
        }
    }

    public static final class DeleteBucketLifecycleResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleResult deleteBucketLifecycleResult) throws java.lang.Exception {
            return deleteBucketLifecycleResult;
        }
    }

    public static final class DeleteBucketLoggingResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.DeleteBucketLoggingResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.DeleteBucketLoggingResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.DeleteBucketLoggingResult deleteBucketLoggingResult) throws java.lang.Exception {
            return deleteBucketLoggingResult;
        }
    }

    public static final class DeleteBucketResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.DeleteBucketResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.DeleteBucketResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.DeleteBucketResult deleteBucketResult) throws java.lang.Exception {
            return deleteBucketResult;
        }
    }

    public static final class DeleteMultipleObjectResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult deleteMultipleObjectResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseDeleteMultipleObjectResponse(responseMessage.getContent(), deleteMultipleObjectResult);
        }
    }

    public static final class DeleteObjectResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.DeleteObjectResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.DeleteObjectResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.DeleteObjectResult deleteObjectResult) throws java.lang.Exception {
            return deleteObjectResult;
        }
    }

    public static final class DeleteObjectTaggingResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.DeleteObjectTaggingResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.DeleteObjectTaggingResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.DeleteObjectTaggingResult deleteObjectTaggingResult) throws java.lang.Exception {
            return deleteObjectTaggingResult;
        }
    }

    public static final class GetBucketACLResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.GetBucketACLResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.GetBucketACLResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.GetBucketACLResult getBucketACLResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseGetBucketACLResponse(responseMessage.getContent(), getBucketACLResult);
        }
    }

    public static final class GetBucketInfoResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.GetBucketInfoResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.GetBucketInfoResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.GetBucketInfoResult getBucketInfoResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseGetBucketInfoResponse(responseMessage.getContent(), getBucketInfoResult);
        }
    }

    public static final class GetBucketLifecycleResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult getBucketLifecycleResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseGetBucketLifecycleResponse(responseMessage.getContent(), getBucketLifecycleResult);
        }
    }

    public static final class GetBucketLoggingResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.GetBucketLoggingResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.GetBucketLoggingResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.GetBucketLoggingResult getBucketLoggingResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseGetBucketLoggingResponse(responseMessage.getContent(), getBucketLoggingResult);
        }
    }

    public static final class GetBucketRefererResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.GetBucketRefererResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.GetBucketRefererResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.GetBucketRefererResult getBucketRefererResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseGetBucketRefererResponse(responseMessage.getContent(), getBucketRefererResult);
        }
    }

    public static final class GetObjectACLResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.GetObjectACLResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.GetObjectACLResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.GetObjectACLResult getObjectACLResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseGetObjectACLResponse(responseMessage.getContent(), getObjectACLResult);
        }
    }

    public static final class GetObjectMetaResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.GetObjectMetaResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.GetObjectMetaResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.GetObjectMetaResult getObjectMetaResult) throws java.lang.Exception {
            getObjectMetaResult.setMetadata(com.alibaba.sdk.android.oss.internal.ResponseParsers.parseObjectMetadata(getObjectMetaResult.getResponseHeader()));
            return getObjectMetaResult;
        }
    }

    public static final class GetObjectResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.GetObjectResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public boolean needCloseResponse() {
            return false;
        }

        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.GetObjectResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.GetObjectResult getObjectResult) throws java.lang.Exception {
            getObjectResult.setMetadata(com.alibaba.sdk.android.oss.internal.ResponseParsers.parseObjectMetadata(getObjectResult.getResponseHeader()));
            getObjectResult.setContentLength(responseMessage.getContentLength());
            if (responseMessage.getRequest().isCheckCRC64()) {
                getObjectResult.setObjectContent(new com.alibaba.sdk.android.oss.internal.CheckCRC64DownloadInputStream(responseMessage.getContent(), new com.alibaba.sdk.android.oss.common.utils.CRC64(), responseMessage.getContentLength(), getObjectResult.getServerCRC().longValue(), getObjectResult.getRequestId()));
            } else {
                getObjectResult.setObjectContent(responseMessage.getContent());
            }
            return getObjectResult;
        }
    }

    public static final class GetObjectTaggingResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.GetObjectTaggingResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.GetObjectTaggingResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.GetObjectTaggingResult getObjectTaggingResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseGetObjectTaggingResponse(responseMessage.getContent(), getObjectTaggingResult);
        }
    }

    public static final class GetSymlinkResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.GetSymlinkResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.GetSymlinkResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.GetSymlinkResult getSymlinkResult) throws java.lang.Exception {
            getSymlinkResult.setTargetObjectName((java.lang.String) responseMessage.getHeaders().get(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_HEADER_SYMLINK_TARGET));
            return getSymlinkResult;
        }
    }

    public static final class HeadObjectResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.HeadObjectResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.HeadObjectResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.HeadObjectResult headObjectResult) throws java.lang.Exception {
            headObjectResult.setMetadata(com.alibaba.sdk.android.oss.internal.ResponseParsers.parseObjectMetadata(headObjectResult.getResponseHeader()));
            return headObjectResult;
        }
    }

    public static final class ImagePersistResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.ImagePersistResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.ImagePersistResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.ImagePersistResult imagePersistResult) throws java.lang.Exception {
            return imagePersistResult;
        }
    }

    public static final class InitMultipartResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult initiateMultipartUploadResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseInitMultipartResponseXML(responseMessage.getContent(), initiateMultipartUploadResult);
        }
    }

    public static final class ListBucketResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.ListBucketsResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.ListBucketsResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.ListBucketsResult listBucketsResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseBucketListResponse(responseMessage.getContent(), listBucketsResult);
        }
    }

    public static final class ListMultipartUploadsResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult listMultipartUploadsResult) throws java.lang.Exception {
            return listMultipartUploadsResult.parseData(responseMessage);
        }
    }

    public static final class ListObjectsResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.ListObjectsResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.ListObjectsResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.ListObjectsResult listObjectsResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseObjectListResponse(responseMessage.getContent(), listObjectsResult);
        }
    }

    public static final class ListPartsResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.ListPartsResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.ListPartsResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.ListPartsResult listPartsResult) throws java.lang.Exception {
            return com.alibaba.sdk.android.oss.internal.ResponseParsers.parseListPartsResponseXML(responseMessage.getContent(), listPartsResult);
        }
    }

    public static final class PutBucketLifecycleResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.PutBucketLifecycleResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.PutBucketLifecycleResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.PutBucketLifecycleResult putBucketLifecycleResult) throws java.lang.Exception {
            return putBucketLifecycleResult;
        }
    }

    public static final class PutBucketLoggingResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.PutBucketLoggingResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.PutBucketLoggingResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.PutBucketLoggingResult putBucketLoggingResult) throws java.lang.Exception {
            return putBucketLoggingResult;
        }
    }

    public static final class PutBucketRefererResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.PutBucketRefererResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.PutBucketRefererResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.PutBucketRefererResult putBucketRefererResult) throws java.lang.Exception {
            return putBucketRefererResult;
        }
    }

    public static final class PutObjectResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.PutObjectResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.PutObjectResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.PutObjectResult putObjectResult) throws java.io.IOException {
            putObjectResult.setETag(com.alibaba.sdk.android.oss.internal.ResponseParsers.trimQuotes((java.lang.String) responseMessage.getHeaders().get("ETag")));
            java.lang.String string = responseMessage.getResponse().body().string();
            if (!android.text.TextUtils.isEmpty(string)) {
                putObjectResult.setServerCallbackReturnBody(string);
            }
            return putObjectResult;
        }
    }

    public static final class PutObjectTaggingResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.PutObjectTaggingResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.PutObjectTaggingResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.PutObjectTaggingResult putObjectTaggingResult) throws java.lang.Exception {
            return putObjectTaggingResult;
        }
    }

    public static final class PutSymlinkResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.PutSymlinkResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.PutSymlinkResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.PutSymlinkResult putSymlinkResult) throws java.lang.Exception {
            return putSymlinkResult;
        }
    }

    public static final class RestoreObjectResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.RestoreObjectResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.RestoreObjectResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.RestoreObjectResult restoreObjectResult) throws java.lang.Exception {
            return restoreObjectResult;
        }
    }

    public static final class TriggerCallbackResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.TriggerCallbackResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.TriggerCallbackResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.TriggerCallbackResult triggerCallbackResult) throws java.lang.Exception {
            java.lang.String string = responseMessage.getResponse().body().string();
            if (!android.text.TextUtils.isEmpty(string)) {
                triggerCallbackResult.setServerCallbackReturnBody(string);
            }
            return triggerCallbackResult;
        }
    }

    public static final class UploadPartResponseParser extends com.alibaba.sdk.android.oss.internal.AbstractResponseParser<com.alibaba.sdk.android.oss.model.UploadPartResult> {
        @Override // com.alibaba.sdk.android.oss.internal.AbstractResponseParser
        public com.alibaba.sdk.android.oss.model.UploadPartResult parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, com.alibaba.sdk.android.oss.model.UploadPartResult uploadPartResult) throws java.lang.Exception {
            uploadPartResult.setETag(com.alibaba.sdk.android.oss.internal.ResponseParsers.trimQuotes((java.lang.String) responseMessage.getHeaders().get("ETag")));
            return uploadPartResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.ListBucketsResult parseBucketListResponse(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.ListBucketsResult listBucketsResult) throws java.lang.Exception {
        listBucketsResult.clearBucketList();
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        com.alibaba.sdk.android.oss.model.OSSBucketSummary oSSBucketSummary = null;
        while (eventType != 1) {
            if (eventType == 2) {
                java.lang.String name = newPullParser.getName();
                if (name != null) {
                    if ("Prefix".equals(name)) {
                        listBucketsResult.setPrefix(newPullParser.nextText());
                    } else if ("Marker".equals(name)) {
                        listBucketsResult.setMarker(newPullParser.nextText());
                    } else if ("MaxKeys".equals(name)) {
                        java.lang.String nextText = newPullParser.nextText();
                        if (nextText != null) {
                            listBucketsResult.setMaxKeys(java.lang.Integer.valueOf(nextText).intValue());
                        }
                    } else if ("IsTruncated".equals(name)) {
                        java.lang.String nextText2 = newPullParser.nextText();
                        if (nextText2 != null) {
                            listBucketsResult.setTruncated(java.lang.Boolean.valueOf(nextText2).booleanValue());
                        }
                    } else if ("NextMarker".equals(name)) {
                        listBucketsResult.setNextMarker(newPullParser.nextText());
                    } else if ("ID".equals(name)) {
                        listBucketsResult.setOwnerId(newPullParser.nextText());
                    } else if ("DisplayName".equals(name)) {
                        listBucketsResult.setOwnerDisplayName(newPullParser.nextText());
                    } else if ("Bucket".equals(name)) {
                        oSSBucketSummary = new com.alibaba.sdk.android.oss.model.OSSBucketSummary();
                    } else if ("CreationDate".equals(name)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.createDate = com.alibaba.sdk.android.oss.common.utils.DateUtil.parseIso8601Date(newPullParser.nextText());
                        }
                    } else if ("ExtranetEndpoint".equals(name)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.extranetEndpoint = newPullParser.nextText();
                        }
                    } else if ("IntranetEndpoint".equals(name)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.intranetEndpoint = newPullParser.nextText();
                        }
                    } else if ("Location".equals(name)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.location = newPullParser.nextText();
                        }
                    } else if (org.apache.tools.ant.taskdefs.Manifest.ATTRIBUTE_NAME.equals(name)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.name = newPullParser.nextText();
                        }
                    } else if (com.alibaba.sdk.android.oss.model.CreateBucketRequest.TAB_STORAGECLASS.equals(name) && oSSBucketSummary != null) {
                        oSSBucketSummary.storageClass = newPullParser.nextText();
                    }
                }
            } else if (eventType == 3 && "Bucket".equals(newPullParser.getName()) && oSSBucketSummary != null) {
                listBucketsResult.addBucket(oSSBucketSummary);
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return listBucketsResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult parseCompleteMultipartUploadResponseXML(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult completeMultipartUploadResult) throws java.lang.Exception {
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                java.lang.String name = newPullParser.getName();
                if ("Location".equals(name)) {
                    completeMultipartUploadResult.setLocation(newPullParser.nextText());
                } else if ("Bucket".equals(name)) {
                    completeMultipartUploadResult.setBucketName(newPullParser.nextText());
                } else if ("Key".equals(name)) {
                    completeMultipartUploadResult.setObjectKey(newPullParser.nextText());
                } else if ("ETag".equals(name)) {
                    completeMultipartUploadResult.setETag(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return completeMultipartUploadResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.CopyObjectResult parseCopyObjectResponseXML(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.CopyObjectResult copyObjectResult) throws java.lang.Exception {
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                java.lang.String name = newPullParser.getName();
                if ("LastModified".equals(name)) {
                    copyObjectResult.setLastModified(com.alibaba.sdk.android.oss.common.utils.DateUtil.parseIso8601Date(newPullParser.nextText()));
                } else if ("ETag".equals(name)) {
                    copyObjectResult.setEtag(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return copyObjectResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult parseDeleteMultipleObjectResponse(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult deleteMultipleObjectResult) throws java.lang.Exception {
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2 && "Key".equals(newPullParser.getName())) {
                deleteMultipleObjectResult.addDeletedObject(newPullParser.nextText());
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return deleteMultipleObjectResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.GetBucketACLResult parseGetBucketACLResponse(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.GetBucketACLResult getBucketACLResult) throws java.lang.Exception {
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                java.lang.String name = newPullParser.getName();
                if ("Grant".equals(name)) {
                    getBucketACLResult.setBucketACL(newPullParser.nextText());
                } else if ("ID".equals(name)) {
                    getBucketACLResult.setBucketOwnerID(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    getBucketACLResult.setBucketOwner(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getBucketACLResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.GetBucketInfoResult parseGetBucketInfoResponse(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.GetBucketInfoResult getBucketInfoResult) throws java.lang.Exception {
        java.lang.String name;
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        com.alibaba.sdk.android.oss.model.OSSBucketSummary oSSBucketSummary = null;
        com.alibaba.sdk.android.oss.model.Owner owner = null;
        while (eventType != 1) {
            if (eventType == 2) {
                java.lang.String name2 = newPullParser.getName();
                if (name2 != null) {
                    if ("Owner".equals(name2)) {
                        owner = new com.alibaba.sdk.android.oss.model.Owner();
                    } else if ("ID".equals(name2)) {
                        if (owner != null) {
                            owner.setId(newPullParser.nextText());
                        }
                    } else if ("DisplayName".equals(name2)) {
                        if (owner != null) {
                            owner.setDisplayName(newPullParser.nextText());
                        }
                    } else if ("Bucket".equals(name2)) {
                        oSSBucketSummary = new com.alibaba.sdk.android.oss.model.OSSBucketSummary();
                    } else if ("CreationDate".equals(name2)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.createDate = com.alibaba.sdk.android.oss.common.utils.DateUtil.parseIso8601Date(newPullParser.nextText());
                        }
                    } else if ("ExtranetEndpoint".equals(name2)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.extranetEndpoint = newPullParser.nextText();
                        }
                    } else if ("IntranetEndpoint".equals(name2)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.intranetEndpoint = newPullParser.nextText();
                        }
                    } else if ("Location".equals(name2)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.location = newPullParser.nextText();
                        }
                    } else if (org.apache.tools.ant.taskdefs.Manifest.ATTRIBUTE_NAME.equals(name2)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.name = newPullParser.nextText();
                        }
                    } else if (com.alibaba.sdk.android.oss.model.CreateBucketRequest.TAB_STORAGECLASS.equals(name2)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.storageClass = newPullParser.nextText();
                        }
                    } else if ("Grant".equals(name2) && oSSBucketSummary != null) {
                        oSSBucketSummary.setAcl(newPullParser.nextText());
                    }
                }
            } else if (eventType == 3 && (name = newPullParser.getName()) != null) {
                if ("Bucket".equals(name)) {
                    if (oSSBucketSummary != null) {
                        getBucketInfoResult.setBucket(oSSBucketSummary);
                    }
                } else if ("Owner".equals(name) && oSSBucketSummary != null) {
                    oSSBucketSummary.owner = owner;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getBucketInfoResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult parseGetBucketLifecycleResponse(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult getBucketLifecycleResult) throws java.lang.Exception {
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        com.alibaba.sdk.android.oss.model.BucketLifecycleRule bucketLifecycleRule = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        java.lang.String str = null;
        java.lang.String str2 = null;
        java.lang.String str3 = null;
        while (eventType != 1) {
            if (eventType == 2) {
                java.lang.String name = newPullParser.getName();
                if ("Rule".equals(name)) {
                    bucketLifecycleRule = new com.alibaba.sdk.android.oss.model.BucketLifecycleRule();
                } else if ("ID".equals(name)) {
                    bucketLifecycleRule.setIdentifier(newPullParser.nextText());
                } else if ("Prefix".equals(name)) {
                    bucketLifecycleRule.setPrefix(newPullParser.nextText());
                } else if ("Status".equals(name)) {
                    if ("Enabled".equals(newPullParser.nextText())) {
                        bucketLifecycleRule.setStatus(true);
                    } else {
                        bucketLifecycleRule.setStatus(false);
                    }
                } else if ("Expiration".equals(name)) {
                    z = true;
                } else if ("AbortMultipartUpload".equals(name)) {
                    z2 = true;
                } else if ("Transition".equals(name)) {
                    z3 = true;
                } else if ("Days".equals(name)) {
                    str = newPullParser.nextText();
                    if (bucketLifecycleRule != null) {
                        if (z) {
                            bucketLifecycleRule.setDays(str);
                        } else if (z2) {
                            bucketLifecycleRule.setMultipartDays(str);
                        } else if (z3 && str3 != null) {
                            if ("IA".equals(str3)) {
                                bucketLifecycleRule.setIADays(str);
                            } else if ("Archive".equals(str3)) {
                                bucketLifecycleRule.setArchiveDays(str);
                            }
                        }
                    }
                } else if ("Date".equals(name)) {
                    str2 = newPullParser.nextText();
                    if (bucketLifecycleRule != null) {
                        if (z) {
                            bucketLifecycleRule.setExpireDate(str2);
                        } else if (z2) {
                            bucketLifecycleRule.setMultipartExpireDate(str2);
                        } else if (z3 && str3 != null) {
                            if ("IA".equals(str3)) {
                                bucketLifecycleRule.setIAExpireDate(str2);
                            } else if ("Archive".equals(str3)) {
                                bucketLifecycleRule.setArchiveExpireDate(str2);
                            }
                        }
                    }
                } else if (com.alibaba.sdk.android.oss.model.CreateBucketRequest.TAB_STORAGECLASS.equals(name)) {
                    str3 = newPullParser.nextText();
                    if (bucketLifecycleRule != null) {
                        if ("IA".equals(str3)) {
                            bucketLifecycleRule.setIADays(str);
                            bucketLifecycleRule.setIAExpireDate(str2);
                        } else if ("Archive".equals(str3)) {
                            bucketLifecycleRule.setArchiveDays(str2);
                            bucketLifecycleRule.setArchiveExpireDate(str2);
                        }
                    }
                }
            } else if (eventType == 3) {
                java.lang.String name2 = newPullParser.getName();
                if ("Rule".equals(name2)) {
                    getBucketLifecycleResult.addLifecycleRule(bucketLifecycleRule);
                } else if ("Expiration".equals(name2)) {
                    z = false;
                } else if ("AbortMultipartUpload".equals(name2)) {
                    z2 = false;
                } else if ("Transition".equals(name2)) {
                    z3 = false;
                    str = null;
                    str2 = null;
                    str3 = null;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getBucketLifecycleResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.GetBucketLoggingResult parseGetBucketLoggingResponse(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.GetBucketLoggingResult getBucketLoggingResult) throws java.lang.Exception {
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                java.lang.String name = newPullParser.getName();
                if ("LoggingEnabled".equals(name)) {
                    getBucketLoggingResult.setLoggingEnabled(true);
                } else if ("TargetBucket".equals(name)) {
                    getBucketLoggingResult.setTargetBucketName(newPullParser.nextText());
                } else if ("TargetPrefix".equals(name)) {
                    getBucketLoggingResult.setTargetPrefix(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getBucketLoggingResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.GetBucketRefererResult parseGetBucketRefererResponse(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.GetBucketRefererResult getBucketRefererResult) throws java.lang.Exception {
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2 && com.google.common.net.HttpHeaders.REFERER.equals(newPullParser.getName())) {
                getBucketRefererResult.addReferer(newPullParser.nextText());
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getBucketRefererResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.GetObjectACLResult parseGetObjectACLResponse(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.GetObjectACLResult getObjectACLResult) throws java.lang.Exception {
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                java.lang.String name = newPullParser.getName();
                if ("Grant".equals(name)) {
                    getObjectACLResult.setObjectACL(newPullParser.nextText());
                } else if ("ID".equals(name)) {
                    getObjectACLResult.setObjectOwnerID(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    getObjectACLResult.setObjectOwner(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getObjectACLResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.GetObjectTaggingResult parseGetObjectTaggingResponse(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.GetObjectTaggingResult getObjectTaggingResult) throws java.lang.Exception {
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String str = null;
        java.lang.String str2 = null;
        while (eventType != 1) {
            java.lang.String name = newPullParser.getName();
            if (eventType != 2) {
                if (eventType == 3 && "Tag".equals(name)) {
                    if (str != null && str2 != null) {
                        hashMap.put(str, str2);
                    }
                    str = null;
                    str2 = null;
                }
            } else if ("Key".equals(name)) {
                str = newPullParser.nextText();
            } else if ("Value".equals(name)) {
                str2 = newPullParser.nextText();
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        getObjectTaggingResult.setTags(hashMap);
        return getObjectTaggingResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult parseInitMultipartResponseXML(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult initiateMultipartUploadResult) throws java.lang.Exception {
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                java.lang.String name = newPullParser.getName();
                if ("Bucket".equals(name)) {
                    initiateMultipartUploadResult.setBucketName(newPullParser.nextText());
                } else if ("Key".equals(name)) {
                    initiateMultipartUploadResult.setObjectKey(newPullParser.nextText());
                } else if ("UploadId".equals(name)) {
                    initiateMultipartUploadResult.setUploadId(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return initiateMultipartUploadResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.ListPartsResult parseListPartsResponseXML(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.ListPartsResult listPartsResult) throws java.lang.Exception {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        com.alibaba.sdk.android.oss.model.PartSummary partSummary = null;
        while (eventType != 1) {
            if (eventType == 2) {
                java.lang.String name = newPullParser.getName();
                if ("Bucket".equals(name)) {
                    listPartsResult.setBucketName(newPullParser.nextText());
                } else if ("Key".equals(name)) {
                    listPartsResult.setKey(newPullParser.nextText());
                } else if ("UploadId".equals(name)) {
                    listPartsResult.setUploadId(newPullParser.nextText());
                } else if ("PartNumberMarker".equals(name)) {
                    java.lang.String nextText = newPullParser.nextText();
                    if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText)) {
                        listPartsResult.setPartNumberMarker(java.lang.Integer.parseInt(nextText));
                    }
                } else if ("NextPartNumberMarker".equals(name)) {
                    java.lang.String nextText2 = newPullParser.nextText();
                    if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText2)) {
                        listPartsResult.setNextPartNumberMarker(java.lang.Integer.parseInt(nextText2));
                    }
                } else if ("MaxParts".equals(name)) {
                    java.lang.String nextText3 = newPullParser.nextText();
                    if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText3)) {
                        listPartsResult.setMaxParts(java.lang.Integer.parseInt(nextText3));
                    }
                } else if ("IsTruncated".equals(name)) {
                    java.lang.String nextText4 = newPullParser.nextText();
                    if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText4)) {
                        listPartsResult.setTruncated(java.lang.Boolean.valueOf(nextText4).booleanValue());
                    }
                } else if (com.alibaba.sdk.android.oss.model.CreateBucketRequest.TAB_STORAGECLASS.equals(name)) {
                    listPartsResult.setStorageClass(newPullParser.nextText());
                } else if ("Part".equals(name)) {
                    partSummary = new com.alibaba.sdk.android.oss.model.PartSummary();
                } else if ("PartNumber".equals(name)) {
                    java.lang.String nextText5 = newPullParser.nextText();
                    if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText5)) {
                        partSummary.setPartNumber(java.lang.Integer.valueOf(nextText5).intValue());
                    }
                } else if ("LastModified".equals(name)) {
                    partSummary.setLastModified(com.alibaba.sdk.android.oss.common.utils.DateUtil.parseIso8601Date(newPullParser.nextText()));
                } else if ("ETag".equals(name)) {
                    partSummary.setETag(newPullParser.nextText());
                } else if ("Size".equals(name)) {
                    java.lang.String nextText6 = newPullParser.nextText();
                    if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText6)) {
                        partSummary.setSize(java.lang.Long.valueOf(nextText6).longValue());
                    }
                }
            } else if (eventType == 3 && "Part".equals(newPullParser.getName())) {
                arrayList.add(partSummary);
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        if (arrayList.size() > 0) {
            listPartsResult.setParts(arrayList);
        }
        return listPartsResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.alibaba.sdk.android.oss.model.ListObjectsResult parseObjectListResponse(java.io.InputStream inputStream, com.alibaba.sdk.android.oss.model.ListObjectsResult listObjectsResult) throws java.lang.Exception {
        listObjectsResult.clearCommonPrefixes();
        listObjectsResult.clearObjectSummaries();
        org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        com.alibaba.sdk.android.oss.model.Owner owner = null;
        com.alibaba.sdk.android.oss.model.OSSObjectSummary oSSObjectSummary = null;
        boolean z = false;
        while (eventType != 1) {
            if (eventType == 2) {
                java.lang.String name = newPullParser.getName();
                if (org.apache.tools.ant.taskdefs.Manifest.ATTRIBUTE_NAME.equals(name)) {
                    listObjectsResult.setBucketName(newPullParser.nextText());
                } else if ("Prefix".equals(name)) {
                    if (z) {
                        java.lang.String nextText = newPullParser.nextText();
                        if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText)) {
                            listObjectsResult.addCommonPrefix(nextText);
                        }
                    } else {
                        listObjectsResult.setPrefix(newPullParser.nextText());
                    }
                } else if ("Marker".equals(name)) {
                    listObjectsResult.setMarker(newPullParser.nextText());
                } else if ("Delimiter".equals(name)) {
                    listObjectsResult.setDelimiter(newPullParser.nextText());
                } else if ("EncodingType".equals(name)) {
                    listObjectsResult.setEncodingType(newPullParser.nextText());
                } else if ("MaxKeys".equals(name)) {
                    java.lang.String nextText2 = newPullParser.nextText();
                    if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText2)) {
                        listObjectsResult.setMaxKeys(java.lang.Integer.valueOf(nextText2).intValue());
                    }
                } else if ("NextMarker".equals(name)) {
                    listObjectsResult.setNextMarker(newPullParser.nextText());
                } else if ("IsTruncated".equals(name)) {
                    java.lang.String nextText3 = newPullParser.nextText();
                    if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText3)) {
                        listObjectsResult.setTruncated(java.lang.Boolean.valueOf(nextText3).booleanValue());
                    }
                } else if ("Contents".equals(name)) {
                    oSSObjectSummary = new com.alibaba.sdk.android.oss.model.OSSObjectSummary();
                } else if ("Key".equals(name)) {
                    oSSObjectSummary.setKey(newPullParser.nextText());
                } else if ("LastModified".equals(name)) {
                    oSSObjectSummary.setLastModified(com.alibaba.sdk.android.oss.common.utils.DateUtil.parseIso8601Date(newPullParser.nextText()));
                } else if ("Size".equals(name)) {
                    java.lang.String nextText4 = newPullParser.nextText();
                    if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(nextText4)) {
                        oSSObjectSummary.setSize(java.lang.Long.valueOf(nextText4).longValue());
                    }
                } else if ("ETag".equals(name)) {
                    oSSObjectSummary.setETag(newPullParser.nextText());
                } else if ("Type".equals(name)) {
                    oSSObjectSummary.setType(newPullParser.nextText());
                } else if (com.alibaba.sdk.android.oss.model.CreateBucketRequest.TAB_STORAGECLASS.equals(name)) {
                    oSSObjectSummary.setStorageClass(newPullParser.nextText());
                } else if ("Owner".equals(name)) {
                    owner = new com.alibaba.sdk.android.oss.model.Owner();
                } else if ("ID".equals(name)) {
                    owner.setId(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    owner.setDisplayName(newPullParser.nextText());
                } else if ("CommonPrefixes".equals(name)) {
                    z = true;
                }
            } else if (eventType == 3) {
                java.lang.String name2 = newPullParser.getName();
                if ("Owner".equals(newPullParser.getName())) {
                    if (owner != null) {
                        oSSObjectSummary.setOwner(owner);
                    }
                } else if ("Contents".equals(name2)) {
                    if (oSSObjectSummary != null) {
                        oSSObjectSummary.setBucketName(listObjectsResult.getBucketName());
                        listObjectsResult.addObjectSummary(oSSObjectSummary);
                    }
                } else if ("CommonPrefixes".equals(name2)) {
                    z = false;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return listObjectsResult;
    }

    public static com.alibaba.sdk.android.oss.model.ObjectMetadata parseObjectMetadata(java.util.Map<java.lang.String, java.lang.String> map) throws java.lang.Exception {
        try {
            com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata = new com.alibaba.sdk.android.oss.model.ObjectMetadata();
            for (java.lang.String str : map.keySet()) {
                if (str.indexOf(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_USER_METADATA_PREFIX) >= 0) {
                    objectMetadata.addUserMetadata(str, map.get(str));
                } else {
                    if (!str.equalsIgnoreCase("Last-Modified") && !str.equalsIgnoreCase("Date")) {
                        if (str.equalsIgnoreCase("Content-Length")) {
                            objectMetadata.setHeader(str, java.lang.Long.valueOf(map.get(str)));
                        } else if (str.equalsIgnoreCase("ETag")) {
                            objectMetadata.setHeader(str, trimQuotes(map.get(str)));
                        } else {
                            objectMetadata.setHeader(str, map.get(str));
                        }
                    }
                    try {
                        objectMetadata.setHeader(str, com.alibaba.sdk.android.oss.common.utils.DateUtil.parseRfc822Date(map.get(str)));
                    } catch (java.text.ParseException e) {
                        throw new java.io.IOException(e.getMessage(), e);
                    }
                }
            }
            return objectMetadata;
        } catch (java.lang.Exception e2) {
            throw new java.io.IOException(e2.getMessage(), e2);
        }
    }

    public static java.lang.Exception parseResponseErrorXML(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, boolean z) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        int statusCode = responseMessage.getStatusCode();
        java.lang.String header = responseMessage.getResponse().header(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_HEADER_REQUEST_ID);
        java.lang.String header2 = responseMessage.getResponse().header(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_HEADER_EC);
        java.lang.String header3 = responseMessage.getResponse().header("Date");
        java.lang.String str9 = null;
        if (z) {
            str3 = header;
            str6 = header2;
            str5 = null;
            str7 = null;
            str8 = null;
            str4 = null;
            str = null;
            str2 = null;
        } else {
            try {
                java.lang.String string = responseMessage.getResponse().body().string();
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("errorMessage  ：  \n " + string);
                java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(string.getBytes());
                org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
                newPullParser.setInput(byteArrayInputStream, "utf-8");
                int eventType = newPullParser.getEventType();
                java.lang.String str10 = null;
                java.lang.String str11 = null;
                java.lang.String str12 = null;
                str = null;
                str2 = null;
                while (eventType != 1) {
                    if (eventType == 2) {
                        if ("Code".equals(newPullParser.getName())) {
                            str9 = newPullParser.nextText();
                        } else if ("Message".equals(newPullParser.getName())) {
                            str10 = newPullParser.nextText();
                        } else if (com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID.equals(newPullParser.getName())) {
                            header = newPullParser.nextText();
                        } else if ("HostId".equals(newPullParser.getName())) {
                            str11 = newPullParser.nextText();
                        } else if ("PartNumber".equals(newPullParser.getName())) {
                            str12 = newPullParser.nextText();
                        } else if ("PartEtag".equals(newPullParser.getName())) {
                            str = newPullParser.nextText();
                        } else if ("EC".equals(newPullParser.getName())) {
                            header2 = newPullParser.nextText();
                        } else if ("RecommendDoc".equals(newPullParser.getName())) {
                            str2 = newPullParser.nextText();
                        }
                    }
                    eventType = newPullParser.next();
                    if (eventType == 4) {
                        eventType = newPullParser.next();
                    }
                }
                str3 = header;
                java.lang.String str13 = str11;
                str4 = string;
                str5 = str12;
                str6 = header2;
                str7 = str10;
                str8 = str13;
            } catch (java.io.IOException e) {
                return new com.alibaba.sdk.android.oss.ClientException(e.getMessage(), e);
            } catch (org.xmlpull.v1.XmlPullParserException e2) {
                return new com.alibaba.sdk.android.oss.ClientException(e2.getMessage(), e2);
            }
        }
        com.alibaba.sdk.android.oss.ServiceException serviceException = new com.alibaba.sdk.android.oss.ServiceException(statusCode, str7, str9, str3, str8, str4, str6);
        if (!android.text.TextUtils.isEmpty(str)) {
            serviceException.setPartEtag(str);
        }
        if (!android.text.TextUtils.isEmpty(str5)) {
            serviceException.setPartNumber(str5);
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            serviceException.setRecommendDoc(str2);
        }
        if (!android.text.TextUtils.isEmpty(header3)) {
            serviceException.setDate(header3);
        }
        return serviceException;
    }

    public static java.lang.String trimQuotes(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String trim = str.trim();
        if (trim.startsWith("\"")) {
            trim = trim.substring(1);
        }
        return trim.endsWith("\"") ? trim.substring(0, trim.length() - 1) : trim;
    }
}
