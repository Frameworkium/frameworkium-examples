package theinternet.util.Constants;

public class Users
{
    public enum Credentials
    {
        VALIDLOGIN("tomsmith", "SuperSecretPassword!"),
        INVALIDLOGIN("smithtom", "NotSoSecretPassword!");

        private final String userName;
        private final String password;

        Credentials(String userName, String password)
        {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName()
        {
            return userName;
        }

        public String getPassword()
        {
            return password;
        }

    }
}
