package com.oukongli.java.mapper;

import com.oukongli.java.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ou_kongli on 2015/5/6.
 */
public interface UserMapper {
     void add(User user);

     User load(@Param("id") int id);

    void delete(int id);
}
