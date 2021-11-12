package kodlama.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import kodlama.hrms.business.abstracts.EmailService;
import kodlama.hrms.entities.concretes.User;



public class EmailManager implements EmailService{
	@Autowired
    private JavaMailSender emailSender;

    public EmailManager(JavaMailSender emailSender) {
		super();
		this.emailSender = emailSender;
	}

	@Override
    public void sendVerifyEmail(User user, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("HRMS Mail Dogrulama");
        message.setText("Hrms kayıt işleminizi tamamlamak için linke tıklayınız: http://localhost:8080/api/activationcode/active/"+code);
        message.setTo(user.getEmail());
        message.setFrom("deneme@gmail.com");


        emailSender.send(message);
    }
}
