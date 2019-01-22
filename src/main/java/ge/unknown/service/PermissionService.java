package ge.unknown.service;

import ge.unknown.dao.PermissionDAO;
import ge.unknown.dto.PermissionDTO;
import ge.unknown.entities.Permission;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MJaniko on 3/9/2017.
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionDAO permissionDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<PermissionDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return permissionDAO.getPaginatedList(Permission.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(PermissionDTO.class);
    }

    @Transactional
    public Permission save(Permission permission) {
        if (permission.getId() != null) {
            return permissionDAO.update(permission);
        }
        return permissionDAO.create(permission);
    }

    @Transactional
    public boolean delete(Long id) {
        return permissionDAO.delete(id);
    }
}
