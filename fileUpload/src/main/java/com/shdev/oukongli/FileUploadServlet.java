package com.shdev.oukongli;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ou_kongli on 2015/5/23.
 */
public class FileUploadServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMutipart = ServletFileUpload.isMultipartContent(request);
        if (isMutipart) {
            ServletFileUpload upload = new ServletFileUpload();
            InputStream inputStream = null;
            FileOutputStream fos = null;
            try {
                FileItemIterator iter = upload.getItemIterator(request);
                while (iter.hasNext()) {
                    FileItemStream fis = iter.next();
                    inputStream = fis.openStream();
                    if (fis.isFormField()) {
                        System.out.println(fis.getFieldName() +":" + Streams.asString(inputStream));
                    } else {
                        System.out.println(fis.getName());
                        String path = request.getSession().getServletContext().getRealPath("/upload");
                        path += fis.getName();
                        fos = new FileOutputStream(path);
                        byte[] buf = new byte[1024];
                        int len = 0;
                        while((len = inputStream.read(buf)) > 0) {
                            fos.write(buf,0, len);
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fos != null) {
                    fos.close();
                }
            }
        }
    }

    protected void doPost02(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, FileUploadException {
        if (ServletFileUpload.isMultipartContent(req)) {
            req = new MultipartRequestWrapper(req);
            System.out.println(req.getParameter("username"));
            System.out.println(req.getParameter("photo"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doPost02(req, resp);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}