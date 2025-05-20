package LibraryManagementSystem.model.user;


import LibraryManagementSystem.model.UserType;

public class UserFactory {
    public static User createUser(UserType type, String id, String name, String email) {
        switch (type) {
            case MEMBER: return new Member(id, name, email);
            case LIBRARIAN: return new Librarian(id, name, email);
            default: throw new IllegalArgumentException("Unknown user type");
        }
    }
}

