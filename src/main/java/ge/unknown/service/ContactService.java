package ge.unknown.service;

import ge.unknown.dao.ContactDAO;
import ge.unknown.dto.ContactDTO;
import ge.unknown.entities.Contact;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MJaniko on 3/12/2017.
 */
@Service
public class ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<ContactDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return contactDAO.getPaginatedList(Contact.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(ContactDTO.class);
    }

    @Transactional(readOnly = true)
    public List<Contact> getAll(){
        return contactDAO.all();
    }

    @Transactional
    public Contact save(Contact contact) {
        if (contact.getId() != null) {
            return contactDAO.update(contact);
        }
        return contactDAO.create(contact);
    }

    @Transactional
    public boolean delete(Long id) {
        return contactDAO.delete(id);
    }

}
