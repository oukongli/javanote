package com.oukongli.mapper;

import com.oukongli.model.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ou_kongli on 2015/5/6.
 */
public interface AddressMapper {
    void add(Address address);
    Address load(@Param("id") int id);
    void delete(int id);
    List<Address> find(@Param("user_id") int user_id);
    void update(@Param("address") Address address);
}
