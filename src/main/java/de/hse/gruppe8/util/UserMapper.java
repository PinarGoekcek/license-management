package de.hse.gruppe8.util;

import de.hse.gruppe8.jaxrs.model.User;
import de.hse.gruppe8.orm.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(config = MappingConfig.class)
public interface UserMapper {

    UserEntity toUserEntity(User user);
    User toUser(UserEntity userEntity);
}
