package kz.greetgo.sandbox.controller.model;

import java.util.ArrayList;
import java.util.List;
import kz.greetgo.sandbox.controller.model.Address;
import kz.greetgo.sandbox.controller.model.Charm;
import kz.greetgo.sandbox.controller.model.Gender;
import kz.greetgo.sandbox.controller.model.PhoneNumber;

public class ClientRecords {
  public String id;
  public String surname;
  public String name;
  public String patronymic;
  public Charm charm;
  public Gender gender;
  public String dateOfBirth;
  public Address addressF;
  public Address addressR;
  public List<PhoneNumber> phoneNumbers = new ArrayList<>();
  public int totalBalance;/**/
  public int minBalance;/**/
  public int maxBalance;/**/
}
