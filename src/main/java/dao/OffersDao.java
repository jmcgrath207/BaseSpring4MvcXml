package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDao {

    private NamedParameterJdbcTemplate jdbc;

    public OffersDao() {
        System.out.println("Successfully load offers DAO");
    }

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    public List<Offers> getOffers() {

        return jdbc.query("select * from offers", new RowMapper<Offers>() {

            public Offers mapRow(ResultSet rs, int rowNum) throws SQLException {
                Offers offers = new Offers();

                offers.setId(rs.getInt("id"));
                offers.setName(rs.getString("name"));
                offers.setText(rs.getString("text"));
                offers.setEmail(rs.getString("email"));

                return offers;
            }

        });
    }

    public boolean update(Offers offers) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offers);

        return jdbc.update("update offers set name=:name, text=:text, email=:email where id=:id", params) == 1;
    }

    public boolean create(Offers offers) {

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offers);

        return jdbc.update("insert into offers (name, text, email) values (:name, :text, :email)", params) == 1;
    }

    @Transactional
    public int[] create(List<Offers> offers) {

        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());

        return jdbc.batchUpdate("insert into offers (id, name, text, email) values (:id, :name, :text, :email)", params);
    }

    public boolean delete(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        return jdbc.update("delete from offers where id=:id", params) == 1;
    }

    public Offers getOffer(int id) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.queryForObject("select * from offers where id=:id", params,
                new RowMapper<Offers>() {

                    public Offers mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Offers offers = new Offers();

                        offers.setId(rs.getInt("id"));
                        offers.setName(rs.getString("name"));
                        offers.setText(rs.getString("text"));
                        offers.setEmail(rs.getString("email"));

                        return offers;
                    }

                });
    }

}