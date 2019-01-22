package ge.unknown.service;

import ge.unknown.dao.AboutDAO;
import ge.unknown.entities.About;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MJaniko on 3/9/2017.
 */
@Service
public class AboutService {

    @Autowired
    private AboutDAO aboutDAO;

    @Transactional(readOnly = true)
    public About find(Long id){
        return aboutDAO.find(id);
    }

    @Transactional(readOnly = true)
    public About first(){
        return aboutDAO.first();
    }

    @Transactional
    public About save(About about) {
        if (about.getId() != null) {
            return aboutDAO.update(about);
        }
        return aboutDAO.create(about);
    }

    @Transactional
    public boolean delete(Long id) {
        return aboutDAO.delete(id);
    }
}
