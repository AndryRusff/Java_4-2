package ru.netology.manager;

import ru.netology.domain.TicketInformation;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;


public class TicketManager {
  private TicketRepository repository;

  public TicketManager(TicketRepository repository) { this.repository = repository; }

  public void addTicketInformation(TicketInformation item) { repository.save(item); }

  public void removeById(int id) { repository.removeById(id); }

  public boolean match(TicketInformation ticketInformation, String departureAirport, String arrivalAirport) {
    if (ticketInformation.getDepartureAirport().contains(departureAirport) && ticketInformation.getArrivalAirport().contains(arrivalAirport)) {
      return true;
    }
    return false;
  }

  public TicketInformation[] findAll(String departureAirport, String arrivalAirport) {
    TicketInformation[] tickets = repository.findAll();
    TicketInformation[] result = new TicketInformation[0];
    for (TicketInformation ticket : tickets) {
      if (match(ticket, departureAirport, arrivalAirport)) {
        int length = result.length + 1;
        TicketInformation[] tmp = new TicketInformation[length];
        System.arraycopy(result, 0, tmp, 0, result.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        result = tmp;
      }
      Arrays.sort(result);
    }
    return result;
  }


}