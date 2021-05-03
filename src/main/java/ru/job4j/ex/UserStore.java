package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            if (user.getUsername().equals(login)) {
                rsl = users[i];
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("UserNotFoundException");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() > 3) {
            return true;
        }
        throw new UserInvalidException("UserInvalidException");
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Pav", true),
                new User("Kolya", true),
                new User("Ivan", true),
                new User("Nadya", true)
        };
        try {
            User user = findUser(users, "Pav");
            if (validate(user)) {
                System.out.println("This user has an access");
            }

        } catch (UserInvalidException ei) {
            System.out.println("User is not valid");
        } catch (UserNotFoundException en) {
            System.out.println("User is not found");
        }
    }
}
