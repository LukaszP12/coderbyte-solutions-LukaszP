package pl.SMSGateway;

public class Gateway {

    private SMSGateway smsGateway;

    public Gateway(SMSGateway smsGateway) {
        this.smsGateway = smsGateway;
    }

    public void wyslijSms(String numerTel, String trescSms) {
//        smsGateway.send(new Sms(numerTel, trescSms));
    }


}
