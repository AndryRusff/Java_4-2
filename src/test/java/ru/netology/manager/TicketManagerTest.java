package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.TicketInformation;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private final TicketRepository repository = new TicketRepository();
    private final TicketManager ticketManager = new TicketManager(repository);

    private final TicketInformation tick1 = new TicketInformation(0, 17850, "SWE", "DME", 15);
    private final TicketInformation tick2 = new TicketInformation(1, 999, "ALA", "SPB", 999);
    private final TicketInformation tick3 = new TicketInformation(2, 61000, "ADL", "CIT", 60);
    private final TicketInformation tick4 = new TicketInformation(3, 1399, "DYK", "SWE", 115);
    private final TicketInformation tick5 = new TicketInformation(4, 2500, "BMX", "LED", 45);
    private final TicketInformation tick6 = new TicketInformation(5, 21300, "DME", "LED", 910);
    private final TicketInformation tick7 = new TicketInformation(6, 34100, "TOR", "NIG", 1800);
    private final TicketInformation tick8 = new TicketInformation(7, 3000, "COI", "MNE", 12);

    @BeforeEach
    public void setUp() {
        ticketManager.addTicketInformation(tick1);
        ticketManager.addTicketInformation(tick2);
        ticketManager.addTicketInformation(tick3);
        ticketManager.addTicketInformation(tick4);
        ticketManager.addTicketInformation(tick5);
        ticketManager.addTicketInformation(tick6);
        ticketManager.addTicketInformation(tick7);
        ticketManager.addTicketInformation(tick8);
    }

    @Test
    public void shouldFindNone() {
        TicketInformation[] expected = new TicketInformation[0];
        TicketInformation[] actual = ticketManager.findAll("IDK", "WTF");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch() {
        TicketInformation[] expected = new TicketInformation[]{tick7};
        TicketInformation[] actual = ticketManager.findAll("TOR", "NIG");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ticketManager.removeById(7);
        TicketInformation[] expected = new TicketInformation[]{tick7};
        TicketInformation[] actual = ticketManager.findAll("TOR", "NIG");
        assertArrayEquals(expected, actual);
    }

}