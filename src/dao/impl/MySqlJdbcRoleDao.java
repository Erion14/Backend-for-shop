package dao.impl;

import java.sql.SQLException;

import dao.RoleDao;
import dto.RoleDto;
import utils.db.DBUtils;

public class MySqlJdbcRoleDao implements RoleDao{

	@Override
	public RoleDto getRoleById(int id) {
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM role WHERE id = ?")){
			ps.setInt(1, id);
			
			try (var rs = ps.executeQuery()){
				if (rs.next()) {
					RoleDto role = new RoleDto();
					role.setId(rs.getInt("id"));
					role.setRoleName(rs.getString("role_name"));
					return role;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
