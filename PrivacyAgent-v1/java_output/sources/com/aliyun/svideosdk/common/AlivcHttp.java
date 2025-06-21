package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AlivcHttp {
    public static com.aliyun.svideosdk.common.AlivcHttpResponse request(com.aliyun.svideosdk.common.AlivcHttpRequest alivcHttpRequest) {
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(alivcHttpRequest.getUrl()).openConnection();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("url : ");
            sb.append(alivcHttpRequest.getUrl());
            httpURLConnection.setReadTimeout(alivcHttpRequest.getReadTimeout());
            httpURLConnection.setConnectTimeout(alivcHttpRequest.getConnectTimeout());
            httpURLConnection.setRequestMethod(alivcHttpRequest.getMethod());
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            boolean equalsIgnoreCase = "POST".equalsIgnoreCase(alivcHttpRequest.getMethod());
            if (equalsIgnoreCase) {
                httpURLConnection.setDoInput(true);
            }
            java.util.Map<java.lang.String, java.lang.String> headers = alivcHttpRequest.getHeaders();
            for (java.lang.String str : headers.keySet()) {
                httpURLConnection.addRequestProperty(str, headers.get(str));
            }
            httpURLConnection.connect();
            if (equalsIgnoreCase) {
                java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(alivcHttpRequest.getBody());
                outputStream.flush();
                outputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            java.lang.String responseMessage = httpURLConnection.getResponseMessage();
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    com.aliyun.svideosdk.common.AlivcHttpResponse alivcHttpResponse = new com.aliyun.svideosdk.common.AlivcHttpResponse(responseCode, responseMessage);
                    alivcHttpResponse.setBody(sb2.toString());
                    return alivcHttpResponse;
                }
                sb2.append(readLine);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return new com.aliyun.svideosdk.common.AlivcHttpResponse(-1, e.getMessage());
        }
    }
}
