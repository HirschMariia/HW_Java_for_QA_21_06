import java.util.regex.Pattern;

public class PasswordValidator {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&_+\\-=])[A-Za-z\\d!@#$%^&_+\\-=]{8,}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValidPassword(String password) {
        return pattern.matcher(password).matches();
    }

    public static void main(String[] args) {
        String[] passwords = {
                "Password1!",
                "password1!",
                "PASSWORD1!",
                "Pass1!",
                "Password!",
                "Password1",
                "Passw0rd!"
        };

        for (String password : passwords) {
            System.out.println(password + " is valid: " + isValidPassword(password));
        }
    }
}
