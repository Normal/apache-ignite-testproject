package ignite.service

import ignite.model.Person
import org.apache.ignite.cache.store.CacheStoreAdapter
import org.h2.jdbcx.JdbcConnectionPool
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper

import javax.cache.Cache
import javax.cache.integration.CacheLoaderException
import javax.cache.integration.CacheWriterException
import java.sql.ResultSet
import java.sql.SQLException

class PersonCacheAdapter extends CacheStoreAdapter<Long, Person> implements Serializable {

    transient JdbcTemplate jdbcTemplate

    PersonCacheAdapter () {
        jdbcTemplate = new JdbcTemplate(JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/test", "sa", ""))
    }

    @Override
    Person load(Long key) throws CacheLoaderException {
        jdbcTemplate.queryForObject("select * from persons where id = ?", new RowMapper<Person>() {

            @Override
            Person mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                new Person(
                        id: rs.getLong(1),
                        balance: rs.getLong(2),
                        type: rs.getLong(3)
                )
            }
        }, key)
    }

    @Override
    void write(Cache.Entry<? extends Long, ? extends Person> entry) throws CacheWriterException {

    }

    @Override
    void delete(Object key) throws CacheWriterException {

    }
}
