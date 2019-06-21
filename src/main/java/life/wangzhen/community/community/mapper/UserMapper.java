package life.wangzhen.community.community.mapper;

import life.wangzhen.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,accountId,token,gmtCreate,getModified) values(#{name},#{accountId},#{token},#{gmtCreate},#{getModified})")
    public void insert(User user);

}
