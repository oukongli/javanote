package com.shdev.oukongli;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ou_kongli on 2015/5/27.
 */
public class MultipartRequestWrapper extends HttpServletRequestWrapper{
    private Map<String, String[]> params = new HashMap<String, String[]>();

    public MultipartRequestWrapper(HttpServletRequest request) throws IOException, FileUploadException {
        super(request);
        setParams(request);
    }

    @Override
    public Map getParameterMap() {
        return params;
    }

    @Override
    public String getParameter(String name) {
        String[] values = params.get(name);
        return values == null ? null : values[0];
    }

    @Override
    public String[] getParameterValues(String name) {
        return super.getParameterValues(name);
    }


    public void setParams(HttpServletRequest request) throws IOException, FileUploadException {
        if (ServletFileUpload.isMultipartContent(request)) {
            ServletFileUpload upload = new ServletFileUpload();
            FileItemIterator iter = upload.getItemIterator(request);
            InputStream is = null;
            while (iter.hasNext()) {
                FileItemStream fis = iter.next();
                is = fis.openStream();
                if (fis.isFormField()) {
                    params.put(fis.getFieldName(),new String[] { Streams.asString(is)});
                } else {
                    if (is.available() > 0) {
                        String path = request.getSession().getServletContext().getRealPath("/upload");
                        Streams.copy(is, new FileOutputStream(path + FilenameUtils.getName(fis.getName())),true );
                        params.put(fis.getFieldName(), new String[] {fis.getName()});
                    }
                }
            }
        } else {
            params = request.getParameterMap();
        }
    }
}
