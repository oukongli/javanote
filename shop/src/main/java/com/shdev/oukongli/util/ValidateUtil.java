package com.shdev.oukongli.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ou_kongli on 2015/4/20.
 */
public class ValidateUtil {
    public static boolean validateNull(HttpServletRequest request, String[] fields) {
        boolean validate = true;
        Map<String, String> messages = new HashMap<String, String>();
        for (String field: fields) {
            String value = request.getParameter(field);
            if (value == null || "".equals(value)) {
                validate = false;
                messages.put(field, field + "不能为空");
            }
        }
        if (!validate) request.setAttribute("errorMessage", messages);
        return validate;
    }

    public static String showError(HttpServletRequest request, String filed) {
        Map<String, String> errorMsg = (Map<String, String>) request.getAttribute("errorMessage");
        if (errorMsg == null) return "";
        String msg = errorMsg.get(filed);
        if (msg == null) return "";
        return msg;
    }
}
