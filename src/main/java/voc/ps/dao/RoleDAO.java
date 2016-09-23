package voc.ps.dao;

import voc.ps.model.Role;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public interface RoleDAO {
    public void addRole(Role role);
    public void updateRole(Role role);
    public List<Role> listRoles();
    public Role getRoleById(int id);
    public void removeRole(int id);
}
