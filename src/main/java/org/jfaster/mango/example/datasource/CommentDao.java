package org.jfaster.mango.example.datasource;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

/**
 * @author ash
 */
@DB(database = "db2")
public interface CommentDao {

    @ReturnGeneratedId
    @SQL("insert into comment(uid, title, content) values(:uid, :title, :content)")
    int addComment(Comment comment);

    @SQL("select id, uid, title, content from comment where id = :1")
    Comment getComment(int id);

}
