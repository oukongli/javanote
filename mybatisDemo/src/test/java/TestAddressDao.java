import com.oukongli.dao.AddressDao;
import com.oukongli.dao.DAOFactory;
import com.oukongli.dao.IAddressDao;
import com.oukongli.model.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ou_kongli on 2015/5/10.
 */
public class TestAddressDao {

    IAddressDao addressDao = DAOFactory.getAddressDao();

    @Test
    public void testAdd() {
        Address address = new Address();
        address.setName("test addressdao name");
        address.setPhone("123");
        address.setPostcode("123456");
        addressDao.add(address, 2);
    }

    @Test
    public void testLoad() {
        Address address = addressDao.load(1);
        Assert.assertNotNull(address);
    }

    @Test
    public void testList() {
        List<Address> list = addressDao.list(1);
        System.out.println(list.size());
    }
}
