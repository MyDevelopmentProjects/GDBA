package ge.unknown.service;

import ge.unknown.dao.RoleDAO;
import ge.unknown.dto.RoleDTO;
import ge.unknown.entities.Role;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MJaniko on 3/9/2017.
 */
@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<RoleDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return roleDAO.getPaginatedList(Role.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(RoleDTO.class);
    }

    @Transactional
    public Role save(Role role) {
        if (role.getId() != null) {
            return roleDAO.update(role);
        }
        return roleDAO.create(role);
    }

    @Transactional
    public boolean delete(Long id) {
        return roleDAO.delete(id);
    }
}
