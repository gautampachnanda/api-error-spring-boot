package org.pachnanda.apierrorspringboot.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class UserCollection {

    @NotNull
    @Size(min = 2)
    private List<Long> usersIds;

    public List<Long> getUsersIds() {
        return usersIds;
    }

    public void setUsersIds(List<Long> users) {
        this.usersIds = users;
    }
}
