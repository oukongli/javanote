package com.shdev.demo.mail.javamail.jacob;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

/**
 * Created by ou_ko on 2016/7/26.
 */
public class TestJacob {
    public static void main(String[] args) {
        ActiveXComponent axOutlook = new ActiveXComponent("Outlook.Application");
        Dispatch mailItem = Dispatch.call(axOutlook, "CreateItem", 0).getDispatch();
        //收件人
        Dispatch recipients = Dispatch.call(mailItem, "Recipients").getDispatch();
        Dispatch.call(recipients, "Add", "ou_kongli@qq.com");
        Dispatch.call(recipients, "Add", "oukongli@gmail.com");

        Dispatch.put(mailItem, "CC", "ou_kongli@outlook.com");

        String body = "<html><body><div style='color:red;'>This is a Test !</div></body></html>";
        Dispatch.put(mailItem, "HTMLBody", body);
        //邮件主题
        Dispatch.put(mailItem, "Subject", "jacob demo");
        //附件
        Dispatch attachments = Dispatch.call(mailItem, "Attachments").getDispatch();
        Dispatch.call(attachments, "Add", "z:\\jacob-1.18.zip");
//        Dispatch.call(attachments, "Add", "D:\\20110128.txt");
//显示新邮件窗口
        Dispatch.call(mailItem, "Display");
//        Dispatch.call(mailItem, "Send");
    }

}
