package com.sensorsdata.sf.core;

/* loaded from: classes19.dex */
class GlobalDataLoadThread extends android.os.HandlerThread implements com.sensorsdata.sf.core.AppStateManager.AppStateChangedListener {
    private static final long GLOBAL_DATA_FLUSH_INTERVAL = 600000;
    private static final int MSG_DISTINCT_ID_CHANGED = 2;
    private static final int MSG_ENABLE_POPUP_DATE = 4;
    private static final int MSG_LOAD_LOCAL_POPUP_PLANS = 0;
    private static final int MSG_LOAD_REMOTE_POPUP_PLANS = 1;
    private static final int MSG_MIGRATION_DATE = 3;
    private static java.lang.String TAG = "GlobalDataLoadThread";
    private java.util.List<com.sensorsdata.sf.core.GlobalDataLoadThread.CallBack> callBacks;
    private boolean mAppInForeground;
    private android.content.Context mContext;
    private android.os.Handler mHandler;

    /* renamed from: com.sensorsdata.sf.core.GlobalDataLoadThread$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        private final com.sensorsdata.sf.core.data.IDataOperate dbAdapter;
        private com.sensorsdata.sf.core.entity.GlobalData mGlobalData;
        private org.json.JSONObject runningGlobalObject;

        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
            this.runningGlobalObject = null;
            this.mGlobalData = null;
            this.dbAdapter = com.sensorsdata.sf.core.SFContextManger.getInstance().getDataOperate();
        }

        /* JADX WARN: Removed duplicated region for block: B:115:0x047b A[Catch: all -> 0x065a, TryCatch #0 {, blocks: (B:14:0x0047, B:16:0x004b, B:17:0x0058, B:19:0x007a, B:21:0x00ab, B:23:0x00b5, B:24:0x00bc, B:26:0x00c4, B:29:0x00f3, B:31:0x00f9, B:33:0x0130, B:35:0x0136, B:36:0x013d, B:37:0x014a, B:39:0x0150, B:41:0x0160, B:42:0x0167, B:44:0x016d, B:46:0x0198, B:48:0x01b5, B:50:0x021e, B:52:0x022e, B:53:0x023a, B:55:0x0283, B:57:0x02a8, B:59:0x02b0, B:60:0x02c6, B:62:0x02ce, B:64:0x02f3, B:66:0x02ff, B:67:0x0307, B:69:0x030f, B:71:0x0334, B:73:0x033c, B:75:0x035a, B:76:0x035f, B:78:0x037f, B:80:0x0383, B:82:0x0387, B:83:0x038b, B:85:0x0391, B:88:0x03a3, B:91:0x03b1, B:94:0x03ba, B:101:0x03c4, B:104:0x03e5, B:106:0x03eb, B:108:0x040d, B:110:0x042d, B:112:0x0444, B:113:0x0463, B:115:0x047b, B:116:0x0483, B:118:0x0489, B:120:0x0497, B:122:0x04a7, B:124:0x04be, B:125:0x04c8, B:127:0x04ce, B:130:0x04f9, B:132:0x04ff, B:134:0x050f, B:137:0x051d, B:139:0x0530, B:141:0x0559, B:142:0x0542, B:144:0x0550, B:146:0x0556, B:152:0x0564, B:154:0x056e, B:156:0x0575, B:160:0x01c3, B:162:0x01c7, B:164:0x01cd, B:165:0x01e5, B:167:0x01e9, B:170:0x01fd, B:171:0x0203, B:173:0x0209, B:176:0x0217, B:185:0x0584, B:187:0x0590, B:188:0x0592, B:210:0x0600, B:213:0x0606, B:214:0x062b, B:216:0x062f, B:218:0x0635, B:219:0x063c, B:220:0x0646, B:222:0x064c, B:224:0x0658, B:229:0x05fd, B:190:0x0593, B:191:0x0599, B:193:0x059f, B:195:0x05b1, B:196:0x05c9, B:198:0x05cf, B:200:0x05df, B:203:0x05e3, B:208:0x05f9), top: B:13:0x0047, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:122:0x04a7 A[Catch: all -> 0x065a, TryCatch #0 {, blocks: (B:14:0x0047, B:16:0x004b, B:17:0x0058, B:19:0x007a, B:21:0x00ab, B:23:0x00b5, B:24:0x00bc, B:26:0x00c4, B:29:0x00f3, B:31:0x00f9, B:33:0x0130, B:35:0x0136, B:36:0x013d, B:37:0x014a, B:39:0x0150, B:41:0x0160, B:42:0x0167, B:44:0x016d, B:46:0x0198, B:48:0x01b5, B:50:0x021e, B:52:0x022e, B:53:0x023a, B:55:0x0283, B:57:0x02a8, B:59:0x02b0, B:60:0x02c6, B:62:0x02ce, B:64:0x02f3, B:66:0x02ff, B:67:0x0307, B:69:0x030f, B:71:0x0334, B:73:0x033c, B:75:0x035a, B:76:0x035f, B:78:0x037f, B:80:0x0383, B:82:0x0387, B:83:0x038b, B:85:0x0391, B:88:0x03a3, B:91:0x03b1, B:94:0x03ba, B:101:0x03c4, B:104:0x03e5, B:106:0x03eb, B:108:0x040d, B:110:0x042d, B:112:0x0444, B:113:0x0463, B:115:0x047b, B:116:0x0483, B:118:0x0489, B:120:0x0497, B:122:0x04a7, B:124:0x04be, B:125:0x04c8, B:127:0x04ce, B:130:0x04f9, B:132:0x04ff, B:134:0x050f, B:137:0x051d, B:139:0x0530, B:141:0x0559, B:142:0x0542, B:144:0x0550, B:146:0x0556, B:152:0x0564, B:154:0x056e, B:156:0x0575, B:160:0x01c3, B:162:0x01c7, B:164:0x01cd, B:165:0x01e5, B:167:0x01e9, B:170:0x01fd, B:171:0x0203, B:173:0x0209, B:176:0x0217, B:185:0x0584, B:187:0x0590, B:188:0x0592, B:210:0x0600, B:213:0x0606, B:214:0x062b, B:216:0x062f, B:218:0x0635, B:219:0x063c, B:220:0x0646, B:222:0x064c, B:224:0x0658, B:229:0x05fd, B:190:0x0593, B:191:0x0599, B:193:0x059f, B:195:0x05b1, B:196:0x05c9, B:198:0x05cf, B:200:0x05df, B:203:0x05e3, B:208:0x05f9), top: B:13:0x0047, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:139:0x0530 A[Catch: all -> 0x065a, TryCatch #0 {, blocks: (B:14:0x0047, B:16:0x004b, B:17:0x0058, B:19:0x007a, B:21:0x00ab, B:23:0x00b5, B:24:0x00bc, B:26:0x00c4, B:29:0x00f3, B:31:0x00f9, B:33:0x0130, B:35:0x0136, B:36:0x013d, B:37:0x014a, B:39:0x0150, B:41:0x0160, B:42:0x0167, B:44:0x016d, B:46:0x0198, B:48:0x01b5, B:50:0x021e, B:52:0x022e, B:53:0x023a, B:55:0x0283, B:57:0x02a8, B:59:0x02b0, B:60:0x02c6, B:62:0x02ce, B:64:0x02f3, B:66:0x02ff, B:67:0x0307, B:69:0x030f, B:71:0x0334, B:73:0x033c, B:75:0x035a, B:76:0x035f, B:78:0x037f, B:80:0x0383, B:82:0x0387, B:83:0x038b, B:85:0x0391, B:88:0x03a3, B:91:0x03b1, B:94:0x03ba, B:101:0x03c4, B:104:0x03e5, B:106:0x03eb, B:108:0x040d, B:110:0x042d, B:112:0x0444, B:113:0x0463, B:115:0x047b, B:116:0x0483, B:118:0x0489, B:120:0x0497, B:122:0x04a7, B:124:0x04be, B:125:0x04c8, B:127:0x04ce, B:130:0x04f9, B:132:0x04ff, B:134:0x050f, B:137:0x051d, B:139:0x0530, B:141:0x0559, B:142:0x0542, B:144:0x0550, B:146:0x0556, B:152:0x0564, B:154:0x056e, B:156:0x0575, B:160:0x01c3, B:162:0x01c7, B:164:0x01cd, B:165:0x01e5, B:167:0x01e9, B:170:0x01fd, B:171:0x0203, B:173:0x0209, B:176:0x0217, B:185:0x0584, B:187:0x0590, B:188:0x0592, B:210:0x0600, B:213:0x0606, B:214:0x062b, B:216:0x062f, B:218:0x0635, B:219:0x063c, B:220:0x0646, B:222:0x064c, B:224:0x0658, B:229:0x05fd, B:190:0x0593, B:191:0x0599, B:193:0x059f, B:195:0x05b1, B:196:0x05c9, B:198:0x05cf, B:200:0x05df, B:203:0x05e3, B:208:0x05f9), top: B:13:0x0047, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0542 A[Catch: all -> 0x065a, TryCatch #0 {, blocks: (B:14:0x0047, B:16:0x004b, B:17:0x0058, B:19:0x007a, B:21:0x00ab, B:23:0x00b5, B:24:0x00bc, B:26:0x00c4, B:29:0x00f3, B:31:0x00f9, B:33:0x0130, B:35:0x0136, B:36:0x013d, B:37:0x014a, B:39:0x0150, B:41:0x0160, B:42:0x0167, B:44:0x016d, B:46:0x0198, B:48:0x01b5, B:50:0x021e, B:52:0x022e, B:53:0x023a, B:55:0x0283, B:57:0x02a8, B:59:0x02b0, B:60:0x02c6, B:62:0x02ce, B:64:0x02f3, B:66:0x02ff, B:67:0x0307, B:69:0x030f, B:71:0x0334, B:73:0x033c, B:75:0x035a, B:76:0x035f, B:78:0x037f, B:80:0x0383, B:82:0x0387, B:83:0x038b, B:85:0x0391, B:88:0x03a3, B:91:0x03b1, B:94:0x03ba, B:101:0x03c4, B:104:0x03e5, B:106:0x03eb, B:108:0x040d, B:110:0x042d, B:112:0x0444, B:113:0x0463, B:115:0x047b, B:116:0x0483, B:118:0x0489, B:120:0x0497, B:122:0x04a7, B:124:0x04be, B:125:0x04c8, B:127:0x04ce, B:130:0x04f9, B:132:0x04ff, B:134:0x050f, B:137:0x051d, B:139:0x0530, B:141:0x0559, B:142:0x0542, B:144:0x0550, B:146:0x0556, B:152:0x0564, B:154:0x056e, B:156:0x0575, B:160:0x01c3, B:162:0x01c7, B:164:0x01cd, B:165:0x01e5, B:167:0x01e9, B:170:0x01fd, B:171:0x0203, B:173:0x0209, B:176:0x0217, B:185:0x0584, B:187:0x0590, B:188:0x0592, B:210:0x0600, B:213:0x0606, B:214:0x062b, B:216:0x062f, B:218:0x0635, B:219:0x063c, B:220:0x0646, B:222:0x064c, B:224:0x0658, B:229:0x05fd, B:190:0x0593, B:191:0x0599, B:193:0x059f, B:195:0x05b1, B:196:0x05c9, B:198:0x05cf, B:200:0x05df, B:203:0x05e3, B:208:0x05f9), top: B:13:0x0047, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:154:0x056e A[Catch: all -> 0x065a, TryCatch #0 {, blocks: (B:14:0x0047, B:16:0x004b, B:17:0x0058, B:19:0x007a, B:21:0x00ab, B:23:0x00b5, B:24:0x00bc, B:26:0x00c4, B:29:0x00f3, B:31:0x00f9, B:33:0x0130, B:35:0x0136, B:36:0x013d, B:37:0x014a, B:39:0x0150, B:41:0x0160, B:42:0x0167, B:44:0x016d, B:46:0x0198, B:48:0x01b5, B:50:0x021e, B:52:0x022e, B:53:0x023a, B:55:0x0283, B:57:0x02a8, B:59:0x02b0, B:60:0x02c6, B:62:0x02ce, B:64:0x02f3, B:66:0x02ff, B:67:0x0307, B:69:0x030f, B:71:0x0334, B:73:0x033c, B:75:0x035a, B:76:0x035f, B:78:0x037f, B:80:0x0383, B:82:0x0387, B:83:0x038b, B:85:0x0391, B:88:0x03a3, B:91:0x03b1, B:94:0x03ba, B:101:0x03c4, B:104:0x03e5, B:106:0x03eb, B:108:0x040d, B:110:0x042d, B:112:0x0444, B:113:0x0463, B:115:0x047b, B:116:0x0483, B:118:0x0489, B:120:0x0497, B:122:0x04a7, B:124:0x04be, B:125:0x04c8, B:127:0x04ce, B:130:0x04f9, B:132:0x04ff, B:134:0x050f, B:137:0x051d, B:139:0x0530, B:141:0x0559, B:142:0x0542, B:144:0x0550, B:146:0x0556, B:152:0x0564, B:154:0x056e, B:156:0x0575, B:160:0x01c3, B:162:0x01c7, B:164:0x01cd, B:165:0x01e5, B:167:0x01e9, B:170:0x01fd, B:171:0x0203, B:173:0x0209, B:176:0x0217, B:185:0x0584, B:187:0x0590, B:188:0x0592, B:210:0x0600, B:213:0x0606, B:214:0x062b, B:216:0x062f, B:218:0x0635, B:219:0x063c, B:220:0x0646, B:222:0x064c, B:224:0x0658, B:229:0x05fd, B:190:0x0593, B:191:0x0599, B:193:0x059f, B:195:0x05b1, B:196:0x05c9, B:198:0x05cf, B:200:0x05df, B:203:0x05e3, B:208:0x05f9), top: B:13:0x0047, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:157:0x0575 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:222:0x064c A[Catch: all -> 0x065a, LOOP:11: B:220:0x0646->B:222:0x064c, LOOP_END, TryCatch #0 {, blocks: (B:14:0x0047, B:16:0x004b, B:17:0x0058, B:19:0x007a, B:21:0x00ab, B:23:0x00b5, B:24:0x00bc, B:26:0x00c4, B:29:0x00f3, B:31:0x00f9, B:33:0x0130, B:35:0x0136, B:36:0x013d, B:37:0x014a, B:39:0x0150, B:41:0x0160, B:42:0x0167, B:44:0x016d, B:46:0x0198, B:48:0x01b5, B:50:0x021e, B:52:0x022e, B:53:0x023a, B:55:0x0283, B:57:0x02a8, B:59:0x02b0, B:60:0x02c6, B:62:0x02ce, B:64:0x02f3, B:66:0x02ff, B:67:0x0307, B:69:0x030f, B:71:0x0334, B:73:0x033c, B:75:0x035a, B:76:0x035f, B:78:0x037f, B:80:0x0383, B:82:0x0387, B:83:0x038b, B:85:0x0391, B:88:0x03a3, B:91:0x03b1, B:94:0x03ba, B:101:0x03c4, B:104:0x03e5, B:106:0x03eb, B:108:0x040d, B:110:0x042d, B:112:0x0444, B:113:0x0463, B:115:0x047b, B:116:0x0483, B:118:0x0489, B:120:0x0497, B:122:0x04a7, B:124:0x04be, B:125:0x04c8, B:127:0x04ce, B:130:0x04f9, B:132:0x04ff, B:134:0x050f, B:137:0x051d, B:139:0x0530, B:141:0x0559, B:142:0x0542, B:144:0x0550, B:146:0x0556, B:152:0x0564, B:154:0x056e, B:156:0x0575, B:160:0x01c3, B:162:0x01c7, B:164:0x01cd, B:165:0x01e5, B:167:0x01e9, B:170:0x01fd, B:171:0x0203, B:173:0x0209, B:176:0x0217, B:185:0x0584, B:187:0x0590, B:188:0x0592, B:210:0x0600, B:213:0x0606, B:214:0x062b, B:216:0x062f, B:218:0x0635, B:219:0x063c, B:220:0x0646, B:222:0x064c, B:224:0x0658, B:229:0x05fd, B:190:0x0593, B:191:0x0599, B:193:0x059f, B:195:0x05b1, B:196:0x05c9, B:198:0x05cf, B:200:0x05df, B:203:0x05e3, B:208:0x05f9), top: B:13:0x0047, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x022e A[Catch: all -> 0x065a, TryCatch #0 {, blocks: (B:14:0x0047, B:16:0x004b, B:17:0x0058, B:19:0x007a, B:21:0x00ab, B:23:0x00b5, B:24:0x00bc, B:26:0x00c4, B:29:0x00f3, B:31:0x00f9, B:33:0x0130, B:35:0x0136, B:36:0x013d, B:37:0x014a, B:39:0x0150, B:41:0x0160, B:42:0x0167, B:44:0x016d, B:46:0x0198, B:48:0x01b5, B:50:0x021e, B:52:0x022e, B:53:0x023a, B:55:0x0283, B:57:0x02a8, B:59:0x02b0, B:60:0x02c6, B:62:0x02ce, B:64:0x02f3, B:66:0x02ff, B:67:0x0307, B:69:0x030f, B:71:0x0334, B:73:0x033c, B:75:0x035a, B:76:0x035f, B:78:0x037f, B:80:0x0383, B:82:0x0387, B:83:0x038b, B:85:0x0391, B:88:0x03a3, B:91:0x03b1, B:94:0x03ba, B:101:0x03c4, B:104:0x03e5, B:106:0x03eb, B:108:0x040d, B:110:0x042d, B:112:0x0444, B:113:0x0463, B:115:0x047b, B:116:0x0483, B:118:0x0489, B:120:0x0497, B:122:0x04a7, B:124:0x04be, B:125:0x04c8, B:127:0x04ce, B:130:0x04f9, B:132:0x04ff, B:134:0x050f, B:137:0x051d, B:139:0x0530, B:141:0x0559, B:142:0x0542, B:144:0x0550, B:146:0x0556, B:152:0x0564, B:154:0x056e, B:156:0x0575, B:160:0x01c3, B:162:0x01c7, B:164:0x01cd, B:165:0x01e5, B:167:0x01e9, B:170:0x01fd, B:171:0x0203, B:173:0x0209, B:176:0x0217, B:185:0x0584, B:187:0x0590, B:188:0x0592, B:210:0x0600, B:213:0x0606, B:214:0x062b, B:216:0x062f, B:218:0x0635, B:219:0x063c, B:220:0x0646, B:222:0x064c, B:224:0x0658, B:229:0x05fd, B:190:0x0593, B:191:0x0599, B:193:0x059f, B:195:0x05b1, B:196:0x05c9, B:198:0x05cf, B:200:0x05df, B:203:0x05e3, B:208:0x05f9), top: B:13:0x0047, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0283 A[Catch: all -> 0x065a, TryCatch #0 {, blocks: (B:14:0x0047, B:16:0x004b, B:17:0x0058, B:19:0x007a, B:21:0x00ab, B:23:0x00b5, B:24:0x00bc, B:26:0x00c4, B:29:0x00f3, B:31:0x00f9, B:33:0x0130, B:35:0x0136, B:36:0x013d, B:37:0x014a, B:39:0x0150, B:41:0x0160, B:42:0x0167, B:44:0x016d, B:46:0x0198, B:48:0x01b5, B:50:0x021e, B:52:0x022e, B:53:0x023a, B:55:0x0283, B:57:0x02a8, B:59:0x02b0, B:60:0x02c6, B:62:0x02ce, B:64:0x02f3, B:66:0x02ff, B:67:0x0307, B:69:0x030f, B:71:0x0334, B:73:0x033c, B:75:0x035a, B:76:0x035f, B:78:0x037f, B:80:0x0383, B:82:0x0387, B:83:0x038b, B:85:0x0391, B:88:0x03a3, B:91:0x03b1, B:94:0x03ba, B:101:0x03c4, B:104:0x03e5, B:106:0x03eb, B:108:0x040d, B:110:0x042d, B:112:0x0444, B:113:0x0463, B:115:0x047b, B:116:0x0483, B:118:0x0489, B:120:0x0497, B:122:0x04a7, B:124:0x04be, B:125:0x04c8, B:127:0x04ce, B:130:0x04f9, B:132:0x04ff, B:134:0x050f, B:137:0x051d, B:139:0x0530, B:141:0x0559, B:142:0x0542, B:144:0x0550, B:146:0x0556, B:152:0x0564, B:154:0x056e, B:156:0x0575, B:160:0x01c3, B:162:0x01c7, B:164:0x01cd, B:165:0x01e5, B:167:0x01e9, B:170:0x01fd, B:171:0x0203, B:173:0x0209, B:176:0x0217, B:185:0x0584, B:187:0x0590, B:188:0x0592, B:210:0x0600, B:213:0x0606, B:214:0x062b, B:216:0x062f, B:218:0x0635, B:219:0x063c, B:220:0x0646, B:222:0x064c, B:224:0x0658, B:229:0x05fd, B:190:0x0593, B:191:0x0599, B:193:0x059f, B:195:0x05b1, B:196:0x05c9, B:198:0x05cf, B:200:0x05df, B:203:0x05e3, B:208:0x05f9), top: B:13:0x0047, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x02ce A[Catch: all -> 0x065a, TryCatch #0 {, blocks: (B:14:0x0047, B:16:0x004b, B:17:0x0058, B:19:0x007a, B:21:0x00ab, B:23:0x00b5, B:24:0x00bc, B:26:0x00c4, B:29:0x00f3, B:31:0x00f9, B:33:0x0130, B:35:0x0136, B:36:0x013d, B:37:0x014a, B:39:0x0150, B:41:0x0160, B:42:0x0167, B:44:0x016d, B:46:0x0198, B:48:0x01b5, B:50:0x021e, B:52:0x022e, B:53:0x023a, B:55:0x0283, B:57:0x02a8, B:59:0x02b0, B:60:0x02c6, B:62:0x02ce, B:64:0x02f3, B:66:0x02ff, B:67:0x0307, B:69:0x030f, B:71:0x0334, B:73:0x033c, B:75:0x035a, B:76:0x035f, B:78:0x037f, B:80:0x0383, B:82:0x0387, B:83:0x038b, B:85:0x0391, B:88:0x03a3, B:91:0x03b1, B:94:0x03ba, B:101:0x03c4, B:104:0x03e5, B:106:0x03eb, B:108:0x040d, B:110:0x042d, B:112:0x0444, B:113:0x0463, B:115:0x047b, B:116:0x0483, B:118:0x0489, B:120:0x0497, B:122:0x04a7, B:124:0x04be, B:125:0x04c8, B:127:0x04ce, B:130:0x04f9, B:132:0x04ff, B:134:0x050f, B:137:0x051d, B:139:0x0530, B:141:0x0559, B:142:0x0542, B:144:0x0550, B:146:0x0556, B:152:0x0564, B:154:0x056e, B:156:0x0575, B:160:0x01c3, B:162:0x01c7, B:164:0x01cd, B:165:0x01e5, B:167:0x01e9, B:170:0x01fd, B:171:0x0203, B:173:0x0209, B:176:0x0217, B:185:0x0584, B:187:0x0590, B:188:0x0592, B:210:0x0600, B:213:0x0606, B:214:0x062b, B:216:0x062f, B:218:0x0635, B:219:0x063c, B:220:0x0646, B:222:0x064c, B:224:0x0658, B:229:0x05fd, B:190:0x0593, B:191:0x0599, B:193:0x059f, B:195:0x05b1, B:196:0x05c9, B:198:0x05cf, B:200:0x05df, B:203:0x05e3, B:208:0x05f9), top: B:13:0x0047, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x030f A[Catch: all -> 0x065a, TryCatch #0 {, blocks: (B:14:0x0047, B:16:0x004b, B:17:0x0058, B:19:0x007a, B:21:0x00ab, B:23:0x00b5, B:24:0x00bc, B:26:0x00c4, B:29:0x00f3, B:31:0x00f9, B:33:0x0130, B:35:0x0136, B:36:0x013d, B:37:0x014a, B:39:0x0150, B:41:0x0160, B:42:0x0167, B:44:0x016d, B:46:0x0198, B:48:0x01b5, B:50:0x021e, B:52:0x022e, B:53:0x023a, B:55:0x0283, B:57:0x02a8, B:59:0x02b0, B:60:0x02c6, B:62:0x02ce, B:64:0x02f3, B:66:0x02ff, B:67:0x0307, B:69:0x030f, B:71:0x0334, B:73:0x033c, B:75:0x035a, B:76:0x035f, B:78:0x037f, B:80:0x0383, B:82:0x0387, B:83:0x038b, B:85:0x0391, B:88:0x03a3, B:91:0x03b1, B:94:0x03ba, B:101:0x03c4, B:104:0x03e5, B:106:0x03eb, B:108:0x040d, B:110:0x042d, B:112:0x0444, B:113:0x0463, B:115:0x047b, B:116:0x0483, B:118:0x0489, B:120:0x0497, B:122:0x04a7, B:124:0x04be, B:125:0x04c8, B:127:0x04ce, B:130:0x04f9, B:132:0x04ff, B:134:0x050f, B:137:0x051d, B:139:0x0530, B:141:0x0559, B:142:0x0542, B:144:0x0550, B:146:0x0556, B:152:0x0564, B:154:0x056e, B:156:0x0575, B:160:0x01c3, B:162:0x01c7, B:164:0x01cd, B:165:0x01e5, B:167:0x01e9, B:170:0x01fd, B:171:0x0203, B:173:0x0209, B:176:0x0217, B:185:0x0584, B:187:0x0590, B:188:0x0592, B:210:0x0600, B:213:0x0606, B:214:0x062b, B:216:0x062f, B:218:0x0635, B:219:0x063c, B:220:0x0646, B:222:0x064c, B:224:0x0658, B:229:0x05fd, B:190:0x0593, B:191:0x0599, B:193:0x059f, B:195:0x05b1, B:196:0x05c9, B:198:0x05cf, B:200:0x05df, B:203:0x05e3, B:208:0x05f9), top: B:13:0x0047, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x037f A[Catch: all -> 0x065a, TryCatch #0 {, blocks: (B:14:0x0047, B:16:0x004b, B:17:0x0058, B:19:0x007a, B:21:0x00ab, B:23:0x00b5, B:24:0x00bc, B:26:0x00c4, B:29:0x00f3, B:31:0x00f9, B:33:0x0130, B:35:0x0136, B:36:0x013d, B:37:0x014a, B:39:0x0150, B:41:0x0160, B:42:0x0167, B:44:0x016d, B:46:0x0198, B:48:0x01b5, B:50:0x021e, B:52:0x022e, B:53:0x023a, B:55:0x0283, B:57:0x02a8, B:59:0x02b0, B:60:0x02c6, B:62:0x02ce, B:64:0x02f3, B:66:0x02ff, B:67:0x0307, B:69:0x030f, B:71:0x0334, B:73:0x033c, B:75:0x035a, B:76:0x035f, B:78:0x037f, B:80:0x0383, B:82:0x0387, B:83:0x038b, B:85:0x0391, B:88:0x03a3, B:91:0x03b1, B:94:0x03ba, B:101:0x03c4, B:104:0x03e5, B:106:0x03eb, B:108:0x040d, B:110:0x042d, B:112:0x0444, B:113:0x0463, B:115:0x047b, B:116:0x0483, B:118:0x0489, B:120:0x0497, B:122:0x04a7, B:124:0x04be, B:125:0x04c8, B:127:0x04ce, B:130:0x04f9, B:132:0x04ff, B:134:0x050f, B:137:0x051d, B:139:0x0530, B:141:0x0559, B:142:0x0542, B:144:0x0550, B:146:0x0556, B:152:0x0564, B:154:0x056e, B:156:0x0575, B:160:0x01c3, B:162:0x01c7, B:164:0x01cd, B:165:0x01e5, B:167:0x01e9, B:170:0x01fd, B:171:0x0203, B:173:0x0209, B:176:0x0217, B:185:0x0584, B:187:0x0590, B:188:0x0592, B:210:0x0600, B:213:0x0606, B:214:0x062b, B:216:0x062f, B:218:0x0635, B:219:0x063c, B:220:0x0646, B:222:0x064c, B:224:0x0658, B:229:0x05fd, B:190:0x0593, B:191:0x0599, B:193:0x059f, B:195:0x05b1, B:196:0x05c9, B:198:0x05cf, B:200:0x05df, B:203:0x05e3, B:208:0x05f9), top: B:13:0x0047, inners: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void JSON2GlobalData(org.json.JSONObject jSONObject, int i, java.lang.String str) {
            boolean z;
            org.json.JSONObject jSONObject2;
            com.sensorsdata.sf.core.entity.GlobalData globalData;
            java.util.Iterator it;
            boolean z2;
            org.json.JSONObject jSONObject3;
            org.json.JSONObject optJSONObject;
            org.json.JSONObject optJSONObject2;
            org.json.JSONObject optJSONObject3;
            org.json.JSONObject optJSONObject4;
            org.json.JSONObject jSONObject4;
            org.json.JSONArray jSONArray;
            org.json.JSONArray optJSONArray;
            org.json.JSONObject optJSONObject5;
            java.util.List<com.sensorsdata.sf.core.entity.Matcher> list;
            java.util.List<com.sensorsdata.sf.core.entity.PopupPlan> list2;
            org.json.JSONObject optJSONObject6;
            org.json.JSONObject optJSONObject7;
            java.lang.String optString = jSONObject.optString("min_sdk_version_required");
            if (!android.text.TextUtils.isEmpty(optString) && com.sensorsdata.sf.android.sdk.BuildConfig.VERSION_NAME.compareTo(optString) < 0) {
                com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.GlobalDataLoadThread.TAG, "SDK versionName:0.5.5, minSdkVersionRequired:" + optString);
                removePlan();
                this.dbAdapter.deletePlan(str);
                return;
            }
            org.json.JSONArray optJSONArray2 = jSONObject.optJSONArray("popup_plans");
            if (optJSONArray2 == null) {
                return;
            }
            synchronized (com.sensorsdata.sf.core.SFContextManger.LOCK_OBJECT) {
                if (this.mGlobalData == null) {
                    this.mGlobalData = new com.sensorsdata.sf.core.entity.GlobalData(com.sensorsdata.sf.core.GlobalDataLoadThread.this.mContext);
                }
                com.sensorsdata.sf.core.entity.GlobalData globalData2 = this.mGlobalData;
                globalData2.userId = str;
                globalData2.minSdkVersion = optString;
                globalData2.serverCurrentTime = jSONObject.optString("server_current_time");
                this.mGlobalData.configPullIntervalMs = jSONObject.optLong("config_pull_interval_ms");
                org.json.JSONObject optJSONObject8 = jSONObject.optJSONObject("popup_interval_global");
                if (optJSONObject8 != null) {
                    this.mGlobalData.globalIntervalWindow = new com.sensorsdata.sf.core.window.Window();
                    this.mGlobalData.globalIntervalWindow.natural = optJSONObject8.optBoolean("natural");
                    this.mGlobalData.globalIntervalWindow.value = optJSONObject8.optInt("value");
                    this.mGlobalData.globalIntervalWindow.unit = optJSONObject8.optString("unit");
                    org.json.JSONObject jSONObject5 = this.runningGlobalObject;
                    if (jSONObject5 != null) {
                        long optLong = jSONObject5.optLong("interval_global");
                        if (optLong != 0) {
                            this.mGlobalData.globalIntervalWindow.setStartTime(optLong);
                        }
                    }
                }
                org.json.JSONObject optJSONObject9 = jSONObject.optJSONObject("msg_limit_global");
                if (optJSONObject9 != null) {
                    this.mGlobalData.globalPopupLimit = new com.sensorsdata.sf.core.entity.GlobalPopupLimit(com.sensorsdata.sf.core.GlobalDataLoadThread.this.mContext);
                    this.mGlobalData.globalPopupLimit.isInUse = optJSONObject9.optBoolean("is_in_use");
                    this.mGlobalData.globalPopupLimit.limits = new java.util.ArrayList();
                    org.json.JSONArray optJSONArray3 = optJSONObject9.optJSONArray("limits");
                    if (optJSONArray3 != null) {
                        for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                            org.json.JSONObject jSONObject6 = (org.json.JSONObject) optJSONArray3.opt(i2);
                            java.lang.String optString2 = jSONObject6.optString("unit");
                            boolean optBoolean = jSONObject6.optBoolean("natural");
                            int optInt = jSONObject6.optInt("value");
                            int optInt2 = jSONObject6.optInt("limit");
                            com.sensorsdata.sf.core.window.Limit limit = new com.sensorsdata.sf.core.window.Limit();
                            limit.unit = optString2;
                            limit.value = optInt;
                            limit.limit = optInt2;
                            limit.natural = optBoolean;
                            this.mGlobalData.globalPopupLimit.limits.add(limit);
                        }
                    }
                }
                com.sensorsdata.sf.core.entity.GlobalData globalData3 = this.mGlobalData;
                if (globalData3.popupPlans == null) {
                    globalData3.popupPlans = new java.util.ArrayList();
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator<com.sensorsdata.sf.core.entity.PopupPlan> it2 = this.mGlobalData.popupPlans.iterator();
                while (it2.hasNext()) {
                    arrayList.add(java.lang.Long.valueOf(it2.next().planId));
                }
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                int i3 = 0;
                boolean z3 = false;
                while (i3 < optJSONArray2.length()) {
                    org.json.JSONObject jSONObject7 = (org.json.JSONObject) optJSONArray2.opt(i3);
                    long optLong2 = jSONObject7.optLong(com.sensorsdata.sf.ui.view.UIProperty.plan_id);
                    arrayList2.add(java.lang.Long.valueOf(optLong2));
                    org.json.JSONObject optJSONObject10 = jSONObject7.optJSONObject("window_update");
                    long optLong3 = jSONObject7.optLong("last_update_config_time");
                    com.sensorsdata.sf.core.entity.PopupPlan popupPlan = this.mGlobalData.getPopupPlan(optLong2);
                    org.json.JSONObject jSONObject8 = this.runningGlobalObject;
                    org.json.JSONArray jSONArray2 = optJSONArray2;
                    if (jSONObject8 != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        z2 = z3;
                        sb.append("plan_");
                        sb.append(optLong2);
                        jSONObject3 = jSONObject8.optJSONObject(sb.toString());
                    } else {
                        z2 = z3;
                        jSONObject3 = null;
                    }
                    if (popupPlan == null) {
                        popupPlan = new com.sensorsdata.sf.core.entity.PopupPlan();
                        popupPlan.planId = optLong2;
                        popupPlan.lastUpdateConfigTime = optLong3;
                        popupPlan.windowUpdate = optJSONObject10;
                    } else if (optJSONObject10 == null) {
                        org.json.JSONObject jSONObject9 = this.runningGlobalObject;
                        if (jSONObject9 != null && optLong3 != popupPlan.lastUpdateConfigTime) {
                            jSONObject9.remove("plan_" + popupPlan.planId);
                            z3 = true;
                            popupPlan.isAudience = jSONObject7.optBoolean("is_audience");
                            if (jSONObject7.has("audience_id")) {
                                popupPlan.audienceId = java.lang.Long.valueOf(jSONObject7.optLong("audience_id"));
                            }
                            popupPlan.cname = jSONObject7.optString("cname");
                            popupPlan.section_id = jSONObject7.optString("section_id");
                            popupPlan.expireAt = jSONObject7.optLong("expire_at");
                            popupPlan.status = jSONObject7.optString("status");
                            popupPlan.isControlGroup = jSONObject7.optBoolean("is_control_group");
                            popupPlan.strategyId = jSONObject7.optString("strategy_id");
                            popupPlan.isTrigger = jSONObject7.optBoolean("is_trigger", false);
                            popupPlan.absolutePriority = jSONObject7.optInt("absolute_priority");
                            optJSONObject = jSONObject7.optJSONObject("re_enter");
                            if (optJSONObject != null) {
                                com.sensorsdata.sf.core.window.Window window = new com.sensorsdata.sf.core.window.Window();
                                popupPlan.planReEntryWindow = window;
                                window.unit = optJSONObject.optString("unit");
                                popupPlan.planReEntryWindow.value = optJSONObject.optInt("value");
                                popupPlan.planReEntryWindow.limit = optJSONObject.optInt("limit");
                                if (jSONObject3 != null && (optJSONObject7 = jSONObject3.optJSONObject("re_entry")) != null) {
                                    popupPlan.planReEntryWindow.setStartTime(optJSONObject7.optLong(com.anythink.expressad.foundation.d.c.bT));
                                    popupPlan.planReEntryWindow.setCount(optJSONObject7.optInt(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT));
                                }
                            }
                            optJSONObject2 = jSONObject7.optJSONObject("popup_interval");
                            if (optJSONObject2 != null) {
                                com.sensorsdata.sf.core.window.Window window2 = new com.sensorsdata.sf.core.window.Window();
                                popupPlan.planIntervalWindow = window2;
                                window2.unit = optJSONObject2.optString("unit");
                                popupPlan.planIntervalWindow.value = optJSONObject2.optInt("value");
                                popupPlan.planIntervalWindow.natural = optJSONObject2.optBoolean("natural");
                                if (jSONObject3 != null) {
                                    long optLong4 = jSONObject3.optLong(com.umeng.analytics.pro.bo.ba);
                                    if (optLong4 != 0) {
                                        popupPlan.planIntervalWindow.setStartTime(optLong4);
                                    }
                                    optJSONObject3 = jSONObject7.optJSONObject("convert_window");
                                    if (optJSONObject3 != null) {
                                        com.sensorsdata.sf.core.window.ConvertWindow convertWindow = new com.sensorsdata.sf.core.window.ConvertWindow();
                                        popupPlan.convertWindow = convertWindow;
                                        convertWindow.unit = optJSONObject3.optString("unit");
                                        popupPlan.convertWindow.value = optJSONObject3.optInt("value");
                                        popupPlan.convertWindow.natural = optJSONObject3.optBoolean("natural");
                                        if (jSONObject3 != null && (optJSONObject6 = jSONObject3.optJSONObject("convert")) != null) {
                                            popupPlan.convertWindow.setUUID(optJSONObject6.optString("uuid"));
                                            popupPlan.convertWindow.setStartTime(optJSONObject6.optLong(com.anythink.expressad.foundation.d.c.bT));
                                            if (!popupPlan.convertWindow.isFinished()) {
                                                this.mGlobalData.addConvertPlan(popupPlan);
                                            }
                                        }
                                    }
                                    popupPlan.popupWindowContent = jSONObject7.optJSONObject("popup_window_content");
                                    popupPlan.pageFilter = jSONObject7.optJSONObject("page_filter");
                                    popupPlan.enableGlobalMsgLimit = jSONObject7.optBoolean("global_msg_limit_enabled");
                                    optJSONObject4 = jSONObject7.optJSONObject("pattern_popup");
                                    if (optJSONObject4 != null) {
                                        com.sensorsdata.sf.core.entity.PatternPopup patternPopup = popupPlan.patternPopup;
                                        if (patternPopup != null && (list = patternPopup.matcherList) != null) {
                                            for (com.sensorsdata.sf.core.entity.Matcher matcher : list) {
                                                if (this.mGlobalData.eventPopupPlans.containsKey(matcher.eventName) && (list2 = this.mGlobalData.eventPopupPlans.get(matcher.eventName)) != null) {
                                                    list2.remove(popupPlan);
                                                    if (list2.isEmpty()) {
                                                        this.mGlobalData.eventPopupPlans.remove(matcher.eventName);
                                                    }
                                                }
                                            }
                                        }
                                        com.sensorsdata.sf.core.entity.PatternPopup patternPopup2 = new com.sensorsdata.sf.core.entity.PatternPopup();
                                        popupPlan.patternPopup = patternPopup2;
                                        patternPopup2.relation = optJSONObject4.optString(com.aliyun.svideo.editor.util.AlivcResUtil.HOST_RELATION);
                                        popupPlan.patternPopup.matcherList = new java.util.ArrayList();
                                        org.json.JSONArray optJSONArray4 = optJSONObject4.optJSONArray("matcher_list");
                                        if (optJSONArray4 != null) {
                                            int i4 = 0;
                                            while (i4 < optJSONArray4.length()) {
                                                org.json.JSONObject jSONObject10 = (org.json.JSONObject) optJSONArray4.opt(i4);
                                                com.sensorsdata.sf.core.entity.Matcher matcher2 = new com.sensorsdata.sf.core.entity.Matcher();
                                                matcher2.type = jSONObject10.optString("type");
                                                matcher2.eventWindow = new com.sensorsdata.sf.core.window.Window();
                                                org.json.JSONObject optJSONObject11 = jSONObject10.optJSONObject("window");
                                                if (optJSONObject11 != null) {
                                                    matcher2.eventWindow.value = optJSONObject11.optInt("value");
                                                    matcher2.eventWindow.unit = optJSONObject11.optString("unit");
                                                    matcher2.eventWindow.natural = optJSONObject11.optBoolean("natural");
                                                    if (jSONObject3 != null) {
                                                        org.json.JSONObject optJSONObject12 = jSONObject3.optJSONObject("matcher_" + i4);
                                                        if (optJSONObject12 != null) {
                                                            jSONObject4 = jSONObject3;
                                                            jSONArray = optJSONArray4;
                                                            matcher2.eventWindow.setStartTime(optJSONObject12.optLong(com.anythink.expressad.foundation.d.c.bT));
                                                            matcher2.eventWindow.setCount(optJSONObject12.optInt(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT));
                                                            matcher2.measure = jSONObject10.optString("measure");
                                                            matcher2.function = jSONObject10.optString("function");
                                                            optJSONArray = jSONObject10.optJSONArray("params");
                                                            if (optJSONArray != null) {
                                                                matcher2.params = new java.util.ArrayList();
                                                                for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                                                                    matcher2.params.add((java.lang.String) optJSONArray.opt(i5));
                                                                }
                                                            }
                                                            matcher2.eventName = jSONObject10.optString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CHANNEL_EVENT_NAME);
                                                            optJSONObject5 = jSONObject10.optJSONObject("filter");
                                                            if (optJSONObject5 != null) {
                                                                com.sensorsdata.sf.core.entity.Filter filter = new com.sensorsdata.sf.core.entity.Filter();
                                                                matcher2.filter = filter;
                                                                filter.relation = optJSONObject5.optString(com.aliyun.svideo.editor.util.AlivcResUtil.HOST_RELATION);
                                                                org.json.JSONArray optJSONArray5 = optJSONObject5.optJSONArray("conditions");
                                                                if (optJSONArray5 != null) {
                                                                    matcher2.filter.conditionsList = new java.util.ArrayList();
                                                                    int i6 = 0;
                                                                    while (i6 < optJSONArray5.length()) {
                                                                        com.sensorsdata.sf.core.entity.Condition condition = new com.sensorsdata.sf.core.entity.Condition();
                                                                        org.json.JSONObject jSONObject11 = (org.json.JSONObject) optJSONArray5.opt(i6);
                                                                        condition.field = jSONObject11.optString("field");
                                                                        condition.function = jSONObject11.optString("function");
                                                                        org.json.JSONArray optJSONArray6 = jSONObject11.optJSONArray("params");
                                                                        condition.params = new java.util.ArrayList();
                                                                        if (optJSONArray6 != null) {
                                                                            int i7 = 0;
                                                                            while (i7 < optJSONArray6.length()) {
                                                                                condition.params.add(optJSONArray6.opt(i7));
                                                                                i7++;
                                                                                optJSONArray5 = optJSONArray5;
                                                                            }
                                                                        }
                                                                        matcher2.filter.conditionsList.add(condition);
                                                                        i6++;
                                                                        optJSONArray5 = optJSONArray5;
                                                                    }
                                                                }
                                                            }
                                                            popupPlan.patternPopup.matcherList.add(matcher2);
                                                            if (this.mGlobalData.eventPopupPlans.containsKey(matcher2.eventName)) {
                                                                java.util.ArrayList arrayList3 = new java.util.ArrayList();
                                                                arrayList3.add(popupPlan);
                                                                this.mGlobalData.eventPopupPlans.put(matcher2.eventName, arrayList3);
                                                            } else {
                                                                java.util.List<com.sensorsdata.sf.core.entity.PopupPlan> list3 = this.mGlobalData.eventPopupPlans.get(matcher2.eventName);
                                                                if (list3 != null && !list3.contains(popupPlan)) {
                                                                    list3.add(popupPlan);
                                                                }
                                                            }
                                                            i4++;
                                                            jSONObject3 = jSONObject4;
                                                            optJSONArray4 = jSONArray;
                                                        }
                                                    }
                                                }
                                                jSONObject4 = jSONObject3;
                                                jSONArray = optJSONArray4;
                                                matcher2.measure = jSONObject10.optString("measure");
                                                matcher2.function = jSONObject10.optString("function");
                                                optJSONArray = jSONObject10.optJSONArray("params");
                                                if (optJSONArray != null) {
                                                }
                                                matcher2.eventName = jSONObject10.optString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CHANNEL_EVENT_NAME);
                                                optJSONObject5 = jSONObject10.optJSONObject("filter");
                                                if (optJSONObject5 != null) {
                                                }
                                                popupPlan.patternPopup.matcherList.add(matcher2);
                                                if (this.mGlobalData.eventPopupPlans.containsKey(matcher2.eventName)) {
                                                }
                                                i4++;
                                                jSONObject3 = jSONObject4;
                                                optJSONArray4 = jSONArray;
                                            }
                                        }
                                    }
                                    if (this.mGlobalData.popupPlans.contains(popupPlan)) {
                                        this.mGlobalData.popupPlans.add(popupPlan);
                                    }
                                    i3++;
                                    optJSONArray2 = jSONArray2;
                                }
                            }
                            optJSONObject3 = jSONObject7.optJSONObject("convert_window");
                            if (optJSONObject3 != null) {
                            }
                            popupPlan.popupWindowContent = jSONObject7.optJSONObject("popup_window_content");
                            popupPlan.pageFilter = jSONObject7.optJSONObject("page_filter");
                            popupPlan.enableGlobalMsgLimit = jSONObject7.optBoolean("global_msg_limit_enabled");
                            optJSONObject4 = jSONObject7.optJSONObject("pattern_popup");
                            if (optJSONObject4 != null) {
                            }
                            if (this.mGlobalData.popupPlans.contains(popupPlan)) {
                            }
                            i3++;
                            optJSONArray2 = jSONArray2;
                        }
                    } else {
                        org.json.JSONObject jSONObject12 = popupPlan.windowUpdate;
                        if (jSONObject12 != null) {
                            boolean equals = android.text.TextUtils.equals(jSONObject12.optString("trigger_window"), optJSONObject10.optString("trigger_window"));
                            if (jSONObject3 != null && !equals) {
                                java.util.Iterator<java.lang.String> keys = jSONObject3.keys();
                                z3 = z2;
                                while (keys.hasNext()) {
                                    if (keys.next().startsWith("matcher_")) {
                                        keys.remove();
                                        z3 = true;
                                    }
                                }
                                popupPlan.isAudience = jSONObject7.optBoolean("is_audience");
                                if (jSONObject7.has("audience_id")) {
                                }
                                popupPlan.cname = jSONObject7.optString("cname");
                                popupPlan.section_id = jSONObject7.optString("section_id");
                                popupPlan.expireAt = jSONObject7.optLong("expire_at");
                                popupPlan.status = jSONObject7.optString("status");
                                popupPlan.isControlGroup = jSONObject7.optBoolean("is_control_group");
                                popupPlan.strategyId = jSONObject7.optString("strategy_id");
                                popupPlan.isTrigger = jSONObject7.optBoolean("is_trigger", false);
                                popupPlan.absolutePriority = jSONObject7.optInt("absolute_priority");
                                optJSONObject = jSONObject7.optJSONObject("re_enter");
                                if (optJSONObject != null) {
                                }
                                optJSONObject2 = jSONObject7.optJSONObject("popup_interval");
                                if (optJSONObject2 != null) {
                                }
                                optJSONObject3 = jSONObject7.optJSONObject("convert_window");
                                if (optJSONObject3 != null) {
                                }
                                popupPlan.popupWindowContent = jSONObject7.optJSONObject("popup_window_content");
                                popupPlan.pageFilter = jSONObject7.optJSONObject("page_filter");
                                popupPlan.enableGlobalMsgLimit = jSONObject7.optBoolean("global_msg_limit_enabled");
                                optJSONObject4 = jSONObject7.optJSONObject("pattern_popup");
                                if (optJSONObject4 != null) {
                                }
                                if (this.mGlobalData.popupPlans.contains(popupPlan)) {
                                }
                                i3++;
                                optJSONArray2 = jSONArray2;
                            }
                        }
                    }
                    z3 = z2;
                    popupPlan.isAudience = jSONObject7.optBoolean("is_audience");
                    if (jSONObject7.has("audience_id")) {
                    }
                    popupPlan.cname = jSONObject7.optString("cname");
                    popupPlan.section_id = jSONObject7.optString("section_id");
                    popupPlan.expireAt = jSONObject7.optLong("expire_at");
                    popupPlan.status = jSONObject7.optString("status");
                    popupPlan.isControlGroup = jSONObject7.optBoolean("is_control_group");
                    popupPlan.strategyId = jSONObject7.optString("strategy_id");
                    popupPlan.isTrigger = jSONObject7.optBoolean("is_trigger", false);
                    popupPlan.absolutePriority = jSONObject7.optInt("absolute_priority");
                    optJSONObject = jSONObject7.optJSONObject("re_enter");
                    if (optJSONObject != null) {
                    }
                    optJSONObject2 = jSONObject7.optJSONObject("popup_interval");
                    if (optJSONObject2 != null) {
                    }
                    optJSONObject3 = jSONObject7.optJSONObject("convert_window");
                    if (optJSONObject3 != null) {
                    }
                    popupPlan.popupWindowContent = jSONObject7.optJSONObject("popup_window_content");
                    popupPlan.pageFilter = jSONObject7.optJSONObject("page_filter");
                    popupPlan.enableGlobalMsgLimit = jSONObject7.optBoolean("global_msg_limit_enabled");
                    optJSONObject4 = jSONObject7.optJSONObject("pattern_popup");
                    if (optJSONObject4 != null) {
                    }
                    if (this.mGlobalData.popupPlans.contains(popupPlan)) {
                    }
                    i3++;
                    optJSONArray2 = jSONArray2;
                }
                boolean z4 = z3;
                if (i == 1) {
                    arrayList2.retainAll(arrayList);
                    arrayList.removeAll(arrayList2);
                    if (!arrayList.isEmpty()) {
                        synchronized (com.sensorsdata.sf.core.SFContextManger.LOCK_OBJECT) {
                            java.util.Iterator it3 = arrayList.iterator();
                            z = z4;
                            while (it3.hasNext()) {
                                long longValue = ((java.lang.Long) it3.next()).longValue();
                                com.sensorsdata.sf.core.entity.PopupPlan popupPlan2 = this.mGlobalData.getPopupPlan(longValue);
                                if (popupPlan2 != null) {
                                    this.mGlobalData.removeConvertPlan(popupPlan2);
                                    this.mGlobalData.popupPlans.remove(popupPlan2);
                                    java.util.Iterator<java.util.Map.Entry<java.lang.String, java.util.List<com.sensorsdata.sf.core.entity.PopupPlan>>> it4 = this.mGlobalData.eventPopupPlans.entrySet().iterator();
                                    while (it4.hasNext()) {
                                        it4.next().getValue().remove(popupPlan2);
                                    }
                                }
                                org.json.JSONObject jSONObject13 = this.runningGlobalObject;
                                if (jSONObject13 != null) {
                                    jSONObject13.remove("plan_" + longValue);
                                    z = true;
                                }
                            }
                        }
                        jSONObject2 = this.runningGlobalObject;
                        if (jSONObject2 != null && z) {
                            java.lang.String jSONObject14 = jSONObject2.toString();
                            this.dbAdapter.savePlanLocal(this.mGlobalData.userId, jSONObject14);
                            com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.GlobalDataLoadThread.TAG, "cached data:" + jSONObject14);
                        }
                        globalData = this.mGlobalData;
                        if (globalData != null && globalData.getCachedGlobalData() == null) {
                            this.mGlobalData.setCachedGlobalData(this.runningGlobalObject);
                        }
                        it = com.sensorsdata.sf.core.GlobalDataLoadThread.this.callBacks.iterator();
                        while (it.hasNext()) {
                            ((com.sensorsdata.sf.core.GlobalDataLoadThread.CallBack) it.next()).loadSuccess(jSONObject, this.mGlobalData);
                        }
                    }
                }
                z = z4;
                jSONObject2 = this.runningGlobalObject;
                if (jSONObject2 != null) {
                    java.lang.String jSONObject142 = jSONObject2.toString();
                    this.dbAdapter.savePlanLocal(this.mGlobalData.userId, jSONObject142);
                    com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.GlobalDataLoadThread.TAG, "cached data:" + jSONObject142);
                }
                globalData = this.mGlobalData;
                if (globalData != null) {
                    this.mGlobalData.setCachedGlobalData(this.runningGlobalObject);
                }
                it = com.sensorsdata.sf.core.GlobalDataLoadThread.this.callBacks.iterator();
                while (it.hasNext()) {
                }
            }
        }

        private void loadData(int i) {
            try {
                java.lang.String distinctId = com.sensorsdata.sf.core.SFContextManger.getInstance().getDistinctId();
                com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.GlobalDataLoadThread.TAG, "distinct id:" + distinctId);
                if (i == 0) {
                    java.lang.String userId = this.dbAdapter.getUserId(distinctId);
                    java.lang.String planRemote = this.dbAdapter.getPlanRemote(userId);
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    this.dbAdapter.updatePlanTime(userId, currentTimeMillis);
                    this.dbAdapter.deletePlanOutTime(currentTimeMillis);
                    updateRunningGlobalObject(userId);
                    if (planRemote != null) {
                        com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.GlobalDataLoadThread.TAG, "loadDataFromLocal:" + com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(planRemote));
                        JSON2GlobalData(new org.json.JSONObject(planRemote), i, userId);
                        return;
                    }
                    return;
                }
                try {
                    java.lang.String pullEventConfig = com.sensorsdata.sf.core.http.HttpRequestHelper.shareInstance().pullEventConfig(distinctId);
                    if (!android.text.TextUtils.isEmpty(pullEventConfig)) {
                        com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.GlobalDataLoadThread.TAG, "loadDataFromNet:" + com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(pullEventConfig));
                        org.json.JSONObject jSONObject = new org.json.JSONObject(pullEventConfig);
                        java.lang.String optString = jSONObject.optString("user_id");
                        if (android.text.TextUtils.isEmpty(optString)) {
                            optString = distinctId;
                        } else if (!this.dbAdapter.hasPlan(optString) && this.dbAdapter.hasPlan(distinctId)) {
                            this.dbAdapter.savePlanUserId(distinctId, optString);
                        }
                        this.dbAdapter.saveUser(distinctId, optString);
                        this.dbAdapter.savePlanRemote(optString, pullEventConfig);
                        updateRunningGlobalObject(optString);
                        JSON2GlobalData(jSONObject, i, optString);
                    }
                } catch (java.lang.Exception e) {
                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                }
                com.sensorsdata.sf.core.SFContextManger.getInstance().startTriggerThread();
            } catch (java.lang.Exception e2) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e2);
            }
        }

        private void updateRunningGlobalObject(java.lang.String str) {
            synchronized (com.sensorsdata.sf.core.SFContextManger.LOCK_OBJECT) {
                com.sensorsdata.sf.core.entity.GlobalData globalData = this.mGlobalData;
                if (globalData != null) {
                    org.json.JSONObject cachedGlobalData = globalData.getCachedGlobalData();
                    this.runningGlobalObject = cachedGlobalData;
                    if (cachedGlobalData != null) {
                        com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.GlobalDataLoadThread.TAG, "CachedRunningGlobalObject:" + this.runningGlobalObject.toString());
                    }
                }
                if (this.runningGlobalObject == null) {
                    try {
                        java.lang.String planLocal = this.dbAdapter.getPlanLocal(str);
                        if (planLocal != null) {
                            this.runningGlobalObject = new org.json.JSONObject(planLocal);
                            com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.GlobalDataLoadThread.TAG, "FileRunningPopupPlan:" + this.runningGlobalObject.toString());
                        }
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        
            if (r0 <= 0) goto L13;
         */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(android.os.Message message) {
            long j;
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                loadData(i);
                sendEmptyMessage(1);
                return;
            }
            if (i == 1) {
                if (com.sensorsdata.sf.core.GlobalDataLoadThread.this.mAppInForeground) {
                    loadData(message.what);
                    com.sensorsdata.sf.core.entity.GlobalData globalData = this.mGlobalData;
                    if (globalData != null) {
                        j = globalData.configPullIntervalMs;
                    }
                    j = 600000;
                    sendEmptyMessageDelayed(1, j);
                    return;
                }
                return;
            }
            if (i == 2) {
                removePlan();
                sendEmptyMessage(1);
                return;
            }
            if (i != 3) {
                if (i == 4) {
                    com.sensorsdata.sf.core.SFContextManger.getInstance().startTriggerThread();
                    return;
                }
                return;
            }
            try {
                com.sensorsdata.sf.core.data.SFDbAdapterOperate sFDbAdapterOperate = com.sensorsdata.sf.core.data.SFDbAdapterOperate.getInstance();
                java.io.File file = new java.io.File(com.sensorsdata.sf.core.GlobalDataLoadThread.this.mContext.getFilesDir(), com.sensorsdata.sf.core.utils.Utils.SENSORS_FOCUS_REMOTE_PLANS);
                if (file.exists()) {
                    java.lang.String loadJsonFromFile = com.sensorsdata.sf.core.utils.Utils.loadJsonFromFile(file);
                    java.io.File file2 = new java.io.File(com.sensorsdata.sf.core.GlobalDataLoadThread.this.mContext.getFilesDir(), com.sensorsdata.sf.core.utils.Utils.SENSORS_FOCUS_LOCAL);
                    java.lang.String loadJsonFromFile2 = com.sensorsdata.sf.core.utils.Utils.loadJsonFromFile(file2);
                    java.lang.String distinctId = com.sensorsdata.sf.core.SFContextManger.getInstance().getDistinctId();
                    sFDbAdapterOperate.saveUser(distinctId, distinctId);
                    sFDbAdapterOperate.savePlanRemote(distinctId, loadJsonFromFile);
                    sFDbAdapterOperate.savePlanLocal(distinctId, loadJsonFromFile2);
                    com.sensorsdata.sf.core.utils.Utils.deleteFile(file2);
                    com.sensorsdata.sf.core.utils.Utils.deleteFile(file);
                    com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.GlobalDataLoadThread.TAG, "migration date success");
                }
                if (com.sensorsdata.sf.core.SFContextManger.getInstance().isEncrypt() && android.text.TextUtils.isEmpty(this.dbAdapter.getSPValue("encrypt", ""))) {
                    sFDbAdapterOperate.migrationData();
                    java.lang.String globalPopupLimit = sFDbAdapterOperate.getGlobalPopupLimit();
                    if (!android.text.TextUtils.isEmpty(globalPopupLimit)) {
                        this.dbAdapter.saveGlobalPopupLimit(globalPopupLimit);
                    }
                    this.dbAdapter.setSPValue("encrypt", "1");
                    com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.GlobalDataLoadThread.TAG, "encrypt migration date success");
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
        }

        public void removePlan() {
            synchronized (com.sensorsdata.sf.core.SFContextManger.LOCK_OBJECT) {
                com.sensorsdata.sf.core.entity.GlobalData globalData = this.mGlobalData;
                if (globalData != null) {
                    globalData.cleanAllPlans();
                    com.sensorsdata.sf.core.entity.GlobalData globalData2 = this.mGlobalData;
                    globalData2.globalIntervalWindow = null;
                    globalData2.userId = null;
                }
                this.runningGlobalObject = null;
                com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.GlobalDataLoadThread.TAG, "removePlan");
            }
        }
    }

    /* renamed from: com.sensorsdata.sf.core.GlobalDataLoadThread$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$distinctId;

        public AnonymousClass2(java.lang.String str) {
            this.val$distinctId = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.sensorsdata.sf.core.GlobalDataLoadThread.this.mHandler == null) {
                return;
            }
            com.sensorsdata.sf.core.SFContextManger sFContextManger = com.sensorsdata.sf.core.SFContextManger.getInstance();
            if (sFContextManger.getSFPlanTriggerRunnable() != null) {
                sFContextManger.getSFPlanTriggerRunnable().stop();
            }
            sFContextManger.setEventDistinct(this.val$distinctId);
            com.sensorsdata.sf.core.GlobalDataLoadThread.this.mHandler.sendEmptyMessage(2);
            com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.GlobalDataLoadThread.TAG, "onDistinctIdChange,distinct id:" + this.val$distinctId);
        }
    }

    public interface CallBack {
        void loadSuccess(org.json.JSONObject jSONObject, com.sensorsdata.sf.core.entity.GlobalData globalData);
    }

    public GlobalDataLoadThread(java.lang.String str, android.content.Context context) {
        super(str);
        this.callBacks = new java.util.ArrayList(1);
        this.mAppInForeground = true;
        this.mContext = context;
    }

    public com.sensorsdata.sf.core.GlobalDataLoadThread addCallBack(com.sensorsdata.sf.core.GlobalDataLoadThread.CallBack callBack) {
        if (!this.callBacks.contains(callBack)) {
            this.callBacks.add(callBack);
        }
        return this;
    }

    public void enableDataCollect() {
        try {
            if (com.sensorsdata.sf.core.SFContextManger.getInstance().isGlobalDateThreadStart().compareAndSet(false, true)) {
                com.sensorsdata.sf.core.SFContextManger.getInstance().setEventDistinct(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getDistinctId());
                try {
                    start();
                } catch (java.lang.Exception e) {
                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                }
                migrationDate();
                android.os.Handler handler = this.mHandler;
                if (handler != null) {
                    handler.sendEmptyMessage(0);
                }
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "GlobalDataLoadThread start");
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e2);
        }
    }

    public void migrationDate() {
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
    }

    public void onDistinctIdChange(java.lang.String str) {
        com.sensorsdata.sf.core.thread.SFPlanTaskManager.getInstance().addTriggerTask(new com.sensorsdata.sf.core.GlobalDataLoadThread.AnonymousClass2(str));
    }

    @Override // com.sensorsdata.sf.core.AppStateManager.AppStateChangedListener
    public void onEnterBackground() {
        this.mAppInForeground = false;
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    @Override // com.sensorsdata.sf.core.AppStateManager.AppStateChangedListener
    public void onEnterForeground(boolean z) {
        this.mAppInForeground = true;
        if (this.mHandler != null) {
            if (z && com.sensorsdata.sf.core.SFContextManger.getInstance().getSFPlanTriggerRunnable() != null) {
                com.sensorsdata.sf.core.SFContextManger.getInstance().getSFPlanTriggerRunnable().stop();
            }
            this.mHandler.sendEmptyMessage(z ? 1 : 0);
        }
    }

    public void sendStartTriggerThreadMsg() {
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessage(4);
        }
    }

    @Override // java.lang.Thread
    public void start() {
        super.start();
        this.mHandler = new com.sensorsdata.sf.core.GlobalDataLoadThread.AnonymousClass1(getLooper());
    }
}
