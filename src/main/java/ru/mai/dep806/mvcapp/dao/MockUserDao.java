package ru.mai.dep806.mvcapp.dao;

import ru.mai.dep806.mvcapp.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Объект доступа к данным о пользователях. Реализация в памяти.
 */
public class MockUserDao {
    private Map<Long, User> users = new HashMap<Long, User>();
    private AtomicLong sequence = new AtomicLong(0);

    public MockUserDao(){
        saveUser(new User("john", "John Smith", "jsmith@mail.com", new Date(), true));
        saveUser(new User("steve", "Steve Brown", "sbrown@mail.com", new Date(), true));
    }

    public List<User> getAllUsers(){
        return new ArrayList<User>(users.values());
    }

    public User findUserById(Long id){
        return users.get(id);
    }

    public User saveUser(User user) {
        if (user.getId() == null){
            user.setId(sequence.getAndIncrement());
        }
        users.put(user.getId(), user);
        return user;
    }
}
