package voc.ps.service;

import voc.ps.dao.RoleDAO;
import voc.ps.model.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public class RoleServiceImpl implements RoleService{

    private RoleDAO roleDAO;

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
    @Override
    @Transactional
    public void addRole(Role p) {
        roleDAO.addRole(p);
    }

    @Override
    @Transactional
    public void updateRole(Role p) {
        roleDAO.updateRole(p);
    }

    @Override
    @Transactional
    public List<Role> listRoles() {
        return roleDAO.listRoles();
    }

    @Override
    @Transactional
    public Role getRoleById(int id) {
        return roleDAO.getRoleById(id);
    }

    @Override
    @Transactional
    public void removeRole(int id) {
        roleDAO.removeRole(id);
    }
}
