package com.oukongli.mapper;

import com.oukongli.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ou_kongli on 2015/5/6.
 */
public interface UserMapper {
    void add(User user);

    User load(@Param("id") int id);

    void delete(int id);

    List<User> find(String name);

    void update(@Param("user") User user);
}
