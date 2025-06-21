package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class JAXPUtils {
    public static final org.apache.tools.ant.util.FileUtils a = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static javax.xml.parsers.SAXParserFactory b = null;
    public static javax.xml.parsers.SAXParserFactory c = null;
    public static javax.xml.parsers.DocumentBuilderFactory d = null;

    public static org.apache.tools.ant.BuildException a(org.xml.sax.SAXException sAXException) {
        java.lang.Exception exception = sAXException.getException();
        return exception != null ? new org.apache.tools.ant.BuildException(exception) : new org.apache.tools.ant.BuildException(sAXException);
    }

    public static synchronized javax.xml.parsers.DocumentBuilderFactory b() throws org.apache.tools.ant.BuildException {
        javax.xml.parsers.DocumentBuilderFactory documentBuilderFactory;
        synchronized (org.apache.tools.ant.util.JAXPUtils.class) {
            if (d == null) {
                try {
                    d = javax.xml.parsers.DocumentBuilderFactory.newInstance();
                } catch (javax.xml.parsers.FactoryConfigurationError e) {
                    throw new org.apache.tools.ant.BuildException("Document builder factory has not been configured correctly: " + e.getMessage(), e);
                }
            }
            documentBuilderFactory = d;
        }
        return documentBuilderFactory;
    }

    public static javax.xml.parsers.SAXParser c(javax.xml.parsers.SAXParserFactory sAXParserFactory) throws org.apache.tools.ant.BuildException {
        try {
            return sAXParserFactory.newSAXParser();
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            throw new org.apache.tools.ant.BuildException("Cannot create parser for the given configuration: " + e.getMessage(), e);
        } catch (org.xml.sax.SAXException e2) {
            throw a(e2);
        }
    }

    public static javax.xml.parsers.DocumentBuilder getDocumentBuilder() throws org.apache.tools.ant.BuildException {
        try {
            return b().newDocumentBuilder();
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public static synchronized javax.xml.parsers.SAXParserFactory getNSParserFactory() throws org.apache.tools.ant.BuildException {
        javax.xml.parsers.SAXParserFactory sAXParserFactory;
        synchronized (org.apache.tools.ant.util.JAXPUtils.class) {
            if (c == null) {
                javax.xml.parsers.SAXParserFactory newParserFactory = newParserFactory();
                c = newParserFactory;
                newParserFactory.setNamespaceAware(true);
            }
            sAXParserFactory = c;
        }
        return sAXParserFactory;
    }

    public static org.xml.sax.XMLReader getNamespaceXMLReader() throws org.apache.tools.ant.BuildException {
        try {
            return c(getNSParserFactory()).getXMLReader();
        } catch (org.xml.sax.SAXException e) {
            throw a(e);
        }
    }

    public static org.xml.sax.Parser getParser() throws org.apache.tools.ant.BuildException {
        try {
            return c(getParserFactory()).getParser();
        } catch (org.xml.sax.SAXException e) {
            throw a(e);
        }
    }

    public static synchronized javax.xml.parsers.SAXParserFactory getParserFactory() throws org.apache.tools.ant.BuildException {
        javax.xml.parsers.SAXParserFactory sAXParserFactory;
        synchronized (org.apache.tools.ant.util.JAXPUtils.class) {
            if (b == null) {
                b = newParserFactory();
            }
            sAXParserFactory = b;
        }
        return sAXParserFactory;
    }

    public static java.lang.String getSystemId(java.io.File file) {
        return a.toURI(file.getAbsolutePath());
    }

    public static org.xml.sax.XMLReader getXMLReader() throws org.apache.tools.ant.BuildException {
        try {
            return c(getParserFactory()).getXMLReader();
        } catch (org.xml.sax.SAXException e) {
            throw a(e);
        }
    }

    public static javax.xml.parsers.SAXParserFactory newParserFactory() throws org.apache.tools.ant.BuildException {
        try {
            return javax.xml.parsers.SAXParserFactory.newInstance();
        } catch (javax.xml.parsers.FactoryConfigurationError e) {
            throw new org.apache.tools.ant.BuildException("XML parser factory has not been configured correctly: " + e.getMessage(), e);
        }
    }
}
