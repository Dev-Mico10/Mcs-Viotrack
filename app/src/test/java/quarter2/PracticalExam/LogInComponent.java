package quarter2.PracticalExam;

public class LogInComponent {
    public class LoginSystem {

        public String username;
        public String password;

        public boolean login(String username, String password) {

            this.username = username;
            this.password = password;

            System.out.println("Validating Login Credentials...");

            if (validateCredentials()) {

                System.out.println("Grant Access");
                System.out.println("Opening User Dashboard...");
                return true;

            } else {

                System.out.println("Invalid Username or Password");
                return false;

            }
        }

        private boolean validateCredentials() {

            return username.equals("admin") &&
                    password.equals("12345");

        }
    }


    }
