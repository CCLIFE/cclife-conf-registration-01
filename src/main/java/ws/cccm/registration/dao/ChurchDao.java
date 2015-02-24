package ws.cccm.registration.dao;

import java.util.List;
import com.cclife.registration.domain.Church;

/**
 * User Data Access Object (GenericDao) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface ChurchDao extends GenericDao<Church, Long> {

    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of users
     */

    /**
     * Saves a user's information.
     * @param user the object to be saved
     * @return the persisted User object
     */
    List<Church> findChurchesByQuery(String query);


}
