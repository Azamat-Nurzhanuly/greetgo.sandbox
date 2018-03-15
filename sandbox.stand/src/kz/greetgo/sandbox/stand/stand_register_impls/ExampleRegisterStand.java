package kz.greetgo.sandbox.stand.stand_register_impls;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.sandbox.controller.model.UserInfo;
import kz.greetgo.sandbox.controller.register.ExampleRegister;
import kz.greetgo.sandbox.db.stand.beans.StandDb;
import kz.greetgo.util.RND;


@Bean
public class ExampleRegisterStand implements ExampleRegister {

  public BeanGetter<StandDb> db;

  @Override
  public UserInfo example(String personId) {

    //TODO: неверное название. Не понятно для чего метод
    
    UserInfo ret = new UserInfo();
    ret.accountName = RND.str(10);
    ret.id = RND.str(10);
    ret.name = RND.str(10);
    ret.patronymic = RND.str(10);

    return ret;
  }
}
