package com.tencent.connect.common;

/* loaded from: classes19.dex */
public class UIListenerManager {
    private static com.tencent.connect.common.UIListenerManager a;
    private java.util.Map<java.lang.String, com.tencent.connect.common.UIListenerManager.ApiTask> b;

    public class ApiTask {
        public com.tencent.tauth.IUiListener mListener;
        public int mRequestCode;

        public ApiTask(int i, com.tencent.tauth.IUiListener iUiListener) {
            this.mRequestCode = i;
            this.mListener = iUiListener;
        }
    }

    private UIListenerManager() {
        java.util.Map<java.lang.String, com.tencent.connect.common.UIListenerManager.ApiTask> synchronizedMap = java.util.Collections.synchronizedMap(new java.util.HashMap());
        this.b = synchronizedMap;
        if (synchronizedMap == null) {
            this.b = java.util.Collections.synchronizedMap(new java.util.HashMap());
        }
    }

    private com.tencent.tauth.IUiListener a(int i, com.tencent.tauth.IUiListener iUiListener) {
        if (i == 11101) {
            com.tencent.open.log.SLog.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11105) {
            com.tencent.open.log.SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11106) {
            com.tencent.open.log.SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        }
        return iUiListener;
    }

    public static com.tencent.connect.common.UIListenerManager getInstance() {
        if (a == null) {
            a = new com.tencent.connect.common.UIListenerManager();
        }
        return a;
    }

    public com.tencent.tauth.IUiListener getListnerWithAction(java.lang.String str) {
        com.tencent.connect.common.UIListenerManager.ApiTask apiTask;
        if (str == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.b) {
            apiTask = this.b.get(str);
            this.b.remove(str);
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public com.tencent.tauth.IUiListener getListnerWithRequestCode(int i) {
        java.lang.String a2 = com.tencent.open.utils.i.a(i);
        if (a2 != null) {
            return getListnerWithAction(a2);
        }
        com.tencent.open.log.SLog.e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + i);
        return null;
    }

    public void handleDataToListener(android.content.Intent intent, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (intent == null) {
            iUiListener.onCancel();
            return;
        }
        java.lang.String stringExtra = intent.getStringExtra(com.tencent.connect.common.Constants.KEY_ACTION);
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra(com.tencent.connect.common.Constants.KEY_ERROR_CODE, 0);
            if (intExtra != 0) {
                com.tencent.open.log.SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                iUiListener.onError(new com.tencent.tauth.UiError(intExtra, intent.getStringExtra(com.tencent.connect.common.Constants.KEY_ERROR_MSG), intent.getStringExtra(com.tencent.connect.common.Constants.KEY_ERROR_DETAIL)));
                return;
            }
            java.lang.String stringExtra2 = intent.getStringExtra(com.tencent.connect.common.Constants.KEY_RESPONSE);
            if (stringExtra2 == null) {
                com.tencent.open.log.SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                iUiListener.onComplete(new org.json.JSONObject());
                return;
            }
            try {
                iUiListener.onComplete(com.tencent.open.utils.l.d(stringExtra2));
                return;
            } catch (org.json.JSONException e) {
                iUiListener.onError(new com.tencent.tauth.UiError(-4, com.tencent.connect.common.Constants.MSG_JSON_ERROR, stringExtra2));
                com.tencent.open.log.SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                return;
            }
        }
        if ("action_share".equals(stringExtra)) {
            java.lang.String stringExtra3 = intent.getStringExtra("result");
            java.lang.String stringExtra4 = intent.getStringExtra("response");
            if (com.anythink.expressad.d.a.b.dO.equals(stringExtra3)) {
                iUiListener.onCancel();
                return;
            }
            if ("error".equals(stringExtra3)) {
                iUiListener.onError(new com.tencent.tauth.UiError(-6, "unknown error", stringExtra4 + ""));
                return;
            }
            if (com.anythink.expressad.foundation.d.c.bX.equals(stringExtra3)) {
                try {
                    iUiListener.onComplete(new org.json.JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                } catch (org.json.JSONException e2) {
                    e2.printStackTrace();
                    iUiListener.onError(new com.tencent.tauth.UiError(-4, "json error", stringExtra4 + ""));
                }
            }
        }
    }

    public boolean onActivityResult(int i, int i2, android.content.Intent intent, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i + " res=" + i2);
        com.tencent.tauth.IUiListener listnerWithRequestCode = getListnerWithRequestCode(i);
        if (listnerWithRequestCode == null) {
            if (iUiListener == null) {
                com.tencent.open.log.SLog.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                return false;
            }
            listnerWithRequestCode = a(i, iUiListener);
        }
        if (i2 != -1) {
            listnerWithRequestCode.onCancel();
        } else {
            if (intent == null) {
                listnerWithRequestCode.onError(new com.tencent.tauth.UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
                return true;
            }
            java.lang.String stringExtra = intent.getStringExtra(com.tencent.connect.common.Constants.KEY_ACTION);
            if ("action_login".equals(stringExtra)) {
                int intExtra = intent.getIntExtra(com.tencent.connect.common.Constants.KEY_ERROR_CODE, 0);
                if (intExtra == 0) {
                    java.lang.String stringExtra2 = intent.getStringExtra(com.tencent.connect.common.Constants.KEY_RESPONSE);
                    if (stringExtra2 != null) {
                        try {
                            listnerWithRequestCode.onComplete(com.tencent.open.utils.l.d(stringExtra2));
                        } catch (org.json.JSONException e) {
                            listnerWithRequestCode.onError(new com.tencent.tauth.UiError(-4, com.tencent.connect.common.Constants.MSG_JSON_ERROR, stringExtra2));
                            com.tencent.open.log.SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                        }
                    } else {
                        com.tencent.open.log.SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                        listnerWithRequestCode.onComplete(new org.json.JSONObject());
                    }
                } else {
                    com.tencent.open.log.SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                    listnerWithRequestCode.onError(new com.tencent.tauth.UiError(intExtra, intent.getStringExtra(com.tencent.connect.common.Constants.KEY_ERROR_MSG), intent.getStringExtra(com.tencent.connect.common.Constants.KEY_ERROR_DETAIL)));
                }
            } else if ("action_share".equals(stringExtra) || "action_request_avatar".equals(stringExtra) || "action_request_dynamic_avatar".equals(stringExtra) || "action_request_set_emotion".equals(stringExtra)) {
                java.lang.String stringExtra3 = intent.getStringExtra("result");
                java.lang.String stringExtra4 = intent.getStringExtra("response");
                if (com.anythink.expressad.d.a.b.dO.equals(stringExtra3)) {
                    listnerWithRequestCode.onCancel();
                } else if ("error".equals(stringExtra3)) {
                    listnerWithRequestCode.onError(new com.tencent.tauth.UiError(-6, "unknown error", stringExtra4 + ""));
                } else if (com.anythink.expressad.foundation.d.c.bX.equals(stringExtra3)) {
                    try {
                        listnerWithRequestCode.onComplete(new org.json.JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                    } catch (org.json.JSONException e2) {
                        e2.printStackTrace();
                        listnerWithRequestCode.onError(new com.tencent.tauth.UiError(-4, "json error", stringExtra4 + ""));
                    }
                }
            } else {
                int intExtra2 = intent.getIntExtra(com.tencent.connect.common.Constants.KEY_ERROR_CODE, 0);
                if (intExtra2 == 0) {
                    java.lang.String stringExtra5 = intent.getStringExtra(com.tencent.connect.common.Constants.KEY_RESPONSE);
                    if (stringExtra5 != null) {
                        try {
                            listnerWithRequestCode.onComplete(com.tencent.open.utils.l.d(stringExtra5));
                        } catch (org.json.JSONException unused) {
                            listnerWithRequestCode.onError(new com.tencent.tauth.UiError(-4, com.tencent.connect.common.Constants.MSG_JSON_ERROR, stringExtra5));
                        }
                    } else {
                        listnerWithRequestCode.onComplete(new org.json.JSONObject());
                    }
                } else {
                    listnerWithRequestCode.onError(new com.tencent.tauth.UiError(intExtra2, intent.getStringExtra(com.tencent.connect.common.Constants.KEY_ERROR_MSG), intent.getStringExtra(com.tencent.connect.common.Constants.KEY_ERROR_DETAIL)));
                }
            }
        }
        return true;
    }

    public java.lang.Object setListenerWithRequestcode(int i, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.connect.common.UIListenerManager.ApiTask put;
        java.lang.String a2 = com.tencent.open.utils.i.a(i);
        if (a2 == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i);
            return null;
        }
        synchronized (this.b) {
            put = this.b.put(a2, new com.tencent.connect.common.UIListenerManager.ApiTask(i, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }

    public java.lang.Object setListnerWithAction(java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.connect.common.UIListenerManager.ApiTask put;
        int a2 = com.tencent.open.utils.i.a(str);
        if (a2 == -1) {
            com.tencent.open.log.SLog.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
            return null;
        }
        synchronized (this.b) {
            put = this.b.put(str, new com.tencent.connect.common.UIListenerManager.ApiTask(a2, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }
}
