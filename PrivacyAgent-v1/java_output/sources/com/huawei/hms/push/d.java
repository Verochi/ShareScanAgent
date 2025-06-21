package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class d {
    public static com.huawei.hms.aaid.constant.ErrorEnum a(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(com.huawei.hms.aaid.utils.BaseUtils.getLocalToken(context, null))) {
            return com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS;
        }
        if (!com.huawei.hms.aaid.init.AutoInitHelper.isAutoInitEnabled(context)) {
            com.huawei.hms.support.log.HMSLog.e("TokenUtil", "Token not exist");
            return com.huawei.hms.aaid.constant.ErrorEnum.ERROR_NO_TOKEN;
        }
        com.huawei.hms.support.log.HMSLog.e("TokenUtil", "Token not exist, try auto init");
        com.huawei.hms.aaid.init.AutoInitHelper.doAutoInit(context);
        return com.huawei.hms.aaid.constant.ErrorEnum.ERROR_AUTO_INITIALIZING;
    }
}
