package com.example.demo.mailing.Repository;
import com.example.demo.mailing.Model.EmailDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmailRepository {
    String sendSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);

}
