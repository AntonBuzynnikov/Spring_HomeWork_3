package ru.gb.example3_sem3_hometask.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.example3_sem3_hometask.domain.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
//    private List<User> users = new ArrayList<>();
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> getUsers() {
        String sql = "SELECT * FROM userTable;";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbc.query(sql,userRowMapper);
    }

    public void saveUser(User user){
        String sql = "INSERT INTO userTable (name, age, email) VALUES(?, ?, ?)";
        jdbc.update(sql,user.getName(),user.getAge(),user.getEmail());
    }

    public void setUsers(List<User> users) {

    }
}
