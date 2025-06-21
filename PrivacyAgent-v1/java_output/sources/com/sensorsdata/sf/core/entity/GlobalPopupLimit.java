package com.sensorsdata.sf.core.entity;

/* loaded from: classes19.dex */
public class GlobalPopupLimit {
    public static final java.lang.String GLOBAL_POPUP_LIMIT_FILE_NAME = "sensors_focus_global_popup_limit";
    public android.content.Context context;
    private org.json.JSONArray data;
    public boolean isInUse;
    public java.util.List<com.sensorsdata.sf.core.window.Limit> limits;
    private long startTime;

    public GlobalPopupLimit(android.content.Context context) {
        this.context = context;
        loadData();
    }

    private void loadData() {
        try {
            java.lang.String globalPopupLimit = com.sensorsdata.sf.core.SFContextManger.getInstance().getDataOperate().getGlobalPopupLimit();
            if (globalPopupLimit != null) {
                this.data = new org.json.JSONArray(globalPopupLimit);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private void saveData() {
        try {
            if (this.data != null) {
                com.sensorsdata.sf.core.SFContextManger.getInstance().getDataOperate().saveGlobalPopupLimit(this.data.toString());
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public void addCount() {
        try {
            if (this.data == null) {
                this.data = new org.json.JSONArray();
            }
            this.data.put(this.startTime);
            saveData();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public boolean isMatcher() {
        boolean z = true;
        if (this.data == null) {
            return true;
        }
        try {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTimeInMillis(this.startTime);
            calendar.add(6, -90);
            long timeInMillis = calendar.getTimeInMillis();
            java.util.Calendar calendar2 = java.util.Calendar.getInstance();
            calendar2.setTimeInMillis(this.startTime);
            for (com.sensorsdata.sf.core.window.Limit limit : this.limits) {
                limit.triggerCount = 0;
                if (limit.natural) {
                    calendar2.set(11, 0);
                    calendar2.set(12, 0);
                    calendar2.set(13, 0);
                    if (android.text.TextUtils.equals(com.sensorsdata.sf.core.window.Window.UNIT_WEEK, limit.unit)) {
                        calendar2.setFirstDayOfWeek(2);
                        calendar2.set(7, 2);
                        calendar2.add(3, -(limit.value - 1));
                    } else if (android.text.TextUtils.equals(com.sensorsdata.sf.core.window.Window.UNIT_MONTH, limit.unit)) {
                        calendar2.add(2, 0);
                        calendar2.set(5, 1);
                        calendar2.add(2, -(limit.value - 1));
                    } else {
                        calendar2.add(6, -(limit.value - 1));
                    }
                } else {
                    calendar2.add(13, -limit.changeToSecond(limit.value, limit.unit));
                }
                limit.before = calendar2.getTimeInMillis();
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int length = this.data.length();
            boolean z2 = length > 90;
            boolean z3 = true;
            for (int i = 0; i < length; i++) {
                try {
                    long optLong = this.data.optLong(i);
                    if (!z2 || optLong >= timeInMillis) {
                        java.util.Iterator<com.sensorsdata.sf.core.window.Limit> it = this.limits.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                com.sensorsdata.sf.core.window.Limit next = it.next();
                                if (optLong >= next.before && optLong <= this.startTime) {
                                    int i2 = next.triggerCount + 1;
                                    next.triggerCount = i2;
                                    if (i2 >= next.limit) {
                                        z3 = false;
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        arrayList.add(java.lang.Integer.valueOf(i));
                    }
                } catch (java.lang.Exception e) {
                    e = e;
                    z = z3;
                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                    return z;
                }
            }
            if (arrayList.size() <= 0) {
                return z3;
            }
            java.util.Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.data.remove(((java.lang.Integer) it2.next()).intValue());
            }
            saveData();
            return z3;
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public java.lang.String toString() {
        return "GlobalPopupLimit{limits=" + this.limits + ", data=" + this.data + '}';
    }
}
