package cc.concurrent.mango.example.cache;

import cc.concurrent.mango.*;

import java.util.List;

@DB
@Cache(prefix = "user_", expire = Hour.class, num = 2)
public interface MultiKeysMultiValuesDao {

    @CacheIgnored
    @SQL("insert into user(uid, name) values(:1, :2)")
    public int insert(int uid, String name);

    @SQL("delete from user where uid=:1")
    public int delete(@CacheBy int uid);

    @SQL("update user set name=:2 where uid=:1")
    public int update(@CacheBy int uid, String name);

    @SQL("select uid, name from user where uid=:1")
    public User getUser(@CacheBy int uid);

    @SQL("select uid, name from user where uid in (:1)")
    public List<User> getUsers(@CacheBy List<Integer> uids);

}