package voc.ps.service;

import voc.ps.model.Role;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public interface RoleService {
    public void addRole(Role p);
    public void updateRole(Role p);
    public List<Role> listRoles();
    public Role getRoleById(int id);
    public void removeRole(int id);
}
