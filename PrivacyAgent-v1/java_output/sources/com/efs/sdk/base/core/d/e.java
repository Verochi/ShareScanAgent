package com.efs.sdk.base.core.d;

/* loaded from: classes22.dex */
public final class e implements com.efs.sdk.base.core.b.d {
    private static void a(com.efs.sdk.base.http.HttpResponse httpResponse) {
        if (httpResponse == null || android.text.TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        for (java.lang.String str : httpResponse.data.split("`")) {
            java.lang.String[] split = str.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length >= 2) {
                if (split[0].equalsIgnoreCase("retcode")) {
                    httpResponse.setBizCode(split[1]);
                } else {
                    ((java.util.Map) httpResponse.extra).put(split[0], split[1]);
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.b.d
    @androidx.annotation.NonNull
    public final com.efs.sdk.base.http.HttpResponse a(com.efs.sdk.base.core.model.LogDto logDto, boolean z) {
        com.efs.sdk.base.http.HttpResponse httpResponse;
        com.efs.sdk.base.core.d.f fVar;
        try {
            fVar = com.efs.sdk.base.core.d.f.a.a;
            com.efs.sdk.base.core.d.c cVar = fVar.a;
            java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
            java.lang.String md5 = com.efs.sdk.base.core.util.secure.EncodeUtil.md5(cVar.b + cVar.c + valueOf + "AppChk#2014");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str = cVar.a;
            if (str.startsWith(com.alipay.sdk.m.l.a.q)) {
                sb.append(str);
                sb.append("?chk=");
            } else {
                sb.append(str);
                sb.append("?chk=");
            }
            sb.append(md5.substring(md5.length() - 8));
            sb.append("&vno=");
            sb.append(valueOf);
            sb.append("&uuid=");
            sb.append(cVar.c);
            sb.append("&app=");
            sb.append(cVar.b);
            sb.append("&zip=gzip");
            java.lang.String sb2 = sb.toString();
            int i = 0;
            byte[] bArr = new byte[0];
            if (logDto.getLogBodyType() == 0) {
                bArr = logDto.getData();
                i = bArr.length;
            } else if (1 == logDto.getLogBodyType()) {
                bArr = com.efs.sdk.base.core.util.FileUtil.read(logDto.getFile().getPath());
                i = bArr.length;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
            hashMap.put("Content-Length", java.lang.String.valueOf(i));
            com.efs.sdk.base.core.util.a.d a = new com.efs.sdk.base.core.util.a.d(sb2).a(hashMap);
            a.a.c = bArr;
            httpResponse = a.a().b();
            a(httpResponse);
        } catch (java.lang.Throwable th) {
            httpResponse = 0 == 0 ? new com.efs.sdk.base.http.HttpResponse() : null;
            com.efs.sdk.base.core.util.Log.e("efs.wa.send", "get file size error", th);
        }
        if (!httpResponse.succ) {
            com.efs.sdk.base.core.util.Log.i("efs.base", "wa upload fail, resp is " + httpResponse.toString());
            return httpResponse;
        }
        com.efs.sdk.base.core.util.Log.i("efs.base", "wa upload succ, " + httpResponse.toString());
        com.efs.sdk.base.core.util.FileUtil.delete(logDto.getFile());
        return httpResponse;
    }
}
