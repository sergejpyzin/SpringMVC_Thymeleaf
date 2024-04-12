package ru.sergeypyzin.firstcrudproject.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.sergeypyzin.firstcrudproject.configuration.DatabaseProperties;
import ru.sergeypyzin.firstcrudproject.model.User;

import java.util.List;

/**
 * Репозиторий для управления пользователями в базе данных.
 */
@Repository
@AllArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbc;
    private final DatabaseProperties databaseProperties;

    /**
     * Метод для получения всех пользователей из базы данных.
     *
     * @return список пользователей
     */
    public List<User> findAll() {
        String sql = databaseProperties.getFindAllUsersQuery();

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Метод для сохранения пользователя в базе данных.
     *
     * @param user объект пользователя для сохранения
     * @return сохраненный объект пользователя
     */
    public User save(User user) {
        String sql = databaseProperties.getSaveUserQuery();
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Метод для удаления пользователя из базы данных по его идентификатору.
     *
     * @param id идентификатор пользователя, которого нужно удалить
     */
    public void deleteById(int id) {

        // SQL запрос для удаления пользователя из таблицы по идентификатору id
        String sql = databaseProperties.getDeleteUserByIdQuery();

        // Выполнение SQL запроса с передачей идентификатора в качестве параметр
        jdbc.update(sql, id);
    }

    /**
     * Метод для обновления информации о пользователе в базе данных.
     *
     * @param user объект пользователя с обновленными данными
     * @return обновленный объект пользователя
     */
    public User updateUser(User user) {

        // SQL запрос для обновления данных пользователя в таблице
        String sql = databaseProperties.getUpdateUserQuery();

        // Выполнение SQL запроса с передачей новых данных пользователя в качестве параметров
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());

        // Возвращение обновленного пользователя
        return user;
    }

    /**
     * Метод для поиска пользователя по его идентификатору в базе данных.
     *
     * @param id идентификатор пользователя
     * @return объект пользователя с указанным идентификатором
     */
    public User findByID (int id) {
        // SQL запрос для выборки пользователя по его id
        String sql = databaseProperties.getFindUserByIdQuery();

        // RowMapper для отображения строк из результата запроса в объекты пользователя
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        // Выполнение SQL запроса и отображение результата в объект пользователя
        return jdbc.queryForObject(sql, new Object[]{id}, userRowMapper);
    }

}
