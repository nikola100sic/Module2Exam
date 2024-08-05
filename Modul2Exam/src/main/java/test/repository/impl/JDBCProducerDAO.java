package test.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import test.model.Producer;
import test.repository.ProducerDAO;

@Repository
public class JDBCProducerDAO implements ProducerDAO {

	private final JdbcTemplate jdbcTemplate;

	public JDBCProducerDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	private class ProducerRowMapper implements RowMapper<Producer> {

		@Override
		public Producer mapRow(ResultSet rset, int rowNum) throws SQLException {
			int column = 0;
			long id = rset.getLong(++column);
			String name = rset.getString(++column);
			String location = rset.getString(++column);

			Producer producer = new Producer(id, name, location);

			return producer;
		}
	}

	@Override
	public Producer get(long id) {
		String sql = "SELECT id, name, location FROM producers WHERE id=?";
		List<Producer> result = jdbcTemplate.query(sql, new ProducerRowMapper(), id);
		return (!result.isEmpty()) ? result.get(0) : null;
	}

	@Override
	public Collection<Producer> getAll() {
		String sql = "SELECT id, name, location FROM producers";
		return jdbcTemplate.query(sql, new ProducerRowMapper());
	}
}
