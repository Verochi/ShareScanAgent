package com.aliyun.common.httpfinal;

/* loaded from: classes.dex */
public class QupaiHttpFinal implements com.aliyun.common.httpfinal.HttpInterface {
    private static com.aliyun.common.httpfinal.QupaiHttpFinal instance;

    public static com.aliyun.common.httpfinal.QupaiHttpFinal getInstance() {
        if (instance == null) {
            synchronized (com.aliyun.common.httpfinal.QupaiHttpFinal.class) {
                if (instance == null) {
                    instance = new com.aliyun.common.httpfinal.QupaiHttpFinal();
                }
            }
        }
        return instance;
    }

    @Override // com.aliyun.common.httpfinal.HttpInterface
    public void initOkHttpFinal() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        okhttp3.Headers build = new okhttp3.Headers.Builder().build();
        com.aliyun.common.qupaiokhttp.OkHttpFinal.getInstance().init(new com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder().setCommenParams(arrayList).setCommenHeaders(build).setTimeout(35000L).setInterceptors(new java.util.ArrayList()).setDebug(true).build());
    }
}
