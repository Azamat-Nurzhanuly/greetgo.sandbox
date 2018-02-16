package kz.greetgo.sandbox.db.register_impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.sandbox.controller.errors.NotFound;
import kz.greetgo.sandbox.controller.model.*;
import kz.greetgo.sandbox.controller.register.ClientRegister;
import kz.greetgo.sandbox.db.dao.ClientDao;

import java.sql.Date;
import java.util.List;

@Bean
public class ClientRegisterImpl implements ClientRegister {

  public BeanGetter<ClientDao> clientDao;

  @Override
  public long getTotalSize(String filterBy, String filterInput) {
//    return clientDao.get().getTotalSize(filterBy != null ? filterBy : "surname",
//      filterInput != null ? filterInput : "");

    return 0;
  }

  @Override
  public List<ClientInfo> getClientsList(String filterBy, String filterInputs, String orderBy, boolean isDesc, int page, int pageSize) {
    return null;
  }

  @Override
  public ClientDetails getClientDetails(String clientId) {
    ClientDetails clientDetails = clientDao.get().selectClientDetailsById(clientId);
    if (clientDetails == null) throw new NotFound();
    return clientDetails;
  }

  @Override
  public ClientInfo addOrUpdateClient(ClientRecords clientRecords) {
    List<PhoneNumber> phoneNumbers = clientRecords.phoneNumbers;
    Address addressFact = clientRecords.addressF;
    Address addressReg = clientRecords.addressR;
    for (PhoneNumber phoneNumber : phoneNumbers) {
      clientDao.get().insertPhoneNumber(clientRecords.id, phoneNumber.number, phoneNumber.phoneType);
    }
    clientDao.get().insertAddress(clientRecords.id, addressFact.type, addressFact.street, addressFact.house, addressFact.flat);
    clientDao.get().insertAddress(clientRecords.id, addressReg.type, addressReg.street, addressReg.house, addressReg.flat);

    clientDao.get().insertOrUpdateClient(clientRecords.id,
      clientRecords.surname,
      clientRecords.name,
      clientRecords.patronymic,
      clientRecords.gender,
      Date.valueOf(clientRecords.dateOfBirth),
      clientRecords.charm.id);

    return clientDao.get().selectClientInfoById(clientRecords.id);
  }

  @Override
  public void removeClient(String clientsId) {
    clientDao.get().removeClientById(clientsId);
    clientDao.get().removeAddressOfClient(clientsId);
    clientDao.get().removePhoneNumbersOfClient(clientsId);
  }
}
