package com.shdev.demo.mail;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class TestSendMail {
    public static void main(String[] arg) throws Exception {
        sendMailWithAttachement();
    }

    /**
     * 不需要验证的邮件发送
     *
     * @throws Exception
     */
    public static void setMessage() throws Exception {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "mail.infoservice.com.cn"); // 设置smtp的服务器地址：该邮件服务器不需要身份验证
        props.put("mail.smtp.auth", "false"); // 设置smtp服务器要身份验证:缺省设置为false

        Address from = new InternetAddress("chencheng@infoservice.com.cn");
        Address to = new InternetAddress("11@qq.com");

        Session session = Session.getDefaultInstance(props, null);
        Message message = new MimeMessage(session);
        message.setFrom(from);
        message.addRecipient(Message.RecipientType.TO, to);
        message.setText("I love U!!!");
        message.setSubject("Test");

        Transport.send(message);
        System.out.println("邮件发送完毕!");
    }

    /**
     * 带授权的发送邮件
     *
     * @throws Exception
     */
    public static void setMessageWithAuthentica() throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.126.com"); // 设置smtp的服务器地址是smtp.126.com
        props.put("mail.smtp.auth", "true"); // 设置smtp服务器要身份验证。

        PopupAuthenticator auth = new PopupAuthenticator();
        // Session 类定义了一个基本的邮件会话。通过该会话可让别的工作顺利执行。
        // 在大多数情况下，使用共享会话就足够了，即使为多个用户邮箱处理邮件会话 也是如此。
        // 您可以在通信过程的后面一步添加上用户名和密码的组合，并保持所有 的一切是独立的。
        Session session = Session.getDefaultInstance(props, auth);

        // 发送人地址
        Address addressFrom = new InternetAddress(PopupAuthenticator.username,
                PopupAuthenticator.username);
        // 收件人地址
        Address addressTo = new InternetAddress("111@qq.com");

        // 抄送地址
        // Address addressCopy = new InternetAddress("haocongping@gmail.com",
        // "George Bush");
        // 可以通过将Session对象传递给MimeMessage构造 器的方法来创建消息
        // 一个MimeMessage是一种理解MIME类型和报头（在不同的RFC文档中 均有定义）的消息。
        // 消息的报头被严格限制成只能使用US-ASCII字符，尽管非 ASCII字符可以被编码到某些报头字段中。
        Message message = new MimeMessage(session);
        message.setContent("This is mail content!", "text/plain");// 或者使用message.setText("Hello");更详细的信息请参看后续文章.
        message.setSubject("测试邮件标题");
        message.setFrom(addressFrom);
        message.addRecipient(Message.RecipientType.TO, addressTo);
        // message.addRecipient(Message.RecipientType.CC,addressCopy);
        message.saveChanges();
        // session.setDebug(true);

        Transport transport = session.getTransport("smtp"); // 创建连接
        transport.connect("smtp.126.com", PopupAuthenticator.username,
                PopupAuthenticator.password);// 连接服务器
        transport.sendMessage(message, message.getAllRecipients()); // 发送信息
        transport.close(); // 关闭连接
        System.out.println("邮件发送完毕!");
    }

    /**
     * 带附件的邮件发送
     *
     * @throws Exception
     */
    public static void sendMailWithAttachement() throws Exception {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.126.com"); // 设置smtp的服务器地址是smtp.126.com
        props.put("mail.smtp.auth", "true"); // 设置smtp服务器要身份验证。
        PopupAuthenticator auth = new PopupAuthenticator();
        Session session = Session.getInstance(props, auth);
        File filename = new File("D:\\testMail.txt");

        // 发送人地址
        Address from = new InternetAddress(PopupAuthenticator.username,
                PopupAuthenticator.password);
        Address to = new InternetAddress("地址@qq.com");
        // Define message
        MimeMessage message = new MimeMessage(session);
        message.setFrom(from);
        message.addRecipient(Message.RecipientType.TO, to);
        //message.addRecipient(Message.RecipientType.TO, new InternetAddress("第二个地址@qq.com"));
        message.setSubject("Hello 同学", "utf-8");
        // Create the message part
        BodyPart messageBodyPart = new MimeBodyPart();
        // Fill the message
        //messageBodyPart.setContent("我勒个去啊","text/html;charSet=utf-8");
        messageBodyPart.setText("看到这封信，请不要惊讶！这是系统自动发送的邮件，请善误操作！");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName("download.txt");
        multipart.addBodyPart(messageBodyPart);
        // Put parts in message
        message.setContent(multipart);
        // Send the message
        Transport.send(message);
        System.out.println("成功！");
    }

    public static void recpMail() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));

        Properties props = new Properties();
        props.put("mail.smtp.host", "mail.infoservice.com.cn");
        props.put("mail.smtp.auth", "false");
        Session session = Session.getInstance(props, new PopupAuthenticator());

        Store store = session.getStore("pop3");
        store.connect("mail.infoservice.com.cn", "zouqingbing", "你的密码");
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_WRITE);
        System.out.println(folder.getPermanentFlags().getSystemFlags().length);
        Message[] messages = folder.getMessages();
        for (int i = 0; i < messages.length; i++) {
            if (i == 19)
                messages[i].reply(true);

            System.out.println(i + ": 发件人=[" + messages[i].getFrom()[0]
                    + "],标题＝[" + messages[i].getSubject() + "]");
        }
        folder.close(true);
        store.close();
    }

}