package com.liulishuo.filedownloader.connection;

/* loaded from: classes23.dex */
public class RedirectHandler {
    public static com.liulishuo.filedownloader.connection.FileDownloadConnection a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, java.lang.String str) throws java.io.IOException {
        com.liulishuo.filedownloader.connection.FileDownloadConnection createConnection = com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().createConnection(str);
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            java.util.List<java.lang.String> value = entry.getValue();
            if (value != null) {
                java.util.Iterator<java.lang.String> it = value.iterator();
                while (it.hasNext()) {
                    createConnection.addHeader(key, it.next());
                }
            }
        }
        return createConnection;
    }

    public static boolean b(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }

    public static com.liulishuo.filedownloader.connection.FileDownloadConnection process(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection, java.util.List<java.lang.String> list) throws java.io.IOException, java.lang.IllegalAccessException {
        int responseCode = fileDownloadConnection.getResponseCode();
        java.lang.String responseHeaderField = fileDownloadConnection.getResponseHeaderField("Location");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        while (b(responseCode)) {
            if (responseHeaderField == null) {
                throw new java.lang.IllegalAccessException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("receive %d (redirect) but the location is null with response [%s]", java.lang.Integer.valueOf(responseCode), fileDownloadConnection.getResponseHeaderFields()));
            }
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.connection.RedirectHandler.class, "redirect to %s with %d, %s", responseHeaderField, java.lang.Integer.valueOf(responseCode), arrayList);
            }
            fileDownloadConnection.ending();
            fileDownloadConnection = a(map, responseHeaderField);
            arrayList.add(responseHeaderField);
            fileDownloadConnection.execute();
            responseCode = fileDownloadConnection.getResponseCode();
            responseHeaderField = fileDownloadConnection.getResponseHeaderField("Location");
            i++;
            if (i >= 10) {
                throw new java.lang.IllegalAccessException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("redirect too many times! %s", arrayList));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return fileDownloadConnection;
    }
}
