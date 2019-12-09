package org.pachnanda.apierrorspringboot.service;

import org.pachnanda.apierrorspringboot.entities.User;

public class UserBuilder {



   public static User create(){
       return User.builder().firstName("First").lastName("Last")
               .build();
    }
}
