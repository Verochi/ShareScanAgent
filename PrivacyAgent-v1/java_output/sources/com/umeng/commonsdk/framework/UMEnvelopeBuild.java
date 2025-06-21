package com.umeng.commonsdk.framework;

/* loaded from: classes19.dex */
public class UMEnvelopeBuild {
    public static boolean transmissionSendFlag;

    private static org.json.JSONObject add2CacheTable(android.content.Context context, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (jSONObject == null || jSONObject2 == null) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]构建信封传入 header 或 body 字段为空，直接返回");
            return null;
        }
        com.umeng.analytics.pro.k a = com.umeng.analytics.pro.k.a(context);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.UUID randomUUID = java.util.UUID.randomUUID();
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.umeng.analytics.pro.bs.e, str2);
        contentValues.put(com.umeng.analytics.pro.bs.f, a.c(jSONObject.toString()));
        contentValues.put(com.umeng.analytics.pro.bs.g, a.c(jSONObject2.toString()));
        contentValues.put(com.umeng.analytics.pro.bs.h, java.lang.String.valueOf(currentTimeMillis));
        contentValues.put(com.umeng.analytics.pro.bs.i, randomUUID.toString());
        contentValues.put(com.umeng.analytics.pro.bs.j, str);
        contentValues.put(com.umeng.analytics.pro.bs.k, str3);
        com.umeng.analytics.pro.bq.a(context).a(com.umeng.analytics.pro.bs.c, contentValues);
        if ("i".equalsIgnoreCase(str2)) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]inner业务，返回空 JSONObject。");
        } else if ("s".equalsIgnoreCase(str2)) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]分享业务 返回body。");
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            try {
                jSONObject3.put("header", new org.json.JSONObject());
                jSONObject3.put("share", jSONObject2.getJSONObject("share"));
                return jSONObject3;
            } catch (org.json.JSONException unused) {
            }
        } else if (!"p".equalsIgnoreCase(str2)) {
            try {
                if ("t".equalsIgnoreCase(str2)) {
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 半开报文，返回body。");
                    org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                    jSONObject4.put(com.umeng.commonsdk.statistics.b.a("header"), new org.json.JSONObject());
                    jSONObject4.put(com.umeng.commonsdk.statistics.b.a("analytics"), jSONObject2.getJSONObject("analytics"));
                    return jSONObject4;
                }
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 闭合报文，返回body。");
                org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                jSONObject5.put(com.umeng.commonsdk.statistics.b.a("header"), new org.json.JSONObject());
                jSONObject5.put(com.umeng.commonsdk.statistics.b.a("analytics"), jSONObject2.getJSONObject("analytics"));
                return jSONObject5;
            } catch (org.json.JSONException unused2) {
                return jSONObject2;
            }
        }
        return new org.json.JSONObject();
    }

    public static org.json.JSONObject buildEnvelopeWithExtHeader(android.content.Context context, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        return buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, com.umeng.commonsdk.statistics.UMServerURL.PATH_ANALYTICS, jSONObject.has("st") ? "t" : jSONObject2.has(com.umeng.analytics.pro.bo.aA) ? "i" : "a", "9.7.5");
    }

    public static org.json.JSONObject buildEnvelopeWithExtHeader(android.content.Context context, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]业务发起构建普通有状态信封请求。");
        org.json.JSONObject jSONObject3 = null;
        if (android.text.TextUtils.isEmpty(str)) {
            try {
                org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                try {
                    jSONObject4.put("exception", 121);
                    return jSONObject4;
                } catch (org.json.JSONException unused) {
                    jSONObject3 = jSONObject4;
                    return jSONObject3;
                }
            } catch (org.json.JSONException unused2) {
            }
        } else {
            if (com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
                if (com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(context)) {
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 未获取到，写入二级缓存");
                    return add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
                }
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 已获取到，判断二级缓存是否为空");
                if (com.umeng.analytics.pro.bq.a(context).c()) {
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存为空，直接打信封");
                    return new com.umeng.commonsdk.statistics.b().a(context.getApplicationContext(), jSONObject, jSONObject2, str, str2, str3);
                }
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存不为空，写入二级缓存");
                org.json.JSONObject add2CacheTable = add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
                if (!com.umeng.commonsdk.framework.UMWorkDispatch.eventHasExist(com.umeng.commonsdk.internal.a.t)) {
                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.t, com.umeng.commonsdk.internal.b.a(context).a(), null);
                }
                return add2CacheTable;
            }
            try {
                org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                try {
                    jSONObject5.put("exception", 120);
                    return jSONObject5;
                } catch (org.json.JSONException unused3) {
                    jSONObject3 = jSONObject5;
                    return jSONObject3;
                }
            } catch (org.json.JSONException unused4) {
            }
        }
    }

    public static org.json.JSONObject buildSilentEnvelopeWithExtHeader(android.content.Context context, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str) {
        if (com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
            return new com.umeng.commonsdk.statistics.b().a(context.getApplicationContext(), jSONObject, jSONObject2, str);
        }
        org.json.JSONObject jSONObject3 = null;
        try {
            org.json.JSONObject jSONObject4 = new org.json.JSONObject();
            try {
                jSONObject4.put("exception", 120);
                return jSONObject4;
            } catch (org.json.JSONException unused) {
                jSONObject3 = jSONObject4;
                return jSONObject3;
            }
        } catch (org.json.JSONException unused2) {
        }
    }

    public static org.json.JSONObject buildZeroEnvelopeWithExtHeader(android.content.Context context, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str) {
        if (com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
            return new com.umeng.commonsdk.statistics.b().b(context.getApplicationContext(), jSONObject, jSONObject2, str);
        }
        org.json.JSONObject jSONObject3 = null;
        try {
            org.json.JSONObject jSONObject4 = new org.json.JSONObject();
            try {
                jSONObject4.put("exception", 120);
                return jSONObject4;
            } catch (org.json.JSONException unused) {
                jSONObject3 = jSONObject4;
                return jSONObject3;
            }
        } catch (org.json.JSONException unused2) {
        }
    }

    public static long getLastInstantBuildTime(android.content.Context context) {
        if (context == null) {
            return 0L;
        }
        return com.umeng.commonsdk.framework.UMFrUtils.getLastInstantBuildTime(context.getApplicationContext());
    }

    public static long getLastSuccessfulBuildTime(android.content.Context context) {
        if (context == null) {
            return 0L;
        }
        return com.umeng.commonsdk.framework.UMFrUtils.getLastSuccessfulBuildTime(context.getApplicationContext());
    }

    public static synchronized boolean getTransmissionSendFlag() {
        boolean z;
        synchronized (com.umeng.commonsdk.framework.UMEnvelopeBuild.class) {
            z = transmissionSendFlag;
        }
        return z;
    }

    public static java.lang.String imprintProperty(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return context == null ? str2 : com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(context.getApplicationContext()).c().a(str, str2);
    }

    public static boolean isOnline(android.content.Context context) {
        return com.umeng.commonsdk.framework.UMFrUtils.isOnline(context) && (com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(context) ^ true);
    }

    public static boolean isReadyBuild(android.content.Context context, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType uMBusinessType) {
        com.umeng.commonsdk.framework.a.a(context);
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuildNew(android.content.Context context, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType uMBusinessType) {
        if (getTransmissionSendFlag()) {
            return isRet(context, uMBusinessType, false);
        }
        return false;
    }

    public static boolean isReadyBuildStateless() {
        return getTransmissionSendFlag();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r5) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        if (com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        r7 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isRet(android.content.Context context, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType uMBusinessType, boolean z) {
        if (context != null) {
            android.content.Context applicationContext = context.getApplicationContext();
            boolean isOnline = com.umeng.commonsdk.framework.UMFrUtils.isOnline(applicationContext);
            int envelopeFileNumber = com.umeng.commonsdk.framework.UMFrUtils.envelopeFileNumber(applicationContext);
            if (isOnline) {
                if (uMBusinessType != com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL) {
                    if (com.umeng.commonsdk.framework.a.a()) {
                        com.umeng.commonsdk.framework.UMWorkDispatch.sendDelayProcessMsg(com.umeng.commonsdk.framework.a.b());
                    } else if (!com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(applicationContext, uMBusinessType)) {
                    }
                    z = false;
                }
            }
            if (isOnline && envelopeFileNumber > 0) {
                com.umeng.commonsdk.framework.a.d();
            }
        }
        return z;
    }

    public static long maxDataSpace(android.content.Context context) {
        if (context == null) {
            return 0L;
        }
        return com.umeng.commonsdk.statistics.b.a(context.getApplicationContext());
    }

    public static void registerNetReceiver(android.content.Context context) {
        com.umeng.commonsdk.framework.a.b(context);
    }

    public static void sendProcessNextMsgOnce() {
        com.umeng.commonsdk.framework.a.d();
    }

    public static synchronized void setTransmissionSendFlag(boolean z) {
        synchronized (com.umeng.commonsdk.framework.UMEnvelopeBuild.class) {
            transmissionSendFlag = z;
        }
    }
}
