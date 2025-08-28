package murach.data;

import murach.models.User;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

    // Danh sách lưu trữ users (trong thực tế sẽ là database)
    private static List<User> users = new ArrayList<>();

    // Thêm user vào database
    public static void insert(User user) {
        if (user != null) {
            users.add(user);
            System.out.println("User đã được thêm: " + user.toString());
        }
    }

    // Lấy tất cả users
    public static List<User> selectAll() {
        return new ArrayList<>(users);
    }

    // Tìm user theo email
    public static User selectUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    // Xóa user
    public static boolean delete(User user) {
        return users.remove(user);
    }

    // Cập nhật user
    public static boolean update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(user.getEmail())) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

   public static User getUser(int index) {
       if (index >= 0 && index < users.size()) {
           return users.get(index);
       } else {
           return new User();
       }
   }

   public static User getLastUser() {
       if (!users.isEmpty()) {
           return users.get(users.size() - 1);
       } else {
           return new User();
       }
   }
}
