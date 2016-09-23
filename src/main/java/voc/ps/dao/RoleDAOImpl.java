package voc.ps.dao;

import voc.ps.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public class RoleDAOImpl implements RoleDAO {

    private static final Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addRole(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(role);
        logger.info("Role saved successfully, Role Details="+ role);
    }

    @Override
    public void updateRole(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(role);
        logger.info("Role updated successfully, Role Details="+role);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> listRoles() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Role> roleList = session.createQuery("from Role").list();
        for(Role role : roleList){
            logger.info("Word List::"+role);
        }
        return roleList;
    }

    @Override
    public Role getRoleById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role role = (Role) session.load(Role.class, new Integer(id));
        logger.info("Role loaded successfully, Role details="+role);
        return role;
    }

    @Override
    public void removeRole(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role role = (Role) session.load(Role.class, new Integer(id));
        if(null != role){
            session.delete(role);
        }
        logger.info("Role deleted successfully, role details="+ role);
    }
}
