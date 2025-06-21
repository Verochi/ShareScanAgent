package com.alibaba.sdk.android.oss.common.auth;

/* loaded from: classes.dex */
public class OSSAuthCredentialsProvider extends com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider {
    private java.lang.String mAuthServerUrl;
    private com.alibaba.sdk.android.oss.common.auth.OSSAuthCredentialsProvider.AuthDecoder mDecoder;

    public interface AuthDecoder {
        java.lang.String decode(java.lang.String str);
    }

    public OSSAuthCredentialsProvider(java.lang.String str) {
        this.mAuthServerUrl = str;
    }

    @Override // com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider, com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider
    public com.alibaba.sdk.android.oss.common.auth.OSSFederationToken getFederationToken() throws com.alibaba.sdk.android.oss.ClientException {
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(this.mAuthServerUrl).openConnection();
            httpURLConnection.setConnectTimeout(10000);
            java.lang.String readStreamAsString = com.alibaba.sdk.android.oss.common.utils.IOUtils.readStreamAsString(httpURLConnection.getInputStream(), "utf-8");
            com.alibaba.sdk.android.oss.common.auth.OSSAuthCredentialsProvider.AuthDecoder authDecoder = this.mDecoder;
            if (authDecoder != null) {
                readStreamAsString = authDecoder.decode(readStreamAsString);
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(readStreamAsString);
            if (jSONObject.getInt("StatusCode") == 200) {
                return new com.alibaba.sdk.android.oss.common.auth.OSSFederationToken(jSONObject.getString(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID), jSONObject.getString("AccessKeySecret"), jSONObject.getString(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN), jSONObject.getString("Expiration"));
            }
            throw new com.alibaba.sdk.android.oss.ClientException("ErrorCode: " + jSONObject.getString("ErrorCode") + "| ErrorMessage: " + jSONObject.getString("ErrorMessage"));
        } catch (java.lang.Exception e) {
            throw new com.alibaba.sdk.android.oss.ClientException(e);
        }
    }

    public void setAuthServerUrl(java.lang.String str) {
        this.mAuthServerUrl = str;
    }

    public void setDecoder(com.alibaba.sdk.android.oss.common.auth.OSSAuthCredentialsProvider.AuthDecoder authDecoder) {
        this.mDecoder = authDecoder;
    }
}
