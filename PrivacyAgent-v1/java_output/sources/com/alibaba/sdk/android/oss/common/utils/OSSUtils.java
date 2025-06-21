package com.alibaba.sdk.android.oss.common.utils;

/* loaded from: classes.dex */
public class OSSUtils {
    private static final java.lang.String NEW_LINE = "\n";
    private static final java.util.List<java.lang.String> SIGNED_PARAMTERS = java.util.Arrays.asList(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_BUCKETINFO, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_ACL, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_UPLOADS, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_CORS, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOGGING, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_WEBSITE, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_REFERER, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LIFECYCLE, "delete", com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_APPEND, com.alibaba.sdk.android.oss.common.RequestParameters.UPLOAD_ID, com.alibaba.sdk.android.oss.common.RequestParameters.PART_NUMBER, com.alibaba.sdk.android.oss.common.RequestParameters.SECURITY_TOKEN, com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, com.alibaba.sdk.android.oss.common.RequestParameters.RESPONSE_HEADER_CACHE_CONTROL, com.alibaba.sdk.android.oss.common.RequestParameters.RESPONSE_HEADER_CONTENT_DISPOSITION, com.alibaba.sdk.android.oss.common.RequestParameters.RESPONSE_HEADER_CONTENT_ENCODING, com.alibaba.sdk.android.oss.common.RequestParameters.RESPONSE_HEADER_CONTENT_LANGUAGE, com.alibaba.sdk.android.oss.common.RequestParameters.RESPONSE_HEADER_CONTENT_TYPE, com.alibaba.sdk.android.oss.common.RequestParameters.RESPONSE_HEADER_EXPIRES, com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_PROCESS, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_SEQUENTIAL, com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_SYMLINK, com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_RESTORE, com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_TAGGING, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_OBJECT_META);

    public enum EscapedChar {
        RETURN("&#x000D;"),
        NEWLINE("&#x000A;"),
        TAB("&#x0009;"),
        QUOT("&quot;"),
        AMP("&amp;"),
        LT("&lt;"),
        GT("&gt;");

        private final java.lang.String escapedChar;

        EscapedChar(java.lang.String str) {
            this.escapedChar = str;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return this.escapedChar;
        }
    }

    public enum MetadataDirective {
        COPY("COPY"),
        REPLACE("REPLACE");

        private final java.lang.String directiveAsString;

        MetadataDirective(java.lang.String str) {
            this.directiveAsString = str;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return this.directiveAsString;
        }
    }

    public static void addDateHeader(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str, java.util.Date date) {
        if (date != null) {
            map.put(str, com.alibaba.sdk.android.oss.common.utils.DateUtil.formatRfc822Date(date));
        }
    }

    public static void addHeader(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str, java.lang.String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    public static void addStringListHeader(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str, java.util.List<java.lang.String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        map.put(str, join(list));
    }

    public static void assertNotNull(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException(str);
        }
    }

    public static void assertTrue(boolean z, java.lang.String str) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(str);
        }
    }

    public static java.lang.String buildBaseLogInfo(android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("=====[device info]=====\n");
        sb.append("[INFO]: android_version：" + android.os.Build.VERSION.RELEASE + "\n");
        sb.append("[INFO]: mobile_model：" + android.os.Build.MODEL + "\n");
        return sb.toString();
    }

    public static java.lang.String buildCanonicalString(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(requestMessage.getMethod().toString() + "\n");
        java.util.Map headers = requestMessage.getHeaders();
        java.util.TreeMap treeMap = new java.util.TreeMap();
        if (headers != null) {
            for (java.util.Map.Entry entry : headers.entrySet()) {
                if (entry.getKey() != null) {
                    java.lang.String lowerCase = ((java.lang.String) entry.getKey()).toLowerCase();
                    if (lowerCase.equals("Content-Type".toLowerCase()) || lowerCase.equals("Content-MD5".toLowerCase()) || lowerCase.equals("Date".toLowerCase()) || lowerCase.startsWith(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_PREFIX)) {
                        treeMap.put(lowerCase, ((java.lang.String) entry.getValue()).trim());
                    }
                }
            }
        }
        if (!treeMap.containsKey("Content-Type".toLowerCase())) {
            treeMap.put("Content-Type".toLowerCase(), "");
        }
        if (!treeMap.containsKey("Content-MD5".toLowerCase())) {
            treeMap.put("Content-MD5".toLowerCase(), "");
        }
        for (java.util.Map.Entry entry2 : treeMap.entrySet()) {
            java.lang.String str = (java.lang.String) entry2.getKey();
            java.lang.Object value = entry2.getValue();
            if (str.startsWith(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_PREFIX)) {
                sb.append(str);
                sb.append(':');
                sb.append(value);
            } else {
                sb.append(value);
            }
            sb.append("\n");
        }
        sb.append(buildCanonicalizedResource(requestMessage.getBucketName(), requestMessage.getObjectKey(), requestMessage.getParameters()));
        return sb.toString();
    }

    public static java.lang.String buildCanonicalizedResource(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String str3 = net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        if (str != null || str2 != null) {
            if (str2 == null) {
                str3 = net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
            } else {
                str3 = net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str2;
            }
        }
        return buildCanonicalizedResource(str3, map);
    }

    public static java.lang.String buildCanonicalizedResource(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        if (map != null) {
            java.lang.String[] strArr = (java.lang.String[]) map.keySet().toArray(new java.lang.String[map.size()]);
            java.util.Arrays.sort(strArr);
            char c = '?';
            for (java.lang.String str2 : strArr) {
                if (SIGNED_PARAMTERS.contains(str2)) {
                    sb.append(c);
                    sb.append(str2);
                    java.lang.String str3 = map.get(str2);
                    if (!isEmptyString(str3)) {
                        sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                        sb.append(str3);
                    }
                    c = kotlin.text.Typography.amp;
                }
            }
        }
        return sb.toString();
    }

    public static java.lang.String buildImagePersistentBody(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("x-oss-process=");
        if (str3.startsWith("image/")) {
            sb.append(str3);
        } else {
            sb.append("image/");
            sb.append(str3);
        }
        sb.append("|sys/");
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            java.lang.String encodeToString2 = android.util.Base64.encodeToString(str2.getBytes(), 2);
            sb.append("saveas,o_");
            sb.append(encodeToString2);
            sb.append(",b_");
            sb.append(encodeToString);
        }
        java.lang.String sb2 = sb.toString();
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("ImagePersistent body : " + sb2);
        return sb2;
    }

    public static java.lang.String buildTriggerCallbackBody(java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("x-oss-process=trigger/callback,callback_");
        if (map != null && map.size() > 0) {
            sb.append(android.util.Base64.encodeToString(new org.json.JSONObject(map).toString().getBytes(), 2));
        }
        sb.append(",callback-var_");
        if (map2 != null && map2.size() > 0) {
            sb.append(android.util.Base64.encodeToString(new org.json.JSONObject(map2).toString().getBytes(), 2));
        }
        return sb.toString();
    }

    public static java.lang.String buildXMLFromPartEtagList(java.util.List<com.alibaba.sdk.android.oss.model.PartETag> list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("<CompleteMultipartUpload>\n");
        for (com.alibaba.sdk.android.oss.model.PartETag partETag : list) {
            sb.append("<Part>\n");
            sb.append("<PartNumber>" + partETag.getPartNumber() + "</PartNumber>\n");
            sb.append("<ETag>" + partETag.getETag() + "</ETag>\n");
            sb.append("</Part>\n");
        }
        sb.append("</CompleteMultipartUpload>\n");
        return sb.toString();
    }

    public static void checkChecksum(java.lang.Long l, java.lang.Long l2, java.lang.String str) throws com.alibaba.sdk.android.oss.exception.InconsistentException {
        if (l != null && l2 != null && !l.equals(l2)) {
            throw new com.alibaba.sdk.android.oss.exception.InconsistentException(l, l2, str);
        }
    }

    public static boolean checkParamRange(long j, long j2, boolean z, long j3, boolean z2) {
        return (z && z2) ? j2 <= j && j <= j3 : (!z || z2) ? (z || z2) ? j2 < j && j <= j3 : j2 < j && j < j3 : j2 <= j && j < j3;
    }

    public static java.lang.String determineContentType(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String mimeTypeFromExtension;
        java.lang.String mimeTypeFromExtension2;
        if (str != null) {
            return str;
        }
        android.webkit.MimeTypeMap singleton = android.webkit.MimeTypeMap.getSingleton();
        return (str2 == null || (mimeTypeFromExtension2 = singleton.getMimeTypeFromExtension(str2.substring(str2.lastIndexOf(46) + 1))) == null) ? (str3 == null || (mimeTypeFromExtension = singleton.getMimeTypeFromExtension(str3.substring(str3.lastIndexOf(46) + 1))) == null) ? com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE : mimeTypeFromExtension : mimeTypeFromExtension2;
    }

    public static boolean doesBucketNameValid(com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest) {
        return !(oSSRequest instanceof com.alibaba.sdk.android.oss.model.ListBucketsRequest);
    }

    public static boolean doesRequestNeedObjectKey(com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest) {
        boolean z;
        boolean z2;
        return ((oSSRequest instanceof com.alibaba.sdk.android.oss.model.ListObjectsRequest) || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.ListBucketsRequest) || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.CreateBucketRequest) || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.DeleteBucketRequest) || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.GetBucketInfoRequest) || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.GetBucketACLRequest) || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest) || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest) || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.GetBucketRefererRequest) || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.PutBucketRefererRequest) || ((z = oSSRequest instanceof com.alibaba.sdk.android.oss.model.PutBucketLoggingRequest)) || ((z2 = oSSRequest instanceof com.alibaba.sdk.android.oss.model.GetBucketLoggingRequest)) || z || z2 || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.DeleteBucketLoggingRequest) || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.PutBucketLifecycleRequest) || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.GetBucketLifecycleRequest) || (oSSRequest instanceof com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleRequest)) ? false : true;
    }

    public static void ensureBucketNameValid(java.lang.String str) {
        if (!validateBucketName(str)) {
            throw new java.lang.IllegalArgumentException("The bucket name is invalid. \nA bucket name must: \n1) be comprised of lower-case characters, numbers or dash(-); \n2) start with lower case or numbers; \n3) be between 3-63 characters long. ");
        }
    }

    public static void ensureObjectKeyValid(java.lang.String str) {
        if (!validateObjectKey(str)) {
            throw new java.lang.IllegalArgumentException("The object key is invalid. \nAn object name should be: \n1) between 1 - 1023 bytes long when encoded as UTF-8 \n2) cannot contain LF or CR or unsupported chars in XML1.0, \n3) cannot begin with \"/\" or \"\\\".");
        }
    }

    public static void ensureRequestValid(com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest, com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) {
        if (doesBucketNameValid(oSSRequest)) {
            ensureBucketNameValid(requestMessage.getBucketName());
        }
        if (doesRequestNeedObjectKey(oSSRequest)) {
            ensureObjectKeyValid(requestMessage.getObjectKey());
        }
        if (oSSRequest instanceof com.alibaba.sdk.android.oss.model.CopyObjectRequest) {
            ensureObjectKeyValid(((com.alibaba.sdk.android.oss.model.CopyObjectRequest) oSSRequest).getDestinationKey());
        }
    }

    public static java.lang.String escapeKey(java.lang.String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            com.alibaba.sdk.android.oss.common.utils.OSSUtils.EscapedChar escapedChar = charAt != '\t' ? charAt != '\n' ? charAt != '\r' ? charAt != '\"' ? charAt != '&' ? charAt != '<' ? charAt != '>' ? null : com.alibaba.sdk.android.oss.common.utils.OSSUtils.EscapedChar.GT : com.alibaba.sdk.android.oss.common.utils.OSSUtils.EscapedChar.LT : com.alibaba.sdk.android.oss.common.utils.OSSUtils.EscapedChar.AMP : com.alibaba.sdk.android.oss.common.utils.OSSUtils.EscapedChar.QUOT : com.alibaba.sdk.android.oss.common.utils.OSSUtils.EscapedChar.RETURN : com.alibaba.sdk.android.oss.common.utils.OSSUtils.EscapedChar.NEWLINE : com.alibaba.sdk.android.oss.common.utils.OSSUtils.EscapedChar.TAB;
            if (escapedChar != null) {
                sb.append(escapedChar.toString());
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static boolean isCname(java.lang.String str) {
        for (java.lang.String str2 : com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_CNAME_EXCLUDE_LIST) {
            if (str.toLowerCase().endsWith(str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmptyString(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str);
    }

    public static boolean isInCustomCnameExcludeList(java.lang.String str, java.util.List<java.lang.String> list) {
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            if (str.endsWith(it.next().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOssOriginHost(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        for (java.lang.String str2 : com.alibaba.sdk.android.oss.common.OSSConstants.OSS_ORIGN_HOST) {
            if (str.toLowerCase().endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidateIP(java.lang.String str) throws java.lang.Exception {
        boolean isNumericAddress;
        if (str == null) {
            throw new java.lang.Exception("host is null");
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            isNumericAddress = android.net.InetAddresses.isNumericAddress(str);
            return isNumericAddress;
        }
        try {
            return ((java.lang.Boolean) java.lang.Class.forName("java.net.InetAddress").getMethod("isNumeric", java.lang.String.class).invoke(null, str)).booleanValue();
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    public static java.lang.String join(java.util.List<java.lang.String> list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = true;
        for (java.lang.String str : list) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(str);
            z = false;
        }
        return sb.toString();
    }

    public static java.lang.String paramToQueryString(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = true;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.String value = entry.getValue();
            if (!z) {
                sb.append("&");
            }
            sb.append(com.alibaba.sdk.android.oss.common.utils.HttpUtil.urlEncode(key, str));
            if (!isEmptyString(value)) {
                sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(com.alibaba.sdk.android.oss.common.utils.HttpUtil.urlEncode(value, str));
            }
            z = false;
        }
        return sb.toString();
    }

    public static void populateCopyObjectHeaders(com.alibaba.sdk.android.oss.model.CopyObjectRequest copyObjectRequest, java.util.Map<java.lang.String, java.lang.String> map) {
        map.put(com.alibaba.sdk.android.oss.common.OSSHeaders.COPY_OBJECT_SOURCE, net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + copyObjectRequest.getSourceBucketName() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.alibaba.sdk.android.oss.common.utils.HttpUtil.urlEncode(copyObjectRequest.getSourceKey(), "utf-8"));
        addDateHeader(map, com.alibaba.sdk.android.oss.common.OSSHeaders.COPY_OBJECT_SOURCE_IF_MODIFIED_SINCE, copyObjectRequest.getModifiedSinceConstraint());
        addDateHeader(map, com.alibaba.sdk.android.oss.common.OSSHeaders.COPY_OBJECT_SOURCE_IF_UNMODIFIED_SINCE, copyObjectRequest.getUnmodifiedSinceConstraint());
        addStringListHeader(map, com.alibaba.sdk.android.oss.common.OSSHeaders.COPY_OBJECT_SOURCE_IF_MATCH, copyObjectRequest.getMatchingETagConstraints());
        addStringListHeader(map, com.alibaba.sdk.android.oss.common.OSSHeaders.COPY_OBJECT_SOURCE_IF_NONE_MATCH, copyObjectRequest.getNonmatchingEtagConstraints());
        addHeader(map, com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION, copyObjectRequest.getServerSideEncryption());
        com.alibaba.sdk.android.oss.model.ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
        if (newObjectMetadata != null) {
            map.put(com.alibaba.sdk.android.oss.common.OSSHeaders.COPY_OBJECT_METADATA_DIRECTIVE, com.alibaba.sdk.android.oss.common.utils.OSSUtils.MetadataDirective.REPLACE.toString());
            populateRequestMetadata(map, newObjectMetadata);
        }
        removeHeader(map, "Content-Length");
    }

    public static void populateListBucketRequestParameters(com.alibaba.sdk.android.oss.model.ListBucketsRequest listBucketsRequest, java.util.Map<java.lang.String, java.lang.String> map) {
        if (listBucketsRequest.getPrefix() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.PREFIX, listBucketsRequest.getPrefix());
        }
        if (listBucketsRequest.getMarker() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.MARKER, listBucketsRequest.getMarker());
        }
        if (listBucketsRequest.getMaxKeys() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.MAX_KEYS, java.lang.Integer.toString(listBucketsRequest.getMaxKeys().intValue()));
        }
    }

    public static void populateListMultipartUploadsRequestParameters(com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest listMultipartUploadsRequest, java.util.Map<java.lang.String, java.lang.String> map) {
        if (listMultipartUploadsRequest.getDelimiter() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.DELIMITER, listMultipartUploadsRequest.getDelimiter());
        }
        if (listMultipartUploadsRequest.getMaxUploads() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.MAX_UPLOADS, java.lang.Integer.toString(listMultipartUploadsRequest.getMaxUploads().intValue()));
        }
        if (listMultipartUploadsRequest.getKeyMarker() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.KEY_MARKER, listMultipartUploadsRequest.getKeyMarker());
        }
        if (listMultipartUploadsRequest.getPrefix() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.PREFIX, listMultipartUploadsRequest.getPrefix());
        }
        if (listMultipartUploadsRequest.getUploadIdMarker() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.UPLOAD_ID_MARKER, listMultipartUploadsRequest.getUploadIdMarker());
        }
        if (listMultipartUploadsRequest.getEncodingType() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.ENCODING_TYPE, listMultipartUploadsRequest.getEncodingType());
        }
    }

    public static void populateListObjectsRequestParameters(com.alibaba.sdk.android.oss.model.ListObjectsRequest listObjectsRequest, java.util.Map<java.lang.String, java.lang.String> map) {
        if (listObjectsRequest.getPrefix() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.PREFIX, listObjectsRequest.getPrefix());
        }
        if (listObjectsRequest.getMarker() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.MARKER, listObjectsRequest.getMarker());
        }
        if (listObjectsRequest.getDelimiter() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.DELIMITER, listObjectsRequest.getDelimiter());
        }
        if (listObjectsRequest.getMaxKeys() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.MAX_KEYS, java.lang.Integer.toString(listObjectsRequest.getMaxKeys().intValue()));
        }
        if (listObjectsRequest.getEncodingType() != null) {
            map.put(com.alibaba.sdk.android.oss.common.RequestParameters.ENCODING_TYPE, listObjectsRequest.getEncodingType());
        }
    }

    public static java.lang.String populateMapToBase64JsonString(java.util.Map<java.lang.String, java.lang.String> map) {
        return android.util.Base64.encodeToString(new org.json.JSONObject(map).toString().getBytes(), 2);
    }

    public static void populateRequestMetadata(java.util.Map<java.lang.String, java.lang.String> map, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        if (objectMetadata == null) {
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> rawMetadata = objectMetadata.getRawMetadata();
        if (rawMetadata != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : rawMetadata.entrySet()) {
                map.put(entry.getKey(), entry.getValue().toString());
            }
        }
        java.util.Map<java.lang.String, java.lang.String> userMetadata = objectMetadata.getUserMetadata();
        if (userMetadata != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : userMetadata.entrySet()) {
                java.lang.String key = entry2.getKey();
                java.lang.String value = entry2.getValue();
                if (key != null) {
                    key = key.trim();
                }
                if (value != null) {
                    value = value.trim();
                }
                map.put(key, value);
            }
        }
    }

    public static void removeHeader(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        if (str == null || !map.containsKey(str)) {
            return;
        }
        map.remove(str);
    }

    public static java.lang.String sign(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            return com.alibaba.sdk.android.oss.signer.SignParameters.AUTHORIZATION_PREFIX + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + new com.alibaba.sdk.android.oss.common.auth.HmacSHA1Signature().computeSignature(str2, str3).trim();
        } catch (java.lang.Exception e) {
            throw new java.lang.IllegalStateException("Compute signature failed!", e);
        }
    }

    public static void signRequest(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) throws java.lang.Exception {
        com.alibaba.sdk.android.oss.common.auth.OSSFederationToken oSSFederationToken;
        java.lang.String sign;
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("signRequest start");
        if (requestMessage.isAuthorizationRequired()) {
            if (requestMessage.getCredentialProvider() == null) {
                throw new java.lang.IllegalStateException("当前CredentialProvider为空！！！\n1. 请检查您是否在初始化OSSService时设置CredentialProvider;\n2. 如果您bucket为公共权限，请确认获取到Bucket后已经调用Bucket中接口声明ACL;");
            }
            com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider credentialProvider = requestMessage.getCredentialProvider();
            boolean z = credentialProvider instanceof com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
            if (z) {
                oSSFederationToken = ((com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider) credentialProvider).getValidFederationToken();
                if (oSSFederationToken == null) {
                    com.alibaba.sdk.android.oss.common.OSSLog.logError("Can't get a federation token");
                    throw new java.io.IOException("Can't get a federation token");
                }
                requestMessage.getHeaders().put(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
            } else if (credentialProvider instanceof com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider) {
                oSSFederationToken = credentialProvider.getFederationToken();
                requestMessage.getHeaders().put(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
            } else {
                oSSFederationToken = null;
            }
            java.lang.String buildCanonicalString = buildCanonicalString(requestMessage);
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("get contentToSign");
            if (z || (credentialProvider instanceof com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider)) {
                sign = sign(oSSFederationToken.getTempAK(), oSSFederationToken.getTempSK(), buildCanonicalString);
            } else if (credentialProvider instanceof com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider) {
                com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider = (com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider) credentialProvider;
                sign = sign(oSSPlainTextAKSKCredentialProvider.getAccessKeyId(), oSSPlainTextAKSKCredentialProvider.getAccessKeySecret(), buildCanonicalString);
            } else {
                sign = credentialProvider instanceof com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider ? ((com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider) credentialProvider).signContent(buildCanonicalString) : "---initValue---";
            }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("signed content: " + buildCanonicalString + "   \n ---------   signature: " + sign, false);
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("get signature");
            requestMessage.getHeaders().put("Authorization", sign);
        }
    }

    public static boolean validateBucketName(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-z0-9][a-z0-9\\-]{1,61}[a-z0-9]$");
    }

    public static boolean validateObjectKey(java.lang.String str) {
        if (str != null && str.length() > 0 && str.length() <= 1023) {
            try {
                str.getBytes("utf-8");
                char[] charArray = str.toCharArray();
                char c = charArray[0];
                if (c != '/' && c != '\\') {
                    for (char c2 : charArray) {
                        if (c2 != '\t' && c2 < ' ') {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (java.io.UnsupportedEncodingException unused) {
            }
        }
        return false;
    }
}
