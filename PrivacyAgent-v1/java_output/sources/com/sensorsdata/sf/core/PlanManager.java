package com.sensorsdata.sf.core;

/* loaded from: classes19.dex */
class PlanManager {
    private static final java.lang.String TAG = "PlanManager";

    /* renamed from: com.sensorsdata.sf.core.PlanManager$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.sensorsdata.sf.ui.listener.PopupListener {
        final /* synthetic */ com.sensorsdata.sf.core.entity.GlobalData val$globalData;
        final /* synthetic */ com.sensorsdata.sf.core.entity.PopupPlan val$p;

        public AnonymousClass1(com.sensorsdata.sf.core.entity.GlobalData globalData, com.sensorsdata.sf.core.entity.PopupPlan popupPlan) {
            this.val$globalData = globalData;
            this.val$p = popupPlan;
        }

        @Override // com.sensorsdata.sf.ui.listener.PopupListener
        public void onPopupClick(java.lang.String str, com.sensorsdata.sf.ui.view.SensorsFocusActionModel sensorsFocusActionModel) {
        }

        @Override // com.sensorsdata.sf.ui.listener.PopupListener
        public void onPopupClose(java.lang.String str) {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            com.sensorsdata.sf.core.window.Window window = this.val$globalData.globalIntervalWindow;
            if (window != null) {
                window.setStartTime(currentTimeMillis);
            }
            com.sensorsdata.sf.core.window.Window window2 = this.val$p.planIntervalWindow;
            if (window2 != null) {
                window2.setStartTime(currentTimeMillis);
            }
        }

        @Override // com.sensorsdata.sf.ui.listener.PopupListener
        public void onPopupLoadFailed(java.lang.String str, int i, java.lang.String str2) {
            com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.PlanManager.TAG, "onPopupLoadFailed, planId=" + str + "，errorCode=" + i);
        }

        @Override // com.sensorsdata.sf.ui.listener.PopupListener
        public void onPopupLoadSuccess(java.lang.String str) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x031d A[LOOP:2: B:124:0x0317->B:126:0x031d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void TriggerPopupPlans(com.sensorsdata.sf.core.entity.GlobalData globalData, android.content.Context context, java.util.List<com.sensorsdata.sf.core.entity.PopupPlan> list, org.json.JSONObject jSONObject, com.sensorsdata.sf.core.AppStateManager appStateManager) {
        java.util.Iterator<com.sensorsdata.sf.core.entity.PopupPlan> it;
        org.json.JSONObject jSONObject2;
        java.lang.String str;
        java.lang.String str2;
        com.sensorsdata.sf.core.window.ConvertWindow convertWindow;
        com.sensorsdata.sf.core.window.Window window;
        com.sensorsdata.sf.core.window.Window window2;
        com.sensorsdata.sf.core.window.Window window3;
        com.sensorsdata.sf.core.window.Window window4;
        com.sensorsdata.sf.core.entity.GlobalPopupLimit globalPopupLimit;
        int i;
        java.util.List<com.sensorsdata.sf.core.entity.Matcher> list2;
        java.lang.String str3;
        java.lang.String str4;
        org.json.JSONObject jSONObject3;
        org.json.JSONObject jSONObject4 = jSONObject;
        java.lang.String str5 = "re_entry";
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, jSONObject.toString());
        java.lang.String optString = jSONObject4.optString("anonymous_id");
        java.lang.String optString2 = jSONObject4.optString("login_id");
        java.util.Iterator<com.sensorsdata.sf.core.entity.PopupPlan> it2 = list.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it2.hasNext()) {
            com.sensorsdata.sf.core.entity.PopupPlan next = it2.next();
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "****** Start Trigger Popup Plan ******");
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, next.toString());
            if (!next.isAudience) {
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "You are not audience.");
            } else if (!next.isActive()) {
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "Plan is paused.");
            } else if (next.isExpired()) {
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "Plan is expired:" + next.expireAt);
            } else if (globalData.isConvertSuccess(next)) {
                com.sensorsdata.sf.core.window.Window window5 = globalData.globalIntervalWindow;
                if (window5 == null || window5.isFinished()) {
                    com.sensorsdata.sf.core.window.Window window6 = next.planIntervalWindow;
                    if (window6 == null || window6.isFinished()) {
                        com.sensorsdata.sf.core.entity.PatternPopup patternPopup = next.patternPopup;
                        if (patternPopup == null) {
                            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "PatternPopup is null，it should not happen.");
                        } else {
                            org.json.JSONObject jSONObject5 = globalData.cachedGlobalData;
                            if (jSONObject5 != null) {
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append("plan_");
                                it = it2;
                                sb.append(next.planId);
                                jSONObject2 = jSONObject5.optJSONObject(sb.toString());
                            } else {
                                it = it2;
                                jSONObject2 = null;
                            }
                            if (jSONObject2 == null) {
                                jSONObject2 = new org.json.JSONObject();
                            }
                            org.json.JSONObject jSONObject6 = jSONObject2;
                            java.util.List<com.sensorsdata.sf.core.entity.Matcher> list3 = patternPopup.matcherList;
                            boolean z3 = z;
                            int i2 = 0;
                            boolean z4 = false;
                            while (true) {
                                str = str5;
                                if (i2 >= list3.size()) {
                                    break;
                                }
                                com.sensorsdata.sf.core.entity.Matcher matcher = list3.get(i2);
                                if (isMatchPattern(jSONObject4, matcher)) {
                                    if (triggerTimesCount(matcher)) {
                                        z4 = true;
                                    }
                                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                    list2 = list3;
                                    sb2.append("matcher index=");
                                    sb2.append(i2);
                                    sb2.append(", arrivalTriggerCount=");
                                    sb2.append(z4);
                                    sb2.append(", matcher=");
                                    sb2.append(matcher);
                                    com.sensorsdata.sf.core.utils.SFLog.d(TAG, sb2.toString());
                                    try {
                                        jSONObject3 = new org.json.JSONObject();
                                        str3 = optString;
                                        str4 = optString2;
                                    } catch (java.lang.Exception e) {
                                        e = e;
                                        str3 = optString;
                                        str4 = optString2;
                                    }
                                    try {
                                        jSONObject3.put(com.anythink.expressad.foundation.d.c.bT, matcher.eventWindow.getStartTime());
                                        jSONObject3.put(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, matcher.eventWindow.getCount());
                                        jSONObject6.put("matcher_" + i2, jSONObject3);
                                    } catch (java.lang.Exception e2) {
                                        e = e2;
                                        com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                                        z3 = true;
                                        i2++;
                                        jSONObject4 = jSONObject;
                                        str5 = str;
                                        list3 = list2;
                                        optString = str3;
                                        optString2 = str4;
                                    }
                                    z3 = true;
                                } else {
                                    str3 = optString;
                                    str4 = optString2;
                                    list2 = list3;
                                }
                                i2++;
                                jSONObject4 = jSONObject;
                                str5 = str;
                                list3 = list2;
                                optString = str3;
                                optString2 = str4;
                            }
                            java.lang.String str6 = optString;
                            java.lang.String str7 = optString2;
                            java.util.List<com.sensorsdata.sf.core.entity.Matcher> list4 = list3;
                            if (z3) {
                                try {
                                    if (globalData.getCachedGlobalData() == null) {
                                        globalData.setCachedGlobalData(new org.json.JSONObject());
                                    }
                                    globalData.getCachedGlobalData().put("plan_" + next.planId, jSONObject6);
                                } catch (java.lang.Exception e3) {
                                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e3);
                                }
                            }
                            if (!z4) {
                                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "It is not arrival trigger count.");
                            } else if (z2) {
                                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "Other plan trigger, continue.");
                            } else {
                                long currentTimeMillis = java.lang.System.currentTimeMillis();
                                com.sensorsdata.sf.core.entity.GlobalPopupLimit globalPopupLimit2 = globalData.globalPopupLimit;
                                if (globalPopupLimit2 != null && globalPopupLimit2.isInUse && next.enableGlobalMsgLimit) {
                                    globalPopupLimit2.setStartTime(currentTimeMillis);
                                    com.sensorsdata.sf.core.utils.SFLog.d(TAG, "Global Popup Limit:" + globalData.globalPopupLimit);
                                    if (!globalData.globalPopupLimit.isMatcher()) {
                                        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "Global Popup Limit, continue.");
                                    }
                                }
                                com.sensorsdata.sf.core.window.Window window7 = next.planReEntryWindow;
                                if (window7 == null || window7.isFinished() || next.planReEntryWindow.getCount() < next.planReEntryWindow.limit) {
                                    java.lang.String uuid = java.util.UUID.randomUUID().toString();
                                    com.sensorsdata.sf.core.window.ConvertWindow convertWindow2 = next.convertWindow;
                                    if (convertWindow2 != null) {
                                        convertWindow2.setUUID(uuid);
                                    }
                                    com.sensorsdata.sf.core.SFContextManger.getInstance().setInternalWindowListener(new com.sensorsdata.sf.core.PlanManager.AnonymousClass1(globalData, next));
                                    new com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder(context, appStateManager, java.lang.String.valueOf(next.planId), str6, str7).campaignStart(next.cname, next.popupWindowContent, next.isControlGroup, next.isTrigger);
                                    com.sensorsdata.sf.core.utils.SFLog.d(TAG, "Window will showing.");
                                    org.json.JSONObject jSONObject7 = new org.json.JSONObject();
                                    try {
                                        org.json.JSONObject jSONObject8 = new org.json.JSONObject();
                                        jSONObject8.put(com.anythink.expressad.foundation.d.c.bT, currentTimeMillis);
                                        jSONObject8.put("uuid", uuid);
                                        jSONObject6.put("convert", jSONObject8);
                                        jSONObject6.put(com.umeng.analytics.pro.bo.ba, currentTimeMillis);
                                        str2 = str;
                                        try {
                                            jSONObject7 = jSONObject6.getJSONObject(str2);
                                        } catch (java.lang.Exception unused) {
                                            convertWindow = next.convertWindow;
                                            if (convertWindow != null) {
                                            }
                                            window = next.planReEntryWindow;
                                            if (window != null) {
                                                next.planReEntryWindow.setStartTime(currentTimeMillis);
                                                next.planReEntryWindow.setCount(0);
                                                try {
                                                    jSONObject7.put(com.anythink.expressad.foundation.d.c.bT, currentTimeMillis);
                                                } catch (java.lang.Exception e4) {
                                                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e4);
                                                }
                                            }
                                            window2 = globalData.globalIntervalWindow;
                                            if (window2 != null) {
                                            }
                                            window3 = next.planIntervalWindow;
                                            if (window3 != null) {
                                            }
                                            window4 = next.planReEntryWindow;
                                            if (window4 != null) {
                                            }
                                            globalPopupLimit = globalData.globalPopupLimit;
                                            if (globalPopupLimit != null) {
                                            }
                                            while (i < list4.size()) {
                                            }
                                            globalData.cachedGlobalData.put("interval_global", currentTimeMillis);
                                            it2 = it;
                                            jSONObject4 = jSONObject;
                                            str5 = str2;
                                            z = z3;
                                            optString = str6;
                                            optString2 = str7;
                                            z2 = true;
                                        }
                                    } catch (java.lang.Exception unused2) {
                                        str2 = str;
                                    }
                                    convertWindow = next.convertWindow;
                                    if (convertWindow != null) {
                                        convertWindow.setStartTime(currentTimeMillis);
                                        globalData.addConvertPlan(next);
                                    }
                                    window = next.planReEntryWindow;
                                    if (window != null && window.isFinished()) {
                                        next.planReEntryWindow.setStartTime(currentTimeMillis);
                                        next.planReEntryWindow.setCount(0);
                                        jSONObject7.put(com.anythink.expressad.foundation.d.c.bT, currentTimeMillis);
                                    }
                                    window2 = globalData.globalIntervalWindow;
                                    if (window2 != null) {
                                        window2.setStartTime(currentTimeMillis);
                                    }
                                    window3 = next.planIntervalWindow;
                                    if (window3 != null) {
                                        window3.setStartTime(currentTimeMillis);
                                    }
                                    window4 = next.planReEntryWindow;
                                    if (window4 != null) {
                                        window4.addCount();
                                        try {
                                            jSONObject7.put(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, next.planReEntryWindow.getCount());
                                            jSONObject6.put(str2, jSONObject7);
                                        } catch (java.lang.Exception e5) {
                                            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e5);
                                        }
                                    }
                                    globalPopupLimit = globalData.globalPopupLimit;
                                    if (globalPopupLimit != null) {
                                        globalPopupLimit.setStartTime(currentTimeMillis);
                                        globalData.globalPopupLimit.addCount();
                                    }
                                    for (i = 0; i < list4.size(); i++) {
                                        com.sensorsdata.sf.core.entity.Matcher matcher2 = list4.get(i);
                                        matcher2.eventWindow.setCount(0);
                                        matcher2.eventWindow.setStartTime(0L);
                                        jSONObject6.remove("matcher_" + i);
                                    }
                                    try {
                                        globalData.cachedGlobalData.put("interval_global", currentTimeMillis);
                                    } catch (java.lang.Exception e6) {
                                        com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e6);
                                    }
                                    it2 = it;
                                    jSONObject4 = jSONObject;
                                    str5 = str2;
                                    z = z3;
                                    optString = str6;
                                    optString2 = str7;
                                    z2 = true;
                                } else {
                                    com.sensorsdata.sf.core.utils.SFLog.d(TAG, "ReEntry Window=" + next.planReEntryWindow);
                                }
                            }
                            it2 = it;
                            jSONObject4 = jSONObject;
                            z = z3;
                            str5 = str;
                            optString = str6;
                            optString2 = str7;
                        }
                    } else {
                        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "Plan Interval Window is not finished:" + next.planIntervalWindow);
                    }
                } else {
                    com.sensorsdata.sf.core.utils.SFLog.d(TAG, "Global Interval Window is not finished:" + globalData.globalIntervalWindow);
                }
            } else {
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "Convert Window is not finished:" + next.convertWindow);
            }
        }
        if (z) {
            globalData.commit();
        }
    }

    private static boolean isMatchPattern(org.json.JSONObject jSONObject, com.sensorsdata.sf.core.entity.Matcher matcher) {
        com.sensorsdata.sf.core.entity.Filter filter;
        java.util.List<com.sensorsdata.sf.core.entity.Condition> list;
        java.lang.Object opt;
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        if (!android.text.TextUtils.equals(jSONObject.getString("event"), matcher.eventName)) {
            return false;
        }
        try {
            filter = matcher.filter;
        } catch (java.lang.Exception e2) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e2);
        }
        if (filter != null && (list = filter.conditionsList) != null && !list.isEmpty()) {
            java.lang.String str = matcher.filter.relation;
            if (android.text.TextUtils.isEmpty(str)) {
                str = com.sensorsdata.sf.core.utils.PropertyExpression.OR;
            }
            int size = matcher.filter.conditionsList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                com.sensorsdata.sf.core.entity.Condition condition = matcher.filter.conditionsList.get(i2);
                java.lang.String str2 = condition.field;
                java.lang.String substring = str2.substring(str2.lastIndexOf(".") + 1, condition.field.length());
                if (substring.equals("$event_duration")) {
                    opt = jSONObject.getJSONObject("properties").opt("$event_duration");
                    if (opt == null) {
                        opt = jSONObject.getJSONObject("properties").opt("event_duration");
                    }
                } else {
                    opt = jSONObject.getJSONObject("properties").opt(substring);
                }
                if (com.sensorsdata.sf.core.utils.PropertyExpression.isMatchProperty(condition.function, opt, condition.params)) {
                    if (com.sensorsdata.sf.core.utils.PropertyExpression.OR.equalsIgnoreCase(str)) {
                        return true;
                    }
                    i++;
                }
            }
            if (!com.sensorsdata.sf.core.utils.PropertyExpression.AND.equalsIgnoreCase(str) || i != size) {
                return false;
            }
        }
        return true;
    }

    private static boolean triggerTimesCount(com.sensorsdata.sf.core.entity.Matcher matcher) {
        if (matcher.eventWindow.isFinished()) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "Event trigger window expired.");
            matcher.eventWindow.setStartTime(java.lang.System.currentTimeMillis());
            matcher.eventWindow.setCount(1);
        } else {
            matcher.eventWindow.addCount();
        }
        return android.text.TextUtils.equals(matcher.measure, "GENERAL") && matcher.eventWindow.getCount() >= java.lang.Integer.parseInt(matcher.params.get(0));
    }
}
