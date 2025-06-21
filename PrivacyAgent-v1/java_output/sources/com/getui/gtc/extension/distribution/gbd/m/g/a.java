package com.getui.gtc.extension.distribution.gbd.m.g;

/* loaded from: classes22.dex */
public final class a implements java.lang.Runnable {
    public static final java.lang.String a = "Up_Rd";
    private final java.lang.String b;
    private final java.lang.String c;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.m.g.a$1, reason: invalid class name */
    public class AnonymousClass1 implements org.xml.sax.ErrorHandler {
        public AnonymousClass1() {
        }

        @Override // org.xml.sax.ErrorHandler
        public final void error(org.xml.sax.SAXParseException sAXParseException) {
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public final void fatalError(org.xml.sax.SAXParseException sAXParseException) {
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public final void warning(org.xml.sax.SAXParseException sAXParseException) {
            throw sAXParseException;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.m.g.a$a, reason: collision with other inner class name */
    public enum EnumC0316a {
        root,
        device,
        service;

        private boolean a(org.w3c.dom.Node node) {
            return toString().equals(node.getLocalName());
        }
    }

    public a(java.lang.String str, java.lang.String str2) {
        this.b = str;
        this.c = str2;
    }

    private void a(java.lang.String str) {
        java.net.HttpURLConnection httpURLConnection;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.io.InputStream inputStream = null;
        try {
            httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.addRequestProperty(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "identity");
                java.io.InputStream inputStream2 = httpURLConnection.getInputStream();
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                            }
                            if (byteArrayOutputStream.toByteArray() != null) {
                                java.lang.String str2 = new java.lang.String(byteArrayOutputStream.toByteArray());
                                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "descriptionUrl: ".concat(java.lang.String.valueOf(str)));
                                javax.xml.parsers.DocumentBuilderFactory newInstance = javax.xml.parsers.DocumentBuilderFactory.newInstance();
                                newInstance.setNamespaceAware(true);
                                javax.xml.parsers.DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
                                newDocumentBuilder.setErrorHandler(new com.getui.gtc.extension.distribution.gbd.m.g.a.AnonymousClass1());
                                a(newDocumentBuilder.parse(new org.xml.sax.InputSource(new java.io.StringReader(str2.trim()))).getDocumentElement());
                            }
                        } else {
                            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "requestUPnPDeviceDescriptionUrl errorCode = ".concat(java.lang.String.valueOf(responseCode)));
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (java.lang.Throwable th) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                                return;
                            }
                        }
                        byteArrayOutputStream.close();
                        httpURLConnection.disconnect();
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        try {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.lang.Throwable th3) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                                    return;
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (java.lang.Throwable th4) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.lang.Throwable th5) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th5);
                                    throw th4;
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th4;
                        }
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = null;
                }
            } catch (java.lang.Throwable th7) {
                th = th7;
                byteArrayOutputStream = null;
            }
        } catch (java.lang.Throwable th8) {
            th = th8;
            httpURLConnection = null;
            byteArrayOutputStream = null;
        }
    }

    private void a(org.w3c.dom.Element element) {
        if (!element.getNodeName().equals(com.getui.gtc.extension.distribution.gbd.m.g.a.EnumC0316a.root.name())) {
            throw new com.getui.gtc.extension.distribution.gbd.m.c.a.C0313a("Root element name is not <root>: " + element.getNodeName());
        }
        org.w3c.dom.NodeList childNodes = element.getChildNodes();
        org.w3c.dom.Node node = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            org.w3c.dom.Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && com.getui.gtc.extension.distribution.gbd.m.g.a.EnumC0316a.device.toString().equals(item.getLocalName())) {
                node = item;
            }
        }
        if (node == null) {
            throw new com.getui.gtc.extension.distribution.gbd.m.c.a.C0313a("No <device> element in <root>");
        }
        a(node);
    }

    private void a(org.w3c.dom.Node node) {
        org.w3c.dom.NodeList childNodes = node.getChildNodes();
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> concurrentHashMap = com.getui.gtc.extension.distribution.gbd.d.h.z.get(this.b);
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "parseXmlDevice hostIp = " + this.b);
        if (concurrentHashMap == null) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "upnpConcurrentHashMap find no hostIp.");
            return;
        }
        for (int i = 0; i < childNodes.getLength(); i++) {
            org.w3c.dom.Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                java.lang.String localName = item.getLocalName();
                java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.m.h.a.a(item);
                concurrentHashMap.put(localName.toLowerCase(), a2);
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "ott device description: " + localName + " " + a2);
            }
        }
    }

    private void b(java.lang.String str) {
        javax.xml.parsers.DocumentBuilderFactory newInstance = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        javax.xml.parsers.DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
        newDocumentBuilder.setErrorHandler(new com.getui.gtc.extension.distribution.gbd.m.g.a.AnonymousClass1());
        a(newDocumentBuilder.parse(new org.xml.sax.InputSource(new java.io.StringReader(str.trim()))).getDocumentElement());
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.net.HttpURLConnection httpURLConnection;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        try {
            java.lang.String str = this.c;
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            java.io.InputStream inputStream = null;
            try {
                httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.addRequestProperty(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "identity");
                    java.io.InputStream inputStream2 = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        try {
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == 200) {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream2.read(bArr);
                                    if (read == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    }
                                }
                                if (byteArrayOutputStream.toByteArray() != null) {
                                    java.lang.String str2 = new java.lang.String(byteArrayOutputStream.toByteArray());
                                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "descriptionUrl: ".concat(java.lang.String.valueOf(str)));
                                    javax.xml.parsers.DocumentBuilderFactory newInstance = javax.xml.parsers.DocumentBuilderFactory.newInstance();
                                    newInstance.setNamespaceAware(true);
                                    javax.xml.parsers.DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
                                    newDocumentBuilder.setErrorHandler(new com.getui.gtc.extension.distribution.gbd.m.g.a.AnonymousClass1());
                                    a(newDocumentBuilder.parse(new org.xml.sax.InputSource(new java.io.StringReader(str2.trim()))).getDocumentElement());
                                }
                            } else {
                                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "requestUPnPDeviceDescriptionUrl errorCode = ".concat(java.lang.String.valueOf(responseCode)));
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (java.lang.Throwable th) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                                    return;
                                }
                            }
                            byteArrayOutputStream.close();
                            httpURLConnection.disconnect();
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            inputStream = inputStream2;
                            try {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (java.lang.Throwable th3) {
                                        com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                                        return;
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } finally {
                                if (inputStream != null) {
                                    try {
                                    } catch (java.lang.Throwable th4) {
                                    }
                                }
                            }
                        }
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        byteArrayOutputStream = null;
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = null;
                }
            } catch (java.lang.Throwable th7) {
                th = th7;
                httpURLConnection = null;
                byteArrayOutputStream = null;
            }
        } catch (java.lang.Throwable th8) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "run error: ".concat(java.lang.String.valueOf(th8)));
        }
    }
}
