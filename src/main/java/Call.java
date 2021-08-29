import java.util.Date;

/**
 * Created by Igor Khristiuk
 * Date: 26.08.2021
 * Time: 18:02
 */
public class Call {
    private String phone;

    public Call(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Call{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
