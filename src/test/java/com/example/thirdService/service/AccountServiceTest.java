package com.example.thirdService.service;

import com.example.thirdService.model.Account;
import com.example.thirdService.repo.AccountRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class AccountServiceTest {

    @MockBean
    private AccountRepo repo;
    @MockBean
    private AccountService service;

    @Test
    void list() {
        List<Account> notes = List.of(new Account("1"), new Account("3"));
        Mockito.when(service.list()).thenReturn(notes);
        List<Account> list = service.list();
        assertArrayEquals(notes.toArray(), list.toArray());
    }

    @Test
    void byId() {
        Account note = new Account("1");
        note.setId(1L);
        Mockito.when(service.byId(1L)).thenReturn(note);
        assertEquals(note, service.byId(1L));
    }

    @Test
    void save() {
        Account note = new Account("1");
        Mockito.when(service.save(note)).thenReturn(note);
        assertEquals(note, service.save(note));
    }
}