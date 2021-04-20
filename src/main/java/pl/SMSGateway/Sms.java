package pl.SMSGateway;

public class Sms {


    private String numerTel;
    private String trescSms;

    public Sms(String numerTel, String trescSms) {
        this.numerTel = numerTel;
        this.trescSms = trescSms;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "numerTel='" + numerTel + '\'' +
                ", trescSms='" + trescSms + '\'' +
                '}';
    }
}
