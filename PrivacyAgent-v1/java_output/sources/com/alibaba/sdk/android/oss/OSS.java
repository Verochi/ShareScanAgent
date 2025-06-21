package com.alibaba.sdk.android.oss;

/* loaded from: classes.dex */
public interface OSS {
    com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult abortMultipartUpload(com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest abortMultipartUploadRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    void abortResumableUpload(com.alibaba.sdk.android.oss.model.ResumableUploadRequest resumableUploadRequest) throws java.io.IOException;

    com.alibaba.sdk.android.oss.model.AppendObjectResult appendObject(com.alibaba.sdk.android.oss.model.AppendObjectRequest appendObjectRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult> asyncAbortMultipartUpload(com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest abortMultipartUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest, com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.AppendObjectResult> asyncAppendObject(com.alibaba.sdk.android.oss.model.AppendObjectRequest appendObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.AppendObjectRequest, com.alibaba.sdk.android.oss.model.AppendObjectResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> asyncCompleteMultipartUpload(com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest completeMultipartUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest, com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.CopyObjectResult> asyncCopyObject(com.alibaba.sdk.android.oss.model.CopyObjectRequest copyObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.CopyObjectRequest, com.alibaba.sdk.android.oss.model.CopyObjectResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.CreateBucketResult> asyncCreateBucket(com.alibaba.sdk.android.oss.model.CreateBucketRequest createBucketRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.CreateBucketRequest, com.alibaba.sdk.android.oss.model.CreateBucketResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.DeleteBucketResult> asyncDeleteBucket(com.alibaba.sdk.android.oss.model.DeleteBucketRequest deleteBucketRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.DeleteBucketRequest, com.alibaba.sdk.android.oss.model.DeleteBucketResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleResult> asyncDeleteBucketLifecycle(com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleRequest deleteBucketLifecycleRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleRequest, com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.DeleteBucketLoggingResult> asyncDeleteBucketLogging(com.alibaba.sdk.android.oss.model.DeleteBucketLoggingRequest deleteBucketLoggingRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.DeleteBucketLoggingRequest, com.alibaba.sdk.android.oss.model.DeleteBucketLoggingResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult> asyncDeleteMultipleObject(com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest deleteMultipleObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest, com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.DeleteObjectResult> asyncDeleteObject(com.alibaba.sdk.android.oss.model.DeleteObjectRequest deleteObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.DeleteObjectRequest, com.alibaba.sdk.android.oss.model.DeleteObjectResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.DeleteObjectTaggingResult> asyncDeleteObjectTagging(com.alibaba.sdk.android.oss.model.DeleteObjectTaggingRequest deleteObjectTaggingRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.DeleteObjectTaggingRequest, com.alibaba.sdk.android.oss.model.DeleteObjectTaggingResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetBucketACLResult> asyncGetBucketACL(com.alibaba.sdk.android.oss.model.GetBucketACLRequest getBucketACLRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetBucketACLRequest, com.alibaba.sdk.android.oss.model.GetBucketACLResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetBucketInfoResult> asyncGetBucketInfo(com.alibaba.sdk.android.oss.model.GetBucketInfoRequest getBucketInfoRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetBucketInfoRequest, com.alibaba.sdk.android.oss.model.GetBucketInfoResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult> asyncGetBucketLifecycle(com.alibaba.sdk.android.oss.model.GetBucketLifecycleRequest getBucketLifecycleRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetBucketLifecycleRequest, com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetBucketLoggingResult> asyncGetBucketLogging(com.alibaba.sdk.android.oss.model.GetBucketLoggingRequest getBucketLoggingRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetBucketLoggingRequest, com.alibaba.sdk.android.oss.model.GetBucketLoggingResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetBucketRefererResult> asyncGetBucketReferer(com.alibaba.sdk.android.oss.model.GetBucketRefererRequest getBucketRefererRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetBucketRefererRequest, com.alibaba.sdk.android.oss.model.GetBucketRefererResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetObjectResult> asyncGetObject(com.alibaba.sdk.android.oss.model.GetObjectRequest getObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetObjectRequest, com.alibaba.sdk.android.oss.model.GetObjectResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetObjectACLResult> asyncGetObjectACL(com.alibaba.sdk.android.oss.model.GetObjectACLRequest getObjectACLRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetObjectACLRequest, com.alibaba.sdk.android.oss.model.GetObjectACLResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetObjectMetaResult> asyncGetObjectMeta(com.alibaba.sdk.android.oss.model.GetObjectMetaRequest getObjectMetaRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetObjectMetaRequest, com.alibaba.sdk.android.oss.model.GetObjectMetaResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetObjectTaggingResult> asyncGetObjectTagging(com.alibaba.sdk.android.oss.model.GetObjectTaggingRequest getObjectTaggingRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetObjectTaggingRequest, com.alibaba.sdk.android.oss.model.GetObjectTaggingResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetSymlinkResult> asyncGetSymlink(com.alibaba.sdk.android.oss.model.GetSymlinkRequest getSymlinkRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetSymlinkRequest, com.alibaba.sdk.android.oss.model.GetSymlinkResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.HeadObjectResult> asyncHeadObject(com.alibaba.sdk.android.oss.model.HeadObjectRequest headObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.HeadObjectRequest, com.alibaba.sdk.android.oss.model.HeadObjectResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ImagePersistResult> asyncImagePersist(com.alibaba.sdk.android.oss.model.ImagePersistRequest imagePersistRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ImagePersistRequest, com.alibaba.sdk.android.oss.model.ImagePersistResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult> asyncInitMultipartUpload(com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest initiateMultipartUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest, com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListBucketsResult> asyncListBuckets(com.alibaba.sdk.android.oss.model.ListBucketsRequest listBucketsRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ListBucketsRequest, com.alibaba.sdk.android.oss.model.ListBucketsResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult> asyncListMultipartUploads(com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest listMultipartUploadsRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest, com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListObjectsResult> asyncListObjects(com.alibaba.sdk.android.oss.model.ListObjectsRequest listObjectsRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ListObjectsRequest, com.alibaba.sdk.android.oss.model.ListObjectsResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListPartsResult> asyncListParts(com.alibaba.sdk.android.oss.model.ListPartsRequest listPartsRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ListPartsRequest, com.alibaba.sdk.android.oss.model.ListPartsResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> asyncMultipartUpload(com.alibaba.sdk.android.oss.model.MultipartUploadRequest multipartUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.MultipartUploadRequest, com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.PutBucketLifecycleResult> asyncPutBucketLifecycle(com.alibaba.sdk.android.oss.model.PutBucketLifecycleRequest putBucketLifecycleRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutBucketLifecycleRequest, com.alibaba.sdk.android.oss.model.PutBucketLifecycleResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.PutBucketLoggingResult> asyncPutBucketLogging(com.alibaba.sdk.android.oss.model.PutBucketLoggingRequest putBucketLoggingRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutBucketLoggingRequest, com.alibaba.sdk.android.oss.model.PutBucketLoggingResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.PutBucketRefererResult> asyncPutBucketReferer(com.alibaba.sdk.android.oss.model.PutBucketRefererRequest putBucketRefererRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutBucketRefererRequest, com.alibaba.sdk.android.oss.model.PutBucketRefererResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.PutObjectResult> asyncPutObject(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutObjectRequest, com.alibaba.sdk.android.oss.model.PutObjectResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.PutObjectTaggingResult> asyncPutObjectTagging(com.alibaba.sdk.android.oss.model.PutObjectTaggingRequest putObjectTaggingRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutObjectTaggingRequest, com.alibaba.sdk.android.oss.model.PutObjectTaggingResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.PutSymlinkResult> asyncPutSymlink(com.alibaba.sdk.android.oss.model.PutSymlinkRequest putSymlinkRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutSymlinkRequest, com.alibaba.sdk.android.oss.model.PutSymlinkResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.RestoreObjectResult> asyncRestoreObject(com.alibaba.sdk.android.oss.model.RestoreObjectRequest restoreObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.RestoreObjectRequest, com.alibaba.sdk.android.oss.model.RestoreObjectResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ResumableDownloadResult> asyncResumableDownload(com.alibaba.sdk.android.oss.model.ResumableDownloadRequest resumableDownloadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ResumableDownloadRequest, com.alibaba.sdk.android.oss.model.ResumableDownloadResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ResumableUploadResult> asyncResumableUpload(com.alibaba.sdk.android.oss.model.ResumableUploadRequest resumableUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ResumableUploadRequest, com.alibaba.sdk.android.oss.model.ResumableUploadResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ResumableUploadResult> asyncSequenceUpload(com.alibaba.sdk.android.oss.model.ResumableUploadRequest resumableUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ResumableUploadRequest, com.alibaba.sdk.android.oss.model.ResumableUploadResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.TriggerCallbackResult> asyncTriggerCallback(com.alibaba.sdk.android.oss.model.TriggerCallbackRequest triggerCallbackRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.TriggerCallbackRequest, com.alibaba.sdk.android.oss.model.TriggerCallbackResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.UploadPartResult> asyncUploadPart(com.alibaba.sdk.android.oss.model.UploadPartRequest uploadPartRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.UploadPartRequest, com.alibaba.sdk.android.oss.model.UploadPartResult> oSSCompletedCallback);

    com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult completeMultipartUpload(com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest completeMultipartUploadRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.CopyObjectResult copyObject(com.alibaba.sdk.android.oss.model.CopyObjectRequest copyObjectRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.CreateBucketResult createBucket(com.alibaba.sdk.android.oss.model.CreateBucketRequest createBucketRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.DeleteBucketResult deleteBucket(com.alibaba.sdk.android.oss.model.DeleteBucketRequest deleteBucketRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleResult deleteBucketLifecycle(com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleRequest deleteBucketLifecycleRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.DeleteBucketLoggingResult deleteBucketLogging(com.alibaba.sdk.android.oss.model.DeleteBucketLoggingRequest deleteBucketLoggingRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult deleteMultipleObject(com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest deleteMultipleObjectRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.DeleteObjectResult deleteObject(com.alibaba.sdk.android.oss.model.DeleteObjectRequest deleteObjectRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.DeleteObjectTaggingResult deleteObjectTagging(com.alibaba.sdk.android.oss.model.DeleteObjectTaggingRequest deleteObjectTaggingRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    boolean doesObjectExist(java.lang.String str, java.lang.String str2) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.GetBucketACLResult getBucketACL(com.alibaba.sdk.android.oss.model.GetBucketACLRequest getBucketACLRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.GetBucketInfoResult getBucketInfo(com.alibaba.sdk.android.oss.model.GetBucketInfoRequest getBucketInfoRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult getBucketLifecycle(com.alibaba.sdk.android.oss.model.GetBucketLifecycleRequest getBucketLifecycleRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.GetBucketLoggingResult getBucketLogging(com.alibaba.sdk.android.oss.model.GetBucketLoggingRequest getBucketLoggingRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.GetBucketRefererResult getBucketReferer(com.alibaba.sdk.android.oss.model.GetBucketRefererRequest getBucketRefererRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.GetObjectResult getObject(com.alibaba.sdk.android.oss.model.GetObjectRequest getObjectRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.GetObjectACLResult getObjectACL(com.alibaba.sdk.android.oss.model.GetObjectACLRequest getObjectACLRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.GetObjectMetaResult getObjectMeta(com.alibaba.sdk.android.oss.model.GetObjectMetaRequest getObjectMetaRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.GetObjectTaggingResult getObjectTagging(com.alibaba.sdk.android.oss.model.GetObjectTaggingRequest getObjectTaggingRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.GetSymlinkResult getSymlink(com.alibaba.sdk.android.oss.model.GetSymlinkRequest getSymlinkRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.HeadObjectResult headObject(com.alibaba.sdk.android.oss.model.HeadObjectRequest headObjectRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.ImagePersistResult imagePersist(com.alibaba.sdk.android.oss.model.ImagePersistRequest imagePersistRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult initMultipartUpload(com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest initiateMultipartUploadRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.ListBucketsResult listBuckets(com.alibaba.sdk.android.oss.model.ListBucketsRequest listBucketsRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult listMultipartUploads(com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest listMultipartUploadsRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.ListObjectsResult listObjects(com.alibaba.sdk.android.oss.model.ListObjectsRequest listObjectsRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.ListPartsResult listParts(com.alibaba.sdk.android.oss.model.ListPartsRequest listPartsRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult multipartUpload(com.alibaba.sdk.android.oss.model.MultipartUploadRequest multipartUploadRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    java.lang.String presignConstrainedObjectURL(com.alibaba.sdk.android.oss.model.GeneratePresignedUrlRequest generatePresignedUrlRequest) throws com.alibaba.sdk.android.oss.ClientException;

    java.lang.String presignConstrainedObjectURL(java.lang.String str, java.lang.String str2, long j) throws com.alibaba.sdk.android.oss.ClientException;

    java.lang.String presignPublicObjectURL(java.lang.String str, java.lang.String str2);

    com.alibaba.sdk.android.oss.model.PutBucketLifecycleResult putBucketLifecycle(com.alibaba.sdk.android.oss.model.PutBucketLifecycleRequest putBucketLifecycleRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.PutBucketLoggingResult putBucketLogging(com.alibaba.sdk.android.oss.model.PutBucketLoggingRequest putBucketLoggingRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.PutBucketRefererResult putBucketReferer(com.alibaba.sdk.android.oss.model.PutBucketRefererRequest putBucketRefererRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.PutObjectResult putObject(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.PutObjectTaggingResult putObjectTagging(com.alibaba.sdk.android.oss.model.PutObjectTaggingRequest putObjectTaggingRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.PutSymlinkResult putSymlink(com.alibaba.sdk.android.oss.model.PutSymlinkRequest putSymlinkRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.RestoreObjectResult restoreObject(com.alibaba.sdk.android.oss.model.RestoreObjectRequest restoreObjectRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.ResumableUploadResult resumableUpload(com.alibaba.sdk.android.oss.model.ResumableUploadRequest resumableUploadRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.ResumableUploadResult sequenceUpload(com.alibaba.sdk.android.oss.model.ResumableUploadRequest resumableUploadRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.ResumableDownloadResult syncResumableDownload(com.alibaba.sdk.android.oss.model.ResumableDownloadRequest resumableDownloadRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    com.alibaba.sdk.android.oss.model.TriggerCallbackResult triggerCallback(com.alibaba.sdk.android.oss.model.TriggerCallbackRequest triggerCallbackRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    void updateCredentialProvider(com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider oSSCredentialProvider);

    com.alibaba.sdk.android.oss.model.UploadPartResult uploadPart(com.alibaba.sdk.android.oss.model.UploadPartRequest uploadPartRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;
}
