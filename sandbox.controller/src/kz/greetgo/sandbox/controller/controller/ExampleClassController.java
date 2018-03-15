package kz.greetgo.sandbox.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.AsIs;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.ParSession;
import kz.greetgo.sandbox.controller.model.UserInfo;
import kz.greetgo.sandbox.controller.register.ExampleRegister;
import kz.greetgo.sandbox.controller.util.Controller;

@Bean
@Mapping("/example")
public class ExampleClassController implements Controller {

  public BeanGetter<ExampleRegister> ex;

  @AsIs
  @Mapping("/test")
  public UserInfo test(@ParSession("personId") String personId) {
    return ex.get().example(personId);
  }
}
