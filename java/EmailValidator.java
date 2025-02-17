import java.util.regex.Pattern;

public class EmailValidator {
    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValidEmail(String email) {
        return pattern.matcher(email).matches();
    }

    public static void main(String[] args) {
        String[] emails = {
                "my_25@domen-38.de",
                "user.name@domain.com",
                "first.last@sub.domain.co",
                "plainaddress",
                "@missingusername.com",
                "username@.com",
                "username@domain.c"
        };

        for (String email : emails) {
            System.out.println(email + " is valid: " + isValidEmail(email));
        }
    }
}
